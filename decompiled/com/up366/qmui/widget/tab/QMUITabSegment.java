package com.up366.qmui.widget.tab;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUITabSegment extends com.up366.qmui.widget.tab.QMUIBasicTabSegment {
    private static final java.lang.String TAG = "QMUITabSegment";
    private com.up366.qmui.widget.tab.QMUITabSegment.AdapterChangeListener mAdapterChangeListener;
    private androidx.viewpager.widget.ViewPager.OnPageChangeListener mOnPageChangeListener;
    private androidx.viewpager.widget.PagerAdapter mPagerAdapter;
    private android.database.DataSetObserver mPagerAdapterObserver;
    private androidx.viewpager.widget.ViewPager mViewPager;
    private int mViewPagerScrollState;
    private com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener mViewPagerSelectedListener;

    public QMUITabSegment(android.content.Context context) {
        super(context);
        this.mViewPagerScrollState = 0;
    }

    public QMUITabSegment(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mViewPagerScrollState = 0;
    }

    public QMUITabSegment(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mViewPagerScrollState = 0;
    }

    @Override // com.up366.qmui.widget.tab.QMUIBasicTabSegment
    protected boolean needPreventEvent() {
        return this.mViewPagerScrollState != 0;
    }

    @Override // com.up366.qmui.widget.tab.QMUIBasicTabSegment
    public void notifyDataChanged() {
        super.notifyDataChanged();
        populateFromPagerAdapter(false);
    }

    public void setupWithViewPager(androidx.viewpager.widget.ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    public void setupWithViewPager(androidx.viewpager.widget.ViewPager viewPager, boolean z) {
        setupWithViewPager(viewPager, z, true);
    }

    public void setupWithViewPager(androidx.viewpager.widget.ViewPager viewPager, boolean z, boolean z2) {
        androidx.viewpager.widget.ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 != null) {
            androidx.viewpager.widget.ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
            if (onPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(onPageChangeListener);
            }
            com.up366.qmui.widget.tab.QMUITabSegment.AdapterChangeListener adapterChangeListener = this.mAdapterChangeListener;
            if (adapterChangeListener != null) {
                this.mViewPager.removeOnAdapterChangeListener(adapterChangeListener);
            }
        }
        com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener onTabSelectedListener = this.mViewPagerSelectedListener;
        if (onTabSelectedListener != null) {
            removeOnTabSelectedListener(onTabSelectedListener);
            this.mViewPagerSelectedListener = null;
        }
        if (viewPager != null) {
            this.mViewPager = viewPager;
            if (this.mOnPageChangeListener == null) {
                this.mOnPageChangeListener = new com.up366.qmui.widget.tab.QMUITabSegment.TabLayoutOnPageChangeListener(this);
            }
            viewPager.addOnPageChangeListener(this.mOnPageChangeListener);
            com.up366.qmui.widget.tab.QMUITabSegment.ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new com.up366.qmui.widget.tab.QMUITabSegment.ViewPagerOnTabSelectedListener(viewPager);
            this.mViewPagerSelectedListener = viewPagerOnTabSelectedListener;
            addOnTabSelectedListener(viewPagerOnTabSelectedListener);
            androidx.viewpager.widget.PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z, z2);
            }
            if (this.mAdapterChangeListener == null) {
                this.mAdapterChangeListener = new com.up366.qmui.widget.tab.QMUITabSegment.AdapterChangeListener(z);
            }
            this.mAdapterChangeListener.setAutoRefresh(z2);
            viewPager.addOnAdapterChangeListener(this.mAdapterChangeListener);
            return;
        }
        this.mViewPager = null;
        setPagerAdapter(null, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewPagerScrollState(int i) {
        this.mViewPagerScrollState = i;
        if (i == 0 && this.mPendingSelectedIndex != -1 && this.mSelectAnimator == null) {
            selectTab(this.mPendingSelectedIndex, true, false);
            this.mPendingSelectedIndex = -1;
        }
    }

    void populateFromPagerAdapter(boolean z) {
        androidx.viewpager.widget.PagerAdapter pagerAdapter = this.mPagerAdapter;
        if (pagerAdapter == null) {
            if (z) {
                reset();
                return;
            }
            return;
        }
        int count = pagerAdapter.getCount();
        if (z) {
            reset();
            for (int i = 0; i < count; i++) {
                addTab(this.mTabBuilder.setText(this.mPagerAdapter.getPageTitle(i)).build(getContext()));
            }
            super.notifyDataChanged();
        }
        androidx.viewpager.widget.ViewPager viewPager = this.mViewPager;
        if (viewPager == null || count <= 0) {
            return;
        }
        selectTab(viewPager.getCurrentItem(), true, false);
    }

    void setPagerAdapter(androidx.viewpager.widget.PagerAdapter pagerAdapter, boolean z, boolean z2) {
        android.database.DataSetObserver dataSetObserver;
        androidx.viewpager.widget.PagerAdapter pagerAdapter2 = this.mPagerAdapter;
        if (pagerAdapter2 != null && (dataSetObserver = this.mPagerAdapterObserver) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.mPagerAdapter = pagerAdapter;
        if (z2 && pagerAdapter != null) {
            if (this.mPagerAdapterObserver == null) {
                this.mPagerAdapterObserver = new com.up366.qmui.widget.tab.QMUITabSegment.PagerAdapterObserver(z);
            }
            pagerAdapter.registerDataSetObserver(this.mPagerAdapterObserver);
        }
        populateFromPagerAdapter(z);
    }

    public static class TabLayoutOnPageChangeListener implements androidx.viewpager.widget.ViewPager.OnPageChangeListener {
        private final java.lang.ref.WeakReference<com.up366.qmui.widget.tab.QMUITabSegment> mTabSegmentRef;

        public TabLayoutOnPageChangeListener(com.up366.qmui.widget.tab.QMUITabSegment qMUITabSegment) {
            this.mTabSegmentRef = new java.lang.ref.WeakReference<>(qMUITabSegment);
        }

        public void onPageScrollStateChanged(int i) {
            com.up366.qmui.widget.tab.QMUITabSegment qMUITabSegment = this.mTabSegmentRef.get();
            if (qMUITabSegment != null) {
                qMUITabSegment.setViewPagerScrollState(i);
            }
        }

        public void onPageScrolled(int i, float f, int i2) {
            com.up366.qmui.widget.tab.QMUITabSegment qMUITabSegment = this.mTabSegmentRef.get();
            if (qMUITabSegment != null) {
                qMUITabSegment.updateIndicatorPosition(i, f);
            }
        }

        public void onPageSelected(int i) {
            com.up366.qmui.widget.tab.QMUITabSegment qMUITabSegment = this.mTabSegmentRef.get();
            if (qMUITabSegment != null && qMUITabSegment.mPendingSelectedIndex != -1) {
                qMUITabSegment.mPendingSelectedIndex = i;
                return;
            }
            if (qMUITabSegment != null && qMUITabSegment.getSelectedIndex() != i && i < qMUITabSegment.getTabCount()) {
                qMUITabSegment.selectTab(i, true, false);
            }
            android.util.Log.i("tiansongtao", " selected = " + java.lang.System.currentTimeMillis() + "  position=" + i);
        }
    }

    private static class ViewPagerOnTabSelectedListener implements com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener {
        private final androidx.viewpager.widget.ViewPager mViewPager;

        @Override // com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
        public void onDoubleTap(int i) {
        }

        @Override // com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
        public void onTabReselected(int i) {
        }

        @Override // com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
        public void onTabUnselected(int i) {
        }

        public ViewPagerOnTabSelectedListener(androidx.viewpager.widget.ViewPager viewPager) {
            this.mViewPager = viewPager;
        }

        @Override // com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
        public void onTabSelected(int i) {
            this.mViewPager.setCurrentItem(i, false);
        }
    }

    private class AdapterChangeListener implements androidx.viewpager.widget.ViewPager.OnAdapterChangeListener {
        private boolean mAutoRefresh;
        private final boolean mUseAdapterTitle;

        AdapterChangeListener(boolean z) {
            this.mUseAdapterTitle = z;
        }

        public void onAdapterChanged(androidx.viewpager.widget.ViewPager viewPager, androidx.viewpager.widget.PagerAdapter pagerAdapter, androidx.viewpager.widget.PagerAdapter pagerAdapter2) {
            if (com.up366.qmui.widget.tab.QMUITabSegment.this.mViewPager == viewPager) {
                com.up366.qmui.widget.tab.QMUITabSegment.this.setPagerAdapter(pagerAdapter2, this.mUseAdapterTitle, this.mAutoRefresh);
            }
        }

        void setAutoRefresh(boolean z) {
            this.mAutoRefresh = z;
        }
    }

    private class PagerAdapterObserver extends android.database.DataSetObserver {
        private final boolean mUseAdapterTitle;

        PagerAdapterObserver(boolean z) {
            this.mUseAdapterTitle = z;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            com.up366.qmui.widget.tab.QMUITabSegment.this.populateFromPagerAdapter(this.mUseAdapterTitle);
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            com.up366.qmui.widget.tab.QMUITabSegment.this.populateFromPagerAdapter(this.mUseAdapterTitle);
        }
    }
}
