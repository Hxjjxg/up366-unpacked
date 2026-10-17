package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UserOrderGoods {
    private double discount;
    private double goodsAmount;
    private java.lang.String goodsId;
    private java.lang.String goodsImg;
    private java.lang.String goodsName;
    private int goodsNumber;
    private double goodsPrice;
    private java.lang.String goodsSn;
    private java.lang.String goodsVerticalImg;
    private int isGift;
    private java.lang.String orderId;
    private java.lang.String pkid;
    private int returnNumber;

    public java.lang.String getGoodsVerticalImg() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.goodsVerticalImg)) {
            return this.goodsImg;
        }
        return this.goodsVerticalImg;
    }

    public void setGoodsVerticalImg(java.lang.String str) {
        this.goodsVerticalImg = str;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double d) {
        this.discount = d;
    }

    public double getGoodsAmount() {
        return this.goodsAmount;
    }

    public void setGoodsAmount(double d) {
        this.goodsAmount = d;
    }

    public java.lang.String getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(java.lang.String str) {
        this.goodsId = str;
    }

    public java.lang.String getGoodsImg() {
        return this.goodsImg;
    }

    public void setGoodsImg(java.lang.String str) {
        this.goodsImg = str;
    }

    public java.lang.String getGoodsName() {
        return this.goodsName;
    }

    public void setGoodsName(java.lang.String str) {
        this.goodsName = str;
    }

    public int getGoodsNumber() {
        return this.goodsNumber;
    }

    public void setGoodsNumber(int i) {
        this.goodsNumber = i;
    }

    public double getGoodsPrice() {
        return this.goodsPrice;
    }

    public void setGoodsPrice(double d) {
        this.goodsPrice = d;
    }

    public java.lang.String getGoodsSn() {
        return this.goodsSn;
    }

    public void setGoodsSn(java.lang.String str) {
        this.goodsSn = str;
    }

    public int getIsGift() {
        return this.isGift;
    }

    public void setIsGift(int i) {
        this.isGift = i;
    }

    public java.lang.String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(java.lang.String str) {
        this.orderId = str;
    }

    public java.lang.String getPkid() {
        return this.pkid;
    }

    public void setPkid(java.lang.String str) {
        this.pkid = str;
    }

    public int getReturnNumber() {
        return this.returnNumber;
    }

    public void setReturnNumber(int i) {
        this.returnNumber = i;
    }
}
