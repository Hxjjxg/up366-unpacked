package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RecyclerSpaceItemView extends android.widget.FrameLayout {
    private float dp;
    private int height;

    public RecyclerSpaceItemView(android.content.Context context) {
        this(context, null);
    }

    public RecyclerSpaceItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerSpaceItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dp = getResources().getDisplayMetrics().density;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(i, this.height);
    }

    public void setSpaceHeight(int i) {
        this.height = (int) (i * this.dp);
        postInvalidate();
    }
}
