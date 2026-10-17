package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ScreenUtils {
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
}
