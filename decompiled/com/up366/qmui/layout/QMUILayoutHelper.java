package com.up366.qmui.layout;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUILayoutHelper implements com.up366.qmui.layout.IQMUILayout {
    public static final int RADIUS_OF_HALF_VIEW_HEIGHT = -1;
    public static final int RADIUS_OF_HALF_VIEW_WIDTH = -2;
    private int mBorderColor;
    private android.graphics.RectF mBorderRect;
    private int mBorderWidth;
    private int mBottomDividerAlpha;
    private int mBottomDividerColor;
    private int mBottomDividerHeight;
    private int mBottomDividerInsetLeft;
    private int mBottomDividerInsetRight;
    private android.graphics.Paint mClipPaint;
    private android.content.Context mContext;
    private android.graphics.Paint mDividerPaint;
    private int mHeightLimit;
    private int mHeightMini;
    private int mHideRadiusSide;
    private boolean mIsOutlineExcludePadding;
    private boolean mIsShowBorderOnlyBeforeL;
    private int mLeftDividerAlpha;
    private int mLeftDividerColor;
    private int mLeftDividerInsetBottom;
    private int mLeftDividerInsetTop;
    private int mLeftDividerWidth;
    private android.graphics.PorterDuffXfermode mMode;
    private int mOuterNormalColor;
    private int mOutlineInsetBottom;
    private int mOutlineInsetLeft;
    private int mOutlineInsetRight;
    private int mOutlineInsetTop;
    private java.lang.ref.WeakReference<android.view.View> mOwner;
    private android.graphics.Path mPath;
    private int mRadius;
    private float[] mRadiusArray;
    private int mRightDividerAlpha;
    private int mRightDividerColor;
    private int mRightDividerInsetBottom;
    private int mRightDividerInsetTop;
    private int mRightDividerWidth;
    private float mShadowAlpha;
    private int mShadowColor;
    private int mShadowElevation;
    private boolean mShouldUseRadiusArray;
    private int mTopDividerAlpha;
    private int mTopDividerColor;
    private int mTopDividerHeight;
    private int mTopDividerInsetLeft;
    private int mTopDividerInsetRight;
    private int mWidthLimit;
    private int mWidthMini;

    public static boolean useFeature() {
        return true;
    }

    public QMUILayoutHelper(android.content.Context context, android.util.AttributeSet attributeSet, int i, android.view.View view) {
        this(context, attributeSet, i, 0, view);
    }

    public QMUILayoutHelper(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2, android.view.View view) {
        boolean z;
        int dimensionPixelSize;
        int attrDimen = 0;
        this.mWidthLimit = 0;
        this.mHeightLimit = 0;
        this.mWidthMini = 0;
        this.mHeightMini = 0;
        this.mTopDividerHeight = 0;
        this.mTopDividerInsetLeft = 0;
        this.mTopDividerInsetRight = 0;
        this.mTopDividerAlpha = 255;
        this.mBottomDividerHeight = 0;
        this.mBottomDividerInsetLeft = 0;
        this.mBottomDividerInsetRight = 0;
        this.mBottomDividerAlpha = 255;
        this.mLeftDividerWidth = 0;
        this.mLeftDividerInsetTop = 0;
        this.mLeftDividerInsetBottom = 0;
        this.mLeftDividerAlpha = 255;
        this.mRightDividerWidth = 0;
        this.mRightDividerInsetTop = 0;
        this.mRightDividerInsetBottom = 0;
        this.mRightDividerAlpha = 255;
        this.mHideRadiusSide = 0;
        this.mBorderColor = 0;
        this.mBorderWidth = 1;
        this.mOuterNormalColor = 0;
        this.mIsOutlineExcludePadding = false;
        this.mPath = new android.graphics.Path();
        this.mIsShowBorderOnlyBeforeL = true;
        this.mShadowElevation = 0;
        this.mShadowColor = com.up366.qmui.widget.QMUIProgressBar.DEFAULT_TEXT_COLOR;
        this.mOutlineInsetLeft = 0;
        this.mOutlineInsetRight = 0;
        this.mOutlineInsetTop = 0;
        this.mOutlineInsetBottom = 0;
        this.mContext = context;
        this.mOwner = new java.lang.ref.WeakReference<>(view);
        int color = androidx.core.content.ContextCompat.getColor(context, com.qmuiteam.qmui.R.color.qmui_config_color_separator);
        this.mTopDividerColor = color;
        this.mBottomDividerColor = color;
        this.mMode = new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT);
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mClipPaint = paint;
        paint.setAntiAlias(true);
        this.mShadowAlpha = com.up366.qmui.util.QMUIResHelper.getAttrFloatValue(context, com.qmuiteam.qmui.R.attr.qmui_general_shadow_alpha);
        this.mBorderRect = new android.graphics.RectF();
        if (attributeSet == null && i == 0 && i2 == 0) {
            z = false;
            dimensionPixelSize = 0;
        } else {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUILayout, i, i2);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            int dimensionPixelSize2 = 0;
            z = false;
            dimensionPixelSize = 0;
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_android_maxWidth) {
                    this.mWidthLimit = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mWidthLimit);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_android_maxHeight) {
                    this.mHeightLimit = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mHeightLimit);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_android_minWidth) {
                    this.mWidthMini = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mWidthMini);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_android_minHeight) {
                    this.mHeightMini = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mHeightMini);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_topDividerColor) {
                    this.mTopDividerColor = typedArrayObtainStyledAttributes.getColor(index, this.mTopDividerColor);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_topDividerHeight) {
                    this.mTopDividerHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mTopDividerHeight);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_topDividerInsetLeft) {
                    this.mTopDividerInsetLeft = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mTopDividerInsetLeft);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_topDividerInsetRight) {
                    this.mTopDividerInsetRight = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mTopDividerInsetRight);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_bottomDividerColor) {
                    this.mBottomDividerColor = typedArrayObtainStyledAttributes.getColor(index, this.mBottomDividerColor);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_bottomDividerHeight) {
                    this.mBottomDividerHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mBottomDividerHeight);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_bottomDividerInsetLeft) {
                    this.mBottomDividerInsetLeft = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mBottomDividerInsetLeft);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_bottomDividerInsetRight) {
                    this.mBottomDividerInsetRight = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mBottomDividerInsetRight);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_leftDividerColor) {
                    this.mLeftDividerColor = typedArrayObtainStyledAttributes.getColor(index, this.mLeftDividerColor);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_leftDividerWidth) {
                    this.mLeftDividerWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mLeftDividerWidth);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_leftDividerInsetTop) {
                    this.mLeftDividerInsetTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mLeftDividerInsetTop);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_leftDividerInsetBottom) {
                    this.mLeftDividerInsetBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mLeftDividerInsetBottom);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_rightDividerColor) {
                    this.mRightDividerColor = typedArrayObtainStyledAttributes.getColor(index, this.mRightDividerColor);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_rightDividerWidth) {
                    this.mRightDividerWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mRightDividerWidth);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_rightDividerInsetTop) {
                    this.mRightDividerInsetTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mRightDividerInsetTop);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_rightDividerInsetBottom) {
                    this.mRightDividerInsetBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mRightDividerInsetBottom);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_borderColor) {
                    this.mBorderColor = typedArrayObtainStyledAttributes.getColor(index, this.mBorderColor);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_borderWidth) {
                    this.mBorderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mBorderWidth);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_radius) {
                    dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_outerNormalColor) {
                    this.mOuterNormalColor = typedArrayObtainStyledAttributes.getColor(index, this.mOuterNormalColor);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_hideRadiusSide) {
                    this.mHideRadiusSide = typedArrayObtainStyledAttributes.getInt(index, this.mHideRadiusSide);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_showBorderOnlyBeforeL) {
                    this.mIsShowBorderOnlyBeforeL = typedArrayObtainStyledAttributes.getBoolean(index, this.mIsShowBorderOnlyBeforeL);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_shadowElevation) {
                    dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize2);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_shadowAlpha) {
                    this.mShadowAlpha = typedArrayObtainStyledAttributes.getFloat(index, this.mShadowAlpha);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_useThemeGeneralShadowElevation) {
                    z = typedArrayObtainStyledAttributes.getBoolean(index, false);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_outlineInsetLeft) {
                    this.mOutlineInsetLeft = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_outlineInsetRight) {
                    this.mOutlineInsetRight = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_outlineInsetTop) {
                    this.mOutlineInsetTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_outlineInsetBottom) {
                    this.mOutlineInsetBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUILayout_qmui_outlineExcludePadding) {
                    this.mIsOutlineExcludePadding = typedArrayObtainStyledAttributes.getBoolean(index, false);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            attrDimen = dimensionPixelSize2;
        }
        if (attrDimen == 0 && z) {
            attrDimen = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_general_shadow_elevation);
        }
        setRadiusAndShadow(dimensionPixelSize, this.mHideRadiusSide, attrDimen, this.mShadowAlpha);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setUseThemeGeneralShadowElevation() {
        int attrDimen = com.up366.qmui.util.QMUIResHelper.getAttrDimen(this.mContext, com.qmuiteam.qmui.R.attr.qmui_general_shadow_elevation);
        this.mShadowElevation = attrDimen;
        setRadiusAndShadow(this.mRadius, this.mHideRadiusSide, attrDimen, this.mShadowAlpha);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setOutlineExcludePadding(boolean z) {
        android.view.View view;
        if (!useFeature() || (view = this.mOwner.get()) == null) {
            return;
        }
        this.mIsOutlineExcludePadding = z;
        view.invalidateOutline();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public boolean setWidthLimit(int i) {
        if (this.mWidthLimit == i) {
            return false;
        }
        this.mWidthLimit = i;
        return true;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public boolean setHeightLimit(int i) {
        if (this.mHeightLimit == i) {
            return false;
        }
        this.mHeightLimit = i;
        return true;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void updateLeftSeparatorColor(int i) {
        if (this.mLeftDividerColor != i) {
            this.mLeftDividerColor = i;
            invalidate();
        }
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void updateBottomSeparatorColor(int i) {
        if (this.mBottomDividerColor != i) {
            this.mBottomDividerColor = i;
            invalidate();
        }
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void updateTopSeparatorColor(int i) {
        if (this.mTopDividerColor != i) {
            this.mTopDividerColor = i;
            invalidate();
        }
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void updateRightSeparatorColor(int i) {
        if (this.mRightDividerColor != i) {
            this.mRightDividerColor = i;
            invalidate();
        }
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public int getShadowElevation() {
        return this.mShadowElevation;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public float getShadowAlpha() {
        return this.mShadowAlpha;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public int getShadowColor() {
        return this.mShadowColor;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setOutlineInset(int i, int i2, int i3, int i4) {
        android.view.View view;
        if (!useFeature() || (view = this.mOwner.get()) == null) {
            return;
        }
        this.mOutlineInsetLeft = i;
        this.mOutlineInsetRight = i3;
        this.mOutlineInsetTop = i2;
        this.mOutlineInsetBottom = i4;
        view.invalidateOutline();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setShowBorderOnlyBeforeL(boolean z) {
        this.mIsShowBorderOnlyBeforeL = z;
        invalidate();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setShadowElevation(int i) {
        if (this.mShadowElevation == i) {
            return;
        }
        this.mShadowElevation = i;
        invalidateOutline();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setShadowAlpha(float f) {
        if (this.mShadowAlpha == f) {
            return;
        }
        this.mShadowAlpha = f;
        invalidateOutline();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setShadowColor(int i) {
        if (this.mShadowColor == i) {
            return;
        }
        this.mShadowColor = i;
        setShadowColorInner(i);
    }

    private void setShadowColorInner(int i) {
        android.view.View view;
        if (android.os.Build.VERSION.SDK_INT < 28 || (view = this.mOwner.get()) == null) {
            return;
        }
        view.setOutlineAmbientShadowColor(i);
        view.setOutlineSpotShadowColor(i);
    }

    private void invalidateOutline() {
        android.view.View view;
        if (!useFeature() || (view = this.mOwner.get()) == null) {
            return;
        }
        int i = this.mShadowElevation;
        if (i == 0) {
            view.setElevation(0.0f);
        } else {
            view.setElevation(i);
        }
        view.invalidateOutline();
    }

    private void invalidate() {
        android.view.View view = this.mOwner.get();
        if (view == null) {
            return;
        }
        view.invalidate();
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setHideRadiusSide(int i) {
        if (this.mHideRadiusSide == i) {
            return;
        }
        setRadiusAndShadow(this.mRadius, i, this.mShadowElevation, this.mShadowAlpha);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public int getHideRadiusSide() {
        return this.mHideRadiusSide;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setRadius(int i) {
        if (this.mRadius != i) {
            setRadiusAndShadow(i, this.mShadowElevation, this.mShadowAlpha);
        }
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setRadius(int i, int i2) {
        if (this.mRadius == i && i2 == this.mHideRadiusSide) {
            return;
        }
        setRadiusAndShadow(i, i2, this.mShadowElevation, this.mShadowAlpha);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public int getRadius() {
        return this.mRadius;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setRadiusAndShadow(int i, int i2, float f) {
        setRadiusAndShadow(i, this.mHideRadiusSide, i2, f);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setRadiusAndShadow(int i, int i2, int i3, float f) {
        setRadiusAndShadow(i, i2, i3, this.mShadowColor, f);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setRadiusAndShadow(int i, int i2, int i3, int i4, float f) {
        android.view.View view = this.mOwner.get();
        if (view == null) {
            return;
        }
        this.mRadius = i;
        this.mHideRadiusSide = i2;
        this.mShouldUseRadiusArray = isRadiusWithSideHidden();
        this.mShadowElevation = i3;
        this.mShadowAlpha = f;
        this.mShadowColor = i4;
        if (useFeature()) {
            int i5 = this.mShadowElevation;
            if (i5 == 0 || this.mShouldUseRadiusArray) {
                view.setElevation(0.0f);
            } else {
                view.setElevation(i5);
            }
            setShadowColorInner(this.mShadowColor);
            view.setOutlineProvider(new android.view.ViewOutlineProvider() { // from class: com.up366.qmui.layout.QMUILayoutHelper.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(android.view.View view2, android.graphics.Outline outline) {
                    int i6;
                    int i7;
                    int i8;
                    int i9;
                    int width = view2.getWidth();
                    int height = view2.getHeight();
                    if (width == 0 || height == 0) {
                        return;
                    }
                    int realRadius = com.up366.qmui.layout.QMUILayoutHelper.this.getRealRadius();
                    if (com.up366.qmui.layout.QMUILayoutHelper.this.mShouldUseRadiusArray) {
                        if (com.up366.qmui.layout.QMUILayoutHelper.this.mHideRadiusSide == 4) {
                            i8 = 0 - realRadius;
                            i6 = width;
                            i7 = height;
                            i9 = 0;
                        } else if (com.up366.qmui.layout.QMUILayoutHelper.this.mHideRadiusSide == 1) {
                            i9 = 0 - realRadius;
                            i6 = width;
                            i7 = height;
                            i8 = 0;
                        } else {
                            if (com.up366.qmui.layout.QMUILayoutHelper.this.mHideRadiusSide == 2) {
                                width += realRadius;
                            } else if (com.up366.qmui.layout.QMUILayoutHelper.this.mHideRadiusSide == 3) {
                                height += realRadius;
                            }
                            i6 = width;
                            i7 = height;
                            i8 = 0;
                            i9 = 0;
                        }
                        outline.setRoundRect(i8, i9, i6, i7, realRadius);
                        return;
                    }
                    int paddingTop = com.up366.qmui.layout.QMUILayoutHelper.this.mOutlineInsetTop;
                    int iMax = java.lang.Math.max(paddingTop + 1, height - com.up366.qmui.layout.QMUILayoutHelper.this.mOutlineInsetBottom);
                    int paddingLeft = com.up366.qmui.layout.QMUILayoutHelper.this.mOutlineInsetLeft;
                    int iMax2 = width - com.up366.qmui.layout.QMUILayoutHelper.this.mOutlineInsetRight;
                    if (com.up366.qmui.layout.QMUILayoutHelper.this.mIsOutlineExcludePadding) {
                        paddingLeft += view2.getPaddingLeft();
                        paddingTop += view2.getPaddingTop();
                        iMax2 = java.lang.Math.max(paddingLeft + 1, iMax2 - view2.getPaddingRight());
                        iMax = java.lang.Math.max(paddingTop + 1, iMax - view2.getPaddingBottom());
                    }
                    int i10 = iMax2;
                    int i11 = iMax;
                    int i12 = paddingTop;
                    int i13 = paddingLeft;
                    float f2 = com.up366.qmui.layout.QMUILayoutHelper.this.mShadowAlpha;
                    if (com.up366.qmui.layout.QMUILayoutHelper.this.mShadowElevation == 0) {
                        f2 = 1.0f;
                    }
                    outline.setAlpha(f2);
                    if (realRadius <= 0) {
                        outline.setRect(i13, i12, i10, i11);
                    } else {
                        outline.setRoundRect(i13, i12, i10, i11, realRadius);
                    }
                }
            });
            int i6 = this.mRadius;
            view.setClipToOutline(i6 == -2 || i6 == -1 || i6 > 0);
        }
        view.invalidate();
    }

    public boolean isRadiusWithSideHidden() {
        int i = this.mRadius;
        return (i == -1 || i == -2 || i > 0) && this.mHideRadiusSide != 0;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void updateTopDivider(int i, int i2, int i3, int i4) {
        this.mTopDividerInsetLeft = i;
        this.mTopDividerInsetRight = i2;
        this.mTopDividerHeight = i3;
        this.mTopDividerColor = i4;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void updateBottomDivider(int i, int i2, int i3, int i4) {
        this.mBottomDividerInsetLeft = i;
        this.mBottomDividerInsetRight = i2;
        this.mBottomDividerColor = i4;
        this.mBottomDividerHeight = i3;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void updateLeftDivider(int i, int i2, int i3, int i4) {
        this.mLeftDividerInsetTop = i;
        this.mLeftDividerInsetBottom = i2;
        this.mLeftDividerWidth = i3;
        this.mLeftDividerColor = i4;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void updateRightDivider(int i, int i2, int i3, int i4) {
        this.mRightDividerInsetTop = i;
        this.mRightDividerInsetBottom = i2;
        this.mRightDividerWidth = i3;
        this.mRightDividerColor = i4;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void onlyShowTopDivider(int i, int i2, int i3, int i4) {
        updateTopDivider(i, i2, i3, i4);
        this.mLeftDividerWidth = 0;
        this.mRightDividerWidth = 0;
        this.mBottomDividerHeight = 0;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void onlyShowBottomDivider(int i, int i2, int i3, int i4) {
        updateBottomDivider(i, i2, i3, i4);
        this.mLeftDividerWidth = 0;
        this.mRightDividerWidth = 0;
        this.mTopDividerHeight = 0;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void onlyShowLeftDivider(int i, int i2, int i3, int i4) {
        updateLeftDivider(i, i2, i3, i4);
        this.mRightDividerWidth = 0;
        this.mTopDividerHeight = 0;
        this.mBottomDividerHeight = 0;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void onlyShowRightDivider(int i, int i2, int i3, int i4) {
        updateRightDivider(i, i2, i3, i4);
        this.mLeftDividerWidth = 0;
        this.mTopDividerHeight = 0;
        this.mBottomDividerHeight = 0;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setTopDividerAlpha(int i) {
        this.mTopDividerAlpha = i;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setBottomDividerAlpha(int i) {
        this.mBottomDividerAlpha = i;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setLeftDividerAlpha(int i) {
        this.mLeftDividerAlpha = i;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setRightDividerAlpha(int i) {
        this.mRightDividerAlpha = i;
    }

    public int handleMiniWidth(int i, int i2) {
        int i3;
        return (android.view.View.MeasureSpec.getMode(i) == 1073741824 || i2 >= (i3 = this.mWidthMini)) ? i : android.view.View.MeasureSpec.makeMeasureSpec(i3, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
    }

    public int handleMiniHeight(int i, int i2) {
        int i3;
        return (android.view.View.MeasureSpec.getMode(i) == 1073741824 || i2 >= (i3 = this.mHeightMini)) ? i : android.view.View.MeasureSpec.makeMeasureSpec(i3, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
    }

    public int getMeasuredWidthSpec(int i) {
        if (this.mWidthLimit <= 0 || android.view.View.MeasureSpec.getSize(i) <= this.mWidthLimit) {
            return i;
        }
        if (android.view.View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            return android.view.View.MeasureSpec.makeMeasureSpec(this.mWidthLimit, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
        }
        return android.view.View.MeasureSpec.makeMeasureSpec(this.mWidthLimit, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
    }

    public int getMeasuredHeightSpec(int i) {
        if (this.mHeightLimit <= 0 || android.view.View.MeasureSpec.getSize(i) <= this.mHeightLimit) {
            return i;
        }
        if (android.view.View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            return android.view.View.MeasureSpec.makeMeasureSpec(this.mWidthLimit, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
        }
        return android.view.View.MeasureSpec.makeMeasureSpec(this.mWidthLimit, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setBorderWidth(int i) {
        this.mBorderWidth = i;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public void setOuterNormalColor(int i) {
        this.mOuterNormalColor = i;
        android.view.View view = this.mOwner.get();
        if (view != null) {
            view.invalidate();
        }
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public boolean hasTopSeparator() {
        return this.mTopDividerHeight > 0;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public boolean hasRightSeparator() {
        return this.mRightDividerWidth > 0;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public boolean hasBottomSeparator() {
        return this.mBottomDividerHeight > 0;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public boolean hasLeftSeparator() {
        return this.mLeftDividerWidth > 0;
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public boolean hasBorder() {
        return this.mBorderWidth > 0;
    }

    public void drawDividers(android.graphics.Canvas canvas, int i, int i2) {
        if (this.mOwner.get() == null) {
            return;
        }
        if (this.mDividerPaint == null && (this.mTopDividerHeight > 0 || this.mBottomDividerHeight > 0 || this.mLeftDividerWidth > 0 || this.mRightDividerWidth > 0)) {
            this.mDividerPaint = new android.graphics.Paint();
        }
        canvas.save();
        canvas.translate(r0.getScrollX(), r0.getScrollY());
        int i3 = this.mTopDividerHeight;
        if (i3 > 0) {
            this.mDividerPaint.setStrokeWidth(i3);
            this.mDividerPaint.setColor(this.mTopDividerColor);
            int i4 = this.mTopDividerAlpha;
            if (i4 < 255) {
                this.mDividerPaint.setAlpha(i4);
            }
            float f = this.mTopDividerHeight / 2.0f;
            canvas.drawLine(this.mTopDividerInsetLeft, f, i - this.mTopDividerInsetRight, f, this.mDividerPaint);
        }
        int i5 = this.mBottomDividerHeight;
        if (i5 > 0) {
            this.mDividerPaint.setStrokeWidth(i5);
            this.mDividerPaint.setColor(this.mBottomDividerColor);
            int i6 = this.mBottomDividerAlpha;
            if (i6 < 255) {
                this.mDividerPaint.setAlpha(i6);
            }
            float fFloor = (float) java.lang.Math.floor(i2 - (this.mBottomDividerHeight / 2.0f));
            canvas.drawLine(this.mBottomDividerInsetLeft, fFloor, i - this.mBottomDividerInsetRight, fFloor, this.mDividerPaint);
        }
        int i7 = this.mLeftDividerWidth;
        if (i7 > 0) {
            this.mDividerPaint.setStrokeWidth(i7);
            this.mDividerPaint.setColor(this.mLeftDividerColor);
            int i8 = this.mLeftDividerAlpha;
            if (i8 < 255) {
                this.mDividerPaint.setAlpha(i8);
            }
            float f2 = this.mLeftDividerWidth / 2.0f;
            canvas.drawLine(f2, this.mLeftDividerInsetTop, f2, i2 - this.mLeftDividerInsetBottom, this.mDividerPaint);
        }
        int i9 = this.mRightDividerWidth;
        if (i9 > 0) {
            this.mDividerPaint.setStrokeWidth(i9);
            this.mDividerPaint.setColor(this.mRightDividerColor);
            int i10 = this.mRightDividerAlpha;
            if (i10 < 255) {
                this.mDividerPaint.setAlpha(i10);
            }
            float fFloor2 = (float) java.lang.Math.floor(i - (this.mRightDividerWidth / 2.0f));
            canvas.drawLine(fFloor2, this.mRightDividerInsetTop, fFloor2, i2 - this.mRightDividerInsetBottom, this.mDividerPaint);
        }
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealRadius() {
        android.view.View view = this.mOwner.get();
        if (view == null) {
            return this.mRadius;
        }
        int i = this.mRadius;
        if (i == -1) {
            return view.getHeight() / 2;
        }
        return i == -2 ? view.getWidth() / 2 : i;
    }

    public void dispatchRoundBorderDraw(android.graphics.Canvas canvas) {
        if (this.mOwner.get() == null) {
            return;
        }
        int realRadius = getRealRadius();
        boolean z = (realRadius <= 0 || useFeature() || this.mOuterNormalColor == 0) ? false : true;
        boolean z2 = this.mBorderWidth > 0 && this.mBorderColor != 0;
        if (z || z2) {
            if (this.mIsShowBorderOnlyBeforeL && useFeature() && this.mShadowElevation != 0) {
                return;
            }
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            canvas.save();
            canvas.translate(r1.getScrollX(), r1.getScrollY());
            float f = this.mBorderWidth / 2.0f;
            if (this.mIsOutlineExcludePadding) {
                this.mBorderRect.set(r1.getPaddingLeft() + f, r1.getPaddingTop() + f, (width - r1.getPaddingRight()) - f, (height - r1.getPaddingBottom()) - f);
            } else {
                this.mBorderRect.set(f, f, width - f, height - f);
            }
            if (this.mShouldUseRadiusArray) {
                if (this.mRadiusArray == null) {
                    this.mRadiusArray = new float[8];
                }
                int i = this.mHideRadiusSide;
                if (i == 1) {
                    float[] fArr = this.mRadiusArray;
                    float f2 = realRadius;
                    fArr[4] = f2;
                    fArr[5] = f2;
                    fArr[6] = f2;
                    fArr[7] = f2;
                } else if (i == 2) {
                    float[] fArr2 = this.mRadiusArray;
                    float f3 = realRadius;
                    fArr2[0] = f3;
                    fArr2[1] = f3;
                    fArr2[6] = f3;
                    fArr2[7] = f3;
                } else if (i == 3) {
                    float[] fArr3 = this.mRadiusArray;
                    float f4 = realRadius;
                    fArr3[0] = f4;
                    fArr3[1] = f4;
                    fArr3[2] = f4;
                    fArr3[3] = f4;
                } else if (i == 4) {
                    float[] fArr4 = this.mRadiusArray;
                    float f5 = realRadius;
                    fArr4[2] = f5;
                    fArr4[3] = f5;
                    fArr4[4] = f5;
                    fArr4[5] = f5;
                }
            }
            if (z) {
                int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, width, height, null, 31);
                canvas.drawColor(this.mOuterNormalColor);
                this.mClipPaint.setColor(this.mOuterNormalColor);
                this.mClipPaint.setStyle(android.graphics.Paint.Style.FILL);
                this.mClipPaint.setXfermode(this.mMode);
                if (!this.mShouldUseRadiusArray) {
                    float f6 = realRadius;
                    canvas.drawRoundRect(this.mBorderRect, f6, f6, this.mClipPaint);
                } else {
                    drawRoundRect(canvas, this.mBorderRect, this.mRadiusArray, this.mClipPaint);
                }
                this.mClipPaint.setXfermode(null);
                canvas.restoreToCount(iSaveLayer);
            }
            if (z2) {
                this.mClipPaint.setColor(this.mBorderColor);
                this.mClipPaint.setStrokeWidth(this.mBorderWidth);
                this.mClipPaint.setStyle(android.graphics.Paint.Style.STROKE);
                if (this.mShouldUseRadiusArray) {
                    drawRoundRect(canvas, this.mBorderRect, this.mRadiusArray, this.mClipPaint);
                } else if (realRadius <= 0) {
                    canvas.drawRect(this.mBorderRect, this.mClipPaint);
                } else {
                    float f7 = realRadius;
                    canvas.drawRoundRect(this.mBorderRect, f7, f7, this.mClipPaint);
                }
            }
            canvas.restore();
        }
    }

    private void drawRoundRect(android.graphics.Canvas canvas, android.graphics.RectF rectF, float[] fArr, android.graphics.Paint paint) {
        this.mPath.reset();
        this.mPath.addRoundRect(rectF, fArr, android.graphics.Path.Direction.CW);
        canvas.drawPath(this.mPath, paint);
    }
}
