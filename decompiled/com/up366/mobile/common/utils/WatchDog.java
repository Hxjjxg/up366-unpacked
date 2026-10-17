package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WatchDog {
    private final android.os.Handler handler;
    private final java.lang.Runnable runnable;
    private final android.os.HandlerThread thread;
    private final long timeout;

    public WatchDog(long j, java.lang.Runnable runnable) {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("watchdog");
        this.thread = handlerThread;
        handlerThread.start();
        android.os.Handler handler = new android.os.Handler(handlerThread.getLooper());
        this.handler = handler;
        this.timeout = j;
        this.runnable = runnable;
        handler.postDelayed(runnable, j);
    }

    public void feed() {
        if (this.thread.isAlive()) {
            this.handler.removeCallbacks(this.runnable);
            this.handler.postDelayed(this.runnable, this.timeout);
        }
    }

    public void cancel() {
        this.handler.removeCallbacks(this.runnable);
        this.thread.quit();
    }
}
