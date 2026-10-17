package com.up366.mobile.book.helper.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V8OpenWebViewParams {
    private java.lang.String bookId;
    private java.lang.String bookInfo;
    private boolean canUse;
    private int courseId;
    private java.lang.String extraData;
    private java.lang.String fileId;

    @com.alibaba.fastjson.annotation.JSONField(name = com.up366.mobile.common.onlinelog.OpLogData.Behavior.IS_REPORT)
    private boolean isReport;
    private java.lang.String linkedData;
    private boolean openNewWebView;
    private int reTest;
    private java.lang.String scene;
    private java.lang.String studyTaskId;
    private java.lang.String taskId;
    private java.lang.String title;
    private java.lang.String url;
    private java.lang.String xotParam;

    public java.lang.String getScene() {
        return this.scene;
    }

    public void setScene(java.lang.String str) {
        this.scene = str;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public java.lang.String getServiceUrl() {
        if (!android.text.TextUtils.isEmpty(this.url) && this.url.startsWith("http")) {
            return com.up366.common.global.GB.get().getServerUrl(this.url);
        }
        return this.url;
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }

    public java.lang.String getFileId() {
        return this.fileId;
    }

    public void setFileId(java.lang.String str) {
        this.fileId = str;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int i) {
        this.courseId = i;
    }

    public java.lang.String getStudyTaskId() {
        return this.studyTaskId;
    }

    public void setStudyTaskId(java.lang.String str) {
        this.studyTaskId = str;
    }

    public java.lang.String getXotParam() {
        return this.xotParam;
    }

    public void setXotParam(java.lang.String str) {
        this.xotParam = str;
    }

    public int getReTest() {
        return this.reTest;
    }

    public void setReTest(int i) {
        this.reTest = i;
    }

    public boolean isReTest() {
        return this.reTest == 1;
    }

    public boolean isOpenNewWebView() {
        return this.openNewWebView;
    }

    public void setOpenNewWebView(boolean z) {
        this.openNewWebView = z;
    }

    public java.lang.String getLinkedData() {
        return this.linkedData;
    }

    public void setLinkedData(java.lang.String str) {
        this.linkedData = str;
    }

    public java.lang.String getBookInfo() {
        return this.bookInfo;
    }

    public void setBookInfo(java.lang.String str) {
        this.bookInfo = str;
    }

    public java.lang.String getExtraData() {
        return this.extraData;
    }

    public com.alibaba.fastjson.JSONObject getExtraDataJsonObject() {
        if (android.text.TextUtils.isEmpty(this.extraData)) {
            return new com.alibaba.fastjson.JSONObject();
        }
        try {
            return com.alibaba.fastjson.JSONObject.parseObject(this.extraData);
        } catch (java.lang.Exception unused) {
            return new com.alibaba.fastjson.JSONObject();
        }
    }

    public boolean fromHistory() {
        return getExtraDataJsonObject().getBooleanValue("fromHistory");
    }

    public void setExtraData(java.lang.String str) {
        this.extraData = str;
    }

    public boolean isCanUse() {
        return this.canUse;
    }

    public void setCanUse(boolean z) {
        this.canUse = z;
    }

    public boolean isReport() {
        return this.isReport;
    }

    public void setIsReport(boolean z) {
        this.isReport = z;
    }

    public void setReport(boolean z) {
        this.isReport = z;
    }

    public java.lang.String toString() {
        return "V8OpenWebViewParams{scene='" + this.scene + "', title='" + this.title + "', url='" + this.url + "', bookId='" + this.bookId + "', taskId='" + this.taskId + "', fileId='" + this.fileId + "', courseId=" + this.courseId + ", studyTaskId='" + this.studyTaskId + "', xotParam='" + this.xotParam + "', reTest=" + this.reTest + ", openNewWebView=" + this.openNewWebView + ", extraData='" + this.extraData + "', linkedData='" + this.linkedData + "', bookInfo='" + this.bookInfo + "', canUse=" + this.canUse + ", isReport=" + this.isReport + '}';
    }
}
