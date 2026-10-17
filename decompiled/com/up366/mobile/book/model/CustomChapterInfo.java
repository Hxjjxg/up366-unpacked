package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CustomChapterInfo {
    private java.lang.String bookId;
    private java.lang.String chapterId;
    private java.lang.String chapterName;
    private int chapterStatus;
    private int chapterType;
    private int checkStatus;
    private int courseId;
    private long createTime;
    private int createUid;
    private int displayOrder;
    private java.lang.String extendParams;
    private java.lang.String fileUrl;
    private int flevel;
    private java.lang.String flipTaskId;
    private java.lang.String id;
    private int isContentnode;
    private java.lang.String name;
    private int pageStatus;
    private java.lang.String paperId;
    private java.lang.String parentId;
    private java.lang.String pictureUrl;
    private float score;
    private java.lang.String taskId;
    private int taskStatus;
    private int type;
    private long updateTime;

    public java.lang.String getChapterId() {
        return this.chapterId;
    }

    public void setChapterId(java.lang.String str) {
        this.chapterId = str;
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

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int i) {
        this.courseId = i;
    }

    public int getCreateUid() {
        return this.createUid;
    }

    public void setCreateUid(int i) {
        this.createUid = i;
    }

    public java.lang.String getFileUrl() {
        return this.fileUrl;
    }

    public void setFileUrl(java.lang.String str) {
        this.fileUrl = str;
    }

    public int getFlevel() {
        return this.flevel;
    }

    public void setFlevel(int i) {
        this.flevel = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
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

    public int getIsContentnode() {
        return this.isContentnode;
    }

    public void setIsContentnode(int i) {
        this.isContentnode = i;
    }

    public int getChapterStatus() {
        return this.chapterStatus;
    }

    public void setChapterStatus(int i) {
        this.chapterStatus = i;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }

    public java.lang.String getPaperId() {
        return this.paperId;
    }

    public void setPaperId(java.lang.String str) {
        this.paperId = str;
    }

    public float getScore() {
        return this.score;
    }

    public void setScore(float f) {
        this.score = f;
    }

    public java.lang.String getFlipTaskId() {
        return this.flipTaskId;
    }

    public void setFlipTaskId(java.lang.String str) {
        this.flipTaskId = str;
    }

    public int getTaskStatus() {
        return this.taskStatus;
    }

    public void setTaskStatus(int i) {
        this.taskStatus = i;
    }

    public int getCheckStatus() {
        return this.checkStatus;
    }

    public void setCheckStatus(int i) {
        this.checkStatus = i;
    }

    public int getPageStatus() {
        return this.pageStatus;
    }

    public void setPageStatus(int i) {
        this.pageStatus = i;
    }

    public java.lang.String getId() {
        return this.id;
    }

    public void setId(java.lang.String str) {
        this.id = str;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public java.lang.String getChapterName() {
        return this.chapterName;
    }

    public void setChapterName(java.lang.String str) {
        this.chapterName = str;
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

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public int getChapterType() {
        return this.chapterType;
    }

    public void setChapterType(int i) {
        this.chapterType = i;
    }

    public boolean isPublish() {
        return isTask() ? this.taskStatus == 1 : isChapter() ? this.chapterStatus == 1 : isPage() && this.pageStatus == 1;
    }

    public boolean isNewNode() {
        if (isPage()) {
            return true;
        }
        if (isTask()) {
            return android.text.TextUtils.isEmpty(this.flipTaskId);
        }
        return false;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.book.model.CustomChapterInfo customChapterInfo = (com.up366.mobile.book.model.CustomChapterInfo) obj;
        if (this.type != customChapterInfo.type || this.courseId != customChapterInfo.courseId || this.createUid != customChapterInfo.createUid || this.flevel != customChapterInfo.flevel || this.isContentnode != customChapterInfo.isContentnode || this.chapterStatus != customChapterInfo.chapterStatus || this.createTime != customChapterInfo.createTime || this.updateTime != customChapterInfo.updateTime || java.lang.Float.compare(customChapterInfo.score, this.score) != 0 || this.taskStatus != customChapterInfo.taskStatus || this.checkStatus != customChapterInfo.checkStatus) {
            return false;
        }
        java.lang.String str = this.chapterId;
        if (str == null ? customChapterInfo.chapterId != null : !str.equals(customChapterInfo.chapterId)) {
            return false;
        }
        java.lang.String str2 = this.parentId;
        if (str2 == null ? customChapterInfo.parentId != null : !str2.equals(customChapterInfo.parentId)) {
            return false;
        }
        java.lang.String str3 = this.bookId;
        if (str3 == null ? customChapterInfo.bookId != null : !str3.equals(customChapterInfo.bookId)) {
            return false;
        }
        java.lang.String str4 = this.fileUrl;
        if (str4 == null ? customChapterInfo.fileUrl != null : !str4.equals(customChapterInfo.fileUrl)) {
            return false;
        }
        java.lang.String str5 = this.taskId;
        if (str5 == null ? customChapterInfo.taskId != null : !str5.equals(customChapterInfo.taskId)) {
            return false;
        }
        java.lang.String str6 = this.paperId;
        if (str6 == null ? customChapterInfo.paperId != null : !str6.equals(customChapterInfo.paperId)) {
            return false;
        }
        java.lang.String str7 = this.flipTaskId;
        java.lang.String str8 = customChapterInfo.flipTaskId;
        return str7 != null ? str7.equals(str8) : str8 == null;
    }

    public int hashCode() {
        int i = this.type * 31;
        java.lang.String str = this.chapterId;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.parentId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.bookId;
        int iHashCode3 = (((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.courseId) * 31) + this.createUid) * 31;
        java.lang.String str4 = this.fileUrl;
        int iHashCode4 = (((((((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.flevel) * 31) + this.isContentnode) * 31) + this.chapterStatus) * 31;
        long j = this.createTime;
        int i2 = (iHashCode4 + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.updateTime;
        int i3 = (i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        java.lang.String str5 = this.taskId;
        int iHashCode5 = (i3 + (str5 != null ? str5.hashCode() : 0)) * 31;
        java.lang.String str6 = this.paperId;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        float f = this.score;
        int iFloatToIntBits = (iHashCode6 + (f != 0.0f ? java.lang.Float.floatToIntBits(f) : 0)) * 31;
        java.lang.String str7 = this.flipTaskId;
        return ((((iFloatToIntBits + (str7 != null ? str7.hashCode() : 0)) * 31) + this.taskStatus) * 31) + this.checkStatus;
    }

    public com.up366.mobile.book.model.ChapterInfo createReplaceCopy(com.up366.mobile.book.model.ChapterInfo chapterInfo) {
        com.up366.mobile.book.model.ChapterInfo chapterInfo2 = new com.up366.mobile.book.model.ChapterInfo(chapterInfo);
        if (chapterInfo.isPage()) {
            chapterInfo2.setTaskId(this.taskId);
            return chapterInfo2;
        }
        if (isChapter()) {
            chapterInfo2.setParentId(getParentId());
            chapterInfo2.setLevel(getFlevel());
            chapterInfo2.setIsContent(getIsContentnode());
            chapterInfo2.setFileId(getFileUrl());
            chapterInfo2.setName(this.chapterName);
            chapterInfo2.setExtendParams(this.extendParams);
            chapterInfo2.setDisplayOrder(this.displayOrder);
            chapterInfo2.setChapterType(this.chapterType);
        }
        if (isTask()) {
            chapterInfo2.setId(getTaskId());
            chapterInfo2.setXotPaperId(getPaperId());
            chapterInfo2.setTotalScore(getScore());
        }
        return chapterInfo2;
    }

    public com.up366.mobile.book.model.ChapterInfo createNewChapterInfoNode() {
        com.up366.mobile.book.model.ChapterInfo chapterInfo = new com.up366.mobile.book.model.ChapterInfo();
        if (isChapter()) {
            chapterInfo.setId(this.chapterId);
            chapterInfo.setType(1);
            chapterInfo.setBookId(this.bookId);
            chapterInfo.setName(this.chapterName);
            chapterInfo.setMobileStatus(java.lang.String.valueOf(this.chapterStatus));
            chapterInfo.setChapterType(this.chapterType);
            chapterInfo.setExtendParams(this.extendParams);
            chapterInfo.setFileId(this.fileUrl);
            chapterInfo.setLevel(this.flevel);
            chapterInfo.setIsContent(this.isContentnode);
            chapterInfo.setXotPaperId(this.paperId);
            chapterInfo.setParentId(this.parentId);
            chapterInfo.setPictureUrl(this.pictureUrl);
        }
        if (isPage()) {
            chapterInfo.setId(this.id);
            chapterInfo.setType(2);
            chapterInfo.setBookId(this.bookId);
            chapterInfo.setDisplayOrder(this.displayOrder);
            chapterInfo.setName(this.name);
            chapterInfo.setParentId(this.parentId);
            chapterInfo.setTaskId(this.taskId);
        }
        if (isTask()) {
            chapterInfo.setId(this.taskId);
            chapterInfo.setType(3);
            chapterInfo.setBookId(this.bookId);
            chapterInfo.setParentId(this.chapterId);
            chapterInfo.setXotPaperId(this.paperId);
            chapterInfo.setTotalScore(this.score);
        }
        return chapterInfo;
    }
}
