package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeMyBookItemViewLayoutBindingImpl extends com.up366.mobile.databinding.MeMyBookItemViewLayoutBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final com.up366.mobile.common.views.PaddingShadowLayout mboundView0;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.rootView, 1);
        sparseIntArray.put(com.up366.mobile.R.id.book_picture, 2);
        sparseIntArray.put(com.up366.mobile.R.id.tip_new, 3);
        sparseIntArray.put(com.up366.mobile.R.id.book_name, 4);
        sparseIntArray.put(com.up366.mobile.R.id.tip_endTime, 5);
        sparseIntArray.put(com.up366.mobile.R.id.tip_text, 6);
        sparseIntArray.put(com.up366.mobile.R.id.goto_study_btn, 7);
        sparseIntArray.put(com.up366.mobile.R.id.down_shelf_tip, 8);
        sparseIntArray.put(com.up366.mobile.R.id.goto_try_btn, 9);
    }

    public MeMyBookItemViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private MeMyBookItemViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[4], (com.up366.mobile.common.views.RoundImageView) objArr[2], (android.widget.ImageView) objArr[8], (android.widget.TextView) objArr[7], (android.widget.TextView) objArr[9], (androidx.constraintlayout.widget.ConstraintLayout) objArr[1], (android.widget.TextView) objArr[5], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[6]);
        this.mDirtyFlags = -1L;
        com.up366.mobile.common.views.PaddingShadowLayout paddingShadowLayout = (com.up366.mobile.common.views.PaddingShadowLayout) objArr[0];
        this.mboundView0 = paddingShadowLayout;
        paddingShadowLayout.setTag(null);
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
