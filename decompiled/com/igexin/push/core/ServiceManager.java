package com.igexin.push.core;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ServiceManager {
    public static android.content.Context b = null;
    private static final java.lang.String c = "ServiceManager";
    public com.igexin.sdk.IPushCore a;
    private final java.util.concurrent.atomic.AtomicBoolean d;
    private java.lang.String e;
    private java.lang.Class f;
    private java.lang.Class g;
    private java.util.concurrent.atomic.AtomicBoolean h;
    private final android.content.ServiceConnection i;
    public android.util.Pair<java.lang.Integer, java.lang.String> initType;

    /* JADX INFO: renamed from: com.igexin.push.core.ServiceManager$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ android.content.Intent a;
        final /* synthetic */ long b;
        final /* synthetic */ android.app.Activity c;
        final /* synthetic */ java.lang.String d;

        public AnonymousClass4(android.content.Intent intent, long j, android.app.Activity activity, java.lang.String str) {
            this.a = intent;
            this.b = j;
            this.c = activity;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (!com.igexin.push.g.k.a(com.igexin.push.core.ServiceManager.b)) {
                    android.content.Intent intent = this.a;
                    if (intent != null && intent.getExtras() != null) {
                        try {
                            android.os.Bundle extras = this.a.getExtras();
                            android.os.IBinder binder = extras.getBinder("callback");
                            if (binder != null) {
                                new com.igexin.a.b(binder).a(new android.os.Bundle());
                                extras.remove("callback");
                            }
                        } catch (java.lang.Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                    }
                    long jA = com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.b, 0);
                    long jA2 = com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.c, 0);
                    boolean z = (jA == 0 || jA2 == 0 || jA2 >= jA) ? false : true;
                    if (jA != 0) {
                        long j = this.b;
                        if (j - jA < com.igexin.push.config.c.s || j - jA2 < com.igexin.push.config.c.s) {
                            z = true;
                        }
                    }
                    android.app.Activity activity = this.c;
                    com.igexin.push.core.a.b.d();
                    android.content.Intent intent2 = new android.content.Intent(activity, (java.lang.Class<?>) com.igexin.push.core.a.b.a((android.content.Context) this.c));
                    android.content.Intent intent3 = this.a;
                    if (intent3 != null && intent3.hasExtra("action") && this.a.hasExtra("isSlave")) {
                        intent2.putExtra("action", this.a.getStringExtra("action"));
                        intent2.putExtra("isSlave", this.a.getBooleanExtra("isSlave", false));
                        if (this.a.hasExtra("op_app")) {
                            intent2.putExtra("op_app", this.a.getStringExtra("op_app"));
                        }
                    }
                    android.content.Intent intent4 = this.a;
                    if (intent4 != null && intent4.hasExtra(com.igexin.push.core.b.aB)) {
                        intent2.putExtra(com.igexin.push.core.b.aB, this.a.getStringExtra(com.igexin.push.core.b.aB));
                    }
                    intent2.putExtra("isGuard", true);
                    intent2.putExtra("isGuardForce", z);
                    com.igexin.push.core.ServiceManager.this.b(this.c, intent2);
                    com.igexin.c.a.c.a.a("ServiceManager|start PushService from da " + this.d, new java.lang.Object[0]);
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    static class a {
        private static final com.igexin.push.core.ServiceManager a = new com.igexin.push.core.ServiceManager(0);

        private a() {
        }
    }

    private ServiceManager() {
        this.d = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.h = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.i = new android.content.ServiceConnection() { // from class: com.igexin.push.core.ServiceManager.7
            @Override // android.content.ServiceConnection
            public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(android.content.ComponentName componentName) {
            }
        };
    }

    /* synthetic */ ServiceManager(byte b2) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(android.content.Intent intent, int i, int i2) {
        if (this.a == null) {
            return 2;
        }
        com.igexin.c.a.c.a.a("ServiceManager|inInit = true, call onServiceStartCommand...", new java.lang.Object[0]);
        return this.a.onServiceStartCommand(intent, i, i2);
    }

    public static void a() {
        com.igexin.c.a.c.a.a("ServiceManager|onLowMemory...", new java.lang.Object[0]);
    }

    private void a(android.app.Activity activity) {
        try {
            android.content.Context applicationContext = activity.getApplicationContext();
            b = applicationContext;
            com.getui.gtc.base.GtcProvider.setContext(applicationContext);
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            java.lang.String name = activity.getClass().getName();
            com.igexin.b.a.a().a("gd").execute(new com.igexin.push.core.ServiceManager.AnonymousClass4(activity.getIntent(), jCurrentTimeMillis, activity, name));
        } catch (java.lang.Throwable th) {
            activity.finish();
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void a(final android.app.Service service) {
        com.igexin.c.a.c.a.a("ServiceManager|startGTCore ++++", new java.lang.Object[0]);
        if (!com.igexin.push.g.g.a()) {
            com.igexin.b.a.a().a.execute(new com.igexin.push.g.h.AnonymousClass1(service, new com.igexin.push.g.h.a() { // from class: com.igexin.push.core.ServiceManager.2
                @Override // com.igexin.push.g.h.a
                public final void a(boolean z) {
                    com.igexin.c.a.c.a.a(com.igexin.push.core.ServiceManager.c, "load encrypt error, report bi result = " + z + " ###########");
                    com.igexin.c.a.c.a.a("ServiceManager|load encrypt error, report bi result = " + z + " ###########", new java.lang.Object[0]);
                    service.stopSelf();
                }
            }));
            return;
        }
        com.igexin.sdk.main.PushCoreLoader.getInstance().init(service);
        this.a = com.igexin.sdk.main.PushCoreLoader.getInstance().getPushCore();
        if (com.igexin.sdk.main.PushCoreLoader.getInstance().getGtcCore() != null) {
            com.igexin.sdk.main.PushCoreLoader.getInstance().getGtcCore().start(service);
        }
        com.igexin.sdk.IPushCore iPushCore = this.a;
        if (iPushCore != null) {
            iPushCore.start(service);
        }
    }

    public static void a(android.content.Context context) {
        b = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(android.app.Service service) {
        com.igexin.c.a.c.a.a("ServiceManager|start by system ####", new java.lang.Object[0]);
        if (!g(service)) {
            service.stopSelf();
            return 2;
        }
        com.igexin.c.a.c.a.a("ServiceManager|intent = null", new java.lang.Object[0]);
        if (!this.d.getAndSet(true)) {
            a(service);
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(android.app.Service service, android.content.Intent intent, int i, int i2) {
        com.igexin.c.a.c.a.a("ServiceManager|start from initialize...", new java.lang.Object[0]);
        com.igexin.c.a.c.a.d.a().a("[ServiceManager] ServiceManager start from initialize...");
        a(service);
        com.igexin.sdk.IPushCore iPushCore = this.a;
        if (iPushCore != null) {
            return iPushCore.onServiceStartCommand(intent, i, i2);
        }
        return 2;
    }

    private void b() {
        com.igexin.c.a.c.a.a("ServiceManager|onDestroy...", new java.lang.Object[0]);
        com.igexin.sdk.IPushCore iPushCore = this.a;
        if (iPushCore != null) {
            iPushCore.onServiceDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(android.app.Service service, android.content.Intent intent, int i, int i2) {
        com.igexin.c.a.c.a.a("ServiceManager|start from guard...", new java.lang.Object[0]);
        if (!g(service)) {
            this.d.set(false);
            service.stopSelf();
            return 2;
        }
        a(service);
        com.igexin.sdk.IPushCore iPushCore = this.a;
        if (iPushCore != null) {
            return iPushCore.onServiceStartCommand(intent, i, i2);
        }
        return 2;
    }

    private boolean c(final android.content.Context context, final android.content.Intent intent) {
        com.igexin.b.a.a().a("pushservice").execute(new java.lang.Runnable() { // from class: com.igexin.push.core.ServiceManager.6
            private void a() {
                try {
                    com.igexin.c.a.c.a.a("ServiceManager|startPService by bind", new java.lang.Object[0]);
                    intent.setType("PB-" + java.lang.System.nanoTime());
                    android.content.Intent intent2 = intent;
                    android.content.Context context2 = context;
                    intent2.setClass(context2, com.igexin.push.core.ServiceManager.this.b(context2));
                    context.getApplicationContext().bindService(intent, com.igexin.push.core.ServiceManager.this.i, 1);
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.b(com.igexin.push.core.ServiceManager.c, "startPService exception = " + th.toString());
                    com.igexin.c.a.c.a.a(th);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (android.os.Build.VERSION.SDK_INT < 26 || !com.igexin.push.g.c.f()) {
                        context.getApplicationContext().startService(intent);
                    } else {
                        a();
                    }
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.b(com.igexin.push.core.ServiceManager.c, "startPService exception = " + th.toString());
                    com.igexin.c.a.c.a.a(th);
                    if (th instanceof java.lang.IllegalStateException) {
                        a();
                    }
                }
            }
        });
        return true;
    }

    public static java.lang.String d(android.content.Context context) {
        return (java.lang.String) com.igexin.push.g.q.b(context, com.igexin.push.g.q.d, "");
    }

    public static java.lang.String e(android.content.Context context) {
        return (java.lang.String) com.igexin.push.g.q.b(context, com.igexin.push.g.q.a, "");
    }

    private static boolean g(android.content.Context context) {
        return !com.igexin.push.g.k.a(context);
    }

    public static com.igexin.push.core.ServiceManager getInstance() {
        return com.igexin.push.core.ServiceManager.a.a;
    }

    public final int a(final android.app.Service service, final android.content.Intent intent, final int i, final int i2) {
        final android.content.Context applicationContext = service.getApplicationContext();
        com.igexin.b.a.a().a("pushservice").execute(new java.lang.Runnable() { // from class: com.igexin.push.core.ServiceManager.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.igexin.c.a.c.a.a(com.igexin.push.core.ServiceManager.c, "| PushService startCommand... time = " + java.lang.System.currentTimeMillis() + " intent = " + intent);
                    android.content.Intent intent2 = intent;
                    if (intent2 == null) {
                        com.igexin.push.core.ServiceManager.this.initType = android.util.Pair.create(0, null);
                        com.igexin.push.core.ServiceManager.this.b(service);
                        return;
                    }
                    com.igexin.push.g.q.a(applicationContext, intent2);
                    android.os.Bundle extras = intent.getExtras();
                    if (extras != null) {
                        for (java.lang.String str : extras.keySet()) {
                            extras.get(str);
                            com.igexin.c.a.c.a.a("ServiceManager|key [" + str + "]: " + extras.get(str), new java.lang.Object[0]);
                        }
                    } else {
                        com.igexin.c.a.c.a.a("ServiceManager|no extras", new java.lang.Object[0]);
                    }
                    java.lang.String stringExtra = intent.getStringExtra("action");
                    boolean booleanExtra = intent.getBooleanExtra("isGuard", false);
                    boolean booleanExtra2 = intent.getBooleanExtra("isGuardForce", false);
                    if (com.igexin.push.core.ServiceManager.this.d.getAndSet(true)) {
                        if (((java.lang.Integer) com.igexin.push.core.ServiceManager.this.initType.first).equals(0) && booleanExtra2) {
                            com.igexin.push.core.ServiceManager.this.initType = android.util.Pair.create(1, intent.getStringExtra(com.igexin.push.core.b.aB));
                            com.igexin.push.g.q.a(applicationContext, com.igexin.push.g.q.f, com.igexin.push.core.ServiceManager.this.initType.first);
                        }
                        com.igexin.push.core.ServiceManager.this.a(intent, i, i2);
                        return;
                    }
                    if (booleanExtra) {
                        com.igexin.push.core.ServiceManager.this.initType = android.util.Pair.create(1, intent.getStringExtra(com.igexin.push.core.b.aB));
                        com.igexin.push.core.ServiceManager.this.c(service, intent, i, i2);
                        com.igexin.push.g.q.a(applicationContext, com.igexin.push.g.q.f, com.igexin.push.core.ServiceManager.this.initType.first);
                        return;
                    }
                    com.igexin.push.core.ServiceManager.this.initType = android.util.Pair.create(0, null);
                    if (!(!com.igexin.push.g.k.a(applicationContext)) && !com.igexin.sdk.PushConsts.ACTION_SERVICE_INITIALIZE.equals(stringExtra)) {
                        com.igexin.push.core.ServiceManager.this.d.set(false);
                        service.stopSelf();
                        return;
                    }
                    com.igexin.push.core.ServiceManager serviceManager = com.igexin.push.core.ServiceManager.this;
                    android.app.Service service2 = service;
                    android.content.Intent intent3 = intent;
                    int i3 = i;
                    int i4 = i2;
                    serviceManager.b(service2, intent3, i3, i4);
                    com.igexin.push.g.q.a(applicationContext, com.igexin.push.g.q.f, com.igexin.push.core.ServiceManager.this.initType.first);
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
        });
        return 2;
    }

    public final android.os.IBinder a(android.app.Service service, android.content.Intent intent) {
        com.igexin.c.a.c.a.a("ServiceManager|onBind...", new java.lang.Object[0]);
        a(service, intent, 0, 0);
        com.igexin.sdk.IPushCore iPushCore = this.a;
        if (iPushCore != null) {
            return iPushCore.onServiceBind(intent);
        }
        return null;
    }

    public final void a(final android.content.Context context, final android.content.Intent intent) {
        try {
            android.content.Context applicationContext = context.getApplicationContext();
            b = applicationContext;
            com.getui.gtc.base.GtcProvider.setContext(applicationContext);
            final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            com.igexin.b.a.a().a("gd").execute(new java.lang.Runnable() { // from class: com.igexin.push.core.ServiceManager.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (com.igexin.push.g.k.a(com.igexin.push.core.ServiceManager.b)) {
                        return;
                    }
                    android.content.Intent intent2 = intent;
                    if (intent2 != null && intent2.getExtras() != null) {
                        try {
                            android.os.Bundle extras = intent.getExtras();
                            android.os.IBinder binder = extras.getBinder("callback");
                            if (binder != null) {
                                new com.igexin.a.b(binder).a(new android.os.Bundle());
                                extras.remove("callback");
                            }
                        } catch (java.lang.Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                    }
                    long jA = com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.b, 0);
                    long jA2 = com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.c, 0);
                    boolean z = (jA == 0 || jA2 == 0 || jA2 >= jA) ? false : true;
                    if (jA != 0 && jCurrentTimeMillis - jA < com.igexin.push.config.c.s) {
                        z = true;
                    }
                    android.content.Context context2 = context;
                    com.igexin.push.core.a.b.d();
                    android.content.Intent intent3 = new android.content.Intent(context2, (java.lang.Class<?>) com.igexin.push.core.a.b.a(context));
                    android.content.Intent intent4 = intent;
                    if (intent4 != null && intent4.hasExtra("action") && intent.hasExtra("isSlave")) {
                        intent3.putExtra("action", intent.getStringExtra("action"));
                        intent3.putExtra("isSlave", intent.getBooleanExtra("isSlave", false));
                        if (intent.hasExtra("op_app")) {
                            intent3.putExtra("op_app", intent.getStringExtra("op_app"));
                        }
                    }
                    android.content.Intent intent5 = intent;
                    if (intent5 != null && intent5.hasExtra(com.igexin.push.core.b.aB)) {
                        intent3.putExtra(com.igexin.push.core.b.aB, intent.getStringExtra(com.igexin.push.core.b.aB));
                    }
                    intent3.putExtra("isGuard", true);
                    intent3.putExtra("isGuardForce", z);
                    com.igexin.push.core.ServiceManager.this.b(context, intent3);
                    com.igexin.c.a.c.a.a("ServiceManager|start PushService from da", new java.lang.Object[0]);
                }
            });
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final java.lang.Class b(android.content.Context context) {
        android.content.ComponentName componentName;
        try {
            if (this.g == null) {
                java.lang.Class cls = (java.lang.Class) com.igexin.push.g.d.a(context, com.igexin.sdk.PushService.class).second;
                this.g = cls;
                if (cls == null) {
                    java.lang.String str = (java.lang.String) com.igexin.push.g.q.b(context, com.igexin.push.g.q.b, "");
                    if (!android.text.TextUtils.isEmpty(str)) {
                        this.g = java.lang.Class.forName(str);
                    }
                }
                if (this.g == null) {
                    this.g = com.igexin.sdk.PushService.class;
                }
            }
            componentName = new android.content.ComponentName(context, (java.lang.Class<?>) this.g);
        } catch (java.lang.Throwable th) {
            try {
                this.g = com.igexin.sdk.PushService.class;
                com.igexin.c.a.c.a.a(th);
                componentName = new android.content.ComponentName(context, (java.lang.Class<?>) this.g);
            } catch (java.lang.Throwable th2) {
                context.getPackageManager().setComponentEnabledSetting(new android.content.ComponentName(context, (java.lang.Class<?>) this.g), 1, 1);
                throw th2;
            }
        }
        context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        return this.g;
    }

    public final boolean b(android.content.Context context, android.content.Intent intent) {
        return c(context.getApplicationContext(), intent);
    }

    public final java.lang.Class c(android.content.Context context) {
        java.lang.Class cls = this.f;
        if (cls != null) {
            return cls;
        }
        java.lang.Class cls2 = (java.lang.Class) com.igexin.push.g.d.a(context, com.igexin.sdk.GTIntentService.class).second;
        this.f = cls2;
        if (cls2 != null) {
            return cls2;
        }
        try {
            java.lang.String str = (java.lang.String) com.igexin.push.g.q.b(context, com.igexin.push.g.q.c, "");
            if (!android.text.TextUtils.isEmpty(str)) {
                java.lang.Class<?> cls3 = java.lang.Class.forName(str);
                this.f = cls3;
                return cls3;
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return this.f;
    }

    public final void f(android.content.Context context) {
        b = context.getApplicationContext();
        final boolean zIsMainProcess = com.getui.gtc.base.util.CommonUtil.isMainProcess();
        if (this.h.getAndSet(true)) {
            final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            com.igexin.b.a.a().a("gd").execute(new java.lang.Runnable() { // from class: com.igexin.push.core.ServiceManager.3
                @Override // java.lang.Runnable
                public final void run() {
                    com.igexin.push.core.d.d.a().a(zIsMainProcess ? com.igexin.push.core.d.d.b : com.igexin.push.core.d.d.c, java.lang.Long.valueOf(jCurrentTimeMillis));
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("init in ");
                    sb.append(zIsMainProcess ? "main process " : "other process ");
                    sb.append(jCurrentTimeMillis);
                    com.igexin.c.a.c.a.b(com.igexin.push.core.ServiceManager.c, sb.toString());
                }
            });
        }
    }
}
