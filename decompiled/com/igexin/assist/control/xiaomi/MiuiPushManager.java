package com.igexin.assist.control.xiaomi;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MiuiPushManager implements com.igexin.assist.control.AbstractPushManager {
    private static final java.lang.String KEY_VERSION_CODE = "ro.miui.ui.version.code";
    private static final java.lang.String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final java.lang.String PACKAGE_XIAOMI = "com.xiaomi.xmsf";
    public static final java.lang.String PLUGIN_VERSION = "3.3.3";
    public static final java.lang.String TAG = "Assist_XM";
    public static final java.lang.String XIAOMI_VERSION = "6_0_1-C";
    private static final java.lang.String phoneBrand = android.os.Build.BRAND;
    private java.lang.String appId;
    private java.lang.String appKey;

    public MiuiPushManager(android.content.Context context) {
        this.appId = "";
        this.appKey = "";
        try {
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

    public static boolean checkXMDevice(android.content.Context context) {
        try {
            return isMIUI();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private static java.lang.String getProp(java.lang.String str) throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop ".concat(java.lang.String.valueOf(str))).getInputStream()), 1024);
            try {
                java.lang.String line = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                return line;
            } catch (java.lang.Exception unused) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused2) {
            bufferedReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static boolean isMIUI() {
        return (android.text.TextUtils.isEmpty(getProp("ro.miui.ui.version.name")) && android.text.TextUtils.isEmpty(getProp("ro.miui.ui.version.code"))) ? false : true;
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
        return com.xiaomi.mipush.sdk.MiPushClient.getRegId(context);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        return false;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(android.content.Context context) {
        try {
            if (!android.text.TextUtils.isEmpty(this.appId) && !android.text.TextUtils.isEmpty(this.appKey)) {
                android.util.Log.d("Assist_XM", "Register mipush, pkg = " + context.getPackageName());
                com.xiaomi.mipush.sdk.MiPushClient.registerPush(context, this.appId, this.appKey);
                return;
            }
            android.util.Log.d("Assist_XM", "Register mipush appId or appKey is null or empty");
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
