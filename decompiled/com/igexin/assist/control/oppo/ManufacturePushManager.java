package com.igexin.assist.control.oppo;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ManufacturePushManager implements com.heytap.msp.push.callback.ICallBackResultService, com.igexin.assist.control.AbstractPushManager {
    public static final java.lang.String PLUGIN_VERSION = "3.4.0";
    public static final java.lang.String TAG = "Assist_OP";
    private java.lang.String appKey;
    private java.lang.String appSecret;
    private android.content.Context context;

    public ManufacturePushManager(android.content.Context context) {
        this.appKey = "";
        this.appSecret = "";
        try {
            this.context = context;
            android.util.Log.d("Assist_OP", "oppo plugin version = 3.4.0, oppo sdk version = " + com.heytap.msp.push.HeytapPushManager.getSDKVersionName());
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            java.lang.String appKeyByBuildConfig = com.igexin.assist.control.oppo.Utils.getAppKeyByBuildConfig(applicationInfo);
            this.appKey = appKeyByBuildConfig;
            if (android.text.TextUtils.isEmpty(appKeyByBuildConfig)) {
                java.lang.String str = (java.lang.String) applicationInfo.metaData.get(com.igexin.assist.sdk.AssistPushConsts.OPPOPUSH_APPKEY);
                this.appKey = str;
                this.appKey = str.replace(com.igexin.assist.sdk.AssistPushConsts.OPPO_PREFIX, "");
            }
            java.lang.String appSecretByBuildConfig = com.igexin.assist.control.oppo.Utils.getAppSecretByBuildConfig(applicationInfo);
            this.appSecret = appSecretByBuildConfig;
            if (android.text.TextUtils.isEmpty(appSecretByBuildConfig)) {
                java.lang.String str2 = (java.lang.String) applicationInfo.metaData.get(com.igexin.assist.sdk.AssistPushConsts.OPPOPUSH_APPSECRET);
                this.appSecret = str2;
                this.appSecret = str2.replace(com.igexin.assist.sdk.AssistPushConsts.OPPO_PREFIX, "");
            }
            createNotificationChannel(context);
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_OP", th.getMessage());
        }
    }

    public static boolean checkOppoDevice(android.content.Context context) {
        try {
            com.heytap.msp.push.HeytapPushManager.init(context, false);
            return com.heytap.msp.push.HeytapPushManager.isSupportPush(context);
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_OP", th.getMessage());
            return false;
        }
    }

    private void createNotificationChannel(android.content.Context context) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.reflect.InvocationTargetException {
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return;
        }
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(com.igexin.push.core.b.n);
        java.lang.Class<?> cls = java.lang.Class.forName("android.app.NotificationChannel");
        java.lang.reflect.Constructor<?> constructor = cls.getConstructor(java.lang.String.class, java.lang.CharSequence.class, java.lang.Integer.TYPE);
        if (constructor == null || ((android.os.Parcelable) android.app.NotificationManager.class.getMethod("getNotificationChannel", java.lang.String.class).invoke(notificationManager, "Default")) != null) {
            return;
        }
        android.app.NotificationManager.class.getMethod("createNotificationChannel", cls).invoke(notificationManager, (android.os.Parcelable) constructor.newInstance("Default", "Default", 3));
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getBrandCode() {
        return "4";
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getToken(android.content.Context context) {
        return com.heytap.msp.push.HeytapPushManager.getRegisterID();
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        android.content.Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            com.heytap.msp.push.HeytapPushManager.init(context, false);
            boolean zIsSupportPush = com.heytap.msp.push.HeytapPushManager.isSupportPush(this.context);
            android.util.Log.d("Assist_OP", "is oppo:".concat(java.lang.String.valueOf(zIsSupportPush)));
            return zIsSupportPush;
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_OP", th.getMessage());
            return false;
        }
    }

    public void onError(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
    }

    public void onGetNotificationStatus(int i, int i2) {
    }

    public void onGetPushStatus(int i, int i2) {
    }

    public void onRegister(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String strValueOf;
        java.lang.String strValueOf2;
        try {
            android.util.Log.d("Assist_OP", "onToken :" + str + ", code = " + i);
            if (this.context == null || i != 0 || android.text.TextUtils.isEmpty(str) || str.equalsIgnoreCase("InvalidAppKey")) {
                return;
            }
            java.lang.String strConcat = "";
            java.lang.String[] strArrSplit = str.split("_");
            if (strArrSplit.length != 1) {
                if (strArrSplit.length == 2) {
                    if (strArrSplit[0].equalsIgnoreCase("CN")) {
                        strValueOf2 = java.lang.String.valueOf(str);
                    } else {
                        strValueOf = java.lang.String.valueOf(str);
                        strConcat = "OPG_".concat(strValueOf);
                    }
                } else if (strArrSplit.length == 3) {
                    if (strArrSplit[1].equalsIgnoreCase("CN")) {
                        strValueOf2 = java.lang.String.valueOf(str);
                    } else {
                        strValueOf = java.lang.String.valueOf(str);
                        strConcat = "OPG_".concat(strValueOf);
                    }
                }
                com.igexin.assist.action.MessageManger.getInstance().addMessage(new com.igexin.assist.MessageBean(this.context, com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, strConcat));
            }
            strValueOf2 = java.lang.String.valueOf(str);
            strConcat = com.igexin.assist.sdk.AssistPushConsts.OPPO_PREFIX.concat(strValueOf2);
            com.igexin.assist.action.MessageManger.getInstance().addMessage(new com.igexin.assist.MessageBean(this.context, com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, strConcat));
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_OP", th.getMessage());
        }
    }

    public void onSetPushTime(int i, java.lang.String str) {
    }

    public void onUnRegister(int i, java.lang.String str, java.lang.String str2) {
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(android.content.Context context) {
        try {
            this.context = context;
            if (!android.text.TextUtils.isEmpty(this.appKey) && !android.text.TextUtils.isEmpty(this.appSecret)) {
                android.util.Log.d("Assist_OP", "Register oppo push, pkg = " + context.getPackageName() + ", appKey = " + this.appKey + ", appSecret = " + this.appSecret);
                if (isSupport()) {
                    com.heytap.msp.push.HeytapPushManager.register(context, this.appKey, this.appSecret, this);
                    return;
                } else {
                    android.util.Log.d("Assist_OP", "not support oppo push.");
                    return;
                }
            }
            android.util.Log.d("Assist_OP", "Register oppo push appKey or appSecret is null or empty");
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_OP", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(android.content.Context context, int i, int i2) {
        if (i2 == 0) {
            turnOnPush(context);
            return;
        }
        int i3 = (i + i2) % 24;
        android.util.Log.d("Assist_OP", "getui setSilentTime" + i + ":" + i2);
        android.util.Log.d("Assist_OP", "oppo push setAcceptTime" + i3 + ":" + i);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i4 = 0; i4 < 7; i4++) {
            arrayList.add(java.lang.Integer.valueOf(i4));
        }
        com.heytap.msp.push.HeytapPushManager.setPushTime(arrayList, i3, 0, i, 0);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(android.content.Context context) {
        try {
            com.heytap.msp.push.HeytapPushManager.pausePush();
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_OP", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(android.content.Context context) {
        try {
            com.heytap.msp.push.HeytapPushManager.resumePush();
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_OP", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(android.content.Context context) {
        try {
            com.heytap.msp.push.HeytapPushManager.unRegister();
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_OP", th.getMessage());
        }
    }
}
