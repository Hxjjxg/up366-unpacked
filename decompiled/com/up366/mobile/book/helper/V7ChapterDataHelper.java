package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V7ChapterDataHelper {
    protected com.up366.mobile.book.model.BookInfoStudy book;
    private com.up366.mobile.book.helper.BookFilePathHelper bookFilePathHelper;

    public void init(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.helper.BookFilePathHelper bookFilePathHelper) {
        this.book = bookInfoStudy;
        this.bookFilePathHelper = bookFilePathHelper;
    }

    public com.up366.mobile.book.model.BookInfoStudy getBook() {
        return this.book;
    }

    public java.lang.String getBookPath() {
        return this.bookFilePathHelper.getCatalogDir();
    }

    public java.lang.String getBookDataPath() {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getUserRootPath(), this.book.getBookId());
    }

    public java.lang.String getChapterPath(com.up366.mobile.book.model.CatalogPage catalogPage) {
        return this.bookFilePathHelper.getContentDir(catalogPage.obj.getId());
    }

    public java.lang.String getChapterDataPath(com.up366.mobile.book.model.CatalogPage catalogPage) {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getUserRootPath(), this.book.getBookId(), catalogPage.obj.getId());
    }

    public java.lang.String getPageHtmlPath(com.up366.mobile.book.model.CatalogPage catalogPage) {
        return com.up366.common.FileUtilsUp.join(getChapterRootDir(catalogPage), catalogPage.obj.getDisplayOrder() + ".html");
    }

    public java.lang.String getPageJsPath(com.up366.mobile.book.model.CatalogPage catalogPage) {
        return com.up366.common.FileUtilsUp.join(getChapterRootDir(catalogPage), com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE + catalogPage.obj.getDisplayOrder() + ".js");
    }

    public java.lang.String getRelativePageDir(com.up366.mobile.book.model.CatalogPage catalogPage) {
        java.lang.String str = getChapterRootDir(catalogPage).split(this.book.getBookId() + "/")[1];
        if (str.endsWith("/")) {
            return str;
        }
        return str + "/";
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

    public java.lang.String getAnswerDataDir(com.up366.mobile.book.model.CatalogPage catalogPage) {
        if (catalogPage == null) {
            return com.up366.common.FileUtilsUp.join(getBookDataPath(), "catalog");
        }
        return com.up366.common.FileUtilsUp.join(getChapterRootDataDir(catalogPage), catalogPage.obj.getId());
    }
}
