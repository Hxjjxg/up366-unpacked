package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BuyBookHelper {
    private final com.up366.mobile.book.model.BookInfoStudy book;
    private final android.content.Context context;

    public BuyBookHelper(android.content.Context context, com.up366.mobile.book.model.BookInfoStudy bookInfoStudy) {
        this.context = context;
        this.book = bookInfoStudy;
    }

    public void buy(int i) {
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo(com.up366.common.global.GB.get().getCurrentActivity(), "抱歉，不支持该功能");
    }
}
