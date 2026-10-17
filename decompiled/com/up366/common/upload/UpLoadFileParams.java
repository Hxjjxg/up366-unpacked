package com.up366.common.upload;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UpLoadFileParams {
    private java.lang.String filePath;
    private java.lang.String uploadFileKey;
    private java.lang.String url;

    public enum State {
        FAILED,
        START,
        UPLOADING,
        SUCCESS
    }

    public void initHeaders(java.util.Map<java.lang.String, java.lang.String> map) {
    }

    public void initParams(java.util.Map<java.lang.String, java.lang.String> map) {
    }

    public void uploadCallback(com.up366.common.upload.UpLoadFileParams.State state, long j, long j2, java.lang.String str) {
    }

    public UpLoadFileParams(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.url = str;
        this.uploadFileKey = str2;
        this.filePath = str3;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }

    public java.lang.String getUploadFileKey() {
        return this.uploadFileKey;
    }

    public void setUploadFileKey(java.lang.String str) {
        this.uploadFileKey = str;
    }

    public java.lang.String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(java.lang.String str) {
        this.filePath = str;
    }
}
