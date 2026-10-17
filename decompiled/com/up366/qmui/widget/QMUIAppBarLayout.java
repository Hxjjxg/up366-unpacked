package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIAppBarLayout extends com.google.android.material.appbar.AppBarLayout implements com.up366.qmui.widget.IWindowInsetLayout {
    @Override // com.up366.qmui.widget.IWindowInsetLayout
    public boolean applySystemWindowInsets21(java.lang.Object obj) {
        return true;
    }

    public QMUIAppBarLayout(android.content.Context context) {
        super(context);
    }

    public QMUIAppBarLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.qmui.widget.IWindowInsetLayout
    public boolean applySystemWindowInsets19(final android.graphics.Rect rect) {
        java.lang.reflect.Field declaredField;
        if (!androidx.core.view.ViewCompat.getFitsSystemWindows(this)) {
            return false;
        }
        androidx.core.view.WindowInsetsCompat windowInsetsCompat = null;
        try {
            try {
                declaredField = com.google.android.material.appbar.AppBarLayout.class.getDeclaredField("lastInsets");
            } catch (java.lang.NoSuchFieldException unused) {
                declaredField = null;
            }
        } catch (java.lang.NoSuchFieldException unused2) {
            declaredField = com.google.android.material.appbar.AppBarLayout.class.getDeclaredField("mLastInsets");
        }
        if (declaredField != null) {
            declaredField.setAccessible(true);
            try {
                declaredField.set(this, new androidx.core.view.WindowInsetsCompat(windowInsetsCompat) { // from class: com.up366.qmui.widget.QMUIAppBarLayout.1
                    public int getSystemWindowInsetTop() {
                        return rect.top;
                    }
                });
            } catch (java.lang.IllegalAccessException unused3) {
            }
        }
        for (int i = 0; i < getChildCount(); i++) {
            android.view.View childAt = getChildAt(i);
            if (!com.up366.qmui.util.QMUIWindowInsetHelper.jumpDispatch(childAt)) {
                if (!com.up366.qmui.util.QMUIWindowInsetHelper.isHandleContainer(childAt)) {
                    childAt.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                } else if (childAt instanceof com.up366.qmui.widget.IWindowInsetLayout) {
                    ((com.up366.qmui.widget.IWindowInsetLayout) childAt).applySystemWindowInsets19(rect);
                }
            }
        }
        return true;
    }
}
