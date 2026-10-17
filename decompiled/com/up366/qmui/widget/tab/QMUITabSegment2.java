package com.up366.qmui.widget.tab;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUITabSegment2 extends com.up366.qmui.widget.tab.QMUIBasicTabSegment {
    private static final java.lang.String TAG = "QMUITabSegment";
    private androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback mOnPageChangeListener;
    private androidx.viewpager2.widget.ViewPager2 mViewPager;
    private int mViewPagerScrollState;
    private com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener mViewPagerSelectedListener;

    public QMUITabSegment2(android.content.Context context) {
        super(context);
        this.mViewPagerScrollState = 0;
    }

    public QMUITabSegment2(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mViewPagerScrollState = 0;
    }

    public QMUITabSegment2(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mViewPagerScrollState = 0;
    }

    @Override // com.up366.qmui.widget.tab.QMUIBasicTabSegment
    protected boolean needPreventEvent() {
        return this.mViewPagerScrollState != 0;
    }

    public void setupWithViewPager(androidx.viewpager2.widget.ViewPager2 viewPager2) {
        androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback onPageChangeCallback;
        androidx.viewpager2.widget.ViewPager2 viewPager22 = this.mViewPager;
        if (viewPager22 != null && (onPageChangeCallback = this.mOnPageChangeListener) != null) {
            viewPager22.unregisterOnPageChangeCallback(onPageChangeCallback);
        }
        com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener onTabSelectedListener = this.mViewPagerSelectedListener;
        if (onTabSelectedListener != null) {
            removeOnTabSelectedListener(onTabSelectedListener);
            this.mViewPagerSelectedListener = null;
        }
        if (viewPager2 != null) {
            this.mViewPager = viewPager2;
            if (this.mOnPageChangeListener == null) {
                this.mOnPageChangeListener = new com.up366.qmui.widget.tab.QMUITabSegment2.TabLayoutOnPageChangeListener(this);
            }
            viewPager2.registerOnPageChangeCallback(this.mOnPageChangeListener);
            com.up366.qmui.widget.tab.QMUITabSegment2.ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new com.up366.qmui.widget.tab.QMUITabSegment2.ViewPagerOnTabSelectedListener(viewPager2);
            this.mViewPagerSelectedListener = viewPagerOnTabSelectedListener;
            addOnTabSelectedListener(viewPagerOnTabSelectedListener);
            selectTab(this.mViewPager.getCurrentItem(), true, false);
            return;
        }
        this.mViewPager = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewPagerScrollState(int i) {
        this.mViewPagerScrollState = i;
        if (i == 0 && this.mPendingSelectedIndex != -1 && this.mSelectAnimator == null) {
            selectTab(this.mPendingSelectedIndex, true, false);
            this.mPendingSelectedIndex = -1;
        }
    }

    public static class TabLayoutOnPageChangeListener extends androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback {
        private final java.lang.ref.WeakReference<com.up366.qmui.widget.tab.QMUITabSegment2> mTabSegmentRef;

        public TabLayoutOnPageChangeListener(com.up366.qmui.widget.tab.QMUITabSegment2 qMUITabSegment2) {
            this.mTabSegmentRef = new java.lang.ref.WeakReference<>(qMUITabSegment2);
        }

        public void onPageScrollStateChanged(int i) {
            com.up366.qmui.widget.tab.QMUITabSegment2 qMUITabSegment2 = this.mTabSegmentRef.get();
            if (qMUITabSegment2 != null) {
                qMUITabSegment2.setViewPagerScrollState(i);
            }
        }

        public void onPageScrolled(int i, float f, int i2) {
            com.up366.qmui.widget.tab.QMUITabSegment2 qMUITabSegment2 = this.mTabSegmentRef.get();
            if (qMUITabSegment2 != null) {
                qMUITabSegment2.updateIndicatorPosition(i, f);
            }
        }

        public void onPageSelected(int i) {
            com.up366.qmui.widget.tab.QMUITabSegment2 qMUITabSegment2 = this.mTabSegmentRef.get();
            if (qMUITabSegment2 != null && qMUITabSegment2.mPendingSelectedIndex != -1) {
                qMUITabSegment2.mPendingSelectedIndex = i;
            } else {
                if (qMUITabSegment2 == null || qMUITabSegment2.getSelectedIndex() == i || i >= qMUITabSegment2.getTabCount()) {
                    return;
                }
                qMUITabSegment2.selectTab(i, true, false);
            }
        }
    }

    private static class ViewPagerOnTabSelectedListener implements com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener {
        private final androidx.viewpager2.widget.ViewPager2 mViewPager;

        @Override // com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
        public void onDoubleTap(int i) {
        }

        @Override // com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
        public void onTabReselected(int i) {
        }

        @Override // com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
        public void onTabUnselected(int i) {
        }

        public ViewPagerOnTabSelectedListener(androidx.viewpager2.widget.ViewPager2 viewPager2) {
            this.mViewPager = viewPager2;
        }

        @Override // com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
        public void onTabSelected(int i) {
            this.mViewPager.setCurrentItem(i, false);
        }
    }
}
