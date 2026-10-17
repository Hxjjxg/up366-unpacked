package com.up366.mobile.book.exercise.js;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ExerciseUploadStatusHelper {
    public static final int ERR_INTERRUPT = -702;
    public static final int ERR_REPEAT = -701;
    private static java.util.List<java.lang.Long> filter = new java.util.ArrayList();

    public static java.lang.String get() {
        int errCode;
        java.lang.String errInfo;
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        long currentNtpTimeInSecond = com.up366.common.TimeUtils.getCurrentNtpTimeInSecond() - 180;
        java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadLog> taskList = com.up366.mobile.common.logic.Auth.cur().logMgr().getTaskList();
        if (com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask != null) {
            java.lang.String string = com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.getString("testId");
            if (!com.up366.common.StringUtils.isEmptyOrNull(string)) {
                jSONObject.put(string, com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask);
            }
            java.lang.String string2 = com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID);
            if (!com.up366.common.StringUtils.isEmptyOrNull(string2)) {
                jSONObject.put(string2, com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask);
            }
            java.lang.String string3 = com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.getString("uploadId");
            if (!com.up366.common.StringUtils.isEmptyOrNull(string3)) {
                jSONObject.put(string3, com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask);
            }
        }
        java.util.Collections.sort(taskList, new java.util.Comparator() { // from class: com.up366.mobile.book.exercise.js.ExerciseUploadStatusHelper$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return java.lang.Long.compare(((com.up366.mobile.common.logic.log.model.BatchUploadLog) obj).getAddTime(), ((com.up366.mobile.common.logic.log.model.BatchUploadLog) obj2).getAddTime());
            }
        });
        for (com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog : taskList) {
            int i = 1;
            if (batchUploadLog.getType() == 0 || batchUploadLog.getType() == 1) {
                if (!filter.contains(batchUploadLog.getRowId())) {
                    com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
                    batchUploadLog.getErrCode();
                    batchUploadLog.getErrInfo();
                    int state = batchUploadLog.getState();
                    if (state == -1) {
                        errCode = batchUploadLog.getErrCode();
                        errInfo = batchUploadLog.getErrInfo();
                    } else if (state == 0 || state == 1) {
                        if (batchUploadLog.getUpdateTime() < currentNtpTimeInSecond) {
                            errCode = -702;
                            errInfo = "上传任务被强制中断";
                        } else {
                            i = 0;
                            errInfo = "上传中";
                            errCode = 0;
                        }
                    } else if (state != 2) {
                        com.up366.common.log.Logger.warn("TAG - ExerciseUploadStatusHelper - get - un handler " + state);
                    }
                    if (!com.up366.mobile.common.logic.Auth.isAuth()) {
                        errCode = -23;
                        errInfo = "未登录";
                    }
                    jSONObject2.put("code", java.lang.Integer.valueOf(errCode));
                    jSONObject2.put("info", errInfo);
                    jSONObject2.put("status", java.lang.Integer.valueOf(i));
                    jSONObject2.put("max", java.lang.Long.valueOf(batchUploadLog.getTotalFileSize()));
                    jSONObject2.put("progress", java.lang.Long.valueOf(batchUploadLog.getUploadFileSize()));
                    jSONObject2.put("percent", java.lang.Integer.valueOf(batchUploadLog.getPercent()));
                    jSONObject2.put("__row_id__", batchUploadLog.getRowId());
                    com.alibaba.fastjson.JSONObject jSONObject3 = jSONObject.getJSONObject(batchUploadLog.getRefKey());
                    if (jSONObject3 != null) {
                        filter.add(java.lang.Long.valueOf(jSONObject3.getLongValue("__row_id__")));
                    }
                    jSONObject.put(batchUploadLog.getRefKey(), jSONObject2);
                }
            }
        }
        com.up366.common.log.Logger.info("TAG - ExerciseUploadStatusHelper - " + jSONObject.toJSONString());
        return jSONObject.toJSONString();
    }
}
