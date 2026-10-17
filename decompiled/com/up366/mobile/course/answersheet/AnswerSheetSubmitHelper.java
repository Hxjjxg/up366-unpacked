package com.up366.mobile.course.answersheet;

/* JADX INFO: compiled from: AnswerSheetSubmitHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u001e\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\f¨\u0006\u000f"}, d2 = {"Lcom/up366/mobile/course/answersheet/AnswerSheetSubmitHelper;", "", "<init>", "()V", "submit", "", "imageList", "", "Lcom/up366/mobile/common/utils/alifile/FileMapInfo;", "submitJson", "Lcom/alibaba/fastjson/JSONObject;", com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, "", com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, "submitKey", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnswerSheetSubmitHelper {
    public static final com.up366.mobile.course.answersheet.AnswerSheetSubmitHelper INSTANCE = new com.up366.mobile.course.answersheet.AnswerSheetSubmitHelper();

    private AnswerSheetSubmitHelper() {
    }

    public final void submit(java.util.Set<com.up366.mobile.common.utils.alifile.FileMapInfo> imageList, com.alibaba.fastjson.JSONObject submitJson, java.lang.String studyTaskId, java.lang.String courseId) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(submitJson, "submitJson");
        final java.lang.String jSONString = submitJson.toJSONString();
        com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(24, studyTaskId);
        if (imageList != null) {
            for (com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo : imageList) {
                batchUploadLog.addFile(new java.io.File(fileMapInfo.getPath()), fileMapInfo.getObjectId());
            }
        }
        final java.lang.String utV2 = com.up366.common.StringUtils.getUtV2(jSONString, "submitTaskToken");
        batchUploadLog.addTask(new com.up366.common.http.RequestParams<java.lang.String>() { // from class: com.up366.mobile.course.answersheet.AnswerSheetSubmitHelper$submit$requestCommon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(com.up366.mobile.common.http.HttpMgrUtils.PHOTO_ANSWER_SUBMIT);
            }

            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> params) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(params, "params");
                params.put("ut", utV2);
                params.put("ocrTaskJson", jSONString);
                com.up366.common.log.Logger.info(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("PhotoAnswerSubmitTask", "result: " + params));
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response resp, java.lang.String result) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(resp, "resp");
                super.onResponse(resp, result);
                com.up366.common.log.Logger.info(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("submitTaskAnswerResult", "result: " + resp));
            }
        });
        com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
        if (courseId == null || studyTaskId == null) {
            return;
        }
        com.up366.mobile.book.oplog.StudyOpLogHelper.recordOpLog(batchUploadLog.getOpLogId(), studyTaskId, courseId);
    }

    public final void submit(java.util.Set<com.up366.mobile.common.utils.alifile.FileMapInfo> imageList, java.lang.String submitKey) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(submitKey, "submitKey");
        com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(24, submitKey);
        if (imageList != null) {
            for (com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo : imageList) {
                batchUploadLog.addFile(new java.io.File(fileMapInfo.getPath()), fileMapInfo.getObjectId());
            }
        }
        com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
    }
}
