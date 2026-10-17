package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class AdapterSnippetsTopShadowBinding implements androidx.viewbinding.ViewBinding {
    private final com.up366.mobile.common.views.PaddingShadowLayout rootView;

    private AdapterSnippetsTopShadowBinding(com.up366.mobile.common.views.PaddingShadowLayout paddingShadowLayout) {
        this.rootView = paddingShadowLayout;
    }

    public com.up366.mobile.common.views.PaddingShadowLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.AdapterSnippetsTopShadowBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.AdapterSnippetsTopShadowBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.adapter_snippets_top_shadow, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.AdapterSnippetsTopShadowBinding bind(android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        return new com.up366.mobile.databinding.AdapterSnippetsTopShadowBinding((com.up366.mobile.common.views.PaddingShadowLayout) view);
    }
}
