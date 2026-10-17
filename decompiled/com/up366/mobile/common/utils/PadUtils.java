package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PadUtils {
    private static final int MIN_TABLET_WIDTH_DP = 550;

    public static boolean isTablet(android.content.Context context) {
        if (com.up366.mobile.common.utils.PreferenceUtils.getInt("isTablet", -1) == 1) {
            return true;
        }
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        ((android.app.Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.widthPixels / displayMetrics.density;
        float f2 = displayMetrics.heightPixels / displayMetrics.density;
        float fMin = java.lang.Math.min(f, f2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("  widthDp:");
        sb.append(f);
        sb.append(",heightDp:");
        sb.append(f2);
        sb.append("  , isTablet: ");
        sb.append(fMin >= 550.0f);
        com.up366.common.log.Logger.info(sb.toString());
        if (fMin >= 550.0f) {
            com.up366.mobile.common.utils.PreferenceUtils.putInt("isTablet", 1);
            return true;
        }
        com.up366.mobile.common.utils.PreferenceUtils.putInt("isTablet", 0);
        return false;
    }
}
