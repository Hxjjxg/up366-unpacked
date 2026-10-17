package com.up366.mobile.course.mgr;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class CourseBookInfo {
    private long addCourseTime;

    @com.alibaba.fastjson.annotation.JSONField(name = "autherName")
    private java.lang.String authorName;
    private java.lang.String bookId;
    private java.lang.String bookName;
    private int bookType;
    private java.lang.String buyCount;
    private int categoryType;
    private int courseId;
    private long endTime;
    private java.lang.String fileId;

    @com.alibaba.fastjson.annotation.JSONField(name = "goodsImg")
    private java.lang.String goodsBigImg;
    private int goodsId;

    @com.alibaba.fastjson.annotation.JSONField(name = "goodsVerticalImg")
    private java.lang.String goodsImg;
    private float goodsPrice;
    private java.lang.String guid;
    private int isGoods;
    private transient boolean isNew;
    private int isShelf;
    private float marketPrice;
    private java.lang.String mobileRevision;
    private int packType;
    private java.lang.String pcFileId;
    private java.lang.Long rowId;
    private java.lang.String specialFlag;
    private int stageId;
    private java.lang.String studyTraceFlag;
    private int subjectId;
    private int toMobile;

    @com.alibaba.fastjson.annotation.JSONField(name = "toPC")
    private int toPc;
    private java.lang.String wordsFlag;

    public CourseBookInfo(java.lang.Long l, java.lang.String str, int i, java.lang.String str2, java.lang.String str3, int i2, float f, float f2, java.lang.String str4, java.lang.String str5, int i3, java.lang.String str6, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10, java.lang.String str11, long j, java.lang.String str12, java.lang.String str13, long j2) {
        this.rowId = l;
        this.guid = str;
        this.courseId = i;
        this.bookId = str2;
        this.bookName = str3;
        this.goodsId = i2;
        this.goodsPrice = f;
        this.marketPrice = f2;
        this.goodsImg = str4;
        this.goodsBigImg = str5;
        this.isShelf = i3;
        this.buyCount = str6;
        this.bookType = i4;
        this.categoryType = i5;
        this.isGoods = i6;
        this.toPc = i7;
        this.toMobile = i8;
        this.packType = i9;
        this.stageId = i10;
        this.subjectId = i11;
        this.fileId = str7;
        this.pcFileId = str8;
        this.wordsFlag = str9;
        this.specialFlag = str10;
        this.studyTraceFlag = str11;
        this.addCourseTime = j;
        this.authorName = str12;
        this.mobileRevision = str13;
        this.endTime = j2;
    }

    public CourseBookInfo() {
        this.toMobile = 1;
    }

    public int getIsGoods() {
        return this.isGoods;
    }

    public void setIsGoods(int i) {
        this.isGoods = i;
    }

    public boolean isGoods() {
        return this.isGoods == 1;
    }

    public int getToPc() {
        return this.toPc;
    }

    public void setToPc(int i) {
        this.toPc = i;
    }

    public int getToMobile() {
        return this.toMobile;
    }

    public void setToMobile(int i) {
        this.toMobile = i;
    }

    public void genGuid() {
        this.guid = this.bookId + "-" + this.courseId;
    }

    public java.lang.String getGuid() {
        return this.guid;
    }

    public void setGuid(java.lang.String str) {
        this.guid = str;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int i) {
        this.courseId = i;
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

    public java.lang.String getGoodsBigImg() {
        return this.goodsBigImg;
    }

    public void setGoodsBigImg(java.lang.String str) {
        this.goodsBigImg = str;
    }

    public int getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(int i) {
        this.goodsId = i;
    }

    public java.lang.String getGoodsImg() {
        return this.goodsImg;
    }

    public void setGoodsImg(java.lang.String str) {
        this.goodsImg = str;
    }

    public float getGoodsPrice() {
        return this.goodsPrice;
    }

    public void setGoodsPrice(float f) {
        this.goodsPrice = f;
    }

    public int getIsShelf() {
        return this.isShelf;
    }

    public boolean isShelf() {
        return this.isShelf == 1;
    }

    public void setIsShelf(int i) {
        this.isShelf = i;
    }

    public float getMarketPrice() {
        return this.marketPrice;
    }

    public void setMarketPrice(float f) {
        this.marketPrice = f;
    }

    public java.lang.String getBuyCount() {
        return this.buyCount;
    }

    public void setBuyCount(java.lang.String str) {
        this.buyCount = str;
    }

    public int getBookType() {
        return this.bookType;
    }

    public void setBookType(int i) {
        this.bookType = i;
    }

    public int getCategoryType() {
        return this.categoryType;
    }

    public int getRemainDay() {
        return (int) java.lang.Math.ceil((((((getEndTime() - com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()) * 1.0f) / 24.0f) / 60.0f) / 60.0f) / 1000.0f);
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

    public java.lang.String getWordsFlag() {
        return this.wordsFlag;
    }

    public void setWordsFlag(java.lang.String str) {
        this.wordsFlag = str;
    }

    public java.lang.String getSpecialFlag() {
        return this.specialFlag;
    }

    public void setSpecialFlag(java.lang.String str) {
        this.specialFlag = str;
    }

    public java.lang.String getStudyTraceFlag() {
        return this.studyTraceFlag;
    }

    public void setStudyTraceFlag(java.lang.String str) {
        this.studyTraceFlag = str;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public long getAddCourseTime() {
        return this.addCourseTime;
    }

    public void setAddCourseTime(long j) {
        this.addCourseTime = j;
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
        com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo = (com.up366.mobile.course.mgr.CourseBookInfo) obj;
        if (this.courseId != courseBookInfo.courseId || this.goodsId != courseBookInfo.goodsId || java.lang.Float.compare(courseBookInfo.goodsPrice, this.goodsPrice) != 0 || java.lang.Float.compare(courseBookInfo.marketPrice, this.marketPrice) != 0 || this.isShelf != courseBookInfo.isShelf || this.bookType != courseBookInfo.bookType || this.categoryType != courseBookInfo.categoryType || this.isGoods != courseBookInfo.isGoods || this.toPc != courseBookInfo.toPc || this.toMobile != courseBookInfo.toMobile || this.packType != courseBookInfo.packType || this.stageId != courseBookInfo.stageId || this.subjectId != courseBookInfo.subjectId || this.addCourseTime != courseBookInfo.addCourseTime || this.isNew != courseBookInfo.isNew || this.endTime != courseBookInfo.endTime) {
            return false;
        }
        java.lang.Long l = this.rowId;
        if (l == null ? courseBookInfo.rowId != null : !l.equals(courseBookInfo.rowId)) {
            return false;
        }
        java.lang.String str = this.guid;
        if (str == null ? courseBookInfo.guid != null : !str.equals(courseBookInfo.guid)) {
            return false;
        }
        java.lang.String str2 = this.bookId;
        if (str2 == null ? courseBookInfo.bookId != null : !str2.equals(courseBookInfo.bookId)) {
            return false;
        }
        java.lang.String str3 = this.bookName;
        if (str3 == null ? courseBookInfo.bookName != null : !str3.equals(courseBookInfo.bookName)) {
            return false;
        }
        java.lang.String str4 = this.goodsImg;
        if (str4 == null ? courseBookInfo.goodsImg != null : !str4.equals(courseBookInfo.goodsImg)) {
            return false;
        }
        java.lang.String str5 = this.goodsBigImg;
        if (str5 == null ? courseBookInfo.goodsBigImg != null : !str5.equals(courseBookInfo.goodsBigImg)) {
            return false;
        }
        java.lang.String str6 = this.buyCount;
        if (str6 == null ? courseBookInfo.buyCount != null : !str6.equals(courseBookInfo.buyCount)) {
            return false;
        }
        java.lang.String str7 = this.fileId;
        if (str7 == null ? courseBookInfo.fileId != null : !str7.equals(courseBookInfo.fileId)) {
            return false;
        }
        java.lang.String str8 = this.pcFileId;
        if (str8 == null ? courseBookInfo.pcFileId != null : !str8.equals(courseBookInfo.pcFileId)) {
            return false;
        }
        java.lang.String str9 = this.wordsFlag;
        if (str9 == null ? courseBookInfo.wordsFlag != null : !str9.equals(courseBookInfo.wordsFlag)) {
            return false;
        }
        java.lang.String str10 = this.specialFlag;
        if (str10 == null ? courseBookInfo.specialFlag != null : !str10.equals(courseBookInfo.specialFlag)) {
            return false;
        }
        java.lang.String str11 = this.studyTraceFlag;
        if (str11 == null ? courseBookInfo.studyTraceFlag != null : !str11.equals(courseBookInfo.studyTraceFlag)) {
            return false;
        }
        java.lang.String str12 = this.authorName;
        if (str12 == null ? courseBookInfo.authorName != null : !str12.equals(courseBookInfo.authorName)) {
            return false;
        }
        java.lang.String str13 = this.mobileRevision;
        java.lang.String str14 = courseBookInfo.mobileRevision;
        return str13 != null ? str13.equals(str14) : str14 == null;
    }

    public int hashCode() {
        java.lang.Long l = this.rowId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        java.lang.String str = this.guid;
        int iHashCode2 = (((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.courseId) * 31;
        java.lang.String str2 = this.bookId;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.bookName;
        int iHashCode4 = (((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.goodsId) * 31;
        float f = this.goodsPrice;
        int iFloatToIntBits = (iHashCode4 + (f != 0.0f ? java.lang.Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.marketPrice;
        int iFloatToIntBits2 = (iFloatToIntBits + (f2 != 0.0f ? java.lang.Float.floatToIntBits(f2) : 0)) * 31;
        java.lang.String str4 = this.goodsImg;
        int iHashCode5 = (iFloatToIntBits2 + (str4 != null ? str4.hashCode() : 0)) * 31;
        java.lang.String str5 = this.goodsBigImg;
        int iHashCode6 = (((iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.isShelf) * 31;
        java.lang.String str6 = this.buyCount;
        int iHashCode7 = (((((((((((((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.bookType) * 31) + this.categoryType) * 31) + this.isGoods) * 31) + this.toPc) * 31) + this.toMobile) * 31) + this.packType) * 31) + this.stageId) * 31) + this.subjectId) * 31;
        java.lang.String str7 = this.fileId;
        int iHashCode8 = (iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        java.lang.String str8 = this.pcFileId;
        int iHashCode9 = (iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        java.lang.String str9 = this.wordsFlag;
        int iHashCode10 = (iHashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
        java.lang.String str10 = this.specialFlag;
        int iHashCode11 = (iHashCode10 + (str10 != null ? str10.hashCode() : 0)) * 31;
        java.lang.String str11 = this.studyTraceFlag;
        int iHashCode12 = (iHashCode11 + (str11 != null ? str11.hashCode() : 0)) * 31;
        long j = this.addCourseTime;
        int i = (iHashCode12 + ((int) (j ^ (j >>> 32)))) * 31;
        java.lang.String str12 = this.authorName;
        int iHashCode13 = (i + (str12 != null ? str12.hashCode() : 0)) * 31;
        java.lang.String str13 = this.mobileRevision;
        int iHashCode14 = (((iHashCode13 + (str13 != null ? str13.hashCode() : 0)) * 31) + (this.isNew ? 1 : 0)) * 31;
        long j2 = this.endTime;
        return iHashCode14 + ((int) (j2 ^ (j2 >>> 32)));
    }
}
