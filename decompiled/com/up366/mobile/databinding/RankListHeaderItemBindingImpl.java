package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class RankListHeaderItemBindingImpl extends com.up366.mobile.databinding.RankListHeaderItemBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.fl_name, 1);
        sparseIntArray.put(com.up366.mobile.R.id.tv_name, 2);
        sparseIntArray.put(com.up366.mobile.R.id.fl_remain_word, 3);
        sparseIntArray.put(com.up366.mobile.R.id.tv_remain_word, 4);
        sparseIntArray.put(com.up366.mobile.R.id.fl_has_destroy_word, 5);
        sparseIntArray.put(com.up366.mobile.R.id.tv_has_destroy_word, 6);
        sparseIntArray.put(com.up366.mobile.R.id.fl_today_destroy_word, 7);
        sparseIntArray.put(com.up366.mobile.R.id.tv_today_destroy_word, 8);
    }

    public RankListHeaderItemBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private RankListHeaderItemBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.FrameLayout) objArr[5], (android.widget.FrameLayout) objArr[1], (android.widget.FrameLayout) objArr[3], (android.widget.FrameLayout) objArr[7], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[2], (android.widget.TextView) objArr[4], (android.widget.TextView) objArr[8]);
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
