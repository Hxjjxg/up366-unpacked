package com.cmic.gen.sdk;

/* JADX INFO: compiled from: OppoOAID.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class q0 extends com.cmic.gen.sdk.o0 {
    private final android.content.Context a;
    private final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b = new java.util.concurrent.LinkedBlockingQueue<>(1);
    private final android.content.ServiceConnection c = new com.cmic.gen.sdk.q0.a();

    /* JADX INFO: compiled from: OppoOAID.java */
    class a implements android.content.ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                com.cmic.gen.sdk.q0.this.b.offer(iBinder, com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS, java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    q0(android.content.Context context) {
        this.a = context;
    }

    @Override // com.cmic.gen.sdk.o0
    public java.lang.String a() {
        android.content.Intent intent = new android.content.Intent();
        intent.setComponent(new android.content.ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        java.lang.String strA = "";
        if (!this.a.bindService(intent, this.c, 1)) {
            return "";
        }
        try {
            strA = a(this.b.poll(com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS, java.util.concurrent.TimeUnit.MILLISECONDS));
            this.a.unbindService(this.c);
            return strA;
        } catch (java.lang.Throwable unused) {
            return strA;
        }
    }

    private java.lang.String a(android.os.IBinder iBinder) {
        java.lang.String string = "";
        if (iBinder == null) {
            return "";
        }
        java.lang.String packageName = this.a.getPackageName();
        java.lang.String strA = a(this.a, packageName);
        try {
            android.os.Parcel parcelObtain = android.os.Parcel.obtain();
            android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                parcelObtain.writeString(packageName);
                parcelObtain.writeString(strA);
                parcelObtain.writeString("OUID");
                iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
                parcelObtain.recycle();
                parcelObtain2.recycle();
            } catch (java.lang.Throwable th) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                throw th;
            }
        } catch (java.lang.Exception unused) {
        }
        return string;
    }

    private java.lang.String a(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] bArrDigest = java.security.MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                for (byte b : bArrDigest) {
                    sb.append(java.lang.Integer.toHexString((b & 255) | 256).substring(1, 3));
                }
                return sb.toString();
            }
            return "";
        } catch (java.lang.Exception unused) {
            return "";
        }
    }
}
