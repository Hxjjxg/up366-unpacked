package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class HtmlBookChapterInfoParser {
    private int authDate;
    private java.lang.String bookId;
    private java.lang.String bookName;
    private java.util.List<com.up366.mobile.book.model.HtmlBookChapterInfoParser.Child> children;
    private java.lang.String courseId;
    private long endTime;
    private int isFree;
    private int isShelf;
    private java.lang.String price;
    private int productId;
    private java.lang.String stageId;
    private long startTime;
    private int studyPro;
    private java.lang.String subjectId;

    public HtmlBookChapterInfoParser(com.up366.mobile.book.model.TreeBookChapter treeBookChapter) {
        com.up366.mobile.book.model.BookInfoStudy book = treeBookChapter.getBook();
        this.isShelf = book.getIsShelf();
        this.bookId = book.getBookId();
        this.bookName = book.getBookName();
        if (book.getCourseId() > 0) {
            this.courseId = java.lang.String.valueOf(book.getCourseId());
        } else {
            this.courseId = "";
        }
        this.stageId = java.lang.String.valueOf(book.getStageId());
        this.subjectId = java.lang.String.valueOf(book.getSubjectId());
        this.isFree = book.isHasBuy() ? 1 : 0;
        this.studyPro = book.getPercent();
        this.authDate = book.getValidDays();
        this.price = java.lang.String.valueOf(book.getPrice());
        this.productId = book.getProductId();
        this.children = new java.util.ArrayList();
        java.util.List<com.up366.mobile.book.model.ChapterInfo> treeChapters = treeBookChapter.getTreeChapters();
        java.util.List<com.up366.mobile.book.model.CatalogChapter> chapters = treeBookChapter.getChapters();
        java.util.Map<java.lang.String, com.up366.mobile.book.model.BookTaskFinishedInfo> taskMap = treeBookChapter.getTaskMap();
        java.util.Iterator<com.up366.mobile.book.model.CatalogChapter> it = chapters.iterator();
        while (it.hasNext()) {
            it.next().countScore();
        }
        java.util.Map<java.lang.String, com.up366.mobile.book.model.CourseBookPlan> planMap = treeBookChapter.getPlanMap();
        for (int i = 0; i < treeChapters.size(); i++) {
            com.up366.mobile.book.model.ChapterInfo chapterInfo = treeChapters.get(i);
            com.up366.mobile.book.model.CourseBookPlan courseBookPlan = planMap.get(chapterInfo.getId());
            if (courseBookPlan == null || !courseBookPlan.isClose()) {
                this.children.add(new com.up366.mobile.book.model.HtmlBookChapterInfoParser.Child(book, chapterInfo, taskMap.get(chapterInfo.getId()), courseBookPlan, treeBookChapter));
            }
        }
        this.startTime = book.getStartTime();
        this.endTime = book.getEndTime();
    }

    public java.lang.String toJSONStr() {
        java.lang.String str;
        java.lang.String str2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("{\"authDate\": ");
        sb.append(this.authDate);
        sb.append(",\"bookId\": \"");
        sb.append(this.bookId);
        sb.append("\",\"courseId\": \"");
        sb.append(this.courseId);
        sb.append("\",\"stageId\": \"");
        sb.append(this.stageId);
        sb.append("\",\"subjectId\": \"");
        sb.append(this.subjectId);
        sb.append("\",\"bookName\": ");
        sb.append(com.alibaba.fastjson.JSON.toJSONString(this.bookName));
        java.lang.String str3 = ",\"endTime\": ";
        sb.append(",\"endTime\": ");
        sb.append(this.endTime);
        sb.append(",\"isFree\": ");
        sb.append(this.isFree);
        sb.append(",\"price\": \"");
        sb.append(this.price);
        sb.append("\",\"productId\": ");
        sb.append(this.productId);
        sb.append(",\"startTime\": ");
        sb.append(this.startTime);
        java.lang.String str4 = ",\"studyPro\": ";
        sb.append(",\"studyPro\": ");
        sb.append(this.studyPro);
        sb.append(",\"isShelf\": ");
        sb.append(this.isShelf);
        sb.append(",\"children\": [");
        int i = 0;
        while (i < this.children.size()) {
            com.up366.mobile.book.model.HtmlBookChapterInfoParser.Child child = this.children.get(i);
            sb.append("{\"id\": \"");
            sb.append(child.id);
            sb.append("\",\"type\": ");
            sb.append(child.type);
            sb.append(",\"parentId\": \"");
            sb.append(child.parentId);
            sb.append("\",\"isShelf\": ");
            sb.append(child.isShelf);
            sb.append(com.igexin.push.core.b.an);
            if (!com.up366.common.StringUtils.isEmptyOrNull(child.extendParams)) {
                sb.append("\"extendParams\": ");
                sb.append(com.alibaba.fastjson.JSON.toJSONString(child.extendParams));
                sb.append(com.igexin.push.core.b.an);
            }
            if (!com.up366.common.StringUtils.isEmptyOrNull(child.chapterPoster)) {
                sb.append("\"chapterPoster\": ");
                sb.append(com.alibaba.fastjson.JSON.toJSONString(child.chapterPoster));
                sb.append(com.igexin.push.core.b.an);
            }
            if (!com.up366.common.StringUtils.isEmptyOrNull(child.grayConfig)) {
                sb.append("\"grayConfig\": ");
                sb.append(com.alibaba.fastjson.JSON.toJSONString(child.grayConfig));
                sb.append(com.igexin.push.core.b.an);
            }
            if (child.type == 1) {
                sb.append("\"chapterState\": ");
                sb.append(child.chapterState);
                sb.append(",\"chapterType\": ");
                sb.append(child.chapterType);
                sb.append(",\"displayName\": ");
                sb.append(com.alibaba.fastjson.JSON.toJSONString(child.displayName));
                sb.append(",\"addTime\": ");
                str = str3;
                java.lang.String str5 = str4;
                sb.append(child.addTime);
                sb.append(",\"finished\": ");
                sb.append(child.finished);
                sb.append(",\"percent\": ");
                sb.append(child.percent);
                sb.append(",\"isContent\": ");
                sb.append(child.isContent);
                sb.append(com.igexin.push.core.b.an);
                if (child.taskId != null) {
                    sb.append("\"taskId\": \"");
                    sb.append(child.taskId);
                    sb.append("\",");
                }
                sb.append("\"isFree\": ");
                sb.append(child.isFree);
                sb.append(",\"lockState\": ");
                sb.append(child.lockState);
                sb.append(",\"order\": ");
                sb.append(child.order);
                sb.append(",\"score\": ");
                sb.append(child.score);
                str2 = str5;
                sb.append(str2);
                sb.append(child.studyPro);
                sb.append(com.igexin.push.core.b.an);
                if (!com.up366.common.StringUtils.isEmptyOrNull(child.xotPaperId)) {
                    sb.append("\"xotPaperId\": \"");
                    sb.append(child.xotPaperId);
                    sb.append("\",");
                }
                sb.append("\"isTest\": ");
                sb.append(child.isTest);
            } else {
                str = str3;
                str2 = str4;
                if (child.type == 2) {
                    sb.append("\"displayName\": ");
                    sb.append(com.alibaba.fastjson.JSON.toJSONString(child.displayName));
                    sb.append(",\"finished\": ");
                    sb.append(child.finished);
                    sb.append(",\"percent\": ");
                    sb.append(child.percent);
                    sb.append(com.igexin.push.core.b.an);
                    if (child.taskId != null) {
                        sb.append("\"taskId\": \"");
                        sb.append(child.taskId);
                        sb.append("\",");
                    }
                    sb.append("\"order\": ");
                    sb.append(child.order);
                    sb.append(",\"score\": ");
                    sb.append(child.score);
                } else if (child.type == 3) {
                    sb.append("\"finished\": ");
                    sb.append(child.finished);
                    sb.append(com.igexin.push.core.b.an);
                    if (child.studyDate > 0) {
                        sb.append("\"studyDate\": ");
                        sb.append(child.studyDate);
                        sb.append(com.igexin.push.core.b.an);
                    }
                    sb.append("\"percent\": ");
                    sb.append(child.percent);
                    sb.append(",\"order\": ");
                    sb.append(child.order);
                    sb.append(",\"isPlaned\": ");
                    sb.append(child.isPlaned);
                    sb.append(",\"beginTime\": ");
                    sb.append(child.beginTime);
                    sb.append(str);
                    sb.append(child.endTime);
                    sb.append(",\"lockState\": ");
                    sb.append(child.lockState);
                    sb.append(",\"publishType\": ");
                    sb.append(child.publishType);
                    sb.append(",\"isPublished\": ");
                    sb.append(child.isPublished);
                    sb.append(",\"score\": ");
                    sb.append(child.score);
                    sb.append(com.igexin.push.core.b.an);
                    if (child.isCustomTask) {
                        sb.append("\"isCustom\": true,");
                    }
                    sb.append("\"maxScore\": ");
                    sb.append(child.maxScore);
                }
            }
            sb.append("}");
            if (i != this.children.size() - 1) {
                sb.append(com.igexin.push.core.b.an);
            }
            i++;
            str4 = str2;
            str3 = str;
        }
        sb.append("]}");
        return sb.toString();
    }

    static class Child {
        private long addTime;
        private long beginTime;
        private java.lang.String chapterPoster;
        private int chapterState;
        private int chapterType;
        private java.lang.String displayName;
        private long endTime;
        private java.lang.String extendParams;
        private int finished;
        private java.lang.String grayConfig;
        private java.lang.String id;
        private boolean isContent;
        private boolean isCustomTask;
        private int isFree;
        private int isPlaned;
        private int isPublished;
        private int isShelf;
        private int isTest;
        private int lockState;
        private float maxScore;
        private int order;
        private java.lang.String parentId;
        private float percent;
        private int publishType;
        private float score;
        private long studyDate;
        private float studyPro;
        private java.lang.String taskId;
        private int type;
        private java.lang.String xotPaperId;

        public Child(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.ChapterInfo chapterInfo, com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo, com.up366.mobile.book.model.CourseBookPlan courseBookPlan, com.up366.mobile.book.model.TreeBookChapter treeBookChapter) {
            float percent;
            int i;
            long studyDate;
            float score;
            if (bookTaskFinishedInfo != null) {
                i = bookTaskFinishedInfo.getStudyDate() > 0 ? 1 : 0;
                studyDate = bookTaskFinishedInfo.getStudyDate();
                percent = bookTaskFinishedInfo.getPercent();
                score = bookTaskFinishedInfo.getScore();
            } else {
                com.up366.mobile.book.model.CatalogChapter chapter = treeBookChapter.getChapter(chapterInfo.getId());
                if (chapter != null) {
                    com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo2 = chapter.taskInfo;
                    i = bookTaskFinishedInfo2.getStudyDate() > 0 ? 1 : 0;
                    studyDate = bookTaskFinishedInfo2.getStudyDate();
                    percent = bookTaskFinishedInfo2.getPercent();
                    score = bookTaskFinishedInfo2.getScore();
                } else {
                    com.up366.common.log.Logger.error("TAG - 2018/6/20 - Child - Child - chapter is null : " + chapterInfo.getId());
                    percent = 0.0f;
                    i = 0;
                    studyDate = 0;
                    score = 0.0f;
                }
            }
            this.id = chapterInfo.getId();
            this.displayName = chapterInfo.getName();
            this.order = chapterInfo.getDisplayOrder();
            this.isContent = chapterInfo.isContent();
            this.isFree = chapterInfo.isFree() ? 1 : 0;
            this.parentId = chapterInfo.getParentId();
            this.lockState = chapterInfo.getIsLock();
            this.chapterState = 2;
            this.type = chapterInfo.getType();
            this.finished = i;
            this.studyDate = studyDate;
            this.percent = percent;
            this.studyPro = chapterInfo.getUnitStudyPercent();
            this.taskId = chapterInfo.getTaskId();
            this.score = score;
            this.maxScore = chapterInfo.getTotalScore();
            this.chapterType = chapterInfo.getChapterType();
            this.xotPaperId = chapterInfo.getXotPaperId();
            this.isTest = chapterInfo.getIsTest();
            this.extendParams = chapterInfo.getExtendParams();
            this.addTime = chapterInfo.getAddTime();
            this.chapterPoster = chapterInfo.getPictureUrl();
            this.isPlaned = 0;
            this.beginTime = 0L;
            this.endTime = 0L;
            this.publishType = 1;
            this.isPublished = 0;
            this.isShelf = chapterInfo.getIsShelf();
            this.grayConfig = chapterInfo.getGrayConfig();
            if (courseBookPlan != null) {
                this.isPlaned = 1;
                this.beginTime = courseBookPlan.getBeginTime();
                this.endTime = courseBookPlan.getEndTime();
                this.publishType = courseBookPlan.getPublishType();
                this.isPublished = courseBookPlan.getIsPublished();
            }
            if (this.type == 3) {
                this.isCustomTask = treeBookChapter.isCustomTaskId(this.id);
            }
        }
    }
}
