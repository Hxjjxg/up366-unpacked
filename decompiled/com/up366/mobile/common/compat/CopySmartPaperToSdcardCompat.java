package com.up366.mobile.common.compat;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CopySmartPaperToSdcardCompat {
    public static final java.lang.String STRING = "13aa4ee984c933b9b105ff250d00e40645ecb1111111111116d6c3ddc2c024c0";
    private android.app.Activity activity;

    public boolean handle(android.app.Activity activity, java.lang.String str) {
        this.activity = activity;
        if (com.up366.common.StringUtils.isEmptyOrNull(str) || !STRING.equals(str.trim())) {
            return false;
        }
        alert("开始导出");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.CopySmartPaperToSdcardCompat$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$handle$0();
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handle$0() throws java.lang.Exception {
        try {
            compat();
        } catch (java.lang.Exception e) {
            alert(e.getMessage());
            com.up366.common.log.Logger.error(e.getMessage(), e);
        }
    }

    private void compat() throws java.lang.Throwable {
        final java.io.File zipFile = getZipFile();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.CopySmartPaperToSdcardCompat$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$compat$1(zipFile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$compat$1(java.io.File file) throws java.lang.Exception {
        android.content.Intent intent = new android.content.Intent("android.intent.action.SEND");
        intent.setType(gdut.bsx.share2.ShareContentType.FILE);
        intent.putExtra("android.intent.extra.STREAM", androidx.core.content.FileProvider.getUriForFile(com.up366.common.global.GB.get().getApplicationContext(), com.up366.mobile.BuildConfig.APPLICATION_ID, file));
        com.up366.common.global.GB.get().getCurrentActivity().startActivity(android.content.Intent.createChooser(intent, "分享"));
        com.up366.common.log.Logger.info("TAG - CopyAppDataToSdcardCompat - success");
        alert("数据导出成功！");
    }

    public static java.io.File getZipFile() throws java.lang.Throwable {
        java.lang.String str = com.up366.mobile.common.utils.AppFileUtils.getAppInternalCacheDir() + java.io.File.separator + "scanPaper";
        java.lang.String str2 = str + ".zip";
        com.up366.mobile.common.compat.CopyFileUtil.copyDirectory(com.up366.mobile.common.utils.AppFileUtils.getAppInternalFilesDir() + "/scanPaper", str, true);
        if (com.up366.common.FileUtilsUp.zip(str, str2)) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(str);
        }
        return new java.io.File(str2);
    }

    private void alert(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.CopySmartPaperToSdcardCompat$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$alert$2(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alert$2(java.lang.String str) throws java.lang.Exception {
        new androidx.appcompat.app.AlertDialog.Builder(this.activity).setTitle("提示").setMessage(str).setPositiveButton("确定", (android.content.DialogInterface.OnClickListener) null).show();
    }
}
