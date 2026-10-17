package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CourseWrongDetailHeadViewBindingImpl extends com.up366.mobile.databinding.CourseWrongDetailHeadViewBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final android.widget.LinearLayout mboundView0;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.remain_num, 1);
        sparseIntArray.put(com.up366.mobile.R.id.kill_num, 2);
        sparseIntArray.put(com.up366.mobile.R.id.kill_yesterday_num, 3);
        sparseIntArray.put(com.up366.mobile.R.id.textView9, 4);
        sparseIntArray.put(com.up366.mobile.R.id.textView10, 5);
        sparseIntArray.put(com.up366.mobile.R.id.textView11, 6);
        sparseIntArray.put(com.up366.mobile.R.id.v_mask, 7);
    }

    public CourseWrongDetailHeadViewBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private CourseWrongDetailHeadViewBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[2], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[1], (android.widget.TextView) objArr[5], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[4], (android.view.View) objArr[7]);
        this.mDirtyFlags = -1L;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
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
