package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LightStatusBarUtils {
    public static void setLightStatusBar(android.app.Activity activity, boolean z, boolean z2, boolean z3, boolean z4) {
        int lightStatausBarAvailableRomType = com.up366.medialibrary.common.utils.RomUtils.getLightStatausBarAvailableRomType();
        if (lightStatausBarAvailableRomType == 1) {
            if (com.up366.medialibrary.common.utils.RomUtils.getMIUIVersionCode() >= 7) {
                setAndroidNativeLightStatusBar(activity, z, z2, z3, z4);
                return;
            } else {
                setMIUILightStatusBar(activity, z, z2, z3, z4);
                return;
            }
        }
        if (lightStatausBarAvailableRomType == 2) {
            setFlymeLightStatusBar(activity, z, z2, z3, z4);
        } else {
            if (lightStatausBarAvailableRomType != 3) {
                return;
            }
            setAndroidNativeLightStatusBar(activity, z, z2, z3, z4);
        }
    }

    private static boolean setMIUILightStatusBar(android.app.Activity activity, boolean z, boolean z2, boolean z3, boolean z4) {
        initStatusBarStyle(activity, z, z2);
        java.lang.Class<?> cls = activity.getWindow().getClass();
        try {
            java.lang.Class<?> cls2 = java.lang.Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            java.lang.Class<?> cls3 = java.lang.Integer.TYPE;
            cls.getMethod("setExtraFlags", cls3, cls3).invoke(activity.getWindow(), java.lang.Integer.valueOf(z4 ? i : 0), java.lang.Integer.valueOf(i));
            return true;
        } catch (java.lang.Exception unused) {
            setAndroidNativeLightStatusBar(activity, z, z2, z3, z4);
            return false;
        }
    }

    private static boolean setFlymeLightStatusBar(android.app.Activity activity, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        if (activity == null) {
            return false;
        }
        initStatusBarStyle(activity, z, z2);
        try {
            android.view.WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            java.lang.reflect.Field declaredField = android.view.WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            java.lang.reflect.Field declaredField2 = android.view.WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z4 ? i | i2 : (~i) & i2);
            activity.getWindow().setAttributes(attributes);
        } catch (java.lang.Exception unused) {
        }
        try {
            if (com.up366.medialibrary.common.utils.RomUtils.getFlymeVersion() >= 7) {
                setAndroidNativeLightStatusBar(activity, z, z2, z3, z4);
            }
            return true;
        } catch (java.lang.Exception unused2) {
            z5 = true;
            setAndroidNativeLightStatusBar(activity, z, z2, z3, z4);
            return z5;
        }
    }

    private static void setAndroidNativeLightStatusBar(android.app.Activity activity, boolean z, boolean z2, boolean z3, boolean z4) {
        try {
            if (z3) {
                android.view.Window window = activity.getWindow();
                if (z && z2) {
                    if (z4) {
                        window.getDecorView().setSystemUiVisibility(8448);
                    } else {
                        window.getDecorView().setSystemUiVisibility(256);
                    }
                } else if (z || z2) {
                    if (z || !z2) {
                        return;
                    }
                    if (z4) {
                        window.getDecorView().setSystemUiVisibility(9472);
                    } else {
                        window.getDecorView().setSystemUiVisibility(1280);
                    }
                } else if (z4) {
                    window.getDecorView().setSystemUiVisibility(9472);
                } else {
                    window.getDecorView().setSystemUiVisibility(1280);
                }
            } else {
                android.view.View decorView = activity.getWindow().getDecorView();
                if (z4) {
                    decorView.setSystemUiVisibility(io.objectbox.model.PropertyFlags.UNSIGNED);
                } else {
                    decorView.setSystemUiVisibility(0);
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    private static void initStatusBarStyle(android.app.Activity activity, boolean z, boolean z2) {
        if (z && z2) {
            activity.getWindow().getDecorView().setSystemUiVisibility(256);
            return;
        }
        if (!z && !z2) {
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        } else {
            if (z || !z2) {
                return;
            }
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        }
    }

    public static void setUpStatusBarLightMode(android.view.Window window, boolean z) {
        window.clearFlags(1024);
        window.clearFlags(67108864);
        try {
            window.getDecorView().setSystemUiVisibility(1280);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        window.addFlags(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
        window.setStatusBarColor(0);
        window.getDecorView().setSystemUiVisibility(514);
        window.getDecorView().setSystemUiVisibility(z ? 9216 : 1024);
    }
}
