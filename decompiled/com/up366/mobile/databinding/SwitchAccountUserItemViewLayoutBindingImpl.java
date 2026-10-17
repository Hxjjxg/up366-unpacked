package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SwitchAccountUserItemViewLayoutBindingImpl extends com.up366.mobile.databinding.SwitchAccountUserItemViewLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.psl_bg, 1);
        sparseIntArray.put(com.up366.mobile.R.id.mask, 2);
        sparseIntArray.put(com.up366.mobile.R.id.user_photo, 3);
        sparseIntArray.put(com.up366.mobile.R.id.real_name, 4);
        sparseIntArray.put(com.up366.mobile.R.id.user_name, 5);
        sparseIntArray.put(com.up366.mobile.R.id.status_group, 6);
        sparseIntArray.put(com.up366.mobile.R.id.cur_use, 7);
        sparseIntArray.put(com.up366.mobile.R.id.clear_btn, 8);
    }

    public SwitchAccountUserItemViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private SwitchAccountUserItemViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[8], (android.widget.TextView) objArr[7], (android.view.View) objArr[2], (com.up366.mobile.common.views.PaddingShadowLayout) objArr[1], (android.widget.TextView) objArr[4], (androidx.constraintlayout.widget.ConstraintLayout) objArr[0], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[5], (com.up366.mobile.common.views.RoundImageView) objArr[3]);
        this.mDirtyFlags = -1L;
        this.rootView.setTag((java.lang.Object) null);
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
