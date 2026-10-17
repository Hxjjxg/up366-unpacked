package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class BookChapterHeadLayoutBindingImpl extends com.up366.mobile.databinding.BookChapterHeadLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.book_pic, 1);
        sparseIntArray.put(com.up366.mobile.R.id.has_buy_tip_content, 2);
        sparseIntArray.put(com.up366.mobile.R.id.remain_time, 3);
        sparseIntArray.put(com.up366.mobile.R.id.no_buy_text, 4);
        sparseIntArray.put(com.up366.mobile.R.id.time_tip, 5);
        sparseIntArray.put(com.up366.mobile.R.id.price, 6);
        sparseIntArray.put(com.up366.mobile.R.id.buy_btn, 7);
        sparseIntArray.put(com.up366.mobile.R.id.buy_content_line, 8);
        sparseIntArray.put(com.up366.mobile.R.id.continue_learn, 9);
        sparseIntArray.put(com.up366.mobile.R.id.last_time, 10);
        sparseIntArray.put(com.up366.mobile.R.id.last_position, 11);
        sparseIntArray.put(com.up366.mobile.R.id.cursor, 12);
        sparseIntArray.put(com.up366.mobile.R.id.download_all, 13);
        sparseIntArray.put(com.up366.mobile.R.id.download_all_line, 14);
    }

    public BookChapterHeadLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private BookChapterHeadLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.ImageView) objArr[1], (android.widget.Button) objArr[7], (android.view.View) objArr[8], (android.widget.LinearLayout) objArr[9], (android.widget.ImageView) objArr[12], (android.widget.LinearLayout) objArr[13], (android.view.View) objArr[14], (android.widget.LinearLayout) objArr[2], (android.widget.TextView) objArr[11], (android.widget.TextView) objArr[10], (android.widget.LinearLayout) objArr[4], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[5]);
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
