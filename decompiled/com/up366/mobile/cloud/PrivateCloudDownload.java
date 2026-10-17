package com.up366.mobile.cloud;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PrivateCloudDownload {
    private static final java.lang.String ENCRYPTED_FILE_QUERY = "et=1";
    private static final java.util.Map<java.lang.String, java.lang.Boolean> usePrivateCloudDownloadKeyMap = new java.util.concurrent.ConcurrentHashMap();

    public static void downloadFile(java.lang.String str, java.lang.String str2, com.up366.mobile.cloud.model.ServerInfo serverInfo, com.up366.common.download.PrivateCloudHandle.HandlerResult handlerResult) {
        java.lang.String str3;
        java.lang.String strNormalizePrivateCloudDownloadUrl = normalizePrivateCloudDownloadUrl(str2);
        try {
            str3 = com.up366.mobile.cloud.PrivateCloudMgr.HTTP + serverInfo.getServerIp() + ":" + serverInfo.getPort() + com.up366.mobile.common.http.HttpMgrUtils.PRIVATE_SERVER_LOAD + java.net.URLEncoder.encode(strNormalizePrivateCloudDownloadUrl, com.igexin.push.g.s.b);
        } catch (java.io.UnsupportedEncodingException e) {
            com.up366.common.log.Logger.error("privateCloudDownload downloadFile url encoder error", e);
            handlerResult.onNotify(5, com.up366.common.download.DownloadInfo.ERR_UNKNOWN, "未知异常！");
            e.printStackTrace();
            str3 = null;
        }
        if (str3 == null) {
            handlerResult.onNotify(5, -101, "下载地址为空！");
        } else {
            usePrivateCloudDownloadKeyMap.put(str, true);
            downloadFile(strNormalizePrivateCloudDownloadUrl, str3, java.lang.System.currentTimeMillis(), handlerResult);
        }
    }

    static java.lang.String normalizePrivateCloudDownloadUrl(java.lang.String str) {
        if (str == null || !str.contains(ENCRYPTED_FILE_QUERY)) {
            return str;
        }
        int iIndexOf = str.indexOf(35);
        java.lang.String strSubstring = iIndexOf >= 0 ? str.substring(iIndexOf) : "";
        java.lang.String strSubstring2 = iIndexOf >= 0 ? str.substring(0, iIndexOf) : str;
        int iIndexOf2 = strSubstring2.indexOf(63);
        if (iIndexOf2 < 0 || iIndexOf2 == strSubstring2.length() - 1) {
            return str;
        }
        java.lang.String strSubstring3 = strSubstring2.substring(0, iIndexOf2);
        java.lang.String[] strArrSplit = strSubstring2.substring(iIndexOf2 + 1).split("&");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = false;
        for (java.lang.String str2 : strArrSplit) {
            if (ENCRYPTED_FILE_QUERY.equals(str2)) {
                z = true;
            } else if (!str2.isEmpty()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(str2);
            }
        }
        if (!z) {
            return str;
        }
        com.up366.common.log.Logger.info("PrivateCloudDownload strip et=1 from private cloud url=" + str);
        if (sb.length() == 0) {
            return strSubstring3 + strSubstring;
        }
        return strSubstring3 + "?" + ((java.lang.Object) sb) + strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void downloadFile(java.lang.String str, java.lang.String str2, long j, com.up366.common.download.PrivateCloudHandle.HandlerResult handlerResult) {
        new okhttp3.OkHttpClient.Builder().followRedirects(false).connectTimeout(5L, java.util.concurrent.TimeUnit.SECONDS).writeTimeout(5L, java.util.concurrent.TimeUnit.SECONDS).build().newCall(new okhttp3.Request.Builder().url(str2).build()).enqueue(new com.up366.mobile.cloud.PrivateCloudDownload.AnonymousClass1(handlerResult, str, j, str2));
    }

    /* JADX INFO: renamed from: com.up366.mobile.cloud.PrivateCloudDownload$1, reason: invalid class name */
    class AnonymousClass1 implements okhttp3.Callback {
        final /* synthetic */ com.up366.common.download.PrivateCloudHandle.HandlerResult val$callback;
        final /* synthetic */ java.lang.String val$downloadUrl;
        final /* synthetic */ java.lang.String val$realUrl;
        final /* synthetic */ long val$time;

        AnonymousClass1(com.up366.common.download.PrivateCloudHandle.HandlerResult handlerResult, java.lang.String str, long j, java.lang.String str2) {
            this.val$callback = handlerResult;
            this.val$downloadUrl = str;
            this.val$time = j;
            this.val$realUrl = str2;
        }

        public void onFailure(okhttp3.Call call, java.io.IOException iOException) {
            if (com.up366.common.NetworkUtilsUp.isConnected()) {
                com.up366.mobile.cloud.PrivateCloudDownload.downloadFailEvent(-104, "你学校的服务器还没准备好", this.val$callback);
                com.up366.common.log.Logger.info("PrivateCloudDownload downloadFile onFailure");
            } else {
                com.up366.mobile.cloud.PrivateCloudDownload.downloadFailEvent(-104, "网络异常！", this.val$callback);
                com.up366.common.log.Logger.info("PrivateCloudDownload downloadFile onFailure net error");
            }
        }

        public void onResponse(okhttp3.Call call, okhttp3.Response response) {
            int iCode = response.code();
            if (iCode == 302) {
                java.lang.String strHeader = response.header("Location");
                com.up366.common.log.Logger.info("PrivateCloudDownload start download url=" + strHeader);
                this.val$callback.onResult(strHeader);
                return;
            }
            if (iCode != 404) {
                switch (iCode) {
                    case 907:
                        break;
                    case 908:
                        com.up366.mobile.cloud.PrivateCloudDownload.downloadFailEvent(-104, "你学校的服务器还没准备好", this.val$callback);
                        break;
                    case com.up366.medialibrary.config.PictureConstants.REQUEST_CAMERA /* 909 */:
                        if (java.lang.System.currentTimeMillis() - this.val$time > 30000) {
                            com.up366.common.log.Logger.info("PrivateCloudDownload wait private cloud timeout");
                            com.up366.mobile.cloud.PrivateCloudDownload.downloadFailEvent(-104, "你学校的服务器还没准备好", this.val$callback);
                        } else {
                            com.up366.common.log.Logger.info("PrivateCloudDownload wait private cloud..  url=" + this.val$realUrl + "  time=" + (java.lang.System.currentTimeMillis() - this.val$time));
                            final com.up366.common.download.PrivateCloudHandle.HandlerResult handlerResult = this.val$callback;
                            final java.lang.String str = this.val$downloadUrl;
                            final java.lang.String str2 = this.val$realUrl;
                            final long j = this.val$time;
                            com.up366.common.task.TaskUtils.postLazyTaskGlobal("private_cloud_download", 1000, new com.up366.common.task.Task() { // from class: com.up366.mobile.cloud.PrivateCloudDownload$1$$ExternalSyntheticLambda0
                                @Override // com.up366.common.task.Task
                                public final void run() throws java.lang.Exception {
                                    com.up366.mobile.cloud.PrivateCloudDownload.AnonymousClass1.lambda$onResponse$0(handlerResult, str, str2, j);
                                }
                            });
                        }
                        break;
                    default:
                        com.up366.mobile.cloud.PrivateCloudDownload.downloadFailEvent(com.up366.common.download.DownloadInfo.ERR_UNKNOWN, "未知错误！" + response.code(), this.val$callback);
                        break;
                }
                return;
            }
            com.up366.common.log.Logger.info("PrivateCloudDownload onResponse code=" + response.code() + " url=" + this.val$downloadUrl);
            this.val$callback.onNotify(5, -104, "私有云服务器异常！");
        }

        static /* synthetic */ void lambda$onResponse$0(com.up366.common.download.PrivateCloudHandle.HandlerResult handlerResult, java.lang.String str, java.lang.String str2, long j) throws java.lang.Exception {
            handlerResult.onNotify(1, 0, "你学校的服务器正在准备资源\n请耐心等待");
            com.up366.mobile.cloud.PrivateCloudDownload.downloadFile(str, str2, j, handlerResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void downloadFailEvent(int i, java.lang.String str, com.up366.common.download.PrivateCloudHandle.HandlerResult handlerResult) {
        handlerResult.onNotify(5, i, str);
    }

    public static void removePrivateDownloadKey(java.lang.String str) {
        usePrivateCloudDownloadKeyMap.remove(str);
    }

    public static boolean isPrivateDownloadKey(java.lang.String str) {
        java.lang.Boolean bool = usePrivateCloudDownloadKeyMap.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
