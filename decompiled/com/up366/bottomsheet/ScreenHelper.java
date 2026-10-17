package com.up366.bottomsheet;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class ScreenHelper {
    private static final java.lang.String NAVIGATION = "navigationBarBackground";
    private static final java.lang.String XIAOMI_FULLSCREEN_GESTURE = "force_fsg_nav_bar";

    ScreenHelper() {
    }

    public static int getNavigationBarHeight(android.content.Context context) {
        android.content.res.Resources resources;
        int identifier;
        if (!hasNavBar(context) || (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static int getStatusBarHeight(android.content.Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean hasNavBar(android.content.Context context) {
        android.content.res.Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            boolean z = resources.getBoolean(identifier);
            java.lang.String navBarOverride = getNavBarOverride();
            if ("1".equals(navBarOverride)) {
                return false;
            }
            if ("0".equals(navBarOverride)) {
                return true;
            }
            return z;
        }
        return !android.view.ViewConfiguration.get(context).hasPermanentMenuKey();
    }

    private static java.lang.String getNavBarOverride() {
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.os.SystemProperties").getDeclaredMethod("get", java.lang.String.class);
            declaredMethod.setAccessible(true);
            return (java.lang.String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static int getScreenHeight(android.content.Context context) {
        int i = getDisplayMetrics(context).heightPixels;
        return (isXiaomi() && xiaomiNavigationGestureEnabled(context)) ? i + getResourceNavHeight(context) : i;
    }

    private static int getResourceNavHeight(android.content.Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return -1;
    }

    public static boolean xiaomiNavigationGestureEnabled(android.content.Context context) {
        return android.provider.Settings.Global.getInt(context.getContentResolver(), XIAOMI_FULLSCREEN_GESTURE, 0) != 0;
    }

    public static boolean isXiaomi() {
        return android.os.Build.MANUFACTURER.toLowerCase().equals(com.igexin.assist.util.AssistUtils.BRAND_XIAOMI);
    }

    public static android.util.DisplayMetrics getDisplayMetrics(android.content.Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static boolean isNavigationBarExist(android.app.Activity activity) {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) activity.getWindow().getDecorView();
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                viewGroup.getChildAt(i).getContext().getPackageName();
                if (viewGroup.getChildAt(i).getId() != -1 && NAVIGATION.equals(activity.getResources().getResourceEntryName(viewGroup.getChildAt(i).getId()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
