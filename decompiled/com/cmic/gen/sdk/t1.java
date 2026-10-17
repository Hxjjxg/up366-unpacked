package com.cmic.gen.sdk;

/* JADX INFO: compiled from: UmcConfigHandle.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class t1 {
    private static com.cmic.gen.sdk.t1 e;
    private com.cmic.gen.sdk.s1 a;
    private final com.cmic.gen.sdk.s1 b;
    private volatile boolean c = false;
    private com.cmic.gen.sdk.t1.c d;

    /* JADX INFO: compiled from: UmcConfigHandle.java */
    class a implements com.cmic.gen.sdk.x0 {
        a() {
        }

        @Override // com.cmic.gen.sdk.x0
        public void a(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
            try {
                if ("103000".equals(str)) {
                    com.cmic.gen.sdk.t1.this.a(jSONObject);
                    com.cmic.gen.sdk.h1.b("sdk_config_version", com.cmic.gen.sdk.auth.b.SDK_VERSION);
                    com.cmic.gen.sdk.t1 t1Var = com.cmic.gen.sdk.t1.this;
                    t1Var.a = t1Var.a();
                    if (com.cmic.gen.sdk.t1.this.d != null) {
                        com.cmic.gen.sdk.t1.this.d.a(com.cmic.gen.sdk.t1.this.a);
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            com.cmic.gen.sdk.t1.this.c = false;
        }
    }

    /* JADX INFO: compiled from: UmcConfigHandle.java */
    class b extends com.cmic.gen.sdk.k1.a {
        final /* synthetic */ com.cmic.gen.sdk.i b;

        b(com.cmic.gen.sdk.i iVar) {
            this.b = iVar;
        }

        @Override // com.cmic.gen.sdk.k1.a
        protected void a() {
            com.cmic.gen.sdk.h0.a("UmcConfigHandle", "开始拉取配置..");
            com.cmic.gen.sdk.t1.this.b(this.b);
        }
    }

    /* JADX INFO: compiled from: UmcConfigHandle.java */
    interface c {
        void a(com.cmic.gen.sdk.s1 s1Var);
    }

    private t1(boolean z) {
        com.cmic.gen.sdk.s1 s1VarA = new com.cmic.gen.sdk.s1.b().a();
        this.b = s1VarA;
        if (z) {
            this.a = s1VarA;
        } else {
            this.a = a();
        }
    }

    com.cmic.gen.sdk.s1 d() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.cmic.gen.sdk.i iVar) {
        if (this.c) {
            com.cmic.gen.sdk.h0.b("UmcConfigHandle", "正在获取配置中...");
        } else {
            this.c = true;
            com.cmic.gen.sdk.e.a().a(false, iVar, (com.cmic.gen.sdk.x0) new com.cmic.gen.sdk.t1.a());
        }
    }

    com.cmic.gen.sdk.s1 c() {
        return this.b;
    }

    void a(com.cmic.gen.sdk.t1.c cVar) {
        this.d = cVar;
    }

    public static com.cmic.gen.sdk.t1 a(boolean z) {
        if (e == null) {
            synchronized (com.cmic.gen.sdk.t1.class) {
                if (e == null) {
                    e = new com.cmic.gen.sdk.t1(z);
                }
            }
        }
        return e;
    }

    void b() {
        com.cmic.gen.sdk.h1.a aVarA = com.cmic.gen.sdk.h1.a("sso_config_xf");
        aVarA.b();
        aVarA.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(org.json.JSONObject jSONObject) {
        com.cmic.gen.sdk.h1.a aVarA = com.cmic.gen.sdk.h1.a("sso_config_xf");
        try {
            if (jSONObject.has("client_valid")) {
                aVarA.a("client_valid", java.lang.System.currentTimeMillis() + (((long) java.lang.Integer.parseInt(jSONObject.getString("client_valid"))) * 3600000));
            }
            if (jSONObject.has("Configlist")) {
                org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("Configlist");
                if (jSONObject2.has("CHANGE_HOST")) {
                    java.lang.String string = jSONObject2.getString("CHANGE_HOST");
                    if (string.contains("M007")) {
                        java.lang.String strA = a(string, "M007");
                        if (!android.text.TextUtils.isEmpty(strA)) {
                            aVarA.a("logHost", strA);
                        }
                    }
                    if (string.contains("M008")) {
                        java.lang.String strA2 = a(string, "M008");
                        if (!android.text.TextUtils.isEmpty(strA2)) {
                            aVarA.a("https_get_phone_scrip_host", strA2);
                        }
                    }
                    if (string.contains("M009")) {
                        java.lang.String strA3 = a(string, "M009");
                        if (!android.text.TextUtils.isEmpty(strA3)) {
                            aVarA.a("config_host", strA3);
                        }
                    }
                } else {
                    aVarA.a("logHost");
                    aVarA.a("https_get_phone_scrip_host");
                    aVarA.a("config_host");
                }
                a(jSONObject2, "CLOSE_FRIEND_WAPKS", "0", aVarA);
                a(jSONObject2, "CLOSE_LOGS_VERSION", "0", aVarA);
                a(jSONObject2, "CLOSE_IPV4_LIST", "0", aVarA);
                a(jSONObject2, "CLOSE_IPV6_LIST", "0", aVarA);
                a(jSONObject2, "CLOSE_M008_SDKVERSION_LIST", "0", aVarA);
                a(jSONObject2, "CLOSE_M008_APPID_LIST", "0", aVarA);
                if (jSONObject2.has("LOGS_CONTROL")) {
                    java.lang.String[] strArrSplit = jSONObject2.getString("LOGS_CONTROL").replace("h", "").split("&");
                    if (strArrSplit.length == 2 && !android.text.TextUtils.isEmpty(strArrSplit[0]) && !android.text.TextUtils.isEmpty(strArrSplit[1])) {
                        try {
                            int i = java.lang.Integer.parseInt(strArrSplit[0]);
                            int i2 = java.lang.Integer.parseInt(strArrSplit[1]);
                            aVarA.a("maxFailedLogTimes", i);
                            aVarA.a("pauseTime", i2);
                        } catch (java.lang.Exception unused) {
                            com.cmic.gen.sdk.h0.b("UmcConfigHandle", "解析日志上报限制时间次数异常");
                        }
                    }
                } else {
                    aVarA.a("maxFailedLogTimes");
                    aVarA.a("pauseTime");
                }
            }
            aVarA.c();
        } catch (java.lang.Exception e2) {
            com.cmic.gen.sdk.h0.b("UmcConfigHandle", "配置项异常，配置失效");
            e2.printStackTrace();
        }
    }

    private java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        java.lang.String[] strArrSplit = str.split("&");
        int length = strArrSplit.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str3 = "";
                break;
            }
            str3 = strArrSplit[i];
            if (str3.contains(str2)) {
                break;
            }
            i++;
        }
        return !android.text.TextUtils.isEmpty(str3) ? str3.substring(str3.lastIndexOf("=") + 1) : str3;
    }

    private void a(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.h1.a aVar) {
        if (jSONObject.has(str)) {
            java.lang.String strOptString = jSONObject.optString(str, str2);
            if (!"CLOSE_FRIEND_WAPKS".equals(str)) {
                if (!"0".equals(strOptString) && !"1".equals(strOptString)) {
                    return;
                }
            } else {
                if (android.text.TextUtils.isEmpty(strOptString)) {
                    return;
                }
                if (!strOptString.contains("CU") && !strOptString.contains(com.igexin.assist.sdk.AssistPushConsts.MSG_KEY_CONTENT) && !strOptString.contains("CM")) {
                    return;
                }
            }
            aVar.a(str, jSONObject.optString(str, str2));
            return;
        }
        aVar.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.cmic.gen.sdk.s1 a() {
        return new com.cmic.gen.sdk.s1.b().c(com.cmic.gen.sdk.v1.b(this.b.d())).a(com.cmic.gen.sdk.v1.a(this.b.b())).b(com.cmic.gen.sdk.v1.b(this.b.c())).d(com.cmic.gen.sdk.v1.c(this.b.e())).c(com.cmic.gen.sdk.v1.c(this.b.k())).d(com.cmic.gen.sdk.v1.d(this.b.l())).a(com.cmic.gen.sdk.v1.a(this.b.i())).b(com.cmic.gen.sdk.v1.b(this.b.j())).f(com.cmic.gen.sdk.v1.f(this.b.n())).e(com.cmic.gen.sdk.v1.e(this.b.m())).b(com.cmic.gen.sdk.v1.b(this.b.g())).a(com.cmic.gen.sdk.v1.a(this.b.f())).a();
    }

    void a(com.cmic.gen.sdk.i iVar) {
        if (com.cmic.gen.sdk.v1.a()) {
            com.cmic.gen.sdk.k1.a(new com.cmic.gen.sdk.t1.b(iVar));
        }
    }
}
