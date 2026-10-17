package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CatalogChapter extends com.up366.mobile.book.model.CatalogPage implements java.lang.Comparable<com.up366.mobile.book.model.CatalogChapter> {
    public com.up366.mobile.book.model.BookTaskFinishedInfo taskInfo;
    public java.util.List<com.up366.mobile.book.model.CatalogChapter> pages = new java.util.ArrayList();
    public java.util.List<com.up366.mobile.book.model.CatalogChapter> tasks = new java.util.ArrayList();

    public CatalogChapter(com.up366.mobile.book.model.ChapterInfo chapterInfo) {
        this.obj = chapterInfo;
    }

    public com.up366.mobile.book.model.CatalogChapter getNextPage() {
        for (com.up366.mobile.book.model.CatalogChapter nextPage : this.pages) {
            if (nextPage.obj.isPage() || nextPage.obj.isWelcome() || (nextPage = nextPage.getNextPage()) != null) {
                return nextPage;
            }
        }
        return null;
    }

    public com.up366.mobile.book.model.CatalogChapter getEndPage() {
        if (this.pages.size() == 0) {
            return null;
        }
        com.up366.mobile.book.model.CatalogChapter catalogChapter = this.pages.get(r0.size() - 1);
        if (catalogChapter.obj.isPage() || catalogChapter.obj.isWelcome()) {
            return catalogChapter;
        }
        com.up366.mobile.book.model.CatalogChapter endPage = catalogChapter.getEndPage();
        if (endPage != null) {
            return endPage;
        }
        return null;
    }

    public int getTaskNum() {
        int size = this.tasks.size();
        java.util.Iterator<com.up366.mobile.book.model.CatalogChapter> it = this.pages.iterator();
        while (it.hasNext()) {
            size += it.next().getTaskNum();
        }
        return size;
    }

    public int getStudyTaskNum() {
        java.util.Iterator<com.up366.mobile.book.model.CatalogChapter> it = this.tasks.iterator();
        int studyTaskNum = 0;
        while (it.hasNext()) {
            if (it.next().isFinished()) {
                studyTaskNum++;
            }
        }
        java.util.Iterator<com.up366.mobile.book.model.CatalogChapter> it2 = this.pages.iterator();
        while (it2.hasNext()) {
            studyTaskNum += it2.next().getStudyTaskNum();
        }
        return studyTaskNum;
    }

    private boolean isFinished() {
        return this.taskInfo.getAddDate() > 0;
    }

    public void countScore() {
        float weight;
        float weight2;
        if (this.pages.size() + this.tasks.size() == 0 || this.obj.isTask()) {
            return;
        }
        java.util.Iterator<com.up366.mobile.book.model.CatalogChapter> it = this.pages.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().obj.isChapter()) {
                i++;
            }
        }
        int size = this.tasks.size() + i;
        if (size == 0) {
            size = 1;
        }
        float f = 1.0f / size;
        long jMax = 0;
        float f2 = 0.0f;
        float unitStudyPercent = 0.0f;
        for (com.up366.mobile.book.model.CatalogChapter catalogChapter : this.pages) {
            catalogChapter.countScore();
            if (!catalogChapter.obj.isTask()) {
                if (catalogChapter.obj.getWeight() < 0.0f) {
                    weight2 = catalogChapter.taskInfo.getScore() * f;
                } else {
                    weight2 = catalogChapter.obj.getWeight() * catalogChapter.taskInfo.getScore();
                }
                f2 += weight2;
                unitStudyPercent += catalogChapter.obj.getUnitStudyPercent();
                jMax = java.lang.Math.max(jMax, catalogChapter.taskInfo.getStudyDate());
            }
        }
        for (com.up366.mobile.book.model.CatalogChapter catalogChapter2 : this.tasks) {
            if (catalogChapter2.obj.getWeight() < 0.0f) {
                weight = catalogChapter2.taskInfo.getScore() * f;
            } else {
                weight = catalogChapter2.obj.getWeight() * catalogChapter2.taskInfo.getScore();
            }
            f2 += weight;
            if (catalogChapter2.isFinished()) {
                unitStudyPercent += 1.0f;
                jMax = java.lang.Math.max(jMax, catalogChapter2.taskInfo.getStudyDate());
            }
        }
        this.taskInfo.setScore(f2);
        this.taskInfo.setStudyDate(jMax);
        if (this.tasks.size() + i == 0) {
            i = 1;
        }
        this.obj.setUnitStudyPercent(unitStudyPercent / (this.tasks.size() + i));
        this.taskInfo.setPercent((int) ((unitStudyPercent * 100.0f) / (i + this.tasks.size())));
    }

    @Override // java.lang.Comparable
    public int compareTo(com.up366.mobile.book.model.CatalogChapter catalogChapter) {
        return this.obj.getDisplayOrder() - catalogChapter.obj.getDisplayOrder();
    }

    public void setTaskInfo(com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo) {
        this.taskInfo = bookTaskFinishedInfo;
    }
}
