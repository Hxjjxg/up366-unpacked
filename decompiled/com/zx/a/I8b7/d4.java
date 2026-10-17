package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class d4 implements java.lang.Runnable {
    public final /* synthetic */ com.zx.a.I8b7.g4 a;

    public d4(com.zx.a.I8b7.g4 g4Var) {
        this.a = g4Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.m1.a.a.a();
            if (!this.a.b.get()) {
                throw new java.lang.IllegalStateException("ZXSdkImpl not init, should init firstly");
            }
            com.zx.a.I8b7.g4.a(this.a);
        } catch (java.lang.Throwable th) {
            com.zx.module.base.Listener listener = this.a.c;
            if (listener != null) {
                listener.onMessage("MESSAGE_ON_ZXID_RECEIVED", com.zx.a.I8b7.o2.a(10000, th.getMessage()));
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("ZXCore start failed: ");
                com.zx.a.I8b7.r3.a(th, sb);
            }
        }
    }
}
