package com.up366.notchtools.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ThreadUtils {
    private static android.os.Handler sLogicThreadHandler;
    private static android.os.Handler sMainHandler;
    private static final java.lang.Object sLock = new java.lang.Object();
    private static final java.lang.Object sLogicThreadHandlerLock = new java.lang.Object();
    private static final java.util.concurrent.Executor EXECUTOR = java.util.concurrent.Executors.newFixedThreadPool(4, new java.util.concurrent.ThreadFactory() { // from class: com.up366.notchtools.helper.ThreadUtils.2
        private int count = -1;

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            this.count++;
            return new java.lang.Thread(runnable, "ThreadUtils: " + this.count);
        }
    });

    public interface Consumer<T> {
        void consume(T t);
    }

    public interface Provider<T> {
        T provide();
    }

    private static android.os.Handler getUIThreadHandler() {
        android.os.Handler handler;
        synchronized (sLock) {
            if (sMainHandler == null) {
                sMainHandler = new android.os.Handler(android.os.Looper.getMainLooper());
            }
            handler = sMainHandler;
        }
        return handler;
    }

    public static boolean isMainThread() {
        return java.lang.Thread.currentThread().getId() == android.os.Looper.getMainLooper().getThread().getId();
    }

    public static boolean post2UI(java.lang.Runnable runnable) {
        return getUIThreadHandler().post(runnable);
    }

    public static boolean post2UI(android.content.Context context, java.lang.Runnable runnable) {
        if (context == null) {
            return post2UI(runnable);
        }
        return getUIThreadHandler().postAtTime(runnable, java.lang.Integer.valueOf(context.hashCode()), android.os.SystemClock.uptimeMillis());
    }

    public static boolean postDelayed2UI(java.lang.Runnable runnable, long j) {
        return getUIThreadHandler().postDelayed(runnable, j);
    }

    public static boolean postDelayed2UI(android.content.Context context, java.lang.Runnable runnable, long j) {
        if (context == null) {
            return postDelayed2UI(runnable, j);
        }
        return getUIThreadHandler().postAtTime(runnable, java.lang.Integer.valueOf(context.hashCode()), android.os.SystemClock.uptimeMillis() + j);
    }

    public static void cancelUITask(java.lang.Runnable runnable) {
        getUIThreadHandler().removeCallbacks(runnable);
    }

    public static void cancelUITask(android.content.Context context) {
        if (context != null) {
            getUIThreadHandler().removeCallbacksAndMessages(java.lang.Integer.valueOf(context.hashCode()));
        }
    }

    private static boolean runningOnUI() {
        return getUIThreadHandler().getLooper() == android.os.Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static android.os.Handler getLogicThreadHandler() {
        android.os.Handler handler;
        synchronized (sLogicThreadHandlerLock) {
            if (sLogicThreadHandler == null) {
                android.os.HandlerThread handlerThread = new android.os.HandlerThread("daemon-handler-thread");
                handlerThread.start();
                sLogicThreadHandler = new android.os.Handler(handlerThread.getLooper());
            }
            handler = sLogicThreadHandler;
        }
        return handler;
    }

    public static boolean post2Logic(java.lang.Runnable runnable) {
        return getLogicThreadHandler().post(runnable);
    }

    public static boolean post2Logic(android.content.Context context, java.lang.Runnable runnable) {
        if (context == null) {
            return post2Logic(runnable);
        }
        return getLogicThreadHandler().postAtTime(runnable, java.lang.Integer.valueOf(context.hashCode()), android.os.SystemClock.uptimeMillis());
    }

    private static boolean postDelayed2Logic(java.lang.Runnable runnable, long j) {
        return getLogicThreadHandler().postDelayed(runnable, j);
    }

    public static boolean postDelayed2Logic(android.content.Context context, java.lang.Runnable runnable, long j) {
        if (context == null) {
            return postDelayed2Logic(runnable, j);
        }
        return getLogicThreadHandler().postAtTime(runnable, java.lang.Integer.valueOf(context.hashCode()), android.os.SystemClock.uptimeMillis() + j);
    }

    public static void cancelLogicTask(java.lang.Runnable runnable) {
        getLogicThreadHandler().removeCallbacks(runnable);
    }

    public static void cancelLogicTask(android.content.Context context) {
        if (context != null) {
            getLogicThreadHandler().removeCallbacksAndMessages(java.lang.Integer.valueOf(context.hashCode()));
        }
    }

    public static void delayCancelLogicTask(android.content.Context context, long j) {
        if (context != null) {
            final java.lang.Integer numValueOf = java.lang.Integer.valueOf(context.hashCode());
            postDelayed2Logic(new java.lang.Runnable() { // from class: com.up366.notchtools.helper.ThreadUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    com.up366.notchtools.helper.ThreadUtils.getLogicThreadHandler().removeCallbacksAndMessages(numValueOf);
                }
            }, j);
        }
    }

    public static boolean runningOnLogic() {
        return getLogicThreadHandler().getLooper() == android.os.Looper.myLooper();
    }

    public static void safeCheckUIThread(java.lang.String str) {
        if (runningOnUI()) {
            return;
        }
        throw new java.lang.RuntimeException("ThreadUtils safeCheck alert " + str);
    }

    public static java.lang.String getThreadName() {
        return java.lang.Thread.currentThread().getName() + " : " + java.lang.Thread.currentThread().getId();
    }

    public static void exec(java.lang.Runnable runnable) {
        if (runnable != null) {
            try {
                EXECUTOR.execute(runnable);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static <T> void exec(final com.up366.notchtools.helper.ThreadUtils.Provider<T> provider, final com.up366.notchtools.helper.ThreadUtils.Consumer<T> consumer) {
        if (provider == null) {
            return;
        }
        EXECUTOR.execute(new java.lang.Runnable() { // from class: com.up366.notchtools.helper.ThreadUtils.3
            @Override // java.lang.Runnable
            public void run() {
                final java.lang.Object objProvide;
                try {
                    objProvide = provider.provide();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                    objProvide = null;
                }
                if (consumer == null) {
                    return;
                }
                com.up366.notchtools.helper.ThreadUtils.post2UI(new java.lang.Runnable() { // from class: com.up366.notchtools.helper.ThreadUtils.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            consumer.consume(objProvide);
                        } catch (java.lang.Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
