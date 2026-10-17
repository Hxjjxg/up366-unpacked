package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ActivityTaskBindingImpl extends com.up366.mobile.databinding.ActivityTaskBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.app_bar, 1);
        sparseIntArray.put(com.up366.mobile.R.id.toolbar_layout, 2);
        sparseIntArray.put(com.up366.mobile.R.id.cl_book, 3);
        sparseIntArray.put(com.up366.mobile.R.id.ib_wrong_word, 4);
        sparseIntArray.put(com.up366.mobile.R.id.ib_strange_word, 5);
        sparseIntArray.put(com.up366.mobile.R.id.search, 6);
        sparseIntArray.put(com.up366.mobile.R.id.toolbar, 7);
        sparseIntArray.put(com.up366.mobile.R.id.title_back_view, 8);
        sparseIntArray.put(com.up366.mobile.R.id.cl_tab, 9);
        sparseIntArray.put(com.up366.mobile.R.id.tabSegment, 10);
        sparseIntArray.put(com.up366.mobile.R.id.ll_select_book, 11);
        sparseIntArray.put(com.up366.mobile.R.id.tv_current_select_book, 12);
        sparseIntArray.put(com.up366.mobile.R.id.tv_history_select_book, 13);
        sparseIntArray.put(com.up366.mobile.R.id.tv_sort, 14);
        sparseIntArray.put(com.up366.mobile.R.id.switch_only_unanswered, 15);
        sparseIntArray.put(com.up366.mobile.R.id.viewpager, 16);
        sparseIntArray.put(com.up366.mobile.R.id.ll_teacher_ask, 17);
        sparseIntArray.put(com.up366.mobile.R.id.rv_ask, 18);
        sparseIntArray.put(com.up366.mobile.R.id.bt_close, 19);
    }

    public ActivityTaskBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private ActivityTaskBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.google.android.material.appbar.AppBarLayout) objArr[1], (com.up366.mobile.common.views.UpScrollExitFrameLayout) objArr[19], (androidx.constraintlayout.widget.ConstraintLayout) objArr[3], (androidx.constraintlayout.widget.ConstraintLayout) objArr[9], (android.widget.ImageButton) objArr[5], (android.widget.ImageButton) objArr[4], (android.widget.LinearLayout) objArr[11], (com.up366.mobile.common.views.MaxHeightLayout) objArr[17], (android.widget.FrameLayout) objArr[0], (androidx.recyclerview.widget.RecyclerView) objArr[18], (android.widget.EditText) objArr[6], (androidx.appcompat.widget.SwitchCompat) objArr[15], (com.up366.qmui.widget.tab.QMUITabSegment) objArr[10], (com.up366.mobile.common.views.TitleBackView) objArr[8], (androidx.appcompat.widget.Toolbar) objArr[7], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[2], (android.widget.TextView) objArr[12], (android.widget.CheckedTextView) objArr[13], (android.widget.TextView) objArr[14], (androidx.viewpager.widget.ViewPager) objArr[16]);
        this.mDirtyFlags = -1L;
        this.rootLayout.setTag(null);
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
