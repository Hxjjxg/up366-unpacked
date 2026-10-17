package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUICollapsingTopBarLayout extends android.widget.FrameLayout implements com.up366.qmui.widget.IWindowInsetLayout, com.up366.qmui.skin.IQMUISkinDispatchInterceptor {
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    private int mCollapsedTextColorSkinAttr;
    final com.up366.qmui.util.QMUICollapsingTextHelper mCollapsingTextHelper;
    private boolean mCollapsingTitleEnabled;
    private android.graphics.drawable.Drawable mContentScrim;
    private int mContentScrimSkinAttr;
    int mCurrentOffset;
    private int mExpandedMarginBottom;
    private int mExpandedMarginEnd;
    private int mExpandedMarginStart;
    private int mExpandedMarginTop;
    private int mExpandedTextColorSkinAttr;
    java.lang.Object mLastInsets;
    private com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener mOnOffsetChangedListener;
    private java.util.ArrayList<com.up366.qmui.widget.QMUICollapsingTopBarLayout.OnOffsetUpdateListener> mOnOffsetUpdateListeners;
    private boolean mRefreshToolbar;
    private int mScrimAlpha;
    private long mScrimAnimationDuration;
    private android.animation.ValueAnimator mScrimAnimator;
    private android.animation.ValueAnimator.AnimatorUpdateListener mScrimUpdateListener;
    private int mScrimVisibleHeightTrigger;
    private boolean mScrimsAreShown;
    android.graphics.drawable.Drawable mStatusBarScrim;
    private int mStatusBarScrimSkinAttr;
    private final android.graphics.Rect mTmpRect;
    private com.up366.qmui.widget.QMUITopBar mTopBar;
    private android.view.View mTopBarDirectChild;
    private int mTopBarId;

    public interface OnOffsetUpdateListener {
        void onOffsetChanged(com.up366.qmui.widget.QMUICollapsingTopBarLayout qMUICollapsingTopBarLayout, int i, float f);
    }

    public QMUICollapsingTopBarLayout(android.content.Context context) {
        this(context, null);
    }

    public QMUICollapsingTopBarLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUICollapsingTopBarLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRefreshToolbar = true;
        this.mTmpRect = new android.graphics.Rect();
        this.mScrimVisibleHeightTrigger = -1;
        this.mOnOffsetUpdateListeners = new java.util.ArrayList<>();
        this.mContentScrimSkinAttr = 0;
        this.mStatusBarScrimSkinAttr = 0;
        this.mCollapsedTextColorSkinAttr = 0;
        this.mExpandedTextColorSkinAttr = 0;
        com.up366.qmui.util.QMUICollapsingTextHelper qMUICollapsingTextHelper = new com.up366.qmui.util.QMUICollapsingTextHelper(this);
        this.mCollapsingTextHelper = qMUICollapsingTextHelper;
        qMUICollapsingTextHelper.setTextSizeInterpolator(com.up366.qmui.QMUIInterpolatorStaticHolder.DECELERATE_INTERPOLATOR);
        com.up366.qmui.util.QMUIViewHelper.checkAppCompatTheme(context);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout, i, 0);
        qMUICollapsingTextHelper.setExpandedTextGravity(typedArrayObtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleGravity, 81));
        qMUICollapsingTextHelper.setCollapsedTextGravity(typedArrayObtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMargin, 0);
        this.mExpandedMarginBottom = dimensionPixelSize;
        this.mExpandedMarginEnd = dimensionPixelSize;
        this.mExpandedMarginTop = dimensionPixelSize;
        this.mExpandedMarginStart = dimensionPixelSize;
        if (typedArrayObtainStyledAttributes.hasValue(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginStart)) {
            this.mExpandedMarginStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginStart, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginEnd)) {
            this.mExpandedMarginEnd = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginEnd, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginTop)) {
            this.mExpandedMarginTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginTop, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginBottom)) {
            this.mExpandedMarginBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginBottom, 0);
        }
        this.mCollapsingTitleEnabled = typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_titleEnabled, true);
        setTitle(typedArrayObtainStyledAttributes.getText(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_title));
        qMUICollapsingTextHelper.setExpandedTextAppearance(com.qmuiteam.qmui.R.style.QMUI_CollapsingTopBarLayoutExpanded);
        qMUICollapsingTextHelper.setCollapsedTextAppearance(com.qmuiteam.qmui.R.style.QMUI_CollapsingTopBarLayoutCollapsed);
        if (typedArrayObtainStyledAttributes.hasValue(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleTextAppearance)) {
            qMUICollapsingTextHelper.setExpandedTextAppearance(typedArrayObtainStyledAttributes.getResourceId(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleTextAppearance, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_collapsedTitleTextAppearance)) {
            qMUICollapsingTextHelper.setCollapsedTextAppearance(typedArrayObtainStyledAttributes.getResourceId(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_collapsedTitleTextAppearance, 0));
        }
        this.mScrimVisibleHeightTrigger = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_scrimVisibleHeightTrigger, -1);
        this.mScrimAnimationDuration = typedArrayObtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_scrimAnimationDuration, DEFAULT_SCRIM_ANIMATION_DURATION);
        this.mTopBarId = typedArrayObtainStyledAttributes.getResourceId(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_topBarId, -1);
        if (typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_followTopBarCommonSkin, false)) {
            followTopBarCommonSkin();
        } else {
            setContentScrimInner(typedArrayObtainStyledAttributes.getDrawable(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_contentScrim));
            setStatusBarScrimInner(typedArrayObtainStyledAttributes.getDrawable(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_qmui_statusBarScrim));
        }
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(this, new androidx.core.view.OnApplyWindowInsetsListener() { // from class: com.up366.qmui.widget.QMUICollapsingTopBarLayout.1
            public androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
                return com.up366.qmui.widget.QMUICollapsingTopBarLayout.this.setWindowInsets(windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public androidx.core.view.WindowInsetsCompat setWindowInsets(androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
        return applySystemWindowInsets21(windowInsetsCompat) ? windowInsetsCompat.consumeSystemWindowInsets() : windowInsetsCompat;
    }

    public void followTopBarCommonSkin() {
        setCollapsedTextColorSkinAttr(com.qmuiteam.qmui.R.attr.qmui_skin_support_topbar_title_color);
        setExpandedTextColorSkinAttr(com.qmuiteam.qmui.R.attr.qmui_skin_support_topbar_title_color);
        setContentScrimSkinAttr(com.qmuiteam.qmui.R.attr.qmui_skin_support_topbar_bg);
        setStatusBarScrimSkinAttr(com.qmuiteam.qmui.R.attr.qmui_skin_support_topbar_bg);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(android.view.View view) {
        super.onViewAdded(view);
        if (view instanceof com.up366.qmui.widget.QMUITopBar) {
            ((com.up366.qmui.widget.QMUITopBar) view).disableBackgroundSetter();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.appbar.AppBarLayout parent = getParent();
        if (parent instanceof com.google.android.material.appbar.AppBarLayout) {
            androidx.core.view.ViewCompat.setFitsSystemWindows(this, androidx.core.view.ViewCompat.getFitsSystemWindows((android.view.View) parent));
            if (this.mOnOffsetChangedListener == null) {
                this.mOnOffsetChangedListener = new com.up366.qmui.widget.QMUICollapsingTopBarLayout.OffsetUpdateListener();
            }
            parent.addOnOffsetChangedListener(this.mOnOffsetChangedListener);
            androidx.core.view.ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        com.google.android.material.appbar.AppBarLayout parent = getParent();
        com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.mOnOffsetChangedListener;
        if (onOffsetChangedListener != null && (parent instanceof com.google.android.material.appbar.AppBarLayout)) {
            parent.removeOnOffsetChangedListener(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        int windowInsetTop;
        android.graphics.drawable.Drawable drawable;
        super.draw(canvas);
        ensureToolbar();
        if (this.mTopBar == null && (drawable = this.mContentScrim) != null && this.mScrimAlpha > 0) {
            drawable.mutate().setAlpha(this.mScrimAlpha);
            this.mContentScrim.draw(canvas);
        }
        if (this.mCollapsingTitleEnabled) {
            this.mCollapsingTextHelper.draw(canvas);
        }
        if (this.mStatusBarScrim == null || this.mScrimAlpha <= 0 || (windowInsetTop = getWindowInsetTop()) <= 0) {
            return;
        }
        this.mStatusBarScrim.setBounds(0, -this.mCurrentOffset, getWidth(), windowInsetTop - this.mCurrentOffset);
        this.mStatusBarScrim.mutate().setAlpha(this.mScrimAlpha);
        this.mStatusBarScrim.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWindowInsetTop() {
        java.lang.Object obj = this.mLastInsets;
        if (obj == null) {
            return 0;
        }
        if (obj instanceof androidx.core.view.WindowInsetsCompat) {
            return ((androidx.core.view.WindowInsetsCompat) obj).getSystemWindowInsetTop();
        }
        if (obj instanceof android.graphics.Rect) {
            return ((android.graphics.Rect) obj).top;
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(android.graphics.Canvas canvas, android.view.View view, long j) {
        boolean z;
        if (this.mContentScrim == null || this.mScrimAlpha <= 0 || !isToolbarChild(view)) {
            z = false;
        } else {
            this.mContentScrim.mutate().setAlpha(this.mScrimAlpha);
            this.mContentScrim.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j) || z;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        android.graphics.drawable.Drawable drawable = this.mContentScrim;
        if (drawable != null) {
            drawable.setBounds(0, 0, i, i2);
        }
    }

    private void ensureToolbar() {
        if (this.mRefreshToolbar) {
            com.up366.qmui.widget.QMUITopBar qMUITopBar = null;
            this.mTopBar = null;
            this.mTopBarDirectChild = null;
            int i = this.mTopBarId;
            if (i != -1) {
                com.up366.qmui.widget.QMUITopBar qMUITopBar2 = (com.up366.qmui.widget.QMUITopBar) findViewById(i);
                this.mTopBar = qMUITopBar2;
                if (qMUITopBar2 != null) {
                    this.mTopBarDirectChild = findDirectChild(qMUITopBar2);
                }
            }
            if (this.mTopBar == null) {
                int childCount = getChildCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        break;
                    }
                    android.view.View childAt = getChildAt(i2);
                    if (childAt instanceof com.up366.qmui.widget.QMUITopBar) {
                        qMUITopBar = (com.up366.qmui.widget.QMUITopBar) childAt;
                        break;
                    }
                    i2++;
                }
                this.mTopBar = qMUITopBar;
            }
            this.mRefreshToolbar = false;
        }
    }

    private boolean isToolbarChild(android.view.View view) {
        android.view.View view2 = this.mTopBarDirectChild;
        if (view2 == null || view2 == this) {
            if (view == this.mTopBar) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    private android.view.View findDirectChild(android.view.View view) {
        for (android.view.ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof android.view.View) {
                view = parent;
            }
        }
        return view;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        ensureToolbar();
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mLastInsets != null) {
            int windowInsetTop = getWindowInsetTop();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                android.view.View childAt = getChildAt(i5);
                if (androidx.core.view.ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < windowInsetTop) {
                    androidx.core.view.ViewCompat.offsetTopAndBottom(childAt, windowInsetTop);
                }
            }
        }
        if (this.mCollapsingTitleEnabled) {
            android.view.View view = this.mTopBarDirectChild;
            if (view == null) {
                view = this.mTopBar;
            }
            int maxOffsetForPinChild = getMaxOffsetForPinChild(view, true);
            com.up366.qmui.util.QMUIViewHelper.getDescendantRect(this, this.mTopBar, this.mTmpRect);
            android.graphics.Rect titleContainerRect = this.mTopBar.getTitleContainerRect();
            this.mCollapsingTextHelper.setCollapsedBounds(this.mTmpRect.left + titleContainerRect.left, this.mTmpRect.top + maxOffsetForPinChild + titleContainerRect.top, this.mTmpRect.left + titleContainerRect.right, this.mTmpRect.top + maxOffsetForPinChild + titleContainerRect.bottom);
            this.mCollapsingTextHelper.setExpandedBounds(this.mExpandedMarginStart, this.mTmpRect.top + this.mExpandedMarginTop, (i3 - i) - this.mExpandedMarginEnd, (i4 - i2) - this.mExpandedMarginBottom);
            this.mCollapsingTextHelper.recalculate();
        }
        int childCount2 = getChildCount();
        for (int i6 = 0; i6 < childCount2; i6++) {
            getViewOffsetHelper(getChildAt(i6)).onViewLayout();
        }
        if (this.mTopBar != null) {
            if (this.mCollapsingTitleEnabled && android.text.TextUtils.isEmpty(this.mCollapsingTextHelper.getText())) {
                this.mCollapsingTextHelper.setText(this.mTopBar.getTitle());
            }
            android.view.View view2 = this.mTopBarDirectChild;
            if (view2 == null || view2 == this) {
                setMinimumHeight(getHeightWithMargins(this.mTopBar));
            } else {
                setMinimumHeight(getHeightWithMargins(view2));
            }
        }
        updateScrimVisibility();
    }

    private static int getHeightWithMargins(android.view.View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) layoutParams;
            return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return view.getHeight();
    }

    static com.up366.qmui.util.QMUIViewOffsetHelper getViewOffsetHelper(android.view.View view) {
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper = (com.up366.qmui.util.QMUIViewOffsetHelper) view.getTag(com.qmuiteam.qmui.R.id.qmui_view_offset_helper);
        if (qMUIViewOffsetHelper != null) {
            return qMUIViewOffsetHelper;
        }
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper2 = new com.up366.qmui.util.QMUIViewOffsetHelper(view);
        view.setTag(com.qmuiteam.qmui.R.id.qmui_view_offset_helper, qMUIViewOffsetHelper2);
        return qMUIViewOffsetHelper2;
    }

    public void setTitle(java.lang.CharSequence charSequence) {
        this.mCollapsingTextHelper.setText(charSequence);
    }

    public java.lang.CharSequence getTitle() {
        if (this.mCollapsingTitleEnabled) {
            return this.mCollapsingTextHelper.getText();
        }
        return null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.mCollapsingTitleEnabled) {
            this.mCollapsingTitleEnabled = z;
            requestLayout();
        }
    }

    public boolean isTitleEnabled() {
        return this.mCollapsingTitleEnabled;
    }

    public void setScrimsShown(boolean z) {
        setScrimsShown(z, androidx.core.view.ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setScrimsShown(boolean z, boolean z2) {
        if (this.mScrimsAreShown != z) {
            if (z2) {
                animateScrim(z ? 255 : 0);
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.mScrimsAreShown = z;
        }
    }

    public void setScrimUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = this.mScrimUpdateListener;
        if (animatorUpdateListener2 != animatorUpdateListener) {
            android.animation.ValueAnimator valueAnimator = this.mScrimAnimator;
            if (valueAnimator == null) {
                this.mScrimUpdateListener = animatorUpdateListener;
                return;
            }
            if (animatorUpdateListener2 != null) {
                valueAnimator.removeUpdateListener(animatorUpdateListener2);
            }
            this.mScrimUpdateListener = animatorUpdateListener;
            if (animatorUpdateListener != null) {
                this.mScrimAnimator.addUpdateListener(animatorUpdateListener);
            }
        }
    }

    private void animateScrim(int i) {
        ensureToolbar();
        android.animation.ValueAnimator valueAnimator = this.mScrimAnimator;
        if (valueAnimator == null) {
            android.animation.ValueAnimator valueAnimator2 = new android.animation.ValueAnimator();
            this.mScrimAnimator = valueAnimator2;
            valueAnimator2.setDuration(this.mScrimAnimationDuration);
            this.mScrimAnimator.setInterpolator(i > this.mScrimAlpha ? com.up366.qmui.QMUIInterpolatorStaticHolder.FAST_OUT_LINEAR_IN_INTERPOLATOR : com.up366.qmui.QMUIInterpolatorStaticHolder.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
            this.mScrimAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.qmui.widget.QMUICollapsingTopBarLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator3) {
                    com.up366.qmui.widget.QMUICollapsingTopBarLayout.this.setScrimAlpha(((java.lang.Integer) valueAnimator3.getAnimatedValue()).intValue());
                }
            });
            android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.mScrimUpdateListener;
            if (animatorUpdateListener != null) {
                this.mScrimAnimator.addUpdateListener(animatorUpdateListener);
            }
        } else if (valueAnimator.isRunning()) {
            this.mScrimAnimator.cancel();
        }
        this.mScrimAnimator.setIntValues(this.mScrimAlpha, i);
        this.mScrimAnimator.start();
    }

    void setScrimAlpha(int i) {
        com.up366.qmui.widget.QMUITopBar qMUITopBar;
        if (i != this.mScrimAlpha) {
            if (this.mContentScrim != null && (qMUITopBar = this.mTopBar) != null) {
                androidx.core.view.ViewCompat.postInvalidateOnAnimation(qMUITopBar);
            }
            this.mScrimAlpha = i;
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    int getScrimAlpha() {
        return this.mScrimAlpha;
    }

    public void setContentScrimSkinAttr(int i) {
        this.mContentScrimSkinAttr = i;
        if (i != 0) {
            setStatusBarScrimInner(com.up366.qmui.skin.QMUISkinHelper.getSkinDrawable(this, i));
        }
    }

    public void setContentScrim(android.graphics.drawable.Drawable drawable) {
        this.mContentScrimSkinAttr = 0;
        setContentScrimInner(drawable);
    }

    private void setContentScrimInner(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2 = this.mContentScrim;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            android.graphics.drawable.Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.mContentScrim = drawableMutate;
            if (drawableMutate != null) {
                drawableMutate.setBounds(0, 0, getWidth(), getHeight());
                this.mContentScrim.setCallback(this);
                this.mContentScrim.setAlpha(this.mScrimAlpha);
            }
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new android.graphics.drawable.ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(androidx.core.content.ContextCompat.getDrawable(getContext(), i));
    }

    public android.graphics.drawable.Drawable getContentScrim() {
        return this.mContentScrim;
    }

    public void setStatusBarScrim(android.graphics.drawable.Drawable drawable) {
        this.mStatusBarScrimSkinAttr = 0;
        setStatusBarScrimInner(drawable);
    }

    private void setStatusBarScrimInner(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2 = this.mStatusBarScrim;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            android.graphics.drawable.Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.mStatusBarScrim = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.mStatusBarScrim.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.DrawableCompat.setLayoutDirection(this.mStatusBarScrim, androidx.core.view.ViewCompat.getLayoutDirection(this));
                this.mStatusBarScrim.setVisible(getVisibility() == 0, false);
                this.mStatusBarScrim.setCallback(this);
                this.mStatusBarScrim.setAlpha(this.mScrimAlpha);
            }
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimSkinAttr(int i) {
        this.mStatusBarScrimSkinAttr = i;
        if (i != 0) {
            setStatusBarScrimInner(com.up366.qmui.skin.QMUISkinHelper.getSkinDrawable(this, i));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        android.graphics.drawable.Drawable drawable = this.mStatusBarScrim;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        android.graphics.drawable.Drawable drawable2 = this.mContentScrim;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        com.up366.qmui.util.QMUICollapsingTextHelper qMUICollapsingTextHelper = this.mCollapsingTextHelper;
        if (qMUICollapsingTextHelper != null) {
            state |= qMUICollapsingTextHelper.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(android.graphics.drawable.Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mContentScrim || drawable == this.mStatusBarScrim;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        android.graphics.drawable.Drawable drawable = this.mStatusBarScrim;
        if (drawable != null && drawable.isVisible() != z) {
            this.mStatusBarScrim.setVisible(z, false);
        }
        android.graphics.drawable.Drawable drawable2 = this.mContentScrim;
        if (drawable2 == null || drawable2.isVisible() == z) {
            return;
        }
        this.mContentScrim.setVisible(z, false);
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new android.graphics.drawable.ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(androidx.core.content.ContextCompat.getDrawable(getContext(), i));
    }

    public android.graphics.drawable.Drawable getStatusBarScrim() {
        return this.mStatusBarScrim;
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.mCollapsingTextHelper.setCollapsedTextAppearance(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(android.content.res.ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextColor(android.content.res.ColorStateList colorStateList) {
        this.mCollapsedTextColorSkinAttr = 0;
        this.mCollapsingTextHelper.setCollapsedTextColor(colorStateList);
    }

    public void setCollapsedTextColorSkinAttr(int i) {
        this.mCollapsedTextColorSkinAttr = i;
        if (i != 0) {
            this.mCollapsingTextHelper.setCollapsedTextColor(com.up366.qmui.skin.QMUISkinHelper.getSkinColorStateList(this, i));
        }
    }

    public void setCollapsedTitleGravity(int i) {
        this.mCollapsingTextHelper.setCollapsedTextGravity(i);
    }

    public int getCollapsedTitleGravity() {
        return this.mCollapsingTextHelper.getCollapsedTextGravity();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.mCollapsingTextHelper.setExpandedTextAppearance(i);
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(android.content.res.ColorStateList.valueOf(i));
    }

    public void setExpandedTitleTextColor(android.content.res.ColorStateList colorStateList) {
        this.mExpandedTextColorSkinAttr = 0;
        this.mCollapsingTextHelper.setExpandedTextColor(colorStateList);
    }

    public void setExpandedTextColorSkinAttr(int i) {
        this.mExpandedTextColorSkinAttr = i;
        if (i != 0) {
            this.mCollapsingTextHelper.setExpandedTextColor(com.up366.qmui.skin.QMUISkinHelper.getSkinColorStateList(this, i));
        }
    }

    public void setExpandedTitleGravity(int i) {
        this.mCollapsingTextHelper.setExpandedTextGravity(i);
    }

    public int getExpandedTitleGravity() {
        return this.mCollapsingTextHelper.getExpandedTextGravity();
    }

    public void setCollapsedTitleTypeface(android.graphics.Typeface typeface) {
        this.mCollapsingTextHelper.setCollapsedTypeface(typeface);
    }

    public android.graphics.Typeface getCollapsedTitleTypeface() {
        return this.mCollapsingTextHelper.getCollapsedTypeface();
    }

    public void setExpandedTitleTypeface(android.graphics.Typeface typeface) {
        this.mCollapsingTextHelper.setExpandedTypeface(typeface);
    }

    public android.graphics.Typeface getExpandedTitleTypeface() {
        return this.mCollapsingTextHelper.getExpandedTypeface();
    }

    public void setExpandedTitleMargin(int i, int i2, int i3, int i4) {
        this.mExpandedMarginStart = i;
        this.mExpandedMarginTop = i2;
        this.mExpandedMarginEnd = i3;
        this.mExpandedMarginBottom = i4;
        requestLayout();
    }

    public int getExpandedTitleMarginStart() {
        return this.mExpandedMarginStart;
    }

    public void setExpandedTitleMarginStart(int i) {
        this.mExpandedMarginStart = i;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.mExpandedMarginTop;
    }

    public void setExpandedTitleMarginTop(int i) {
        this.mExpandedMarginTop = i;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.mExpandedMarginEnd;
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.mExpandedMarginEnd = i;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.mExpandedMarginBottom;
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.mExpandedMarginBottom = i;
        requestLayout();
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.mScrimVisibleHeightTrigger != i) {
            this.mScrimVisibleHeightTrigger = i;
            updateScrimVisibility();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        int i = this.mScrimVisibleHeightTrigger;
        if (i >= 0) {
            return i;
        }
        int windowInsetTop = getWindowInsetTop();
        int minimumHeight = androidx.core.view.ViewCompat.getMinimumHeight(this);
        if (minimumHeight > 0) {
            return java.lang.Math.min((minimumHeight * 2) + windowInsetTop, getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long j) {
        this.mScrimAnimationDuration = j;
    }

    public long getScrimAnimationDuration() {
        return this.mScrimAnimationDuration;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof com.up366.qmui.widget.QMUICollapsingTopBarLayout.LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public com.up366.qmui.widget.QMUICollapsingTopBarLayout.LayoutParams generateDefaultLayoutParams() {
        return new com.up366.qmui.widget.QMUICollapsingTopBarLayout.LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public android.widget.FrameLayout.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new com.up366.qmui.widget.QMUICollapsingTopBarLayout.LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public android.widget.FrameLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new com.up366.qmui.widget.QMUICollapsingTopBarLayout.LayoutParams(layoutParams);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(android.graphics.Rect rect) {
        return applySystemWindowInsets19(rect);
    }

    @Override // com.up366.qmui.widget.IWindowInsetLayout
    public boolean applySystemWindowInsets19(android.graphics.Rect rect) {
        if (!androidx.core.view.ViewCompat.getFitsSystemWindows(this)) {
            rect = null;
        }
        if (com.up366.qmui.util.QMUILangHelper.objectEquals(this.mLastInsets, rect)) {
            return true;
        }
        this.mLastInsets = rect;
        requestLayout();
        return true;
    }

    @Override // com.up366.qmui.widget.IWindowInsetLayout
    public boolean applySystemWindowInsets21(java.lang.Object obj) {
        if (!androidx.core.view.ViewCompat.getFitsSystemWindows(this)) {
            obj = null;
        }
        if (com.up366.qmui.util.QMUILangHelper.objectEquals(this.mLastInsets, obj)) {
            return true;
        }
        this.mLastInsets = obj;
        requestLayout();
        return true;
    }

    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        int mCollapseMode;
        float mParallaxMult;

        public LayoutParams(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mCollapseMode = 0;
            this.mParallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_Layout);
            this.mCollapseMode = typedArrayObtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_Layout_qmui_layout_collapseMode, 0);
            setParallaxMultiplier(typedArrayObtainStyledAttributes.getFloat(com.qmuiteam.qmui.R.styleable.QMUICollapsingTopBarLayout_Layout_qmui_layout_collapseParallaxMultiplier, DEFAULT_PARALLAX_MULTIPLIER));
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mCollapseMode = 0;
            this.mParallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2, i3);
            this.mCollapseMode = 0;
            this.mParallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mCollapseMode = 0;
            this.mParallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mCollapseMode = 0;
            this.mParallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(android.widget.FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.mCollapseMode = 0;
            this.mParallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public void setCollapseMode(int i) {
            this.mCollapseMode = i;
        }

        public int getCollapseMode() {
            return this.mCollapseMode;
        }

        public void setParallaxMultiplier(float f) {
            this.mParallaxMult = f;
        }

        public float getParallaxMultiplier() {
            return this.mParallaxMult;
        }
    }

    final void updateScrimVisibility() {
        if (this.mContentScrim == null && this.mStatusBarScrim == null) {
            return;
        }
        setScrimsShown(getHeight() + this.mCurrentOffset < getScrimVisibleHeightTrigger());
    }

    final int getMaxOffsetForPinChild(android.view.View view, boolean z) {
        int top = view.getTop();
        if (!z) {
            top = getViewOffsetHelper(view).getLayoutTop();
        }
        return ((getHeight() - top) - view.getHeight()) - ((com.up366.qmui.widget.QMUICollapsingTopBarLayout.LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    public void addOnOffsetUpdateListener(com.up366.qmui.widget.QMUICollapsingTopBarLayout.OnOffsetUpdateListener onOffsetUpdateListener) {
        this.mOnOffsetUpdateListeners.add(onOffsetUpdateListener);
    }

    public void removeOnOffsetUpdateListener(com.up366.qmui.widget.QMUICollapsingTopBarLayout.OnOffsetUpdateListener onOffsetUpdateListener) {
        this.mOnOffsetUpdateListeners.remove(onOffsetUpdateListener);
    }

    private class OffsetUpdateListener implements com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener {
        OffsetUpdateListener() {
        }

        public void onOffsetChanged(com.google.android.material.appbar.AppBarLayout appBarLayout, int i) {
            com.up366.qmui.widget.QMUICollapsingTopBarLayout.this.mCurrentOffset = i;
            int windowInsetTop = com.up366.qmui.widget.QMUICollapsingTopBarLayout.this.getWindowInsetTop();
            int childCount = com.up366.qmui.widget.QMUICollapsingTopBarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                android.view.View childAt = com.up366.qmui.widget.QMUICollapsingTopBarLayout.this.getChildAt(i2);
                com.up366.qmui.widget.QMUICollapsingTopBarLayout.LayoutParams layoutParams = (com.up366.qmui.widget.QMUICollapsingTopBarLayout.LayoutParams) childAt.getLayoutParams();
                com.up366.qmui.util.QMUIViewOffsetHelper viewOffsetHelper = com.up366.qmui.widget.QMUICollapsingTopBarLayout.getViewOffsetHelper(childAt);
                int i3 = layoutParams.mCollapseMode;
                if (i3 == 1) {
                    viewOffsetHelper.setTopAndBottomOffset(com.up366.qmui.util.QMUILangHelper.constrain(-i, 0, com.up366.qmui.widget.QMUICollapsingTopBarLayout.this.getMaxOffsetForPinChild(childAt, false)));
                } else if (i3 == 2) {
                    viewOffsetHelper.setTopAndBottomOffset(java.lang.Math.round((-i) * layoutParams.mParallaxMult));
                }
            }
            com.up366.qmui.widget.QMUICollapsingTopBarLayout.this.updateScrimVisibility();
            if (com.up366.qmui.widget.QMUICollapsingTopBarLayout.this.mStatusBarScrim != null && windowInsetTop > 0) {
                androidx.core.view.ViewCompat.postInvalidateOnAnimation(com.up366.qmui.widget.QMUICollapsingTopBarLayout.this);
            }
            float fAbs = java.lang.Math.abs(i) / ((com.up366.qmui.widget.QMUICollapsingTopBarLayout.this.getHeight() - androidx.core.view.ViewCompat.getMinimumHeight(com.up366.qmui.widget.QMUICollapsingTopBarLayout.this)) - windowInsetTop);
            com.up366.qmui.widget.QMUICollapsingTopBarLayout.this.mCollapsingTextHelper.setExpansionFraction(fAbs);
            java.util.Iterator it = com.up366.qmui.widget.QMUICollapsingTopBarLayout.this.mOnOffsetUpdateListeners.iterator();
            while (it.hasNext()) {
                ((com.up366.qmui.widget.QMUICollapsingTopBarLayout.OnOffsetUpdateListener) it.next()).onOffsetChanged(com.up366.qmui.widget.QMUICollapsingTopBarLayout.this, i, fAbs);
            }
        }
    }

    @Override // com.up366.qmui.skin.IQMUISkinDispatchInterceptor
    public boolean intercept(int i, android.content.res.Resources.Theme theme) {
        if (this.mContentScrimSkinAttr != 0) {
            setContentScrimInner(com.up366.qmui.util.QMUIResHelper.getAttrDrawable(getContext(), theme, this.mContentScrimSkinAttr));
        }
        if (this.mStatusBarScrimSkinAttr != 0) {
            setStatusBarScrimInner(com.up366.qmui.util.QMUIResHelper.getAttrDrawable(getContext(), theme, this.mStatusBarScrimSkinAttr));
        }
        int i2 = this.mCollapsedTextColorSkinAttr;
        if (i2 != 0) {
            this.mCollapsingTextHelper.setCollapsedTextColor(com.up366.qmui.skin.QMUISkinHelper.getSkinColorStateList(this, i2));
        }
        int i3 = this.mExpandedTextColorSkinAttr;
        if (i3 == 0) {
            return false;
        }
        this.mCollapsingTextHelper.setExpandedTextColor(com.up366.qmui.skin.QMUISkinHelper.getSkinColorStateList(this, i3));
        return false;
    }
}
