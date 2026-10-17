package com.igexin.push.g;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class l {
    private static int a = Integer.MIN_VALUE;
    private static java.lang.String b = "GT_PM";
    private static java.lang.Object c;

    private static int a() {
        int i = a;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        if (com.getui.gtc.base.GtcProvider.context() != null) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName(new java.lang.String(android.util.Base64.decode("YW5kcm9pZC5vcy5Vc2VySGFuZGxl", 0)));
                java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod(new java.lang.String(android.util.Base64.decode("Z2V0VXNlcklk", 0)), java.lang.Integer.TYPE);
                declaredMethod.setAccessible(true);
                int iIntValue = ((java.lang.Integer) declaredMethod.invoke(cls, java.lang.Integer.valueOf(android.os.Process.myUid()))).intValue();
                a = iIntValue;
                return iIntValue;
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
        return 0;
    }

    private static android.content.pm.PackageInfo a(java.lang.Object obj, java.lang.String str, int i) {
        try {
            android.os.IBinder iBinderAsBinder = ((android.os.IInterface) obj).asBinder();
            android.os.Parcel parcelObtain = android.os.Parcel.obtain();
            android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(iBinderAsBinder.getInterfaceDescriptor());
                parcelObtain.writeString(str);
                parcelObtain.writeLong(i);
                parcelObtain.writeInt(a());
                iBinderAsBinder.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                packageInfo = parcelObtain2.readInt() != 0 ? (android.content.pm.PackageInfo) android.content.pm.PackageInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                parcelObtain2.recycle();
                parcelObtain.recycle();
            } catch (java.lang.Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
        }
        return packageInfo;
    }

    public static android.content.pm.PackageInfo a(java.lang.String str, int i) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.pm.PackageInfo packageInfoA = a(str, i, a());
        if (packageInfoA != null) {
            return packageInfoA;
        }
        throw new android.content.pm.PackageManager.NameNotFoundException(str + " not found");
    }

    private static android.content.pm.PackageInfo a(java.lang.String str, int i, int i2) {
        try {
            if (c == null) {
                c = java.lang.Class.forName(new java.lang.String(android.util.Base64.decode("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=", 0))).getMethod(new java.lang.String(android.util.Base64.decode("Z2V0UGFja2FnZU1hbmFnZXI=", 0)), null).invoke(null, null);
            }
            if (android.os.Build.VERSION.SDK_INT >= 33) {
                return a(c, str, i);
            }
            java.lang.String str2 = new java.lang.String(android.util.Base64.decode("Z2V0UGFja2FnZUluZm8=", 0));
            java.lang.Class<?> cls = c.getClass();
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            return (android.content.pm.PackageInfo) cls.getMethod(str2, java.lang.String.class, cls2, cls2).invoke(c, str, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return null;
        }
    }
}
