package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class UserLogOffActivityLayoutBindingImpl extends com.up366.mobile.databinding.UserLogOffActivityLayoutBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final android.widget.LinearLayout mboundView0;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.back_btn, 1);
        sparseIntArray.put(com.up366.mobile.R.id.ask_for_layout, 2);
        sparseIntArray.put(com.up366.mobile.R.id.log_off_btn, 3);
        sparseIntArray.put(com.up366.mobile.R.id.telephone_tip, 4);
        sparseIntArray.put(com.up366.mobile.R.id.tx1, 5);
        sparseIntArray.put(com.up366.mobile.R.id.tx2, 6);
        sparseIntArray.put(com.up366.mobile.R.id.tx3, 7);
        sparseIntArray.put(com.up366.mobile.R.id.tx4, 8);
        sparseIntArray.put(com.up366.mobile.R.id.tx5, 9);
        sparseIntArray.put(com.up366.mobile.R.id.tx6, 10);
        sparseIntArray.put(com.up366.mobile.R.id.tx7, 11);
        sparseIntArray.put(com.up366.mobile.R.id.tx8, 12);
        sparseIntArray.put(com.up366.mobile.R.id.dot1, 13);
        sparseIntArray.put(com.up366.mobile.R.id.dot2, 14);
        sparseIntArray.put(com.up366.mobile.R.id.dot3, 15);
    }

    public UserLogOffActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private UserLogOffActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (androidx.constraintlayout.widget.ConstraintLayout) objArr[2], (com.up366.mobile.common.views.TitleBackView) objArr[1], (android.view.View) objArr[13], (android.view.View) objArr[14], (android.view.View) objArr[15], (android.widget.Button) objArr[3], (android.widget.TextView) objArr[4], (android.widget.TextView) objArr[5], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[7], (android.widget.TextView) objArr[8], (android.widget.TextView) objArr[9], (android.widget.TextView) objArr[10], (android.widget.TextView) objArr[11], (android.widget.TextView) objArr[12]);
        this.mDirtyFlags = -1L;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
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
