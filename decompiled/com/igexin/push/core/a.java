package com.igexin.push.core;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class a extends java.lang.Thread {
    protected abstract void a();

    protected abstract java.lang.String b();

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        java.lang.Thread.currentThread().setName(b());
        if (android.os.Looper.myLooper() == null) {
            android.os.Looper.prepare();
            android.os.Looper.loop();
        }
    }
}
