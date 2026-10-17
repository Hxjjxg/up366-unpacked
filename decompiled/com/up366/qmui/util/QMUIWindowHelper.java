package com.up366.qmui.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIWindowHelper {
    public static void setWindowType(android.view.WindowManager.LayoutParams layoutParams) {
        layoutParams.type = 2005;
    }

    public static android.graphics.Rect unSafeGetWindowVisibleInsets(android.view.View view) {
        java.lang.Object attachInfoFromView = getAttachInfoFromView(view);
        if (attachInfoFromView == null) {
            return null;
        }
        try {
            java.lang.reflect.Field declaredField = attachInfoFromView.getClass().getDeclaredField("mVisibleInsets");
            declaredField.setAccessible(true);
            java.lang.Object obj = declaredField.get(attachInfoFromView);
            if (obj instanceof android.graphics.Rect) {
                return (android.graphics.Rect) obj;
            }
        } catch (java.lang.Throwable unused) {
        }
        return null;
    }

    public static android.graphics.Rect unSafeGetContentInsets(android.view.View view) {
        java.lang.Object attachInfoFromView = getAttachInfoFromView(view);
        if (attachInfoFromView == null) {
            return null;
        }
        try {
            java.lang.reflect.Field declaredField = attachInfoFromView.getClass().getDeclaredField("mContentInsets");
            declaredField.setAccessible(true);
            java.lang.Object obj = declaredField.get(attachInfoFromView);
            if (obj instanceof android.graphics.Rect) {
                return (android.graphics.Rect) obj;
            }
        } catch (java.lang.Throwable unused) {
        }
        return null;
    }

    public static java.lang.Object getAttachInfoFromView(android.view.View view) {
        android.view.ViewParent parent;
        java.lang.Object obj = null;
        if (android.os.Build.VERSION.SDK_INT > 28) {
            android.view.View rootView = view.getRootView();
            if (rootView != null && (parent = rootView.getParent()) != null) {
                java.lang.reflect.Field declaredField = parent.getClass().getDeclaredField("mAttachInfo");
                declaredField.setAccessible(true);
                obj = declaredField.get(parent);
            }
            return obj;
        }
        java.lang.reflect.Field declaredField2 = android.view.View.class.getDeclaredField("mAttachInfo");
        declaredField2.setAccessible(true);
        obj = declaredField2.get(view);
        return obj;
    }
}
