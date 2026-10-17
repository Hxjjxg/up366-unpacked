package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MyBook {
    private long addTime;
    private java.lang.String authorName;
    private java.lang.String bookId;
    private java.util.Map<java.lang.Integer, com.up366.mobile.course.mgr.CourseBookInfo> bookInfoMap = new java.util.HashMap();
    private java.lang.String bookName;
    private java.lang.String bookPic;
    private int bookType;
    private int categoryType;
    private int curCourseId;
    private long endDate;
    private java.lang.String fileId;
    private java.lang.String goodsBigImg;
    private int goodsId;
    private java.lang.String goodsImg;
    private float goodsPrice;
    private boolean hasBuy;
    private int isGoods;
    private boolean isNew;
    private int isShelf;
    private long lastStudyTime;
    private java.lang.String mobileVersion;
    private int packType;
    private int remainDay;
    private int spId;
    private int stageId;
    private long startDate;
    private int subjectId;
    private int toMobile;
    private int toPC;
    private int validDays;

    public MyBook(com.up366.mobile.common.logic.model.ProductInfo productInfo) {
        initByProductInfo(productInfo);
    }

    private void initByProductInfo(com.up366.mobile.common.logic.model.ProductInfo productInfo) {
        this.bookId = productInfo.getBookId();
        this.bookName = productInfo.getBookName();
        this.validDays = productInfo.getValidDays();
        this.hasBuy = true;
        this.bookPic = productInfo.getGoodsImg();
        this.remainDay = productInfo.getRemainDay();
        this.endDate = productInfo.getEndDate();
        this.toMobile = productInfo.getToMobile();
        this.lastStudyTime = productInfo.getLastStudyTime();
        this.isNew = productInfo.isNew();
        this.mobileVersion = productInfo.getMobileRevision();
        this.bookType = productInfo.getBookType();
        this.fileId = productInfo.getFileId();
        this.goodsId = productInfo.getGoodsId();
        this.goodsBigImg = productInfo.getGoodsBigImg();
        this.goodsImg = productInfo.getGoodsImg();
        this.addTime = productInfo.getAddTime();
        this.startDate = productInfo.getStartDate();
        this.stageId = productInfo.getStageId();
        this.subjectId = productInfo.getSubjectId();
        this.categoryType = productInfo.getCategoryType();
        this.packType = productInfo.getPackType();
        this.spId = productInfo.getSpId();
        this.isShelf = productInfo.getIsShelf();
        this.isGoods = productInfo.getIsGoods();
        this.goodsPrice = productInfo.getGoodsPrice();
        this.authorName = productInfo.getAuthorName();
        this.toPC = productInfo.getToPC();
    }

    public MyBook(com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo) {
        com.up366.mobile.common.logic.model.ProductInfo productInfo = com.up366.mobile.common.logic.Auth.cur().book().getProductInfo(courseBookInfo.getBookId());
        if (productInfo != null) {
            initByProductInfo(productInfo);
            this.lastStudyTime = com.up366.mobile.common.logic.Auth.cur().bookProgress().get(courseBookInfo.getBookId()).getLastStudyTime();
            return;
        }
        boolean zHasBuy = com.up366.mobile.common.logic.Auth.cur().book().hasBuy(courseBookInfo.getCourseId(), courseBookInfo.getBookId(), courseBookInfo.isGoods());
        this.hasBuy = zHasBuy;
        if (!zHasBuy && courseBookInfo.getIsShelf() != 1) {
            this.lastStudyTime = -1L;
        } else {
            this.lastStudyTime = com.up366.mobile.common.logic.Auth.cur().bookProgress().get(courseBookInfo.getBookId()).getLastStudyTime();
        }
        this.bookId = courseBookInfo.getBookId();
        this.bookName = courseBookInfo.getBookName();
        this.validDays = 0;
        this.bookPic = courseBookInfo.getGoodsImg();
        this.remainDay = courseBookInfo.getRemainDay();
        this.endDate = courseBookInfo.getEndTime();
        this.toMobile = courseBookInfo.getToMobile();
        this.isNew = courseBookInfo.isNew();
        this.mobileVersion = courseBookInfo.getMobileRevision();
        this.bookType = courseBookInfo.getBookType();
        this.fileId = courseBookInfo.getFileId();
        this.goodsId = courseBookInfo.getGoodsId();
        this.goodsBigImg = courseBookInfo.getGoodsBigImg();
        this.goodsImg = courseBookInfo.getGoodsImg();
        this.addTime = courseBookInfo.getAddCourseTime();
        this.stageId = courseBookInfo.getStageId();
        this.subjectId = courseBookInfo.getSubjectId();
        this.categoryType = courseBookInfo.getCategoryType();
        this.packType = courseBookInfo.getPackType();
        this.isShelf = courseBookInfo.getIsShelf();
        this.isGoods = courseBookInfo.getIsGoods();
        this.goodsPrice = courseBookInfo.getGoodsPrice();
        this.authorName = courseBookInfo.getAuthorName();
        this.toPC = courseBookInfo.getToPc();
    }

    public boolean isTextBook() {
        return this.bookType == 2;
    }

    public void addCourseBookInfo(com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo) {
        this.bookInfoMap.put(java.lang.Integer.valueOf(courseBookInfo.getCourseId()), courseBookInfo);
    }

    public java.util.Map<java.lang.Integer, com.up366.mobile.course.mgr.CourseBookInfo> getBookInfoMap() {
        return this.bookInfoMap;
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public java.lang.String getBookName() {
        return this.bookName;
    }

    public int getValidDays() {
        return this.validDays;
    }

    public boolean isHasBuy() {
        return this.hasBuy;
    }

    public java.lang.String getBookPic() {
        return this.bookPic;
    }

    public int getRemainDay() {
        return this.remainDay;
    }

    public long getEndDate() {
        return this.endDate;
    }

    public boolean containsCourseId(int i) {
        return this.bookInfoMap.containsKey(java.lang.Integer.valueOf(i));
    }

    public void setCurCourseId(int i) {
        this.curCourseId = i;
    }

    public int getCurCourseId() {
        return this.curCourseId;
    }

    public long getLastStudyTime() {
        return this.lastStudyTime;
    }

    public void setLastStudyTime(long j) {
        this.lastStudyTime = j;
    }

    public int getToMobile() {
        return this.toMobile;
    }

    public boolean isNew() {
        return this.isNew;
    }

    public void setNew(boolean z) {
        this.isNew = z;
    }

    public java.lang.String getMobileVersion() {
        return this.mobileVersion;
    }

    public int getBookType() {
        return this.bookType;
    }

    public int getGoodsId() {
        return this.goodsId;
    }

    public java.lang.String getGoodsBigImg() {
        return this.goodsBigImg;
    }

    public java.lang.String getGoodsImg() {
        return this.goodsImg;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public long getStartDate() {
        return this.startDate;
    }

    public int getStageId() {
        return this.stageId;
    }

    public int getSubjectId() {
        return this.subjectId;
    }

    public int getCategoryType() {
        return this.categoryType;
    }

    public int getPackType() {
        return this.packType;
    }

    public java.lang.String getFileId() {
        return this.fileId;
    }

    public int getSpId() {
        return this.spId;
    }

    public int getIsShelf() {
        return this.isShelf;
    }

    public int getIsGoods() {
        return this.isGoods;
    }

    public float getGoodsPrice() {
        return this.goodsPrice;
    }

    public java.lang.String getAuthorName() {
        return this.authorName;
    }

    public int getToPC() {
        return this.toPC;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.common.logic.model.MyBook myBook = (com.up366.mobile.common.logic.model.MyBook) obj;
        if (this.validDays != myBook.validDays || this.hasBuy != myBook.hasBuy || this.remainDay != myBook.remainDay || this.endDate != myBook.endDate || this.toMobile != myBook.toMobile || this.bookType != myBook.bookType || this.lastStudyTime != myBook.lastStudyTime || this.curCourseId != myBook.curCourseId || this.goodsId != myBook.goodsId || this.addTime != myBook.addTime || this.startDate != myBook.startDate || this.stageId != myBook.stageId || this.subjectId != myBook.subjectId || this.categoryType != myBook.categoryType || this.packType != myBook.packType || this.spId != myBook.spId || this.isShelf != myBook.isShelf || this.isGoods != myBook.isGoods || java.lang.Float.compare(myBook.goodsPrice, this.goodsPrice) != 0 || this.toPC != myBook.toPC || this.isNew != myBook.isNew) {
            return false;
        }
        java.lang.String str = this.bookId;
        if (str == null ? myBook.bookId != null : !str.equals(myBook.bookId)) {
            return false;
        }
        java.lang.String str2 = this.bookName;
        if (str2 == null ? myBook.bookName != null : !str2.equals(myBook.bookName)) {
            return false;
        }
        java.lang.String str3 = this.bookPic;
        if (str3 == null ? myBook.bookPic != null : !str3.equals(myBook.bookPic)) {
            return false;
        }
        java.lang.String str4 = this.goodsBigImg;
        if (str4 == null ? myBook.goodsBigImg != null : !str4.equals(myBook.goodsBigImg)) {
            return false;
        }
        java.lang.String str5 = this.goodsImg;
        if (str5 == null ? myBook.goodsImg != null : !str5.equals(myBook.goodsImg)) {
            return false;
        }
        java.lang.String str6 = this.fileId;
        if (str6 == null ? myBook.fileId != null : !str6.equals(myBook.fileId)) {
            return false;
        }
        java.lang.String str7 = this.authorName;
        if (str7 == null ? myBook.authorName != null : !str7.equals(myBook.authorName)) {
            return false;
        }
        java.lang.String str8 = this.mobileVersion;
        java.lang.String str9 = myBook.mobileVersion;
        return str8 != null ? str8.equals(str9) : str9 == null;
    }

    public int hashCode() {
        java.lang.String str = this.bookId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        java.lang.String str2 = this.bookName;
        int iHashCode2 = (((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.validDays) * 31) + (this.hasBuy ? 1 : 0)) * 31;
        java.lang.String str3 = this.bookPic;
        int iHashCode3 = (((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.remainDay) * 31;
        long j = this.endDate;
        int i = (((((iHashCode3 + ((int) (j ^ (j >>> 32)))) * 31) + this.toMobile) * 31) + this.bookType) * 31;
        long j2 = this.lastStudyTime;
        int i2 = (((((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.curCourseId) * 31) + this.goodsId) * 31;
        java.lang.String str4 = this.goodsBigImg;
        int iHashCode4 = (i2 + (str4 != null ? str4.hashCode() : 0)) * 31;
        java.lang.String str5 = this.goodsImg;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        long j3 = this.addTime;
        int i3 = (iHashCode5 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.startDate;
        int i4 = (((((((((i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.stageId) * 31) + this.subjectId) * 31) + this.categoryType) * 31) + this.packType) * 31;
        java.lang.String str6 = this.fileId;
        int iHashCode6 = (((((((i4 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.spId) * 31) + this.isShelf) * 31) + this.isGoods) * 31;
        float f = this.goodsPrice;
        int iFloatToIntBits = (iHashCode6 + (f != 0.0f ? java.lang.Float.floatToIntBits(f) : 0)) * 31;
        java.lang.String str7 = this.authorName;
        int iHashCode7 = (((((iFloatToIntBits + (str7 != null ? str7.hashCode() : 0)) * 31) + this.toPC) * 31) + (this.isNew ? 1 : 0)) * 31;
        java.lang.String str8 = this.mobileVersion;
        return iHashCode7 + (str8 != null ? str8.hashCode() : 0);
    }
}
