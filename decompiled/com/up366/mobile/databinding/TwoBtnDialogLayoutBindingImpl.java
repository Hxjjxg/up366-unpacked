package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class TwoBtnDialogLayoutBindingImpl extends com.up366.mobile.databinding.TwoBtnDialogLayoutBinding {
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
        sparseIntArray.put(2131362177, 1);
        sparseIntArray.put(2131363459, 2);
        sparseIntArray.put(com.up366.mobile.R.id.content_scroll_view, 3);
        sparseIntArray.put(2131362830, 4);
        sparseIntArray.put(com.up366.mobile.R.id.button_container, 5);
        sparseIntArray.put(com.up366.mobile.R.id.btn_left, 6);
        sparseIntArray.put(com.up366.mobile.R.id.btn_right, 7);
    }

    public TwoBtnDialogLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private TwoBtnDialogLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[7], (android.widget.LinearLayout) objArr[5], (android.widget.LinearLayout) objArr[1], (android.widget.ScrollView) objArr[3], (android.widget.TextView) objArr[4], (android.widget.TextView) objArr[2]);
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
