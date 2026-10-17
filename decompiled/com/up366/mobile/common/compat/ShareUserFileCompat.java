package com.up366.mobile.common.compat;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ShareUserFileCompat {
    public boolean handle(final android.app.Activity activity, java.lang.String str) {
        if (str == null || !str.startsWith("SHAREFILE:")) {
            return false;
        }
        final java.lang.String[] strArrSplit = str.replace("SHAREFILE:", "").split(";");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.ShareUserFileCompat$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "加载中");
            }
        });
        final java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getAppExternalCacheDir(), "user");
        final java.lang.String str2 = strJoin + ".zip";
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.ShareUserFileCompat$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$handle$2(strArrSplit, strJoin, str2, activity);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handle$2(java.lang.String[] strArr, java.lang.String str, final java.lang.String str2, final android.app.Activity activity) throws java.lang.Exception {
        for (java.lang.String str3 : strArr) {
            com.up366.common.FileUtilsUp.copyFileOrDir(com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getAppExternalFilesDir(), str3), com.up366.common.FileUtilsUp.join(str, str3));
        }
        if (com.up366.common.FileUtilsUp.zip(str, str2)) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(str);
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.ShareUserFileCompat$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$handle$1(activity, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handle$1(android.app.Activity activity, java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        shareZip(activity, str);
    }

    private void shareZip(android.app.Activity activity, java.lang.String str) {
        new gdut.bsx.share2.Share2.Builder(activity).setContentType(gdut.bsx.share2.ShareContentType.FILE).setShareFileUri(gdut.bsx.share2.FileUtil.getFileUri(activity, gdut.bsx.share2.ShareContentType.FILE, new java.io.File(str))).setTitle("分享").build().shareBySystem();
    }
}
