package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class UserLogOffActivityConfirmLayoutBindingImpl extends com.up366.mobile.databinding.UserLogOffActivityConfirmLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.back_btn, 1);
        sparseIntArray.put(com.up366.mobile.R.id.title_layout, 2);
        sparseIntArray.put(com.up366.mobile.R.id.tx1, 3);
        sparseIntArray.put(com.up366.mobile.R.id.username, 4);
        sparseIntArray.put(com.up366.mobile.R.id.root, 5);
        sparseIntArray.put(com.up366.mobile.R.id.tip1, 6);
        sparseIntArray.put(com.up366.mobile.R.id.mobile, 7);
        sparseIntArray.put(com.up366.mobile.R.id.error_tip, 8);
        sparseIntArray.put(com.up366.mobile.R.id.captcha, 9);
        sparseIntArray.put(com.up366.mobile.R.id.btn_change, 10);
        sparseIntArray.put(com.up366.mobile.R.id.btn_no_code, 11);
        sparseIntArray.put(com.up366.mobile.R.id.ask_for_success_layout, 12);
        sparseIntArray.put(com.up366.mobile.R.id.success_img, 13);
        sparseIntArray.put(com.up366.mobile.R.id.success_tip, 14);
        sparseIntArray.put(com.up366.mobile.R.id.tip, 15);
        sparseIntArray.put(com.up366.mobile.R.id.to_login, 16);
    }

    public UserLogOffActivityConfirmLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private UserLogOffActivityConfirmLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (androidx.constraintlayout.widget.ConstraintLayout) objArr[12], (com.up366.mobile.common.views.TitleBackView) objArr[1], (android.widget.Button) objArr[10], (android.widget.TextView) objArr[11], (com.up366.mobile.common.views.AppEditTextView) objArr[9], (android.widget.TextView) objArr[8], (com.up366.mobile.common.views.AppEditTextView) objArr[7], (androidx.constraintlayout.widget.ConstraintLayout) objArr[5], (android.widget.ImageView) objArr[13], (android.widget.TextView) objArr[14], (android.widget.TextView) objArr[15], (android.widget.TextView) objArr[6], (android.widget.LinearLayout) objArr[2], (android.widget.TextView) objArr[16], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[4]);
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
