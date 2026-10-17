package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ChangeMobileDialogBindingImpl extends com.up366.mobile.databinding.ChangeMobileDialogBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363459, 1);
        sparseIntArray.put(com.up366.mobile.R.id.account_info, 2);
        sparseIntArray.put(com.up366.mobile.R.id.account_info_title, 3);
        sparseIntArray.put(com.up366.mobile.R.id.account_label, 4);
        sparseIntArray.put(com.up366.mobile.R.id.account_value, 5);
        sparseIntArray.put(com.up366.mobile.R.id.realname_label, 6);
        sparseIntArray.put(com.up366.mobile.R.id.realname_value, 7);
        sparseIntArray.put(com.up366.mobile.R.id.school_label, 8);
        sparseIntArray.put(com.up366.mobile.R.id.school_value, 9);
        sparseIntArray.put(com.up366.mobile.R.id.mobile_label, 10);
        sparseIntArray.put(com.up366.mobile.R.id.mobile_value, 11);
        sparseIntArray.put(com.up366.mobile.R.id.account_info1, 12);
        sparseIntArray.put(com.up366.mobile.R.id.account_info_title1, 13);
        sparseIntArray.put(com.up366.mobile.R.id.account_label1, 14);
        sparseIntArray.put(com.up366.mobile.R.id.account_value1, 15);
        sparseIntArray.put(com.up366.mobile.R.id.realname_label1, 16);
        sparseIntArray.put(com.up366.mobile.R.id.realname_value1, 17);
        sparseIntArray.put(com.up366.mobile.R.id.school_label1, 18);
        sparseIntArray.put(com.up366.mobile.R.id.school_value1, 19);
        sparseIntArray.put(com.up366.mobile.R.id.mobile_label1, 20);
        sparseIntArray.put(com.up366.mobile.R.id.mobile_value1, 21);
        sparseIntArray.put(com.up366.mobile.R.id.btn_cancel, 22);
        sparseIntArray.put(com.up366.mobile.R.id.btn_confirm_change, 23);
    }

    public ChangeMobileDialogBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 24, sIncludes, sViewsWithIds));
    }

    private ChangeMobileDialogBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (androidx.constraintlayout.widget.ConstraintLayout) objArr[2], (androidx.constraintlayout.widget.ConstraintLayout) objArr[12], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[13], (android.widget.TextView) objArr[4], (android.widget.TextView) objArr[14], (android.widget.TextView) objArr[5], (android.widget.TextView) objArr[15], (android.widget.TextView) objArr[22], (android.widget.TextView) objArr[23], (android.widget.TextView) objArr[10], (android.widget.TextView) objArr[20], (android.widget.TextView) objArr[11], (android.widget.TextView) objArr[21], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[16], (android.widget.TextView) objArr[7], (android.widget.TextView) objArr[17], (android.widget.TextView) objArr[8], (android.widget.TextView) objArr[18], (android.widget.TextView) objArr[9], (android.widget.TextView) objArr[19], (android.widget.TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((java.lang.Object) null);
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
