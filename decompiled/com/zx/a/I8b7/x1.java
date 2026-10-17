package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class x1 {
    public static java.lang.String a = "";
    public static java.lang.String b = "";
    public static javax.crypto.SecretKey d;
    public static byte[] e;
    public static java.util.LinkedList<java.lang.String> c = new java.util.LinkedList<>();
    public static final java.security.SecureRandom f = new java.security.SecureRandom();
    public static long g = 0;

    @com.zx.module.annotation.Java2C.Method2C
    private static native void a(org.json.JSONObject jSONObject) throws java.lang.Throwable;

    @com.zx.module.annotation.Java2C.Method2C
    private static native void b(org.json.JSONObject jSONObject) throws java.lang.Throwable;

    @com.zx.module.annotation.Java2C.Method2C
    public static native synchronized java.lang.String c();

    public static org.json.JSONObject d() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            c.clear();
            java.util.HashMap<java.lang.String, java.lang.String> mapA = a();
            com.zx.a.I8b7.x3.G = new org.json.JSONObject(mapA).toString();
            org.json.JSONObject jSONObject2 = !android.text.TextUtils.isEmpty(com.zx.a.I8b7.x3.A) ? new org.json.JSONObject(com.zx.a.I8b7.x3.A) : new org.json.JSONObject();
            org.json.JSONObject jSONObject3 = !android.text.TextUtils.isEmpty(com.zx.a.I8b7.x3.B) ? new org.json.JSONObject(com.zx.a.I8b7.x3.B) : new org.json.JSONObject();
            java.util.Iterator<java.lang.String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                java.lang.String next = itKeys.next();
                org.json.JSONObject jSONObject4 = jSONObject2.getJSONObject(next);
                int i = jSONObject4.getInt("type");
                org.json.JSONArray jSONArray = jSONObject4.getJSONArray("list");
                if (i == 1) {
                    jSONObject.put(next, a(jSONArray, mapA, jSONObject3));
                } else if (i == 2) {
                    jSONObject.put(next, b(jSONArray, mapA, jSONObject3));
                } else if (i == 3) {
                    jSONObject.put(next, c(jSONArray, mapA, jSONObject3));
                }
            }
        } catch (java.lang.Throwable th) {
            java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("ZXID 获取data参数异常:");
            sbA.append(th.getMessage());
            com.zx.a.I8b7.c3.b(sbA.toString());
        }
        return jSONObject;
    }

    @com.zx.module.annotation.Java2C.Method2C
    private static native java.lang.String e();

    /* JADX WARN: Removed duplicated region for block: B:28:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f() throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.x1.f():void");
    }

    public static org.json.JSONObject c(org.json.JSONArray jSONArray, java.util.HashMap<java.lang.String, java.lang.String> map, org.json.JSONObject jSONObject) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
        org.json.JSONObject jSONObjectB = b();
        int i = 0;
        while (true) {
            java.lang.String str = "";
            if (i >= jSONArray.length()) {
                break;
            }
            try {
                java.lang.String string = jSONArray.getString(i);
                java.lang.String str2 = map.get(string);
                if (str2 == null) {
                    str2 = "";
                }
                java.lang.String strA = a(string, str2, jSONObject);
                if (strA != null) {
                    str = strA;
                }
                jSONObject2.put(string, str);
                stringBuffer.append(str2).append("|");
                stringBuffer2.append(a(string, jSONObjectB)).append("|");
            } catch (org.json.JSONException e2) {
                java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("ZXID handleType3 error:");
                sbA.append(e2.getMessage());
                com.zx.a.I8b7.c3.b(sbA.toString());
            }
            i++;
        }
        for (java.lang.String str3 : c) {
            try {
                java.lang.String str4 = map.get(str3);
                if (str4 == null) {
                    str4 = "";
                }
                java.lang.String strA2 = a(str3, str4, jSONObject);
                if (strA2 == null) {
                    strA2 = "";
                }
                jSONObject2.put(str3, strA2);
                stringBuffer.append(str4).append("|");
                stringBuffer2.append(a(str3, jSONObjectB)).append("|");
            } catch (org.json.JSONException e3) {
                java.lang.StringBuilder sbA2 = com.zx.a.I8b7.q3.a("ZXID handleType3 childIndex error:");
                sbA2.append(e3.getMessage());
                com.zx.a.I8b7.c3.b(sbA2.toString());
            }
        }
        return !android.text.TextUtils.equals(com.zx.a.I8b7.w.b(stringBuffer.toString(), "SHA256"), com.zx.a.I8b7.w.b(stringBuffer2.toString(), "SHA256")) ? jSONObject2 : new org.json.JSONObject();
    }

    public static org.json.JSONObject b() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            return !android.text.TextUtils.isEmpty(com.zx.a.I8b7.x3.F) ? new org.json.JSONObject(com.zx.a.I8b7.x3.F) : jSONObject;
        } catch (org.json.JSONException e2) {
            java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("ZXID buildOldLv1 error:");
            sbA.append(e2.getMessage());
            com.zx.a.I8b7.c3.b(sbA.toString());
            return jSONObject;
        }
    }

    public static org.json.JSONObject b(org.json.JSONArray jSONArray, java.util.HashMap<java.lang.String, java.lang.String> map, org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        org.json.JSONObject jSONObjectB = b();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                java.lang.String string = jSONArray.getString(i);
                java.lang.String str = map.get(string);
                java.lang.String str2 = "";
                if (str == null) {
                    str = "";
                }
                if (!android.text.TextUtils.equals(a(string, jSONObjectB), str)) {
                    java.lang.String strA = a(string, str, jSONObject);
                    if (strA != null) {
                        str2 = strA;
                    }
                    jSONObject2.put(string, str2);
                }
            } catch (org.json.JSONException e2) {
                java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("ZXID handleType2 error:");
                sbA.append(e2.getMessage());
                com.zx.a.I8b7.c3.b(sbA.toString());
            }
        }
        return jSONObject2;
    }

    public static java.util.HashMap<java.lang.String, java.lang.String> a() throws org.json.JSONException {
        java.lang.String strA;
        org.json.JSONObject jSONObject = !android.text.TextUtils.isEmpty(com.zx.a.I8b7.x3.z) ? new org.json.JSONObject(com.zx.a.I8b7.x3.z) : new org.json.JSONObject();
        org.json.JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("lv1");
        org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("lv2");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return new java.util.HashMap<>();
        }
        if (jSONObjectOptJSONObject == null) {
            java.util.HashMap<java.lang.String, java.lang.String> map = new java.util.HashMap<>();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                java.lang.String string = jSONArrayOptJSONArray.getString(i);
                if ("99".equals(string)) {
                    map.put(string, com.zx.a.I8b7.b1.a());
                } else {
                    map.put(string, com.zx.a.I8b7.j4.a(string));
                }
            }
            return map;
        }
        java.util.HashMap<java.lang.String, java.lang.String> map2 = new java.util.HashMap<>();
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            java.lang.String string2 = jSONArrayOptJSONArray.getString(i2);
            if ("99".equals(string2)) {
                strA = com.zx.a.I8b7.b1.a();
            } else {
                strA = com.zx.a.I8b7.j4.a(string2);
            }
            if (!android.text.TextUtils.isEmpty(strA) && jSONObjectOptJSONObject.has(string2)) {
                string2.getClass();
                string2.hashCode();
                switch (string2) {
                    case "48":
                    case "49":
                    case "98":
                        java.lang.String[] strArrSplit = strA.split("#");
                        java.util.HashMap map3 = new java.util.HashMap();
                        for (java.lang.String str : strArrSplit) {
                            java.lang.String str2 = str.split(com.igexin.push.core.b.an)[0];
                            map3.put(str2, str.substring(str2.length() + 1));
                        }
                        org.json.JSONObject jSONObject2 = jSONObjectOptJSONObject.getJSONObject(string2);
                        java.util.Iterator<java.lang.String> itKeys = jSONObject2.keys();
                        while (itKeys.hasNext()) {
                            java.lang.String next = itKeys.next();
                            try {
                                java.lang.String str3 = string2 + "." + next;
                                java.lang.String str4 = (java.lang.String) map3.get(com.zx.a.I8b7.w.a(jSONObject2.getString(next), true));
                                map2.put(str3, str4);
                                if (!android.text.TextUtils.isEmpty(str4)) {
                                    c.add(str3);
                                }
                            } catch (java.lang.Throwable th) {
                                com.zx.a.I8b7.c3.a(th);
                            }
                        }
                        break;
                }
            }
            map2.put(string2, strA);
        }
        return map2;
    }

    public static org.json.JSONObject a(org.json.JSONArray jSONArray, java.util.HashMap<java.lang.String, java.lang.String> map, org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                java.lang.String string = jSONArray.getString(i);
                java.lang.String strA = a(string, map.get(string), jSONObject);
                if (strA == null) {
                    strA = "";
                }
                jSONObject2.put(string, strA);
            } catch (org.json.JSONException e2) {
                java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("ZXID handleType1 error:");
                sbA.append(e2.getMessage());
                com.zx.a.I8b7.c3.b(sbA.toString());
            }
        }
        return jSONObject2;
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
        java.lang.String strB;
        if (jSONObject == null || !jSONObject.has(str) || android.text.TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            int i = jSONObject.getInt(str);
            if (i == 1) {
                return new java.lang.String(android.util.Base64.encode(com.zx.a.I8b7.w.a(str2, d, "UDID_ENC_AUTHTAG"), 2), java.nio.charset.StandardCharsets.UTF_8);
            }
            if (i == 2) {
                strB = com.zx.a.I8b7.w.b(com.zx.a.I8b7.w.b(str2, "MD5").substring(0, 20), "MD5");
            } else {
                if (i != 3) {
                    return str2;
                }
                java.lang.String strB2 = com.zx.a.I8b7.w.b(str2, "MD5");
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(strB2.substring(0, 20));
                android.content.pm.PackageManager packageManager = com.zx.a.I8b7.j4.a;
                sb.append(android.os.Build.MODEL);
                strB = com.zx.a.I8b7.w.b(sb.toString(), "MD5");
            }
            return strB;
        } catch (java.lang.Exception e2) {
            com.zx.a.I8b7.c3.b("加密脱敏失败:" + str + ",error:" + e2);
            return null;
        }
    }

    public static java.lang.String a(java.lang.String str, org.json.JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0 && !jSONObject.isNull(str)) {
            return jSONObject.optString(str);
        }
        return "";
    }
}
