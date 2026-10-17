package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class BookTypeSelectorViewLayoutBindingImpl extends com.up366.mobile.databinding.BookTypeSelectorViewLayoutBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    private final com.up366.mobile.databinding.BookTypeSelectorViewLayoutStageItemBinding mboundView1;
    private final com.up366.mobile.databinding.BookTypeSelectorViewLayoutStageItemBinding mboundView11;
    private final com.up366.mobile.databinding.BookTypeItemLayoutBinding mboundView2;
    private final com.up366.mobile.databinding.BookTypeItemLayoutBinding mboundView21;
    private final com.up366.mobile.databinding.BookTypeItemLayoutBinding mboundView22;
    private final com.up366.mobile.databinding.BookTypeItemLayoutBinding mboundView23;
    private final com.up366.mobile.databinding.BookTypeItemLayoutBinding mboundView24;
    private final com.up366.mobile.databinding.BookTypeItemLayoutBinding mboundView25;
    private final com.up366.mobile.databinding.BookTypeItemLayoutBinding mboundView26;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        androidx.databinding.ViewDataBinding.IncludedLayouts includedLayouts = new androidx.databinding.ViewDataBinding.IncludedLayouts(13);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new java.lang.String[]{"book_type_selector_view_layout_stage_item", "book_type_selector_view_layout_stage_item"}, new int[]{10, 11}, new int[]{com.up366.mobile.R.layout.book_type_selector_view_layout_stage_item, com.up366.mobile.R.layout.book_type_selector_view_layout_stage_item});
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.line, 12);
    }

    public BookTypeSelectorViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private BookTypeSelectorViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.view.View) objArr[12], (com.up366.mobile.common.views.TabIndicatorView) objArr[1], (com.up366.mobile.common.views.FlowRadioGroupLayout) objArr[2]);
        this.mDirtyFlags = -1L;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((java.lang.Object) null);
        com.up366.mobile.databinding.BookTypeSelectorViewLayoutStageItemBinding bookTypeSelectorViewLayoutStageItemBinding = (com.up366.mobile.databinding.BookTypeSelectorViewLayoutStageItemBinding) objArr[10];
        this.mboundView1 = bookTypeSelectorViewLayoutStageItemBinding;
        setContainedBinding(bookTypeSelectorViewLayoutStageItemBinding);
        com.up366.mobile.databinding.BookTypeSelectorViewLayoutStageItemBinding bookTypeSelectorViewLayoutStageItemBinding2 = (com.up366.mobile.databinding.BookTypeSelectorViewLayoutStageItemBinding) objArr[11];
        this.mboundView11 = bookTypeSelectorViewLayoutStageItemBinding2;
        setContainedBinding(bookTypeSelectorViewLayoutStageItemBinding2);
        java.lang.Object obj = objArr[3];
        this.mboundView2 = obj != null ? com.up366.mobile.databinding.BookTypeItemLayoutBinding.bind((android.view.View) obj) : null;
        java.lang.Object obj2 = objArr[4];
        this.mboundView21 = obj2 != null ? com.up366.mobile.databinding.BookTypeItemLayoutBinding.bind((android.view.View) obj2) : null;
        java.lang.Object obj3 = objArr[5];
        this.mboundView22 = obj3 != null ? com.up366.mobile.databinding.BookTypeItemLayoutBinding.bind((android.view.View) obj3) : null;
        java.lang.Object obj4 = objArr[6];
        this.mboundView23 = obj4 != null ? com.up366.mobile.databinding.BookTypeItemLayoutBinding.bind((android.view.View) obj4) : null;
        java.lang.Object obj5 = objArr[7];
        this.mboundView24 = obj5 != null ? com.up366.mobile.databinding.BookTypeItemLayoutBinding.bind((android.view.View) obj5) : null;
        java.lang.Object obj6 = objArr[8];
        this.mboundView25 = obj6 != null ? com.up366.mobile.databinding.BookTypeItemLayoutBinding.bind((android.view.View) obj6) : null;
        java.lang.Object obj7 = objArr[9];
        this.mboundView26 = obj7 != null ? com.up366.mobile.databinding.BookTypeItemLayoutBinding.bind((android.view.View) obj7) : null;
        this.tabIndicator.setTag(null);
        this.tagGroup.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
        }
        this.mboundView1.invalidateAll();
        this.mboundView11.invalidateAll();
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.mboundView1.hasPendingBindings() || this.mboundView11.hasPendingBindings();
        }
    }

    public void setLifecycleOwner(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView1.setLifecycleOwner(lifecycleOwner);
        this.mboundView11.setLifecycleOwner(lifecycleOwner);
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        executeBindingsOn(this.mboundView1);
        executeBindingsOn(this.mboundView11);
    }
}
