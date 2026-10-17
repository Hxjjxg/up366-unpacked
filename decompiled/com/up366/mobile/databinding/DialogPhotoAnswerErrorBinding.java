package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class DialogPhotoAnswerErrorBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.TextView btnLeft;
    public final android.widget.TextView btnRight;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView tipTxt;
    public final android.widget.TextView tvTitle;

    private DialogPhotoAnswerErrorBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4) {
        this.rootView = constraintLayout;
        this.btnLeft = textView;
        this.btnRight = textView2;
        this.tipTxt = textView3;
        this.tvTitle = textView4;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.DialogPhotoAnswerErrorBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.DialogPhotoAnswerErrorBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.dialog_photo_answer_error, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.DialogPhotoAnswerErrorBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.btn_left;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_left);
        if (textView != null) {
            i = com.up366.mobile.R.id.btn_right;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_right);
            if (textView2 != null) {
                i = com.up366.mobile.R.id.tip_txt;
                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tip_txt);
                if (textView3 != null) {
                    i = com.up366.mobile.R.id.tv_title;
                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_title);
                    if (textView4 != null) {
                        return new com.up366.mobile.databinding.DialogPhotoAnswerErrorBinding((androidx.constraintlayout.widget.ConstraintLayout) view, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
