package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FlowRadioGroupLayout extends android.widget.RadioGroup {
    private float itemHorizontalSpace;
    private float itemVerticalSpace;

    public FlowRadioGroupLayout(android.content.Context context) {
        super(context);
        this.itemHorizontalSpace = 20.0f;
        this.itemVerticalSpace = 20.0f;
        init(context, null);
    }

    public FlowRadioGroupLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.itemHorizontalSpace = 20.0f;
        this.itemVerticalSpace = 20.0f;
        init(context, attributeSet);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet) {
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.FlowRadioGroupLayout);
            this.itemHorizontalSpace = typedArrayObtainStyledAttributes.getDimension(0, 20.0f);
            this.itemVerticalSpace = typedArrayObtainStyledAttributes.getDimension(1, 20.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = android.view.View.MeasureSpec.getSize(i);
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(size, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
        int iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i3 = 0;
        int iMax = 0;
        int i4 = paddingLeft;
        while (true) {
            if (i3 >= getChildCount()) {
                break;
            }
            android.view.View childAt = getChildAt(i3);
            childAt.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = childAt.getMeasuredWidth();
            iMax = java.lang.Math.max(iMax, childAt.getMeasuredHeight());
            if (i4 != paddingLeft) {
                i4 = (int) (i4 + this.itemHorizontalSpace);
            }
            i4 += measuredWidth;
            if (i4 + paddingRight > size) {
                int i5 = measuredWidth + paddingLeft;
                paddingTop = ((int) (paddingTop + this.itemVerticalSpace)) + iMax;
                if (i3 == getChildCount() - 1) {
                    paddingTop += iMax + paddingBottom;
                    break;
                } else {
                    iMax = 0;
                    i4 = i5;
                }
            }
            if (i3 == getChildCount() - 1) {
                paddingTop += iMax + paddingBottom;
            }
            i3++;
        }
        setMeasuredDimension(size, paddingTop);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = paddingLeft;
        int iMax = 0;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            android.view.View childAt = getChildAt(i6);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            iMax = java.lang.Math.max(iMax, measuredHeight);
            if (i5 != paddingLeft) {
                i5 = (int) (i5 + this.itemHorizontalSpace);
            }
            i5 += measuredWidth;
            if (i5 + paddingRight > width) {
                i5 = paddingLeft + measuredWidth;
                paddingTop = ((int) (paddingTop + this.itemVerticalSpace)) + iMax;
                iMax = 0;
            }
            childAt.layout(i5 - measuredWidth, paddingTop, i5, measuredHeight + paddingTop);
        }
    }
}
