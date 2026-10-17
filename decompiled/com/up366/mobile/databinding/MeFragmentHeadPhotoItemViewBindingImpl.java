package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeFragmentHeadPhotoItemViewBindingImpl extends com.up366.mobile.databinding.MeFragmentHeadPhotoItemViewBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.me_photo, 1);
        sparseIntArray.put(com.up366.mobile.R.id.name_layout, 2);
        sparseIntArray.put(com.up366.mobile.R.id.name, 3);
        sparseIntArray.put(com.up366.mobile.R.id.study_card_icon, 4);
        sparseIntArray.put(com.up366.mobile.R.id.account, 5);
        sparseIntArray.put(com.up366.mobile.R.id.dayStudyTime, 6);
        sparseIntArray.put(com.up366.mobile.R.id.image_enter, 7);
        sparseIntArray.put(com.up366.mobile.R.id.tip_card_time, 8);
    }

    public MeFragmentHeadPhotoItemViewBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private MeFragmentHeadPhotoItemViewBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[5], (android.widget.TextView) objArr[6], (android.widget.ImageView) objArr[7], (androidx.constraintlayout.widget.ConstraintLayout) objArr[0], (com.up366.mobile.common.views.CircleImageView) objArr[1], (android.widget.TextView) objArr[3], (android.widget.LinearLayout) objArr[2], (android.widget.ImageView) objArr[4], (android.widget.TextView) objArr[8]);
        this.mDirtyFlags = -1L;
        this.meHeadView.setTag((java.lang.Object) null);
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
