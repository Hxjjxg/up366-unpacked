package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BackToBookCatalog {
    private final java.lang.String bookId;
    private final int courseId;

    public BackToBookCatalog(int i, java.lang.String str) {
        this.courseId = i;
        this.bookId = str;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }
}
