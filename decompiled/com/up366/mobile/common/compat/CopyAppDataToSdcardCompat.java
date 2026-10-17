package com.up366.mobile.common.compat;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CopyAppDataToSdcardCompat {
    public static final java.lang.String STRING = "13aa4ee984c933b9b105ff250d00e40645ecb18aa5877a9f96d6c3ddc2c024c0";
    private android.app.Activity activity;

    public boolean handle(android.app.Activity activity, java.lang.String str) {
        this.activity = activity;
        if (com.up366.common.StringUtils.isEmptyOrNull(str) || !STRING.equals(str.trim())) {
            return false;
        }
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.CopyAppDataToSdcardCompat$$ExternalSyntheticLambda1
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

    private void compat() {
        final java.io.File zipFile = getZipFile(true, null);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.CopyAppDataToSdcardCompat$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.compat.CopyAppDataToSdcardCompat.lambda$compat$1(zipFile);
            }
        });
    }

    static /* synthetic */ void lambda$compat$1(java.io.File file) throws java.lang.Exception {
        android.content.Intent intent = new android.content.Intent("android.intent.action.SEND");
        intent.setType(gdut.bsx.share2.ShareContentType.FILE);
        intent.putExtra("android.intent.extra.STREAM", androidx.core.content.FileProvider.getUriForFile(com.up366.common.global.GB.get().getApplicationContext(), com.up366.mobile.BuildConfig.APPLICATION_ID, file));
        com.up366.common.global.GB.get().getCurrentActivity().startActivity(android.content.Intent.createChooser(intent, "分享"));
        com.up366.common.log.Logger.info("TAG - CopyAppDataToSdcardCompat - success");
    }

    public static java.io.File getZipFile(boolean z, @javax.annotation.Nullable java.util.List<java.lang.String> list) {
        return getZipFile(z, list, "app");
    }

    public static java.io.File getZipFile(boolean z, @javax.annotation.Nullable java.util.List<java.lang.String> list, java.lang.String str) throws java.lang.Throwable {
        java.lang.String str2;
        java.lang.String str3 = com.up366.mobile.common.utils.AppFileUtils.getAppInternalCacheDir() + java.io.File.separator + str;
        java.lang.String str4 = str3 + java.io.File.separator + "databases";
        java.lang.String str5 = str3 + java.io.File.separator + "mmkv";
        java.lang.String str6 = str3 + java.io.File.separator + io.objectbox.BoxStoreBuilder.DEFAULT_NAME;
        java.lang.String str7 = str3 + java.io.File.separator + "local_files";
        java.lang.String str8 = str3 + java.io.File.separator + "app_bugly";
        java.lang.String str9 = str3 + ".zip";
        java.lang.String str10 = com.up366.common.global.GB.get().getApplicationContext().getFilesDir().getParent() + "/databases";
        java.lang.String str11 = com.up366.common.global.GB.get().getApplicationContext().getFilesDir().getParent() + "/files/mmkv";
        java.lang.String str12 = com.up366.common.global.GB.get().getApplicationContext().getFilesDir().getParent() + "/app_bugly";
        java.lang.String str13 = com.up366.common.global.GB.get().getApplicationContext().getFilesDir().getParent() + "/files/objectbox";
        java.lang.String answerBinPath = com.up366.mobile.common.utils.AppFileUtils.getAnswerBinPath();
        java.lang.String str14 = str3 + java.io.File.separator + "answers.bin";
        java.lang.String recordBinPath = com.up366.mobile.common.utils.AppFileUtils.getRecordBinPath();
        java.lang.String str15 = str3 + java.io.File.separator + "record.bin";
        java.lang.String str16 = str7;
        com.up366.common.FileUtilsUp.saveContentToFile(str3 + java.io.File.separator + "client-version.txt", "com.up366.mobile 6.0.1.8b928e8\n" + com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel() + "  " + android.os.Build.MODEL);
        if (z) {
            com.up366.mobile.common.compat.CopyFileUtil.copyDirectory(str10, str4, true);
            com.up366.mobile.common.compat.CopyFileUtil.copyDirectory(str11, str5, true);
            com.up366.mobile.common.compat.CopyFileUtil.copyDirectory(str12, str8, true);
            com.up366.mobile.common.compat.CopyFileUtil.copyDirectory(str13, str6, true);
            com.up366.mobile.common.compat.CopyFileUtil.copyDirectory(com.up366.mobile.common.utils.AppFileUtils.getLogPathOld(), str3 + java.io.File.separator + "logs", true);
            com.up366.mobile.common.compat.CopyFileUtil.copyDirectory(com.up366.mobile.common.utils.AppFileUtils.getLogPath(), str3 + java.io.File.separator + "logs", true);
            com.up366.common.FileUtilsUp.copyFileOrDir(answerBinPath, str14);
            com.up366.common.FileUtilsUp.copyFileOrDir(recordBinPath, str15);
        }
        if (list != null) {
            java.lang.String appExternalFilesDir = com.up366.mobile.common.utils.AppFileUtils.getAppExternalFilesDir();
            java.lang.String parent = com.up366.common.global.GB.get().getCurrentActivity().getFilesDir().getParent();
            for (java.lang.String str17 : list) {
                java.lang.String strJoin = com.up366.common.FileUtilsUp.join(appExternalFilesDir, str17);
                if (!com.up366.common.FileUtilsUp.isFileExists(strJoin)) {
                    strJoin = com.up366.common.FileUtilsUp.join(parent, str17);
                }
                if (com.up366.common.FileUtilsUp.isFileExists(strJoin)) {
                    if (com.up366.common.FileUtilsUp.isDir(strJoin)) {
                        str2 = str16;
                        com.up366.mobile.common.compat.CopyFileUtil.copyDirectory(strJoin, str2, true);
                    } else {
                        str2 = str16;
                        com.up366.common.FileUtilsUp.copyFileOrDir(strJoin, com.up366.common.FileUtilsUp.join(str2, new java.io.File(strJoin).getName()));
                    }
                    str16 = str2;
                }
            }
        }
        if (com.up366.common.FileUtilsUp.zip(str3, str9)) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(str3);
        }
        return new java.io.File(str9);
    }

    private void alert(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.CopyAppDataToSdcardCompat$$ExternalSyntheticLambda0
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
