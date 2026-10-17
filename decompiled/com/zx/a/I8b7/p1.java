package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class p1 {
    public static volatile com.zx.a.I8b7.g2 i;
    public static volatile com.zx.a.I8b7.g2 j;
    public volatile int a;
    public volatile int b;
    public final java.util.concurrent.atomic.AtomicBoolean c = new java.util.concurrent.atomic.AtomicBoolean(false);
    public volatile java.lang.String d;
    public volatile long e;
    public volatile long f;
    public volatile long g;
    public com.zx.a.I8b7.h2 h;

    public class a implements android.app.Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: com.zx.a.I8b7.p1$a$a, reason: collision with other inner class name */
        public class RunnableC0033a implements java.lang.Runnable {
            public RunnableC0033a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.zx.a.I8b7.p1.a(com.zx.a.I8b7.p1.this);
                } catch (java.lang.Throwable unused) {
                }
            }
        }

        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(android.app.Activity activity) {
            try {
                com.zx.a.I8b7.i4.f.a.e.execute(new com.zx.a.I8b7.p1.a.RunnableC0033a());
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(android.app.Activity activity) {
            try {
                com.zx.a.I8b7.p1 p1Var = com.zx.a.I8b7.p1.this;
                p1Var.e = p1Var.a();
                com.zx.a.I8b7.p1 p1Var2 = com.zx.a.I8b7.p1.this;
                p1Var2.f = p1Var2.a();
                com.zx.a.I8b7.p1.this.d = activity.getClass().getName();
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
        }
    }

    public static final class b {
        public static final com.zx.a.I8b7.p1 a = new com.zx.a.I8b7.p1();
    }

    public final void a(long j2) throws org.json.JSONException {
        java.lang.String strA = com.zx.a.I8b7.w2.a.a.a.a(61);
        if (android.text.TextUtils.isEmpty(strA)) {
            i = new com.zx.a.I8b7.g2();
        } else {
            i = new com.zx.a.I8b7.g2(strA);
        }
        java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("read appRt = ");
        sbA.append(i);
        com.zx.a.I8b7.c3.a(sbA.toString());
        i.put(j2 + "#0");
        this.a = i.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() throws org.json.JSONException {
        /*
            r5 = this;
            android.content.Context r0 = com.zx.a.I8b7.x3.a
            android.content.Context r0 = r0.getApplicationContext()
            boolean r0 = r0 instanceof android.app.Application
            if (r0 == 0) goto Laf
            android.content.Context r0 = com.zx.a.I8b7.x3.a
            android.content.Context r0 = r0.getApplicationContext()
            android.app.Application r0 = (android.app.Application) r0
            com.zx.a.I8b7.h2 r1 = new com.zx.a.I8b7.h2
            r1.<init>()
            r5.h = r1
            long r1 = r5.a()
            r5.e = r1
            long r1 = r5.a()
            r5.f = r1
            android.content.Context r1 = com.zx.a.I8b7.x3.a     // Catch: java.lang.Exception -> L5f
            android.content.pm.PackageManager r1 = com.zx.a.I8b7.j4.d(r1)     // Catch: java.lang.Exception -> L5f
            android.content.Intent r2 = new android.content.Intent     // Catch: java.lang.Exception -> L5f
            java.lang.String r3 = "android.intent.action.MAIN"
            r4 = 0
            r2.<init>(r3, r4)     // Catch: java.lang.Exception -> L5f
            java.lang.String r3 = "android.intent.category.LAUNCHER"
            r2.addCategory(r3)     // Catch: java.lang.Exception -> L5f
            java.lang.String r3 = com.zx.a.I8b7.x3.g     // Catch: java.lang.Exception -> L5f
            r2.setPackage(r3)     // Catch: java.lang.Exception -> L5f
            r3 = 0
            java.util.List r1 = r1.queryIntentActivities(r2, r3)     // Catch: java.lang.Exception -> L5f
            if (r1 == 0) goto L63
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Exception -> L5f
            if (r2 != 0) goto L63
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L5f
            boolean r2 = r1.hasNext()     // Catch: java.lang.Exception -> L5f
            if (r2 == 0) goto L63
            java.lang.Object r1 = r1.next()     // Catch: java.lang.Exception -> L5f
            android.content.pm.ResolveInfo r1 = (android.content.pm.ResolveInfo) r1     // Catch: java.lang.Exception -> L5f
            android.content.pm.ActivityInfo r1 = r1.activityInfo     // Catch: java.lang.Exception -> L5f
            java.lang.String r1 = r1.name     // Catch: java.lang.Exception -> L5f
            goto L65
        L5f:
            r1 = move-exception
            com.zx.a.I8b7.c3.a(r1)
        L63:
            java.lang.String r1 = "ZX_MainActivity"
        L65:
            r5.d = r1
            com.zx.a.I8b7.w2 r1 = com.zx.a.I8b7.w2.a.a
            com.zx.a.I8b7.h4 r1 = r1.a
            r2 = 62
            java.lang.String r1 = r1.a(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L7f
            com.zx.a.I8b7.g2 r2 = new com.zx.a.I8b7.g2
            r2.<init>(r1)
            com.zx.a.I8b7.p1.j = r2
            goto L86
        L7f:
            com.zx.a.I8b7.g2 r1 = new com.zx.a.I8b7.g2
            r1.<init>()
            com.zx.a.I8b7.p1.j = r1
        L86:
            java.lang.String r1 = "read tabRT = "
            java.lang.StringBuilder r1 = com.zx.a.I8b7.q3.a(r1)
            com.zx.a.I8b7.g2 r2 = com.zx.a.I8b7.p1.j
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.zx.a.I8b7.c3.a(r1)
            com.zx.a.I8b7.g2 r1 = com.zx.a.I8b7.p1.j
            com.zx.a.I8b7.h2 r2 = r5.h
            r1.put(r2)
            com.zx.a.I8b7.g2 r1 = com.zx.a.I8b7.p1.j
            int r1 = r1.length()
            r5.b = r1
            com.zx.a.I8b7.p1$a r1 = new com.zx.a.I8b7.p1$a
            r1.<init>()
            r0.registerActivityLifecycleCallbacks(r1)
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.p1.b():void");
    }

    public static void a(com.zx.a.I8b7.p1 p1Var, long j2, long j3) throws java.lang.Throwable {
        p1Var.getClass();
        long j4 = j3 - j2;
        try {
            int length = i.length() - 1;
            if (length >= 0) {
                i.put(length, j2 + "#" + j4);
            }
            com.zx.a.I8b7.w2 w2Var = com.zx.a.I8b7.w2.a.a;
            com.zx.a.I8b7.h4 h4Var = w2Var.a;
            com.zx.a.I8b7.g2 g2Var = i;
            h4Var.getClass();
            if (g2Var == null) {
                return;
            }
            w2Var.a.a(61, g2Var.toString(), true);
            com.zx.a.I8b7.c3.a("appRt had changed refresh:" + g2Var);
        } catch (java.lang.Throwable th) {
            java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("dealAppRT ex:");
            sbA.append(th.getMessage());
            com.zx.a.I8b7.c3.b(sbA.toString());
        }
    }

    public static void a(com.zx.a.I8b7.p1 p1Var) throws java.lang.Throwable {
        com.zx.a.I8b7.g2 g2Var;
        p1Var.getClass();
        try {
            if (j != null && j.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8).length <= 512000) {
                java.lang.Object objOpt = p1Var.h.opt(p1Var.d);
                long j2 = p1Var.f - p1Var.e;
                if (j2 <= 0) {
                    j2 = 1;
                }
                if (objOpt != null && (objOpt instanceof com.zx.a.I8b7.g2)) {
                    g2Var = (com.zx.a.I8b7.g2) objOpt;
                    int iA = g2Var.a(p1Var.e + "");
                    if (iA != -1) {
                        g2Var.put(iA, p1Var.e + "#" + j2);
                    } else {
                        g2Var.put(p1Var.e + "#" + j2);
                    }
                } else {
                    g2Var = new com.zx.a.I8b7.g2();
                    g2Var.put(p1Var.e + "#" + j2);
                }
                p1Var.h.put(p1Var.d, g2Var);
                int length = j.length() - 1;
                if (length >= 0) {
                    j.remove(length);
                }
                j.put(p1Var.h);
                com.zx.a.I8b7.w2 w2Var = com.zx.a.I8b7.w2.a.a;
                com.zx.a.I8b7.h4 h4Var = w2Var.a;
                com.zx.a.I8b7.g2 g2Var2 = j;
                h4Var.getClass();
                if (g2Var2 == null) {
                    return;
                }
                w2Var.a.a(62, g2Var2.toString(), true);
                com.zx.a.I8b7.c3.a("TABRt had changed refresh:" + g2Var2);
            }
        } catch (java.lang.Throwable th) {
            java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("dealTabRT ex:");
            sbA.append(th.getMessage());
            com.zx.a.I8b7.c3.b(sbA.toString());
        }
    }

    public final long a() {
        return java.lang.System.currentTimeMillis() / 1000;
    }
}
