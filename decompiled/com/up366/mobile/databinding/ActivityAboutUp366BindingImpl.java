package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ActivityAboutUp366BindingImpl extends com.up366.mobile.databinding.ActivityAboutUp366Binding {
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
        sparseIntArray.put(com.up366.mobile.R.id.tbv_trail_back, 3);
        sparseIntArray.put(com.up366.mobile.R.id.host, 4);
        sparseIntArray.put(com.up366.mobile.R.id.iv_up366_head, 5);
        sparseIntArray.put(com.up366.mobile.R.id.tv_up366_name, 6);
        sparseIntArray.put(com.up366.mobile.R.id.tv_current_version, 7);
        sparseIntArray.put(com.up366.mobile.R.id.check_version, 8);
        sparseIntArray.put(com.up366.mobile.R.id.add_praise, 9);
        sparseIntArray.put(com.up366.mobile.R.id.content_ext_decrypt_test, 10);
        sparseIntArray.put(com.up366.mobile.R.id.icp, 11);
        sparseIntArray.put(com.up366.mobile.R.id.tv_copy_right, 12);
    }

    public ActivityAboutUp366BindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private ActivityAboutUp366BindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.up366.mobile.common.views.SettingItemView) objArr[9], (com.google.android.material.appbar.AppBarLayout) objArr[1], (com.up366.mobile.common.views.SettingItemView) objArr[8], (com.up366.mobile.common.views.SettingItemView) objArr[10], (android.widget.TextView) objArr[4], (android.widget.TextView) objArr[11], (android.widget.ImageView) objArr[5], (com.up366.mobile.common.views.TitleBackView) objArr[3], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[2], (android.widget.TextView) objArr[12], (android.widget.TextView) objArr[7], (android.widget.TextView) objArr[6]);
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
