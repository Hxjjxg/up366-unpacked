package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class t0 {
    private static volatile com.chuanglan.shanyan_sdk.t0 q;
    private android.content.Context a;
    private com.chuanglan.shanyan_sdk.listener.OpenLoginAuthListener e;
    private com.chuanglan.shanyan_sdk.listener.OneKeyLoginListener f;
    private com.chuanglan.shanyan_sdk.listener.ActionListener g;
    private java.util.concurrent.ExecutorService h;
    private android.view.ViewGroup i;
    private android.widget.CheckBox m;
    private android.widget.Button n;
    private boolean o;
    private volatile java.util.concurrent.CopyOnWriteArrayList b = new java.util.concurrent.CopyOnWriteArrayList();
    private volatile java.util.concurrent.CopyOnWriteArrayList c = new java.util.concurrent.CopyOnWriteArrayList();
    private volatile java.util.concurrent.CopyOnWriteArrayList d = new java.util.concurrent.CopyOnWriteArrayList();
    private com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig j = null;
    private com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig k = null;
    private com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig l = null;
    private final java.util.concurrent.atomic.AtomicBoolean p = new java.util.concurrent.atomic.AtomicBoolean(true);

    class a implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        a(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.chuanglan.shanyan_sdk.a0.b().c(this.a);
        }
    }

    class b implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ int e;
        final /* synthetic */ java.lang.String f;
        final /* synthetic */ int g;
        final /* synthetic */ long h;
        final /* synthetic */ long i;
        final /* synthetic */ long j;

        b(int i, int i2, java.lang.String str, java.lang.String str2, int i3, java.lang.String str3, int i4, long j, long j2, long j3) {
            this.a = i;
            this.b = i2;
            this.c = str;
            this.d = str2;
            this.e = i3;
            this.f = str3;
            this.g = i4;
            this.h = j;
            this.i = j2;
            this.j = j3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            char c = 2;
            int i = 1;
            char c2 = 0;
            try {
                int i2 = 0;
                for (com.chuanglan.shanyan_sdk.listener.InitListener initListener : com.chuanglan.shanyan_sdk.t0.this.b) {
                    java.lang.Integer numValueOf = java.lang.Integer.valueOf(this.a);
                    java.lang.Integer numValueOf2 = java.lang.Integer.valueOf(this.b);
                    java.lang.String str = this.c;
                    java.lang.String str2 = this.d;
                    java.lang.Object[] objArr = new java.lang.Object[6];
                    objArr[c2] = "initCallBack code";
                    objArr[i] = numValueOf;
                    objArr[c] = "processName";
                    objArr[3] = numValueOf2;
                    objArr[4] = str;
                    objArr[5] = str2;
                    com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", objArr);
                    initListener.getInitStatus(this.a, this.d);
                    if (com.chuanglan.shanyan_sdk.t0.this.b.size() > i) {
                        i2 = i;
                    }
                    com.chuanglan.shanyan_sdk.A.g().a(this.a, this.e, this.d, this.f, this.c, this.b, 1, this.g, this.h, this.i, this.j, i2, 1);
                    c = 2;
                    i = 1;
                    c2 = 0;
                }
                com.chuanglan.shanyan_sdk.t0.this.b.clear();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "initCallBack Exception", e);
            }
        }
    }

    class c implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ int e;
        final /* synthetic */ java.lang.String f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;
        final /* synthetic */ long i;
        final /* synthetic */ long j;
        final /* synthetic */ long k;

        c(int i, int i2, java.lang.String str, java.lang.String str2, int i3, java.lang.String str3, int i4, int i5, long j, long j2, long j3) {
            this.a = i;
            this.b = i2;
            this.c = str;
            this.d = str2;
            this.e = i3;
            this.f = str3;
            this.g = i4;
            this.h = i5;
            this.i = j;
            this.j = j2;
            this.k = j3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            char c = 2;
            int i = 1;
            char c2 = 0;
            try {
                int i2 = 0;
                for (com.chuanglan.shanyan_sdk.listener.GetPhoneInfoListener getPhoneInfoListener : com.chuanglan.shanyan_sdk.t0.this.c) {
                    java.lang.Integer numValueOf = java.lang.Integer.valueOf(this.a);
                    java.lang.Integer numValueOf2 = java.lang.Integer.valueOf(this.b);
                    java.lang.String str = this.c;
                    java.lang.String str2 = this.d;
                    java.lang.Object[] objArr = new java.lang.Object[6];
                    objArr[c2] = "preInfoCallBack code";
                    objArr[i] = numValueOf;
                    objArr[c] = "processName";
                    objArr[3] = numValueOf2;
                    objArr[4] = str;
                    objArr[5] = str2;
                    com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", objArr);
                    getPhoneInfoListener.getPhoneInfoStatus(this.a, this.d);
                    if (com.chuanglan.shanyan_sdk.t0.this.c.size() > i) {
                        i2 = i;
                    }
                    com.chuanglan.shanyan_sdk.A.g().a(this.a, this.e, this.d, this.f, this.c, this.b, this.g, this.h, this.i, this.j, this.k, i2, 1);
                    c = 2;
                    i = 1;
                    c2 = 0;
                }
                com.chuanglan.shanyan_sdk.t0.this.c.clear();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "getPhoneInfoCallBack Exception", e);
            }
        }
    }

    class d implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;

        d(int i, java.lang.String str, java.lang.String str2) {
            this.a = i;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "start activity CallBack", java.lang.Integer.valueOf(this.a), this.b, java.lang.Integer.valueOf(com.chuanglan.shanyan_sdk.AbstractC0055l.v.get()), this.c);
                if (com.chuanglan.shanyan_sdk.t0.this.e != null) {
                    com.chuanglan.shanyan_sdk.t0.this.e.getOpenLoginAuthStatus(this.a, this.c);
                    com.chuanglan.shanyan_sdk.t0.this.e = null;
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "getOpenLoginAuthStatus Exception", e);
            }
        }
    }

    class e implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ int d;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;
        final /* synthetic */ long h;
        final /* synthetic */ long i;
        final /* synthetic */ long j;

        e(int i, java.lang.String str, java.lang.String str2, int i2, java.lang.String str3, int i3, int i4, long j, long j2, long j3) {
            this.a = i;
            this.b = str;
            this.c = str2;
            this.d = i2;
            this.e = str3;
            this.f = i3;
            this.g = i4;
            this.h = j;
            this.i = j2;
            this.j = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "get token CallBack", java.lang.Integer.valueOf(this.a), "result", this.b, this.c);
                if (com.chuanglan.shanyan_sdk.t0.this.f != null) {
                    com.chuanglan.shanyan_sdk.t0.this.f.getOneKeyLoginStatus(this.a, this.c);
                }
                if (com.chuanglan.shanyan_sdk.t0.this.n != null) {
                    com.chuanglan.shanyan_sdk.t0.this.n.setClickable(true);
                }
                if (this.a != com.chuanglan.shanyan_sdk.EnumC0060q.USER_CANCEL_CODE.d()) {
                    com.chuanglan.shanyan_sdk.t0.h().d();
                    if (com.chuanglan.shanyan_sdk.t0.this.o) {
                        com.chuanglan.shanyan_sdk.t0.this.f();
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "getLoginTokenCallBack Exception", e);
            }
            com.chuanglan.shanyan_sdk.A.g().a(this.a, this.d, this.c, this.e, this.b, 4, this.f, this.g, this.h, this.i, this.j, false, 1);
        }
    }

    class f implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ int d;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;
        final /* synthetic */ long h;
        final /* synthetic */ long i;
        final /* synthetic */ long j;

        f(int i, java.lang.String str, java.lang.String str2, int i2, java.lang.String str3, int i3, int i4, long j, long j2, long j3) {
            this.a = i;
            this.b = str;
            this.c = str2;
            this.d = i2;
            this.e = str3;
            this.f = i3;
            this.g = i4;
            this.h = j;
            this.i = j2;
            this.j = j3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            char c = 2;
            int i = 1;
            char c2 = 0;
            try {
                int i2 = 0;
                for (com.chuanglan.shanyan_sdk.listener.AuthenticationExecuteListener authenticationExecuteListener : com.chuanglan.shanyan_sdk.t0.this.d) {
                    java.lang.Integer numValueOf = java.lang.Integer.valueOf(this.a);
                    java.lang.String str = this.b;
                    java.lang.String str2 = this.c;
                    java.lang.Object[] objArr = new java.lang.Object[4];
                    objArr[c2] = "getAuthTokenCallBack code";
                    objArr[i] = numValueOf;
                    objArr[c] = str;
                    objArr[3] = str2;
                    com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", objArr);
                    authenticationExecuteListener.authenticationRespond(this.a, this.c);
                    if (com.chuanglan.shanyan_sdk.t0.this.d.size() > i) {
                        i2 = i;
                    }
                    com.chuanglan.shanyan_sdk.A.g().a(this.a, this.d, this.c, this.e, this.b, 11, this.f, this.g, this.h, this.i, this.j, i2, 1);
                    c = 2;
                    i = 1;
                    c2 = 0;
                }
                com.chuanglan.shanyan_sdk.t0.this.d.clear();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "getAuthTokenCallBack Exception", e);
            }
        }
    }

    class g implements com.chuanglan.shanyan_sdk.listener.AuthPageActionListener {
        g() {
        }

        @Override // com.chuanglan.shanyan_sdk.listener.AuthPageActionListener
        public void setAuthPageActionListener(int i, int i2, java.lang.String str) {
            if (com.chuanglan.shanyan_sdk.t0.this.g != null) {
                com.chuanglan.shanyan_sdk.t0.this.g.ActionListner(i, i2, str);
            }
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "setAuthPageActionListener type", java.lang.Integer.valueOf(i), "code", java.lang.Integer.valueOf(i2), "message", str);
        }
    }

    private t0() {
    }

    public boolean i() {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getPreIntStatus");
        return com.chuanglan.shanyan_sdk.p0.a(this.a, "cl_jm_f4", false);
    }

    public android.widget.CheckBox j() {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getPrivacyCheckBox");
        return this.m;
    }

    public void k() {
        android.widget.CheckBox checkBox;
        try {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "performLoginClick");
            if (this.n == null || (checkBox = this.m) == null || !checkBox.isChecked() || this.m.getVisibility() != 0) {
                return;
            }
            this.n.performClick();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public void l() {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "removeAllListener");
        com.chuanglan.shanyan_sdk.AbstractC0055l.Q = null;
        com.chuanglan.shanyan_sdk.AbstractC0055l.R = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    public void m() {
        com.chuanglan.shanyan_sdk.Q.a("UIShanYanLogger", "setAuthThemeConfig innerSet", java.lang.Boolean.valueOf(this.k == null), java.lang.Boolean.valueOf(this.l == null), java.lang.Boolean.valueOf(this.j == null));
        if (this.k != null || this.l != null || this.j != null) {
            com.chuanglan.shanyan_sdk.tool.a.b().a(this.k, this.l, this.j);
        } else {
            com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfigBuild = new com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig.Builder().build();
            com.chuanglan.shanyan_sdk.tool.a.b().a(shanYanUIConfigBuild, shanYanUIConfigBuild, shanYanUIConfigBuild);
        }
    }

    public boolean n() {
        return this.p.compareAndSet(false, true);
    }

    public void o() {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "unregisterOnClickPrivacyListener");
        com.chuanglan.shanyan_sdk.AbstractC0055l.Q = null;
        com.chuanglan.shanyan_sdk.AbstractC0055l.R = null;
    }

    public static com.chuanglan.shanyan_sdk.t0 h() {
        if (q == null) {
            synchronized (com.chuanglan.shanyan_sdk.t0.class) {
                if (q == null) {
                    q = new com.chuanglan.shanyan_sdk.t0();
                }
            }
        }
        return q;
    }

    public void b(int i, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3, int i3, int i4, long j, long j2, long j3) {
        com.chuanglan.shanyan_sdk.AbstractC0050g.a(new com.chuanglan.shanyan_sdk.t0.f(i, str3, str, i2, str2, i3, i4, j, j2, j3));
    }

    public void c(int i, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3, int i3, int i4, long j, long j2, long j3) {
        if (n()) {
            com.chuanglan.shanyan_sdk.AbstractC0050g.a(new com.chuanglan.shanyan_sdk.t0.e(i, str3, str, i2, str2, i3, i4, j, j2, j3));
        } else {
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "getLoginTokenCallBack duplicate, ignore. code=", java.lang.Integer.valueOf(i));
        }
    }

    public void d(int i, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3, int i3, int i4, long j, long j2, long j3) {
        com.chuanglan.shanyan_sdk.AbstractC0050g.a(new com.chuanglan.shanyan_sdk.t0.b(i, i3, str3, str, i2, str2, i4, j, j2, j3));
    }

    public void e(android.content.Context context) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "registerActivityLifecycleCallbacks");
        if (context != null) {
            com.chuanglan.shanyan_sdk.A.g().a(context.getApplicationContext());
        }
    }

    public void f(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "setLoadingVisibility", java.lang.Boolean.valueOf(z));
        try {
            android.view.ViewGroup viewGroup = this.i;
            if (viewGroup != null) {
                if (z) {
                    viewGroup.setVisibility(0);
                } else {
                    viewGroup.setVisibility(8);
                }
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "setLoadingVisibility Exception", e2);
        }
    }

    public void g(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "setReadPhoneStatePermissionEnable", java.lang.Boolean.valueOf(z));
        com.chuanglan.shanyan_sdk.AbstractC0055l.E = z;
    }

    public void a(android.content.Context context, java.lang.String str, com.chuanglan.shanyan_sdk.listener.InitListener initListener) {
        try {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "initialization");
            if (com.chuanglan.shanyan_sdk.AbstractC0050g.a(1, context)) {
                this.a = context;
                this.b.add(initListener);
                com.chuanglan.shanyan_sdk.N.b().a(context, str);
                com.chuanglan.shanyan_sdk.N.b().a(java.lang.System.currentTimeMillis(), android.os.SystemClock.uptimeMillis());
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "initialization version", "2.3.7.7", "JC", "appId", str, "packageSign", com.chuanglan.shanyan_sdk.C0065v.g().d(context), "packageName", com.chuanglan.shanyan_sdk.C0065v.g().c(context));
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "initialization Exception", e2);
        }
    }

    public void b() {
        try {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "inner init clear");
            com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_b2", 0L);
            com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_f2", false);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "clearInitCache Exception=", e2);
        }
    }

    public void d() {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "inner preInfo clear");
        com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_f4", false);
        com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_d8", 0L);
    }

    public void i(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "unregisterActivityLifecycleCallbacks", java.lang.Boolean.valueOf(z));
        if (this.a != null) {
            com.chuanglan.shanyan_sdk.A.g().b(this.a.getApplicationContext());
        }
    }

    public android.app.Activity g() {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getAuthActivity");
        try {
            java.lang.ref.WeakReference<com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity> weakReference = com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.mLoginActivityWeakReference;
            if (weakReference == null) {
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getAuthActivity: weakRef is null");
                return null;
            }
            com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity shanYanOneKeyActivity = weakReference.get();
            if (shanYanOneKeyActivity == null) {
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getAuthActivity: activity is null");
                return null;
            }
            if (shanYanOneKeyActivity.isFinishing()) {
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getAuthActivity: activity is finishing");
                return null;
            }
            if (shanYanOneKeyActivity.isDestroyed()) {
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getAuthActivity: activity is destroyed");
                return null;
            }
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getAuthActivity: returning valid activity");
            return shanYanOneKeyActivity;
        } catch (java.lang.Exception e2) {
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "getAuthActivity Exception", e2);
            return null;
        }
    }

    public void e() {
        com.chuanglan.shanyan_sdk.x0.a(this.i);
        this.i = null;
    }

    public void c() {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "clearScripCache");
        d();
    }

    public void d(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getOaidEnable", java.lang.Boolean.valueOf(z));
        com.chuanglan.shanyan_sdk.AbstractC0055l.J = z;
    }

    public void e(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "setCheckBoxValue", java.lang.Boolean.valueOf(z));
        android.widget.CheckBox checkBox = this.m;
        if (checkBox != null) {
            checkBox.setChecked(z);
        }
    }

    public void b(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getImeiEnable", java.lang.Boolean.valueOf(z));
    }

    public void c(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getIpEnable", java.lang.Boolean.valueOf(z));
        com.chuanglan.shanyan_sdk.AbstractC0055l.F = z;
    }

    public boolean d(android.content.Context context) {
        boolean zC = c(context);
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "final info", java.lang.Boolean.valueOf(zC));
        return zC;
    }

    public java.lang.String b(android.content.Context context) {
        java.lang.String strB;
        java.lang.String str = "Unknown_Operator";
        try {
            if (com.chuanglan.shanyan_sdk.AbstractC0055l.U.get() || "Unknown_Operator".equals(com.chuanglan.shanyan_sdk.AbstractC0055l.q)) {
                strB = com.chuanglan.shanyan_sdk.C0065v.g().b(context);
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getCurrentOperatorType: " + strB);
            } else {
                strB = com.chuanglan.shanyan_sdk.AbstractC0055l.q;
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "currentOperarotType auth: " + strB);
            }
            str = strB;
        } catch (java.lang.Exception e2) {
            com.chuanglan.shanyan_sdk.Q.b("ProcessShanYanLogger", "getOperatorInfo error", e2);
        }
        return com.chuanglan.shanyan_sdk.AbstractC0049f.c(str);
    }

    public void h(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "setRunningAppProcessesEnable", java.lang.Boolean.valueOf(z));
        com.chuanglan.shanyan_sdk.AbstractC0055l.D = z;
    }

    public boolean c(android.content.Context context) {
        try {
            boolean zA = com.chuanglan.shanyan_sdk.p0.a(context, "cl_jm_f4", false);
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "save info", java.lang.Boolean.valueOf(zA));
            if (!zA) {
                return false;
            }
            java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(context, "cl_jm_f8", "");
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "fakeNumber", strA);
            if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(strA) || com.chuanglan.shanyan_sdk.C0065v.g().e(context) < 1) {
                return false;
            }
            boolean zB = com.chuanglan.shanyan_sdk.AbstractC0059p.b(context, "scripCache_sub");
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "isChange", java.lang.Boolean.valueOf(zB));
            if (zB) {
                return false;
            }
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            long jA = com.chuanglan.shanyan_sdk.p0.a(context, "cl_jm_d8", 1L);
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "time", java.lang.Long.valueOf(jCurrentTimeMillis), java.lang.Long.valueOf(jA));
            if (jCurrentTimeMillis > jA) {
                return false;
            }
            java.lang.String strA2 = com.chuanglan.shanyan_sdk.p0.a(context, "cl_jm_f6", "");
            java.lang.String strA3 = com.chuanglan.shanyan_sdk.p0.a(context, "cl_jm_g3", "");
            java.lang.String strA4 = com.chuanglan.shanyan_sdk.p0.a(context, "cl_jm_g2", "");
            boolean z = "CUCC".equals(strA2) && "cu".equals(strA3);
            boolean z2 = "CTCC".equals(strA2) && "ct".equals(strA4);
            if (!z && !z2) {
                return true;
            }
            java.lang.String strA5 = com.chuanglan.shanyan_sdk.p0.a(context, "cl_jm_f7", "");
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "accessCode", strA5);
            return com.chuanglan.shanyan_sdk.AbstractC0049f.b(strA5);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void f() {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "finishAuthActivity");
        try {
            java.lang.ref.WeakReference<com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity> weakReference = com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.mLoginActivityWeakReference;
            if (weakReference == null) {
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "finishAuthActivity: weakRef is null");
                return;
            }
            com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity shanYanOneKeyActivity = weakReference.get();
            if (shanYanOneKeyActivity == null) {
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "finishAuthActivity: activity is null");
            } else if (shanYanOneKeyActivity.isFinishing()) {
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "finishAuthActivity: activity already finishing");
            } else {
                shanYanOneKeyActivity.finish();
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "finishAuthActivity: activity finished successfully");
            }
        } catch (java.lang.Exception e2) {
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "finishAuthActivity Exception", e2);
        }
    }

    public void a(com.chuanglan.shanyan_sdk.listener.GetPhoneInfoListener getPhoneInfoListener) {
        try {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getPhoneInfo", "2.3.7.7");
            if (com.chuanglan.shanyan_sdk.AbstractC0050g.a(2, this.a)) {
                this.c.add(getPhoneInfoListener);
                com.chuanglan.shanyan_sdk.k0.b().a(2, null, java.lang.System.currentTimeMillis(), android.os.SystemClock.uptimeMillis());
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "getPhoneInfo Exception", e2);
        }
    }

    private void a(android.content.Context context) {
        try {
            java.util.concurrent.ExecutorService executorService = this.h;
            if (executorService == null || executorService.isShutdown()) {
                this.h = new java.util.concurrent.ThreadPoolExecutor(8, Integer.MAX_VALUE, 120L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingDeque());
            }
            this.h.execute(new com.chuanglan.shanyan_sdk.t0.a(context));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(com.chuanglan.shanyan_sdk.listener.AuthenticationExecuteListener authenticationExecuteListener) {
        try {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "startAuthentication");
            a(this.a);
            com.chuanglan.shanyan_sdk.AbstractC0050g.e(this.a);
            if (com.chuanglan.shanyan_sdk.AbstractC0050g.a(11, this.a)) {
                this.d.add(authenticationExecuteListener);
                com.chuanglan.shanyan_sdk.C0053j.a().a(java.lang.System.currentTimeMillis(), android.os.SystemClock.uptimeMillis());
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "startAuthentication Exception", e2);
        }
    }

    public void a(int i, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3, int i3, int i4, int i5, long j, long j2, long j3) {
        com.chuanglan.shanyan_sdk.AbstractC0050g.a(new com.chuanglan.shanyan_sdk.t0.c(i, i3, str3, str, i2, str2, i4, i5, j, j2, j3));
    }

    public void a(int i, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3, int i3, int i4, long j, long j2, long j3) {
        if (this.e != null) {
            com.chuanglan.shanyan_sdk.AbstractC0050g.a(new com.chuanglan.shanyan_sdk.t0.d(i, str3, str));
            com.chuanglan.shanyan_sdk.A.g().a(i, i2, str, str2, str3, 3, i3, i4, j, j2, j3, false, 1);
        }
    }

    public void a() {
        try {
            b();
            d();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "clearInitCache Exception=", e2);
        }
    }

    public void a(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "checkProcessesEnable", java.lang.Boolean.valueOf(z));
        com.chuanglan.shanyan_sdk.AbstractC0055l.C = z;
    }

    public void a(boolean z, java.lang.String[] strArr) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "setPrivacyUrlWhiteList", java.lang.Boolean.valueOf(z));
        com.chuanglan.shanyan_sdk.AbstractC0055l.K = z;
        com.chuanglan.shanyan_sdk.AbstractC0055l.L.clear();
        if (strArr != null) {
            for (java.lang.String str : strArr) {
                if (str != null && !str.isEmpty()) {
                    com.chuanglan.shanyan_sdk.AbstractC0055l.L.add(str);
                }
            }
        }
    }

    public void a(android.view.ViewGroup viewGroup) {
        this.i = viewGroup;
    }

    public void a(com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig, com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig2, com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig3) {
        com.chuanglan.shanyan_sdk.Q.a("UIShanYanLogger", "setAuthThemeConfig");
        this.l = shanYanUIConfig2;
        this.j = shanYanUIConfig3;
        if (shanYanUIConfig != null) {
            this.k = shanYanUIConfig;
            com.chuanglan.shanyan_sdk.Q.a("UIShanYanLogger", "setAuthThemeConfig portraitUIConfig", shanYanUIConfig.toString());
        } else if (shanYanUIConfig2 != null) {
            this.k = shanYanUIConfig2;
        }
        if (shanYanUIConfig2 != null) {
            com.chuanglan.shanyan_sdk.Q.a("UIShanYanLogger", "setAuthThemeConfig landUIConfig", shanYanUIConfig2.toString());
        }
        if (shanYanUIConfig3 != null) {
            com.chuanglan.shanyan_sdk.Q.a("UIShanYanLogger", "setAuthThemeConfig shanYanUIConfig", shanYanUIConfig3.toString());
        }
    }

    public void a(boolean z, com.chuanglan.shanyan_sdk.listener.OpenLoginAuthListener openLoginAuthListener, com.chuanglan.shanyan_sdk.listener.OneKeyLoginListener oneKeyLoginListener) {
        try {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "openLoginAuth", java.lang.Boolean.valueOf(z), "2.3.7.7");
            this.o = z;
            this.e = openLoginAuthListener;
            this.f = oneKeyLoginListener;
            this.p.set(false);
            if (com.chuanglan.shanyan_sdk.AbstractC0050g.a(3, this.a)) {
                com.chuanglan.shanyan_sdk.T.a().a(3, java.lang.System.currentTimeMillis(), android.os.SystemClock.uptimeMillis());
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "openLoginAuth Exception", e2);
        }
    }

    public void a(com.chuanglan.shanyan_sdk.listener.ActionListener actionListener) {
        try {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "setActionListener");
            this.g = actionListener;
            com.chuanglan.shanyan_sdk.AbstractC0055l.S = new com.chuanglan.shanyan_sdk.t0.g();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(android.widget.CheckBox checkBox) {
        this.m = checkBox;
    }

    public void a(android.widget.Button button) {
        this.n = button;
    }

    public void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "startPrivacyProtocolActivity", str, str2);
        com.chuanglan.shanyan_sdk.AbstractC0044a.a(context, str, str2);
    }

    public void a(com.chuanglan.shanyan_sdk.listener.LoginActivityStatusListener loginActivityStatusListener) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "setLoginActivityStatusListener");
        com.chuanglan.shanyan_sdk.AbstractC0055l.T = loginActivityStatusListener;
    }

    public void a(com.chuanglan.shanyan_sdk.listener.OnClickPrivacyListener onClickPrivacyListener) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "setOnClickPrivacyListener");
        com.chuanglan.shanyan_sdk.AbstractC0055l.Q = onClickPrivacyListener;
    }

    public void a(com.chuanglan.shanyan_sdk.listener.PricacyOnClickListener pricacyOnClickListener) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "setPrivacyOnClickListener");
        com.chuanglan.shanyan_sdk.AbstractC0055l.R = pricacyOnClickListener;
    }
}
