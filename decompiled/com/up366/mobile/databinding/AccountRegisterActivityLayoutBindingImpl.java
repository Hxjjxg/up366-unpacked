package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AccountRegisterActivityLayoutBindingImpl extends com.up366.mobile.databinding.AccountRegisterActivityLayoutBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final androidx.appcompat.widget.LinearLayoutCompat mboundView0;

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
        sparseIntArray.put(com.up366.mobile.R.id.pager, 3);
        sparseIntArray.put(2131362178, 4);
        sparseIntArray.put(com.up366.mobile.R.id.btn_no_code, 5);
    }

    public AccountRegisterActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private AccountRegisterActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.google.android.material.appbar.AppBarLayout) objArr[1], (android.widget.TextView) objArr[5], (androidx.core.widget.NestedScrollView) objArr[4], (android.widget.TextView) objArr[3], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[2]);
        this.mDirtyFlags = -1L;
        androidx.appcompat.widget.LinearLayoutCompat linearLayoutCompat = (androidx.appcompat.widget.LinearLayoutCompat) objArr[0];
        this.mboundView0 = linearLayoutCompat;
        linearLayoutCompat.setTag((java.lang.Object) null);
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
