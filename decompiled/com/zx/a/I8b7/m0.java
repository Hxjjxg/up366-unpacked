package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class m0 {
    public static javax.crypto.SecretKey a;
    public static byte[] b;
    public static final java.security.SecureRandom c = new java.security.SecureRandom();

    @com.zx.module.annotation.Java2C.Method2C
    public static native synchronized java.lang.String a();

    public static void b() throws java.lang.Exception {
        java.lang.String string;
        com.zx.a.I8b7.y1.a aVar = new com.zx.a.I8b7.y1.a();
        java.util.HashMap<java.lang.String, java.lang.String> mapB = com.zx.a.I8b7.p0.b(a());
        aVar.c.clear();
        aVar.c.putAll(mapB);
        com.zx.a.I8b7.y1.a aVarA = aVar.a("https://zxid-m.mobileservice.cn/sdk/module/getCoreModule");
        aVarA.b = "POST";
        com.zx.a.I8b7.e1 e1VarB = com.zx.a.I8b7.e1.b("application/json; charset=utf-8");
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        jSONObject2.put("lid", com.zx.a.I8b7.x3.a(com.zx.a.I8b7.x3.h));
        jSONObject2.put("zid", com.zx.a.I8b7.x3.i);
        jSONObject.put("ctx", jSONObject2);
        jSONObject.put("sdkInfo", com.zx.a.I8b7.p0.d());
        jSONObject.put("deviceInfo", com.zx.a.I8b7.p0.b());
        aVarA.d = com.zx.a.I8b7.a2.a(e1VarB, new java.lang.String(android.util.Base64.encode(com.zx.a.I8b7.w.a(jSONObject.toString(), a, "UDID_ENC_AUTHTAG"), 2), java.nio.charset.StandardCharsets.UTF_8));
        aVarA.e = "request getCoreModule api";
        com.zx.a.I8b7.z2 z2Var = com.zx.a.I8b7.p0.a;
        com.zx.a.I8b7.y1 y1Var = new com.zx.a.I8b7.y1(aVar);
        z2Var.getClass();
        com.zx.a.I8b7.b2 b2VarA = new com.zx.a.I8b7.q1(z2Var, y1Var).a();
        if (b2VarA.b != 200) {
            throw new java.lang.RuntimeException(com.zx.a.I8b7.a.a("response errCode: ", b2VarA.a("Udid-Error-Code"), ", errMsg: ", b2VarA.a("Udid-Error-Message")));
        }
        org.json.JSONObject jSONObject3 = new org.json.JSONObject(com.zx.a.I8b7.w.a(android.util.Base64.decode(new org.json.JSONObject(b2VarA.e.b()).getString("data"), 2), a, "UDID_ENC_AUTHTAG"));
        if (!jSONObject3.getBoolean("enable")) {
            com.zx.a.I8b7.h4 h4Var = com.zx.a.I8b7.w2.a.a.a;
            if (h4Var.b == null) {
                h4Var.b = h4Var.d();
            }
            try {
                h4Var.b.delete("zx_table", "key in(17,18)", null);
                com.zx.a.I8b7.x3.H = null;
                com.zx.a.I8b7.c3.a("clearCoreModule success");
            } catch (java.lang.Exception e) {
                java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("clearCoreModule error:");
                sbA.append(e.getMessage());
                com.zx.a.I8b7.c3.b(sbA.toString());
            }
            com.zx.a.I8b7.c3.a("coreModule enable is false");
            return;
        }
        org.json.JSONObject jSONObject4 = jSONObject3.getJSONObject("module");
        jSONObject4.getString("version");
        java.lang.String string2 = jSONObject4.getString("checksum");
        byte[] bArrDecode = android.util.Base64.decode(jSONObject4.getString("data"), 0);
        if (!android.text.TextUtils.equals(string2, com.zx.a.I8b7.w.a("SHA256", bArrDecode))) {
            throw new java.io.IOException("zx checksum1 exception");
        }
        com.zx.a.I8b7.c3.a("verify checksum finished");
        org.json.JSONObject jSONObject5 = new org.json.JSONObject();
        jSONObject5.put("mainVersion", com.zx.a.I8b7.x3.b);
        jSONObject5.put("coreVersion", com.zx.a.I8b7.x3.d);
        jSONObject5.put("checksum", string2);
        com.zx.a.I8b7.w2.a.a.a.getClass();
        java.lang.String string3 = jSONObject5.getString("coreVersion");
        try {
            string = com.zx.a.I8b7.x3.H.getString("coreVersion");
        } catch (java.lang.Exception unused) {
            string = "";
        }
        if (!android.text.TextUtils.isEmpty(string3) && !android.text.TextUtils.equals(string3, string)) {
            com.zx.a.I8b7.h4 h4Var2 = com.zx.a.I8b7.w2.a.a.a;
            if (h4Var2.b == null) {
                h4Var2.b = h4Var2.d();
            }
            try {
                java.lang.String str = new java.lang.String(android.util.Base64.encode(com.zx.a.I8b7.w.b("AES/CBC/PKCS5Padding", com.zx.a.I8b7.x3.x, com.zx.a.I8b7.x3.y, bArrDecode), 0), java.nio.charset.StandardCharsets.UTF_8);
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put("key", (java.lang.Integer) 17);
                contentValues.put("value", str);
                com.zx.a.I8b7.c3.a("replace resultId = " + h4Var2.b.replace("zx_table", null, contentValues));
            } catch (java.lang.Exception e2) {
                com.zx.a.I8b7.c3.b("ZXID updateDBValue valueID:17,value:" + bArrDecode + ",error:" + e2.toString());
            }
            com.zx.a.I8b7.w2.a.a.a.a(18, jSONObject5.toString(), true);
            com.zx.a.I8b7.x3.H = jSONObject5;
        }
        com.zx.a.I8b7.c3.a("decrypt and checksum finished");
    }
}
