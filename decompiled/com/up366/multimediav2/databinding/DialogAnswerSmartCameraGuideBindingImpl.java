package com.up366.multimediav2.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class DialogAnswerSmartCameraGuideBindingImpl extends com.up366.multimediav2.databinding.DialogAnswerSmartCameraGuideBinding {
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
        sparseIntArray.put(com.up366.multimediav2.R.id.tv_title, 1);
        sparseIntArray.put(com.up366.multimediav2.R.id.ib_close, 2);
        sparseIntArray.put(com.up366.multimediav2.R.id.vp_content_show, 3);
        sparseIntArray.put(com.up366.multimediav2.R.id.tv_operation_tips, 4);
        sparseIntArray.put(com.up366.multimediav2.R.id.view_pager_index, 5);
    }

    public DialogAnswerSmartCameraGuideBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private DialogAnswerSmartCameraGuideBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.ImageButton) objArr[2], (android.widget.TextView) objArr[4], (android.widget.TextView) objArr[1], (com.up366.view.RotationMapCirclePointView) objArr[5], (androidx.viewpager.widget.ViewPager) objArr[3]);
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
