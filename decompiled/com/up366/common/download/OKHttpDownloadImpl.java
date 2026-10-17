package com.up366.common.download;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OKHttpDownloadImpl {
    private static final int DEFAULT_MAX_NETWORK_REQUEST_COUNT = 2;
    private static final int MAX_NETWORK_REQUEST_COUNT_LIMIT = 64;
    private static okhttp3.OkHttpClient httpClient = null;
    private static int maxNetworkRequestCount = 2;
    private final com.up366.common.download.DownloadInfo info;
    private com.up366.common.download.IDownloadStateChangeListener listener;
    private com.up366.common.download.PrivateCloudHandle privateCloudHandle;
    private boolean requestStop;

    public OKHttpDownloadImpl(com.up366.common.download.DownloadInfo downloadInfo) {
        this.info = downloadInfo;
        buildHttpClient();
    }

    private synchronized void buildHttpClient() {
        if (httpClient == null) {
            okhttp3.Dispatcher dispatcher = new okhttp3.Dispatcher();
            dispatcher.setMaxRequests(maxNetworkRequestCount);
            dispatcher.setMaxRequestsPerHost(maxNetworkRequestCount);
            okhttp3.OkHttpClient.Builder builderWriteTimeout = new okhttp3.OkHttpClient.Builder().dispatcher(dispatcher).followRedirects(true).followSslRedirects(true).connectTimeout(30L, java.util.concurrent.TimeUnit.SECONDS).readTimeout(30L, java.util.concurrent.TimeUnit.SECONDS).writeTimeout(40L, java.util.concurrent.TimeUnit.SECONDS);
            if (com.up366.common.global.GB.get().getConfig().getBooleanValue("HTTP_DNS_SWITCH")) {
                builderWriteTimeout.dns(com.up366.common.http.OkHttpDns.getInstance());
            }
            httpClient = builderWriteTimeout.build();
        }
    }

    public static synchronized void setMaxNetworkRequestCount(int i) {
        int iMax = java.lang.Math.max(1, java.lang.Math.min(i, 64));
        maxNetworkRequestCount = iMax;
        okhttp3.OkHttpClient okHttpClient = httpClient;
        if (okHttpClient != null) {
            okhttp3.Dispatcher dispatcher = okHttpClient.dispatcher();
            dispatcher.setMaxRequests(iMax);
            dispatcher.setMaxRequestsPerHost(iMax);
        }
        com.up366.common.log.Logger.info("TAG - OKHttpDownloadImpl - setMaxNetworkRequestCount - maxNetworkRequestCount = [" + maxNetworkRequestCount + "]");
    }

    public com.up366.common.download.OKHttpDownloadImpl setCallback(com.up366.common.download.IDownloadStateChangeListener iDownloadStateChangeListener) {
        this.listener = iDownloadStateChangeListener;
        return this;
    }

    public void start() {
        if (this.requestStop) {
            this.listener.onStateChange(3, 0L, 100L, 0, "cancel");
        } else {
            this.privateCloudHandle.handle(this.info, new com.up366.common.download.PrivateCloudHandle.HandlerResult() { // from class: com.up366.common.download.OKHttpDownloadImpl.1
                @Override // com.up366.common.download.PrivateCloudHandle.HandlerResult
                public void onResult(java.lang.String str) {
                    com.up366.common.download.OKHttpDownloadImpl oKHttpDownloadImpl = com.up366.common.download.OKHttpDownloadImpl.this;
                    oKHttpDownloadImpl.downloadImpl(oKHttpDownloadImpl.info, str);
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
                /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
                @Override // com.up366.common.download.PrivateCloudHandle.HandlerResult
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onNotify(int r11, int r12, java.lang.String r13) {
                    /*
                        r10 = this;
                        r0 = 1
                        r1 = 4
                        if (r11 == r0) goto L34
                        r0 = 5
                        if (r11 == r0) goto L32
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        java.lang.String r2 = "TAG - OKHttpDownloadImpl - onNotify - uncheck privateCloudHandle state : "
                        r0.<init>(r2)
                        r0.append(r11)
                        java.lang.String r0 = r0.toString()
                        com.up366.common.log.Logger.warn(r0)
                        com.up366.common.global.IGlobalUp r0 = com.up366.common.global.GB.get()
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        java.lang.String r3 = "state:"
                        r2.<init>(r3)
                        r2.append(r11)
                        java.lang.String r11 = r2.toString()
                        java.lang.String r2 = "base-uncheck-private-cloud-state"
                        r0.sendLog(r2, r11)
                        r3 = r1
                        goto L36
                    L32:
                        r11 = -1
                        goto L35
                    L34:
                        r11 = 0
                    L35:
                        r3 = r11
                    L36:
                        if (r3 == r1) goto L4f
                        com.up366.common.download.OKHttpDownloadImpl r11 = com.up366.common.download.OKHttpDownloadImpl.this
                        com.up366.common.download.IDownloadStateChangeListener r2 = com.up366.common.download.OKHttpDownloadImpl.m32$$Nest$fgetlistener(r11)
                        com.up366.common.download.OKHttpDownloadImpl r11 = com.up366.common.download.OKHttpDownloadImpl.this
                        com.up366.common.download.DownloadInfo r11 = com.up366.common.download.OKHttpDownloadImpl.m31$$Nest$fgetinfo(r11)
                        long r6 = r11.getFileSize()
                        r4 = 0
                        r8 = r12
                        r9 = r13
                        r2.onStateChange(r3, r4, r6, r8, r9)
                    L4f:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.up366.common.download.OKHttpDownloadImpl.AnonymousClass1.onNotify(int, int, java.lang.String):void");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadImpl(final com.up366.common.download.DownloadInfo downloadInfo, final java.lang.String str) {
        final long length;
        final java.lang.String key = downloadInfo.getKey();
        final java.lang.String fileTempPath = downloadInfo.getFileTempPath();
        final long fileSize = downloadInfo.getFileSize();
        try {
            if (com.up366.common.FileUtilsUp.isFileExists(fileTempPath)) {
                length = new java.io.File(fileTempPath).length();
            } else {
                com.up366.common.FileUtilsUp.mkdirParentDir(fileTempPath);
                com.up366.common.log.Logger.info("TAG - OKHttpDownloadImpl - downloadImpl - createNewFile : " + new java.io.File(fileTempPath).createNewFile());
                length = 0L;
            }
            if (length >= fileSize && fileSize != 0) {
                com.up366.common.log.Logger.info("TAG - OKHttpDownloadImpl - downloadImpl - tmpFileLength == totalFileLength");
                this.listener.onStateChange(1, fileSize, fileSize, 0, null);
                this.listener.onStateChange(2, fileSize, fileSize, 0, null);
                return;
            }
            okhttp3.Request.Builder builderAddHeader = new okhttp3.Request.Builder().url(str).addHeader("Connection", "close");
            if (length > 0) {
                builderAddHeader.addHeader("RANGE", "bytes=" + length + "-");
            }
            builderAddHeader.addHeader("User-Agent", com.up366.common.http.RequestParams.getUserAgent());
            okhttp3.Request requestBuild = builderAddHeader.build();
            if (this.requestStop) {
                this.listener.onStateChange(3, 0L, fileSize, 0, "cancel");
            } else {
                httpClient.newCall(requestBuild).enqueue(new okhttp3.Callback() { // from class: com.up366.common.download.OKHttpDownloadImpl.2
                    public void onFailure(okhttp3.Call call, java.io.IOException iOException) {
                        if (com.up366.common.download.OKHttpDownloadImpl.this.requestStop) {
                            com.up366.common.download.OKHttpDownloadImpl.this.listener.onStateChange(3, 0L, fileSize, 0, "cancel");
                            return;
                        }
                        com.up366.common.log.Logger.error("TAG - OKHttpDownloadImpl - onFailure - " + str, iOException);
                        com.up366.common.download.OKHttpDownloadImpl.this.listener.onStateChange(-1, 0L, fileSize, -104, iOException.getMessage());
                    }

                    public void onResponse(okhttp3.Call call, okhttp3.Response response) throws java.lang.Throwable {
                        okhttp3.HttpUrl httpUrlUrl = response.request().url();
                        try {
                            downloadInfo.ext.ipAddress = com.up366.common.download.OKHttpDownloadImpl.httpClient.dns().lookup(httpUrlUrl.host()).toString();
                        } catch (java.lang.Exception e) {
                            com.up366.common.log.Logger.error("TAG - OKHttpDownloadImpl - onResponse - lookup " + httpUrlUrl.host(), e);
                        }
                        downloadInfo.ext.redirectUrl = httpUrlUrl.toString();
                        com.up366.common.log.Logger.info("TAG - OKHttpDownloadImpl - onResponse - redirectUrl : " + downloadInfo.ext.redirectUrl + " ipAddress:" + downloadInfo.ext.ipAddress);
                        if (response.isSuccessful()) {
                            com.up366.common.download.OKHttpDownloadImpl.this.handleResponse(response, key, fileSize, fileTempPath, length, str);
                            return;
                        }
                        com.up366.common.log.Logger.error("TAG - OKHttpDownloadImpl - onResponse - " + response.toString());
                        if (response.code() == 416) {
                            com.up366.common.log.Logger.info("TAG - OKHttpDownloadImpl - onResponse : response.code() == 416 delete tmp file:" + fileTempPath);
                            com.up366.common.FileUtilsUp.deleteDirOrFile(fileTempPath);
                        }
                        com.up366.common.download.OKHttpDownloadImpl.this.listener.onStateChange(-1, 0L, fileSize, -104, response.toString());
                    }
                });
            }
        } catch (java.lang.Exception e) {
            if (this.requestStop) {
                this.listener.onStateChange(3, 0L, fileSize, 0, "cancel");
                return;
            }
            com.up366.common.log.Logger.error("TAG - OKHttpDownloadImpl - onResponse - " + str, e);
            this.listener.onStateChange(-1, 0L, fileSize, -105, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleResponse(okhttp3.Response response, java.lang.String str, long j, java.lang.String str2, long j2, java.lang.String str3) throws java.lang.Throwable {
        long j3;
        java.io.RandomAccessFile randomAccessFile;
        if (this.requestStop) {
            this.listener.onStateChange(3, 0L, j, 0, "cancel");
            return;
        }
        byte[] bArr = new byte[4096];
        java.io.InputStream inputStreamByteStream = null;
        try {
            try {
                okhttp3.ResponseBody responseBodyBody = response.body();
                if (responseBodyBody == null) {
                    com.up366.common.log.Logger.error("TAG - OKHttpDownloadImpl - onResponse - response.body() == null");
                    this.listener.onStateChange(-1, 0L, j, -106, "DownloadInfo.ERR_NET_NO_BODY");
                    com.up366.common.IOUtils.close(null);
                    com.up366.common.IOUtils.close(null);
                    return;
                }
                randomAccessFile = new java.io.RandomAccessFile(str2, "rwd");
                try {
                    randomAccessFile.seek(j2);
                    inputStreamByteStream = responseBodyBody.byteStream();
                    long jUptimeMillis = -1;
                    if (j == 0) {
                        java.lang.String strHeader = response.header("content-range");
                        java.lang.String strHeader2 = response.header("content-length");
                        if (com.up366.common.StringUtils.isEmptyOrNull(strHeader)) {
                            if (com.up366.common.StringUtils.isEmptyOrNull(strHeader2)) {
                                strHeader2 = "1";
                            }
                            j3 = java.lang.Long.parseLong(strHeader2);
                        } else {
                            j3 = java.lang.Long.parseLong(strHeader.split("/")[1]);
                        }
                    } else {
                        j3 = j;
                    }
                    long j4 = j2;
                    int i = -1;
                    while (true) {
                        try {
                            int i2 = inputStreamByteStream.read(bArr);
                            if (i2 == -1) {
                                this.listener.onStateChange(2, j4, j3, 0, null);
                                break;
                            }
                            if (this.requestStop) {
                                this.listener.onStateChange(3, 0L, j3, 0, "cancel");
                                com.up366.common.IOUtils.close(inputStreamByteStream);
                                com.up366.common.IOUtils.close(randomAccessFile);
                                return;
                            }
                            randomAccessFile.write(bArr, 0, i2);
                            long j5 = ((long) i2) + j4;
                            int i3 = (int) ((100 * j5) / j3);
                            long jUptimeMillis2 = android.os.SystemClock.uptimeMillis() - jUptimeMillis;
                            if (i3 != i && jUptimeMillis2 > 345) {
                                jUptimeMillis = android.os.SystemClock.uptimeMillis();
                                this.listener.onStateChange(1, j5, j3, 0, null);
                                i = i3;
                            }
                            j4 = j5;
                        } catch (java.lang.Exception e) {
                            e = e;
                            if (this.requestStop) {
                                this.listener.onStateChange(3, 0L, j3, 0, "cancel");
                                com.up366.common.IOUtils.close(inputStreamByteStream);
                                com.up366.common.IOUtils.close(randomAccessFile);
                                return;
                            }
                            com.up366.common.log.Logger.error("TAG - OKHttpDownloadImpl - onResponse - " + str3, e);
                            this.listener.onStateChange(-1, 0L, j3, -105, e.getMessage());
                            com.up366.common.IOUtils.close(inputStreamByteStream);
                            com.up366.common.IOUtils.close(randomAccessFile);
                            return;
                        }
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    j3 = j;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                com.up366.common.IOUtils.close(null);
                com.up366.common.IOUtils.close(null);
                throw th;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            j3 = j;
            randomAccessFile = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            com.up366.common.IOUtils.close(null);
            com.up366.common.IOUtils.close(null);
            throw th;
        }
    }

    public void requestStop() {
        this.requestStop = true;
        com.up366.common.log.Logger.info("TAG - OKHttpDownloadImpl - stop - " + this.info.getDownloadUrl());
    }

    public void setPrivateCloudHandle(com.up366.common.download.PrivateCloudHandle privateCloudHandle) {
        this.privateCloudHandle = privateCloudHandle;
    }
}
