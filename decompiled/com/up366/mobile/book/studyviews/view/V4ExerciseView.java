package com.up366.mobile.book.studyviews.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V4ExerciseView extends android.widget.FrameLayout {
    private boolean autoLoadPage;
    public com.up366.mobile.book.helper.BookTaskLogHelper bookTaskLogHelper;
    private com.up366.mobile.book.StudyActivity context;
    public com.up366.mobile.book.helper.V4ChapterDataHelper dataHelper;
    private com.up366.mobile.book.jsinterface.JSInterfaceV4 jsInterface;
    private com.up366.mobile.book.model.CatalogPage page;
    private int position;
    public com.up366.mobile.book.studyviews.StudyV4View studyFragment;
    private java.lang.String url;
    public final com.up366.mobile.book.webview.StudyPageWebView webView;

    public V4ExerciseView(android.content.Context context) {
        this(context, null);
    }

    public V4ExerciseView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V4ExerciseView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.autoLoadPage = true;
        com.up366.mobile.book.webview.StudyPageWebView studyPageWebView = new com.up366.mobile.book.webview.StudyPageWebView(context);
        this.webView = studyPageWebView;
        addView(studyPageWebView, -1, -1);
        this.context = (com.up366.mobile.book.StudyActivity) context;
    }

    public void setParams(com.up366.mobile.book.helper.V4ChapterDataHelper v4ChapterDataHelper, com.up366.mobile.book.model.CatalogPage catalogPage, int i, com.up366.mobile.book.studyviews.StudyV4View studyV4View) {
        this.bookTaskLogHelper = new com.up366.mobile.book.helper.BookTaskLogHelper(catalogPage, this.context.book, this.context.cfg);
        this.dataHelper = v4ChapterDataHelper;
        this.page = catalogPage;
        this.position = i;
        this.studyFragment = studyV4View;
        this.jsInterface = new com.up366.mobile.book.jsinterface.JSInterfaceV4(this.context, this, catalogPage, i);
        if (this.autoLoadPage) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$destroy$0() throws java.lang.Exception {
        com.up366.mobile.common.utils.WebViewCleanupUtils.destroy(this.webView, "jsObj");
    }

    public void destroy() {
        com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.view.V4ExerciseView$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$destroy$0();
            }
        });
    }

    public void onEnterPage() {
        this.bookTaskLogHelper.onEnterPage();
        if (this.webView.isPageHasLoaded()) {
            this.webView.setOnFinishedInterface(null);
            this.webView.callJSMethod("onEnterPage()");
            this.context.showLoading(false);
        } else {
            this.webView.setOnFinishedInterface(new com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface() { // from class: com.up366.mobile.book.studyviews.view.V4ExerciseView$$ExternalSyntheticLambda1
                @Override // com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface
                public final void onFinish() {
                    this.f$0.lambda$onEnterPage$1();
                }
            });
        }
        com.up366.mobile.book.StudyActivity studyActivity = this.context;
        studyActivity.buildBookPagePath(studyActivity.book, this.page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEnterPage$1() {
        if (this.dataHelper.curPosition == this.position) {
            this.webView.callJSMethod("onEnterPage()");
            this.context.showLoading(false);
        }
    }

    public void setAutoLoadPage(boolean z) {
        this.autoLoadPage = z;
    }

    public void refresh() {
        java.lang.String str;
        if (this.dataHelper.hasInit) {
            java.lang.String pageHtmlPath = this.dataHelper.getPageHtmlPath(this.page);
            if (com.up366.common.FileUtilsUp.isFileExists(pageHtmlPath)) {
                str = "file://" + pageHtmlPath;
            } else {
                com.up366.common.log.Logger.error("TAG - 2018/5/30 - V4ExerciseView - refresh - 文件不存在:" + pageHtmlPath);
                str = "about:blank";
            }
        } else {
            str = "about:blank";
        }
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.url)) {
            str = this.url;
        }
        this.webView.addJavascriptInterface(this.jsInterface, "jsObj");
        boolean zLoadUrlInQueue = this.webView.loadUrlInQueue(str, this.position);
        if (this.dataHelper.curPosition == this.position && zLoadUrlInQueue) {
            onEnterPage();
        }
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }
}
