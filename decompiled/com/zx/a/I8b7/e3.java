package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class e3 implements java.lang.Runnable {
    public final /* synthetic */ android.content.Context a;
    public final /* synthetic */ com.zx.sdk.api.Callback b;

    public e3(com.zx.a.I8b7.i3 i3Var, android.content.Context context, com.zx.sdk.api.Callback callback) {
        this.a = context;
        this.b = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.String strA;
        try {
            android.content.Context context = this.a;
            if (android.text.TextUtils.isEmpty(com.zx.a.I8b7.x3.k) || "{}".equals(com.zx.a.I8b7.x3.k)) {
                com.zx.a.I8b7.x3.a = context.getApplicationContext();
                com.zx.a.I8b7.w2 w2Var = com.zx.a.I8b7.w2.a.a;
                com.zx.a.I8b7.x3.a(w2Var.a);
                strA = w2Var.a.a(16);
                com.zx.a.I8b7.x3.k = strA;
            } else {
                strA = com.zx.a.I8b7.x3.k;
            }
            try {
                if (android.text.TextUtils.isEmpty(strA)) {
                    java.lang.String strA2 = com.zx.a.I8b7.j4.a("62");
                    com.zx.sdk.api.Callback callback = this.b;
                    if (com.zx.a.I8b7.j4.d.get(strA2) == java.lang.Boolean.TRUE) {
                        strA2 = "";
                    }
                    callback.onSuccess(strA2);
                    return;
                }
                java.lang.String strOptString = new org.json.JSONObject(strA).optString("openid");
                if ("OPENID_CLOSED".equals(strOptString)) {
                    this.b.onFailed(10001, "未开通");
                    return;
                }
                java.lang.String strA3 = com.zx.a.I8b7.j4.a("62");
                if (com.zx.a.I8b7.j4.d.get(strA3) != java.lang.Boolean.TRUE) {
                    strOptString = strA3;
                }
                this.b.onSuccess(strOptString);
            } catch (java.lang.Throwable th) {
                this.b.onFailed(10000, th.getMessage());
            }
        } catch (java.lang.Throwable th2) {
            com.zx.sdk.api.Callback callback2 = this.b;
            if (callback2 != null) {
                callback2.onFailed(10000, th2.getMessage());
            }
            com.zx.a.I8b7.r3.a(th2, com.zx.a.I8b7.q3.a("ZXManager.getZXID(zxidListener) failed: "));
        }
    }
}
