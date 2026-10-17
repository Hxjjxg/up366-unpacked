package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeUserInfoActivityLayoutBindingImpl extends com.up366.mobile.databinding.MeUserInfoActivityLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.me_photo, 3);
        sparseIntArray.put(com.up366.mobile.R.id.me_username, 4);
        sparseIntArray.put(com.up366.mobile.R.id.me_student_number, 5);
        sparseIntArray.put(com.up366.mobile.R.id.me_realname, 6);
        sparseIntArray.put(com.up366.mobile.R.id.me_school, 7);
        sparseIntArray.put(com.up366.mobile.R.id.me_classname, 8);
    }

    public MeUserInfoActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private MeUserInfoActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.google.android.material.appbar.AppBarLayout) objArr[1], (com.up366.mobile.me.views.UserInfoItemView) objArr[8], (com.up366.mobile.me.views.UserInfoItemView) objArr[3], (com.up366.mobile.me.views.UserInfoItemView) objArr[6], (com.up366.mobile.me.views.UserInfoItemView) objArr[7], (com.up366.mobile.me.views.UserInfoItemView) objArr[5], (com.up366.mobile.me.views.UserInfoItemView) objArr[4], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[2]);
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
