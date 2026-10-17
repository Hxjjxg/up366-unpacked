package com.igexin.push.c;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class e {
    private static final java.lang.String e = "DT_DetectRunTask";
    private static final long f = 60;
    java.util.concurrent.Future<com.igexin.push.c.d> a;
    com.igexin.push.c.d b;
    com.igexin.push.c.i c;
    boolean d;

    /* JADX INFO: renamed from: com.igexin.push.c.e$1, reason: invalid class name */
    final class AnonymousClass1 implements java.util.concurrent.Callable<com.igexin.push.c.d> {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.igexin.push.c.d call() throws java.lang.Throwable {
            java.lang.Thread.currentThread().hashCode();
            com.igexin.b.a.a().a.getActiveCount();
            if (!java.lang.Thread.currentThread().isInterrupted()) {
                java.net.Socket socket = null;
                try {
                    try {
                    } catch (java.lang.Exception e) {
                        e = e;
                    }
                    if (java.lang.Thread.currentThread().isInterrupted()) {
                        com.igexin.c.a.c.a.a(com.igexin.push.c.e.e, java.lang.Thread.currentThread().getName() + " is interrupted ######");
                        java.lang.Thread.currentThread().hashCode();
                        com.igexin.b.a.a().a.getActiveCount();
                        return null;
                    }
                    synchronized (com.igexin.push.c.i.class) {
                    }
                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                    java.lang.String[] strArrA = com.igexin.c.a.b.g.a(com.igexin.push.c.e.this.b.a());
                    java.net.Socket socket2 = new java.net.Socket();
                    try {
                        socket2.connect(new java.net.InetSocketAddress(strArrA[1], com.igexin.push.c.e.this.b.b), com.igexin.push.c.b.b);
                        long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
                        java.lang.String strA = com.igexin.push.c.e.a(socket2.getInetAddress());
                        com.igexin.push.c.e.this.b.a("socket://" + strA + ":" + com.igexin.push.c.e.this.b.b, jCurrentTimeMillis2 - jCurrentTimeMillis, jCurrentTimeMillis2);
                        com.igexin.push.c.e.this.c();
                        com.igexin.c.a.c.a.a("DT_DetectRunTask|detect " + com.igexin.push.c.e.this.c() + "|time = " + com.igexin.push.c.e.this.b.c(), new java.lang.Object[0]);
                        synchronized (com.igexin.push.c.i.class) {
                            if (com.igexin.push.c.e.this.c != null && !java.lang.Thread.currentThread().isInterrupted()) {
                                com.igexin.push.c.e.this.c.a(com.igexin.push.c.b.a.a, com.igexin.push.c.e.this.b);
                            }
                            if (!socket2.isClosed()) {
                                try {
                                    socket2.close();
                                } catch (java.lang.Exception e2) {
                                    e = e2;
                                    com.igexin.c.a.c.a.a(e);
                                }
                            }
                        }
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        socket = socket2;
                        com.igexin.c.a.c.a.b(com.igexin.push.c.e.e, "|detect " + com.igexin.push.c.e.this.c() + "thread -->" + e.getMessage());
                        synchronized (com.igexin.push.c.i.class) {
                            if (com.igexin.push.c.e.this.c != null) {
                                com.igexin.push.c.e.this.b.b();
                                com.igexin.push.c.e.this.c.a(com.igexin.push.c.b.a.c, com.igexin.push.c.e.this.b);
                            }
                            if (socket != null && !socket.isClosed()) {
                                try {
                                    socket.close();
                                } catch (java.lang.Exception e4) {
                                    e = e4;
                                    com.igexin.c.a.c.a.a(e);
                                }
                            }
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        socket = socket2;
                        if (socket != null) {
                            try {
                                socket.close();
                            } catch (java.lang.Exception e5) {
                                com.igexin.c.a.c.a.a(e5);
                            }
                        }
                        java.lang.Thread.currentThread().hashCode();
                        com.igexin.b.a.a().a.getActiveCount();
                        throw th;
                    }
                    java.lang.Thread.currentThread().hashCode();
                    com.igexin.b.a.a().a.getActiveCount();
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (socket != null && !socket.isClosed()) {
                        socket.close();
                    }
                    java.lang.Thread.currentThread().hashCode();
                    com.igexin.b.a.a().a.getActiveCount();
                    throw th;
                }
            }
            return com.igexin.push.c.e.this.b;
        }
    }

    public static java.lang.String a(java.net.InetAddress inetAddress) throws java.lang.NoSuchMethodException {
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("java.net.InetAddress").getDeclaredMethod("holder", null);
            declaredMethod.setAccessible(true);
            java.lang.Object objInvoke = declaredMethod.invoke(inetAddress, null);
            java.lang.reflect.Field declaredField = objInvoke.getClass().getDeclaredField("address");
            declaredField.setAccessible(true);
            int iIntValue = ((java.lang.Integer) declaredField.get(objInvoke)).intValue();
            java.lang.String str = ((iIntValue >>> 24) & 255) + "." + ((iIntValue >>> 16) & 255) + "." + ((iIntValue >>> 8) & 255) + "." + (iIntValue & 255);
            com.igexin.c.a.c.a.b(e, "i new Str: ".concat(java.lang.String.valueOf(str)));
            return str;
        } catch (java.lang.Throwable unused) {
            if (!com.igexin.push.config.d.Z) {
                throw new java.lang.NoSuchMethodException("can't get ad by new method");
            }
            com.igexin.c.a.c.a.b(e, "get ad by original method");
            return inetAddress.getHostAddress();
        }
    }

    private void a(com.igexin.push.c.d dVar) {
        this.b = dVar;
    }

    private void a(boolean z) {
        this.d = z;
    }

    private com.igexin.push.c.d d() {
        return this.b;
    }

    private void e() {
        synchronized (com.igexin.push.c.i.class) {
            if (this.c != null) {
                this.a = com.igexin.b.a.a().a.submit(new com.igexin.push.c.e.AnonymousClass1());
            }
        }
    }

    private void f() {
        this.a = com.igexin.b.a.a().a.submit(new com.igexin.push.c.e.AnonymousClass1());
    }

    private void g() {
        try {
            java.util.concurrent.Future<com.igexin.push.c.d> future = this.a;
            if (future == null || future.isCancelled() || this.a.isDone()) {
                return;
            }
            this.a.cancel(true);
            this.a = null;
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    public final void a() {
        c();
        com.igexin.c.a.c.a.a("DT_DetectRunTask|stop " + c() + " task", new java.lang.Object[0]);
        g();
    }

    public final void a(com.igexin.push.c.i iVar) {
        synchronized (com.igexin.push.c.i.class) {
            this.c = iVar;
        }
    }

    public final void b() {
        a((com.igexin.push.c.i) null);
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final java.lang.String c() {
        return this.b.a() + "|" + this.b.a;
    }
}
