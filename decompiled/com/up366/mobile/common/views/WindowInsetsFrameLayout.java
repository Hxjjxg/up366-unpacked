package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WindowInsetsFrameLayout extends android.widget.FrameLayout {
    public WindowInsetsFrameLayout(android.content.Context context) {
        this(context, null);
    }

    public WindowInsetsFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WindowInsetsFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOnHierarchyChangeListener(new android.view.ViewGroup.OnHierarchyChangeListener() { // from class: com.up366.mobile.common.views.WindowInsetsFrameLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(android.view.View view, android.view.View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(android.view.View view, android.view.View view2) {
                com.up366.mobile.common.views.WindowInsetsFrameLayout.this.requestApplyInsets();
            }
        });
    }

    @Override // android.view.View
    public android.view.WindowInsets onApplyWindowInsets(android.view.WindowInsets windowInsets) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).dispatchApplyWindowInsets(windowInsets);
        }
        return windowInsets;
    }
}
