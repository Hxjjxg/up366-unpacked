package com.up366.notchtools.phone;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PVersionNotchScreen extends com.up366.notchtools.core.AbsNotchScreenSupport {
    @Override // com.up366.notchtools.core.INotchSupport
    public boolean isNotchScreen(android.view.Window window) {
        android.view.DisplayCutout displayCutoutM;
        android.view.WindowInsets rootWindowInsets = window.getDecorView().getRootWindowInsets();
        return (rootWindowInsets == null || (displayCutoutM = androidx.core.util.HalfKt$.ExternalSyntheticApiModelOutline0.m(rootWindowInsets)) == null || displayCutoutM.getBoundingRects() == null) ? false : true;
    }

    @Override // com.up366.notchtools.core.INotchSupport
    public int getNotchHeight(android.view.Window window) {
        android.view.DisplayCutout displayCutoutM;
        android.view.WindowInsets rootWindowInsets = window.getDecorView().getRootWindowInsets();
        if (rootWindowInsets == null || (displayCutoutM = androidx.core.util.HalfKt$.ExternalSyntheticApiModelOutline0.m(rootWindowInsets)) == null || displayCutoutM.getBoundingRects() == null) {
            return 0;
        }
        return displayCutoutM.getSafeInsetTop();
    }

    @Override // com.up366.notchtools.core.AbsNotchScreenSupport, com.up366.notchtools.core.INotchSupport
    public void fullScreenDontUseStatus(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        super.fullScreenDontUseStatus(activity, onNotchCallBack);
        if (isNotchScreen(activity.getWindow())) {
            android.view.WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(attributes, 2);
            activity.getWindow().setAttributes(attributes);
        }
    }

    @Override // com.up366.notchtools.core.AbsNotchScreenSupport, com.up366.notchtools.core.INotchSupport
    public void fullScreenUseStatus(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        super.fullScreenUseStatus(activity, onNotchCallBack);
        android.view.WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(attributes, 1);
        activity.getWindow().setAttributes(attributes);
    }

    @Override // com.up366.notchtools.core.AbsNotchScreenSupport, com.up366.notchtools.core.INotchSupport
    public void fullScreenLayoutParams(android.view.WindowManager.LayoutParams layoutParams, android.view.Window window) {
        super.fullScreenLayoutParams(layoutParams, window);
        com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(layoutParams, 1);
    }
}
