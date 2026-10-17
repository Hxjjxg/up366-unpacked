package com.igexin.push.core.stub;

import com.igexin.push.core.e.f.AnonymousClass4;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class GtcCore implements com.igexin.sdk.IPushCore {
    private static final java.lang.String a = "GtcCore";

    static /* synthetic */ void a(java.lang.String str) {
        try {
            if (str.equals(com.igexin.push.core.e.C)) {
                return;
            }
            com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
            com.igexin.push.core.e.C = str;
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass4(), false, true);
            if (com.igexin.push.core.e.u) {
                com.igexin.push.core.a.b.d().i();
            }
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private static void b(java.lang.String str) {
        try {
            if (str.equals(com.igexin.push.core.e.C)) {
                return;
            }
            com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
            com.igexin.push.core.e.C = str;
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass4(), false, true);
            if (com.igexin.push.core.e.u) {
                com.igexin.push.core.a.b.d().i();
            }
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityConfigurationChanged(android.app.Activity activity, android.content.res.Configuration configuration) {
    }

    @Override // com.igexin.sdk.IPushCore
    public boolean onActivityCreateOptionsMenu(android.app.Activity activity, android.view.Menu menu) {
        return false;
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityDestroy(android.app.Activity activity) {
    }

    @Override // com.igexin.sdk.IPushCore
    public boolean onActivityKeyDown(android.app.Activity activity, int i, android.view.KeyEvent keyEvent) {
        return false;
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityNewIntent(android.app.Activity activity, android.content.Intent intent) {
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityPause(android.app.Activity activity) {
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityRestart(android.app.Activity activity) {
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityResume(android.app.Activity activity) {
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityStart(android.app.Activity activity, android.content.Intent intent) {
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityStop(android.app.Activity activity) {
    }

    @Override // com.igexin.sdk.IPushCore
    public android.os.IBinder onServiceBind(android.content.Intent intent) {
        return null;
    }

    @Override // com.igexin.sdk.IPushCore
    public void onServiceDestroy() {
    }

    @Override // com.igexin.sdk.IPushCore
    public int onServiceStartCommand(android.content.Intent intent, int i, int i2) {
        return 2;
    }

    @Override // com.igexin.sdk.IPushCore
    public boolean start(android.content.Context context) {
        com.igexin.c.a.c.a.a("GtcCore | ready to start gtc ", new java.lang.Object[0]);
        final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        final java.util.concurrent.atomic.AtomicInteger atomicInteger = new java.util.concurrent.atomic.AtomicInteger(1);
        try {
            try {
                com.igexin.push.g.o.s();
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a("GtcCore|init gtc data listener error =  " + th.toString(), new java.lang.Object[0]);
            }
            java.lang.String strInitialize = com.getui.gtc.api.GtcManager.getInstance().initialize(context, com.getui.gtc.dim.Caller.PUSH, new com.getui.gtc.api.GtcIdCallback.Stub() { // from class: com.igexin.push.core.stub.GtcCore.1
                public final void onFailure(java.lang.String str) throws android.os.RemoteException {
                    com.igexin.c.a.c.a.a("GtcCore|gtcid callback error ,error info is :".concat(java.lang.String.valueOf(str)), new java.lang.Object[0]);
                }

                public final void onSuccess(final java.lang.String str) throws android.os.RemoteException {
                    java.lang.System.currentTimeMillis();
                    com.igexin.c.a.c.a.a("GtcCore|gtcid = ".concat(java.lang.String.valueOf(str)), new java.lang.Object[0]);
                    if (com.igexin.push.core.e.m.get()) {
                        com.igexin.push.core.stub.GtcCore.a(str);
                    } else {
                        final android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
                        handler.postDelayed(new java.lang.Runnable() { // from class: com.igexin.push.core.stub.GtcCore.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (com.igexin.push.core.e.m.get()) {
                                    atomicInteger.get();
                                    com.igexin.push.core.stub.GtcCore.a(str);
                                } else if (atomicInteger.incrementAndGet() <= 30) {
                                    atomicInteger.get();
                                    handler.postDelayed(this, 300L);
                                }
                            }
                        }, 300L);
                    }
                }
            });
            java.lang.System.currentTimeMillis();
            com.igexin.c.a.c.a.a("GtcCore|gtcid = ".concat(java.lang.String.valueOf(strInitialize)), new java.lang.Object[0]);
        } catch (java.lang.Throwable th2) {
            com.igexin.c.a.c.a.a("GtcCore|init gtc error =  " + th2.toString(), new java.lang.Object[0]);
        }
        java.lang.System.currentTimeMillis();
        return true;
    }
}
