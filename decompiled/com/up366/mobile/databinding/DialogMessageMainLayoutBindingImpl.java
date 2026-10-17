package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class DialogMessageMainLayoutBindingImpl extends com.up366.mobile.databinding.DialogMessageMainLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.update_dialog_background, 1);
        sparseIntArray.put(com.up366.mobile.R.id.message_title, 2);
        sparseIntArray.put(com.up366.mobile.R.id.message_subject, 3);
        sparseIntArray.put(com.up366.mobile.R.id.message_content, 4);
        sparseIntArray.put(com.up366.mobile.R.id.message_img, 5);
        sparseIntArray.put(com.up366.mobile.R.id.message_btn, 6);
        sparseIntArray.put(com.up366.mobile.R.id.message_more, 7);
        sparseIntArray.put(com.up366.mobile.R.id.message_close, 8);
    }

    public DialogMessageMainLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private DialogMessageMainLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[6], (android.widget.ImageView) objArr[8], (android.widget.TextView) objArr[4], (android.widget.ImageView) objArr[5], (android.widget.TextView) objArr[7], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[2], (android.widget.TextView) objArr[1]);
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
