package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class InitCreateOrder {
    private double balance;
    private java.lang.String bonusList;
    private java.lang.String goodsList;
    private double totalPrice;

    public java.util.List<com.up366.mobile.common.logic.model.InitCreateOrderGoods> getGoods() {
        return com.alibaba.fastjson.JSON.parseArray(this.goodsList, com.up366.mobile.common.logic.model.InitCreateOrderGoods.class);
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double d) {
        this.balance = d;
    }

    public java.lang.String getGoodsList() {
        return this.goodsList;
    }

    public void setGoodsList(java.lang.String str) {
        this.goodsList = str;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double d) {
        this.totalPrice = d;
    }

    public java.lang.String getBonusList() {
        return this.bonusList;
    }

    public void setBonusList(java.lang.String str) {
        this.bonusList = str;
    }
}
