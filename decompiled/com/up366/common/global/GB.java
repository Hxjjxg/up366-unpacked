package com.up366.common.global;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class GB {
    private static com.up366.common.global.IActivityUp activityUp;
    private static com.up366.common.global.IGlobalUp globalCallBack;
    private static com.up366.common.global.IOpLogUp opLogUp;

    public static void setCallBack(com.up366.common.global.IGlobalUp iGlobalUp) {
        globalCallBack = iGlobalUp;
    }

    public static void setActivityUp(com.up366.common.global.IActivityUp iActivityUp) {
        activityUp = iActivityUp;
    }

    @java.lang.Deprecated
    public static com.up366.common.global.IGlobalUp getCallBack() {
        return globalCallBack;
    }

    public static com.up366.common.global.IGlobalUp get() {
        return globalCallBack;
    }

    public static void setOpLogUp(com.up366.common.global.IOpLogUp iOpLogUp) {
        opLogUp = iOpLogUp;
    }

    public static com.up366.common.global.IOpLogUp getOpLogUp() {
        com.up366.common.global.IOpLogUp iOpLogUp = opLogUp;
        return iOpLogUp != null ? iOpLogUp : new com.up366.common.global.IOpLogUp() { // from class: com.up366.common.global.GB.1
            @Override // com.up366.common.global.IOpLogUp
            public /* synthetic */ void reportOpLog(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.fastjson.JSONObject jSONObject) {
                com.up366.common.log.Logger.error("reportOpLog 没有初始化接口");
            }
        };
    }

    public static com.up366.common.global.IActivityUp getActivity() {
        com.up366.common.global.IActivityUp iActivityUp = activityUp;
        return iActivityUp != null ? iActivityUp : new com.up366.common.global.IActivityUp() { // from class: com.up366.common.global.GB.2
            @Override // com.up366.common.global.IActivityUp
            public /* synthetic */ void openWebViewActivity(android.content.Context context, com.up366.common.global.IActivityUp.ActivityType activityType, com.alibaba.fastjson.JSONObject jSONObject, boolean z) {
                com.up366.common.log.Logger.error("openWebViewActivity 没有初始化接口");
            }
        };
    }
}
