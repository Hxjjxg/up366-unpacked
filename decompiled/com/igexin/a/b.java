package com.igexin.a;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class b {
    private static final java.lang.String a = "com.igexin.push.extension.distribution.gws.action.guard.WakeCallback";
    private static final int c = 1;
    private android.os.IBinder b;

    public b(android.os.IBinder iBinder) {
        this.b = iBinder;
    }

    private android.os.IBinder a() {
        return this.b;
    }

    public final void a(android.os.Bundle bundle) throws android.os.RemoteException {
        if (this.b == null) {
            return;
        }
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(a);
            parcelObtain.writeInt(1);
            bundle.writeToParcel(parcelObtain, 0);
            this.b.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
