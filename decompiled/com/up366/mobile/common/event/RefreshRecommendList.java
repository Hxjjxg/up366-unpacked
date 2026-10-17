package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RefreshRecommendList {
    private final com.up366.mobile.market.GoodsCategory stage;
    private final com.up366.mobile.market.GoodsCategory tag;

    public RefreshRecommendList(com.up366.mobile.market.GoodsCategory goodsCategory, com.up366.mobile.market.GoodsCategory goodsCategory2) {
        this.stage = goodsCategory;
        this.tag = goodsCategory2;
    }

    public com.up366.mobile.market.GoodsCategory getStage() {
        return this.stage;
    }

    public com.up366.mobile.market.GoodsCategory getTag() {
        return this.tag;
    }
}
