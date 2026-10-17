package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class WordNoteSelectSortBottomSheetViewBindingImpl extends com.up366.mobile.databinding.WordNoteSelectSortBottomSheetViewBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.tv_add_count, 1);
        sparseIntArray.put(com.up366.mobile.R.id.tv_character_order, 2);
        sparseIntArray.put(com.up366.mobile.R.id.tv_select, 3);
        sparseIntArray.put(com.up366.mobile.R.id.ll_container, 4);
        sparseIntArray.put(com.up366.mobile.R.id.tv_all, 5);
        sparseIntArray.put(com.up366.mobile.R.id.tv_ren_du, 6);
        sparseIntArray.put(com.up366.mobile.R.id.tv_pin_xie, 7);
        sparseIntArray.put(com.up366.mobile.R.id.tv_yun_yong, 8);
        sparseIntArray.put(com.up366.mobile.R.id.tv_ting_shuo, 9);
        sparseIntArray.put(com.up366.mobile.R.id.tv_qi_ta, 10);
        sparseIntArray.put(com.up366.mobile.R.id.tv_confirm, 11);
    }

    public WordNoteSelectSortBottomSheetViewBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private WordNoteSelectSortBottomSheetViewBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.LinearLayout) objArr[4], (android.widget.TextView) objArr[1], (android.widget.TextView) objArr[5], (android.widget.TextView) objArr[2], (android.widget.TextView) objArr[11], (android.widget.TextView) objArr[7], (android.widget.TextView) objArr[10], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[3], (android.widget.TextView) objArr[9], (android.widget.TextView) objArr[8]);
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
