package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class x3 {
    public static java.lang.String A = null;
    public static java.lang.String B = null;
    public static java.lang.String C = null;
    public static java.lang.String D = null;
    public static java.lang.String E = null;
    public static java.lang.String F = null;
    public static java.lang.String G = null;
    public static android.content.Context a = null;
    public static java.lang.String b = "";
    public static java.lang.String c = "";
    public static java.lang.String d = "";
    public static java.lang.String e = null;
    public static java.lang.String f = "";
    public static java.lang.String g = "";
    public static java.lang.String h = null;
    public static java.lang.String i = null;
    public static java.lang.String j = null;
    public static java.lang.String k = "{}";
    public static boolean r;
    public static javax.crypto.SecretKey x;
    public static javax.crypto.spec.IvParameterSpec y;
    public static java.lang.String z;
    public static volatile org.json.JSONArray l = new org.json.JSONArray();
    public static java.lang.String m = "{}";
    public static java.lang.String n = "";
    public static java.lang.String o = "";
    public static int p = 0;
    public static java.lang.String q = "ANDROID-V3";
    public static java.util.HashMap<java.lang.String, java.lang.String> s = new java.util.HashMap<>();
    public static int t = 1;
    public static int u = 1;
    public static int v = -1;
    public static long w = 0;
    public static org.json.JSONObject H = new org.json.JSONObject();
    public static volatile boolean I = false;
    public static final java.util.Set<java.lang.String> J = java.util.Collections.newSetFromMap(new java.util.concurrent.ConcurrentHashMap());
    public static final java.util.Set<java.lang.String> K = java.util.Collections.newSetFromMap(new java.util.concurrent.ConcurrentHashMap());
    public static android.os.Bundle L = null;

    public static void a(android.content.Context context) throws java.lang.Exception {
        android.content.Context applicationContext = context.getApplicationContext();
        a = applicationContext;
        g = applicationContext.getPackageName();
        com.zx.a.I8b7.f2.c(a);
        f = com.zx.a.I8b7.f2.a(a);
        java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("initAppId: ");
        sbA.append(f);
        com.zx.a.I8b7.c3.a(sbA.toString());
        b(a);
        if (android.text.TextUtils.isEmpty(h)) {
            b();
        } else {
            java.lang.String strB = com.zx.a.I8b7.w.b(com.zx.a.I8b7.j4.b() + android.os.Build.MODEL, "SHA256");
            java.lang.String[] strArrSplit = h.split("-");
            if (strArrSplit.length < 2) {
                java.lang.StringBuilder sbA2 = com.zx.a.I8b7.q3.a("ZXID 检测到老版本LID:");
                sbA2.append(h);
                com.zx.a.I8b7.y.a(sbA2.toString());
                h += "-" + strB;
                com.zx.a.I8b7.w2 w2Var = com.zx.a.I8b7.w2.a.a;
                com.zx.a.I8b7.h4 h4Var = w2Var.a;
                java.lang.String str = h;
                h4Var.getClass();
                if (!android.text.TextUtils.equals(str, h)) {
                    h = str;
                    w2Var.a.a(0, str, true);
                }
                java.lang.StringBuilder sbA3 = com.zx.a.I8b7.q3.a("ZXID 兼容老版本LID后重新生成LID:");
                sbA3.append(h);
                com.zx.a.I8b7.y.a(sbA3.toString());
            } else if (android.text.TextUtils.equals(strB, strArrSplit[1])) {
                com.zx.a.I8b7.y.a("ZXID LID校验通过!");
            } else {
                com.zx.a.I8b7.h4 h4Var2 = com.zx.a.I8b7.w2.a.a.a;
                if (h4Var2.b == null) {
                    h4Var2.b = h4Var2.d();
                }
                try {
                    h4Var2.b.delete("zx_table", "key in(0,1,53,3,4,6,11,12,15,21,22,23,321,24,25,26,19,13,14)", null);
                    h = "";
                    i = "";
                    k = "";
                    m = "{}";
                    p = 0;
                    q = "ANDROID-V3";
                    r = false;
                    z = "";
                    A = "";
                    B = "";
                    F = "";
                    t = 1;
                    C = "";
                    com.zx.a.I8b7.c3.a("ZXID清理数据成功");
                } catch (java.lang.Exception e2) {
                    java.lang.StringBuilder sbA4 = com.zx.a.I8b7.q3.a("清理本地数据error:");
                    sbA4.append(e2.getMessage());
                    com.zx.a.I8b7.c3.b(sbA4.toString());
                }
                b();
                com.zx.a.I8b7.y.a("ZXID LID校验不通过");
            }
        }
        com.zx.a.I8b7.z2 z2Var = com.zx.a.I8b7.p0.a;
        try {
            com.zx.a.I8b7.z2.a aVar = new com.zx.a.I8b7.z2.a();
            aVar.b.add(new com.zx.a.I8b7.z0(com.zx.a.I8b7.c3.a.a.a, 5));
            aVar.b.add(new com.zx.a.I8b7.n0());
            javax.net.ssl.SSLSocketFactory sSLSocketFactoryC = com.zx.a.I8b7.p0.c();
            if (sSLSocketFactoryC == null) {
                throw new java.lang.NullPointerException("sslSocketFactory == null");
            }
            aVar.c = sSLSocketFactoryC;
            com.zx.a.I8b7.p0.a = new com.zx.a.I8b7.z2(aVar);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th);
            th.printStackTrace();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(4:146|3|(1:5)|(2:150|6))|(2:(8:13|152|14|200|(2:44|45)|(2:199|(3:198|48|(3:197|50|(2:196|(2:195|(2:194|(2:193|(2:189|(2:188|(3:187|58|(3:186|60|(3:185|62|(12:184|SW:64|111|136|112|(1:114)|115|144|116|(3:142|121|(1:123)(1:124))(3:148|119|(0))|128|129)(3:167|86|216))(3:166|87|215))(3:165|88|214))(3:164|89|213))(3:163|90|212))(6:162|91|140|92|192|(3:191|94|210)(3:190|95|209)))(3:161|99|208))(3:160|100|207))(3:159|101|206))(3:158|102|205))(3:157|103|204))(3:156|104|203))(3:155|105|202)|201|11)|154)|(0)|115|144|116|(0)(0)|128|129|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03aa A[DONT_GENERATE, PHI: r4
  0x03aa: PHI (r4v2 android.database.Cursor) = (r4v1 android.database.Cursor), (r4v5 android.database.Cursor) binds: [B:113:0x03a8, B:109:0x03a1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(android.content.Context r14) {
        /*
            Method dump skipped, instruction units count: 1080
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.x3.b(android.content.Context):void");
    }

    public static void c() {
        try {
            if (E != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(E);
                org.json.JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("internal");
                org.json.JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("external");
                if (jSONArrayOptJSONArray != null) {
                    java.util.Set<java.lang.String> set = J;
                    set.clear();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        set.add(jSONArrayOptJSONArray.getString(i2));
                    }
                }
                if (jSONArrayOptJSONArray2 != null) {
                    java.util.Set<java.lang.String> set2 = K;
                    set2.clear();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                        set2.add(jSONArrayOptJSONArray2.getString(i3));
                    }
                }
            }
        } catch (org.json.JSONException e2) {
            com.zx.a.I8b7.c3.a(e2);
        }
    }

    public static void a(com.zx.a.I8b7.h4 h4Var) {
        if (y == null) {
            javax.crypto.spec.IvParameterSpec ivParameterSpecG = h4Var.g();
            y = ivParameterSpecG;
            if (ivParameterSpecG == null) {
                byte[] bArrGenerateSeed = new java.security.SecureRandom().generateSeed(16);
                java.lang.String str = new java.lang.String(android.util.Base64.encode(bArrGenerateSeed, 0), java.nio.charset.StandardCharsets.UTF_8);
                h4Var.a(10, str.concat(""), false);
                com.zx.a.I8b7.c3.a("ZXID saveIvParameter ivStr:".concat(str));
                y = new javax.crypto.spec.IvParameterSpec(bArrGenerateSeed);
            }
        }
        if (x == null) {
            javax.crypto.SecretKey secretKeyI = h4Var.i();
            x = secretKeyI;
            if (secretKeyI == null) {
                try {
                    java.security.SecureRandom secureRandom = com.zx.a.I8b7.w.a;
                    javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("AES");
                    keyGenerator.init(128);
                    javax.crypto.SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
                    x = secretKeyGenerateKey;
                    h4Var.a(secretKeyGenerateKey.getEncoded());
                } catch (java.security.NoSuchAlgorithmException e2) {
                    com.zx.a.I8b7.c3.a(e2);
                    e2.printStackTrace();
                }
            }
        }
    }

    public static java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.lang.String[] strArrSplit = str.split("-");
        return strArrSplit.length == 2 ? strArrSplit[0] : str;
    }

    public static java.lang.String a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("zid", i);
            jSONObject.put("ext", k);
        } catch (org.json.JSONException e2) {
            com.zx.a.I8b7.c3.a(e2);
        }
        return jSONObject.toString();
    }

    public static void b() {
        java.lang.String str = java.util.UUID.randomUUID().toString().replaceAll("-", "") + "-" + com.zx.a.I8b7.w.b(com.zx.a.I8b7.j4.b() + android.os.Build.MODEL, "SHA256");
        com.zx.a.I8b7.w2 w2Var = com.zx.a.I8b7.w2.a.a;
        w2Var.a.getClass();
        if (!android.text.TextUtils.equals(str, h)) {
            h = str;
            w2Var.a.a(0, str, true);
        }
        com.zx.a.I8b7.y.a("ZXID 生成LID:" + str);
    }
}
