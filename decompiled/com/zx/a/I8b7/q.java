package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class q {
    public static javax.crypto.SecretKey a;
    public static byte[] b;
    public static final java.security.SecureRandom c = new java.security.SecureRandom();

    @com.zx.module.annotation.Java2C.Method2C
    public static native synchronized java.lang.String a();

    @com.zx.module.annotation.Java2C.Method2C
    public static native void a(java.lang.String str);

    public static java.lang.String b(java.lang.String str) throws java.lang.Exception {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        jSONObject2.put("lid", com.zx.a.I8b7.x3.a(com.zx.a.I8b7.x3.h));
        jSONObject2.put("zid", com.zx.a.I8b7.x3.i);
        jSONObject.put("ctx", jSONObject2);
        jSONObject.put("code", str);
        return new java.lang.String(android.util.Base64.encode(com.zx.a.I8b7.w.a(jSONObject.toString(), a, "UDID_ENC_AUTHTAG"), 2), java.nio.charset.StandardCharsets.UTF_8);
    }
}
