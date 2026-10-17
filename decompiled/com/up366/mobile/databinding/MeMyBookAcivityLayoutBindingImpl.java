package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeMyBookAcivityLayoutBindingImpl extends com.up366.mobile.databinding.MeMyBookAcivityLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.search_icon, 4);
        sparseIntArray.put(com.up366.mobile.R.id.me_my_book_selector, 5);
        sparseIntArray.put(com.up366.mobile.R.id.pull_refresh_layout, 6);
        sparseIntArray.put(com.up366.mobile.R.id.recycleView, 7);
    }

    public MeMyBookAcivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private MeMyBookAcivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.google.android.material.appbar.AppBarLayout) objArr[1], (android.widget.TextView) objArr[5], (com.ylw.pullrefreshlibrary.PullRefreshLayout) objArr[6], (androidx.recyclerview.widget.RecyclerView) objArr[7], (android.widget.ImageView) objArr[4], (androidx.appcompat.widget.Toolbar) objArr[3], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[2]);
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
