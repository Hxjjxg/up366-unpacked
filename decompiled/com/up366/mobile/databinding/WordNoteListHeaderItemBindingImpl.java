package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class WordNoteListHeaderItemBindingImpl extends com.up366.mobile.databinding.WordNoteListHeaderItemBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final android.widget.FrameLayout mboundView0;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.tv_has_killed_count, 1);
        sparseIntArray.put(com.up366.mobile.R.id.tv_has_killed, 2);
        sparseIntArray.put(com.up366.mobile.R.id.tv_remain_count, 3);
        sparseIntArray.put(com.up366.mobile.R.id.tv_remain, 4);
        sparseIntArray.put(com.up366.mobile.R.id.tv_today_killed_count, 5);
        sparseIntArray.put(com.up366.mobile.R.id.tv_today_killed, 6);
        sparseIntArray.put(com.up366.mobile.R.id.v_start, 7);
        sparseIntArray.put(com.up366.mobile.R.id.v_end, 8);
        sparseIntArray.put(com.up366.mobile.R.id.v_mask, 9);
    }

    public WordNoteListHeaderItemBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private WordNoteListHeaderItemBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[2], (android.widget.TextView) objArr[1], (android.widget.TextView) objArr[4], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[5], (android.view.View) objArr[8], (android.view.View) objArr[9], (android.view.View) objArr[7]);
        this.mDirtyFlags = -1L;
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
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
