package com.up366.common.download;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DownloadInfo implements java.io.Serializable {
    public static final int ERR_DOWNLOAD_INFO_NULL = -100;
    public static final int ERR_DOWNLOAD_URL_NULL = -101;
    public static final int ERR_FAILED_GENERATE_VALID = -112;
    public static final int ERR_FAILED_NO_FILE = -115;
    public static final int ERR_FAILED_NO_SPACE = -114;
    public static final int ERR_FAILED_UNZIP = -111;
    public static final int ERR_FAILED_UNZIP_NEED_REBOOT = -117;
    public static final int ERR_FAILED_VALID = -113;
    public static final int ERR_FILE_MD5 = -108;
    public static final int ERR_FILE_NO_EXISTS = -110;
    public static final int ERR_FILE_SIZE = -109;
    public static final int ERR_NET = -104;
    public static final int ERR_NET_NO_BODY = -106;
    public static final int ERR_NET_NO_CONNECT = -103;
    public static final int ERR_NET_READ = -105;
    public static final int ERR_NO_ERROR = 0;
    public static final int ERR_RENAME = -107;
    public static final int ERR_SDCARD_NO_SPACE = -102;
    public static final int ERR_UNKNOWN = -999;
    public static final int STATE_CANCEL = 6;
    public static final int STATE_DOWN_ING = 2;
    public static final int STATE_FAILED = 5;
    public static final int STATE_NOT_DOWN = 0;
    public static final int STATE_REPLACE = 8;
    public static final int STATE_RETRY = 7;
    public static final int STATE_SUCCESS = 4;
    public static final int STATE_UNZIP_ING = 3;
    public static final int STATE_WAIT = 1;
    public static final java.lang.String TEMP_SUFFIX = ".tem";
    private static final long serialVersionUID = 1752669199919483484L;
    protected long addTime;
    private java.lang.String displayOrder;
    private int downType;
    private java.lang.String downloadUrl;
    private java.lang.String fileMD5;
    private java.lang.String filePath;
    private long fileSize;
    private java.lang.String fileVersion;
    private java.lang.String idIndex;
    private java.lang.String key;
    private java.lang.String name;
    private boolean needCheck;
    private boolean needUnzip;
    private java.lang.String rawDownloadUrl;
    private int state;
    private int downOrder = 1;
    private boolean disablePrivateCloud = false;
    public com.up366.common.download.DownloadInfo.ExtData ext = new com.up366.common.download.DownloadInfo.ExtData();
    private int tryCount = 0;
    private final java.lang.String[] downloadSuffix = {"", "", "back", "local"};

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface DownloadErrorCode {
    }

    public static class ExtData {
        public java.lang.String downloadFileMD5;
        public long downloadFileSize;
        public java.lang.String extSign;
        public int extType;
        public java.lang.String ipAddress;
        public java.lang.String redirectUrl;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FileDownloadState {
    }

    public int getDownOrder() {
        return this.downOrder;
    }

    public void setDownOrder(int i) {
        this.downOrder = i;
    }

    public java.lang.String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setDownloadUrl(java.lang.String str) {
        this.downloadUrl = str;
    }

    public java.lang.String getDisplayOrder() {
        return this.displayOrder;
    }

    public void setDisplayOrder(java.lang.String str) {
        this.displayOrder = str;
    }

    public java.lang.String getFileVersion() {
        return this.fileVersion;
    }

    public void setFileVersion(java.lang.String str) {
        this.fileVersion = str;
    }

    public java.lang.String getKey() {
        return this.key;
    }

    public void setKey(java.lang.String str) {
        this.key = str;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public void setAddTime(long j) {
        this.addTime = j;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public int getDownType() {
        return this.downType;
    }

    public void setDownType(int i) {
        this.downType = i;
    }

    public java.lang.String getIdIndex() {
        return this.idIndex;
    }

    public void setIdIndex(java.lang.String str) {
        this.idIndex = str;
    }

    public java.lang.String getFilePath() {
        return this.filePath;
    }

    public java.lang.String getFileTempPath() {
        java.lang.String filePath = getFilePath();
        if (isNeedUnzip()) {
            return com.up366.common.FileUtilsUp.join(filePath, TEMP_SUFFIX);
        }
        return filePath + TEMP_SUFFIX;
    }

    public void setFilePath(java.lang.String str) {
        this.filePath = str;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public java.lang.String getFileMD5() {
        return this.fileMD5;
    }

    public void setFileMD5(java.lang.String str) {
        this.fileMD5 = str;
    }

    public boolean isDisablePrivateCloud() {
        return this.disablePrivateCloud;
    }

    public void setDisablePrivateCloud(boolean z) {
        this.disablePrivateCloud = z;
    }

    public java.lang.String toString() {
        return "DownloadInfo{key='" + this.key + "', downloadUrl='" + this.downloadUrl + "', filePath='" + this.filePath + "', state=" + this.state + ", addTime=" + this.addTime + ", name='" + this.name + "', downType=" + this.downType + ", fileMD5='" + this.fileMD5 + "', fileSize=" + this.fileSize + ", displayOrder='" + this.displayOrder + "', needUnzip=" + this.needUnzip + ", needCheck=" + this.needCheck + ", disablePrivateCloud=" + this.disablePrivateCloud + ", fileVersion='" + this.fileVersion + "', idIndex='" + this.idIndex + "', downOrder=" + this.downOrder + ", tryCount=" + this.tryCount + ", downloadSuffix=" + java.util.Arrays.toString(this.downloadSuffix) + ", rawDownloadUrl='" + this.rawDownloadUrl + "'}";
    }

    public boolean isNeedUnzip() {
        return this.needUnzip;
    }

    public void setNeedUnzip(boolean z) {
        this.needUnzip = z;
    }

    public boolean isNeedCheck() {
        return this.needCheck;
    }

    public void setNeedCheck(boolean z) {
        this.needCheck = z;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.common.download.DownloadInfo downloadInfo = (com.up366.common.download.DownloadInfo) obj;
        if (this.state != downloadInfo.state || this.addTime != downloadInfo.addTime || this.downType != downloadInfo.downType || this.fileSize != downloadInfo.fileSize || this.needUnzip != downloadInfo.needUnzip || this.needCheck != downloadInfo.needCheck || this.downOrder != downloadInfo.downOrder || this.tryCount != downloadInfo.tryCount) {
            return false;
        }
        java.lang.String str = this.key;
        if (str == null ? downloadInfo.key != null : !str.equals(downloadInfo.key)) {
            return false;
        }
        java.lang.String str2 = this.downloadUrl;
        if (str2 == null ? downloadInfo.downloadUrl != null : !str2.equals(downloadInfo.downloadUrl)) {
            return false;
        }
        java.lang.String str3 = this.filePath;
        if (str3 == null ? downloadInfo.filePath != null : !str3.equals(downloadInfo.filePath)) {
            return false;
        }
        java.lang.String str4 = this.name;
        if (str4 == null ? downloadInfo.name != null : !str4.equals(downloadInfo.name)) {
            return false;
        }
        java.lang.String str5 = this.fileMD5;
        if (str5 == null ? downloadInfo.fileMD5 != null : !str5.equals(downloadInfo.fileMD5)) {
            return false;
        }
        java.lang.String str6 = this.displayOrder;
        if (str6 == null ? downloadInfo.displayOrder != null : !str6.equals(downloadInfo.displayOrder)) {
            return false;
        }
        java.lang.String str7 = this.fileVersion;
        if (str7 == null ? downloadInfo.fileVersion != null : !str7.equals(downloadInfo.fileVersion)) {
            return false;
        }
        java.lang.String str8 = this.idIndex;
        if (str8 == null ? downloadInfo.idIndex != null : !str8.equals(downloadInfo.idIndex)) {
            return false;
        }
        if (!java.util.Arrays.equals(this.downloadSuffix, downloadInfo.downloadSuffix)) {
            return false;
        }
        java.lang.String str9 = this.rawDownloadUrl;
        java.lang.String str10 = downloadInfo.rawDownloadUrl;
        return str9 != null ? str9.equals(str10) : str10 == null;
    }

    public int hashCode() {
        java.lang.String str = this.key;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        java.lang.String str2 = this.downloadUrl;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.filePath;
        int iHashCode3 = (((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.state) * 31;
        long j = this.addTime;
        int i = (iHashCode3 + ((int) (j ^ (j >>> 32)))) * 31;
        java.lang.String str4 = this.name;
        int iHashCode4 = (((i + (str4 != null ? str4.hashCode() : 0)) * 31) + this.downType) * 31;
        java.lang.String str5 = this.fileMD5;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        long j2 = this.fileSize;
        int i2 = (iHashCode5 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        java.lang.String str6 = this.displayOrder;
        int iHashCode6 = (((((i2 + (str6 != null ? str6.hashCode() : 0)) * 31) + (this.needUnzip ? 1 : 0)) * 31) + (this.needCheck ? 1 : 0)) * 31;
        java.lang.String str7 = this.fileVersion;
        int iHashCode7 = (iHashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        java.lang.String str8 = this.idIndex;
        int iHashCode8 = (((((((iHashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31) + this.downOrder) * 31) + this.tryCount) * 31) + java.util.Arrays.hashCode(this.downloadSuffix)) * 31;
        java.lang.String str9 = this.rawDownloadUrl;
        return iHashCode8 + (str9 != null ? str9.hashCode() : 0);
    }

    public java.lang.String getFixedDownloadUrl() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.rawDownloadUrl)) {
            this.rawDownloadUrl = this.downloadUrl;
        }
        int i = this.tryCount;
        java.lang.String[] strArr = this.downloadSuffix;
        if (i >= strArr.length) {
            return null;
        }
        this.tryCount = i + 1;
        java.lang.String str = strArr[i];
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return this.rawDownloadUrl;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.rawDownloadUrl);
        sb.append(this.rawDownloadUrl.contains("?") ? "&" : "?");
        sb.append(str);
        return sb.toString();
    }

    @java.lang.Deprecated
    public void setFilesize(long j) {
        this.fileSize = j;
    }

    @java.lang.Deprecated
    public void setDowntype(int i) {
        this.downType = i;
    }
}
