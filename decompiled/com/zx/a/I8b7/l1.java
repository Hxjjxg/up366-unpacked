package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class l1 {
    public static javax.crypto.SecretKey a;
    public static byte[] b;
    public static final java.security.SecureRandom c = new java.security.SecureRandom();

    @com.zx.module.annotation.Java2C.Method2C
    public static native synchronized java.lang.String a();

    public static void b() throws java.lang.Exception {
        java.lang.String strA = com.zx.a.I8b7.j4.a("30");
        if (android.text.TextUtils.isEmpty(strA)) {
            return;
        }
        com.zx.a.I8b7.y1.a aVar = new com.zx.a.I8b7.y1.a();
        java.util.HashMap<java.lang.String, java.lang.String> mapB = com.zx.a.I8b7.p0.b(a());
        aVar.c.clear();
        aVar.c.putAll(mapB);
        com.zx.a.I8b7.y1.a aVarA = aVar.a("https://zxid-m.mobileservice.cn/sdk/app/itfs");
        aVarA.b = "POST";
        com.zx.a.I8b7.e1 e1VarB = com.zx.a.I8b7.e1.b("application/json; charset=utf-8");
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        jSONObject2.put("lid", com.zx.a.I8b7.x3.a(com.zx.a.I8b7.x3.h));
        jSONObject2.put("zid", com.zx.a.I8b7.x3.i);
        jSONObject.put("ctx", jSONObject2);
        jSONObject.put("sdkInfo", com.zx.a.I8b7.p0.d());
        jSONObject.put("deviceInfo", com.zx.a.I8b7.p0.b());
        jSONObject.put("itfs", new java.lang.String(android.util.Base64.encode(com.zx.a.I8b7.w.a(strA, a, "UDID_ENC_AUTHTAG"), 2), java.nio.charset.StandardCharsets.UTF_8));
        aVarA.d = com.zx.a.I8b7.a2.a(e1VarB, new java.lang.String(android.util.Base64.encode(com.zx.a.I8b7.w.a(jSONObject.toString(), a, "UDID_ENC_AUTHTAG"), 2), java.nio.charset.StandardCharsets.UTF_8));
        aVarA.e = "request postITFS api";
        com.zx.a.I8b7.z2 z2Var = com.zx.a.I8b7.p0.a;
        com.zx.a.I8b7.y1 y1Var = new com.zx.a.I8b7.y1(aVar);
        z2Var.getClass();
        com.zx.a.I8b7.b2 b2VarA = new com.zx.a.I8b7.q1(z2Var, y1Var).a();
        if (b2VarA.b != 200) {
            throw new java.lang.RuntimeException(com.zx.a.I8b7.a.a("response errCode: ", b2VarA.a("Udid-Error-Code"), ", errMsg: ", b2VarA.a("Udid-Error-Message")));
        }
        com.zx.a.I8b7.c3.a("PostITFSRequest SUC");
    }
}
