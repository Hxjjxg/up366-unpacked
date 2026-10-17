package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ToastShowCenterBlackBinding implements androidx.viewbinding.ViewBinding {
    private final android.widget.LinearLayout rootView;
    public final android.widget.TextView tvMessage;

    private ToastShowCenterBlackBinding(android.widget.LinearLayout linearLayout, android.widget.TextView textView) {
        this.rootView = linearLayout;
        this.tvMessage = textView;
    }

    public android.widget.LinearLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.ToastShowCenterBlackBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.ToastShowCenterBlackBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.toast_show_center_black, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.ToastShowCenterBlackBinding bind(android.view.View view) {
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_message);
        if (textView != null) {
            return new com.up366.mobile.databinding.ToastShowCenterBlackBinding((android.widget.LinearLayout) view, textView);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(com.up366.mobile.R.id.tv_message)));
    }
}
