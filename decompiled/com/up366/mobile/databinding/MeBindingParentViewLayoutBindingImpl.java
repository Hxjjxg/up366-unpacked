package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeBindingParentViewLayoutBindingImpl extends com.up366.mobile.databinding.MeBindingParentViewLayoutBinding {
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
        sparseIntArray.put(2131362178, 1);
        sparseIntArray.put(com.up366.mobile.R.id.user_photo, 2);
        sparseIntArray.put(com.up366.mobile.R.id.user_realname, 3);
        sparseIntArray.put(com.up366.mobile.R.id.user_public, 4);
        sparseIntArray.put(com.up366.mobile.R.id.code_tip_1, 5);
        sparseIntArray.put(com.up366.mobile.R.id.qr_parent_bg, 6);
        sparseIntArray.put(com.up366.mobile.R.id.qr_parent, 7);
        sparseIntArray.put(com.up366.mobile.R.id.tip_mask, 8);
        sparseIntArray.put(com.up366.mobile.R.id.tip_layout, 9);
        sparseIntArray.put(com.up366.mobile.R.id.parent_loading, 10);
        sparseIntArray.put(com.up366.mobile.R.id.tip_message, 11);
        sparseIntArray.put(com.up366.mobile.R.id.retry_btn, 12);
    }

    public MeBindingParentViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private MeBindingParentViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[5], (com.up366.mobile.common.views.PaddingShadowLayout) objArr[1], (android.widget.ImageView) objArr[10], (android.widget.ImageView) objArr[7], (android.view.View) objArr[6], (android.widget.TextView) objArr[12], (android.widget.LinearLayout) objArr[9], (android.view.View) objArr[8], (android.widget.TextView) objArr[11], (com.up366.mobile.common.views.CircleImageView) objArr[2], (android.widget.TextView) objArr[4], (android.widget.TextView) objArr[3]);
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
