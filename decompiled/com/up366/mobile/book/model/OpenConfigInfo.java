package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OpenConfigInfo implements java.io.Serializable {
    public java.lang.String behavior;
    public java.lang.String bookId;
    public java.lang.String chapterId;
    public java.lang.String commonParams;
    public java.lang.String exerciseData;
    public java.lang.String exerciseType;
    public java.lang.String extDailyDate;
    private transient java.util.List<java.lang.String> extFileIdList;
    public java.lang.String extFileIds;
    public boolean fromTaskHistory;
    public boolean initRangeFromIntent;
    public java.lang.String openUrl;
    public int packType;
    public java.lang.String pageId;
    public int pageNo = -1;
    public int[] range;
    public boolean reTest;
    public transient com.up366.mobile.book.model.OpenConfigInfo.ResourceList resourceListObj;
    public java.lang.String restoredPageRoute;
    public java.lang.String studyTaskId;
    public java.lang.String taskId;
    public java.lang.String title;
    public java.lang.String xotParam;

    public OpenConfigInfo(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy) {
        this.title = bookInfoStudy.getBookName();
        this.bookId = bookInfoStudy.getBookId();
        this.packType = bookInfoStudy.getPackType();
        bookInfoStudy.setUpJumpParams(this);
    }

    public OpenConfigInfo() {
    }

    public boolean isOpenPage() {
        return (com.up366.common.StringUtils.isEmptyOrNull(this.chapterId) && com.up366.common.StringUtils.isEmptyOrNull(this.pageId) && com.up366.common.StringUtils.isEmptyOrNull(this.taskId)) ? false : true;
    }

    public boolean isExercise() {
        return !com.up366.common.StringUtils.isEmptyOrNull(this.exerciseType);
    }

    public boolean isDict() {
        return com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.TX_DICT.equals(this.exerciseType);
    }

    public boolean isSDKV8() {
        return com.up366.mobile.book.helper.Tools.isSDKV8(this.bookId, this.packType);
    }

    public boolean isSDKV9() {
        return com.up366.mobile.book.helper.Tools.isSDKV9(this.packType);
    }

    public boolean isCatalog() {
        return this.pageNo < 0;
    }

    public void setExtFileIdList(java.util.List<java.lang.String> list) {
        this.extFileIdList = list;
    }

    public java.util.List<java.lang.String> getExtFileIdList() {
        java.util.List<java.lang.String> list = this.extFileIdList;
        return list == null ? new java.util.ArrayList() : list;
    }

    public java.lang.String toString() {
        return "OpenConfigInfo{title='" + this.title + "', chapterId='" + this.chapterId + "', pageId='" + this.pageId + "', taskId='" + this.taskId + "', range=" + java.util.Arrays.toString(this.range) + ", initRangeFromIntent=" + this.initRangeFromIntent + ", pageNo=" + this.pageNo + ", openUrl='" + this.openUrl + "', exerciseType='" + this.exerciseType + "', exerciseData='" + this.exerciseData + "', studyTaskId='" + this.studyTaskId + "', reTest='" + this.reTest + "', extDailyDate='" + this.extDailyDate + "', fromTaskHistory=" + this.fromTaskHistory + ", xotParam='" + this.xotParam + "', commonParams='" + this.commonParams + "', extFileIds='" + this.extFileIds + "'}";
    }

    public com.up366.mobile.book.model.OpenConfigInfo.ResourceList getResourceListObj() {
        if (this.resourceListObj == null) {
            this.resourceListObj = new com.up366.mobile.book.model.OpenConfigInfo.ResourceList();
        }
        return this.resourceListObj;
    }

    public void setResourceListObj(com.up366.mobile.book.model.OpenConfigInfo.ResourceList resourceList) {
        this.resourceListObj = resourceList;
    }

    public static class ResourceList {
        private java.lang.String[] dirGlobal = new java.lang.String[0];
        private java.lang.String[] dirBooks = new java.lang.String[0];
        private java.lang.String[] dirChapters = new java.lang.String[0];
        private java.lang.String[] dirExtend = new java.lang.String[0];
        private java.lang.String[] dirQuestions = new java.lang.String[0];
        private java.lang.String[] dirAllQuestions = new java.lang.String[0];

        public java.lang.String[] getDirGlobal() {
            return this.dirGlobal;
        }

        public void setDirGlobal(java.lang.String[] strArr) {
            this.dirGlobal = strArr;
        }

        public java.lang.String[] getDirBooks() {
            return this.dirBooks;
        }

        public void setDirBooks(java.lang.String[] strArr) {
            this.dirBooks = strArr;
        }

        public java.lang.String[] getDirChapters() {
            return this.dirChapters;
        }

        public void setDirChapters(java.lang.String[] strArr) {
            this.dirChapters = strArr;
        }

        public java.lang.String[] getDirExtend() {
            return this.dirExtend;
        }

        public void setDirExtend(java.lang.String[] strArr) {
            this.dirExtend = strArr;
        }

        public java.lang.String[] getDirQuestions() {
            return this.dirQuestions;
        }

        public void setDirQuestions(java.lang.String[] strArr) {
            this.dirQuestions = strArr;
        }

        public java.lang.String[] getDirAllQuestions() {
            return this.dirAllQuestions;
        }

        public void setDirAllQuestions(java.lang.String[] strArr) {
            this.dirAllQuestions = strArr;
        }
    }
}
