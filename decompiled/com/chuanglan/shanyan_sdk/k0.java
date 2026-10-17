package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class k0 {
    private static volatile com.chuanglan.shanyan_sdk.k0 j;
    private android.content.Context a;
    private com.chuanglan.shanyan_sdk.listener.GetPhoneInfoCallbacks b;
    private com.chuanglan.shanyan_sdk.k0.d c;
    private int d;
    private java.lang.String e;
    private long f;
    private long g;
    private long h;
    private java.util.concurrent.ExecutorService i;

    class a implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;
        final /* synthetic */ java.lang.String e;

        a(int i, long j, long j2, long j3, java.lang.String str) {
            this.a = i;
            this.b = j;
            this.c = j2;
            this.d = j3;
            this.e = str;
        }

        @Override // java.lang.Runnable
        public void run() throws java.lang.Throwable {
            try {
                com.chuanglan.shanyan_sdk.k0.this.a(this.a, this.b, this.c, this.d, this.e);
            } catch (java.lang.Exception e) {
                com.chuanglan.shanyan_sdk.k0.this.a("getPhoneInfoMethod Exception" + e, this.e, this.a, this.b, this.c, this.d);
            }
        }
    }

    class b implements cn.com.chinatelecom.account.api.ResultListener {
        final /* synthetic */ int a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ java.lang.String f;

        b(int i, java.lang.String str, long j, long j2, long j3, java.lang.String str2) {
            this.a = i;
            this.b = str;
            this.c = j;
            this.d = j2;
            this.e = j3;
            this.f = str2;
        }

        public void onResult(java.lang.String str) {
            try {
                com.chuanglan.shanyan_sdk.Q.c("LogInfoShanYanLogger", "ct requestPreLogin", str);
                if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(str)) {
                    com.chuanglan.shanyan_sdk.k0.this.a(this.a, this.b, this.c, this.d, this.e, -1, (java.lang.String) null, "ct response isEmpty");
                    return;
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                int iOptInt = jSONObject.optInt("result");
                java.lang.String strOptString = jSONObject.optString("msg");
                java.lang.String strOptString2 = jSONObject.optString("reqId");
                if (iOptInt != 0) {
                    com.chuanglan.shanyan_sdk.k0.this.a(this.a, this.b, this.c, this.d, this.e, iOptInt, strOptString, strOptString2);
                    return;
                }
                org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (jSONObjectOptJSONObject == null) {
                    com.chuanglan.shanyan_sdk.k0.this.a(this.a, this.b, this.c, this.d, this.e, iOptInt, strOptString, strOptString2);
                    return;
                }
                java.lang.String strOptString3 = jSONObjectOptJSONObject.optString("number");
                java.lang.String strOptString4 = jSONObjectOptJSONObject.optString("accessCode");
                java.lang.String strOptString5 = jSONObjectOptJSONObject.optString("gwAuth");
                if (!com.chuanglan.shanyan_sdk.AbstractC0049f.a(strOptString3) && !com.chuanglan.shanyan_sdk.AbstractC0049f.a(strOptString4)) {
                    com.chuanglan.shanyan_sdk.k0.this.a(strOptString3, strOptString4, strOptString5, iOptInt, this.f, this.b, this.a, this.c, this.d, this.e);
                    return;
                }
                com.chuanglan.shanyan_sdk.k0.this.a(this.a, this.b, this.c, this.d, this.e, iOptInt, strOptString, jSONObjectOptJSONObject + strOptString2);
            } catch (java.lang.Exception e) {
                com.chuanglan.shanyan_sdk.k0.this.a("ct requestPreLogin Exception" + e, this.b, this.a, this.c, this.d, this.e);
            }
        }
    }

    class c implements com.unicom.online.account.shield.ResultListener {
        final /* synthetic */ int a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ java.lang.String f;

        c(int i, java.lang.String str, long j, long j2, long j3, java.lang.String str2) {
            this.a = i;
            this.b = str;
            this.c = j;
            this.d = j2;
            this.e = j3;
            this.f = str2;
        }

        @Override // com.unicom.online.account.shield.ResultListener
        public void onResult(java.lang.String str) {
            try {
                com.chuanglan.shanyan_sdk.Q.c("LogInfoShanYanLogger", "cu cuGetToken", str);
                if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(str)) {
                    com.chuanglan.shanyan_sdk.k0.this.a(this.a, this.b, this.c, this.d, this.e, -1, (java.lang.String) null, "cu response isEmpty");
                    return;
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                int iOptInt = jSONObject.optInt("resultCode");
                java.lang.String strOptString = jSONObject.optString("resultMsg");
                java.lang.String strOptString2 = jSONObject.optString("seq");
                if (iOptInt != 100) {
                    com.chuanglan.shanyan_sdk.k0.this.a(this.a, this.b, this.c, this.d, this.e, iOptInt, strOptString, strOptString2);
                    return;
                }
                org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("resultData");
                if (jSONObjectOptJSONObject == null) {
                    com.chuanglan.shanyan_sdk.k0.this.a(this.a, this.b, this.c, this.d, this.e, iOptInt, strOptString, strOptString2);
                    return;
                }
                java.lang.String strOptString3 = jSONObjectOptJSONObject.optString("fakeMobile");
                java.lang.String strOptString4 = jSONObjectOptJSONObject.optString("accessCode");
                if (!com.chuanglan.shanyan_sdk.AbstractC0049f.a(strOptString3) && !com.chuanglan.shanyan_sdk.AbstractC0049f.a(strOptString4)) {
                    com.chuanglan.shanyan_sdk.k0.this.a(strOptString3, strOptString4, iOptInt, this.f, this.b, this.a, this.c, this.d, this.e);
                    return;
                }
                com.chuanglan.shanyan_sdk.k0.this.a(this.a, this.b, this.c, this.d, this.e, iOptInt, strOptString, jSONObjectOptJSONObject + strOptString2);
            } catch (java.lang.Exception e) {
                com.chuanglan.shanyan_sdk.k0.this.a("cuPreInfo Exception" + e, this.b, this.a, this.c, this.d, this.e);
            }
        }
    }

    private class d implements com.cmic.gen.sdk.auth.GenTokenListener {
        private d() {
        }

        @Override // com.cmic.gen.sdk.auth.GenTokenListener
        public void onGetTokenComplete(int i, org.json.JSONObject jSONObject) {
            try {
                com.chuanglan.shanyan_sdk.Q.c("LogInfoShanYanLogger", "cm onGetTokenComplete", jSONObject, java.lang.Integer.valueOf(i));
                if (jSONObject == null) {
                    com.chuanglan.shanyan_sdk.k0 k0Var = com.chuanglan.shanyan_sdk.k0.this;
                    k0Var.a(k0Var.d, com.chuanglan.shanyan_sdk.k0.this.e, com.chuanglan.shanyan_sdk.k0.this.g, com.chuanglan.shanyan_sdk.k0.this.f, com.chuanglan.shanyan_sdk.k0.this.h, -1, (java.lang.String) null, "cm response isEmpty");
                    return;
                }
                int iOptInt = jSONObject.optInt("resultCode");
                java.lang.String strOptString = jSONObject.optString("desc");
                java.lang.String strOptString2 = jSONObject.optString("traceId");
                if (iOptInt != 103000) {
                    com.chuanglan.shanyan_sdk.k0 k0Var2 = com.chuanglan.shanyan_sdk.k0.this;
                    k0Var2.a(k0Var2.d, com.chuanglan.shanyan_sdk.k0.this.e, com.chuanglan.shanyan_sdk.k0.this.g, com.chuanglan.shanyan_sdk.k0.this.f, com.chuanglan.shanyan_sdk.k0.this.h, iOptInt, strOptString, strOptString2);
                    return;
                }
                java.lang.String strA = com.cmic.gen.sdk.u0.a(com.chuanglan.shanyan_sdk.k0.this.a);
                if (!com.chuanglan.shanyan_sdk.AbstractC0049f.a(strA)) {
                    com.chuanglan.shanyan_sdk.k0.this.a(strA, iOptInt);
                } else {
                    com.chuanglan.shanyan_sdk.k0 k0Var3 = com.chuanglan.shanyan_sdk.k0.this;
                    k0Var3.a(k0Var3.d, com.chuanglan.shanyan_sdk.k0.this.e, com.chuanglan.shanyan_sdk.k0.this.g, com.chuanglan.shanyan_sdk.k0.this.f, com.chuanglan.shanyan_sdk.k0.this.h, iOptInt, strOptString, strOptString2);
                }
            } catch (java.lang.Exception e) {
                com.chuanglan.shanyan_sdk.k0.this.a("cm onGetTokenComplete Exception" + e, com.chuanglan.shanyan_sdk.k0.this.e, com.chuanglan.shanyan_sdk.k0.this.d, com.chuanglan.shanyan_sdk.k0.this.g, com.chuanglan.shanyan_sdk.k0.this.f, com.chuanglan.shanyan_sdk.k0.this.h);
            }
        }

        /* synthetic */ d(com.chuanglan.shanyan_sdk.k0 k0Var, com.chuanglan.shanyan_sdk.k0.a aVar) {
            this();
        }
    }

    private k0() {
    }

    public static com.chuanglan.shanyan_sdk.k0 b() {
        if (j == null) {
            synchronized (com.chuanglan.shanyan_sdk.k0.class) {
                if (j == null) {
                    j = new com.chuanglan.shanyan_sdk.k0();
                }
            }
        }
        return j;
    }

    public void c(int i, java.lang.String str, long j2, long j3, long j4) {
        java.lang.String strB = com.chuanglan.shanyan_sdk.AbstractC0049f.a(str) ? com.chuanglan.shanyan_sdk.C0065v.g().b(this.a) : str;
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "startGetPhoneInfo processName", java.lang.Integer.valueOf(i), strB);
        strB.hashCode();
        if (strB.equals("CTCC")) {
            java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_g2", "ct");
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "ctChannelType", strA);
            a(i, strB, j2, j3, j4, "cl_jm_e5", com.chuanglan.shanyan_sdk.EnumC0060q.CTCC_UNAVAILABLE_CODE, strA);
        } else if (!strB.equals("CUCC")) {
            java.lang.String strA2 = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_g1", "cm");
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "cmChannelType", strA2);
            a(i, strB, j2, j3, j4, "cl_jm_e3", com.chuanglan.shanyan_sdk.EnumC0060q.CMCC_UNAVAILABLE_CODE, strA2);
        } else {
            if (a(i, strB, j2, j3, j4)) {
                return;
            }
            java.lang.String strA3 = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_g3", "cu");
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "cuChannelType", strA3);
            a(i, strB, j2, j3, j4, "cl_jm_e4", com.chuanglan.shanyan_sdk.EnumC0060q.CUCC_UNAVAILABLE_CODE, strA3);
        }
    }

    public void a(android.content.Context context, java.util.concurrent.ExecutorService executorService) {
        this.a = context;
        this.i = executorService;
    }

    private void b(int i, java.lang.String str, long j2, long j3, long j4) {
        com.chuanglan.shanyan_sdk.listener.GetPhoneInfoCallbacks getPhoneInfoCallbacks = this.b;
        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.DATA_REQUEST_FAILED_CODE;
        getPhoneInfoCallbacks.getPhoneInfoFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c(), i, str, j2, j3, j4);
    }

    public void a(int i, java.lang.String str, long j2, long j3) {
        this.b = new com.chuanglan.shanyan_sdk.C(this.a);
        com.chuanglan.shanyan_sdk.AbstractC0050g.e(this.a);
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        com.chuanglan.shanyan_sdk.k0.a aVar = new com.chuanglan.shanyan_sdk.k0.a(i, j2, j3, jUptimeMillis, str);
        if (this.a != null && this.i != null) {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "start preInfo processName", java.lang.Integer.valueOf(i));
            this.i.execute(aVar);
            return;
        }
        com.chuanglan.shanyan_sdk.listener.GetPhoneInfoCallbacks getPhoneInfoCallbacks = this.b;
        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.NOT_INITIALIZED_CODE;
        getPhoneInfoCallbacks.getPhoneInfoFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c() + "getPhoneInfoMethod()", i, "Unknown_Operator", j2, j3, jUptimeMillis);
    }

    private void b(java.lang.String str, int i, long j2, long j3, long j4, java.lang.String str2) {
        try {
            if (com.chuanglan.shanyan_sdk.t0.h().d(this.a)) {
                com.chuanglan.shanyan_sdk.AbstractC0055l.n = com.chuanglan.shanyan_sdk.f0.a(str);
                com.chuanglan.shanyan_sdk.AbstractC0055l.o = com.chuanglan.shanyan_sdk.f0.b(str);
                com.chuanglan.shanyan_sdk.AbstractC0055l.m = str;
                com.chuanglan.shanyan_sdk.AbstractC0055l.p = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_f8", "");
                com.chuanglan.shanyan_sdk.listener.GetPhoneInfoCallbacks getPhoneInfoCallbacks = this.b;
                com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.PRE_CACHE_SUCCESS_CODE;
                getPhoneInfoCallbacks.getPhoneInfoSuccessed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c(), i, j2, j3, j4);
            } else {
                com.chuanglan.shanyan_sdk.t0.h().d();
                a(str, i, j2, j3, j4, str2);
            }
        } catch (java.lang.Exception e) {
            a("preTimeCheck Exception" + e, str, i, j2, j3, j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, long j2, long j3, long j4, java.lang.String str) throws java.lang.Throwable {
        com.chuanglan.shanyan_sdk.AbstractC0050g.a(this.a);
        int iA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_e7", 6);
        com.chuanglan.shanyan_sdk.j0.a(this.a, ((long) iA) * 1000, i, this.b, j2, j3, j4);
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "preInfo", java.lang.Integer.valueOf(iA), "status", java.lang.Integer.valueOf(com.chuanglan.shanyan_sdk.AbstractC0055l.u.get()));
        if (com.chuanglan.shanyan_sdk.AbstractC0055l.u.get() == com.chuanglan.shanyan_sdk.AbstractC0055l.r) {
            if (1 == com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_a6", com.chuanglan.shanyan_sdk.AbstractC0061r.b)) {
                com.chuanglan.shanyan_sdk.AbstractC0055l.B = false;
                com.chuanglan.shanyan_sdk.listener.GetPhoneInfoCallbacks getPhoneInfoCallbacks = this.b;
                com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.ACCOUNT_DISABLED_CODE;
                getPhoneInfoCallbacks.getPhoneInfoFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c(), i, com.chuanglan.shanyan_sdk.C0065v.g().b(this.a), j2, j3, j4);
                return;
            }
            com.chuanglan.shanyan_sdk.N.b().a(i, j2, j3);
            return;
        }
        c(i, str, j2, j3, j4);
    }

    private void b(java.lang.String str, int i, long j2, long j3, long j4) {
        int iA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_e7", 6);
        java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_c4", "");
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "start cu preinfo", strA);
        com.unicom.online.account.shield.UniAccountHelper.getInstance().init(this.a, strA, false);
        com.unicom.online.account.shield.UniAccountHelper.getInstance().setUseCacheFlag(false);
        com.unicom.online.account.shield.UniAccountHelper.getInstance().clearCache();
        com.unicom.online.account.shield.UniAccountHelper.getInstance().cuGetToken((iA + 1) * 1000, new com.chuanglan.shanyan_sdk.k0.c(i, str, j2, j3, j4, strA));
    }

    public boolean a(int i, java.lang.String str, long j2, long j3, long j4) {
        java.lang.String[] strArrSplit = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_d7", "0").split(com.igexin.push.core.b.an);
        java.lang.String str2 = strArrSplit.length > 0 ? strArrSplit[0] : "0";
        java.lang.String str3 = strArrSplit.length > 1 ? strArrSplit[1] : "0";
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "startGetPhoneInfo cucc", str2, str3);
        if (!"1".equals(str2)) {
            return false;
        }
        com.chuanglan.shanyan_sdk.t0.h().d();
        if (!com.chuanglan.shanyan_sdk.AbstractC0059p.g(this.a)) {
            b(i, str, j2, j3, j4);
            return true;
        }
        int iJ = com.chuanglan.shanyan_sdk.AbstractC0059p.j(this.a);
        if (iJ != 2 && iJ != 3) {
            boolean zC = com.chuanglan.shanyan_sdk.AbstractC0059p.c(this.a);
            boolean zA = com.chuanglan.shanyan_sdk.AbstractC0049f.a(java.lang.Integer.parseInt(str3));
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "startGetPhoneInfo enable", java.lang.Boolean.valueOf(zC), str3, java.lang.Boolean.valueOf(zA));
            if (!zC || !zA) {
                return false;
            }
            b(i, str, j2, j3, j4);
            return true;
        }
        b(i, str, j2, j3, j4);
        return true;
    }

    private void a(int i, java.lang.String str, long j2, long j3, long j4, java.lang.String str2, com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q, java.lang.String str3) {
        int iA = com.chuanglan.shanyan_sdk.p0.a(this.a, str2, com.chuanglan.shanyan_sdk.AbstractC0061r.c);
        if (iA != 1 && iA != 2) {
            this.b.getPhoneInfoFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c(), i, str, j2, j3, j4);
        } else {
            b(str, i, j2, j3, j4, str3);
        }
    }

    private void a(java.lang.String str, int i, long j2, long j3, long j4, java.lang.String str2) {
        this.d = i;
        this.f = j3;
        this.h = j4;
        this.g = j2;
        this.e = str;
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "operatorPreInfo ", java.lang.Integer.valueOf(i), str, str2);
        if ("cu".equals(str2)) {
            b(str, i, j2, j3, j4);
        } else if ("ct".equals(str2)) {
            a(str, i, j2, j3, j4);
        } else {
            a();
        }
    }

    private void a() {
        com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(this.a).setOverTime((com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_e7", 6) + 1) * 1000);
        if (this.c == null) {
            this.c = new com.chuanglan.shanyan_sdk.k0.d(this, null);
        }
        java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_a9", "");
        java.lang.String strA2 = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_c7", "");
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "start  cm preinfo", strA);
        com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(this.a).getPhoneInfo(strA, strA2, this.c);
    }

    private void a(java.lang.String str, int i, long j2, long j3, long j4) {
        int iA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_e7", 6);
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "start ct preinfo", str, java.lang.Integer.valueOf(iA));
        int i2 = iA + 1;
        int i3 = i2 * 500;
        cn.com.chinatelecom.account.api.CtAuth.getInstance().requestPreLogin(new cn.com.chinatelecom.account.api.CtSetting(i3, i3, i2 * 1000), new com.chuanglan.shanyan_sdk.k0.b(i, str, j2, j3, j4, com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_a8", "")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.String str4, java.lang.String str5, int i2, long j2, long j3, long j4) {
        com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_f8", str);
        com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_d8", java.lang.System.currentTimeMillis() + (com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_b5", 3600L) * 1000));
        com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_f7", "3" + str4 + com.igexin.push.core.b.an + str2);
        com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_d9", str3);
        com.chuanglan.shanyan_sdk.AbstractC0055l.p = str;
        com.chuanglan.shanyan_sdk.AbstractC0055l.n = com.chuanglan.shanyan_sdk.f0.a(str5);
        com.chuanglan.shanyan_sdk.AbstractC0055l.o = com.chuanglan.shanyan_sdk.f0.b(str5);
        com.chuanglan.shanyan_sdk.AbstractC0055l.m = str5;
        com.chuanglan.shanyan_sdk.listener.GetPhoneInfoCallbacks getPhoneInfoCallbacks = this.b;
        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.PRE_SUCCESS_CODE;
        getPhoneInfoCallbacks.getPhoneInfoSuccessed(enumC0060q.d(), i, enumC0060q.e(), enumC0060q.c(), i2, j2, j3, j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, java.lang.String str2, int i, long j2, long j3, long j4) {
        com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "Exception in preTimeCheck", str);
        com.chuanglan.shanyan_sdk.listener.GetPhoneInfoCallbacks getPhoneInfoCallbacks = this.b;
        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.SDK_EXCEPTION_CODE;
        getPhoneInfoCallbacks.getPhoneInfoFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c() + "Exception_e=" + str, i, str2, j2, j3, j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.lang.String str4, int i2, long j2, long j3, long j4) {
        com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_f8", str);
        com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_d8", java.lang.System.currentTimeMillis() + (com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_c6", 3600L) * 1000));
        com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_f7", "2" + str3 + com.igexin.push.core.b.an + str2);
        com.chuanglan.shanyan_sdk.AbstractC0055l.p = str;
        com.chuanglan.shanyan_sdk.AbstractC0055l.o = com.chuanglan.shanyan_sdk.f0.b(str4);
        com.chuanglan.shanyan_sdk.AbstractC0055l.n = com.chuanglan.shanyan_sdk.f0.a(str4);
        com.chuanglan.shanyan_sdk.AbstractC0055l.m = str4;
        com.chuanglan.shanyan_sdk.listener.GetPhoneInfoCallbacks getPhoneInfoCallbacks = this.b;
        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.PRE_SUCCESS_CODE;
        getPhoneInfoCallbacks.getPhoneInfoSuccessed(enumC0060q.d(), i, enumC0060q.e(), enumC0060q.c(), i2, j2, j3, j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, int i) {
        com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_f8", str);
        com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_d8", java.lang.System.currentTimeMillis() + java.lang.System.currentTimeMillis() + (com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_b6", 3600L) * 1000));
        com.chuanglan.shanyan_sdk.AbstractC0055l.p = str;
        com.chuanglan.shanyan_sdk.AbstractC0055l.n = com.chuanglan.shanyan_sdk.f0.a(this.e);
        com.chuanglan.shanyan_sdk.AbstractC0055l.o = com.chuanglan.shanyan_sdk.f0.b(this.e);
        com.chuanglan.shanyan_sdk.AbstractC0055l.m = this.e;
        com.chuanglan.shanyan_sdk.listener.GetPhoneInfoCallbacks getPhoneInfoCallbacks = this.b;
        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.PRE_SUCCESS_CODE;
        getPhoneInfoCallbacks.getPhoneInfoSuccessed(enumC0060q.d(), i, enumC0060q.e(), enumC0060q.c(), this.d, this.g, this.f, this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, java.lang.String str, long j2, long j3, long j4, int i2, java.lang.String str2, java.lang.String str3) {
        com.chuanglan.shanyan_sdk.listener.GetPhoneInfoCallbacks getPhoneInfoCallbacks = this.b;
        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.PRE_REQUEST_FAILED_CODE;
        getPhoneInfoCallbacks.getPhoneInfoFailed(enumC0060q.d(), i2 == -1 ? com.chuanglan.shanyan_sdk.EnumC0060q.AUTH_TOKEN_FAILED_CODE.b() : i2, str2 == null ? com.chuanglan.shanyan_sdk.EnumC0060q.AUTH_TOKEN_FAILED_CODE.e() : str2, enumC0060q.c() + str3, i, str, j2, j3, j4);
    }
}
