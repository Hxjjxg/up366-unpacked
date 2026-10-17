package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ScreenUtils {
    public static int dip2px(android.content.Context context, float f) {
        return (int) ((f * context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getScreenWidth(android.content.Context context) {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        ((android.app.Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight(android.content.Context context) {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        ((android.app.Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels - getStatusBarHeight(context);
    }

    public static int getStatusBarHeight(android.content.Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        return dimensionPixelSize == 0 ? dip2px(context, 25.0f) : dimensionPixelSize;
    }

    public static float[] getScreenInfo(android.content.Context context) {
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        float[] fArr = new float[5];
        if (windowManager != null) {
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            fArr[0] = displayMetrics.widthPixels;
            fArr[1] = displayMetrics.heightPixels;
            fArr[2] = displayMetrics.densityDpi;
            fArr[3] = displayMetrics.density;
            fArr[4] = displayMetrics.scaledDensity;
        }
        return fArr;
    }
}
