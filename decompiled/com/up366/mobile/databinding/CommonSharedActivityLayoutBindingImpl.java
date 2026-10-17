package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CommonSharedActivityLayoutBindingImpl extends com.up366.mobile.databinding.CommonSharedActivityLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.shared_botoom_dashboard, 1);
        sparseIntArray.put(com.up366.mobile.R.id.shared_to_qq, 2);
        sparseIntArray.put(com.up366.mobile.R.id.shared_to_qq_space, 3);
        sparseIntArray.put(com.up366.mobile.R.id.shared_to_wechat_friend, 4);
        sparseIntArray.put(com.up366.mobile.R.id.shared_to_wechat_space, 5);
        sparseIntArray.put(com.up366.mobile.R.id.shared_save_to_local, 6);
        sparseIntArray.put(com.up366.mobile.R.id.shared_cancle, 7);
        sparseIntArray.put(2131362573, 8);
    }

    public CommonSharedActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private CommonSharedActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.up366.mobile.common.views.RoundImageView) objArr[8], (android.widget.LinearLayout) objArr[1], (android.widget.TextView) objArr[7], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[2], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[4], (android.widget.TextView) objArr[5]);
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
