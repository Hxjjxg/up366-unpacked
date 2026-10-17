package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TaskUploadStatusHelper {
    public static final int ERR_INTERRUPT = -702;
    public static final int ERR_REPEAT = -701;

    public static java.lang.String get() {
        int errCode;
        java.lang.String errInfo;
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        long currentNtpTimeInSecond = com.up366.common.TimeUtils.getCurrentNtpTimeInSecond() - 180;
        java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadLog> taskList = com.up366.mobile.common.logic.Auth.cur().logMgr().getTaskList();
        if (com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask != null && com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID) != null) {
            jSONObject.put(com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID), com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask);
        }
        for (com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog : taskList) {
            int i = 1;
            if (batchUploadLog.getType() != 1) {
                com.up366.common.log.Logger.info("TAG - TaskUploadStatusHelper - get - not BATCH_TASK type " + batchUploadLog);
            } else {
                com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
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
                jSONObject2.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, batchUploadLog.getStudyTaskId());
                jSONObject2.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, batchUploadLog.getRefKey());
                jSONObject2.put("code", java.lang.Integer.valueOf(errCode));
                jSONObject2.put("info", errInfo);
                jSONObject2.put("status", java.lang.Integer.valueOf(i));
                jSONObject2.put("max", java.lang.Long.valueOf(batchUploadLog.getTotalFileSize()));
                jSONObject2.put("progress", java.lang.Long.valueOf(batchUploadLog.getUploadFileSize()));
                jSONObject2.put("percent", java.lang.Integer.valueOf(batchUploadLog.getPercent()));
                jSONObject.put(batchUploadLog.getRefKey(), jSONObject2);
            }
        }
        com.up366.common.log.Logger.info("TAG - TaskUploadStatusHelper - " + jSONObject.toJSONString());
        return jSONObject.toJSONString();
    }

    public static java.lang.String getV8() {
        int errCode;
        java.lang.String errInfo;
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        long currentNtpTimeInSecond = com.up366.common.TimeUtils.getCurrentNtpTimeInSecond() - 180;
        java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadLog> taskList = com.up366.mobile.common.logic.Auth.cur().logMgr().getTaskList();
        if (com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask != null && com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.getString("key") != null) {
            jSONObject.put(com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.getString("key"), com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask);
        }
        for (com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog : taskList) {
            if (batchUploadLog.getType() == 1 || batchUploadLog.getType() == 26) {
                com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
                int state = batchUploadLog.getState();
                int i = -1;
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
                jSONObject2.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, batchUploadLog.getStudyTaskId());
                jSONObject2.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, batchUploadLog.getTaskId());
                jSONObject2.put("code", java.lang.Integer.valueOf(errCode));
                jSONObject2.put("info", errInfo);
                jSONObject2.put("status", java.lang.Integer.valueOf(i));
                jSONObject2.put("max", java.lang.Long.valueOf(batchUploadLog.getTotalFileSize()));
                jSONObject2.put("progress", java.lang.Long.valueOf(batchUploadLog.getUploadFileSize()));
                jSONObject.put(batchUploadLog.getRefKey(), jSONObject2);
            }
        }
        com.up366.common.log.Logger.info("TAG - TaskUploadStatusHelper - " + jSONObject.toJSONString());
        return jSONObject.toJSONString();
    }

    public static java.lang.String getV9() {
        int errCode;
        java.lang.String errInfo;
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        long currentNtpTimeInSecond = com.up366.common.TimeUtils.getCurrentNtpTimeInSecond() - 180;
        java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadLog> taskList = com.up366.mobile.common.logic.Auth.cur().logMgr().getTaskList();
        if (com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask != null && com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.getString("key") != null) {
            jSONObject.put(com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.getString("key"), com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask);
        }
        for (com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog : taskList) {
            if (batchUploadLog.getType() == 1 || batchUploadLog.getType() == 28) {
                com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
                int state = batchUploadLog.getState();
                int i = -1;
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
                jSONObject2.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, batchUploadLog.getStudyTaskId());
                jSONObject2.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, batchUploadLog.getTaskId());
                jSONObject2.put("code", java.lang.Integer.valueOf(errCode));
                jSONObject2.put("info", errInfo);
                jSONObject2.put("status", java.lang.Integer.valueOf(i));
                jSONObject2.put("max", java.lang.Long.valueOf(batchUploadLog.getTotalFileSize()));
                jSONObject2.put("progress", java.lang.Long.valueOf(batchUploadLog.getUploadFileSize()));
                jSONObject.put(batchUploadLog.getRefKey(), jSONObject2);
            }
        }
        com.up366.common.log.Logger.info("TAG - TaskUploadStatusHelper - " + jSONObject.toJSONString());
        return jSONObject.toJSONString();
    }
}
