package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CourseWordNoteRankItemViewBindingImpl extends com.up366.mobile.databinding.CourseWordNoteRankItemViewBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.rank_LL, 1);
        sparseIntArray.put(com.up366.mobile.R.id.iv_rank_no, 2);
        sparseIntArray.put(com.up366.mobile.R.id.tv_no, 3);
        sparseIntArray.put(com.up366.mobile.R.id.tv_name, 4);
        sparseIntArray.put(com.up366.mobile.R.id.tv_wrong_count, 5);
        sparseIntArray.put(com.up366.mobile.R.id.tv_killed_count, 6);
        sparseIntArray.put(com.up366.mobile.R.id.tv_killed_count_lately, 7);
    }

    public CourseWordNoteRankItemViewBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private CourseWordNoteRankItemViewBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.ImageView) objArr[2], (android.widget.LinearLayout) objArr[1], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[7], (android.widget.TextView) objArr[4], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[5]);
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
