package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class TitleviewDropdownLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.FrameLayout dropdownLayout;
    public final androidx.recyclerview.widget.RecyclerView recycleView;

    protected TitleviewDropdownLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.FrameLayout frameLayout, androidx.recyclerview.widget.RecyclerView recyclerView) {
        super(obj, view, i);
        this.dropdownLayout = frameLayout;
        this.recycleView = recyclerView;
    }

    public static com.up366.mobile.databinding.TitleviewDropdownLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TitleviewDropdownLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TitleviewDropdownLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.titleview_dropdown_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.TitleviewDropdownLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TitleviewDropdownLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TitleviewDropdownLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.titleview_dropdown_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.TitleviewDropdownLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TitleviewDropdownLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TitleviewDropdownLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.titleview_dropdown_layout);
    }
}
