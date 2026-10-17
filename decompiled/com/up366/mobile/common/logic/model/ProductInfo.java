package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ProductInfo {
    private long addTime;

    @com.alibaba.fastjson.annotation.JSONField(name = "autherName")
    private java.lang.String authorName;
    private java.lang.String bookId;
    private java.lang.String bookName;
    private int bookType;
    private int categoryType;
    private long endDate;
    private java.lang.String fileId;

    @com.alibaba.fastjson.annotation.JSONField(name = "goodsImg")
    private java.lang.String goodsBigImg;
    private int goodsId;

    @com.alibaba.fastjson.annotation.JSONField(name = "goodsVerticalImg")
    private java.lang.String goodsImg;
    private float goodsPrice;
    private int isGoods;
    private transient boolean isNew;
    private int isShelf;
    private transient long lastStudyTime;
    private java.lang.String mobileRevision;
    private int packType;
    private java.lang.String pcFileId;
    private java.lang.Long rowId;
    private int spId;
    private int stageId;
    private long startDate;
    private int subjectId;
    private int toMobile;
    private int toPC;
    private int validDays;

    public ProductInfo(java.lang.Long l, java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.lang.String str4, long j, long j2, long j3, int i2, int i3, int i4, int i5, int i6, java.lang.String str5, java.lang.String str6, int i7, int i8, int i9, int i10, int i11, int i12, float f, java.lang.String str7, java.lang.String str8) {
        this.rowId = l;
        this.bookId = str;
        this.bookName = str2;
        this.goodsId = i;
        this.goodsBigImg = str3;
        this.goodsImg = str4;
        this.addTime = j;
        this.startDate = j2;
        this.endDate = j3;
        this.validDays = i2;
        this.stageId = i3;
        this.subjectId = i4;
        this.categoryType = i5;
        this.packType = i6;
        this.fileId = str5;
        this.pcFileId = str6;
        this.spId = i7;
        this.bookType = i8;
        this.toPC = i9;
        this.toMobile = i10;
        this.isShelf = i11;
        this.isGoods = i12;
        this.goodsPrice = f;
        this.authorName = str7;
        this.mobileRevision = str8;
    }

    public ProductInfo() {
    }

    public long getLastStudyTime() {
        return this.lastStudyTime;
    }

    public void setLastStudyTime(long j) {
        this.lastStudyTime = j;
    }

    public int getRemainDay() {
        return (int) java.lang.Math.ceil((((((getEndDate() - com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()) * 1.0f) / 24.0f) / 60.0f) / 60.0f) / 1000.0f);
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public java.lang.String getBookName() {
        return this.bookName;
    }

    public void setBookName(java.lang.String str) {
        this.bookName = str;
    }

    public int getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(int i) {
        this.goodsId = i;
    }

    public java.lang.String getGoodsBigImg() {
        return this.goodsBigImg;
    }

    public void setGoodsBigImg(java.lang.String str) {
        this.goodsBigImg = str;
    }

    public java.lang.String getGoodsImg() {
        return this.goodsImg;
    }

    public void setGoodsImg(java.lang.String str) {
        this.goodsImg = str;
    }

    public long getStartDate() {
        return this.startDate;
    }

    public void setStartDate(long j) {
        this.startDate = j;
    }

    public long getEndDate() {
        return this.endDate;
    }

    public void setEndDate(long j) {
        this.endDate = j;
    }

    public int getValidDays() {
        return this.validDays;
    }

    public void setValidDays(int i) {
        this.validDays = i;
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

    public int getCategoryType() {
        return this.categoryType;
    }

    public void setCategoryType(int i) {
        this.categoryType = i;
    }

    public int getPackType() {
        return this.packType;
    }

    public void setPackType(int i) {
        this.packType = i;
    }

    public java.lang.String getFileId() {
        return this.fileId;
    }

    public void setFileId(java.lang.String str) {
        this.fileId = str;
    }

    public java.lang.String getPcFileId() {
        return this.pcFileId;
    }

    public void setPcFileId(java.lang.String str) {
        this.pcFileId = str;
    }

    public int getSpId() {
        return this.spId;
    }

    public void setSpId(int i) {
        this.spId = i;
    }

    public int getBookType() {
        return this.bookType;
    }

    public void setBookType(int i) {
        this.bookType = i;
    }

    public int getToPC() {
        return this.toPC;
    }

    public void setToPC(int i) {
        this.toPC = i;
    }

    public int getToMobile() {
        return this.toMobile;
    }

    public void setToMobile(int i) {
        this.toMobile = i;
    }

    public int getIsShelf() {
        return this.isShelf;
    }

    public void setIsShelf(int i) {
        this.isShelf = i;
    }

    public int getIsGoods() {
        return this.isGoods;
    }

    public void setIsGoods(int i) {
        this.isGoods = i;
    }

    public float getGoodsPrice() {
        return this.goodsPrice;
    }

    public void setGoodsPrice(float f) {
        this.goodsPrice = f;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public void setAddTime(long j) {
        this.addTime = j;
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }

    public java.lang.String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(java.lang.String str) {
        this.authorName = str;
    }

    public java.lang.String getMobileRevision() {
        return this.mobileRevision;
    }

    public void setMobileRevision(java.lang.String str) {
        this.mobileRevision = str;
    }

    public boolean isNew() {
        return this.isNew;
    }

    public void setNew(boolean z) {
        this.isNew = z;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.common.logic.model.ProductInfo productInfo = (com.up366.mobile.common.logic.model.ProductInfo) obj;
        if (this.goodsId != productInfo.goodsId || this.addTime != productInfo.addTime || this.startDate != productInfo.startDate || this.endDate != productInfo.endDate || this.validDays != productInfo.validDays || this.stageId != productInfo.stageId || this.subjectId != productInfo.subjectId || this.categoryType != productInfo.categoryType || this.packType != productInfo.packType || this.spId != productInfo.spId || this.bookType != productInfo.bookType || this.toPC != productInfo.toPC || this.toMobile != productInfo.toMobile || this.isShelf != productInfo.isShelf || this.isGoods != productInfo.isGoods || java.lang.Float.compare(productInfo.goodsPrice, this.goodsPrice) != 0 || this.lastStudyTime != productInfo.lastStudyTime || this.isNew != productInfo.isNew) {
            return false;
        }
        java.lang.Long l = this.rowId;
        if (l == null ? productInfo.rowId != null : !l.equals(productInfo.rowId)) {
            return false;
        }
        java.lang.String str = this.bookId;
        if (str == null ? productInfo.bookId != null : !str.equals(productInfo.bookId)) {
            return false;
        }
        java.lang.String str2 = this.bookName;
        if (str2 == null ? productInfo.bookName != null : !str2.equals(productInfo.bookName)) {
            return false;
        }
        java.lang.String str3 = this.goodsBigImg;
        if (str3 == null ? productInfo.goodsBigImg != null : !str3.equals(productInfo.goodsBigImg)) {
            return false;
        }
        java.lang.String str4 = this.goodsImg;
        if (str4 == null ? productInfo.goodsImg != null : !str4.equals(productInfo.goodsImg)) {
            return false;
        }
        java.lang.String str5 = this.fileId;
        if (str5 == null ? productInfo.fileId != null : !str5.equals(productInfo.fileId)) {
            return false;
        }
        java.lang.String str6 = this.pcFileId;
        if (str6 == null ? productInfo.pcFileId != null : !str6.equals(productInfo.pcFileId)) {
            return false;
        }
        java.lang.String str7 = this.authorName;
        if (str7 == null ? productInfo.authorName != null : !str7.equals(productInfo.authorName)) {
            return false;
        }
        java.lang.String str8 = this.mobileRevision;
        java.lang.String str9 = productInfo.mobileRevision;
        return str8 != null ? str8.equals(str9) : str9 == null;
    }

    public int hashCode() {
        java.lang.Long l = this.rowId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        java.lang.String str = this.bookId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.bookName;
        int iHashCode3 = (((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.goodsId) * 31;
        java.lang.String str3 = this.goodsBigImg;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        java.lang.String str4 = this.goodsImg;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        long j = this.addTime;
        int i = (iHashCode5 + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.startDate;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.endDate;
        int i3 = (((((((((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.validDays) * 31) + this.stageId) * 31) + this.subjectId) * 31) + this.categoryType) * 31) + this.packType) * 31;
        java.lang.String str5 = this.fileId;
        int iHashCode6 = (i3 + (str5 != null ? str5.hashCode() : 0)) * 31;
        java.lang.String str6 = this.pcFileId;
        int iHashCode7 = (((((((((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.spId) * 31) + this.bookType) * 31) + this.toPC) * 31) + this.toMobile) * 31) + this.isShelf) * 31) + this.isGoods) * 31;
        float f = this.goodsPrice;
        int iFloatToIntBits = (iHashCode7 + (f != 0.0f ? java.lang.Float.floatToIntBits(f) : 0)) * 31;
        java.lang.String str7 = this.authorName;
        int iHashCode8 = (iFloatToIntBits + (str7 != null ? str7.hashCode() : 0)) * 31;
        java.lang.String str8 = this.mobileRevision;
        int iHashCode9 = (iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        long j4 = this.lastStudyTime;
        return ((iHashCode9 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.isNew ? 1 : 0);
    }
}
