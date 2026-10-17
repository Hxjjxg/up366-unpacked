package com.cmic.gen.sdk;

/* JADX INFO: compiled from: HonorOaid.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class u extends com.cmic.gen.sdk.o0 {
    private final android.content.Context a;
    private final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b = new java.util.concurrent.LinkedBlockingQueue<>(1);

    u(android.content.Context context) {
        this.a = context;
    }

    @Override // com.cmic.gen.sdk.o0
    java.lang.String a() {
        java.lang.String str = "";
        try {
            com.cmic.gen.sdk.b.a aVarA = com.cmic.gen.sdk.b.a(this.a);
            if (aVarA == null) {
                return "";
            }
            str = aVarA.a;
            com.cmic.gen.sdk.h0.a("HonorOaid", "getAdvertisingIdInfo id=" + aVarA.a + ", isLimitAdTrackingEnabled=" + aVarA.b);
            return str;
        } catch (java.lang.Exception e) {
            com.cmic.gen.sdk.h0.b("HonorOaid", "getAdvertisingIdInfo Exception: " + e);
            return str;
        }
    }
}
