package com.up366.qrcode.view.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIDisplayHelper {
    private static final java.lang.String HUAWAI_DISPLAY_NOTCH_STATUS = "display_notch_status";
    private static final java.lang.String TAG = "QMUIDisplayHelper";
    private static final java.lang.String VIVO_NAVIGATION_GESTURE = "navigation_gesture_on";
    private static final java.lang.String XIAOMI_DISPLAY_NOTCH_STATUS = "force_black";
    private static final java.lang.String XIAOMI_FULLSCREEN_GESTURE = "force_fsg_nav_bar";
    public static final float DENSITY = android.content.res.Resources.getSystem().getDisplayMetrics().density;
    private static java.lang.Boolean sHasCamera = null;

    public static boolean isElevationSupported() {
        return true;
    }

    public static android.util.DisplayMetrics getDisplayMetrics(android.content.Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static int dpToPx(int i) {
        return (int) ((i * DENSITY) + 0.5f);
    }

    public static int pxToDp(float f) {
        return (int) ((f / DENSITY) + 0.5f);
    }

    public static float getDensity(android.content.Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static float getFontDensity(android.content.Context context) {
        return context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static int getScreenWidth(android.content.Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    public static int getScreenHeight(android.content.Context context) {
        int i = getDisplayMetrics(context).heightPixels;
        return (com.up366.qrcode.view.utils.QMUIDeviceHelper.isXiaomi() && xiaomiNavigationGestureEnabled(context)) ? i + getResourceNavHeight(context) : i;
    }

    public static int[] getRealScreenSize(android.content.Context context) {
        return doGetRealScreenSize(context);
    }

    private static int[] doGetRealScreenSize(android.content.Context context) {
        android.view.Display defaultDisplay = ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay();
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int iIntValue = displayMetrics.widthPixels;
        int iIntValue2 = displayMetrics.heightPixels;
        try {
            iIntValue = ((java.lang.Integer) android.view.Display.class.getMethod("getRawWidth", null).invoke(defaultDisplay, null)).intValue();
            iIntValue2 = ((java.lang.Integer) android.view.Display.class.getMethod("getRawHeight", null).invoke(defaultDisplay, null)).intValue();
        } catch (java.lang.Exception unused) {
        }
        try {
            android.graphics.Point point = new android.graphics.Point();
            defaultDisplay.getRealSize(point);
            android.view.Display.class.getMethod("getRealSize", android.graphics.Point.class).invoke(defaultDisplay, point);
            iIntValue = point.x;
            iIntValue2 = point.y;
        } catch (java.lang.Exception unused2) {
        }
        return new int[]{iIntValue, iIntValue2};
    }

    public static int getUsefulScreenWidth(android.app.Activity activity) {
        return getUsefulScreenWidth(activity, com.up366.qrcode.view.utils.QMUINotchHelper.hasNotch(activity));
    }

    public static int getUsefulScreenWidth(android.view.View view) {
        return getUsefulScreenWidth(view.getContext(), com.up366.qrcode.view.utils.QMUINotchHelper.hasNotch(view));
    }

    public static int getUsefulScreenWidth(android.content.Context context, boolean z) {
        int i = getRealScreenSize(context)[0];
        boolean z2 = context.getResources().getConfiguration().orientation == 2;
        return !z ? (z2 && com.up366.qrcode.view.utils.QMUIDeviceHelper.isEssentialPhone() && android.os.Build.VERSION.SDK_INT < 26) ? i - (com.up366.qrcode.view.utils.QMUIStatusBarHelper.getStatusbarHeight(context) * 2) : i : (z2 && com.up366.qrcode.view.utils.QMUIDeviceHelper.isHuawei() && !huaweiIsNotchSetToShowInSetting(context)) ? i - com.up366.qrcode.view.utils.QMUINotchHelper.getNotchSizeInHuawei(context)[1] : i;
    }

    public static int getUsefulScreenHeight(android.app.Activity activity) {
        return getUsefulScreenHeight(activity, com.up366.qrcode.view.utils.QMUINotchHelper.hasNotch(activity));
    }

    public static int getUsefulScreenHeight(android.view.View view) {
        return getUsefulScreenHeight(view.getContext(), com.up366.qrcode.view.utils.QMUINotchHelper.hasNotch(view));
    }

    private static int getUsefulScreenHeight(android.content.Context context, boolean z) {
        int i = getRealScreenSize(context)[1];
        return (z || !(context.getResources().getConfiguration().orientation == 1) || !com.up366.qrcode.view.utils.QMUIDeviceHelper.isEssentialPhone() || android.os.Build.VERSION.SDK_INT >= 26) ? i : i - (com.up366.qrcode.view.utils.QMUIStatusBarHelper.getStatusbarHeight(context) * 2);
    }

    public static boolean isNavMenuExist(android.content.Context context) {
        return (android.view.ViewConfiguration.get(context).hasPermanentMenuKey() || android.view.KeyCharacterMap.deviceHasKey(4)) ? false : true;
    }

    public static int dp2px(android.content.Context context, int i) {
        return (int) (((double) (getDensity(context) * i)) + 0.5d);
    }

    public static int sp2px(android.content.Context context, int i) {
        return (int) (((double) (getFontDensity(context) * i)) + 0.5d);
    }

    public static int px2dp(android.content.Context context, int i) {
        return (int) (((double) (i / getDensity(context))) + 0.5d);
    }

    public static int px2sp(android.content.Context context, int i) {
        return (int) (((double) (i / getFontDensity(context))) + 0.5d);
    }

    public static boolean hasStatusBar(android.content.Context context) {
        return ((context instanceof android.app.Activity) && (((android.app.Activity) context).getWindow().getAttributes().flags & 1024) == 1024) ? false : true;
    }

    public static int getActionBarHeight(android.content.Context context) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, typedValue, true)) {
            return android.util.TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        return 0;
    }

    public static int getStatusBarHeight(android.content.Context context) {
        if (com.up366.qrcode.view.utils.QMUIDeviceHelper.isXiaomi()) {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.android.internal.R$dimen");
            int i = java.lang.Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString());
            if (i > 0) {
                return context.getResources().getDimensionPixelSize(i);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getNavMenuHeight(android.content.Context context) {
        if (!isNavMenuExist(context)) {
            return 0;
        }
        int resourceNavHeight = getResourceNavHeight(context);
        return resourceNavHeight >= 0 ? resourceNavHeight : getRealScreenSize(context)[1] - getScreenHeight(context);
    }

    private static int getResourceNavHeight(android.content.Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return -1;
    }

    public static final boolean hasCamera(android.content.Context context) {
        if (sHasCamera == null) {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            sHasCamera = java.lang.Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.camera.front") || packageManager.hasSystemFeature("android.hardware.camera"));
        }
        return sHasCamera.booleanValue();
    }

    public static boolean hasHardwareMenuKey(android.content.Context context) {
        return android.view.ViewConfiguration.get(context).hasPermanentMenuKey();
    }

    public static boolean hasInternet(android.content.Context context) {
        return ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
    }

    public static boolean isPackageExist(android.content.Context context, java.lang.String str) {
        return context.getPackageManager().getPackageInfo(str, 0) != null;
    }

    public static boolean isSdcardReady() {
        return "mounted".equals(android.os.Environment.getExternalStorageState());
    }

    public static java.lang.String getCurCountryLan(android.content.Context context) {
        java.util.Locale localeM;
        android.content.res.Configuration configuration = context.getResources().getConfiguration();
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            localeM = androidx.core.graphics.ColorKt$.ExternalSyntheticApiModelOutline0.m(androidx.activity.ComponentDialog$.ExternalSyntheticApiModelOutline0.m(configuration), 0);
        } else {
            localeM = configuration.locale;
        }
        return localeM.getLanguage() + "-" + localeM.getCountry();
    }

    public static boolean isZhCN(android.content.Context context) {
        java.util.Locale localeM;
        android.content.res.Configuration configuration = context.getResources().getConfiguration();
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            localeM = androidx.core.graphics.ColorKt$.ExternalSyntheticApiModelOutline0.m(androidx.activity.ComponentDialog$.ExternalSyntheticApiModelOutline0.m(configuration), 0);
        } else {
            localeM = configuration.locale;
        }
        return localeM.getCountry().equalsIgnoreCase("CN");
    }

    public static void setFullScreen(android.app.Activity activity) {
        android.view.Window window = activity.getWindow();
        window.addFlags(512);
        window.addFlags(1024);
    }

    public static void cancelFullScreen(android.app.Activity activity) {
        android.view.Window window = activity.getWindow();
        window.clearFlags(1024);
        window.clearFlags(512);
    }

    public static boolean isFullScreen(android.app.Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    public static boolean hasNavigationBar(android.content.Context context) {
        if (!deviceHasNavigationBar()) {
            return false;
        }
        if (com.up366.qrcode.view.utils.QMUIDeviceHelper.isVivo()) {
            return vivoNavigationGestureEnabled(context);
        }
        return true;
    }

    private static boolean deviceHasNavigationBar() {
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.view.WindowManagerGlobal").getDeclaredMethod("getWindowManagerService", null);
            declaredMethod.setAccessible(true);
            java.lang.Object objInvoke = declaredMethod.invoke(null, null);
            java.lang.reflect.Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("hasNavigationBar", null);
            declaredMethod2.setAccessible(true);
            return ((java.lang.Boolean) declaredMethod2.invoke(objInvoke, null)).booleanValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean vivoNavigationGestureEnabled(android.content.Context context) {
        return android.provider.Settings.Secure.getInt(context.getContentResolver(), VIVO_NAVIGATION_GESTURE, 0) != 0;
    }

    public static boolean xiaomiNavigationGestureEnabled(android.content.Context context) {
        return android.provider.Settings.Global.getInt(context.getContentResolver(), XIAOMI_FULLSCREEN_GESTURE, 0) != 0;
    }

    public static boolean huaweiIsNotchSetToShowInSetting(android.content.Context context) {
        return android.provider.Settings.Secure.getInt(context.getContentResolver(), HUAWAI_DISPLAY_NOTCH_STATUS, 0) == 0;
    }

    public static boolean xiaomiIsNotchSetToShowInSetting(android.content.Context context) {
        return android.provider.Settings.Global.getInt(context.getContentResolver(), XIAOMI_DISPLAY_NOTCH_STATUS, 0) == 0;
    }
}
