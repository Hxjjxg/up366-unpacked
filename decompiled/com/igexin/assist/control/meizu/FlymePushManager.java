package com.igexin.assist.control.meizu;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FlymePushManager implements com.igexin.assist.control.AbstractPushManager {
    public static final java.lang.String PLUGIN_VERSION = "3.3.0";
    public static final java.lang.String TAG = "Assist_MZ";
    private java.lang.String appId;
    private java.lang.String appKey;

    public FlymePushManager(android.content.Context context) {
        this.appId = "";
        this.appKey = "";
        java.lang.String sdkVersion = "5.0.3";
        try {
            try {
                sdkVersion = com.meizu.cloud.pushsdk.PushManager.getSdkVersion();
            } catch (java.lang.Throwable th) {
                android.util.Log.d("Assist_MZ", th.getMessage());
                return;
            }
        } catch (java.lang.Exception unused) {
        }
        android.util.Log.d("Assist_MZ", "meizu plugin version = 3.3.0, meizu sdk version = ".concat(java.lang.String.valueOf(sdkVersion)));
        android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        java.lang.String appIdByBuildConfig = com.igexin.assist.control.meizu.Utils.getAppIdByBuildConfig(applicationInfo);
        this.appId = appIdByBuildConfig;
        if (android.text.TextUtils.isEmpty(appIdByBuildConfig)) {
            java.lang.String str = (java.lang.String) applicationInfo.metaData.get(com.igexin.assist.sdk.AssistPushConsts.MEIZUPUSH_APPID);
            this.appId = str;
            this.appId = str.replace(com.igexin.assist.sdk.AssistPushConsts.MZ_PREFIX, "");
        }
        java.lang.String appKeyByBuildConfig = com.igexin.assist.control.meizu.Utils.getAppKeyByBuildConfig(applicationInfo);
        this.appKey = appKeyByBuildConfig;
        if (android.text.TextUtils.isEmpty(appKeyByBuildConfig)) {
            java.lang.String str2 = (java.lang.String) applicationInfo.metaData.get(com.igexin.assist.sdk.AssistPushConsts.MEIZUPUSH_APPKEY);
            this.appKey = str2;
            this.appKey = str2.replace(com.igexin.assist.sdk.AssistPushConsts.MZ_PREFIX, "");
        }
    }

    public static boolean checkMZDevice(android.content.Context context) {
        try {
            return com.meizu.cloud.pushsdk.PushManager.isBrandMeizu();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private static boolean isBrandMeizu() {
        try {
            return com.meizu.cloud.pushsdk.PushManager.isBrandMeizu();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getBrandCode() {
        return null;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getToken(android.content.Context context) {
        if (context == null) {
            return null;
        }
        return com.meizu.cloud.pushsdk.PushManager.getPushId(context);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        return false;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(android.content.Context context) {
        try {
            if (!android.text.TextUtils.isEmpty(this.appId) && !android.text.TextUtils.isEmpty(this.appKey)) {
                android.util.Log.d("Assist_MZ", "Register meizupush, pkg = " + context.getPackageName());
                com.meizu.cloud.pushsdk.PushManager.register(context, this.appId, this.appKey);
                return;
            }
            android.util.Log.d("Assist_MZ", "Register meizupush appId not find");
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_MZ", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(android.content.Context context, int i, int i2) {
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(android.content.Context context) {
        if (context == null) {
            return;
        }
        java.lang.String pushId = com.meizu.cloud.pushsdk.PushManager.getPushId(context);
        if (android.text.TextUtils.isEmpty(this.appId) || android.text.TextUtils.isEmpty(this.appKey) || android.text.TextUtils.isEmpty(pushId)) {
            return;
        }
        com.meizu.cloud.pushsdk.PushManager.switchPush(context, this.appId, this.appKey, pushId, false);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(android.content.Context context) {
        if (context == null) {
            return;
        }
        java.lang.String pushId = com.meizu.cloud.pushsdk.PushManager.getPushId(context);
        if (android.text.TextUtils.isEmpty(this.appId) || android.text.TextUtils.isEmpty(this.appKey) || android.text.TextUtils.isEmpty(pushId)) {
            return;
        }
        com.meizu.cloud.pushsdk.PushManager.switchPush(context, this.appId, this.appKey, pushId, true);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(android.content.Context context) {
        try {
            if (!android.text.TextUtils.isEmpty(this.appId) && !android.text.TextUtils.isEmpty(this.appKey)) {
                android.util.Log.d("Assist_MZ", "|Unregister meizupush");
                com.meizu.cloud.pushsdk.PushManager.unRegister(context, this.appId, this.appKey);
                return;
            }
            android.util.Log.d("Assist_MZ", "|Unregister meizupush appId not find");
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_MZ", th.getMessage());
        }
    }
}
