package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class TitleviewDropdownLayoutArrowBinding extends androidx.databinding.ViewDataBinding {
    public final android.view.View dropdownUpview;
    public final androidx.recyclerview.widget.RecyclerView recycleView;

    protected TitleviewDropdownLayoutArrowBinding(java.lang.Object obj, android.view.View view, int i, android.view.View view2, androidx.recyclerview.widget.RecyclerView recyclerView) {
        super(obj, view, i);
        this.dropdownUpview = view2;
        this.recycleView = recyclerView;
    }

    public static com.up366.mobile.databinding.TitleviewDropdownLayoutArrowBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TitleviewDropdownLayoutArrowBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TitleviewDropdownLayoutArrowBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.titleview_dropdown_layout_arrow, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.TitleviewDropdownLayoutArrowBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TitleviewDropdownLayoutArrowBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TitleviewDropdownLayoutArrowBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.titleview_dropdown_layout_arrow, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.TitleviewDropdownLayoutArrowBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TitleviewDropdownLayoutArrowBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TitleviewDropdownLayoutArrowBinding) bind(obj, view, com.up366.mobile.R.layout.titleview_dropdown_layout_arrow);
    }
}
