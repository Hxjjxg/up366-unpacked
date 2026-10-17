package com.up366.mobile.book;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookProgressMgr {
    private java.lang.String currentPageId;
    private final com.up366.greendao.DaoSession db;
    private final com.up366.mobile.common.logic.Manager manager;
    private java.util.Map<java.lang.String, com.up366.mobile.book.model.BookScheduleInfo> map = new java.util.HashMap();

    public BookProgressMgr(com.up366.mobile.common.logic.Manager manager) {
        this.manager = manager;
        this.db = manager.db();
        fullMap();
    }

    private void fullMap() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.BookProgressMgr$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$fullMap$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fullMap$0() throws java.lang.Exception {
        for (com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo : this.db.getBookScheduleInfoDao().loadAll()) {
            this.map.put(bookScheduleInfo.getBookId(), bookScheduleInfo);
        }
    }

    public com.up366.mobile.book.model.BookScheduleInfo get(java.lang.String str) {
        com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo = this.map.get(str);
        if (bookScheduleInfo != null) {
            return bookScheduleInfo;
        }
        com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo2 = new com.up366.mobile.book.model.BookScheduleInfo();
        bookScheduleInfo2.setBookId(str);
        this.map.put(bookScheduleInfo2.getBookId(), bookScheduleInfo2);
        return bookScheduleInfo2;
    }

    private void update(java.lang.String str) {
        final com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo = get(str);
        bookScheduleInfo.setLastStudyTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.BookProgressMgr$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$update$1(bookScheduleInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$update$1(com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo) throws java.lang.Exception {
        this.db.insertOrReplace(bookScheduleInfo);
    }

    public void save(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy) {
        final com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo = get(bookInfoStudy.getBookId());
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.BookProgressMgr$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$save$2(bookScheduleInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$save$2(com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo) throws java.lang.Exception {
        this.db.insertOrReplace(bookScheduleInfo);
    }

    public void update(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy) {
        update(bookInfoStudy.getBookId());
    }

    public void set(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.CatalogPage catalogPage) {
        com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo = get(bookInfoStudy.getBookId());
        bookScheduleInfo.setPageId(catalogPage.obj.getId());
        this.currentPageId = catalogPage.obj.getId();
        if (catalogPage.getChapterPPage() != null) {
            bookScheduleInfo.setChapterId(catalogPage.getChapterPPage().obj.getId());
            bookScheduleInfo.setChapterStudyTaskNum(((com.up366.mobile.book.model.CatalogChapter) catalogPage.getChapterPPage()).getStudyTaskNum());
        } else {
            bookScheduleInfo.setChapterId(catalogPage.obj.getId());
            bookScheduleInfo.setChapterStudyTaskNum(0);
        }
        bookScheduleInfo.setShortSchedule(catalogPage.obj.getName());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        com.up366.mobile.book.model.CatalogPage catalogPage2 = catalogPage;
        while (true) {
            java.lang.String name = catalogPage2.obj.getName();
            if (!com.up366.common.StringUtils.isEmptyOrNull(name)) {
                sb.insert(0, name);
            }
            catalogPage2 = catalogPage2.getpPage();
            if (catalogPage2 == null) {
                break;
            } else {
                sb.insert(0, " # ");
            }
        }
        bookScheduleInfo.setSchedule(sb.toString());
        if (bookInfoStudy.getBookType() == 2) {
            bookScheduleInfo.setBookId(catalogPage.obj.getBookId());
            bookScheduleInfo.setChapterId(catalogPage.getChapterPPage().obj.getId());
            bookScheduleInfo.setShortSchedule(catalogPage.obj.getName());
            bookScheduleInfo.setTaskId(catalogPage.obj.getId());
            bookScheduleInfo.setTaskNo(catalogPage.obj.getDisplayOrder());
        }
        update(bookInfoStudy.getBookId());
    }

    public java.lang.String getCurrentPageId() {
        return this.currentPageId;
    }

    public void setCurrentPageId(java.lang.String str) {
        this.currentPageId = str;
    }
}
