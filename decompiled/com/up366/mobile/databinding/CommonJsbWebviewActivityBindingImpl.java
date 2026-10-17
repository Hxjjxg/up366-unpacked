package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CommonJsbWebviewActivityBindingImpl extends com.up366.mobile.databinding.CommonJsbWebviewActivityBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final androidx.appcompat.widget.LinearLayoutCompat mboundView0;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.title_bar, 1);
        sparseIntArray.put(com.up366.mobile.R.id.content_layout, 2);
        sparseIntArray.put(com.up366.mobile.R.id.web_view, 3);
        sparseIntArray.put(com.up366.mobile.R.id.empty_state_view_layout, 4);
        sparseIntArray.put(com.up366.mobile.R.id.empty_state_view, 5);
    }

    public CommonJsbWebviewActivityBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private CommonJsbWebviewActivityBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.FrameLayout) objArr[2], (com.up366.mobile.common.views.EmptyStateView) objArr[5], (androidx.core.widget.NestedScrollView) objArr[4], (com.up366.mobile.common.views.TitleBarView) objArr[1], (com.up366.mobile.book.webview.StudyPageWebView) objArr[3]);
        this.mDirtyFlags = -1L;
        androidx.appcompat.widget.LinearLayoutCompat linearLayoutCompat = (androidx.appcompat.widget.LinearLayoutCompat) objArr[0];
        this.mboundView0 = linearLayoutCompat;
        linearLayoutCompat.setTag((java.lang.Object) null);
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
