package com.igexin.c.a.d;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class g extends android.content.BroadcastReceiver implements java.util.Comparator<com.igexin.c.a.d.f> {
    public static final long E = java.util.concurrent.TimeUnit.SECONDS.toMillis(2);
    protected static final java.lang.String F = "AlarmTaskSchedule.";
    protected static final java.lang.String G = "AlarmTaskScheduleBak.";
    protected static final java.lang.String H = "AlarmNioTaskSchedule.";
    public static final java.lang.String h = "TaskService";
    public static final java.lang.String i = "com.igexin.c.a.d.g";
    static final byte j = -1;
    static final byte k = 0;
    static final byte l = 1;
    static final byte m = 2;
    static final byte n = -128;
    static final byte o = 7;
    public android.app.PendingIntent A;
    public java.lang.String B;
    volatile long C;
    public volatile boolean D;
    public boolean t;
    public android.os.PowerManager v;
    public android.app.AlarmManager w;
    public android.content.Intent x;
    public android.app.PendingIntent y;
    public android.content.Intent z;
    final java.util.concurrent.locks.ReentrantLock u = new java.util.concurrent.locks.ReentrantLock();
    public boolean I = false;
    final java.util.HashMap<java.lang.Long, com.igexin.c.a.d.a.c> q = new java.util.HashMap<>(7);
    public final com.igexin.c.a.d.e<com.igexin.c.a.d.f> s = new com.igexin.c.a.d.e<>(this, this);
    final com.igexin.c.a.d.d r = new com.igexin.c.a.d.d();
    public final com.igexin.c.a.d.g.b p = new com.igexin.c.a.d.g.b();

    /* JADX INFO: renamed from: com.igexin.c.a.d.g$1, reason: invalid class name */
    public class AnonymousClass1 extends android.content.IntentFilter {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
            addAction(com.igexin.c.a.d.g.F + context.getPackageName());
            addAction(com.igexin.c.a.d.g.G + context.getPackageName());
            addAction("android.intent.action.SCREEN_OFF");
            addAction("android.intent.action.SCREEN_ON");
        }
    }

    final class a {
        volatile int g;
        final java.util.concurrent.locks.ReentrantLock c = new java.util.concurrent.locks.ReentrantLock();
        final java.util.concurrent.BlockingQueue<com.igexin.c.a.d.f> a = new java.util.concurrent.SynchronousQueue();
        final java.util.HashMap<java.lang.Integer, com.igexin.c.a.d.g.a.RunnableC0016a> b = new java.util.HashMap<>();
        volatile long e = java.util.concurrent.TimeUnit.SECONDS.toNanos(60);
        volatile int f = 0;
        java.util.concurrent.ThreadFactory d = new com.igexin.c.a.d.g.a.b();
        volatile int h = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: com.igexin.c.a.d.g$a$a, reason: collision with other inner class name */
        final class RunnableC0016a implements java.lang.Runnable {
            final java.util.concurrent.BlockingQueue<com.igexin.c.a.d.f> a = new java.util.concurrent.LinkedBlockingQueue();
            com.igexin.c.a.d.f b;
            com.igexin.c.a.d.f c;
            volatile int d;
            volatile boolean e;

            public RunnableC0016a(com.igexin.c.a.d.f fVar) {
                this.b = fVar;
            }

            private void a() {
                this.a.clear();
                this.c = null;
            }

            private void a(com.igexin.c.a.d.f fVar) {
                if (this.d == 0) {
                    this.d = fVar.C;
                }
                boolean z = true;
                while (z) {
                    try {
                        try {
                            fVar.b_();
                            fVar.o();
                            if (!fVar.v) {
                                fVar.d_();
                            }
                            boolean z2 = fVar.m;
                            boolean z3 = fVar.p;
                            long j = fVar.w;
                        } catch (java.lang.Exception e) {
                            com.igexin.c.a.c.a.a(e);
                            com.igexin.c.a.c.a.a(com.igexin.c.a.d.g.h + e.toString(), new java.lang.Object[0]);
                            fVar.v = true;
                            fVar.E = e;
                            fVar.p();
                            fVar.l();
                            com.igexin.c.a.d.g.this.a((java.lang.Object) fVar);
                            com.igexin.c.a.d.g.this.e();
                            if (!fVar.v) {
                                fVar.d_();
                            }
                            boolean z4 = fVar.m;
                            boolean z5 = fVar.p;
                            long j2 = fVar.w;
                            if (fVar.m || !fVar.p || fVar.w == 0) {
                            }
                        }
                    } finally {
                    }
                    if (fVar.m || !fVar.p || fVar.w == 0) {
                        fVar = null;
                        z = false;
                    }
                }
            }

            private com.igexin.c.a.d.f b() {
                while (this.d != 0) {
                    try {
                        com.igexin.c.a.d.f fVarPoll = this.a.poll(com.igexin.c.a.d.g.a.this.e, java.util.concurrent.TimeUnit.NANOSECONDS);
                        if (fVarPoll != null) {
                            return fVarPoll;
                        }
                        if (this.a.isEmpty()) {
                            java.util.concurrent.locks.ReentrantLock reentrantLock = com.igexin.c.a.d.g.a.this.c;
                            reentrantLock.lock();
                            try {
                                if (this.a.isEmpty()) {
                                    com.igexin.c.a.d.g.a.this.b.remove(java.lang.Integer.valueOf(this.d));
                                    this.d = 0;
                                    return null;
                                }
                            } finally {
                                reentrantLock.unlock();
                            }
                        } else {
                            continue;
                        }
                    } catch (java.lang.InterruptedException e) {
                        com.igexin.c.a.c.a.a(e);
                    }
                }
                return null;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean zA = true;
                while (zA) {
                    try {
                        try {
                            com.igexin.c.a.d.f fVarB = this.b;
                            this.b = null;
                            while (true) {
                                if (fVarB == null) {
                                    fVarB = b();
                                    if (fVarB == null && (fVarB = com.igexin.c.a.d.g.a.this.b()) == null) {
                                        zA = com.igexin.c.a.d.g.a.this.a(this);
                                        if (!zA) {
                                        }
                                    }
                                }
                                this.c = null;
                                if (this.d == 0) {
                                    this.d = fVarB.C;
                                }
                                boolean z = true;
                                com.igexin.c.a.d.f fVar = fVarB;
                                while (z) {
                                    try {
                                        try {
                                            fVar.b_();
                                            fVar.o();
                                            if (!fVar.v) {
                                                fVar.d_();
                                            }
                                            boolean z2 = fVar.m;
                                            boolean z3 = fVar.p;
                                            long j = fVar.w;
                                        } catch (java.lang.Exception e) {
                                            com.igexin.c.a.c.a.a(e);
                                            com.igexin.c.a.c.a.a(com.igexin.c.a.d.g.h + e.toString(), new java.lang.Object[0]);
                                            fVar.v = true;
                                            fVar.E = e;
                                            fVar.p();
                                            fVar.l();
                                            com.igexin.c.a.d.g.this.a((java.lang.Object) fVar);
                                            com.igexin.c.a.d.g.this.e();
                                            if (!fVar.v) {
                                                fVar.d_();
                                            }
                                            boolean z4 = fVar.m;
                                            boolean z5 = fVar.p;
                                            long j2 = fVar.w;
                                            if (fVar.m || !fVar.p || fVar.w == 0) {
                                            }
                                        }
                                    } catch (java.lang.Throwable th) {
                                        if (!fVar.v) {
                                            fVar.d_();
                                        }
                                        boolean z6 = fVar.m;
                                        boolean z7 = fVar.p;
                                        long j3 = fVar.w;
                                        if (fVar.m || !fVar.p || fVar.w == 0) {
                                            throw th;
                                        }
                                    }
                                    if (fVar.m || !fVar.p || fVar.w == 0) {
                                        z = false;
                                        fVar = null;
                                    }
                                }
                                this.c = fVarB;
                                fVarB = null;
                            }
                            throw th;
                        } catch (java.lang.Exception e2) {
                            com.igexin.c.a.c.a.a(e2);
                            com.igexin.c.a.c.a.a("TaskService|Worker|run()|error" + e2.toString(), new java.lang.Object[0]);
                            zA = com.igexin.c.a.d.g.a.this.a(this);
                            if (!zA) {
                                a();
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        if (!com.igexin.c.a.d.g.a.this.a(this)) {
                            a();
                        }
                        throw th2;
                    }
                }
            }
        }

        final class b implements java.util.concurrent.ThreadFactory {
            final java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(0);

            public b() {
            }

            @Override // java.util.concurrent.ThreadFactory
            public final java.lang.Thread newThread(java.lang.Runnable runnable) {
                return new java.lang.Thread(runnable, "TS-pool-" + this.a.incrementAndGet());
            }
        }

        public a() {
        }

        private void c(com.igexin.c.a.d.f fVar) {
            fVar.getClass();
            if (fVar.C != 0) {
                java.util.concurrent.locks.ReentrantLock reentrantLock = this.c;
                reentrantLock.lock();
                try {
                    com.igexin.c.a.d.g.a.RunnableC0016a runnableC0016a = this.b.get(java.lang.Integer.valueOf(fVar.C));
                    if (runnableC0016a != null) {
                        runnableC0016a.a.offer(fVar);
                        return;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            if (this.g >= this.f || !a(fVar)) {
                if (!this.a.offer(fVar)) {
                    b(fVar);
                } else if (this.g == 0) {
                    a();
                }
            }
        }

        private void d(com.igexin.c.a.d.f fVar) {
            if (this.g >= this.f || !a(fVar)) {
                if (!this.a.offer(fVar)) {
                    b(fVar);
                } else if (this.g == 0) {
                    a();
                }
            }
        }

        private java.lang.Thread e(com.igexin.c.a.d.f fVar) {
            com.igexin.c.a.d.g.a.RunnableC0016a runnableC0016a = new com.igexin.c.a.d.g.a.RunnableC0016a(fVar);
            if (fVar != null && fVar.C != 0) {
                this.b.put(java.lang.Integer.valueOf(fVar.C), runnableC0016a);
            }
            java.lang.Thread threadNewThread = this.d.newThread(runnableC0016a);
            if (threadNewThread != null) {
                this.g++;
            }
            return threadNewThread;
        }

        final void a() {
            java.util.concurrent.locks.ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                java.lang.Thread threadE = null;
                if (this.g < java.lang.Math.max(this.f, 1) && !this.a.isEmpty()) {
                    threadE = e(null);
                }
                if (threadE != null) {
                    threadE.start();
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        final boolean a(com.igexin.c.a.d.f fVar) {
            java.util.concurrent.locks.ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                java.lang.Thread threadE = this.g < this.f ? e(fVar) : null;
                if (threadE == null) {
                    return false;
                }
                threadE.start();
                return true;
            } finally {
                reentrantLock.unlock();
            }
        }

        final boolean a(com.igexin.c.a.d.g.a.RunnableC0016a runnableC0016a) {
            java.util.concurrent.locks.ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                int i = this.g - 1;
                this.g = i;
                if (i == 0 && !this.a.isEmpty()) {
                    java.lang.Thread threadE = e(null);
                    if (threadE != null) {
                        threadE.start();
                    }
                } else if (!runnableC0016a.a.isEmpty()) {
                    return true;
                }
                this.b.remove(java.lang.Integer.valueOf(runnableC0016a.d));
                reentrantLock.unlock();
                return false;
            } finally {
                reentrantLock.unlock();
            }
        }

        final com.igexin.c.a.d.f b() {
            com.igexin.c.a.d.f fVarPoll;
            while (true) {
                try {
                    fVarPoll = this.g > this.f ? this.a.poll(this.e, java.util.concurrent.TimeUnit.NANOSECONDS) : this.a.take();
                } catch (java.lang.InterruptedException e) {
                    com.igexin.c.a.c.a.a(e);
                }
                if (fVarPoll != null) {
                    return fVarPoll;
                }
                if (this.a.isEmpty()) {
                    return null;
                }
            }
        }

        final boolean b(com.igexin.c.a.d.f fVar) {
            java.util.concurrent.locks.ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                java.lang.Thread threadE = this.g < this.h ? e(fVar) : null;
                if (threadE == null) {
                    return false;
                }
                threadE.start();
                return true;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final class b extends java.lang.Thread {
        volatile boolean a = true;
        long b;
        long c;
        com.igexin.c.a.d.g.a d;

        public b() {
            setName("TS-processor");
        }

        private static void a() {
        }

        /* JADX WARN: Can't wrap try/catch for region: R(11:(4:(2:(3:128|11|(2:135|132)(3:121|81|125))|124)|96|72|(2:74|(4:130|80|133|132)(4:131|79|134|132))(4:122|81|125|124))(6:102|14|(5:119|16|(1:18)|19|(2:21|(5:23|100|24|123|(4:107|26|27|118)(2:106|28))(1:105))(3:104|42|43))(2:44|(4:120|48|126|124))|3|4|(1:5))|98|50|51|(1:53)|54|(2:56|(1:58))|59|96|72|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
        
            if (r4.g >= r4.f) goto L108;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0085, code lost:
        
            if (r4.a(r5) != false) goto L114;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x008d, code lost:
        
            if (r4.a.offer(r5) == false) goto L110;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0091, code lost:
        
            if (r4.g != 0) goto L116;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0093, code lost:
        
            r4.a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0098, code lost:
        
            r4.b(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00fd, code lost:
        
            r4 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00fe, code lost:
        
            com.igexin.c.a.c.a.a(r4);
            com.igexin.c.a.c.a.a(com.igexin.c.a.d.g.h, r4.toString());
            com.igexin.c.a.c.a.a("TaskService|SERVICE_PROCESSING|error|" + r4.toString(), new java.lang.Object[0]);
            r5.v = true;
            r5.E = r4;
            r5.p();
            r5.l();
            r13.e.r.a(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0130, code lost:
        
            r13.e.f();
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0137, code lost:
        
            if (r5.v == false) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0139, code lost:
        
            r5.d_();
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x013e, code lost:
        
            if (r5.m == false) goto L69;
         */
        /* JADX WARN: Removed duplicated region for block: B:122:0x0161 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0152  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() {
            /*
                Method dump skipped, instruction units count: 421
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.igexin.c.a.d.g.b.run():void");
        }
    }

    protected g() {
        com.igexin.c.a.d.f.H = this;
    }

    private static int a(com.igexin.c.a.d.f fVar, com.igexin.c.a.d.f fVar2) {
        if (fVar.w < fVar2.w) {
            return -1;
        }
        if (fVar.w > fVar2.w) {
            return 1;
        }
        if (fVar.D > fVar2.D) {
            return -1;
        }
        if (fVar.D < fVar2.D) {
            return 1;
        }
        if (fVar.x < fVar2.x) {
            return -1;
        }
        if (fVar.x > fVar2.x) {
            return 1;
        }
        return fVar.hashCode() - fVar2.hashCode();
    }

    private void a() {
        try {
            android.app.PendingIntent pendingIntent = this.y;
            if (pendingIntent != null) {
                this.w.cancel(pendingIntent);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(h, th.toString());
        }
    }

    private void a(int i2, java.util.concurrent.TimeUnit timeUnit) {
        this.p.b = java.util.concurrent.TimeUnit.MILLISECONDS.convert(i2, timeUnit);
    }

    private void a(android.content.Context context) {
        if (this.I) {
            return;
        }
        if (!com.igexin.push.g.o.l()) {
            this.v = (android.os.PowerManager) context.getSystemService("power");
            this.D = true;
            this.w = (android.app.AlarmManager) context.getSystemService("alarm");
            try {
                if (android.os.Build.VERSION.SDK_INT >= 31) {
                    this.t = ((java.lang.Boolean) android.app.AlarmManager.class.getDeclaredMethod("canScheduleExactAlarms", null).invoke(this.w, null)).booleanValue();
                } else {
                    this.t = true;
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
            com.igexin.c.a.d.g.AnonymousClass1 anonymousClass1 = new com.igexin.c.a.d.g.AnonymousClass1(context);
            if (android.os.Build.VERSION.SDK_INT > 33) {
                context.registerReceiver(this, anonymousClass1, com.igexin.push.core.e.ac, null, 4);
            } else {
                context.registerReceiver(this, anonymousClass1, com.igexin.push.core.e.ac, null);
            }
            this.B = H + context.getPackageName();
            if (android.os.Build.VERSION.SDK_INT > 33) {
                context.registerReceiver(this, new android.content.IntentFilter(this.B), com.igexin.push.core.e.ac, null, 4);
            } else {
                context.registerReceiver(this, new android.content.IntentFilter(this.B), com.igexin.push.core.e.ac, null);
            }
            int i2 = (com.igexin.push.g.o.a(context) < 31 || android.os.Build.VERSION.SDK_INT < 30) ? 134217728 : 201326592;
            this.x = new android.content.Intent(F + context.getPackageName());
            this.y = android.app.PendingIntent.getBroadcast(context, hashCode(), this.x, i2);
            hashCode();
            this.z = new android.content.Intent(this.B);
            this.A = android.app.PendingIntent.getBroadcast(context, hashCode() + 2, this.z, i2);
            hashCode();
        }
        this.p.start();
        try {
            java.lang.Thread.yield();
        } catch (java.lang.Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
        }
        this.I = true;
    }

    private static boolean a(com.igexin.c.a.d.a.e eVar, com.igexin.c.a.d.a.c cVar) {
        int iC = eVar.c();
        if (iC <= Integer.MIN_VALUE || iC >= 0) {
            if (iC < 0 || iC >= Integer.MAX_VALUE) {
                return false;
            }
            return cVar.a(eVar);
        }
        com.igexin.c.a.d.f fVar = (com.igexin.c.a.d.f) eVar;
        boolean zA = fVar.v ? false : cVar.a(eVar);
        if (zA) {
            fVar.d_();
        }
        return zA;
    }

    private boolean a(com.igexin.c.a.d.f fVar) {
        com.igexin.c.a.d.e<com.igexin.c.a.d.f> eVar = this.s;
        return eVar != null && eVar.c(fVar);
    }

    private boolean a(com.igexin.c.a.d.f fVar, boolean z, int i2, long j2, byte b2, java.lang.Object obj, com.igexin.c.a.d.a.d dVar, int i3, com.igexin.c.a.d.a.g gVar) {
        fVar.getClass();
        fVar.A = i2;
        fVar.a((int) b2);
        fVar.F = obj;
        fVar.O = dVar;
        fVar.a(j2, java.util.concurrent.TimeUnit.MILLISECONDS);
        fVar.a(i3, gVar);
        return a(fVar, z);
    }

    private boolean a(java.lang.Class cls) {
        com.igexin.c.a.d.e<com.igexin.c.a.d.f> eVar = this.s;
        return eVar != null && eVar.a(cls);
    }

    private void b(long j2) {
        if (com.igexin.push.g.o.l()) {
            return;
        }
        com.igexin.c.a.c.a.a("setnioalarm|" + new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(j2)), new java.lang.Object[0]);
        if (j2 < 0) {
            j2 = java.lang.System.currentTimeMillis() + E;
        }
        try {
            try {
                if (this.t) {
                    this.w.setExact(0, j2, this.A);
                } else if (android.os.Build.VERSION.SDK_INT > 23) {
                    this.w.setAndAllowWhileIdle(0, j2, this.y);
                } else {
                    this.w.set(0, j2, this.A);
                }
            } catch (java.lang.Exception unused) {
                this.w.set(0, j2, this.A);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(h, th.toString());
        }
    }

    private boolean b() {
        com.igexin.c.a.d.e<com.igexin.c.a.d.f> eVar = this.s;
        if (eVar == null) {
            return false;
        }
        eVar.c.clear();
        return true;
    }

    public final void a(long j2) {
        if (this.D) {
            com.igexin.c.a.c.a.a("setalarm|" + new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(j2)), new java.lang.Object[0]);
            if (j2 < 0) {
                j2 = java.lang.System.currentTimeMillis() + E;
            }
            try {
                if (this.y != null) {
                    try {
                        if (this.t) {
                            this.w.setExact(0, j2, this.y);
                        } else if (android.os.Build.VERSION.SDK_INT > 23) {
                            this.w.setAndAllowWhileIdle(0, j2, this.y);
                        } else {
                            this.w.set(0, j2, this.y);
                        }
                    } catch (java.lang.Throwable unused) {
                        this.w.set(0, j2, this.y);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(h, th.toString());
                com.igexin.c.a.c.a.a(h + th.toString(), new java.lang.Object[0]);
            }
        }
    }

    public final boolean a(com.igexin.c.a.d.a.c cVar) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.u;
        if (reentrantLock.tryLock()) {
            try {
                if (this.q.containsKey(java.lang.Long.valueOf(cVar.g()))) {
                    return false;
                }
                this.q.put(java.lang.Long.valueOf(cVar.g()), cVar);
                reentrantLock.unlock();
                return true;
            } catch (java.lang.Throwable th) {
                try {
                    com.igexin.c.a.c.a.a(th);
                    com.igexin.c.a.c.a.a("TaskService|" + th.toString(), new java.lang.Object[0]);
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
        return false;
    }

    public final boolean a(com.igexin.c.a.d.f fVar, boolean z) {
        fVar.getClass();
        int iIncrementAndGet = 0;
        if (fVar.q || fVar.m) {
            return false;
        }
        fVar.getClass().getName();
        com.igexin.c.a.d.e<com.igexin.c.a.d.f> eVar = this.s;
        if ((fVar instanceof com.igexin.c.a.b.f) && (((com.igexin.c.a.b.f) fVar).d instanceof com.igexin.push.d.c.o)) {
            if (z) {
                iIncrementAndGet = Integer.MAX_VALUE;
            }
        } else if (z) {
            iIncrementAndGet = eVar.d.incrementAndGet();
        }
        fVar.D = iIncrementAndGet;
        return eVar.a(fVar);
    }

    public final boolean a(com.igexin.c.a.d.f fVar, boolean z, boolean z2) {
        fVar.getClass();
        boolean z3 = false;
        if (fVar.n) {
            return false;
        }
        if (!z || z2) {
            if (z2 && z) {
                z3 = true;
            }
            return a(fVar, z3);
        }
        fVar.d();
        try {
            try {
                fVar.b_();
                fVar.o();
                if (!fVar.v) {
                    fVar.d_();
                }
                return true;
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
                fVar.v = true;
                fVar.E = e;
                fVar.l();
                fVar.p();
                a((java.lang.Object) fVar);
                e();
                if (!fVar.v) {
                    fVar.d_();
                }
                return false;
            }
        } catch (java.lang.Throwable th) {
            if (!fVar.v) {
                fVar.d_();
            }
            throw th;
        }
    }

    public final boolean a(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        obj.getClass().getName();
        obj.hashCode();
        try {
            if (obj instanceof com.igexin.push.d.c.n) {
                obj.getClass().getName();
                obj.hashCode();
            }
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        obj.getClass().getName();
        obj.hashCode();
        com.igexin.c.a.c.a.a("TaskService|responseQueue ++ task = " + obj.getClass().getName() + "@" + obj.hashCode(), new java.lang.Object[0]);
        if (!(obj instanceof com.igexin.c.a.d.a.e)) {
            throw new java.lang.ClassCastException("response Obj is not a TaskResult ");
        }
        com.igexin.c.a.d.a.e eVar = (com.igexin.c.a.d.a.e) obj;
        if (eVar.j()) {
            return false;
        }
        eVar.a(false);
        if ((obj instanceof com.igexin.push.d.b.a) || (obj instanceof com.igexin.push.d.b.b)) {
            this.r.a();
            com.igexin.c.a.c.a.a("TaskService|change to primaryQueue", new java.lang.Object[0]);
        }
        this.r.a(eVar);
        return true;
    }

    @Override // java.util.Comparator
    public /* synthetic */ int compare(com.igexin.c.a.d.f fVar, com.igexin.c.a.d.f fVar2) {
        com.igexin.c.a.d.f fVar3 = fVar;
        com.igexin.c.a.d.f fVar4 = fVar2;
        if (fVar3.w < fVar4.w) {
            return -1;
        }
        if (fVar3.w > fVar4.w) {
            return 1;
        }
        if (fVar3.D > fVar4.D) {
            return -1;
        }
        if (fVar3.D < fVar4.D) {
            return 1;
        }
        if (fVar3.x < fVar4.x) {
            return -1;
        }
        if (fVar3.x > fVar4.x) {
            return 1;
        }
        return fVar3.hashCode() - fVar4.hashCode();
    }

    public final void d() {
        try {
            android.app.PendingIntent pendingIntent = this.A;
            if (pendingIntent != null) {
                this.w.cancel(pendingIntent);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(h, th.toString());
        }
    }

    protected final void e() {
        com.igexin.c.a.d.g.b bVar = this.p;
        if (bVar == null || bVar.isInterrupted()) {
            return;
        }
        this.p.interrupt();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0000 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void f() {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.c.a.d.g.f():void");
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.D = true;
            com.igexin.c.a.c.a.a("screenoff", new java.lang.Object[0]);
            if (this.s.g.get() > 0) {
                a(this.s.g.get());
                return;
            }
            return;
        }
        if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
            this.D = false;
            com.igexin.c.a.c.a.a("screenon", new java.lang.Object[0]);
            return;
        }
        if (intent.getAction().startsWith(F) || intent.getAction().startsWith(G)) {
            java.util.Calendar.getInstance().getTime().toLocaleString();
            com.igexin.c.a.c.a.a("receivealarm|" + this.D, new java.lang.Object[0]);
            e();
            return;
        }
        if (this.B.equals(intent.getAction())) {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            com.igexin.c.a.c.a.b(i, "CPU ON + NioAlarmReceiver:-> cTime; " + calendar.getTime().toLocaleString());
            try {
                com.igexin.c.a.c.a.a(h, " alarm time out #######");
                com.igexin.c.a.c.a.a("TaskService|alarm time out #######", new java.lang.Object[0]);
                com.igexin.c.a.b.a.a.d.a().f();
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }
}
