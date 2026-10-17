package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class p0 {
    public static com.zx.a.I8b7.z2 a;
    public static final java.lang.String[] b;

    static {
        g();
        b = h();
    }

    public static void a(java.net.HttpURLConnection httpURLConnection) throws java.security.NoSuchAlgorithmException, java.io.IOException, java.security.cert.CertificateException, java.security.KeyStoreException, java.security.KeyManagementException {
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setConnectTimeout(7000);
        httpURLConnection.setReadTimeout(7000);
        if (httpURLConnection instanceof javax.net.ssl.HttpsURLConnection) {
            javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(c());
            httpsURLConnection.setHostnameVerifier(com.zx.a.I8b7.y2.a);
        }
    }

    public static java.util.HashMap<java.lang.String, java.lang.String> b(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.String> map = new java.util.HashMap<>();
        map.put("UDID-LID", com.zx.a.I8b7.x3.a(com.zx.a.I8b7.x3.h));
        java.lang.String str2 = com.zx.a.I8b7.x3.i;
        if (str2 == null) {
            str2 = "";
        }
        map.put("UDID-ZID", str2);
        try {
            java.lang.String str3 = new java.lang.String(android.util.Base64.encode(a().toString().getBytes(java.nio.charset.StandardCharsets.UTF_8), 2), java.nio.charset.StandardCharsets.UTF_8);
            com.zx.a.I8b7.c3.a("ZXID 请求 header 中的 appInfo: ".concat(str3));
            map.put("UDID-APP-INFO", str3);
            java.lang.String str4 = new java.lang.String(android.util.Base64.encode(e().toString().getBytes(java.nio.charset.StandardCharsets.UTF_8), 2), java.nio.charset.StandardCharsets.UTF_8);
            com.zx.a.I8b7.c3.a("ZXID 请求 header 中的 sdkInfoBase: ".concat(str4));
            map.put("UDID-SDK-INFO-BASE", str4);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("ZXID 请求 header 创建异常: ");
            sbA.append(e.getMessage());
            com.zx.a.I8b7.c3.b(sbA.toString());
        }
        map.put("UDID-PROTOCOL", "v3.0.0");
        map.put("UDID-KEY", str);
        return map;
    }

    public static javax.net.ssl.SSLSocketFactory c() throws java.security.NoSuchAlgorithmException, java.io.IOException, java.security.cert.CertificateException, java.security.KeyStoreException, java.security.KeyManagementException {
        java.security.cert.X509Certificate x509CertificateF = f();
        if (x509CertificateF == null) {
            throw new java.security.cert.CertificateException("getCurEnvCA is null");
        }
        java.security.KeyStore keyStore = java.security.KeyStore.getInstance(java.security.KeyStore.getDefaultType());
        keyStore.load(null, null);
        keyStore.setCertificateEntry(com.igexin.push.core.b.ab, x509CertificateF);
        javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
        int i = android.os.Build.VERSION.SDK_INT;
        if (i < 24 || i > 26) {
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
        } else {
            sSLContext.init(null, new javax.net.ssl.TrustManager[]{new com.zx.a.I8b7.o0()}, null);
        }
        return sSLContext.getSocketFactory();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public static org.json.JSONObject d() {
        ?? r2;
        ?? E = e();
        try {
            com.zx.a.I8b7.h4 h4Var = com.zx.a.I8b7.w2.a.a.a;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.up366.papercut.library.BuildConfig.BUILD_TYPE, com.zx.a.I8b7.j4.k() ? 1 : 0);
            jSONObject.put("permission", h4Var.h());
            jSONObject.put("enable", h4Var.f());
            jSONObject.put("showPermissionDialog", h4Var.e());
            E.put("userSettings", jSONObject);
            com.zx.a.I8b7.m1 m1Var = com.zx.a.I8b7.m1.a.a;
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                jSONObject2.put("pts", m1Var.a);
                jSONObject2.put(com.igexin.sdk.PushConsts.KEY_SERVICE_PIT, m1Var.b);
                jSONObject2.put("rc", m1Var.c);
            } catch (java.lang.Exception e) {
                com.zx.a.I8b7.c3.a(e);
            }
            E.put("processInfo", jSONObject2);
            try {
                r2 = com.zx.a.I8b7.f2.b(com.zx.a.I8b7.x3.a).getBoolean("ZX_IS_PRIVACY");
            } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
                com.zx.a.I8b7.c3.a(e2);
                r2 = 0;
            }
            E.put("privacy", r2);
            E.put("appIds", com.zx.a.I8b7.f2.a());
        } catch (org.json.JSONException e3) {
            java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("ZXID 构建SDKInfo异常:");
            sbA.append(e3.getMessage());
            com.zx.a.I8b7.c3.b(sbA.toString());
        }
        return E;
    }

    public static org.json.JSONObject e() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("version", com.zx.a.I8b7.x3.b);
            jSONObject.put("configVersion", com.zx.a.I8b7.x3.q);
            if (android.text.TextUtils.equals("core-d", com.zx.a.I8b7.x3.c)) {
                jSONObject.put("versiond", com.zx.a.I8b7.x3.d);
            }
            jSONObject.put("channelId", com.zx.a.I8b7.x3.e);
            jSONObject.put("arch", android.os.Build.CPU_ABI);
        } catch (org.json.JSONException e) {
            java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("ZXID 构建SDKInfoBase异常:");
            sbA.append(e.getMessage());
            com.zx.a.I8b7.c3.b(sbA.toString());
        }
        return jSONObject;
    }

    public static java.security.cert.X509Certificate f() throws java.security.cert.CertificateException {
        return (java.security.cert.X509Certificate) java.security.cert.CertificateFactory.getInstance("X.509").generateCertificate(new java.io.ByteArrayInputStream(a(b[0]).getBytes()));
    }

    @com.zx.module.annotation.Java2C.Method2C
    private static native java.lang.String[] g();

    @com.zx.module.annotation.Java2C.Method2C
    private static native java.lang.String[] h();

    public static java.lang.String a(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        a(stringBuffer);
        stringBuffer.append("BE");
        stringBuffer.append("GIN ");
        stringBuffer.append("CE");
        stringBuffer.append("RT");
        stringBuffer.append("IFIC");
        stringBuffer.append("ATE");
        a(stringBuffer);
        stringBuffer.append("\n");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.ByteArrayInputStream(str.getBytes(java.nio.charset.StandardCharsets.UTF_8)), java.nio.charset.StandardCharsets.UTF_8));
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (!line.trim().equals("")) {
                    sb.append(line.substring(0, line.length() - 5));
                }
            }
        } catch (java.lang.Exception e) {
            com.zx.a.I8b7.c3.a(e);
        }
        stringBuffer.append(sb.toString());
        stringBuffer.append("\n");
        a(stringBuffer);
        stringBuffer.append("EN");
        stringBuffer.append("D ");
        stringBuffer.append("CE");
        stringBuffer.append("RTI");
        stringBuffer.append("FIC");
        stringBuffer.append("ATE");
        a(stringBuffer);
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    public static org.json.JSONObject b() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("os", "Android");
            jSONObject.put("isp", com.zx.a.I8b7.j4.c(com.zx.a.I8b7.x3.a));
            jSONObject.put("brand", android.os.Build.MANUFACTURER.toUpperCase());
            jSONObject.put("applicationId", com.zx.a.I8b7.x3.g);
            jSONObject.put("country", java.util.Locale.getDefault().getCountry());
            jSONObject.put("language", java.util.Locale.getDefault().getLanguage());
            jSONObject.put("model", android.os.Build.MODEL);
            jSONObject.put("arch", com.zx.a.I8b7.j4.c());
            java.lang.String property = "";
            try {
                property = java.lang.System.getProperty("os.version");
            } catch (java.lang.Throwable unused) {
            }
            jSONObject.put("linuxV", property);
            jSONObject.put("androidVersion", com.zx.a.I8b7.j4.a("59"));
        } catch (org.json.JSONException e) {
            java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("ZXID 构建deviceInfo异常:");
            sbA.append(e.getMessage());
            com.zx.a.I8b7.c3.b(sbA.toString());
        }
        return jSONObject;
    }

    public static void a(java.lang.StringBuffer stringBuffer) {
        for (int i = 0; i < 5; i++) {
            stringBuffer.append("-");
        }
    }

    public static org.json.JSONObject a() throws org.json.JSONException {
        java.lang.String string;
        java.lang.Exception e;
        android.content.pm.Signature[] signatureArrA;
        java.security.MessageDigest messageDigest;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("appPkg", com.zx.a.I8b7.x3.g);
        java.lang.String str = "error!";
        try {
            signatureArrA = com.zx.a.I8b7.g.a(com.zx.a.I8b7.x3.g);
        } catch (java.lang.Exception e2) {
            string = "error!";
            e = e2;
        }
        if (signatureArrA != null) {
            string = "error!";
            for (android.content.pm.Signature signature : signatureArrA) {
                try {
                    byte[] byteArray = signature.toByteArray();
                    try {
                        messageDigest = java.security.MessageDigest.getInstance("MD5");
                    } catch (java.security.NoSuchAlgorithmException e3) {
                        com.zx.a.I8b7.c3.a(e3);
                    }
                    if (messageDigest == null) {
                        string = "error!";
                    } else {
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        for (byte b2 : bArrDigest) {
                            sb.append(java.lang.Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        string = sb.toString();
                    }
                } catch (java.lang.Exception e4) {
                    e = e4;
                }
            }
            str = string;
            jSONObject.put("appSign", str);
            jSONObject.put("appId", com.zx.a.I8b7.x3.f);
            return jSONObject;
        }
        jSONObject.put("appSign", str);
        jSONObject.put("appId", com.zx.a.I8b7.x3.f);
        return jSONObject;
        com.zx.a.I8b7.c3.a(e);
        str = string;
        jSONObject.put("appSign", str);
        jSONObject.put("appId", com.zx.a.I8b7.x3.f);
        return jSONObject;
    }
}
