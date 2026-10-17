package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class c {
    public static final java.lang.StringBuffer b = new java.lang.StringBuffer();

    public static java.lang.String b(int i, android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String simOperator = ((android.telephony.TelephonyManager) context.getSystemService("phone")).getSimOperator();
        if (1 == i) {
            return "AC_" + str + str2 + simOperator + b.toString();
        }
        java.lang.String strSubstring = com.unicom.online.account.kernel.au.b(com.unicom.online.account.kernel.au.b()).substring(2, 10);
        java.lang.StringBuffer stringBuffer = b;
        stringBuffer.setLength(0);
        stringBuffer.append(strSubstring);
        if (!com.unicom.online.account.kernel.bh.c(strSubstring).booleanValue()) {
            return null;
        }
        return "AC_" + str + str2 + simOperator + strSubstring;
    }
}
