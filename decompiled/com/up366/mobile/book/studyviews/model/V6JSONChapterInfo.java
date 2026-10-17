package com.up366.mobile.book.studyviews.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V6JSONChapterInfo {
    private java.lang.String chapterId;
    private java.lang.String chapterName;
    private com.alibaba.fastjson.JSONObject extendParams;
    private int isShelf;
    private int order;
    private java.lang.String parentId;
    private java.util.List<com.up366.mobile.book.studyviews.model.V6JSONChapterInfo.JSONTask> tasks = new java.util.ArrayList();

    public java.lang.String JSONStr() {
        return com.alibaba.fastjson.JSON.toJSONString(this);
    }

    public static class JSONTask {
        int isSubmitFailed;
        java.util.List<com.up366.mobile.book.studyviews.model.V6JSONChapterInfo.JSONPage> pages = new java.util.ArrayList();
        float percent;
        float score;
        java.lang.String taskId;
        java.lang.String taskName;
        int taskNum;
        float totalScore;

        public JSONTask(com.up366.mobile.book.model.CatalogChapter catalogChapter, com.alibaba.fastjson.JSONObject jSONObject) {
            this.taskId = catalogChapter.obj.getId();
            this.taskNum = catalogChapter.obj.getDisplayOrder();
            this.totalScore = catalogChapter.obj.getTotalScore();
            this.score = catalogChapter.taskInfo.getScore();
            this.percent = catalogChapter.taskInfo.getPercent();
            java.util.Iterator<com.up366.mobile.book.model.CatalogChapter> it = catalogChapter.pages.iterator();
            while (it.hasNext()) {
                this.pages.add(new com.up366.mobile.book.studyviews.model.V6JSONChapterInfo.JSONPage(it.next()));
            }
            if (catalogChapter.pages.size() > 0) {
                this.taskName = catalogChapter.pages.get(0).obj.getName();
            } else {
                this.taskName = "NOT FOUND PAGE FOR TASK " + this.taskId;
            }
            com.alibaba.fastjson.JSONObject jSONObject2 = jSONObject.getJSONObject(this.taskId);
            this.isSubmitFailed = 0;
            if (jSONObject2 == null || jSONObject2.getIntValue("status") != 1) {
                return;
            }
            this.isSubmitFailed = 1;
        }

        public java.lang.String getTaskId() {
            return this.taskId;
        }

        public void setTaskId(java.lang.String str) {
            this.taskId = str;
        }

        public float getScore() {
            return this.score;
        }

        public void setScore(float f) {
            this.score = f;
        }

        public java.util.List<com.up366.mobile.book.studyviews.model.V6JSONChapterInfo.JSONPage> getPages() {
            return this.pages;
        }

        public void setPages(java.util.List<com.up366.mobile.book.studyviews.model.V6JSONChapterInfo.JSONPage> list) {
            this.pages = list;
        }

        public java.lang.String getTaskName() {
            return this.taskName;
        }

        public void setTaskName(java.lang.String str) {
            this.taskName = str;
        }

        public int getTaskNum() {
            return this.taskNum;
        }

        public void setTaskNum(int i) {
            this.taskNum = i;
        }

        public float getPercent() {
            return this.percent;
        }

        public void setPercent(float f) {
            this.percent = f;
        }

        public int getIsSubmitFailed() {
            return this.isSubmitFailed;
        }

        public void setIsSubmitFailed(int i) {
            this.isSubmitFailed = i;
        }

        public float getTotalScore() {
            return this.totalScore;
        }

        public void setTotalScore(float f) {
            this.totalScore = f;
        }
    }

    public static class JSONPage {
        java.lang.String pageId;

        public JSONPage(com.up366.mobile.book.model.CatalogChapter catalogChapter) {
            this.pageId = catalogChapter.obj.getId();
        }

        public java.lang.String getPageId() {
            return this.pageId;
        }

        public void setPageId(java.lang.String str) {
            this.pageId = str;
        }
    }

    public V6JSONChapterInfo(com.up366.mobile.book.model.CatalogChapter catalogChapter) {
        java.lang.String str;
        this.extendParams = new com.alibaba.fastjson.JSONObject();
        this.chapterId = catalogChapter.obj.getId();
        this.order = catalogChapter.obj.getDisplayOrder();
        this.chapterName = catalogChapter.obj.getName();
        this.parentId = catalogChapter.obj.getParentId();
        this.isShelf = catalogChapter.obj.getIsShelf();
        try {
            str = com.up366.mobile.book.helper.TaskUploadStatusHelper.get();
        } catch (java.lang.Exception unused) {
            str = "{}";
        }
        try {
            this.extendParams = com.alibaba.fastjson.JSON.parseObject(catalogChapter.obj.getExtendParams());
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - V6JSONChapterInfo - parse extendParams error", e);
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.util.Iterator<com.up366.mobile.book.model.CatalogChapter> it = catalogChapter.tasks.iterator();
        while (it.hasNext()) {
            this.tasks.add(new com.up366.mobile.book.studyviews.model.V6JSONChapterInfo.JSONTask(it.next(), object));
        }
    }

    public java.lang.String getChapterId() {
        return this.chapterId;
    }

    public void setChapterId(java.lang.String str) {
        this.chapterId = str;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int i) {
        this.order = i;
    }

    public java.lang.String getChapterName() {
        return this.chapterName;
    }

    public void setChapterName(java.lang.String str) {
        this.chapterName = str;
    }

    public java.util.List<com.up366.mobile.book.studyviews.model.V6JSONChapterInfo.JSONTask> getTasks() {
        return this.tasks;
    }

    public void setTasks(java.util.List<com.up366.mobile.book.studyviews.model.V6JSONChapterInfo.JSONTask> list) {
        this.tasks = list;
    }

    public java.lang.String getParentId() {
        return this.parentId;
    }

    public void setParentId(java.lang.String str) {
        this.parentId = str;
    }

    public com.alibaba.fastjson.JSONObject getExtendParams() {
        return this.extendParams;
    }

    public void setExtendParams(com.alibaba.fastjson.JSONObject jSONObject) {
        this.extendParams = jSONObject;
    }

    public int getIsShelf() {
        return this.isShelf;
    }

    public void setIsShelf(int i) {
        this.isShelf = i;
    }
}
