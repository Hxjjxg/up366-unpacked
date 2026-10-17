package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RealNameUtils {
    public static boolean isSystemCreate(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || !str.startsWith("天学用户")) {
            return false;
        }
        try {
            java.lang.Integer.parseInt(str.replace("天学用户", ""));
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
