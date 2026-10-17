package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class NavBarUtils {
    public static void setNavBarColor(android.app.Activity activity, int i) {
        setNavBarColor(activity.getWindow(), i);
    }

    public static void setNavBarColor(android.view.Window window, int i) {
        window.setNavigationBarColor(i);
    }
}
