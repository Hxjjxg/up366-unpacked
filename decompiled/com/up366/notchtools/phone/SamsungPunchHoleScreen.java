package com.up366.notchtools.phone;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SamsungPunchHoleScreen extends com.up366.notchtools.core.AbsNotchScreenSupport {
    @Override // com.up366.notchtools.core.INotchSupport
    public boolean isNotchScreen(android.view.Window window) {
        if (window == null) {
            return false;
        }
        try {
            android.content.res.Resources resources = window.getContext().getResources();
            int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");
            java.lang.String string = identifier > 0 ? resources.getString(identifier) : null;
            if (string != null) {
                return !android.text.TextUtils.isEmpty(string);
            }
            return false;
        } catch (java.lang.Exception unused) {
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
            android.view.Window window = activity.getWindow();
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                java.lang.reflect.Field field = attributes.getClass().getField("layoutInDisplayCutoutMode");
                field.setAccessible(true);
                field.setInt(attributes, 1);
                window.setAttributes(attributes);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            com.up366.notchtools.helper.NotchStatusBarUtils.showFakeNotchView(activity.getWindow());
        }
    }

    @Override // com.up366.notchtools.core.AbsNotchScreenSupport, com.up366.notchtools.core.INotchSupport
    public void fullScreenDontUseStatusForPortrait(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        fullScreenDontUseStatus(activity, onNotchCallBack);
    }

    @Override // com.up366.notchtools.core.AbsNotchScreenSupport, com.up366.notchtools.core.INotchSupport
    public void fullScreenUseStatus(android.app.Activity activity, com.up366.notchtools.core.OnNotchCallBack onNotchCallBack) {
        super.fullScreenUseStatus(activity, onNotchCallBack);
        if (isNotchScreen(activity.getWindow())) {
            android.view.Window window = activity.getWindow();
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                java.lang.reflect.Field field = attributes.getClass().getField("layoutInDisplayCutoutMode");
                field.setAccessible(true);
                field.setInt(attributes, 1);
                window.setAttributes(attributes);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.up366.notchtools.core.AbsNotchScreenSupport, com.up366.notchtools.core.INotchSupport
    public void fullScreenLayoutParams(android.view.WindowManager.LayoutParams layoutParams, android.view.Window window) {
        super.fullScreenLayoutParams(layoutParams, window);
        if (isNotchScreen(window)) {
            try {
                java.lang.reflect.Field field = layoutParams.getClass().getField("layoutInDisplayCutoutMode");
                field.setAccessible(true);
                field.setInt(layoutParams, 1);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }
}
