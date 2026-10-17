package com.up366.mobile.cloud;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PrivateCloudDownloadHandle extends com.up366.common.download.PrivateCloudHandle {
    @Override // com.up366.common.download.PrivateCloudHandle
    public void handle(com.up366.common.download.DownloadInfo downloadInfo, final com.up366.common.download.PrivateCloudHandle.HandlerResult handlerResult) {
        final java.lang.String key = downloadInfo.getKey();
        final java.lang.String downloadUrl = downloadInfo.getDownloadUrl();
        if (downloadInfo.isDisablePrivateCloud()) {
            com.up366.common.log.Logger.info("TAG - PrivateCloudDownloadHandle - handle - disablePrivateCloud " + downloadUrl);
            handlerResult.onResult(downloadUrl);
            return;
        }
        com.up366.mobile.common.logic.Auth.cur().getPrivateCloudMgr().checkResult(new com.up366.mobile.cloud.CheckResultCallback() { // from class: com.up366.mobile.cloud.PrivateCloudDownloadHandle$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.cloud.CheckResultCallback
            public final void checkOver(com.up366.mobile.cloud.model.ServerInfo serverInfo) {
                com.up366.mobile.cloud.PrivateCloudDownloadHandle.lambda$handle$1(downloadUrl, handlerResult, key, serverInfo);
            }
        });
    }

    static /* synthetic */ void lambda$handle$1(final java.lang.String str, final com.up366.common.download.PrivateCloudHandle.HandlerResult handlerResult, final java.lang.String str2, final com.up366.mobile.cloud.model.ServerInfo serverInfo) {
        com.up366.common.log.Logger.info("PrivateCloudDownloadHandle serverInfo = " + serverInfo);
        if (serverInfo == null) {
            com.up366.common.log.Logger.info(" PrivateCloudDownloadHandle handle url=" + str);
            handlerResult.onResult(str);
            return;
        }
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.cloud.PrivateCloudDownloadHandle$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.cloud.PrivateCloudDownload.downloadFile(str2, str, serverInfo, handlerResult);
            }
        });
    }

    @Override // com.up366.common.download.PrivateCloudHandle
    public void onDownloadStateChange(final java.lang.String str, int i) {
        if (i == 5 || i == 4 || i == 6) {
            com.up366.common.task.TaskUtils.postMainTaskDelay(com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS, new com.up366.common.task.Task() { // from class: com.up366.mobile.cloud.PrivateCloudDownloadHandle$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.cloud.PrivateCloudDownload.removePrivateDownloadKey(str);
                }
            });
        }
        if (i == 5) {
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.cloud.PrivateCloudDownloadHandle$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.common.logic.Auth.cur().getPrivateCloudMgr().startPrivateCloudModel(null);
                }
            });
        }
    }
}
