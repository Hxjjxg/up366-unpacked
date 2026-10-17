package com.up366.qrcode.view.decoding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class InactivityTimer {
    private static final int INACTIVITY_DELAY_SECONDS = 300;
    private final android.app.Activity activity;
    private final java.util.concurrent.ScheduledExecutorService inactivityTimer = java.util.concurrent.Executors.newSingleThreadScheduledExecutor(new com.up366.qrcode.view.decoding.InactivityTimer.DaemonThreadFactory());
    private java.util.concurrent.ScheduledFuture<?> inactivityFuture = null;

    public InactivityTimer(android.app.Activity activity) {
        this.activity = activity;
        onActivity();
    }

    public void onActivity() {
        cancel();
        this.inactivityFuture = this.inactivityTimer.schedule(new com.up366.qrcode.view.decoding.FinishListener(this.activity), 300L, java.util.concurrent.TimeUnit.SECONDS);
    }

    private void cancel() {
        java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.inactivityFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.inactivityFuture = null;
        }
    }

    public void shutdown() {
        cancel();
        this.inactivityTimer.shutdown();
    }

    private static final class DaemonThreadFactory implements java.util.concurrent.ThreadFactory {
        private DaemonThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    }
}
