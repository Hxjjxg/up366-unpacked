package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AccountLoginStudentNumberActivityLayoutBindingImpl extends com.up366.mobile.databinding.AccountLoginStudentNumberActivityLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.scroll_view, 1);
        sparseIntArray.put(2131362177, 2);
        sparseIntArray.put(com.up366.mobile.R.id.view_tip, 3);
        sparseIntArray.put(com.up366.mobile.R.id.head, 4);
        sparseIntArray.put(com.up366.mobile.R.id.school, 5);
        sparseIntArray.put(com.up366.mobile.R.id.view_re_select, 6);
        sparseIntArray.put(com.up366.mobile.R.id.hand, 7);
        sparseIntArray.put(com.up366.mobile.R.id.student_number, 8);
        sparseIntArray.put(com.up366.mobile.R.id.password, 9);
        sparseIntArray.put(com.up366.mobile.R.id.btn_login, 10);
        sparseIntArray.put(com.up366.mobile.R.id.view_btn_next, 11);
        sparseIntArray.put(com.up366.mobile.R.id.btn_username_login, 12);
        sparseIntArray.put(com.up366.mobile.R.id.accept_deal_checbox, 13);
        sparseIntArray.put(com.up366.mobile.R.id.license_text, 14);
        sparseIntArray.put(2131361949, 15);
    }

    public AccountLoginStudentNumberActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private AccountLoginStudentNumberActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.ImageView) objArr[13], (com.up366.mobile.common.views.TitleBackView) objArr[15], (android.widget.Button) objArr[10], (android.widget.TextView) objArr[12], (androidx.constraintlayout.widget.ConstraintLayout) objArr[2], (android.widget.ImageView) objArr[7], (android.widget.ImageView) objArr[4], (com.up366.mobile.common.views.AppTextView) objArr[14], (com.up366.mobile.common.views.AppEditTextView) objArr[9], (android.widget.TextView) objArr[5], (android.widget.ScrollView) objArr[1], (com.up366.mobile.common.views.AppEditTextView) objArr[8], (android.widget.Button) objArr[11], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[3]);
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
