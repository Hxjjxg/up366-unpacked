package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DownloadExtHelper {
    private static volatile boolean resolverInstalled;

    public static void apply(com.up366.common.download.DownloadInfo downloadInfo, com.up366.mobile.book.model.FileInfo fileInfo) {
        if (downloadInfo == null || fileInfo == null || !fileInfo.isEncrypted()) {
            return;
        }
        installResolver();
        downloadInfo.ext.extSign = fileInfo.getExtTime();
        downloadInfo.ext.extType = fileInfo.getExtType();
        warm(fileInfo.getExtTime());
    }

    public static void installResolver() {
        if (resolverInstalled) {
            return;
        }
        synchronized (com.up366.mobile.book.helper.DownloadExtHelper.class) {
            if (resolverInstalled) {
                return;
            }
            com.up366.common.download.DownloadManager.getInstance().setExtResolver(new com.up366.common.download.DownloadExtResolver() { // from class: com.up366.mobile.book.helper.DownloadExtHelper$$ExternalSyntheticLambda0
                @Override // com.up366.common.download.DownloadExtResolver
                public final java.lang.String resolve(java.lang.String str, boolean z) {
                    return com.up366.mobile.common.logic.Auth.cur().config().resolveContentExt(str, z);
                }
            });
            resolverInstalled = true;
        }
    }

    private static void warm(final java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.DownloadExtHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.DownloadExtHelper.lambda$warm$1(str);
            }
        });
    }

    static /* synthetic */ void lambda$warm$1(java.lang.String str) throws java.lang.Exception {
        try {
            com.up366.mobile.common.logic.Auth.cur().config().resolveContentExt(str, false);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.warn("TAG - DownloadExtHelper - warm - failed", e);
        }
    }
}
