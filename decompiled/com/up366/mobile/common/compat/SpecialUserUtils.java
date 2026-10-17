package com.up366.mobile.common.compat;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SpecialUserUtils {
    public static boolean isOralTester() {
        return true;
    }

    public static boolean isNanTongUser() {
        return 1319343 == com.up366.mobile.common.logic.Auth.getUserInfo().getOrganId();
    }
}
