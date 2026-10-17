package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeAddTearchingClassAcivityLayoutBindingImpl extends com.up366.mobile.databinding.MeAddTearchingClassAcivityLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.qr_search_class, 3);
        sparseIntArray.put(com.up366.mobile.R.id.content_layout, 4);
        sparseIntArray.put(com.up366.mobile.R.id.search_text, 5);
        sparseIntArray.put(com.up366.mobile.R.id.searcher_image, 6);
        sparseIntArray.put(com.up366.mobile.R.id.searcher_delete_image, 7);
        sparseIntArray.put(com.up366.mobile.R.id.empty_state, 8);
        sparseIntArray.put(com.up366.mobile.R.id.course_info_layout, 9);
        sparseIntArray.put(com.up366.mobile.R.id.course_name, 10);
        sparseIntArray.put(com.up366.mobile.R.id.teacher_name, 11);
        sparseIntArray.put(com.up366.mobile.R.id.approve_status, 12);
        sparseIntArray.put(com.up366.mobile.R.id.approve_loading, 13);
        sparseIntArray.put(com.up366.mobile.R.id.approve_btn, 14);
        sparseIntArray.put(com.up366.mobile.R.id.add_how_get_course, 15);
        sparseIntArray.put(com.up366.mobile.R.id.place_holder, 16);
    }

    public MeAddTearchingClassAcivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private MeAddTearchingClassAcivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[15], (com.google.android.material.appbar.AppBarLayout) objArr[1], (android.widget.TextView) objArr[14], (android.widget.ImageView) objArr[13], (android.widget.TextView) objArr[12], (android.widget.LinearLayout) objArr[4], (androidx.constraintlayout.widget.ConstraintLayout) objArr[9], (android.widget.TextView) objArr[10], (com.up366.mobile.common.views.EmptyStateView) objArr[8], (android.view.View) objArr[16], (android.widget.ImageView) objArr[3], (com.up366.mobile.common.views.CommonEditText) objArr[5], (android.widget.ImageView) objArr[7], (android.widget.ImageView) objArr[6], (android.widget.TextView) objArr[11], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[2]);
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
