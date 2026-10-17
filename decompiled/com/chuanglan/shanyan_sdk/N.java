package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class N {
    private static volatile com.chuanglan.shanyan_sdk.N g;
    private com.chuanglan.shanyan_sdk.listener.InitCallbacks a;
    private java.lang.String b;
    private android.content.Context c;
    private java.util.concurrent.ExecutorService d;
    private java.util.concurrent.ExecutorService e;
    private int f;

    class a implements java.lang.Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ long b;

        a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        @Override // java.lang.Runnable
        public void run() throws java.lang.Throwable {
            if (com.chuanglan.shanyan_sdk.N.this.d == null || com.chuanglan.shanyan_sdk.N.this.d.isShutdown()) {
                com.chuanglan.shanyan_sdk.N.this.d = new java.util.concurrent.ThreadPoolExecutor(8, Integer.MAX_VALUE, 120L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingDeque());
            }
            com.chuanglan.shanyan_sdk.N.this.d.execute(new com.chuanglan.shanyan_sdk.i0().a());
            android.os.Process.setThreadPriority(-20);
            com.chuanglan.shanyan_sdk.N.this.a(1, this.a, this.b);
        }
    }

    class c implements cn.com.chinatelecom.account.api.TraceLogger {
        c() {
        }

        public void debug(java.lang.String str, java.lang.String str2) {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "debug s", str, "s1", str2);
        }

        public void info(java.lang.String str, java.lang.String str2) {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "info s", str, "s1", str2);
        }

        public void warn(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "warn s", str, "s1", str2, "throwable", th);
        }
    }

    private N() {
    }

    public static com.chuanglan.shanyan_sdk.N b() {
        if (g == null) {
            synchronized (com.chuanglan.shanyan_sdk.N.class) {
                if (g == null) {
                    g = new com.chuanglan.shanyan_sdk.N();
                }
            }
        }
        return g;
    }

    private void c() {
        if (!com.chuanglan.shanyan_sdk.AbstractC0055l.P) {
            a("ipv6.cl2009.com");
        } else {
            com.chuanglan.shanyan_sdk.AbstractC0055l.M.remove("ipv6.cl2009.com");
            com.chuanglan.shanyan_sdk.AbstractC0055l.M.add(0, "ipv6.cl2009.com");
        }
    }

    private void e() {
        a(java.util.Arrays.asList("sy.cl2m.cn", "fs.cl2009.com", "sy.new253.com", "sy.cl2009.com"));
        java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(this.c, "cl_jm_b1", "");
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strA)) {
            if (com.chuanglan.shanyan_sdk.p0.a(this.c, "cl_jm_a7", false)) {
                com.chuanglan.shanyan_sdk.AbstractC0055l.M.add(0, strA);
            } else {
                a(strA);
            }
        }
        c();
    }

    private java.lang.String f() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String strB = new com.chuanglan.shanyan_sdk.g0().b();
        com.chuanglan.shanyan_sdk.AbstractC0055l.z = (int) (java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
        com.chuanglan.shanyan_sdk.Q.c("ProcessShanYanLogger", "init list", com.chuanglan.shanyan_sdk.AbstractC0055l.M);
        return strB;
    }

    public void d() {
        try {
            java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(this.c, "cl_jm_a8", "");
            java.lang.String strA2 = com.chuanglan.shanyan_sdk.p0.a(this.c, "cl_jm_c9", "");
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "start ct init", strA);
            if (com.chuanglan.shanyan_sdk.P.a) {
                cn.com.chinatelecom.account.api.CtAuth.getInstance().init(this.c, strA, strA2, new com.chuanglan.shanyan_sdk.N.c());
            } else {
                cn.com.chinatelecom.account.api.CtAuth.getInstance().init(this.c, strA, strA2, (cn.com.chinatelecom.account.api.TraceLogger) null);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "CtAuth init Exception", th);
        }
    }

    class b extends com.chuanglan.shanyan_sdk.AbstractC0048e {
        final /* synthetic */ java.util.Map b;
        final /* synthetic */ int c;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ long f;

        b(java.util.Map map, int i, long j, long j2, long j3) {
            this.b = map;
            this.c = i;
            this.d = j;
            this.e = j2;
            this.f = j3;
        }

        @Override // com.chuanglan.shanyan_sdk.AbstractC0048e
        public void a(java.lang.String str) {
            com.chuanglan.shanyan_sdk.Q.c("LogInfoShanYanLogger", "initStart params", this.b, "\nresult==", str);
            com.chuanglan.shanyan_sdk.N.this.a(str, this.c, this.d, this.e, this.f);
        }

        @Override // com.chuanglan.shanyan_sdk.AbstractC0056m
        public void a(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
            com.chuanglan.shanyan_sdk.N.this.a(str, str2, this.c, this.d, this.e, this.f);
        }
    }

    public void a(android.content.Context context, java.lang.String str) {
        java.util.concurrent.ExecutorService executorService = this.e;
        if (executorService == null || executorService.isShutdown()) {
            this.e = new java.util.concurrent.ThreadPoolExecutor(1, Integer.MAX_VALUE, 120L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingDeque());
        }
        this.b = str;
        this.c = context;
        this.f = 0;
        com.chuanglan.shanyan_sdk.AbstractC0066w.a(context);
        com.chuanglan.shanyan_sdk.k0.b().a(context, this.e);
        com.chuanglan.shanyan_sdk.T.a().a(context, this.e);
        com.chuanglan.shanyan_sdk.E.a().a(context, str, this.e);
        com.chuanglan.shanyan_sdk.C0053j.a().a(context, str, this.e);
        com.chuanglan.shanyan_sdk.A.g().a(context, str);
        a();
        com.chuanglan.shanyan_sdk.AbstractC0050g.e(context);
        com.chuanglan.shanyan_sdk.AbstractC0050g.d(context);
        com.chuanglan.shanyan_sdk.AbstractC0050g.c(context);
    }

    private void c(java.lang.String str) {
        if (!com.chuanglan.shanyan_sdk.AbstractC0049f.b(str) || str.length() < 3) {
            return;
        }
        int i = java.lang.Integer.parseInt(java.lang.String.valueOf(str.charAt(0)));
        int i2 = java.lang.Integer.parseInt(java.lang.String.valueOf(str.charAt(1)));
        int i3 = java.lang.Integer.parseInt(java.lang.String.valueOf(str.charAt(2)));
        int iA = com.chuanglan.shanyan_sdk.p0.a(this.c, "cl_jm_e3", com.chuanglan.shanyan_sdk.AbstractC0061r.c);
        int iA2 = com.chuanglan.shanyan_sdk.p0.a(this.c, "cl_jm_e4", com.chuanglan.shanyan_sdk.AbstractC0061r.c);
        int iA3 = com.chuanglan.shanyan_sdk.p0.a(this.c, "cl_jm_e5", com.chuanglan.shanyan_sdk.AbstractC0061r.c);
        if (iA == i && iA2 == i2 && iA3 == i3) {
            return;
        }
        com.chuanglan.shanyan_sdk.t0.h().d();
        com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_e3", i);
        com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_e4", i2);
        com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_e5", i3);
    }

    private void b(java.lang.String str) {
        if (str != null) {
            com.chuanglan.shanyan_sdk.n0.a = "https://" + str + "/flash/thin/accountInit/v3";
        }
    }

    private void a() {
        java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(this.c, "cl_jm_a5", "");
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(strA) || !"2.3.7.7".equals(strA)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_a5", "2.3.7.7");
            com.chuanglan.shanyan_sdk.t0.h().a();
        }
    }

    public void a(long j, long j2) {
        com.chuanglan.shanyan_sdk.N.a aVar = new com.chuanglan.shanyan_sdk.N.a(j, j2);
        if (com.chuanglan.shanyan_sdk.AbstractC0055l.t != com.chuanglan.shanyan_sdk.AbstractC0055l.u.getAndSet(com.chuanglan.shanyan_sdk.AbstractC0055l.t)) {
            this.e.execute(aVar);
        } else {
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "Initialization is in progress");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v3 */
    public void a(int i, long j, long j2) throws java.lang.Throwable {
        char c2;
        char c3;
        int i2;
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        char c4 = 2;
        try {
            this.a = new com.chuanglan.shanyan_sdk.L(this.c);
            int i3 = i;
            i2 = i3;
            if (i3 == 1) {
                long j3 = jUptimeMillis;
                com.chuanglan.shanyan_sdk.M.a(((long) com.chuanglan.shanyan_sdk.p0.a(this.c, "cl_jm_e6", 6)) * 1000, this.a, i, j, j2, j3);
                i2 = j3;
            }
            java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(this.c, "cl_jm_a6", "0");
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "initStart processName", java.lang.Integer.valueOf(i), "user", strA);
            try {
                if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strA)) {
                    try {
                        if ("1".equals(strA)) {
                            com.chuanglan.shanyan_sdk.AbstractC0055l.B = false;
                            com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.ACCOUNT_DISABLED_CODE;
                            a(enumC0060q, enumC0060q.b(), enumC0060q.e(), enumC0060q.c(), i, j, j2, jUptimeMillis);
                            return;
                        }
                    } catch (java.lang.Exception e) {
                        e = e;
                        c4 = 0;
                        c3 = 1;
                        c2 = c4;
                        i2 = 2;
                        e.printStackTrace();
                        java.lang.Object[] objArr = new java.lang.Object[i2];
                        objArr[c2] = "initStart Exception";
                        objArr[c3] = e;
                        com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", objArr);
                        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q2 = com.chuanglan.shanyan_sdk.EnumC0060q.SDK_EXCEPTION_CODE;
                        a(enumC0060q2, enumC0060q2.b(), enumC0060q2.e(), "initStart--Exception_" + e, i, j, j2, jUptimeMillis);
                    }
                }
                com.chuanglan.shanyan_sdk.A.g().a();
                com.chuanglan.shanyan_sdk.AbstractC0055l.u.set(com.chuanglan.shanyan_sdk.AbstractC0055l.t);
                boolean zA = com.chuanglan.shanyan_sdk.p0.a(this.c, "cl_jm_f2", false);
                java.lang.String strA2 = com.chuanglan.shanyan_sdk.p0.a(this.c, "cl_jm_c3", "");
                java.lang.String strA3 = com.chuanglan.shanyan_sdk.p0.a(this.c, "cl_jm_e1", "");
                if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(this.b)) {
                    com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q3 = com.chuanglan.shanyan_sdk.EnumC0060q.APPID_NULL_CODE;
                    a(enumC0060q3, enumC0060q3.b(), enumC0060q3.e(), enumC0060q3.c(), i, j, j2, jUptimeMillis);
                    return;
                }
                try {
                    if (zA && !com.chuanglan.shanyan_sdk.AbstractC0049f.a(strA2) && this.b.equals(strA3)) {
                        if ((android.os.SystemClock.uptimeMillis() - com.chuanglan.shanyan_sdk.p0.a(this.c, "cl_jm_e9", android.os.SystemClock.uptimeMillis())) / 1000 < com.chuanglan.shanyan_sdk.p0.a(this.c, "cl_jm_b2", com.chuanglan.shanyan_sdk.AbstractC0061r.a)) {
                            com.chuanglan.shanyan_sdk.listener.InitCallbacks initCallbacks = this.a;
                            com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q4 = com.chuanglan.shanyan_sdk.EnumC0060q.INIT_CACHE_SUCCESS_CODE;
                            c3 = 1;
                            c2 = 0;
                            i2 = 2;
                            initCallbacks.initSuccessed(enumC0060q4.d(), enumC0060q4.b(), enumC0060q4.e(), enumC0060q4.c(), i, j, j2, jUptimeMillis);
                        } else {
                            c3 = 1;
                            c2 = 0;
                            i2 = 2;
                            com.chuanglan.shanyan_sdk.listener.InitCallbacks initCallbacks2 = this.a;
                            com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q5 = com.chuanglan.shanyan_sdk.EnumC0060q.INIT_CACHE_SUCCESS_CODE;
                            initCallbacks2.initSuccessed(enumC0060q5.d(), enumC0060q5.b(), enumC0060q5.e(), enumC0060q5.c(), -1, j, j2, jUptimeMillis);
                            a(i, j, j2, jUptimeMillis);
                        }
                    } else {
                        c3 = 1;
                        c2 = 0;
                        i2 = 2;
                        com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_e1", this.b);
                        a(i, j, j2, jUptimeMillis);
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    java.lang.Object[] objArr2 = new java.lang.Object[i2];
                    objArr2[c2] = "initStart Exception";
                    objArr2[c3] = e;
                    com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", objArr2);
                    com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q22 = com.chuanglan.shanyan_sdk.EnumC0060q.SDK_EXCEPTION_CODE;
                    a(enumC0060q22, enumC0060q22.b(), enumC0060q22.e(), "initStart--Exception_" + e, i, j, j2, jUptimeMillis);
                }
            } catch (java.lang.Exception e3) {
                e = e3;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            c2 = 0;
            c3 = 1;
            i2 = 2;
        }
    }

    private void a(int i, long j, long j2, long j3) throws java.lang.Throwable {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getOperatorInfo start");
        e();
        java.lang.String strF = f();
        b(strF);
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "init getOperatorData", strF, java.lang.Integer.valueOf(this.f));
        a(new com.chuanglan.shanyan_sdk.C0051h(com.chuanglan.shanyan_sdk.n0.a, this.c), i, j, j2, j3);
    }

    private void a(java.util.List list) {
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            a((java.lang.String) it.next());
        }
    }

    private void a(java.lang.String str) {
        if (com.chuanglan.shanyan_sdk.AbstractC0055l.M.contains(str)) {
            return;
        }
        com.chuanglan.shanyan_sdk.AbstractC0055l.M.add(str);
    }

    private void a(com.chuanglan.shanyan_sdk.C0051h c0051h, int i, long j, long j2, long j3) throws java.lang.Throwable {
        java.util.Map mapA = com.chuanglan.shanyan_sdk.W.a().a(this.b, this.c);
        c0051h.a(mapA, new com.chuanglan.shanyan_sdk.N.b(mapA, i, j, j2, j3), java.lang.Boolean.FALSE, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, java.lang.String str2, int i, long j, long j2, long j3) throws java.lang.Throwable {
        try {
            if (this.f == 0) {
                this.f = 1;
                b("fs.cl2009.com");
                java.lang.String str3 = com.chuanglan.shanyan_sdk.n0.a;
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "init onFailure again", str, str3.substring(0, 15), java.lang.Integer.valueOf(this.f));
                a(new com.chuanglan.shanyan_sdk.C0051h(str3, this.c), i, j, j2, j3);
            } else {
                com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.REQUEST_FAILED_CODE;
                a(enumC0060q, enumC0060q.b(), enumC0060q.e(), str2 + str, i, j, j2, j3);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q2 = com.chuanglan.shanyan_sdk.EnumC0060q.SDK_EXCEPTION_CODE;
            a(enumC0060q2, enumC0060q2.b(), enumC0060q2.e(), "getOperatorData--Exception_" + e, i, j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, int i, long j, long j2, long j3) {
        try {
            if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(str)) {
                com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.REQUEST_DATA_ERROR_CODE;
                a(enumC0060q, enumC0060q.b(), enumC0060q.e(), "result isEmpty", i, j, j2, j3);
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            int iOptInt = jSONObject.optInt("r1");
            java.lang.String strOptString = jSONObject.optString("r2");
            if (iOptInt == 0) {
                a(jSONObject, i, j, j2, j3, iOptInt, strOptString, str);
            } else {
                a(com.chuanglan.shanyan_sdk.EnumC0060q.REQUEST_DATA_ERROR_CODE, iOptInt, strOptString, str, i, j, j2, j3);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "getOperatorData Exception", e);
            com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q2 = com.chuanglan.shanyan_sdk.EnumC0060q.SDK_EXCEPTION_CODE;
            a(enumC0060q2, enumC0060q2.b(), enumC0060q2.e(), "getOperatorData--Exception_" + e, i, j, j2, j3);
        }
    }

    private void a(org.json.JSONObject jSONObject, int i, long j, long j2, long j3, int i2, java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("r3");
        if (jSONObjectOptJSONObject != null) {
            java.lang.String strOptString = jSONObjectOptJSONObject.optString("r5");
            if ("1".equals(strOptString)) {
                com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_a6", strOptString);
                com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.ACCOUNT_DISABLED_CODE;
                a(enumC0060q, enumC0060q.b(), enumC0060q.e(), enumC0060q.c(), i, j, j2, j3);
                return;
            }
            a(jSONObjectOptJSONObject);
            c(jSONObjectOptJSONObject.optString("rk"));
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_f2", true);
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_e9", android.os.SystemClock.uptimeMillis());
            com.chuanglan.shanyan_sdk.listener.InitCallbacks initCallbacks = this.a;
            com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q2 = com.chuanglan.shanyan_sdk.EnumC0060q.INIT_SUCCESS_CODE;
            initCallbacks.initSuccessed(enumC0060q2.d(), enumC0060q2.b(), enumC0060q2.e(), enumC0060q2.c(), i, j, j2, j3);
            return;
        }
        a(com.chuanglan.shanyan_sdk.EnumC0060q.REQUEST_DATA_ERROR_CODE, i2, str, str2, i, j, j2, j3);
    }

    private void a(org.json.JSONObject jSONObject) {
        java.lang.String strOptString = jSONObject.optString("r7");
        java.lang.String strOptString2 = jSONObject.optString("rt");
        java.lang.String strOptString3 = jSONObject.optString("rq");
        java.lang.String strOptString4 = jSONObject.optString("r6");
        java.lang.String strOptString5 = jSONObject.optString("rw");
        java.lang.String strOptString6 = jSONObject.optString("rp");
        java.lang.String strOptString7 = jSONObject.optString("rj");
        java.lang.String strOptString8 = jSONObject.optString("ri");
        java.lang.String strOptString9 = jSONObject.optString("rb");
        java.lang.String strOptString10 = jSONObject.optString("rd");
        java.lang.String strOptString11 = jSONObject.optString("rs");
        java.lang.String strOptString12 = jSONObject.optString("rc");
        java.lang.String strOptString13 = jSONObject.optString("r9");
        java.lang.String strOptString14 = jSONObject.optString("s2");
        java.lang.String strOptString15 = jSONObject.optString("ry");
        java.lang.String strOptString16 = jSONObject.optString("ro");
        java.lang.String strOptString17 = jSONObject.optString("rz");
        java.lang.String strOptString18 = jSONObject.optString(com.igexin.push.g.q.e);
        java.lang.String strOptString19 = jSONObject.optString("rm");
        java.lang.String strOptString20 = jSONObject.optString("rh");
        java.lang.String strOptString21 = jSONObject.optString("rn");
        java.lang.String strOptString22 = jSONObject.optString("s4");
        java.lang.String strOptString23 = jSONObject.optString("s5");
        java.lang.String strOptString24 = jSONObject.optString("s6");
        java.lang.String strOptString25 = jSONObject.optString("s7");
        com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_a9", strOptString);
        com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_c7", strOptString2);
        com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_a8", strOptString4);
        com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_c9", strOptString5);
        com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_c4", strOptString3);
        com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_c3", strOptString6);
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString25)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_g4", strOptString25);
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString20)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_b7", strOptString20);
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString22)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_g1", strOptString22);
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString23)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_g2", strOptString23);
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString24)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_g3", strOptString24);
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString19)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_c1", strOptString19);
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString17)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_d3", strOptString17);
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString18)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_d4", strOptString18);
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString16)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_c2", strOptString16);
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString21) && strOptString21.contains(com.igexin.push.core.b.an)) {
            java.lang.String[] strArrSplit = strOptString21.split(com.igexin.push.core.b.an);
            java.lang.String str = strArrSplit[0];
            java.lang.String str2 = strArrSplit[1];
            java.lang.String str3 = strArrSplit[2];
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_e6", java.lang.Integer.parseInt(str));
            int i = com.chuanglan.shanyan_sdk.AbstractC0055l.y;
            if (-1 == i) {
                com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_e7", java.lang.Integer.parseInt(str2));
                com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_e8", java.lang.Integer.parseInt(str3));
            } else {
                com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_e7", i);
                com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_e8", com.chuanglan.shanyan_sdk.AbstractC0055l.y);
            }
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString7)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_b9", java.lang.Long.parseLong(strOptString7));
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString8)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_b8", java.lang.Long.parseLong(strOptString8));
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString9)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_b4", java.lang.Integer.parseInt(strOptString9));
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString10)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_b6", java.lang.Long.parseLong(strOptString10));
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString11)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_c6", java.lang.Long.parseLong(strOptString11));
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString12)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_b5", java.lang.Long.parseLong(strOptString12));
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString13)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_b2", java.lang.Long.parseLong(strOptString13));
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString15)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_d2", strOptString15);
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strOptString14)) {
            com.chuanglan.shanyan_sdk.p0.b(this.c, "cl_jm_d7", strOptString14);
        }
    }

    private void a(com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q, int i, java.lang.String str, java.lang.String str2, int i2, long j, long j2, long j3) {
        com.chuanglan.shanyan_sdk.listener.InitCallbacks initCallbacks = this.a;
        if (initCallbacks != null) {
            initCallbacks.initFailed(enumC0060q.d(), i, str, str2, i2, j, j2, j3);
        }
    }
}
