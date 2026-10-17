package com.cmic.gen.sdk;

/* JADX INFO: compiled from: RequestParameter.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class y0 {
    public abstract java.lang.String a();

    protected abstract java.lang.String a(java.lang.String str);

    public java.lang.String b(java.lang.String str) {
        return com.cmic.gen.sdk.j0.a(a(str)).toLowerCase();
    }

    public abstract org.json.JSONObject b();
}
