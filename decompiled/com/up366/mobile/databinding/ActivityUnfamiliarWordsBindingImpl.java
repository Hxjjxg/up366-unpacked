package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ActivityUnfamiliarWordsBindingImpl extends com.up366.mobile.databinding.ActivityUnfamiliarWordsBinding {
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
        sparseIntArray.put(2131363459, 4);
        sparseIntArray.put(com.up366.mobile.R.id.ll_select_class, 5);
        sparseIntArray.put(com.up366.mobile.R.id.ibTip, 6);
        sparseIntArray.put(com.up366.mobile.R.id.ib_ranking_list, 7);
        sparseIntArray.put(com.up366.mobile.R.id.selectBtn, 8);
        sparseIntArray.put(com.up366.mobile.R.id.tbv_trail_back, 9);
        sparseIntArray.put(com.up366.mobile.R.id.refresh_layout, 10);
        sparseIntArray.put(com.up366.mobile.R.id.recycle_view, 11);
        sparseIntArray.put(com.up366.mobile.R.id.bottom_view, 12);
        sparseIntArray.put(com.up366.mobile.R.id.bottom_view_read_word, 13);
        sparseIntArray.put(com.up366.mobile.R.id.bottom_view_select_word, 14);
    }

    public ActivityUnfamiliarWordsBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private ActivityUnfamiliarWordsBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.google.android.material.appbar.AppBarLayout) objArr[1], (android.widget.LinearLayout) objArr[12], (com.up366.mobile.common.views.BlueButtonBottomView) objArr[13], (com.up366.mobile.common.views.BlueButtonBottomView) objArr[14], (android.widget.ImageButton) objArr[7], (android.widget.ImageButton) objArr[6], (android.widget.LinearLayout) objArr[5], (androidx.recyclerview.widget.RecyclerView) objArr[11], (com.ylw.pullrefreshlibrary.PullRefreshLayout) objArr[10], (android.widget.CheckedTextView) objArr[8], (com.up366.mobile.common.views.TitleBackView) objArr[9], (com.up366.mobile.common.views.MarqueeTextView) objArr[4], (androidx.appcompat.widget.Toolbar) objArr[3], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[2]);
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
