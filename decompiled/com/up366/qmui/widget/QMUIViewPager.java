package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIViewPager extends androidx.viewpager.widget.ViewPager implements com.up366.qmui.widget.IWindowInsetLayout {
    private static final int DEFAULT_INFINITE_RATIO = 100;
    private boolean mEnableLoop;
    private int mInfiniteRatio;
    private boolean mIsInMeasure;
    private boolean mIsSwipeable;
    private com.up366.qmui.util.QMUIWindowInsetHelper mQMUIWindowInsetHelper;

    public QMUIViewPager(android.content.Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QMUIViewPager(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsSwipeable = true;
        this.mIsInMeasure = false;
        this.mEnableLoop = false;
        this.mInfiniteRatio = 100;
        this.mQMUIWindowInsetHelper = new com.up366.qmui.util.QMUIWindowInsetHelper(this, this);
    }

    public void setSwipeable(boolean z) {
        this.mIsSwipeable = z;
    }

    public int getInfiniteRatio() {
        return this.mInfiniteRatio;
    }

    public void setInfiniteRatio(int i) {
        this.mInfiniteRatio = i;
    }

    public boolean isEnableLoop() {
        return this.mEnableLoop;
    }

    public void setEnableLoop(boolean z) {
        if (this.mEnableLoop != z) {
            this.mEnableLoop = z;
            if (getAdapter() != null) {
                getAdapter().notifyDataSetChanged();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addView(android.view.View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        androidx.core.view.ViewCompat.requestApplyInsets(this);
    }

    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return this.mIsSwipeable && super.onTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        return this.mIsSwipeable && super.onInterceptTouchEvent(motionEvent);
    }

    protected void onMeasure(int i, int i2) {
        this.mIsInMeasure = true;
        super.onMeasure(i, i2);
        this.mIsInMeasure = false;
    }

    public boolean isInMeasure() {
        return this.mIsInMeasure;
    }

    protected boolean fitSystemWindows(android.graphics.Rect rect) {
        return super.fitSystemWindows(rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.qmui.widget.IWindowInsetLayout
    public boolean applySystemWindowInsets19(android.graphics.Rect rect) {
        return this.mQMUIWindowInsetHelper.defaultApplySystemWindowInsets19(this, rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.qmui.widget.IWindowInsetLayout
    public boolean applySystemWindowInsets21(java.lang.Object obj) {
        return this.mQMUIWindowInsetHelper.defaultApplySystemWindowInsets21(this, obj);
    }

    public void setAdapter(androidx.viewpager.widget.PagerAdapter pagerAdapter) {
        if (pagerAdapter instanceof com.up366.qmui.widget.QMUIPagerAdapter) {
            super.setAdapter(new com.up366.qmui.widget.QMUIViewPager.WrapperPagerAdapter((com.up366.qmui.widget.QMUIPagerAdapter) pagerAdapter));
        } else {
            super.setAdapter(pagerAdapter);
        }
    }

    class WrapperPagerAdapter extends androidx.viewpager.widget.PagerAdapter {
        private com.up366.qmui.widget.QMUIPagerAdapter mAdapter;

        public WrapperPagerAdapter(com.up366.qmui.widget.QMUIPagerAdapter qMUIPagerAdapter) {
            this.mAdapter = qMUIPagerAdapter;
        }

        public int getCount() {
            int count = this.mAdapter.getCount();
            return (!com.up366.qmui.widget.QMUIViewPager.this.mEnableLoop || count <= 3) ? count : count * com.up366.qmui.widget.QMUIViewPager.this.mInfiniteRatio;
        }

        public java.lang.Object instantiateItem(android.view.ViewGroup viewGroup, int i) {
            if (com.up366.qmui.widget.QMUIViewPager.this.mEnableLoop && this.mAdapter.getCount() != 0) {
                i %= this.mAdapter.getCount();
            }
            return this.mAdapter.instantiateItem(viewGroup, i);
        }

        public void destroyItem(android.view.ViewGroup viewGroup, int i, java.lang.Object obj) {
            if (com.up366.qmui.widget.QMUIViewPager.this.mEnableLoop && this.mAdapter.getCount() != 0) {
                i %= this.mAdapter.getCount();
            }
            this.mAdapter.destroyItem(viewGroup, i, obj);
        }

        public boolean isViewFromObject(android.view.View view, java.lang.Object obj) {
            return this.mAdapter.isViewFromObject(view, obj);
        }

        public void restoreState(android.os.Parcelable parcelable, java.lang.ClassLoader classLoader) {
            this.mAdapter.restoreState(parcelable, classLoader);
        }

        public android.os.Parcelable saveState() {
            return this.mAdapter.saveState();
        }

        public void startUpdate(android.view.ViewGroup viewGroup) {
            this.mAdapter.startUpdate(viewGroup);
        }

        public void finishUpdate(android.view.ViewGroup viewGroup) {
            this.mAdapter.finishUpdate(viewGroup);
        }

        public java.lang.CharSequence getPageTitle(int i) {
            return this.mAdapter.getPageTitle(i % this.mAdapter.getCount());
        }

        public float getPageWidth(int i) {
            return this.mAdapter.getPageWidth(i);
        }

        public void setPrimaryItem(android.view.ViewGroup viewGroup, int i, java.lang.Object obj) {
            this.mAdapter.setPrimaryItem(viewGroup, i, obj);
        }

        public void unregisterDataSetObserver(android.database.DataSetObserver dataSetObserver) {
            this.mAdapter.unregisterDataSetObserver(dataSetObserver);
        }

        public void registerDataSetObserver(android.database.DataSetObserver dataSetObserver) {
            this.mAdapter.registerDataSetObserver(dataSetObserver);
        }

        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            this.mAdapter.notifyDataSetChanged();
        }

        public int getItemPosition(java.lang.Object obj) {
            return this.mAdapter.getItemPosition(obj);
        }
    }
}
