package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppConfigLastVersion {
    public static int FORCE_UPDATE = 3;
    public static int SILENCE_UPDATE = 4;
    public static int UPDATE_NO_TIP = 1;
    public static int UPDATE_TIP = 2;
    private java.lang.String apkMd5;
    private long apkSize;
    private java.lang.String desc;
    private com.up366.mobile.common.logic.model.AppConfigLastVersion.DiffApkInfo diffApkInfo;
    private int forceUpgrade;
    private int status;
    private java.lang.String updateLog;
    private java.lang.String url;
    private int version;
    private java.lang.String versionName;

    public java.lang.String getApkMd5() {
        return this.apkMd5;
    }

    public void setApkMd5(java.lang.String str) {
        this.apkMd5 = str;
    }

    public long getApkSize() {
        return this.apkSize;
    }

    public void setApkSize(long j) {
        this.apkSize = j;
    }

    public java.lang.String getDesc() {
        return this.desc;
    }

    public void setDesc(java.lang.String str) {
        this.desc = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public java.lang.String getUpdateLog() {
        return this.updateLog;
    }

    public void setUpdateLog(java.lang.String str) {
        this.updateLog = str;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public java.lang.String getVersionName() {
        return this.versionName;
    }

    public void setVersionName(java.lang.String str) {
        this.versionName = str;
    }

    public int getForceUpgrade() {
        return this.forceUpgrade;
    }

    public void setForceUpgrade(int i) {
        this.forceUpgrade = i;
    }

    public com.up366.mobile.common.logic.model.AppConfigLastVersion.DiffApkInfo getDiffApkInfo() {
        return this.diffApkInfo;
    }

    public void setDiffApkInfo(com.up366.mobile.common.logic.model.AppConfigLastVersion.DiffApkInfo diffApkInfo) {
        this.diffApkInfo = diffApkInfo;
    }

    public static class DiffApkInfo {
        private java.lang.String apkMd5;
        private long apkSize;
        private java.lang.String url;

        public java.lang.String getUrl() {
            return this.url;
        }

        public void setUrl(java.lang.String str) {
            this.url = str;
        }

        public java.lang.String getApkMd5() {
            return this.apkMd5;
        }

        public void setApkMd5(java.lang.String str) {
            this.apkMd5 = str;
        }

        public long getApkSize() {
            return this.apkSize;
        }

        public void setApkSize(long j) {
            this.apkSize = j;
        }
    }
}
