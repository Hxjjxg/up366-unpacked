package com.zx.sdk.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ZXTask implements java.lang.Runnable {
    private com.zx.sdk.common.utils.ZXTask.a errorCallback;
    private java.lang.Runnable r;

    public interface a {
    }

    public ZXTask(java.lang.Runnable runnable, com.zx.sdk.common.utils.ZXTask.a aVar) {
        this.r = runnable;
        this.errorCallback = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.zx.module.base.Listener listener;
        try {
            java.lang.Runnable runnable = this.r;
            if (runnable != null) {
                runnable.run();
            }
        } catch (java.lang.Throwable th) {
            com.zx.sdk.common.utils.ZXTask.a aVar = this.errorCallback;
            if (aVar == null || (listener = ((com.zx.a.I8b7.e4) aVar).a.c) == null) {
                return;
            }
            listener.onMessage("MESSAGE_ON_ZXID_RECEIVED", com.zx.a.I8b7.o2.a(com.igexin.sdk.PushConsts.GET_SDKSERVICEPID, th.getMessage()));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("ZXCore start failed: ");
            com.zx.a.I8b7.r3.a(th, sb);
        }
    }
}
