package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V7ExerciseOpenHelper {
    private final android.app.Activity context;
    private final com.up366.mobile.book.StudyActivityInterface studyActivityInterface;
    private final com.up366.mobile.book.studyviews.StudyV7View studyV7View;

    static /* synthetic */ void lambda$openWebView$1(android.view.View view) {
    }

    public V7ExerciseOpenHelper(com.up366.mobile.book.studyviews.StudyV7View studyV7View) {
        this.studyActivityInterface = studyV7View.studyActivityInterface;
        this.context = studyV7View.context;
        this.studyV7View = studyV7View;
    }

    public void launchXotEngine(java.lang.String str, java.lang.String str2, boolean z) {
        android.content.Intent intent = new android.content.Intent(this.context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("exercise_type", str);
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, com.alibaba.fastjson.JSON.parseObject(str2).toJSONString());
        this.context.startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openWebView(java.lang.String str) {
        java.lang.String str2;
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = this.studyV7View.cfg;
        final com.up366.mobile.book.model.OpenConfigInfo openConfigInfo2 = new com.up366.mobile.book.model.OpenConfigInfo();
        openConfigInfo2.chapterId = openConfigInfo.chapterId;
        openConfigInfo2.pageId = openConfigInfo.pageId;
        openConfigInfo2.taskId = openConfigInfo.taskId;
        openConfigInfo2.pageNo = openConfigInfo.pageNo;
        openConfigInfo2.range = openConfigInfo.range;
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        openConfigInfo2.title = object.getString("title");
        java.lang.String string = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
        final java.lang.String string2 = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID);
        final java.lang.String string3 = object.getString("pageId");
        java.lang.String string4 = object.getString("params");
        java.lang.String string5 = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID);
        java.lang.String string6 = object.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
        openConfigInfo2.exerciseData = string4;
        openConfigInfo2.studyTaskId = string5;
        java.lang.String bookId = this.studyActivityInterface.getBookChapterInfo().getBook().getBookId();
        int courseId = this.studyActivityInterface.getBookChapterInfo().getBook().getCourseId();
        if (!com.up366.common.StringUtils.isEmptyOrNull(string) && !string.equals(bookId)) {
            final com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
            bookInfoStudy.setBookId(string);
            bookInfoStudy.setBookType(1);
            com.up366.mobile.common.logic.Auth.cur().course().selectCourseIdContainsBook(this.context, string, courseId, new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.helper.V7ExerciseOpenHelper$$ExternalSyntheticLambda2
                public final void accept(java.lang.Object obj) {
                    this.f$0.lambda$openWebView$0(bookInfoStudy, openConfigInfo2, string3, string2, (java.lang.Integer) obj);
                }
            });
            return;
        }
        java.lang.String str3 = null;
        if (!com.up366.common.StringUtils.isEmptyOrNull(string2) || !com.up366.common.StringUtils.isEmptyOrNull(string3)) {
            com.up366.mobile.book.model.CatalogPage pageByTaskId = this.studyActivityInterface.getBookChapterInfo().getPageByTaskId(string2);
            if (pageByTaskId == null) {
                pageByTaskId = this.studyActivityInterface.getBookChapterInfo().getPage(string3);
            }
            if (pageByTaskId == null) {
                com.up366.mobile.common.dialog.AppDialog.create(this.context).title("提示").message(this.context.getResources().getString(com.up366.mobile.R.string.study_page_not_found) + "(-3)").btnOne("确定", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.helper.V7ExerciseOpenHelper$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view) {
                        com.up366.mobile.book.helper.V7ExerciseOpenHelper.lambda$openWebView$1(view);
                    }
                }).show();
                java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - V7ExerciseOpenHelper - openWebView - 找不到要打开的页面:");
                sb.append(string3);
                com.up366.common.log.Logger.info(sb.toString());
                return;
            }
            openConfigInfo2.chapterId = ((com.up366.mobile.book.model.CatalogChapter) pageByTaskId.getChapterPPage()).obj.getId();
            openConfigInfo2.pageId = string3;
            openConfigInfo2.pageNo = pageByTaskId.getPageNo();
            openConfigInfo2.range = this.studyActivityInterface.getBookChapterInfo().getPageRange(null);
            openConfigInfo2.taskId = string2;
            if (android.text.TextUtils.isEmpty(string2)) {
                openConfigInfo2.taskId = pageByTaskId.obj.getTaskId();
            }
            java.lang.Object obj = this.context;
            if (obj instanceof com.up366.mobile.book.StudyActivity) {
                ((com.up366.mobile.book.StudyActivity) obj).openPage(openConfigInfo2);
                return;
            } else {
                com.up366.common.log.Logger.error("TAG - V7ExerciseOpenHelper - openWebView - context is not StudyActivity");
                return;
            }
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(string6)) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(this.context, "格式错误");
            com.up366.common.log.Logger.error("TAG - V7ExerciseOpenHelper - openWebView - 格式错误 ： " + str);
            return;
        }
        if (string6.startsWith("http")) {
            openConfigInfo2.openUrl = string6;
        } else {
            if (string6.contains("?")) {
                java.lang.String[] strArrSplit = string6.split("\\?");
                java.lang.String str4 = strArrSplit[0];
                str3 = strArrSplit[1];
                string6 = str4;
            }
            java.lang.String strJoin = com.up366.common.FileUtilsUp.join(this.studyV7View.b.webView.getCurrentDir(), string6);
            if (!com.up366.common.FileUtilsUp.isFileExists(strJoin)) {
                com.up366.mobile.common.utils.ToastPopupUtil.show(this.context, this.context.getResources().getString(com.up366.mobile.R.string.study_page_not_found) + "(-5)");
                com.up366.common.log.Logger.error("TAG - V7ExerciseOpenHelper - openWebView - 找不到页面 ： " + str + " filepath:" + strJoin);
                return;
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("file://");
            sb2.append(strJoin);
            if (str3 == null) {
                str2 = "";
            } else {
                str2 = "?" + str3;
            }
            sb2.append(str2);
            openConfigInfo2.openUrl = sb2.toString();
        }
        android.app.Activity activity = this.context;
        if (activity instanceof com.up366.mobile.book.StudyActivity) {
            ((com.up366.mobile.book.StudyActivity) activity).openPage(openConfigInfo2);
        } else if (activity instanceof com.up366.mobile.jssdk.JsSdk2019CommonActivity) {
            com.up366.mobile.jssdk.JsSdk2019CommonActivity.start(activity, openConfigInfo2.openUrl);
        } else {
            com.up366.common.log.Logger.error("TAG - V7ExerciseOpenHelper - openWebView - context not handle");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWebView$0(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.OpenConfigInfo openConfigInfo, java.lang.String str, java.lang.String str2, java.lang.Integer num) {
        bookInfoStudy.setCourseId(num.intValue());
        openConfigInfo.chapterId = null;
        openConfigInfo.pageNo = -1;
        openConfigInfo.range = null;
        openConfigInfo.pageId = str;
        openConfigInfo.taskId = str2;
        android.content.Intent intent = new android.content.Intent(this.context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("cfg", openConfigInfo);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("scenario", com.up366.mobile.book.helper.Tools.getBookScenario(bookInfoStudy.getBookType()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookInfoStudy.getBookId());
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(bookInfoStudy.getCourseId()));
        jSONObject.put("bookType", java.lang.Integer.valueOf(bookInfoStudy.getBookType()));
        bookInfoStudy.setJumpCommonParams(jSONObject.toJSONString());
        bookInfoStudy.setJumpExtFileIds(com.up366.mobile.book.helper.Tools.buildPendingInfosTask(bookInfoStudy.getBookId(), str2, bookInfoStudy.getBookType()));
        intent.putExtra("book", bookInfoStudy);
        this.context.startActivity(intent);
    }

    public void closeWebView() {
        this.studyV7View.registerHelper.unRegister("beforegoback");
        this.context.onBackPressed();
    }

    public void backToBookShelf() {
        java.lang.Object obj = this.context;
        if (obj instanceof com.up366.mobile.book.StudyActivity) {
            ((com.up366.mobile.book.StudyActivity) obj).backToBookshelf();
        } else {
            com.up366.common.log.Logger.error("TAG - V7ExerciseOpenHelper - backToBookShelf - context is not StudyActivity");
        }
    }

    public void backToCatalog() {
        if (this.studyActivityInterface.getOpenConfigInfo().isCatalog()) {
            return;
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V7ExerciseOpenHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$backToCatalog$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$backToCatalog$2() throws java.lang.Exception {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = this.studyActivityInterface.getBookInfoStudy();
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.BackToBookCatalog(bookInfoStudy.getCourseId(), bookInfoStudy.getBookId()));
        if (!com.up366.mobile.book.activity.BookDataCache.getInstance().containsCatalogPage(bookInfoStudy.getCourseId(), bookInfoStudy.getBookId())) {
            java.lang.Object obj = this.context;
            if (obj instanceof com.up366.mobile.book.StudyActivity) {
                ((com.up366.mobile.book.StudyActivity) obj).openCatalogPage();
            } else {
                com.up366.common.log.Logger.error("TAG - V7ExerciseOpenHelper - backToCatalog - context is not StudyActivity");
            }
        }
        this.context.onBackPressed();
        this.context.finish();
    }

    public void openWrongQuestion() {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = this.studyActivityInterface.getBookInfoStudy();
        final android.content.Intent intent = new android.content.Intent(this.context, (java.lang.Class<?>) com.up366.mobile.course.wrongnote.WrongNoteActivity.class);
        intent.putExtra("stageId", bookInfoStudy.getStageId());
        intent.putExtra("subjectId", bookInfoStudy.getSubjectId());
        intent.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookInfoStudy.getBookId());
        intent.putExtra("bookName", bookInfoStudy.getBookName());
        intent.putExtra("type", 2);
        intent.putExtra("fromType", 2);
        com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_WRONGNOTE).runWithTip(new java.lang.Runnable() { // from class: com.up366.mobile.book.helper.V7ExerciseOpenHelper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openWrongQuestion$3(intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWrongQuestion$3(android.content.Intent intent) {
        this.context.startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openDictionary(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - V7ExerciseOpenHelper - openDictionary - word:" + com.alibaba.fastjson.JSON.parseObject(str).getString(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD));
        android.app.Activity activity = this.context;
        if (activity instanceof com.up366.mobile.book.StudyActivityInterface) {
            com.up366.mobile.book.StudyActivityDialog.openDict(activity, ((com.up366.mobile.book.StudyActivityInterface) activity).getRootView(), str);
        } else {
            com.up366.common.log.Logger.error("TAG - V7ExerciseOpenHelper - openDictionary - context is not StudyActivityInterface");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openDictionaryV2(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - V7ExerciseOpenHelper - openDictionaryV2 - " + str);
        android.app.Activity activity = this.context;
        if (activity instanceof com.up366.mobile.book.StudyActivityInterface) {
            com.up366.mobile.book.StudyActivity2025Dialog.openDict(activity, ((com.up366.mobile.book.StudyActivityInterface) activity).getRootView(), str);
        } else {
            com.up366.common.log.Logger.error("TAG - V7ExerciseOpenHelper - openDictionaryV2 - context is not StudyActivityInterface");
        }
    }
}
