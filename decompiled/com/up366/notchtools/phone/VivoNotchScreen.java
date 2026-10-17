package com.up366.notchtools.phone;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class VivoNotchScreen extends com.up366.notchtools.core.AbsNotchScreenSupport {
    private static final java.lang.String TAG = "VivoNotchScreen";
    private java.lang.Class mClass;
    private java.lang.reflect.Method mMethod;

    @Override // com.up366.notchtools.core.INotchSupport
    public boolean isNotchScreen(android.view.Window window) {
        if (window == null) {
            return false;
        }
        try {
            java.lang.Class<?> clsLoadClass = window.getContext().getClassLoader().loadClass("android.util.FtFeature");
            this.mClass = clsLoadClass;
            java.lang.reflect.Method method = clsLoadClass.getMethod("isFeatureSupport", java.lang.Integer.TYPE);
            this.mMethod = method;
            return ((java.lang.Boolean) method.invoke(this.mClass, 32)).booleanValue();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    @Override // com.up366.notchtools.core.INotchSupport
    public int getNotchHeight(android.view.Window window) {
        if (isNotchScreen(window)) {
            return com.up366.notchtools.helper.NotchStatusBarUtils.getStatusBarHeight(window.getContext());
        }
        return 0;
    }

    @Override // com.up366.notchtools.core.AbsNotchScreenSupport, com.up366.notchtools.core.INotchSupport
    public void fullScreenDontUseStatus(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        super.fullScreenDontUseStatus(activity, onNotchCallBack);
        if (isNotchScreen(activity.getWindow())) {
            com.up366.notchtools.helper.NotchStatusBarUtils.showFakeNotchView(activity.getWindow());
        }
    }

    @Override // com.up366.notchtools.core.AbsNotchScreenSupport, com.up366.notchtools.core.INotchSupport
    public void fullScreenDontUseStatusForPortrait(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        fullScreenDontUseStatus(activity, onNotchCallBack);
    }

    @Override // com.up366.notchtools.core.AbsNotchScreenSupport, com.up366.notchtools.core.INotchSupport
    public void fullScreenDontUseStatusForLandscape(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        super.fullScreenDontUseStatusForLandscape(activity, onNotchCallBack);
    }

    @Override // com.up366.notchtools.core.AbsNotchScreenSupport, com.up366.notchtools.core.INotchSupport
    public void fullScreenUseStatus(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        super.fullScreenUseStatus(activity, onNotchCallBack);
    }

    @Override // com.up366.notchtools.core.AbsNotchScreenSupport, com.up366.notchtools.core.INotchSupport
    public void fullScreenLayoutParams(android.view.WindowManager.LayoutParams layoutParams, android.view.Window window) {
        super.fullScreenLayoutParams(layoutParams, window);
    }
}
