package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIWrapContentScrollView extends com.up366.qmui.widget.QMUIObservableScrollView {
    private int mMaxHeight;

    public QMUIWrapContentScrollView(android.content.Context context) {
        super(context);
        this.mMaxHeight = 536870911;
    }

    public QMUIWrapContentScrollView(android.content.Context context, int i) {
        super(context);
        this.mMaxHeight = i;
    }

    public QMUIWrapContentScrollView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxHeight = 536870911;
    }

    public QMUIWrapContentScrollView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxHeight = 536870911;
    }

    public void setMaxHeight(int i) {
        if (this.mMaxHeight != i) {
            this.mMaxHeight = i;
            requestLayout();
        }
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int iMin = java.lang.Math.min(android.view.View.MeasureSpec.getSize(i2), this.mMaxHeight);
        if (layoutParams != null && layoutParams.height > 0 && layoutParams.height <= this.mMaxHeight) {
            iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(layoutParams.height, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
        } else {
            iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(iMin, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
        }
        super.onMeasure(i, iMakeMeasureSpec);
    }
}
