package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CountFragmentBindingImpl extends com.up366.mobile.databinding.CountFragmentBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final android.widget.FrameLayout mboundView0;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.bg, 1);
        sparseIntArray.put(com.up366.mobile.R.id.titleBar, 2);
        sparseIntArray.put(com.up366.mobile.R.id.refreshLayout, 3);
        sparseIntArray.put(com.up366.mobile.R.id.count_html_content, 4);
        sparseIntArray.put(com.up366.mobile.R.id.anim, 5);
        sparseIntArray.put(com.up366.mobile.R.id.html_count_no_textbook, 6);
        sparseIntArray.put(com.up366.mobile.R.id.no_data_login_iv, 7);
        sparseIntArray.put(com.up366.mobile.R.id.no_data_login_tv, 8);
    }

    public CountFragmentBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private CountFragmentBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.ProgressBar) objArr[5], (com.up366.mobile.common.views.HeadSemicircleBackgroundView) objArr[1], (android.widget.FrameLayout) objArr[4], (android.widget.LinearLayout) objArr[6], (android.widget.ImageView) objArr[7], (android.widget.TextView) objArr[8], (com.ylw.pullrefreshlibrary.PullRefreshLayout) objArr[3], (com.up366.mobile.common.views.TitleBarView) objArr[2]);
        this.mDirtyFlags = -1L;
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
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
