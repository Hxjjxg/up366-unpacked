package com.up366.mobile.cloud;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PrivateCloudUpload {

    public interface IPrivateCloudUploadCallback {
        void onFailure(int i, java.lang.String str);

        void onProgress(long j, long j2);

        void onSuccess();
    }

    public static void uploadFile(final java.lang.String str, final com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest, com.up366.mobile.cloud.model.ServerInfo serverInfo, final com.up366.mobile.cloud.PrivateCloudUpload.IPrivateCloudUploadCallback iPrivateCloudUploadCallback) {
        com.up366.common.upload.OkHttpUploadFile.post(new com.up366.common.upload.UpLoadFileParams(com.up366.mobile.cloud.PrivateCloudMgr.HTTP + serverInfo.getServerIp() + ":" + serverInfo.getPort() + com.up366.mobile.common.http.HttpMgrUtils.PRIVATE_SERVER_UPLOAD, "fileData", putObjectRequest.getUploadFilePath()) { // from class: com.up366.mobile.cloud.PrivateCloudUpload.1
            @Override // com.up366.common.upload.UpLoadFileParams
            public void initParams(java.util.Map<java.lang.String, java.lang.String> map) {
                super.initParams(map);
                map.put("endpoint", str);
                map.put("bucketName", putObjectRequest.getBucketName());
                map.put("objectName", putObjectRequest.getObjectKey());
            }

            @Override // com.up366.common.upload.UpLoadFileParams
            public void uploadCallback(com.up366.common.upload.UpLoadFileParams.State state, long j, long j2, java.lang.String str2) {
                super.uploadCallback(state, j, j2, str2);
                int i = com.up366.mobile.cloud.PrivateCloudUpload.AnonymousClass2.$SwitchMap$com$up366$common$upload$UpLoadFileParams$State[state.ordinal()];
                if (i == 1) {
                    com.up366.common.log.Logger.error(" privateCloudUpload net ok other error" + str2);
                    com.up366.mobile.common.logic.Auth.cur().getPrivateCloudMgr().startPrivateCloudModel(null);
                    if (iPrivateCloudUploadCallback != null) {
                        if (com.up366.common.NetworkUtilsUp.isConnected()) {
                            iPrivateCloudUploadCallback.onFailure(com.up366.common.download.DownloadInfo.ERR_UNKNOWN, "访问服务器失败，请检查网络(OSS)。");
                            com.up366.common.log.Logger.error(putObjectRequest.getObjectKey() + " privateCloudUpload net ok other error" + str2);
                            return;
                        }
                        iPrivateCloudUploadCallback.onFailure(com.up366.common.http.Response.FAIL_NETWORK_NO_CONNECT, "访问服务器失败，请检查网络(OSS)。");
                        com.up366.common.log.Logger.error("网络异常：" + putObjectRequest.getObjectKey());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    com.up366.common.log.Logger.info("PrivateCloudUpload success file=" + putObjectRequest.getUploadFilePath());
                    com.up366.mobile.cloud.PrivateCloudUpload.IPrivateCloudUploadCallback iPrivateCloudUploadCallback2 = iPrivateCloudUploadCallback;
                    if (iPrivateCloudUploadCallback2 != null) {
                        iPrivateCloudUploadCallback2.onSuccess();
                        return;
                    }
                    return;
                }
                if (i == 3 || i == 4) {
                    com.up366.common.log.Logger.info("PrivateCloudUpload uploading percent = " + ((int) ((100 * j) / j2)));
                    com.up366.mobile.cloud.PrivateCloudUpload.IPrivateCloudUploadCallback iPrivateCloudUploadCallback3 = iPrivateCloudUploadCallback;
                    if (iPrivateCloudUploadCallback3 != null) {
                        iPrivateCloudUploadCallback3.onProgress(j, j2);
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.up366.mobile.cloud.PrivateCloudUpload$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$up366$common$upload$UpLoadFileParams$State;

        static {
            int[] iArr = new int[com.up366.common.upload.UpLoadFileParams.State.values().length];
            $SwitchMap$com$up366$common$upload$UpLoadFileParams$State = iArr;
            try {
                iArr[com.up366.common.upload.UpLoadFileParams.State.FAILED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$up366$common$upload$UpLoadFileParams$State[com.up366.common.upload.UpLoadFileParams.State.SUCCESS.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$up366$common$upload$UpLoadFileParams$State[com.up366.common.upload.UpLoadFileParams.State.START.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$up366$common$upload$UpLoadFileParams$State[com.up366.common.upload.UpLoadFileParams.State.UPLOADING.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }
}
