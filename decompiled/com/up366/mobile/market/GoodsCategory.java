package com.up366.mobile.market;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class GoodsCategory {
    private int categoryId;
    private java.lang.String categoryName;
    private java.util.List<com.up366.mobile.market.GoodsCategory> childs;
    private int displayOrder;
    private int level;
    private java.lang.String marketUrl;
    private int pid;
    private java.lang.String previewUrl;

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public java.lang.String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(java.lang.String str) {
        this.categoryName = str;
    }

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public java.lang.String getMarketUrl() {
        return this.marketUrl;
    }

    public void setMarketUrl(java.lang.String str) {
        this.marketUrl = str;
    }

    public int getPid() {
        return this.pid;
    }

    public void setPid(int i) {
        this.pid = i;
    }

    public java.lang.String getPreviewUrl() {
        return this.previewUrl;
    }

    public void setPreviewUrl(java.lang.String str) {
        this.previewUrl = str;
    }

    public java.util.List<com.up366.mobile.market.GoodsCategory> getChilds() {
        return this.childs;
    }

    public void setChilds(java.util.List<com.up366.mobile.market.GoodsCategory> list) {
        this.childs = list;
    }

    public void add(com.up366.mobile.market.GoodsCategory goodsCategory) {
        if (this.childs == null) {
            this.childs = new java.util.ArrayList();
        }
        if (goodsCategory.getPid() == getCategoryId()) {
            this.childs.add(goodsCategory);
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.market.GoodsCategory goodsCategory = (com.up366.mobile.market.GoodsCategory) obj;
        if (this.categoryId != goodsCategory.categoryId) {
            return false;
        }
        java.lang.String str = this.categoryName;
        java.lang.String str2 = goodsCategory.categoryName;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        int i = this.categoryId * 31;
        java.lang.String str = this.categoryName;
        return i + (str != null ? str.hashCode() : 0);
    }
}
