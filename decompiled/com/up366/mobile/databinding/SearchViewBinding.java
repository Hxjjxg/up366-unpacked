package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class SearchViewBinding implements androidx.viewbinding.ViewBinding {
    public final com.up366.mobile.common.views.CommonEditText etSearchInput;
    public final android.widget.FrameLayout flSearchLayout;
    public final android.widget.ImageButton ibClearSearch;
    public final android.widget.LinearLayout llSearchBefore;
    public final android.widget.RelativeLayout rlSearchAfter;
    private final android.widget.FrameLayout rootView;
    public final android.widget.TextView tvSearchHint;

    private SearchViewBinding(android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.CommonEditText commonEditText, android.widget.FrameLayout frameLayout2, android.widget.ImageButton imageButton, android.widget.LinearLayout linearLayout, android.widget.RelativeLayout relativeLayout, android.widget.TextView textView) {
        this.rootView = frameLayout;
        this.etSearchInput = commonEditText;
        this.flSearchLayout = frameLayout2;
        this.ibClearSearch = imageButton;
        this.llSearchBefore = linearLayout;
        this.rlSearchAfter = relativeLayout;
        this.tvSearchHint = textView;
    }

    public android.widget.FrameLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.SearchViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.SearchViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.search_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.SearchViewBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.et_search_input;
        com.up366.mobile.common.views.CommonEditText commonEditText = (com.up366.mobile.common.views.CommonEditText) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.et_search_input);
        if (commonEditText != null) {
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) view;
            i = com.up366.mobile.R.id.ib_clear_search;
            android.widget.ImageButton imageButton = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.ib_clear_search);
            if (imageButton != null) {
                i = com.up366.mobile.R.id.ll_search_before;
                android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.ll_search_before);
                if (linearLayout != null) {
                    i = com.up366.mobile.R.id.rl_search_after;
                    android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.rl_search_after);
                    if (relativeLayout != null) {
                        i = com.up366.mobile.R.id.tv_search_hint;
                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_search_hint);
                        if (textView != null) {
                            return new com.up366.mobile.databinding.SearchViewBinding(frameLayout, commonEditText, frameLayout, imageButton, linearLayout, relativeLayout, textView);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
