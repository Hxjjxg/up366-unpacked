package com.up366.mobile.common.utils.alifile;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AliFileMgrV2 {
    public static final java.lang.String BIZ_UP366 = "up366";
    public static final java.lang.String BIZ_VIDEO = "video-uncheck";
    private static final long EXPIRATION_TIME = 1800000;
    private static final com.up366.mobile.common.utils.alifile.AliFileMgrV2 instance = new com.up366.mobile.common.utils.alifile.AliFileMgrV2();
    private final java.util.Map<java.lang.String, com.up366.mobile.common.utils.alifile.AliFileMgrV2.Holder> holderMap = new java.util.HashMap();

    public static void uploadFile(final com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo, final com.up366.mobile.common.utils.alifile.IOSSCallback iOSSCallback) {
        if (fileMapInfo.isUploaded()) {
            com.up366.common.log.Logger.info("TAG - AliFileMgrV2 - uploadFile - repeat upload return success!");
            iOSSCallback.onSuccess();
        } else {
            instance.getClientHolder(fileMapInfo.getBiz(), new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.common.utils.alifile.AliFileMgrV2$$ExternalSyntheticLambda2
                @Override // com.up366.common.callback.ICallbackCodeInfoObj
                public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                    com.up366.mobile.common.utils.alifile.AliFileMgrV2.lambda$uploadFile$1(iOSSCallback, fileMapInfo, i, str, (com.up366.mobile.common.utils.alifile.AliFileMgrV2.Holder) obj);
                }
            });
        }
    }

    static /* synthetic */ void lambda$uploadFile$1(final com.up366.mobile.common.utils.alifile.IOSSCallback iOSSCallback, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo, int i, java.lang.String str, final com.up366.mobile.common.utils.alifile.AliFileMgrV2.Holder holder) {
        if (i != 0) {
            iOSSCallback.onFailure(i, str);
        } else {
            final com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest = new com.alibaba.sdk.android.oss.model.PutObjectRequest(holder.bucketName, fileMapInfo.getObjectId(), fileMapInfo.getPath());
            com.up366.mobile.common.logic.Auth.cur().getPrivateCloudMgr().checkResult(new com.up366.mobile.cloud.CheckResultCallback() { // from class: com.up366.mobile.common.utils.alifile.AliFileMgrV2$$ExternalSyntheticLambda4
                @Override // com.up366.mobile.cloud.CheckResultCallback
                public final void checkOver(com.up366.mobile.cloud.model.ServerInfo serverInfo) {
                    com.up366.mobile.common.utils.alifile.AliFileMgrV2.lambda$uploadFile$0(holder, putObjectRequest, iOSSCallback, serverInfo);
                }
            });
        }
    }

    static /* synthetic */ void lambda$uploadFile$0(com.up366.mobile.common.utils.alifile.AliFileMgrV2.Holder holder, com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest, com.up366.mobile.common.utils.alifile.IOSSCallback iOSSCallback, com.up366.mobile.cloud.model.ServerInfo serverInfo) {
        if (serverInfo == null) {
            uploadByOss(holder, putObjectRequest, iOSSCallback);
            return;
        }
        com.up366.common.log.Logger.info("TAG - AliFileMgrV2 - uploadFile - uploadByPrivateCloud : " + serverInfo);
        uploadByPrivateCloud(holder, putObjectRequest, serverInfo, iOSSCallback);
    }

    private static void uploadByPrivateCloud(com.up366.mobile.common.utils.alifile.AliFileMgrV2.Holder holder, com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest, com.up366.mobile.cloud.model.ServerInfo serverInfo, final com.up366.mobile.common.utils.alifile.IOSSCallback iOSSCallback) {
        com.up366.mobile.cloud.PrivateCloudUpload.uploadFile(holder.endPoint, putObjectRequest, serverInfo, new com.up366.mobile.cloud.PrivateCloudUpload.IPrivateCloudUploadCallback() { // from class: com.up366.mobile.common.utils.alifile.AliFileMgrV2.1
            @Override // com.up366.mobile.cloud.PrivateCloudUpload.IPrivateCloudUploadCallback
            public void onSuccess() {
                iOSSCallback.onSuccess();
            }

            @Override // com.up366.mobile.cloud.PrivateCloudUpload.IPrivateCloudUploadCallback
            public void onFailure(int i, java.lang.String str) {
                iOSSCallback.onFailure(i, str);
            }

            @Override // com.up366.mobile.cloud.PrivateCloudUpload.IPrivateCloudUploadCallback
            public void onProgress(long j, long j2) {
                iOSSCallback.onProgress(j, j2);
            }
        });
    }

    private static void uploadByOss(com.up366.mobile.common.utils.alifile.AliFileMgrV2.Holder holder, com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest, final com.up366.mobile.common.utils.alifile.IOSSCallback iOSSCallback) {
        putObjectRequest.setProgressCallback(new com.alibaba.sdk.android.oss.callback.OSSProgressCallback() { // from class: com.up366.mobile.common.utils.alifile.AliFileMgrV2$$ExternalSyntheticLambda1
            public final void onProgress(java.lang.Object obj, long j, long j2) {
                iOSSCallback.onProgress(j, j2);
            }
        });
        holder.ossClient.asyncPutObject(putObjectRequest, new com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.PutObjectRequest, com.alibaba.sdk.android.oss.model.PutObjectResult>() { // from class: com.up366.mobile.common.utils.alifile.AliFileMgrV2.2
            public void onSuccess(com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest2, com.alibaba.sdk.android.oss.model.PutObjectResult putObjectResult) {
                iOSSCallback.onSuccess();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r5v2 */
            /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r5v4 */
            /* JADX WARN: Type inference failed for: r5v5 */
            /* JADX WARN: Type inference failed for: r5v6 */
            public void onFailure(com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest2, com.alibaba.sdk.android.oss.ClientException clientException, com.alibaba.sdk.android.oss.ServiceException serviceException) {
                if (com.up366.common.NetworkUtilsUp.isConnected()) {
                    iOSSCallback.onFailure(com.up366.common.download.DownloadInfo.ERR_UNKNOWN, "访问服务器失败，请检查网络(OSS)。");
                    java.lang.String str = "uploadByOss: error " + putObjectRequest2.getObjectKey();
                    ?? r5 = clientException;
                    if (serviceException != null) {
                        r5 = serviceException;
                    }
                    com.up366.common.log.Logger.error(str, r5);
                    return;
                }
                iOSSCallback.onFailure(com.up366.common.http.Response.FAIL_NETWORK_NO_CONNECT, "访问服务器失败，请检查网络(OSS)。");
                java.lang.String str2 = "uploadByOss: error  网络未连接 " + putObjectRequest2.getObjectKey();
                ?? r52 = clientException;
                if (serviceException != null) {
                    r52 = serviceException;
                }
                com.up366.common.log.Logger.error(str2, r52);
            }
        });
    }

    public static void appendFile(final java.lang.String str, final byte[] bArr, final java.lang.String str2, final com.up366.mobile.common.utils.alifile.IOSSCallback iOSSCallback) {
        headObject(str, str2, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.common.utils.alifile.AliFileMgrV2$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str3, java.lang.Object obj) {
                com.up366.mobile.common.utils.alifile.AliFileMgrV2.lambda$appendFile$3(iOSSCallback, str, bArr, str2, i, str3, (com.alibaba.sdk.android.oss.model.HeadObjectResult) obj);
            }
        });
    }

    static /* synthetic */ void lambda$appendFile$3(com.up366.mobile.common.utils.alifile.IOSSCallback iOSSCallback, java.lang.String str, byte[] bArr, java.lang.String str2, int i, java.lang.String str3, com.alibaba.sdk.android.oss.model.HeadObjectResult headObjectResult) {
        long j;
        if (i != 0 && i != -404) {
            iOSSCallback.onFailure(i, str3);
            return;
        }
        if (i != -404) {
            try {
                j = java.lang.Long.parseLong(java.util.Objects.requireNonNull(headObjectResult.getMetadata().getRawMetadata().get("x-oss-next-append-position")).toString());
            } catch (java.lang.Exception e) {
                iOSSCallback.onFailure(-500, e.getMessage());
                com.up366.common.log.Logger.error("TAG - AliFileMgrV2 - appendFile - ", e);
                return;
            }
        } else {
            j = 0;
        }
        appendFile(str, j, bArr, str2, iOSSCallback);
    }

    public static void appendFile(java.lang.String str, final long j, final byte[] bArr, final java.lang.String str2, final com.up366.mobile.common.utils.alifile.IOSSCallback iOSSCallback) {
        instance.getClientHolder(str, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.common.utils.alifile.AliFileMgrV2$$ExternalSyntheticLambda3
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str3, java.lang.Object obj) {
                com.up366.mobile.common.utils.alifile.AliFileMgrV2.lambda$appendFile$5(iOSSCallback, str2, bArr, j, i, str3, (com.up366.mobile.common.utils.alifile.AliFileMgrV2.Holder) obj);
            }
        });
    }

    static /* synthetic */ void lambda$appendFile$5(final com.up366.mobile.common.utils.alifile.IOSSCallback iOSSCallback, java.lang.String str, byte[] bArr, long j, int i, java.lang.String str2, com.up366.mobile.common.utils.alifile.AliFileMgrV2.Holder holder) {
        if (i != 0) {
            iOSSCallback.onFailure(i, str2);
            return;
        }
        com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata = new com.alibaba.sdk.android.oss.model.ObjectMetadata();
        objectMetadata.setContentType(gdut.bsx.share2.ShareContentType.TEXT);
        com.alibaba.sdk.android.oss.model.AppendObjectRequest appendObjectRequest = new com.alibaba.sdk.android.oss.model.AppendObjectRequest(holder.bucketName, str, bArr, objectMetadata);
        appendObjectRequest.setPosition(j);
        appendObjectRequest.setProgressCallback(new com.alibaba.sdk.android.oss.callback.OSSProgressCallback() { // from class: com.up366.mobile.common.utils.alifile.AliFileMgrV2$$ExternalSyntheticLambda6
            public final void onProgress(java.lang.Object obj, long j2, long j3) {
                iOSSCallback.onProgress(j2, j3);
            }
        });
        holder.ossClient.asyncAppendObject(appendObjectRequest, new com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.AppendObjectRequest, com.alibaba.sdk.android.oss.model.AppendObjectResult>() { // from class: com.up366.mobile.common.utils.alifile.AliFileMgrV2.3
            public void onSuccess(com.alibaba.sdk.android.oss.model.AppendObjectRequest appendObjectRequest2, com.alibaba.sdk.android.oss.model.AppendObjectResult appendObjectResult) {
                com.up366.common.log.Logger.info("TAG - AliFileMgrV2 - onSuccess - nextPosition : " + appendObjectResult.getNextPosition());
                iOSSCallback.onSuccess();
            }

            public void onFailure(com.alibaba.sdk.android.oss.model.AppendObjectRequest appendObjectRequest2, com.alibaba.sdk.android.oss.ClientException clientException, com.alibaba.sdk.android.oss.ServiceException serviceException) {
                if (com.up366.common.NetworkUtilsUp.isConnected()) {
                    iOSSCallback.onFailure(com.up366.common.download.DownloadInfo.ERR_UNKNOWN, "访问服务器失败，请检查网络(OSS)。");
                    com.up366.common.log.Logger.error(appendObjectRequest2.getObjectKey(), serviceException);
                } else {
                    iOSSCallback.onFailure(com.up366.common.http.Response.FAIL_NETWORK_NO_CONNECT, "访问服务器失败，请检查网络(OSS)。");
                    com.up366.common.log.Logger.error("网络异常：" + appendObjectRequest2.getObjectKey());
                }
            }
        });
    }

    public static void headObject(java.lang.String str, final java.lang.String str2, final com.up366.common.callback.ICallbackCodeInfoObj<com.alibaba.sdk.android.oss.model.HeadObjectResult> iCallbackCodeInfoObj) {
        instance.getClientHolder(str, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.common.utils.alifile.AliFileMgrV2$$ExternalSyntheticLambda7
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str3, java.lang.Object obj) {
                com.up366.mobile.common.utils.alifile.AliFileMgrV2.lambda$headObject$6(iCallbackCodeInfoObj, str2, i, str3, (com.up366.mobile.common.utils.alifile.AliFileMgrV2.Holder) obj);
            }
        });
    }

    static /* synthetic */ void lambda$headObject$6(final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, java.lang.String str, int i, java.lang.String str2, com.up366.mobile.common.utils.alifile.AliFileMgrV2.Holder holder) {
        if (i != 0) {
            iCallbackCodeInfoObj.onResult(i, str2, null);
        } else {
            holder.ossClient.asyncHeadObject(new com.alibaba.sdk.android.oss.model.HeadObjectRequest(holder.bucketName, str), new com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.HeadObjectRequest, com.alibaba.sdk.android.oss.model.HeadObjectResult>() { // from class: com.up366.mobile.common.utils.alifile.AliFileMgrV2.4
                public void onSuccess(com.alibaba.sdk.android.oss.model.HeadObjectRequest headObjectRequest, com.alibaba.sdk.android.oss.model.HeadObjectResult headObjectResult) {
                    iCallbackCodeInfoObj.onResult(0, null, headObjectResult);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Throwable] */
                /* JADX WARN: Type inference failed for: r6v4 */
                /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Throwable] */
                /* JADX WARN: Type inference failed for: r6v6 */
                /* JADX WARN: Type inference failed for: r6v7 */
                /* JADX WARN: Type inference failed for: r6v8 */
                public void onFailure(com.alibaba.sdk.android.oss.model.HeadObjectRequest headObjectRequest, com.alibaba.sdk.android.oss.ClientException clientException, com.alibaba.sdk.android.oss.ServiceException serviceException) {
                    if (com.up366.common.NetworkUtilsUp.isConnected()) {
                        if (serviceException != null && serviceException.getStatusCode() == 404) {
                            iCallbackCodeInfoObj.onResult(-404, "不存在指定的对象(OSS)。", null);
                            java.lang.String objectKey = headObjectRequest.getObjectKey();
                            ?? r6 = clientException;
                            if (clientException == null) {
                                r6 = serviceException;
                            }
                            com.up366.common.log.Logger.warn(objectKey, r6);
                            return;
                        }
                        iCallbackCodeInfoObj.onResult(-998, "访问服务器失败，请检查网络(OSS)。", null);
                        java.lang.String objectKey2 = headObjectRequest.getObjectKey();
                        ?? r62 = clientException;
                        if (clientException == null) {
                            r62 = serviceException;
                        }
                        com.up366.common.log.Logger.error(objectKey2, r62);
                        return;
                    }
                    iCallbackCodeInfoObj.onResult(com.up366.common.http.Response.FAIL_NETWORK_NO_CONNECT, "访问服务器失败，请检查网络(OSS)。", null);
                    com.up366.common.log.Logger.error("网络异常：" + headObjectRequest.getObjectKey());
                }
            });
        }
    }

    private void getClientHolder(java.lang.String str, com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.utils.alifile.AliFileMgrV2.Holder> iCallbackCodeInfoObj) {
        com.up366.mobile.common.utils.alifile.AliFileMgrV2.Holder holder = this.holderMap.get(str);
        if (holder != null && holder.expirationTime > com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()) {
            iCallbackCodeInfoObj.onResult(0, null, holder);
        } else {
            initOSSClientHolder(str, iCallbackCodeInfoObj);
        }
    }

    private void initOSSClientHolder(final java.lang.String str, final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.utils.alifile.AliFileMgrV2.Holder> iCallbackCodeInfoObj) {
        com.up366.mobile.common.logic.Auth.cur().config().fetchAliTokenMap(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.common.utils.alifile.AliFileMgrV2$$ExternalSyntheticLambda5
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$initOSSClientHolder$8(str, iCallbackCodeInfoObj, response, (java.util.Map) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initOSSClientHolder$8(final java.lang.String str, final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, com.up366.common.http.Response response, java.util.Map map) {
        com.up366.mobile.common.logic.model.AppConfigOssBucketInfo appConfigOssBucketInfo = (map == null || map.get(str) == null || ((com.up366.mobile.common.logic.model.AppConfigOssBucketInfo) java.util.Objects.requireNonNull((com.up366.mobile.common.logic.model.AppConfigOssBucketInfo) map.get(str))).getCurrentTime() + 1800000 <= com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()) ? null : (com.up366.mobile.common.logic.model.AppConfigOssBucketInfo) map.get(str);
        if (appConfigOssBucketInfo != null) {
            iCallbackCodeInfoObj.onResult(0, null, createOSSClientHolder(str, appConfigOssBucketInfo));
        } else {
            com.up366.mobile.common.logic.Auth.cur().config().refreshAliTokenMap(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.common.utils.alifile.AliFileMgrV2$$ExternalSyntheticLambda8
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response2, java.lang.Object obj) {
                    this.f$0.lambda$initOSSClientHolder$7(iCallbackCodeInfoObj, str, response2, (java.util.Map) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initOSSClientHolder$7(com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, java.lang.String str, com.up366.common.http.Response response, java.util.Map map) {
        if (response.isError()) {
            iCallbackCodeInfoObj.onResult(response.getCode(), response.getInfo(), null);
            return;
        }
        if (map != null && map.get(str) != null) {
            iCallbackCodeInfoObj.onResult(0, null, createOSSClientHolder(str, (com.up366.mobile.common.logic.model.AppConfigOssBucketInfo) java.util.Objects.requireNonNull((com.up366.mobile.common.logic.model.AppConfigOssBucketInfo) map.get(str))));
            return;
        }
        iCallbackCodeInfoObj.onResult(-1, "not found biz : " + str, null);
    }

    private com.up366.mobile.common.utils.alifile.AliFileMgrV2.Holder createOSSClientHolder(java.lang.String str, final com.up366.mobile.common.logic.model.AppConfigOssBucketInfo appConfigOssBucketInfo) {
        com.up366.mobile.common.utils.alifile.AliFileMgrV2.Holder holder = new com.up366.mobile.common.utils.alifile.AliFileMgrV2.Holder();
        holder.expirationTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() + 1800000;
        holder.bucketName = appConfigOssBucketInfo.getBucketname();
        holder.endPoint = appConfigOssBucketInfo.getDefaulthostid();
        com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider oSSFederationCredentialProvider = new com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider() { // from class: com.up366.mobile.common.utils.alifile.AliFileMgrV2.5
            public com.alibaba.sdk.android.oss.common.auth.OSSFederationToken getFederationToken() {
                return new com.alibaba.sdk.android.oss.common.auth.OSSFederationToken(appConfigOssBucketInfo.getTmpAkId(), appConfigOssBucketInfo.getTmpAkSecret(), appConfigOssBucketInfo.getSecurityToken(), java.lang.String.valueOf(3600));
            }
        };
        com.alibaba.sdk.android.oss.ClientConfiguration clientConfiguration = new com.alibaba.sdk.android.oss.ClientConfiguration();
        clientConfiguration.setConnectionTimeout(30000);
        clientConfiguration.setSocketTimeout(300000);
        clientConfiguration.setMaxConcurrentRequest(10);
        clientConfiguration.setMaxErrorRetry(2);
        holder.ossClient = new com.alibaba.sdk.android.oss.OSSClient(com.up366.common.global.GB.get().getApplicationContext(), "https://" + appConfigOssBucketInfo.getDefaulthostid(), oSSFederationCredentialProvider, clientConfiguration);
        this.holderMap.put(str, holder);
        return holder;
    }

    static class Holder {
        java.lang.String bucketName;
        java.lang.String endPoint;
        long expirationTime;
        com.alibaba.sdk.android.oss.OSSClient ossClient;

        Holder() {
        }
    }
}
