package com.igexin.sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PushService extends android.app.Service {
    private final java.lang.String TAG = getClass().getName();

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        java.lang.String type = (intent == null || intent.getType() == null) ? "" : intent.getType();
        if (!type.startsWith("GB-") && !type.startsWith("PB-")) {
            return com.igexin.c.a.c.a.c.a.equals(type) ? com.igexin.c.a.c.a.d.a().a.getBinder() : type.startsWith("GTC-") ? com.igexin.push.core.ServiceManager.getInstance().a((android.app.Service) this, intent) : com.igexin.push.core.ServiceManager.getInstance().a((android.app.Service) this, intent);
        }
        com.igexin.push.core.ServiceManager.getInstance().a(this, intent, 0, 0);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            com.getui.gtc.base.GtcProvider.setContext(this);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        super.onCreate();
        com.igexin.push.core.ServiceManager.getInstance();
        com.igexin.push.core.ServiceManager.a((android.content.Context) this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        com.igexin.push.core.ServiceManager serviceManager = com.igexin.push.core.ServiceManager.getInstance();
        com.igexin.c.a.c.a.a("ServiceManager|onDestroy...", new java.lang.Object[0]);
        if (serviceManager.a != null) {
            serviceManager.a.onServiceDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        com.igexin.push.core.ServiceManager.getInstance();
        com.igexin.push.core.ServiceManager.a();
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        com.igexin.push.core.ServiceManager.getInstance().a(this, intent, i, i2);
        return 2;
    }
}
