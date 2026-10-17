package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class DropdownLayoutArrowSmallBinding extends androidx.databinding.ViewDataBinding {
    public final androidx.cardview.widget.CardView cardView;
    public final androidx.recyclerview.widget.RecyclerView recycleView;

    protected DropdownLayoutArrowSmallBinding(java.lang.Object obj, android.view.View view, int i, androidx.cardview.widget.CardView cardView, androidx.recyclerview.widget.RecyclerView recyclerView) {
        super(obj, view, i);
        this.cardView = cardView;
        this.recycleView = recyclerView;
    }

    public static com.up366.mobile.databinding.DropdownLayoutArrowSmallBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.DropdownLayoutArrowSmallBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.DropdownLayoutArrowSmallBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.dropdown_layout_arrow_small, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.DropdownLayoutArrowSmallBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.DropdownLayoutArrowSmallBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.DropdownLayoutArrowSmallBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.dropdown_layout_arrow_small, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.DropdownLayoutArrowSmallBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.DropdownLayoutArrowSmallBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.DropdownLayoutArrowSmallBinding) bind(obj, view, com.up366.mobile.R.layout.dropdown_layout_arrow_small);
    }
}
