package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ActivityMainBindingImpl extends com.up366.mobile.databinding.ActivityMainBinding {
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
        sparseIntArray.put(2131362178, 1);
        sparseIntArray.put(com.up366.mobile.R.id.tab, 2);
        sparseIntArray.put(com.up366.mobile.R.id.mask_view, 3);
        sparseIntArray.put(com.up366.mobile.R.id.top_layout, 4);
        sparseIntArray.put(com.up366.mobile.R.id.splash_mask, 5);
        sparseIntArray.put(com.up366.mobile.R.id.btn_promotion, 6);
        sparseIntArray.put(com.up366.mobile.R.id.promotion, 7);
        sparseIntArray.put(com.up366.mobile.R.id.timer, 8);
        sparseIntArray.put(com.up366.mobile.R.id.btn_skip, 9);
    }

    public ActivityMainBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.FrameLayout) objArr[6], (com.up366.mobile.common.views.ShapeableTextView) objArr[9], (com.up366.mobile.common.views.WindowInsetsFrameLayout) objArr[1], (android.view.View) objArr[3], (android.widget.ImageView) objArr[7], (android.view.View) objArr[5], (com.up366.mobile.common.views.MainBottomTabView) objArr[2], (com.up366.mobile.common.views.ShapeableTextView) objArr[8], (androidx.constraintlayout.widget.ConstraintLayout) objArr[4]);
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
