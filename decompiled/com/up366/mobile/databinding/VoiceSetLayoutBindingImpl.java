package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class VoiceSetLayoutBindingImpl extends com.up366.mobile.databinding.VoiceSetLayoutBinding {
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
        sparseIntArray.put(2131361949, 1);
        sparseIntArray.put(com.up366.mobile.R.id.shadow, 2);
        sparseIntArray.put(2131363459, 3);
        sparseIntArray.put(com.up366.mobile.R.id.anim, 4);
        sparseIntArray.put(com.up366.mobile.R.id.text1, 5);
        sparseIntArray.put(2131363385, 6);
        sparseIntArray.put(com.up366.mobile.R.id.btn_record, 7);
    }

    public VoiceSetLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private VoiceSetLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.ImageView) objArr[4], (com.up366.mobile.common.views.TitleBackView) objArr[1], (android.widget.TextView) objArr[7], (com.up366.mobile.common.views.PaddingShadowLayout) objArr[2], (android.widget.TextView) objArr[5], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[3]);
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
