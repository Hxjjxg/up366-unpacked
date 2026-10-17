package com.cmic.gen.sdk;

/* JADX INFO: compiled from: CooseaOAID.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class n extends com.cmic.gen.sdk.o0 {
    private final android.app.KeyguardManager a;
    public final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b = new java.util.concurrent.LinkedBlockingQueue<>(1);

    n(android.content.Context context) {
        this.a = (android.app.KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.cmic.gen.sdk.o0
    java.lang.String a() {
        try {
            java.lang.Object objInvoke = this.a.getClass().getDeclaredMethod("obtainOaid", null).invoke(this.a, null);
            if (objInvoke != null) {
                return objInvoke.toString();
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
