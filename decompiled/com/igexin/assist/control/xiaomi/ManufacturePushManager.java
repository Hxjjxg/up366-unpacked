package com.igexin.assist.control.xiaomi;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ManufacturePushManager implements com.igexin.assist.control.AbstractPushManager {
    private static final java.lang.String PACKAGE_XIAOMI = "com.xiaomi.xmsf";
    public static final java.lang.String PLUGIN_VERSION = "3.3.3";
    public static final java.lang.String TAG = "Assist_XM";
    public static final java.lang.String XIAOMI_VERSION = "6_0_1-C";
    private java.lang.String appId;
    private java.lang.String appKey;
    private android.content.Context context;

    public ManufacturePushManager(android.content.Context context) {
        this.appId = "";
        this.appKey = "";
        try {
            this.context = context;
            android.util.Log.d("Assist_XM", "xiaomi plugin version = 3.3.3, xiaomi sdk version = 6_0_1-C");
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            java.lang.String appIdByBuildConfig = com.igexin.assist.control.xiaomi.Utils.getAppIdByBuildConfig(applicationInfo);
            this.appId = appIdByBuildConfig;
            if (android.text.TextUtils.isEmpty(appIdByBuildConfig)) {
                java.lang.String str = (java.lang.String) applicationInfo.metaData.get(com.igexin.assist.sdk.AssistPushConsts.MIPUSH_APPID);
                this.appId = str;
                this.appId = str.replace(com.igexin.assist.sdk.AssistPushConsts.XM_PREFIX, "");
            }
            java.lang.String appKeyByBuildConfig = com.igexin.assist.control.xiaomi.Utils.getAppKeyByBuildConfig(applicationInfo);
            this.appKey = appKeyByBuildConfig;
            if (android.text.TextUtils.isEmpty(appKeyByBuildConfig)) {
                java.lang.String str2 = (java.lang.String) applicationInfo.metaData.get(com.igexin.assist.sdk.AssistPushConsts.MIPUSH_APPKEY);
                this.appKey = str2;
                this.appKey = str2.replace(com.igexin.assist.sdk.AssistPushConsts.XM_PREFIX, "");
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_XM", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getBrandCode() {
        return "3";
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getToken(android.content.Context context) {
        if (context == null) {
            return null;
        }
        return com.xiaomi.mipush.sdk.MiPushClient.getRegId(context);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        try {
            return com.igexin.assist.control.xiaomi.XmSystemUtils.isBrandXiaoMi();
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_XM", "support error is : " + th.toString());
            return false;
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(android.content.Context context) {
        try {
            if (!android.text.TextUtils.isEmpty(this.appId) && !android.text.TextUtils.isEmpty(this.appKey) && context != null) {
                android.util.Log.d("Assist_XM", "Register mipush, pkg = " + context.getPackageName());
                if (isSupport()) {
                    com.xiaomi.mipush.sdk.MiPushClient.registerPush(context, this.appId, this.appKey);
                    return;
                } else {
                    android.util.Log.d("Assist_XM", "mipush not support.");
                    return;
                }
            }
            android.util.Log.d("Assist_XM", "Register mipush appId or appKey is empty, or context null.");
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_XM", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(android.content.Context context, int i, int i2) {
        if (i2 == 0) {
            turnOnPush(context);
            return;
        }
        int i3 = (i + i2) % 24;
        android.util.Log.d("Assist_XM", "getui setSilentTime" + i + ":" + i2);
        android.util.Log.d("Assist_XM", "mipush setAcceptTime" + i3 + ":" + i);
        com.xiaomi.mipush.sdk.MiPushClient.setAcceptTime(context, i3, 0, i, 0, (java.lang.String) null);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(android.content.Context context) {
        if (context == null) {
            return;
        }
        com.xiaomi.mipush.sdk.MiPushClient.pausePush(context, this.appId);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(android.content.Context context) {
        if (context == null) {
            return;
        }
        com.xiaomi.mipush.sdk.MiPushClient.resumePush(context, this.appId);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(android.content.Context context) {
        try {
            android.util.Log.d("Assist_XM", "Unregister mipush");
            if (context == null) {
                return;
            }
            com.xiaomi.mipush.sdk.MiPushClient.unregisterPush(context);
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_XM", th.getMessage());
        }
    }
}
