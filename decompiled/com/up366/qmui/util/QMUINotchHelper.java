package com.up366.qmui.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUINotchHelper {
    private static final java.lang.String MIUI_NOTCH = "ro.miui.notch";
    private static final int NOTCH_IN_SCREEN_VOIO = 32;
    private static final java.lang.String TAG = "QMUINotchHelper";
    private static java.lang.Boolean sHasNotch;
    private static java.lang.Boolean sHuaweiIsNotchSetToShow;
    private static int[] sNotchSizeInHawei;
    private static android.graphics.Rect sRotation0SafeInset;
    private static android.graphics.Rect sRotation180SafeInset;
    private static android.graphics.Rect sRotation270SafeInset;
    private static android.graphics.Rect sRotation90SafeInset;

    public static boolean hasNotchInVivo(android.content.Context context) {
        try {
            java.lang.Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            java.lang.reflect.Method[] declaredMethods = clsLoadClass.getDeclaredMethods();
            if (declaredMethods == null) {
                return false;
            }
            for (java.lang.reflect.Method method : declaredMethods) {
                if (method.getName().equalsIgnoreCase("isFeatureSupport")) {
                    return ((java.lang.Boolean) method.invoke(clsLoadClass, 32)).booleanValue();
                }
            }
            return false;
        } catch (java.lang.ClassNotFoundException unused) {
            android.util.Log.i(TAG, "hasNotchInVivo ClassNotFoundException");
            return false;
        } catch (java.lang.Exception unused2) {
            android.util.Log.e(TAG, "hasNotchInVivo Exception");
            return false;
        }
    }

    public static boolean hasNotchInHuawei(android.content.Context context) {
        try {
            java.lang.Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((java.lang.Boolean) clsLoadClass.getMethod("hasNotchInScreen", null).invoke(clsLoadClass, null)).booleanValue();
        } catch (java.lang.ClassNotFoundException unused) {
            android.util.Log.i(TAG, "hasNotchInHuawei ClassNotFoundException");
            return false;
        } catch (java.lang.NoSuchMethodException unused2) {
            android.util.Log.e(TAG, "hasNotchInHuawei NoSuchMethodException");
            return false;
        } catch (java.lang.Exception unused3) {
            android.util.Log.e(TAG, "hasNotchInHuawei Exception");
            return false;
        }
    }

    public static boolean hasNotchInOppo(android.content.Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean hasNotchInXiaomi(android.content.Context context) {
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", java.lang.String.class, java.lang.Integer.TYPE);
            declaredMethod.setAccessible(true);
            return ((java.lang.Integer) declaredMethod.invoke(null, MIUI_NOTCH, 0)).intValue() == 1;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean hasNotch(android.view.View view) {
        if (sHasNotch == null) {
            if (isNotchOfficialSupport()) {
                if (!attachHasOfficialNotch(view)) {
                    return false;
                }
            } else {
                sHasNotch = java.lang.Boolean.valueOf(has3rdNotch(view.getContext()));
            }
        }
        return sHasNotch.booleanValue();
    }

    public static boolean hasNotch(android.app.Activity activity) {
        android.view.View decorView;
        if (sHasNotch == null) {
            if (isNotchOfficialSupport()) {
                android.view.Window window = activity.getWindow();
                if (window == null || (decorView = window.getDecorView()) == null || !attachHasOfficialNotch(decorView)) {
                    return false;
                }
            } else {
                sHasNotch = java.lang.Boolean.valueOf(has3rdNotch(activity));
            }
        }
        return sHasNotch.booleanValue();
    }

    private static boolean attachHasOfficialNotch(android.view.View view) {
        android.view.WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return false;
        }
        sHasNotch = java.lang.Boolean.valueOf(androidx.core.util.HalfKt$.ExternalSyntheticApiModelOutline0.m(rootWindowInsets) != null);
        return true;
    }

    public static boolean has3rdNotch(android.content.Context context) {
        if (com.up366.qmui.util.QMUIDeviceHelper.isHuawei()) {
            return hasNotchInHuawei(context);
        }
        if (com.up366.qmui.util.QMUIDeviceHelper.isVivo()) {
            return hasNotchInVivo(context);
        }
        if (com.up366.qmui.util.QMUIDeviceHelper.isOppo()) {
            return hasNotchInOppo(context);
        }
        if (com.up366.qmui.util.QMUIDeviceHelper.isXiaomi()) {
            return hasNotchInXiaomi(context);
        }
        return false;
    }

    public static int getSafeInsetTop(android.app.Activity activity) {
        if (hasNotch(activity)) {
            return getSafeInsetRect(activity).top;
        }
        return 0;
    }

    public static int getSafeInsetBottom(android.app.Activity activity) {
        if (hasNotch(activity)) {
            return getSafeInsetRect(activity).bottom;
        }
        return 0;
    }

    public static int getSafeInsetLeft(android.app.Activity activity) {
        if (hasNotch(activity)) {
            return getSafeInsetRect(activity).left;
        }
        return 0;
    }

    public static int getSafeInsetRight(android.app.Activity activity) {
        if (hasNotch(activity)) {
            return getSafeInsetRect(activity).right;
        }
        return 0;
    }

    public static int getSafeInsetTop(android.view.View view) {
        if (hasNotch(view)) {
            return getSafeInsetRect(view).top;
        }
        return 0;
    }

    public static int getSafeInsetBottom(android.view.View view) {
        if (hasNotch(view)) {
            return getSafeInsetRect(view).bottom;
        }
        return 0;
    }

    public static int getSafeInsetLeft(android.view.View view) {
        if (hasNotch(view)) {
            return getSafeInsetRect(view).left;
        }
        return 0;
    }

    public static int getSafeInsetRight(android.view.View view) {
        if (hasNotch(view)) {
            return getSafeInsetRect(view).right;
        }
        return 0;
    }

    private static void clearAllRectInfo() {
        sRotation0SafeInset = null;
        sRotation90SafeInset = null;
        sRotation180SafeInset = null;
        sRotation270SafeInset = null;
    }

    private static void clearPortraitRectInfo() {
        sRotation0SafeInset = null;
        sRotation180SafeInset = null;
    }

    private static void clearLandscapeRectInfo() {
        sRotation90SafeInset = null;
        sRotation270SafeInset = null;
    }

    private static android.graphics.Rect getSafeInsetRect(android.app.Activity activity) {
        if (isNotchOfficialSupport()) {
            android.graphics.Rect rect = new android.graphics.Rect();
            getOfficialSafeInsetRect(activity.getWindow().getDecorView(), rect);
            return rect;
        }
        return get3rdSafeInsetRect(activity);
    }

    private static android.graphics.Rect getSafeInsetRect(android.view.View view) {
        if (isNotchOfficialSupport()) {
            android.graphics.Rect rect = new android.graphics.Rect();
            getOfficialSafeInsetRect(view, rect);
            return rect;
        }
        return get3rdSafeInsetRect(view.getContext());
    }

    private static void getOfficialSafeInsetRect(android.view.View view, android.graphics.Rect rect) {
        android.view.WindowInsets rootWindowInsets;
        android.view.DisplayCutout displayCutoutM;
        if (view == null || (rootWindowInsets = view.getRootWindowInsets()) == null || (displayCutoutM = androidx.core.util.HalfKt$.ExternalSyntheticApiModelOutline0.m(rootWindowInsets)) == null) {
            return;
        }
        rect.set(displayCutoutM.getSafeInsetLeft(), displayCutoutM.getSafeInsetTop(), displayCutoutM.getSafeInsetRight(), displayCutoutM.getSafeInsetBottom());
    }

    private static android.graphics.Rect get3rdSafeInsetRect(android.content.Context context) {
        if (com.up366.qmui.util.QMUIDeviceHelper.isHuawei()) {
            boolean zHuaweiIsNotchSetToShowInSetting = com.up366.qmui.util.QMUIDisplayHelper.huaweiIsNotchSetToShowInSetting(context);
            java.lang.Boolean bool = sHuaweiIsNotchSetToShow;
            if (bool != null && bool.booleanValue() != zHuaweiIsNotchSetToShowInSetting) {
                clearLandscapeRectInfo();
            }
            sHuaweiIsNotchSetToShow = java.lang.Boolean.valueOf(zHuaweiIsNotchSetToShowInSetting);
        }
        int screenRotation = getScreenRotation(context);
        if (screenRotation == 1) {
            if (sRotation90SafeInset == null) {
                sRotation90SafeInset = getRectInfoRotation90(context);
            }
            return sRotation90SafeInset;
        }
        if (screenRotation == 2) {
            if (sRotation180SafeInset == null) {
                sRotation180SafeInset = getRectInfoRotation180(context);
            }
            return sRotation180SafeInset;
        }
        if (screenRotation == 3) {
            if (sRotation270SafeInset == null) {
                sRotation270SafeInset = getRectInfoRotation270(context);
            }
            return sRotation270SafeInset;
        }
        if (sRotation0SafeInset == null) {
            sRotation0SafeInset = getRectInfoRotation0(context);
        }
        return sRotation0SafeInset;
    }

    private static android.graphics.Rect getRectInfoRotation0(android.content.Context context) {
        android.graphics.Rect rect = new android.graphics.Rect();
        if (com.up366.qmui.util.QMUIDeviceHelper.isVivo()) {
            rect.top = getNotchHeightInVivo(context);
            rect.bottom = 0;
        } else if (com.up366.qmui.util.QMUIDeviceHelper.isOppo()) {
            rect.top = com.up366.qmui.util.QMUIStatusBarHelper.getStatusbarHeight(context);
            rect.bottom = 0;
        } else if (com.up366.qmui.util.QMUIDeviceHelper.isHuawei()) {
            rect.top = getNotchSizeInHuawei(context)[1];
            rect.bottom = 0;
        } else if (com.up366.qmui.util.QMUIDeviceHelper.isXiaomi()) {
            rect.top = getNotchHeightInXiaomi(context);
            rect.bottom = 0;
        }
        return rect;
    }

    private static android.graphics.Rect getRectInfoRotation90(android.content.Context context) {
        android.graphics.Rect rect = new android.graphics.Rect();
        if (com.up366.qmui.util.QMUIDeviceHelper.isVivo()) {
            rect.left = getNotchHeightInVivo(context);
            rect.right = 0;
        } else if (com.up366.qmui.util.QMUIDeviceHelper.isOppo()) {
            rect.left = com.up366.qmui.util.QMUIStatusBarHelper.getStatusbarHeight(context);
            rect.right = 0;
        } else if (com.up366.qmui.util.QMUIDeviceHelper.isHuawei()) {
            if (sHuaweiIsNotchSetToShow.booleanValue()) {
                rect.left = getNotchSizeInHuawei(context)[1];
            } else {
                rect.left = 0;
            }
            rect.right = 0;
        } else if (com.up366.qmui.util.QMUIDeviceHelper.isXiaomi()) {
            rect.left = getNotchHeightInXiaomi(context);
            rect.right = 0;
        }
        return rect;
    }

    private static android.graphics.Rect getRectInfoRotation180(android.content.Context context) {
        android.graphics.Rect rect = new android.graphics.Rect();
        if (com.up366.qmui.util.QMUIDeviceHelper.isVivo()) {
            rect.top = 0;
            rect.bottom = getNotchHeightInVivo(context);
        } else if (com.up366.qmui.util.QMUIDeviceHelper.isOppo()) {
            rect.top = 0;
            rect.bottom = com.up366.qmui.util.QMUIStatusBarHelper.getStatusbarHeight(context);
        } else if (com.up366.qmui.util.QMUIDeviceHelper.isHuawei()) {
            int[] notchSizeInHuawei = getNotchSizeInHuawei(context);
            rect.top = 0;
            rect.bottom = notchSizeInHuawei[1];
        } else if (com.up366.qmui.util.QMUIDeviceHelper.isXiaomi()) {
            rect.top = 0;
            rect.bottom = getNotchHeightInXiaomi(context);
        }
        return rect;
    }

    private static android.graphics.Rect getRectInfoRotation270(android.content.Context context) {
        android.graphics.Rect rect = new android.graphics.Rect();
        if (com.up366.qmui.util.QMUIDeviceHelper.isVivo()) {
            rect.right = getNotchHeightInVivo(context);
            rect.left = 0;
        } else if (com.up366.qmui.util.QMUIDeviceHelper.isOppo()) {
            rect.right = com.up366.qmui.util.QMUIStatusBarHelper.getStatusbarHeight(context);
            rect.left = 0;
        } else if (com.up366.qmui.util.QMUIDeviceHelper.isHuawei()) {
            if (sHuaweiIsNotchSetToShow.booleanValue()) {
                rect.right = getNotchSizeInHuawei(context)[1];
            } else {
                rect.right = 0;
            }
            rect.left = 0;
        } else if (com.up366.qmui.util.QMUIDeviceHelper.isXiaomi()) {
            rect.right = getNotchHeightInXiaomi(context);
            rect.left = 0;
        }
        return rect;
    }

    public static int[] getNotchSizeInHuawei(android.content.Context context) {
        if (sNotchSizeInHawei == null) {
            sNotchSizeInHawei = new int[]{0, 0};
            try {
                java.lang.Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                sNotchSizeInHawei = (int[]) clsLoadClass.getMethod("getNotchSize", null).invoke(clsLoadClass, null);
            } catch (java.lang.ClassNotFoundException unused) {
                android.util.Log.e(TAG, "getNotchSizeInHuawei ClassNotFoundException");
            } catch (java.lang.NoSuchMethodException unused2) {
                android.util.Log.e(TAG, "getNotchSizeInHuawei NoSuchMethodException");
            } catch (java.lang.Exception unused3) {
                android.util.Log.e(TAG, "getNotchSizeInHuawei Exception");
            }
        }
        return sNotchSizeInHawei;
    }

    public static int getNotchWidthInXiaomi(android.content.Context context) {
        int identifier = context.getResources().getIdentifier("notch_width", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return -1;
    }

    public static int getNotchHeightInXiaomi(android.content.Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return com.up366.qmui.util.QMUIDisplayHelper.getStatusBarHeight(context);
    }

    public static int getNotchWidthInVivo(android.content.Context context) {
        return com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 100);
    }

    public static int getNotchHeightInVivo(android.content.Context context) {
        return com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 27);
    }

    private static int getScreenRotation(android.content.Context context) {
        android.view.Display defaultDisplay;
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return 0;
        }
        return defaultDisplay.getRotation();
    }

    public static boolean isNotchOfficialSupport() {
        return android.os.Build.VERSION.SDK_INT >= 28;
    }

    public static boolean needFixLandscapeNotchAreaFitSystemWindow(android.view.View view) {
        return (com.up366.qmui.util.QMUIDeviceHelper.isXiaomi() || com.up366.qmui.util.QMUIDeviceHelper.isVivo()) && hasNotch(view);
    }
}
