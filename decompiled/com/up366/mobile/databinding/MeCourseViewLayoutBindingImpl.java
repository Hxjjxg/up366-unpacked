package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeCourseViewLayoutBindingImpl extends com.up366.mobile.databinding.MeCourseViewLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.me_course_title, 1);
        sparseIntArray.put(com.up366.mobile.R.id.course_view_count_text, 2);
        sparseIntArray.put(com.up366.mobile.R.id.course_view_text_right, 3);
        sparseIntArray.put(com.up366.mobile.R.id.course_view_recycle_view, 4);
    }

    public MeCourseViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private MeCourseViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[2], (androidx.recyclerview.widget.RecyclerView) objArr[4], (androidx.constraintlayout.widget.ConstraintLayout) objArr[0], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.courseViewTextBtn.setTag((java.lang.Object) null);
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
