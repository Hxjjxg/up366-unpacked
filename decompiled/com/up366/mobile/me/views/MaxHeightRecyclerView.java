package com.up366.mobile.me.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MaxHeightRecyclerView extends androidx.recyclerview.widget.RecyclerView {
    private int mMaxHeight;

    public MaxHeightRecyclerView(android.content.Context context) {
        super(context);
    }

    public MaxHeightRecyclerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context, attributeSet);
    }

    public MaxHeightRecyclerView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize(context, attributeSet);
    }

    private void initialize(android.content.Context context, android.util.AttributeSet attributeSet) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.MaxHeightRecyclerView);
        this.mMaxHeight = typedArrayObtainStyledAttributes.getLayoutDimension(0, this.mMaxHeight);
        typedArrayObtainStyledAttributes.recycle();
    }

    protected void onMeasure(int i, int i2) {
        try {
            int i3 = this.mMaxHeight;
            if (i3 > 0) {
                i2 = android.view.View.MeasureSpec.makeMeasureSpec(i3, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
            }
            super.onMeasure(i, i2);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("onMeasure error " + e.getMessage(), e);
        }
    }
}
