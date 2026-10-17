package com.igexin.assist.control.vivo;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class VivoPushManager implements com.igexin.assist.control.AbstractPushManager {
    public static final java.lang.String PLUGIN_VERSION = "3.2.0";
    public static final java.lang.String TAG = "Assist_VV";
    private static final java.lang.String VIVO_VERSION = "sdk_version_vivo";
    private java.lang.String mSdkSwitchPath;
    private java.lang.String mToken = "";
    public static final java.lang.String VIVO = "Vivo".toLowerCase();
    private static final java.lang.String phoneBrand = android.os.Build.BRAND;

    public VivoPushManager(android.content.Context context) {
        try {
            com.vivo.push.PushConfig pushConfigBuild = new com.vivo.push.PushConfig.Builder().agreePrivacyStatement(true).build();
            android.util.Log.d("Assist_VV", "vivo plugin version = 3.2.0, vivo sdk version = 506");
            this.mSdkSwitchPath = context.getFilesDir().getPath() + "/init.pid";
            com.vivo.push.PushClient.getInstance(context).initialize(pushConfigBuild);
            com.vivo.push.PushClient.getInstance(context).checkManifest();
        } catch (java.lang.Throwable th) {
            android.util.Log.e("Assist_VV", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVivoMessageBeanExtra(com.igexin.assist.MessageBean messageBean) {
        try {
            java.lang.reflect.Field declaredField = com.igexin.assist.MessageBean.class.getDeclaredField("extra");
            declaredField.setAccessible(true);
            ((android.os.Bundle) declaredField.get(messageBean)).putBoolean("isForce", true);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean checkVivoDevice(android.content.Context context) {
        try {
            boolean zIsSupport = com.vivo.push.PushClient.getInstance(context).isSupport();
            android.util.Log.d("Assist_VV", "the vivo system push support = ".concat(java.lang.String.valueOf(zIsSupport)));
            return zIsSupport;
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_VV", th.getMessage());
            return false;
        }
    }

    private boolean isSdkInit() {
        if (this.mSdkSwitchPath != null) {
            return new java.io.File(this.mSdkSwitchPath).exists();
        }
        return false;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getBrandCode() {
        return null;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getToken(android.content.Context context) {
        return this.mToken;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        return false;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(android.content.Context context) {
        try {
            android.util.Log.d("Assist_VV", "Register vivo push, pkg = " + context.getPackageName());
            if (com.igexin.sdk.PushManager.getInstance().isPushTurnedOn(context) || !isSdkInit()) {
                turnOnPush(context);
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_VV", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(android.content.Context context, int i, int i2) {
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(final android.content.Context context) {
        try {
            com.vivo.push.PushClient.getInstance(context).turnOffPush(new com.vivo.push.IPushActionListener() { // from class: com.igexin.assist.control.vivo.VivoPushManager.2
                public void onStateChanged(int i) {
                    android.util.Log.d("Assist_VV", "turnOffPush finish, state = ".concat(java.lang.String.valueOf(i)));
                    if (i == 0) {
                        com.igexin.assist.control.vivo.VivoPushManager.this.mToken = "";
                        if (context != null) {
                            android.util.Log.d("Assist_VV", "turnOnPush token = \"false\"");
                            com.igexin.assist.action.MessageManger.getInstance().addMessage(new com.igexin.assist.MessageBean(context, com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, "false"));
                        }
                    }
                }
            });
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_VV", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(final android.content.Context context) {
        try {
            com.vivo.push.PushClient.getInstance(context).turnOnPush(new com.vivo.push.IPushActionListener() { // from class: com.igexin.assist.control.vivo.VivoPushManager.1
                public void onStateChanged(int i) {
                    android.util.Log.d("Assist_VV", "turnOnPush finish, state = ".concat(java.lang.String.valueOf(i)));
                    if (i == 0) {
                        com.vivo.push.PushClient.getInstance(context).getRegId(new com.vivo.push.listener.IPushQueryActionListener() { // from class: com.igexin.assist.control.vivo.VivoPushManager.1.1
                            public void onFail(java.lang.Integer num) {
                                android.util.Log.d("Assist_VV", "get fail token = ".concat(java.lang.String.valueOf(num)));
                            }

                            public void onSuccess(java.lang.String str) {
                                com.igexin.assist.control.vivo.VivoPushManager.this.mToken = str;
                                android.util.Log.d("Assist_VV", "get success token = " + com.igexin.assist.control.vivo.VivoPushManager.this.mToken);
                                if (context == null || android.text.TextUtils.isEmpty(com.igexin.assist.control.vivo.VivoPushManager.this.mToken)) {
                                    return;
                                }
                                com.igexin.assist.MessageBean messageBean = new com.igexin.assist.MessageBean(context, com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, com.igexin.assist.sdk.AssistPushConsts.VIVO_PREFIX + com.igexin.assist.control.vivo.VivoPushManager.this.mToken);
                                com.igexin.assist.control.vivo.VivoPushManager.this.addVivoMessageBeanExtra(messageBean);
                                com.igexin.assist.action.MessageManger.getInstance().addMessage(messageBean);
                            }
                        });
                    } else if (i == 101) {
                        android.util.Log.d("Assist_VV", "the vivo rom not support system push");
                    }
                }
            });
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_VV", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(android.content.Context context) {
        try {
            turnOffPush(context);
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_VV", th.getMessage());
        }
    }
}
