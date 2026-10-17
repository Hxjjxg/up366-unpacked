package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PostOrderData {
    private java.lang.String bonusId;
    private java.util.List<com.up366.mobile.common.logic.model.PostGoodsInfo> goods;
    private java.lang.String type;
    private boolean useBalanace;

    public PostOrderData() {
        this.type = "1";
    }

    public PostOrderData(com.up366.mobile.common.logic.model.InitCreateOrder initCreateOrder) {
        this.type = "1";
        if (initCreateOrder == null) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.up366.mobile.common.logic.model.PostGoodsInfo(java.lang.String.valueOf(initCreateOrder.getGoods().get(0).getGoodsId()), 1));
        this.goods = arrayList;
    }

    public PostOrderData(java.util.List<com.up366.mobile.common.logic.model.PostGoodsInfo> list, java.lang.String str, boolean z, java.lang.String str2) {
        this.goods = list;
        this.bonusId = str;
        this.useBalanace = z;
        this.type = str2;
    }

    public java.util.List<com.up366.mobile.common.logic.model.PostGoodsInfo> getGoods() {
        return this.goods;
    }

    public void setGoods(java.util.List<com.up366.mobile.common.logic.model.PostGoodsInfo> list) {
        this.goods = list;
    }

    public java.lang.String getBonusId() {
        return this.bonusId;
    }

    public void setBonusId(java.lang.String str) {
        this.bonusId = str;
    }

    public boolean isUseBalanace() {
        return this.useBalanace;
    }

    public void setUseBalanace(boolean z) {
        this.useBalanace = z;
    }

    public java.lang.String getType() {
        return this.type;
    }

    public void setType(java.lang.String str) {
        this.type = str;
    }
}
