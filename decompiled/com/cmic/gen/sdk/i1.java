package com.cmic.gen.sdk;

/* JADX INFO: compiled from: SignUtil.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class i1 {
    public static byte[] a(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (context.getPackageName().equalsIgnoreCase(str)) {
            try {
                android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
                if (packageInfo.packageName.equals(str)) {
                    return packageInfo.signatures[0].toByteArray();
                }
            } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] a(android.content.Context context) {
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                android.content.pm.SigningInfo signingInfoM = androidx.core.app.NotificationCompat$.ExternalSyntheticApiModelOutline0.m(packageManager.getPackageInfo(context.getPackageName(), 134217728));
                android.content.pm.Signature[] signatureArrM = signingInfoM != null ? com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(signingInfoM) : null;
                if (signatureArrM != null && signatureArrM.length > 0) {
                    return signatureArrM[0].toByteArray();
                }
            }
            android.content.pm.Signature[] signatureArr = packageManager.getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr != null && signatureArr.length > 0) {
                return signatureArr[0].toByteArray();
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
