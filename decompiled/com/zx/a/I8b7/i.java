package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class i implements java.lang.Runnable {
    public static volatile java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    @com.zx.module.annotation.Java2C.Method2C
    public native org.json.JSONObject a(int i) throws org.json.JSONException;

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.x2.c.a.a(new com.zx.a.I8b7.i.a());
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th);
        }
    }

    public class a implements com.zx.a.I8b7.x2.b {
        public a() {
        }

        @com.zx.module.annotation.Java2C.Method2C
        private native void b(android.net.Network network);

        @Override // com.zx.a.I8b7.x2.b
        public void a(android.net.Network network) {
            if (com.zx.a.I8b7.i.a.getAndSet(true)) {
                com.zx.a.I8b7.i.a.set(false);
            } else {
                b(network);
            }
        }

        @Override // com.zx.a.I8b7.x2.b
        public void a(int i, java.lang.String str) {
            if (com.zx.a.I8b7.i.a.getAndSet(true)) {
                com.zx.a.I8b7.i.a.set(false);
            }
        }

        @Override // com.zx.a.I8b7.x2.b
        public void a() {
            if (com.zx.a.I8b7.i.a.getAndSet(true)) {
                com.zx.a.I8b7.i.a.set(false);
            } else {
                b(null);
            }
        }
    }
}
