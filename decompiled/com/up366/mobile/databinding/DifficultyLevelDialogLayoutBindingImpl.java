package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class DifficultyLevelDialogLayoutBindingImpl extends com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final com.up366.mobile.common.views.PaddingShadowLayout mboundView0;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.imageView6, 1);
        sparseIntArray.put(com.up366.mobile.R.id.difficulty_level_1, 2);
        sparseIntArray.put(com.up366.mobile.R.id.radio_button_1, 3);
        sparseIntArray.put(com.up366.mobile.R.id.level_text1, 4);
        sparseIntArray.put(com.up366.mobile.R.id.difficulty_level_2, 5);
        sparseIntArray.put(com.up366.mobile.R.id.radio_button_2, 6);
        sparseIntArray.put(com.up366.mobile.R.id.level_text2, 7);
        sparseIntArray.put(com.up366.mobile.R.id.difficulty_level_3, 8);
        sparseIntArray.put(com.up366.mobile.R.id.radio_button_3, 9);
        sparseIntArray.put(com.up366.mobile.R.id.level_text3, 10);
        sparseIntArray.put(com.up366.mobile.R.id.difficulty_level_4, 11);
        sparseIntArray.put(com.up366.mobile.R.id.radio_button_4, 12);
        sparseIntArray.put(com.up366.mobile.R.id.level_text4, 13);
        sparseIntArray.put(com.up366.mobile.R.id.difficulty_level_5, 14);
        sparseIntArray.put(com.up366.mobile.R.id.radio_button_5, 15);
        sparseIntArray.put(com.up366.mobile.R.id.level_text5, 16);
        sparseIntArray.put(com.up366.mobile.R.id.btn_confirm, 17);
        sparseIntArray.put(com.up366.mobile.R.id.btn_close, 18);
    }

    public DifficultyLevelDialogLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 19, sIncludes, sViewsWithIds));
    }

    private DifficultyLevelDialogLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.ImageView) objArr[18], (android.widget.TextView) objArr[17], (android.widget.RelativeLayout) objArr[2], (android.widget.RelativeLayout) objArr[5], (android.widget.RelativeLayout) objArr[8], (android.widget.RelativeLayout) objArr[11], (android.widget.RelativeLayout) objArr[14], (android.widget.ImageView) objArr[1], (android.widget.TextView) objArr[4], (android.widget.TextView) objArr[7], (android.widget.TextView) objArr[10], (android.widget.TextView) objArr[13], (android.widget.TextView) objArr[16], (android.widget.RadioButton) objArr[3], (android.widget.RadioButton) objArr[6], (android.widget.RadioButton) objArr[9], (android.widget.RadioButton) objArr[12], (android.widget.RadioButton) objArr[15]);
        this.mDirtyFlags = -1L;
        com.up366.mobile.common.views.PaddingShadowLayout paddingShadowLayout = (com.up366.mobile.common.views.PaddingShadowLayout) objArr[0];
        this.mboundView0 = paddingShadowLayout;
        paddingShadowLayout.setTag(null);
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
