package com.igexin.sdk;

import com.igexin.d.a.AnonymousClass1;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PushManager {
    private static final java.lang.String TAG = "PushManager";
    private volatile com.igexin.push.core.h callback;
    private byte[] keyBytes;
    private long lastOpAliasTime;
    private long lastQueryTagTime;
    private long lastSendMessageTime;
    private long lastSetFenceLabelsTime;
    private long lastSetTagTime;
    private java.lang.String safeCode;
    private java.lang.String uActivity;
    private java.lang.String uIntentService;
    private java.lang.Class uPushService;
    private java.lang.String uRegisterService;

    static class a {
        private static final com.igexin.sdk.PushManager a = new com.igexin.sdk.PushManager();

        private a() {
        }
    }

    private PushManager() {
        this.lastQueryTagTime = 0L;
    }

    private static void checkContext(android.content.Context context) {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("NULL context");
        }
    }

    private boolean checkGTCVersion() {
        if (!com.igexin.push.g.d.b("3.2.5.0")) {
            return true;
        }
        com.igexin.c.a.c.a.c.a().a("[PushManager] GTC Version Need >= 3.2.5.0");
        return false;
    }

    private int getAssistAction(int i, java.lang.String str) {
        return (android.text.TextUtils.isEmpty(str) || !str.contains("_")) ? i : (i == 60001 || i == 60002) ? str.startsWith(com.igexin.assist.sdk.AssistPushConsts.HW_PREFIX) ? i + 18 : str.startsWith(com.igexin.assist.sdk.AssistPushConsts.XM_PREFIX) ? i + 48 : str.startsWith(com.igexin.assist.sdk.AssistPushConsts.OPPO_PREFIX) ? i + 28 : str.startsWith(com.igexin.assist.sdk.AssistPushConsts.VIVO_PREFIX) ? i + 38 : str.startsWith(com.igexin.assist.sdk.AssistPushConsts.MZ_PREFIX) ? i + 58 : str.startsWith(com.igexin.assist.sdk.AssistPushConsts.ST_PREFIX) ? i + 78 : str.startsWith(com.igexin.assist.sdk.AssistPushConsts.FCM_PREFIX) ? i + 98 : str.startsWith(com.igexin.assist.sdk.AssistPushConsts.HONOR_PREFIX) ? i + 118 : i : i;
    }

    public static com.igexin.sdk.PushManager getInstance() {
        return com.igexin.sdk.PushManager.a.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.app.Application getMainApplication(android.content.Context context) {
        if (context == null || !isMainProcess(context)) {
            return null;
        }
        return context instanceof android.app.Application ? (android.app.Application) context : (android.app.Application) context.getApplicationContext();
    }

    private java.lang.Class getUserPushService(android.content.Context context) {
        checkContext(context);
        java.lang.Class cls = this.uPushService;
        return cls != null ? cls : com.igexin.push.core.ServiceManager.getInstance().b(context);
    }

    private boolean isMainProcess(android.content.Context context) {
        try {
            com.getui.gtc.base.GtcProvider.setContext(context);
            return com.getui.gtc.base.util.CommonUtil.isMainProcess();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private void registerCallback(final android.content.Context context) {
        com.igexin.push.core.ServiceManager.b = context.getApplicationContext();
        com.igexin.b.a.a().a("GTALCallback").execute(new java.lang.Runnable() { // from class: com.igexin.sdk.PushManager.1
            @Override // java.lang.Runnable
            public final void run() {
                android.app.Application mainApplication;
                try {
                    if (com.igexin.sdk.PushManager.this.callback != null || (mainApplication = com.igexin.sdk.PushManager.this.getMainApplication(context)) == null || com.igexin.sdk.PushManager.this.callback != null || mainApplication == null) {
                        return;
                    }
                    com.igexin.sdk.PushManager.this.callback = new com.igexin.push.core.h();
                    mainApplication.registerActivityLifecycleCallbacks(com.igexin.sdk.PushManager.this.callback);
                    com.igexin.c.a.c.a.a("PushManager｜ registerCallback ", new java.lang.Object[0]);
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
        });
    }

    private <T extends android.app.Activity> void registerPushActivity(android.content.Context context, java.lang.Class<T> cls) {
        java.lang.String name;
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            if (cls != null) {
                try {
                    java.lang.Class.forName(cls.getName());
                    name = cls.getName();
                } catch (java.lang.Exception e) {
                    com.igexin.c.a.c.a.c.a().a("[PushManager] can't load activity = " + e.toString());
                    com.igexin.c.a.c.a.a("PushManager|registerPushActivity|" + e.toString(), new java.lang.Object[0]);
                    return;
                }
            } else {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call -> registerPushActivity, parameter [activity] is null");
                name = "";
            }
            this.uActivity = name;
            if (this.uPushService != null) {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("action", "registerPushActivity");
                bundle.putString(com.igexin.push.g.q.d, this.uActivity);
                android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) this.uPushService);
                intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra("bundle", bundle);
                intent.putExtra(com.igexin.push.g.q.d, this.uActivity);
                startService(context, intent);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] registerPushActivity sdk error = " + th.toString());
        }
    }

    private <T extends android.app.Service> void registerUserService(android.content.Context context, java.lang.Class<T> cls) {
        java.lang.String name;
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            if (cls != null) {
                try {
                    java.lang.Class.forName(cls.getName());
                    name = cls.getName();
                } catch (java.lang.Exception e) {
                    com.igexin.c.a.c.a.c.a().a("[PushManager] can't load service = " + e.toString());
                    com.igexin.c.a.c.a.a("PushManager|registerUserService|" + e.toString(), new java.lang.Object[0]);
                    return;
                }
            } else {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call -> registerUserService, parameter [service] is null");
                name = "";
            }
            this.uRegisterService = name;
            if (this.uPushService != null) {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("action", "registerUserService");
                bundle.putString(com.igexin.push.g.q.a, this.uRegisterService);
                android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) this.uPushService);
                intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra("bundle", bundle);
                intent.putExtra(com.igexin.push.g.q.a, this.uRegisterService);
                startService(context, intent);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] registerUserService  error = " + th.toString());
        }
    }

    private void sendBindAliasResult(android.content.Context context, java.lang.String str, java.lang.String str2) {
        sendResult(context, new com.igexin.sdk.message.BindAliasCmdMessage(str, str2, 10010));
    }

    private void sendFenceLabelResult(android.content.Context context, java.lang.String str) {
        sendResult(context, new com.igexin.sdk.message.SetFenceLabelMessage(str, com.igexin.sdk.PushConsts.SET_FENCE_LABELS_RESULT));
    }

    private void sendResult(android.content.Context context, com.igexin.sdk.message.GTCmdMessage gTCmdMessage) {
        try {
            java.lang.Class clsC = com.igexin.push.core.ServiceManager.getInstance().c(context);
            if (clsC == null || context == null) {
                return;
            }
            android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) clsC);
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("action", 10010);
            bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_CMD_MSG, gTCmdMessage);
            intent.putExtras(bundle);
            context.startService(intent);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a("PushManager|" + th.toString(), new java.lang.Object[0]);
        }
    }

    private void sendSetTagResult(android.content.Context context, java.lang.String str, java.lang.String str2) {
        sendResult(context, new com.igexin.sdk.message.SetTagCmdMessage(str, str2, com.igexin.sdk.PushConsts.SET_TAG_RESULT));
    }

    private void sendUnBindAliasResult(android.content.Context context, java.lang.String str, java.lang.String str2) {
        sendResult(context, new com.igexin.sdk.message.UnBindAliasCmdMessage(str, str2, 10011));
    }

    private boolean startService(android.content.Context context, android.content.Intent intent) {
        try {
            if (android.text.TextUtils.isEmpty(this.safeCode)) {
                java.lang.String string = com.igexin.push.g.q.b(context, com.igexin.push.g.q.e, "").toString();
                this.safeCode = string;
                if (android.text.TextUtils.isEmpty(string)) {
                    javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("AES");
                    keyGenerator.init(128);
                    java.lang.String strA = com.igexin.push.g.e.a(keyGenerator.generateKey().getEncoded());
                    this.safeCode = strA;
                    com.igexin.push.g.q.a(context, com.igexin.push.g.q.e, strA);
                }
            }
            intent.putExtra(com.igexin.push.g.q.e, this.safeCode);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        if (checkGTCVersion()) {
            return com.igexin.push.core.ServiceManager.getInstance().b(context, intent);
        }
        return false;
    }

    private void unRegisterCallback(final android.content.Context context) {
        com.igexin.b.a.a().a("GTALCallback").execute(new java.lang.Runnable() { // from class: com.igexin.sdk.PushManager.2
            @Override // java.lang.Runnable
            public final void run() {
                android.app.Application mainApplication;
                try {
                    if (com.igexin.sdk.PushManager.this.callback == null || (mainApplication = com.igexin.sdk.PushManager.this.getMainApplication(context)) == null) {
                        return;
                    }
                    mainApplication.unregisterActivityLifecycleCallbacks(com.igexin.sdk.PushManager.this.callback);
                    com.igexin.sdk.PushManager.this.callback = null;
                    java.lang.System.currentTimeMillis();
                    com.igexin.c.a.c.a.a("PushManager | unRegisterCallback time= " + java.lang.System.currentTimeMillis(), new java.lang.Object[0]);
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
        });
    }

    public boolean areNotificationsEnabled(android.content.Context context) {
        return com.igexin.push.g.c.b(context);
    }

    public boolean bindAlias(android.content.Context context, java.lang.String str) {
        return bindAlias(context, str, "bindAlias_" + java.lang.System.currentTimeMillis());
    }

    public boolean bindAlias(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            com.igexin.c.a.c.a.c.a().a("PushManager|call bindAlias");
            com.igexin.c.a.c.a.a("PushManager|call bindAlias", new java.lang.Object[0]);
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastOpAliasTime < 1000) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call - > bindAlias failed, it be called too frequently");
                sendBindAliasResult(context, str2, "30001");
                return false;
            }
            this.lastOpAliasTime = jCurrentTimeMillis;
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("action", "bindAlias");
            bundle.putString("alias", str);
            bundle.putString("sn", str2);
            android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] bindAlias  error = " + th.toString());
            return false;
        }
    }

    public void checkManifest(android.content.Context context) throws com.igexin.sdk.GetuiPushException {
        if (isMainProcess(context)) {
            com.igexin.push.g.c.c(context);
        }
    }

    public synchronized java.lang.String getClientid(android.content.Context context) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            if (this.keyBytes == null) {
                try {
                    android.content.pm.ApplicationInfo applicationInfoB = com.igexin.push.g.o.b(context);
                    if (applicationInfoB != null && applicationInfoB.metaData != null) {
                        java.lang.String strA = com.igexin.push.g.d.a(applicationInfoB);
                        if (android.text.TextUtils.isEmpty(strA)) {
                            strA = applicationInfoB.metaData.getString(com.igexin.push.core.b.b);
                        }
                        if (android.text.TextUtils.isEmpty(strA)) {
                            strA = applicationInfoB.metaData.getString("GETUI_APPID");
                        }
                        if (strA != null) {
                            strA = strA.trim();
                        }
                        if (!android.text.TextUtils.isEmpty(strA)) {
                            java.lang.String strA2 = com.igexin.c.b.a.a(strA + context.getPackageName());
                            if (strA2 != null) {
                                this.keyBytes = strA2.getBytes();
                            }
                        }
                    }
                } catch (java.lang.Exception e) {
                    com.igexin.c.a.c.a.a("PushManager|" + e.toString(), new java.lang.Object[0]);
                }
            }
            if (this.keyBytes != null) {
                com.igexin.push.core.ServiceManager.b = context.getApplicationContext();
                if (android.text.TextUtils.isEmpty(com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.d))) {
                    return "";
                }
                byte[] bArrDecode = android.util.Base64.decode(com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.d), 0);
                if (bArrDecode != null && this.keyBytes.length == bArrDecode.length) {
                    int length = bArrDecode.length;
                    byte[] bArr = new byte[length];
                    for (int i = 0; i < length; i++) {
                        bArr[i] = (byte) (this.keyBytes[i] ^ bArrDecode[i]);
                    }
                    if (java.util.regex.Pattern.matches("[a-zA-Z0-9]+", new java.lang.String(bArr))) {
                        return new java.lang.String(bArr);
                    }
                }
            }
        } finally {
        }
        return null;
    }

    public java.lang.String getVersion(android.content.Context context) {
        return "3.3.13.0";
    }

    public void initialize(android.content.Context context) {
        java.lang.Class cls;
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            com.igexin.push.core.ServiceManager.getInstance().f(context);
            if (android.text.TextUtils.isEmpty(this.uIntentService) && (cls = (java.lang.Class) com.igexin.push.g.d.a(context, com.igexin.sdk.GTIntentService.class).second) != null) {
                this.uIntentService = cls.getName();
            }
            if (this.uPushService == null) {
                this.uPushService = (java.lang.Class) com.igexin.push.g.d.a(context, com.igexin.sdk.PushService.class).second;
            }
            initialize(context, this.uPushService);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] initialize sdk error = " + th.toString());
        }
    }

    @java.lang.Deprecated
    public <T extends android.app.Service> void initialize(android.content.Context context, java.lang.Class<T> cls) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            if (checkGTCVersion()) {
                com.igexin.push.core.ServiceManager.getInstance().f(context);
                if (cls == null || com.igexin.push.core.b.ao.equals(cls.getName())) {
                    cls = com.igexin.sdk.PushService.class;
                }
                context.getPackageManager().setComponentEnabledSetting(new android.content.ComponentName(context, (java.lang.Class<?>) cls), 1, 1);
                android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) cls);
                intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_SERVICE_INITIALIZE);
                intent.putExtra(com.igexin.push.g.q.b, cls.getName());
                java.lang.String str = this.uIntentService;
                if (str != null) {
                    intent.putExtra(com.igexin.push.g.q.c, str);
                }
                if (!android.text.TextUtils.isEmpty(this.uActivity)) {
                    intent.putExtra(com.igexin.push.g.q.d, this.uActivity);
                }
                if (!android.text.TextUtils.isEmpty(this.uRegisterService)) {
                    intent.putExtra(com.igexin.push.g.q.a, this.uRegisterService);
                }
                if (startService(context, intent)) {
                    this.uPushService = cls;
                }
                registerCallback(context);
                try {
                    com.igexin.d.a aVarA = com.igexin.d.a.a();
                    aVarA.a = context.getApplicationContext();
                    com.igexin.b.a.a().b().schedule(aVarA.new AnonymousClass1(), 2000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                } catch (java.lang.Throwable unused) {
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] initialize sdk error = " + th.toString());
        }
    }

    public boolean isPushTurnedOn(android.content.Context context) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            com.igexin.push.core.ServiceManager.b = context.getApplicationContext();
            return com.igexin.push.core.d.d.a().b(com.igexin.push.core.d.d.f);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] turnOffPush  error = " + th.toString());
            return false;
        }
    }

    public void openNotification(android.content.Context context) {
        java.lang.String str;
        int i;
        try {
            android.content.Intent intent = new android.content.Intent();
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                str = "android.provider.extra.CHANNEL_ID";
                i = context.getApplicationInfo().uid;
            } else {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("app_package", context.getPackageName());
                str = "app_uid";
                i = context.getApplicationInfo().uid;
            }
            intent.putExtra(str, i);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (java.lang.Throwable unused) {
        }
    }

    public boolean preInit(android.content.Context context) {
        java.lang.Class cls;
        try {
            android.content.Context applicationContext = context.getApplicationContext();
            if (android.text.TextUtils.isEmpty(this.uIntentService) && (cls = (java.lang.Class) com.igexin.push.g.d.a(applicationContext, com.igexin.sdk.GTIntentService.class).second) != null) {
                this.uIntentService = cls.getName();
            }
            if (this.uPushService != null) {
                return true;
            }
            this.uPushService = (java.lang.Class) com.igexin.push.g.d.a(applicationContext, com.igexin.sdk.PushService.class).second;
            return true;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public boolean queryPushOnLine(android.content.Context context) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("action", "queryPushOnLine");
            android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] queryPushOnLine  error = " + th.toString());
            return false;
        }
    }

    public int queryTag(android.content.Context context, java.lang.String str) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            if (str == null) {
                com.igexin.c.a.c.a.c.a().a("[PushManager]call -> queryTag failed, parameter [sn] is null");
                return 20007;
            }
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastQueryTagTime < 1000) {
                com.igexin.c.a.c.a.c.a().a("[PushManager]call -> queryTag failed, it be called too frequently");
                return 20002;
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("action", com.igexin.sdk.PushConsts.QUERY_TAG);
            bundle.putString("sn", str);
            this.lastQueryTagTime = jCurrentTimeMillis;
            android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            startService(context, intent);
            return 0;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] queryTag  error = " + th.toString());
            return 0;
        }
    }

    @java.lang.Deprecated
    public <T extends com.igexin.sdk.GTIntentService> void registerPushIntentService(android.content.Context context, java.lang.Class<T> cls) {
        java.lang.String name;
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            com.igexin.c.a.c.a.a("PushManager|call registerPushIntentService", new java.lang.Object[0]);
            if (cls != null) {
                try {
                    java.lang.Class.forName(cls.getName());
                    if (!com.igexin.push.g.c.a(new android.content.Intent(context, (java.lang.Class<?>) cls), context)) {
                        com.igexin.c.a.c.a.e.a(TAG, "call - > registerPushIntentService, parameter [userIntentService] is set, but didn't find class \"" + cls.getName() + "\", please check your AndroidManifest");
                        return;
                    }
                    name = cls.getName();
                } catch (java.lang.Exception e) {
                    com.igexin.c.a.c.a.a("PushManager|registerPushIntentService|" + e.toString(), new java.lang.Object[0]);
                    return;
                }
            } else {
                name = "";
            }
            this.uIntentService = name;
            if (this.uPushService != null) {
                com.igexin.c.a.c.a.b(TAG, "start service to save intent service");
                android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) this.uPushService);
                intent.putExtra(com.igexin.push.g.q.c, this.uIntentService);
                startService(context, intent);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] registerPushIntentService  error = " + th.toString());
        }
    }

    public boolean sendApplinkFeedback(android.content.Context context, java.lang.String str) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            if (android.text.TextUtils.isEmpty(str)) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call - > sendApplinkFeedback failed, parameter is illegal");
                return false;
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("action", "sendApplinkFeedback");
            bundle.putString(com.up366.mobile.commonui.CommonWebViewActivity.URL, str);
            android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] sendApplinkFeedback  error = " + th.toString());
            return false;
        }
    }

    public boolean sendFeedbackMessage(android.content.Context context, java.lang.String str, java.lang.String str2, int i) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            boolean z = (i >= 60001 && i <= 60999) || (i >= 90001 && i <= 90999);
            if (str != null && str2 != null && z) {
                int assistAction = getAssistAction(i, str2);
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("action", "sendFeedbackMessage");
                bundle.putString("taskid", str);
                bundle.putString("messageid", str2);
                bundle.putString("actionid", java.lang.String.valueOf(assistAction));
                android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
                intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra("bundle", bundle);
                return startService(context, intent);
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] call - > sendFeedbackMessage failed, parameter is illegal");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] sendFeedbackMessage  error = " + th.toString());
            return false;
        }
    }

    public boolean sendMessage(android.content.Context context, java.lang.String str, byte[] bArr) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (str != null && bArr != null && bArr.length <= com.igexin.sdk.main.PushConfig.MESSAGE_MAX_SIZE && jCurrentTimeMillis - this.lastSendMessageTime >= 1000) {
                this.lastSendMessageTime = jCurrentTimeMillis;
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("action", "sendMessage");
                bundle.putString("taskid", str);
                bundle.putByteArray("extraData", bArr);
                android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
                intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra("bundle", bundle);
                return startService(context, intent);
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] call - > sendMessage failed, parameter is illegal or it be called too frequently");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] sendMessage  error = " + th.toString());
            return false;
        }
    }

    public boolean setAdvertisingIdEnable(android.content.Context context, boolean z) {
        try {
            if (com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.u, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(z))) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setAdvertisingIdEnable success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setAdvertisingIdEnable  error");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] setAdvertisingIdEnable fail " + th.getMessage());
            return false;
        }
    }

    public boolean setAdvertisingIdInterval(android.content.Context context, long j) {
        try {
            if (com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.v, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(j * 3600000))) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setAdvertisingIdInterval success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setAdvertisingIdInterval  error =必须在 24-24*7 小时之间");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] setAdvertisingIdInterval fail " + th.getMessage());
            return false;
        }
    }

    public boolean setAppListInterval(android.content.Context context, long j) {
        try {
            if (com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.f, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(j * 3600000))) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setAppListInterval success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setAppListInterval  error = 必须在6-24小时之间");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] setAppListInterval  error = " + th.toString());
            return false;
        }
    }

    public boolean setBadgeNum(android.content.Context context, int i) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            com.igexin.c.a.c.a.c.a().a("[PushManager] call - > setBadgeNum");
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("action", "setBadgeNum");
            bundle.putInt("badgeNum", i);
            android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] setBadgeNum  error = " + th.toString());
            return false;
        }
    }

    public boolean setCellInfoEnable(android.content.Context context, boolean z) {
        try {
            if (com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.w, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(z))) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setCellInfoEnable success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setCellInfoEnable  error");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] setCellInfoEnable fail " + th.getMessage());
            return false;
        }
    }

    public boolean setCellInfoInterval(android.content.Context context, int i) {
        try {
            if (com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.x, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(i * 1000))) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setCellInfoInterval success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setCellInfoInterval  error = 必须在 5-1800 秒之间");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] setCellInfoInterval fail " + th.getMessage());
            return false;
        }
    }

    public void setDebugLogger(android.content.Context context, com.igexin.sdk.IUserLoggerInterface iUserLoggerInterface) {
        if (context == null || iUserLoggerInterface == null) {
            throw new java.lang.IllegalArgumentException("context or loggerInterface can not be null");
        }
        try {
            com.getui.gtc.base.GtcProvider.setContext(context);
            if (!com.igexin.push.g.c.a(context)) {
                iUserLoggerInterface.log("only run in debug mode");
                return;
            }
            if (!isMainProcess(context)) {
                iUserLoggerInterface.log("Must be called in main process!");
                return;
            }
            try {
                checkManifest(context);
            } catch (com.igexin.sdk.GetuiPushException e) {
                iUserLoggerInterface.log(e.toString());
            }
            com.igexin.c.a.c.a.c cVarA = com.igexin.c.a.c.a.c.a();
            if (iUserLoggerInterface == null) {
                com.igexin.c.a.c.a.e.a("LogController", "user logger register parameter can not be null!");
                return;
            }
            android.content.Context applicationContext = context.getApplicationContext();
            cVarA.a(applicationContext);
            cVarA.b.a(iUserLoggerInterface);
            cVarA.b.a();
            cVarA.a("[LogController] Sdk version = " + getInstance().getVersion(applicationContext));
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public boolean setDeviceToken(android.content.Context context, java.lang.String str) {
        try {
            android.content.Context applicationContext = context.getApplicationContext();
            if (android.text.TextUtils.isEmpty(str)) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setDeviceToken error = token is empty");
                return false;
            }
            if (str.equalsIgnoreCase("InvalidAppKey")) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setDeviceToken error = token is InvalidAppKey");
                return false;
            }
            checkContext(applicationContext);
            com.getui.gtc.base.GtcProvider.setContext(applicationContext);
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("action", "setDeviceToken");
            bundle.putString(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, str);
            android.content.Intent intent = new android.content.Intent(applicationContext.getApplicationContext(), (java.lang.Class<?>) getUserPushService(applicationContext));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(applicationContext, intent);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] setDeviceToken  error = " + th.toString());
            return false;
        }
    }

    public boolean setEmergencyPush(android.content.Context context, boolean z) {
        try {
            android.content.Context applicationContext = context.getApplicationContext();
            checkContext(applicationContext);
            com.getui.gtc.base.GtcProvider.setContext(applicationContext);
            com.igexin.push.g.q.a(applicationContext, com.igexin.push.g.q.m, java.lang.Boolean.valueOf(z));
            boolean z2 = ((java.lang.Boolean) com.igexin.push.g.q.b(applicationContext, com.igexin.push.g.q.n, java.lang.Boolean.TRUE)).booleanValue() || z;
            com.getui.gtc.dim.DimManager.getInstance().setSetting(applicationContext, com.igexin.push.g.f.b.A, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(z2));
            com.getui.gtc.dim.DimManager.getInstance().setSetting(applicationContext, com.igexin.push.g.f.b.i, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(z2));
            com.getui.gtc.dim.DimManager.getInstance().setSetting(applicationContext, com.igexin.push.g.f.b.g, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(z2));
            com.getui.gtc.dim.DimManager.getInstance().setSetting(applicationContext, com.igexin.push.g.f.b.e, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(((java.lang.Boolean) com.igexin.push.g.q.b(applicationContext, com.igexin.push.g.q.l, java.lang.Boolean.TRUE)).booleanValue() || z || ((java.lang.Boolean) com.igexin.push.g.q.b(applicationContext, com.igexin.push.g.q.k, java.lang.Boolean.TRUE)).booleanValue()));
            com.igexin.c.a.c.a.c.a().a("[PushManager] setEmergencyPush  success");
            return true;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] setEmergencyPush  error = " + th.toString());
            return false;
        }
    }

    public boolean setFenceLabels(android.content.Context context, java.util.List<com.igexin.sdk.message.Label> list) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            if (list == null) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call -> setFenceLabels failed, parameter labels is null");
                com.igexin.c.a.c.a.a("PushManager|labels is null", new java.lang.Object[0]);
                sendFenceLabelResult(context, "40001");
                return false;
            }
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastSetFenceLabelsTime < 1000) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call - > set fenceLabels failed, it be called too frequently");
                sendFenceLabelResult(context, "40002");
                return false;
            }
            if (list.size() != 0 && list.size() <= 100) {
                for (com.igexin.sdk.message.Label label : list) {
                    if (label == null || android.text.TextUtils.isEmpty(label.getTagName()) || label.getTagName().length() > 32 || label.getTagName().matches(".*[\n\r].*") || android.text.TextUtils.isEmpty(label.getTagId()) || label.getTagId().length() > 32 || label.getTagId().startsWith(com.igexin.push.g.i.a) || !label.getTagId().matches("^[a-zA-Z0-9_-]+$") || ((!android.text.TextUtils.isEmpty(label.getTagVersion()) && (label.getTagVersion().matches(".*[\n\r].*") || label.getTagVersion().length() > 32)) || ((!android.text.TextUtils.isEmpty(label.getExtraData()) && label.getExtraData().matches(".*[\n\r].*")) || label.getEndTime() <= 0))) {
                        com.igexin.c.a.c.a.c.a().a("[PushManager] call -> set fenceLabels failed, labels  is  illegal");
                        sendFenceLabelResult(context, "40011");
                        return false;
                    }
                }
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                java.util.Iterator<com.igexin.sdk.message.Label> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().getJsonObject());
                }
                this.lastSetFenceLabelsTime = jCurrentTimeMillis;
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("action", "setFenceLabels");
                bundle.putString("labels", jSONArray.toString());
                android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
                intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra("bundle", bundle);
                startService(context, intent);
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] call -> set fenceLabels failed, labels  is  illegal");
            sendFenceLabelResult(context, "40011");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] set fenceLabels  error = " + th.toString());
            return false;
        }
    }

    @java.lang.Deprecated
    public boolean setGuardOptions(android.content.Context context, boolean z, boolean z2) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("action", "setGuardOptions");
            bundle.putBoolean("guardMe", z);
            bundle.putBoolean("guardOthers", z2);
            android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] setGuardOptions  error = " + th.toString());
            return false;
        }
    }

    public boolean setHeartbeatInterval(android.content.Context context, int i) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            if (i < 0) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call -> setHeartbeatInterval failed, parameter [interval] < 0, illegal");
                return false;
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("action", "setHeartbeatInterval");
            bundle.putInt("interval", i);
            android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] setHeartbeatInterval  error = " + th.toString());
            return false;
        }
    }

    @java.lang.Deprecated
    public boolean setHwBadgeNum(android.content.Context context, int i) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            com.igexin.c.a.c.a.c.a().a("[PushManager] call - > setHwBadgeNum");
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("action", "setHwBadgeNum");
            bundle.putInt("badgeNum", i);
            android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] setHwBadgeNum  error = " + th.toString());
            return false;
        }
    }

    public boolean setIccIdEnable(android.content.Context context, boolean z) {
        try {
            if (com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.q, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(z))) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setIccIdEnable success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setIccIdEnable  error");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] setIccIdEnable fail " + th.getMessage());
            return false;
        }
    }

    public boolean setIccIdInterval(android.content.Context context, int i) {
        try {
            if (com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.r, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(((long) i) * 3600000))) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setIccIdInterval success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setIccIdInterval  error = 必须在 24-24*7 小时之间");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] setIccIdInterval fail " + th.getMessage());
            return false;
        }
    }

    public boolean setImeiEnable(android.content.Context context, boolean z) {
        try {
            if (com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.k, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(z))) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setImeiEnable success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setImeiEnable  error");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] setImeiEnable fail " + th.getMessage());
            return false;
        }
    }

    public boolean setImeiInterval(android.content.Context context, int i) {
        try {
            if (com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.l, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(((long) i) * 3600000))) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setImeiInterval success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setImeiInterval  error = 必须在 24-24*7 小时之间");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] setImeiInterval fail " + th.getMessage());
            return false;
        }
    }

    public boolean setImsiEnable(android.content.Context context, boolean z) {
        try {
            if (com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.m, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(z))) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setImsiEnable success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setImsiEnable  error");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] setImsiEnable fail " + th.getMessage());
            return false;
        }
    }

    public boolean setImsiInterval(android.content.Context context, int i) {
        try {
            if (com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.n, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(((long) i) * 3600000))) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setImsiInterval success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setImsiInterval  error = 必须在 24-24*7 小时之间");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] setImsiInterval fail " + th.getMessage());
            return false;
        }
    }

    public boolean setIndividuationPush(android.content.Context context, boolean z) {
        try {
            android.content.Context applicationContext = context.getApplicationContext();
            checkContext(applicationContext);
            com.getui.gtc.base.GtcProvider.setContext(applicationContext);
            com.igexin.push.g.q.a(applicationContext, com.igexin.push.g.q.k, java.lang.Boolean.valueOf(z));
            com.getui.gtc.dim.DimManager.getInstance().setSetting(applicationContext, com.igexin.push.g.f.b.e, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(z || ((java.lang.Boolean) com.igexin.push.g.q.b(applicationContext, com.igexin.push.g.q.l, java.lang.Boolean.TRUE)).booleanValue() || ((java.lang.Boolean) com.igexin.push.g.q.b(applicationContext, com.igexin.push.g.q.m, java.lang.Boolean.TRUE)).booleanValue()));
            com.igexin.c.a.c.a.c.a().a("[PushManager] setIndividuationPush success");
            return true;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] setIndividuationPush  error = " + th.toString());
            return false;
        }
    }

    public boolean setIpEnable(android.content.Context context, boolean z) {
        try {
            if (com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.y, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(z))) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setIpEnable success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setIpEnable  error");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] setIpEnable fail " + th.getMessage());
            return false;
        }
    }

    public boolean setIpInterval(android.content.Context context, long j) {
        try {
            if (com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.z, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(j * 1000))) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setIpInterval success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setIpInterval  error = 必须在 5-1800  秒之间");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] setIpInterval fail " + th.getMessage());
            return false;
        }
    }

    public boolean setLinkMerge(android.content.Context context, boolean z) {
        try {
            android.content.Context applicationContext = context.getApplicationContext();
            checkContext(applicationContext);
            com.getui.gtc.base.GtcProvider.setContext(applicationContext);
            com.igexin.push.g.q.a(applicationContext, com.igexin.push.g.q.l, java.lang.Boolean.valueOf(z));
            com.getui.gtc.dim.DimManager.getInstance().setSetting(applicationContext, com.igexin.push.g.f.b.e, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(((java.lang.Boolean) com.igexin.push.g.q.b(applicationContext, com.igexin.push.g.q.k, java.lang.Boolean.TRUE)).booleanValue() || z || ((java.lang.Boolean) com.igexin.push.g.q.b(applicationContext, com.igexin.push.g.q.m, java.lang.Boolean.TRUE)).booleanValue()));
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("action", "setLinkMerge");
            bundle.putBoolean("enable", z);
            android.content.Intent intent = new android.content.Intent(applicationContext.getApplicationContext(), (java.lang.Class<?>) getInstance().getUserPushService(applicationContext));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return getInstance().startService(applicationContext, intent);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] setLinkMerge  error = " + th.toString());
            return false;
        }
    }

    public boolean setLocationInterval(android.content.Context context, long j) {
        try {
            long j2 = j * 1000;
            boolean setting = com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.h, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(j2));
            boolean setting2 = com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.j, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(j2));
            if (setting && setting2) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setLocationInterval success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setLocationInterval  error = 必须在 5-1800 秒之间");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] setLocationInterval fail " + th.getMessage());
            return false;
        }
    }

    public boolean setMacEnable(android.content.Context context, boolean z) {
        try {
            if (com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.o, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(z))) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setMacEnable success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setMacEnable  error");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] setMacEnable fail " + th.getMessage());
            return false;
        }
    }

    public boolean setMacInterval(android.content.Context context, int i) {
        try {
            if (com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.p, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(((long) i) * 3600000))) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setMacInterval success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setMacInterval  error = 必须在 24-24*7 小时之间");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] setMacInterval fail " + th.getMessage());
            return false;
        }
    }

    public boolean setNotificationIcon(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("action", "setNotificationIcon");
            bundle.putString("smallIcon", str);
            bundle.putString("largeIcon", str2);
            android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] setNotificationIcon  error = " + th.toString());
            return false;
        }
    }

    @java.lang.Deprecated
    public boolean setOPPOBadgeNum(android.content.Context context, int i) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            com.igexin.c.a.c.a.c.a().a("[PushManager] call - > setHwBadgeNum");
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("action", "setOppoBadgeNum");
            bundle.putInt("badgeNum", i);
            android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] setOPPOBadgeNum  error = " + th.toString());
            return false;
        }
    }

    public boolean setScenePush(android.content.Context context, boolean z) {
        try {
            android.content.Context applicationContext = context.getApplicationContext();
            checkContext(applicationContext);
            com.getui.gtc.base.GtcProvider.setContext(applicationContext);
            com.igexin.push.g.q.a(applicationContext, com.igexin.push.g.q.n, java.lang.Boolean.valueOf(z));
            boolean z2 = z || ((java.lang.Boolean) com.igexin.push.g.q.b(applicationContext, com.igexin.push.g.q.m, java.lang.Boolean.TRUE)).booleanValue();
            com.getui.gtc.dim.DimManager.getInstance().setSetting(applicationContext, com.igexin.push.g.f.b.i, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(z2));
            com.getui.gtc.dim.DimManager.getInstance().setSetting(applicationContext, com.igexin.push.g.f.b.g, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(z2));
            com.getui.gtc.dim.DimManager.getInstance().setSetting(applicationContext, com.igexin.push.g.f.b.A, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(z2));
            com.igexin.c.a.c.a.c.a().a("[PushManager] setScenePush success");
            return true;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] setScenePush  error = " + th.toString());
            return false;
        }
    }

    public boolean setSerialNumberEnable(android.content.Context context, boolean z) {
        try {
            if (com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.s, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(z))) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setSerialNumberEnable success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setSerialNumberEnable  error");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] setSerialNumberEnable fail " + th.getMessage());
            return false;
        }
    }

    public boolean setSerialNumberInterval(android.content.Context context, int i) {
        try {
            if (com.getui.gtc.dim.DimManager.getInstance().setSetting(context, com.igexin.push.g.f.b.t, com.getui.gtc.dim.Caller.PUSH.name(), java.lang.String.valueOf(((long) i) * 3600000))) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setSerialNumberInterval success");
                return true;
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] setSerialNumberInterval  error = 必须在 24-24*7 小时之间");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.c.a().a("[PushManager] setSerialNumberInterval fail " + th.getMessage());
            return false;
        }
    }

    public boolean setSilentTime(android.content.Context context, int i, int i2) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            if (i >= 0 && i < 24 && i2 >= 0 && i2 <= 23) {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("action", "setSilentTime");
                bundle.putInt("beginHour", i);
                bundle.putInt("duration", i2);
                android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
                intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra("bundle", bundle);
                return startService(context, intent);
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] call - > setSilentTime failed, parameter [beginHour] or [duration] value exceeding");
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] queryTag  error = " + th.toString());
            return false;
        }
    }

    public boolean setSocketTimeout(android.content.Context context, int i) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            if (i < 0) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call - > setSocketTimeout failed, parameter [timeout] < 0, illegal");
                return false;
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("action", "setSocketTimeout");
            bundle.putInt("timeout", i);
            android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] setSocketTimeout  error = " + th.toString());
            return false;
        }
    }

    public int setTag(android.content.Context context, com.igexin.sdk.Tag[] tagArr, java.lang.String str) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            if (tagArr == null) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call -> setTag failed, parameter [tags] is null");
                com.igexin.c.a.c.a.a("PushManager|tags is null", new java.lang.Object[0]);
                sendSetTagResult(context, str, "20006");
                return com.igexin.sdk.PushConsts.SETTAG_ERROR_NULL;
            }
            if (str == null) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call -> setTag failed, parameter [sn] is null");
                sendSetTagResult(context, str, "20007");
                return 20007;
            }
            if (tagArr.length > 200) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call -> setTag failed, parameter [tags] len > 200 is exceeds");
                sendSetTagResult(context, str, com.igexin.sdk.PushConsts.SEND_MESSAGE_ERROR_GENERAL);
                return com.igexin.sdk.PushConsts.SETTAG_ERROR_COUNT;
            }
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastSetTagTime < 1000) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call - > setTag failed, it be called too frequently");
                sendSetTagResult(context, str, com.igexin.sdk.PushConsts.SEND_MESSAGE_ERROR_TIME_OUT);
                return 20002;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (com.igexin.sdk.Tag tag : tagArr) {
                if (tag != null && tag.getName() != null) {
                    if (!tag.getName().contains(" ") && !tag.getName().contains(com.igexin.push.core.b.an)) {
                        sb.append(tag.getName());
                        sb.append(com.igexin.push.core.b.an);
                    }
                    com.igexin.c.a.c.a.c.a().a("[PushManager] call -> setTag failed, the tag [" + tag.getName() + "] is not illegal");
                    sendSetTagResult(context, str, "20011");
                    return com.igexin.sdk.PushConsts.SETTAG_TAG_ILLEGAL;
                }
            }
            if (sb.length() <= 0) {
                sendSetTagResult(context, str, "20006");
                return com.igexin.sdk.PushConsts.SETTAG_ERROR_NULL;
            }
            sb.deleteCharAt(sb.length() - 1);
            com.igexin.c.a.c.a.c.a().a("[PushManager] call setTag");
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("action", "setTag");
            bundle.putString("tags", sb.toString());
            bundle.putString("sn", str);
            this.lastSetTagTime = jCurrentTimeMillis;
            android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            startService(context, intent);
            return 0;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] setTag  error = " + th.toString());
            return com.igexin.sdk.PushConsts.SETTAG_ERROR_EXCEPTION;
        }
    }

    @java.lang.Deprecated
    public boolean setVivoAppBadgeNum(android.content.Context context, int i) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            com.igexin.c.a.c.a.c.a().a("[PushManager] call - > setHwBadgeNum");
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("action", "setVivoBadgeNum");
            bundle.putInt("badgeNum", i);
            android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] setOPPOBadgeNum  error = " + th.toString());
            return false;
        }
    }

    public void turnOffPush(android.content.Context context) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            com.igexin.c.a.c.a.c.a().a("PushManager|call turnOffPush");
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("action", "turnOffPush");
            android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            startService(context, intent);
            unRegisterCallback(context);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] turnOffPush  error = " + th.toString());
        }
    }

    public void turnOnPush(android.content.Context context) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            com.igexin.c.a.c.a.c.a().a("PushManager|call turnOnPush");
            android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE);
            intent.putExtra("op_app", context.getApplicationContext().getPackageName());
            intent.putExtra("isSlave", true);
            startService(context, intent);
            registerCallback(context);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] turnOnPush  error = " + th.toString());
        }
    }

    public boolean unBindAlias(android.content.Context context, java.lang.String str, boolean z) {
        return unBindAlias(context, str, z, "unBindAlias_" + java.lang.System.currentTimeMillis());
    }

    public boolean unBindAlias(android.content.Context context, java.lang.String str, boolean z, java.lang.String str2) {
        try {
            checkContext(context);
            com.getui.gtc.base.GtcProvider.setContext(context);
            com.igexin.c.a.c.a.c.a().a("PushManager|call unBindAlias");
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastOpAliasTime < 1000) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call - > unBindAlias failed, it be called too frequently");
                sendUnBindAliasResult(context, str2, "30001");
                return false;
            }
            this.lastOpAliasTime = jCurrentTimeMillis;
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("action", "unbindAlias");
            bundle.putString("alias", str);
            bundle.putBoolean("isSeft", z);
            bundle.putString("sn", str2);
            android.content.Intent intent = new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) getUserPushService(context));
            intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a("[PushManager] unBindAlias  error = " + th.toString());
            return false;
        }
    }
}
