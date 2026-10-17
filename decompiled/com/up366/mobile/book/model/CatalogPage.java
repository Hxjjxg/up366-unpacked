package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CatalogPage {
    public com.up366.mobile.book.model.ChapterInfo obj;
    private com.up366.mobile.book.model.CatalogPage pPage;
    private int pageNo = 0;
    public com.up366.mobile.book.model.CourseBookPlan plan;

    public CatalogPage() {
    }

    public CatalogPage(com.up366.mobile.book.model.ChapterInfo chapterInfo) {
        this.obj = chapterInfo;
    }

    public com.up366.mobile.book.model.CatalogPage getContentPPage() {
        com.up366.mobile.book.model.CatalogPage catalogPage = this.pPage;
        if (catalogPage == null) {
            return null;
        }
        if (catalogPage.obj.isContent()) {
            return this.pPage;
        }
        return this.pPage.getContentPPage();
    }

    public com.up366.mobile.book.model.CatalogPage getChapterPPage() {
        com.up366.mobile.book.model.CatalogPage catalogPage = this.pPage;
        if (catalogPage == null) {
            return null;
        }
        if (catalogPage.obj.isChapter()) {
            return this.pPage;
        }
        return this.pPage.getChapterPPage();
    }

    public boolean isInLockChapter() {
        if (this.obj.getIsLock() == 1) {
            return true;
        }
        for (com.up366.mobile.book.model.CatalogPage chapterPPage = getChapterPPage(); chapterPPage != null; chapterPPage = chapterPPage.getChapterPPage()) {
            if (chapterPPage.obj.getIsLock() == 1) {
                return true;
            }
        }
        return false;
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(int i) {
        this.pageNo = i;
    }

    public com.up366.mobile.book.model.CatalogPage getpPage() {
        return this.pPage;
    }

    public void setpPage(com.up366.mobile.book.model.CatalogPage catalogPage) {
        this.pPage = catalogPage;
    }

    public com.up366.mobile.book.model.ChapterInfo getObj() {
        return this.obj;
    }

    public void setObj(com.up366.mobile.book.model.ChapterInfo chapterInfo) {
        this.obj = chapterInfo;
    }

    public java.lang.String toString() {
        return "CatalogPage{pageNo=" + this.pageNo + ", pPage=" + this.pPage + ", obj=" + this.obj + '}';
    }

    public boolean isInOnlinePaperChapter() {
        if (this.obj.getChapterType() == 4) {
            return true;
        }
        for (com.up366.mobile.book.model.CatalogPage chapterPPage = getChapterPPage(); chapterPPage != null; chapterPPage = chapterPPage.getChapterPPage()) {
            if (chapterPPage.obj.getChapterType() == 4) {
                return true;
            }
        }
        return false;
    }

    public void setPlan(com.up366.mobile.book.model.CourseBookPlan courseBookPlan) {
        this.plan = courseBookPlan;
    }
}
