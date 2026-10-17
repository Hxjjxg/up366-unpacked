package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeMainFragmentLayoutBindingImpl extends com.up366.mobile.databinding.MeMainFragmentLayoutBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.refreshLayout, 1);
        sparseIntArray.put(com.up366.mobile.R.id.scroll_view, 2);
        sparseIntArray.put(com.up366.mobile.R.id.scan_title, 3);
        sparseIntArray.put(com.up366.mobile.R.id.head_view, 4);
        sparseIntArray.put(com.up366.mobile.R.id.parent_tip_text, 5);
        sparseIntArray.put(com.up366.mobile.R.id.parent_tip_close, 6);
        sparseIntArray.put(com.up366.mobile.R.id.me_study_card_update, 7);
        sparseIntArray.put(com.up366.mobile.R.id.me_course_view, 8);
        sparseIntArray.put(com.up366.mobile.R.id.me_teaching_class, 9);
        sparseIntArray.put(com.up366.mobile.R.id.me_divider_4, 10);
        sparseIntArray.put(com.up366.mobile.R.id.me_help, 11);
        sparseIntArray.put(com.up366.mobile.R.id.me_divider_5, 12);
        sparseIntArray.put(com.up366.mobile.R.id.me_feedback, 13);
        sparseIntArray.put(com.up366.mobile.R.id.me_divider_6, 14);
        sparseIntArray.put(com.up366.mobile.R.id.me_set_up, 15);
    }

    public MeMainFragmentLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private MeMainFragmentLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.up366.mobile.me.views.MeFragmentHeadPhotoItemView) objArr[4], (com.up366.mobile.common.views.me.MeCourseBookView) objArr[8], (android.view.View) objArr[10], (android.view.View) objArr[12], (android.view.View) objArr[14], (com.up366.mobile.common.views.me.MeItemView) objArr[13], (com.up366.mobile.common.views.me.MeItemView) objArr[11], (com.up366.mobile.common.views.me.MeItemView) objArr[15], (com.up366.mobile.common.views.me.MeStudyCardUpdateView) objArr[7], (com.up366.mobile.common.views.me.MeItemView) objArr[9], (android.widget.ImageView) objArr[6], (android.widget.TextView) objArr[5], (com.ylw.pullrefreshlibrary.PullRefreshLayout) objArr[1], (android.widget.FrameLayout) objArr[0], (com.up366.mobile.me.views.MeFragmentScanPhotoView) objArr[3], (androidx.core.widget.NestedScrollView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.rootView.setTag(null);
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
