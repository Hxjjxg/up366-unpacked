package com.up366.mobile.common.onlinelog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ActionLogTool {
    private static final int MAX_BUFFER_SIZE = 500;
    private static final java.util.concurrent.ConcurrentLinkedQueue<com.up366.mobile.common.onlinelog.ActionLogTool.StoredLog> logBuffer = new java.util.concurrent.ConcurrentLinkedQueue<>();
    private static final java.util.concurrent.atomic.AtomicBoolean isProcessingBuffer = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static final com.up366.common.task.TaskExecutor logExecutor = com.up366.common.task.TaskUtils.createSerialExecutor("ActionLogTool");
    private static long syncBaseElapsedTime = -1;
    private static long syncReliableTime = -1;
    private static long currentBatchId = -1;
    private static boolean isAfterResignActive = false;

    private ActionLogTool() {
    }

    public static void append(java.lang.String str) {
        if (!com.up366.mobile.AppStateMonitor.INSTANCE.canRecordEvent(str)) {
            com.up366.common.log.Logger.info("canRecordEvent ，忽略日志: " + str);
        } else if (com.up366.mobile.common.utils.TimeSyncMgr.isTimeManipulated()) {
            bufferLog(str);
            com.up366.mobile.common.utils.TimeSyncMgr.syncNtpTime();
        } else {
            logMessage(str);
        }
    }

    public static void onTimeSyncSuccess() {
        syncBaseElapsedTime = android.os.SystemClock.elapsedRealtime();
        syncReliableTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        processBufferedLogs();
    }

    private static void bufferLog(java.lang.String str) {
        java.util.concurrent.ConcurrentLinkedQueue<com.up366.mobile.common.onlinelog.ActionLogTool.StoredLog> concurrentLinkedQueue = logBuffer;
        if (concurrentLinkedQueue.size() >= 500) {
            concurrentLinkedQueue.poll();
            com.up366.common.log.Logger.warn("日志缓冲区已满，丢弃最旧的日志");
        }
        if (com.up366.mobile.common.onlinelog.OpLogData.Event.EXIT_APP.equals(com.alibaba.fastjson.JSON.parseObject(str).getString("event"))) {
            return;
        }
        concurrentLinkedQueue.offer(new com.up366.mobile.common.onlinelog.ActionLogTool.StoredLog(str, android.os.SystemClock.elapsedRealtime()));
        com.up366.common.log.Logger.info("时间不可靠，暂存日志，当前缓冲数量: " + concurrentLinkedQueue.size());
    }

    private static void processBufferedLogs() {
        if (isProcessingBuffer.getAndSet(true)) {
            return;
        }
        logExecutor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.onlinelog.ActionLogTool$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.common.onlinelog.ActionLogTool.processLogs();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processLogs() {
        try {
            java.util.concurrent.ConcurrentLinkedQueue<com.up366.mobile.common.onlinelog.ActionLogTool.StoredLog> concurrentLinkedQueue = logBuffer;
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            com.up366.common.log.Logger.info("开始处理缓冲日志，数量: " + concurrentLinkedQueue.size());
            while (true) {
                java.util.concurrent.ConcurrentLinkedQueue<com.up366.mobile.common.onlinelog.ActionLogTool.StoredLog> concurrentLinkedQueue2 = logBuffer;
                if (!concurrentLinkedQueue2.isEmpty()) {
                    com.up366.mobile.common.onlinelog.ActionLogTool.StoredLog storedLogPoll = concurrentLinkedQueue2.poll();
                    if (storedLogPoll != null) {
                        logMessage(correctLogTime(storedLogPoll));
                    }
                } else {
                    com.up366.common.log.Logger.info("缓冲日志处理完成");
                    return;
                }
            }
        } finally {
            isProcessingBuffer.set(false);
        }
    }

    private static java.lang.String correctLogTime(com.up366.mobile.common.onlinelog.ActionLogTool.StoredLog storedLog) {
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(storedLog.message);
            long jCalculateReliableTime = calculateReliableTime(storedLog.storageElapsedTime);
            object.put("evTime", com.up366.common.TimeUtils.formatTime(jCalculateReliableTime, "yyyy-MM-dd HH:mm:ss.SSS"));
            updateBatchIdIfNeeded(object, jCalculateReliableTime);
            return object.toJSONString();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("修正日志时间失败: " + e.getMessage(), e);
            return storedLog.message;
        }
    }

    private static long calculateReliableTime(long j) {
        long j2 = syncBaseElapsedTime;
        if (j2 != -1) {
            long j3 = syncReliableTime;
            if (j3 != -1) {
                return j3 + (j - j2);
            }
        }
        com.up366.common.log.Logger.warn("没有时间同步基准，使用当前系统时间");
        return com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
    }

    private static void updateBatchIdIfNeeded(com.alibaba.fastjson.JSONObject jSONObject, long j) {
        if (com.up366.mobile.common.onlinelog.OpLogData.Event.RESIGN_ACTIVE.equals(jSONObject.getString("event"))) {
            jSONObject.put("batchId", java.lang.Long.valueOf(currentBatchId));
            isAfterResignActive = true;
            return;
        }
        if (currentBatchId == -1 || isAfterResignActive) {
            currentBatchId = j;
            isAfterResignActive = false;
        }
        jSONObject.put("batchId", java.lang.Long.valueOf(currentBatchId));
    }

    private static void logMessage(java.lang.String str) {
        com.up366.common.log.Logger.info(" [U3Behavior]" + str + "[/U3Behavior]");
    }

    private static class StoredLog {
        java.lang.String message;
        long storageElapsedTime;

        StoredLog(java.lang.String str, long j) {
            this.message = str;
            this.storageElapsedTime = j;
        }
    }

    public static int getBufferedLogCount() {
        return logBuffer.size();
    }

    public static void clearBuffer() {
        logBuffer.clear();
    }

    public static java.lang.String getSyncStatus() {
        return "syncBaseElapsedTime: " + syncBaseElapsedTime + ", syncReliableTime: " + syncReliableTime + ", bufferedLogs: " + logBuffer.size();
    }
}
