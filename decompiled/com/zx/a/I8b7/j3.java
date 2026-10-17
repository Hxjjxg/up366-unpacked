package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class j3 implements java.lang.Runnable {
    public final /* synthetic */ java.lang.String a;
    public final /* synthetic */ java.lang.String b;
    public final /* synthetic */ java.lang.String c;
    public final /* synthetic */ java.lang.String d;
    public final /* synthetic */ java.lang.String e;
    public final /* synthetic */ java.lang.String f;
    public final /* synthetic */ com.zx.sdk.api.SAIDCallback g;

    public j3(com.zx.a.I8b7.i3 i3Var, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, com.zx.sdk.api.SAIDCallback sAIDCallback) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = sAIDCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.i3.a().a(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        } catch (java.lang.Throwable th) {
            com.zx.sdk.api.SAIDCallback sAIDCallback = this.g;
            if (sAIDCallback != null) {
                sAIDCallback.onFailed(10000, th.getMessage());
            }
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.getSAID() failed: "));
        }
    }
}
