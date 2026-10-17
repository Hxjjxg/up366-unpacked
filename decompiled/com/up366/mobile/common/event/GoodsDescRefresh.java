package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class GoodsDescRefresh {
    private final com.up366.mobile.market.GoodsDescInfo goodsDesc;
    private final com.up366.common.http.Response resp;

    public GoodsDescRefresh(com.up366.common.http.Response response, com.up366.mobile.market.GoodsDescInfo goodsDescInfo) {
        this.resp = response;
        this.goodsDesc = goodsDescInfo;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }

    public com.up366.mobile.market.GoodsDescInfo getGoodsDesc() {
        return this.goodsDesc;
    }
}
