package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CourseRateItemViewLayoutBindingImpl extends com.up366.mobile.databinding.CourseRateItemViewLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.text_avg, 2);
        sparseIntArray.put(com.up366.mobile.R.id.text_max, 3);
        sparseIntArray.put(com.up366.mobile.R.id.img_avg, 4);
        sparseIntArray.put(com.up366.mobile.R.id.img_max, 5);
        sparseIntArray.put(com.up366.mobile.R.id.score_avg, 6);
        sparseIntArray.put(com.up366.mobile.R.id.score_max, 7);
        sparseIntArray.put(com.up366.mobile.R.id.percent_text_avg, 8);
        sparseIntArray.put(com.up366.mobile.R.id.percent_text_max, 9);
        sparseIntArray.put(com.up366.mobile.R.id.month, 10);
        sparseIntArray.put(com.up366.mobile.R.id.subject, 11);
        sparseIntArray.put(com.up366.mobile.R.id.rate_tip, 12);
        sparseIntArray.put(com.up366.mobile.R.id.rate_tip_arrow, 13);
    }

    public CourseRateItemViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private CourseRateItemViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (androidx.constraintlayout.widget.ConstraintLayout) objArr[0], (android.widget.ImageView) objArr[4], (android.widget.ImageView) objArr[5], (android.widget.TextView) objArr[10], (android.widget.TextView) objArr[8], (android.widget.TextView) objArr[9], (com.up366.mobile.common.views.PaddingShadowLayout) objArr[1], (android.widget.TextView) objArr[12], (android.view.View) objArr[13], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[7], (android.widget.TextView) objArr[11], (android.widget.TextView) objArr[2], (android.widget.TextView) objArr[3]);
        this.mDirtyFlags = -1L;
        this.clRateItem.setTag((java.lang.Object) null);
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
