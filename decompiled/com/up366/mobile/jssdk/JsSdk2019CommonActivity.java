package com.up366.mobile.jssdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class JsSdk2019CommonActivity extends com.up366.mobile.common.base.BaseActivity implements com.up366.mobile.book.StudyActivityInterface {
    private static final java.lang.String INTENT_SKIP_URL = "skipUrl";
    private com.up366.mobile.databinding.ActivityJssdk2019CommonBinding bing;
    private boolean hasDestroyedStudyView;
    private boolean hasReleasedOnExit;
    private com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper pickerClippedPhotoV2Helper;
    private com.up366.mobile.jssdk.PageEvent2019RecordHelper recordHelper;
    private com.up366.mobile.book.studyviews.StudyV7View studyV7View;
    private com.up366.mobile.book.exercise.js.TakePhotoHelper takePhotoHelper;
    private java.lang.String url;

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void buildBookPagePath(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.CatalogPage catalogPage) {
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void buildBookPagePathV8(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.book.StudyActivityInterface
    /* JADX INFO: renamed from: getContext */
    public android.app.Activity m1148getContext() {
        return this;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void qrScan(androidx.core.util.Consumer<java.lang.String> consumer) {
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showDownloadLoadingView() {
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showLoadingTitleBar(boolean z) {
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void updateDownloadLoadingView(int i, long j, long j2, java.lang.String str, java.lang.Runnable runnable) {
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "jssdk_2019_common";
    }

    public static void start(android.content.Context context, java.lang.String str) {
        com.up366.common.log.Logger.info("JsSdk2019CommonActivity start with skipUrl: " + str);
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.jssdk.JsSdk2019CommonActivity.class);
        intent.putExtra(INTENT_SKIP_URL, str);
        context.startActivity(intent);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.url = getIntent().getStringExtra(INTENT_SKIP_URL);
        this.recordHelper = new com.up366.mobile.jssdk.PageEvent2019RecordHelper(this.url);
        com.up366.mobile.databinding.ActivityJssdk2019CommonBinding activityJssdk2019CommonBinding = (com.up366.mobile.databinding.ActivityJssdk2019CommonBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.activity_jssdk_2019_common);
        this.bing = activityJssdk2019CommonBinding;
        activityJssdk2019CommonBinding.loadingView.setVisibility(0);
        this.bing.loadingView.setData(0);
        this.takePhotoHelper = new com.up366.mobile.book.exercise.js.TakePhotoHelper((android.app.Activity) this);
        this.pickerClippedPhotoV2Helper = new com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper(this, com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.REQUEST_CODE);
        this.studyV7View = new com.up366.mobile.book.studyviews.StudyV7View(this);
        this.studyV7View.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        this.bing.content.addView(this.studyV7View);
        this.studyV7View.b.webView.setWebViewClient(new android.webkit.WebViewClient() { // from class: com.up366.mobile.jssdk.JsSdk2019CommonActivity.1
            @Override // android.webkit.WebViewClient
            public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (android.text.TextUtils.equals(webResourceRequest.getUrl().toString(), com.up366.mobile.jssdk.JsSdk2019CommonActivity.this.studyV7View.b.webView.getUrl())) {
                    com.up366.common.log.Logger.error("TAG - StudyV8View - onReceivedError - load url error " + webResourceRequest.getUrl());
                    com.up366.mobile.jssdk.JsSdk2019CommonActivity.this.showLoadErrorTip("加载失败", "网络错误，建议更换网络环境或稍后重试。");
                }
            }
        });
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onStart() {
        super.onStart();
        this.recordHelper.onStart();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onStop() {
        super.onStop();
        this.recordHelper.onStop();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        com.up366.common.EventBusUtilsUp.unregister(this);
        destroyStudyViewIfNeeded();
        super.onDestroy();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.up366.mobile.book.exercise.js.TakePhotoHelper takePhotoHelper = this.takePhotoHelper;
        if (takePhotoHelper != null) {
            takePhotoHelper.onActivityResult(i, i2, intent);
        }
        com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper photoPickerClippedPhotoV2Helper = this.pickerClippedPhotoV2Helper;
        if (photoPickerClippedPhotoV2Helper != null) {
            photoPickerClippedPhotoV2Helper.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        if (getOnBackPressedDispatcher().hasEnabledCallbacks()) {
            super.onBackPressed();
            return;
        }
        com.up366.mobile.book.studyviews.StudyV7View studyV7View = this.studyV7View;
        if (studyV7View == null || !studyV7View.onBackPress()) {
            super.onBackPressed();
        }
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public void finish() {
        releaseStudyViewOnExit();
        super.finish();
    }

    private void releaseStudyViewOnExit() {
        com.up366.mobile.book.studyviews.StudyV7View studyV7View;
        if (this.hasReleasedOnExit || (studyV7View = this.studyV7View) == null) {
            return;
        }
        this.hasReleasedOnExit = true;
        studyV7View.stopPlayback();
    }

    private void destroyStudyViewIfNeeded() {
        com.up366.mobile.book.studyviews.StudyV7View studyV7View;
        if (this.hasDestroyedStudyView || (studyV7View = this.studyV7View) == null) {
            return;
        }
        this.hasDestroyedStudyView = true;
        studyV7View.onPageDestroy();
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.ContentDownloadHelper getContentDownloadHelper() {
        return new com.up366.mobile.book.helper.ContentDownloadHelper(this, new com.up366.mobile.book.helper.BookFilePathHelper(new com.up366.mobile.book.model.BookInfoStudy(), new com.up366.mobile.book.model.TreeBookChapter(false)));
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.BuyBookHelper getBuyBookHelper() {
        return new com.up366.mobile.book.helper.BuyBookHelper(m1148getContext(), getBookInfoStudy());
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.V8FilePathHelper getV8FilePathHelper() {
        return new com.up366.mobile.book.helper.V8FilePathHelper();
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.BookFilePathHelper getBookFilePathHelper() {
        return new com.up366.mobile.book.helper.BookFilePathHelper(new com.up366.mobile.book.model.BookInfoStudy(), new com.up366.mobile.book.model.TreeBookChapter(false));
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.HeadsetHelper getHeadsetHelper() {
        return new com.up366.mobile.book.helper.HeadsetHelper(m1148getContext());
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.exercise.js.TakePhotoHelper getTakePhotoHelper() {
        return this.takePhotoHelper;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper getPhotoPickerClippedPhotoV2Helper() {
        return this.pickerClippedPhotoV2Helper;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.common.helper.QRScanHelper getQRScanHelper() {
        return new com.up366.mobile.common.helper.QRScanHelper(m1148getContext());
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.model.OpenConfigInfo getOpenConfigInfo() {
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = new com.up366.mobile.book.model.OpenConfigInfo();
        openConfigInfo.openUrl = com.up366.common.global.GB.get().getServerUrl(this.url);
        return openConfigInfo;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.model.BookInfoStudy getBookInfoStudy() {
        return new com.up366.mobile.book.model.BookInfoStudy();
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.model.TreeBookChapter getBookChapterInfo() {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = getBookInfoStudy();
        com.up366.mobile.book.model.TreeBookChapter treeBookChapter = new com.up366.mobile.book.model.TreeBookChapter(false);
        treeBookChapter.setBook(bookInfoStudy);
        return treeBookChapter;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.common.views.TitleBarView getTitleBar() {
        return this.bing.titleBar;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showLoadErrorTip(java.lang.String str, java.lang.String str2) {
        onMessageEvent(new com.up366.mobile.common.event.LoadWebViewEvent(3, 3));
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showLoading(boolean z, boolean z2) {
        if (z && z2) {
            onMessageEvent(new com.up366.mobile.common.event.LoadWebViewEvent(3, 1));
            return;
        }
        com.up366.common.log.Logger.error("showLoading  showFlag:" + z + " b:" + z2);
        onMessageEvent(new com.up366.mobile.common.event.LoadWebViewEvent(3, 2));
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showLoading(boolean z) {
        if (z) {
            onMessageEvent(new com.up366.mobile.common.event.LoadWebViewEvent(3, 1));
        } else {
            onMessageEvent(new com.up366.mobile.common.event.LoadWebViewEvent(3, 2));
        }
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public android.view.View getRootView() {
        return this.bing.getRoot();
    }

    public void onMessageEvent(com.up366.mobile.common.event.LoadWebViewEvent loadWebViewEvent) {
        this.bing.loadingView.setShowTitleBar(false);
        int iState = loadWebViewEvent.state();
        if (iState == 1) {
            this.bing.loadingView.setVisibility(0);
            this.bing.loadingView.setData(0);
            return;
        }
        if (this.bing.loadingView.getCurrentType() == 1) {
            this.bing.loadingView.setShowTitleBar(true);
            return;
        }
        if (iState == 2) {
            this.bing.loadingView.setVisibility(8);
            return;
        }
        if (iState == 3) {
            this.bing.loadingView.setData(1, "", new android.view.View.OnClickListener() { // from class: com.up366.mobile.jssdk.JsSdk2019CommonActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$onMessageEvent$0(view);
                }
            });
            this.bing.loadingView.setShowTitleBar(true);
            this.bing.loadingView.setVisibility(0);
        } else {
            com.up366.common.log.Logger.error("未知状态 state = " + iState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$0(android.view.View view) {
        this.bing.loadingView.setData(0);
        this.bing.loadingView.setShowTitleBar(false);
        this.studyV7View.b.webView.reload();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.multimedia.event.PictureLoadEvent pictureLoadEvent) {
        com.up366.mobile.book.exercise.js.TakePhotoHelper takePhotoHelper = this.takePhotoHelper;
        if (takePhotoHelper != null) {
            takePhotoHelper.onMessageEvent(pictureLoadEvent);
        }
    }
}
