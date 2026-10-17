package com.up366.mobile.common.compat;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ExportOralDataHelper {
    public void export(final android.view.View view) {
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(view, "loading");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.ExportOralDataHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$export$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$export$0(android.view.View view) throws java.lang.Exception {
        try {
            java.lang.String strBuildZipFile = buildZipFile();
            if (android.text.TextUtils.isEmpty(strBuildZipFile)) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(view, "未找到录音数据");
            } else {
                shareZip(com.up366.common.global.GB.get().getCurrentActivity(), strBuildZipFile);
                com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(view, "导出成功");
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - ExportOralDataHelper - export - ", e);
            com.up366.mobile.common.utils.ToastPopupUtil.showError(view, e.getMessage() + "\n" + android.util.Log.getStackTraceString(e));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005c, code lost:
    
        com.up366.common.log.Logger.error("buildZipFile - len:" + r12 + " size:" + r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String buildZipFile() throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.common.compat.ExportOralDataHelper.buildZipFile():java.lang.String");
    }

    private void shareZip(final android.app.Activity activity, final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.ExportOralDataHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.compat.ExportOralDataHelper.lambda$shareZip$1(str, activity);
            }
        });
    }

    static /* synthetic */ void lambda$shareZip$1(java.lang.String str, android.app.Activity activity) throws java.lang.Exception {
        android.content.Intent intent = new android.content.Intent("android.intent.action.SEND");
        intent.setType(gdut.bsx.share2.ShareContentType.FILE);
        intent.putExtra("android.intent.extra.STREAM", androidx.core.content.FileProvider.getUriForFile(com.up366.common.global.GB.get().getApplicationContext(), com.up366.mobile.BuildConfig.APPLICATION_ID, new java.io.File(str)));
        activity.startActivity(android.content.Intent.createChooser(intent, "分享"));
    }
}
