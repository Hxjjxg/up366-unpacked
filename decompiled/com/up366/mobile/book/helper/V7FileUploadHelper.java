package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V7FileUploadHelper {
    private final com.up366.mobile.book.studyviews.StudyV7View studyV7View;

    public V7FileUploadHelper(com.up366.mobile.book.studyviews.StudyV7View studyV7View) {
        this.studyV7View = studyV7View;
    }

    public void onMessageEvent_BATCH_JS_UPLOAD(com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        if (commonUploadLogEvent.getType() != 10) {
            return;
        }
        if (commonUploadLogEvent.isProgressUpdate()) {
            callJsOnUploadPro(commonUploadLogEvent);
        }
        if (commonUploadLogEvent.isFailed()) {
            com.up366.mobile.common.logic.Auth.cur().logMgr().deleteTask(commonUploadLogEvent.getBatchId());
            callJsOnUploadPro(commonUploadLogEvent);
        }
        if (commonUploadLogEvent.isSuccess()) {
            callJsOnUploadPro(commonUploadLogEvent);
        }
    }

    private void callJsOnUploadPro(com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("code", java.lang.Integer.valueOf(commonUploadLogEvent.getErrCode()));
        jSONObject2.put("msg", commonUploadLogEvent.getErrInfo());
        com.alibaba.fastjson.JSONObject jSONObject3 = new com.alibaba.fastjson.JSONObject();
        jSONObject3.put(com.igexin.push.core.b.C, commonUploadLogEvent.getRefKey());
        jSONObject3.put("percent", java.lang.Integer.valueOf(commonUploadLogEvent.getPercent()));
        jSONObject.put("result", jSONObject2);
        jSONObject.put("data", jSONObject3);
        this.studyV7View.registerHelper.callJsEvent("fileupload", "(%s)", jSONObject.toJSONString());
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

    private void callJsOnUpload(int i, com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("type", "_EVT_UPLOADTASK_");
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("status", java.lang.Integer.valueOf(i));
        jSONObject2.put("code", java.lang.Integer.valueOf(commonUploadLogEvent.getErrCode()));
        jSONObject2.put("info", commonUploadLogEvent.getErrInfo());
        jSONObject2.put("max", java.lang.Long.valueOf(commonUploadLogEvent.getTotalFileSize()));
        jSONObject2.put("progress", java.lang.Long.valueOf(java.lang.Math.min(commonUploadLogEvent.getTotalFileSize(), commonUploadLogEvent.getOverFileSize())));
        jSONObject2.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, commonUploadLogEvent.getRefKey());
        java.lang.String batchId = commonUploadLogEvent.getBatchId();
        jSONObject2.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, batchId.contains(";") ? batchId.split(";")[0] : null);
        jSONObject.put("detail", jSONObject2);
        this.studyV7View.registerHelper.callJsEvent("message", "(%s)", jSONObject.toJSONString());
    }
}
