package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ActivityUpdatePhonePasswordLayoutBindingImpl extends com.up366.mobile.databinding.ActivityUpdatePhonePasswordLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.title_back, 3);
        sparseIntArray.put(com.up366.mobile.R.id.title_close, 4);
        sparseIntArray.put(2131362178, 5);
        sparseIntArray.put(com.up366.mobile.R.id.tip, 6);
        sparseIntArray.put(com.up366.mobile.R.id.mobile, 7);
        sparseIntArray.put(com.up366.mobile.R.id.error_tip, 8);
        sparseIntArray.put(com.up366.mobile.R.id.captcha, 9);
        sparseIntArray.put(com.up366.mobile.R.id.password, 10);
        sparseIntArray.put(com.up366.mobile.R.id.error_tip_password, 11);
        sparseIntArray.put(com.up366.mobile.R.id.password_again, 12);
        sparseIntArray.put(com.up366.mobile.R.id.error_tip_again_password, 13);
        sparseIntArray.put(com.up366.mobile.R.id.btn_submit, 14);
        sparseIntArray.put(com.up366.mobile.R.id.btn_no_code, 15);
    }

    public ActivityUpdatePhonePasswordLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private ActivityUpdatePhonePasswordLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.google.android.material.appbar.AppBarLayout) objArr[1], (android.widget.TextView) objArr[15], (android.widget.Button) objArr[14], (com.up366.mobile.common.views.AppEditTextView) objArr[9], (androidx.core.widget.NestedScrollView) objArr[5], (android.widget.TextView) objArr[8], (android.widget.TextView) objArr[13], (android.widget.TextView) objArr[11], (com.up366.mobile.common.views.AppEditTextView) objArr[7], (com.up366.mobile.common.views.AppEditTextView) objArr[10], (com.up366.mobile.common.views.AppEditTextView) objArr[12], (android.widget.TextView) objArr[6], (com.up366.mobile.common.views.TitleBackView) objArr[3], (com.up366.mobile.common.views.TitleCloseGroupView) objArr[4], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[2]);
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
