package com.up366.mobile.user.setting;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AboutUp366Activity extends com.up366.mobile.common.base.BaseActivity {
    private static final java.lang.String JS_API_TEST_PAGE = "file:///android_asset/debug_js_api_effect_test.html";
    private com.up366.mobile.databinding.ActivityAboutUp366Binding binding;

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "user_setting_about";
    }

    public static void startAboutUp366Activity(android.content.Context context) {
        context.startActivity(new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.user.setting.AboutUp366Activity.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.mobile.databinding.ActivityAboutUp366Binding activityAboutUp366Binding = (com.up366.mobile.databinding.ActivityAboutUp366Binding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.activity_about_up366);
        this.binding = activityAboutUp366Binding;
        activityAboutUp366Binding.tvCurrentVersion.setText(java.lang.String.format("当前版本号:%s%s%s版本", com.up366.common.PackageUtils.getVersionName(), com.up366.mobile.BuildConfig.GIT_VERSION.concat(com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? "-pad" : ""), com.up366.mobile.common.utils.PlatformUtils.getTargetName()));
        this.binding.tvCurrentVersion.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.AboutUp366Activity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.checkVersion.setShowRedPoint(false);
        com.up366.mobile.common.logic.Auth.cur().config().fetchModelMap(com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel(), com.up366.mobile.BuildConfig.VERSION_CODE, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.setting.AboutUp366Activity$$ExternalSyntheticLambda1
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$onCreate$1(response, (com.up366.mobile.common.logic.model.AppConfigLastVersion) obj);
            }
        });
        this.binding.checkVersion.setTextTypeface(android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, 1));
        this.binding.checkVersion.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.AboutUp366Activity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.addPraise.setVisibility(com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? 8 : 0);
        this.binding.addPraise.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.AboutUp366Activity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        this.binding.icp.setTextIsSelectable(true ^ com.up366.mobile.common.utils.PlatformUtils.isClosePad());
        this.binding.icp.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.AboutUp366Activity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(android.view.View view) {
        if (com.up366.mobile.common.utils.DataPostDelay.isNoOutOfDate("show_version")) {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, com.up366.mobile.user.setting.VersionHelper.getVersionInfo());
        } else {
            com.up366.mobile.common.utils.DataPostDelay.addCacheFlag("show_version", 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(com.up366.common.http.Response response, com.up366.mobile.common.logic.model.AppConfigLastVersion appConfigLastVersion) {
        if (appConfigLastVersion == null || appConfigLastVersion.getVersion() <= 220) {
            return;
        }
        this.binding.checkVersion.setShowRedPoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$3(android.view.View view) {
        com.up366.mobile.common.utils.ViewUtil.clickView(view);
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, "正在检查更新...");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.setting.AboutUp366Activity$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onCreate$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$2() throws java.lang.Exception {
        com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo> netHolderFetchAllSync = com.up366.mobile.common.logic.Auth.cur().config().fetchAllSync();
        if (netHolderFetchAllSync.resp.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, netHolderFetchAllSync.resp);
            return;
        }
        com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.AppConfigLastVersion> modelMap = com.up366.mobile.common.logic.Auth.cur().config().getModelMap(com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel(), com.up366.mobile.BuildConfig.VERSION_CODE);
        if (modelMap.info != null && modelMap.info.getVersion() > 220) {
            this.binding.checkVersion.setShowRedPoint(true);
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
            com.up366.mobile.common.utils.UpdateModule.getInstance().checkNewVersionByUser();
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, "当前已是最新版本");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$4(android.view.View view) {
        com.up366.mobile.common.utils.ViewUtil.clickView(view);
        com.up366.mobile.common.dialog.PraiseDialog.startPraiseMarket(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$5(android.view.View view) {
        if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            return;
        }
        com.up366.mobile.common.utils.ViewUtil.clickView(view);
        android.content.Intent intent = new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.commonui.CommonWebViewActivity.class);
        intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, "https://beian.miit.gov.cn/");
        intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL_NAME, "ICP备案查询");
        startActivity(intent);
    }

    private static /* synthetic */ boolean lambda$onCreate$6(android.view.View view) {
        new com.up366.mobile.common.compat.ExportOralDataHelper().export(view);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$onCreate$8(android.view.View view) {
        com.up366.mobile.common.utils.PlatformUtils.switchTargetHost(this, new java.lang.Runnable() { // from class: com.up366.mobile.user.setting.AboutUp366Activity$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$7();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7() {
        this.binding.host.setText(com.up366.mobile.common.utils.PlatformUtils.getTargetHostInner());
    }

    private /* synthetic */ boolean lambda$onCreate$9(android.view.View view) {
        showJsApiTestDialog();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showJsApiTestDialog() {
        com.up366.mobile.common.dialog.AppDialog.create(this).title("JS API 测试").message("使用当前 host 打开独立测试页，不进入正常业务流程。\n左侧打开 V8，右侧打开 V9。").left("打开 V8", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.AboutUp366Activity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$showJsApiTestDialog$10(view);
            }
        }).right("打开 V9", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.AboutUp366Activity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$showJsApiTestDialog$11(view);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showJsApiTestDialog$10(android.view.View view) {
        openJsApiTestV8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showJsApiTestDialog$11(android.view.View view) {
        openJsApiTestV9();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void openJsApiTestV8() {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.up366.mobile.book.helper.Tools.KEY_EXTRA_DATA_DISMISS_LOADING, true);
        jSONObject.put(com.up366.mobile.book.helper.Tools.KEY_EXTRA_DATA_SHOW_TITLE_BAR, true);
        jSONObject.put(com.up366.mobile.book.helper.Tools.KEY_EXTRA_DATA_UPDATE_TITLE_FROM_HTML, true);
        com.up366.mobile.book.helper.Tools.openJSV8WebViewWithUrl(this, "JS API Effect Test V8", buildJsApiTestUrl("v8"), jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void openJsApiTestV9() {
        com.up366.mobile.book.StudyActivity2025Dialog.openDebugPage(this, this.binding.getRoot(), "JS API Effect Test V9", buildJsApiTestUrl("v9"));
    }

    private java.lang.String buildJsApiTestUrl(java.lang.String str) {
        return "file:///android_asset/debug_js_api_effect_test.html?sdk=" + android.net.Uri.encode(str) + "&host=" + android.net.Uri.encode(com.up366.mobile.common.utils.PlatformUtils.getTargetHostInner());
    }
}
