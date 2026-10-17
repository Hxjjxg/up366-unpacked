package com.up366.mobile.course.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class JsSdk2023TaskActivity extends com.up366.mobile.common.base.BaseActivity implements com.up366.mobile.book.StudyActivityInterface {
    private com.up366.mobile.databinding.ActivityJssdk2023CommonBinding bing;
    private boolean controlShowLoadingByJs = false;
    private com.up366.mobile.book.studyviews.StudyV8View studyV8View;

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
        return "smartroom_homework";
    }

    public static void start(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.course.task.JsSdk2023TaskActivity.class);
        intent.addFlags(603979776);
        context.startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.mobile.databinding.ActivityJssdk2023CommonBinding activityJssdk2023CommonBinding = (com.up366.mobile.databinding.ActivityJssdk2023CommonBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.activity_jssdk_2023_common);
        this.bing = activityJssdk2023CommonBinding;
        activityJssdk2023CommonBinding.loadingView.setVisibility(0);
        this.bing.loadingView.setData(0);
        this.studyV8View = new com.up366.mobile.book.studyviews.StudyV8View(this);
        this.studyV8View.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        this.bing.content.addView(this.studyV8View);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        this.studyV8View.onResume();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onPause() {
        super.onPause();
        this.studyV8View.onPause();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        com.up366.mobile.book.studyviews.StudyV8View studyV8View = this.studyV8View;
        if (studyV8View != null) {
            studyV8View.onPageDestroy(true);
            com.up366.mobile.databinding.ActivityJssdk2023CommonBinding activityJssdk2023CommonBinding = this.bing;
            if (activityJssdk2023CommonBinding != null) {
                activityJssdk2023CommonBinding.content.removeView(this.studyV8View);
            }
            this.studyV8View = null;
        }
        this.bing = null;
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.ContentDownloadHelper getContentDownloadHelper() {
        return new com.up366.mobile.book.helper.ContentDownloadHelper(this);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper getPhotoPickerClippedPhotoV2Helper() {
        return new com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper(this, com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.REQUEST_CODE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.common.helper.QRScanHelper getQRScanHelper() {
        return new com.up366.mobile.common.helper.QRScanHelper(this);
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.model.OpenConfigInfo getOpenConfigInfo() {
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = new com.up366.mobile.book.model.OpenConfigInfo();
        openConfigInfo.openUrl = com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.common.http.HttpMgrUtils.GOTO_TASK_LIST_HOME);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.up366.mobile.book.helper.Tools.KEY_EXTRA_DATA_DISMISS_LOADING, false);
        jSONObject.put(com.up366.mobile.book.helper.Tools.KEY_EXTRA_DATA_SHOW_TITLE_BAR, false);
        jSONObject.put(com.up366.mobile.book.helper.Tools.KEY_EXTRA_DATA_UPDATE_TITLE_FROM_HTML, false);
        openConfigInfo.exerciseData = jSONObject.toJSONString();
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
        if (z2) {
            this.controlShowLoadingByJs = true;
        }
        if (z2 || !this.controlShowLoadingByJs) {
            com.up366.common.log.Logger.info("showLoading  showFlag:" + z + " b:" + this.controlShowLoadingByJs);
            if (z) {
                onMessageEvent(new com.up366.mobile.common.event.LoadWebViewEvent(2, 1));
            } else {
                onMessageEvent(new com.up366.mobile.common.event.LoadWebViewEvent(2, 2));
            }
        }
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showLoading(boolean z) {
        showLoading(z, false);
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
            this.bing.loadingView.setData(1, "", new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.JsSdk2023TaskActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$onMessageEvent$0(view);
                }
            });
            this.bing.loadingView.setShowTitleBar(true);
            this.bing.loadingView.setTitleBarBackViewType(1);
            this.bing.loadingView.setVisibility(0);
            return;
        }
        com.up366.common.log.Logger.error("未知状态 state = " + iState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$0(android.view.View view) {
        this.bing.loadingView.setData(0);
        this.bing.loadingView.setShowTitleBar(false);
        this.studyV8View.b.webView.reload();
    }
}
