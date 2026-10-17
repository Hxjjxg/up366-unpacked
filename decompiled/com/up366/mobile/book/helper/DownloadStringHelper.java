package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DownloadStringHelper {
    public void load(final java.lang.String str, final com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.DownloadStringHelper$$ExternalSyntheticLambda9
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$load$4(str, iCallbackCodeInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public /* synthetic */ void lambda$load$4(final java.lang.String str, final com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) throws java.lang.Exception {
        java.net.HttpURLConnection httpURLConnection;
        ?? r6;
        final java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                try {
                    httpURLConnection.setReadTimeout(3000);
                    final int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        str = httpURLConnection.getInputStream();
                        try {
                            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                        } catch (java.lang.Exception unused) {
                        }
                        try {
                            byte[] bArr = new byte[1024];
                            do {
                                int i = str.read(bArr);
                                if (i != -1) {
                                    byteArrayOutputStream.write(bArr, 0, i);
                                } else {
                                    com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.DownloadStringHelper$$ExternalSyntheticLambda0
                                        @Override // com.up366.common.task.Task
                                        public final void run() {
                                            iCallbackCodeInfo.onResult(0, new java.lang.String(byteArrayOutputStream.toByteArray()));
                                        }
                                    });
                                    byteArrayOutputStream2 = byteArrayOutputStream;
                                    r6 = str;
                                }
                            } while (byteArrayOutputStream.size() <= 102400);
                            com.up366.mobile.common.onlinelog.OpLog.report("Illegal-Download-String-Length", "Content-Length:" + httpURLConnection.getHeaderField("Content-Length"));
                            throw new java.lang.IllegalStateException();
                        } catch (java.lang.Exception unused2) {
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.DownloadStringHelper$$ExternalSyntheticLambda3
                                @Override // com.up366.common.task.Task
                                public final void run() {
                                    iCallbackCodeInfo.onResult(-1, null);
                                }
                            });
                            com.up366.mobile.common.utils.IOUtils.close(byteArrayOutputStream2);
                            com.up366.mobile.common.utils.IOUtils.close(str);
                            if (httpURLConnection == null) {
                                return;
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            com.up366.mobile.common.utils.IOUtils.close(byteArrayOutputStream2);
                            com.up366.mobile.common.utils.IOUtils.close(str);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } else {
                        if (responseCode == 302) {
                            java.lang.String headerField = httpURLConnection.getHeaderField("Location");
                            if (str.equals(headerField)) {
                                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.DownloadStringHelper$$ExternalSyntheticLambda1
                                    @Override // com.up366.common.task.Task
                                    public final void run() {
                                        iCallbackCodeInfo.onResult(-3, "responseCode:" + responseCode + " url:" + str);
                                    }
                                });
                            } else {
                                load(headerField, iCallbackCodeInfo);
                            }
                        } else {
                            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.DownloadStringHelper$$ExternalSyntheticLambda2
                                @Override // com.up366.common.task.Task
                                public final void run() {
                                    iCallbackCodeInfo.onResult(-2, "responseCode:" + responseCode);
                                }
                            });
                        }
                        r6 = 0;
                    }
                    com.up366.mobile.common.utils.IOUtils.close(byteArrayOutputStream2);
                    com.up366.mobile.common.utils.IOUtils.close(r6);
                    if (httpURLConnection == null) {
                        return;
                    }
                } catch (java.lang.Exception unused3) {
                    str = 0;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    str = 0;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.lang.Exception unused4) {
            str = 0;
            httpURLConnection = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            str = 0;
            httpURLConnection = null;
        }
        httpURLConnection.disconnect();
    }

    public static void load(final java.lang.String str, final java.lang.String str2, final com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.DownloadStringHelper$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.DownloadStringHelper.lambda$load$9(str2, str, iCallbackCodeInfo);
            }
        });
    }

    static /* synthetic */ void lambda$load$9(final java.lang.String str, final java.lang.String str2, final com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) throws java.lang.Exception {
        java.io.InputStream inputStream;
        java.net.HttpURLConnection httpURLConnection;
        final int responseCode;
        java.io.FileOutputStream fileOutputStream;
        byte[] bArr;
        com.up366.common.FileUtilsUp.mkdirParentDir(str);
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.common.global.GB.get().getHttpCacheDir(), "net", com.up366.common.digest.MD5.md5(str));
        com.up366.common.FileUtilsUp.mkdirParentDir(strJoin);
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str2).openConnection();
            try {
                httpURLConnection.setReadTimeout(3000);
                responseCode = httpURLConnection.getResponseCode();
            } catch (java.lang.Exception e) {
                e = e;
                inputStream = null;
            } catch (java.lang.Throwable th) {
                th = th;
                inputStream = null;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            inputStream = null;
            httpURLConnection = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStream = null;
            httpURLConnection = null;
        }
        if (responseCode == 200) {
            inputStream = httpURLConnection.getInputStream();
            try {
                try {
                    com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin);
                    fileOutputStream = new java.io.FileOutputStream(strJoin);
                } catch (java.lang.Exception e3) {
                    e = e3;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
            try {
                bArr = new byte[4096];
            } catch (java.lang.Exception e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                com.up366.common.log.Logger.error("TAG - 2018/7/14 - DownloadStringHelper - load - " + e.getMessage(), e);
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.DownloadStringHelper$$ExternalSyntheticLambda8
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        iCallbackCodeInfo.onResult(-1, e.getMessage());
                    }
                });
                com.up366.mobile.common.utils.IOUtils.close(fileOutputStream2);
                com.up366.mobile.common.utils.IOUtils.close(inputStream);
                if (httpURLConnection == null) {
                    return;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                fileOutputStream2 = fileOutputStream;
                com.up366.mobile.common.utils.IOUtils.close(fileOutputStream2);
                com.up366.mobile.common.utils.IOUtils.close(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i);
                }
                httpURLConnection.disconnect();
            }
            fileOutputStream.flush();
            com.up366.common.FileUtilsUp.copyFileOrDir(strJoin, str);
            com.up366.common.log.Logger.info("TAG - 2019/2/20 - DownloadStringHelper - load - ok! " + str);
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.DownloadStringHelper$$ExternalSyntheticLambda5
                @Override // com.up366.common.task.Task
                public final void run() {
                    iCallbackCodeInfo.onResult(0, str);
                }
            });
            fileOutputStream2 = fileOutputStream;
        } else {
            if (responseCode == 302) {
                java.lang.String headerField = httpURLConnection.getHeaderField("Location");
                if (str2.equals(headerField)) {
                    com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.DownloadStringHelper$$ExternalSyntheticLambda6
                        @Override // com.up366.common.task.Task
                        public final void run() {
                            iCallbackCodeInfo.onResult(-3, "responseCode:" + responseCode + " url:" + str2);
                        }
                    });
                } else {
                    load(headerField, str, iCallbackCodeInfo);
                }
            } else {
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.DownloadStringHelper$$ExternalSyntheticLambda7
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        iCallbackCodeInfo.onResult(-2, "responseCode:" + responseCode);
                    }
                });
            }
            inputStream = null;
        }
        com.up366.mobile.common.utils.IOUtils.close(fileOutputStream2);
        com.up366.mobile.common.utils.IOUtils.close(inputStream);
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.disconnect();
    }
}
