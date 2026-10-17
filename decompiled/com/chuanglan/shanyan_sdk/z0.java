package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class z0 {

    class a implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ android.view.ViewGroup a;

        a(android.view.ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.a.setPadding(0, 0, 0, 0);
            this.a.requestLayout();
        }
    }

    private static int a() {
        return 7942;
    }

    public static void a(android.app.Activity activity, boolean z) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    android.view.Window window = activity.getWindow();
                    if (window == null) {
                        return;
                    }
                    boolean z2 = (window.getAttributes().flags & io.objectbox.model.PropertyFlags.UNSIGNED) != 0;
                    if (z && !z2) {
                        window.addFlags(io.objectbox.model.PropertyFlags.UNSIGNED);
                    } else if (!z && z2) {
                        window.clearFlags(io.objectbox.model.PropertyFlags.UNSIGNED);
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(android.app.Activity activity, com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        android.view.Window window = activity.getWindow();
        try {
            if (shanYanUIConfig == null) {
                a(window);
            } else {
                a(window, shanYanUIConfig);
            }
        } catch (java.lang.Exception e) {
            a(window, e, "setSystemStatusBar with config");
        }
    }

    public static void c(android.app.Activity activity, com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        android.view.Window window = activity.getWindow();
        try {
            if (shanYanUIConfig == null) {
                a(window);
            } else {
                b(window, shanYanUIConfig);
            }
        } catch (java.lang.Exception e) {
            a(window, e, "setSystemStatusBar with config");
        }
    }

    private static void b(android.view.Window window, com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig) {
        b(window, shanYanUIConfig.isStatusBarHidden());
        if (shanYanUIConfig.getStatusBarColor() == -1) {
            a(window, shanYanUIConfig.isLightColor());
        } else {
            a(window, shanYanUIConfig.getStatusBarColor(), shanYanUIConfig.isLightColor());
        }
        if (shanYanUIConfig.isVirtualKeyTransparent()) {
            b(window);
        }
    }

    public static void a(android.app.Activity activity, float f) {
        android.view.Window window;
        if (activity == null || activity.isFinishing() || (window = activity.getWindow()) == null || f == -1.0f) {
            return;
        }
        window.setDimAmount(f);
    }

    private static void a(android.view.Window window, com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig) {
        b(window, shanYanUIConfig.isPrivacyStatusBarHidden());
        if (shanYanUIConfig.getStatusBarColor() == -1) {
            a(window, shanYanUIConfig.isPrivacyLightColor());
        } else {
            a(window, shanYanUIConfig.getPrivacyStatusBarColor(), shanYanUIConfig.isPrivacyLightColor());
        }
        if (shanYanUIConfig.isVirtualKeyTransparent()) {
            b(window);
        }
    }

    private static void b(android.view.Window window, boolean z) {
        if (z) {
            window.addFlags(1024);
        } else {
            window.clearFlags(1024);
        }
    }

    private static void b(android.view.Window window) {
        window.clearFlags(134217728);
        window.setNavigationBarColor(0);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 512);
    }

    public static void b(android.app.Activity activity, boolean z) {
        if (z) {
            a(activity);
        } else {
            b(activity);
        }
    }

    private static void a(android.view.Window window) {
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(9216);
        window.addFlags(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
        window.setStatusBarColor(0);
    }

    public static void b(android.app.Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        android.view.Window window = activity.getWindow();
        try {
            window.getDecorView().setSystemUiVisibility(0);
        } catch (java.lang.Exception e) {
            a(window, e, "showSystemUI");
        }
    }

    private static void a(android.view.Window window, boolean z) {
        window.clearFlags(201326592);
        window.getDecorView().setSystemUiVisibility(z ? 1024 : 9216);
        window.addFlags(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
        window.setStatusBarColor(0);
    }

    private static void a(android.view.Window window, int i, boolean z) {
        window.setStatusBarColor(i);
        window.setNavigationBarColor(i);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        window.getDecorView().setSystemUiVisibility(z ? systemUiVisibility & (-8193) : systemUiVisibility | io.objectbox.model.PropertyFlags.UNSIGNED);
    }

    private static void a(android.view.Window window, java.lang.Exception exc, java.lang.String str) {
        exc.printStackTrace();
        com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", str + " Exception: ", exc);
        if ("setSystemStatusBar with config".equals(str)) {
            try {
                a(window);
            } catch (java.lang.Exception e) {
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "Fallback to default config failed: ", e);
            }
        }
    }

    public static void a(android.app.Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        android.view.Window window = activity.getWindow();
        try {
            android.view.View decorView = window.getDecorView();
            int iA = a();
            decorView.setSystemUiVisibility(iA);
            com.chuanglan.shanyan_sdk.Q.a("UIShanYanLogger", "setSystemUiVisibility", java.lang.Integer.valueOf(iA));
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                android.view.WindowManager.LayoutParams attributes = window.getAttributes();
                com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(attributes, 1);
                window.setAttributes(attributes);
            }
        } catch (java.lang.Exception e) {
            a(window, e, "hideSystemUI");
        }
    }

    public static void a(android.app.Activity activity, com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        android.view.Window window = activity.getWindow();
        try {
            a(window, shanYanUIConfig.getDialogDimAmount());
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = com.chuanglan.shanyan_sdk.AbstractC0046c.a(activity.getApplicationContext(), shanYanUIConfig.getDialogWidth());
            attributes.height = com.chuanglan.shanyan_sdk.AbstractC0046c.a(activity.getApplicationContext(), shanYanUIConfig.getDialogHeight());
            attributes.x = shanYanUIConfig.getDialogX();
            if (shanYanUIConfig.isDialogBottom()) {
                attributes.gravity = 80;
            } else {
                attributes.y = shanYanUIConfig.getDialogY();
            }
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(attributes, 1);
            }
            window.setAttributes(attributes);
        } catch (java.lang.Exception e) {
            a(window, e, "configureDialogTheme");
        }
    }

    private static void a(android.view.Window window, float f) {
        if (f != -1.0f) {
            window.setDimAmount(f);
        } else {
            window.setDimAmount(0.6f);
        }
        window.addFlags(2);
        window.clearFlags(1024);
    }

    public static void a(android.view.ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            try {
                com.chuanglan.shanyan_sdk.Q.a("UIShanYanLogger", "fitSystemWindows", java.lang.Boolean.valueOf(z));
                if (!z) {
                    viewGroup.setFitsSystemWindows(false);
                    viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new com.chuanglan.shanyan_sdk.z0.a(viewGroup));
                } else {
                    viewGroup.setFitsSystemWindows(true);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }
}
