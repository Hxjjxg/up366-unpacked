package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class H implements android.os.IInterface {
    private android.os.IBinder a;
    private java.lang.String b;

    private H(android.os.IBinder iBinder, java.lang.String str) {
        this.a = iBinder;
        this.b = str;
    }

    static com.chuanglan.shanyan_sdk.H a(android.os.IBinder iBinder, java.lang.String str) {
        if (iBinder == null) {
            return null;
        }
        android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(str);
        return iInterfaceQueryLocalInterface instanceof com.chuanglan.shanyan_sdk.H ? (com.chuanglan.shanyan_sdk.H) iInterfaceQueryLocalInterface : new com.chuanglan.shanyan_sdk.H(iBinder, str);
    }

    @Override // android.os.IInterface
    public android.os.IBinder asBinder() {
        return this.a;
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
        try {
            try {
                parcelObtain.writeInterfaceToken(this.b);
                if (!android.text.TextUtils.isEmpty(str)) {
                    parcelObtain.writeString(str);
                }
                if (!android.text.TextUtils.isEmpty(str2)) {
                    parcelObtain.writeString(str2);
                }
                if (!android.text.TextUtils.isEmpty(str3)) {
                    parcelObtain.writeString(str3);
                }
                this.a.transact(i, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } catch (java.lang.Exception unused) {
                return "";
            }
        } catch (java.lang.Throwable unused2) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            return "";
        }
    }
}
