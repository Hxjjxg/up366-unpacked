package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class X implements com.chuanglan.shanyan_sdk.c0 {
    private static java.lang.String h;
    private static boolean i;
    private static boolean j;
    private static final java.util.concurrent.CountDownLatch k = new java.util.concurrent.CountDownLatch(1);
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private com.chuanglan.shanyan_sdk.Z e;
    private java.lang.String f;
    private java.lang.String g;

    public X(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public java.lang.String a() {
        return "OUID";
    }

    public int b() {
        return 1;
    }

    @Override // com.chuanglan.shanyan_sdk.c0
    public java.lang.String c(android.content.Context context) {
        com.chuanglan.shanyan_sdk.Z z;
        if (!android.text.TextUtils.isEmpty(h) || (z = this.e) == null || z.a() == null) {
            return h;
        }
        try {
            java.lang.String strA = this.e.a().a(d(context), e(context), a(), b());
            h = strA;
            if (!android.text.TextUtils.isEmpty(strA)) {
                context.unbindService(this.e);
            }
        } catch (java.lang.Throwable unused) {
        }
        return h;
    }

    public java.lang.String d(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(this.f)) {
            this.f = com.chuanglan.shanyan_sdk.C0065v.g().c(context);
        }
        return this.f;
    }

    public java.lang.String e(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(this.g)) {
            try {
                this.f = d(context);
                android.content.pm.Signature[] signatureArr = context.getPackageManager().getPackageInfo(this.f, 64).signatures;
                if (signatureArr != null && signatureArr.length > 0) {
                    byte[] bArrDigest = java.security.MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    for (byte b : bArrDigest) {
                        sb.append(java.lang.Integer.toHexString((b & 255) | 256).substring(1, 3));
                    }
                    this.g = sb.toString();
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return this.g;
    }

    @Override // com.chuanglan.shanyan_sdk.c0
    public boolean a(android.content.Context context) {
        if (j) {
            return i;
        }
        if (context == null || android.text.TextUtils.isEmpty(this.a)) {
            i = false;
        } else {
            try {
                android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.a, 0);
                if (android.os.Build.VERSION.SDK_INT >= 28) {
                    return packageInfo != null && com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(packageInfo) >= 1;
                }
                i = packageInfo != null && packageInfo.versionCode >= 1;
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }
        j = true;
        return i;
    }

    @Override // com.chuanglan.shanyan_sdk.c0
    public boolean b(android.content.Context context) {
        if (context == null || android.text.TextUtils.isEmpty(this.a)) {
            return false;
        }
        if (this.e == null) {
            this.e = new com.chuanglan.shanyan_sdk.Z(this.d, k);
        }
        android.content.Intent intent = new android.content.Intent();
        if (android.text.TextUtils.isEmpty(this.b)) {
            intent.setPackage(this.a);
        } else {
            intent.setComponent(new android.content.ComponentName(this.a, this.b));
        }
        if (!android.text.TextUtils.isEmpty(this.c)) {
            intent.setAction(this.c);
        }
        return this.e.a(context, intent);
    }
}
