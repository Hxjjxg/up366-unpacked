package com.up366.notchtools;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class NotchTools {
    public static final java.lang.String NOTCH_CONTAINER = "notch_container";
    public static final java.lang.String TOOLBAR_CONTAINER = "toolbar_container";
    public static final int VERSION_P = 28;
    private boolean mHasJudge;
    private boolean mIsNotchScreen;
    private int notchHeight;
    private com.up366.notchtools.core.INotchSupport notchScreenSupport = null;
    private static com.up366.notchtools.NotchTools sFullScreenTolls = new com.up366.notchtools.NotchTools();
    private static final int CURRENT_SDK = android.os.Build.VERSION.SDK_INT;

    public void initNotchTools(android.view.Window window) {
        com.up366.notchtools.helper.NotchStatusBarUtils.sShowNavigation = true;
        isNotchScreen(window);
        getNotchHeight(window);
    }

    public static com.up366.notchtools.NotchTools getInst() {
        return sFullScreenTolls;
    }

    private NotchTools() {
    }

    public boolean isNotchScreen(android.view.Window window) {
        if (!this.mHasJudge) {
            if (this.notchScreenSupport == null) {
                checkScreenSupportInit(window);
            }
            com.up366.notchtools.core.INotchSupport iNotchSupport = this.notchScreenSupport;
            if (iNotchSupport == null) {
                this.mHasJudge = true;
                this.mIsNotchScreen = false;
            } else {
                this.mIsNotchScreen = iNotchSupport.isNotchScreen(window);
            }
        }
        return this.mIsNotchScreen;
    }

    public boolean isNotchScreen() {
        return this.mIsNotchScreen;
    }

    public int getNotchHeight(android.view.Window window) {
        if (this.notchScreenSupport == null) {
            checkScreenSupportInit(window);
        }
        com.up366.notchtools.core.INotchSupport iNotchSupport = this.notchScreenSupport;
        if (iNotchSupport == null) {
            this.notchHeight = 0;
        }
        int notchHeight = iNotchSupport.getNotchHeight(window);
        this.notchHeight = notchHeight;
        return notchHeight;
    }

    public int getNotchHeight() {
        return this.notchHeight;
    }

    public int getStatusHeight(android.view.Window window) {
        return com.up366.notchtools.helper.NotchStatusBarUtils.getStatusBarHeight(window.getContext());
    }

    public void fitNotchForLayoutParams(android.view.WindowManager.LayoutParams layoutParams, android.view.Window window) {
        if (this.notchScreenSupport == null) {
            checkScreenSupportInit(window);
        }
        com.up366.notchtools.core.INotchSupport iNotchSupport = this.notchScreenSupport;
        if (iNotchSupport == null) {
            return;
        }
        iNotchSupport.fullScreenLayoutParams(layoutParams, window);
    }

    public com.up366.notchtools.NotchTools showNavigation(boolean z) {
        com.up366.notchtools.helper.NotchStatusBarUtils.sShowNavigation = z;
        return this;
    }

    public void fullScreenDontUseStatusForActivityOnCreate(final android.app.Activity activity) {
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new android.view.View.OnAttachStateChangeListener() { // from class: com.up366.notchtools.NotchTools.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(android.view.View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(android.view.View view) {
                com.up366.notchtools.NotchTools.this.fullScreenDontUseStatus(activity);
            }
        });
    }

    public void fullScreenDontUseStatusForActivityOnCreate(final android.app.Activity activity, final com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new android.view.View.OnAttachStateChangeListener() { // from class: com.up366.notchtools.NotchTools.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(android.view.View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(android.view.View view) {
                com.up366.notchtools.NotchTools.this.fullScreenDontUseStatus(activity, onNotchCallBack);
            }
        });
    }

    public void fullScreenDontUseStatusForOnWindowFocusChanged(android.app.Activity activity) {
        fullScreenDontUseStatus(activity);
    }

    public void fullScreenDontUseStatus(android.app.Activity activity) {
        fullScreenDontUseStatus(activity, null);
    }

    public void fullScreenDontUseStatus(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        if (this.notchScreenSupport == null) {
            checkScreenSupportInit(activity.getWindow());
        }
        if (this.notchScreenSupport == null) {
            return;
        }
        if (isPortrait(activity)) {
            this.notchScreenSupport.fullScreenDontUseStatusForPortrait(activity, onNotchCallBack);
        } else {
            this.notchScreenSupport.fullScreenDontUseStatusForLandscape(activity, onNotchCallBack);
        }
    }

    public void fullScreenUseStatusForActivityOnCreate(final android.app.Activity activity) {
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new android.view.View.OnAttachStateChangeListener() { // from class: com.up366.notchtools.NotchTools.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(android.view.View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(android.view.View view) {
                com.up366.notchtools.NotchTools.this.fullScreenUseStatus(activity);
            }
        });
    }

    public void fullScreenUseStatusForActivityOnCreate(final android.app.Activity activity, final com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new android.view.View.OnAttachStateChangeListener() { // from class: com.up366.notchtools.NotchTools.4
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(android.view.View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(android.view.View view) {
                com.up366.notchtools.NotchTools.this.fullScreenUseStatus(activity, onNotchCallBack);
            }
        });
    }

    public void fullScreenUseStatusForOnWindowFocusChanged(android.app.Activity activity) {
        fullScreenUseStatus(activity);
    }

    public void fullScreenUseStatus(android.app.Activity activity) {
        fullScreenUseStatus(activity, null);
    }

    public void fullScreenUseStatus(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        if (this.notchScreenSupport == null) {
            checkScreenSupportInit(activity.getWindow());
        }
        com.up366.notchtools.core.INotchSupport iNotchSupport = this.notchScreenSupport;
        if (iNotchSupport != null) {
            iNotchSupport.fullScreenUseStatus(activity, onNotchCallBack);
        }
    }

    public void translucentStatusBar(android.app.Activity activity) {
        if (this.notchScreenSupport == null) {
            checkScreenSupportInit(activity.getWindow());
        }
        com.up366.notchtools.core.INotchSupport iNotchSupport = this.notchScreenSupport;
        if (iNotchSupport != null) {
            iNotchSupport.translucentStatusBar(activity);
        }
    }

    public void translucentStatusBar(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        if (this.notchScreenSupport == null) {
            checkScreenSupportInit(activity.getWindow());
        }
        com.up366.notchtools.core.INotchSupport iNotchSupport = this.notchScreenSupport;
        if (iNotchSupport != null) {
            iNotchSupport.translucentStatusBar(activity, onNotchCallBack);
        }
    }

    private void checkScreenSupportInit(android.view.Window window) {
        if (this.notchScreenSupport != null) {
            return;
        }
        int i = CURRENT_SDK;
        if (i < 26) {
            this.notchScreenSupport = new com.up366.notchtools.phone.CommonScreen();
            return;
        }
        com.up366.notchtools.helper.DeviceBrandTools deviceBrandTools = com.up366.notchtools.helper.DeviceBrandTools.getInstance();
        if (i < 28) {
            if (deviceBrandTools.isHuaWei()) {
                this.notchScreenSupport = new com.up366.notchtools.phone.HuaWeiNotchScreen();
                return;
            }
            if (deviceBrandTools.isMiui()) {
                this.notchScreenSupport = new com.up366.notchtools.phone.MiuiNotchScreen();
                return;
            }
            if (deviceBrandTools.isVivo()) {
                this.notchScreenSupport = new com.up366.notchtools.phone.VivoNotchScreen();
                return;
            }
            if (deviceBrandTools.isOppo()) {
                this.notchScreenSupport = new com.up366.notchtools.phone.OppoNotchScreen();
                return;
            } else if (deviceBrandTools.isSamsung()) {
                this.notchScreenSupport = new com.up366.notchtools.phone.SamsungPunchHoleScreen();
                return;
            } else {
                this.notchScreenSupport = new com.up366.notchtools.phone.CommonScreen();
                return;
            }
        }
        if (deviceBrandTools.isHuaWei()) {
            this.notchScreenSupport = new com.up366.notchtools.phone.PVersionNotchScreen();
        } else {
            this.notchScreenSupport = new com.up366.notchtools.phone.PVersionNotchScreenWithFakeNotch();
        }
    }

    private boolean isPortrait(android.app.Activity activity) {
        return activity.getResources().getConfiguration().orientation == 1;
    }
}
