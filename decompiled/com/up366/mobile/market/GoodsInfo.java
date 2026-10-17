package com.up366.mobile.market;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class GoodsInfo implements java.io.Serializable {
    private static final long serialVersionUID = 289002602203055456L;
    private java.lang.String buyCount;
    private int categoryId;
    private int categoryType;

    @com.alibaba.fastjson.annotation.JSONField(name = "goodsImg")
    private java.lang.String goodsBigImg;
    private java.lang.String goodsBrief;
    private int goodsId;

    @com.alibaba.fastjson.annotation.JSONField(name = "goodsVerticalImg")
    private java.lang.String goodsImg;
    private java.lang.String goodsName;
    private float goodsPrice;
    private java.lang.String guid;
    private boolean hasBuy;
    private int isGroup;
    private float marketPrice;
    private int packType;
    private int recommentId;
    private java.lang.Long rowId;
    private int sortOrder;
    private java.lang.String spGoodsId;
    private int spId;
    private int stageId;
    private int subjectId;

    public GoodsInfo() {
    }

    public GoodsInfo(com.up366.mobile.common.logic.model.ProductInfo productInfo) {
        setGoodsId(productInfo.getGoodsId());
        setBuyCount("");
        setGoodsBrief("");
        setCategoryType(productInfo.getCategoryType());
        setGoodsBigImg(productInfo.getGoodsBigImg());
        setGoodsImg(productInfo.getGoodsImg());
        setGoodsName(productInfo.getBookName());
        setGoodsPrice(productInfo.getGoodsPrice());
        setPackType(productInfo.getPackType());
        setSpGoodsId(productInfo.getBookId());
        setSpId(productInfo.getSpId());
        setStageId(productInfo.getStageId());
        setSubjectId(productInfo.getSubjectId());
    }

    public GoodsInfo(com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo) {
        setGoodsId(courseBookInfo.getGoodsId());
        setBuyCount(courseBookInfo.getBuyCount());
        setCategoryType(courseBookInfo.getCategoryType());
        setGoodsBigImg(courseBookInfo.getGoodsBigImg());
        setGoodsImg(courseBookInfo.getGoodsImg());
        setGoodsName(courseBookInfo.getBookName());
        setGoodsPrice(courseBookInfo.getGoodsPrice());
        setMarketPrice(courseBookInfo.getMarketPrice());
        setPackType(courseBookInfo.getPackType());
        setSpGoodsId(courseBookInfo.getBookId());
        setSpId(java.lang.Integer.parseInt(com.up366.mobile.common.base.Constants.FLIPBOOK_SPID));
        setStageId(courseBookInfo.getStageId());
        setSubjectId(courseBookInfo.getSubjectId());
        if (courseBookInfo.getBookType() == 1) {
            setSpId(9);
        } else if (courseBookInfo.getBookType() == 2) {
            setSpId(12);
        }
    }

    public GoodsInfo(java.lang.Long l, java.lang.String str, int i, java.lang.String str2, java.lang.String str3, int i2, int i3, java.lang.String str4, java.lang.String str5, java.lang.String str6, float f, int i4, float f2, int i5, int i6, java.lang.String str7, int i7, int i8, int i9, int i10) {
        this.rowId = l;
        this.guid = str;
        this.goodsId = i;
        this.buyCount = str2;
        this.goodsBrief = str3;
        this.categoryId = i2;
        this.categoryType = i3;
        this.goodsBigImg = str4;
        this.goodsImg = str5;
        this.goodsName = str6;
        this.goodsPrice = f;
        this.isGroup = i4;
        this.marketPrice = f2;
        this.packType = i5;
        this.sortOrder = i6;
        this.spGoodsId = str7;
        this.spId = i7;
        this.stageId = i8;
        this.subjectId = i9;
        this.recommentId = i10;
    }

    public GoodsInfo(java.lang.Long l, java.lang.String str, int i, java.lang.String str2, java.lang.String str3, boolean z, int i2, int i3, java.lang.String str4, java.lang.String str5, java.lang.String str6, float f, int i4, float f2, int i5, int i6, java.lang.String str7, int i7, int i8, int i9, int i10) {
        this.rowId = l;
        this.guid = str;
        this.goodsId = i;
        this.buyCount = str2;
        this.goodsBrief = str3;
        this.hasBuy = z;
        this.categoryId = i2;
        this.categoryType = i3;
        this.goodsBigImg = str4;
        this.goodsImg = str5;
        this.goodsName = str6;
        this.goodsPrice = f;
        this.isGroup = i4;
        this.marketPrice = f2;
        this.packType = i5;
        this.sortOrder = i6;
        this.spGoodsId = str7;
        this.spId = i7;
        this.stageId = i8;
        this.subjectId = i9;
        this.recommentId = i10;
    }

    public void setGoodsId(int i) {
        this.goodsId = i;
    }

    public java.lang.String getBuyCount() {
        return this.buyCount;
    }

    public void setBuyCount(java.lang.String str) {
        this.buyCount = str;
    }

    public java.lang.String getGoodsBrief() {
        return this.goodsBrief;
    }

    public void setGoodsBrief(java.lang.String str) {
        this.goodsBrief = str;
    }

    public boolean isHasBuy() {
        return this.hasBuy;
    }

    public void setHasBuy(boolean z) {
        this.hasBuy = z;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public int getCategoryType() {
        return this.categoryType;
    }

    public void setCategoryType(int i) {
        this.categoryType = i;
    }

    public java.lang.String getGoodsBigImg() {
        return this.goodsBigImg;
    }

    public void setGoodsBigImg(java.lang.String str) {
        this.goodsBigImg = str;
    }

    public int getGoodsId() {
        return this.goodsId;
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

    public float getGoodsPrice() {
        return this.goodsPrice;
    }

    public void setGoodsPrice(float f) {
        this.goodsPrice = f;
    }

    public int getIsGroup() {
        return this.isGroup;
    }

    public void setIsGroup(int i) {
        this.isGroup = i;
    }

    public boolean isGroup() {
        return this.isGroup == 1;
    }

    public float getMarketPrice() {
        return this.marketPrice;
    }

    public void setMarketPrice(float f) {
        this.marketPrice = f;
    }

    public int getPackType() {
        return this.packType;
    }

    public void setPackType(int i) {
        this.packType = i;
    }

    public int getSortOrder() {
        return this.sortOrder;
    }

    public void setSortOrder(int i) {
        this.sortOrder = i;
    }

    public java.lang.String getSpGoodsId() {
        return this.spGoodsId;
    }

    public void setSpGoodsId(java.lang.String str) {
        this.spGoodsId = str;
    }

    public int getSpId() {
        return this.spId;
    }

    public void setSpId(int i) {
        this.spId = i;
    }

    public int getStageId() {
        return this.stageId;
    }

    public void setStageId(int i) {
        this.stageId = i;
    }

    public int getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(int i) {
        this.subjectId = i;
    }

    public int getRecommentId() {
        return this.recommentId;
    }

    public void setRecommentId(int i) {
        this.recommentId = i;
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }

    public java.lang.String getGuid() {
        return this.guid;
    }

    public void setGuid(java.lang.String str) {
        this.guid = str;
    }

    public boolean getHasBuy() {
        return this.hasBuy;
    }
}
