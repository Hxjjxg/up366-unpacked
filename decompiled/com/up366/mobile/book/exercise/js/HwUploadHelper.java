package com.up366.mobile.book.exercise.js;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class HwUploadHelper {
    /* JADX INFO: renamed from: submitToServer, reason: merged with bridge method [inline-methods] */
    public void lambda$submitToServer$0(final java.lang.String str, final java.lang.String str2, final long j, final long j2, final int i, final java.lang.String str3, final java.lang.String str4, final java.lang.String str5, final java.lang.String str6) {
        if (com.up366.common.task.TaskUtils.isMainThread()) {
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.HwUploadHelper$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$submitToServer$0(str, str2, j, j2, i, str3, str4, str5, str6);
                }
            });
            return;
        }
        final java.lang.String str7 = com.up366.common.StringUtils.isEmptyOrNull(str3) ? "<elements></elements>" : str3;
        com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(0, str);
        if (!com.up366.common.StringUtils.isEmptyOrNull(str4)) {
            new com.up366.mobile.book.helper.DataHelper();
            java.lang.String[] strArrSplit = str4.split(";");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.String str8 : strArrSplit) {
                if (!com.up366.common.StringUtils.isEmptyOrNull(str8) && !arrayList.contains(str8)) {
                    arrayList.add(str8);
                    com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoLoadSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().loadSync(str8, null);
                    if (fileMapInfoLoadSync == null) {
                        com.up366.common.log.Logger.error("TAG - HwUploadHelper - submitToServer - find local file error : " + str8);
                    } else if (fileMapInfoLoadSync.getPath().endsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.WAV)) {
                        com.up366.mobile.common.logic.Auth.cur().bookLog().addRecordBatchUploadFile(batchUploadLog, fileMapInfoLoadSync);
                    } else {
                        com.up366.mobile.common.logic.Auth.cur().bookLog().addBatchUploadFile(batchUploadLog, fileMapInfoLoadSync);
                    }
                }
            }
        }
        batchUploadLog.addTask(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.submitAnswerData) { // from class: com.up366.mobile.book.exercise.js.HwUploadHelper.1
            @Override // com.up366.common.http.RequestParams
            public void initHeaders(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("clientType", (short) 1);
            }

            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("student_uuid", com.up366.mobile.common.logic.Auth.getUserInfo().getUuid());
                map.put("testId", str);
                map.put("paperId", str2);
                map.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
                map.put("testno", "1");
                map.put("beginTime", com.up366.common.TimeUtils.formatTime(j, "yyyy-MM-dd HH:mm:ss"));
                map.put("endTime", com.up366.common.TimeUtils.formatTime(j2, "yyyy-MM-dd HH:mm:ss"));
                map.put("answerData", str7);
                map.put("spid", com.up366.mobile.common.base.Constants.DEFAULT_SPID);
                map.put("playData", com.up366.common.StringUtils.isEmptyOrNull(str6) ? "[]" : str6);
                map.put("timeData", com.up366.common.StringUtils.isEmptyOrNull(str5) ? "[]" : str5);
                map.put("duration", java.lang.String.valueOf(i / 1000));
            }
        });
        com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent("", str);
        if (com.up366.mobile.common.logic.Auth.isAuth()) {
            com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
        } else {
            com.up366.mobile.common.logic.Auth.cur().logMgr().addToHistory(batchUploadLog);
        }
    }
}
