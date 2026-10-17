package com.up366.qmui.widget.roundwidget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIRoundButtonDrawable extends android.graphics.drawable.GradientDrawable {
    private android.content.res.ColorStateList mFillColors;
    private android.content.res.ColorStateList mStrokeColors;
    private boolean mRadiusAdjustBounds = true;
    private int mStrokeWidth = 0;

    private boolean hasNativeStateListAPI() {
        return true;
    }

    public void setBgData(android.content.res.ColorStateList colorStateList) {
        if (hasNativeStateListAPI()) {
            super.setColor(colorStateList);
        } else {
            this.mFillColors = colorStateList;
            setColor(colorStateList != null ? colorStateList.getColorForState(getState(), 0) : 0);
        }
    }

    public void setStrokeData(int i, android.content.res.ColorStateList colorStateList) {
        this.mStrokeWidth = i;
        this.mStrokeColors = colorStateList;
        if (hasNativeStateListAPI()) {
            super.setStroke(i, colorStateList);
        } else {
            setStroke(i, colorStateList != null ? colorStateList.getColorForState(getState(), 0) : 0);
        }
    }

    public int getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public void setStrokeColors(android.content.res.ColorStateList colorStateList) {
        setStrokeData(this.mStrokeWidth, colorStateList);
    }

    public void setIsRadiusAdjustBounds(boolean z) {
        this.mRadiusAdjustBounds = z;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        android.content.res.ColorStateList colorStateList = this.mFillColors;
        if (colorStateList != null) {
            setColor(colorStateList.getColorForState(iArr, 0));
            zOnStateChange = true;
        }
        android.content.res.ColorStateList colorStateList2 = this.mStrokeColors;
        if (colorStateList2 == null) {
            return zOnStateChange;
        }
        setStroke(this.mStrokeWidth, colorStateList2.getColorForState(iArr, 0));
        return true;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        android.content.res.ColorStateList colorStateList;
        android.content.res.ColorStateList colorStateList2 = this.mFillColors;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.mStrokeColors) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        if (this.mRadiusAdjustBounds) {
            setCornerRadius(java.lang.Math.min(rect.width(), rect.height()) / 2);
        }
    }

    public static com.up366.qmui.widget.roundwidget.QMUIRoundButtonDrawable fromAttributeSet(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        boolean z = false;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUIRoundButton, i, 0);
        android.content.res.ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(com.qmuiteam.qmui.R.styleable.QMUIRoundButton_qmui_backgroundColor);
        android.content.res.ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(com.qmuiteam.qmui.R.styleable.QMUIRoundButton_qmui_borderColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIRoundButton_qmui_borderWidth, 0);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUIRoundButton_qmui_isRadiusAdjustBounds, false);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIRoundButton_qmui_radius, 0);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIRoundButton_qmui_radiusTopLeft, 0);
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIRoundButton_qmui_radiusTopRight, 0);
        int dimensionPixelSize5 = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIRoundButton_qmui_radiusBottomLeft, 0);
        int dimensionPixelSize6 = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIRoundButton_qmui_radiusBottomRight, 0);
        typedArrayObtainStyledAttributes.recycle();
        com.up366.qmui.widget.roundwidget.QMUIRoundButtonDrawable qMUIRoundButtonDrawable = new com.up366.qmui.widget.roundwidget.QMUIRoundButtonDrawable();
        qMUIRoundButtonDrawable.setBgData(colorStateList);
        qMUIRoundButtonDrawable.setStrokeData(dimensionPixelSize, colorStateList2);
        if (dimensionPixelSize3 > 0 || dimensionPixelSize4 > 0 || dimensionPixelSize5 > 0 || dimensionPixelSize6 > 0) {
            float f = dimensionPixelSize3;
            float f2 = dimensionPixelSize4;
            float f3 = dimensionPixelSize6;
            float f4 = dimensionPixelSize5;
            qMUIRoundButtonDrawable.setCornerRadii(new float[]{f, f, f2, f2, f3, f3, f4, f4});
        } else {
            qMUIRoundButtonDrawable.setCornerRadius(dimensionPixelSize2);
            if (dimensionPixelSize2 <= 0) {
                z = z2;
            }
        }
        qMUIRoundButtonDrawable.setIsRadiusAdjustBounds(z);
        return qMUIRoundButtonDrawable;
    }
}
