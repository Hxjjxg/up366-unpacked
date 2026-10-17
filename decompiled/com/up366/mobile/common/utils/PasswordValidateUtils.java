package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PasswordValidateUtils {
    public static boolean verifyPasswordV2(java.lang.String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[\\x21-\\x7E]{8,16}$");
    }
}
