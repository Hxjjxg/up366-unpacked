package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class EmptyStateViewBindingImpl extends com.up366.mobile.databinding.EmptyStateViewBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.empty_loading_layout, 1);
        sparseIntArray.put(com.up366.mobile.R.id.empty_loading_img, 2);
        sparseIntArray.put(com.up366.mobile.R.id.iv_empty_state_tipimg, 3);
        sparseIntArray.put(com.up366.mobile.R.id.tv_empty_view_tip, 4);
        sparseIntArray.put(com.up366.mobile.R.id.btn_empty_state_left, 5);
        sparseIntArray.put(com.up366.mobile.R.id.btn_empty_state_right, 6);
    }

    public EmptyStateViewBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private EmptyStateViewBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[5], (android.widget.TextView) objArr[6], (android.widget.ImageView) objArr[2], (android.widget.LinearLayout) objArr[1], (android.widget.ImageView) objArr[3], (androidx.constraintlayout.widget.ConstraintLayout) objArr[0], (android.widget.TextView) objArr[4]);
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
