package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class K implements com.chuanglan.shanyan_sdk.c0 {
    private java.lang.Class a = null;
    private java.lang.String b;

    @Override // com.chuanglan.shanyan_sdk.c0
    public boolean a(android.content.Context context) {
        try {
            this.a = java.lang.Class.forName("com.android.id.impl.IdProviderImpl");
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    @Override // com.chuanglan.shanyan_sdk.c0
    public boolean b(android.content.Context context) {
        return true;
    }

    @Override // com.chuanglan.shanyan_sdk.c0
    public java.lang.String c(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(this.b)) {
            try {
                this.b = java.lang.String.valueOf(this.a.getMethod("getOAID", android.content.Context.class).invoke(this.a.newInstance(), context));
            } catch (java.lang.Throwable unused) {
                this.b = null;
            }
        }
        return this.b;
    }
}
