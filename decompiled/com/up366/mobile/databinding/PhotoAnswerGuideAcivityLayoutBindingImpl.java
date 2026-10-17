package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PhotoAnswerGuideAcivityLayoutBindingImpl extends com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding {
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
        sparseIntArray.put(2131363459, 1);
        sparseIntArray.put(com.up366.mobile.R.id.image_layout, 2);
        sparseIntArray.put(com.up366.mobile.R.id.image1, 3);
        sparseIntArray.put(com.up366.mobile.R.id.image2, 4);
        sparseIntArray.put(com.up366.mobile.R.id.image3, 5);
        sparseIntArray.put(com.up366.mobile.R.id.image4, 6);
        sparseIntArray.put(com.up366.mobile.R.id.btn_next, 7);
        sparseIntArray.put(com.up366.mobile.R.id.btn_layout_two, 8);
        sparseIntArray.put(com.up366.mobile.R.id.btn_prev_two, 9);
        sparseIntArray.put(com.up366.mobile.R.id.btn_next_two, 10);
        sparseIntArray.put(com.up366.mobile.R.id.btn_layout_three, 11);
        sparseIntArray.put(com.up366.mobile.R.id.btn_prev, 12);
        sparseIntArray.put(com.up366.mobile.R.id.btn_i_know, 13);
    }

    public PhotoAnswerGuideAcivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private PhotoAnswerGuideAcivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[13], (android.widget.LinearLayout) objArr[11], (android.widget.LinearLayout) objArr[8], (android.widget.TextView) objArr[7], (android.widget.TextView) objArr[10], (android.widget.TextView) objArr[12], (android.widget.TextView) objArr[9], (android.widget.ImageView) objArr[3], (android.widget.ImageView) objArr[4], (android.widget.ImageView) objArr[5], (android.widget.ImageView) objArr[6], (android.widget.ScrollView) objArr[2], (android.widget.TextView) objArr[1]);
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
