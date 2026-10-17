package com.up366.qrcode.view.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIStatusBarHelper {
    private static final int STATUSBAR_TYPE_ANDROID6 = 3;
    private static final int STATUSBAR_TYPE_DEFAULT = 0;
    private static final int STATUSBAR_TYPE_FLYME = 2;
    private static final int STATUSBAR_TYPE_MIUI = 1;
    private static final int STATUS_BAR_DEFAULT_HEIGHT_DP = 25;
    private static int mStatuBarType = 0;
    private static int sStatusbarHeight = -1;
    private static java.lang.Integer sTransparentValue = null;
    public static float sVirtualDensity = -1.0f;
    public static float sVirtualDensityDpi = -1.0f;

    public static void translucent(android.app.Activity activity) {
        translucent(activity.getWindow());
    }

    public static void translucent(android.view.Window window) {
        translucent(window, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
    }

    private static boolean supportTranslucent() {
        return !com.up366.qrcode.view.utils.QMUIDeviceHelper.isEssentialPhone() || android.os.Build.VERSION.SDK_INT >= 26;
    }

    public static void translucent(android.app.Activity activity, int i) {
        translucent(activity.getWindow(), i);
    }

    public static void translucent(android.view.Window window, int i) {
        if (supportTranslucent()) {
            if (com.up366.qrcode.view.utils.QMUINotchHelper.isNotchOfficialSupport()) {
                handleDisplayCutoutMode(window);
            }
            if (com.up366.qrcode.view.utils.QMUIDeviceHelper.isFlymeLowerThan(8)) {
                window.setFlags(67108864, 67108864);
                return;
            }
            com.up366.qrcode.view.utils.QMUIDeviceHelper.isMIUI();
            window.getDecorView().setSystemUiVisibility(1280);
            if (supportTransclentStatusBar6()) {
                window.clearFlags(67108864);
                window.addFlags(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
                window.setStatusBarColor(0);
            } else {
                window.clearFlags(67108864);
                window.addFlags(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
                window.setStatusBarColor(i);
            }
        }
    }

    private static void handleDisplayCutoutMode(final android.view.Window window) {
        android.view.View decorView = window.getDecorView();
        if (decorView != null) {
            if (androidx.core.view.ViewCompat.isAttachedToWindow(decorView)) {
                realHandleDisplayCutoutMode(window, decorView);
            } else {
                decorView.addOnAttachStateChangeListener(new android.view.View.OnAttachStateChangeListener() { // from class: com.up366.qrcode.view.utils.QMUIStatusBarHelper.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(android.view.View view) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(android.view.View view) {
                        view.removeOnAttachStateChangeListener(this);
                        com.up366.qrcode.view.utils.QMUIStatusBarHelper.realHandleDisplayCutoutMode(window, view);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void realHandleDisplayCutoutMode(android.view.Window window, android.view.View view) {
        if (view.getRootWindowInsets() == null || androidx.core.util.HalfKt$.ExternalSyntheticApiModelOutline0.m(view.getRootWindowInsets()) == null) {
            return;
        }
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(attributes, 1);
        window.setAttributes(attributes);
    }

    public static boolean setStatusBarLightMode(android.app.Activity activity) {
        if (activity == null || com.up366.qrcode.view.utils.QMUIDeviceHelper.isZTKC2016()) {
            return false;
        }
        int i = mStatuBarType;
        if (i != 0) {
            return setStatusBarLightMode(activity, i);
        }
        if (isMIUICustomStatusBarLightModeImpl() && MIUISetStatusBarLightMode(activity.getWindow(), true)) {
            mStatuBarType = 1;
            return true;
        }
        if (FlymeSetStatusBarLightMode(activity.getWindow(), true)) {
            mStatuBarType = 2;
            return true;
        }
        Android6SetStatusBarLightMode(activity.getWindow(), true);
        mStatuBarType = 3;
        return true;
    }

    private static boolean setStatusBarLightMode(android.app.Activity activity, int i) {
        if (i == 1) {
            return MIUISetStatusBarLightMode(activity.getWindow(), true);
        }
        if (i == 2) {
            return FlymeSetStatusBarLightMode(activity.getWindow(), true);
        }
        if (i == 3) {
            return Android6SetStatusBarLightMode(activity.getWindow(), true);
        }
        return false;
    }

    public static boolean setStatusBarDarkMode(android.app.Activity activity) {
        if (activity == null) {
            return false;
        }
        int i = mStatuBarType;
        if (i == 0) {
            return true;
        }
        if (i == 1) {
            return MIUISetStatusBarLightMode(activity.getWindow(), false);
        }
        if (i == 2) {
            return FlymeSetStatusBarLightMode(activity.getWindow(), false);
        }
        if (i == 3) {
            return Android6SetStatusBarLightMode(activity.getWindow(), false);
        }
        return true;
    }

    private static int changeStatusBarModeRetainFlag(android.view.Window window, int i) {
        return retainSystemUiFlag(window, retainSystemUiFlag(window, retainSystemUiFlag(window, retainSystemUiFlag(window, retainSystemUiFlag(window, retainSystemUiFlag(window, i, 1024), 4), 2), 4096), 1024), 512);
    }

    public static int retainSystemUiFlag(android.view.Window window, int i, int i2) {
        return (window.getDecorView().getSystemUiVisibility() & i2) == i2 ? i | i2 : i;
    }

    private static boolean Android6SetStatusBarLightMode(android.view.Window window, boolean z) {
        window.getDecorView().setSystemUiVisibility(changeStatusBarModeRetainFlag(window, z ? io.objectbox.model.PropertyFlags.UNSIGNED : 256));
        if (!com.up366.qrcode.view.utils.QMUIDeviceHelper.isMIUIV9()) {
            return true;
        }
        MIUISetStatusBarLightMode(window, z);
        return true;
    }

    public static boolean MIUISetStatusBarLightMode(android.view.Window window, boolean z) {
        if (window == null) {
            return false;
        }
        java.lang.Class<?> cls = window.getClass();
        try {
            java.lang.Class<?> cls2 = java.lang.Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            java.lang.Class<?> cls3 = java.lang.Integer.TYPE;
            java.lang.reflect.Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            if (z) {
                method.invoke(window, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i));
            } else {
                method.invoke(window, 0, java.lang.Integer.valueOf(i));
            }
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private static boolean isMIUICustomStatusBarLightModeImpl() {
        com.up366.qrcode.view.utils.QMUIDeviceHelper.isMIUIV9();
        return com.up366.qrcode.view.utils.QMUIDeviceHelper.isMIUIV5() || com.up366.qrcode.view.utils.QMUIDeviceHelper.isMIUIV6() || com.up366.qrcode.view.utils.QMUIDeviceHelper.isMIUIV7() || com.up366.qrcode.view.utils.QMUIDeviceHelper.isMIUIV8();
    }

    public static boolean FlymeSetStatusBarLightMode(android.view.Window window, boolean z) {
        if (window != null) {
            Android6SetStatusBarLightMode(window, z);
            if (!com.up366.qrcode.view.utils.QMUIDeviceHelper.isFlymeLowerThan(7)) {
                return true;
            }
            try {
                android.view.WindowManager.LayoutParams attributes = window.getAttributes();
                java.lang.reflect.Field declaredField = android.view.WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                java.lang.reflect.Field declaredField2 = android.view.WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i = declaredField.getInt(null);
                int i2 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z ? i2 | i : (~i) & i2);
                window.setAttributes(attributes);
                return true;
            } catch (java.lang.Exception unused) {
            }
        }
        return false;
    }

    public static boolean isFullScreen(android.app.Activity activity) {
        try {
            return (activity.getWindow().getAttributes().flags & 1024) != 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static java.lang.Integer getStatusBarAPITransparentValue(android.content.Context context) {
        java.lang.Integer num = sTransparentValue;
        if (num != null) {
            return num;
        }
        java.lang.String str = null;
        for (java.lang.String str2 : context.getPackageManager().getSystemSharedLibraryNames()) {
            if ("touchwiz".equals(str2)) {
                str = "SYSTEM_UI_FLAG_TRANSPARENT_BACKGROUND";
            } else if (str2.startsWith("com.sonyericsson.navigationbar")) {
                str = "SYSTEM_UI_FLAG_TRANSPARENT";
            }
        }
        if (str != null) {
            try {
                java.lang.reflect.Field field = android.view.View.class.getField(str);
                if (field != null && field.getType() == java.lang.Integer.TYPE) {
                    sTransparentValue = java.lang.Integer.valueOf(field.getInt(null));
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return sTransparentValue;
    }

    public static boolean supportTransclentStatusBar6() {
        return (com.up366.qrcode.view.utils.QMUIDeviceHelper.isZUKZ1() || com.up366.qrcode.view.utils.QMUIDeviceHelper.isZTKC2016()) ? false : true;
    }

    public static int getStatusbarHeight(android.content.Context context) {
        if (sStatusbarHeight == -1) {
            initStatusBarHeight(context);
        }
        return sStatusbarHeight;
    }

    private static void initStatusBarHeight(android.content.Context context) {
        java.lang.Throwable th;
        java.lang.reflect.Field field;
        java.lang.Object objNewInstance;
        java.lang.Object obj = null;
        field = null;
        field = null;
        field = null;
        java.lang.reflect.Field field2 = null;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.android.internal.R$dimen");
            objNewInstance = cls.newInstance();
            try {
                if (com.up366.qrcode.view.utils.QMUIDeviceHelper.isMeizu()) {
                    try {
                        field2 = cls.getField("status_bar_height_large");
                    } catch (java.lang.Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                if (field2 == null) {
                    field2 = cls.getField("status_bar_height");
                }
            } catch (java.lang.Throwable th3) {
                field = field2;
                obj = objNewInstance;
                th = th3;
                th.printStackTrace();
                objNewInstance = obj;
                field2 = field;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            field = null;
        }
        if (field2 != null && objNewInstance != null) {
            try {
                sStatusbarHeight = context.getResources().getDimensionPixelSize(java.lang.Integer.parseInt(field2.get(objNewInstance).toString()));
            } catch (java.lang.Throwable th5) {
                th5.printStackTrace();
            }
        }
        if (com.up366.qrcode.view.utils.QMUIDeviceHelper.isTablet(context) && sStatusbarHeight > com.up366.qrcode.view.utils.QMUIDisplayHelper.dp2px(context, 25)) {
            sStatusbarHeight = 0;
            return;
        }
        if (sStatusbarHeight <= 0) {
            float f = sVirtualDensity;
            if (f == -1.0f) {
                sStatusbarHeight = com.up366.qrcode.view.utils.QMUIDisplayHelper.dp2px(context, 25);
            } else {
                sStatusbarHeight = (int) ((f * 25.0f) + 0.5f);
            }
        }
    }

    public static void setVirtualDensity(float f) {
        sVirtualDensity = f;
    }

    public static void setVirtualDensityDpi(float f) {
        sVirtualDensityDpi = f;
    }
}
