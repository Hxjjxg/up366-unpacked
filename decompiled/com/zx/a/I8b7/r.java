package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class r {
    public static javax.crypto.SecretKey a;
    public static byte[] b;
    public static final java.security.SecureRandom c = new java.security.SecureRandom();

    @com.zx.module.annotation.Java2C.Method2C
    public static native synchronized java.lang.String a();

    @com.zx.module.annotation.Java2C.Method2C
    private static native java.lang.String b() throws java.lang.Exception;

    public static void c() throws java.lang.Exception {
        com.zx.a.I8b7.y1.a aVar = new com.zx.a.I8b7.y1.a();
        java.util.HashMap<java.lang.String, java.lang.String> mapB = com.zx.a.I8b7.p0.b(a());
        aVar.c.clear();
        aVar.c.putAll(mapB);
        com.zx.a.I8b7.y1.a aVarA = aVar.a("https://zxid-m.mobileservice.cn/sdk/config/init");
        aVarA.b = "POST";
        aVarA.d = com.zx.a.I8b7.a2.a(com.zx.a.I8b7.e1.b("application/json; charset=utf-8"), b());
        aVarA.e = "request config api";
        com.zx.a.I8b7.z2 z2Var = com.zx.a.I8b7.p0.a;
        com.zx.a.I8b7.y1 y1Var = new com.zx.a.I8b7.y1(aVar);
        z2Var.getClass();
        com.zx.a.I8b7.b2 b2VarA = new com.zx.a.I8b7.q1(z2Var, y1Var).a();
        if (b2VarA.b != 200) {
            throw new java.lang.RuntimeException(com.zx.a.I8b7.a.a("response errCode: ", b2VarA.a("Udid-Error-Code"), ", errMsg: ", b2VarA.a("Udid-Error-Message")));
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject(com.zx.a.I8b7.w.a(android.util.Base64.decode(new org.json.JSONObject(b2VarA.e.b()).getString("data"), 2), a, "UDID_ENC_AUTHTAG"));
        java.lang.String string = jSONObject.getString("configVersion");
        com.zx.a.I8b7.w2 w2Var = com.zx.a.I8b7.w2.a.a;
        w2Var.a.getClass();
        if (!android.text.TextUtils.equals(string, com.zx.a.I8b7.x3.q)) {
            com.zx.a.I8b7.x3.q = string;
            w2Var.a.a(4, string, false);
        }
        org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("fieldConfig");
        com.zx.a.I8b7.h4 h4Var = w2Var.a;
        java.lang.String string2 = jSONObject2.toString();
        h4Var.getClass();
        if (!android.text.TextUtils.equals(string2, com.zx.a.I8b7.x3.z)) {
            com.zx.a.I8b7.x3.z = string2;
            w2Var.a.a(11, string2, true);
        }
        org.json.JSONObject jSONObject3 = jSONObject.getJSONObject("reportConfig");
        com.zx.a.I8b7.h4 h4Var2 = w2Var.a;
        java.lang.String string3 = jSONObject3.toString();
        h4Var2.getClass();
        if (!android.text.TextUtils.equals(string3, com.zx.a.I8b7.x3.A)) {
            com.zx.a.I8b7.x3.A = string3;
            w2Var.a.a(12, string3, true);
        }
        org.json.JSONObject jSONObject4 = jSONObject.getJSONObject("cryptoConfig");
        com.zx.a.I8b7.h4 h4Var3 = w2Var.a;
        java.lang.String string4 = jSONObject4.toString();
        h4Var3.getClass();
        if (!android.text.TextUtils.equals(string4, com.zx.a.I8b7.x3.B)) {
            com.zx.a.I8b7.x3.B = string4;
            w2Var.a.a(15, string4, true);
        }
        org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("appConfig");
        if (jSONObjectOptJSONObject != null) {
            com.zx.a.I8b7.c3.a("处理 appConfig ");
            try {
                org.json.JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray("list");
                if (jSONArray == null || jSONArray.length() <= 0) {
                    com.zx.a.I8b7.c3.b("appConfig list is empty");
                } else {
                    int length = jSONArray.length();
                    int i = jSONObjectOptJSONObject.getInt("type");
                    if (i == 1) {
                        for (int i2 = 0; i2 < length; i2++) {
                            jSONArray.put(i2, com.zx.a.I8b7.w.a(android.util.Base64.decode(jSONArray.getString(i2), 2), a, "UDID_ENC_AUTHTAG"));
                        }
                    } else if (i == 3) {
                        javax.crypto.SecretKey secretKeyA = com.zx.a.I8b7.w.a(b, com.zx.a.I8b7.x3.a(com.zx.a.I8b7.x3.h));
                        for (int i3 = 0; i3 < length; i3++) {
                            jSONArray.put(i3, new java.lang.String(com.zx.a.I8b7.w.a("AES/CBC/PKCS7Padding", secretKeyA, new javax.crypto.spec.IvParameterSpec("UDID_ENC_AUTHTAG".getBytes(java.nio.charset.StandardCharsets.UTF_8)), android.util.Base64.decode(jSONArray.getString(i3), 2)), java.nio.charset.StandardCharsets.UTF_8));
                        }
                    }
                    com.zx.a.I8b7.w2 w2Var2 = com.zx.a.I8b7.w2.a.a;
                    com.zx.a.I8b7.h4 h4Var4 = w2Var2.a;
                    java.lang.String string5 = jSONObjectOptJSONObject.toString();
                    h4Var4.getClass();
                    if (!android.text.TextUtils.equals(string5, com.zx.a.I8b7.x3.C)) {
                        com.zx.a.I8b7.x3.C = string5;
                        w2Var2.a.a(21, string5, true);
                    }
                }
            } catch (java.lang.Exception e) {
                com.zx.a.I8b7.c3.a(e);
            }
        }
        org.json.JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("commonConfig");
        if (jSONObjectOptJSONObject2 != null) {
            com.zx.a.I8b7.w2 w2Var3 = com.zx.a.I8b7.w2.a.a;
            com.zx.a.I8b7.h4 h4Var5 = w2Var3.a;
            java.lang.String string6 = jSONObjectOptJSONObject2.toString();
            h4Var5.getClass();
            if (!android.text.TextUtils.equals(string6, com.zx.a.I8b7.x3.D)) {
                com.zx.a.I8b7.x3.D = string6;
                w2Var3.a.a(22, string6, true);
            }
        }
        org.json.JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("invokeConfig");
        if (jSONObjectOptJSONObject3 != null) {
            com.zx.a.I8b7.w2 w2Var4 = com.zx.a.I8b7.w2.a.a;
            com.zx.a.I8b7.h4 h4Var6 = w2Var4.a;
            java.lang.String string7 = jSONObjectOptJSONObject3.toString();
            synchronized (h4Var6) {
                if (!android.text.TextUtils.equals(string7, com.zx.a.I8b7.x3.E)) {
                    com.zx.a.I8b7.x3.E = string7;
                    com.zx.a.I8b7.x3.c();
                    w2Var4.a.a(19, com.zx.a.I8b7.x3.E, true);
                }
            }
        }
        org.json.JSONObject jSONObject5 = new org.json.JSONObject();
        org.json.JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("extConfig");
        if (jSONObjectOptJSONObject4 != null && jSONObjectOptJSONObject4.has("zxc4")) {
            jSONObject5.put("zxc4", true);
        }
        com.zx.a.I8b7.w2 w2Var5 = com.zx.a.I8b7.w2.a.a;
        w2Var5.a.a(jSONObject5);
        if (com.zx.a.I8b7.x3.r) {
            return;
        }
        w2Var5.a.getClass();
        if (true != com.zx.a.I8b7.x3.r) {
            com.zx.a.I8b7.x3.r = true;
            w2Var5.a.a(6, com.zx.a.I8b7.x3.r + "", false);
        }
    }
}
