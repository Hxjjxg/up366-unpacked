package com.up366.notchtools.phone;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class HuaWeiNotchScreen extends com.up366.notchtools.core.AbsNotchScreenSupport {
    private static final java.lang.String DISPLAY_NOTCH_STATUS = "display_notch_status";
    public static final int FLAG_NOTCH_SUPPORT = 65536;
    private static final java.lang.String TAG = "HuaWeiNotchScreen";

    @Override // com.up366.notchtools.core.INotchSupport
    public boolean isNotchScreen(android.view.Window window) {
        try {
            try {
                try {
                    java.lang.Class<?> clsLoadClass = window.getContext().getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                    return ((java.lang.Boolean) clsLoadClass.getMethod("hasNotchInScreen", null).invoke(clsLoadClass, null)).booleanValue();
                } catch (java.lang.Exception unused) {
                    android.util.Log.d(TAG, "hasNotchInScreen Exception");
                    return false;
                }
            } catch (java.lang.ClassNotFoundException unused2) {
                android.util.Log.d(TAG, "hasNotchInScreen ClassNotFoundException");
                return false;
            } catch (java.lang.NoSuchMethodException unused3) {
                android.util.Log.d(TAG, "hasNotchInScreen NoSuchMethodException");
                return false;
            }
        } catch (java.lang.Throwable unused4) {
            return false;
        }
    }

    @Override // com.up366.notchtools.core.INotchSupport
    public int getNotchHeight(android.view.Window window) {
        if (!isNotchScreen(window)) {
            return 0;
        }
        int[] iArr = {0, 0};
        try {
            java.lang.Class<?> clsLoadClass = window.getContext().getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((int[]) clsLoadClass.getMethod("getNotchSize", null).invoke(clsLoadClass, null))[1];
        } catch (java.lang.ClassNotFoundException unused) {
            return iArr[1];
        } catch (java.lang.NoSuchMethodException unused2) {
            return iArr[1];
        } catch (java.lang.Exception unused3) {
            return iArr[1];
        } catch (java.lang.Throwable unused4) {
            return iArr[1];
        }
    }

    @Override // com.up366.notchtools.core.AbsNotchScreenSupport, com.up366.notchtools.core.INotchSupport
    public void fullScreenDontUseStatus(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        fullScreenUseStatus(activity, onNotchCallBack);
        if (isNotchScreen(activity.getWindow())) {
            com.up366.notchtools.helper.NotchStatusBarUtils.showFakeNotchView(activity.getWindow());
        }
    }

    @Override // com.up366.notchtools.core.AbsNotchScreenSupport, com.up366.notchtools.core.INotchSupport
    public void fullScreenUseStatus(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        super.fullScreenUseStatus(activity, onNotchCallBack);
        if (isNotchScreen(activity.getWindow())) {
            setFullScreenWindowLayoutInDisplayCutout(activity.getWindow());
        }
    }

    public static void setFullScreenWindowLayoutInDisplayCutout(android.view.Window window) {
        if (window == null) {
            return;
        }
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.android.view.LayoutParamsEx");
            cls.getMethod("addHwFlags", java.lang.Integer.TYPE).invoke(cls.getConstructor(android.view.WindowManager.LayoutParams.class).newInstance(attributes), 65536);
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            android.util.Log.e("test", "hw add notch screen flag api error");
        } catch (java.lang.Exception unused2) {
            android.util.Log.e("test", "other Exception");
        }
    }

    public static void setNotFullScreenWindowLayoutInDisplayCutout(android.view.Window window) {
        if (window == null) {
            return;
        }
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.android.view.LayoutParamsEx");
            cls.getMethod("clearHwFlags", java.lang.Integer.TYPE).invoke(cls.getConstructor(android.view.WindowManager.LayoutParams.class).newInstance(attributes), 65536);
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            android.util.Log.e("test", "hw clear notch screen flag api error");
        } catch (java.lang.Exception unused2) {
            android.util.Log.e("test", "other Exception");
        }
    }

    private boolean isHideNotch(android.content.Context context) {
        return android.provider.Settings.Secure.getInt(context.getContentResolver(), DISPLAY_NOTCH_STATUS, 0) == 1;
    }

    @Override // com.up366.notchtools.core.AbsNotchScreenSupport, com.up366.notchtools.core.INotchSupport
    public void fullScreenLayoutParams(android.view.WindowManager.LayoutParams layoutParams, android.view.Window window) {
        if (layoutParams == null) {
            return;
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.android.view.LayoutParamsEx");
            cls.getMethod("addHwFlags", java.lang.Integer.TYPE).invoke(cls.getConstructor(android.view.WindowManager.LayoutParams.class).newInstance(layoutParams), 65536);
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            android.util.Log.e("test", "hw add notch screen flag api error");
        } catch (java.lang.Exception unused2) {
            android.util.Log.e("test", "other Exception");
        }
    }
}
