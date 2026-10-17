package com.up366.mobile.common.logic.log.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BatchUploadItem {
    public static final int FILE_OTHERS = 2;
    public static final int FILE_RECORD = 1;
    public static final int FILE_RECORD_JSON = 3;
    private static int SEQUENCE = 0;
    public static final int STATE_FAILED = -1;
    public static final int STATE_RUNNING = 1;
    public static final int STATE_SUCCESS = 2;
    public static final int STATE_WAIT = 0;
    public static final int STRING = 0;
    private java.lang.String batchId;
    private java.lang.String configUrl;
    private java.lang.String headers;
    private int id;
    private java.lang.String objectId;
    private java.lang.String path;
    private java.lang.String postParams;
    private java.lang.Long rowId;
    private long size;
    private int state;
    private int type;
    private long uploadSize;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface LogItemType {
    }

    public BatchUploadItem() {
        this.state = 0;
    }

    public BatchUploadItem(com.up366.common.http.RequestParams<?> requestParams) {
        this.state = 0;
        this.type = 0;
        this.configUrl = requestParams.getUrl();
        this.headers = com.alibaba.fastjson.JSON.toJSONString(requestParams.getHeaders());
        this.postParams = com.alibaba.fastjson.JSON.toJSONString(requestParams.getParams());
        this.size = r3.length();
        int i = SEQUENCE;
        SEQUENCE = i + 1;
        this.id = i;
    }

    public BatchUploadItem(java.io.File file, boolean z, java.lang.String str) {
        this(file, z ? 1 : 2, str);
    }

    public BatchUploadItem(java.io.File file, int i, java.lang.String str) {
        this.state = 0;
        this.type = i;
        if (i == 1) {
            this.size = (long) ((file.length() / 7.0f) * 3.0f);
        } else {
            this.size = file.length();
        }
        this.path = file.getPath();
        this.objectId = str;
        int i2 = SEQUENCE;
        SEQUENCE = i2 + 1;
        this.id = i2;
    }

    public BatchUploadItem(java.lang.Long l, java.lang.String str, int i, int i2, long j, long j2, int i3, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        this.rowId = l;
        this.batchId = str;
        this.id = i;
        this.type = i2;
        this.size = j;
        this.uploadSize = j2;
        this.state = i3;
        this.configUrl = str2;
        this.headers = str3;
        this.postParams = str4;
        this.path = str5;
        this.objectId = str6;
    }

    public java.lang.String getBatchId() {
        return this.batchId;
    }

    public void setBatchId(java.lang.String str) {
        this.batchId = str;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public long getUploadSize() {
        return this.uploadSize;
    }

    public void setUploadSize(long j) {
        this.uploadSize = j;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }

    public java.lang.String getConfigUrl() {
        return this.configUrl;
    }

    public void setConfigUrl(java.lang.String str) {
        this.configUrl = str;
    }

    public java.lang.String getHeaders() {
        return this.headers;
    }

    public void setHeaders(java.lang.String str) {
        this.headers = str;
    }

    public java.lang.String getPostParams() {
        return this.postParams;
    }

    public void setPostParams(java.lang.String str) {
        this.postParams = str;
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public void setPath(java.lang.String str) {
        this.path = str;
    }

    public java.lang.String getObjectId() {
        return this.objectId;
    }

    public void setObjectId(java.lang.String str) {
        this.objectId = str;
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }

    public java.lang.String toString() {
        return "BatchUploadItem{rowId=" + this.rowId + ", batchId='" + this.batchId + "', id=" + this.id + ", type=" + this.type + ", size=" + this.size + ", uploadSize=" + this.uploadSize + ", state=" + this.state + ", configUrl='" + this.configUrl + "', headers='" + this.headers + "', postParams='" + this.postParams + "', path='" + this.path + "', objectId='" + this.objectId + "'}";
    }
}
