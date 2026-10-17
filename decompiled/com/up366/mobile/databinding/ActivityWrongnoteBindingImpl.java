package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ActivityWrongnoteBindingImpl extends com.up366.mobile.databinding.ActivityWrongnoteBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.ib_ranking_list, 3);
        sparseIntArray.put(com.up366.mobile.R.id.tbv_trail_back, 4);
        sparseIntArray.put(com.up366.mobile.R.id.qm_tab_layout, 5);
        sparseIntArray.put(com.up366.mobile.R.id.view_pager, 6);
        sparseIntArray.put(com.up366.mobile.R.id.emptyView, 7);
        sparseIntArray.put(com.up366.mobile.R.id.iv_empty_state_tipimg, 8);
        sparseIntArray.put(com.up366.mobile.R.id.tv_empty_view_tip, 9);
        sparseIntArray.put(com.up366.mobile.R.id.bottomView, 10);
    }

    public ActivityWrongnoteBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ActivityWrongnoteBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.google.android.material.appbar.AppBarLayout) objArr[1], (com.up366.mobile.common.views.BlueButtonBottomView) objArr[10], (androidx.constraintlayout.widget.ConstraintLayout) objArr[7], (android.widget.ImageButton) objArr[3], (android.widget.ImageView) objArr[8], (com.up366.qmui.widget.tab.QMUITabSegment) objArr[5], (com.up366.mobile.common.views.TitleBackView) objArr[4], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[2], (android.widget.TextView) objArr[9], (androidx.viewpager.widget.ViewPager) objArr[6]);
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
