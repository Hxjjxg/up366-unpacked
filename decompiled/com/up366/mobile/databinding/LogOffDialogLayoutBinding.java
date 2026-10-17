package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class LogOffDialogLayoutBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.TextView applyBtn;
    public final android.widget.ImageView closeBtn;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.Button thinkBtn;
    public final android.widget.TextView wordText;

    private LogOffDialogLayoutBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView, android.widget.ImageView imageView, android.widget.Button button, android.widget.TextView textView2) {
        this.rootView = constraintLayout;
        this.applyBtn = textView;
        this.closeBtn = imageView;
        this.thinkBtn = button;
        this.wordText = textView2;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.LogOffDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.LogOffDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.log_off_dialog_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.LogOffDialogLayoutBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.apply_btn;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.apply_btn);
        if (textView != null) {
            i = com.up366.mobile.R.id.close_btn;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.close_btn);
            if (imageView != null) {
                i = com.up366.mobile.R.id.think_btn;
                android.widget.Button button = (android.widget.Button) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.think_btn);
                if (button != null) {
                    i = com.up366.mobile.R.id.word_text;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.word_text);
                    if (textView2 != null) {
                        return new com.up366.mobile.databinding.LogOffDialogLayoutBinding((androidx.constraintlayout.widget.ConstraintLayout) view, textView, imageView, button, textView2);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
