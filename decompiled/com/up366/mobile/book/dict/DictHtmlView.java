package com.up366.mobile.book.dict;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DictHtmlView extends android.widget.FrameLayout {
    public com.up366.mobile.book.helper.AppInfoHelper appInfoHelper;
    public com.up366.mobile.book.dict.js.DictAudioHelper audioHelper;
    public com.up366.mobile.databinding.HtmlDictContentBinding b;
    public com.up366.mobile.book.model.OpenConfigInfo cfg;
    public com.up366.mobile.book.StudyActivity context;
    public com.up366.mobile.book.dict.DictDataHelper dataHelper;
    public com.up366.mobile.book.dict.js.DictHelper dictHelper;
    public com.up366.mobile.book.dict.js.DictJSInterface jsInterface;
    public com.up366.mobile.book.dict.js.DictOpenHelper openHelper;
    public com.up366.mobile.book.dict.js.DictRecordHelper recordHelper;
    public com.up366.mobile.book.dict.js.DictRegisterHelper registerHelper;
    public com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper;
    private int visibility;

    public void refresh() {
    }

    public DictHtmlView(android.content.Context context) {
        this(context, null);
    }

    public DictHtmlView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DictHtmlView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.HtmlDictContentBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.html_dict_content, this, true);
        com.up366.mobile.book.StudyActivity studyActivity = (com.up366.mobile.book.StudyActivity) context;
        initData(studyActivity);
        initHelpers();
        initViewData();
        loadHtmlPage();
        studyActivity.showLoading(true, true);
    }

    private void initHelpers() {
        this.appInfoHelper = new com.up366.mobile.book.helper.AppInfoHelper(this.context, this.b.webView);
        this.speechRecordHelper = new com.up366.mobile.book.helper.recorder.SpeechRecordHelper(this.context);
        com.up366.mobile.book.dict.DictDataHelper dictDataHelper = new com.up366.mobile.book.dict.DictDataHelper();
        this.dataHelper = dictDataHelper;
        this.dictHelper = new com.up366.mobile.book.dict.js.DictHelper(this, dictDataHelper, this.context);
        this.jsInterface = new com.up366.mobile.book.dict.js.DictJSInterface(this.context, this);
        this.openHelper = new com.up366.mobile.book.dict.js.DictOpenHelper(this);
        this.registerHelper = new com.up366.mobile.book.dict.js.DictRegisterHelper(this.context, this.b.webView, this.openHelper);
        this.recordHelper = new com.up366.mobile.book.dict.js.DictRecordHelper(this.b.webView, this.dataHelper, this.speechRecordHelper, this.registerHelper);
        this.audioHelper = new com.up366.mobile.book.dict.js.DictAudioHelper(this.b.webView, this.recordHelper, this.registerHelper);
    }

    private void initViewData() {
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = this.context.cfg;
        this.dataHelper.init(this.context, new com.up366.mobile.book.dict.js.DictDataHolder(openConfigInfo.exerciseType, openConfigInfo.exerciseData));
        this.context.titleBar.setVisibility(8);
        this.context.showLoadingTitleBar(false);
        this.context.setTitle(this.dictHelper.getLoadingTitle());
        this.b.webView.setHasAnim(false);
        this.b.webView.getBridgeHelper().setEnable(true);
    }

    private void loadHtmlPage() {
        java.lang.String path;
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.cfg.openUrl)) {
            path = this.cfg.openUrl;
            com.up366.common.log.Logger.debug("html open - page path : " + this.cfg.openUrl);
        } else {
            path = this.dataHelper.getPath();
        }
        com.up366.mobile.book.dict.js.DictJSInterface dictJSInterface = new com.up366.mobile.book.dict.js.DictJSInterface(this.context, this);
        this.b.webView.removeJavascriptInterface("_android_js_obj_");
        this.b.webView.addJavascriptInterface(dictJSInterface, "_android_js_obj_");
        boolean zLoadUrlInQueue = this.b.webView.loadUrlInQueue(path, 0);
        com.up366.common.log.Logger.info("TAG - DictHtmlView - loadHtmlPage - " + path);
        if (zLoadUrlInQueue) {
            onEnterPage();
        }
    }

    private void onEnterPage() {
        if (this.b.webView.isPageHasLoaded()) {
            this.b.webView.setOnFinishedInterface(null);
            com.up366.common.task.TaskUtils.postMainTaskDelay(50L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.dict.DictHtmlView$$ExternalSyntheticLambda3
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onEnterPage$0();
                }
            });
        } else {
            this.b.webView.setOnFinishedInterface(new com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface() { // from class: com.up366.mobile.book.dict.DictHtmlView$$ExternalSyntheticLambda4
                @Override // com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface
                public final void onFinish() {
                    this.f$0.lambda$onEnterPage$2();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEnterPage$0() throws java.lang.Exception {
        this.context.showLoading(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEnterPage$1() throws java.lang.Exception {
        this.context.showLoading(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEnterPage$2() {
        com.up366.common.task.TaskUtils.postMainTaskDelay(50L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.dict.DictHtmlView$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onEnterPage$1();
            }
        });
    }

    private void initData(com.up366.mobile.book.StudyActivity studyActivity) {
        this.context = studyActivity;
        this.cfg = studyActivity.cfg;
        this.context.titleBar.setVisibility(8);
        this.context.showLoadingTitleBar(false);
    }

    public boolean onBackPress() {
        if (this.registerHelper.hasRegister("beforegoback")) {
            this.registerHelper.callJsEvent("beforegoback");
            return true;
        }
        this.audioHelper.release();
        this.speechRecordHelper.forceStopAll();
        return false;
    }

    public void onPageDestroy() {
        this.dictHelper.closeDb();
        this.registerHelper.callJsEvent("beforewebviewdestory");
        this.registerHelper.destroy();
        postDelayed(new java.lang.Runnable() { // from class: com.up366.mobile.book.dict.DictHtmlView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onPageDestroy$4();
            }
        }, 500L);
        this.audioHelper.release();
        this.speechRecordHelper.forceStopAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPageDestroy$3() throws java.lang.Exception {
        com.up366.mobile.common.utils.WebViewCleanupUtils.destroy(this.b.webView, "_android_js_obj_");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPageDestroy$4() {
        com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.dict.DictHtmlView$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onPageDestroy$3();
            }
        });
    }

    public void onPause() {
        this.registerHelper.callJsEvent("pause");
    }

    public void onResume() {
        this.registerHelper.callJsEvent("resume");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        com.up366.common.EventBusUtilsUp.unregister(this);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        this.visibility = i;
    }

    public int getRealVisibility() {
        return this.visibility;
    }

    public void refreshData() {
        com.up366.common.log.Logger.info("TAG - DictHtmlView - refreshData - ");
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.common.event.NetStatusChangeEvent netStatusChangeEvent) {
        java.lang.String netWorkInfo = this.appInfoHelper.getNetWorkInfo();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("type", "_EVT_NETWORK_CHANGE_");
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("networkType", netWorkInfo);
        jSONObject.put("detail", jSONObject2);
        this.registerHelper.callJsEvent("message", "(%s)", jSONObject.toJSONString());
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.JSGlobalEvent jSGlobalEvent) {
        this.registerHelper.callJsEvent("message", "(%s)", jSGlobalEvent.getMsg());
    }
}
