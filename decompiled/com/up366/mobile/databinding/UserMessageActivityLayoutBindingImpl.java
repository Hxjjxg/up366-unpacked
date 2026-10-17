package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class UserMessageActivityLayoutBindingImpl extends com.up366.mobile.databinding.UserMessageActivityLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.iv_msg_unread, 3);
        sparseIntArray.put(com.up366.mobile.R.id.tv_msg_unread_number, 4);
        sparseIntArray.put(com.up366.mobile.R.id.tbv_trail_back, 5);
        sparseIntArray.put(com.up366.mobile.R.id.no_notification, 6);
        sparseIntArray.put(com.up366.mobile.R.id.refreshLayout, 7);
        sparseIntArray.put(com.up366.mobile.R.id.recycleView, 8);
    }

    public UserMessageActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private UserMessageActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.google.android.material.appbar.AppBarLayout) objArr[1], (android.widget.ImageView) objArr[3], (com.up366.mobile.common.views.NoNotificationPermissionView) objArr[6], (androidx.recyclerview.widget.RecyclerView) objArr[8], (com.ylw.pullrefreshlibrary.PullRefreshLayout) objArr[7], (com.up366.mobile.common.views.TitleBackView) objArr[5], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[2], (android.widget.TextView) objArr[4]);
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
