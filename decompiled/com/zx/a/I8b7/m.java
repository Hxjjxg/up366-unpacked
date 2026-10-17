package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class m implements java.lang.Runnable {

    public class a implements com.zx.module.base.Callback {
        public a(com.zx.a.I8b7.m mVar) {
        }

        @Override // com.zx.module.base.Callback
        public void callback(java.lang.String str) {
            try {
                com.zx.a.I8b7.w2 w2Var = com.zx.a.I8b7.w2.a.a;
                w2Var.a.getClass();
                w2Var.a.a(322, str, true);
                com.zx.a.I8b7.c3.a("isp net Err had changed refresh: value");
                com.zx.a.I8b7.c3.a("n x 1 x d n1");
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.c3.a(th);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.a4.c.a.e(new org.json.JSONObject(), new com.zx.a.I8b7.m.a(this), 2);
        } catch (java.lang.Throwable unused) {
        }
    }
}
