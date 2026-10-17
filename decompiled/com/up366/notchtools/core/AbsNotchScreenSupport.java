package com.up366.notchtools.core;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AbsNotchScreenSupport implements com.up366.notchtools.core.INotchSupport {
    @Override // com.up366.notchtools.core.INotchSupport
    public void fullScreenLayoutParams(android.view.WindowManager.LayoutParams layoutParams, android.view.Window window) {
    }

    @Override // com.up366.notchtools.core.INotchSupport
    public int getStatusHeight(android.view.Window window) {
        return com.up366.notchtools.helper.NotchStatusBarUtils.getStatusBarHeight(window.getContext());
    }

    @Override // com.up366.notchtools.core.INotchSupport
    public void fullScreenDontUseStatus(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        com.up366.notchtools.helper.NotchStatusBarUtils.setFullScreenWithSystemUi(activity.getWindow(), false);
        onBindCallBackWithNotchProperty(activity, onNotchCallBack);
    }

    @Override // com.up366.notchtools.core.INotchSupport
    public void fullScreenDontUseStatusForPortrait(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        fullScreenDontUseStatus(activity, onNotchCallBack);
    }

    @Override // com.up366.notchtools.core.INotchSupport
    public void fullScreenDontUseStatusForLandscape(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        com.up366.notchtools.helper.NotchStatusBarUtils.setFullScreenWithSystemUi(activity.getWindow(), false);
        onBindCallBackWithNotchProperty(activity, onNotchCallBack);
        if (isNotchScreen(activity.getWindow())) {
            com.up366.notchtools.helper.NotchStatusBarUtils.hideFakeNotchView(activity.getWindow());
        }
    }

    @Override // com.up366.notchtools.core.INotchSupport
    public void fullScreenUseStatus(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        com.up366.notchtools.helper.NotchStatusBarUtils.setFullScreenWithSystemUi(activity.getWindow(), false);
        onBindCallBackWithNotchProperty(activity, getNotchHeight(activity.getWindow()), onNotchCallBack);
    }

    @Override // com.up366.notchtools.core.INotchSupport
    public void translucentStatusBar(android.app.Activity activity) {
        translucentStatusBar(activity, null);
    }

    @Override // com.up366.notchtools.core.INotchSupport
    public void translucentStatusBar(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        com.up366.notchtools.helper.NotchStatusBarUtils.hideFakeNotchView(activity.getWindow());
        com.up366.notchtools.helper.NotchStatusBarUtils.setStatusBarTransparent(activity.getWindow(), onNotchCallBack);
    }

    protected void onBindCallBackWithNotchProperty(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        if (onNotchCallBack != null) {
            com.up366.notchtools.core.NotchProperty notchProperty = new com.up366.notchtools.core.NotchProperty();
            notchProperty.setNotchHeight(getNotchHeight(activity.getWindow()));
            notchProperty.setNotch(isNotchScreen(activity.getWindow()));
            if (onNotchCallBack != null) {
                onNotchCallBack.onNotchPropertyCallback(notchProperty);
            }
        }
    }

    protected void onBindCallBackWithNotchProperty(android.app.Activity activity, int i, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        if (onNotchCallBack != null) {
            com.up366.notchtools.core.NotchProperty notchProperty = new com.up366.notchtools.core.NotchProperty();
            notchProperty.setNotchHeight(getNotchHeight(activity.getWindow()));
            notchProperty.setNotch(isNotchScreen(activity.getWindow()));
            notchProperty.setMarginTop(i);
            if (onNotchCallBack != null) {
                onNotchCallBack.onNotchPropertyCallback(notchProperty);
            }
        }
    }
}
