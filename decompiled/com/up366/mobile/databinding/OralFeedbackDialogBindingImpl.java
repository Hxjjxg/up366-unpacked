package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class OralFeedbackDialogBindingImpl extends com.up366.mobile.databinding.OralFeedbackDialogBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.state_select, 1);
        sparseIntArray.put(com.up366.mobile.R.id.sl_title, 2);
        sparseIntArray.put(com.up366.mobile.R.id.sl_description, 3);
        sparseIntArray.put(com.up366.mobile.R.id.sl_feedback_type_title, 4);
        sparseIntArray.put(com.up366.mobile.R.id.sl_feedback_type_group, 5);
        sparseIntArray.put(com.up366.mobile.R.id.sl_score_high, 6);
        sparseIntArray.put(com.up366.mobile.R.id.sl_score_low, 7);
        sparseIntArray.put(com.up366.mobile.R.id.sl_cancle, 8);
        sparseIntArray.put(com.up366.mobile.R.id.sl_submit, 9);
        sparseIntArray.put(com.up366.mobile.R.id.state_uploading, 10);
        sparseIntArray.put(com.up366.mobile.R.id.su_title, 11);
        sparseIntArray.put(com.up366.mobile.R.id.su_message, 12);
        sparseIntArray.put(com.up366.mobile.R.id.su_progress_bar, 13);
        sparseIntArray.put(com.up366.mobile.R.id.su_progress_text, 14);
        sparseIntArray.put(com.up366.mobile.R.id.state_failed, 15);
        sparseIntArray.put(com.up366.mobile.R.id.sf_icon, 16);
        sparseIntArray.put(com.up366.mobile.R.id.sf_title, 17);
        sparseIntArray.put(com.up366.mobile.R.id.sf_message, 18);
        sparseIntArray.put(com.up366.mobile.R.id.sf_cancle, 19);
        sparseIntArray.put(com.up366.mobile.R.id.sf_retry, 20);
        sparseIntArray.put(com.up366.mobile.R.id.state_success, 21);
        sparseIntArray.put(com.up366.mobile.R.id.ss_icon, 22);
        sparseIntArray.put(com.up366.mobile.R.id.ss_title, 23);
        sparseIntArray.put(com.up366.mobile.R.id.ss_message, 24);
    }

    public OralFeedbackDialogBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 25, sIncludes, sViewsWithIds));
    }

    private OralFeedbackDialogBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[19], (android.widget.ImageView) objArr[16], (android.widget.TextView) objArr[18], (android.widget.TextView) objArr[20], (android.widget.TextView) objArr[17], (android.widget.TextView) objArr[8], (android.widget.TextView) objArr[3], (android.widget.RadioGroup) objArr[5], (android.widget.TextView) objArr[4], (android.widget.RadioButton) objArr[6], (android.widget.RadioButton) objArr[7], (android.widget.TextView) objArr[9], (android.widget.TextView) objArr[2], (android.widget.ImageView) objArr[22], (android.widget.TextView) objArr[24], (android.widget.TextView) objArr[23], (androidx.constraintlayout.widget.ConstraintLayout) objArr[15], (androidx.constraintlayout.widget.ConstraintLayout) objArr[1], (androidx.constraintlayout.widget.ConstraintLayout) objArr[21], (androidx.constraintlayout.widget.ConstraintLayout) objArr[10], (android.widget.TextView) objArr[12], (android.widget.ProgressBar) objArr[13], (android.widget.TextView) objArr[14], (android.widget.TextView) objArr[11]);
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
