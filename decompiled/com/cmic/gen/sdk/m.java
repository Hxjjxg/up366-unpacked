package com.cmic.gen.sdk;

/* JADX INFO: compiled from: CoolpadOAID.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class m extends com.cmic.gen.sdk.o0 {
    private final android.content.Context a;
    public final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b = new java.util.concurrent.LinkedBlockingQueue<>(1);
    private final android.content.ServiceConnection c = new com.cmic.gen.sdk.m.a();

    /* JADX INFO: compiled from: CoolpadOAID.java */
    class a implements android.content.ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                com.cmic.gen.sdk.m.this.b.offer(iBinder, com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS, java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (java.lang.InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    m(android.content.Context context) {
        this.a = context;
    }

    @Override // com.cmic.gen.sdk.o0
    public java.lang.String a() {
        android.content.Context context;
        android.content.ServiceConnection serviceConnection;
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService");
        java.lang.String string = "";
        if (!this.a.bindService(intent, this.c, 1)) {
            return "";
        }
        try {
            android.os.IBinder iBinderPoll = this.b.poll(com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS, java.util.concurrent.TimeUnit.MILLISECONDS);
            if (iBinderPoll == null) {
                return "";
            }
            android.os.Parcel parcelObtain = android.os.Parcel.obtain();
            android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                iBinderPoll.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
                parcelObtain2.recycle();
                parcelObtain.recycle();
                context = this.a;
                serviceConnection = this.c;
            } catch (java.lang.Throwable unused) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                context = this.a;
                serviceConnection = this.c;
            }
            context.unbindService(serviceConnection);
        } catch (java.lang.InterruptedException unused2) {
        }
        return string;
    }
}
