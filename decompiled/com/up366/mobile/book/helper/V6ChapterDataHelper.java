package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V6ChapterDataHelper {
    protected com.up366.mobile.book.model.BookInfoStudy book;
    public int curPosition;
    private com.up366.mobile.book.model.CatalogChapter info;
    private int[] range = new int[2];

    public void init(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.CatalogChapter catalogChapter, int[] iArr) {
        this.book = bookInfoStudy;
        this.info = catalogChapter;
        this.range = iArr;
    }

    public com.up366.mobile.book.model.BookInfoStudy getBook() {
        return this.book;
    }

    public com.up366.mobile.book.model.CatalogChapter getInfo() {
        return this.info;
    }

    public int[] getRange() {
        return this.range;
    }

    public java.lang.String getBookPath() {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), this.book.getBookId());
    }

    public java.lang.String getBookDataPath() {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getUserRootPath(), this.book.getBookId());
    }

    public java.lang.String getChapterPath(com.up366.mobile.book.model.CatalogPage catalogPage) {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), this.book.getBookId(), catalogPage.obj.getId());
    }

    public java.lang.String getChapterDataPath(com.up366.mobile.book.model.CatalogPage catalogPage) {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getUserRootPath(), this.book.getBookId(), catalogPage.obj.getId());
    }

    public java.lang.String getPageHtmlPath(com.up366.mobile.book.model.CatalogPage catalogPage) {
        return com.up366.common.FileUtilsUp.join(getChapterRootDir(catalogPage), catalogPage.obj.getDisplayOrder() + ".html");
    }

    public java.lang.String getChapterRootDir(com.up366.mobile.book.model.CatalogPage catalogPage) {
        if (catalogPage.obj.isWelcome()) {
            return com.up366.common.FileUtilsUp.join(getBookPath(), "welcome");
        }
        if (catalogPage.getContentPPage() != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i = 0;
            while (true) {
                catalogPage = catalogPage.getpPage();
                if (catalogPage.obj.isContent()) {
                    return com.up366.common.FileUtilsUp.join(getChapterPath(catalogPage), sb.toString());
                }
                sb.insert(0, catalogPage.obj.getDisplayOrder() + java.io.File.separator);
                int i2 = i + 1;
                if (i > 10) {
                    throw new java.lang.IllegalStateException("文件目录查找失败");
                }
                i = i2;
            }
        } else {
            return com.up366.common.FileUtilsUp.join(getChapterPath(catalogPage));
        }
    }

    public java.lang.String getChapterRootDataDir(com.up366.mobile.book.model.CatalogPage catalogPage) {
        if (catalogPage.obj.isWelcome()) {
            return com.up366.common.FileUtilsUp.join(getBookDataPath(), "welcome");
        }
        if (catalogPage.getContentPPage() != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i = 0;
            while (true) {
                catalogPage = catalogPage.getpPage();
                if (catalogPage.obj.isContent()) {
                    return com.up366.common.FileUtilsUp.join(getChapterDataPath(catalogPage), sb.toString());
                }
                sb.insert(0, catalogPage.obj.getDisplayOrder() + java.io.File.separator);
                int i2 = i + 1;
                if (i > 10) {
                    throw new java.lang.IllegalStateException("文件目录查找失败");
                }
                i = i2;
            }
        } else {
            return com.up366.common.FileUtilsUp.join(getChapterDataPath(catalogPage));
        }
    }
}
