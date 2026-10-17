package com.up366.mobile.book.exercise;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ExerciseResourceHelper {
    private static final java.lang.String VERSION_SPLIT = "###";
    private static java.lang.String xotVersion;

    public static com.up366.common.download.DownloadInfo getDownloadInfo(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j) {
        com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
        downloadInfo.setFileMD5(str4);
        downloadInfo.setFileSize(j);
        downloadInfo.setDownloadUrl(str3);
        downloadInfo.setDownType(i);
        downloadInfo.setNeedCheck(true);
        downloadInfo.setNeedUnzip(true);
        downloadInfo.setFileVersion(str2 + "###20201106");
        downloadInfo.setKey(str);
        downloadInfo.setFilePath(com.up366.common.FileUtilsUp.join(getExerciseRootDir(), "/"));
        com.up366.mobile.common.utils.FileDownloadRecord.add(downloadInfo.getKey(), new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.exercise.ExerciseResourceHelper$$ExternalSyntheticLambda0
            public final void accept(java.lang.Object obj) {
                ((com.alibaba.fastjson.JSONObject) obj).put("xot", com.up366.mobile.book.exercise.ExerciseResourceHelper.getXotVersionName());
            }
        });
        return downloadInfo;
    }

    public static java.lang.String getXotVersionName() {
        java.lang.String str = xotVersion;
        if (str != null) {
            return str;
        }
        try {
            java.lang.String exerciseConfig = getExerciseConfig();
            if (exerciseConfig == null) {
                xotVersion = "-";
                return "-";
            }
            java.lang.String string = com.alibaba.fastjson.JSON.parseObject(exerciseConfig).getString("version");
            xotVersion = string;
            return string;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - ExerciseResourceHelper - getXotVersion - ", e);
            com.up366.mobile.common.onlinelog.OpLog.report("ERROR-getXotVersion", e.getMessage(), e);
            xotVersion = "error";
            return null;
        }
    }

    public static void clearXotVersionCache() {
        xotVersion = null;
    }

    public static int getVersionNo() {
        try {
            java.lang.String exerciseConfig = getExerciseConfig();
            if (exerciseConfig == null) {
                return 0;
            }
            return com.alibaba.fastjson.JSON.parseObject(exerciseConfig).getIntValue("versionNo");
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - ExerciseResourceHelper - getVersionNo - ", e);
            com.up366.mobile.common.onlinelog.OpLog.report("ERROR-Exercise-getVersionNo", e.getMessage(), e);
            return 0;
        }
    }

    public static java.lang.String getExerciseConfig() {
        if (!isExistResource()) {
            return null;
        }
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(getExerciseRootDir(), "config.json");
        if (com.up366.common.FileUtilsUp.isFileExists(strJoin)) {
            return com.up366.common.FileUtilsUp.getFileContent(strJoin);
        }
        com.up366.common.log.Logger.warn("TAG - ExerciseResourceHelper - getExerciseConfig - not found file config.json");
        return null;
    }

    public static boolean hasUpdate(java.lang.String str) throws java.lang.Throwable {
        java.lang.String fileContent = com.up366.common.FileUtilsUp.getFileContent(com.up366.common.FileUtilsUp.join(getExerciseRootDir(), "checkFile"));
        com.up366.common.log.Logger.info("TAG - ExerciseResourceHelper - hasUpdate - old:" + fileContent + " new:" + str);
        if (str == null || com.up366.common.StringUtils.isEmptyOrNull(fileContent)) {
            return false;
        }
        return !fileContent.trim().equals(str);
    }

    public static boolean isExistResource() {
        if (isTestDir() || com.up366.common.FileUtilsUp.isFileExists(com.up366.common.FileUtilsUp.join(getExerciseRootDir(), "checkFile"))) {
            return true;
        }
        com.up366.common.log.Logger.warn("TAG - ExerciseResourceHelper - isExistResource - false");
        return false;
    }

    public static boolean isTestDir() {
        if (!getExerciseRootDir().endsWith("exercise")) {
            return false;
        }
        com.up366.common.log.Logger.info("TAG - ExerciseResourceHelper - isTestDir - true");
        return true;
    }

    public static java.lang.String getExerciseRootDir() {
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getAppExternalFilesDir(), "exercise");
        if (com.up366.common.FileUtilsUp.isFileExists(com.up366.common.FileUtilsUp.join(strJoin, "config.json"))) {
            com.up366.common.log.Logger.info("TAG - ExerciseResourceHelper - getExerciseRootDir - test exercise dir : " + strJoin);
            return strJoin;
        }
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getAppExternalFilesDir(), "exerciseV1");
    }
}
