package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ChapterInfo {
    public static final int CHAPTER_TYPE_NORMAL = 1;
    public static final int CHAPTER_TYPE_OFFLINE_PAPER = 5;
    public static final int CHAPTER_TYPE_ONLINE_PAPER = 4;
    public static final int CHAPTER_TYPE_ORAL = 2;
    public static final int CHAPTER_TYPE_SPEECH = 3;
    public static final int CONTENT_NO = 0;
    public static final int CONTENT_YES = 1;
    public static final int FREE_NO = 0;
    public static final int FREE_YES = 1;
    public static final int LOCK_NO = 0;
    public static final int LOCK_YES = 1;
    public static final int NODE_TYPE_CHAPTER = 1;
    public static final int NODE_TYPE_PAGE = 2;
    public static final int NODE_TYPE_TASK = 3;
    public static final int OPEN_NO = 0;
    public static final int OPEN_YES = 1;
    public static final int SHELF_OFF = 0;
    public static final int SHELF_ON = 1;
    private long addTime;
    private java.lang.String bookId;
    private int chapterType;
    private int displayOrder;

    @com.alibaba.fastjson.annotation.JSONField(name = "extendParams")
    private java.lang.String extendParams;
    private java.lang.String fileId;

    @com.alibaba.fastjson.annotation.JSONField(name = "grayConfig")
    private java.lang.String grayConfig;
    private java.lang.String id;
    private int isContent;
    private int isFree;
    private int isLock;
    private int isShelf;
    private int isTest;
    private int level;
    private java.lang.String mobileStatus;
    private java.lang.String name;
    private java.lang.String paperId;
    private java.lang.String parentId;
    private int pcStatus;
    private java.lang.String pictureUrl;
    private java.lang.String resourceList;
    private com.up366.mobile.book.model.ChapterInfo.ResourceList resourceListObj;
    private java.lang.Long rowId;
    private java.lang.String taskId;

    @com.alibaba.fastjson.annotation.JSONField(name = "score")
    private float totalScore;
    private int type;
    private float unitStudyPercent;
    private float weight;
    private java.lang.String welFileName;
    private java.lang.String xotPaperId;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface NodeType {
    }

    public boolean isWelcome() {
        return false;
    }

    public ChapterInfo(com.up366.mobile.book.model.ChapterInfo chapterInfo) {
        this.weight = -1.0f;
        this.isShelf = 1;
        this.isLock = 0;
        this.rowId = chapterInfo.rowId;
        this.id = chapterInfo.id;
        this.parentId = chapterInfo.parentId;
        this.bookId = chapterInfo.bookId;
        this.name = chapterInfo.name;
        this.welFileName = chapterInfo.welFileName;
        this.type = chapterInfo.type;
        this.level = chapterInfo.level;
        this.displayOrder = chapterInfo.displayOrder;
        this.isContent = chapterInfo.isContent;
        this.isFree = chapterInfo.isFree;
        this.chapterType = chapterInfo.chapterType;
        this.weight = chapterInfo.weight;
        this.taskId = chapterInfo.taskId;
        this.pcStatus = chapterInfo.pcStatus;
        this.fileId = chapterInfo.fileId;
        this.mobileStatus = chapterInfo.mobileStatus;
        this.xotPaperId = chapterInfo.xotPaperId;
        this.pictureUrl = chapterInfo.pictureUrl;
        this.isTest = chapterInfo.isTest;
        this.totalScore = chapterInfo.totalScore;
        this.extendParams = chapterInfo.extendParams;
        this.addTime = chapterInfo.addTime;
        this.isLock = chapterInfo.isLock;
        this.unitStudyPercent = chapterInfo.unitStudyPercent;
        this.isShelf = chapterInfo.isShelf;
        this.grayConfig = chapterInfo.grayConfig;
        this.resourceList = chapterInfo.resourceList;
    }

    public ChapterInfo(java.lang.Long l, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i, int i2, int i3, int i4, int i5, int i6, float f, java.lang.String str6, int i7, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10, int i8, float f2, java.lang.String str11, long j, java.lang.String str12, int i9, java.lang.String str13, java.lang.String str14, int i10, float f3) {
        this.rowId = l;
        this.id = str;
        this.parentId = str2;
        this.bookId = str3;
        this.name = str4;
        this.welFileName = str5;
        this.type = i;
        this.level = i2;
        this.displayOrder = i3;
        this.isContent = i4;
        this.isFree = i5;
        this.chapterType = i6;
        this.weight = f;
        this.taskId = str6;
        this.pcStatus = i7;
        this.fileId = str7;
        this.mobileStatus = str8;
        this.xotPaperId = str9;
        this.pictureUrl = str10;
        this.isTest = i8;
        this.totalScore = f2;
        this.extendParams = str11;
        this.addTime = j;
        this.paperId = str12;
        this.isShelf = i9;
        this.grayConfig = str13;
        this.resourceList = str14;
        this.isLock = i10;
        this.unitStudyPercent = f3;
    }

    public ChapterInfo() {
        this.weight = -1.0f;
        this.isShelf = 1;
        this.isLock = 0;
    }

    public java.lang.String getId() {
        return this.id;
    }

    public void setId(java.lang.String str) {
        this.id = str;
    }

    public java.lang.String getParentId() {
        return this.parentId;
    }

    public void setParentId(java.lang.String str) {
        this.parentId = str;
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public java.lang.String getWelFileName() {
        return this.welFileName;
    }

    public void setWelFileName(java.lang.String str) {
        this.welFileName = str;
    }

    public int getIsContent() {
        return this.isContent;
    }

    public void setIsContent(int i) {
        this.isContent = i;
    }

    public boolean isContent() {
        return this.isContent == 1;
    }

    public boolean isRootNode() {
        return this.level == 0 && com.up366.common.StringUtils.isEmptyOrNull(this.parentId);
    }

    public boolean isChapter() {
        return this.type == 1;
    }

    public boolean isPage() {
        return this.type == 2;
    }

    public boolean isTask() {
        return this.type == 3;
    }

    public int getIsLock() {
        return this.isLock;
    }

    public void setIsLock(int i) {
        this.isLock = i;
    }

    public boolean isLock() {
        return this.isLock == 1;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public int getIsFree() {
        return this.isFree;
    }

    public boolean isFree() {
        return this.isFree == 1;
    }

    public void setIsFree(int i) {
        this.isFree = i;
    }

    public int getChapterType() {
        return this.chapterType;
    }

    public void setChapterType(int i) {
        this.chapterType = i;
    }

    public float getWeight() {
        return this.weight;
    }

    public void setWeight(float f) {
        this.weight = f;
    }

    public int getPcStatus() {
        return this.pcStatus;
    }

    public void setPcStatus(int i) {
        this.pcStatus = i;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }

    public java.lang.String getFileId() {
        return this.fileId;
    }

    public void setFileId(java.lang.String str) {
        this.fileId = str;
    }

    public java.lang.String getMobileStatus() {
        return this.mobileStatus;
    }

    public void setMobileStatus(java.lang.String str) {
        this.mobileStatus = str;
    }

    public java.lang.String getXotPaperId() {
        return this.xotPaperId;
    }

    public void setXotPaperId(java.lang.String str) {
        this.xotPaperId = str;
    }

    public float getUnitStudyPercent() {
        return this.unitStudyPercent;
    }

    public void setUnitStudyPercent(float f) {
        this.unitStudyPercent = f;
    }

    public int getIsTest() {
        return this.isTest;
    }

    public void setIsTest(int i) {
        this.isTest = i;
    }

    public float getTotalScore() {
        return this.totalScore;
    }

    public void setTotalScore(float f) {
        this.totalScore = f;
    }

    public java.lang.String getExtendParams() {
        return this.extendParams;
    }

    public void setExtendParams(java.lang.String str) {
        this.extendParams = str;
    }

    public java.lang.String getPictureUrl() {
        return this.pictureUrl;
    }

    public void setPictureUrl(java.lang.String str) {
        this.pictureUrl = str;
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

    public java.lang.String getPaperId() {
        return this.paperId;
    }

    public void setPaperId(java.lang.String str) {
        this.paperId = str;
    }

    public int getIsShelf() {
        return this.isShelf;
    }

    public void setIsShelf(int i) {
        this.isShelf = i;
    }

    public java.lang.String getGrayConfig() {
        return this.grayConfig;
    }

    public void setGrayConfig(java.lang.String str) {
        this.grayConfig = str;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.book.model.ChapterInfo chapterInfo = (com.up366.mobile.book.model.ChapterInfo) obj;
        return this.type == chapterInfo.type && this.level == chapterInfo.level && this.displayOrder == chapterInfo.displayOrder && this.isContent == chapterInfo.isContent && this.isFree == chapterInfo.isFree && this.chapterType == chapterInfo.chapterType && java.lang.Float.compare(chapterInfo.weight, this.weight) == 0 && this.pcStatus == chapterInfo.pcStatus && this.isTest == chapterInfo.isTest && java.lang.Float.compare(chapterInfo.totalScore, this.totalScore) == 0 && this.addTime == chapterInfo.addTime && this.isShelf == chapterInfo.isShelf && this.isLock == chapterInfo.isLock && java.lang.Float.compare(chapterInfo.unitStudyPercent, this.unitStudyPercent) == 0 && java.util.Objects.equals(this.rowId, chapterInfo.rowId) && java.util.Objects.equals(this.id, chapterInfo.id) && java.util.Objects.equals(this.parentId, chapterInfo.parentId) && java.util.Objects.equals(this.bookId, chapterInfo.bookId) && java.util.Objects.equals(this.name, chapterInfo.name) && java.util.Objects.equals(this.welFileName, chapterInfo.welFileName) && java.util.Objects.equals(this.taskId, chapterInfo.taskId) && java.util.Objects.equals(this.fileId, chapterInfo.fileId) && java.util.Objects.equals(this.mobileStatus, chapterInfo.mobileStatus) && java.util.Objects.equals(this.xotPaperId, chapterInfo.xotPaperId) && java.util.Objects.equals(this.pictureUrl, chapterInfo.pictureUrl) && java.util.Objects.equals(this.extendParams, chapterInfo.extendParams) && java.util.Objects.equals(this.paperId, chapterInfo.paperId) && java.util.Objects.equals(this.grayConfig, chapterInfo.grayConfig) && java.util.Objects.equals(this.resourceList, chapterInfo.resourceList);
    }

    public int hashCode() {
        return java.util.Objects.hash(this.rowId, this.id, this.parentId, this.bookId, this.name, this.welFileName, java.lang.Integer.valueOf(this.type), java.lang.Integer.valueOf(this.level), java.lang.Integer.valueOf(this.displayOrder), java.lang.Integer.valueOf(this.isContent), java.lang.Integer.valueOf(this.isFree), java.lang.Integer.valueOf(this.chapterType), java.lang.Float.valueOf(this.weight), this.taskId, java.lang.Integer.valueOf(this.pcStatus), this.fileId, this.mobileStatus, this.xotPaperId, this.pictureUrl, java.lang.Integer.valueOf(this.isTest), java.lang.Float.valueOf(this.totalScore), this.extendParams, java.lang.Long.valueOf(this.addTime), this.paperId, java.lang.Integer.valueOf(this.isShelf), java.lang.Integer.valueOf(this.isLock), java.lang.Float.valueOf(this.unitStudyPercent), this.grayConfig, this.resourceList);
    }

    public java.lang.String getResourceList() {
        return this.resourceList;
    }

    public void setResourceList(java.lang.String str) {
        this.resourceList = str;
    }

    public com.up366.mobile.book.model.ChapterInfo.ResourceList getResourceListObj() {
        com.up366.mobile.book.model.ChapterInfo.ResourceList resourceList = new com.up366.mobile.book.model.ChapterInfo.ResourceList();
        this.resourceListObj = resourceList;
        java.lang.String str = this.resourceList;
        if (str == null) {
            return resourceList;
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        if (object.containsKey("dirChapters")) {
            this.resourceListObj.setDirChapters((java.lang.String[]) object.getJSONArray("dirChapters").toArray(new java.lang.String[0]));
        }
        return this.resourceListObj;
    }

    public void setResourceListObj(com.up366.mobile.book.model.ChapterInfo.ResourceList resourceList) {
        this.resourceListObj = resourceList;
    }

    public static class ResourceList {
        private java.lang.String[] dirChapters = new java.lang.String[0];

        public java.lang.String[] getDirChapters() {
            return this.dirChapters;
        }

        public void setDirChapters(java.lang.String[] strArr) {
            this.dirChapters = strArr;
        }
    }
}
