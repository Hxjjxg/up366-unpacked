package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class AdapterSnippetsLinePadding37dpBinding implements androidx.viewbinding.ViewBinding {
    private final android.widget.FrameLayout rootView;

    private AdapterSnippetsLinePadding37dpBinding(android.widget.FrameLayout frameLayout) {
        this.rootView = frameLayout;
    }

    public android.widget.FrameLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.AdapterSnippetsLinePadding37dpBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.AdapterSnippetsLinePadding37dpBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.adapter_snippets_line_padding_37dp, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.AdapterSnippetsLinePadding37dpBinding bind(android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        return new com.up366.mobile.databinding.AdapterSnippetsLinePadding37dpBinding((android.widget.FrameLayout) view);
    }
}
