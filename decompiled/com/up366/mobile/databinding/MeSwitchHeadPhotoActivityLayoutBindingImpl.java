package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeSwitchHeadPhotoActivityLayoutBindingImpl extends com.up366.mobile.databinding.MeSwitchHeadPhotoActivityLayoutBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.head_photo_bg, 1);
        sparseIntArray.put(com.up366.mobile.R.id.me_photo_img, 2);
        sparseIntArray.put(com.up366.mobile.R.id.me_photo_img_meng, 3);
        sparseIntArray.put(com.up366.mobile.R.id.jiao, 4);
        sparseIntArray.put(com.up366.mobile.R.id.me_photo_error_text, 5);
        sparseIntArray.put(com.up366.mobile.R.id.me_photo_img_loading, 6);
        sparseIntArray.put(com.up366.mobile.R.id.update_by_user, 7);
        sparseIntArray.put(com.up366.mobile.R.id.confirm_update_btn, 8);
        sparseIntArray.put(com.up366.mobile.R.id.tip_text, 9);
        sparseIntArray.put(com.up366.mobile.R.id.update_by_system, 10);
        sparseIntArray.put(com.up366.mobile.R.id.confirm_cancel_btn, 11);
        sparseIntArray.put(com.up366.mobile.R.id.app_bar, 12);
        sparseIntArray.put(com.up366.mobile.R.id.toolbar_layout, 13);
        sparseIntArray.put(com.up366.mobile.R.id.head_photo_rule, 14);
    }

    public MeSwitchHeadPhotoActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private MeSwitchHeadPhotoActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.google.android.material.appbar.AppBarLayout) objArr[12], (android.widget.TextView) objArr[11], (android.widget.TextView) objArr[8], (android.widget.ImageView) objArr[1], (android.widget.TextView) objArr[14], (android.widget.ImageView) objArr[4], (android.widget.TextView) objArr[5], (com.up366.mobile.common.views.CircleImageView) objArr[2], (android.widget.ImageView) objArr[6], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[9], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[13], (android.widget.TextView) objArr[10], (android.widget.TextView) objArr[7]);
        this.mDirtyFlags = -1L;
        androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout = (androidx.coordinatorlayout.widget.CoordinatorLayout) objArr[0];
        this.mboundView0 = coordinatorLayout;
        coordinatorLayout.setTag((java.lang.Object) null);
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
