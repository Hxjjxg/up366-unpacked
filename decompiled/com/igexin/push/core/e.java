package com.igexin.push.core;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class e {
    public static java.lang.String A = null;
    public static java.lang.String B = null;
    public static java.lang.String C = null;
    public static java.lang.String D = null;
    public static java.lang.String E = null;
    public static java.lang.String F = null;
    public static java.lang.String G = null;
    public static java.lang.String H = null;
    public static java.lang.String I = null;
    public static java.lang.String K = null;
    public static java.lang.String L = null;
    public static java.lang.String M = null;
    public static java.lang.String Z = null;
    public static java.lang.String a = "";
    public static int aA = 0;
    public static byte[] aB = null;
    public static long aH = 0;
    public static java.lang.String aN = null;
    private static final java.lang.String aP = "CoreRuntimeInfo";
    private static java.util.Map<java.lang.String, java.lang.Integer> aQ = null;
    public static java.lang.String ac = null;
    public static byte[] ad = null;
    public static boolean ae = false;
    public static boolean af = false;
    public static boolean ag = false;
    public static volatile java.util.Map<java.lang.String, com.igexin.push.extension.mod.PushTaskBean> ah = null;
    public static java.util.Map<java.lang.String, java.lang.Integer> ai = null;
    public static java.util.Map<java.lang.String, java.util.HashSet<java.lang.String>> aj = null;
    public static java.util.Map<java.lang.String, java.lang.Integer> ak = null;
    public static java.util.HashMap<java.lang.String, java.lang.Long> al = null;
    public static java.lang.String an = null;
    public static long ao = 0;
    public static java.lang.String ap = null;
    public static java.lang.String aq = null;
    public static java.lang.String ar = null;
    public static java.lang.String as = null;
    public static java.lang.String at = null;
    public static java.lang.String au = null;
    public static long av = 0;
    public static long aw = 0;
    public static volatile long ax = 0;
    public static long ay = 0;
    public static boolean az = false;
    public static java.lang.String b = "";
    public static long c = 0;
    public static java.lang.String d = null;
    public static java.lang.String e = null;
    public static java.lang.String f = "";
    public static java.lang.String g = "";
    public static java.lang.String h = null;
    public static java.lang.String i = "";
    public static int j;
    public static int k;
    public static android.content.Context l;
    public static volatile boolean s;
    public static volatile boolean u;
    public static volatile boolean v;
    public static java.util.concurrent.atomic.AtomicBoolean m = new java.util.concurrent.atomic.AtomicBoolean(false);
    public static boolean n = true;
    public static java.util.HashMap<java.lang.String, java.lang.ClassLoader> o = new java.util.HashMap<>();
    public static volatile boolean p = true;
    public static volatile boolean q = false;
    public static int r = 0;
    public static boolean t = true;
    public static java.util.concurrent.atomic.AtomicBoolean w = new java.util.concurrent.atomic.AtomicBoolean(true);
    public static int x = 0;
    public static int y = 0;
    public static long z = 0;
    public static int J = -1;
    public static java.lang.String N = "";
    public static long O = -1;
    public static long P = -1;
    public static long Q = 0;
    public static long R = 0;
    public static long S = 0;
    public static long T = 0;
    public static long U = 0;
    public static java.lang.String V = null;
    public static boolean W = false;
    public static long X = 0;
    public static long Y = 0;
    public static long aa = 0;
    public static int ab = 0;
    public static int am = 0;
    public static java.lang.String aC = null;
    public static int aD = 3600;
    public static boolean aE = false;
    public static long aF = 7200000;
    public static long aG = 7200000;
    public static java.lang.String aI = "oppo r9";
    public static int aJ = 200;
    public static java.lang.String aK = "";
    public static java.lang.String aL = "";
    private static java.lang.String aR = "";
    public static boolean aM = false;
    public static java.lang.String aO = "";

    public static int a(java.lang.String str) {
        int iIntValue;
        synchronized (com.igexin.push.core.e.class) {
            if (aQ.get(str) == null) {
                aQ.put(str, 0);
            }
            iIntValue = aQ.get(str).intValue() - 1;
            aQ.put(str, java.lang.Integer.valueOf(iIntValue));
            if (iIntValue == 0) {
                aQ.remove(str);
            }
        }
        return iIntValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a() {
        /*
            com.igexin.push.core.ServiceManager.getInstance()
            android.content.Context r0 = com.igexin.push.core.e.l
            java.lang.String r0 = com.igexin.push.core.ServiceManager.d(r0)
            com.igexin.push.core.ServiceManager.getInstance()
            android.content.Context r1 = com.igexin.push.core.e.l
            java.lang.String r1 = com.igexin.push.core.ServiceManager.e(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L2a
            if (r2 != 0) goto L2e
            java.lang.Class r2 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L2a
            java.lang.Class<com.igexin.sdk.PushService> r3 = com.igexin.sdk.PushService.class
            if (r2 == r3) goto L28
            java.lang.Class<com.igexin.sdk.PushService> r3 = com.igexin.sdk.PushService.class
            boolean r2 = r3.isAssignableFrom(r2)     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L2e
        L28:
            r1 = 0
            goto L2e
        L2a:
            r2 = move-exception
            com.igexin.c.a.c.a.a(r2)
        L2e:
            java.lang.Class<com.igexin.sdk.GService> r2 = com.igexin.sdk.GService.class
            java.lang.String r2 = r2.getName()
            java.lang.String[] r0 = new java.lang.String[]{r0, r1, r2}
            int r1 = com.igexin.push.config.e.b()
            r2 = 0
        L3d:
            r3 = 3
            if (r2 >= r3) goto L6a
            r3 = r0[r2]
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L67
            android.content.ComponentName r4 = new android.content.ComponentName     // Catch: java.lang.Throwable -> L63
            android.content.Context r5 = com.igexin.push.core.e.l     // Catch: java.lang.Throwable -> L63
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> L63
            android.content.Context r3 = com.igexin.push.core.e.l     // Catch: java.lang.Throwable -> L63
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch: java.lang.Throwable -> L63
            r5 = -1
            r6 = 1
            if (r1 == r5) goto L5e
            if (r1 != r6) goto L5c
            goto L5e
        L5c:
            r5 = 2
            goto L5f
        L5e:
            r5 = r6
        L5f:
            r3.setComponentEnabledSetting(r4, r5, r6)     // Catch: java.lang.Throwable -> L63
            goto L67
        L63:
            r3 = move-exception
            com.igexin.c.a.c.a.a(r3)
        L67:
            int r2 = r2 + 1
            goto L3d
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.e.a():void");
    }

    public static void a(long j2) {
        z = j2;
        A = com.igexin.c.b.a.b(java.lang.String.valueOf(j2));
    }

    public static void a(java.lang.String str, long j2) {
        com.igexin.c.a.c.a.b(str, " set delayTime = ".concat(java.lang.String.valueOf(j2)));
        O = j2;
    }

    public static boolean a(android.content.Context context) throws java.lang.Throwable {
        l = context;
        g = context.getPackageName();
        i = com.igexin.push.g.q.b(context, com.igexin.push.g.q.e, "").toString();
        ac = "getui.permission.GetuiService." + g;
        if (!e()) {
            com.igexin.c.a.c.a.a(aP, "parseManifests failed");
            com.igexin.c.a.c.a.a("CoreRuntimeInfo|parseManifests failed", new java.lang.Object[0]);
            throw new java.lang.IllegalArgumentException("parseManifests failed");
        }
        ad = com.igexin.c.b.a.b(a + context.getPackageName()).getBytes();
        com.igexin.push.g.k.a();
        com.igexin.push.config.e.a();
        a();
        if (android.os.Build.VERSION.SDK_INT < 29) {
            java.lang.System.currentTimeMillis();
            D = com.igexin.push.g.o.g();
            java.lang.System.currentTimeMillis();
            E = com.igexin.push.g.o.f();
            java.lang.System.currentTimeMillis();
        }
        F = com.igexin.push.g.o.e();
        G = com.igexin.push.g.o.d();
        n = com.igexin.push.g.c.e();
        ah = new java.util.concurrent.ConcurrentHashMap();
        ai = new java.util.concurrent.ConcurrentHashMap();
        aj = new java.util.HashMap();
        ak = new java.util.HashMap();
        al = new java.util.HashMap<>();
        com.igexin.push.g.g.c = new java.lang.String(com.igexin.push.a.j.getBytes(java.nio.charset.StandardCharsets.UTF_8), java.nio.charset.StandardCharsets.UTF_8);
        s = com.igexin.push.core.d.d.a().b(com.igexin.push.core.d.d.f);
        aQ = new java.util.HashMap();
        az = true;
        com.igexin.c.a.c.a.a("CoreRuntimeInfo|getui sdk init success ##########", new java.lang.Object[0]);
        if (new com.igexin.sdk.main.SdkInitSwitch(l).isSwitchOn()) {
            com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.e, java.lang.Boolean.TRUE);
            new com.igexin.sdk.main.SdkInitSwitch(l).delete();
        }
        if (new com.igexin.sdk.main.SdkPushSwitch(l).isSwitchOn()) {
            s = true;
            com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.f, java.lang.Boolean.TRUE);
            new com.igexin.sdk.main.SdkPushSwitch(l).delete();
        }
        return true;
    }

    public static boolean a(java.lang.String str, java.lang.Integer num) {
        synchronized (com.igexin.push.core.e.class) {
            int iIntValue = num.intValue();
            if (aQ.get(str) == null || (iIntValue = aQ.get(str).intValue() + num.intValue()) != 0) {
                aQ.put(str, java.lang.Integer.valueOf(iIntValue));
                return true;
            }
            aQ.remove(str);
            return false;
        }
    }

    public static java.lang.Boolean b() {
        return java.lang.Boolean.valueOf(aR.equals("*"));
    }

    public static java.lang.ClassLoader b(java.lang.String str) {
        java.lang.String str2 = str.split("_")[0];
        if (o.containsKey(str2)) {
            return o.get(str2);
        }
        return null;
    }

    private static void c() {
        if (new com.igexin.sdk.main.SdkInitSwitch(l).isSwitchOn()) {
            com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.e, java.lang.Boolean.TRUE);
            new com.igexin.sdk.main.SdkInitSwitch(l).delete();
        }
        if (new com.igexin.sdk.main.SdkPushSwitch(l).isSwitchOn()) {
            s = true;
            com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.f, java.lang.Boolean.TRUE);
            new com.igexin.sdk.main.SdkPushSwitch(l).delete();
        }
    }

    private static java.lang.String d() {
        return com.igexin.push.config.SDKUrlConfig.getConfigServiceUrl();
    }

    private static boolean e() {
        try {
            android.content.pm.ApplicationInfo applicationInfoB = com.igexin.push.g.o.b(l);
            if (applicationInfoB == null || applicationInfoB.metaData == null) {
                return false;
            }
            java.lang.String strA = com.igexin.push.g.d.a(applicationInfoB);
            if (android.text.TextUtils.isEmpty(strA)) {
                strA = applicationInfoB.metaData.getString(com.igexin.push.core.b.b);
            }
            if (android.text.TextUtils.isEmpty(strA)) {
                strA = applicationInfoB.metaData.getString("GETUI_APPID");
            }
            if (strA != null) {
                strA = strA.trim();
            }
            b = applicationInfoB.metaData.getString(com.igexin.push.core.b.d);
            java.lang.String string = applicationInfoB.metaData.getString(com.igexin.push.core.b.e);
            if (string != null) {
                aR = string;
            }
            try {
                java.lang.String strValueOf = java.lang.String.valueOf(applicationInfoB.metaData.get(com.igexin.push.core.b.aC));
                aO = strValueOf;
                if (!android.text.TextUtils.isEmpty(strValueOf) && aO.contains("=")) {
                    java.lang.String str = aO;
                    aO = str.substring(str.lastIndexOf("=") + 1);
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
            if (android.text.TextUtils.isEmpty(strA)) {
                com.igexin.c.a.c.a.a(aP, "getui sdk init error, missing parm ######");
                com.igexin.c.a.c.a.a("CoreRuntimeInfo|getui sdk init error, missing parm #####", new java.lang.Object[0]);
                return false;
            }
            a = strA;
            f = com.igexin.push.config.SDKUrlConfig.getLocation();
            return true;
        } catch (java.lang.Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
            return false;
        }
    }

    private static void f() {
        if (android.os.Build.VERSION.SDK_INT < 29) {
            java.lang.System.currentTimeMillis();
            D = com.igexin.push.g.o.g();
            java.lang.System.currentTimeMillis();
            E = com.igexin.push.g.o.f();
            java.lang.System.currentTimeMillis();
        }
        F = com.igexin.push.g.o.e();
        G = com.igexin.push.g.o.d();
    }
}
