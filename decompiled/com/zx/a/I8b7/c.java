package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class c implements java.lang.Runnable {
    public final /* synthetic */ org.json.JSONObject a;

    public c(org.json.JSONObject jSONObject) {
        this.a = jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.c3.a("zxc10 ac start!");
            com.zx.a.I8b7.b.b(com.zx.a.I8b7.j4.a(this.a));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th);
        }
    }
}
