package com.up366.common.download;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class FileCheckHelper {
    public static final int STATE_ERROR = -1;
    public static final int STATE_SUCCESS = 0;
    private com.up366.common.download.FileCheckHelper.ICheckResult callback;
    private final com.up366.common.download.DownloadInfo.ExtData downloadInfoExt;
    private final java.lang.String fileMd5;
    private final long fileSize;
    private final java.lang.String path;

    public interface ICheckResult {
        void onCheckResult(int i, int i2, java.lang.String str);
    }

    public FileCheckHelper(java.lang.String str, java.lang.String str2, long j, com.up366.common.download.DownloadInfo.ExtData extData) {
        this.path = str;
        this.fileMd5 = str2;
        this.fileSize = j;
        this.downloadInfoExt = extData;
    }

    public com.up366.common.download.FileCheckHelper setCallback(com.up366.common.download.FileCheckHelper.ICheckResult iCheckResult) {
        this.callback = iCheckResult;
        return this;
    }

    public void check() {
        try {
            java.io.File file = new java.io.File(this.path);
            if (!com.up366.common.FileUtilsUp.isFileExists(file)) {
                this.callback.onCheckResult(-1, -110, "文件不存在：" + this.path);
                return;
            }
            long length = file.length();
            if (this.fileSize != length) {
                com.up366.common.FileUtilsUp.deleteDirOrFile(this.path);
                this.downloadInfoExt.downloadFileSize = length;
                this.callback.onCheckResult(-1, -109, "文件大小校验失败：require:" + this.fileSize + " real:" + length);
                return;
            }
            java.lang.String strMD5DigestFileToFileMgr = com.up366.common.digest.MD5.MD5DigestFileToFileMgr(file);
            if (strMD5DigestFileToFileMgr != null && strMD5DigestFileToFileMgr.equalsIgnoreCase(this.fileMd5)) {
                this.callback.onCheckResult(0, 0, "success");
                return;
            }
            com.up366.common.FileUtilsUp.deleteDirOrFile(this.path);
            this.downloadInfoExt.downloadFileMD5 = strMD5DigestFileToFileMgr;
            this.callback.onCheckResult(-1, -108, "文件MD5校验失败：require:" + this.fileMd5 + " real:" + strMD5DigestFileToFileMgr);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - FileCheckHelper - check - error!", e);
            this.callback.onCheckResult(-1, com.up366.common.download.DownloadInfo.ERR_UNKNOWN, e.getMessage());
        }
    }
}
