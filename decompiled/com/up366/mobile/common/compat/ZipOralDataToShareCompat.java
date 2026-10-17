package com.up366.mobile.common.compat;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ZipOralDataToShareCompat {
    private static final java.lang.String dataDirPath;
    private static final java.lang.String dirPath;
    private static final com.up366.common.task.TaskExecutor executor = com.up366.common.task.TaskUtils.createSerialExecutor("saveOralData");
    protected static java.lang.String resultJsonPath;

    static {
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getAppExternalFilesDir(), "oraltest");
        dirPath = strJoin;
        java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(strJoin, "data");
        dataDirPath = strJoin2;
        resultJsonPath = com.up366.common.FileUtilsUp.join(strJoin2, "answer.json");
    }

    public static boolean hasUploadData() {
        return com.up366.common.FileUtilsUp.isFileExists(dirPath);
    }

    public static void autoClearUploadData() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.ZipOralDataToShareCompat$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.compat.ZipOralDataToShareCompat.lambda$autoClearUploadData$0();
            }
        });
    }

    static /* synthetic */ void lambda$autoClearUploadData$0() throws java.lang.Exception {
        try {
            clearOldFiles(dirPath, 30, true);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("清理文件时发生异常", e);
        }
    }

    public static void upload() throws java.lang.Throwable {
        final java.io.File zipFile = getZipFile();
        com.up366.mobile.common.logic.Auth.cur().fileMgr().save(zipFile.getPath(), ".zip", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, com.up366.mobile.common.utils.alifile.OssObjectKey.INSTANCE.getObjectKey(zipFile.getPath(), ".zip", false, com.up366.mobile.common.utils.alifile.OssObjectKey.Business.FEEDBACK), new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.common.compat.ZipOralDataToShareCompat$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
            public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                com.up366.mobile.common.compat.ZipOralDataToShareCompat.lambda$upload$1(zipFile, fileMapInfo);
            }
        });
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.compat.ZipOralDataToShareCompat$1, reason: invalid class name */
    class AnonymousClass1 implements com.up366.mobile.common.utils.alifile.IOSSCallback {
        final /* synthetic */ com.up366.mobile.common.utils.alifile.FileMapInfo val$info;
        final /* synthetic */ java.io.File val$zipFile;

        AnonymousClass1(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo, java.io.File file) {
            this.val$info = fileMapInfo;
            this.val$zipFile = file;
        }

        @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
        public void onSuccess() {
            try {
                com.up366.common.http.NetHolder<java.lang.String> netHolderSubmitOralSync = com.up366.mobile.common.logic.Auth.cur().feedback().submitOralSync(this.val$info.getUrl());
                if (netHolderSubmitOralSync.resp.isError()) {
                    com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.OralUploadLogEvent(netHolderSubmitOralSync.resp.getInfo(), 4, 0L, 0L));
                } else {
                    final java.io.File file = this.val$zipFile;
                    com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.ZipOralDataToShareCompat$1$$ExternalSyntheticLambda0
                        @Override // com.up366.common.task.Task
                        public final void run() throws java.lang.Exception {
                            com.up366.mobile.common.compat.ZipOralDataToShareCompat.AnonymousClass1.lambda$onSuccess$0(file);
                        }
                    });
                    com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.OralUploadLogEvent("上传成功", 3, 0L, 0L));
                }
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("submitOralSync error", e);
            }
        }

        static /* synthetic */ void lambda$onSuccess$0(java.io.File file) throws java.lang.Exception {
            com.up366.common.FileUtilsUp.deleteDirOrFile(com.up366.mobile.common.compat.ZipOralDataToShareCompat.dirPath);
            com.up366.common.FileUtilsUp.deleteDirOrFile(file.getPath());
        }

        @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
        public void onFailure(int i, java.lang.String str) {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.OralUploadLogEvent(str, 4, 0L, 0L));
        }

        @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
        public void onProgress(long j, long j2) {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.OralUploadLogEvent("", 2, j, j2));
        }
    }

    static /* synthetic */ void lambda$upload$1(java.io.File file, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        com.up366.common.log.Logger.error("share File path " + fileMapInfo.getUrl());
        com.up366.mobile.common.utils.alifile.AliFileMgrV2.uploadFile(fileMapInfo, new com.up366.mobile.common.compat.ZipOralDataToShareCompat.AnonymousClass1(fileMapInfo, file));
    }

    private static java.io.File getZipFile() throws java.lang.Throwable {
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(dataDirPath, "answer.js");
        java.lang.String str = dirPath;
        java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(str, "index.html");
        java.lang.String str2 = str + ".zip";
        if (com.up366.common.FileUtilsUp.isFileExists(str2)) {
            return new java.io.File(str2);
        }
        com.up366.common.FileUtilsUp.mkdirParentDir(resultJsonPath);
        java.lang.String str3 = "var data = [" + com.up366.common.FileUtilsUp.getFileContent(resultJsonPath) + "false]";
        java.lang.String assetFile = com.up366.common.FileUtilsUp.getAssetFile("oraltest/show.html");
        com.up366.common.FileUtilsUp.saveContentToFile(strJoin, str3);
        com.up366.common.FileUtilsUp.saveContentToFile(strJoin2, assetFile);
        com.up366.common.FileUtilsUp.zip(str, str2);
        return new java.io.File(str2);
    }

    public static void clear() {
        final java.lang.String str = dirPath + ".zip";
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.ZipOralDataToShareCompat$$ExternalSyntheticLambda8
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.compat.ZipOralDataToShareCompat.lambda$clear$2(str);
            }
        });
    }

    static /* synthetic */ void lambda$clear$2(java.lang.String str) throws java.lang.Exception {
        com.up366.common.FileUtilsUp.deleteDirOrFile(dirPath);
        com.up366.common.FileUtilsUp.deleteDirOrFile(str);
    }

    public static void saveAnswer(final com.up366.asecengine.englishengine.AsecSession asecSession) {
        executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.ZipOralDataToShareCompat$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.compat.ZipOralDataToShareCompat.lambda$saveAnswer$3(asecSession);
            }
        });
    }

    static /* synthetic */ void lambda$saveAnswer$3(com.up366.asecengine.englishengine.AsecSession asecSession) throws java.lang.Exception {
        java.lang.String wavPath = asecSession.getWavPath();
        java.lang.String netFiles = asecSession.getNetFiles();
        if (com.up366.common.StringUtils.isEmptyOrNull(netFiles)) {
            return;
        }
        java.lang.String str = new java.io.File(wavPath).getName().replace(com.up366.medialibrary.common.utils.MimeTypeUtils.WAV, "") + "-" + com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        java.lang.String str2 = dataDirPath;
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(str2, str + com.up366.medialibrary.common.utils.MimeTypeUtils.WAV);
        java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(str2, str, "net");
        java.lang.String[] strArrSplit = netFiles.split(com.igexin.push.core.b.an);
        com.up366.common.FileUtilsUp.copyFileOrDir(wavPath, strJoin);
        if (strArrSplit.length > 0) {
            java.lang.String str3 = strArrSplit[0];
            if (com.up366.common.FileUtilsUp.isDir(str3)) {
                com.up366.common.FileUtilsUp.copyFileOrDir(str3, strJoin2);
            }
            if (com.up366.common.FileUtilsUp.isFile(str3)) {
                com.up366.common.FileUtilsUp.copyFileOrDir(new java.io.File(str3).getParent(), strJoin2);
            }
        }
        java.lang.String md5Str = asecSession.getMd5Str();
        java.lang.String str4 = str + com.up366.medialibrary.common.utils.MimeTypeUtils.WAV;
        long duration = asecSession.getDuration();
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(asecSession.getJsonResult());
        object.put("app_time", java.lang.Long.valueOf(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()));
        object.put("app_md5", md5Str);
        object.put("app_wav", str4);
        object.put("app_net_dir", str);
        object.put("app_duration", java.lang.Long.valueOf(duration));
        com.up366.common.FileUtilsUp.mkdirParentDir(resultJsonPath);
        new java.io.FileOutputStream(new java.io.File(resultJsonPath), true).write((object.toJSONString() + com.igexin.push.core.b.an).getBytes());
    }

    private static void clearOldFiles(java.lang.String str, int i, boolean z) {
        if (!com.up366.common.FileUtilsUp.isFileExists(str)) {
            com.up366.common.log.Logger.info("目录不存在: " + str);
            return;
        }
        java.io.File file = new java.io.File(str);
        if (!file.isDirectory()) {
            com.up366.common.log.Logger.info("路径不是目录: " + str);
            return;
        }
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - (((long) (86400 * i)) * 1000);
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            com.up366.common.log.Logger.info("无法读取目录内容: " + str);
            return;
        }
        for (java.io.File file2 : fileArrListFiles) {
            try {
                if (file2.isFile()) {
                    if (shouldDeleteFile(file2, currentNtpTimeInMillisecond)) {
                        com.up366.common.FileUtilsUp.deleteDirOrFile(file2.getAbsolutePath());
                    }
                } else if (file2.isDirectory() && z) {
                    clearOldFiles(file2.getAbsolutePath(), i, z);
                    if (file2.list() != null && file2.list().length == 0) {
                        com.up366.common.FileUtilsUp.deleteDirOrFile(file2.getAbsolutePath());
                    }
                } else if (file2.isDirectory() && shouldDeleteFile(file2, currentNtpTimeInMillisecond)) {
                    com.up366.common.FileUtilsUp.deleteDirOrFile(file2.getAbsolutePath());
                }
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.info("处理文件时发生异常: " + file2.getAbsolutePath(), e);
            }
        }
    }

    private static boolean shouldDeleteFile(java.io.File file, long j) {
        long lastModified = getLastModified(file.getAbsolutePath());
        return lastModified > 0 && lastModified < j;
    }

    private static long getLastModified(java.lang.String str) {
        if (str != null && !str.trim().isEmpty()) {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                return 0L;
            }
            try {
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    try {
                        return java.nio.file.Files.readAttributes(java.nio.file.Paths.get(str, new java.lang.String[0]), com.up366.mobile.book.helper.Tools$$ExternalSyntheticApiModelOutline0.m305m(), new java.nio.file.LinkOption[0]).lastModifiedTime().toMillis();
                    } catch (java.io.IOException unused) {
                        return file.lastModified();
                    }
                }
                return file.lastModified();
            } catch (java.lang.SecurityException unused2) {
                com.up366.common.log.Logger.info("无法访问文件权限: " + str);
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.info("获取文件修改时间失败: " + str + ", 错误: " + e.getMessage());
                return 0L;
            }
        }
        return 0L;
    }
}
