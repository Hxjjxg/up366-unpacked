package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeMyBookSearchAcivityLayoutBindingImpl extends com.up366.mobile.databinding.MeMyBookSearchAcivityLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.search_text, 1);
        sparseIntArray.put(com.up366.mobile.R.id.search_cancel, 2);
        sparseIntArray.put(com.up366.mobile.R.id.pull_refresh_layout, 3);
        sparseIntArray.put(com.up366.mobile.R.id.recycleView, 4);
    }

    public MeMyBookSearchAcivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private MeMyBookSearchAcivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.ylw.pullrefreshlibrary.PullRefreshLayout) objArr[3], (androidx.recyclerview.widget.RecyclerView) objArr[4], (android.widget.TextView) objArr[2], (com.up366.mobile.common.views.AppEditTextView) objArr[1]);
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
