package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppFileUtils {
    private static java.lang.String appExternalCacheDir;
    private static java.lang.String appExternalFilesDir;
    private static java.lang.String appInternalCacheDir;
    private static java.lang.String appInternalFilesDir;
    private static java.lang.String appSDCardRootDir;
    private static final java.lang.String[] imageMIME = {"bmp", "jpg", "jpeg", "gif", "png"};
    private static final java.lang.String[] videoMIME = {"3gp", "avi", "asf", "m4u", "m4v", "mov", "mp4", "mpe", "mpeg", "mpg", "mpg4"};
    private static final java.lang.String[] textMIME = {com.igexin.push.core.d.d.d, "cpp", "conf", "h", "htm", "html", "java", "log", "prop", "sh", "txt", "rc", "xml"};
    private static final java.lang.String[] pdfMIME = {"pdf"};
    private static final java.lang.String[] pptMIME = {"ppt", "pptx"};
    private static final java.lang.String[] wordMIME = {"doc", "docx"};
    private static final java.lang.String[] excelMIME = {"xls", "xlsx"};

    public static class StorageSize {
        public long freeBytes;
        public long totalBytes;
    }

    public static void initPaths(android.content.Context context) {
        appInternalFilesDir = context.getFilesDir().getAbsolutePath();
        appInternalCacheDir = context.getCacheDir().getAbsolutePath();
        java.io.File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            appExternalFilesDir = com.up366.common.FileUtilsUp.join(appInternalFilesDir, "sdcard");
        } else {
            appExternalFilesDir = externalFilesDir.getAbsolutePath();
        }
        java.io.File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            appExternalCacheDir = com.up366.common.FileUtilsUp.join(appInternalCacheDir, "sdcard");
        } else {
            appExternalCacheDir = externalCacheDir.getAbsolutePath();
        }
    }

    public static java.lang.String getAppInternalFilesDir() {
        return appInternalFilesDir;
    }

    public static java.lang.String getAppInternalCacheDir() {
        return appInternalCacheDir;
    }

    public static java.lang.String getAppExternalFilesDir() {
        return appExternalFilesDir;
    }

    public static java.lang.String getAppExternalCacheDir() {
        return appExternalCacheDir;
    }

    public static java.lang.String getAppSDCardRootDir() {
        return appSDCardRootDir;
    }

    public static java.lang.String getUserRootPath() {
        return com.up366.common.FileUtilsUp.join(getAppInternalFilesDir(), java.lang.String.valueOf(com.up366.mobile.common.logic.Auth.UID()));
    }

    public static java.lang.String getCacheDir() {
        return com.up366.common.FileUtilsUp.join(getAppExternalCacheDir(), "cache");
    }

    public static java.lang.String getImgCacheDir() {
        return com.up366.common.FileUtilsUp.join(getCacheDir(), "img_cache");
    }

    public static java.lang.String getHttpCacheDir() {
        return com.up366.common.FileUtilsUp.join(getCacheDir(), "http_cache");
    }

    public static java.lang.String getFilpbookDir() {
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(getAppExternalFilesDir(), "flipbook");
        return com.up366.common.FileUtilsUp.isFileExists(strJoin) ? strJoin : com.up366.common.FileUtilsUp.join(getAppInternalFilesDir(), "flipbook");
    }

    public static java.lang.String getRootResourceDir() {
        return com.up366.common.FileUtilsUp.join(getAppInternalFilesDir(), "resources/");
    }

    public static java.lang.String getV9RootResourceDir() {
        return com.up366.common.FileUtilsUp.join(getAppInternalFilesDir(), "RootResources/");
    }

    public static java.lang.String getHomeworkDir() {
        return com.up366.common.FileUtilsUp.join(getAppExternalFilesDir(), "homework");
    }

    public static java.lang.String getUpdateApkRootDir() {
        return com.up366.common.FileUtilsUp.join(getAppExternalCacheDir(), "apkDownload");
    }

    public static java.lang.String getImFileDir() {
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(getAppExternalFilesDir(), "im-files");
        return com.up366.common.FileUtilsUp.isFileExists(strJoin) ? strJoin : com.up366.common.FileUtilsUp.join(getAppInternalFilesDir(), "im-files");
    }

    public static java.lang.String getImFileGroupDir(java.lang.String str) {
        return com.up366.common.FileUtilsUp.join(getImFileDir(), str);
    }

    public static java.lang.String getImFilePath(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return com.up366.common.FileUtilsUp.join(getImFileGroupDir(str), str2, str3);
    }

    public static java.lang.String getLogPath() {
        return com.up366.common.FileUtilsUp.join(getAppInternalFilesDir(), "Logs");
    }

    @java.lang.Deprecated
    public static java.lang.String getLogPathOld() {
        return com.up366.common.FileUtilsUp.join(getAppInternalCacheDir(), "Logs");
    }

    public static synchronized void saveBinaryFileRecord(java.lang.String str, byte[] bArr) {
        java.io.FileOutputStream fileOutputStream;
        if (!com.up366.common.StringUtils.isEmptyOrNull(str) && bArr != null) {
            java.io.File file = new java.io.File(str);
            java.io.FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    createFile(file);
                    fileOutputStream = new java.io.FileOutputStream(file, true);
                } catch (java.io.IOException unused) {
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(com.up366.common.digest.Hex.intToByteArray(bArr.length));
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                com.up366.common.IOUtils.close(fileOutputStream);
            } catch (java.io.IOException unused2) {
                fileOutputStream2 = fileOutputStream;
                com.up366.common.log.Logger.error("saveBinaryFileRecord : '" + str + "' error ...");
                com.up366.common.IOUtils.close(fileOutputStream2);
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.up366.common.IOUtils.close(fileOutputStream2);
                throw th;
            }
        }
    }

    private static boolean createFile(java.io.File file) {
        com.up366.common.FileUtilsUp.mkdirParentDir(file);
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("create file error:" + e.getMessage());
            return false;
        }
    }

    public static java.lang.String getRecordBinPath() {
        return com.up366.common.FileUtilsUp.join(getAppExternalFilesDir(), "record.bin");
    }

    public static java.lang.String getAnswerBinPath() {
        return com.up366.common.FileUtilsUp.join(getAppExternalFilesDir(), "answers.bin");
    }

    public static void cleanOldFiles(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.AppFileUtils$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.utils.AppFileUtils.lambda$cleanOldFiles$0(str);
            }
        });
    }

    static /* synthetic */ void lambda$cleanOldFiles$0(java.lang.String str) throws java.lang.Exception {
        java.io.File[] fileArrListFiles;
        java.io.File file = new java.io.File(str);
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - 2592000000L;
            for (java.io.File file2 : fileArrListFiles) {
                if (file2.lastModified() < jCurrentTimeMillis) {
                    com.up366.common.log.Logger.info("TAG - AppFileUtils - cleanOldFiles - delete: lastModified:" + file2.lastModified() + " file:" + file2.getAbsolutePath());
                    com.up366.common.FileUtilsUp.deleteDirOrFile(file2);
                }
            }
        }
    }

    public static com.up366.mobile.common.utils.AppFileUtils.StorageSize getStorageSize(android.content.Context context) {
        com.up366.mobile.common.utils.AppFileUtils.StorageSize storageSize = new com.up366.mobile.common.utils.AppFileUtils.StorageSize();
        try {
            java.io.File parentFile = ((java.io.File) java.util.Objects.requireNonNull(context.getDatabasePath("abc").getParentFile())).getParentFile();
            storageSize.totalBytes = parentFile.getTotalSpace();
            storageSize.freeBytes = parentFile.getUsableSpace();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - AppFileUtils - getStorageSizeString - ", e);
            com.up366.mobile.common.onlinelog.OpLog.report("error_getStorageSize", e.getMessage(), e);
        }
        return storageSize;
    }

    public static java.lang.String getStorageSizeString(android.content.Context context) {
        com.up366.mobile.common.utils.AppFileUtils.StorageSize storageSize = getStorageSize(context);
        return " TotalSpace:" + com.up366.common.ByteUtilsUp.bytesToMKB(storageSize.totalBytes) + " UsableSpace:" + com.up366.common.ByteUtilsUp.bytesToMKB(storageSize.freeBytes);
    }

    public static java.lang.String byteToFormat(long j) {
        if (j >= 1073741824) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(div(j + "", "1073741824", 2));
            sb.append("GB");
            return sb.toString();
        }
        if (j >= com.up366.medialibrary.config.PictureConstants.MB) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(div(j + "", com.up366.medialibrary.config.PictureConstants.MB + "", 2));
            sb2.append("MB");
            return sb2.toString();
        }
        if (j > 1024) {
            return div(j + "", "1024", 2) + "KB";
        }
        return div(j + "", "1", 2) + "B";
    }

    public static java.lang.String div(java.lang.String str, java.lang.String str2, int i) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("保留的小数位数必须大于零");
        }
        return new java.math.BigDecimal(str).divide(new java.math.BigDecimal(str2), i, 5).toString();
    }

    public static java.lang.String getMimeType(android.content.Context context, android.net.Uri uri) {
        if (uri.getScheme().equals(com.igexin.sdk.FlymePushReceiver.CONTENT)) {
            return android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
        }
        return android.webkit.MimeTypeMap.getFileExtensionFromUrl(android.net.Uri.fromFile(new java.io.File(uri.getPath())).toString());
    }

    public static boolean isSendFile(android.content.Context context, android.net.Uri uri) {
        java.lang.String mimeType = getMimeType(context, uri);
        return java.util.Arrays.toString(imageMIME).contains(mimeType) || java.util.Arrays.toString(videoMIME).contains(mimeType) || java.util.Arrays.toString(textMIME).contains(mimeType) || java.util.Arrays.toString(pdfMIME).contains(mimeType) || java.util.Arrays.toString(pptMIME).contains(mimeType) || java.util.Arrays.toString(excelMIME).contains(mimeType) || java.util.Arrays.toString(wordMIME).contains(mimeType);
    }

    public static int getFileType(java.lang.String str) {
        if (java.util.Arrays.toString(imageMIME).contains(str)) {
            return 1;
        }
        if (java.util.Arrays.toString(videoMIME).contains(str)) {
            return 2;
        }
        if (java.util.Arrays.toString(textMIME).contains(str)) {
            return 3;
        }
        if (java.util.Arrays.toString(pdfMIME).contains(str)) {
            return 4;
        }
        if (java.util.Arrays.toString(pptMIME).contains(str)) {
            return 5;
        }
        if (java.util.Arrays.toString(excelMIME).contains(str)) {
            return 6;
        }
        return java.util.Arrays.toString(wordMIME).contains(str) ? 7 : 3;
    }
}
