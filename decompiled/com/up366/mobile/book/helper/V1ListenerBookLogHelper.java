package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V1ListenerBookLogHelper {
    private java.util.List<com.up366.mobile.book.model.AnswerEleAttrInfo.AnswerJSLog> ansList;
    private com.up366.mobile.book.helper.BookTaskLogHelper bookTaskLogHelper;
    private final com.up366.mobile.book.model.CatalogPage page;
    private float score;
    private java.lang.String taskNo;

    public V1ListenerBookLogHelper(com.up366.mobile.book.model.CatalogPage catalogPage, com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        com.up366.mobile.book.helper.BookTaskLogHelper bookTaskLogHelper = new com.up366.mobile.book.helper.BookTaskLogHelper(catalogPage, bookInfoStudy, openConfigInfo);
        this.bookTaskLogHelper = bookTaskLogHelper;
        this.page = catalogPage;
        bookTaskLogHelper.onEnterPage();
    }

    public void saveLogOnPause() {
        this.bookTaskLogHelper.addAnswers(this.page, this.ansList);
        this.bookTaskLogHelper.submitTask(this.taskNo, this.score, 100.0f, null);
    }

    public void onPagePause() {
        this.bookTaskLogHelper.onPause();
    }

    public void onPageResume() {
        this.bookTaskLogHelper.onResume();
    }

    public void submitManyExerlogToServer(java.util.List<com.up366.mobile.book.model.AnswerEleAttrInfo.AnswerJSLog> list) {
        this.ansList = list;
    }

    public void addTaskProgress(java.lang.String str, float f) {
        this.taskNo = str;
        this.score = f;
    }
}
