package com.up366.mobile.course.mgr;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class DailyInterestInfo {
    public static final int TYPE_SHOW_BOOK = 0;
    public static final int TYPE_SHOW_SCAN = 1;
    private java.lang.String bookId;
    private java.lang.String bookName;
    private int bookType = 1;
    private java.lang.String coverImg;
    private java.lang.String goodsImg;
    private java.lang.String goodsVerticalImg;
    private transient boolean isFirst;
    private transient boolean isNew;
    private java.lang.String mark;
    private java.lang.String mobileRevision;
    private java.lang.String pcRevision;
    private int showType;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @interface ShowType {
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public int getBookType() {
        return this.bookType;
    }

    public void setBookType(int i) {
        this.bookType = i;
    }

    public java.lang.String getBookName() {
        return this.bookName;
    }

    public void setBookName(java.lang.String str) {
        this.bookName = str;
    }

    public java.lang.String getCoverImg() {
        return this.coverImg;
    }

    public void setCoverImg(java.lang.String str) {
        this.coverImg = str;
    }

    public java.lang.String getGoodsImg() {
        return this.goodsImg;
    }

    public void setGoodsImg(java.lang.String str) {
        this.goodsImg = str;
    }

    public java.lang.String getGoodsVerticalImg() {
        return this.goodsVerticalImg;
    }

    public void setGoodsVerticalImg(java.lang.String str) {
        this.goodsVerticalImg = str;
    }

    public java.lang.String getMark() {
        return this.mark;
    }

    public void setMark(java.lang.String str) {
        this.mark = str;
    }

    public java.lang.String getMobileRevision() {
        return this.mobileRevision;
    }

    public void setMobileRevision(java.lang.String str) {
        this.mobileRevision = str;
    }

    public java.lang.String getPcRevision() {
        return this.pcRevision;
    }

    public void setPcRevision(java.lang.String str) {
        this.pcRevision = str;
    }

    public boolean isNew() {
        return this.isNew;
    }

    public void setNew(boolean z) {
        this.isNew = z;
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public void setFirst(boolean z) {
        this.isFirst = z;
    }

    public int getShowType() {
        return this.showType;
    }

    public void setShowType(int i) {
        this.showType = i;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.course.mgr.DailyInterestInfo dailyInterestInfo = (com.up366.mobile.course.mgr.DailyInterestInfo) obj;
        return this.bookType == dailyInterestInfo.bookType && this.showType == dailyInterestInfo.showType && this.isNew == dailyInterestInfo.isNew && this.isFirst == dailyInterestInfo.isFirst && java.util.Objects.equals(this.bookId, dailyInterestInfo.bookId) && java.util.Objects.equals(this.bookName, dailyInterestInfo.bookName) && java.util.Objects.equals(this.coverImg, dailyInterestInfo.coverImg) && java.util.Objects.equals(this.goodsImg, dailyInterestInfo.goodsImg) && java.util.Objects.equals(this.goodsVerticalImg, dailyInterestInfo.goodsVerticalImg) && java.util.Objects.equals(this.mark, dailyInterestInfo.mark) && java.util.Objects.equals(this.mobileRevision, dailyInterestInfo.mobileRevision) && java.util.Objects.equals(this.pcRevision, dailyInterestInfo.pcRevision);
    }

    public int hashCode() {
        return java.util.Objects.hash(this.bookId, java.lang.Integer.valueOf(this.bookType), this.bookName, this.coverImg, this.goodsImg, this.goodsVerticalImg, this.mark, this.mobileRevision, this.pcRevision, java.lang.Integer.valueOf(this.showType), java.lang.Boolean.valueOf(this.isNew), java.lang.Boolean.valueOf(this.isFirst));
    }
}
