package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class E {
    private static volatile com.chuanglan.shanyan_sdk.E m;
    private android.content.Context a;
    private com.chuanglan.shanyan_sdk.listener.LoginAuthCallbacks b;
    private long c;
    private long d;
    private long e;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private com.chuanglan.shanyan_sdk.E.d i;
    private java.util.concurrent.ExecutorService j;
    private java.util.concurrent.ExecutorService k;
    private java.lang.String l;

    class a implements java.lang.Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ long b;
        final /* synthetic */ int c;
        final /* synthetic */ long d;

        a(long j, long j2, int i, long j3) {
            this.a = j;
            this.b = j2;
            this.c = i;
            this.d = j3;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00cb A[Catch: all -> 0x0113, Exception -> 0x0115, TRY_LEAVE, TryCatch #1 {Exception -> 0x0115, blocks: (B:3:0x0006, B:17:0x0072, B:18:0x009f, B:19:0x00cb, B:23:0x00e7, B:8:0x0059, B:11:0x0063), top: B:33:0x0006, outer: #0 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instruction units count: 331
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chuanglan.shanyan_sdk.E.a.run():void");
        }
    }

    class b implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        b(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.chuanglan.shanyan_sdk.a0.b().c(this.a);
        }
    }

    class c implements com.cmic.gen.sdk.view.GenLoginClickListener {
        c() {
        }

        @Override // com.cmic.gen.sdk.view.GenLoginClickListener
        public void onLoginClickComplete(android.content.Context context, org.json.JSONObject jSONObject) {
        }

        @Override // com.cmic.gen.sdk.view.GenLoginClickListener
        public void onLoginClickStart(android.content.Context context, org.json.JSONObject jSONObject) {
        }
    }

    private class d implements com.cmic.gen.sdk.auth.GenTokenListener {
        private d() {
        }

        @Override // com.cmic.gen.sdk.auth.GenTokenListener
        public void onGetTokenComplete(int i, org.json.JSONObject jSONObject) {
            try {
                com.chuanglan.shanyan_sdk.Q.c("LogInfoShanYanLogger", "cm onGetTokenComplete", jSONObject, java.lang.Integer.valueOf(i));
                com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(com.chuanglan.shanyan_sdk.E.this.a).quitAuthActivity();
                if (jSONObject == null) {
                    com.chuanglan.shanyan_sdk.E.this.a(-1, (java.lang.String) null, "login response isEmpty");
                    return;
                }
                int iOptInt = jSONObject.optInt("resultCode");
                java.lang.String strOptString = jSONObject.optString("desc");
                java.lang.String strOptString2 = jSONObject.optString("traceId");
                if (jSONObject.has(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN) && iOptInt == 103000) {
                    java.lang.String strOptString3 = jSONObject.optString(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN);
                    if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(strOptString3)) {
                        com.chuanglan.shanyan_sdk.E.this.a(iOptInt, strOptString, "token is empty" + strOptString2);
                        return;
                    }
                    com.chuanglan.shanyan_sdk.AbstractC0055l.p = com.cmic.gen.sdk.u0.a(com.chuanglan.shanyan_sdk.E.this.a);
                    com.chuanglan.shanyan_sdk.p0.b(com.chuanglan.shanyan_sdk.E.this.a, "cl_jm_f8", com.chuanglan.shanyan_sdk.AbstractC0055l.p);
                    com.chuanglan.shanyan_sdk.p0.b(com.chuanglan.shanyan_sdk.E.this.a, "cl_jm_f7", com.chuanglan.shanyan_sdk.E.this.a(strOptString3));
                    java.lang.String str = com.chuanglan.shanyan_sdk.E.this.g;
                    com.chuanglan.shanyan_sdk.AbstractC0055l.m = str;
                    com.chuanglan.shanyan_sdk.E e = com.chuanglan.shanyan_sdk.E.this;
                    e.a(str, e.e, com.chuanglan.shanyan_sdk.E.this.d, com.chuanglan.shanyan_sdk.E.this.c);
                    return;
                }
                com.chuanglan.shanyan_sdk.E.this.a(iOptInt, strOptString, strOptString2);
            } catch (java.lang.Exception e2) {
                com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(com.chuanglan.shanyan_sdk.E.this.a).quitAuthActivity();
                com.chuanglan.shanyan_sdk.E.this.a(com.chuanglan.shanyan_sdk.C0065v.g().b(com.chuanglan.shanyan_sdk.E.this.a), com.chuanglan.shanyan_sdk.E.this.e, com.chuanglan.shanyan_sdk.E.this.d, com.chuanglan.shanyan_sdk.E.this.c, "onGetTokenComplete Exception" + e2);
            }
        }

        /* synthetic */ d(com.chuanglan.shanyan_sdk.E e, com.chuanglan.shanyan_sdk.E.a aVar) {
            this();
        }
    }

    private E() {
    }

    public static com.chuanglan.shanyan_sdk.E a() {
        if (m == null) {
            synchronized (com.chuanglan.shanyan_sdk.E.class) {
                if (m == null) {
                    m = new com.chuanglan.shanyan_sdk.E();
                }
            }
        }
        return m;
    }

    public void a(android.content.Context context, java.lang.String str, java.util.concurrent.ExecutorService executorService) {
        this.a = context;
        this.f = str;
        this.j = executorService;
    }

    public void a(int i, long j, long j2) {
        this.b = new com.chuanglan.shanyan_sdk.S(this.a);
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        a(this.a);
        com.chuanglan.shanyan_sdk.AbstractC0050g.e(this.a);
        android.content.Context context = this.a;
        if (context != null && this.j != null) {
            if (com.chuanglan.shanyan_sdk.AbstractC0055l.t == com.chuanglan.shanyan_sdk.AbstractC0055l.w.getAndSet(com.chuanglan.shanyan_sdk.AbstractC0055l.t)) {
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "startGetToken is in progress");
                return;
            } else {
                this.j.execute(new com.chuanglan.shanyan_sdk.E.a(j, j2, i, jUptimeMillis));
                return;
            }
        }
        com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "startGetToken context", context, this.j);
        com.chuanglan.shanyan_sdk.listener.LoginAuthCallbacks loginAuthCallbacks = this.b;
        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.NOT_INITIALIZED_CODE;
        loginAuthCallbacks.getTokenFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c() + ":startGetToken()", "Unknown_Operator", j, j2, jUptimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, java.lang.String str, long j, long j2, long j3, java.lang.String str2, com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q, java.lang.String str3) {
        int iA = com.chuanglan.shanyan_sdk.p0.a(this.a, str2, com.chuanglan.shanyan_sdk.AbstractC0061r.c);
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "channelSwitch", java.lang.Integer.valueOf(iA));
        if (iA != 1 && iA != 2) {
            this.b.getTokenFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c(), str, j, j2, j3);
            return;
        }
        if (!"cu".equals(str3) && !"ct".equals(str3)) {
            a(str, j, j2, j3, iA);
            return;
        }
        boolean zD = com.chuanglan.shanyan_sdk.t0.h().d(this.a);
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "startGetToken status", java.lang.Boolean.valueOf(zD));
        java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_f7", "");
        if (zD && !com.chuanglan.shanyan_sdk.AbstractC0049f.a(strA)) {
            a(com.chuanglan.shanyan_sdk.AbstractC0055l.m, j, j2, j3);
        } else {
            com.chuanglan.shanyan_sdk.k0.b().a(i, str, j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, long j, long j2, long j3, java.lang.String str2) {
        com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", str2);
        com.chuanglan.shanyan_sdk.listener.LoginAuthCallbacks loginAuthCallbacks = this.b;
        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.SDK_EXCEPTION_CODE;
        loginAuthCallbacks.getTokenFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c() + str2, str, j, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, java.lang.String str, java.lang.String str2) {
        com.chuanglan.shanyan_sdk.listener.LoginAuthCallbacks loginAuthCallbacks = this.b;
        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.REQUEST_TOKEN_ERROR_CODE;
        int iD = enumC0060q.d();
        if (i == -1) {
            i = enumC0060q.b();
        }
        if (str == null) {
            str = enumC0060q.e();
        }
        java.lang.String str3 = str;
        if (str2 == null) {
            str2 = enumC0060q.c();
        }
        loginAuthCallbacks.getTokenFailed(iD, i, str3, str2, this.g, this.e, this.d, this.c);
    }

    private void a(android.content.Context context) {
        java.util.concurrent.ExecutorService executorService = this.k;
        if (executorService == null || executorService.isShutdown()) {
            this.k = new java.util.concurrent.ThreadPoolExecutor(8, Integer.MAX_VALUE, 120L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingDeque());
        }
        this.k.execute(new com.chuanglan.shanyan_sdk.E.b(context));
    }

    public void a(java.lang.String str, long j, long j2, long j3, int i) {
        this.e = j;
        this.d = j2;
        this.c = j3;
        this.g = str;
        if (i == 1) {
            this.h = "1";
        } else {
            this.h = "5";
        }
        com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(this.a).setAuthThemeConfig(new com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder().setPrivacyState(true).setLogBtnClickListener(new com.chuanglan.shanyan_sdk.E.c()).build());
        com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(this.a).setOverTime((com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_e8", 6) + 1) * 1000);
        this.l = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_a9", "");
        java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_c7", "");
        if (this.i == null) {
            this.i = new com.chuanglan.shanyan_sdk.E.d(this, null);
        }
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "start  cm loginAuth", this.l);
        com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(this.a).loginAuth(this.l, strA, this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String a(java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3 = this.g;
        str3.hashCode();
        str3.hashCode();
        switch (str3) {
            case "CMHK":
                str2 = com.chuanglan.shanyan_sdk.n0.c;
                break;
            case "CTCC":
                str2 = "t,";
                break;
            case "CUCC":
                str2 = "u,";
                break;
            default:
                str2 = "m,";
                break;
        }
        return this.h + this.l + com.igexin.push.core.b.an + str2 + str;
    }

    public void a(java.lang.String str, long j, long j2, long j3) {
        java.lang.String str2;
        try {
            java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_f7", "");
            if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(strA)) {
                a(-1, (java.lang.String) null, "accessCode is empty");
                return;
            }
            java.lang.String strSubstring = strA.substring(0, 1);
            int iIndexOf = strA.indexOf(44);
            java.lang.String strSubstring2 = strA.substring(1, iIndexOf);
            java.lang.String strSubstring3 = strA.substring(iIndexOf + 1);
            java.lang.String strA2 = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_d9", "");
            java.lang.String strA3 = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_c3", "");
            java.lang.String strA4 = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_c2", "");
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("ap", strA3);
            jSONObject.put("tk", strSubstring3);
            jSONObject.put("au", strA2);
            java.lang.String strB = com.chuanglan.shanyan_sdk.AbstractC0050g.b(this.a);
            java.lang.String strA5 = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_f8", "");
            java.lang.String strB2 = com.chuanglan.shanyan_sdk.AbstractC0045b.b(this.f);
            java.lang.String strSubstring4 = strB2.substring(0, 16);
            java.lang.String strSubstring5 = strB2.substring(16);
            java.lang.String str3 = android.util.Base64.encodeToString(com.chuanglan.shanyan_sdk.AbstractC0045b.a(strA5.getBytes("UTF-8"), strSubstring4, strSubstring5), 11) + com.igexin.push.core.b.an + strB;
            java.lang.String strA6 = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_a3", "");
            com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_f5", str3);
            jSONObject.put("dd", strA6 + com.igexin.push.core.b.an + str3);
            jSONObject.put("ud", com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_a2", ""));
            jSONObject.put("vs", "2.3.7.7");
            jSONObject.put("tp", "0");
            jSONObject.put("nlt", "1");
            jSONObject.put("ad", strSubstring2);
            java.lang.String strEncodeToString = android.util.Base64.encodeToString(com.chuanglan.shanyan_sdk.AbstractC0045b.a(jSONObject.toString().getBytes("UTF-8"), strSubstring4, strSubstring5), 11);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strA4) && "1".equals(strA4)) {
                str2 = "A" + strSubstring + strA3 + "-" + strEncodeToString;
            } else {
                str2 = "A" + strSubstring + "-" + strEncodeToString;
            }
            jSONObject2.put(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, str2);
            java.lang.String string = jSONObject2.toString();
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "token id", strA3, java.lang.Integer.valueOf(iIndexOf), str, strSubstring2);
            com.chuanglan.shanyan_sdk.Q.c("LogInfoShanYanLogger", "pre token", strSubstring4, strSubstring5, jSONObject);
            com.chuanglan.shanyan_sdk.listener.LoginAuthCallbacks loginAuthCallbacks = this.b;
            com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.LOGIN_SUCCESS_CODE;
            loginAuthCallbacks.getTokenSuccessed(enumC0060q.d(), enumC0060q.b(), string, enumC0060q.c(), j, j2, j3);
        } catch (java.lang.Exception e) {
            a(str, j, j2, j3, "getMobileNum Exception" + e);
        }
    }
}
