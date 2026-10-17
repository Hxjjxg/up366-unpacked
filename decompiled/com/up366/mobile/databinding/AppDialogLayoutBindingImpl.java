package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AppDialogLayoutBindingImpl extends com.up366.mobile.databinding.AppDialogLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.head_img, 2);
        sparseIntArray.put(2131363459, 3);
        sparseIntArray.put(com.up366.mobile.R.id.title_scroll_view, 4);
        sparseIntArray.put(com.up366.mobile.R.id.message_title, 5);
        sparseIntArray.put(com.up366.mobile.R.id.content_scroll_view, 6);
        sparseIntArray.put(2131362830, 7);
        sparseIntArray.put(com.up366.mobile.R.id.button_container, 8);
        sparseIntArray.put(com.up366.mobile.R.id.btn_left, 9);
        sparseIntArray.put(com.up366.mobile.R.id.btn_right, 10);
        sparseIntArray.put(com.up366.mobile.R.id.btn_one, 11);
        sparseIntArray.put(com.up366.mobile.R.id.btn_big, 12);
        sparseIntArray.put(com.up366.mobile.R.id.tip, 13);
        sparseIntArray.put(com.up366.mobile.R.id.clickTip, 14);
        sparseIntArray.put(com.up366.mobile.R.id.btn_close, 15);
        sparseIntArray.put(com.up366.mobile.R.id.button_container_v2, 16);
        sparseIntArray.put(com.up366.mobile.R.id.line_v2_top, 17);
        sparseIntArray.put(com.up366.mobile.R.id.btn_v2_left, 18);
        sparseIntArray.put(com.up366.mobile.R.id.line_v2_center, 19);
        sparseIntArray.put(com.up366.mobile.R.id.btn_v2_right, 20);
    }

    public AppDialogLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private AppDialogLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[12], (android.widget.ImageView) objArr[15], (android.widget.TextView) objArr[9], (android.widget.TextView) objArr[11], (android.widget.TextView) objArr[10], (android.widget.TextView) objArr[18], (android.widget.TextView) objArr[20], (android.widget.LinearLayout) objArr[8], (androidx.constraintlayout.widget.ConstraintLayout) objArr[16], (android.widget.TextView) objArr[14], (android.widget.LinearLayout) objArr[1], (android.widget.ScrollView) objArr[6], (android.widget.ImageView) objArr[2], (android.view.View) objArr[19], (android.view.View) objArr[17], (android.widget.TextView) objArr[7], (android.widget.TextView) objArr[5], (android.widget.TextView) objArr[13], (android.widget.TextView) objArr[3], (android.widget.ScrollView) objArr[4]);
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
