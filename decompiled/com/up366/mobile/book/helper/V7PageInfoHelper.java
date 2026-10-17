package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V7PageInfoHelper {
    private final android.app.Activity context;
    private final com.up366.mobile.book.helper.V7ChapterDataHelper dataHelper;
    protected final com.up366.mobile.book.model.CatalogPage page;
    private final com.up366.mobile.book.StudyActivityInterface studyActivityInterface;

    public V7PageInfoHelper(com.up366.mobile.book.StudyActivityInterface studyActivityInterface, com.up366.mobile.book.model.CatalogPage catalogPage, com.up366.mobile.book.helper.V7ChapterDataHelper v7ChapterDataHelper) {
        this.studyActivityInterface = studyActivityInterface;
        this.context = studyActivityInterface.getContext();
        this.page = catalogPage;
        this.dataHelper = v7ChapterDataHelper;
    }

    public java.lang.String loadPageInfo(java.lang.String str) {
        com.up366.mobile.book.model.CatalogPage page;
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            page = this.page;
        } else {
            page = this.studyActivityInterface.getBookChapterInfo().getPage(str);
        }
        if (page == null) {
            throw new java.lang.IllegalStateException("pageId 不存在:" + str);
        }
        return new com.up366.mobile.book.studyviews.model.V7JSONChapterInfo().getJSONPageInfo(page.obj.getId(), page, this.dataHelper.getRelativePageDir(page));
    }

    public java.lang.String loadChapterInfo(java.lang.String str) {
        boolean zHasDownloadChapter;
        com.up366.mobile.book.model.CatalogChapter chapter = this.studyActivityInterface.getBookChapterInfo().getChapter(str);
        if (chapter != null) {
            com.up366.mobile.book.model.ChapterInfo chapterInfo = chapter.obj;
            if (!chapter.obj.isContent()) {
                chapterInfo = chapter.getContentPPage().obj;
            }
            zHasDownloadChapter = this.studyActivityInterface.getContentDownloadHelper().hasDownloadChapter(chapterInfo);
        } else {
            zHasDownloadChapter = false;
        }
        return new com.up366.mobile.book.studyviews.model.V7JSONChapterInfo().getJSONChapterInfo(str, chapter, zHasDownloadChapter);
    }

    public java.lang.String loadTaskInfo(java.lang.String str) {
        com.up366.mobile.book.model.CourseBookPlan courseBookPlan = this.studyActivityInterface.getBookChapterInfo().getPlanMap().get(str);
        com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo = this.studyActivityInterface.getBookChapterInfo().getTaskMap().get(str);
        com.up366.mobile.book.model.CatalogChapter task = this.studyActivityInterface.getBookChapterInfo().getTask(str);
        return new com.up366.mobile.book.studyviews.model.V7JSONChapterInfo().getJSONTaskInfo(this.studyActivityInterface.getBookChapterInfo().getBook(), str, task, courseBookPlan, bookTaskFinishedInfo, this.studyActivityInterface.getOpenConfigInfo());
    }

    public java.lang.String loadBookInfo() {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        com.up366.mobile.book.model.BookInfoStudy book = this.studyActivityInterface.getBookChapterInfo().getBook();
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, book.getBookId());
        jSONObject.put("bookName", book.getBookName());
        jSONObject.put("isFree", java.lang.Integer.valueOf(book.isHasBuy() ? 1 : 0));
        jSONObject.put("startTime", java.lang.Long.valueOf(book.getStartTime()));
        jSONObject.put("endTime", java.lang.Long.valueOf(book.getEndTime()));
        jSONObject.put("authDate", java.lang.Integer.valueOf(book.getValidDays()));
        jSONObject.put("price", java.lang.Float.valueOf(book.getPrice()));
        jSONObject.put("productId", java.lang.Integer.valueOf(book.getProductId()));
        jSONObject.put("stageId", java.lang.Integer.valueOf(book.getStageId()));
        jSONObject.put("subjectId", java.lang.Integer.valueOf(book.getSubjectId()));
        jSONObject.put("isShelf", java.lang.Integer.valueOf(book.getIsShelf()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(book.getCourseId() > 0 ? book.getCourseId() : -1));
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.studyActivityInterface.getOpenConfigInfo().extDailyDate)) {
            jSONObject.put("extDailyDate", this.studyActivityInterface.getOpenConfigInfo().extDailyDate);
        }
        return jSONObject.toJSONString();
    }
}
