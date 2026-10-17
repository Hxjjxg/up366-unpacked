package com.up366.mobile.user.setting.clearcache;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CacheInfo {
    public static final int CACHE_TYPE_HOMEWORK = 5;
    public static final int CACHE_TYPE_SINGLE_BOOK = 7;
    public static final int CACHE_TYPE_TOTAL_BOOK = 6;
    private java.lang.String bookId;
    private boolean bookIsOwn;
    private java.lang.String bookName;
    private java.lang.String bookPicUrl;
    private int bookRemainDays;
    private java.lang.String cacheName;
    private long cacheSize;
    private int cacheType;
    private java.lang.Runnable clean;
    private boolean isSelected = false;
    private boolean showDotLine;

    public CacheInfo(java.lang.String str, java.lang.Runnable runnable, int i) {
        this.cacheName = str;
        this.clean = runnable;
        this.cacheType = i;
    }

    public CacheInfo(java.lang.String str, java.lang.Runnable runnable, int i, long j) {
        this.cacheName = str;
        this.clean = runnable;
        this.cacheType = i;
        this.cacheSize = j;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public int getCacheType() {
        return this.cacheType;
    }

    public void setCacheType(int i) {
        this.cacheType = i;
    }

    public java.lang.Runnable getClean() {
        return this.clean;
    }

    public void setClean(java.lang.Runnable runnable) {
        this.clean = runnable;
    }

    public long getCacheSize() {
        return this.cacheSize;
    }

    public void setCacheSize(long j) {
        this.cacheSize = j;
    }

    public java.lang.String getCacheName() {
        return this.cacheName;
    }

    public void setCacheName(java.lang.String str) {
        this.cacheName = str;
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public java.lang.String getBookPicUrl() {
        return this.bookPicUrl;
    }

    public void setBookPicUrl(java.lang.String str) {
        this.bookPicUrl = str;
    }

    public java.lang.String getBookName() {
        return this.bookName;
    }

    public void setBookName(java.lang.String str) {
        this.bookName = str;
    }

    public boolean isShowDotLine() {
        return this.showDotLine;
    }

    public void setShowDotLine(boolean z) {
        this.showDotLine = z;
    }

    public int getBookRemainDays() {
        return this.bookRemainDays;
    }

    public void setBookRemainDays(int i) {
        this.bookRemainDays = i;
    }

    public boolean isBookIsOwn() {
        return this.bookIsOwn;
    }

    public void setBookIsOwn(boolean z) {
        this.bookIsOwn = z;
    }
}
