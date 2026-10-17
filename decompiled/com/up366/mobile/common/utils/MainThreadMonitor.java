package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MainThreadMonitor {
    private static final int DELAY_MILLIS = 1000;
    private static boolean hasInit;

    public static void monitor() {
        if (hasInit) {
            return;
        }
        hasInit = true;
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("main thread monitor");
        handlerThread.start();
        android.os.Handler handler = new android.os.Handler(handlerThread.getLooper());
        android.os.Looper.getMainLooper().setMessageLogging(new com.up366.mobile.common.utils.MainThreadMonitor.AnonymousClass1(android.os.Looper.getMainLooper().getThread(), handler));
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.utils.MainThreadMonitor$1, reason: invalid class name */
    class AnonymousClass1 implements android.util.Printer {
        final java.lang.Runnable recordStack;
        java.lang.Exception stack;
        long time = android.os.SystemClock.uptimeMillis();
        final /* synthetic */ android.os.Handler val$handler;
        final /* synthetic */ java.lang.Thread val$mainThread;

        AnonymousClass1(final java.lang.Thread thread, android.os.Handler handler) {
            this.val$mainThread = thread;
            this.val$handler = handler;
            this.recordStack = new java.lang.Runnable() { // from class: com.up366.mobile.common.utils.MainThreadMonitor$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$$0(thread);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$$0(java.lang.Thread thread) {
            java.lang.Exception exc = new java.lang.Exception("main thread monitor");
            this.stack = exc;
            exc.setStackTrace(thread.getStackTrace());
        }

        @Override // android.util.Printer
        public void println(java.lang.String str) {
            if (str == null) {
                return;
            }
            if (str.startsWith(">>>>>")) {
                this.time = android.os.SystemClock.uptimeMillis();
                this.val$handler.postDelayed(this.recordStack, 1000L);
            } else if (str.startsWith("<<<<<")) {
                this.val$handler.removeCallbacks(this.recordStack);
                if (this.stack != null) {
                    com.up366.common.log.Logger.info("TAG - MainThreadMonitor - monitor - cost time : " + (android.os.SystemClock.uptimeMillis() - this.time), this.stack);
                    this.stack = null;
                }
            }
        }
    }
}
