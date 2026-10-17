package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MarketProductActivityLayoutBindingImpl extends com.up366.mobile.databinding.MarketProductActivityLayoutBinding {
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
        sparseIntArray.put(2131363159, 1);
        sparseIntArray.put(2131363488, 2);
        sparseIntArray.put(2131362573, 3);
        sparseIntArray.put(com.up366.mobile.R.id.name, 4);
        sparseIntArray.put(com.up366.mobile.R.id.buyCount, 5);
        sparseIntArray.put(com.up366.mobile.R.id.contentLayout, 6);
        sparseIntArray.put(com.up366.mobile.R.id.days_tip, 7);
        sparseIntArray.put(com.up366.mobile.R.id.remain, 8);
        sparseIntArray.put(com.up366.mobile.R.id.rePay, 9);
        sparseIntArray.put(com.up366.mobile.R.id.webview, 10);
        sparseIntArray.put(com.up366.mobile.R.id.loading, 11);
        sparseIntArray.put(com.up366.mobile.R.id.error, 12);
        sparseIntArray.put(com.up366.mobile.R.id.anim, 13);
        sparseIntArray.put(com.up366.mobile.R.id.tip, 14);
        sparseIntArray.put(com.up366.mobile.R.id.titleBar, 15);
        sparseIntArray.put(com.up366.mobile.R.id.bottomBtnGroup, 16);
        sparseIntArray.put(com.up366.mobile.R.id.tryIt, 17);
        sparseIntArray.put(com.up366.mobile.R.id.buyIt, 18);
        sparseIntArray.put(com.up366.mobile.R.id.studyIt, 19);
    }

    public MarketProductActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private MarketProductActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.airbnb.lottie.LottieAnimationView) objArr[13], (android.widget.LinearLayout) objArr[16], (android.widget.TextView) objArr[5], (android.widget.Button) objArr[18], (android.widget.LinearLayout) objArr[6], (android.widget.LinearLayout) objArr[7], (android.widget.ImageView) objArr[12], (android.widget.ImageView) objArr[3], (android.widget.LinearLayout) objArr[11], (android.widget.TextView) objArr[4], (android.widget.Button) objArr[9], (android.widget.TextView) objArr[8], (com.up366.mobile.common.views.ScrollViewWithScrollChangeListener) objArr[1], (android.widget.Button) objArr[19], (android.widget.TextView) objArr[14], (com.up366.mobile.common.views.TitleBarView) objArr[15], (androidx.constraintlayout.widget.ConstraintLayout) objArr[2], (android.widget.Button) objArr[17], (com.up366.mobile.book.webview.StudyPageWebView) objArr[10]);
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
