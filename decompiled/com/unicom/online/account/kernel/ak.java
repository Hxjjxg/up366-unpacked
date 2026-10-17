package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class ak implements java.util.concurrent.ThreadFactory {
    public final java.util.concurrent.atomic.AtomicInteger b = new java.util.concurrent.atomic.AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public final java.lang.Thread newThread(java.lang.Runnable runnable) {
        java.lang.Thread thread = new java.lang.Thread(runnable, "LogUploader-" + this.b.getAndIncrement());
        thread.setDaemon(true);
        return thread;
    }
}
