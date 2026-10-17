package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookDetailInfo {
    private long addTime;
    private java.lang.String bookId;
    private java.lang.String bookName;
    private int bookType;
    private int categoryType;
    private com.alibaba.fastjson.JSONObject configObj;
    private java.lang.String configs;
    private long endDate;
    private java.lang.String fileId;

    @com.alibaba.fastjson.annotation.JSONField(name = "goodsImg")
    private java.lang.String goodsBigImg;
    private int goodsId;

    @com.alibaba.fastjson.annotation.JSONField(name = "goodsVerticalImg")
    private java.lang.String goodsImg;
    private float goodsPrice;
    private int isGoods;
    private int isOwned;
    private int isShelf;
    private java.lang.String openUrl;
    private int packType;
    private java.lang.String pcFileId;
    private java.lang.String resourceList;
    private com.up366.mobile.book.model.BookDetailInfo.ResourceList resourceListObj;
    private java.lang.Long rowId;
    private int spId;
    private int stageId;
    private long startDate;
    private int subjectId;
    private int toMobile;
    private int toPC;
    private int validDays;

    public BookDetailInfo(java.lang.Long l, java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.lang.String str4, long j, long j2, long j3, int i2, int i3, int i4, int i5, int i6, java.lang.String str5, java.lang.String str6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, float f, java.lang.String str7, java.lang.String str8, java.lang.String str9) {
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
        this.isOwned = i11;
        this.isShelf = i12;
        this.isGoods = i13;
        this.goodsPrice = f;
        this.configs = str7;
        this.resourceList = str8;
        this.openUrl = str9;
    }

    public BookDetailInfo() {
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

    public java.lang.String getGoodsImg() {
        return this.goodsImg;
    }

    public void setGoodsImg(java.lang.String str) {
        this.goodsImg = str;
    }

    public java.lang.String getGoodsBigImg() {
        return this.goodsBigImg;
    }

    public void setGoodsBigImg(java.lang.String str) {
        this.goodsBigImg = str;
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

    public boolean toMobile() {
        return this.toMobile == 1;
    }

    public void setToMobile(int i) {
        this.toMobile = i;
    }

    public int getIsOwned() {
        return this.isOwned;
    }

    public void setIsOwned(int i) {
        this.isOwned = i;
    }

    public int getIsShelf() {
        return this.isShelf;
    }

    public void setIsShelf(int i) {
        this.isShelf = i;
    }

    public boolean isShelf() {
        return this.isShelf == 1;
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

    public boolean isGoods() {
        return this.isGoods == 1;
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

    public java.lang.String getConfigs() {
        return this.configs;
    }

    public void setConfigs(java.lang.String str) {
        this.configs = str;
    }

    private void initConfigObj() {
        if (this.configObj != null) {
            return;
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(this.configs);
        this.configObj = object;
        if (object == null) {
            this.configObj = new com.alibaba.fastjson.JSONObject();
        }
    }

    public boolean hasCustomTask() {
        initConfigObj();
        return this.configObj.getIntValue("customFlag") == 1;
    }

    public java.lang.String getOpenUrl() {
        return this.openUrl;
    }

    public void setOpenUrl(java.lang.String str) {
        this.openUrl = str;
    }

    public java.lang.String getResourceList() {
        return this.resourceList;
    }

    public void setResourceList(java.lang.String str) {
        this.resourceList = str;
    }

    public com.up366.mobile.book.model.BookDetailInfo.ResourceList getResourceListObj() {
        com.up366.mobile.book.model.BookDetailInfo.ResourceList resourceList = new com.up366.mobile.book.model.BookDetailInfo.ResourceList();
        this.resourceListObj = resourceList;
        java.lang.String str = this.resourceList;
        if (str == null) {
            return resourceList;
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        if (object.containsKey("dirGlobal")) {
            this.resourceListObj.setDirGlobal((java.lang.String[]) object.getJSONArray("dirGlobal").toArray(new java.lang.String[0]));
        }
        if (object.containsKey("dirBooks")) {
            this.resourceListObj.setDirBooks((java.lang.String[]) object.getJSONArray("dirBooks").toArray(new java.lang.String[0]));
        }
        if (object.containsKey("dirExtend")) {
            this.resourceListObj.setDirExtend((java.lang.String[]) object.getJSONArray("dirExtend").toArray(new java.lang.String[0]));
        }
        return this.resourceListObj;
    }

    public void setResourceListObj(com.up366.mobile.book.model.BookDetailInfo.ResourceList resourceList) {
        this.resourceListObj = resourceList;
    }

    public static class ResourceList {
        private java.lang.String[] dirGlobal = new java.lang.String[0];
        private java.lang.String[] dirBooks = new java.lang.String[0];
        private java.lang.String[] dirExtend = new java.lang.String[0];

        public java.lang.String[] getDirGlobal() {
            return this.dirGlobal;
        }

        public void setDirGlobal(java.lang.String[] strArr) {
            if (strArr == null) {
                strArr = new java.lang.String[0];
            }
            this.dirGlobal = strArr;
        }

        public java.lang.String[] getDirBooks() {
            return this.dirBooks;
        }

        public void setDirBooks(java.lang.String[] strArr) {
            if (strArr == null) {
                strArr = new java.lang.String[0];
            }
            this.dirBooks = strArr;
        }

        public java.lang.String[] getDirExtend() {
            return this.dirExtend;
        }

        public void setDirExtend(java.lang.String[] strArr) {
            if (strArr == null) {
                strArr = new java.lang.String[0];
            }
            this.dirExtend = strArr;
        }
    }
}
