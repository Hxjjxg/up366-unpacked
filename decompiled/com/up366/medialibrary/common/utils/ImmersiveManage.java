package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ImmersiveManage {
    public static void immersiveAboveAPI23(androidx.appcompat.app.AppCompatActivity appCompatActivity, int i, int i2, boolean z) {
        immersiveAboveAPI23(appCompatActivity, false, false, i, i2, z);
    }

    public static void immersiveAboveAPI23(androidx.appcompat.app.AppCompatActivity appCompatActivity, boolean z, boolean z2, int i, int i2, boolean z3) {
        try {
            android.view.Window window = appCompatActivity.getWindow();
            boolean z4 = true;
            if (z && z2) {
                window.clearFlags(201326592);
                com.up366.medialibrary.common.utils.LightStatusBarUtils.setLightStatusBar(appCompatActivity, true, true, i == 0, z3);
                window.addFlags(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
            } else if (!z && !z2) {
                window.requestFeature(1);
                window.clearFlags(201326592);
                if (i != 0) {
                    z4 = false;
                }
                com.up366.medialibrary.common.utils.LightStatusBarUtils.setLightStatusBar(appCompatActivity, false, false, z4, z3);
                window.addFlags(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
            } else {
                if (z) {
                    return;
                }
                window.requestFeature(1);
                window.clearFlags(201326592);
                com.up366.medialibrary.common.utils.LightStatusBarUtils.setLightStatusBar(appCompatActivity, false, true, i == 0, z3);
                window.addFlags(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
            }
            window.setStatusBarColor(i);
            window.setNavigationBarColor(i2);
        } catch (java.lang.Exception unused) {
        }
    }
}
