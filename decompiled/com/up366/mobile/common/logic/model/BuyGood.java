package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BuyGood implements java.io.Serializable {
    private java.lang.String goodsIds;

    public BuyGood(java.lang.String str) {
        this.goodsIds = str;
    }

    public BuyGood(com.up366.mobile.market.GoodsInfo goodsInfo) {
        this.goodsIds = java.lang.String.valueOf(goodsInfo.getGoodsId());
    }

    public BuyGood(com.up366.mobile.common.logic.model.UserOrder userOrder) {
        java.util.List array = com.alibaba.fastjson.JSON.parseArray(userOrder.getGoodsList(), com.up366.mobile.common.logic.model.UserOrderGoods.class);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.util.Iterator it = array.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((com.up366.mobile.common.logic.model.UserOrderGoods) it.next()).getGoodsId() + com.igexin.push.core.b.an);
        }
        this.goodsIds = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
    }

    public int getProductId() {
        return java.lang.Integer.parseInt(this.goodsIds.split(com.igexin.push.core.b.an)[0]);
    }

    public java.lang.String getGoodsIds() {
        return this.goodsIds;
    }

    public void setGoodsIds(java.lang.String str) {
        this.goodsIds = str;
    }
}
