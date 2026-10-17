package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UserOrder {
    private java.lang.String auditorId;
    private int bonus;
    private long confirmTime;
    private long createTime;
    private java.lang.String creatorId;
    private java.lang.String fullName;
    private double goodsAmount;

    @com.alibaba.fastjson.annotation.JSONField(name = "goodsList")
    private java.lang.String goodsList;
    private double integral;
    private double integralMoney;
    private int isAgent;
    private int moneyPaid;
    private double orderAmount;
    private double orderDiscount;
    private double orderGoodsAmount;
    private java.lang.String orderId;
    private java.lang.String orderSn;
    private int orderStatus;
    private double payAmount;
    private int payStatus;
    private long payTime;
    private java.lang.Long rowId;
    private java.lang.String type;
    private java.lang.String userId;
    private java.lang.String userName;

    public UserOrder(java.lang.Long l, java.lang.String str, java.lang.String str2, int i, long j, long j2, java.lang.String str3, java.lang.String str4, java.lang.String str5, double d, double d2, int i2, int i3, double d3, double d4, double d5, java.lang.String str6, int i4, double d6, int i5, long j3, java.lang.String str7, java.lang.String str8, java.lang.String str9, double d7) {
        this.rowId = l;
        this.orderId = str;
        this.auditorId = str2;
        this.bonus = i;
        this.confirmTime = j;
        this.createTime = j2;
        this.creatorId = str3;
        this.fullName = str4;
        this.goodsList = str5;
        this.integral = d;
        this.integralMoney = d2;
        this.isAgent = i2;
        this.moneyPaid = i3;
        this.orderAmount = d3;
        this.orderDiscount = d4;
        this.orderGoodsAmount = d5;
        this.orderSn = str6;
        this.orderStatus = i4;
        this.payAmount = d6;
        this.payStatus = i5;
        this.payTime = j3;
        this.type = str7;
        this.userId = str8;
        this.userName = str9;
        this.goodsAmount = d7;
    }

    public UserOrder() {
    }

    public java.lang.String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(java.lang.String str) {
        this.orderId = str;
    }

    public java.lang.String getAuditorId() {
        return this.auditorId;
    }

    public void setAuditorId(java.lang.String str) {
        this.auditorId = str;
    }

    public int getBonus() {
        return this.bonus;
    }

    public void setBonus(int i) {
        this.bonus = i;
    }

    public long getConfirmTime() {
        return this.confirmTime;
    }

    public void setConfirmTime(long j) {
        this.confirmTime = j;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public java.lang.String getCreatorId() {
        return this.creatorId;
    }

    public void setCreatorId(java.lang.String str) {
        this.creatorId = str;
    }

    public java.lang.String getFullName() {
        return this.fullName;
    }

    public void setFullName(java.lang.String str) {
        this.fullName = str;
    }

    public java.lang.String getGoodsList() {
        return this.goodsList;
    }

    public void setGoodsList(java.lang.String str) {
        this.goodsList = str;
    }

    public double getIntegral() {
        return this.integral;
    }

    public void setIntegral(double d) {
        this.integral = d;
    }

    public double getIntegralMoney() {
        return this.integralMoney;
    }

    public void setIntegralMoney(double d) {
        this.integralMoney = d;
    }

    public int getIsAgent() {
        return this.isAgent;
    }

    public void setIsAgent(int i) {
        this.isAgent = i;
    }

    public int getMoneyPaid() {
        return this.moneyPaid;
    }

    public void setMoneyPaid(int i) {
        this.moneyPaid = i;
    }

    public double getOrderAmount() {
        return this.orderAmount;
    }

    public void setOrderAmount(double d) {
        this.orderAmount = d;
    }

    public double getOrderDiscount() {
        return this.orderDiscount;
    }

    public void setOrderDiscount(double d) {
        this.orderDiscount = d;
    }

    public double getOrderGoodsAmount() {
        return this.orderGoodsAmount;
    }

    public void setOrderGoodsAmount(double d) {
        this.orderGoodsAmount = d;
    }

    public java.lang.String getOrderSn() {
        return this.orderSn;
    }

    public void setOrderSn(java.lang.String str) {
        this.orderSn = str;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(int i) {
        this.orderStatus = i;
    }

    public double getPayAmount() {
        return this.payAmount;
    }

    public void setPayAmount(double d) {
        this.payAmount = d;
    }

    public int getPayStatus() {
        return this.payStatus;
    }

    public void setPayStatus(int i) {
        this.payStatus = i;
    }

    public long getPayTime() {
        return this.payTime;
    }

    public void setPayTime(long j) {
        this.payTime = j;
    }

    public java.lang.String getType() {
        return this.type;
    }

    public void setType(java.lang.String str) {
        this.type = str;
    }

    public java.lang.String getUserId() {
        return this.userId;
    }

    public void setUserId(java.lang.String str) {
        this.userId = str;
    }

    public java.lang.String getUserName() {
        return this.userName;
    }

    public void setUserName(java.lang.String str) {
        this.userName = str;
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }

    public double getGoodsAmount() {
        return this.goodsAmount;
    }

    public void setGoodsAmount(double d) {
        this.goodsAmount = d;
    }
}
