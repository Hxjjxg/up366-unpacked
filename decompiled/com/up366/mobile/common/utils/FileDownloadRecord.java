package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FileDownloadRecord {
    private static final java.lang.String KEY_DOWNLOAD_END = "__1_2";
    private static final java.lang.String KEY_DOWNLOAD_START = "__1_1";
    private static final java.lang.String KEY_UNZIP_END = "__2_2";
    private static final java.lang.String KEY_UNZIP_START = "__2_1";
    private static final java.util.Map<java.lang.String, com.alibaba.fastjson.JSONObject> dict = new java.util.concurrent.ConcurrentHashMap();

    public static void add(java.lang.String str, androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject> consumer) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        if (consumer != null) {
            consumer.accept(jSONObject);
        }
        dict.put(str, jSONObject);
    }

    public static void addParam(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        com.alibaba.fastjson.JSONObject jSONObject = dict.get(str);
        if (jSONObject == null) {
            return;
        }
        jSONObject.put(str2, obj);
    }

    public static void record(com.up366.common.download.DownloadInfo downloadInfo) {
        java.lang.String key;
        java.util.Map<java.lang.String, com.alibaba.fastjson.JSONObject> map;
        com.alibaba.fastjson.JSONObject jSONObject;
        if (downloadInfo == null || (jSONObject = (map = dict).get((key = downloadInfo.getKey()))) == null) {
            return;
        }
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        int state = downloadInfo.getState();
        if (!jSONObject.containsKey(KEY_DOWNLOAD_START)) {
            jSONObject.put(KEY_DOWNLOAD_START, java.lang.Long.valueOf(jUptimeMillis));
        }
        if (state == 3) {
            if (jSONObject.containsKey(KEY_UNZIP_START)) {
                return;
            }
            jSONObject.put(KEY_UNZIP_START, java.lang.Long.valueOf(jUptimeMillis));
            return;
        }
        if (state == 4) {
            jSONObject.put(KEY_DOWNLOAD_END, java.lang.Long.valueOf(jUptimeMillis));
            long longValue = jSONObject.getLongValue(KEY_DOWNLOAD_START);
            long longValue2 = jSONObject.getLongValue(KEY_UNZIP_START);
            long longValue3 = jSONObject.getLongValue(KEY_DOWNLOAD_END);
            if (longValue > 0 && longValue2 > 0 && longValue2 >= longValue) {
                jSONObject.put("duration", java.lang.Float.valueOf((longValue2 - longValue) / 1000.0f));
            } else if (longValue <= 0 || longValue3 < longValue || longValue2 != 0) {
                jSONObject.put("duration", 5);
            } else {
                jSONObject.put("duration", java.lang.Float.valueOf((longValue3 - longValue) / 1000.0f));
            }
            jSONObject.put("size", java.lang.Long.valueOf(downloadInfo.getFileSize()));
            jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, downloadInfo.getDownloadUrl());
            com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
            jSONObject2.put("extData", jSONObject);
            com.up366.mobile.common.onlinelog.ActionLogRecord.record("DOWNLOAD", ".def.app.download", jSONObject2);
            com.up366.common.log.Logger.info("TAG - FileDownloadRecord - record - " + jSONObject.toJSONString());
            map.remove(key);
        }
    }
}
