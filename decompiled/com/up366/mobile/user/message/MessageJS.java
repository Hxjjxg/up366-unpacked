package com.up366.mobile.user.message;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MessageJS {
    private static final int EXTEND_OP_TYPE_OTHER = 99;
    private static final int EXTEND_OP_TYPE_SELF_STUDY = 4;
    private static final int EXTEND_OP_TYPE_STAND_STUDY = 3;
    private static final int EXTEND_OP_TYPE_WRONG_NOTE = 2;
    private android.app.Activity activity;
    private com.up366.mobile.common.logic.model.Messages messages;

    public MessageJS(android.app.Activity activity) {
        this.activity = activity;
    }

    public void setMessages(com.up366.mobile.common.logic.model.Messages messages) {
        this.messages = messages;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getTitle() {
        return (this.messages.getExt() == null || com.up366.common.StringUtils.isEmptyOrNull(this.messages.getExt().getStudyTaskName())) ? "" : this.messages.getExt().getStudyTaskName();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getContent() {
        if (this.messages.getMsgType() == 2) {
            return this.messages.getContent();
        }
        return covertJumpUrl(covertHttp(this.messages.getContent().replaceAll("\\n", "<br/>")));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getMessageTime() {
        return com.up366.common.TimeUtils.formatTime(this.messages.getSendTime(), "yy-MM-dd HH:mm");
    }

    @android.webkit.JavascriptInterface
    public int getMessageType() {
        if (this.messages.getExt().isExtendOpTypeMessage()) {
            return 3;
        }
        return com.up366.common.StringUtils.isEmptyOrNull(this.messages.getExt().getStudyTaskId()) ? 1 : 2;
    }

    @android.webkit.JavascriptInterface
    public int getExtendOpType() {
        return this.messages.getExt().getOptype();
    }

    @android.webkit.JavascriptInterface
    public void openTask() {
        com.up366.common.log.Logger.info("MessageJS openTask");
        skipStudyPage();
    }

    @android.webkit.JavascriptInterface
    public void skipByExtendOpType() {
        int optype = this.messages.getExt().getOptype();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("messagetype", java.lang.Integer.valueOf(optype));
        com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.MESSAGE_DETAIL, com.up366.mobile.common.onlinelog.OpLogData.Control.MESSAGE_DETAIL, com.up366.mobile.common.onlinelog.OpLogData.Event.CLICK, jSONObject);
        if (optype == 2) {
            goToWrongNote();
            return;
        }
        if (optype == 3) {
            openStudyPage(this.activity, this.messages.getExt().getBookId(), this.messages.getExt().getBookType());
            return;
        }
        if (optype == 4) {
            com.up366.mobile.me.book.MeMyBookActivity.openPage(this.activity);
            return;
        }
        if (optype == 99) {
            return;
        }
        com.up366.common.log.Logger.error("MessageJS skipByExtendOpType error, opType: " + optype + ", messages: " + com.alibaba.fastjson.JSON.toJSONString(this.messages));
    }

    private void goToWrongNote() {
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(this.activity, "数据加载中");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.message.MessageJS$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$goToWrongNote$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$goToWrongNote$1() throws java.lang.Exception {
        final com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolderLoad = com.up366.mobile.course.task.model.CoursePageCountHolder.load();
        com.up366.mobile.common.logic.Auth.cur().wrongnote().fetchWrongNoteList(coursePageCountHolderLoad, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.message.MessageJS$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$goToWrongNote$0(coursePageCountHolderLoad, response, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$goToWrongNote$0(com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder, com.up366.common.http.Response response, java.util.List list) {
        java.util.Objects.requireNonNull(coursePageCountHolder);
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.mobile.book.helper.V8OpenHelper$$ExternalSyntheticLambda10(coursePageCountHolder));
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(this.activity);
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError(this.activity, com.up366.mobile.common.utils.ErrorMessageTool.convert(response));
            return;
        }
        android.content.Intent intent = new android.content.Intent(this.activity, (java.lang.Class<?>) com.up366.mobile.course.wrongnote.WrongNoteActivity.class);
        intent.putExtra("type", 1);
        intent.putExtra("fromType", 0);
        intent.putExtra(com.up366.mobile.course.wrongnote.WrongNoteActivity.INTENT_WRONG_SUBJECT, (java.io.Serializable) list);
        this.activity.startActivity(intent);
    }

    private static void openStudyPage(android.content.Context context, java.lang.String str, int i) {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
        bookInfoStudy.setBookId(str);
        bookInfoStudy.setBookType(i);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("scenario", "_STANDARD_BOOK_");
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookInfoStudy.getBookId());
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(bookInfoStudy.getCourseId()));
        jSONObject.put("bookType", java.lang.Integer.valueOf(bookInfoStudy.getBookType()));
        bookInfoStudy.setJumpCommonParams(jSONObject.toJSONString());
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("book", bookInfoStudy);
        context.startActivity(intent);
    }

    private void skipStudyPage() {
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(this.activity, "加载中");
        com.up366.mobile.common.logic.Auth.cur().taskMgr().fetchTask(java.lang.String.valueOf(this.messages.getExt().getCourseId()), this.messages.getExt().getStudyTaskId(), new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.message.MessageJS$$ExternalSyntheticLambda2
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$skipStudyPage$2(response, (com.up366.mobile.course.task.TaskInfoV2) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$skipStudyPage$2(com.up366.common.http.Response response, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(this.activity);
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError(this.activity, "获取练习信息失败：" + response.getInfo());
            return;
        }
        if (taskInfoV2 == null) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError(this.activity, "未获取到练习信息");
            return;
        }
        if (taskInfoV2.getType() == 1) {
            new com.up366.mobile.course.task.TaskOpenBookStudyHelper().open(this.activity, taskInfoV2);
        } else if (taskInfoV2.getType() == 3) {
            com.up366.mobile.course.task.TaskOpenBookStudyHelper.openHomework(this.activity, taskInfoV2);
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showError(com.up366.common.global.GB.get().getCurrentActivity(), "目前不支持类型跳转");
        }
    }

    private java.lang.String covertHttp(java.lang.String str) {
        java.util.List<java.lang.String> urls = getUrls(str);
        if (urls.size() == 0) {
            return str;
        }
        for (java.lang.String str2 : urls) {
            str = str.replace(str2, "<a href=\"" + str2 + "\">" + str2 + "</a>");
        }
        return str;
    }

    private java.lang.String covertJumpUrl(java.lang.String str) {
        java.util.List<java.lang.String> jumpUrls = getJumpUrls(str);
        if (jumpUrls.size() == 0) {
            return str;
        }
        for (java.lang.String str2 : jumpUrls) {
            str = str.replace(str2, "<a href=\"" + str2 + "\">" + str2 + "</a>");
        }
        return str;
    }

    private java.util.List<java.lang.String> getUrls(java.lang.String str) {
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("(https?)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]").matcher(str);
        if (!matcher.find()) {
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(matcher.group());
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }

    private java.util.List<java.lang.String> getJumpUrls(java.lang.String str) {
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("(up366mobile?)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]").matcher(str);
        if (!matcher.find()) {
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(matcher.group());
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }
}
