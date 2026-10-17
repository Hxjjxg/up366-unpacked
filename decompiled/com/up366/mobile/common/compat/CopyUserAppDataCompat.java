package com.up366.mobile.common.compat;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CopyUserAppDataCompat {
    private android.app.Activity activity;

    public boolean handle(android.app.Activity activity, java.lang.String str) {
        this.activity = activity;
        if (com.up366.common.StringUtils.isEmptyOrNull(str) || !"7095600fd54d12b781dc7fb56bd8c6095ba38bf00c59468b38112db6b36c5ede".equals(str.trim())) {
            return false;
        }
        alert("开始导入");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.CopyUserAppDataCompat$$ExternalSyntheticLambda1
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
            alert(e.getMessage() + "\n" + android.util.Log.getStackTraceString(e));
            com.up366.common.log.Logger.error(e.getMessage(), e);
        }
    }

    private void compat() throws java.lang.Throwable {
        java.lang.String path = ((java.io.File) java.util.Objects.requireNonNull(this.activity.getExternalCacheDir())).getPath();
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(path, "app.zip");
        java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(path, "app_unz");
        syncUnzip(strJoin, strJoin2);
        java.lang.String path2 = this.activity.getDatabasePath("abc").getParentFile().getParentFile().getPath();
        com.up366.mobile.common.compat.CopyFileUtil.copyDirectory(com.up366.common.FileUtilsUp.join(strJoin2, "/app/databases"), path2 + "/databases/", true);
        com.up366.mobile.common.compat.CopyFileUtil.copyDirectory(com.up366.common.FileUtilsUp.join(strJoin2, "/app/mmkv"), path2 + "/files/mmkv/", true);
        com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin2);
        alert("数据导入成功！");
    }

    private void alert(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.CopyUserAppDataCompat$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$alert$1(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alert$1(java.lang.String str) throws java.lang.Exception {
        new androidx.appcompat.app.AlertDialog.Builder(this.activity).setTitle("提示").setMessage(str).setPositiveButton("确定", (android.content.DialogInterface.OnClickListener) null).show();
    }

    private void syncUnzip(java.lang.String str, java.lang.String str2) {
        com.up366.common.download.ZipHelper.unzip(str, str2, new com.up366.common.download.ZipHelper.ZipCallback() { // from class: com.up366.mobile.common.compat.CopyUserAppDataCompat.1
            @Override // com.up366.common.download.ZipHelper.ZipCallback
            public void onProgress(int i) {
            }

            @Override // com.up366.common.download.ZipHelper.ZipCallback
            public void onSuccess() {
            }

            @Override // com.up366.common.download.ZipHelper.ZipCallback
            public void onFail(java.lang.Exception exc) {
                throw new java.lang.IllegalStateException(exc);
            }
        });
    }
}
