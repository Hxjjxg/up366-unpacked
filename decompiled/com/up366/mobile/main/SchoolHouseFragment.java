package com.up366.mobile.main;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SchoolHouseFragment extends com.up366.mobile.common.base.BaseFragment implements com.up366.mobile.book.StudyActivityInterface {
    private com.up366.mobile.databinding.SchoolHouseFragmentLayoutBinding bing;
    private com.up366.mobile.book.studyviews.StudyV8View studyV8View;

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void buildBookPagePath(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.CatalogPage catalogPage) {
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void buildBookPagePathV8(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy) {
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

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
    }

    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        this.bing = (com.up366.mobile.databinding.SchoolHouseFragmentLayoutBinding) androidx.databinding.DataBindingUtil.inflate(layoutInflater, com.up366.mobile.R.layout.school_house_fragment_layout, viewGroup, false);
        setTranslucentStatus(getActivity());
        com.up366.qmui.util.QMUIStatusBarHelper.setStatusBarLightMode(getActivity());
        this.bing.loadingView.setVisibility(0);
        this.bing.loadingView.setData(0);
        this.studyV8View = new com.up366.mobile.book.studyviews.StudyV8View(m1148getContext());
        this.studyV8View.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        this.bing.content.addView(this.studyV8View);
        return this.bing.getRoot();
    }

    public static void setTranslucentStatus(android.app.Activity activity) {
        android.view.Window window = activity.getWindow();
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
        window.setStatusBarColor(0);
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onResume() {
        super.onResume();
        this.studyV8View.onResume();
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onPause() {
        super.onPause();
        this.studyV8View.onPause();
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    /* JADX INFO: renamed from: getContext, reason: merged with bridge method [inline-methods] */
    public android.app.Activity m1148getContext() {
        return getActivity();
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.ContentDownloadHelper getContentDownloadHelper() {
        return new com.up366.mobile.book.helper.ContentDownloadHelper(m1148getContext());
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.BuyBookHelper getBuyBookHelper() {
        return new com.up366.mobile.book.helper.BuyBookHelper(m1148getContext(), new com.up366.mobile.book.model.BookInfoStudy());
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
        return new com.up366.mobile.book.exercise.js.TakePhotoHelper(m1148getContext());
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper getPhotoPickerClippedPhotoV2Helper() {
        return new com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper(getActivity(), com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.REQUEST_CODE);
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.common.helper.QRScanHelper getQRScanHelper() {
        return new com.up366.mobile.common.helper.QRScanHelper(m1148getContext());
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.model.OpenConfigInfo getOpenConfigInfo() {
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = new com.up366.mobile.book.model.OpenConfigInfo();
        openConfigInfo.openUrl = com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.common.http.HttpMgrUtils.SCHOOL_HOUSE_HOME_URL);
        return openConfigInfo;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.model.BookInfoStudy getBookInfoStudy() {
        return new com.up366.mobile.book.model.BookInfoStudy();
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.model.TreeBookChapter getBookChapterInfo() {
        return new com.up366.mobile.book.model.TreeBookChapter(false);
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.common.views.TitleBarView getTitleBar() {
        return this.bing.titleBar;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showLoadErrorTip(java.lang.String str, java.lang.String str2) {
        onMessageEvent(new com.up366.mobile.common.event.LoadWebViewEvent(2, 3));
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showLoading(boolean z, boolean z2) {
        if (z && z2) {
            onMessageEvent(new com.up366.mobile.common.event.LoadWebViewEvent(2, 1));
            return;
        }
        com.up366.common.log.Logger.error("showLoading  showFlag:" + z + " b:" + z2);
        onMessageEvent(new com.up366.mobile.common.event.LoadWebViewEvent(2, 2));
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showLoading(boolean z) {
        if (z) {
            onMessageEvent(new com.up366.mobile.common.event.LoadWebViewEvent(2, 1));
        } else {
            onMessageEvent(new com.up366.mobile.common.event.LoadWebViewEvent(2, 2));
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
            this.bing.loadingView.setData(1, "", new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.SchoolHouseFragment$$ExternalSyntheticLambda0
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
        this.studyV8View.b.webView.reload();
    }
}
