package com.up366.qmui.widget.tab;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUITabView extends android.widget.FrameLayout implements com.up366.qmui.skin.IQMUISkinHandlerView {
    private static final java.lang.String TAG = "QMUITabView";
    private com.up366.qmui.widget.tab.QMUITabView.Callback mCallback;
    private com.up366.qmui.util.QMUICollapsingTextHelper mCollapsingTextHelper;
    private float mCurrentIconHeight;
    private float mCurrentIconLeft;
    private float mCurrentIconTop;
    private float mCurrentIconWidth;
    private float mCurrentTextHeight;
    private float mCurrentTextLeft;
    private float mCurrentTextTop;
    private float mCurrentTextWidth;
    private android.view.GestureDetector mGestureDetector;
    private float mNormalIconLeft;
    private float mNormalIconTop;
    private float mNormalTextLeft;
    private float mNormalTextTop;
    private android.view.animation.Interpolator mPositionInterpolator;
    private float mSelectedIconLeft;
    private float mSelectedIconTop;
    private float mSelectedTextLeft;
    private float mSelectedTextTop;
    private com.up366.qmui.widget.roundwidget.QMUIRoundButton mSignCountView;
    private com.up366.qmui.widget.tab.QMUITab mTab;

    public interface Callback {
        void onClick(com.up366.qmui.widget.tab.QMUITabView qMUITabView);

        void onDoubleClick(com.up366.qmui.widget.tab.QMUITabView qMUITabView);

        void onLongClick(com.up366.qmui.widget.tab.QMUITabView qMUITabView);
    }

    public QMUITabView(android.content.Context context) {
        super(context);
        this.mCurrentIconLeft = 0.0f;
        this.mCurrentIconTop = 0.0f;
        this.mCurrentTextLeft = 0.0f;
        this.mCurrentTextTop = 0.0f;
        this.mCurrentIconWidth = 0.0f;
        this.mCurrentIconHeight = 0.0f;
        this.mCurrentTextWidth = 0.0f;
        this.mCurrentTextHeight = 0.0f;
        this.mNormalIconLeft = 0.0f;
        this.mNormalIconTop = 0.0f;
        this.mNormalTextLeft = 0.0f;
        this.mNormalTextTop = 0.0f;
        this.mSelectedIconLeft = 0.0f;
        this.mSelectedIconTop = 0.0f;
        this.mSelectedTextLeft = 0.0f;
        this.mSelectedTextTop = 0.0f;
        setWillNotDraw(false);
        this.mCollapsingTextHelper = new com.up366.qmui.util.QMUICollapsingTextHelper(this, 1.0f);
        this.mGestureDetector = new android.view.GestureDetector(getContext(), new android.view.GestureDetector.SimpleOnGestureListener() { // from class: com.up366.qmui.widget.tab.QMUITabView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(android.view.MotionEvent motionEvent) {
                if (com.up366.qmui.widget.tab.QMUITabView.this.mCallback == null) {
                    return false;
                }
                com.up366.qmui.widget.tab.QMUITabView.this.mCallback.onDoubleClick(com.up366.qmui.widget.tab.QMUITabView.this);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
                if (com.up366.qmui.widget.tab.QMUITabView.this.mCallback != null) {
                    com.up366.qmui.widget.tab.QMUITabView.this.mCallback.onClick(com.up366.qmui.widget.tab.QMUITabView.this);
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(android.view.MotionEvent motionEvent) {
                return com.up366.qmui.widget.tab.QMUITabView.this.mCallback != null;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(android.view.MotionEvent motionEvent) {
                if (com.up366.qmui.widget.tab.QMUITabView.this.mCallback != null) {
                    com.up366.qmui.widget.tab.QMUITabView.this.mCallback.onLongClick(com.up366.qmui.widget.tab.QMUITabView.this);
                }
            }
        });
    }

    public void setCallback(com.up366.qmui.widget.tab.QMUITabView.Callback callback) {
        this.mCallback = callback;
    }

    public void setPositionInterpolator(android.view.animation.Interpolator interpolator) {
        this.mPositionInterpolator = interpolator;
        this.mCollapsingTextHelper.setPositionInterpolator(interpolator);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return this.mGestureDetector.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
    }

    public void bind(com.up366.qmui.widget.tab.QMUITab qMUITab) {
        this.mCollapsingTextHelper.setTextSize(qMUITab.normalTextSize, qMUITab.selectedTextSize, false);
        this.mCollapsingTextHelper.setTypeface(qMUITab.normalTypeface, qMUITab.selectedTypeface, false);
        this.mCollapsingTextHelper.setGravity(51, 51, false);
        this.mCollapsingTextHelper.setText(qMUITab.getText());
        this.mTab = qMUITab;
        if (qMUITab.tabIcon != null) {
            qMUITab.tabIcon.setCallback(this);
        }
        boolean z = this.mTab.signCount == -1;
        boolean z2 = this.mTab.signCount > 0;
        if (z || z2) {
            ensureSignCountView(getContext());
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.mSignCountView.getLayoutParams();
            if (z2) {
                this.mSignCountView.setText(com.up366.qmui.util.QMUILangHelper.formatNumberToLimitedDigits(this.mTab.signCount, this.mTab.signCountDigits));
                this.mSignCountView.setMinWidth(com.up366.qmui.util.QMUIResHelper.getAttrDimen(getContext(), com.qmuiteam.qmui.R.attr.qmui_tab_sign_count_view_min_size_with_text));
                layoutParams.height = com.up366.qmui.util.QMUIResHelper.getAttrDimen(getContext(), com.qmuiteam.qmui.R.attr.qmui_tab_sign_count_view_min_size_with_text);
            } else {
                this.mSignCountView.setText(null);
                int attrDimen = com.up366.qmui.util.QMUIResHelper.getAttrDimen(getContext(), com.qmuiteam.qmui.R.attr.qmui_tab_sign_count_view_min_size);
                layoutParams.width = attrDimen;
                layoutParams.height = attrDimen;
            }
            this.mSignCountView.setLayoutParams(layoutParams);
            this.mSignCountView.setVisibility(0);
        } else {
            com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton = this.mSignCountView;
            if (qMUIRoundButton != null) {
                qMUIRoundButton.setVisibility(8);
            }
        }
        updateSkinInfo(qMUITab);
        requestLayout();
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [android.view.View, com.up366.qmui.widget.roundwidget.QMUIRoundButton] */
    /* JADX WARN: Type inference failed for: r5v7, types: [android.view.View, com.up366.qmui.widget.roundwidget.QMUIRoundButton] */
    public void setSelectFraction(float f) {
        float fConstrain = com.up366.qmui.util.QMUILangHelper.constrain(f, 0.0f, 1.0f);
        com.up366.qmui.widget.tab.QMUITabIcon tabIcon = this.mTab.getTabIcon();
        if (tabIcon != null) {
            tabIcon.setSelectFraction(fConstrain, com.up366.qmui.util.QMUIColorHelper.computeColor(this.mTab.getNormalColor(this), this.mTab.getSelectColor(this), fConstrain));
        }
        updateCurrentInfo(fConstrain);
        this.mCollapsingTextHelper.setExpansionFraction(1.0f - fConstrain);
        if (this.mSignCountView != null) {
            android.graphics.Point pointCalculateSignCountLayoutPosition = calculateSignCountLayoutPosition();
            int measuredWidth = pointCalculateSignCountLayoutPosition.x;
            int measuredHeight = pointCalculateSignCountLayoutPosition.y;
            if (pointCalculateSignCountLayoutPosition.x + this.mSignCountView.getMeasuredWidth() > getMeasuredWidth()) {
                measuredWidth = getMeasuredWidth() - this.mSignCountView.getMeasuredWidth();
            }
            if (pointCalculateSignCountLayoutPosition.y - this.mSignCountView.getMeasuredHeight() < 0) {
                measuredHeight = this.mSignCountView.getMeasuredHeight();
            }
            ?? r5 = this.mSignCountView;
            androidx.core.view.ViewCompat.offsetLeftAndRight((android.view.View) r5, measuredWidth - r5.getLeft());
            ?? r52 = this.mSignCountView;
            androidx.core.view.ViewCompat.offsetTopAndBottom((android.view.View) r52, measuredHeight - r52.getBottom());
        }
    }

    private void updateCurrentInfo(float f) {
        this.mCurrentIconLeft = com.up366.qmui.util.QMUICollapsingTextHelper.lerp(this.mNormalIconLeft, this.mSelectedIconLeft, f, this.mPositionInterpolator);
        this.mCurrentIconTop = com.up366.qmui.util.QMUICollapsingTextHelper.lerp(this.mNormalIconTop, this.mSelectedIconTop, f, this.mPositionInterpolator);
        int normalTabIconWidth = this.mTab.getNormalTabIconWidth();
        int normalTabIconHeight = this.mTab.getNormalTabIconHeight();
        float selectedTabIconScale = this.mTab.getSelectedTabIconScale();
        float f2 = normalTabIconWidth;
        this.mCurrentIconWidth = com.up366.qmui.util.QMUICollapsingTextHelper.lerp(f2, f2 * selectedTabIconScale, f, this.mPositionInterpolator);
        float f3 = normalTabIconHeight;
        this.mCurrentIconHeight = com.up366.qmui.util.QMUICollapsingTextHelper.lerp(f3, selectedTabIconScale * f3, f, this.mPositionInterpolator);
        this.mCurrentTextLeft = com.up366.qmui.util.QMUICollapsingTextHelper.lerp(this.mNormalTextLeft, this.mSelectedTextLeft, f, this.mPositionInterpolator);
        this.mCurrentTextTop = com.up366.qmui.util.QMUICollapsingTextHelper.lerp(this.mNormalTextTop, this.mSelectedTextTop, f, this.mPositionInterpolator);
        float collapsedTextWidth = this.mCollapsingTextHelper.getCollapsedTextWidth();
        float collapsedTextHeight = this.mCollapsingTextHelper.getCollapsedTextHeight();
        float expandedTextWidth = this.mCollapsingTextHelper.getExpandedTextWidth();
        float expandedTextHeight = this.mCollapsingTextHelper.getExpandedTextHeight();
        this.mCurrentTextWidth = com.up366.qmui.util.QMUICollapsingTextHelper.lerp(collapsedTextWidth, expandedTextWidth, f, this.mPositionInterpolator);
        this.mCurrentTextHeight = com.up366.qmui.util.QMUICollapsingTextHelper.lerp(collapsedTextHeight, expandedTextHeight, f, this.mPositionInterpolator);
    }

    public int getContentViewWidth() {
        double iconTextGap;
        if (this.mTab == null) {
            return 0;
        }
        float expandedTextWidth = this.mCollapsingTextHelper.getExpandedTextWidth();
        if (this.mTab.getTabIcon() == null) {
            iconTextGap = expandedTextWidth;
        } else {
            int iconPosition = this.mTab.getIconPosition();
            float normalTabIconWidth = this.mTab.getNormalTabIconWidth() * this.mTab.getSelectedTabIconScale();
            if (iconPosition == 3 || iconPosition == 1) {
                expandedTextWidth = java.lang.Math.max(normalTabIconWidth, expandedTextWidth);
                iconTextGap = expandedTextWidth;
            } else {
                iconTextGap = normalTabIconWidth + expandedTextWidth + this.mTab.getIconTextGap();
            }
        }
        return (int) (iconTextGap + 0.5d);
    }

    public int getContentViewLeft() {
        com.up366.qmui.widget.tab.QMUITab qMUITab = this.mTab;
        if (qMUITab == null) {
            return 0;
        }
        if (qMUITab.getTabIcon() == null) {
            return (int) (((double) this.mSelectedTextLeft) + 0.5d);
        }
        int iconPosition = this.mTab.getIconPosition();
        if (iconPosition == 3 || iconPosition == 1) {
            return (int) java.lang.Math.min(this.mSelectedTextLeft, ((double) this.mSelectedIconLeft) + 0.5d);
        }
        if (iconPosition == 0) {
            return (int) (((double) this.mSelectedIconLeft) + 0.5d);
        }
        return (int) (((double) this.mSelectedTextLeft) + 0.5d);
    }

    private com.up366.qmui.widget.roundwidget.QMUIRoundButton ensureSignCountView(android.content.Context context) {
        android.view.ViewGroup.LayoutParams layoutParams;
        if (this.mSignCountView == null) {
            com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButtonCreateSignCountView = createSignCountView(context);
            this.mSignCountView = qMUIRoundButtonCreateSignCountView;
            if (qMUIRoundButtonCreateSignCountView.getLayoutParams() != null) {
                layoutParams = new android.widget.FrameLayout.LayoutParams(this.mSignCountView.getLayoutParams());
            } else {
                layoutParams = new android.widget.FrameLayout.LayoutParams(-2, -2);
            }
            addView((android.view.View) this.mSignCountView, layoutParams);
        }
        return this.mSignCountView;
    }

    protected com.up366.qmui.widget.roundwidget.QMUIRoundButton createSignCountView(android.content.Context context) {
        com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton = new com.up366.qmui.widget.roundwidget.QMUIRoundButton(context, null, com.qmuiteam.qmui.R.attr.qmui_tab_sign_count_view);
        com.up366.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider qMUISkinSimpleDefaultAttrProvider = new com.up366.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider();
        qMUISkinSimpleDefaultAttrProvider.setDefaultSkinAttr("background", com.qmuiteam.qmui.R.attr.qmui_skin_support_tab_sign_count_view_bg_color);
        qMUISkinSimpleDefaultAttrProvider.setDefaultSkinAttr(com.up366.qmui.skin.QMUISkinValueBuilder.TEXT_COLOR, com.qmuiteam.qmui.R.attr.qmui_skin_support_tab_sign_count_view_text_color);
        qMUIRoundButton.setTag(com.qmuiteam.qmui.R.id.qmui_skin_default_attr_provider, qMUISkinSimpleDefaultAttrProvider);
        return qMUIRoundButton;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        float fMax;
        float fMax2;
        if (this.mTab == null) {
            super.onMeasure(i, i2);
            return;
        }
        int size = android.view.View.MeasureSpec.getSize(i);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        int mode = android.view.View.MeasureSpec.getMode(i);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        onMeasureTab(size, size2);
        com.up366.qmui.widget.tab.QMUITabIcon tabIcon = this.mTab.getTabIcon();
        int iconPosition = this.mTab.getIconPosition();
        if (mode == Integer.MIN_VALUE) {
            if (tabIcon == null) {
                fMax2 = this.mCollapsingTextHelper.getExpandedTextWidth();
            } else if (iconPosition == 3 || iconPosition == 1) {
                fMax2 = java.lang.Math.max(this.mTab.getNormalTabIconWidth() * this.mTab.getSelectedTabIconScale(), this.mCollapsingTextHelper.getExpandedTextWidth());
            } else {
                fMax2 = this.mCollapsingTextHelper.getExpandedTextWidth() + this.mTab.getIconTextGap() + (this.mTab.getNormalTabIconWidth() * this.mTab.getSelectedTabIconScale());
            }
            int iMax = (int) fMax2;
            com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton = this.mSignCountView;
            if (qMUIRoundButton != null && qMUIRoundButton.getVisibility() != 8) {
                this.mSignCountView.measure(0, 0);
                iMax = java.lang.Math.max(iMax, this.mSignCountView.getMeasuredWidth() + iMax + this.mTab.signCountLeftMarginWithIconOrText);
            }
            i = android.view.View.MeasureSpec.makeMeasureSpec(iMax, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (tabIcon == null) {
                fMax = this.mCollapsingTextHelper.getExpandedTextHeight();
            } else if (iconPosition == 0 || iconPosition == 2) {
                fMax = java.lang.Math.max(this.mTab.getNormalTabIconHeight() * this.mTab.getSelectedTabIconScale(), this.mCollapsingTextHelper.getExpandedTextWidth());
            } else {
                fMax = this.mCollapsingTextHelper.getExpandedTextHeight() + this.mTab.getIconTextGap() + (this.mTab.getNormalTabIconHeight() * this.mTab.getSelectedTabIconScale());
            }
            i2 = android.view.View.MeasureSpec.makeMeasureSpec((int) fMax, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
        }
        super.onMeasure(i, i2);
    }

    protected void onMeasureTab(int i, int i2) {
        if (this.mTab.getTabIcon() != null && !this.mTab.isAllowIconDrawOutside()) {
            float normalTabIconWidth = this.mTab.getNormalTabIconWidth() * this.mTab.selectedTabIconScale;
            float normalTabIconHeight = this.mTab.getNormalTabIconHeight() * this.mTab.selectedTabIconScale;
            int i3 = this.mTab.iconPosition;
            if (i3 == 1 || i3 == 3) {
                i2 = (int) (i2 - (normalTabIconHeight - this.mTab.getIconTextGap()));
            } else {
                i = (int) (i - (normalTabIconWidth - this.mTab.getIconTextGap()));
            }
        }
        this.mCollapsingTextHelper.setCollapsedBounds(0, 0, i, i2);
        this.mCollapsingTextHelper.setExpandedBounds(0, 0, i, i2);
        this.mCollapsingTextHelper.calculateBaseOffsets();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        onLayoutTab(i5, i6);
        onLayoutSignCount(i5, i6);
    }

    protected void onLayoutSignCount(int i, int i2) {
        if (this.mSignCountView == null || this.mTab == null) {
            return;
        }
        android.graphics.Point pointCalculateSignCountLayoutPosition = calculateSignCountLayoutPosition();
        int measuredWidth = pointCalculateSignCountLayoutPosition.x;
        int measuredHeight = pointCalculateSignCountLayoutPosition.y;
        if (pointCalculateSignCountLayoutPosition.x + this.mSignCountView.getMeasuredWidth() > i) {
            measuredWidth = i - this.mSignCountView.getMeasuredWidth();
        }
        if (pointCalculateSignCountLayoutPosition.y - this.mSignCountView.getMeasuredHeight() < 0) {
            measuredHeight = this.mSignCountView.getMeasuredHeight();
        }
        com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton = this.mSignCountView;
        qMUIRoundButton.layout(measuredWidth, measuredHeight - qMUIRoundButton.getMeasuredHeight(), this.mSignCountView.getMeasuredWidth() + measuredWidth, measuredHeight);
    }

    private android.graphics.Point calculateSignCountLayoutPosition() {
        int i;
        float f;
        com.up366.qmui.widget.tab.QMUITabIcon tabIcon = this.mTab.getTabIcon();
        int iconPosition = this.mTab.getIconPosition();
        if (tabIcon == null || iconPosition == 3 || iconPosition == 0) {
            i = (int) (this.mCurrentTextLeft + this.mCurrentTextWidth);
            f = this.mCurrentTextTop;
        } else {
            i = (int) (this.mCurrentIconLeft + this.mCurrentIconWidth);
            f = this.mCurrentIconTop;
        }
        android.graphics.Point point = new android.graphics.Point(i, (int) f);
        int i2 = this.mTab.signCountBottomMarginWithIconOrText;
        if (i2 == Integer.MIN_VALUE && this.mSignCountView != null) {
            point.y = getMeasuredHeight() - ((getMeasuredHeight() - this.mSignCountView.getMeasuredHeight()) / 2);
            point.offset(this.mTab.signCountLeftMarginWithIconOrText, 0);
        } else {
            point.offset(this.mTab.signCountLeftMarginWithIconOrText, i2);
        }
        return point;
    }

    protected void onLayoutTab(int i, int i2) {
        if (this.mTab == null) {
            return;
        }
        this.mCollapsingTextHelper.calculateCurrentOffsets();
        com.up366.qmui.widget.tab.QMUITabIcon tabIcon = this.mTab.getTabIcon();
        float collapsedTextWidth = this.mCollapsingTextHelper.getCollapsedTextWidth();
        float collapsedTextHeight = this.mCollapsingTextHelper.getCollapsedTextHeight();
        float expandedTextWidth = this.mCollapsingTextHelper.getExpandedTextWidth();
        float expandedTextHeight = this.mCollapsingTextHelper.getExpandedTextHeight();
        if (tabIcon == null) {
            this.mSelectedIconTop = 0.0f;
            this.mSelectedIconLeft = 0.0f;
            this.mNormalIconTop = 0.0f;
            this.mNormalIconLeft = 0.0f;
            int i3 = this.mTab.gravity & 112;
            if (i3 == 48) {
                this.mNormalTextTop = 0.0f;
                this.mSelectedTextTop = 0.0f;
            } else if (i3 == 80) {
                float f = i2;
                this.mNormalTextTop = f - collapsedTextHeight;
                this.mSelectedTextTop = f - expandedTextHeight;
            } else {
                float f2 = i2;
                this.mNormalTextTop = (f2 - collapsedTextHeight) / 2.0f;
                this.mSelectedTextTop = (f2 - expandedTextHeight) / 2.0f;
            }
            int i4 = this.mTab.gravity & 8388615;
            if (i4 == 3) {
                this.mNormalTextLeft = 0.0f;
                this.mSelectedTextLeft = 0.0f;
            } else if (i4 == 5) {
                float f3 = i;
                this.mNormalTextLeft = f3 - collapsedTextWidth;
                this.mSelectedTextLeft = f3 - expandedTextWidth;
            } else {
                float f4 = i;
                this.mNormalTextLeft = (f4 - collapsedTextWidth) / 2.0f;
                this.mSelectedTextLeft = (f4 - expandedTextWidth) / 2.0f;
            }
        } else {
            int iconTextGap = this.mTab.getIconTextGap();
            int i5 = this.mTab.iconPosition;
            float normalTabIconWidth = this.mTab.getNormalTabIconWidth();
            float normalTabIconHeight = this.mTab.getNormalTabIconHeight();
            float selectedTabIconScale = this.mTab.getSelectedTabIconScale() * normalTabIconWidth;
            float selectedTabIconScale2 = this.mTab.getSelectedTabIconScale() * normalTabIconHeight;
            float f5 = iconTextGap;
            float f6 = collapsedTextWidth + f5;
            float f7 = f6 + normalTabIconWidth;
            float f8 = collapsedTextHeight + f5;
            float f9 = f8 + normalTabIconHeight;
            float f10 = expandedTextWidth + f5;
            float f11 = f10 + selectedTabIconScale;
            float f12 = expandedTextHeight + f5;
            float f13 = f12 + selectedTabIconScale2;
            if (i5 == 1 || i5 == 3) {
                int i6 = this.mTab.gravity & 8388615;
                if (i6 == 3) {
                    this.mNormalIconLeft = 0.0f;
                    this.mNormalTextLeft = 0.0f;
                    this.mSelectedIconLeft = 0.0f;
                    this.mSelectedTextLeft = 0.0f;
                } else if (i6 == 5) {
                    float f14 = i;
                    this.mNormalIconLeft = f14 - normalTabIconWidth;
                    this.mNormalTextLeft = f14 - collapsedTextWidth;
                    this.mSelectedIconLeft = f14 - selectedTabIconScale;
                    this.mSelectedTextLeft = f14 - expandedTextWidth;
                } else {
                    float f15 = i;
                    this.mNormalIconLeft = (f15 - normalTabIconWidth) / 2.0f;
                    this.mNormalTextLeft = (f15 - collapsedTextWidth) / 2.0f;
                    this.mSelectedIconLeft = (f15 - selectedTabIconScale) / 2.0f;
                    this.mSelectedTextLeft = (f15 - expandedTextWidth) / 2.0f;
                }
                int i7 = this.mTab.gravity & 112;
                if (i7 != 48) {
                    if (i7 != 80) {
                        if (i5 == 1) {
                            float f16 = i2;
                            if (f9 >= f16) {
                                this.mNormalIconTop = f16 - f9;
                            } else {
                                this.mNormalIconTop = (f16 - f9) / 2.0f;
                            }
                            this.mNormalTextTop = this.mNormalIconTop + f5 + normalTabIconHeight;
                            if (f13 >= f16) {
                                this.mSelectedIconTop = f16 - f13;
                            } else {
                                this.mSelectedIconTop = (f16 - f13) / 2.0f;
                            }
                            this.mSelectedTextTop = this.mSelectedIconTop + f5 + selectedTabIconScale2;
                        } else {
                            float f17 = i2;
                            if (f9 >= f17) {
                                this.mNormalTextTop = 0.0f;
                            } else {
                                this.mNormalTextTop = (f17 - f9) / 2.0f;
                            }
                            this.mNormalIconTop = this.mNormalTextTop + f5 + collapsedTextHeight;
                            if (f13 >= f17) {
                                this.mNormalTextTop = 0.0f;
                            } else {
                                this.mNormalTextTop = (f17 - f13) / 2.0f;
                            }
                            this.mNormalIconTop = this.mNormalTextTop + f5 + expandedTextHeight;
                        }
                    } else if (i5 == 1) {
                        float f18 = i2;
                        float f19 = f18 - collapsedTextHeight;
                        this.mNormalTextTop = f19;
                        float f20 = f18 - expandedTextHeight;
                        this.mSelectedTextTop = f20;
                        this.mNormalIconTop = (f19 - f5) - normalTabIconHeight;
                        this.mSelectedIconTop = (f20 - f5) - selectedTabIconScale2;
                    } else {
                        float f21 = i2;
                        float f22 = f21 - normalTabIconHeight;
                        this.mNormalIconTop = f22;
                        float f23 = f21 - selectedTabIconScale2;
                        this.mSelectedIconTop = f23;
                        this.mNormalTextTop = (f22 - f5) - collapsedTextHeight;
                        this.mSelectedTextTop = (f23 - f5) - expandedTextHeight;
                    }
                } else if (i5 == 1) {
                    this.mNormalIconTop = 0.0f;
                    this.mSelectedIconTop = 0.0f;
                    this.mNormalTextTop = normalTabIconHeight + f5;
                    this.mSelectedTextTop = selectedTabIconScale2 + f5;
                } else {
                    this.mNormalTextTop = 0.0f;
                    this.mSelectedTextTop = 0.0f;
                    this.mNormalIconTop = f8;
                    this.mSelectedIconTop = f12;
                }
            } else {
                int i8 = this.mTab.gravity & 112;
                if (i8 == 48) {
                    this.mNormalIconTop = 0.0f;
                    this.mNormalTextTop = 0.0f;
                    this.mSelectedIconTop = 0.0f;
                    this.mSelectedTextTop = 0.0f;
                } else if (i8 == 80) {
                    float f24 = i2;
                    this.mNormalIconTop = f24 - normalTabIconHeight;
                    this.mNormalTextTop = f24 - collapsedTextHeight;
                    this.mSelectedIconTop = f24 - selectedTabIconScale2;
                    this.mSelectedTextTop = f24 - expandedTextHeight;
                } else {
                    float f25 = i2;
                    this.mNormalIconTop = (f25 - normalTabIconHeight) / 2.0f;
                    this.mNormalTextTop = (f25 - collapsedTextHeight) / 2.0f;
                    this.mSelectedIconTop = (f25 - selectedTabIconScale2) / 2.0f;
                    this.mSelectedTextTop = (f25 - expandedTextHeight) / 2.0f;
                }
                int i9 = this.mTab.gravity & 8388615;
                if (i9 != 3) {
                    if (i9 != 5) {
                        if (i5 == 2) {
                            float f26 = i;
                            float f27 = (f26 - f7) / 2.0f;
                            this.mNormalTextLeft = f27;
                            float f28 = (f26 - f11) / 2.0f;
                            this.mSelectedTextLeft = f28;
                            this.mNormalIconLeft = f27 + collapsedTextWidth + f5;
                            this.mSelectedIconLeft = f28 + expandedTextWidth + f5;
                        } else {
                            float f29 = i;
                            float f30 = (f29 - f7) / 2.0f;
                            this.mNormalIconLeft = f30;
                            float f31 = (f29 - f11) / 2.0f;
                            this.mSelectedIconLeft = f31;
                            this.mNormalTextLeft = f30 + normalTabIconWidth + f5;
                            this.mSelectedTextLeft = f31 + selectedTabIconScale + f5;
                        }
                    } else if (i5 == 2) {
                        float f32 = i;
                        this.mNormalTextLeft = f32 - f7;
                        this.mSelectedTextLeft = f32 - f11;
                        this.mNormalIconLeft = f32 - normalTabIconWidth;
                        this.mSelectedIconLeft = f32 - selectedTabIconScale;
                    } else {
                        float f33 = i;
                        this.mNormalIconLeft = f33 - f7;
                        this.mSelectedIconLeft = f33 - f11;
                        this.mNormalTextLeft = f33 - collapsedTextWidth;
                        this.mSelectedTextLeft = f33 - expandedTextWidth;
                    }
                } else if (i5 == 2) {
                    this.mNormalTextLeft = 0.0f;
                    this.mSelectedTextLeft = 0.0f;
                    this.mNormalIconLeft = f6;
                    this.mSelectedIconLeft = f10;
                } else {
                    this.mNormalIconLeft = 0.0f;
                    this.mSelectedIconLeft = 0.0f;
                    this.mNormalTextLeft = normalTabIconWidth + f5;
                    this.mSelectedTextLeft = selectedTabIconScale + f5;
                }
                if (i5 == 0) {
                    float f34 = i;
                    if (f7 >= f34) {
                        this.mNormalIconLeft = f34 - f7;
                    } else {
                        this.mNormalIconLeft = (f34 - f7) / 2.0f;
                    }
                    this.mNormalTextLeft = this.mNormalIconLeft + normalTabIconWidth + f5;
                    if (f11 >= f34) {
                        this.mSelectedIconLeft = f34 - f11;
                    } else {
                        this.mSelectedIconLeft = (f34 - f11) / 2.0f;
                    }
                    this.mSelectedTextLeft = this.mSelectedIconLeft + selectedTabIconScale + f5;
                } else {
                    float f35 = i;
                    if (f7 >= f35) {
                        this.mNormalTextLeft = 0.0f;
                    } else {
                        this.mNormalTextLeft = (f35 - f7) / 2.0f;
                    }
                    this.mNormalIconLeft = this.mNormalTextLeft + collapsedTextWidth + f5;
                    if (f11 >= f35) {
                        this.mSelectedTextLeft = 0.0f;
                    } else {
                        this.mSelectedTextLeft = (f35 - f11) / 2.0f;
                    }
                    this.mSelectedIconLeft = this.mSelectedTextLeft + expandedTextWidth + f5;
                }
            }
        }
        updateCurrentInfo(1.0f - this.mCollapsingTextHelper.getExpansionFraction());
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(android.graphics.drawable.Drawable drawable) {
        invalidate();
    }

    @Override // android.view.View
    public final void draw(android.graphics.Canvas canvas) {
        onDrawTab(canvas);
        super.draw(canvas);
    }

    protected void onDrawTab(android.graphics.Canvas canvas) {
        com.up366.qmui.widget.tab.QMUITab qMUITab = this.mTab;
        if (qMUITab == null) {
            return;
        }
        com.up366.qmui.widget.tab.QMUITabIcon tabIcon = qMUITab.getTabIcon();
        if (tabIcon != null) {
            canvas.save();
            canvas.translate(this.mCurrentIconLeft, this.mCurrentIconTop);
            tabIcon.setBounds(0, 0, (int) this.mCurrentIconWidth, (int) this.mCurrentIconHeight);
            tabIcon.draw(canvas);
            canvas.restore();
        }
        canvas.save();
        canvas.translate(this.mCurrentTextLeft, this.mCurrentTextTop);
        this.mCollapsingTextHelper.draw(canvas);
        canvas.restore();
    }

    @Override // com.up366.qmui.skin.IQMUISkinHandlerView
    public void handle(com.up366.qmui.skin.QMUISkinManager qMUISkinManager, int i, android.content.res.Resources.Theme theme, androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> simpleArrayMap) {
        com.up366.qmui.widget.tab.QMUITab qMUITab = this.mTab;
        if (qMUITab != null) {
            updateSkinInfo(qMUITab);
            invalidate();
        }
    }

    private void updateSkinInfo(com.up366.qmui.widget.tab.QMUITab qMUITab) {
        int normalColor = qMUITab.getNormalColor(this);
        int selectColor = qMUITab.getSelectColor(this);
        this.mCollapsingTextHelper.setTextColor(android.content.res.ColorStateList.valueOf(normalColor), android.content.res.ColorStateList.valueOf(selectColor), true);
        if (qMUITab.tabIcon != null) {
            if (qMUITab.skinChangeWithTintColor) {
                qMUITab.tabIcon.tint(normalColor, selectColor);
                return;
            }
            android.graphics.drawable.Drawable skinDrawable = qMUITab.normalIconAttr != 0 ? com.up366.qmui.skin.QMUISkinHelper.getSkinDrawable(this, qMUITab.normalIconAttr) : null;
            android.graphics.drawable.Drawable skinDrawable2 = qMUITab.selectedIconAttr != 0 ? com.up366.qmui.skin.QMUISkinHelper.getSkinDrawable(this, qMUITab.selectedIconAttr) : null;
            if (skinDrawable != null && skinDrawable2 != null) {
                qMUITab.tabIcon.src(skinDrawable, skinDrawable2);
            } else if (skinDrawable != null && !qMUITab.tabIcon.hasSelectedIcon()) {
                qMUITab.tabIcon.src(skinDrawable, normalColor, selectColor);
            } else {
                com.up366.qmui.QMUILog.i(TAG, "skin attr not matched with current value.", new java.lang.Object[0]);
            }
        }
    }
}
