package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AccountRegisterActivityPageInputPasswordLayoutBindingImpl extends com.up366.mobile.databinding.AccountRegisterActivityPageInputPasswordLayoutBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final androidx.core.widget.NestedScrollView mboundView0;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.tip, 1);
        sparseIntArray.put(com.up366.mobile.R.id.password, 2);
        sparseIntArray.put(com.up366.mobile.R.id.error_tip_password, 3);
        sparseIntArray.put(com.up366.mobile.R.id.password_again, 4);
        sparseIntArray.put(com.up366.mobile.R.id.btn_register, 5);
    }

    public AccountRegisterActivityPageInputPasswordLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private AccountRegisterActivityPageInputPasswordLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.Button) objArr[5], (android.widget.TextView) objArr[3], (com.up366.mobile.common.views.AppEditTextView) objArr[2], (com.up366.mobile.common.views.AppEditTextView) objArr[4], (android.widget.TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        androidx.core.widget.NestedScrollView nestedScrollView = (androidx.core.widget.NestedScrollView) objArr[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag((java.lang.Object) null);
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
