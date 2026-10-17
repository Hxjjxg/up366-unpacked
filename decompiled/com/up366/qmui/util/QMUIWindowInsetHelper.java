package com.up366.qmui.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIWindowInsetHelper {
    public static final int KEYBOARD_HEIGHT_BOUNDARY_DP = 100;
    private final int KEYBOARD_HEIGHT_BOUNDARY;
    private final java.lang.ref.WeakReference<com.up366.qmui.widget.IWindowInsetLayout> mWindowInsetLayoutWR;
    private int sApplySystemWindowInsetsCount = 0;
    private static final java.lang.Object KEYBOARD_CONSUMER = new java.lang.Object();
    private static java.util.ArrayList<java.lang.Class<? extends android.view.ViewGroup>> sCustomHandlerContainerList = new java.util.ArrayList<>();

    public QMUIWindowInsetHelper(android.view.ViewGroup viewGroup, com.up366.qmui.widget.IWindowInsetLayout iWindowInsetLayout) {
        this.mWindowInsetLayoutWR = new java.lang.ref.WeakReference<>(iWindowInsetLayout);
        this.KEYBOARD_HEIGHT_BOUNDARY = com.up366.qmui.util.QMUIDisplayHelper.dp2px(viewGroup.getContext(), 100);
        if (com.up366.qmui.util.QMUINotchHelper.isNotchOfficialSupport()) {
            setOnApplyWindowInsetsListener28(viewGroup);
        } else {
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new androidx.core.view.OnApplyWindowInsetsListener() { // from class: com.up366.qmui.util.QMUIWindowInsetHelper.1
                public androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
                    if (com.up366.qmui.util.QMUIWindowInsetHelper.this.mWindowInsetLayoutWR.get() == null || !((com.up366.qmui.widget.IWindowInsetLayout) com.up366.qmui.util.QMUIWindowInsetHelper.this.mWindowInsetLayoutWR.get()).applySystemWindowInsets21(windowInsetsCompat) || windowInsetsCompat.isConsumed()) {
                        return windowInsetsCompat;
                    }
                    androidx.core.view.WindowInsetsCompat windowInsetsCompatConsumeSystemWindowInsets = windowInsetsCompat.consumeSystemWindowInsets();
                    return windowInsetsCompatConsumeSystemWindowInsets.isConsumed() ? windowInsetsCompatConsumeSystemWindowInsets : windowInsetsCompatConsumeSystemWindowInsets.consumeStableInsets();
                }
            });
        }
    }

    private void setOnApplyWindowInsetsListener28(android.view.ViewGroup viewGroup) {
        viewGroup.setOnApplyWindowInsetsListener(new android.view.View.OnApplyWindowInsetsListener() { // from class: com.up366.qmui.util.QMUIWindowInsetHelper.2
            @Override // android.view.View.OnApplyWindowInsetsListener
            public android.view.WindowInsets onApplyWindowInsets(android.view.View view, android.view.WindowInsets windowInsets) {
                if (com.up366.qmui.util.QMUIWindowInsetHelper.this.mWindowInsetLayoutWR.get() == null || !((com.up366.qmui.widget.IWindowInsetLayout) com.up366.qmui.util.QMUIWindowInsetHelper.this.mWindowInsetLayoutWR.get()).applySystemWindowInsets21(windowInsets)) {
                    return windowInsets;
                }
                android.view.WindowInsets windowInsetsConsumeSystemWindowInsets = windowInsets.consumeSystemWindowInsets();
                if (androidx.core.util.HalfKt$.ExternalSyntheticApiModelOutline0.m(windowInsetsConsumeSystemWindowInsets) != null) {
                    windowInsetsConsumeSystemWindowInsets = androidx.core.util.HalfKt$.ExternalSyntheticApiModelOutline0.m(windowInsetsConsumeSystemWindowInsets);
                }
                return windowInsetsConsumeSystemWindowInsets.isConsumed() ? windowInsetsConsumeSystemWindowInsets : windowInsetsConsumeSystemWindowInsets.consumeStableInsets();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean defaultApplySystemWindowInsets19(android.view.ViewGroup r9, android.graphics.Rect r10) {
        /*
            r8 = this;
            int r0 = r10.bottom
            int r1 = r8.KEYBOARD_HEIGHT_BOUNDARY
            r2 = 0
            if (r0 < r1) goto L29
            boolean r0 = r8.shouldInterceptKeyboardInset(r9)
            if (r0 == 0) goto L29
            boolean r0 = r9 instanceof com.up366.qmui.widget.IWindowInsetKeyboardConsumer
            if (r0 == 0) goto L1a
            r0 = r9
            com.up366.qmui.widget.IWindowInsetKeyboardConsumer r0 = (com.up366.qmui.widget.IWindowInsetKeyboardConsumer) r0
            int r1 = r10.bottom
            r0.onHandleKeyboard(r1)
            goto L1f
        L1a:
            int r0 = r10.bottom
            com.up366.qmui.util.QMUIViewHelper.setPaddingBottom(r9, r0)
        L1f:
            int r0 = com.qmuiteam.qmui.R.id.qmui_window_inset_keyboard_area_consumer
            java.lang.Object r1 = com.up366.qmui.util.QMUIWindowInsetHelper.KEYBOARD_CONSUMER
            r9.setTag(r0, r1)
            r10.bottom = r2
            goto L3d
        L29:
            int r0 = com.qmuiteam.qmui.R.id.qmui_window_inset_keyboard_area_consumer
            r1 = 0
            r9.setTag(r0, r1)
            boolean r0 = r9 instanceof com.up366.qmui.widget.IWindowInsetKeyboardConsumer
            if (r0 == 0) goto L3a
            r0 = r9
            com.up366.qmui.widget.IWindowInsetKeyboardConsumer r0 = (com.up366.qmui.widget.IWindowInsetKeyboardConsumer) r0
            r0.onHandleKeyboard(r2)
            goto L3d
        L3a:
            com.up366.qmui.util.QMUIViewHelper.setPaddingBottom(r9, r2)
        L3d:
            r0 = r2
            r1 = r0
        L3f:
            int r3 = r9.getChildCount()
            if (r0 >= r3) goto L8c
            android.view.View r3 = r9.getChildAt(r0)
            boolean r4 = jumpDispatch(r3)
            if (r4 == 0) goto L50
            goto L89
        L50:
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>(r10)
            r8.computeInsets(r3, r4)
            boolean r5 = isHandleContainer(r3)
            if (r5 != 0) goto L6a
            int r5 = r4.left
            int r6 = r4.top
            int r7 = r4.right
            int r4 = r4.bottom
            r3.setPadding(r5, r6, r7, r4)
            goto L89
        L6a:
            boolean r5 = r3 instanceof com.up366.qmui.widget.IWindowInsetLayout
            r6 = 1
            if (r5 == 0) goto L7e
            com.up366.qmui.widget.IWindowInsetLayout r3 = (com.up366.qmui.widget.IWindowInsetLayout) r3
            boolean r3 = r3.applySystemWindowInsets19(r4)
            if (r1 != 0) goto L7c
            if (r3 == 0) goto L7a
            goto L7c
        L7a:
            r1 = r2
            goto L89
        L7c:
            r1 = r6
            goto L89
        L7e:
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            boolean r3 = r8.defaultApplySystemWindowInsets19(r3, r4)
            if (r1 != 0) goto L7c
            if (r3 == 0) goto L7a
            goto L7c
        L89:
            int r0 = r0 + 1
            goto L3f
        L8c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.qmui.util.QMUIWindowInsetHelper.defaultApplySystemWindowInsets19(android.view.ViewGroup, android.graphics.Rect):boolean");
    }

    public boolean defaultApplySystemWindowInsets21(android.view.ViewGroup viewGroup, java.lang.Object obj) {
        if (com.up366.qmui.util.QMUINotchHelper.isNotchOfficialSupport()) {
            return defaultApplySystemWindowInsets(viewGroup, (android.view.WindowInsets) obj);
        }
        return defaultApplySystemWindowInsetsCompat(viewGroup, (androidx.core.view.WindowInsetsCompat) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean defaultApplySystemWindowInsetsCompat(android.view.ViewGroup viewGroup, androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
        boolean z;
        if (windowInsetsCompat.getSystemWindowInsetBottom() >= this.KEYBOARD_HEIGHT_BOUNDARY && shouldInterceptKeyboardInset(viewGroup)) {
            if (viewGroup instanceof com.up366.qmui.widget.IWindowInsetKeyboardConsumer) {
                ((com.up366.qmui.widget.IWindowInsetKeyboardConsumer) viewGroup).onHandleKeyboard(windowInsetsCompat.getSystemWindowInsetBottom());
            } else {
                com.up366.qmui.util.QMUIViewHelper.setPaddingBottom(viewGroup, windowInsetsCompat.getSystemWindowInsetBottom());
            }
            viewGroup.setTag(com.qmuiteam.qmui.R.id.qmui_window_inset_keyboard_area_consumer, KEYBOARD_CONSUMER);
            z = true;
        } else {
            if (viewGroup instanceof com.up366.qmui.widget.IWindowInsetKeyboardConsumer) {
                ((com.up366.qmui.widget.IWindowInsetKeyboardConsumer) viewGroup).onHandleKeyboard(0);
            } else {
                com.up366.qmui.util.QMUIViewHelper.setPaddingBottom(viewGroup, 0);
            }
            viewGroup.setTag(com.qmuiteam.qmui.R.id.qmui_window_inset_keyboard_area_consumer, null);
            z = false;
        }
        boolean z2 = false;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            android.view.View childAt = viewGroup.getChildAt(i);
            if (!jumpDispatch(childAt)) {
                int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
                int systemWindowInsetRight = windowInsetsCompat.getSystemWindowInsetRight();
                if (com.up366.qmui.util.QMUINotchHelper.needFixLandscapeNotchAreaFitSystemWindow(viewGroup) && viewGroup.getResources().getConfiguration().orientation == 2) {
                    systemWindowInsetLeft = java.lang.Math.max(systemWindowInsetLeft, com.up366.qmui.util.QMUINotchHelper.getSafeInsetLeft(viewGroup));
                    systemWindowInsetRight = java.lang.Math.max(systemWindowInsetRight, com.up366.qmui.util.QMUINotchHelper.getSafeInsetRight(viewGroup));
                }
                android.graphics.Rect rect = new android.graphics.Rect(systemWindowInsetLeft, windowInsetsCompat.getSystemWindowInsetTop(), systemWindowInsetRight, z ? 0 : windowInsetsCompat.getSystemWindowInsetBottom());
                computeInsets(childAt, rect);
                androidx.core.view.WindowInsetsCompat windowInsetsCompatDispatchApplyWindowInsets = androidx.core.view.ViewCompat.dispatchApplyWindowInsets(childAt, windowInsetsCompat.replaceSystemWindowInsets(rect));
                z2 = z2 || (windowInsetsCompatDispatchApplyWindowInsets != null && windowInsetsCompatDispatchApplyWindowInsets.isConsumed());
            }
        }
        return z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean defaultApplySystemWindowInsets(android.view.ViewGroup viewGroup, android.view.WindowInsets windowInsets) {
        boolean z;
        this.sApplySystemWindowInsetsCount++;
        if (com.up366.qmui.util.QMUINotchHelper.isNotchOfficialSupport()) {
            if (this.sApplySystemWindowInsetsCount == 1) {
                dispatchNotchInsetChange(viewGroup);
            }
            windowInsets = androidx.core.util.HalfKt$.ExternalSyntheticApiModelOutline0.m(windowInsets);
        }
        if (windowInsets.getSystemWindowInsetBottom() >= this.KEYBOARD_HEIGHT_BOUNDARY && shouldInterceptKeyboardInset(viewGroup)) {
            if (viewGroup instanceof com.up366.qmui.widget.IWindowInsetKeyboardConsumer) {
                ((com.up366.qmui.widget.IWindowInsetKeyboardConsumer) viewGroup).onHandleKeyboard(windowInsets.getSystemWindowInsetBottom());
            } else {
                com.up366.qmui.util.QMUIViewHelper.setPaddingBottom(viewGroup, windowInsets.getSystemWindowInsetBottom());
            }
            viewGroup.setTag(com.qmuiteam.qmui.R.id.qmui_window_inset_keyboard_area_consumer, KEYBOARD_CONSUMER);
            z = true;
        } else {
            if (viewGroup instanceof com.up366.qmui.widget.IWindowInsetKeyboardConsumer) {
                ((com.up366.qmui.widget.IWindowInsetKeyboardConsumer) viewGroup).onHandleKeyboard(0);
            } else {
                com.up366.qmui.util.QMUIViewHelper.setPaddingBottom(viewGroup, 0);
            }
            viewGroup.setTag(com.qmuiteam.qmui.R.id.qmui_window_inset_keyboard_area_consumer, null);
            z = false;
        }
        boolean z2 = false;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            android.view.View childAt = viewGroup.getChildAt(i);
            if (!jumpDispatch(childAt)) {
                android.graphics.Rect rect = new android.graphics.Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), z ? 0 : windowInsets.getSystemWindowInsetBottom());
                computeInsets(childAt, rect);
                z2 = z2 || childAt.dispatchApplyWindowInsets(windowInsets.replaceSystemWindowInsets(rect)).isConsumed();
            }
        }
        this.sApplySystemWindowInsetsCount--;
        return z2;
    }

    private boolean shouldInterceptKeyboardInset(android.view.ViewGroup viewGroup) {
        return viewGroup.getClass().getAnnotation(com.up366.qmui.util.DoNotInterceptKeyboardInset.class) == null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void dispatchNotchInsetChange(android.view.View view) {
        if (!((view instanceof com.up366.qmui.widget.INotchInsetConsumer) && ((com.up366.qmui.widget.INotchInsetConsumer) view).notifyInsetMaybeChanged()) && (view instanceof android.view.ViewGroup)) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                dispatchNotchInsetChange(viewGroup.getChildAt(i));
            }
        }
    }

    public static boolean jumpDispatch(android.view.View view) {
        return (view.getFitsSystemWindows() || isHandleContainer(view)) ? false : true;
    }

    public static boolean isHandleContainer(android.view.View view) {
        if ((view instanceof com.up366.qmui.widget.IWindowInsetLayout) || (view instanceof androidx.coordinatorlayout.widget.CoordinatorLayout) || (view instanceof androidx.drawerlayout.widget.DrawerLayout)) {
            return true;
        }
        java.util.Iterator<java.lang.Class<? extends android.view.ViewGroup>> it = sCustomHandlerContainerList.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    public static void addHandleContainer(java.lang.Class<? extends android.view.ViewGroup> cls) {
        sCustomHandlerContainerList.add(cls);
    }

    public void computeInsets(android.view.View view, android.graphics.Rect rect) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) {
            computeInsetsWithConstraint(view, rect, (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams);
        } else {
            computeInsetsWithGravity(view, rect, layoutParams);
        }
    }

    public void computeInsetsWithGravity(android.view.View view, android.graphics.Rect rect, android.view.ViewGroup.LayoutParams layoutParams) {
        int i = layoutParams instanceof android.widget.FrameLayout.LayoutParams ? ((android.widget.FrameLayout.LayoutParams) layoutParams).gravity : -1;
        if (i == -1) {
            i = 51;
        }
        if (layoutParams.width != -1) {
            int i2 = i & 7;
            if (i2 == 3) {
                rect.right = 0;
            } else if (i2 == 5) {
                rect.left = 0;
            }
        }
        if (layoutParams.height != -1) {
            int i3 = i & 112;
            if (i3 == 48) {
                rect.bottom = 0;
            } else {
                if (i3 != 80) {
                    return;
                }
                rect.top = 0;
            }
        }
    }

    public void computeInsetsWithConstraint(android.view.View view, android.graphics.Rect rect, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams) {
        if (layoutParams.width == -2) {
            if (layoutParams.leftToLeft == 0) {
                rect.right = 0;
            } else if (layoutParams.rightToRight == 0) {
                rect.left = 0;
            }
        }
        if (layoutParams.height == -2) {
            if (layoutParams.topToTop == 0) {
                rect.bottom = 0;
            } else if (layoutParams.bottomToBottom == 0) {
                rect.top = 0;
            }
        }
    }

    public static android.view.View findKeyboardAreaConsumer(android.view.View view) {
        while (view != null) {
            if (KEYBOARD_CONSUMER == view.getTag(com.qmuiteam.qmui.R.id.qmui_window_inset_keyboard_area_consumer)) {
                return view;
            }
            java.lang.Object parent = view.getParent();
            view = parent instanceof android.view.View ? (android.view.View) parent : null;
        }
        return null;
    }
}
