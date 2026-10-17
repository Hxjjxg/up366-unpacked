package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class UserFeedbackActivityLayoutBindingImpl extends com.up366.mobile.databinding.UserFeedbackActivityLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.app_bar, 1);
        sparseIntArray.put(com.up366.mobile.R.id.toolbar_layout, 2);
        sparseIntArray.put(com.up366.mobile.R.id.feedback_scrollview, 3);
        sparseIntArray.put(com.up366.mobile.R.id.feedback_text1, 4);
        sparseIntArray.put(com.up366.mobile.R.id.feedback_content_et, 5);
        sparseIntArray.put(com.up366.mobile.R.id.feedback_text2, 6);
        sparseIntArray.put(com.up366.mobile.R.id.feedback_phone_et, 7);
        sparseIntArray.put(com.up366.mobile.R.id.cancel_btn, 8);
        sparseIntArray.put(com.up366.mobile.R.id.feedback_divider, 9);
        sparseIntArray.put(com.up366.mobile.R.id.feedback_text3, 10);
        sparseIntArray.put(com.up366.mobile.R.id.feedback_pic_layout, 11);
        sparseIntArray.put(com.up366.mobile.R.id.feedback_pic, 12);
        sparseIntArray.put(com.up366.mobile.R.id.feedback_submit_btn, 13);
        sparseIntArray.put(com.up366.mobile.R.id.feed_tip, 14);
        sparseIntArray.put(com.up366.mobile.R.id.feed_phone, 15);
        sparseIntArray.put(com.up366.mobile.R.id.feed_email, 16);
        sparseIntArray.put(com.up366.mobile.R.id.icon_feed_wechat, 17);
    }

    public UserFeedbackActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
    }

    private UserFeedbackActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.google.android.material.appbar.AppBarLayout) objArr[1], (android.widget.TextView) objArr[8], (android.widget.TextView) objArr[16], (android.widget.TextView) objArr[15], (android.widget.TextView) objArr[14], (com.up366.mobile.common.views.CustomEditText) objArr[5], (android.view.View) objArr[9], (com.up366.mobile.common.views.CommonEditText) objArr[7], (com.up366.multimedia.views.PictureVideoGridView) objArr[12], (android.widget.FrameLayout) objArr[11], (android.widget.ScrollView) objArr[3], (android.widget.TextView) objArr[13], (android.widget.TextView) objArr[4], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[10], (android.widget.TextView) objArr[17], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[2]);
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
