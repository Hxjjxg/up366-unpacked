package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class FeedbackTaskRecordDialogBindingImpl extends com.up366.mobile.databinding.FeedbackTaskRecordDialogBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.state_tip, 1);
        sparseIntArray.put(com.up366.mobile.R.id.st_message, 2);
        sparseIntArray.put(com.up366.mobile.R.id.st_cancel, 3);
        sparseIntArray.put(com.up366.mobile.R.id.st_continue, 4);
        sparseIntArray.put(com.up366.mobile.R.id.state_progress, 5);
        sparseIntArray.put(com.up366.mobile.R.id.sp_title, 6);
        sparseIntArray.put(com.up366.mobile.R.id.sp_progress, 7);
        sparseIntArray.put(com.up366.mobile.R.id.percent_text, 8);
        sparseIntArray.put(com.up366.mobile.R.id.state_success, 9);
        sparseIntArray.put(com.up366.mobile.R.id.state_failed, 10);
        sparseIntArray.put(com.up366.mobile.R.id.sf_message, 11);
        sparseIntArray.put(com.up366.mobile.R.id.sf_cancel, 12);
        sparseIntArray.put(com.up366.mobile.R.id.sf_continue, 13);
    }

    public FeedbackTaskRecordDialogBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private FeedbackTaskRecordDialogBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[8], (android.widget.TextView) objArr[12], (android.widget.TextView) objArr[13], (android.widget.TextView) objArr[11], (android.widget.ProgressBar) objArr[7], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[4], (android.widget.TextView) objArr[2], (android.widget.LinearLayout) objArr[10], (android.widget.LinearLayout) objArr[5], (android.widget.LinearLayout) objArr[9], (android.widget.LinearLayout) objArr[1]);
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
