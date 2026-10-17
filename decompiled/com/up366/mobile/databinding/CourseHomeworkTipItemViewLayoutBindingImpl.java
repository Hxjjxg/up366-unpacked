package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CourseHomeworkTipItemViewLayoutBindingImpl extends com.up366.mobile.databinding.CourseHomeworkTipItemViewLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.item_bg, 1);
        sparseIntArray.put(com.up366.mobile.R.id.tip, 2);
        sparseIntArray.put(com.up366.mobile.R.id.tip_arrow, 3);
        sparseIntArray.put(com.up366.mobile.R.id.count, 4);
        sparseIntArray.put(com.up366.mobile.R.id.count_sub, 5);
        sparseIntArray.put(2131363383, 6);
        sparseIntArray.put(com.up366.mobile.R.id.text_tip, 7);
        sparseIntArray.put(com.up366.mobile.R.id.btn_start, 8);
        sparseIntArray.put(com.up366.mobile.R.id.live_Guide_focus_view, 9);
    }

    public CourseHomeworkTipItemViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private CourseHomeworkTipItemViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[8], (android.widget.TextView) objArr[4], (android.widget.TextView) objArr[5], (com.up366.mobile.common.views.RoundImageView) objArr[1], (android.view.View) objArr[9], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[7], (android.widget.TextView) objArr[2], (android.view.View) objArr[3]);
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
