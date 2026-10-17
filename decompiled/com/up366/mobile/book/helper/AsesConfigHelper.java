package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AsesConfigHelper {
    public static final java.lang.String DEFAULT_CONFIG = "{\"8\":\"音频时长过长\",\"147\":\"音频读取失败\",\"148\":\"音频时长过短\",\"149\":\"音频错误\"}";
    public static final java.lang.String PREFERENCE_KEY = "asesConfig";

    public static void fetchAsesConfig() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.AsesConfigHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.AsesConfigHelper.lambda$fetchAsesConfig$0();
            }
        });
    }

    static /* synthetic */ void lambda$fetchAsesConfig$0() throws java.lang.Exception {
        java.lang.String str;
        if (!com.up366.mobile.common.utils.PlatformUtils.isDemo()) {
            str = com.up366.mobile.common.http.HttpMgrUtils.ASES_ERROR_MSG_CONFIG_URL;
        } else {
            str = com.up366.mobile.common.http.HttpMgrUtils.ASES_ERROR_MSG_CONFIG_URL_DEMO;
        }
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Void>(str, false) { // from class: com.up366.mobile.book.helper.AsesConfigHelper.1
            @Override // com.up366.common.http.RequestParams
            public java.lang.Void handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                com.up366.common.log.Logger.info("AsesConfigHelper - fetchAsesConfig - result - " + str2);
                if (response.isError()) {
                    com.up366.common.log.Logger.error("AsesConfigHelper - fetchAsesConfig - error - " + response.toString());
                    return null;
                }
                if (com.up366.mobile.book.helper.AsesConfigHelper.isValidJson(str2)) {
                    com.up366.mobile.common.utils.PreferenceUtils.putString(com.up366.mobile.book.helper.AsesConfigHelper.PREFERENCE_KEY, str2);
                } else {
                    com.up366.mobile.common.utils.PreferenceUtils.putString(com.up366.mobile.book.helper.AsesConfigHelper.PREFERENCE_KEY, com.up366.mobile.book.helper.AsesConfigHelper.DEFAULT_CONFIG);
                }
                return null;
            }
        });
    }

    public static java.lang.String getConfigErrorMsg(int i) {
        java.lang.String string = com.up366.mobile.common.utils.PreferenceUtils.getString(PREFERENCE_KEY, DEFAULT_CONFIG);
        com.up366.common.log.Logger.info("AsesConfigHelper engineErrorCode = [ " + i + " ] - config = [" + string + " ]");
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(string);
            java.lang.String strValueOf = java.lang.String.valueOf(i);
            if (!object.containsKey(strValueOf)) {
                return "录音失败，请重试！";
            }
            return object.getString(strValueOf);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("AsesConfigHelper getErrorMsg error", e);
            return "录音失败，请重试！";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidJson(java.lang.String str) {
        try {
            com.alibaba.fastjson.JSON.parseObject(str);
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
