package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class TitleBarViewLayoutBindingImpl extends com.up366.mobile.databinding.TitleBarViewLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.leftText, 1);
        sparseIntArray.put(com.up366.mobile.R.id.findCourse, 2);
        sparseIntArray.put(2131363459, 3);
        sparseIntArray.put(com.up366.mobile.R.id.input, 4);
        sparseIntArray.put(com.up366.mobile.R.id.arrow, 5);
        sparseIntArray.put(2131362830, 6);
        sparseIntArray.put(com.up366.mobile.R.id.rightIcon, 7);
        sparseIntArray.put(com.up366.mobile.R.id.rightText, 8);
        sparseIntArray.put(2131361949, 9);
        sparseIntArray.put(com.up366.mobile.R.id.right_btn_container, 10);
        sparseIntArray.put(com.up366.mobile.R.id.line, 11);
    }

    public TitleBarViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private TitleBarViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.ImageView) objArr[5], (com.up366.mobile.common.views.TitleBackView) objArr[9], (com.up366.mobile.common.views.TitleSearchClassView) objArr[2], (com.up366.mobile.common.views.CommonEditText) objArr[4], (android.widget.TextView) objArr[1], (android.view.View) objArr[11], (com.up366.mobile.common.views.TitleMessageView) objArr[6], (android.widget.LinearLayout) objArr[10], (com.up366.mobile.common.views.TitleRightView) objArr[7], (android.widget.TextView) objArr[8], (com.up366.mobile.common.views.MarqueeTextView) objArr[3]);
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
