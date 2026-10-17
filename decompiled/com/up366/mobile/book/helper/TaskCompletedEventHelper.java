package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TaskCompletedEventHelper {
    public static void sendTaskCompletedEvent(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("sendTaskCompletedEvent taskId = " + str + ", studyTaskId = " + str2);
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.TaskCompletedEvent());
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("type", "_SUBMIT_TASK_");
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, str);
        jSONObject2.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, str2);
        jSONObject.put("detail", jSONObject2);
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.JSGlobalEvent(jSONObject.toJSONString()));
    }

    public static void sendTaskCompletedEvent() {
        sendTaskCompletedEvent("", "");
    }
}
