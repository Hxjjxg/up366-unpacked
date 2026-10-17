package com.cmic.gen.sdk;

/* JADX INFO: compiled from: LenovoOAID.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class d0 extends com.cmic.gen.sdk.o0 {
    private final android.content.Context a;
    private final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b = new java.util.concurrent.LinkedBlockingQueue<>(1);
    private final android.content.ServiceConnection c = new com.cmic.gen.sdk.d0.a();

    /* JADX INFO: compiled from: LenovoOAID.java */
    class a implements android.content.ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                com.cmic.gen.sdk.d0.this.b.offer(iBinder, com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS, java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (java.lang.InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    d0(android.content.Context context) {
        this.a = context;
    }

    @Override // com.cmic.gen.sdk.o0
    public java.lang.String a() {
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        java.lang.String string = "";
        if (this.a.bindService(intent, this.c, 1)) {
            android.os.Parcel parcelObtain = android.os.Parcel.obtain();
            android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
            try {
                android.os.IBinder iBinderPoll = this.b.poll(com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS, java.util.concurrent.TimeUnit.MILLISECONDS);
                if (iBinderPoll == null) {
                    return "";
                }
                parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                iBinderPoll.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
            } catch (java.lang.Exception unused) {
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                this.a.unbindService(this.c);
            }
        }
        return string;
    }
}
