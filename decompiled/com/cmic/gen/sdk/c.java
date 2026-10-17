package com.cmic.gen.sdk;

/* JADX INFO: compiled from: AsusOAID.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class c extends com.cmic.gen.sdk.o0 {
    private final android.content.Context a;
    private final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b = new java.util.concurrent.LinkedBlockingQueue<>(1);
    private final android.content.ServiceConnection c = new com.cmic.gen.sdk.c.a();

    /* JADX INFO: compiled from: AsusOAID.java */
    class a implements android.content.ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                com.cmic.gen.sdk.c.this.b.offer(iBinder, com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS, java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (java.lang.Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    c(android.content.Context context) {
        this.a = context;
    }

    @Override // com.cmic.gen.sdk.o0
    public java.lang.String a() {
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new android.content.ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        java.lang.String string = "";
        if (this.a.bindService(intent, this.c, 1)) {
            try {
                android.os.IBinder iBinderPoll = this.b.poll(com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS, java.util.concurrent.TimeUnit.MILLISECONDS);
                if (iBinderPoll == null) {
                    return "";
                }
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    iBinderPoll.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                    this.a.unbindService(this.c);
                    parcelObtain.recycle();
                } catch (java.lang.Throwable unused) {
                    parcelObtain.recycle();
                }
                parcelObtain2.recycle();
            } catch (java.lang.Exception unused2) {
            }
        }
        return string;
    }
}
