package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class A {
    private static volatile com.chuanglan.shanyan_sdk.A n;
    private android.content.Context a;
    private java.lang.String b;
    private com.chuanglan.shanyan_sdk.I c;
    private java.util.List d;
    private java.util.List e;
    private java.util.concurrent.ExecutorService i;
    private boolean f = false;
    private int g = 10000;
    private int h = 1;
    private long j = 100;
    private int k = 0;
    private java.util.concurrent.atomic.AtomicBoolean l = new java.util.concurrent.atomic.AtomicBoolean(false);
    private final com.chuanglan.shanyan_sdk.C0067x.c m = new com.chuanglan.shanyan_sdk.A.a();

    class a implements com.chuanglan.shanyan_sdk.C0067x.c {

        /* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.A$a$a, reason: collision with other inner class name */
        class RunnableC0000a implements java.lang.Runnable {
            RunnableC0000a() {
            }

            @Override // java.lang.Runnable
            public void run() throws java.lang.Throwable {
                com.chuanglan.shanyan_sdk.Q.a("ActivityLifecycleShanYanLogger", "enterBackground");
                com.chuanglan.shanyan_sdk.A.this.d();
            }
        }

        a() {
        }

        @Override // com.chuanglan.shanyan_sdk.C0067x.c
        public void a() {
            com.chuanglan.shanyan_sdk.A.this.f().execute(new com.chuanglan.shanyan_sdk.A.a.RunnableC0000a());
        }
    }

    class b implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;
        final /* synthetic */ long i;
        final /* synthetic */ long j;
        final /* synthetic */ long k;
        final /* synthetic */ boolean l;
        final /* synthetic */ int m;

        b(int i, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3, int i3, int i4, int i5, long j, long j2, long j3, boolean z, int i6) {
            this.a = i;
            this.b = i2;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = i3;
            this.g = i4;
            this.h = i5;
            this.i = j;
            this.j = j2;
            this.k = j3;
            this.l = z;
            this.m = i6;
        }

        @Override // java.lang.Runnable
        public void run() throws java.lang.Throwable {
            try {
                if (com.chuanglan.shanyan_sdk.A.this.a != null) {
                    com.chuanglan.shanyan_sdk.A.this.b(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.chuanglan.shanyan_sdk.Q.b("NetworkShanYanLogger", "Full report processing failed", e);
            }
        }
    }

    class c implements java.lang.Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() throws java.lang.Throwable {
            com.chuanglan.shanyan_sdk.A.this.d();
        }
    }

    class d extends com.chuanglan.shanyan_sdk.AbstractC0048e {
        final /* synthetic */ boolean b;
        final /* synthetic */ org.json.JSONObject c;
        final /* synthetic */ java.lang.String d;

        d(boolean z, org.json.JSONObject jSONObject, java.lang.String str) {
            this.b = z;
            this.c = jSONObject;
            this.d = str;
        }

        @Override // com.chuanglan.shanyan_sdk.AbstractC0048e
        public void a(java.lang.String str) throws java.lang.Throwable {
            com.chuanglan.shanyan_sdk.A.this.a(str, this.b);
        }

        @Override // com.chuanglan.shanyan_sdk.AbstractC0056m
        public void a(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
            com.chuanglan.shanyan_sdk.A.this.a(str, str2, this.c, this.b, this.d);
        }
    }

    private A() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() throws java.lang.Throwable {
        try {
            this.j = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_b8", 100L);
            com.chuanglan.shanyan_sdk.I i = this.c;
            if (i != null) {
                long jC = i.c();
                com.chuanglan.shanyan_sdk.Q.a("NetworkShanYanLogger", "full reportCount", java.lang.Long.valueOf(this.j), java.lang.Long.valueOf(jC));
                if (jC > 0) {
                    this.h = (int) java.lang.Math.ceil(jC / this.j);
                    com.chuanglan.shanyan_sdk.Q.a("NetworkShanYanLogger", "full reportCount", java.lang.Long.valueOf(this.j), java.lang.Integer.valueOf(this.h));
                    k();
                    this.f = false;
                }
            }
        } catch (java.lang.Exception e) {
            com.chuanglan.shanyan_sdk.Q.b("NetworkShanYanLogger", "Background report execution failed", e);
        }
    }

    private java.lang.String e() {
        java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_c3", "");
        return com.chuanglan.shanyan_sdk.AbstractC0049f.b(strA) ? strA : this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.util.concurrent.ExecutorService f() {
        java.util.concurrent.ExecutorService executorService = this.i;
        if (executorService == null || executorService.isShutdown()) {
            this.i = new java.util.concurrent.ThreadPoolExecutor(1, Integer.MAX_VALUE, 120L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingDeque());
        }
        return this.i;
    }

    public static com.chuanglan.shanyan_sdk.A g() {
        if (n == null) {
            synchronized (com.chuanglan.shanyan_sdk.A.class) {
                if (n == null) {
                    n = new com.chuanglan.shanyan_sdk.A();
                }
            }
        }
        return n;
    }

    private long h() {
        long jA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_e2", 1L);
        if (jA != 1) {
            return jA;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_e2", jCurrentTimeMillis);
        return jCurrentTimeMillis;
    }

    private void i() {
        android.content.Context context;
        if (this.c != null || (context = this.a) == null) {
            return;
        }
        this.c = new com.chuanglan.shanyan_sdk.I(context);
    }

    private void j() {
        java.util.Iterator it = java.util.Arrays.asList("sysdk.cl2009.com", "sylogs.cl2009.com").iterator();
        while (it.hasNext()) {
            a((java.lang.String) it.next());
        }
        java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_g4", "");
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strA)) {
            a(strA);
        }
        java.lang.String strB = new com.chuanglan.shanyan_sdk.h0().b();
        if (strB != null) {
            com.chuanglan.shanyan_sdk.Q.c("NetworkShanYanLogger", "log list", com.chuanglan.shanyan_sdk.AbstractC0055l.N);
            com.chuanglan.shanyan_sdk.n0.b = "https://" + strB + "/log/fdr/v3";
        }
        com.chuanglan.shanyan_sdk.Q.a("NetworkShanYanLogger", "log upload", strB, java.lang.Boolean.valueOf(this.f));
    }

    private void k() throws java.lang.Throwable {
        try {
            com.chuanglan.shanyan_sdk.Q.c("NetworkShanYanLogger", "nonRealTimeReport");
            com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_e2", java.lang.System.currentTimeMillis());
            this.d = new java.util.ArrayList();
            long jA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_b8", 100L);
            this.j = jA;
            this.d.addAll(this.c.a(java.lang.String.valueOf(jA)));
            java.util.ArrayList arrayList = new java.util.ArrayList();
            this.e = arrayList;
            arrayList.addAll(this.c.a());
            a(true);
        } catch (java.lang.Exception e) {
            com.chuanglan.shanyan_sdk.Q.b("NetworkShanYanLogger", "Report upload failed", e);
        }
    }

    private boolean l() {
        if (!com.chuanglan.shanyan_sdk.AbstractC0055l.B || !com.chuanglan.shanyan_sdk.AbstractC0055l.D) {
            return false;
        }
        long jA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_b9", 600L);
        return (jA == -1 || jA == 0 || !"1".equals(com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_c1", "1"))) ? false : true;
    }

    private void m() throws java.lang.Throwable {
        this.j = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_b8", 100L);
        com.chuanglan.shanyan_sdk.I i = this.c;
        if (i == null || i.c() <= 0) {
            return;
        }
        this.h = (int) java.lang.Math.ceil(this.c.c() / this.j);
        k();
        this.f = false;
    }

    private com.chuanglan.shanyan_sdk.C0069z c() {
        com.chuanglan.shanyan_sdk.C0069z c0069z = new com.chuanglan.shanyan_sdk.C0069z();
        c0069z.b = "2";
        c0069z.c = com.chuanglan.shanyan_sdk.C0065v.g().a();
        c0069z.d = com.chuanglan.shanyan_sdk.C0065v.g().b();
        c0069z.e = com.chuanglan.shanyan_sdk.p0.a(this.a, com.chuanglan.shanyan_sdk.v0.a, "-1");
        c0069z.a = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_a3", "");
        return c0069z;
    }

    public void b(android.content.Context context) {
        if (context != null) {
            com.chuanglan.shanyan_sdk.C0067x.e().b((android.app.Application) context, this.m);
            com.chuanglan.shanyan_sdk.C0067x.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008c A[PHI: r3
  0x008c: PHI (r3v4 int) = (r3v6 int), (r3v7 int) binds: [B:15:0x008a, B:12:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(int r20, int r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, int r25, int r26, int r27, long r28, long r30, long r32, boolean r34, int r35) throws java.lang.Throwable {
        /*
            r19 = this;
            r15 = r19
            r13 = r25
            r14 = r27
            android.content.Context r0 = r15.a
            java.lang.String r1 = "cl_jm_b9"
            r2 = 600(0x258, double:2.964E-321)
            long r11 = com.chuanglan.shanyan_sdk.p0.a(r0, r1, r2)
            java.lang.Long r0 = java.lang.Long.valueOf(r11)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r25)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r26)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r20)
            boolean r4 = com.chuanglan.shanyan_sdk.AbstractC0055l.B
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r27)
            r6 = 8
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r16 = 0
            java.lang.String r7 = "full params"
            r6[r16] = r7
            r9 = 1
            r6[r9] = r0
            r0 = 2
            r6[r0] = r1
            r0 = 3
            r6[r0] = r2
            r10 = 4
            r6[r10] = r3
            r0 = 5
            r6[r0] = r4
            r0 = 6
            r6[r0] = r23
            r0 = 7
            r6[r0] = r5
            java.lang.String r0 = "NetworkShanYanLogger"
            com.chuanglan.shanyan_sdk.Q.a(r0, r6)
            r0 = -1
            int r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r0 == 0) goto La7
            boolean r0 = com.chuanglan.shanyan_sdk.AbstractC0055l.B
            if (r0 != 0) goto L59
            goto La7
        L59:
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r26
            r8 = r27
            r9 = r28
            r17 = r11
            r11 = r30
            r13 = r32
            r15 = r35
            com.chuanglan.shanyan_sdk.y r0 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r15)
            r1 = r26
            r2 = 1
            if (r1 != r2) goto L88
            r1 = r27
            if (r1 != 0) goto L88
            r3 = r25
            r4 = 4
            if (r3 == r4) goto L8a
            goto L8c
        L88:
            r3 = r25
        L8a:
            if (r34 == 0) goto L90
        L8c:
            r5 = r19
            r1 = r2
            goto L94
        L90:
            r5 = r19
            r1 = r16
        L94:
            r5.a(r0, r1)
            if (r3 != r2) goto La6
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.l
            boolean r0 = r0.getAndSet(r2)
            if (r0 != 0) goto La6
            r0 = r17
            r5.a(r0)
        La6:
            return
        La7:
            r2 = r9
            r4 = r10
            r3 = r13
            r1 = r14
            r5 = r15
            if (r3 == r4) goto Lb2
            r0 = 11
            if (r3 != r0) goto Lbd
        Lb2:
            if (r1 != r2) goto Lbd
            android.content.Context r0 = r5.a
            java.lang.String r1 = "cl_jm_a2"
            java.lang.String r2 = ""
            com.chuanglan.shanyan_sdk.p0.b(r0, r1, r2)
        Lbd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuanglan.shanyan_sdk.A.b(int, int, java.lang.String, java.lang.String, java.lang.String, int, int, int, long, long, long, boolean, int):void");
    }

    public void a(android.content.Context context, java.lang.String str) {
        this.a = context.getApplicationContext();
        this.b = str;
    }

    public void a() {
        try {
            if (l()) {
                com.chuanglan.shanyan_sdk.Q.a("ActivityLifecycleShanYanLogger", "shouldEnable");
                if (this.a != null) {
                    com.chuanglan.shanyan_sdk.C0067x.e().b((android.app.Application) this.a, this.m);
                    com.chuanglan.shanyan_sdk.C0067x.e().a((android.app.Application) this.a, this.m);
                }
            }
        } catch (java.lang.Exception e) {
            com.chuanglan.shanyan_sdk.Q.b("NetworkShanYanLogger", "Background report setup failed", e);
        }
    }

    public void a(android.content.Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
            com.chuanglan.shanyan_sdk.C0067x.e().a((android.app.Application) context, this.m);
        }
    }

    public void a(int i, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3, int i3, int i4, int i5, long j, long j2, long j3, boolean z, int i6) {
        f().execute(new com.chuanglan.shanyan_sdk.A.b(i, i2, str, str2, str3, i3, i4, i5, j, j2, j3, z, i6));
    }

    private com.chuanglan.shanyan_sdk.C0068y a(int i, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3, int i3, int i4, int i5, long j, long j2, long j3, int i6) {
        com.chuanglan.shanyan_sdk.C0068y c0068y = new com.chuanglan.shanyan_sdk.C0068y();
        c0068y.b = str3;
        c0068y.h = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_a2", "");
        c0068y.d = "JC";
        c0068y.e = com.chuanglan.shanyan_sdk.C0065v.g().f();
        c0068y.f = com.chuanglan.shanyan_sdk.C0065v.g().h();
        c0068y.g = "2.3.7.7";
        c0068y.m = i3;
        c0068y.n = i4;
        c0068y.o = j;
        c0068y.p = j3;
        c0068y.q = j2;
        c0068y.r = i5;
        c0068y.s = i;
        c0068y.t = com.chuanglan.shanyan_sdk.AbstractC0049f.a(i, str);
        c0068y.u = i2;
        c0068y.v = str2;
        c0068y.w = i6;
        c0068y.k = "-1";
        c0068y.l = "-1";
        c0068y.c = -1;
        c0068y.i = "-1";
        c0068y.j = "-1";
        if (i3 == 4 || i3 == 11) {
            a(c0068y, i5);
        }
        return c0068y;
    }

    private void b(org.json.JSONObject jSONObject) {
        org.json.JSONArray jSONArrayOptJSONArray;
        try {
            org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("r3");
            if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("r4")) != null && jSONArrayOptJSONArray.length() != 0) {
                java.lang.String strOptString = ((org.json.JSONObject) jSONArrayOptJSONArray.get(0)).optString("r8");
                if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(strOptString)) {
                    return;
                }
                boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("r5");
                com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_b1", strOptString);
                com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_a7", zOptBoolean);
                if (zOptBoolean) {
                    com.chuanglan.shanyan_sdk.AbstractC0055l.M.remove(strOptString);
                    com.chuanglan.shanyan_sdk.AbstractC0055l.M.add(0, strOptString);
                } else if (!com.chuanglan.shanyan_sdk.AbstractC0055l.M.contains(strOptString)) {
                    com.chuanglan.shanyan_sdk.AbstractC0055l.M.add(strOptString);
                }
            }
        } catch (java.lang.Exception e) {
            com.chuanglan.shanyan_sdk.Q.b("NetworkShanYanLogger", "Domain initialization failed", e);
        }
    }

    private void a(com.chuanglan.shanyan_sdk.C0068y c0068y, int i) {
        c0068y.i = com.chuanglan.shanyan_sdk.C0065v.g().d();
        c0068y.j = java.lang.String.valueOf(com.chuanglan.shanyan_sdk.AbstractC0059p.j(this.a));
        if (com.chuanglan.shanyan_sdk.AbstractC0055l.O && !"-1".equals(com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_d4", "0"))) {
            c0068y.c = com.chuanglan.shanyan_sdk.C0065v.g().e(this.a);
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0059p.g(this.a)) {
            c0068y.k = "0";
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0059p.c(this.a)) {
            c0068y.l = "0";
        }
        if (i == 1) {
            com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_a2", "");
        }
    }

    private void b() throws java.lang.Throwable {
        try {
            com.chuanglan.shanyan_sdk.I i = this.c;
            if (i == null || !i.a(this.g)) {
                return;
            }
            this.c.a(java.lang.String.valueOf((int) (((double) this.g) * 0.1d)));
            com.chuanglan.shanyan_sdk.I i2 = this.c;
            i2.a(i2.b());
        } catch (java.lang.Exception e) {
            com.chuanglan.shanyan_sdk.Q.b("NetworkShanYanLogger", "DB count check failed", e);
        }
    }

    private void a(long j) {
        if (j != 0) {
            long j2 = java.lang.Long.parseLong(com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_b7", "120"));
            if (j2 > 0) {
                android.os.HandlerThread handlerThread = new android.os.HandlerThread("ReportHandlerThread");
                handlerThread.start();
                new android.os.Handler(handlerThread.getLooper()).postDelayed(new com.chuanglan.shanyan_sdk.A.c(), j2 * 1000);
            }
        }
    }

    private void a(com.chuanglan.shanyan_sdk.C0068y c0068y, boolean z) throws java.lang.Throwable {
        if (com.chuanglan.shanyan_sdk.AbstractC0055l.B) {
            try {
                i();
                com.chuanglan.shanyan_sdk.C0069z c0069zC = c();
                c0068y.a = c0069zC.a;
                c0068y.x = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_f5", "-1");
                long jA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_b9", 600L);
                if (jA == -1) {
                    return;
                }
                long jH = h();
                if (jA == 0) {
                    a(c0069zC, c0068y);
                } else {
                    this.c.a(c0069zC);
                    this.c.a(c0068y, z);
                    if (a(c0068y.m, jH, jA)) {
                        m();
                    }
                }
            } catch (java.lang.Exception e) {
                com.chuanglan.shanyan_sdk.Q.b("NetworkShanYanLogger", "Full report failed", e);
            }
        }
    }

    private boolean a(int i, long j, long j2) {
        return i == 4 || i == 11 || java.lang.System.currentTimeMillis() > j + (j2 * 1000);
    }

    private void a(com.chuanglan.shanyan_sdk.C0069z c0069z, com.chuanglan.shanyan_sdk.C0068y c0068y) throws java.lang.Throwable {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            this.d = arrayList;
            arrayList.add(c0068y);
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            this.e = arrayList2;
            arrayList2.add(c0069z);
            a(false);
        } catch (java.lang.Exception e) {
            com.chuanglan.shanyan_sdk.Q.b("NetworkShanYanLogger", "Real-time report upload failed", e);
        }
    }

    private void a(boolean z) throws java.lang.Throwable {
        com.chuanglan.shanyan_sdk.Q.c("NetworkShanYanLogger", "reportUpload");
        java.util.List list = this.d;
        if (list == null || this.e == null || list.isEmpty() || this.e.isEmpty()) {
            return;
        }
        org.json.JSONArray jSONArrayA = com.chuanglan.shanyan_sdk.AbstractC0045b.a(this.d);
        org.json.JSONArray jSONArrayB = com.chuanglan.shanyan_sdk.AbstractC0045b.b(this.e);
        com.chuanglan.shanyan_sdk.Q.c("NetworkShanYanLogger", "deviceJsonArray");
        if (jSONArrayA.length() == 0 || jSONArrayB.length() == 0) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("a4", jSONArrayA);
        jSONObject.put("a2", new org.json.JSONArray("[\"i4\", \"bk\",\"bp\", \"bm\", \"b2\", \"bc\", \"bh\", \"ba\", \"b7\", \"bi\", \"b8\",\"bg\", \"bj\", \"bb\", \"bl\", \"b5\", \"b1\", \"b4\", \"be\", \"b3\", \"b6\", \"bd\", \"b9\", \"bf\"]"));
        jSONObject.put("a3", jSONArrayB);
        jSONObject.put("a1", new org.json.JSONArray("[\"i4\", \"i8\", \"i1\", \"i7\", \"i9\"]"));
        com.chuanglan.shanyan_sdk.Q.c("NetworkShanYanLogger", "full upload", java.lang.Boolean.valueOf(z), java.lang.Integer.valueOf(jSONArrayA.length()), java.lang.Integer.valueOf(this.d.size()), java.lang.Integer.valueOf(jSONArrayB.length()), java.lang.Integer.valueOf(this.e.size()));
        j();
        a(new com.chuanglan.shanyan_sdk.C0051h(com.chuanglan.shanyan_sdk.n0.b, this.a), jSONObject, z, "");
    }

    private void a(java.lang.String str) {
        if (com.chuanglan.shanyan_sdk.AbstractC0055l.N.contains(str)) {
            return;
        }
        com.chuanglan.shanyan_sdk.AbstractC0055l.N.add(str);
    }

    private void a(com.chuanglan.shanyan_sdk.C0051h c0051h, org.json.JSONObject jSONObject, boolean z, java.lang.String str) throws java.lang.Throwable {
        this.g = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_b4", 10000);
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(str)) {
            str = com.chuanglan.shanyan_sdk.AbstractC0047d.a();
        }
        java.lang.String strE = e();
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "log request id", strE);
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(strE)) {
            java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_d2", "0MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJaqWkyQhbQ6EbYBFaxhfblDc3wmzSV27D/CncV6b1dG9DW/9rPqKLP9TvpcxA8OTgQR/WZ1YKwtcHJurR83spkCAwEAAQ==");
            java.util.Map mapA = com.chuanglan.shanyan_sdk.W.a().a(strE, str, jSONObject, this.a);
            com.chuanglan.shanyan_sdk.Q.c("NetworkShanYanLogger", "map", mapA);
            c0051h.a(mapA, new com.chuanglan.shanyan_sdk.A.d(z, jSONObject, str), java.lang.Boolean.TRUE, strA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, boolean z) throws java.lang.Throwable {
        try {
            com.chuanglan.shanyan_sdk.Q.c("NetworkShanYanLogger", "onSuccess", str);
            if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(str)) {
                if (z) {
                    b();
                    return;
                }
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (jSONObject.optInt("r1") == 0) {
                if (z) {
                    a(jSONObject);
                }
                b(jSONObject);
            } else if (z) {
                b();
            }
        } catch (org.json.JSONException e) {
            com.chuanglan.shanyan_sdk.Q.b("NetworkShanYanLogger", "Response parsing failed", e);
            if (z) {
                b();
            }
        }
    }

    private void a(org.json.JSONObject jSONObject) throws java.lang.Throwable {
        int i;
        com.chuanglan.shanyan_sdk.I i2 = this.c;
        if (i2 != null) {
            i2.a(i2.b());
            this.h--;
        }
        if (this.h <= 0 || (i = this.k) >= 10) {
            return;
        }
        this.k = i + 1;
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, boolean z, java.lang.String str3) throws java.lang.Throwable {
        try {
            com.chuanglan.shanyan_sdk.Q.c("NetworkShanYanLogger", "onFailure", str, str2);
            if (!this.f) {
                this.f = true;
                com.chuanglan.shanyan_sdk.C0051h c0051h = new com.chuanglan.shanyan_sdk.C0051h("https://sylogs.cl2009.com/log/fdr/v3", this.a);
                com.chuanglan.shanyan_sdk.Q.a("NetworkShanYanLogger", "log again", "sylogs.cl2009.com", java.lang.Boolean.valueOf(this.f));
                a(c0051h, jSONObject, z, str3);
            } else if (z) {
                b();
            }
        } catch (java.lang.Exception e) {
            com.chuanglan.shanyan_sdk.Q.b("NetworkShanYanLogger", "Failure handling failed", e);
        }
    }
}
