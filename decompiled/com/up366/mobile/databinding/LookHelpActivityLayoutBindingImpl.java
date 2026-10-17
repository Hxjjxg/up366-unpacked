package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class LookHelpActivityLayoutBindingImpl extends com.up366.mobile.databinding.LookHelpActivityLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.text1, 3);
        sparseIntArray.put(com.up366.mobile.R.id.look_help_dot1, 4);
        sparseIntArray.put(2131363385, 5);
        sparseIntArray.put(com.up366.mobile.R.id.look_help_dot2, 6);
        sparseIntArray.put(com.up366.mobile.R.id.text3, 7);
        sparseIntArray.put(com.up366.mobile.R.id.text4, 8);
        sparseIntArray.put(com.up366.mobile.R.id.text5, 9);
        sparseIntArray.put(com.up366.mobile.R.id.text6, 10);
        sparseIntArray.put(com.up366.mobile.R.id.text7, 11);
        sparseIntArray.put(com.up366.mobile.R.id.text8, 12);
        sparseIntArray.put(com.up366.mobile.R.id.text9, 13);
        sparseIntArray.put(com.up366.mobile.R.id.look_help_to_setting, 14);
    }

    public LookHelpActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private LookHelpActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.google.android.material.appbar.AppBarLayout) objArr[1], (android.view.View) objArr[4], (android.view.View) objArr[6], (android.widget.TextView) objArr[14], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[5], (android.widget.TextView) objArr[7], (android.widget.TextView) objArr[8], (android.widget.TextView) objArr[9], (android.widget.TextView) objArr[10], (android.widget.TextView) objArr[11], (android.widget.TextView) objArr[12], (android.widget.TextView) objArr[13], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[2]);
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
