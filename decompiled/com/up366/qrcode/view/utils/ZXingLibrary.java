package com.up366.qrcode.view.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ZXingLibrary {
    public static void initDisplayOpinion(android.content.Context context) {
        if (context == null) {
            return;
        }
        android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        com.up366.qrcode.view.utils.ZXingLibrary.DisplayUtil.density = displayMetrics.density;
        com.up366.qrcode.view.utils.ZXingLibrary.DisplayUtil.densityDPI = displayMetrics.densityDpi;
        com.up366.qrcode.view.utils.ZXingLibrary.DisplayUtil.screenWidthPx = displayMetrics.widthPixels;
        com.up366.qrcode.view.utils.ZXingLibrary.DisplayUtil.screenhightPx = displayMetrics.heightPixels;
        com.up366.qrcode.view.utils.ZXingLibrary.DisplayUtil.screenWidthDip = com.up366.qrcode.view.utils.ZXingLibrary.DisplayUtil.px2dip(context, displayMetrics.widthPixels);
        com.up366.qrcode.view.utils.ZXingLibrary.DisplayUtil.screenHightDip = com.up366.qrcode.view.utils.ZXingLibrary.DisplayUtil.px2dip(context, displayMetrics.heightPixels);
    }

    public static class DisplayUtil {
        public static float density;
        public static int densityDPI;
        public static float screenHightDip;
        public static float screenWidthDip;
        public static int screenWidthPx;
        public static int screenhightPx;

        public static int dip2px(android.content.Context context, float f) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }

        public static int px2dip(android.content.Context context, float f) {
            return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
        }

        public static void initDisplayOpinion(android.content.Context context) {
            android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            density = displayMetrics.density;
            densityDPI = displayMetrics.densityDpi;
            screenWidthPx = displayMetrics.widthPixels;
            screenhightPx = displayMetrics.heightPixels;
            screenWidthDip = px2dip(context, displayMetrics.widthPixels);
            screenHightDip = px2dip(context, displayMetrics.heightPixels);
        }
    }
}
