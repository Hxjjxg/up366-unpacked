package com.up366.medialibrary.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MediaHelperManager {
    private static com.up366.medialibrary.ITools tools;
    private static final com.up366.medialibrary.helper.SelectorHelper selectorHelper = new com.up366.medialibrary.helper.SelectorHelper();
    private static final com.up366.medialibrary.helper.PreviewHelper previewHelper = new com.up366.medialibrary.helper.PreviewHelper();
    private static final com.up366.medialibrary.helper.SaveHelper saveHelper = new com.up366.medialibrary.helper.SaveHelper();

    public static com.up366.medialibrary.helper.SelectorHelper getSelectorHelper() {
        return selectorHelper;
    }

    public static com.up366.medialibrary.helper.PreviewHelper getPreviewHelper() {
        return previewHelper;
    }

    public static com.up366.medialibrary.helper.SaveHelper getSaveHelper() {
        return saveHelper;
    }

    public static void init(android.content.Context context, com.up366.medialibrary.ITools iTools) {
        tools = iTools;
        selectorHelper.init(context);
    }

    public static com.up366.medialibrary.ITools getTools() {
        com.up366.medialibrary.ITools iTools = tools;
        return iTools == null ? defaultTools() : iTools;
    }

    /* JADX INFO: renamed from: com.up366.medialibrary.helper.MediaHelperManager$1, reason: invalid class name */
    class AnonymousClass1 implements com.up366.medialibrary.ITools {
        AnonymousClass1() {
        }

        @Override // com.up366.medialibrary.ITools
        public void toastMessage(java.lang.String str) {
            com.up366.common.log.Logger.error("defaultTools toastMessage " + str);
        }

        @Override // com.up366.medialibrary.ITools
        public java.lang.String getRootPath(int i) {
            return com.up366.common.global.GB.get().getApplicationContext().getCacheDir().getPath();
        }

        @Override // com.up366.medialibrary.ITools
        public void downloadThnumbnail(java.lang.String str, java.lang.String str2, com.up366.medialibrary.listener.OnDownloadListener onDownloadListener) {
            downloadFile(str, str2, onDownloadListener);
        }

        @Override // com.up366.medialibrary.ITools
        public void downloadFile(java.lang.String str, java.lang.String str2, final com.up366.medialibrary.listener.OnDownloadListener onDownloadListener) {
            com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
            downloadInfo.setKey(str);
            downloadInfo.setDownloadUrl(str);
            downloadInfo.setNeedUnzip(false);
            downloadInfo.setNeedCheck(false);
            downloadInfo.setFilePath(str2);
            com.up366.common.download.DownloadManager.getInstance().addDownload(downloadInfo, new com.up366.common.download.DownloadManager.IDownloadCallback() { // from class: com.up366.medialibrary.helper.MediaHelperManager$1$$ExternalSyntheticLambda0
                @Override // com.up366.common.download.DownloadManager.IDownloadCallback
                public final void onStateChange(java.lang.String str3, int i, int i2, java.lang.String str4, long j, long j2, int i3, java.lang.String str5) {
                    com.up366.medialibrary.helper.MediaHelperManager.AnonymousClass1.lambda$downloadFile$0(onDownloadListener, str3, i, i2, str4, j, j2, i3, str5);
                }
            });
        }

        static /* synthetic */ void lambda$downloadFile$0(com.up366.medialibrary.listener.OnDownloadListener onDownloadListener, java.lang.String str, int i, int i2, java.lang.String str2, long j, long j2, int i3, java.lang.String str3) {
            onDownloadListener.onProgress(java.lang.Math.min((int) ((j * 100.0f) / j2), 100), "0");
            if (i == 5) {
                onDownloadListener.onError(i3, str3);
            } else if (i == 4) {
                onDownloadListener.onSuccess();
            }
        }
    }

    private static com.up366.medialibrary.ITools defaultTools() {
        return new com.up366.medialibrary.helper.MediaHelperManager.AnonymousClass1();
    }
}
