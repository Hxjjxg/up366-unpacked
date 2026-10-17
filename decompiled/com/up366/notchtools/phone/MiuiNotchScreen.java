package com.up366.notchtools.phone;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MiuiNotchScreen extends com.up366.notchtools.core.AbsNotchScreenSupport {
    private static final java.lang.String TAG = "MiuiNotchScreen";

    @Override // com.up366.notchtools.core.INotchSupport
    public boolean isNotchScreen(android.view.Window window) {
        return "1".equals(com.up366.notchtools.helper.SystemProperties.getInstance().get("ro.miui.notch"));
    }

    @Override // com.up366.notchtools.core.INotchSupport
    public int getNotchHeight(android.view.Window window) {
        if (!isNotchScreen(window) || window == null) {
            return 0;
        }
        android.content.Context context = window.getContext();
        if (isHideNotch(window.getContext())) {
            return com.up366.notchtools.helper.NotchStatusBarUtils.getStatusBarHeight(context);
        }
        return getRealNotchHeight(context);
    }

    private int getRealNotchHeight(android.content.Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return com.up366.notchtools.helper.NotchStatusBarUtils.getStatusBarHeight(context);
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
        if (android.os.Build.VERSION.SDK_INT < 26 || !isNotchScreen(activity.getWindow())) {
            return;
        }
        try {
            java.lang.reflect.Method method = android.view.Window.class.getMethod("addExtraFlags", java.lang.Integer.TYPE);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(activity.getWindow(), 1792);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isHideNotch(android.content.Context context) {
        return android.provider.Settings.Global.getInt(context.getContentResolver(), "force_black", 0) == 1;
    }

    @Override // com.up366.notchtools.core.AbsNotchScreenSupport, com.up366.notchtools.core.INotchSupport
    public void fullScreenLayoutParams(android.view.WindowManager.LayoutParams layoutParams, android.view.Window window) {
        if (android.os.Build.VERSION.SDK_INT < 26 || !isNotchScreen(window)) {
            return;
        }
        try {
            java.lang.reflect.Method method = android.view.Window.class.getMethod("addExtraFlags", java.lang.Integer.TYPE);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(window, 1792);
        } catch (java.lang.Exception e) {
            android.util.Log.e(TAG, "fullScreenLayoutParams error " + e.getMessage());
        }
    }
}
