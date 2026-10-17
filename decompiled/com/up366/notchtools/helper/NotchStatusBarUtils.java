package com.up366.notchtools.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class NotchStatusBarUtils {
    public static boolean sShowNavigation = false;
    private static int statusBarHeight = -1;

    public static int getStatusBarHeight(android.content.Context context) {
        int i = statusBarHeight;
        if (i != -1) {
            return i;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            statusBarHeight = context.getResources().getDimensionPixelSize(identifier);
        }
        if (statusBarHeight < 0) {
            int dimensionPixelSize = 0;
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("com.android.internal.R$dimen");
                dimensionPixelSize = context.getResources().getDimensionPixelSize(java.lang.Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (java.lang.Exception unused) {
            } catch (java.lang.Throwable th) {
                statusBarHeight = 0;
                throw th;
            }
            statusBarHeight = dimensionPixelSize;
        }
        if (statusBarHeight < 0) {
            statusBarHeight = dip2px(context, 25.0f);
        }
        return statusBarHeight;
    }

    private static int dip2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void setFullScreenWithSystemUi(final android.view.Window window, boolean z) {
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 1024;
        window.setAttributes(attributes);
        window.getDecorView().setSystemUiVisibility((!sShowNavigation ? 1542 : 1028) | 4096);
        if (z) {
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new android.view.View.OnSystemUiVisibilityChangeListener() { // from class: com.up366.notchtools.helper.NotchStatusBarUtils.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i == 0) {
                        com.up366.notchtools.helper.NotchStatusBarUtils.setFullScreenWithSystemUi(window, false);
                    }
                }
            });
        }
    }

    public static void setStatusBarTransparent(android.view.Window window, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        window.clearFlags(1024);
        window.clearFlags(67108864);
        try {
            window.getDecorView().setSystemUiVisibility(1280);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        window.addFlags(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
        window.setStatusBarColor(0);
        if (!sShowNavigation) {
            window.getDecorView().setSystemUiVisibility(514);
        }
        com.up366.notchtools.core.NotchProperty notchProperty = new com.up366.notchtools.core.NotchProperty();
        notchProperty.setStatusBarHeight(com.up366.notchtools.NotchTools.getInst().getStatusHeight(window));
        notchProperty.setNotchHeight(com.up366.notchtools.NotchTools.getInst().getNotchHeight(window));
        notchProperty.setNotch(com.up366.notchtools.NotchTools.getInst().isNotchScreen(window));
        if (onNotchCallBack != null) {
            onNotchCallBack.onNotchPropertyCallback(notchProperty);
        }
    }

    private static void setToolbarContainerFillStatusBar(android.view.Window window) {
        android.view.View childAt;
        int statusHeight = com.up366.notchtools.NotchTools.getInst().getStatusHeight(window);
        android.view.ViewGroup toolBarContainer = getToolBarContainer(window);
        if (toolBarContainer == null || toolBarContainer.getChildCount() < 1 || (childAt = toolBarContainer.getChildAt(0)) == null) {
            return;
        }
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (layoutParams.height > 0) {
            layoutParams.height += statusHeight;
            childAt.setLayoutParams(layoutParams);
        } else {
            childAt.setPadding(0, statusHeight, 0, 0);
        }
    }

    public static void showFakeNotchView(android.view.Window window) {
        android.view.ViewGroup notchContainer = getNotchContainer(window);
        if (notchContainer == null) {
            return;
        }
        if (notchContainer.getChildCount() == 0) {
            android.view.View view = new android.view.View(window.getContext());
            view.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, com.up366.notchtools.NotchTools.getInst().getNotchHeight(window)));
            view.setBackgroundColor(com.up366.qmui.widget.QMUIProgressBar.DEFAULT_TEXT_COLOR);
            notchContainer.addView(view);
        }
        notchContainer.setVisibility(0);
    }

    public static void showFakeNotchViewColor(android.view.Window window, int i) {
        android.view.ViewGroup notchContainer = getNotchContainer(window);
        if (notchContainer != null && notchContainer.getChildCount() == 1) {
            notchContainer.getChildAt(0).setBackgroundColor(i);
        }
    }

    public static void hideFakeNotchView(android.view.Window window) {
        android.view.ViewGroup notchContainer = getNotchContainer(window);
        if (notchContainer == null) {
            return;
        }
        notchContainer.getChildCount();
        notchContainer.setVisibility(8);
    }

    private static android.view.ViewGroup getNotchContainer(android.view.Window window) {
        android.view.View decorView = window.getDecorView();
        if (decorView == null) {
            return null;
        }
        return (android.view.ViewGroup) decorView.findViewWithTag(com.up366.notchtools.NotchTools.NOTCH_CONTAINER);
    }

    public static android.view.ViewGroup getToolBarContainer(android.view.Window window) {
        android.view.View decorView = window.getDecorView();
        if (decorView == null) {
            return null;
        }
        return (android.view.ViewGroup) decorView.findViewWithTag(com.up366.notchtools.NotchTools.TOOLBAR_CONTAINER);
    }
}
