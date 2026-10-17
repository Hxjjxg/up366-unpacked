package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ClearCacheLittleItemBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.TextView clearCacheLittleItemCacheName;
    public final android.widget.ImageView clearCacheLittleItemCheckRadio;
    public final android.widget.LinearLayout clearCacleLittleItemContent;
    private final android.widget.LinearLayout rootView;
    public final android.widget.TextView tvCacheSize;

    private ClearCacheLittleItemBinding(android.widget.LinearLayout linearLayout, android.widget.TextView textView, android.widget.ImageView imageView, android.widget.LinearLayout linearLayout2, android.widget.TextView textView2) {
        this.rootView = linearLayout;
        this.clearCacheLittleItemCacheName = textView;
        this.clearCacheLittleItemCheckRadio = imageView;
        this.clearCacleLittleItemContent = linearLayout2;
        this.tvCacheSize = textView2;
    }

    public android.widget.LinearLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.ClearCacheLittleItemBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.ClearCacheLittleItemBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.clear_cache_little_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.ClearCacheLittleItemBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.clear_cache_little_item_cache_name;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.clear_cache_little_item_cache_name);
        if (textView != null) {
            i = com.up366.mobile.R.id.clear_cache_little_item_check_radio;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.clear_cache_little_item_check_radio);
            if (imageView != null) {
                android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) view;
                i = com.up366.mobile.R.id.tv_cache_size;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_cache_size);
                if (textView2 != null) {
                    return new com.up366.mobile.databinding.ClearCacheLittleItemBinding(linearLayout, textView, imageView, linearLayout, textView2);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
