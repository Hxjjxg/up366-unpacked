package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class BookTypeSelectorViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.view.View line;
    public final com.up366.mobile.common.views.TabIndicatorView tabIndicator;
    public final com.up366.mobile.common.views.FlowRadioGroupLayout tagGroup;

    protected BookTypeSelectorViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.view.View view2, com.up366.mobile.common.views.TabIndicatorView tabIndicatorView, com.up366.mobile.common.views.FlowRadioGroupLayout flowRadioGroupLayout) {
        super(obj, view, i);
        this.line = view2;
        this.tabIndicator = tabIndicatorView;
        this.tagGroup = flowRadioGroupLayout;
    }

    public static com.up366.mobile.databinding.BookTypeSelectorViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BookTypeSelectorViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BookTypeSelectorViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.book_type_selector_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.BookTypeSelectorViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BookTypeSelectorViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BookTypeSelectorViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.book_type_selector_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.BookTypeSelectorViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BookTypeSelectorViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BookTypeSelectorViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.book_type_selector_view_layout);
    }
}
