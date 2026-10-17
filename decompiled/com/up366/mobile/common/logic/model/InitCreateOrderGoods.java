package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class InitCreateOrderGoods {
    private int goodsId;
    private java.lang.String goodsImg;
    private java.lang.String goodsName;
    private double goodsPrice;
    private java.lang.String goodsVerticalImg;
    private long validTime;

    public java.lang.String getGoodsVerticalImg() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.goodsVerticalImg)) {
            return this.goodsImg;
        }
        return this.goodsVerticalImg;
    }

    public void setGoodsVerticalImg(java.lang.String str) {
        this.goodsVerticalImg = str;
    }

    public java.lang.String getGoodsName() {
        return this.goodsName;
    }

    public void setGoodsName(java.lang.String str) {
        this.goodsName = str;
    }

    public java.lang.String getGoodsImg() {
        return this.goodsImg;
    }

    public void setGoodsImg(java.lang.String str) {
        this.goodsImg = str;
    }

    public double getGoodsPrice() {
        return this.goodsPrice;
    }

    public void setGoodsPrice(double d) {
        this.goodsPrice = d;
    }

    public long getValidTime() {
        return this.validTime;
    }

    public void setValidTime(long j) {
        this.validTime = j;
    }

    public int getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(int i) {
        this.goodsId = i;
    }
}
