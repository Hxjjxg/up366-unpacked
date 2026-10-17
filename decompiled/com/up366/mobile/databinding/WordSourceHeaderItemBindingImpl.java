package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class WordSourceHeaderItemBindingImpl extends com.up366.mobile.databinding.WordSourceHeaderItemBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.tv_word_category, 1);
        sparseIntArray.put(com.up366.mobile.R.id.tv_content, 2);
        sparseIntArray.put(com.up366.mobile.R.id.iv_play_icon, 3);
        sparseIntArray.put(com.up366.mobile.R.id.tv_explain, 4);
        sparseIntArray.put(2131363704, 5);
        sparseIntArray.put(com.up366.mobile.R.id.tv_add_count, 6);
    }

    public WordSourceHeaderItemBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private WordSourceHeaderItemBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.airbnb.lottie.LottieAnimationView) objArr[3], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[2], (android.widget.TextView) objArr[4], (android.widget.TextView) objArr[1], (android.view.View) objArr[5]);
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
