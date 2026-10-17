package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIRadiusImageView2 extends androidx.appcompat.widget.AppCompatImageView implements com.up366.qmui.layout.IQMUILayout {
    private static final int DEFAULT_BORDER_COLOR = -7829368;
    private com.up366.qmui.alpha.QMUIAlphaViewHelper mAlphaViewHelper;
    private int mBorderColor;
    private int mBorderWidth;
    private android.graphics.ColorFilter mColorFilter;
    private boolean mIsCircle;
    private boolean mIsInOnTouchEvent;
    private boolean mIsSelected;
    private boolean mIsTouchSelectModeEnabled;
    private com.up366.qmui.layout.QMUILayoutHelper mLayoutHelper;
    private int mSelectedBorderColor;
    private int mSelectedBorderWidth;
    private android.graphics.ColorFilter mSelectedColorFilter;
    private int mSelectedMaskColor;

    public QMUIRadiusImageView2(android.content.Context context) {
        super(context);
        this.mIsCircle = false;
        this.mIsSelected = false;
        this.mIsTouchSelectModeEnabled = true;
        this.mIsInOnTouchEvent = false;
        init(context, null, 0);
    }

    public QMUIRadiusImageView2(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsCircle = false;
        this.mIsSelected = false;
        this.mIsTouchSelectModeEnabled = true;
        this.mIsInOnTouchEvent = false;
        init(context, attributeSet, 0);
    }

    public QMUIRadiusImageView2(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsCircle = false;
        this.mIsSelected = false;
        this.mIsTouchSelectModeEnabled = true;
        this.mIsInOnTouchEvent = false;
        init(context, attributeSet, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        this.mLayoutHelper = new com.up366.qmui.layout.QMUILayoutHelper(context, attributeSet, i, this);
        setChangeAlphaWhenPress(false);
        setChangeAlphaWhenDisable(false);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView2, i, 0);
        this.mBorderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView2_qmui_border_width, 0);
        this.mBorderColor = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView2_qmui_border_color, -7829368);
        this.mSelectedBorderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView2_qmui_selected_border_width, this.mBorderWidth);
        this.mSelectedBorderColor = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView2_qmui_selected_border_color, this.mBorderColor);
        int color = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView2_qmui_selected_mask_color, 0);
        this.mSelectedMaskColor = color;
        if (color != 0) {
            this.mSelectedColorFilter = new android.graphics.PorterDuffColorFilter(this.mSelectedMaskColor, android.graphics.PorterDuff.Mode.DARKEN);
        }
        this.mIsTouchSelectModeEnabled = typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView2_qmui_is_touch_select_mode_enabled, true);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView2_qmui_is_circle, false);
        this.mIsCircle = z;
        if (!z) {
            setRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView2_qmui_corner_radius, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.up366.qmui.alpha.QMUIAlphaViewHelper getAlphaViewHelper() {
        if (this.mAlphaViewHelper == null) {
            this.mAlphaViewHelper = new com.up366.qmui.alpha.QMUIAlphaViewHelper(this);
        }
        return this.mAlphaViewHelper;
    }

    public void setCornerRadius(int i) {
        setRadius(i);
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        return super.setFrame(i, i2, i3, i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPressed(boolean z) {
        super.setPressed(z);
        getAlphaViewHelper().onPressedChanged(this, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        getAlphaViewHelper().onEnabledChanged(this, z);
    }

    public void setChangeAlphaWhenPress(boolean z) {
        getAlphaViewHelper().setChangeAlphaWhenPress(z);
    }

    public void setChangeAlphaWhenDisable(boolean z) {
        getAlphaViewHelper().setChangeAlphaWhenDisable(z);
    }

    public void setCircle(boolean z) {
        if (this.mIsCircle != z) {
            this.mIsCircle = z;
            requestLayout();
            invalidate();
        }
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public int getCornerRadius() {
        return getRadius();
    }

    public int getSelectedBorderColor() {
        return this.mSelectedBorderColor;
    }

    public int getSelectedBorderWidth() {
        return this.mSelectedBorderWidth;
    }

    public int getSelectedMaskColor() {
        return this.mSelectedMaskColor;
    }

    public boolean isCircle() {
        return this.mIsCircle;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    protected void onMeasure(int i, int i2) {
        int measuredWidthSpec = this.mLayoutHelper.getMeasuredWidthSpec(i);
        int measuredHeightSpec = this.mLayoutHelper.getMeasuredHeightSpec(i2);
        super.onMeasure(measuredWidthSpec, measuredHeightSpec);
        int iHandleMiniWidth = this.mLayoutHelper.handleMiniWidth(measuredWidthSpec, getMeasuredWidth());
        int iHandleMiniHeight = this.mLayoutHelper.handleMiniHeight(measuredHeightSpec, getMeasuredHeight());
        if (measuredWidthSpec != iHandleMiniWidth || measuredHeightSpec != iHandleMiniHeight) {
            super.onMeasure(iHandleMiniWidth, iHandleMiniHeight);
        }
        if (this.mIsCircle) {
            int measuredHeight = getMeasuredHeight();
            int measuredWidth = getMeasuredWidth();
            int i3 = measuredWidth / 2;
            if (measuredHeight != measuredWidth) {
                int iMin = java.lang.Math.min(measuredHeight, measuredWidth);
                i3 = iMin / 2;
                int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(iMin, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
                super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            setRadius(i3);
        }
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void updateTopDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.updateTopDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void updateBottomDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.updateBottomDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void updateLeftDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.updateLeftDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void updateRightDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.updateRightDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void onlyShowTopDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.onlyShowTopDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void onlyShowBottomDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.onlyShowBottomDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void onlyShowLeftDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.onlyShowLeftDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void onlyShowRightDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.onlyShowRightDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void updateBottomSeparatorColor(int i) {
        this.mLayoutHelper.updateBottomSeparatorColor(i);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void updateLeftSeparatorColor(int i) {
        this.mLayoutHelper.updateLeftSeparatorColor(i);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void updateRightSeparatorColor(int i) {
        this.mLayoutHelper.updateRightSeparatorColor(i);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void updateTopSeparatorColor(int i) {
        this.mLayoutHelper.updateTopSeparatorColor(i);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setTopDividerAlpha(int i) {
        this.mLayoutHelper.setTopDividerAlpha(i);
        invalidate();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setBottomDividerAlpha(int i) {
        this.mLayoutHelper.setBottomDividerAlpha(i);
        invalidate();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setLeftDividerAlpha(int i) {
        this.mLayoutHelper.setLeftDividerAlpha(i);
        invalidate();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setRightDividerAlpha(int i) {
        this.mLayoutHelper.setRightDividerAlpha(i);
        invalidate();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setRadiusAndShadow(int i, int i2, float f) {
        this.mLayoutHelper.setRadiusAndShadow(i, i2, f);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setRadiusAndShadow(int i, int i2, int i3, float f) {
        this.mLayoutHelper.setRadiusAndShadow(i, i2, i3, f);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setRadiusAndShadow(int i, int i2, int i3, int i4, float f) {
        this.mLayoutHelper.setRadiusAndShadow(i, i2, i3, i4, f);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setRadius(int i) {
        this.mLayoutHelper.setRadius(i);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setRadius(int i, int i2) {
        this.mLayoutHelper.setRadius(i, i2);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public int getRadius() {
        return this.mLayoutHelper.getRadius();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setOutlineInset(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.setOutlineInset(i, i2, i3, i4);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setBorderColor(int i) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
            if (this.mIsSelected) {
                return;
            }
            this.mLayoutHelper.setBorderColor(i);
            invalidate();
        }
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setBorderWidth(int i) {
        if (this.mBorderWidth != i) {
            this.mBorderWidth = i;
            if (this.mIsSelected) {
                return;
            }
            this.mLayoutHelper.setBorderWidth(i);
            invalidate();
        }
    }

    public void setSelectedBorderColor(int i) {
        if (this.mSelectedBorderColor != i) {
            this.mSelectedBorderColor = i;
            if (this.mIsSelected) {
                this.mLayoutHelper.setBorderColor(i);
                invalidate();
            }
        }
    }

    public void setSelectedBorderWidth(int i) {
        if (this.mSelectedBorderWidth != i) {
            this.mSelectedBorderWidth = i;
            if (this.mIsSelected) {
                this.mLayoutHelper.setBorderWidth(i);
                invalidate();
            }
        }
    }

    public void setSelectedMaskColor(int i) {
        if (this.mSelectedMaskColor != i) {
            this.mSelectedMaskColor = i;
            if (i != 0) {
                this.mSelectedColorFilter = new android.graphics.PorterDuffColorFilter(this.mSelectedMaskColor, android.graphics.PorterDuff.Mode.DARKEN);
            } else {
                this.mSelectedColorFilter = null;
            }
            if (this.mIsSelected) {
                invalidate();
            }
        }
        this.mSelectedMaskColor = i;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setShowBorderOnlyBeforeL(boolean z) {
        this.mLayoutHelper.setShowBorderOnlyBeforeL(z);
        invalidate();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setHideRadiusSide(int i) {
        this.mLayoutHelper.setHideRadiusSide(i);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public int getHideRadiusSide() {
        return this.mLayoutHelper.getHideRadiusSide();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public boolean setWidthLimit(int i) {
        if (!this.mLayoutHelper.setWidthLimit(i)) {
            return true;
        }
        requestLayout();
        invalidate();
        return true;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public boolean setHeightLimit(int i) {
        if (!this.mLayoutHelper.setHeightLimit(i)) {
            return true;
        }
        requestLayout();
        invalidate();
        return true;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setUseThemeGeneralShadowElevation() {
        this.mLayoutHelper.setUseThemeGeneralShadowElevation();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setOutlineExcludePadding(boolean z) {
        this.mLayoutHelper.setOutlineExcludePadding(z);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setShadowElevation(int i) {
        this.mLayoutHelper.setShadowElevation(i);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public int getShadowElevation() {
        return this.mLayoutHelper.getShadowElevation();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setShadowAlpha(float f) {
        this.mLayoutHelper.setShadowAlpha(f);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setShadowColor(int i) {
        this.mLayoutHelper.setShadowColor(i);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public int getShadowColor() {
        return this.mLayoutHelper.getShadowColor();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setOuterNormalColor(int i) {
        this.mLayoutHelper.setOuterNormalColor(i);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public float getShadowAlpha() {
        return this.mLayoutHelper.getShadowAlpha();
    }

    protected void dispatchDraw(android.graphics.Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mLayoutHelper.drawDividers(canvas, getWidth(), getHeight());
        this.mLayoutHelper.dispatchRoundBorderDraw(canvas);
    }

    public void setSelected(boolean z) {
        if (!this.mIsInOnTouchEvent) {
            super.setSelected(z);
        }
        if (this.mIsSelected != z) {
            this.mIsSelected = z;
            if (z) {
                super.setColorFilter(this.mSelectedColorFilter);
            } else {
                super.setColorFilter(this.mColorFilter);
            }
            boolean z2 = this.mIsSelected;
            int i = z2 ? this.mSelectedBorderWidth : this.mBorderWidth;
            int i2 = z2 ? this.mSelectedBorderColor : this.mBorderColor;
            this.mLayoutHelper.setBorderWidth(i);
            this.mLayoutHelper.setBorderColor(i2);
            invalidate();
        }
    }

    public void setTouchSelectModeEnabled(boolean z) {
        this.mIsTouchSelectModeEnabled = z;
    }

    public boolean isTouchSelectModeEnabled() {
        return this.mIsTouchSelectModeEnabled;
    }

    public void setSelectedColorFilter(android.graphics.ColorFilter colorFilter) {
        if (this.mSelectedColorFilter == colorFilter) {
            return;
        }
        this.mSelectedColorFilter = colorFilter;
        if (this.mIsSelected) {
            super.setColorFilter(colorFilter);
        }
    }

    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        if (this.mColorFilter == colorFilter) {
            return;
        }
        this.mColorFilter = colorFilter;
        if (this.mIsSelected) {
            return;
        }
        super.setColorFilter(colorFilter);
    }

    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        this.mIsInOnTouchEvent = true;
        if (!isClickable()) {
            setSelected(false);
            return super.onTouchEvent(motionEvent);
        }
        if (this.mIsTouchSelectModeEnabled) {
            int action = motionEvent.getAction();
            if (action == 0) {
                setSelected(true);
            } else if (action == 1 || action == 3 || action == 4 || action == 8) {
                setSelected(false);
            }
        }
        this.mIsInOnTouchEvent = false;
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public boolean hasBorder() {
        return this.mLayoutHelper.hasBorder();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public boolean hasLeftSeparator() {
        return this.mLayoutHelper.hasLeftSeparator();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public boolean hasTopSeparator() {
        return this.mLayoutHelper.hasTopSeparator();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public boolean hasRightSeparator() {
        return this.mLayoutHelper.hasRightSeparator();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public boolean hasBottomSeparator() {
        return this.mLayoutHelper.hasBottomSeparator();
    }
}
