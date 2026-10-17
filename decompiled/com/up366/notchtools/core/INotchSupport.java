package com.up366.notchtools.core;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface INotchSupport {
    void fullScreenDontUseStatus(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack);

    void fullScreenDontUseStatusForLandscape(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack);

    void fullScreenDontUseStatusForPortrait(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack);

    void fullScreenLayoutParams(android.view.WindowManager.LayoutParams layoutParams, android.view.Window window);

    void fullScreenUseStatus(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack);

    int getNotchHeight(android.view.Window window);

    int getStatusHeight(android.view.Window window);

    boolean isNotchScreen(android.view.Window window);

    void translucentStatusBar(android.app.Activity activity);

    void translucentStatusBar(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack);
}
