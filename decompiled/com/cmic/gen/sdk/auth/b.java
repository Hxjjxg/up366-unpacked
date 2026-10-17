package com.cmic.gen.sdk.auth;

/* JADX INFO: compiled from: AuthnHelperCore.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class b {
    public static final java.lang.String SDK_VERSION = "quick_login_android_5.9.17";
    private static com.cmic.gen.sdk.auth.b h;
    protected final com.cmic.gen.sdk.auth.a a;
    protected final android.content.Context b;
    protected long c;
    protected final android.os.Handler d;
    protected java.lang.String e;
    private final java.lang.Object f;
    private boolean g;

    /* JADX INFO: compiled from: AuthnHelperCore.java */
    class a extends com.cmic.gen.sdk.k1.a {
        a() {
        }

        @Override // com.cmic.gen.sdk.k1.a
        protected void a() {
            java.lang.String strA = com.cmic.gen.sdk.h1.a("AID", "");
            com.cmic.gen.sdk.h0.a("AuthnHelperCore", "aid = " + strA);
            if (android.text.TextUtils.isEmpty(strA)) {
                com.cmic.gen.sdk.auth.b.this.a();
            }
            if (com.cmic.gen.sdk.auth.b.this.b()) {
                java.lang.String strA2 = new com.cmic.gen.sdk.n0(com.cmic.gen.sdk.auth.b.this.b).a();
                com.cmic.gen.sdk.h0.a("AuthnHelperCore", "oaid = " + strA2);
                if (!android.text.TextUtils.isEmpty(strA2)) {
                    com.cmic.gen.sdk.h1.b("oaid", strA2);
                }
            } else {
                com.cmic.gen.sdk.h0.a("AuthnHelperCore", "非主进程");
            }
            if (com.cmic.gen.sdk.c0.a(com.cmic.gen.sdk.auth.b.this.b, true)) {
                com.cmic.gen.sdk.h0.a("AuthnHelperCore", "生成androidkeystore成功");
            } else {
                com.cmic.gen.sdk.h0.a("AuthnHelperCore", "生成androidkeystore失败");
            }
        }
    }

    /* JADX INFO: renamed from: com.cmic.gen.sdk.auth.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AuthnHelperCore.java */
    class C0005b extends com.cmic.gen.sdk.k1.a {
        final /* synthetic */ com.cmic.gen.sdk.i b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ com.cmic.gen.sdk.auth.GenTokenListener e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0005b(android.content.Context context, com.cmic.gen.sdk.i iVar, com.cmic.gen.sdk.i iVar2, java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.auth.GenTokenListener genTokenListener) {
            super(context, iVar);
            this.b = iVar2;
            this.c = str;
            this.d = str2;
            this.e = genTokenListener;
        }

        @Override // com.cmic.gen.sdk.k1.a
        protected void a() {
            if (com.cmic.gen.sdk.auth.b.this.a(this.b, this.c, this.d, "loginAuth", 1, this.e)) {
                com.cmic.gen.sdk.auth.b.this.a(this.b);
            }
        }
    }

    /* JADX INFO: compiled from: AuthnHelperCore.java */
    class c extends com.cmic.gen.sdk.k1.a {
        final /* synthetic */ com.cmic.gen.sdk.i b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ com.cmic.gen.sdk.auth.GenTokenListener e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(android.content.Context context, com.cmic.gen.sdk.i iVar, com.cmic.gen.sdk.i iVar2, java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.auth.GenTokenListener genTokenListener) {
            super(context, iVar);
            this.b = iVar2;
            this.c = str;
            this.d = str2;
            this.e = genTokenListener;
        }

        @Override // com.cmic.gen.sdk.k1.a
        protected void a() {
            if (com.cmic.gen.sdk.auth.b.this.a(this.b, this.c, this.d, "mobileAuth", 0, this.e)) {
                com.cmic.gen.sdk.auth.b.this.a(this.b);
            }
        }
    }

    /* JADX INFO: compiled from: AuthnHelperCore.java */
    class d extends com.cmic.gen.sdk.k1.a {
        final /* synthetic */ com.cmic.gen.sdk.i b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ com.cmic.gen.sdk.auth.GenTokenListener e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(android.content.Context context, com.cmic.gen.sdk.i iVar, com.cmic.gen.sdk.i iVar2, java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.auth.GenTokenListener genTokenListener) {
            super(context, iVar);
            this.b = iVar2;
            this.c = str;
            this.d = str2;
            this.e = genTokenListener;
        }

        @Override // com.cmic.gen.sdk.k1.a
        protected void a() {
            if (com.cmic.gen.sdk.auth.b.this.a(this.b, this.c, this.d, "preGetMobile", 3, this.e)) {
                com.cmic.gen.sdk.auth.b.this.a(this.b);
            }
        }
    }

    /* JADX INFO: compiled from: AuthnHelperCore.java */
    class e extends com.cmic.gen.sdk.k1.a {
        final /* synthetic */ com.cmic.gen.sdk.o1 b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ com.cmic.gen.sdk.auth.d d;

        e(com.cmic.gen.sdk.o1 o1Var, java.lang.String str, com.cmic.gen.sdk.auth.d dVar) {
            this.b = o1Var;
            this.c = str;
            this.d = dVar;
        }

        @Override // com.cmic.gen.sdk.k1.a
        protected void a() {
            this.b.a((int) com.cmic.gen.sdk.auth.b.this.c, this.c, this.d);
        }
    }

    /* JADX INFO: compiled from: AuthnHelperCore.java */
    class f implements com.cmic.gen.sdk.d {
        final /* synthetic */ com.cmic.gen.sdk.auth.b.i a;

        f(com.cmic.gen.sdk.auth.b.i iVar) {
            this.a = iVar;
        }

        @Override // com.cmic.gen.sdk.d
        public void a(java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.i iVar, org.json.JSONObject jSONObject) {
            com.cmic.gen.sdk.auth.b.this.d.removeCallbacks(this.a);
            com.cmic.gen.sdk.auth.b.this.callBackResult(str, str2, iVar, jSONObject);
        }
    }

    /* JADX INFO: compiled from: AuthnHelperCore.java */
    class g implements java.lang.Runnable {
        final /* synthetic */ com.cmic.gen.sdk.auth.GenTokenListener a;
        final /* synthetic */ int b;
        final /* synthetic */ org.json.JSONObject c;

        g(com.cmic.gen.sdk.auth.GenTokenListener genTokenListener, int i, org.json.JSONObject jSONObject) {
            this.a = genTokenListener;
            this.b = i;
            this.c = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onGetTokenComplete(this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: AuthnHelperCore.java */
    class h extends com.cmic.gen.sdk.k1.a {
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ android.content.Context c;
        final /* synthetic */ com.cmic.gen.sdk.i d;

        h(java.lang.String str, android.content.Context context, com.cmic.gen.sdk.i iVar) {
            this.b = str;
            this.c = context;
            this.d = iVar;
        }

        @Override // com.cmic.gen.sdk.k1.a
        protected void a() {
            if ("200023".equals(this.b)) {
                android.os.SystemClock.sleep(8000L);
            }
            new com.cmic.gen.sdk.f1().a(this.c, this.b, this.d);
        }
    }

    /* JADX INFO: compiled from: AuthnHelperCore.java */
    protected class i implements java.lang.Runnable {
        private final com.cmic.gen.sdk.i a;

        i(com.cmic.gen.sdk.i iVar) {
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            org.json.JSONObject jSONObjectB = com.cmic.gen.sdk.auth.c.b("200023", "登录超时");
            com.cmic.gen.sdk.auth.b.this.callBackResult(jSONObjectB.optString("resultCode", "200023"), jSONObjectB.optString("desc", "登录超时"), this.a, jSONObjectB);
        }
    }

    b(android.content.Context context) {
        this.c = 8000L;
        this.f = new java.lang.Object();
        this.g = false;
        com.cmic.gen.sdk.h0.a("AuthnHelperCore", "AuthnHelperCore init");
        android.content.Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.d = new android.os.Handler(applicationContext.getMainLooper());
        this.a = com.cmic.gen.sdk.auth.a.a(applicationContext);
        com.cmic.gen.sdk.a2.a(applicationContext);
        com.cmic.gen.sdk.h1.a(applicationContext);
        com.cmic.gen.sdk.c1.a(applicationContext);
        com.cmic.gen.sdk.k1.a(new com.cmic.gen.sdk.auth.b.a());
    }

    public static com.cmic.gen.sdk.auth.b getInstance(android.content.Context context) {
        if (h == null) {
            synchronized (com.cmic.gen.sdk.auth.b.class) {
                if (h == null) {
                    h = new com.cmic.gen.sdk.auth.b(context);
                }
            }
        }
        return h;
    }

    public static void setDebugMode(boolean z) {
        com.cmic.gen.sdk.h0.a(z);
    }

    public void callBackResult(java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.i iVar, org.json.JSONObject jSONObject) {
        try {
            java.lang.String strC = iVar.c("traceId");
            int iA = iVar.a("SDKRequestCode", -1);
            if (com.cmic.gen.sdk.r0.d(strC)) {
                return;
            }
            synchronized (this) {
                com.cmic.gen.sdk.auth.GenTokenListener genTokenListenerB = com.cmic.gen.sdk.r0.b(strC);
                if (jSONObject == null || !jSONObject.optBoolean("keepListener", false)) {
                    com.cmic.gen.sdk.r0.c(strC);
                }
                if (genTokenListenerB == null) {
                    return;
                }
                iVar.b("systemEndTime", android.os.SystemClock.elapsedRealtime());
                iVar.b("endtime", com.cmic.gen.sdk.l1.a());
                int iB = iVar.b("logintype");
                if (jSONObject == null) {
                    jSONObject = com.cmic.gen.sdk.auth.c.b(str, str2);
                }
                org.json.JSONObject jSONObjectA = iB == 3 ? com.cmic.gen.sdk.auth.c.a(str, iVar, jSONObject) : com.cmic.gen.sdk.auth.c.a(str, str2, iVar, jSONObject);
                jSONObjectA.put("traceId", strC);
                jSONObjectA.put("scripExpiresIn", java.lang.String.valueOf(com.cmic.gen.sdk.u0.c()));
                this.d.post(new com.cmic.gen.sdk.auth.b.g(genTokenListenerB, iA, jSONObjectA));
                com.cmic.gen.sdk.u1.a(this.b).a(iVar);
                if (iVar.b().m() || com.cmic.gen.sdk.x1.a(iVar.b())) {
                    return;
                }
                a(this.b, str, iVar);
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public void delScrip() {
        try {
            com.cmic.gen.sdk.u0.a(true, true);
            com.cmic.gen.sdk.h0.a("AuthnHelperCore", "删除scrip");
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public void enableApkContentSigners(boolean z) {
        this.g = z;
    }

    public org.json.JSONObject getNetworkType(android.content.Context context) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            try {
                boolean zA = com.cmic.gen.sdk.j1.a(this.b);
                com.cmic.gen.sdk.q1.a().a(context, zA);
                java.lang.String strA = com.cmic.gen.sdk.c1.b().a(null, zA);
                int iA = com.cmic.gen.sdk.j1.a(context, zA, new com.cmic.gen.sdk.i(1));
                jSONObject.put("operatortype", strA);
                jSONObject.put("networktype", iA + "");
                java.lang.StringBuilder sb = new java.lang.StringBuilder("网络类型: ");
                sb.append(iA);
                com.cmic.gen.sdk.h0.a("AuthnHelperCore", sb.toString());
                com.cmic.gen.sdk.h0.a("AuthnHelperCore", "运营商类型: " + strA);
                return jSONObject;
            } catch (java.lang.Exception unused) {
                jSONObject.put("errorDes", "发生未知错误");
                return jSONObject;
            }
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    public void getPhoneInfo(java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.auth.GenTokenListener genTokenListener) {
        com.cmic.gen.sdk.i iVarA = a(genTokenListener);
        com.cmic.gen.sdk.k1.a(new com.cmic.gen.sdk.auth.b.d(this.b, iVarA, iVarA, str, str2, genTokenListener));
    }

    public void loginAuth(java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.auth.GenTokenListener genTokenListener) {
        com.cmic.gen.sdk.i iVarA = a(genTokenListener);
        com.cmic.gen.sdk.k1.a(new com.cmic.gen.sdk.auth.b.C0005b(this.b, iVarA, iVarA, str, str2, genTokenListener));
    }

    public void mobileAuth(java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.auth.GenTokenListener genTokenListener) {
        com.cmic.gen.sdk.i iVarA = a(genTokenListener);
        com.cmic.gen.sdk.k1.a(new com.cmic.gen.sdk.auth.b.c(this.b, iVarA, iVarA, str, str2, genTokenListener));
    }

    public void setOverTime(long j) {
        this.c = j;
    }

    @android.webkit.JavascriptInterface
    public void transmitRequestUniversal(java.lang.String str) {
        com.cmic.gen.sdk.i iVarA = a((com.cmic.gen.sdk.auth.GenTokenListener) null);
        com.cmic.gen.sdk.o1 o1Var = new com.cmic.gen.sdk.o1(this.b, iVarA);
        com.cmic.gen.sdk.auth.d dVar = new com.cmic.gen.sdk.auth.d(this.b, (int) this.c, iVarA);
        dVar.b();
        com.cmic.gen.sdk.k1.a(new com.cmic.gen.sdk.auth.b.e(o1Var, str, dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        java.lang.String str = "%" + com.cmic.gen.sdk.x1.a();
        com.cmic.gen.sdk.h0.a("AuthnHelperCore", "generate aid = " + str);
        com.cmic.gen.sdk.h1.b("AID", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        int iMyPid = android.os.Process.myPid();
        com.cmic.gen.sdk.h0.a("AuthnHelperCore", "进程pid = " + iMyPid);
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((android.app.ActivityManager) this.b.getSystemService("activity")).getRunningAppProcesses();
        com.up366.asmlibrary.Utils.writeLog("com/cmic/gen/sdk/auth/b  ->  b  ->  ()Z\r\nandroid/app/ActivityManager  ->  getRunningAppProcesses  ->  ()Ljava/util/List;\r\n", new java.lang.Throwable());
        if (runningAppProcesses == null) {
            return false;
        }
        for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return this.b.getPackageName().equals(runningAppProcessInfo.processName);
            }
        }
        return false;
    }

    protected com.cmic.gen.sdk.i a(com.cmic.gen.sdk.auth.GenTokenListener genTokenListener) {
        com.cmic.gen.sdk.i iVar = new com.cmic.gen.sdk.i(64);
        java.lang.String strC = com.cmic.gen.sdk.x1.c();
        iVar.a(new com.cmic.gen.sdk.e0());
        iVar.b("traceId", strC);
        com.cmic.gen.sdk.h0.b("traceId", strC);
        if (genTokenListener != null) {
            com.cmic.gen.sdk.r0.a(strC, genTokenListener);
        }
        return iVar;
    }

    public static com.cmic.gen.sdk.auth.b getInstance(android.content.Context context, java.lang.String str) {
        if (h == null) {
            synchronized (com.cmic.gen.sdk.auth.b.class) {
                if (h == null) {
                    h = new com.cmic.gen.sdk.auth.b(context, str);
                }
            }
        }
        return h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.cmic.gen.sdk.i iVar) {
        com.cmic.gen.sdk.auth.b.i iVar2 = new com.cmic.gen.sdk.auth.b.i(iVar);
        this.d.postDelayed(iVar2, this.c);
        iVar.b("methodChain", iVar.c("methodChain") + ",100003");
        iVar.b("methodCostTime", iVar.c("methodCostTime") + com.igexin.push.core.b.an + (java.lang.System.currentTimeMillis() - iVar.a("methodCostTimePre", 0L)));
        iVar.b("methodCostTimePre", java.lang.System.currentTimeMillis());
        this.a.a(iVar, new com.cmic.gen.sdk.auth.b.f(iVar2));
    }

    protected boolean a(com.cmic.gen.sdk.i iVar, java.lang.String str, java.lang.String str2, java.lang.String str3, int i2, com.cmic.gen.sdk.auth.GenTokenListener genTokenListener) {
        boolean zA;
        com.cmic.gen.sdk.s1 s1VarB = com.cmic.gen.sdk.u1.a(this.b).b();
        iVar.b("methodChain", iVar.c("methodChain") + ",100002");
        iVar.b("methodCostTime", java.lang.String.valueOf(java.lang.System.currentTimeMillis() - iVar.a("methodCostTimePre", 0L)));
        iVar.b("methodCostTimePre", java.lang.System.currentTimeMillis());
        iVar.a(s1VarB);
        iVar.b("enable_apk_contents_signers", this.g);
        iVar.b("use2048PublicKey", "rsa2048".equals(this.e));
        iVar.b("systemStartTime", android.os.SystemClock.elapsedRealtime());
        iVar.b("starttime", com.cmic.gen.sdk.l1.a());
        iVar.b("loginMethod", str3);
        iVar.b("appkey", str2);
        iVar.b("appid", str);
        iVar.b("timeOut", java.lang.String.valueOf(this.c));
        boolean zA2 = com.cmic.gen.sdk.j1.a(this.b);
        com.cmic.gen.sdk.q1.a().a(this.b, zA2);
        java.lang.String strA = com.cmic.gen.sdk.c1.b().a();
        java.lang.String strA2 = com.cmic.gen.sdk.c1.b().a(zA2);
        java.lang.String strA3 = com.cmic.gen.sdk.c1.b().a(strA2, zA2);
        iVar.b("operator", strA2);
        iVar.b("operatortype", strA3);
        iVar.b("logintype", i2);
        com.cmic.gen.sdk.h0.a("AuthnHelperCore", "subId = " + strA);
        if (!android.text.TextUtils.isEmpty(strA)) {
            com.cmic.gen.sdk.h0.b("AuthnHelperCore", "使用subId作为缓存key = " + strA);
            iVar.b("scripType", "subid");
            iVar.b("scripKey", strA);
        } else if (!android.text.TextUtils.isEmpty(strA2)) {
            com.cmic.gen.sdk.h0.b("AuthnHelperCore", "使用operator作为缓存key = " + strA2);
            iVar.b("scripType", "operator");
            iVar.b("scripKey", strA2);
        }
        int iA = com.cmic.gen.sdk.j1.a(this.b, zA2, iVar);
        iVar.b("networktype", iA);
        if (!zA2) {
            iVar.b("authType", java.lang.String.valueOf(0));
            callBackResult("200010", "无法识别sim卡或没有sim卡", iVar, null);
            return false;
        }
        if (genTokenListener == null) {
            callBackResult("102203", "listener不能为空", iVar, null);
            return false;
        }
        if (s1VarB.n()) {
            callBackResult("200082", "服务器繁忙，请稍后重试", iVar, null);
            return false;
        }
        if (android.text.TextUtils.isEmpty(str == null ? "" : str.trim())) {
            callBackResult("102203", "appId 不能为空", iVar, null);
            return false;
        }
        if (android.text.TextUtils.isEmpty(str2 == null ? "" : str2.trim())) {
            callBackResult("102203", "appkey不能为空", iVar, null);
            return false;
        }
        if (iA == 0) {
            callBackResult("102101", "未检测到网络", iVar, null);
            return false;
        }
        if ("2".equals(strA3) && s1VarB.j()) {
            callBackResult("200082", "服务器繁忙，请稍后重试", iVar, null);
            return false;
        }
        if ("3".equals(strA3) && s1VarB.i()) {
            callBackResult("200082", "服务器繁忙，请稍后重试", iVar, null);
            return false;
        }
        synchronized (this.f) {
            zA = com.cmic.gen.sdk.u0.a(iVar);
            if (zA) {
                iVar.b("securityphone", com.cmic.gen.sdk.u0.a(this.b));
                if (3 != i2) {
                    java.lang.String strB = com.cmic.gen.sdk.u0.b(this.b);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("解密phoneScript ");
                    sb.append(!android.text.TextUtils.isEmpty(strB));
                    com.cmic.gen.sdk.h0.a("AuthnHelperCore", sb.toString());
                    if (android.text.TextUtils.isEmpty(strB)) {
                        zA = false;
                    } else {
                        iVar.b("phonescrip", strB);
                    }
                    com.cmic.gen.sdk.u0.a(true, false);
                }
            }
            iVar.b("isCacheScrip", zA);
            com.cmic.gen.sdk.h0.a("AuthnHelperCore", "isCachePhoneScrip = " + zA);
        }
        if (iA != 2 || zA) {
            return true;
        }
        callBackResult("102103", "无数据网络", iVar, null);
        return false;
    }

    private b(android.content.Context context, java.lang.String str) {
        this(context);
        this.e = str;
    }

    private void a(android.content.Context context, java.lang.String str, com.cmic.gen.sdk.i iVar) {
        com.cmic.gen.sdk.k1.a(new com.cmic.gen.sdk.auth.b.h(str, context, iVar));
    }
}
