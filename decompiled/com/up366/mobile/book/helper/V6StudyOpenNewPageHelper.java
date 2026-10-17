package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V6StudyOpenNewPageHelper {
    private final com.up366.mobile.book.StudyActivity context;
    private final com.up366.mobile.book.studyviews.StudyV6View studyFragment;

    public V6StudyOpenNewPageHelper(com.up366.mobile.book.StudyActivity studyActivity, com.up366.mobile.book.studyviews.StudyV6View studyV6View) {
        this.context = studyActivity;
        this.studyFragment = studyV6View;
    }

    public void openPage(final java.lang.String str, final int i, java.lang.String str2, final int i2) {
        if (!str.startsWith("http:") && !str.startsWith("https:")) {
            java.lang.String strJoin = com.up366.common.FileUtilsUp.join(str2, str);
            try {
                strJoin = new java.io.File(strJoin).getCanonicalPath();
            } catch (java.io.IOException e) {
                com.up366.common.log.Logger.error("TAG - 2018/8/8 - V6StudyOpenNewPageHelper - openPage - ", e);
            }
            str = "file://" + strJoin;
        }
        com.up366.common.log.Logger.debug("-----------urlStr : " + str);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V6StudyOpenNewPageHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openPage$0(i, str, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openPage$0(int i, java.lang.String str, int i2) throws java.lang.Exception {
        if (i == 0) {
            com.up366.mobile.book.studyviews.view.V6ExerciseView currentExerciseView = this.studyFragment.getCurrentExerciseView();
            if (currentExerciseView != null) {
                currentExerciseView.webView.loadUrlInQueue(str, i2);
                return;
            } else {
                com.up366.common.log.Logger.error("TAG - 2019/5/19 - V6StudyOpenNewPageHelper - openPage : currentExerciseView == null");
                return;
            }
        }
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = this.studyFragment.cfg;
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo2 = new com.up366.mobile.book.model.OpenConfigInfo();
        openConfigInfo2.chapterId = openConfigInfo.chapterId;
        openConfigInfo2.pageId = openConfigInfo.pageId;
        openConfigInfo2.taskId = openConfigInfo.taskId;
        openConfigInfo2.pageNo = openConfigInfo.pageNo;
        openConfigInfo2.range = openConfigInfo.range;
        openConfigInfo2.title = openConfigInfo.title;
        openConfigInfo2.openUrl = str;
        this.context.openPage(openConfigInfo2);
    }

    public void openWebView(java.lang.String str) {
        final com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = new com.up366.mobile.book.model.OpenConfigInfo();
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        object.getString("title");
        java.lang.String string = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
        final java.lang.String string2 = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID);
        final java.lang.String string3 = object.getString("pageId");
        int intValue = object.getIntValue(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID);
        java.lang.String string4 = object.getString("params");
        java.lang.String string5 = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID);
        java.lang.String string6 = object.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
        openConfigInfo.exerciseData = string4;
        if (android.text.TextUtils.isEmpty(string)) {
            string = this.context.book.getBookId();
        }
        java.lang.String str2 = string;
        if (!android.text.TextUtils.isEmpty(string6)) {
            int intValue2 = object.getIntValue("openInCurrentWebView");
            openPage(string6, intValue2 == 1 ? 0 : 1, this.studyFragment.getCurrentDir(), 0);
        } else {
            final com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
            bookInfoStudy.setBookId(str2);
            bookInfoStudy.setBookType(1);
            if (!android.text.TextUtils.isEmpty(string5)) {
                bookInfoStudy.setJumpStudyTaskId(string5);
            }
            com.up366.mobile.common.logic.Auth.cur().course().selectCourseIdContainsBook(this.context, str2, intValue, new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.helper.V6StudyOpenNewPageHelper$$ExternalSyntheticLambda1
                public final void accept(java.lang.Object obj) {
                    this.f$0.lambda$openWebView$1(bookInfoStudy, openConfigInfo, string3, string2, (java.lang.Integer) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWebView$1(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.OpenConfigInfo openConfigInfo, java.lang.String str, java.lang.String str2, java.lang.Integer num) {
        bookInfoStudy.setCourseId(num.intValue());
        openConfigInfo.chapterId = null;
        openConfigInfo.pageNo = -1;
        openConfigInfo.range = null;
        openConfigInfo.pageId = str;
        openConfigInfo.taskId = str2;
        android.content.Intent intent = new android.content.Intent((android.content.Context) this.context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("cfg", openConfigInfo);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("scenario", com.up366.mobile.book.helper.Tools.getBookScenario(bookInfoStudy.getBookType()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookInfoStudy.getBookId());
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(bookInfoStudy.getCourseId()));
        jSONObject.put("bookType", java.lang.Integer.valueOf(bookInfoStudy.getBookType()));
        bookInfoStudy.setJumpCommonParams(jSONObject.toJSONString());
        intent.putExtra("book", bookInfoStudy);
        this.context.startActivity(intent);
    }
}
