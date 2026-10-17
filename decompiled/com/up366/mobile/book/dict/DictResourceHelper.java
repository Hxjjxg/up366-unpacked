package com.up366.mobile.book.dict;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DictResourceHelper {
    private static final java.lang.String VERSION_SPLIT = "###";
    private static java.lang.String dictVersion;

    public static com.up366.common.download.DownloadInfo getDownloadInfo(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j) {
        com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
        downloadInfo.setFileMD5(str4);
        downloadInfo.setFileSize(j);
        downloadInfo.setDownloadUrl(str3);
        downloadInfo.setDownType(i);
        downloadInfo.setNeedCheck(true);
        downloadInfo.setNeedUnzip(true);
        downloadInfo.setFileVersion(str2 + "###20200713");
        downloadInfo.setKey(str);
        downloadInfo.setFilePath(com.up366.common.FileUtilsUp.join(getDictRootDir(), "/"));
        com.up366.mobile.common.utils.FileDownloadRecord.add(downloadInfo.getKey(), new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.dict.DictResourceHelper$$ExternalSyntheticLambda0
            public final void accept(java.lang.Object obj) {
                ((com.alibaba.fastjson.JSONObject) obj).put("dict", com.up366.mobile.book.dict.DictResourceHelper.getDictVersionName());
            }
        });
        return downloadInfo;
    }

    public static java.lang.String getDictVersionName() {
        java.lang.String str = dictVersion;
        if (str != null) {
            return str;
        }
        try {
            java.lang.String dictConfig = getDictConfig();
            if (dictConfig == null) {
                dictVersion = "-";
                return "-";
            }
            java.lang.String string = com.alibaba.fastjson.JSON.parseObject(dictConfig).getString("version");
            dictVersion = string;
            return string;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - DictResourceHelper - getDictVersion - ", e);
            com.up366.mobile.common.onlinelog.OpLog.report("ERROR-getDictVersion", e.getMessage(), e);
            return null;
        }
    }

    public static void clearDictVersionCache() {
        dictVersion = null;
    }

    public static int getVersionNo() {
        try {
            java.lang.String dictConfig = getDictConfig();
            if (dictConfig == null) {
                return 0;
            }
            return com.alibaba.fastjson.JSON.parseObject(dictConfig).getIntValue("versionNo");
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - DictResourceHelper - getVersionNo - ", e);
            com.up366.mobile.common.onlinelog.OpLog.report("ERROR-Dict-getVersionNo", e.getMessage(), e);
            return 0;
        }
    }

    public static java.lang.String getDictConfig() {
        if (!isExistResource()) {
            return null;
        }
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(getDictRootDir(), "config.json");
        if (com.up366.common.FileUtilsUp.isFileExists(strJoin)) {
            return com.up366.common.FileUtilsUp.getFileContent(strJoin);
        }
        com.up366.common.log.Logger.warn("TAG - DictResourceHelper - getDictConfig - not found file config.json");
        return null;
    }

    public static boolean hasUpdate(java.lang.String str) throws java.lang.Throwable {
        java.lang.String fileContent = com.up366.common.FileUtilsUp.getFileContent(com.up366.common.FileUtilsUp.join(getDictRootDir(), "checkFile"));
        com.up366.common.log.Logger.info("TAG - DictResourceHelper - hasUpdate - old:" + fileContent + " new:" + str);
        if (str == null || com.up366.common.StringUtils.isEmptyOrNull(fileContent)) {
            return false;
        }
        return !fileContent.trim().equals(str);
    }

    public static boolean isExistResource() {
        if (isTestDir() || com.up366.common.FileUtilsUp.isFileExists(com.up366.common.FileUtilsUp.join(getDictRootDir(), "checkFile"))) {
            return true;
        }
        com.up366.common.log.Logger.warn("TAG - DictResourceHelper - isExistResource - false");
        return false;
    }

    public static boolean isTestDir() {
        if (!getDictRootDir().endsWith("dict")) {
            return false;
        }
        com.up366.common.log.Logger.info("TAG - DictResourceHelper - isTestDir - true");
        return true;
    }

    public static java.lang.String getDictRootDir() {
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getAppExternalFilesDir(), "dict");
        if (com.up366.common.FileUtilsUp.isFileExists(com.up366.common.FileUtilsUp.join(strJoin, "config.json"))) {
            com.up366.common.log.Logger.info("TAG - DictResourceHelper - getDictRootDir - test exercise dir : " + strJoin);
            return strJoin;
        }
        android.content.Context applicationContext = com.up366.common.global.GB.get().getApplicationContext();
        java.io.File externalFilesDir = applicationContext.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            externalFilesDir = applicationContext.getFilesDir();
        }
        return com.up366.common.FileUtilsUp.join(externalFilesDir.getAbsolutePath(), "dictV1");
    }
}
