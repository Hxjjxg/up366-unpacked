package com.igexin.b;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class a {
    private static java.lang.String b = "GTSDK-thread-pool | ";
    public final java.util.concurrent.ThreadPoolExecutor a;
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.ThreadPoolExecutor> c;
    private java.util.concurrent.ScheduledThreadPoolExecutor d;
    private final java.util.concurrent.atomic.AtomicInteger e;
    private final java.util.concurrent.atomic.AtomicInteger f;
    private int g;

    /* JADX INFO: renamed from: com.igexin.b.a$a, reason: collision with other inner class name */
    static class C0013a {
        private static final com.igexin.b.a a = new com.igexin.b.a(0);

        private C0013a() {
        }
    }

    private a() {
        this.c = new java.util.concurrent.ConcurrentHashMap<>();
        this.e = new java.util.concurrent.atomic.AtomicInteger(0);
        this.f = new java.util.concurrent.atomic.AtomicInteger(0);
        this.g = 30;
        this.a = new java.util.concurrent.ThreadPoolExecutor(0, java.lang.Runtime.getRuntime().availableProcessors() * 2, this.g, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), new java.util.concurrent.ThreadFactory() { // from class: com.igexin.b.a.1
            @Override // java.util.concurrent.ThreadFactory
            public final java.lang.Thread newThread(java.lang.Runnable runnable) {
                java.lang.Thread thread = new java.lang.Thread(runnable, "gt-thread-multiple " + com.igexin.b.a.this.e.getAndIncrement());
                thread.setUncaughtExceptionHandler(new java.lang.Thread.UncaughtExceptionHandler() { // from class: com.igexin.b.a.1.1
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public final void uncaughtException(java.lang.Thread thread2, java.lang.Throwable th) {
                        com.igexin.c.a.c.a.a(com.igexin.b.a.b + "| caught an exception from " + thread2.getName(), th);
                    }
                });
                return thread;
            }
        }, new java.util.concurrent.RejectedExecutionHandler() { // from class: com.igexin.b.a.2
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
                if (com.igexin.push.core.ServiceManager.b != null) {
                    com.igexin.c.a.c.a.a(com.igexin.b.a.b + "|gtsdk-multiple-thread rejected task tasknum = " + threadPoolExecutor.getActiveCount(), new java.lang.Object[0]);
                }
            }
        });
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static com.igexin.b.a a() {
        return com.igexin.b.a.C0013a.a;
    }

    private java.util.concurrent.ThreadPoolExecutor d() {
        return this.a;
    }

    public final java.util.concurrent.ThreadPoolExecutor a(java.lang.String str) {
        final java.lang.String strConcat = android.text.TextUtils.isEmpty(str) ? "gt-thread" : "gt-thread-".concat(java.lang.String.valueOf(str));
        if (this.c.containsKey(strConcat)) {
            return this.c.get(strConcat);
        }
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(0, 1, this.g, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), new java.util.concurrent.ThreadFactory() { // from class: com.igexin.b.a.3
            @Override // java.util.concurrent.ThreadFactory
            public final java.lang.Thread newThread(java.lang.Runnable runnable) {
                java.lang.Thread thread = new java.lang.Thread(runnable, strConcat);
                thread.setUncaughtExceptionHandler(new java.lang.Thread.UncaughtExceptionHandler() { // from class: com.igexin.b.a.3.1
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public final void uncaughtException(java.lang.Thread thread2, java.lang.Throwable th) {
                        com.igexin.c.a.c.a.a(com.igexin.b.a.b + "| caught an exception from " + thread2.getName(), th);
                    }
                });
                return thread;
            }
        }, new java.util.concurrent.RejectedExecutionHandler() { // from class: com.igexin.b.a.4
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor2) {
                if (com.igexin.push.core.ServiceManager.b != null) {
                    com.igexin.c.a.c.a.a(com.igexin.b.a.b + "singleThread rejected task tasknum = " + threadPoolExecutor2.getActiveCount(), new java.lang.Object[0]);
                }
            }
        });
        this.c.put(strConcat, threadPoolExecutor);
        return threadPoolExecutor;
    }

    public final java.util.concurrent.ScheduledThreadPoolExecutor b() {
        if (this.d == null) {
            final java.lang.String str = "gt-thread-delay";
            this.d = new java.util.concurrent.ScheduledThreadPoolExecutor(0, new java.util.concurrent.ThreadFactory() { // from class: com.igexin.b.a.5
                @Override // java.util.concurrent.ThreadFactory
                public final java.lang.Thread newThread(java.lang.Runnable runnable) {
                    java.lang.Thread thread = new java.lang.Thread(runnable, str);
                    thread.setUncaughtExceptionHandler(new java.lang.Thread.UncaughtExceptionHandler() { // from class: com.igexin.b.a.5.1
                        @Override // java.lang.Thread.UncaughtExceptionHandler
                        public final void uncaughtException(java.lang.Thread thread2, java.lang.Throwable th) {
                            com.igexin.c.a.c.a.a(com.igexin.b.a.b + "| caught an exception from " + thread2.getName(), th);
                        }
                    });
                    return thread;
                }
            });
        }
        return this.d;
    }
}
