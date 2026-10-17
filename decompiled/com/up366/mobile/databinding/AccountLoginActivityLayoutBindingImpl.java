package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AccountLoginActivityLayoutBindingImpl extends com.up366.mobile.databinding.AccountLoginActivityLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.app_bar, 2);
        sparseIntArray.put(com.up366.mobile.R.id.toolbar_layout, 3);
        sparseIntArray.put(com.up366.mobile.R.id.title_back_view, 4);
        sparseIntArray.put(2131362177, 5);
        sparseIntArray.put(com.up366.mobile.R.id.tip, 6);
        sparseIntArray.put(com.up366.mobile.R.id.username, 7);
        sparseIntArray.put(com.up366.mobile.R.id.password, 8);
        sparseIntArray.put(com.up366.mobile.R.id.btn_login, 9);
        sparseIntArray.put(com.up366.mobile.R.id.btn_mobile_login, 10);
        sparseIntArray.put(com.up366.mobile.R.id.forget, 11);
        sparseIntArray.put(com.up366.mobile.R.id.accept_deal_checbox, 12);
        sparseIntArray.put(com.up366.mobile.R.id.license_text, 13);
        sparseIntArray.put(com.up366.mobile.R.id.register, 14);
        sparseIntArray.put(com.up366.mobile.R.id.flow, 15);
        sparseIntArray.put(com.up366.mobile.R.id.btn_login_tourist, 16);
        sparseIntArray.put(com.up366.mobile.R.id.btn_login_student_num, 17);
        sparseIntArray.put(com.up366.mobile.R.id.btn_login_wechat, 18);
        sparseIntArray.put(com.up366.mobile.R.id.btn_login_qq, 19);
        sparseIntArray.put(com.up366.mobile.R.id.desc_student_num, 20);
        sparseIntArray.put(com.up366.mobile.R.id.desc_wechat, 21);
        sparseIntArray.put(com.up366.mobile.R.id.desc_qq, 22);
        sparseIntArray.put(com.up366.mobile.R.id.iv_hide_icon, 23);
        sparseIntArray.put(com.up366.mobile.R.id.iv_evs, 24);
        sparseIntArray.put(com.up366.mobile.R.id.host, 25);
    }

    public AccountLoginActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 26, sIncludes, sViewsWithIds));
    }

    private AccountLoginActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.ImageView) objArr[12], (com.google.android.material.appbar.AppBarLayout) objArr[2], (android.widget.TextView) objArr[9], (android.widget.ImageView) objArr[19], (android.widget.ImageView) objArr[17], (android.widget.TextView) objArr[16], (android.widget.ImageView) objArr[18], (android.widget.TextView) objArr[10], (androidx.constraintlayout.widget.ConstraintLayout) objArr[5], (android.widget.TextView) objArr[22], (android.widget.TextView) objArr[20], (android.widget.TextView) objArr[21], (androidx.constraintlayout.helper.widget.Flow) objArr[15], (android.widget.TextView) objArr[11], (android.widget.TextView) objArr[25], (android.widget.ImageView) objArr[24], (android.widget.ImageView) objArr[23], (com.up366.mobile.common.views.AppTextView) objArr[13], (com.up366.mobile.common.views.AppEditTextView) objArr[8], (android.widget.TextView) objArr[14], (android.widget.ScrollView) objArr[1], (android.widget.TextView) objArr[6], (com.up366.mobile.common.views.TitleBackView) objArr[4], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[3], (com.up366.mobile.common.views.AppEditTextView) objArr[7]);
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
