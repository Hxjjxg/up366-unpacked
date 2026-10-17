package com.cmic.gen.sdk.auth;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class GenAuthnHelper extends com.cmic.gen.sdk.auth.b {
    private static com.cmic.gen.sdk.auth.GenAuthnHelper l;
    protected static org.json.JSONObject m;
    private com.cmic.gen.sdk.view.GenAuthThemeConfig i;
    private com.cmic.gen.sdk.view.GenLoginPageInListener j;
    protected android.view.View k;

    class a extends com.cmic.gen.sdk.k1.a {
        final /* synthetic */ com.cmic.gen.sdk.i b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ com.cmic.gen.sdk.auth.GenTokenListener e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(android.content.Context context, com.cmic.gen.sdk.i iVar, com.cmic.gen.sdk.i iVar2, java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.auth.GenTokenListener genTokenListener) {
            super(context, iVar);
            this.b = iVar2;
            this.c = str;
            this.d = str2;
            this.e = genTokenListener;
        }

        @Override // com.cmic.gen.sdk.k1.a
        protected void a() {
            if (com.cmic.gen.sdk.auth.GenAuthnHelper.this.a(this.b, this.c, this.d, "preGetMobile", 3, this.e)) {
                com.cmic.gen.sdk.auth.GenAuthnHelper.super.a(this.b);
            }
        }
    }

    class b extends com.cmic.gen.sdk.k1.a {
        final /* synthetic */ com.cmic.gen.sdk.i b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ com.cmic.gen.sdk.auth.GenTokenListener e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(android.content.Context context, com.cmic.gen.sdk.i iVar, com.cmic.gen.sdk.i iVar2, java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.auth.GenTokenListener genTokenListener) {
            super(context, iVar);
            this.b = iVar2;
            this.c = str;
            this.d = str2;
            this.e = genTokenListener;
        }

        @Override // com.cmic.gen.sdk.k1.a
        protected void a() {
            if (com.cmic.gen.sdk.auth.GenAuthnHelper.this.a(this.b, this.c, this.d, "loginAuth", 3, this.e)) {
                java.lang.String strB = com.cmic.gen.sdk.u0.b(com.cmic.gen.sdk.auth.GenAuthnHelper.this.b);
                if (!android.text.TextUtils.isEmpty(strB)) {
                    this.b.b("phonescrip", strB);
                }
                com.cmic.gen.sdk.auth.GenAuthnHelper.this.a(this.b);
            }
        }
    }

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
            if (com.cmic.gen.sdk.auth.GenAuthnHelper.this.a(this.b, this.c, this.d, "mobileAuth", 0, this.e)) {
                com.cmic.gen.sdk.auth.GenAuthnHelper.super.a(this.b);
            }
        }
    }

    class d implements com.cmic.gen.sdk.d {
        final /* synthetic */ com.cmic.gen.sdk.auth.b.i a;

        d(com.cmic.gen.sdk.auth.b.i iVar) {
            this.a = iVar;
        }

        @Override // com.cmic.gen.sdk.d
        public void a(java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.i iVar, org.json.JSONObject jSONObject) {
            com.cmic.gen.sdk.h0.a("onBusinessComplete", "onBusinessComplete");
            com.cmic.gen.sdk.auth.GenAuthnHelper.this.d.removeCallbacks(this.a);
            if (!"103000".equals(str) || com.cmic.gen.sdk.r0.d(iVar.c("traceId"))) {
                com.cmic.gen.sdk.auth.GenAuthnHelper.this.callBackResult(str, str2, iVar, jSONObject);
            } else {
                com.cmic.gen.sdk.auth.GenAuthnHelper.b(com.cmic.gen.sdk.auth.GenAuthnHelper.this.b, iVar);
            }
        }
    }

    private GenAuthnHelper(android.content.Context context) {
        super(context);
        this.j = null;
        this.k = null;
    }

    public static com.cmic.gen.sdk.auth.GenAuthnHelper getInstance(android.content.Context context) {
        if (l == null) {
            synchronized (com.cmic.gen.sdk.auth.GenAuthnHelper.class) {
                if (l == null) {
                    l = new com.cmic.gen.sdk.auth.GenAuthnHelper(context);
                }
            }
        }
        return l;
    }

    public void addJavascriptInterface(android.view.View view, org.json.JSONObject jSONObject) {
        if (view != null) {
            this.k = view;
            m = jSONObject;
        }
        com.cmic.gen.sdk.g.a().a(view, this, "AndroidView");
    }

    public void deleteAuthThemeConfig() {
        this.i = null;
    }

    public com.cmic.gen.sdk.view.GenAuthThemeConfig getAuthThemeConfig() {
        if (this.i == null) {
            this.i = new com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder().build();
        }
        return this.i;
    }

    public long getOverTime() {
        return this.c;
    }

    @Override // com.cmic.gen.sdk.auth.b
    public void getPhoneInfo(java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.auth.GenTokenListener genTokenListener) {
        getPhoneInfo(str, str2, genTokenListener, -1);
    }

    @Override // com.cmic.gen.sdk.auth.b
    public void loginAuth(java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.auth.GenTokenListener genTokenListener) {
        loginAuth(str, str2, genTokenListener, -1);
    }

    public void loginPageInCallBack(java.lang.String str) {
        com.cmic.gen.sdk.view.GenLoginPageInListener genLoginPageInListener = this.j;
        if (genLoginPageInListener != null) {
            genLoginPageInListener.onLoginPageInComplete(str);
        }
    }

    @Override // com.cmic.gen.sdk.auth.b
    public void mobileAuth(java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.auth.GenTokenListener genTokenListener) {
        mobileAuth(str, str2, genTokenListener, -1);
    }

    public void quitAuthActivity() {
        try {
            if (com.cmic.gen.sdk.view.a.a().b() != null) {
                com.cmic.gen.sdk.view.a.a().b = 0;
                com.cmic.gen.sdk.view.a.a().b().a();
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.cmic.gen.sdk.h0.b("AuthnHelper", "关闭授权页失败");
        }
    }

    public void removeJavascriptInterface() {
        if (this.k != null) {
            com.cmic.gen.sdk.g.a().a(this.k, "AndroidView");
            this.k = null;
            m = null;
        }
    }

    public void setAuthThemeConfig(com.cmic.gen.sdk.view.GenAuthThemeConfig genAuthThemeConfig) {
        this.i = genAuthThemeConfig;
    }

    public void setPageInListener(com.cmic.gen.sdk.view.GenLoginPageInListener genLoginPageInListener) {
        this.j = genLoginPageInListener;
    }

    private void b(com.cmic.gen.sdk.i iVar) {
        try {
            java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            int iMin = java.lang.Math.min(stackTrace.length, 5);
            for (int i = 0; i < iMin; i++) {
                stringBuffer.append(stackTrace[i].toString()).append("\n");
            }
            iVar.b("pathOfCallingMethod", stringBuffer.toString());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void getPhoneInfo(java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.auth.GenTokenListener genTokenListener, int i) {
        com.cmic.gen.sdk.i iVarA = a(genTokenListener);
        iVarA.b("SDKRequestCode", i);
        iVarA.b("methodChain", "100001");
        iVarA.b("methodCostTimePre", java.lang.System.currentTimeMillis());
        b(iVarA);
        com.cmic.gen.sdk.k1.a(new com.cmic.gen.sdk.auth.GenAuthnHelper.a(this.b, iVarA, iVarA, str, str2, genTokenListener));
    }

    public void loginAuth(java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.auth.GenTokenListener genTokenListener, int i) {
        com.cmic.gen.sdk.i iVarA = a(genTokenListener);
        iVarA.b("SDKRequestCode", i);
        iVarA.b("methodChain", "100001");
        iVarA.b("methodCostTimePre", java.lang.System.currentTimeMillis());
        iVarA.b("displayLogo", this.i.isDisplayLogo() ? "1" : "0");
        b(iVarA);
        com.cmic.gen.sdk.k1.a(new com.cmic.gen.sdk.auth.GenAuthnHelper.b(this.b, iVarA, iVarA, str, str2, genTokenListener));
    }

    public void mobileAuth(java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.auth.GenTokenListener genTokenListener, int i) {
        com.cmic.gen.sdk.i iVarA = a(genTokenListener);
        iVarA.b("SDKRequestCode", i);
        iVarA.b("methodChain", "100001");
        iVarA.b("methodCostTimePre", java.lang.System.currentTimeMillis());
        b(iVarA);
        com.cmic.gen.sdk.k1.a(new com.cmic.gen.sdk.auth.GenAuthnHelper.c(this.b, iVarA, iVarA, str, str2, genTokenListener));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cmic.gen.sdk.auth.b
    public void a(com.cmic.gen.sdk.i iVar) {
        com.cmic.gen.sdk.auth.b.i iVar2 = new com.cmic.gen.sdk.auth.b.i(iVar);
        this.d.postDelayed(iVar2, this.c);
        iVar.b("methodChain", iVar.c("methodChain") + ",100003");
        iVar.b("methodCostTime", iVar.c("methodCostTime") + com.igexin.push.core.b.an + (java.lang.System.currentTimeMillis() - iVar.a("methodCostTimePre", 0L)));
        iVar.b("methodCostTimePre", java.lang.System.currentTimeMillis());
        this.a.a(iVar, new com.cmic.gen.sdk.auth.GenAuthnHelper.d(iVar2));
    }

    private GenAuthnHelper(android.content.Context context, java.lang.String str) {
        super(context);
        this.j = null;
        this.k = null;
        this.e = str;
    }

    public static com.cmic.gen.sdk.auth.GenAuthnHelper getInstance(android.content.Context context, java.lang.String str) {
        if (l == null) {
            synchronized (com.cmic.gen.sdk.auth.GenAuthnHelper.class) {
                if (l == null) {
                    l = new com.cmic.gen.sdk.auth.GenAuthnHelper(context, str);
                }
            }
        }
        return l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(android.content.Context context, com.cmic.gen.sdk.i iVar) {
        java.lang.String strC = iVar.c("traceId");
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("traceId", strC);
        com.cmic.gen.sdk.r0.a(iVar.c("traceId"), iVar);
        intent.setClassName(context, "com.cmic.gen.sdk.view.GenLoginAuthActivity");
        intent.setFlags(268435456);
        context.startActivity(intent);
    }
}
