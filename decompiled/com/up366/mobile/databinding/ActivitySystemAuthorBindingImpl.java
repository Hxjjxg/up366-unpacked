package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ActivitySystemAuthorBindingImpl extends com.up366.mobile.databinding.ActivitySystemAuthorBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.titleBar, 1);
        sparseIntArray.put(com.up366.mobile.R.id.tip, 2);
        sparseIntArray.put(com.up366.mobile.R.id.storage, 3);
        sparseIntArray.put(com.up366.mobile.R.id.storage_manage, 4);
        sparseIntArray.put(com.up366.mobile.R.id.storage_tip, 5);
        sparseIntArray.put(com.up366.mobile.R.id.audio, 6);
        sparseIntArray.put(com.up366.mobile.R.id.audio_manage, 7);
        sparseIntArray.put(com.up366.mobile.R.id.audio_tip, 8);
        sparseIntArray.put(com.up366.mobile.R.id.camara, 9);
        sparseIntArray.put(com.up366.mobile.R.id.camara_manage, 10);
        sparseIntArray.put(com.up366.mobile.R.id.camara_tip, 11);
        sparseIntArray.put(com.up366.mobile.R.id.install, 12);
        sparseIntArray.put(com.up366.mobile.R.id.install_manage, 13);
        sparseIntArray.put(com.up366.mobile.R.id.install_tip, 14);
        sparseIntArray.put(com.up366.mobile.R.id.flow, 15);
        sparseIntArray.put(com.up366.mobile.R.id.flow_manage, 16);
        sparseIntArray.put(com.up366.mobile.R.id.flow_tip, 17);
    }

    public ActivitySystemAuthorBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
    }

    private ActivitySystemAuthorBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[7], (android.widget.TextView) objArr[8], (android.widget.TextView) objArr[9], (android.widget.TextView) objArr[10], (android.widget.TextView) objArr[11], (android.widget.TextView) objArr[15], (android.widget.TextView) objArr[16], (android.widget.TextView) objArr[17], (android.widget.TextView) objArr[12], (android.widget.TextView) objArr[13], (android.widget.TextView) objArr[14], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[4], (android.widget.TextView) objArr[5], (android.widget.TextView) objArr[2], (com.up366.mobile.common.views.TitleBarView) objArr[1]);
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
