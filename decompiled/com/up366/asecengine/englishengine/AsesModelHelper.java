package com.up366.asecengine.englishengine;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AsesModelHelper {
    private static final java.lang.String VERSION_SPLIT = "###";
    private static com.up366.asecengine.englishengine.AsesModelHelper helper;
    private java.lang.String modelDir;

    public static com.up366.asecengine.englishengine.AsesModelHelper create() {
        if (helper == null) {
            helper = new com.up366.asecengine.englishengine.AsesModelHelper();
        }
        return helper;
    }

    public com.up366.common.download.DownloadInfo getDownloadInfo(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j) {
        com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
        downloadInfo.setFileMD5(str4);
        downloadInfo.setFileSize(j);
        downloadInfo.setDownloadUrl(str3);
        downloadInfo.setDownType(i);
        downloadInfo.setNeedCheck(true);
        downloadInfo.setNeedUnzip(true);
        downloadInfo.setFileVersion(str2 + "###20260731");
        downloadInfo.setKey(str);
        downloadInfo.setFilePath(getModelDir());
        return downloadInfo;
    }

    public void setModelDir(java.lang.String str) {
        this.modelDir = str;
    }

    public java.lang.String getModelDir() {
        return this.modelDir;
    }

    public boolean hasModel() throws java.lang.Throwable {
        java.lang.String fileContent = com.up366.common.FileUtilsUp.getFileContent(com.up366.common.FileUtilsUp.join(this.modelDir, "checkFile"));
        if (com.up366.common.StringUtils.isEmptyOrNull(fileContent)) {
            return false;
        }
        java.lang.String[] strArrSplit = fileContent.split(VERSION_SPLIT);
        if (strArrSplit.length < 2) {
            com.up366.common.log.Logger.error("TAG - AsesModelHelper - hasModel - split.length < 2 : " + fileContent);
            return false;
        }
        java.lang.String str = strArrSplit[0];
        java.lang.String str2 = strArrSplit[1];
        if (!com.up366.aseclibrary.BuildConfig.ASES_MODEL_VERSION.equals(str2)) {
            com.up366.common.log.Logger.info("TAG - AsesModelHelper - hasModel - false modelVersion:" + str2);
            return false;
        }
        return !com.up366.common.StringUtils.isEmptyOrNull(str);
    }

    public boolean hasUpdate(java.lang.String str) throws java.lang.Throwable {
        java.lang.String fileContent = com.up366.common.FileUtilsUp.getFileContent(com.up366.common.FileUtilsUp.join(this.modelDir, "checkFile"));
        com.up366.common.log.Logger.info("TAG - AsecEngineHelper - hasUpdate - old:" + fileContent + " new:" + str);
        if (str == null || com.up366.common.StringUtils.isEmptyOrNull(fileContent)) {
            return false;
        }
        return !fileContent.trim().equals(str);
    }

    public void invalidateModel() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.modelDir)) {
            return;
        }
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(this.modelDir, "checkFile");
        com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin);
        com.up366.common.log.Logger.warn("TAG - AsesModelHelper - invalidateModel - delete check file: " + strJoin);
    }
}
