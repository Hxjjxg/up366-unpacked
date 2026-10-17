package com.up366.photopicker.ui;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class GuideWebLoadDecider {
    private GuideWebLoadDecider() {
    }

    public static boolean canRevealContent(java.lang.String str, java.lang.String str2, boolean z, boolean z2, boolean z3, int i, int i2) {
        if (z || z2 || str == null || str.isEmpty() || str2 == null || !str.equals(str2)) {
            return false;
        }
        return z3 || i >= i2;
    }
}
