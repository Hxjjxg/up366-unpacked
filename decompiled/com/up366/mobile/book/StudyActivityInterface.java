package com.up366.mobile.book;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface StudyActivityInterface {
    void buildBookPagePath(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.CatalogPage catalogPage);

    void buildBookPagePathV8(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy);

    com.up366.mobile.book.model.TreeBookChapter getBookChapterInfo();

    com.up366.mobile.book.helper.BookFilePathHelper getBookFilePathHelper();

    com.up366.mobile.book.model.BookInfoStudy getBookInfoStudy();

    com.up366.mobile.book.helper.BuyBookHelper getBuyBookHelper();

    com.up366.mobile.book.helper.ContentDownloadHelper getContentDownloadHelper();

    android.app.Activity getContext();

    com.up366.mobile.book.helper.HeadsetHelper getHeadsetHelper();

    com.up366.mobile.book.model.OpenConfigInfo getOpenConfigInfo();

    com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper getPhotoPickerClippedPhotoV2Helper();

    com.up366.mobile.common.helper.QRScanHelper getQRScanHelper();

    android.view.View getRootView();

    com.up366.mobile.book.exercise.js.TakePhotoHelper getTakePhotoHelper();

    com.up366.mobile.common.views.TitleBarView getTitleBar();

    com.up366.mobile.book.helper.V8FilePathHelper getV8FilePathHelper();

    void qrScan(androidx.core.util.Consumer<java.lang.String> consumer);

    void showDownloadLoadingView();

    void showLoadErrorTip(java.lang.String str, java.lang.String str2);

    void showLoading(boolean z);

    void showLoading(boolean z, boolean z2);

    void showLoadingTitleBar(boolean z);

    void updateDownloadLoadingView(int i, long j, long j2, java.lang.String str, java.lang.Runnable runnable);
}
