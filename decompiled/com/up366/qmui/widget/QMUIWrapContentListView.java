package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIWrapContentListView extends android.widget.ListView {
    private int mMaxHeight;

    public QMUIWrapContentListView(android.content.Context context) {
        super(context);
        this.mMaxHeight = 536870911;
    }

    public QMUIWrapContentListView(android.content.Context context, int i) {
        super(context);
        this.mMaxHeight = i;
    }

    public QMUIWrapContentListView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxHeight = 536870911;
    }

    public QMUIWrapContentListView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxHeight = 536870911;
    }

    public void setMaxHeight(int i) {
        if (this.mMaxHeight != i) {
            this.mMaxHeight = i;
            requestLayout();
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER));
    }
}
