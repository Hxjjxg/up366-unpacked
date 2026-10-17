package com.cmic.gen.sdk;

/* JADX INFO: compiled from: XiaoMiOAID.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class b2 extends com.cmic.gen.sdk.o0 {
    private final android.content.Context a;

    b2(android.content.Context context) {
        this.a = context;
    }

    @Override // com.cmic.gen.sdk.o0
    public java.lang.String a() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.android.id.impl.IdProviderImpl");
            return (java.lang.String) cls.getMethod("getOAID", android.content.Context.class).invoke(cls.newInstance(), this.a);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }
}
