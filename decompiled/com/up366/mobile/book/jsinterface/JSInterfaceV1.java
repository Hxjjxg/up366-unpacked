package com.up366.mobile.book.jsinterface;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class JSInterfaceV1 {
    private com.up366.mobile.book.jsinterface.JSInterfaceV1.ShowAnswerCallBack answerCallBack;
    private com.up366.mobile.book.helper.V1AudioHelper audioMgr;
    private final com.up366.mobile.book.model.BookInfoStudy book;
    private final com.up366.mobile.book.model.CatalogChapter chapter;
    private android.content.Context context;
    private final java.lang.String mp3;
    private java.lang.String questionId;
    private java.lang.String timePattern = "yyyy-MM-dd HH:mm:ss";
    private com.up366.mobile.book.helper.DataHelper dataHelper = new com.up366.mobile.book.helper.DataHelper();

    public interface ShowAnswerCallBack {
        void addTaskProgress(java.lang.String str, float f);

        void showCheckButton();

        void submitManyExerlogToServer(java.util.List<com.up366.mobile.book.model.AnswerEleAttrInfo.AnswerJSLog> list);
    }

    public JSInterfaceV1(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.CatalogChapter catalogChapter, android.content.Context context, java.lang.String str, java.lang.String str2, com.up366.mobile.book.helper.V1AudioHelper v1AudioHelper, com.up366.mobile.book.jsinterface.JSInterfaceV1.ShowAnswerCallBack showAnswerCallBack) {
        this.context = context;
        this.book = bookInfoStudy;
        this.chapter = catalogChapter;
        this.questionId = str;
        this.mp3 = str2;
        this.answerCallBack = showAnswerCallBack;
        this.audioMgr = v1AudioHelper;
    }

    @android.webkit.JavascriptInterface
    public void toPlay(int i) {
        this.audioMgr.toPlay(i);
    }

    @android.webkit.JavascriptInterface
    public void stopPlay() {
        this.audioMgr.stopPlay();
    }

    @android.webkit.JavascriptInterface
    public void pause() {
        this.audioMgr.pausePlay();
    }

    @android.webkit.JavascriptInterface
    public void resume() {
        this.audioMgr.resumePlaying();
    }

    @android.webkit.JavascriptInterface
    public int getCurrentTime() {
        return this.audioMgr.getCurrentTime();
    }

    @android.webkit.JavascriptInterface
    public void doExamnation(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.up366.common.log.Logger.info("TAG - 2018/5/27 - JSInterfaceV1 - doExamnation - thisExamId = [" + str + "], questionId = [" + str2 + "], answer = [" + str3 + "], result = [" + str4 + "]");
        com.up366.common.log.Logger.warn("doExamnation : 此方法已废弃不用");
    }

    @android.webkit.JavascriptInterface
    public void doExamnation(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        com.up366.common.log.Logger.info("TAG - 2018/5/27 - JSInterfaceV1 - doExamnation - thisExamId = [" + str + "], questionId = [" + str2 + "], fragenummer = [" + str3 + "], answer = [" + str4 + "], result = [" + str5 + "]");
        com.up366.common.log.Logger.warn("doExamnation : 此方法已废弃不用");
    }

    @android.webkit.JavascriptInterface
    public void doExamnation(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, int i2) {
        com.up366.common.log.Logger.info("TAG - 2018/5/27 - JSInterfaceV1 - doExamnation - thisExamId = [" + str + "], questionId = [" + str2 + "], answer = [" + str3 + "], rusult = [" + i + "], answerNo = [" + i2 + "]");
        com.up366.common.log.Logger.warn("doExamnation : 2016/7/14 此方法已废弃不用");
    }

    @android.webkit.JavascriptInterface
    public void showCheckButton() {
        this.answerCallBack.showCheckButton();
    }

    @android.webkit.JavascriptInterface
    public void openQuestionText() {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV1$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openQuestionText$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openQuestionText$0() throws java.lang.Exception {
        android.content.Intent intent = new android.content.Intent(this.context, (java.lang.Class<?>) com.up366.mobile.book.activity.ViewTextActivity.class);
        intent.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, this.book.getBookId());
        intent.putExtra("chapterId", this.chapter.obj.getId());
        intent.putExtra("questionId", this.questionId);
        intent.putExtra("mp3", this.mp3);
        this.context.startActivity(intent);
    }

    @android.webkit.JavascriptInterface
    public int saveData(java.lang.String str, java.lang.String str2) {
        this.dataHelper.saveData(str2, str);
        return 0;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadData(java.lang.String str) {
        return this.dataHelper.loadData(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadPageInfo() {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("chapterId", this.chapter.obj.getId());
        jSONObject.put("pageId", this.chapter.getNextPage().obj.getId());
        jSONObject.put("pageNum", "0");
        jSONObject.put("displayname", this.chapter.obj.getName());
        jSONObject.put("file", "no_file");
        java.lang.String jSONString = jSONObject.toJSONString();
        com.up366.common.log.Logger.debug("LLLLL - getCurrentPageInfo - result:" + jSONString);
        return jSONString;
    }

    @android.webkit.JavascriptInterface
    public int submitPageEleInfo(java.lang.String str, java.lang.String str2, int i) {
        com.up366.common.log.Logger.info("submitPageEleInfo('" + str2 + "','" + i + "')");
        return 0;
    }

    @android.webkit.JavascriptInterface
    public int submitTask(java.lang.String str, java.lang.String str2, float f) {
        com.up366.common.log.Logger.debug("页面submit() 提交");
        this.answerCallBack.addTaskProgress(str2, f);
        return 0;
    }

    @android.webkit.JavascriptInterface
    public void submitEleAttr(java.lang.String str) {
        java.util.List<com.up366.mobile.book.model.AnswerEleAttrInfo.AnswerJSLog> array = com.alibaba.fastjson.JSON.parseArray(str, com.up366.mobile.book.model.AnswerEleAttrInfo.AnswerJSLog.class);
        if (array != null && array.size() > 0) {
            this.answerCallBack.submitManyExerlogToServer(array);
            return;
        }
        com.up366.common.log.Logger.warn("ldx - submitEleAttr(String answer) : " + str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getUUID() {
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }
}
