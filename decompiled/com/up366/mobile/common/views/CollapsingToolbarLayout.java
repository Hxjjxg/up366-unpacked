package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CollapsingToolbarLayout extends com.google.android.material.appbar.CollapsingToolbarLayout {
    public CollapsingToolbarLayout(android.content.Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        android.content.res.Resources resources;
        int i2;
        super(context, attributeSet, i);
        boolean z = false;
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.CollapsingToolbarLayout);
            z = typedArrayObtainStyledAttributes.getBoolean(4, false);
            typedArrayObtainStyledAttributes.recycle();
        }
        setUpStatusBarLightMode(z);
        if (z) {
            resources = getResources();
            i2 = com.up366.mobile.R.color.font_c4;
        } else {
            resources = getResources();
            i2 = com.up366.mobile.R.color.c9;
        }
        setExpandedTitleColor(resources.getColor(i2));
    }

    public void setUpStatusBarLightMode(boolean z) {
        if (isInEditMode()) {
            return;
        }
        setSystemUiVisibility(z ? 9216 : 1024);
    }
}
