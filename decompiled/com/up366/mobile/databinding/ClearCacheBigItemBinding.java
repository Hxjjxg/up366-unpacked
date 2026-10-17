package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ClearCacheBigItemBinding implements androidx.viewbinding.ViewBinding {
    public final com.up366.mobile.common.views.ClearCacheBookItemView clearCacheBigItemBookInfo;
    public final android.widget.ImageView clearCacheBigItemCheckRadio;
    public final android.widget.RelativeLayout clearCacheBigItemContent;
    private final android.widget.RelativeLayout rootView;
    public final android.widget.TextView tvCacheSize;

    private ClearCacheBigItemBinding(android.widget.RelativeLayout relativeLayout, com.up366.mobile.common.views.ClearCacheBookItemView clearCacheBookItemView, android.widget.ImageView imageView, android.widget.RelativeLayout relativeLayout2, android.widget.TextView textView) {
        this.rootView = relativeLayout;
        this.clearCacheBigItemBookInfo = clearCacheBookItemView;
        this.clearCacheBigItemCheckRadio = imageView;
        this.clearCacheBigItemContent = relativeLayout2;
        this.tvCacheSize = textView;
    }

    public android.widget.RelativeLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.ClearCacheBigItemBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.ClearCacheBigItemBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.clear_cache_big_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.ClearCacheBigItemBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.clear_cache_big_item_book_info;
        com.up366.mobile.common.views.ClearCacheBookItemView clearCacheBookItemView = (com.up366.mobile.common.views.ClearCacheBookItemView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.clear_cache_big_item_book_info);
        if (clearCacheBookItemView != null) {
            i = com.up366.mobile.R.id.clear_cache_big_item_check_radio;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.clear_cache_big_item_check_radio);
            if (imageView != null) {
                android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) view;
                i = com.up366.mobile.R.id.tv_cache_size;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_cache_size);
                if (textView != null) {
                    return new com.up366.mobile.databinding.ClearCacheBigItemBinding(relativeLayout, clearCacheBookItemView, imageView, relativeLayout, textView);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
