package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class AdapterSnippetsSpace12dpBinding implements androidx.viewbinding.ViewBinding {
    private final android.widget.FrameLayout rootView;

    private AdapterSnippetsSpace12dpBinding(android.widget.FrameLayout frameLayout) {
        this.rootView = frameLayout;
    }

    public android.widget.FrameLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.AdapterSnippetsSpace12dpBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.AdapterSnippetsSpace12dpBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.adapter_snippets_space_12dp, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.AdapterSnippetsSpace12dpBinding bind(android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        return new com.up366.mobile.databinding.AdapterSnippetsSpace12dpBinding((android.widget.FrameLayout) view);
    }
}
