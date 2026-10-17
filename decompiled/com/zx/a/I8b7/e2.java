package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class e2 {
    public static javax.crypto.SecretKey a;
    public static byte[] b;
    public static final java.security.SecureRandom c = new java.security.SecureRandom();

    @com.zx.module.annotation.Java2C.Method2C
    public static native synchronized java.lang.String a();

    @com.zx.module.annotation.Java2C.Method2C
    private static native java.lang.String a(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Exception;

    public static java.lang.String b(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Exception {
        com.zx.a.I8b7.y1.a aVar = new com.zx.a.I8b7.y1.a();
        java.util.HashMap<java.lang.String, java.lang.String> mapB = com.zx.a.I8b7.p0.b(a());
        aVar.c.clear();
        aVar.c.putAll(mapB);
        com.zx.a.I8b7.y1.a aVarA = aVar.a("https://zxid-m.mobileservice.cn/sdk/uaid/get");
        aVarA.b = "POST";
        aVarA.d = com.zx.a.I8b7.a2.a(com.zx.a.I8b7.e1.b("application/json; charset=utf-8"), a(jSONObject, str, str2, str3));
        aVarA.e = "said get api";
        com.zx.a.I8b7.z2 z2Var = com.zx.a.I8b7.p0.a;
        com.zx.a.I8b7.y1 y1Var = new com.zx.a.I8b7.y1(aVar);
        z2Var.getClass();
        com.zx.a.I8b7.b2 b2VarA = new com.zx.a.I8b7.q1(z2Var, y1Var).a();
        if (b2VarA.b == 200) {
            return new org.json.JSONObject(com.zx.a.I8b7.w.a(android.util.Base64.decode(new org.json.JSONObject(b2VarA.e.b()).getString("data"), 2), a, "UDID_ENC_AUTHTAG")).getString("uaid");
        }
        throw new java.lang.RuntimeException(com.zx.a.I8b7.a.a("response errCode: ", b2VarA.a("Udid-Error-Code"), ", errMsg: ", b2VarA.a("Udid-Error-Message")));
    }
}
