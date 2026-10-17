package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MultiFileDownloadManager {
    private com.up366.mobile.common.utils.MultiFileDownloadManager.IDownloadManagerCallback callback;
    private com.up366.common.download.DownloadInfo currentDownloadInfo;
    private final long initDownloadSize;
    private final java.util.List<com.up366.common.download.DownloadInfo> list = new java.util.ArrayList();
    private final java.util.Map<java.lang.String, java.lang.Long> currentSizeMap = new java.util.HashMap();
    private boolean checkPermission = true;
    private boolean checkNoneWifi = true;
    private androidx.arch.core.util.Function<com.up366.common.download.DownloadInfo, com.up366.common.download.DownloadInfo> downloadFailedHandler = new androidx.arch.core.util.Function() { // from class: com.up366.mobile.common.utils.MultiFileDownloadManager$$ExternalSyntheticLambda5
        public final java.lang.Object apply(java.lang.Object obj) {
            return com.up366.mobile.common.utils.MultiFileDownloadManager.lambda$new$0((com.up366.common.download.DownloadInfo) obj);
        }
    };
    private androidx.arch.core.util.Function<com.up366.common.download.DownloadInfo, com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo>> downloadSuccessHandler = new androidx.arch.core.util.Function() { // from class: com.up366.mobile.common.utils.MultiFileDownloadManager$$ExternalSyntheticLambda6
        public final java.lang.Object apply(java.lang.Object obj) {
            return com.up366.mobile.common.utils.MultiFileDownloadManager.lambda$new$1((com.up366.common.download.DownloadInfo) obj);
        }
    };

    public interface IDownloadManagerCallback {
        void onResult(int i, long j, long j2, int i2, java.lang.String str);
    }

    static /* synthetic */ com.up366.common.download.DownloadInfo lambda$new$0(com.up366.common.download.DownloadInfo downloadInfo) {
        if (downloadInfo.getDownType() == 17) {
            return com.up366.mobile.common.helper.AppResourceUpdateHelper.getAsesModelDownloadInfo().info;
        }
        return null;
    }

    static /* synthetic */ com.up366.common.http.NetHolder lambda$new$1(com.up366.common.download.DownloadInfo downloadInfo) {
        if (downloadInfo.getDownType() == 17) {
            return com.up366.mobile.common.helper.AppResourceUpdateHelper.getAsesModelDownloadInfo();
        }
        return null;
    }

    public MultiFileDownloadManager(long j) {
        this.initDownloadSize = j;
    }

    public void add(com.up366.common.download.DownloadInfo downloadInfo) {
        this.list.add(downloadInfo);
    }

    public long getTotalSize() {
        long fileSize = this.initDownloadSize;
        java.util.Iterator<com.up366.common.download.DownloadInfo> it = this.list.iterator();
        while (it.hasNext()) {
            fileSize += it.next().getFileSize();
        }
        return fileSize;
    }

    private long getCurrentSize() {
        long jLongValue = this.initDownloadSize;
        for (com.up366.common.download.DownloadInfo downloadInfo : this.list) {
            java.lang.Long lValueOf = this.currentSizeMap.get(downloadInfo.getKey());
            if (lValueOf == null) {
                lValueOf = 0L;
            }
            if (lValueOf.longValue() > downloadInfo.getFileSize()) {
                lValueOf = java.lang.Long.valueOf(downloadInfo.getFileSize());
            }
            jLongValue += lValueOf.longValue();
        }
        return jLongValue;
    }

    public long getHasSuccessSize() {
        long fileSize = this.initDownloadSize;
        for (com.up366.common.download.DownloadInfo downloadInfo : this.list) {
            if (downloadInfo.getState() == 4) {
                fileSize += downloadInfo.getFileSize();
            }
        }
        return fileSize;
    }

    public void startDownload() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.MultiFileDownloadManager$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$startDownload$8();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$startDownload$8() throws java.lang.Exception {
        com.up366.common.http.NetHolder netHolder;
        final int i;
        final java.lang.String str;
        com.up366.common.download.DownloadInfo downloadInfo;
        com.up366.common.log.Logger.info("TAG - MultiFileDownloadManager - startDownload - wait lock : " + this.list.size());
        synchronized (com.up366.mobile.common.utils.MultiFileDownloadManager.class) {
            com.up366.common.log.Logger.info("TAG - MultiFileDownloadManager - startDownload - get lock : " + this.list.size());
            if (this.list.size() == 0) {
                com.up366.common.log.Logger.warn("TAG - MultiFileDownloadManager - startDownload - list.size == 0");
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.MultiFileDownloadManager$$ExternalSyntheticLambda7
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        this.f$0.lambda$startDownload$2();
                    }
                });
                return;
            }
            com.up366.mobile.common.helper.AppResourceUpdateHelper appResourceUpdateHelper = com.up366.mobile.common.helper.AppResourceUpdateHelper.getInstance();
            int i2 = 0;
            while (i2 < this.list.size()) {
                boolean z = i2 + 1 == this.list.size();
                com.up366.common.download.DownloadInfo downloadInfo2 = this.list.get(i2);
                this.currentDownloadInfo = downloadInfo2;
                if (downloadInfo2.getDownType() == 15 && com.up366.common.FileUtilsUp.isFileExists(com.up366.asecengine.englishengine.AsesModelHelper.create().getModelDir())) {
                    com.up366.common.FileUtilsUp.deleteDirOrFile(com.up366.asecengine.englishengine.AsesModelHelper.create().getModelDir());
                }
                if (downloadInfo2.getDownType() == 15 || downloadInfo2.getDownType() == 17) {
                    com.up366.common.log.Logger.info("TAG - MultiFileDownloadManager - startDownload - getDownType : " + downloadInfo2.getDownType());
                    if (appResourceUpdateHelper.isUpdateAsesModelByAssets()) {
                        final long currentSize = getCurrentSize();
                        final long totalSize = getTotalSize();
                        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.MultiFileDownloadManager$$ExternalSyntheticLambda8
                            @Override // com.up366.common.task.Task
                            public final void run() throws java.lang.Exception {
                                this.f$0.lambda$startDownload$3(currentSize, totalSize);
                            }
                        });
                        boolean zInitAsesModelFromAssets = appResourceUpdateHelper.initAsesModelFromAssets(com.up366.asecengine.englishengine.AsesModelHelper.create().getModelDir(), downloadInfo2.getFileVersion());
                        com.up366.common.log.Logger.info("TAG - MultiFileDownloadManager - startDownload - initAsesModelFromAssets success : " + zInitAsesModelFromAssets);
                        if (zInitAsesModelFromAssets) {
                            this.currentSizeMap.put(downloadInfo2.getKey(), java.lang.Long.valueOf(downloadInfo2.getFileSize()));
                            if (z) {
                                final long currentSize2 = getCurrentSize();
                                final long totalSize2 = getTotalSize();
                                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.MultiFileDownloadManager$$ExternalSyntheticLambda9
                                    @Override // com.up366.common.task.Task
                                    public final void run() throws java.lang.Exception {
                                        this.f$0.lambda$startDownload$4(currentSize2, totalSize2);
                                    }
                                });
                            }
                            i2++;
                        } else if (com.up366.common.FileUtilsUp.isFileExists(com.up366.asecengine.englishengine.AsesModelHelper.create().getModelDir())) {
                            com.up366.common.FileUtilsUp.deleteDirOrFile(com.up366.asecengine.englishengine.AsesModelHelper.create().getModelDir());
                        }
                    }
                }
                final com.up366.common.http.NetHolder<java.lang.Object> netHolderDownloadSync = downloadSync(z, downloadInfo2, this.callback);
                this.currentDownloadInfo = null;
                if (netHolderDownloadSync.resp.getCode() == 6) {
                    break;
                }
                final long currentSize3 = getCurrentSize();
                final long totalSize3 = getTotalSize();
                if (netHolderDownloadSync.resp.isError()) {
                    androidx.arch.core.util.Function<com.up366.common.download.DownloadInfo, com.up366.common.download.DownloadInfo> function = this.downloadFailedHandler;
                    if (function != null && (downloadInfo = (com.up366.common.download.DownloadInfo) function.apply(downloadInfo2)) != null) {
                        this.list.set(i2, downloadInfo);
                    } else {
                        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.MultiFileDownloadManager$$ExternalSyntheticLambda10
                            @Override // com.up366.common.task.Task
                            public final void run() throws java.lang.Exception {
                                this.f$0.lambda$startDownload$5(currentSize3, totalSize3, netHolderDownloadSync);
                            }
                        });
                        return;
                    }
                } else {
                    androidx.arch.core.util.Function<com.up366.common.download.DownloadInfo, com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo>> function2 = this.downloadSuccessHandler;
                    if (function2 != null && (netHolder = (com.up366.common.http.NetHolder) function2.apply(downloadInfo2)) != null) {
                        if (!netHolder.resp.isError() && netHolder.info != 0) {
                            if (!applyDiffPatch(downloadInfo2.getFilePath(), ((com.up366.common.download.DownloadInfo) netHolder.info).getFilePath())) {
                                this.list.set(i2, (com.up366.common.download.DownloadInfo) netHolder.info);
                            }
                        }
                        com.up366.common.log.Logger.error("TAG - MultiFileDownloadManager - startDownload - downloadSuccessHandler :" + netHolder.resp.toString() + " info:" + netHolder.info);
                        int code = netHolder.resp.getCode();
                        java.lang.String info = netHolder.resp.getInfo();
                        if (netHolder.info == 0) {
                            str = "获取全量包失败";
                            i = -3;
                        } else {
                            i = code;
                            str = info;
                        }
                        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.MultiFileDownloadManager$$ExternalSyntheticLambda11
                            @Override // com.up366.common.task.Task
                            public final void run() throws java.lang.Exception {
                                this.f$0.lambda$startDownload$6(currentSize3, totalSize3, i, str);
                            }
                        });
                        return;
                    }
                    if (z) {
                        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.MultiFileDownloadManager$$ExternalSyntheticLambda1
                            @Override // com.up366.common.task.Task
                            public final void run() throws java.lang.Exception {
                                this.f$0.lambda$startDownload$7(currentSize3, totalSize3);
                            }
                        });
                    }
                    i2++;
                }
                i2--;
                i2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startDownload$2() throws java.lang.Exception {
        this.callback.onResult(4, 100L, 100L, 0, "success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startDownload$3(long j, long j2) throws java.lang.Exception {
        this.callback.onResult(1, j, j2, 0, "loading");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startDownload$4(long j, long j2) throws java.lang.Exception {
        this.callback.onResult(4, j, j2, 0, "success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startDownload$5(long j, long j2, com.up366.common.http.NetHolder netHolder) throws java.lang.Exception {
        this.callback.onResult(5, j, j2, netHolder.resp.getCode(), netHolder.resp.getInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startDownload$6(long j, long j2, int i, java.lang.String str) throws java.lang.Exception {
        this.callback.onResult(5, j, j2, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startDownload$7(long j, long j2) throws java.lang.Exception {
        this.callback.onResult(4, j, j2, 0, "success");
    }

    private boolean applyDiffPatch(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        boolean z = false;
        try {
            long jUptimeMillis = android.os.SystemClock.uptimeMillis();
            com.alibaba.fastjson.JSONArray array = com.alibaba.fastjson.JSON.parseArray(com.up366.common.FileUtilsUp.getFileContent(com.up366.common.FileUtilsUp.join(str, "filePath.json")));
            for (int i = 0; i < array.size(); i++) {
                java.lang.String string = array.getJSONObject(i).getString(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
                java.lang.String strJoin = com.up366.common.FileUtilsUp.join(str, string);
                java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(str2, string);
                if (!com.up366.common.FileUtilsUp.isFileExists(strJoin)) {
                    if (!com.up366.common.FileUtilsUp.isFileExists(strJoin2)) {
                        com.up366.common.log.Logger.error("TAG - MultiFileDownloadManager - applyDiffPatch - no origin file :" + strJoin2);
                        com.up366.common.FileUtilsUp.deleteDirOrFile(str);
                        return false;
                    }
                    if (com.up366.common.FileUtilsUp.isDir(strJoin2)) {
                        com.up366.common.log.Logger.error("TAG - MultiFileDownloadManager - applyDiffPatch - origin file is dir :" + strJoin2);
                        com.up366.common.FileUtilsUp.deleteDirOrFile(str);
                        return false;
                    }
                    com.up366.common.FileUtilsUp.copyFileOrDir(new java.io.File(strJoin2), new java.io.File(strJoin));
                }
            }
            int i2 = 0;
            while (i2 < array.size()) {
                com.alibaba.fastjson.JSONObject jSONObject = array.getJSONObject(i2);
                java.lang.String string2 = jSONObject.getString(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
                long longValue = jSONObject.getLongValue("size");
                java.lang.String string3 = jSONObject.getString("md5");
                java.lang.String strJoin3 = com.up366.common.FileUtilsUp.join(str, string2);
                if (!com.up366.common.FileUtilsUp.isFileExists(strJoin3)) {
                    com.up366.common.log.Logger.error("TAG - MultiFileDownloadManager - applyDiffPatch - before - file not exists : file:" + strJoin3);
                    com.up366.common.FileUtilsUp.deleteDirOrFile(str);
                    return z;
                }
                java.io.File file = new java.io.File(strJoin3);
                long j = jUptimeMillis;
                long length = file.length();
                if (longValue != length) {
                    com.up366.common.log.Logger.error("TAG - MultiFileDownloadManager - applyDiffPatch - before - patch file size is :" + length + " require:" + longValue + " file:" + strJoin3);
                    com.up366.common.FileUtilsUp.deleteDirOrFile(str);
                    return false;
                }
                java.lang.String strMd5 = com.up366.common.digest.MD5.md5(file);
                if (!strMd5.equalsIgnoreCase(string3)) {
                    com.up366.common.log.Logger.error("TAG - MultiFileDownloadManager - applyDiffPatch - before - patch file md5 is :" + strMd5 + " require:" + string3 + " file:" + strJoin3);
                    com.up366.common.FileUtilsUp.deleteDirOrFile(str);
                    return false;
                }
                i2++;
                jUptimeMillis = j;
                z = false;
            }
            long j2 = jUptimeMillis;
            com.up366.common.FileUtilsUp.deleteDirOrFile(str2);
            com.up366.common.FileUtilsUp.copyFileOrDir(str, str2);
            com.up366.common.FileUtilsUp.deleteDirOrFile(str);
            for (int i3 = 0; i3 < array.size(); i3++) {
                com.alibaba.fastjson.JSONObject jSONObject2 = array.getJSONObject(i3);
                java.lang.String string4 = jSONObject2.getString(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
                long longValue2 = jSONObject2.getLongValue("size");
                java.lang.String string5 = jSONObject2.getString("md5");
                java.lang.String strJoin4 = com.up366.common.FileUtilsUp.join(str2, string4);
                if (!com.up366.common.FileUtilsUp.isFileExists(strJoin4)) {
                    com.up366.common.log.Logger.error("TAG - MultiFileDownloadManager - applyDiffPatch - after - file not exists : file:" + strJoin4);
                    return false;
                }
                java.io.File file2 = new java.io.File(strJoin4);
                long length2 = file2.length();
                if (longValue2 != length2) {
                    com.up366.common.log.Logger.error("TAG - MultiFileDownloadManager - applyDiffPatch - after - file size is :" + length2 + " require:" + longValue2 + " file:" + strJoin4);
                    return false;
                }
                java.lang.String strMd52 = com.up366.common.digest.MD5.md5(file2);
                if (!strMd52.equalsIgnoreCase(string5)) {
                    com.up366.common.log.Logger.error("TAG - MultiFileDownloadManager - applyDiffPatch - after - file md5 is :" + strMd52 + " require:" + string5 + " file:" + strJoin4);
                    return false;
                }
            }
            com.up366.common.log.Logger.info("TAG - MultiFileDownloadManager - applyDiffPatch - success : time : " + (android.os.SystemClock.uptimeMillis() - j2));
            return true;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - MultiFileDownloadManager - applyDiffPatch - ", e);
            return false;
        }
    }

    private com.up366.common.http.NetHolder<java.lang.Object> downloadSync(final boolean z, final com.up366.common.download.DownloadInfo downloadInfo, final com.up366.mobile.common.utils.MultiFileDownloadManager.IDownloadManagerCallback iDownloadManagerCallback) throws java.lang.InterruptedException {
        if (downloadInfo.getDownType() == 2) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(downloadInfo.getFilePath());
        }
        final com.up366.common.http.NetHolder<java.lang.Object> netHolder = new com.up366.common.http.NetHolder<>();
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final com.up366.mobile.common.utils.WatchDog watchDog = new com.up366.mobile.common.utils.WatchDog(60000L, new java.lang.Runnable() { // from class: com.up366.mobile.common.utils.MultiFileDownloadManager$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.common.utils.MultiFileDownloadManager.lambda$downloadSync$9(downloadInfo, netHolder, countDownLatch);
            }
        });
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.MultiFileDownloadManager$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$downloadSync$11(downloadInfo, watchDog, iDownloadManagerCallback, netHolder, countDownLatch, z);
            }
        });
        countDownLatch.await();
        watchDog.cancel();
        return netHolder;
    }

    static /* synthetic */ void lambda$downloadSync$9(com.up366.common.download.DownloadInfo downloadInfo, com.up366.common.http.NetHolder netHolder, java.util.concurrent.CountDownLatch countDownLatch) {
        com.up366.mobile.common.onlinelog.OpLog.report("ERROR_download_sync_timeout", downloadInfo.toString());
        netHolder.initWith(new com.up366.common.http.Response(5, "", "Download timeout", 0, null), downloadInfo);
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadSync$11(final com.up366.common.download.DownloadInfo downloadInfo, final com.up366.mobile.common.utils.WatchDog watchDog, final com.up366.mobile.common.utils.MultiFileDownloadManager.IDownloadManagerCallback iDownloadManagerCallback, final com.up366.common.http.NetHolder netHolder, final java.util.concurrent.CountDownLatch countDownLatch, final boolean z) throws java.lang.Exception {
        com.up366.mobile.common.utils.DownloadHelper.add(this.checkPermission, this.checkNoneWifi, getTotalSize(), downloadInfo, new com.up366.common.download.DownloadManager.IDownloadCallback() { // from class: com.up366.mobile.common.utils.MultiFileDownloadManager$$ExternalSyntheticLambda0
            @Override // com.up366.common.download.DownloadManager.IDownloadCallback
            public final void onStateChange(java.lang.String str, int i, int i2, java.lang.String str2, long j, long j2, int i3, java.lang.String str3) {
                this.f$0.lambda$downloadSync$10(watchDog, downloadInfo, iDownloadManagerCallback, netHolder, countDownLatch, z, str, i, i2, str2, j, j2, i3, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadSync$10(com.up366.mobile.common.utils.WatchDog watchDog, com.up366.common.download.DownloadInfo downloadInfo, com.up366.mobile.common.utils.MultiFileDownloadManager.IDownloadManagerCallback iDownloadManagerCallback, com.up366.common.http.NetHolder netHolder, java.util.concurrent.CountDownLatch countDownLatch, boolean z, java.lang.String str, int i, int i2, java.lang.String str2, long j, long j2, int i3, java.lang.String str3) {
        int i4 = i;
        watchDog.feed();
        if (i4 == 2 && j != 0) {
            this.currentSizeMap.put(str, java.lang.Long.valueOf(j));
        }
        com.up366.mobile.common.utils.FileDownloadRecord.record(downloadInfo);
        long currentSize = getCurrentSize();
        long totalSize = getTotalSize();
        switch (i4) {
            case 0:
            case 2:
                iDownloadManagerCallback.onResult(i, currentSize, totalSize, i3, str3);
                break;
            case 1:
                if (currentSize != 0) {
                    i4 = 2;
                }
                iDownloadManagerCallback.onResult(i4, currentSize, totalSize, i3, str3);
                break;
            case 3:
                if (z) {
                    iDownloadManagerCallback.onResult(i, currentSize, totalSize, i3, str3);
                }
                break;
            case 4:
                this.currentSizeMap.put(str, java.lang.Long.valueOf(downloadInfo.getFileSize()));
                netHolder.initWith(new com.up366.common.http.Response(0, "", "", 0, null), downloadInfo);
                countDownLatch.countDown();
                break;
            case 5:
                java.lang.String str4 = com.up366.mobile.book.helper.Tools.alarmLogTrackContext.fileId;
                java.lang.String downloadUrl = downloadInfo.getDownloadUrl();
                if (downloadUrl != null && str4 != null && downloadUrl.contains(str4)) {
                    com.up366.mobile.book.helper.Tools.alarmLogTrackContext.url = downloadInfo.ext.redirectUrl;
                    com.up366.mobile.book.helper.Tools.alarmLogTrackContext.ipAddress = downloadInfo.ext.ipAddress;
                    com.up366.mobile.book.helper.Tools.alarmLogTrackContext.msg = str3;
                    if (i3 == -108) {
                        com.up366.mobile.book.helper.Tools.alarmLogTrackContext.md5 = downloadInfo.getFileMD5();
                        com.up366.mobile.book.helper.Tools.alarmLogTrackContext.localMd5 = downloadInfo.ext.downloadFileMD5;
                        com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004002005));
                    } else if (i3 == -111) {
                        com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004002006));
                    } else {
                        com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004002004));
                    }
                }
                netHolder.initWith(new com.up366.common.http.Response(i3, "", str3, 0, null), downloadInfo);
                countDownLatch.countDown();
                break;
            case 6:
                iDownloadManagerCallback.onResult(i, currentSize, totalSize, i3, str3);
                netHolder.initWith(new com.up366.common.http.Response(6, "", str3, 0, null), downloadInfo);
                countDownLatch.countDown();
                break;
            case 7:
                break;
            default:
                com.up366.common.log.Logger.error("TAG - MultiFileDownloadManager - onDownloadEvent - unknown:" + i4);
                break;
        }
    }

    public void setCallback(com.up366.mobile.common.utils.MultiFileDownloadManager.IDownloadManagerCallback iDownloadManagerCallback) {
        this.callback = iDownloadManagerCallback;
    }

    public void setCheckPermission(boolean z) {
        this.checkPermission = z;
    }

    public void setCheckNoneWifi(boolean z) {
        this.checkNoneWifi = z;
    }

    public void setDownloadFailedHandler(androidx.arch.core.util.Function<com.up366.common.download.DownloadInfo, com.up366.common.download.DownloadInfo> function) {
        this.downloadFailedHandler = function;
    }

    public void setDownloadSuccessHandler(androidx.arch.core.util.Function<com.up366.common.download.DownloadInfo, com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo>> function) {
        this.downloadSuccessHandler = function;
    }

    public com.up366.common.download.DownloadInfo getCurrentDownloadInfo() {
        return this.currentDownloadInfo;
    }
}
