package com.up366.qmui.layout;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIConstraintLayout extends com.up366.qmui.alpha.QMUIAlphaConstraintLayout implements com.up366.qmui.layout.IQMUILayout {
    private com.up366.qmui.layout.QMUILayoutHelper mLayoutHelper;

    public QMUIConstraintLayout(android.content.Context context) {
        super(context);
        init(context, null, 0);
    }

    public QMUIConstraintLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public QMUIConstraintLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        this.mLayoutHelper = new com.up366.qmui.layout.QMUILayoutHelper(context, attributeSet, i, this);
        setChangeAlphaWhenPress(false);
        setChangeAlphaWhenDisable(false);
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

    protected void onMeasure(int i, int i2) {
        int measuredWidthSpec = this.mLayoutHelper.getMeasuredWidthSpec(i);
        int measuredHeightSpec = this.mLayoutHelper.getMeasuredHeightSpec(i2);
        super.onMeasure(measuredWidthSpec, measuredHeightSpec);
        int iHandleMiniWidth = this.mLayoutHelper.handleMiniWidth(measuredWidthSpec, getMeasuredWidth());
        int iHandleMiniHeight = this.mLayoutHelper.handleMiniHeight(measuredHeightSpec, getMeasuredHeight());
        if (measuredWidthSpec == iHandleMiniWidth && measuredHeightSpec == iHandleMiniHeight) {
            return;
        }
        super.onMeasure(iHandleMiniWidth, iHandleMiniHeight);
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
        this.mLayoutHelper.setBorderColor(i);
        invalidate();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setBorderWidth(int i) {
        this.mLayoutHelper.setBorderWidth(i);
        invalidate();
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

    public void dispatchDraw(android.graphics.Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mLayoutHelper.drawDividers(canvas, getWidth(), getHeight());
        this.mLayoutHelper.dispatchRoundBorderDraw(canvas);
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
