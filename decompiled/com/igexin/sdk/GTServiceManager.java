package com.igexin.sdk;

import com.igexin.push.core.ServiceManager.AnonymousClass4;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class GTServiceManager {

    static class a {
        private static final com.igexin.sdk.GTServiceManager a = new com.igexin.sdk.GTServiceManager();

        private a() {
        }
    }

    private GTServiceManager() {
    }

    public static com.igexin.sdk.GTServiceManager getInstance() {
        return com.igexin.sdk.GTServiceManager.a.a;
    }

    public void onActivityCreate(android.app.Activity activity) {
        com.igexin.push.core.ServiceManager serviceManager = com.igexin.push.core.ServiceManager.getInstance();
        try {
            android.content.Context applicationContext = activity.getApplicationContext();
            com.igexin.push.core.ServiceManager.b = applicationContext;
            com.getui.gtc.base.GtcProvider.setContext(applicationContext);
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            java.lang.String name = activity.getClass().getName();
            com.igexin.b.a.a().a("gd").execute(serviceManager.new AnonymousClass4(activity.getIntent(), jCurrentTimeMillis, activity, name));
        } catch (java.lang.Throwable th) {
            activity.finish();
            com.igexin.c.a.c.a.a(th);
        }
    }

    public void onServiceCreate(android.content.Context context, android.content.Intent intent) {
        com.igexin.push.core.ServiceManager.getInstance().a(context, intent);
    }
}
