package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class C0053j {
    private static volatile com.chuanglan.shanyan_sdk.C0053j l;
    private android.content.Context a;
    private com.chuanglan.shanyan_sdk.listener.AuthCallbacks b;
    private java.lang.String c;
    private java.lang.String d;
    private final com.chuanglan.shanyan_sdk.C0053j.d e = new com.chuanglan.shanyan_sdk.C0053j.d(this, null);
    private java.util.concurrent.ExecutorService f;
    private java.lang.String g;
    private long h;
    private long i;
    private long j;
    private java.lang.String k;

    /* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.j$a */
    class a implements java.lang.Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;

        a(long j, long j2, long j3) {
            this.a = j;
            this.b = j2;
            this.c = j3;
        }

        @Override // java.lang.Runnable
        public void run() throws java.lang.Throwable {
            try {
                com.chuanglan.shanyan_sdk.AbstractC0050g.a(com.chuanglan.shanyan_sdk.C0053j.this.a);
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "auth check", 11, "int status", java.lang.Integer.valueOf(com.chuanglan.shanyan_sdk.AbstractC0055l.u.get()));
                if (com.chuanglan.shanyan_sdk.AbstractC0055l.u.get() != com.chuanglan.shanyan_sdk.AbstractC0055l.r) {
                    com.chuanglan.shanyan_sdk.C0053j.a().c(this.a, this.b, this.c);
                } else if (com.chuanglan.shanyan_sdk.AbstractC0061r.c == com.chuanglan.shanyan_sdk.p0.a(com.chuanglan.shanyan_sdk.C0053j.this.a, "cl_jm_a6", com.chuanglan.shanyan_sdk.AbstractC0061r.b)) {
                    com.chuanglan.shanyan_sdk.AbstractC0055l.B = false;
                    com.chuanglan.shanyan_sdk.listener.AuthCallbacks authCallbacks = com.chuanglan.shanyan_sdk.C0053j.this.b;
                    com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.ACCOUNT_DISABLED_CODE;
                    authCallbacks.authFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c(), 11, com.chuanglan.shanyan_sdk.C0065v.g().b(com.chuanglan.shanyan_sdk.C0053j.this.a), this.a, this.b, this.c);
                } else {
                    com.chuanglan.shanyan_sdk.N.b().a(11, this.a, this.b);
                }
            } catch (java.lang.Exception e) {
                com.chuanglan.shanyan_sdk.C0053j.this.a(com.chuanglan.shanyan_sdk.C0065v.g().b(com.chuanglan.shanyan_sdk.C0053j.this.a), this.a, this.b, this.c, "authStart Exception" + e);
            }
        }
    }

    /* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.j$b */
    class b implements cn.com.chinatelecom.account.api.ResultListener {
        final /* synthetic */ long a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;

        b(long j, long j2, long j3) {
            this.a = j;
            this.b = j2;
            this.c = j3;
        }

        public void onResult(java.lang.String str) {
            try {
                com.chuanglan.shanyan_sdk.Q.c("LogInfoShanYanLogger", "ct requestPreLogin", str);
                if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(str)) {
                    com.chuanglan.shanyan_sdk.C0053j.this.a(-1, (java.lang.String) null, "ctcc response isEmpty");
                    return;
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                int iOptInt = jSONObject.optInt("result");
                java.lang.String strOptString = jSONObject.optString("msg");
                java.lang.String strOptString2 = jSONObject.optString("reqId");
                if (iOptInt != 0) {
                    com.chuanglan.shanyan_sdk.C0053j.this.a(iOptInt, strOptString, strOptString2);
                    return;
                }
                org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (jSONObjectOptJSONObject == null) {
                    com.chuanglan.shanyan_sdk.C0053j.this.a(iOptInt, strOptString, strOptString2);
                    return;
                }
                java.lang.String strOptString3 = jSONObjectOptJSONObject.optString("accessCode");
                java.lang.String strOptString4 = jSONObjectOptJSONObject.optString("gwAuth");
                if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(strOptString3)) {
                    com.chuanglan.shanyan_sdk.C0053j.this.a(iOptInt, strOptString, strOptString2);
                    return;
                }
                com.chuanglan.shanyan_sdk.C0053j.this.a("CTCC", "3" + com.chuanglan.shanyan_sdk.p0.a(com.chuanglan.shanyan_sdk.C0053j.this.a, "cl_jm_a8", "") + com.igexin.push.core.b.an + strOptString3, strOptString4, this.a, this.b, this.c);
            } catch (java.lang.Exception e) {
                com.chuanglan.shanyan_sdk.C0053j.this.a("CTCC", this.a, this.b, this.c, "ctcc onResult Exception" + e);
            }
        }
    }

    /* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.j$c */
    class c implements com.unicom.online.account.shield.ResultListener {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;

        c(java.lang.String str, long j, long j2, long j3) {
            this.a = str;
            this.b = j;
            this.c = j2;
            this.d = j3;
        }

        @Override // com.unicom.online.account.shield.ResultListener
        public void onResult(java.lang.String str) {
            try {
                com.chuanglan.shanyan_sdk.Q.c("LogInfoShanYanLogger", "cu cuGetToken", str);
                if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(str)) {
                    com.chuanglan.shanyan_sdk.C0053j.this.a(-1, (java.lang.String) null, "cucc response isEmpty");
                    return;
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                int iOptInt = jSONObject.optInt("resultCode");
                java.lang.String strOptString = jSONObject.optString("resultMsg");
                java.lang.String strOptString2 = jSONObject.optString("seq");
                org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("resultData");
                if (iOptInt == 100 && jSONObjectOptJSONObject != null) {
                    java.lang.String strOptString3 = jSONObjectOptJSONObject.optString("accessCode");
                    if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(strOptString3)) {
                        com.chuanglan.shanyan_sdk.C0053j.this.a(iOptInt, strOptString, jSONObjectOptJSONObject + strOptString2);
                        return;
                    }
                    com.chuanglan.shanyan_sdk.C0053j.this.a("CUCC", "2" + this.a + com.igexin.push.core.b.an + strOptString3, "", this.b, this.c, this.d);
                    return;
                }
                com.chuanglan.shanyan_sdk.C0053j.this.a(iOptInt, strOptString, jSONObjectOptJSONObject + strOptString2);
            } catch (java.lang.Exception e) {
                com.chuanglan.shanyan_sdk.C0053j.this.a("CUCC", this.b, this.c, this.d, "cucc onResult Exception" + e);
            }
        }
    }

    /* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.j$d */
    private class d implements com.cmic.gen.sdk.auth.GenTokenListener {
        private d() {
        }

        @Override // com.cmic.gen.sdk.auth.GenTokenListener
        public void onGetTokenComplete(int i, org.json.JSONObject jSONObject) {
            try {
                com.chuanglan.shanyan_sdk.Q.c("LogInfoShanYanLogger", "cm onGetTokenComplete", jSONObject, java.lang.Integer.valueOf(i));
                if (jSONObject == null) {
                    com.chuanglan.shanyan_sdk.C0053j.this.a(-1, (java.lang.String) null, "auth response isEmpty");
                    return;
                }
                int iOptInt = jSONObject.optInt("resultCode");
                java.lang.String strOptString = jSONObject.optString("desc");
                java.lang.String strOptString2 = jSONObject.optString("traceId");
                if (jSONObject.has(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN) && iOptInt == 103000) {
                    java.lang.String strOptString3 = jSONObject.optString(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN);
                    if (!com.chuanglan.shanyan_sdk.AbstractC0049f.a(strOptString3)) {
                        com.chuanglan.shanyan_sdk.C0053j c0053j = com.chuanglan.shanyan_sdk.C0053j.this;
                        c0053j.a(c0053j.g, com.chuanglan.shanyan_sdk.C0053j.this.a(strOptString3), "", com.chuanglan.shanyan_sdk.C0053j.this.i, com.chuanglan.shanyan_sdk.C0053j.this.h, com.chuanglan.shanyan_sdk.C0053j.this.j);
                        return;
                    } else {
                        com.chuanglan.shanyan_sdk.C0053j.this.a(iOptInt, strOptString, "token is empty" + strOptString2);
                        return;
                    }
                }
                com.chuanglan.shanyan_sdk.C0053j.this.a(iOptInt, strOptString, strOptString2);
            } catch (java.lang.Exception e) {
                com.chuanglan.shanyan_sdk.C0053j c0053j2 = com.chuanglan.shanyan_sdk.C0053j.this;
                c0053j2.a(c0053j2.g, com.chuanglan.shanyan_sdk.C0053j.this.i, com.chuanglan.shanyan_sdk.C0053j.this.h, com.chuanglan.shanyan_sdk.C0053j.this.j, "mCMCCAuth onGetTokenComplete Exception" + e);
            }
        }

        /* synthetic */ d(com.chuanglan.shanyan_sdk.C0053j c0053j, com.chuanglan.shanyan_sdk.C0053j.a aVar) {
            this();
        }
    }

    private C0053j() {
    }

    private void b(long j, long j2, long j3) {
        int iA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_e7", 6);
        java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_c4", new java.lang.String());
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "start cu mobileAuth", strA);
        com.unicom.online.account.shield.UniAccountHelper.getInstance().init(this.a, strA, false);
        com.unicom.online.account.shield.UniAccountHelper.getInstance().cuGetToken((iA + 1) * 1000, new com.chuanglan.shanyan_sdk.C0053j.c(strA, j, j2, j3));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(long r16, long r18, long r20) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuanglan.shanyan_sdk.C0053j.c(long, long, long):void");
    }

    public static com.chuanglan.shanyan_sdk.C0053j a() {
        if (l == null) {
            synchronized (com.chuanglan.shanyan_sdk.C0053j.class) {
                if (l == null) {
                    l = new com.chuanglan.shanyan_sdk.C0053j();
                }
            }
        }
        return l;
    }

    public void a(android.content.Context context, java.lang.String str, java.util.concurrent.ExecutorService executorService) {
        this.a = context;
        this.c = str;
        this.f = executorService;
    }

    public void a(long j, long j2) {
        this.b = new com.chuanglan.shanyan_sdk.C0052i();
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        com.chuanglan.shanyan_sdk.C0053j.a aVar = new com.chuanglan.shanyan_sdk.C0053j.a(j, j2, jUptimeMillis);
        if (this.a != null && this.f != null) {
            if (com.chuanglan.shanyan_sdk.AbstractC0055l.t != com.chuanglan.shanyan_sdk.AbstractC0055l.x.getAndSet(com.chuanglan.shanyan_sdk.AbstractC0055l.t)) {
                this.f.execute(aVar);
                return;
            } else {
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "auth is in progress");
                return;
            }
        }
        com.chuanglan.shanyan_sdk.listener.AuthCallbacks authCallbacks = this.b;
        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.NOT_INITIALIZED_CODE;
        authCallbacks.authFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c() + ":auth()", 11, "Unknown_Operator", j, j2, jUptimeMillis);
    }

    private boolean a(int i, long j, long j2, long j3) {
        java.lang.String str = "0";
        java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_d7", "0");
        if (strA.contains(com.igexin.push.core.b.an)) {
            java.lang.String[] strArrSplit = strA.split(com.igexin.push.core.b.an);
            java.lang.String str2 = strArrSplit.length == 1 ? strArrSplit[0] : "0";
            if (strArrSplit.length == 2) {
                str2 = strArrSplit[0];
                str = strArrSplit[1];
            }
            strA = str2;
        }
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "startGetPhoneInfo cucc", strA, str);
        if ("1".equals(strA)) {
            com.chuanglan.shanyan_sdk.t0.h().d();
            boolean zG = com.chuanglan.shanyan_sdk.AbstractC0059p.g(this.a);
            if (zG) {
                int iJ = com.chuanglan.shanyan_sdk.AbstractC0059p.j(this.a);
                if (iJ != 2 && iJ != 3) {
                    boolean zC = com.chuanglan.shanyan_sdk.AbstractC0059p.c(this.a);
                    boolean zA = com.chuanglan.shanyan_sdk.AbstractC0049f.a(java.lang.Integer.parseInt(str));
                    com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "startGetPhoneInfo enable", java.lang.Boolean.valueOf(zC), str);
                    if (zC && zA) {
                        com.chuanglan.shanyan_sdk.listener.AuthCallbacks authCallbacks = this.b;
                        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.DATA_REQUEST_FAILED_CODE;
                        authCallbacks.authFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c() + zG + iJ + zC, i, "CUCC", j, j2, j3);
                    }
                } else {
                    com.chuanglan.shanyan_sdk.listener.AuthCallbacks authCallbacks2 = this.b;
                    com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q2 = com.chuanglan.shanyan_sdk.EnumC0060q.DATA_REQUEST_FAILED_CODE;
                    authCallbacks2.authFailed(enumC0060q2.d(), enumC0060q2.b(), enumC0060q2.e(), enumC0060q2.c() + zG + iJ, i, "CUCC", j, j2, j3);
                    return true;
                }
            } else {
                com.chuanglan.shanyan_sdk.listener.AuthCallbacks authCallbacks3 = this.b;
                com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q3 = com.chuanglan.shanyan_sdk.EnumC0060q.DATA_REQUEST_FAILED_CODE;
                authCallbacks3.authFailed(enumC0060q3.d(), enumC0060q3.b(), enumC0060q3.e(), enumC0060q3.c() + zG, i, "CUCC", j, j2, j3);
                return true;
            }
        }
        return false;
    }

    private void a(java.lang.String str, long j, long j2, long j3, java.lang.String str2, com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q, java.lang.String str3) {
        int iA = com.chuanglan.shanyan_sdk.p0.a(this.a, str2, com.chuanglan.shanyan_sdk.AbstractC0061r.c);
        if (iA != 1) {
            if (iA != 2) {
                this.b.authFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c(), 11, str, j, j2, j3);
                return;
            } else {
                a(str, "5");
                return;
            }
        }
        if ("cu".equals(str3)) {
            b(j, j2, j3);
        } else if ("ct".equals(str3)) {
            a(j, j2, j3);
        } else {
            a(str, "1");
        }
    }

    private void a(long j, long j2, long j3) {
        int iA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_e7", 6);
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "start ct preinfo", java.lang.Integer.valueOf(iA));
        int i = iA + 1;
        int i2 = i * 500;
        cn.com.chinatelecom.account.api.CtAuth.getInstance().requestPreLogin(new cn.com.chinatelecom.account.api.CtSetting(i2, i2, i * 1000), new com.chuanglan.shanyan_sdk.C0053j.b(j, j2, j3));
    }

    private void a(java.lang.String str, java.lang.String str2) {
        this.g = str;
        this.h = android.os.SystemClock.uptimeMillis();
        this.j = android.os.SystemClock.uptimeMillis();
        this.i = java.lang.System.currentTimeMillis();
        this.d = str2;
        this.k = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_a9", new java.lang.String());
        java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_c7", new java.lang.String());
        com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(this.a).setOverTime((com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_e7", 6) + 1) * 1000);
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "start  cm mobileAuth", this.k);
        com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(this.a).mobileAuth(this.k, strA, this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3, long j, long j2, long j3) {
        java.lang.String str4;
        try {
            java.lang.String strSubstring = str2.substring(0, 1);
            int iIndexOf = str2.indexOf(44);
            java.lang.String strSubstring2 = str2.substring(1, iIndexOf);
            java.lang.String strSubstring3 = str2.substring(iIndexOf + 1);
            java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_c3", "");
            java.lang.String strA2 = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_c2", "");
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("ap", strA);
            jSONObject.put("tk", strSubstring3);
            jSONObject.put("au", str3);
            java.lang.String strB = com.chuanglan.shanyan_sdk.AbstractC0050g.b(this.a);
            java.lang.String strB2 = com.chuanglan.shanyan_sdk.AbstractC0045b.b(this.c);
            java.lang.String strSubstring4 = strB2.substring(0, 16);
            java.lang.String strSubstring5 = strB2.substring(16);
            java.lang.String str5 = com.igexin.push.core.b.an + strB;
            java.lang.String strA3 = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_a3", "");
            com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_f5", str5);
            jSONObject.put("dd", strA3 + str5);
            jSONObject.put("ud", com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_a2", ""));
            jSONObject.put("vs", "2.3.7.7");
            jSONObject.put("tp", "1");
            jSONObject.put("nlt", "1");
            jSONObject.put("ad", strSubstring2);
            java.lang.String strEncodeToString = android.util.Base64.encodeToString(com.chuanglan.shanyan_sdk.AbstractC0045b.a(jSONObject.toString().getBytes("UTF-8"), strSubstring4, strSubstring5), 11);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strA2) && "1".equals(strA2)) {
                str4 = "A" + strSubstring + strA + "-" + strEncodeToString;
            } else {
                str4 = "A" + strSubstring + "-" + strEncodeToString;
            }
            jSONObject2.put(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, str4);
            java.lang.String string = jSONObject2.toString();
            com.chuanglan.shanyan_sdk.Q.c("LogInfoShanYanLogger", "pre token", strSubstring4, strSubstring5, jSONObject);
            com.chuanglan.shanyan_sdk.listener.AuthCallbacks authCallbacks = this.b;
            com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.AUTH_TOKEN_SUCCESS_CODE;
            authCallbacks.authSuccessed(enumC0060q.d(), enumC0060q.b(), string, enumC0060q.c(), 11, str, j, j2, j3);
        } catch (java.lang.Exception e) {
            a(com.chuanglan.shanyan_sdk.C0065v.g().b(this.a), j, j2, j3, "phoneNumVerify Exception" + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, java.lang.String str, java.lang.String str2) {
        com.chuanglan.shanyan_sdk.listener.AuthCallbacks authCallbacks = this.b;
        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.AUTH_TOKEN_FAILED_CODE;
        authCallbacks.authFailed(enumC0060q.d(), i == -1 ? enumC0060q.b() : i, str == null ? enumC0060q.e() : str, enumC0060q.c() + str2, 11, this.g, this.i, this.h, this.j);
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
        return this.d + this.k + com.igexin.push.core.b.an + str2 + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, long j, long j2, long j3, java.lang.String str2) {
        com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", str2);
        com.chuanglan.shanyan_sdk.listener.AuthCallbacks authCallbacks = this.b;
        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.SDK_EXCEPTION_CODE;
        authCallbacks.authFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c() + str2, 11, str, j, j2, j3);
    }
}
