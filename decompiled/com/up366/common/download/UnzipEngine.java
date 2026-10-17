package com.up366.common.download;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UnzipEngine {
    private final java.lang.String destDir;
    private final com.up366.common.download.DownloadExtResolver extResolver;
    private final java.lang.String extSign;
    private final int extType;
    private final java.lang.String fileVersion;
    private final java.lang.String key;
    private com.up366.common.download.IUnZipListener listener;
    private final java.lang.String zipFilePath;

    public UnzipEngine(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this(str, str2, str3, str4, null, 0, null);
    }

    public UnzipEngine(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i, com.up366.common.download.DownloadExtResolver downloadExtResolver) {
        this.key = str;
        this.destDir = str2;
        this.zipFilePath = str3;
        this.fileVersion = str4;
        this.extSign = str5;
        this.extType = i;
        this.extResolver = downloadExtResolver;
    }

    public com.up366.common.download.UnzipEngine setListener(com.up366.common.download.IUnZipListener iUnZipListener) {
        this.listener = iUnZipListener;
        return this;
    }

    public void start() {
        boolean zGenerateValid;
        java.lang.String strMd5;
        try {
            try {
                this.listener.onUnzip(this.key, 0, 0, 100, 0, "");
                try {
                    zGenerateValid = com.up366.common.utils.EncryptUtil.generateValid(this.zipFilePath);
                } catch (java.lang.Error e) {
                    com.up366.common.log.Logger.error(e.getMessage(), e);
                    zGenerateValid = false;
                }
            } finally {
                com.up366.common.FileUtilsUp.deleteDirOrFile(this.zipFilePath);
            }
        } catch (java.lang.Exception e2) {
            notifyError(e2);
        }
        if (!zGenerateValid) {
            com.up366.common.log.Logger.error("生成校验文件失败！");
            com.up366.common.log.Logger.error(com.up366.common.utils.EncryptUtil.errMsg());
            com.up366.common.global.GB.get().sendLog("base-unzip-err-generate-valid", com.up366.common.utils.EncryptUtil.errMsg());
            this.listener.onUnzip(this.key, 2, 0, 100, -112, "生成校验文件失败");
            return;
        }
        final java.lang.String strResolveMkIfNeed = resolveMkIfNeed();
        if (android.text.TextUtils.isEmpty(strResolveMkIfNeed)) {
            strMd5 = null;
        } else {
            strMd5 = com.up366.common.digest.MD5.md5(com.up366.common.utils.EncryptUtil.decryptDk(this.extSign, strResolveMkIfNeed));
            if (android.text.TextUtils.isEmpty(strMd5)) {
                throw new java.lang.IllegalStateException("ext value is empty");
            }
        }
        com.up366.common.download.ZipHelper.unzip(this.zipFilePath, this.destDir, strMd5, new com.up366.common.download.ZipHelper.ZipCallback() { // from class: com.up366.common.download.UnzipEngine.1
            @Override // com.up366.common.download.ZipHelper.ZipCallback
            public void onProgress(int i) {
                com.up366.common.download.UnzipEngine.this.listener.onUnzip(com.up366.common.download.UnzipEngine.this.key, 0, i, 100, 0, "");
            }

            @Override // com.up366.common.download.ZipHelper.ZipCallback
            public void onSuccess() throws java.lang.Throwable {
                if (!android.text.TextUtils.isEmpty(strResolveMkIfNeed)) {
                    com.up366.common.FileUtilsUp.deleteDirOrFile(com.up366.common.download.UnzipEngine.this.zipFilePath);
                    if (!com.up366.common.utils.EncryptUtil.generateValid(com.up366.common.download.UnzipEngine.this.destDir)) {
                        com.up366.common.log.Logger.error("生成解压目录校验文件失败！");
                        com.up366.common.log.Logger.error(com.up366.common.utils.EncryptUtil.errMsg().trim());
                        com.up366.common.global.GB.get().sendLog("base-unzip-err-generate-valid-dir", com.up366.common.utils.EncryptUtil.errMsg());
                        com.up366.common.download.UnzipEngine.this.listener.onUnzip(com.up366.common.download.UnzipEngine.this.key, 2, 0, 100, -112, "生成解压目录校验文件失败");
                        return;
                    }
                }
                if (!com.up366.common.utils.EncryptUtil.valid(com.up366.common.download.UnzipEngine.this.destDir)) {
                    com.up366.common.log.Logger.error("解压文件校验失败！");
                    com.up366.common.log.Logger.error(com.up366.common.utils.EncryptUtil.errMsg().trim());
                    com.up366.common.global.GB.get().sendLog("base-unzip-err-valid-file", com.up366.common.utils.EncryptUtil.errMsg());
                    com.up366.common.download.UnzipEngine.this.listener.onUnzip(com.up366.common.download.UnzipEngine.this.key, 2, 0, 100, com.up366.common.download.DownloadInfo.ERR_FAILED_VALID, "校验解压文件内容失败");
                    return;
                }
                if (!android.text.TextUtils.isEmpty(strResolveMkIfNeed) && !com.up366.common.utils.EncryptUtil.saveValidExt(com.up366.common.download.UnzipEngine.this.destDir, strResolveMkIfNeed, com.up366.common.download.UnzipEngine.this.extSign)) {
                    com.up366.common.log.Logger.error("写入解密信息失败！");
                    com.up366.common.log.Logger.error(com.up366.common.utils.EncryptUtil.errMsg().trim());
                    com.up366.common.global.GB.get().sendLog("base-unzip-err-save-ext", com.up366.common.utils.EncryptUtil.errMsg());
                    com.up366.common.download.UnzipEngine.this.listener.onUnzip(com.up366.common.download.UnzipEngine.this.key, 2, 0, 100, com.up366.common.download.DownloadInfo.ERR_FAILED_VALID, "写入解密信息失败");
                    return;
                }
                com.up366.common.FileUtilsUp.addFileVersion(com.up366.common.download.UnzipEngine.this.destDir, com.up366.common.download.UnzipEngine.this.fileVersion);
                com.up366.common.FileUtilsUp.deleteDirOrFile(com.up366.common.download.UnzipEngine.this.zipFilePath);
                com.up366.common.download.UnzipEngine.this.listener.onUnzip(com.up366.common.download.UnzipEngine.this.key, 1, 100, 100, 0, "");
            }

            @Override // com.up366.common.download.ZipHelper.ZipCallback
            public void onFail(java.lang.Exception exc) {
                com.up366.common.download.UnzipEngine.this.notifyError(exc);
            }
        });
    }

    private boolean hasExtSign() {
        return (android.text.TextUtils.isEmpty(this.extSign) || this.extType == 0) ? false : true;
    }

    private java.lang.String resolveMkIfNeed() throws java.lang.Exception {
        if (!hasExtSign()) {
            return null;
        }
        com.up366.common.download.DownloadExtResolver downloadExtResolver = this.extResolver;
        if (downloadExtResolver == null) {
            throw new java.lang.IllegalStateException("ext resolver is null");
        }
        java.lang.String strResolve = downloadExtResolver.resolve(this.extSign, false);
        if (!android.text.TextUtils.isEmpty(strResolve) && com.up366.common.utils.EncryptUtil.matchMkEdk(this.extSign, strResolve)) {
            return strResolve;
        }
        java.lang.String strResolve2 = this.extResolver.resolve(this.extSign, true);
        if (android.text.TextUtils.isEmpty(strResolve2)) {
            throw new java.lang.IllegalStateException("ext resolver returned empty data");
        }
        if (com.up366.common.utils.EncryptUtil.matchMkEdk(this.extSign, strResolve2)) {
            return strResolve2;
        }
        throw new java.lang.SecurityException("ext sign does not match resolved data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyError(java.lang.Exception exc) {
        int i;
        java.lang.String str;
        com.up366.common.log.Logger.error("解压失败！ key:" + this.key + " path:  " + this.zipFilePath, exc);
        com.up366.common.global.GB.get().sendLog("base-unzip-err-exception", "key:" + this.key + " path:" + this.zipFilePath + "\n" + android.util.Log.getStackTraceString(exc));
        com.up366.common.FileUtilsUp.deleteDirOrFile(this.zipFilePath);
        java.lang.String message = exc.getMessage() == null ? "" : exc.getMessage();
        if (!message.contains("No space")) {
            i = -111;
            str = "解压失败";
        } else {
            i = -102;
            str = "存储空间不足";
        }
        if (message.contains("Structure needs cleaning")) {
            i = com.up366.common.download.DownloadInfo.ERR_FAILED_UNZIP_NEED_REBOOT;
            str = "解压失败，请重试";
        }
        if (message.contains("No such file or directory")) {
            i = com.up366.common.download.DownloadInfo.ERR_FAILED_NO_FILE;
            str = "找不到文件";
        }
        this.listener.onUnzip(this.key, 2, 0, 100, i, str);
    }
}
