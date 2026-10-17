package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CommonWebViewActivityLayoutBindingImpl extends com.up366.mobile.databinding.CommonWebViewActivityLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.toolbar, 3);
        sparseIntArray.put(com.up366.mobile.R.id.title_back, 4);
        sparseIntArray.put(2131363459, 5);
        sparseIntArray.put(com.up366.mobile.R.id.common_webview_progressbar, 6);
        sparseIntArray.put(com.up366.mobile.R.id.content_layout, 7);
        sparseIntArray.put(com.up366.mobile.R.id.web_view, 8);
        sparseIntArray.put(com.up366.mobile.R.id.empty_state_view_layout, 9);
        sparseIntArray.put(com.up366.mobile.R.id.empty_state_view, 10);
    }

    public CommonWebViewActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private CommonWebViewActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.google.android.material.appbar.AppBarLayout) objArr[1], (android.widget.ProgressBar) objArr[6], (android.widget.FrameLayout) objArr[7], (com.up366.mobile.common.views.EmptyStateView) objArr[10], (androidx.core.widget.NestedScrollView) objArr[9], (com.up366.mobile.common.views.MarqueeTextView) objArr[5], (com.up366.mobile.common.views.TitleBackView) objArr[4], (androidx.appcompat.widget.Toolbar) objArr[3], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[2], (com.up366.mobile.book.webview.StudyPageWebView) objArr[8]);
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
