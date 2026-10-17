package com.cmic.gen.sdk.auth;

/* JADX INFO: compiled from: AuthnBusiness.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class a {
    private static com.cmic.gen.sdk.auth.a c;
    private final com.cmic.gen.sdk.e a = com.cmic.gen.sdk.e.a();
    private final android.content.Context b;

    /* JADX INFO: renamed from: com.cmic.gen.sdk.auth.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AuthnBusiness.java */
    class C0003a extends com.cmic.gen.sdk.k1.a {
        final /* synthetic */ com.cmic.gen.sdk.i b;

        /* JADX INFO: renamed from: com.cmic.gen.sdk.auth.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AuthnBusiness.java */
        class C0004a implements com.cmic.gen.sdk.x0 {
            C0004a() {
            }

            @Override // com.cmic.gen.sdk.x0
            public void a(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
                if ("103000".equals(str)) {
                    com.cmic.gen.sdk.h0.b("AuthnBusiness", "jsonobj=" + jSONObject.toString());
                    try {
                        java.lang.String strOptString = jSONObject.optString("authPrivacyLink", "");
                        com.cmic.gen.sdk.h0.b("AuthnBusiness", "authPrivacyLinkStr=" + strOptString);
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject(strOptString.replace("\t", ""));
                        com.cmic.gen.sdk.h0.b("AuthnBusiness", "authPrivacyLink=" + jSONObject2.toString());
                        org.json.JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("1");
                        com.cmic.gen.sdk.h0.b("AuthnBusiness", "cmcc=" + jSONObjectOptJSONObject.toString());
                        org.json.JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("2");
                        org.json.JSONObject jSONObjectOptJSONObject3 = jSONObject2.optJSONObject("3");
                        org.json.JSONObject jSONObjectOptJSONObject4 = jSONObject2.optJSONObject("4");
                        com.cmic.gen.sdk.h1.b("operator1", jSONObjectOptJSONObject.toString());
                        com.cmic.gen.sdk.h1.b("operator2", jSONObjectOptJSONObject2.toString());
                        com.cmic.gen.sdk.h1.b("operator3", jSONObjectOptJSONObject3.toString());
                        com.cmic.gen.sdk.h1.b("operator4", jSONObjectOptJSONObject4.toString());
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0003a(android.content.Context context, com.cmic.gen.sdk.i iVar, com.cmic.gen.sdk.i iVar2) {
            super(context, iVar);
            this.b = iVar2;
        }

        @Override // com.cmic.gen.sdk.k1.a
        protected void a() {
            com.cmic.gen.sdk.auth.a.this.a.b(this.b, new com.cmic.gen.sdk.auth.a.C0003a.C0004a());
        }
    }

    /* JADX INFO: compiled from: AuthnBusiness.java */
    class b implements com.cmic.gen.sdk.x0 {
        final /* synthetic */ com.cmic.gen.sdk.i a;
        final /* synthetic */ com.cmic.gen.sdk.d b;

        b(com.cmic.gen.sdk.i iVar, com.cmic.gen.sdk.d dVar) {
            this.a = iVar;
            this.b = dVar;
        }

        @Override // com.cmic.gen.sdk.x0
        public void a(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
            com.cmic.gen.sdk.auth.a.this.a(this.a, this.b, str, str2, jSONObject);
        }
    }

    private a(android.content.Context context) {
        this.b = context.getApplicationContext();
    }

    private void c(com.cmic.gen.sdk.i iVar) {
        com.cmic.gen.sdk.k1.a(new com.cmic.gen.sdk.auth.a.C0003a(this.b, iVar, iVar));
    }

    public void b(com.cmic.gen.sdk.i iVar, com.cmic.gen.sdk.d dVar) {
        c(iVar);
        com.cmic.gen.sdk.h0.a("AuthnBusiness", "getScripAndToken start");
        iVar.b("methodChain", iVar.c("methodChain") + ",100005");
        iVar.b("methodCostTime", iVar.c("methodCostTime") + com.igexin.push.core.b.an + (java.lang.System.currentTimeMillis() - iVar.a("methodCostTimePre", 0L)));
        iVar.b("methodCostTimePre", java.lang.System.currentTimeMillis());
        boolean zA = iVar.a("isGotScrip", false);
        com.cmic.gen.sdk.h0.a("AuthnBusiness", "isGotScrip = " + zA);
        if (!zA) {
            b(iVar);
            if (!iVar.a("isCacheScrip", false)) {
                a(iVar);
                if (iVar.b("networktype") == 3 && !"loginAuth".equals(iVar.c("loginMethod")) && iVar.b("logintype") != 3) {
                    iVar.b("isRisk", true);
                }
            }
            if (iVar.b("logintype") == 1) {
                iVar.b("userCapaid", "200");
            } else if (iVar.b("logintype") == 0) {
                iVar.b("userCapaid", "50");
            }
        }
        this.a.a(iVar, new com.cmic.gen.sdk.auth.a.b(iVar, dVar));
    }

    public static com.cmic.gen.sdk.auth.a a(android.content.Context context) {
        if (c == null) {
            synchronized (com.cmic.gen.sdk.auth.a.class) {
                if (c == null) {
                    c = new com.cmic.gen.sdk.auth.a(context);
                }
            }
        }
        return c;
    }

    public void a(com.cmic.gen.sdk.i iVar, com.cmic.gen.sdk.d dVar) {
        com.cmic.gen.sdk.h0.a("AuthnBusiness", "LoginCheck method start");
        int iB = iVar.b("logintype");
        iVar.b("methodChain", iVar.c("methodChain") + ",100004");
        iVar.b("methodCostTime", iVar.c("methodCostTime") + com.igexin.push.core.b.an + (java.lang.System.currentTimeMillis() - iVar.a("methodCostTimePre", 0L)));
        iVar.b("methodCostTimePre", java.lang.System.currentTimeMillis());
        if (iVar.a("isCacheScrip", false)) {
            java.lang.String strA = iVar.a("securityphone", "");
            if (iB == 3) {
                dVar.a("103000", "true", iVar, com.cmic.gen.sdk.auth.c.a(strA));
                return;
            } else {
                b(iVar, dVar);
                return;
            }
        }
        b(iVar, dVar);
    }

    private void a(com.cmic.gen.sdk.i iVar) {
        byte[] bytes = new byte[0];
        if (iVar.a("use2048PublicKey", false)) {
            com.cmic.gen.sdk.h0.b("AuthnBusiness", "使用2048公钥对应的对称秘钥生成方式");
            bytes = com.cmic.gen.sdk.a.a();
        } else {
            com.cmic.gen.sdk.h0.b("AuthnBusiness", "使用1024公钥对应的对称秘钥生成方式");
            try {
                bytes = java.util.UUID.randomUUID().toString().substring(0, 16).getBytes(com.igexin.push.g.s.b);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        byte[] bArrA = com.cmic.gen.sdk.a.a();
        iVar.a(com.cmic.gen.sdk.k.a.a, bytes);
        iVar.a(com.cmic.gen.sdk.k.a.b, bArrA);
        iVar.b("authType", "3");
    }

    private void b(com.cmic.gen.sdk.i iVar) {
        byte[] bArrA;
        java.lang.String packageName = this.b.getPackageName();
        if (iVar.a("enable_apk_contents_signers", false)) {
            bArrA = com.cmic.gen.sdk.i1.a(this.b);
            com.cmic.gen.sdk.h0.a("getLocalAppInfo", "enable_apk_contents_signers=true");
        } else {
            bArrA = com.cmic.gen.sdk.i1.a(this.b, packageName);
        }
        java.lang.String strA = com.cmic.gen.sdk.j0.a(bArrA);
        com.cmic.gen.sdk.h0.a("getLocalAppInfo", "sign=" + strA);
        iVar.b("apppackage", packageName);
        iVar.b("appsign", strA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.cmic.gen.sdk.i r26, com.cmic.gen.sdk.d r27, java.lang.String r28, java.lang.String r29, org.json.JSONObject r30) {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.gen.sdk.auth.a.a(com.cmic.gen.sdk.i, com.cmic.gen.sdk.d, java.lang.String, java.lang.String, org.json.JSONObject):void");
    }
}
