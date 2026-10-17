package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BottomMenuView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.BottomMenuViewLayoutBinding binding;
    private boolean firstComeIn;
    private int mJsonPath;
    private boolean mUsedAsCourseTab;
    private java.lang.String text;

    public BottomMenuView(android.content.Context context) {
        super(context);
        this.firstComeIn = true;
        init(context, null);
    }

    public BottomMenuView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.firstComeIn = true;
        init(context, attributeSet);
    }

    public BottomMenuView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.firstComeIn = true;
        init(context, attributeSet);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet) {
        this.binding = (com.up366.mobile.databinding.BottomMenuViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.bottom_menu_view_layout, this, true);
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.BottomMenuView);
            this.mUsedAsCourseTab = typedArrayObtainStyledAttributes.getBoolean(2, false);
            this.mJsonPath = typedArrayObtainStyledAttributes.getResourceId(0, -1);
            this.text = typedArrayObtainStyledAttributes.getString(1);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.binding.icon.setAnimation(this.mJsonPath);
        this.binding.icon.setSpeed(1.5f);
        this.binding.name.setText(this.text);
    }

    public void setText(java.lang.String str) {
        this.binding.name.setText(str);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.binding.icon.setEnabled(z);
        if (z) {
            this.binding.icon.pauseAnimation();
            this.binding.icon.setProgress(0.0f);
        } else if (this.mUsedAsCourseTab && this.firstComeIn) {
            this.binding.icon.setProgress(1.0f);
            this.firstComeIn = false;
        } else {
            this.binding.icon.playAnimation();
        }
        this.binding.name.setEnabled(z);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelSize(com.up366.mobile.R.dimen.main_bottom_view_tab_bar_height), 0);
        super.onMeasure(i, iMakeMeasureSpec);
        setMeasuredDimension(i, iMakeMeasureSpec);
    }

    public void setNumber(int i) {
        this.binding.number.setText(i < 100 ? java.lang.String.valueOf(i) : "99+");
        if (i <= 0) {
            this.binding.number.setVisibility(4);
        } else {
            this.binding.number.setVisibility(0);
        }
    }
}
