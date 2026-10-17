package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class B {
    public static java.lang.String a(android.content.Context context) {
        if (context != null) {
            try {
                android.content.pm.Signature[] signatureArr = context.getPackageManager().getPackageInfo(com.chuanglan.shanyan_sdk.C0065v.g().c(context), 64).signatures;
                if (signatureArr != null && signatureArr.length > 0) {
                    return a(signatureArr[0].toByteArray()).toUpperCase();
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return "-1";
    }

    private static java.lang.String a(byte[] bArr) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            for (byte b : messageDigest.digest()) {
                int i = b & 255;
                if (java.lang.Integer.toHexString(i).length() == 1) {
                    stringBuffer.append("0").append(java.lang.Integer.toHexString(i));
                } else {
                    stringBuffer.append(java.lang.Integer.toHexString(i));
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
