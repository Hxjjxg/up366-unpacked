package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class GoodsCategoryListRefresh {
    private com.up366.common.http.Response resp;
    private final java.util.List<com.up366.mobile.market.GoodsCategory> types;

    public GoodsCategoryListRefresh(java.util.List<com.up366.mobile.market.GoodsCategory> list) {
        this.types = list;
    }

    public GoodsCategoryListRefresh(java.util.List<com.up366.mobile.market.GoodsCategory> list, com.up366.common.http.Response response) {
        this.types = list;
        this.resp = response;
    }

    public java.util.List<com.up366.mobile.market.GoodsCategory> getTypes() {
        return this.types;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }
}
