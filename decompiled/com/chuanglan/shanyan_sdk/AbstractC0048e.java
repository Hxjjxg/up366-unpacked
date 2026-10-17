package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class AbstractC0048e extends com.chuanglan.shanyan_sdk.AbstractC0056m {
    private java.lang.String a;

    public AbstractC0048e() {
        this(com.igexin.push.g.s.b);
    }

    protected abstract void a(java.lang.String str);

    @Override // com.chuanglan.shanyan_sdk.AbstractC0056m
    public void a(byte[] bArr) {
        try {
            a(new java.lang.String(bArr, this.a));
        } catch (java.io.UnsupportedEncodingException e) {
            a(e.toString(), e.getClass().getSimpleName());
        }
    }

    private AbstractC0048e(java.lang.String str) {
        this.a = str;
    }
}
