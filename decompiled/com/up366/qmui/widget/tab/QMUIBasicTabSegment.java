package com.up366.qmui.widget.tab;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIBasicTabSegment extends android.widget.HorizontalScrollView implements com.up366.qmui.layout.IQMUILayout, com.up366.qmui.skin.IQMUISkinHandlerView, com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider {
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    public static final int NO_POSITION = -1;
    private static final java.lang.String TAG = "QMUIBasicTabSegment";
    private static androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> sDefaultSkinAttrs;
    private com.up366.qmui.widget.tab.QMUIBasicTabSegment.Container mContentLayout;
    protected int mCurrentSelectedIndex;
    private boolean mHideIndicatorWhenTabCountLessTwo;
    private com.up366.qmui.widget.tab.QMUITabIndicator mIndicator;
    private boolean mIsInSelectTab;
    private int mItemSpaceInScrollMode;
    private com.up366.qmui.layout.QMUILayoutHelper mLayoutHelper;
    private int mMode;
    private com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabClickListener mOnTabClickListener;
    protected int mPendingSelectedIndex;
    protected android.animation.Animator mSelectAnimator;
    private boolean mSelectNoAnimation;
    private final java.util.ArrayList<com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener> mSelectedListeners;
    private com.up366.qmui.widget.tab.QMUITabAdapter mTabAdapter;
    protected com.up366.qmui.widget.tab.QMUITabBuilder mTabBuilder;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public interface OnTabClickListener {
        void onTabClick(int i);
    }

    public interface OnTabSelectedListener {
        void onDoubleTap(int i);

        void onTabReselected(int i);

        void onTabSelected(int i);

        void onTabUnselected(int i);
    }

    public interface TabBuilderUpdater {
        void update(com.up366.qmui.widget.tab.QMUITabBuilder qMUITabBuilder);
    }

    protected boolean needPreventEvent() {
        return false;
    }

    static {
        androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> simpleArrayMap = new androidx.collection.SimpleArrayMap<>(3);
        sDefaultSkinAttrs = simpleArrayMap;
        simpleArrayMap.put(com.up366.qmui.skin.QMUISkinValueBuilder.BOTTOM_SEPARATOR, java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_tab_separator_color));
        sDefaultSkinAttrs.put(com.up366.qmui.skin.QMUISkinValueBuilder.TOP_SEPARATOR, java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_tab_separator_color));
        sDefaultSkinAttrs.put("background", java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_tab_bg));
    }

    public QMUIBasicTabSegment(android.content.Context context) {
        this(context, null);
    }

    public QMUIBasicTabSegment(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.qmuiteam.qmui.R.attr.QMUITabSegmentStyle);
    }

    public QMUIBasicTabSegment(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSelectedListeners = new java.util.ArrayList<>();
        this.mCurrentSelectedIndex = -1;
        this.mPendingSelectedIndex = -1;
        this.mIndicator = null;
        this.mHideIndicatorWhenTabCountLessTwo = true;
        this.mMode = 1;
        this.mIsInSelectTab = false;
        setWillNotDraw(false);
        this.mLayoutHelper = new com.up366.qmui.layout.QMUILayoutHelper(context, attributeSet, i, this);
        init(context, attributeSet, i);
        setHorizontalScrollBarEnabled(false);
        setClipToPadding(false);
        setClipChildren(false);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUITabSegment, i, 0);
        this.mIndicator = createTabIndicatorFromXmlInfo(typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUITabSegment_qmui_tab_has_indicator, false), typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUITabSegment_qmui_tab_indicator_height, getResources().getDimensionPixelSize(com.qmuiteam.qmui.R.dimen.qmui_tab_segment_indicator_height)), typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUITabSegment_qmui_tab_indicator_top, false), typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUITabSegment_qmui_tab_indicator_with_follow_content, false));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUITabSegment_qmui_tab_normal_text_size, typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUITabSegment_android_textSize, getResources().getDimensionPixelSize(com.qmuiteam.qmui.R.dimen.qmui_tab_segment_text_size)));
        this.mTabBuilder = new com.up366.qmui.widget.tab.QMUITabBuilder(context).setTextSize(dimensionPixelSize, typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUITabSegment_qmui_tab_selected_text_size, dimensionPixelSize)).setIconPosition(typedArrayObtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUITabSegment_qmui_tab_icon_position, 0));
        this.mMode = typedArrayObtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUITabSegment_qmui_tab_mode, 1);
        this.mItemSpaceInScrollMode = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUITabSegment_qmui_tab_space, com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 10));
        this.mSelectNoAnimation = typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUITabSegment_qmui_tab_select_no_animation, false);
        typedArrayObtainStyledAttributes.recycle();
        com.up366.qmui.widget.tab.QMUIBasicTabSegment.Container container = new com.up366.qmui.widget.tab.QMUIBasicTabSegment.Container(context);
        this.mContentLayout = container;
        addView(container, new android.widget.FrameLayout.LayoutParams(-2, -1));
        this.mTabAdapter = createTabAdapter(this.mContentLayout);
    }

    public void setDefaultTextSize(int i, int i2) {
        this.mTabBuilder.setTextSize(i, i2);
    }

    public void setDefaultTabIconPosition(int i) {
        this.mTabBuilder.setIconPosition(i);
    }

    public void updateParentTabBuilder(com.up366.qmui.widget.tab.QMUIBasicTabSegment.TabBuilderUpdater tabBuilderUpdater) {
        tabBuilderUpdater.update(this.mTabBuilder);
    }

    protected com.up366.qmui.widget.tab.QMUITabAdapter createTabAdapter(android.view.ViewGroup viewGroup) {
        return new com.up366.qmui.widget.tab.QMUITabAdapter(this, viewGroup);
    }

    protected com.up366.qmui.widget.tab.QMUITabIndicator createTabIndicatorFromXmlInfo(boolean z, int i, boolean z2, boolean z3) {
        if (z) {
            return new com.up366.qmui.widget.tab.QMUITabIndicator(i, z2, z3);
        }
        return null;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder tabBuilder() {
        return new com.up366.qmui.widget.tab.QMUITabBuilder(this.mTabBuilder);
    }

    public void setIndicator(com.up366.qmui.widget.tab.QMUITabIndicator qMUITabIndicator) {
        this.mIndicator = qMUITabIndicator;
        this.mContentLayout.requestLayout();
    }

    public void setHideIndicatorWhenTabCountLessTwo(boolean z) {
        this.mHideIndicatorWhenTabCountLessTwo = z;
    }

    public void setItemSpaceInScrollMode(int i) {
        this.mItemSpaceInScrollMode = i;
    }

    public void reset() {
        this.mTabAdapter.clear();
        this.mCurrentSelectedIndex = -1;
        android.animation.Animator animator = this.mSelectAnimator;
        if (animator != null) {
            animator.cancel();
            this.mSelectAnimator = null;
        }
    }

    public com.up366.qmui.widget.tab.QMUIBasicTabSegment addTab(com.up366.qmui.widget.tab.QMUITab qMUITab) {
        this.mTabAdapter.addItem(qMUITab);
        return this;
    }

    public void notifyDataChanged() {
        this.mTabAdapter.setup();
    }

    public void addOnTabSelectedListener(com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener onTabSelectedListener) {
        if (this.mSelectedListeners.contains(onTabSelectedListener)) {
            return;
        }
        this.mSelectedListeners.add(onTabSelectedListener);
    }

    public void removeOnTabSelectedListener(com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener onTabSelectedListener) {
        this.mSelectedListeners.remove(onTabSelectedListener);
    }

    public void clearOnTabSelectedListeners() {
        this.mSelectedListeners.clear();
    }

    public int getMode() {
        return this.mMode;
    }

    public void setMode(int i) {
        if (this.mMode != i) {
            this.mMode = i;
            if (i == 0) {
                this.mTabBuilder.setGravity(3);
            }
            this.mContentLayout.invalidate();
        }
    }

    void onClickTab(int i) {
        if (this.mSelectAnimator != null || needPreventEvent()) {
            return;
        }
        if (this.mTabAdapter.getItem(i) != null) {
            selectTab(i, this.mSelectNoAnimation, true);
        }
        com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabClickListener onTabClickListener = this.mOnTabClickListener;
        if (onTabClickListener != null) {
            onTabClickListener.onTabClick(i);
        }
    }

    void onDoubleClick(int i) {
        if (this.mSelectedListeners.isEmpty() || this.mTabAdapter.getItem(i) == null) {
            return;
        }
        dispatchTabDoubleTap(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchTabSelected(int i) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).onTabSelected(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchTabUnselected(int i) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).onTabUnselected(i);
        }
    }

    private void dispatchTabReselected(int i) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).onTabReselected(i);
        }
    }

    private void dispatchTabDoubleTap(int i) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).onDoubleTap(i);
        }
    }

    public void setSelectNoAnimation(boolean z) {
        this.mSelectNoAnimation = z;
    }

    public void selectTab(int i) {
        selectTab(i, this.mSelectNoAnimation, false);
    }

    public void selectTab(final int i, boolean z, boolean z2) {
        if (this.mIsInSelectTab) {
            return;
        }
        this.mIsInSelectTab = true;
        java.util.List<com.up366.qmui.widget.tab.QMUITabView> views = this.mTabAdapter.getViews();
        if (views.size() != this.mTabAdapter.getSize()) {
            this.mTabAdapter.setup();
            views = this.mTabAdapter.getViews();
        }
        if (views.size() == 0 || views.size() <= i) {
            this.mIsInSelectTab = false;
            return;
        }
        if (this.mSelectAnimator != null || needPreventEvent()) {
            this.mPendingSelectedIndex = i;
            this.mIsInSelectTab = false;
            return;
        }
        int i2 = this.mCurrentSelectedIndex;
        if (i2 == i) {
            if (z2) {
                dispatchTabReselected(i);
            }
            this.mIsInSelectTab = false;
            this.mContentLayout.invalidate();
            return;
        }
        if (i2 > views.size()) {
            android.util.Log.i(TAG, "selectTab: current selected index is bigger than views size.");
            this.mCurrentSelectedIndex = -1;
        }
        final int i3 = this.mCurrentSelectedIndex;
        if (i3 == -1) {
            layoutIndicator(this.mTabAdapter.getItem(i), true);
            views.get(i).setSelectFraction(1.0f);
            dispatchTabSelected(i);
            this.mCurrentSelectedIndex = i;
            this.mIsInSelectTab = false;
            return;
        }
        final com.up366.qmui.widget.tab.QMUITab item = this.mTabAdapter.getItem(i3);
        final com.up366.qmui.widget.tab.QMUITabView qMUITabView = views.get(i3);
        final com.up366.qmui.widget.tab.QMUITab item2 = this.mTabAdapter.getItem(i);
        final com.up366.qmui.widget.tab.QMUITabView qMUITabView2 = views.get(i);
        if (z) {
            dispatchTabUnselected(i3);
            dispatchTabSelected(i);
            qMUITabView.setSelectFraction(0.0f);
            qMUITabView2.setSelectFraction(1.0f);
            if (this.mMode == 0) {
                int scrollX = getScrollX();
                int width = getWidth();
                int width2 = this.mContentLayout.getWidth();
                int left = qMUITabView2.getLeft();
                int width3 = qMUITabView2.getWidth();
                int paddingLeft = getPaddingLeft() + getPaddingRight();
                int size = this.mTabAdapter.getSize();
                int i4 = (width2 - width) + paddingLeft;
                if (i > i3) {
                    if (i >= size - 2) {
                        smoothScrollBy(i4 - scrollX, 0);
                    } else {
                        int width4 = views.get(i + 1).getWidth();
                        int iMin = java.lang.Math.min(i4, left - ((((width - (getPaddingRight() * 2)) - width4) - width3) - this.mItemSpaceInScrollMode)) - (width4 - width3);
                        if (scrollX < iMin) {
                            smoothScrollBy(iMin - scrollX, 0);
                        }
                    }
                } else if (i <= 1) {
                    smoothScrollBy(-scrollX, 0);
                } else {
                    int iMax = java.lang.Math.max(0, (left - views.get(i - 1).getWidth()) - this.mItemSpaceInScrollMode);
                    if (iMax < scrollX) {
                        smoothScrollBy(iMax - scrollX, 0);
                    }
                }
            }
            this.mCurrentSelectedIndex = i;
            this.mIsInSelectTab = false;
            layoutIndicator(item2, true);
            return;
        }
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(com.up366.qmui.QMUIInterpolatorStaticHolder.LINEAR_INTERPOLATOR);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.qmui.widget.tab.QMUIBasicTabSegment.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                qMUITabView.setSelectFraction(1.0f - fFloatValue);
                qMUITabView2.setSelectFraction(fFloatValue);
                com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.layoutIndicatorInTransition(item, item2, fFloatValue);
            }
        });
        valueAnimatorOfFloat.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.up366.qmui.widget.tab.QMUIBasicTabSegment.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mSelectAnimator = animator;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mSelectAnimator = null;
                qMUITabView.setSelectFraction(0.0f);
                qMUITabView2.setSelectFraction(1.0f);
                com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.dispatchTabSelected(i);
                com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.dispatchTabUnselected(i3);
                com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mCurrentSelectedIndex = i;
                if (com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mPendingSelectedIndex == -1 || com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.needPreventEvent()) {
                    return;
                }
                com.up366.qmui.widget.tab.QMUIBasicTabSegment qMUIBasicTabSegment = com.up366.qmui.widget.tab.QMUIBasicTabSegment.this;
                qMUIBasicTabSegment.selectTab(qMUIBasicTabSegment.mPendingSelectedIndex, true, false);
                com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mPendingSelectedIndex = -1;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mSelectAnimator = null;
                qMUITabView.setSelectFraction(1.0f);
                qMUITabView2.setSelectFraction(0.0f);
                com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.layoutIndicator(item, true);
            }
        });
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.start();
        this.mIsInSelectTab = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void layoutIndicator(com.up366.qmui.widget.tab.QMUITab qMUITab, boolean z) {
        com.up366.qmui.widget.tab.QMUITabIndicator qMUITabIndicator;
        if (qMUITab == null || (qMUITabIndicator = this.mIndicator) == null) {
            return;
        }
        qMUITabIndicator.updateInfo(qMUITab.contentLeft, qMUITab.contentWidth, qMUITab.selectedColorAttr == 0 ? qMUITab.selectColor : com.up366.qmui.skin.QMUISkinHelper.getSkinColor(this, qMUITab.selectedColorAttr), -2.0f);
        if (z) {
            this.mContentLayout.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void layoutIndicatorInTransition(com.up366.qmui.widget.tab.QMUITab qMUITab, com.up366.qmui.widget.tab.QMUITab qMUITab2, float f) {
        if (this.mIndicator == null) {
            return;
        }
        this.mIndicator.updateInfo((int) (qMUITab.contentLeft + ((qMUITab2.contentLeft - qMUITab.contentLeft) * f)), (int) (qMUITab.contentWidth + ((qMUITab2.contentWidth - qMUITab.contentWidth) * f)), com.up366.qmui.util.QMUIColorHelper.computeColor(qMUITab.selectedColorAttr == 0 ? qMUITab.selectColor : com.up366.qmui.skin.QMUISkinHelper.getSkinColor(this, qMUITab.selectedColorAttr), qMUITab2.selectedColorAttr == 0 ? qMUITab2.selectColor : com.up366.qmui.skin.QMUISkinHelper.getSkinColor(this, qMUITab2.selectedColorAttr), f), f);
        this.mContentLayout.invalidate();
    }

    public void updateIndicatorPosition(int i, float f) {
        int i2;
        if (this.mSelectAnimator != null || this.mIsInSelectTab || f == 0.0f) {
            return;
        }
        if (f < 0.0f) {
            i2 = i - 1;
            f = -f;
        } else {
            i2 = i + 1;
        }
        java.util.List<com.up366.qmui.widget.tab.QMUITabView> views = this.mTabAdapter.getViews();
        if (views.size() <= i || views.size() <= i2) {
            return;
        }
        com.up366.qmui.widget.tab.QMUITab item = this.mTabAdapter.getItem(i);
        com.up366.qmui.widget.tab.QMUITab item2 = this.mTabAdapter.getItem(i2);
        com.up366.qmui.widget.tab.QMUITabView qMUITabView = views.get(i);
        com.up366.qmui.widget.tab.QMUITabView qMUITabView2 = views.get(i2);
        qMUITabView.setSelectFraction(1.0f - f);
        qMUITabView2.setSelectFraction(f);
        layoutIndicatorInTransition(item, item2, f);
    }

    public void updateTabText(int i, java.lang.String str) {
        com.up366.qmui.widget.tab.QMUITab item = this.mTabAdapter.getItem(i);
        if (item == null) {
            return;
        }
        item.setText(str);
        notifyDataChanged();
    }

    public void replaceTab(int i, com.up366.qmui.widget.tab.QMUITab qMUITab) {
        try {
            if (this.mCurrentSelectedIndex == i) {
                this.mCurrentSelectedIndex = -1;
            }
            this.mTabAdapter.replaceItem(i, qMUITab);
            notifyDataChanged();
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void setOnTabClickListener(com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabClickListener onTabClickListener) {
        this.mOnTabClickListener = onTabClickListener;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = android.view.View.MeasureSpec.getSize(i);
        int mode = android.view.View.MeasureSpec.getMode(i);
        if (getChildCount() > 0) {
            android.view.View childAt = getChildAt(0);
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            childAt.measure(android.view.View.MeasureSpec.makeMeasureSpec(size - paddingLeft, com.up366.medialibrary.common.utils.PictureFileUtils.GB), i2);
            if (mode == Integer.MIN_VALUE) {
                setMeasuredDimension(java.lang.Math.min(size, childAt.getMeasuredWidth() + paddingLeft), i2);
                return;
            }
        }
        setMeasuredDimension(i, i2);
    }

    public int getSelectedIndex() {
        return this.mCurrentSelectedIndex;
    }

    public int getTabCount() {
        return this.mTabAdapter.getSize();
    }

    public com.up366.qmui.widget.tab.QMUITab getTab(int i) {
        return this.mTabAdapter.getItem(i);
    }

    public void showSignCountView(android.content.Context context, int i, int i2) {
        this.mTabAdapter.getItem(i).setSignCount(i2);
        notifyDataChanged();
    }

    public void clearSignCountView(int i) {
        this.mTabAdapter.getItem(i).clearSignCountOrRedPoint();
        notifyDataChanged();
    }

    public int getSignCount(int i) {
        return this.mTabAdapter.getItem(i).getSignCount();
    }

    public boolean isRedPointShowing(int i) {
        return this.mTabAdapter.getItem(i).isRedPointShowing();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mCurrentSelectedIndex == -1 || this.mMode != 0) {
            return;
        }
        com.up366.qmui.widget.tab.QMUITabView qMUITabView = this.mTabAdapter.getViews().get(this.mCurrentSelectedIndex);
        if (getScrollX() > qMUITabView.getLeft()) {
            scrollTo(qMUITabView.getLeft(), 0);
            return;
        }
        int width = (getWidth() - getPaddingRight()) - getPaddingLeft();
        if (getScrollX() + width < qMUITabView.getRight()) {
            scrollBy((qMUITabView.getRight() - width) - getScrollX(), 0);
        }
    }

    private final class Container extends android.view.ViewGroup {
        public Container(android.content.Context context) {
            super(context);
            setClipChildren(false);
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            int size = android.view.View.MeasureSpec.getSize(i);
            int size2 = android.view.View.MeasureSpec.getSize(i2);
            java.util.List<com.up366.qmui.widget.tab.QMUITabView> views = com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mTabAdapter.getViews();
            int size3 = views.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size3; i4++) {
                if (views.get(i4).getVisibility() == 0) {
                    i3++;
                }
            }
            if (size3 == 0 || i3 == 0) {
                setMeasuredDimension(size, size2);
                return;
            }
            int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            if (com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mMode != 1) {
                int measuredWidth = 0;
                float f = 0.0f;
                for (int i5 = 0; i5 < size3; i5++) {
                    com.up366.qmui.widget.tab.QMUITabView qMUITabView = views.get(i5);
                    if (qMUITabView.getVisibility() == 0) {
                        qMUITabView.measure(android.view.View.MeasureSpec.makeMeasureSpec(size, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER), android.view.View.MeasureSpec.makeMeasureSpec(paddingTop, com.up366.medialibrary.common.utils.PictureFileUtils.GB));
                        measuredWidth += qMUITabView.getMeasuredWidth() + com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mItemSpaceInScrollMode;
                        com.up366.qmui.widget.tab.QMUITab item = com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mTabAdapter.getItem(i5);
                        f += item.leftSpaceWeight + item.rightSpaceWeight;
                        item.leftAddonMargin = 0;
                        item.rightAddonMargin = 0;
                    }
                }
                int i6 = measuredWidth - com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mItemSpaceInScrollMode;
                if (f <= 0.0f || i6 >= size) {
                    size = i6;
                } else {
                    int i7 = size - i6;
                    for (int i8 = 0; i8 < size3; i8++) {
                        if (views.get(i8).getVisibility() == 0) {
                            com.up366.qmui.widget.tab.QMUITab item2 = com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mTabAdapter.getItem(i8);
                            float f2 = i7;
                            item2.leftAddonMargin = (int) ((item2.leftSpaceWeight * f2) / f);
                            item2.rightAddonMargin = (int) ((f2 * item2.rightSpaceWeight) / f);
                        }
                    }
                }
            } else {
                int i9 = size / i3;
                for (int i10 = 0; i10 < size3; i10++) {
                    com.up366.qmui.widget.tab.QMUITabView qMUITabView2 = views.get(i10);
                    if (qMUITabView2.getVisibility() == 0) {
                        qMUITabView2.measure(android.view.View.MeasureSpec.makeMeasureSpec(i9, com.up366.medialibrary.common.utils.PictureFileUtils.GB), android.view.View.MeasureSpec.makeMeasureSpec(paddingTop, com.up366.medialibrary.common.utils.PictureFileUtils.GB));
                        com.up366.qmui.widget.tab.QMUITab item3 = com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mTabAdapter.getItem(i10);
                        item3.leftAddonMargin = 0;
                        item3.rightAddonMargin = 0;
                    }
                }
            }
            setMeasuredDimension(size, size2);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            java.util.List<com.up366.qmui.widget.tab.QMUITabView> views = com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mTabAdapter.getViews();
            int size = views.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                if (views.get(i6).getVisibility() == 0) {
                    i5++;
                }
            }
            if (size == 0 || i5 == 0) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            for (int i7 = 0; i7 < size; i7++) {
                com.up366.qmui.widget.tab.QMUITabView qMUITabView = views.get(i7);
                if (qMUITabView.getVisibility() == 0) {
                    int measuredWidth = qMUITabView.getMeasuredWidth();
                    com.up366.qmui.widget.tab.QMUITab item = com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mTabAdapter.getItem(i7);
                    int contentViewLeft = paddingLeft + item.leftAddonMargin;
                    int i8 = contentViewLeft + measuredWidth;
                    qMUITabView.layout(contentViewLeft, getPaddingTop(), i8, (i4 - i2) - getPaddingBottom());
                    int i9 = item.contentLeft;
                    int i10 = item.contentWidth;
                    if (com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mMode == 1 && com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mIndicator != null && com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mIndicator.isIndicatorWidthFollowContent()) {
                        contentViewLeft += qMUITabView.getContentViewLeft();
                        measuredWidth = qMUITabView.getContentViewWidth();
                    }
                    if (i9 != contentViewLeft || i10 != measuredWidth) {
                        item.contentLeft = contentViewLeft;
                        item.contentWidth = measuredWidth;
                    }
                    paddingLeft = i8 + item.rightAddonMargin + (com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mMode == 0 ? com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mItemSpaceInScrollMode : 0);
                }
            }
            if (com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mCurrentSelectedIndex == -1 || com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mSelectAnimator != null || com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.needPreventEvent()) {
                return;
            }
            com.up366.qmui.widget.tab.QMUIBasicTabSegment qMUIBasicTabSegment = com.up366.qmui.widget.tab.QMUIBasicTabSegment.this;
            qMUIBasicTabSegment.layoutIndicator(qMUIBasicTabSegment.mTabAdapter.getItem(com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mCurrentSelectedIndex), true);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(android.graphics.Canvas canvas) {
            super.dispatchDraw(canvas);
            if (com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mIndicator != null) {
                if (!com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mHideIndicatorWhenTabCountLessTwo || com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mTabAdapter.getSize() > 1) {
                    com.up366.qmui.widget.tab.QMUIBasicTabSegment.this.mIndicator.draw(this, canvas, getPaddingTop(), getHeight() - getPaddingBottom());
                }
            }
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
    public void setHideRadiusSide(int i) {
        this.mLayoutHelper.setHideRadiusSide(i);
    }

    @Override // com.up366.qmui.layout.IQMUILayout
    public int getHideRadiusSide() {
        return this.mLayoutHelper.getHideRadiusSide();
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
    public float getShadowAlpha() {
        return this.mLayoutHelper.getShadowAlpha();
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

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        this.mLayoutHelper.drawDividers(canvas, getWidth(), getHeight());
        this.mLayoutHelper.dispatchRoundBorderDraw(canvas);
        super.onDraw(canvas);
    }

    @Override // com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
    public androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> getDefaultSkinAttrs() {
        return sDefaultSkinAttrs;
    }

    @Override // com.up366.qmui.skin.IQMUISkinHandlerView
    public void handle(com.up366.qmui.skin.QMUISkinManager qMUISkinManager, int i, android.content.res.Resources.Theme theme, androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> simpleArrayMap) {
        qMUISkinManager.defaultHandleSkinAttrs(this, theme, simpleArrayMap);
        com.up366.qmui.widget.tab.QMUITabIndicator qMUITabIndicator = this.mIndicator;
        if (qMUITabIndicator != null) {
            qMUITabIndicator.handleSkinChange(qMUISkinManager, i, theme, this.mTabAdapter.getItem(this.mCurrentSelectedIndex));
            this.mContentLayout.invalidate();
        }
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
