package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ActivityLearnTrailBindingImpl extends com.up366.mobile.databinding.ActivityLearnTrailBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.app_bar, 1);
        sparseIntArray.put(com.up366.mobile.R.id.toolbar_layout, 2);
        sparseIntArray.put(com.up366.mobile.R.id.toolbar, 3);
        sparseIntArray.put(com.up366.mobile.R.id.iv_toolbar_bg, 4);
        sparseIntArray.put(com.up366.mobile.R.id.bt_filter_by_time, 5);
        sparseIntArray.put(com.up366.mobile.R.id.tbv_trail_back, 6);
        sparseIntArray.put(com.up366.mobile.R.id.pull_refresh, 7);
        sparseIntArray.put(com.up366.mobile.R.id.ll_trend, 8);
        sparseIntArray.put(com.up366.mobile.R.id.trend_score_ratio, 9);
        sparseIntArray.put(com.up366.mobile.R.id.trend_homework_complete, 10);
    }

    public ActivityLearnTrailBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ActivityLearnTrailBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.google.android.material.appbar.AppBarLayout) objArr[1], (android.widget.Button) objArr[5], (android.widget.ImageView) objArr[4], (android.widget.LinearLayout) objArr[8], (com.ylw.pullrefreshlibrary.PullRefreshLayout) objArr[7], (com.up366.mobile.common.views.TitleBackView) objArr[6], (androidx.appcompat.widget.Toolbar) objArr[3], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[2], (com.up366.mobile.common.views.TrendView) objArr[10], (com.up366.mobile.common.views.TrendView) objArr[9]);
        this.mDirtyFlags = -1L;
        androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout = (androidx.coordinatorlayout.widget.CoordinatorLayout) objArr[0];
        this.mboundView0 = coordinatorLayout;
        coordinatorLayout.setTag((java.lang.Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
