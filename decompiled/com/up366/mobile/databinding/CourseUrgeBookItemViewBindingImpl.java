package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CourseUrgeBookItemViewBindingImpl extends com.up366.mobile.databinding.CourseUrgeBookItemViewBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.item_bg, 2);
        sparseIntArray.put(com.up366.mobile.R.id.focusView, 3);
        sparseIntArray.put(2131362563, 4);
        sparseIntArray.put(com.up366.mobile.R.id.name, 5);
        sparseIntArray.put(com.up366.mobile.R.id.num, 6);
        sparseIntArray.put(com.up366.mobile.R.id.btn_first_go, 7);
        sparseIntArray.put(com.up366.mobile.R.id.btn_go, 8);
        sparseIntArray.put(com.up366.mobile.R.id.icon_new, 9);
    }

    public CourseUrgeBookItemViewBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private CourseUrgeBookItemViewBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[7], (android.widget.TextView) objArr[8], (android.view.View) objArr[3], (com.up366.mobile.common.views.RoundImageView) objArr[4], (android.widget.TextView) objArr[9], (com.up366.mobile.common.views.RoundImageView) objArr[2], (android.widget.TextView) objArr[5], (android.widget.TextView) objArr[6], (com.up366.mobile.common.views.PaddingShadowLayout) objArr[1], (androidx.constraintlayout.widget.ConstraintLayout) objArr[0]);
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
