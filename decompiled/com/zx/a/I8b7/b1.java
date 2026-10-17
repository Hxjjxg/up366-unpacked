package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class b1 {

    public class a implements com.zx.module.base.Callback {
        public final /* synthetic */ java.lang.String[] a;
        public final /* synthetic */ java.util.concurrent.CountDownLatch b;

        public a(java.lang.String[] strArr, java.util.concurrent.CountDownLatch countDownLatch) {
            this.a = strArr;
            this.b = countDownLatch;
        }

        @Override // com.zx.module.base.Callback
        public void callback(java.lang.String str) {
            try {
                this.a[0] = str;
                this.b.countDown();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static final java.lang.String a() {
        java.lang.String[] strArr = {""};
        try {
            java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
            java.lang.Thread thread = new java.lang.Thread(new com.zx.a.I8b7.c1(new com.zx.a.I8b7.b1.a(strArr, countDownLatch)));
            thread.setUncaughtExceptionHandler(new com.zx.a.I8b7.d1());
            thread.start();
            countDownLatch.await(1L, java.util.concurrent.TimeUnit.SECONDS);
        } catch (java.lang.Throwable unused) {
        }
        return strArr[0];
    }
}
