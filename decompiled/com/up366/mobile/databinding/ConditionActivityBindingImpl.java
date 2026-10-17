package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ConditionActivityBindingImpl extends com.up366.mobile.databinding.ConditionActivityBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.title_bar, 1);
        sparseIntArray.put(com.up366.mobile.R.id.llNoteType, 2);
        sparseIntArray.put(com.up366.mobile.R.id.noteAll, 3);
        sparseIntArray.put(com.up366.mobile.R.id.noteRead, 4);
        sparseIntArray.put(com.up366.mobile.R.id.noteWrite, 5);
        sparseIntArray.put(com.up366.mobile.R.id.noteUse, 6);
        sparseIntArray.put(com.up366.mobile.R.id.noteListen, 7);
        sparseIntArray.put(com.up366.mobile.R.id.noteOther, 8);
        sparseIntArray.put(com.up366.mobile.R.id.llTimeSelect, 9);
        sparseIntArray.put(com.up366.mobile.R.id.llTimeSelectTitle, 10);
        sparseIntArray.put(com.up366.mobile.R.id.timeBtnAll, 11);
        sparseIntArray.put(com.up366.mobile.R.id.timeBtnToday, 12);
        sparseIntArray.put(com.up366.mobile.R.id.timeBtnWeek, 13);
        sparseIntArray.put(com.up366.mobile.R.id.timeBtnMouth, 14);
        sparseIntArray.put(com.up366.mobile.R.id.dateBtnLl, 15);
        sparseIntArray.put(com.up366.mobile.R.id.dateBtnBegin, 16);
        sparseIntArray.put(com.up366.mobile.R.id.dateBtnEnd, 17);
        sparseIntArray.put(com.up366.mobile.R.id.llBookList, 18);
        sparseIntArray.put(com.up366.mobile.R.id.tv_list_title, 19);
        sparseIntArray.put(com.up366.mobile.R.id.refresh_layout, 20);
        sparseIntArray.put(com.up366.mobile.R.id.recycle_view, 21);
        sparseIntArray.put(com.up366.mobile.R.id.view, 22);
        sparseIntArray.put(com.up366.mobile.R.id.btnReset, 23);
        sparseIntArray.put(com.up366.mobile.R.id.btnConfirm, 24);
    }

    public ConditionActivityBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 25, sIncludes, sViewsWithIds));
    }

    private ConditionActivityBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[24], (android.widget.TextView) objArr[23], (android.widget.CheckedTextView) objArr[16], (android.widget.CheckedTextView) objArr[17], (android.widget.LinearLayout) objArr[15], (android.widget.LinearLayout) objArr[18], (android.widget.LinearLayout) objArr[2], (android.widget.LinearLayout) objArr[9], (android.widget.TextView) objArr[10], (android.widget.CheckedTextView) objArr[3], (android.widget.CheckedTextView) objArr[7], (android.widget.CheckedTextView) objArr[8], (android.widget.CheckedTextView) objArr[4], (android.widget.CheckedTextView) objArr[6], (android.widget.CheckedTextView) objArr[5], (androidx.recyclerview.widget.RecyclerView) objArr[21], (com.ylw.pullrefreshlibrary.PullRefreshLayout) objArr[20], (android.widget.CheckedTextView) objArr[11], (android.widget.CheckedTextView) objArr[14], (android.widget.CheckedTextView) objArr[12], (android.widget.CheckedTextView) objArr[13], (com.up366.mobile.common.views.TitleBarView) objArr[1], (android.widget.TextView) objArr[19], (android.view.View) objArr[22]);
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
