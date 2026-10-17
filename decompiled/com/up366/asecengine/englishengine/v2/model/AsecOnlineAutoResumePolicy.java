package com.up366.asecengine.englishengine.v2.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AsecOnlineAutoResumePolicy {
    public static final int DEFAULT_MAX_ATTEMPTS = 6;
    public static final long DEFAULT_MAX_DURATION_MS = 30000;
    private static final long[] DEFAULT_RETRY_BACKOFF_MS = {1000, 2000, com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS, 4000, com.igexin.push.config.c.s};
    public static final int EXHAUST_STRATEGY_WAIT_STOP_THEN_FALLBACK = 0;
    private boolean enabled;
    private int exhaustStrategy;
    private int maxAttempts;
    private long maxDurationMs;
    private long[] retryBackoffMs;

    private static int sanitizeExhaustStrategy(int i) {
        if (i != 0) {
            return 0;
        }
        return i;
    }

    private static int sanitizeMaxAttempts(int i) {
        if (i < 1) {
            return 1;
        }
        return i;
    }

    private static long sanitizeMaxDurationMs(long j) {
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    public AsecOnlineAutoResumePolicy() {
        this.retryBackoffMs = (long[]) DEFAULT_RETRY_BACKOFF_MS.clone();
        this.maxAttempts = 6;
        this.maxDurationMs = 30000L;
        this.exhaustStrategy = 0;
    }

    public AsecOnlineAutoResumePolicy(com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy asecOnlineAutoResumePolicy) {
        this.retryBackoffMs = (long[]) DEFAULT_RETRY_BACKOFF_MS.clone();
        this.maxAttempts = 6;
        this.maxDurationMs = 30000L;
        this.exhaustStrategy = 0;
        if (asecOnlineAutoResumePolicy == null) {
            return;
        }
        this.enabled = asecOnlineAutoResumePolicy.enabled;
        this.retryBackoffMs = sanitizeRetryBackoffMs(asecOnlineAutoResumePolicy.retryBackoffMs);
        this.maxAttempts = sanitizeMaxAttempts(asecOnlineAutoResumePolicy.maxAttempts);
        this.maxDurationMs = sanitizeMaxDurationMs(asecOnlineAutoResumePolicy.maxDurationMs);
        this.exhaustStrategy = sanitizeExhaustStrategy(asecOnlineAutoResumePolicy.exhaustStrategy);
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy setEnabled(boolean z) {
        this.enabled = z;
        return this;
    }

    public long[] getRetryBackoffMs() {
        return (long[]) this.retryBackoffMs.clone();
    }

    public com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy setRetryBackoffMs(long... jArr) {
        this.retryBackoffMs = sanitizeRetryBackoffMs(jArr);
        return this;
    }

    public int getMaxAttempts() {
        return this.maxAttempts;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy setMaxAttempts(int i) {
        this.maxAttempts = sanitizeMaxAttempts(i);
        return this;
    }

    public long getMaxDurationMs() {
        return this.maxDurationMs;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy setMaxDurationMs(long j) {
        this.maxDurationMs = sanitizeMaxDurationMs(j);
        return this;
    }

    public int getExhaustStrategy() {
        return this.exhaustStrategy;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy setExhaustStrategy(int i) {
        this.exhaustStrategy = sanitizeExhaustStrategy(i);
        return this;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy copy() {
        return new com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy(this);
    }

    private static long[] sanitizeRetryBackoffMs(long[] jArr) {
        if (jArr == null || jArr.length == 0) {
            return (long[]) DEFAULT_RETRY_BACKOFF_MS.clone();
        }
        long[] jArrCopyOf = java.util.Arrays.copyOf(jArr, jArr.length);
        for (int i = 0; i < jArrCopyOf.length; i++) {
            if (jArrCopyOf[i] < 0) {
                jArrCopyOf[i] = 0;
            }
        }
        return jArrCopyOf;
    }
}
