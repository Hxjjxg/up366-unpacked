package com.warkiz.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class IndicatorUtils {
    IndicatorUtils() {
    }

    static int dp2px(android.content.Context context, float f) {
        return (int) android.util.TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    static int sp2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    static int px2sp(android.content.Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
