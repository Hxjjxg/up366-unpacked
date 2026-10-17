package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class GoodsListRefresh {
    public static final int TYPE_MARKET = 1;
    public static final int TYPE_RECOMMEND = 2;
    private int categoryId;
    private final java.util.List<com.up366.mobile.market.GoodsInfo> goods;
    private final com.up366.common.http.Response resp;
    private int type;

    public GoodsListRefresh(com.up366.common.http.Response response, int i, java.util.List<com.up366.mobile.market.GoodsInfo> list) {
        this.resp = response;
        this.type = i;
        this.goods = list;
    }

    public GoodsListRefresh(java.util.List<com.up366.mobile.market.GoodsInfo> list, int i) {
        this.type = i;
        this.resp = null;
        this.goods = list;
    }

    public GoodsListRefresh(com.up366.common.http.Response response, java.util.List<com.up366.mobile.market.GoodsInfo> list, int i, int i2) {
        this.type = i;
        this.categoryId = i2;
        this.resp = response;
        this.goods = list;
    }

    public int getType() {
        return this.type;
    }

    public java.util.List<com.up366.mobile.market.GoodsInfo> getGoods() {
        return this.goods;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }

    public int getCategoryId() {
        return this.categoryId;
    }
}
