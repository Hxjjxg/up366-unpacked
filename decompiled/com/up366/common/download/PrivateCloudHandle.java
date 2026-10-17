package com.up366.common.download;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PrivateCloudHandle {

    public interface HandlerResult {
        void onNotify(int i, int i2, java.lang.String str);

        void onResult(java.lang.String str);
    }

    public void onDownloadStateChange(java.lang.String str, int i) {
    }

    public void handle(com.up366.common.download.DownloadInfo downloadInfo, com.up366.common.download.PrivateCloudHandle.HandlerResult handlerResult) {
        handlerResult.onResult(downloadInfo.getDownloadUrl());
    }
}
