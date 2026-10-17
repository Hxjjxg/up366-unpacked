package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class k3 implements java.lang.Runnable {
    public final /* synthetic */ java.lang.String a;
    public final /* synthetic */ com.zx.sdk.api.Callback b;

    public k3(com.zx.a.I8b7.i3 i3Var, java.lang.String str, com.zx.sdk.api.Callback callback) {
        this.a = str;
        this.b = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.i3.a().b(this.a, this.b);
        } catch (java.lang.Throwable th) {
            com.zx.sdk.api.Callback callback = this.b;
            if (callback != null) {
                callback.onFailed(10000, th.getMessage());
            }
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.getTag() failed: "));
        }
    }
}
