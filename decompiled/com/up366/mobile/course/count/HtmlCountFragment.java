package com.up366.mobile.course.count;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class HtmlCountFragment extends com.up366.mobile.common.base.BaseFragment {
    private com.up366.mobile.databinding.HtmlCountContentBinding b;
    private com.up366.mobile.course.count.CountFragment.ICallMainFragment callMainFragment;
    public com.up366.mobile.course.count.HtmlCountJSInterface jsInterface;
    private java.lang.String loadUrl;
    public com.up366.mobile.book.webview.StudyPageWebView webView;
    private int resumeCount = 0;
    private com.up366.mobile.course.count.HtmlCountFragment.ICallFragment iCallFragment = new com.up366.mobile.course.count.HtmlCountFragment.AnonymousClass1();

    public interface ICallFragment {
        void closePage();

        void disableRefresh(boolean z);

        void dissmissProgressDialog();

        com.up366.mobile.book.model.BookInfoStudy getBookInfo();

        void openNewPage(java.lang.String str);

        void setContentView(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView);

        void showLoading(boolean z);

        void updateTitle(java.lang.String str, int i);
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (getParentFragment() instanceof com.up366.mobile.course.count.CountFragment) {
            this.callMainFragment = ((com.up366.mobile.course.count.CountFragment) getParentFragment()).iCallMainFragment;
        }
    }

    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        this.b = (com.up366.mobile.databinding.HtmlCountContentBinding) androidx.databinding.DataBindingUtil.inflate(layoutInflater, com.up366.mobile.R.layout.html_count_content, viewGroup, false);
        initView();
        initViewData();
        return this.b.getRoot();
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.jsInterface != null) {
            int i = this.resumeCount;
            this.resumeCount = i + 1;
            if (i <= 0 || this.callMainFragment.getCurHtmlFragment() != this) {
                return;
            }
            this.jsInterface.callJSMethod("onResume()");
        }
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onPause() {
        if (this.callMainFragment.getCurHtmlFragment() == this) {
            this.jsInterface.callJSMethod("onPause()");
        }
        super.onPause();
    }

    public void onDestroyView() {
        com.up366.mobile.course.count.HtmlCountJSInterface htmlCountJSInterface = this.jsInterface;
        if (htmlCountJSInterface != null) {
            htmlCountJSInterface.callJSMethod("onPageExchange()");
        }
        com.up366.mobile.common.utils.WebViewCleanupUtils.destroy(this.webView, "jsCountObj");
        this.webView = null;
        this.jsInterface = null;
        this.b = null;
        super.onDestroyView();
    }

    private void initView() {
        com.up366.mobile.book.webview.StudyPageWebView studyPageWebView = new com.up366.mobile.book.webview.StudyPageWebView(com.up366.common.global.GB.get().getApplicationContext());
        this.webView = studyPageWebView;
        studyPageWebView.setHasAnim(false);
        this.callMainFragment.setContentView(this.webView);
        this.webView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        this.b.countHtmlWebView.removeAllViews();
        this.b.countHtmlWebView.addView(this.webView);
        this.webView.setOnFinishedInterface(new com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface() { // from class: com.up366.mobile.course.count.HtmlCountFragment$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface
            public final void onFinish() {
                this.f$0.lambda$initView$0();
            }
        });
        com.up366.mobile.course.count.HtmlCountJSInterface htmlCountJSInterface = new com.up366.mobile.course.count.HtmlCountJSInterface(this.webView, this.iCallFragment);
        this.jsInterface = htmlCountJSInterface;
        this.webView.addJavascriptInterface(htmlCountJSInterface, "jsCountObj");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        visible(this.webView);
        this.jsInterface.callJSMethod("onEnterPage()");
    }

    private void initViewData() {
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.loadUrl)) {
            this.webView.loadUrlInQueue(this.loadUrl, 0);
        } else {
            loadHtmlCountPage();
        }
    }

    public void loadHtmlCountPage() {
        this.webView.setBackgroundColor(-986896);
        invisible(this.webView);
        this.webView.loadUrlInQueue("file://" + com.up366.common.FileUtilsUp.join(com.up366.mobile.book.exercise.ExerciseResourceHelper.getExerciseRootDir(), "report") + "/report.html", 0);
    }

    public void loadPage(java.lang.String str) {
        com.up366.mobile.book.webview.StudyPageWebView studyPageWebView = this.webView;
        if (studyPageWebView != null) {
            studyPageWebView.loadUrlInQueue(str, 0);
        } else {
            this.loadUrl = str;
        }
    }

    public void onResumeBack() {
        com.up366.mobile.course.count.HtmlCountJSInterface htmlCountJSInterface = this.jsInterface;
        if (htmlCountJSInterface != null) {
            int i = this.resumeCount;
            this.resumeCount = i + 1;
            if (i > 0) {
                htmlCountJSInterface.callJSMethod("onResume()");
            }
        }
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.count.HtmlCountFragment$1, reason: invalid class name */
    class AnonymousClass1 implements com.up366.mobile.course.count.HtmlCountFragment.ICallFragment {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$dissmissProgressDialog$0() throws java.lang.Exception {
            com.up366.mobile.course.count.HtmlCountFragment.this.callMainFragment.dismissProgressDialog();
        }

        @Override // com.up366.mobile.course.count.HtmlCountFragment.ICallFragment
        public void dissmissProgressDialog() {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.count.HtmlCountFragment$1$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$dissmissProgressDialog$0();
                }
            });
        }

        @Override // com.up366.mobile.course.count.HtmlCountFragment.ICallFragment
        public void setContentView(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
            com.up366.mobile.course.count.HtmlCountFragment.this.callMainFragment.setContentView(studyPageWebView);
        }

        @Override // com.up366.mobile.course.count.HtmlCountFragment.ICallFragment
        public void openNewPage(java.lang.String str) {
            com.up366.mobile.course.count.HtmlCountFragment.this.callMainFragment.openNewPage(str);
        }

        @Override // com.up366.mobile.course.count.HtmlCountFragment.ICallFragment
        public void closePage() {
            com.up366.mobile.course.count.HtmlCountFragment.this.callMainFragment.closePage();
        }

        @Override // com.up366.mobile.course.count.HtmlCountFragment.ICallFragment
        public void updateTitle(java.lang.String str, int i) {
            com.up366.mobile.course.count.HtmlCountFragment.this.callMainFragment.updateTitle(str, i);
        }

        @Override // com.up366.mobile.course.count.HtmlCountFragment.ICallFragment
        public com.up366.mobile.book.model.BookInfoStudy getBookInfo() {
            return com.up366.mobile.course.count.HtmlCountFragment.this.callMainFragment.getBookInfo();
        }

        @Override // com.up366.mobile.course.count.HtmlCountFragment.ICallFragment
        public void disableRefresh(boolean z) {
            com.up366.mobile.course.count.HtmlCountFragment.this.callMainFragment.setEnable(!z);
        }

        @Override // com.up366.mobile.course.count.HtmlCountFragment.ICallFragment
        public void showLoading(boolean z) {
            com.up366.mobile.course.count.HtmlCountFragment.this.callMainFragment.showLoading(z);
        }
    }
}
