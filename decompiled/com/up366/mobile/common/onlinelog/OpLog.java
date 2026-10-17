package com.up366.mobile.common.onlinelog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OpLog {
    private static final com.up366.mobile.common.onlinelog.OpLog instance = new com.up366.mobile.common.onlinelog.OpLog();
    private final java.util.Map<java.lang.String, java.lang.StringBuilder> map = new java.util.HashMap();
    private final com.up366.common.task.TaskExecutor executor = com.up366.common.task.TaskUtils.createSerialExecutor("OpLog");

    private OpLog() {
    }

    public static void record(final java.lang.String str, final java.lang.String str2) {
        instance.executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.onlinelog.OpLog$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.onlinelog.OpLog.lambda$record$0(str, str2);
            }
        });
    }

    static /* synthetic */ void lambda$record$0(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.lang.StringBuilder oldValue = getOldValue(str);
        oldValue.append(com.up366.common.TimeUtils.formatTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond(), "yyyy-MM-dd HH:mm:ss.SSS"));
        oldValue.append(":");
        oldValue.append(str2);
        oldValue.append("\n");
        if (oldValue.length() > 512000) {
            oldValue.delete(0, 102400);
        }
    }

    private static java.lang.StringBuilder getOldValue(java.lang.String str) {
        com.up366.mobile.common.onlinelog.OpLog opLog = instance;
        java.lang.StringBuilder sb = opLog.map.get(str);
        if (sb != null) {
            return sb;
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        opLog.map.put(str, sb2);
        return sb2;
    }

    public static void report(java.lang.String str, java.lang.String str2) {
        reportImpl(str, str2, null, null, null);
    }

    public static void report(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.fastjson.JSONObject jSONObject) {
        instance.writeOneLog(str, str2, str3, "", jSONObject, null);
    }

    public static void report(java.lang.String str, java.lang.String str2, java.lang.String str3, androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject> consumer) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        if (consumer != null) {
            consumer.accept(jSONObject);
        }
        instance.writeOneLog(str, str2, str3, "", jSONObject, null);
    }

    public static void report(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        reportImpl(str, str2, th, null, null);
    }

    public static void report(java.lang.String str, androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject> consumer) {
        reportImpl(str, "", null, consumer, null);
    }

    public static void report(java.lang.String str, final java.lang.String str2, androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject> consumer) {
        reportImpl(str, "", null, consumer, new androidx.core.util.Consumer() { // from class: com.up366.mobile.common.onlinelog.OpLog$$ExternalSyntheticLambda3
            public final void accept(java.lang.Object obj) {
                ((com.alibaba.fastjson.JSONObject) obj).put("control", str2);
            }
        });
    }

    public static void report(java.lang.String str, androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject> consumer, androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject> consumer2) {
        reportImpl(str, "", null, consumer, consumer2);
    }

    public static void report(java.lang.String str, java.lang.String str2, java.lang.Throwable th, final com.alibaba.fastjson.JSONObject jSONObject) {
        reportImpl(str, str2, th, new androidx.core.util.Consumer() { // from class: com.up366.mobile.common.onlinelog.OpLog$$ExternalSyntheticLambda4
            public final void accept(java.lang.Object obj) {
                com.up366.mobile.common.onlinelog.OpLog.lambda$report$2(jSONObject, (com.alibaba.fastjson.JSONObject) obj);
            }
        }, null);
    }

    static /* synthetic */ void lambda$report$2(com.alibaba.fastjson.JSONObject jSONObject, com.alibaba.fastjson.JSONObject jSONObject2) {
        if (jSONObject != null) {
            jSONObject2.putAll(jSONObject);
        }
    }

    public static void report(java.lang.String str, java.lang.String str2, java.lang.Throwable th, androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject> consumer, androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject> consumer2) {
        reportImpl(str, str2, th, consumer, consumer2);
    }

    public static void reportImmediate(java.lang.String str, java.lang.String str2) {
        reportImmediate(str, str2, null);
    }

    public static void reportImmediate(final java.lang.String str, final java.lang.String str2, final java.lang.Throwable th) {
        instance.executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.onlinelog.OpLog$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.onlinelog.OpLog.lambda$reportImmediate$3(str, str2, th);
            }
        });
    }

    static /* synthetic */ void lambda$reportImmediate$3(java.lang.String str, java.lang.String str2, java.lang.Throwable th) throws java.lang.Exception {
        java.lang.StringBuilder oldValue = getOldValue(str);
        oldValue.append(str2);
        oldValue.append("\n");
        if (th != null) {
            oldValue.append(android.util.Log.getStackTraceString(th));
        }
        java.lang.String string = oldValue.toString();
        com.up366.mobile.common.onlinelog.OpLog opLog = instance;
        opLog.map.remove(str);
        opLog.addLogRecord(str, string, null, null);
    }

    private static void reportImpl(final java.lang.String str, final java.lang.String str2, final java.lang.Throwable th, final androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject> consumer, final androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject> consumer2) {
        instance.executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.onlinelog.OpLog$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.onlinelog.OpLog.lambda$reportImpl$4(str, str2, th, consumer, consumer2);
            }
        });
    }

    static /* synthetic */ void lambda$reportImpl$4(java.lang.String str, java.lang.String str2, java.lang.Throwable th, androidx.core.util.Consumer consumer, androidx.core.util.Consumer consumer2) throws java.lang.Exception {
        java.lang.StringBuilder oldValue = getOldValue(str);
        oldValue.append(str2);
        oldValue.append("\n");
        if (th != null) {
            oldValue.append(android.util.Log.getStackTraceString(th));
        }
        java.lang.String string = oldValue.toString();
        com.up366.mobile.common.onlinelog.OpLog opLog = instance;
        opLog.map.remove(str);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        if (consumer != null) {
            consumer.accept(jSONObject);
        }
        if (consumer2 != null) {
            consumer2.accept(jSONObject2);
        }
        opLog.addLogRecord(str, string, jSONObject, jSONObject2);
    }

    private void addLogRecord(java.lang.String str, java.lang.String str2, com.alibaba.fastjson.JSONObject jSONObject, com.alibaba.fastjson.JSONObject jSONObject2) {
        instance.writeOneLog(str, "", com.up366.mobile.common.onlinelog.OpLogData.Event.OTHER, str2, jSONObject, jSONObject2);
    }

    private void writeOneLog(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.alibaba.fastjson.JSONObject jSONObject, com.alibaba.fastjson.JSONObject jSONObject2) {
        try {
            com.alibaba.fastjson.JSONObject jSONObject3 = new com.alibaba.fastjson.JSONObject();
            com.alibaba.fastjson.JSONObject jSONObject4 = new com.alibaba.fastjson.JSONObject();
            if (!android.text.TextUtils.isEmpty(str4.trim())) {
                jSONObject4.put("body", str4);
            }
            if (jSONObject != null) {
                jSONObject4.putAll(jSONObject);
            }
            jSONObject3.put("extData", jSONObject4);
            if (jSONObject2 != null) {
                jSONObject3.putAll(jSONObject2);
            }
            com.up366.mobile.common.onlinelog.ActionLogRecord.record(str3, str, str2, jSONObject3);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - OpLog - writeOneLog - ", e);
        }
    }
}
