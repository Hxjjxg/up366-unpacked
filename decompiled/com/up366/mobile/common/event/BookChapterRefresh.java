package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookChapterRefresh {
    private final com.up366.common.http.Response resp;
    private final com.up366.mobile.book.model.TreeBookChapter treeBookChapter;

    public BookChapterRefresh(com.up366.common.http.Response response, com.up366.mobile.book.model.TreeBookChapter treeBookChapter) {
        this.resp = response;
        this.treeBookChapter = treeBookChapter;
    }

    public BookChapterRefresh(com.up366.mobile.book.model.TreeBookChapter treeBookChapter) {
        this.resp = null;
        this.treeBookChapter = treeBookChapter;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }

    public com.up366.mobile.book.model.TreeBookChapter getTreeBookChapter() {
        return this.treeBookChapter;
    }
}
