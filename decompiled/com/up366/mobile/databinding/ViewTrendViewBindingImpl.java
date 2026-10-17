package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ViewTrendViewBindingImpl extends com.up366.mobile.databinding.ViewTrendViewBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.iv_trend_title, 1);
        sparseIntArray.put(com.up366.mobile.R.id.tv_trend_title, 2);
        sparseIntArray.put(com.up366.mobile.R.id.tv_last_compare, 3);
        sparseIntArray.put(com.up366.mobile.R.id.iv_last_compare, 4);
        sparseIntArray.put(com.up366.mobile.R.id.rb_my_line_color, 5);
        sparseIntArray.put(com.up366.mobile.R.id.rb_school_line_color, 6);
        sparseIntArray.put(com.up366.mobile.R.id.rb_earth_line_color, 7);
        sparseIntArray.put(com.up366.mobile.R.id.tv_chart_y_title, 8);
        sparseIntArray.put(com.up366.mobile.R.id.lsv__show_chart, 9);
    }

    public ViewTrendViewBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ViewTrendViewBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.ImageView) objArr[4], (android.widget.ImageView) objArr[1], (com.up366.mobile.common.views.LineSheetViewV3) objArr[9], (android.widget.RadioButton) objArr[7], (android.widget.RadioButton) objArr[5], (android.widget.RadioButton) objArr[6], (android.widget.TextView) objArr[8], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[2]);
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
