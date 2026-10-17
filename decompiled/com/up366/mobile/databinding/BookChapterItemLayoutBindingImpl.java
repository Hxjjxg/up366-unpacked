package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class BookChapterItemLayoutBindingImpl extends com.up366.mobile.databinding.BookChapterItemLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.space, 1);
        sparseIntArray.put(com.up366.mobile.R.id.head_flag, 2);
        sparseIntArray.put(com.up366.mobile.R.id.chapter_name, 3);
        sparseIntArray.put(com.up366.mobile.R.id.score, 4);
        sparseIntArray.put(com.up366.mobile.R.id.cursor, 5);
        sparseIntArray.put(com.up366.mobile.R.id.lock, 6);
    }

    public BookChapterItemLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private BookChapterItemLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[3], (android.widget.ImageView) objArr[5], (android.widget.ImageView) objArr[2], (android.widget.LinearLayout) objArr[0], (android.widget.ImageView) objArr[6], (android.widget.TextView) objArr[4], (android.widget.Space) objArr[1]);
        this.mDirtyFlags = -1L;
        this.item.setTag(null);
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
