package com.up366.common.upload;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OkHttpUploadFile {
    private static final java.lang.String TAG = "OkHttpUploadImpl";
    private static final com.up366.common.upload.OkHttpUploadFile okHttpUploadFile = new com.up366.common.upload.OkHttpUploadFile();
    private okhttp3.OkHttpClient httpClient;

    private OkHttpUploadFile() {
        buildHttpClient();
    }

    private synchronized void buildHttpClient() {
        if (this.httpClient == null) {
            okhttp3.OkHttpClient.Builder builderWriteTimeout = new okhttp3.OkHttpClient.Builder().followRedirects(true).followSslRedirects(true).connectTimeout(30L, java.util.concurrent.TimeUnit.SECONDS).readTimeout(30L, java.util.concurrent.TimeUnit.SECONDS).writeTimeout(40L, java.util.concurrent.TimeUnit.SECONDS);
            if (com.up366.common.global.GB.get().getConfig().getBooleanValue("HTTP_DNS_SWITCH")) {
                builderWriteTimeout.dns(com.up366.common.http.OkHttpDns.getInstance());
            }
            this.httpClient = builderWriteTimeout.build();
        }
    }

    public static void post(final com.up366.common.upload.UpLoadFileParams upLoadFileParams) {
        if (com.up366.common.task.TaskUtils.isMainThread()) {
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.common.upload.OkHttpUploadFile.1
                @Override // com.up366.common.task.Task
                public void run() throws java.lang.Exception {
                    com.up366.common.upload.OkHttpUploadFile.okHttpUploadFile.upload(upLoadFileParams);
                }
            });
        } else {
            okHttpUploadFile.upload(upLoadFileParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upload(final com.up366.common.upload.UpLoadFileParams upLoadFileParams) {
        java.lang.String strCheckParams = checkParams(upLoadFileParams);
        if (!android.text.TextUtils.equals(strCheckParams, "")) {
            upLoadFileParams.uploadCallback(com.up366.common.upload.UpLoadFileParams.State.FAILED, 0L, 0L, strCheckParams);
            return;
        }
        final java.io.File file = new java.io.File(upLoadFileParams.getFilePath());
        final long length = file.length();
        okhttp3.RequestBody requestBody = new okhttp3.RequestBody() { // from class: com.up366.common.upload.OkHttpUploadFile.2
            public okhttp3.MediaType contentType() {
                return null;
            }

            public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                byte[] bArr = new byte[io.objectbox.model.PropertyFlags.INDEX_HASH];
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                long j = 0;
                int i = 0;
                while (true) {
                    try {
                        try {
                            int i2 = fileInputStream.read(bArr);
                            if (i2 == -1) {
                                break;
                            }
                            bufferedSink.write(bArr, 0, i2);
                            j += (long) i2;
                            int i3 = (int) ((100 * j) / length);
                            if ((i3 != i && java.lang.System.currentTimeMillis() - jCurrentTimeMillis > 345) || i3 == 100) {
                                jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                                upLoadFileParams.uploadCallback(com.up366.common.upload.UpLoadFileParams.State.UPLOADING, j, length, "");
                                i = i3;
                            }
                        } catch (java.lang.Exception e) {
                            com.up366.common.log.Logger.info("OkHttpUploadFile write to sink error " + e.getMessage());
                        }
                    } finally {
                        fileInputStream.close();
                    }
                }
            }
        };
        okhttp3.MultipartBody.Builder builder = new okhttp3.MultipartBody.Builder();
        java.util.HashMap map = new java.util.HashMap(0);
        upLoadFileParams.initParams(map);
        if (map.size() > 0) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                builder.addFormDataPart(entry.getKey(), entry.getValue());
            }
        }
        builder.setType(okhttp3.MultipartBody.FORM);
        builder.addFormDataPart(upLoadFileParams.getUploadFileKey(), file.getName(), requestBody);
        okhttp3.MultipartBody multipartBodyBuild = builder.build();
        java.util.HashMap map2 = new java.util.HashMap();
        upLoadFileParams.initHeaders(map2);
        okhttp3.Request requestBuild = new okhttp3.Request.Builder().url(upLoadFileParams.getUrl()).headers(okhttp3.Headers.of(map2)).post(multipartBodyBuild).build();
        upLoadFileParams.uploadCallback(com.up366.common.upload.UpLoadFileParams.State.START, 0L, length, "");
        this.httpClient.newCall(requestBuild).enqueue(new okhttp3.Callback() { // from class: com.up366.common.upload.OkHttpUploadFile.3
            public void onFailure(okhttp3.Call call, java.io.IOException iOException) {
                if (iOException instanceof java.net.SocketTimeoutException) {
                    upLoadFileParams.uploadCallback(com.up366.common.upload.UpLoadFileParams.State.FAILED, 0L, length, "网络错误，访问超时。");
                } else {
                    upLoadFileParams.uploadCallback(com.up366.common.upload.UpLoadFileParams.State.FAILED, 0L, length, "访问服务器失败，请检查网络。");
                }
            }

            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws java.io.IOException {
                if (response.isSuccessful()) {
                    com.up366.common.upload.UpLoadFileParams upLoadFileParams2 = upLoadFileParams;
                    com.up366.common.upload.UpLoadFileParams.State state = com.up366.common.upload.UpLoadFileParams.State.SUCCESS;
                    long j = length;
                    upLoadFileParams2.uploadCallback(state, j, j, "");
                    return;
                }
                upLoadFileParams.uploadCallback(com.up366.common.upload.UpLoadFileParams.State.FAILED, 0L, length, response.message());
            }
        });
    }

    private java.lang.String checkParams(com.up366.common.upload.UpLoadFileParams upLoadFileParams) {
        if (com.up366.common.StringUtils.isEmptyOrNull(upLoadFileParams.getUrl()) || com.up366.common.StringUtils.isEmptyOrNull(upLoadFileParams.getUploadFileKey()) || com.up366.common.StringUtils.isEmptyOrNull(upLoadFileParams.getFilePath())) {
            return "参数错误";
        }
        if (!new java.io.File(upLoadFileParams.getFilePath()).exists()) {
            return "文件不存在";
        }
        return "";
    }
}
