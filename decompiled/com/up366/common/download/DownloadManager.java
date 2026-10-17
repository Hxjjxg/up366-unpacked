package com.up366.common.download;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DownloadManager {
    private static com.up366.common.download.DownloadManager instance = null;
    private static int parallelDownloadSize = 2;
    private com.up366.common.download.DownloadExtResolver extResolver;
    private com.up366.common.download.PrivateCloudHandle privateCloudHandle = new com.up366.common.download.PrivateCloudHandle();
    private final java.util.Map<java.lang.String, com.up366.common.download.DownloadManager.Holder> holderMap = new java.util.concurrent.ConcurrentHashMap();

    public interface IDownloadCallback {
        void onStateChange(java.lang.String str, int i, int i2, java.lang.String str2, long j, long j2, int i3, java.lang.String str3);
    }

    private DownloadManager() {
    }

    public static com.up366.common.download.DownloadManager getInstance() {
        if (instance == null) {
            synchronized (com.up366.common.download.DownloadManager.class) {
                if (instance == null) {
                    instance = new com.up366.common.download.DownloadManager();
                }
            }
        }
        return instance;
    }

    public int getQueueSize() {
        return this.holderMap.size();
    }

    public void setParallelDownloadSize(int i) {
        if (i < 1) {
            return;
        }
        parallelDownloadSize = i;
        com.up366.common.download.OKHttpDownloadImpl.setMaxNetworkRequestCount(i);
        com.up366.common.log.Logger.info("TAG - DownloadManager - setParallelDownloadSize - parallelDownloadSize = [" + parallelDownloadSize + "]");
    }

    public com.up366.common.download.DownloadInfo getDownloadInfo(java.lang.String str) {
        if (this.holderMap.get(str) == null) {
            return null;
        }
        return this.holderMap.get(str).info;
    }

    public void addDownload(com.up366.common.download.DownloadInfo downloadInfo) {
        addDownload(downloadInfo, null);
    }

    public void addDownload(final com.up366.common.download.DownloadInfo downloadInfo, com.up366.common.download.DownloadManager.IDownloadCallback iDownloadCallback) {
        if (checkDownloadInfo(downloadInfo, iDownloadCallback)) {
            if (downloadInfo.getAddTime() <= 0) {
                downloadInfo.setAddTime(java.lang.System.currentTimeMillis());
            }
            java.lang.String key = downloadInfo.getKey();
            final com.up366.common.download.DownloadManager.Holder holder = new com.up366.common.download.DownloadManager.Holder(key, downloadInfo, iDownloadCallback);
            this.holderMap.put(key, holder);
            postDownloadStateUpdate(holder, 1, 0L, downloadInfo.getFileSize(), 0, "wait");
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.common.download.DownloadManager$$ExternalSyntheticLambda4
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$addDownload$0(holder, downloadInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addDownload$0(com.up366.common.download.DownloadManager.Holder holder, com.up366.common.download.DownloadInfo downloadInfo) throws java.lang.Exception {
        try {
            pickAndStartDownload();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - DownloadManager - addDownload - run - error : ", e);
            postDownloadStateUpdate(holder, 5, 0L, downloadInfo.getFileSize(), com.up366.common.download.DownloadInfo.ERR_UNKNOWN, e.getMessage());
            com.up366.common.global.GB.get().sendLog("base-download-add-error", android.util.Log.getStackTraceString(e));
        }
    }

    public void pauseDownload(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - DownloadManager - pauseDownload - key = [" + str + "]");
        com.up366.common.download.DownloadManager.Holder holder = this.holderMap.get(str);
        if (holder != null) {
            holder.cancel = true;
            if (holder.httpDownload != null) {
                holder.httpDownload.requestStop();
            }
        }
    }

    public void pauseAllDownload() {
        com.up366.common.log.Logger.info("TAG - DownloadManager - pauseAllDownload - ");
        synchronized (com.up366.common.download.DownloadManager.class) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.up366.common.download.DownloadManager.Holder>> it = this.holderMap.entrySet().iterator();
            while (it.hasNext()) {
                com.up366.common.download.DownloadManager.Holder value = it.next().getValue();
                value.cancel = true;
                if (value.httpDownload != null) {
                    value.httpDownload.requestStop();
                }
            }
        }
    }

    public void setPrivateCloudHandle(com.up366.common.download.PrivateCloudHandle privateCloudHandle) {
        this.privateCloudHandle = privateCloudHandle;
    }

    public void setExtResolver(com.up366.common.download.DownloadExtResolver downloadExtResolver) {
        this.extResolver = downloadExtResolver;
    }

    private boolean checkDownloadInfo(com.up366.common.download.DownloadInfo downloadInfo, com.up366.common.download.DownloadManager.IDownloadCallback iDownloadCallback) {
        if (downloadInfo == null) {
            com.up366.common.log.Logger.error("addDownload DownloadInfo is null", new java.lang.IllegalStateException("DownloadInfo is null ..."));
            postDownloadStateUpdate(new com.up366.common.download.DownloadManager.Holder(com.igexin.push.core.b.m, null, iDownloadCallback), 5, 0L, 0L, -100, "DownloadInfo is null");
            return false;
        }
        java.lang.String key = downloadInfo.getKey();
        com.up366.common.download.DownloadManager.Holder holderRemove = this.holderMap.remove(key);
        if (holderRemove != null) {
            holderRemove.replace = true;
            holderRemove.cancel = true;
            if (holderRemove.httpDownload != null) {
                holderRemove.httpDownload.requestStop();
            }
            postDownloadStateUpdate(holderRemove, 8, 0L, downloadInfo.getFileSize(), 0, com.up366.mobile.common.onlinelog.OpLogData.Control.NAVIGATION_REPLACE);
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(downloadInfo.getDownloadUrl())) {
            com.up366.common.log.Logger.error("addDownload error :  downUrl is null, key is " + downloadInfo.getKey());
            postDownloadStateUpdate(new com.up366.common.download.DownloadManager.Holder(key, downloadInfo, iDownloadCallback), 5, 0L, 0L, -101, "下载地址为空！");
            return false;
        }
        if (com.up366.common.FileUtilsUp.getExternalStoreAvailableSize() < 31457280) {
            com.up366.common.log.Logger.error("addDownload error :  not enough storage space, key is " + downloadInfo.getKey());
            postDownloadStateUpdate(new com.up366.common.download.DownloadManager.Holder(key, downloadInfo, iDownloadCallback), 5, 0L, 0L, -102, "存储空间不足！");
            return false;
        }
        if (com.up366.common.NetworkUtilsUp.isConnected()) {
            return true;
        }
        com.up366.common.log.Logger.error("addDownload error :  NetworkUtilsUp.isConnected() is false. key is " + downloadInfo.getKey());
        postDownloadStateUpdate(new com.up366.common.download.DownloadManager.Holder(key, downloadInfo, iDownloadCallback), 5, 0L, 0L, -103, "网络未连接！");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pickAndStartDownload() {
        com.up366.common.download.DownloadManager.Holder holder;
        synchronized (com.up366.common.download.DownloadManager.class) {
            if (getCurrentDownloadSize() < parallelDownloadSize) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator<java.util.Map.Entry<java.lang.String, com.up366.common.download.DownloadManager.Holder>> it = this.holderMap.entrySet().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getValue());
                }
                java.util.Collections.sort(arrayList, new java.util.Comparator() { // from class: com.up366.common.download.DownloadManager$$ExternalSyntheticLambda3
                    @Override // java.util.Comparator
                    public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                        return com.up366.common.download.DownloadManager.lambda$pickAndStartDownload$1((com.up366.common.download.DownloadManager.Holder) obj, (com.up366.common.download.DownloadManager.Holder) obj2);
                    }
                });
                java.util.Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        holder = null;
                        break;
                    } else {
                        holder = (com.up366.common.download.DownloadManager.Holder) it2.next();
                        if (canStart(holder)) {
                            break;
                        }
                    }
                }
                if (holder != null) {
                    startDownload(holder.info);
                }
            }
        }
    }

    static /* synthetic */ int lambda$pickAndStartDownload$1(com.up366.common.download.DownloadManager.Holder holder, com.up366.common.download.DownloadManager.Holder holder2) {
        int iCompare = java.lang.Integer.compare(holder2.info.getDownOrder(), holder.info.getDownOrder());
        return iCompare == 0 ? java.lang.Long.compare(holder2.info.getAddTime(), holder.info.getAddTime()) : iCompare;
    }

    private boolean canStart(com.up366.common.download.DownloadManager.Holder holder) {
        return (holder == null || holder.info == null || holder.downloading || holder.cancel || holder.success || holder.failed || holder.info.getState() >= 2) ? false : true;
    }

    private void startDownload(final com.up366.common.download.DownloadInfo downloadInfo) {
        com.up366.common.log.Logger.info("TAG - DownloadManager - startDownload - info = [" + downloadInfo + "]");
        final com.up366.common.download.DownloadManager.Holder holder = this.holderMap.get(downloadInfo.getKey());
        if (holder == null) {
            com.up366.common.log.Logger.warn("TAG - DownloadManager - startDownload - holderMap.get(info.getKey()) == null");
            return;
        }
        downloadInfo.setState(2);
        postDownloadStateUpdate(holder, 2, 0L, downloadInfo.getFileSize(), 0, "start");
        holder.downloading = true;
        com.up366.common.download.OKHttpDownloadImpl oKHttpDownloadImpl = new com.up366.common.download.OKHttpDownloadImpl(downloadInfo);
        oKHttpDownloadImpl.setPrivateCloudHandle(this.privateCloudHandle);
        holder.httpDownload = oKHttpDownloadImpl;
        oKHttpDownloadImpl.setCallback(new com.up366.common.download.IDownloadStateChangeListener() { // from class: com.up366.common.download.DownloadManager$$ExternalSyntheticLambda6
            @Override // com.up366.common.download.IDownloadStateChangeListener
            public final void onStateChange(int i, long j, long j2, int i2, java.lang.String str) throws java.lang.Throwable {
                this.f$0.lambda$startDownload$2(downloadInfo, holder, i, j, j2, i2, str);
            }
        });
        oKHttpDownloadImpl.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startDownload$2(com.up366.common.download.DownloadInfo downloadInfo, com.up366.common.download.DownloadManager.Holder holder, int i, long j, long j2, int i2, java.lang.String str) throws java.lang.Throwable {
        int iHandleOnError;
        int i3;
        if (i == -1) {
            iHandleOnError = handleOnError(downloadInfo, holder);
        } else {
            iHandleOnError = 1;
            if (i != 0) {
                if (i == 1) {
                    i3 = 2;
                } else if (i != 2) {
                    if (i != 3) {
                        throw new java.lang.IllegalStateException("unknown state : " + i);
                    }
                    iHandleOnError = 6;
                } else {
                    if (downloadInfo.isNeedCheck()) {
                        startCheckFile(downloadInfo, holder);
                        return;
                    }
                    if (downloadInfo.isNeedUnzip()) {
                        startUnZipFile(downloadInfo, holder);
                        return;
                    }
                    if (com.up366.common.FileUtilsUp.isFileExists(downloadInfo.getFilePath())) {
                        com.up366.common.FileUtilsUp.deleteDirOrFile(downloadInfo.getFilePath());
                    }
                    if (!new java.io.File(downloadInfo.getFileTempPath()).renameTo(new java.io.File(downloadInfo.getFilePath()))) {
                        com.up366.common.FileUtilsUp.copyFileOrDir(downloadInfo.getFileTempPath(), downloadInfo.getFilePath());
                    }
                    com.up366.common.FileUtilsUp.deleteDirOrFile(downloadInfo.getFileTempPath());
                    if (!com.up366.common.FileUtilsUp.isFileExists(downloadInfo.getFilePath())) {
                        throw new java.lang.IllegalStateException("文件重命名失败！");
                    }
                    holder.success = true;
                    iHandleOnError = 4;
                }
            }
            postDownloadStateUpdate(holder, i3, j, j2, i2, str);
        }
        i3 = iHandleOnError;
        postDownloadStateUpdate(holder, i3, j, j2, i2, str);
    }

    private void postDownloadStateUpdate(final com.up366.common.download.DownloadManager.Holder holder, final int i, final long j, final long j2, final int i2, final java.lang.String str) {
        if (!holder.replace || i == 8) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.common.download.DownloadManager$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$postDownloadStateUpdate$3(holder, i, j, j2, i2, str);
                }
            });
            if (i == 4 || i == 5 || i == 6) {
                if (holder.cancel || holder.success || holder.failed) {
                    this.holderMap.remove(holder.key);
                }
                com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.common.download.DownloadManager$$ExternalSyntheticLambda2
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        this.f$0.pickAndStartDownload();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postDownloadStateUpdate$3(com.up366.common.download.DownloadManager.Holder holder, int i, long j, long j2, int i2, java.lang.String str) throws java.lang.Exception {
        int i3;
        java.lang.String name;
        com.up366.common.download.DownloadInfo downloadInfo = holder.info;
        if (downloadInfo == null) {
            i3 = -1;
            name = com.igexin.push.core.b.m;
        } else {
            downloadInfo.setState(i);
            int downType = downloadInfo.getDownType();
            name = downloadInfo.getName();
            i3 = downType;
        }
        com.up366.common.EventBusUtilsUp.post(new com.up366.common.event.DownloadEvent(holder.key, i, i3, name, j, j2, i2, str));
        if (holder.callback != null) {
            holder.callback.onStateChange(holder.key, i, i3, name, j, j2, i2, str);
        }
        com.up366.common.download.PrivateCloudHandle privateCloudHandle = this.privateCloudHandle;
        if (privateCloudHandle != null) {
            privateCloudHandle.onDownloadStateChange(holder.key, i);
        }
    }

    private void startUnZipFile(final com.up366.common.download.DownloadInfo downloadInfo, final com.up366.common.download.DownloadManager.Holder holder) {
        java.lang.String str;
        int i;
        java.lang.String key = downloadInfo.getKey();
        java.lang.String fileTempPath = downloadInfo.getFileTempPath();
        java.lang.String filePath = downloadInfo.getFilePath();
        if (downloadInfo.ext != null) {
            str = downloadInfo.ext.extSign;
            i = downloadInfo.ext.extType;
        } else {
            str = null;
            i = 0;
        }
        int i2 = i;
        com.up366.common.download.UnzipEngine unzipEngine = new com.up366.common.download.UnzipEngine(key, filePath, fileTempPath, downloadInfo.getFileVersion(), str, i2, this.extResolver);
        unzipEngine.setListener(new com.up366.common.download.IUnZipListener() { // from class: com.up366.common.download.DownloadManager$$ExternalSyntheticLambda5
            @Override // com.up366.common.download.IUnZipListener
            public final void onUnzip(java.lang.String str2, int i3, int i4, int i5, int i6, java.lang.String str3) {
                this.f$0.lambda$startUnZipFile$4(downloadInfo, holder, str2, i3, i4, i5, i6, str3);
            }
        });
        unzipEngine.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startUnZipFile$4(com.up366.common.download.DownloadInfo downloadInfo, com.up366.common.download.DownloadManager.Holder holder, java.lang.String str, int i, int i2, int i3, int i4, java.lang.String str2) {
        int i5;
        int iHandleOnError;
        int i6;
        if (i == 0) {
            i5 = 3;
        } else {
            if (i != 1) {
                if (i == 2) {
                    i6 = i2;
                    iHandleOnError = handleOnError(downloadInfo, holder);
                    postDownloadStateUpdate(holder, iHandleOnError, i6, i3, i4, str2);
                } else {
                    throw new java.lang.IllegalStateException("un known state :" + i);
                }
            }
            holder.success = true;
            i5 = 4;
        }
        iHandleOnError = i5;
        i6 = i2;
        postDownloadStateUpdate(holder, iHandleOnError, i6, i3, i4, str2);
    }

    private int handleOnError(com.up366.common.download.DownloadInfo downloadInfo, com.up366.common.download.DownloadManager.Holder holder) {
        java.lang.String fixedDownloadUrl = downloadInfo.getFixedDownloadUrl();
        if (!com.up366.common.StringUtils.isEmptyOrNull(fixedDownloadUrl)) {
            downloadInfo.setDownloadUrl(fixedDownloadUrl);
            startDownload(downloadInfo);
            return 7;
        }
        holder.failed = true;
        return 5;
    }

    private void startCheckFile(final com.up366.common.download.DownloadInfo downloadInfo, final com.up366.common.download.DownloadManager.Holder holder) {
        com.up366.common.download.FileCheckHelper fileCheckHelper = new com.up366.common.download.FileCheckHelper(downloadInfo.getFileTempPath(), downloadInfo.getFileMD5(), downloadInfo.getFileSize(), downloadInfo.ext);
        fileCheckHelper.setCallback(new com.up366.common.download.FileCheckHelper.ICheckResult() { // from class: com.up366.common.download.DownloadManager$$ExternalSyntheticLambda0
            @Override // com.up366.common.download.FileCheckHelper.ICheckResult
            public final void onCheckResult(int i, int i2, java.lang.String str) throws java.lang.Throwable {
                this.f$0.lambda$startCheckFile$5(downloadInfo, holder, i, i2, str);
            }
        });
        fileCheckHelper.check();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCheckFile$5(com.up366.common.download.DownloadInfo downloadInfo, com.up366.common.download.DownloadManager.Holder holder, int i, int i2, java.lang.String str) throws java.lang.Throwable {
        int iHandleOnError;
        if (i == -1) {
            iHandleOnError = handleOnError(downloadInfo, holder);
        } else if (i == 0) {
            if (downloadInfo.isNeedUnzip()) {
                postDownloadStateUpdate(holder, 3, 0L, 100L, i2, str);
                startUnZipFile(downloadInfo, holder);
                return;
            }
            if (com.up366.common.FileUtilsUp.isFileExists(downloadInfo.getFilePath())) {
                com.up366.common.FileUtilsUp.deleteDirOrFile(downloadInfo.getFilePath());
            }
            if (!new java.io.File(downloadInfo.getFileTempPath()).renameTo(new java.io.File(downloadInfo.getFilePath()))) {
                com.up366.common.FileUtilsUp.copyFileOrDir(downloadInfo.getFileTempPath(), downloadInfo.getFilePath());
            }
            com.up366.common.FileUtilsUp.deleteDirOrFile(downloadInfo.getFileTempPath());
            if (!com.up366.common.FileUtilsUp.isFileExists(downloadInfo.getFilePath())) {
                throw new java.lang.IllegalStateException("文件重命名失败！");
            }
            holder.success = true;
            iHandleOnError = 4;
        } else {
            throw new java.lang.IllegalStateException("un handle state:" + i);
        }
        postDownloadStateUpdate(holder, iHandleOnError, 0L, 100L, i2, str);
    }

    private int getCurrentDownloadSize() {
        int i;
        synchronized (com.up366.common.download.DownloadManager.class) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.up366.common.download.DownloadManager.Holder>> it = this.holderMap.entrySet().iterator();
            i = 0;
            while (it.hasNext()) {
                if (it.next().getValue().downloading) {
                    i++;
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class Holder {
        com.up366.common.download.DownloadManager.IDownloadCallback callback;
        com.up366.common.download.OKHttpDownloadImpl httpDownload;
        com.up366.common.download.DownloadInfo info;
        java.lang.String key;
        boolean cancel = false;
        boolean replace = false;
        boolean success = false;
        boolean failed = false;
        boolean downloading = false;

        Holder(java.lang.String str, com.up366.common.download.DownloadInfo downloadInfo, com.up366.common.download.DownloadManager.IDownloadCallback iDownloadCallback) {
            this.key = str;
            this.info = downloadInfo;
            this.callback = iDownloadCallback;
        }
    }
}
