package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ViewTrendFilterDayPickerBindingImpl extends com.up366.mobile.databinding.ViewTrendFilterDayPickerBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final android.widget.LinearLayout mboundView0;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.rl_title, 1);
        sparseIntArray.put(com.up366.mobile.R.id.ib_close, 2);
        sparseIntArray.put(com.up366.mobile.R.id.bt_start_time, 3);
        sparseIntArray.put(com.up366.mobile.R.id.bt_end_time, 4);
        sparseIntArray.put(com.up366.mobile.R.id.wv_year, 5);
        sparseIntArray.put(com.up366.mobile.R.id.wv_month, 6);
        sparseIntArray.put(com.up366.mobile.R.id.bottom_confirm, 7);
    }

    public ViewTrendFilterDayPickerBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ViewTrendFilterDayPickerBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.Button) objArr[7], (android.widget.Button) objArr[4], (android.widget.Button) objArr[3], (android.widget.ImageButton) objArr[2], (android.widget.RelativeLayout) objArr[1], (com.up366.view.wheelview.WheelView) objArr[6], (com.up366.view.wheelview.WheelView) objArr[5]);
        this.mDirtyFlags = -1L;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
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
