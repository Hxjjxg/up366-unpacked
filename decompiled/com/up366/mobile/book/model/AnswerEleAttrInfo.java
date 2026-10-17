package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AnswerEleAttrInfo {
    private java.lang.String bookId;
    private java.lang.String chapterId;
    private java.lang.Integer courseId;
    private com.alibaba.fastjson.JSONObject extendParams;
    private int killStudyTask;
    private float percent;
    private java.util.List<com.up366.mobile.book.model.AnswerEleAttrInfo.EleAttrInfo> qstJson;
    private java.lang.String result;
    private float score;
    private int seconds;
    private long studyDate;
    private java.lang.String studyTaskId;
    private java.lang.String taskId;
    private java.lang.String taskNo;
    private int uid;

    public AnswerEleAttrInfo() {
        this.uid = com.up366.mobile.common.logic.Auth.getUserInfo().getUid();
        this.qstJson = new java.util.ArrayList();
    }

    public AnswerEleAttrInfo(com.up366.mobile.book.model.CatalogPage catalogPage, com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2, int i, java.lang.String str) {
        this.qstJson = new java.util.ArrayList();
        init(catalogPage, bookTaskLogV2, i, str);
    }

    public void addAnswers(com.up366.mobile.book.model.CatalogPage catalogPage, long j, java.util.List<com.up366.mobile.book.model.AnswerEleAttrInfo.AnswerJSLog> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        java.util.Iterator<com.up366.mobile.book.model.AnswerEleAttrInfo.AnswerJSLog> it = list.iterator();
        while (it.hasNext()) {
            this.qstJson.add(new com.up366.mobile.book.model.AnswerEleAttrInfo.EleAttrInfo(catalogPage, j, it.next()));
        }
    }

    public static java.lang.String UUID() {
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }

    public void init(com.up366.mobile.book.model.CatalogPage catalogPage, com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2, int i, java.lang.String str) {
        if (i > 0) {
            this.courseId = java.lang.Integer.valueOf(i);
        }
        this.studyTaskId = str;
        this.bookId = catalogPage.obj.getBookId();
        this.chapterId = catalogPage.obj.getId();
        if (catalogPage.getChapterPPage() != null) {
            this.chapterId = catalogPage.getChapterPPage().obj.getId();
        }
        this.taskId = catalogPage.obj.getTaskId();
        this.score = bookTaskLogV2.getScore();
        this.studyDate = bookTaskLogV2.getStudyDate();
        this.taskNo = bookTaskLogV2.getTaskNo();
        this.seconds = bookTaskLogV2.getStudyTime();
        this.result = "";
        this.uid = com.up366.mobile.common.logic.Auth.getUserInfo().getUid();
    }

    public static class AnswerJSLog {
        private java.lang.String batchTag;
        private java.lang.String elementAttr;
        private java.lang.String elementId;
        private java.lang.String elementType;

        public java.lang.String getBatchTag() {
            return this.batchTag;
        }

        public void setBatchTag(java.lang.String str) {
            this.batchTag = str;
        }

        public java.lang.String getElementId() {
            return this.elementId;
        }

        public void setElementId(java.lang.String str) {
            this.elementId = str;
        }

        public java.lang.String getElementType() {
            return this.elementType;
        }

        public void setElementType(java.lang.String str) {
            this.elementType = str;
        }

        public java.lang.String getElementAttr() {
            return this.elementAttr;
        }

        public void setElementAttr(java.lang.String str) {
            this.elementAttr = str;
        }
    }

    public static class EleAttrInfo {
        private long addTime;
        private java.lang.String elementAttr;
        private java.lang.String elementId;
        private java.lang.String elementType;
        private java.lang.String pageId;

        public EleAttrInfo() {
        }

        public EleAttrInfo(com.up366.mobile.book.model.CatalogPage catalogPage, long j, com.up366.mobile.book.model.AnswerEleAttrInfo.AnswerJSLog answerJSLog) {
            this.pageId = catalogPage.obj.getId();
            this.addTime = j;
            this.elementId = answerJSLog.getElementId();
            this.elementType = answerJSLog.getElementType();
            this.elementAttr = answerJSLog.getElementAttr();
        }

        public java.lang.String getPageId() {
            return this.pageId;
        }

        public void setPageId(java.lang.String str) {
            this.pageId = str;
        }

        public long getAddTime() {
            return this.addTime;
        }

        public void setAddTime(long j) {
            this.addTime = j;
        }

        public java.lang.String getElementId() {
            return this.elementId;
        }

        public void setElementId(java.lang.String str) {
            this.elementId = str;
        }

        public java.lang.String getElementType() {
            return this.elementType;
        }

        public void setElementType(java.lang.String str) {
            this.elementType = str;
        }

        public java.lang.String getElementAttr() {
            return this.elementAttr;
        }

        public void setElementAttr(java.lang.String str) {
            this.elementAttr = str;
        }
    }

    public java.util.List<com.up366.mobile.book.model.AnswerEleAttrInfo.EleAttrInfo> getQstJson() {
        return this.qstJson;
    }

    public void setQstJson(java.util.List<com.up366.mobile.book.model.AnswerEleAttrInfo.EleAttrInfo> list) {
        this.qstJson = list;
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public java.lang.String getChapterId() {
        return this.chapterId;
    }

    public void setChapterId(java.lang.String str) {
        this.chapterId = str;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }

    public java.lang.String getTaskNo() {
        return this.taskNo;
    }

    public void setTaskNo(java.lang.String str) {
        this.taskNo = str;
    }

    public float getScore() {
        return this.score;
    }

    public void setScore(float f) {
        this.score = f;
    }

    public long getStudyDate() {
        return this.studyDate;
    }

    public void setStudyDate(long j) {
        this.studyDate = (j / 1000) * 1000;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void setSeconds(int i) {
        this.seconds = i;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public java.lang.String getResult() {
        return this.result;
    }

    public void setResult(java.lang.String str) {
        this.result = str;
    }

    public int getUid() {
        return this.uid;
    }

    public float getPercent() {
        return this.percent;
    }

    public void setPercent(float f) {
        this.percent = f;
    }

    public com.alibaba.fastjson.JSONObject getExtendParams() {
        return this.extendParams;
    }

    public void setExtendParams(java.lang.String str) {
        this.extendParams = com.alibaba.fastjson.JSON.parseObject(str);
    }

    public java.lang.Integer getCourseId() {
        return this.courseId;
    }

    public void setCourseId(java.lang.Integer num) {
        this.courseId = num;
    }

    public java.lang.String getStudyTaskId() {
        return this.studyTaskId;
    }

    public void setStudyTaskId(java.lang.String str) {
        this.studyTaskId = str;
    }

    public int getKillStudyTask() {
        return this.killStudyTask;
    }

    public void setKillStudyTask(int i) {
        this.killStudyTask = i;
    }
}
