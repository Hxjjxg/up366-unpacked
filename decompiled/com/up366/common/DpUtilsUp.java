package com.up366.common;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DpUtilsUp {
    public static int dp2px(float f) {
        return (int) ((f * com.up366.common.global.GB.get().getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dp(float f) {
        return (int) ((f / com.up366.common.global.GB.get().getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int sp2px(float f) {
        return (int) ((f * com.up366.common.global.GB.get().getApplicationContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int px2sp(float f) {
        return (int) ((f / com.up366.common.global.GB.get().getApplicationContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
