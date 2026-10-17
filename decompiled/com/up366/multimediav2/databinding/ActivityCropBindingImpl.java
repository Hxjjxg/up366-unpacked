package com.up366.multimediav2.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ActivityCropBindingImpl extends com.up366.multimediav2.databinding.ActivityCropBinding {
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
        sparseIntArray.put(com.up366.multimediav2.R.id.ib_crop_back, 1);
        sparseIntArray.put(com.up366.multimediav2.R.id.ll_auto_title, 2);
        sparseIntArray.put(com.up366.multimediav2.R.id.tv_title, 3);
        sparseIntArray.put(com.up366.multimediav2.R.id.ib_auto_tips, 4);
        sparseIntArray.put(com.up366.multimediav2.R.id.frame, 5);
        sparseIntArray.put(com.up366.multimediav2.R.id.ucrop, 6);
        sparseIntArray.put(com.up366.multimediav2.R.id.auto_crop_view, 7);
        sparseIntArray.put(com.up366.multimediav2.R.id.pb_loading, 8);
        sparseIntArray.put(com.up366.multimediav2.R.id.tv_desc, 9);
        sparseIntArray.put(com.up366.multimediav2.R.id.crop_bottom, 10);
        sparseIntArray.put(com.up366.multimediav2.R.id.tv_retry, 11);
        sparseIntArray.put(com.up366.multimediav2.R.id.ib_crop_rotate, 12);
        sparseIntArray.put(com.up366.multimediav2.R.id.ib_crop_take_picture, 13);
    }

    public ActivityCropBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private ActivityCropBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.up366.view.crop.AutoCropImageView) objArr[7], (androidx.constraintlayout.widget.ConstraintLayout) objArr[10], (androidx.constraintlayout.widget.ConstraintLayout) objArr[5], (android.widget.ImageButton) objArr[4], (android.widget.ImageButton) objArr[1], (android.widget.ImageButton) objArr[12], (android.widget.TextView) objArr[13], (android.widget.LinearLayout) objArr[2], (android.widget.ImageView) objArr[8], (androidx.constraintlayout.widget.ConstraintLayout) objArr[0], (android.widget.TextView) objArr[9], (android.widget.TextView) objArr[11], (android.widget.TextView) objArr[3], (com.up366.view.crop.view.UCropView) objArr[6]);
        this.mDirtyFlags = -1L;
        this.rlRoot.setTag((java.lang.Object) null);
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
