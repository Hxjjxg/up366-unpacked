package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class Z implements android.content.ServiceConnection {
    private com.chuanglan.shanyan_sdk.H a;
    private java.lang.String b;
    private java.util.concurrent.CountDownLatch c;
    private android.os.IBinder d;

    Z(java.lang.String str, java.util.concurrent.CountDownLatch countDownLatch) {
        this.b = str;
        this.c = countDownLatch;
    }

    public com.chuanglan.shanyan_sdk.H a() {
        return this.a;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        try {
            this.d = iBinder;
            this.c.countDown();
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        this.a = null;
        this.d = null;
    }

    public boolean a(android.content.Context context, android.content.Intent intent) {
        if (context == null) {
            return false;
        }
        if (this.a != null) {
            return true;
        }
        try {
            boolean zBindService = context.bindService(intent, this, 1);
            this.c.await();
            this.a = com.chuanglan.shanyan_sdk.H.a(this.d, this.b);
            return zBindService;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }
}
