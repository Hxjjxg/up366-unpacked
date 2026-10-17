package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class CountDownTimer {
    private static final int MSG = 1;
    private final long mCountdownInterval;
    private long mMillisInFuture;
    private long mStopTimeInFuture;
    private boolean mCancelled = false;
    private boolean mPaused = false;
    private final android.os.Handler mHandler = new android.os.Handler((android.os.Looper) java.util.Objects.requireNonNull(android.os.Looper.myLooper())) { // from class: com.up366.mobile.common.utils.CountDownTimer.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            long j;
            synchronized (com.up366.mobile.common.utils.CountDownTimer.this) {
                if (com.up366.mobile.common.utils.CountDownTimer.this.mCancelled) {
                    return;
                }
                long jElapsedRealtime = com.up366.mobile.common.utils.CountDownTimer.this.mStopTimeInFuture - android.os.SystemClock.elapsedRealtime();
                long j2 = 0;
                if (jElapsedRealtime <= 0) {
                    com.up366.mobile.common.utils.CountDownTimer.this.onFinish();
                } else {
                    long jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
                    com.up366.mobile.common.utils.CountDownTimer.this.onTick(jElapsedRealtime);
                    long jElapsedRealtime3 = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    if (jElapsedRealtime >= com.up366.mobile.common.utils.CountDownTimer.this.mCountdownInterval) {
                        j = com.up366.mobile.common.utils.CountDownTimer.this.mCountdownInterval - jElapsedRealtime3;
                        while (j < 0) {
                            j += com.up366.mobile.common.utils.CountDownTimer.this.mCountdownInterval;
                        }
                    } else {
                        j = jElapsedRealtime - jElapsedRealtime3;
                        if (j < 0) {
                        }
                        sendMessageDelayed(obtainMessage(1), j2);
                    }
                    j2 = j;
                    sendMessageDelayed(obtainMessage(1), j2);
                }
            }
        }
    };

    public abstract void onFinish();

    public abstract void onTick(long j);

    public CountDownTimer(long j, long j2) {
        this.mMillisInFuture = j;
        this.mCountdownInterval = j2;
    }

    public final synchronized void cancel() {
        this.mCancelled = true;
        this.mHandler.removeMessages(1);
    }

    public final synchronized void pause() {
        this.mCancelled = true;
        this.mMillisInFuture = this.mStopTimeInFuture - android.os.SystemClock.elapsedRealtime();
        this.mHandler.removeMessages(1);
    }

    public final synchronized com.up366.mobile.common.utils.CountDownTimer start() {
        this.mCancelled = false;
        if (this.mMillisInFuture <= 0) {
            onFinish();
            return this;
        }
        this.mStopTimeInFuture = android.os.SystemClock.elapsedRealtime() + this.mMillisInFuture;
        android.os.Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}
