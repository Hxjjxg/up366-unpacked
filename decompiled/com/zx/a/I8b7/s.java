package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class s {
    public static javax.crypto.SecretKey a;
    public static byte[] b;
    public static final java.security.SecureRandom c = new java.security.SecureRandom();

    @com.zx.module.annotation.Java2C.Method2C
    public static native synchronized java.lang.String a();

    @com.zx.module.annotation.Java2C.Method2C
    private static native java.lang.String b(int i, org.json.JSONObject jSONObject) throws java.lang.Exception;

    public static void a(int i, org.json.JSONObject jSONObject) throws java.lang.Exception {
        com.zx.a.I8b7.y1.a aVar = new com.zx.a.I8b7.y1.a();
        java.util.HashMap<java.lang.String, java.lang.String> mapB = com.zx.a.I8b7.p0.b(a());
        aVar.c.clear();
        aVar.c.putAll(mapB);
        com.zx.a.I8b7.y1.a aVarA = aVar.a("https://zxid-m.mobileservice.cn/sdk/config/token");
        aVarA.b = "POST";
        aVarA.d = com.zx.a.I8b7.a2.a(com.zx.a.I8b7.e1.b("application/json; charset=utf-8"), b(i, jSONObject));
        aVarA.e = "configToken get api";
        com.zx.a.I8b7.z2 z2Var = com.zx.a.I8b7.p0.a;
        com.zx.a.I8b7.y1 y1Var = new com.zx.a.I8b7.y1(aVar);
        z2Var.getClass();
        com.zx.a.I8b7.b2 b2VarA = new com.zx.a.I8b7.q1(z2Var, y1Var).a();
        if (b2VarA.b == 200) {
            new org.json.JSONObject(b2VarA.e.b());
            return;
        }
        throw new java.lang.RuntimeException(com.zx.a.I8b7.a.a("response errCode: ", b2VarA.a("Udid-Error-Code"), ", errMsg: ", b2VarA.a("Udid-Error-Message")));
    }
}
