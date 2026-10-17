package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MaxHeightLayout extends com.up366.mobile.common.views.PaddingShadowLayout {
    private int maxHeight;

    public MaxHeightLayout(android.content.Context context) {
        this(context, null);
    }

    public MaxHeightLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxHeightLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.PaddingShadowLayout_MaxHeight);
        this.maxHeight = (int) typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(this.maxHeight, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
        int measuredHeight = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            android.view.View childAt = getChildAt(i3);
            measureChild(childAt, i, iMakeMeasureSpec);
            measuredHeight += childAt.getMeasuredHeight();
        }
        setMeasuredDimension(i, android.view.View.MeasureSpec.makeMeasureSpec(java.lang.Math.min(measuredHeight, this.maxHeight), com.up366.medialibrary.common.utils.PictureFileUtils.GB));
    }
}
