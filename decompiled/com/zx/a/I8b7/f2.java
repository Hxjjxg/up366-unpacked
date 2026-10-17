package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class f2 {
    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String a(java.lang.String str) throws java.security.NoSuchAlgorithmException, java.security.InvalidKeyException;

    public static org.json.JSONArray a() {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        try {
            android.os.Bundle bundleB = b(com.zx.a.I8b7.x3.a);
            if (bundleB == null) {
                return jSONArray;
            }
            for (java.lang.String str : bundleB.keySet()) {
                if (str.startsWith("ZX_APPID_")) {
                    java.lang.String string = bundleB.getString(str);
                    if (!android.text.TextUtils.isEmpty(string)) {
                        jSONArray.put(string);
                    }
                }
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.zx.a.I8b7.c3.a(e);
        }
        return jSONArray;
    }

    public static android.os.Bundle b(android.content.Context context) throws android.content.pm.PackageManager.NameNotFoundException {
        if (com.zx.a.I8b7.x3.L == null) {
            android.content.pm.PackageManager packageManagerD = com.zx.a.I8b7.j4.d(context.getApplicationContext());
            if (android.text.TextUtils.isEmpty(com.zx.a.I8b7.x3.g)) {
                com.zx.a.I8b7.x3.g = context.getPackageName();
            }
            com.zx.a.I8b7.x3.L = packageManagerD.getApplicationInfo(com.zx.a.I8b7.x3.g, 128).metaData;
        }
        return com.zx.a.I8b7.x3.L;
    }

    @com.zx.module.annotation.Java2C.Method2C
    private static native java.lang.String b();

    public static void c(android.content.Context context) {
        try {
            com.zx.a.I8b7.x3.e = b(context).getString("ZX_CHANNEL_ID");
            com.zx.a.I8b7.c3.a("initChannelId: , channelId = '" + com.zx.a.I8b7.x3.e + "'");
        } catch (java.lang.Exception e) {
            com.zx.a.I8b7.c3.a(e);
        }
    }

    public static java.lang.String a(android.content.Context context) throws java.lang.Exception {
        java.lang.String strA;
        if (!android.text.TextUtils.isEmpty(com.zx.a.I8b7.x3.f)) {
            return com.zx.a.I8b7.x3.f.trim();
        }
        if (context != null) {
            try {
                strA = b(context).getString("ZX_APPID");
            } catch (java.lang.Exception e) {
                com.zx.a.I8b7.c3.a(e);
                strA = null;
            }
            if (android.text.TextUtils.isEmpty(strA)) {
                if (com.zx.a.I8b7.x3.e == null) {
                    c(context);
                }
                if (!android.text.TextUtils.isEmpty(com.zx.a.I8b7.x3.e)) {
                    if (android.text.TextUtils.isEmpty(com.zx.a.I8b7.x3.g)) {
                        com.zx.a.I8b7.x3.g = context.getPackageName();
                    }
                    strA = a(com.zx.a.I8b7.x3.g);
                } else {
                    throw new java.lang.IllegalStateException("ZX_APPID not found");
                }
            }
            return strA.trim();
        }
        throw new java.lang.RuntimeException("context not provided, cannot be null");
    }
}
