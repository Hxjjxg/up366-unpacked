package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ProductInfoUpdate {
    private final com.up366.common.http.Response resp;
    private final com.up366.mobile.book.model.BookDetailInfo result;

    public ProductInfoUpdate(com.up366.common.http.Response response, com.up366.mobile.book.model.BookDetailInfo bookDetailInfo) {
        this.resp = response;
        this.result = bookDetailInfo;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }

    public com.up366.mobile.book.model.BookDetailInfo getResult() {
        return this.result;
    }
}
