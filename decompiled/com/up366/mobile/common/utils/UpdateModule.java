package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UpdateModule {
    private static final com.up366.mobile.common.utils.UpdateModule instance = new com.up366.mobile.common.utils.UpdateModule();
    private com.up366.mobile.common.logic.model.AppConfigLastVersion configLastVersion;
    private androidx.appcompat.app.AlertDialog errorDialog;
    private com.up366.mobile.common.views.UpdateCustomProgressDialog mDownloadProgressDialog;
    private androidx.appcompat.app.AlertDialog mUpdateDialog;
    private boolean userCheck = false;
    private final java.lang.String defaultDesc = "更新内容：\n1.修复已知bug~\n2.优化使用体验~\n温馨提示: 升级新版本不会删除您的任何数据哦~";

    private UpdateModule() {
    }

    public static com.up366.mobile.common.utils.UpdateModule getInstance() {
        return instance;
    }

    public void checkNewVersionAuto() {
        checkNewVersion(false);
    }

    public void checkNewVersionByUser() {
        checkNewVersion(true);
    }

    private void checkNewVersion(boolean z) {
        this.userCheck = z;
        com.up366.mobile.common.logic.Auth.cur().config().fetchModelMap(com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel(), com.up366.mobile.BuildConfig.VERSION_CODE, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.common.utils.UpdateModule$$ExternalSyntheticLambda4
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$checkNewVersion$1(response, (com.up366.mobile.common.logic.model.AppConfigLastVersion) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkNewVersion$1(com.up366.common.http.Response response, com.up366.mobile.common.logic.model.AppConfigLastVersion appConfigLastVersion) {
        if (appConfigLastVersion == null) {
            com.up366.common.log.Logger.error("fetchModelMap error ..." + response.toString());
            return;
        }
        this.configLastVersion = appConfigLastVersion;
        if (appConfigLastVersion.getStatus() == 0) {
            deleteOldApk();
            if ("AboutUp366Activity".equals(com.up366.common.global.GB.get().getCurrentActivity().getClass().getSimpleName())) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(com.up366.common.global.GB.get().getCurrentActivity(), "当前已是最新版本");
                return;
            }
            return;
        }
        if (this.configLastVersion.getVersion() <= 220 || 1 != appConfigLastVersion.getStatus()) {
            return;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(this.configLastVersion.getUrl())) {
            com.up366.common.log.Logger.error("APK下载地址为空...");
            return;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(this.configLastVersion.getDesc())) {
            this.configLastVersion.setDesc("更新内容：\n1.修复已知bug~\n2.优化使用体验~\n温馨提示: 升级新版本不会删除您的任何数据哦~");
        }
        java.io.File file = new java.io.File(getApkDownloadPath());
        if (com.up366.common.FileUtilsUp.isFileExists(file)) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(file);
        }
        com.up366.mobile.common.logic.Auth.cur().getPrivateCloudMgr().checkResult(new com.up366.mobile.cloud.CheckResultCallback() { // from class: com.up366.mobile.common.utils.UpdateModule$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.cloud.CheckResultCallback
            public final void checkOver(com.up366.mobile.cloud.model.ServerInfo serverInfo) {
                this.f$0.lambda$checkNewVersion$0(serverInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkNewVersion$0(com.up366.mobile.cloud.model.ServerInfo serverInfo) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.UpdateModule$$ExternalSyntheticLambda10
            @Override // com.up366.common.task.Task
            public final void run() {
                this.f$0.showUpdateTipDialog();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUpdateTipDialog() {
        if (this.userCheck || this.configLastVersion.getForceUpgrade() != com.up366.mobile.common.logic.model.AppConfigLastVersion.UPDATE_NO_TIP) {
            dismissAllDialog();
            this.mUpdateDialog = new androidx.appcompat.app.AlertDialog.Builder(com.up366.common.global.GB.get().getCurrentActivity(), 2132017829).create();
            int iLastIndexOf = this.configLastVersion.getVersionName().lastIndexOf(".");
            java.lang.String versionName = this.configLastVersion.getVersionName();
            if (iLastIndexOf <= 0) {
                iLastIndexOf = this.configLastVersion.getVersionName().length();
            }
            java.lang.String str = com.up366.common.StringUtils.format("新版本%s更新要点", versionName.substring(0, iLastIndexOf));
            android.view.View viewInflate = android.view.LayoutInflater.from(com.up366.common.global.GB.get().getCurrentActivity()).inflate(com.up366.mobile.R.layout.update_dialog_layout, (android.view.ViewGroup) null);
            ((android.widget.TextView) viewInflate.findViewById(com.up366.mobile.R.id.update_dialog_find_new_version_txt)).setText(str);
            ((android.widget.TextView) viewInflate.findViewById(com.up366.mobile.R.id.update_dialog_version_desc_txt)).setText(this.configLastVersion.getUpdateLog());
            android.widget.ImageButton imageButton = (android.widget.ImageButton) viewInflate.findViewById(com.up366.mobile.R.id.update_dialog_exit);
            imageButton.setVisibility(this.configLastVersion.getForceUpgrade() == com.up366.mobile.common.logic.model.AppConfigLastVersion.FORCE_UPDATE ? 8 : 0);
            imageButton.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.utils.UpdateModule$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$showUpdateTipDialog$2(view);
                }
            });
            com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(viewInflate.findViewById(com.up366.mobile.R.id.update_dialog_install_btn), new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.utils.UpdateModule$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$showUpdateTipDialog$4(view);
                }
            });
            if (this.mUpdateDialog.getWindow() != null) {
                this.mUpdateDialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable());
            }
            this.mUpdateDialog.setView(viewInflate);
            this.mUpdateDialog.setCancelable(false);
            this.mUpdateDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showUpdateTipDialog$2(android.view.View view) {
        this.mUpdateDialog.dismiss();
        showUpdatePhoneDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showUpdateTipDialog$4(android.view.View view) {
        com.up366.mobile.common.utils.PermissionUtils.checkInstallPermission(com.up366.common.global.GB.get().getCurrentActivity(), "天学网应用apk安装", new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.common.utils.UpdateModule$$ExternalSyntheticLambda5
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str) {
                this.f$0.lambda$showUpdateTipDialog$3(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showUpdateTipDialog$3(int i, java.lang.String str) {
        if (i == 0) {
            toDownload();
            this.mUpdateDialog.dismiss();
        } else {
            com.up366.mobile.common.onlinelog.OpLog.report("UpdateModule-noAuth", "弹出重试对话框，权限不足");
            onInstallFailed("权限不足");
        }
    }

    private void showUpdatePhoneDialog() {
        if (this.userCheck) {
            return;
        }
        com.up366.mobile.main.PhonePasswordUpdateHelper.INSTANCE.skip(com.up366.common.global.GB.get().getCurrentActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showErrorTipDialog, reason: merged with bridge method [inline-methods] */
    public void lambda$onInstallFailed$8(java.lang.String str) {
        if (this.userCheck || this.configLastVersion.getForceUpgrade() != com.up366.mobile.common.logic.model.AppConfigLastVersion.UPDATE_NO_TIP) {
            dismissAllDialog();
            this.errorDialog = new androidx.appcompat.app.AlertDialog.Builder(com.up366.common.global.GB.get().getCurrentActivity(), 2132017829).create();
            android.view.View viewInflate = android.view.LayoutInflater.from(com.up366.common.global.GB.get().getCurrentActivity()).inflate(com.up366.mobile.R.layout.update_dialog_layout, (android.view.ViewGroup) null);
            android.widget.TextView textView = (android.widget.TextView) viewInflate.findViewById(com.up366.mobile.R.id.update_dialog_find_new_version_txt);
            textView.setText("更新失败:" + str);
            textView.setTextColor(-168338);
            android.widget.TextView textView2 = (android.widget.TextView) viewInflate.findViewById(com.up366.mobile.R.id.update_dialog_version_desc_txt);
            android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
            spannableStringBuilder.append((java.lang.CharSequence) "温馨提示：\n");
            spannableStringBuilder.append((java.lang.CharSequence) "1.请检查网络连接是否正常\n");
            spannableStringBuilder.append((java.lang.CharSequence) "2.请检查是否允许了相关权限请求\n");
            textView2.setText(spannableStringBuilder);
            textView2.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
            android.widget.ImageButton imageButton = (android.widget.ImageButton) viewInflate.findViewById(com.up366.mobile.R.id.update_dialog_exit);
            imageButton.setVisibility(this.configLastVersion.getForceUpgrade() == com.up366.mobile.common.logic.model.AppConfigLastVersion.FORCE_UPDATE ? 8 : 0);
            imageButton.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.utils.UpdateModule$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$showErrorTipDialog$5(view);
                }
            });
            android.widget.Button button = (android.widget.Button) viewInflate.findViewById(com.up366.mobile.R.id.update_dialog_install_btn);
            button.setText("重试");
            com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(button, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.utils.UpdateModule$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$showErrorTipDialog$7(view);
                }
            });
            if (this.errorDialog.getWindow() != null) {
                this.errorDialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable());
            }
            this.errorDialog.setView(viewInflate);
            this.errorDialog.setCancelable(false);
            this.errorDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showErrorTipDialog$5(android.view.View view) {
        this.errorDialog.dismiss();
        showUpdatePhoneDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showErrorTipDialog$7(android.view.View view) {
        com.up366.mobile.common.utils.PermissionUtils.checkInstallPermission(com.up366.common.global.GB.get().getCurrentActivity(), "天学网应用apk安装", new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.common.utils.UpdateModule$$ExternalSyntheticLambda9
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str) {
                this.f$0.lambda$showErrorTipDialog$6(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showErrorTipDialog$6(int i, java.lang.String str) {
        if (i == 0) {
            toDownload();
            this.mUpdateDialog.dismiss();
        } else {
            com.up366.mobile.common.onlinelog.OpLog.report("UpdateModule-noAuth", "弹出重试对话框，权限不足");
            onInstallFailed("权限不足");
        }
    }

    private void dismissAllDialog() {
        androidx.appcompat.app.AlertDialog alertDialog = this.errorDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.errorDialog.dismiss();
            this.errorDialog = null;
        }
        androidx.appcompat.app.AlertDialog alertDialog2 = this.mUpdateDialog;
        if (alertDialog2 != null && alertDialog2.isShowing()) {
            this.mUpdateDialog.dismiss();
            this.mUpdateDialog = null;
        }
        com.up366.mobile.common.views.UpdateCustomProgressDialog updateCustomProgressDialog = this.mDownloadProgressDialog;
        if (updateCustomProgressDialog == null || !updateCustomProgressDialog.isShowing()) {
            return;
        }
        this.mDownloadProgressDialog.dismiss();
        this.mDownloadProgressDialog = null;
    }

    private java.lang.String getApkDownloadPath() {
        java.lang.String updateApkRootDir = com.up366.mobile.common.utils.AppFileUtils.getUpdateApkRootDir();
        java.io.File file = new java.io.File(updateApkRootDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        return com.up366.common.FileUtilsUp.join(updateApkRootDir, this.configLastVersion.getVersionName() + ".apk");
    }

    private void toInstallApk() {
        java.io.File file = new java.io.File(getApkDownloadPath());
        if (!isApkEffectve(file)) {
            com.up366.common.log.Logger.error("安装文件不正确");
            com.up366.mobile.common.onlinelog.OpLog.report("UpdateModule-fileError", "弹出重试对话框，安装文件不正确");
            deleteOldApk();
            onInstallFailed("文件异常");
            return;
        }
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
            intent.addFlags(2);
            intent.setDataAndType(androidx.core.content.FileProvider.getUriForFile(com.up366.common.global.GB.get().getCurrentActivity(), com.up366.common.global.GB.get().getCurrentActivity().getPackageName(), file), "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(android.net.Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        com.up366.common.global.GB.get().getCurrentActivity().startActivity(intent);
    }

    private void onInstallFailed(final java.lang.String str) {
        com.up366.mobile.common.logic.Auth.cur().getPrivateCloudMgr().checkResult(new com.up366.mobile.cloud.CheckResultCallback() { // from class: com.up366.mobile.common.utils.UpdateModule$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.cloud.CheckResultCallback
            public final void checkOver(com.up366.mobile.cloud.model.ServerInfo serverInfo) {
                this.f$0.lambda$onInstallFailed$9(str, serverInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInstallFailed$9(final java.lang.String str, com.up366.mobile.cloud.model.ServerInfo serverInfo) {
        if (serverInfo == null) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.UpdateModule$$ExternalSyntheticLambda14
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onInstallFailed$8(str);
                }
            });
        }
    }

    private void toDownload() {
        com.up366.mobile.common.logic.Auth.cur().getPrivateCloudMgr().checkResult(new com.up366.mobile.cloud.CheckResultCallback() { // from class: com.up366.mobile.common.utils.UpdateModule$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.cloud.CheckResultCallback
            public final void checkOver(com.up366.mobile.cloud.model.ServerInfo serverInfo) {
                this.f$0.lambda$toDownload$11(serverInfo);
            }
        });
        com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
        downloadInfo.setKey(this.configLastVersion.getUrl());
        downloadInfo.setDownloadUrl(this.configLastVersion.getUrl());
        downloadInfo.setFilePath(getApkDownloadPath());
        downloadInfo.setNeedCheck(true);
        downloadInfo.setFileMD5(this.configLastVersion.getApkMd5());
        downloadInfo.setFileSize(this.configLastVersion.getApkSize());
        com.up366.common.download.DownloadManager.getInstance().addDownload(downloadInfo, new com.up366.common.download.DownloadManager.IDownloadCallback() { // from class: com.up366.mobile.common.utils.UpdateModule$$ExternalSyntheticLambda2
            @Override // com.up366.common.download.DownloadManager.IDownloadCallback
            public final void onStateChange(java.lang.String str, int i, int i2, java.lang.String str2, long j, long j2, int i3, java.lang.String str3) {
                this.f$0.lambda$toDownload$12(str, i, i2, str2, j, j2, i3, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toDownload$11(com.up366.mobile.cloud.model.ServerInfo serverInfo) {
        if (serverInfo == null) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.UpdateModule$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$toDownload$10();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toDownload$10() throws java.lang.Exception {
        dismissAllDialog();
        com.up366.mobile.common.views.UpdateCustomProgressDialog updateCustomProgressDialog = new com.up366.mobile.common.views.UpdateCustomProgressDialog(com.up366.common.global.GB.get().getCurrentActivity());
        this.mDownloadProgressDialog = updateCustomProgressDialog;
        updateCustomProgressDialog.setCancelable(false);
        com.up366.common.global.GB.get().getCurrentActivity().getWindow().addFlags(128);
        this.mDownloadProgressDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toDownload$12(java.lang.String str, int i, int i2, java.lang.String str2, long j, long j2, int i3, java.lang.String str3) {
        com.up366.mobile.common.views.UpdateCustomProgressDialog updateCustomProgressDialog = this.mDownloadProgressDialog;
        if (updateCustomProgressDialog == null) {
            return;
        }
        if (i == 2) {
            if (updateCustomProgressDialog.isShowing()) {
                this.mDownloadProgressDialog.setMax((int) j2);
                this.mDownloadProgressDialog.setProgress((int) j);
                return;
            }
            return;
        }
        if (i == 4) {
            updateCustomProgressDialog.dismiss();
            toInstallApk();
        } else {
            if (i != 5) {
                return;
            }
            updateCustomProgressDialog.dismiss();
            onInstallFailed("下载异常");
            com.up366.mobile.common.onlinelog.OpLog.report("UpdateModule-downError", "弹出重试对话框，下载异常:" + str3 + "(" + i3 + ")");
        }
    }

    private boolean isApkDownloadSuccess() {
        java.io.File file;
        java.lang.String apkDownloadPath = getApkDownloadPath();
        try {
            file = new java.io.File(apkDownloadPath);
        } catch (java.lang.Exception unused) {
        }
        if (!com.up366.common.FileUtilsUp.isFileExists(file)) {
            return false;
        }
        if (this.configLastVersion.getApkSize() != file.length()) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(apkDownloadPath);
            return false;
        }
        java.lang.String strMD5DigestFileToFileMgr = com.up366.common.digest.MD5.MD5DigestFileToFileMgr(file);
        if (strMD5DigestFileToFileMgr != null && strMD5DigestFileToFileMgr.equalsIgnoreCase(this.configLastVersion.getApkMd5())) {
            return true;
        }
        com.up366.common.FileUtilsUp.deleteDirOrFile(apkDownloadPath);
        return false;
    }

    private boolean isApkEffectve(java.io.File file) {
        java.lang.String packageName = com.up366.common.global.GB.get().getCurrentActivity().getPackageName();
        android.app.Activity currentActivity = com.up366.common.global.GB.get().getCurrentActivity();
        if (!file.isFile() || !file.exists() || com.up366.common.StringUtils.isEmptyOrNull(packageName)) {
            return false;
        }
        android.content.pm.PackageInfo packageArchiveInfo = currentActivity.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1);
        if (packageArchiveInfo == null) {
            com.up366.common.log.Logger.error("包名校验失败，获取下载应用的PackageInfo为空");
            com.up366.mobile.common.onlinelog.OpLog.report("UpdateModule", "包名校验失败，获取下载应用的PackageInfo为空");
            return true;
        }
        if (packageName.equals(packageArchiveInfo.packageName)) {
            return true;
        }
        com.up366.common.log.Logger.error("更新失败，包名校验失败。已安装应用包名：" + packageName + "，下载应用包名：" + packageArchiveInfo.packageName);
        com.up366.mobile.common.onlinelog.OpLog.report("UpdateModule", "更新失败，包名校验失败。已安装应用包名：" + packageName + "，下载应用包名：" + packageArchiveInfo.packageName);
        return false;
    }

    private void deleteOldApk() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.UpdateModule$$ExternalSyntheticLambda11
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.utils.UpdateModule.lambda$deleteOldApk$13();
            }
        });
    }

    static /* synthetic */ void lambda$deleteOldApk$13() throws java.lang.Exception {
        java.io.File[] fileArrListFiles = new java.io.File(com.up366.mobile.common.utils.AppFileUtils.getUpdateApkRootDir()).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (java.io.File file : fileArrListFiles) {
            file.delete();
        }
    }
}
