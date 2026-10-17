package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class j2 {
    public static javax.crypto.SecretKey a;
    public static byte[] b;
    public static final java.security.SecureRandom c = new java.security.SecureRandom();
    public static java.lang.String d = "";

    public static void a(com.zx.a.I8b7.b2 b2Var) throws java.lang.Exception {
        if (b2Var.b != 200) {
            throw new java.lang.RuntimeException(com.zx.a.I8b7.a.a("response errCode: ", b2Var.a("Udid-Error-Code"), ", errMsg: ", b2Var.a("Udid-Error-Message")));
        }
        java.lang.String strB = b2Var.e.b();
        new org.json.JSONObject(strB);
        com.zx.a.I8b7.c3.a(strB);
        if (android.text.TextUtils.isEmpty(d)) {
            return;
        }
        com.zx.a.I8b7.w2.a.a.a.b(d);
        com.zx.a.I8b7.c3.a("tb2 rp suc!, lastmd5:" + d);
        d = "";
    }

    public static void b(java.lang.String str) {
        try {
            java.lang.String strB = com.zx.a.I8b7.w.b(str, "MD5");
            java.lang.String strA = com.zx.a.I8b7.w2.a.a.a.a(64);
            com.zx.a.I8b7.x3.o = strA;
            if (android.text.TextUtils.equals(strA, strB)) {
                return;
            }
            d = strB;
            com.zx.a.I8b7.y1.a aVar = new com.zx.a.I8b7.y1.a();
            java.util.HashMap<java.lang.String, java.lang.String> mapB = com.zx.a.I8b7.p0.b(a());
            aVar.c.clear();
            aVar.c.putAll(mapB);
            com.zx.a.I8b7.y1.a aVarA = aVar.a("https://zxid-m.mobileservice.cn/sdk/ext/tconfig");
            aVarA.b = "POST";
            aVarA.d = com.zx.a.I8b7.a2.a(com.zx.a.I8b7.e1.b("application/json; charset=utf-8"), a(str));
            aVarA.e = "ext tb2 request get api";
            com.zx.a.I8b7.z2 z2Var = com.zx.a.I8b7.p0.a;
            com.zx.a.I8b7.y1 y1Var = new com.zx.a.I8b7.y1(aVar);
            z2Var.getClass();
            a(new com.zx.a.I8b7.q1(z2Var, y1Var).a());
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th);
        }
    }

    public static synchronized java.lang.String a() {
        byte[] bArr = new byte[16];
        b = bArr;
        c.nextBytes(bArr);
        a = com.zx.a.I8b7.w.b(b, com.zx.a.I8b7.x3.a(com.zx.a.I8b7.x3.h));
        return new java.lang.String(android.util.Base64.encode(b, 2), java.nio.charset.StandardCharsets.UTF_8);
    }

    public static java.lang.String a(java.lang.String str) throws java.lang.Exception {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        jSONObject2.put("lid", com.zx.a.I8b7.x3.a(com.zx.a.I8b7.x3.h));
        jSONObject2.put("zid", com.zx.a.I8b7.x3.i);
        jSONObject.put("ctx", jSONObject2);
        jSONObject.put("sdkInfo", com.zx.a.I8b7.p0.d());
        jSONObject.put("deviceInfo", com.zx.a.I8b7.p0.b());
        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
        jSONObject3.put("tb2", new java.lang.String(android.util.Base64.encode(com.zx.a.I8b7.w.a(str, a, "UDID_ENC_AUTHTAG"), 2), java.nio.charset.StandardCharsets.UTF_8));
        jSONObject3.put("ood", com.zx.a.I8b7.j4.a("62"));
        jSONObject.put("extensionInfo", jSONObject3);
        return new java.lang.String(android.util.Base64.encode(com.zx.a.I8b7.w.a(jSONObject.toString(), a, "UDID_ENC_AUTHTAG"), 2), java.nio.charset.StandardCharsets.UTF_8);
    }
}
