package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AccountUpdateActivityHomeLayoutBindingImpl extends com.up366.mobile.databinding.AccountUpdateActivityHomeLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.username, 1);
        sparseIntArray.put(com.up366.mobile.R.id.change_mobile, 2);
        sparseIntArray.put(2131362700, 3);
        sparseIntArray.put(com.up366.mobile.R.id.change_wechat, 4);
        sparseIntArray.put(com.up366.mobile.R.id.line2, 5);
        sparseIntArray.put(com.up366.mobile.R.id.change_qq, 6);
        sparseIntArray.put(com.up366.mobile.R.id.change_password, 7);
        sparseIntArray.put(com.up366.mobile.R.id.set_voice, 8);
        sparseIntArray.put(com.up366.mobile.R.id.cancellation, 9);
    }

    public AccountUpdateActivityHomeLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private AccountUpdateActivityHomeLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[9], (com.up366.mobile.common.views.AccountSettingItemView) objArr[2], (com.up366.mobile.common.views.AccountSettingItemView) objArr[7], (com.up366.mobile.common.views.AccountSettingItemView) objArr[6], (com.up366.mobile.common.views.AccountSettingItemView) objArr[4], (android.view.View) objArr[3], (android.view.View) objArr[5], (com.up366.mobile.common.views.AccountSettingItemView) objArr[8], (android.widget.TextView) objArr[1]);
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
