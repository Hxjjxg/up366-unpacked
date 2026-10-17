package com.up366.mobile.course.p1p.log;

/* JADX INFO: compiled from: P1pLogHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\"\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005J \u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005JQ\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/up366/mobile/course/p1p/log/P1pLogHelper;", "", "<init>", "()V", "TAG", "", "taskInfo", "Lcom/up366/mobile/course/task/TaskInfoV2;", "alarmExecutor", "Lcom/up366/common/task/TaskExecutor;", "kotlin.jvm.PlatformType", "Lcom/up366/common/task/TaskExecutor;", "setTaskInfo", "", "taskInfoV2", "buildLog", "logKey", com.igexin.sdk.FlymePushReceiver.CONTENT, "buildLogWithUploadFile", "file", "Lcom/alibaba/fastjson/JSONObject;", "buildLogAlarm", "alarmCode", "errCode", "", "errMsg", "layoutJson", "paperCode", "picUrls", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class P1pLogHelper {
    private static final java.lang.String TAG = "p1p-student-answer";
    private static com.up366.mobile.course.task.TaskInfoV2 taskInfo;
    public static final com.up366.mobile.course.p1p.log.P1pLogHelper INSTANCE = new com.up366.mobile.course.p1p.log.P1pLogHelper();
    private static final com.up366.common.task.TaskExecutor alarmExecutor = com.up366.common.task.TaskUtils.createSerialExecutor("p1p-alarm-log");

    private P1pLogHelper() {
    }

    public final void setTaskInfo(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(taskInfoV2, "taskInfoV2");
        taskInfo = taskInfoV2;
        java.util.HashMap map = new java.util.HashMap();
        java.util.HashMap map2 = map;
        com.up366.mobile.course.task.TaskInfoV2 taskInfoV22 = taskInfo;
        kotlin.jvm.internal.Intrinsics.checkNotNull(taskInfoV22);
        map2.put("contentId", taskInfoV22.getContentId());
        com.up366.mobile.course.task.TaskInfoV2 taskInfoV23 = taskInfo;
        kotlin.jvm.internal.Intrinsics.checkNotNull(taskInfoV23);
        map2.put("jobName", taskInfoV23.getJobName());
        com.up366.mobile.course.task.TaskInfoV2 taskInfoV24 = taskInfo;
        kotlin.jvm.internal.Intrinsics.checkNotNull(taskInfoV24);
        map2.put("jobId", taskInfoV24.getJobId());
        com.up366.mobile.course.task.TaskInfoV2 taskInfoV25 = taskInfo;
        kotlin.jvm.internal.Intrinsics.checkNotNull(taskInfoV25);
        int courseId = taskInfoV25.getCourseId();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(courseId);
        map2.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, sb.toString());
        if (com.up366.mobile.common.logic.Auth.getUserInfo() != null) {
            map2.put("username", com.up366.mobile.common.logic.Auth.getUserInfo().getUsername());
            map2.put("uid", java.lang.String.valueOf(com.up366.mobile.common.logic.Auth.getUserInfo().getUid()));
            map2.put("organId", java.lang.String.valueOf(com.up366.mobile.common.logic.Auth.getUserInfo().getOrganId()));
        }
        com.up366.common.log.Logger.info("setTaskInfo " + com.alibaba.fastjson.JSON.toJSONString(map));
    }

    public final java.lang.String buildLog(java.lang.String logKey, java.lang.String content) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(logKey, "logKey");
        return "p1p-student-answer:" + logKey + " - " + content;
    }

    public final void buildLogWithUploadFile(java.lang.String logKey, java.lang.String content, java.lang.String file) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(logKey, "logKey");
        java.util.Map jSONObject = new com.alibaba.fastjson.JSONObject();
        java.lang.String str = content;
        if (str != null && str.length() != 0) {
            jSONObject.put("msg", content);
        }
        buildLogWithUploadFile(logKey, (com.alibaba.fastjson.JSONObject) jSONObject, file);
    }

    public final void buildLogWithUploadFile(final java.lang.String logKey, final com.alibaba.fastjson.JSONObject content, final java.lang.String file) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(logKey, "logKey");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(content, com.igexin.sdk.FlymePushReceiver.CONTENT);
        if (com.up366.mobile.common.utils.PlatformUtils.isCustomClosePad()) {
            com.up366.common.log.Logger.info("custompad  p1p-student-answer:" + logKey + " - " + content.toJSONString() + " : " + file + " ");
            return;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(file) || !com.up366.common.FileUtilsUp.isFileExists(file)) {
            com.up366.common.log.Logger.info("p1p-student-answer:" + logKey + " - " + content.toJSONString());
            return;
        }
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.p1p.log.P1pLogHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.p1p.log.P1pLogHelper.buildLogWithUploadFile$lambda$0(file, logKey, content);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildLogWithUploadFile$lambda$0(java.lang.String str, java.lang.String str2, com.alibaba.fastjson.JSONObject jSONObject) {
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo = com.up366.mobile.common.logic.Auth.cur().fileMgr().getFileMapInfo(null, str);
        if (fileMapInfo == null) {
            com.up366.common.log.Logger.info("p1p-student-answer:" + str2 + " - " + jSONObject.toJSONString());
            return;
        }
        com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(2, fileMapInfo.getPath(), -1);
        batchUploadLog.addFile(new java.io.File(fileMapInfo.getPath()), fileMapInfo.getObjectId());
        com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
        ((java.util.Map) jSONObject).put(com.up366.mobile.commonui.CommonWebViewActivity.URL, fileMapInfo.getUrl());
        com.up366.common.log.Logger.info("p1p-student-answer:" + str2 + " - " + jSONObject.toJSONString() + " ");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void buildLogAlarm(final java.lang.String alarmCode, final int errCode, java.lang.String errMsg, final java.lang.String layoutJson, final java.lang.String paperCode, final java.lang.String[] picUrls) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(alarmCode, "alarmCode");
        if (taskInfo == null) {
            com.up366.common.log.Logger.error("buildLogAlarm error , taskInfo is null");
        }
        final com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        java.util.Map map = (java.util.Map) jSONObject;
        com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 = taskInfo;
        kotlin.jvm.internal.Intrinsics.checkNotNull(taskInfoV2);
        map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(taskInfoV2.getCourseId()));
        com.up366.mobile.course.task.TaskInfoV2 taskInfoV22 = taskInfo;
        kotlin.jvm.internal.Intrinsics.checkNotNull(taskInfoV22);
        map.put("jobId", taskInfoV22.getJobId());
        com.up366.mobile.course.task.TaskInfoV2 taskInfoV23 = taskInfo;
        kotlin.jvm.internal.Intrinsics.checkNotNull(taskInfoV23);
        map.put("jobName", taskInfoV23.getJobName());
        switch (alarmCode.hashCode()) {
            case -1002294155:
                if (!alarmCode.equals(com.up366.mobile.common.helper.AlarmLogHelper.P1p._006002001)) {
                }
                map.put("errCode", java.lang.Integer.valueOf(errCode));
                map.put("errMsg", errMsg);
                com.up366.common.log.Logger.error(com.up366.mobile.common.helper.AlarmLogHelper.INSTANCE.buildAlarmLog(alarmCode, jSONObject));
                break;
            case -1002294154:
                if (!alarmCode.equals(com.up366.mobile.common.helper.AlarmLogHelper.P1p._006002002)) {
                }
                map.put("errCode", java.lang.Integer.valueOf(errCode));
                map.put("errMsg", errMsg);
                com.up366.common.log.Logger.error(com.up366.mobile.common.helper.AlarmLogHelper.INSTANCE.buildAlarmLog(alarmCode, jSONObject));
                break;
            case -1002294153:
                if (!alarmCode.equals(com.up366.mobile.common.helper.AlarmLogHelper.P1p._006002003)) {
                }
                alarmExecutor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.p1p.log.P1pLogHelper$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        com.up366.mobile.course.p1p.log.P1pLogHelper.buildLogAlarm$lambda$1(jSONObject, errCode, layoutJson, paperCode, picUrls, alarmCode);
                    }
                });
                break;
            case -1002294152:
                if (!alarmCode.equals(com.up366.mobile.common.helper.AlarmLogHelper.P1p._006002004)) {
                }
                alarmExecutor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.p1p.log.P1pLogHelper$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        com.up366.mobile.course.p1p.log.P1pLogHelper.buildLogAlarm$lambda$1(jSONObject, errCode, layoutJson, paperCode, picUrls, alarmCode);
                    }
                });
                break;
            case -1002294151:
                if (!alarmCode.equals(com.up366.mobile.common.helper.AlarmLogHelper.P1p._006002005)) {
                }
                alarmExecutor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.p1p.log.P1pLogHelper$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        com.up366.mobile.course.p1p.log.P1pLogHelper.buildLogAlarm$lambda$1(jSONObject, errCode, layoutJson, paperCode, picUrls, alarmCode);
                    }
                });
                break;
            case -1002294150:
                if (!alarmCode.equals(com.up366.mobile.common.helper.AlarmLogHelper.P1p._006002006)) {
                }
                alarmExecutor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.p1p.log.P1pLogHelper$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        com.up366.mobile.course.p1p.log.P1pLogHelper.buildLogAlarm$lambda$1(jSONObject, errCode, layoutJson, paperCode, picUrls, alarmCode);
                    }
                });
                break;
            case -1002294149:
                if (!alarmCode.equals(com.up366.mobile.common.helper.AlarmLogHelper.P1p._006002007)) {
                }
                alarmExecutor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.p1p.log.P1pLogHelper$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        com.up366.mobile.course.p1p.log.P1pLogHelper.buildLogAlarm$lambda$1(jSONObject, errCode, layoutJson, paperCode, picUrls, alarmCode);
                    }
                });
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildLogAlarm$lambda$1(com.alibaba.fastjson.JSONObject jSONObject, int i, java.lang.String str, java.lang.String str2, java.lang.String[] strArr, java.lang.String str3) {
        java.util.Map map = (java.util.Map) jSONObject;
        map.put("errCode", java.lang.Integer.valueOf(i));
        if (str != null) {
            map.put("layoutJson", str);
        }
        if (str2 != null) {
            map.put("paperCode", str2);
        }
        java.lang.String picUrls = com.up366.mobile.common.helper.AlarmLogHelper.INSTANCE.getPicUrls(strArr);
        if (picUrls.length() > 0) {
            map.put("picUrls", picUrls);
        }
        com.up366.common.log.Logger.error(com.up366.mobile.common.helper.AlarmLogHelper.INSTANCE.buildAlarmLog(str3, jSONObject));
    }
}
