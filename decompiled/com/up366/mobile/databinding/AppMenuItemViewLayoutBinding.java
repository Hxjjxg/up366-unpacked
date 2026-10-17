package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AppMenuItemViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView cursor;
    public final android.widget.ImageView icon;
    public final android.widget.TextView subTitle;
    public final android.widget.TextView title;

    protected AppMenuItemViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.ImageView imageView2, android.widget.TextView textView, android.widget.TextView textView2) {
        super(obj, view, i);
        this.cursor = imageView;
        this.icon = imageView2;
        this.subTitle = textView;
        this.title = textView2;
    }

    public static com.up366.mobile.databinding.AppMenuItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AppMenuItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AppMenuItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.app_menu_item_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AppMenuItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AppMenuItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AppMenuItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.app_menu_item_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AppMenuItemViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AppMenuItemViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AppMenuItemViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.app_menu_item_view_layout);
    }
}
