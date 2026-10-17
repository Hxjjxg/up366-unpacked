package com.cmic.gen.sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class g2 implements android.content.ServiceConnection {
    public static final java.util.concurrent.ThreadPoolExecutor c = new java.util.concurrent.ThreadPoolExecutor(0, 3, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(io.objectbox.model.PropertyFlags.INDEX_HASH), new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
    public boolean a = false;
    public final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b = new java.util.concurrent.LinkedBlockingQueue<>(1);

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(android.os.IBinder iBinder) {
        try {
            android.util.Log.d("OaidSerivceConnection", "onServiceConnected " + java.lang.System.currentTimeMillis());
            this.b.offer(iBinder);
        } catch (java.lang.Throwable th) {
            android.util.Log.e("OaidSerivceConnection", "onServiceConnected  " + th.getMessage());
        }
    }

    public android.os.IBinder a() {
        if (this.a) {
            throw new java.lang.IllegalStateException();
        }
        this.a = true;
        return this.b.take();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, final android.os.IBinder iBinder) {
        android.util.Log.d("OaidSerivceConnection", "onServiceConnected");
        c.execute(new java.lang.Runnable() { // from class: com.cmic.gen.sdk.g2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(iBinder);
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        android.util.Log.d("OaidSerivceConnection", "onServiceDisconnected " + java.lang.System.currentTimeMillis());
    }
}
