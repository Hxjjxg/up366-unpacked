package com.cmic.gen.sdk;

/* JADX INFO: compiled from: NubiaOAID.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class m0 extends com.cmic.gen.sdk.o0 {
    private final android.content.Context a;

    m0(android.content.Context context) {
        this.a = context;
    }

    @Override // com.cmic.gen.sdk.o0
    public java.lang.String a() {
        android.net.Uri uri = android.net.Uri.parse("content://cn.nubia.identity/identity");
        try {
            int i = android.os.Build.VERSION.SDK_INT;
            android.content.ContentProviderClient contentProviderClientAcquireContentProviderClient = this.a.getContentResolver().acquireContentProviderClient(uri);
            android.os.Bundle bundleCall = null;
            if (contentProviderClientAcquireContentProviderClient != null) {
                bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
                if (i >= 24) {
                    contentProviderClientAcquireContentProviderClient.release();
                } else {
                    contentProviderClientAcquireContentProviderClient.release();
                }
            }
            return (bundleCall != null ? bundleCall.getInt("code", -1) : -1) == 0 ? bundleCall.getString(com.igexin.push.core.b.C) : "";
        } catch (java.lang.Exception unused) {
            return "";
        }
    }
}
