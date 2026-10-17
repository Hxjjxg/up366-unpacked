package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AccountUnbindBottomSheetDialogLayoutBindingImpl extends com.up366.mobile.databinding.AccountUnbindBottomSheetDialogLayoutBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final com.up366.mobile.common.views.ClipCornerLayout mboundView0;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363459, 1);
        sparseIntArray.put(2131362830, 2);
        sparseIntArray.put(com.up366.mobile.R.id.btn_unbind, 3);
        sparseIntArray.put(com.up366.mobile.R.id.btn_close, 4);
    }

    public AccountUnbindBottomSheetDialogLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private AccountUnbindBottomSheetDialogLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.ImageView) objArr[4], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[2], (android.widget.TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        com.up366.mobile.common.views.ClipCornerLayout clipCornerLayout = (com.up366.mobile.common.views.ClipCornerLayout) objArr[0];
        this.mboundView0 = clipCornerLayout;
        clipCornerLayout.setTag(null);
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
