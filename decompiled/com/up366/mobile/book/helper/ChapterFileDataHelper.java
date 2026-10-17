package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ChapterFileDataHelper extends com.up366.mobile.book.helper.V6ChapterDataHelper {
    public ChapterFileDataHelper(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy) {
        this.book = bookInfoStudy;
    }

    @Override // com.up366.mobile.book.helper.V6ChapterDataHelper
    @java.lang.Deprecated
    public void init(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.CatalogChapter catalogChapter, int[] iArr) {
        super.init(bookInfoStudy, catalogChapter, iArr);
    }

    @Override // com.up366.mobile.book.helper.V6ChapterDataHelper
    public com.up366.mobile.book.model.BookInfoStudy getBook() {
        return super.getBook();
    }

    @Override // com.up366.mobile.book.helper.V6ChapterDataHelper
    @java.lang.Deprecated
    public com.up366.mobile.book.model.CatalogChapter getInfo() {
        return super.getInfo();
    }

    @Override // com.up366.mobile.book.helper.V6ChapterDataHelper
    @java.lang.Deprecated
    public int[] getRange() {
        return super.getRange();
    }

    @Override // com.up366.mobile.book.helper.V6ChapterDataHelper
    public java.lang.String getBookPath() {
        return super.getBookPath();
    }

    @Override // com.up366.mobile.book.helper.V6ChapterDataHelper
    public java.lang.String getBookDataPath() {
        return super.getBookDataPath();
    }

    @Override // com.up366.mobile.book.helper.V6ChapterDataHelper
    @java.lang.Deprecated
    public java.lang.String getChapterPath(com.up366.mobile.book.model.CatalogPage catalogPage) {
        return super.getChapterPath(catalogPage);
    }

    @Override // com.up366.mobile.book.helper.V6ChapterDataHelper
    @java.lang.Deprecated
    public java.lang.String getChapterDataPath(com.up366.mobile.book.model.CatalogPage catalogPage) {
        return super.getChapterDataPath(catalogPage);
    }

    @Override // com.up366.mobile.book.helper.V6ChapterDataHelper
    @java.lang.Deprecated
    public java.lang.String getPageHtmlPath(com.up366.mobile.book.model.CatalogPage catalogPage) {
        return super.getPageHtmlPath(catalogPage);
    }

    @Override // com.up366.mobile.book.helper.V6ChapterDataHelper
    @java.lang.Deprecated
    public java.lang.String getChapterRootDir(com.up366.mobile.book.model.CatalogPage catalogPage) {
        return super.getChapterRootDir(catalogPage);
    }

    @Override // com.up366.mobile.book.helper.V6ChapterDataHelper
    @java.lang.Deprecated
    public java.lang.String getChapterRootDataDir(com.up366.mobile.book.model.CatalogPage catalogPage) {
        return super.getChapterRootDataDir(catalogPage);
    }
}
