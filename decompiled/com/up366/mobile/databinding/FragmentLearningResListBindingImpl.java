package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class FragmentLearningResListBindingImpl extends com.up366.mobile.databinding.FragmentLearningResListBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.rv_res_list, 1);
    }

    public FragmentLearningResListBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, sIncludes, sViewsWithIds));
    }

    private FragmentLearningResListBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.ylw.pullrefreshlibrary.PullRefreshLayout) objArr[0], (androidx.recyclerview.widget.RecyclerView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.pullRefreshLayout.setTag(null);
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
