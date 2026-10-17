package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ToastPopupLayoutBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageView icon;
    private final android.widget.LinearLayout rootView;
    public final android.widget.TextView text;

    private ToastPopupLayoutBinding(android.widget.LinearLayout linearLayout, android.widget.ImageView imageView, android.widget.TextView textView) {
        this.rootView = linearLayout;
        this.icon = imageView;
        this.text = textView;
    }

    public android.widget.LinearLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.ToastPopupLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.ToastPopupLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.toast_popup_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.ToastPopupLayoutBinding bind(android.view.View view) {
        int i = 2131362563;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131362563);
        if (imageView != null) {
            i = 2131363383;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131363383);
            if (textView != null) {
                return new com.up366.mobile.databinding.ToastPopupLayoutBinding((android.widget.LinearLayout) view, imageView, textView);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
