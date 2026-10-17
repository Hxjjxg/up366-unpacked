package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CourseMainFragmentLayoutBindingImpl extends com.up366.mobile.databinding.CourseMainFragmentLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.message_toolbar, 4);
        sparseIntArray.put(com.up366.mobile.R.id.ll_title, 5);
        sparseIntArray.put(2131363459, 6);
        sparseIntArray.put(com.up366.mobile.R.id.iv_private_cloud_state, 7);
        sparseIntArray.put(2131362830, 8);
        sparseIntArray.put(com.up366.mobile.R.id.title_no, 9);
        sparseIntArray.put(com.up366.mobile.R.id.refresh_layout, 10);
        sparseIntArray.put(com.up366.mobile.R.id.recycle_view, 11);
    }

    public CourseMainFragmentLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private CourseMainFragmentLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.google.android.material.appbar.AppBarLayout) objArr[1], (android.widget.ImageView) objArr[7], (android.widget.LinearLayout) objArr[5], (com.up366.mobile.common.views.TitleMessageView) objArr[8], (com.up366.mobile.common.views.TitleMessageView) objArr[4], (androidx.recyclerview.widget.RecyclerView) objArr[11], (com.ylw.pullrefreshlibrary.PullRefreshLayout) objArr[10], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[9], (androidx.appcompat.widget.Toolbar) objArr[3], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[2]);
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
