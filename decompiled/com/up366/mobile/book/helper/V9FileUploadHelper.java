package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V9FileUploadHelper {
    private final com.up366.mobile.book.studyviews.StudyV9View studyV9View;

    public V9FileUploadHelper(com.up366.mobile.book.studyviews.StudyV9View studyV9View) {
        this.studyV9View = studyV9View;
    }

    public void onMessageEvent_BATCH_JS_UPLOAD(com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        if (commonUploadLogEvent.getType() != 10) {
            return;
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.igexin.push.core.b.C, commonUploadLogEvent.getRefKey());
        jSONObject.put("progress", java.lang.Integer.valueOf(commonUploadLogEvent.getPercent()));
        jSONObject.put("errorCode", java.lang.Integer.valueOf(commonUploadLogEvent.getErrCode()));
        jSONObject.put("msg", commonUploadLogEvent.getErrInfo());
        jSONObject.put("size", java.lang.Long.valueOf(commonUploadLogEvent.getTotalFileSize()));
        jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, com.alibaba.fastjson.JSON.parseObject(commonUploadLogEvent.getParams()).get(com.up366.mobile.commonui.CommonWebViewActivity.URL));
        if (commonUploadLogEvent.isProgressUpdate()) {
            jSONObject.put("status", 0);
        }
        if (commonUploadLogEvent.isFailed()) {
            com.up366.mobile.common.logic.Auth.cur().logMgr().deleteTask(commonUploadLogEvent.getBatchId());
            jSONObject.put("status", -1);
        }
        if (commonUploadLogEvent.isSuccess()) {
            jSONObject.put("status", 1);
        }
        this.studyV9View.registerHelper.callJsEvent("fileUpload", "(%s)", jSONObject.toJSONString());
    }

    public void onMessageEvent_BATCH_TASK(com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        if (commonUploadLogEvent.getType() != 1) {
            return;
        }
        if (commonUploadLogEvent.isProgressUpdate()) {
            callJsOnUpload(0, commonUploadLogEvent);
        }
        if (commonUploadLogEvent.isFailed()) {
            callJsOnUpload(1, commonUploadLogEvent);
        }
        if (commonUploadLogEvent.isSuccess()) {
            callJsOnUpload(-1, commonUploadLogEvent);
        }
    }

    public void onMessageEvent_BATCH_APP_LOG(com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        if (commonUploadLogEvent.getType() != 27) {
            return;
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(commonUploadLogEvent.getParams());
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.igexin.push.core.b.C, commonUploadLogEvent.getRefKey());
        jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, object.get(com.up366.mobile.commonui.CommonWebViewActivity.URL));
        jSONObject.put("msg", commonUploadLogEvent.getErrInfo());
        jSONObject.put("uploadSize", java.lang.Long.valueOf(commonUploadLogEvent.getOverFileSize()));
        jSONObject.put("totalSize", java.lang.Long.valueOf(commonUploadLogEvent.getTotalFileSize()));
        if (commonUploadLogEvent.isProgressUpdate()) {
            jSONObject.put("code", 2);
        }
        if (commonUploadLogEvent.isFailed()) {
            jSONObject.put("code", -1);
        }
        if (commonUploadLogEvent.isSuccess()) {
            jSONObject.put("code", 3);
        }
        this.studyV9View.registerHelper.callJsEvent("appLogsUpload", "(%s)", jSONObject.toJSONString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    public void onMessageEvent_BATCH_JS_UPLOAD_COMMON_V9(com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        if (commonUploadLogEvent.getType() != 28) {
            return;
        }
        ?? IsFailed = commonUploadLogEvent.isFailed();
        if (commonUploadLogEvent.isSuccess()) {
            IsFailed = -1;
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("status", java.lang.Integer.valueOf((int) IsFailed));
        jSONObject.put("code", java.lang.Integer.valueOf(commonUploadLogEvent.getErrCode()));
        jSONObject.put("info", commonUploadLogEvent.getErrInfo());
        jSONObject.put("max", java.lang.Long.valueOf(commonUploadLogEvent.getTotalFileSize()));
        jSONObject.put("progress", java.lang.Long.valueOf(java.lang.Math.min(commonUploadLogEvent.getTotalFileSize(), commonUploadLogEvent.getOverFileSize())));
        jSONObject.put("key", commonUploadLogEvent.getRefKey());
        this.studyV9View.registerHelper.callJsEvent("taskUpload", "(%s)", jSONObject.toJSONString());
    }

    private void callJsOnUpload(int i, com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("status", java.lang.Integer.valueOf(i));
        jSONObject.put("code", java.lang.Integer.valueOf(commonUploadLogEvent.getErrCode()));
        jSONObject.put("info", commonUploadLogEvent.getErrInfo());
        jSONObject.put("max", java.lang.Long.valueOf(commonUploadLogEvent.getTotalFileSize()));
        jSONObject.put("progress", java.lang.Long.valueOf(java.lang.Math.min(commonUploadLogEvent.getTotalFileSize(), commonUploadLogEvent.getOverFileSize())));
        jSONObject.put("key", commonUploadLogEvent.getRefKey());
        this.studyV9View.registerHelper.callJsEvent("taskUpload", "(%s)", jSONObject.toJSONString());
    }
}
