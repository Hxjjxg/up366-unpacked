package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class WordNoteListContentItemBindingImpl extends com.up366.mobile.databinding.WordNoteListContentItemBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.clContent, 1);
        sparseIntArray.put(com.up366.mobile.R.id.v_bottom_line, 2);
        sparseIntArray.put(com.up366.mobile.R.id.tv_word_category, 3);
        sparseIntArray.put(com.up366.mobile.R.id.tv_word_content, 4);
        sparseIntArray.put(com.up366.mobile.R.id.tv_add_count, 5);
        sparseIntArray.put(com.up366.mobile.R.id.iv_play_icon, 6);
        sparseIntArray.put(2131361951, 7);
        sparseIntArray.put(com.up366.mobile.R.id.tv_word_explain, 8);
        sparseIntArray.put(com.up366.mobile.R.id.tv_finish_count, 9);
        sparseIntArray.put(com.up366.mobile.R.id.delete_btn, 10);
    }

    public WordNoteListContentItemBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private WordNoteListContentItemBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (androidx.constraintlayout.widget.Barrier) objArr[7], (androidx.constraintlayout.widget.ConstraintLayout) objArr[1], (android.widget.TextView) objArr[10], (com.airbnb.lottie.LottieAnimationView) objArr[6], (com.up366.mobile.common.views.ListItemDragLayout) objArr[0], (android.widget.TextView) objArr[5], (android.widget.TextView) objArr[9], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[4], (android.widget.TextView) objArr[8], (android.view.View) objArr[2]);
        this.mDirtyFlags = -1L;
        this.listItemDragLayout.setTag(null);
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
