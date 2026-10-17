package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class DialogNoteTipBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageView btnClose;
    public final android.widget.Button btnToBack;
    private final android.widget.LinearLayout rootView;
    public final android.widget.TextView txtTitle;

    private DialogNoteTipBinding(android.widget.LinearLayout linearLayout, android.widget.ImageView imageView, android.widget.Button button, android.widget.TextView textView) {
        this.rootView = linearLayout;
        this.btnClose = imageView;
        this.btnToBack = button;
        this.txtTitle = textView;
    }

    public android.widget.LinearLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.DialogNoteTipBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.DialogNoteTipBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.dialog_note_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.DialogNoteTipBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.btn_close;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_close);
        if (imageView != null) {
            i = com.up366.mobile.R.id.btn_to_back;
            android.widget.Button button = (android.widget.Button) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_to_back);
            if (button != null) {
                i = com.up366.mobile.R.id.txt_title;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.txt_title);
                if (textView != null) {
                    return new com.up366.mobile.databinding.DialogNoteTipBinding((android.widget.LinearLayout) view, imageView, button, textView);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
