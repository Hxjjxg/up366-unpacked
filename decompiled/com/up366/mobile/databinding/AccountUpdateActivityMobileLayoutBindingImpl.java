package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AccountUpdateActivityMobileLayoutBindingImpl extends com.up366.mobile.databinding.AccountUpdateActivityMobileLayoutBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.current_mobile, 1);
        sparseIntArray.put(com.up366.mobile.R.id.unbind_mobile, 2);
        sparseIntArray.put(com.up366.mobile.R.id.mobile, 3);
        sparseIntArray.put(com.up366.mobile.R.id.error_tip, 4);
        sparseIntArray.put(com.up366.mobile.R.id.captcha, 5);
        sparseIntArray.put(com.up366.mobile.R.id.btn_change, 6);
        sparseIntArray.put(com.up366.mobile.R.id.btn_no_code, 7);
    }

    public AccountUpdateActivityMobileLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private AccountUpdateActivityMobileLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.Button) objArr[6], (android.widget.TextView) objArr[7], (com.up366.mobile.common.views.AppEditTextView) objArr[5], (android.widget.TextView) objArr[1], (android.widget.TextView) objArr[4], (com.up366.mobile.common.views.AppEditTextView) objArr[3], (androidx.constraintlayout.widget.ConstraintLayout) objArr[0], (android.widget.TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.root.setTag((java.lang.Object) null);
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
