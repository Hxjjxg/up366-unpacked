package com.up366.mobile.book.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookDataCache {
    private static com.up366.mobile.book.activity.BookDataCache instance;
    private final java.util.Map<java.lang.String, com.up366.mobile.book.activity.BookDataCache.M> map = new java.util.HashMap();
    private final java.util.List<com.up366.mobile.book.activity.BookDataCache.S> studyActivityQueue = new java.util.LinkedList();

    private BookDataCache() {
    }

    private java.lang.String buildKey(int i, java.lang.String str) {
        return i + "-" + str;
    }

    public static com.up366.mobile.book.activity.BookDataCache getInstance() {
        if (instance == null) {
            synchronized (com.up366.mobile.book.activity.BookDataCache.class) {
                if (instance == null) {
                    instance = new com.up366.mobile.book.activity.BookDataCache();
                }
            }
        }
        return instance;
    }

    public synchronized com.up366.mobile.book.model.TreeBookChapter getTreeBookChapter(int i, java.lang.String str) {
        com.up366.mobile.book.activity.BookDataCache.M m;
        m = this.map.get(buildKey(i, str));
        if (m == null) {
            m = new com.up366.mobile.book.activity.BookDataCache.M();
            m.count = 0;
            m.treeBookChapter = new com.up366.mobile.book.model.TreeBookChapter(false);
            this.map.put(buildKey(i, str), m);
        }
        m.count++;
        return m.treeBookChapter;
    }

    public synchronized void clear(int i, java.lang.String str) {
        com.up366.mobile.book.activity.BookDataCache.M m = this.map.get(buildKey(i, str));
        if (m != null) {
            m.count--;
            if (m.count <= 0) {
                this.map.remove(buildKey(i, str));
            }
        }
    }

    public synchronized void resetTreeBookChapter(int i, java.lang.String str) {
        com.up366.mobile.book.activity.BookDataCache.M m = this.map.get(buildKey(i, str));
        if (m == null) {
            com.up366.mobile.book.activity.BookDataCache.M m2 = new com.up366.mobile.book.activity.BookDataCache.M();
            m2.count = 0;
            m2.treeBookChapter = new com.up366.mobile.book.model.TreeBookChapter(false);
            this.map.put(buildKey(i, str), m2);
        } else {
            m.treeBookChapter = new com.up366.mobile.book.model.TreeBookChapter(false);
        }
    }

    public synchronized void resetBookChapterCache() {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.up366.mobile.book.activity.BookDataCache.M>> it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().treeBookChapter.invalidHtmlJsonStrHash();
        }
    }

    public void addToQueue(com.up366.mobile.book.StudyActivity studyActivity) {
        com.up366.mobile.book.activity.BookDataCache.S s = new com.up366.mobile.book.activity.BookDataCache.S();
        s.context = studyActivity;
        this.studyActivityQueue.add(s);
    }

    public void removeFromQueue(com.up366.mobile.book.StudyActivity studyActivity) {
        for (int i = 0; i < this.studyActivityQueue.size(); i++) {
            if (this.studyActivityQueue.get(i).context == studyActivity) {
                this.studyActivityQueue.remove(i);
                return;
            }
        }
    }

    private int indexOfStudyPage(int i, java.lang.String str) {
        for (int i2 = 0; i2 < this.studyActivityQueue.size(); i2++) {
            com.up366.mobile.book.activity.BookDataCache.S s = this.studyActivityQueue.get(i2);
            com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = s.context.book;
            com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = s.context.cfg;
            if (openConfigInfo != null && openConfigInfo.isCatalog() && bookInfoStudy != null && bookInfoStudy.getBookId().equals(str) && bookInfoStudy.getCourseId() == i) {
                return i2;
            }
        }
        return -1;
    }

    private int indexOfStudyPage(com.up366.mobile.book.StudyActivity studyActivity) {
        for (int i = 0; i < this.studyActivityQueue.size(); i++) {
            if (this.studyActivityQueue.get(i).context == studyActivity) {
                return i;
            }
        }
        return -1;
    }

    public boolean containsCatalogPage(int i, java.lang.String str) {
        return indexOfStudyPage(i, str) >= 0;
    }

    public boolean coverToBackCatalogPage(int i, java.lang.String str, com.up366.mobile.book.StudyActivity studyActivity) {
        int iIndexOfStudyPage = indexOfStudyPage(i, str);
        return iIndexOfStudyPage >= 0 && indexOfStudyPage(studyActivity) > iIndexOfStudyPage;
    }

    static class M {
        volatile int count;
        com.up366.mobile.book.model.TreeBookChapter treeBookChapter;

        M() {
        }
    }

    static class S {
        com.up366.mobile.book.StudyActivity context;

        S() {
        }
    }
}
