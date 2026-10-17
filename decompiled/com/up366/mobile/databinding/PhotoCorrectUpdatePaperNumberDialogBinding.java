package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class PhotoCorrectUpdatePaperNumberDialogBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.TextView btnLeft;
    public final android.widget.TextView btnRight;
    public final android.widget.LinearLayout contentTx;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView tipTxt;
    public final android.widget.TextView tvTitle;
    public final com.up366.view.wheelview.WheelView wheel;

    private PhotoCorrectUpdatePaperNumberDialogBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView, android.widget.TextView textView2, android.widget.LinearLayout linearLayout, android.widget.TextView textView3, android.widget.TextView textView4, com.up366.view.wheelview.WheelView wheelView) {
        this.rootView = constraintLayout;
        this.btnLeft = textView;
        this.btnRight = textView2;
        this.contentTx = linearLayout;
        this.tipTxt = textView3;
        this.tvTitle = textView4;
        this.wheel = wheelView;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.PhotoCorrectUpdatePaperNumberDialogBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.PhotoCorrectUpdatePaperNumberDialogBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.photo_correct_update_paper_number_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.PhotoCorrectUpdatePaperNumberDialogBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.btn_left;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_left);
        if (textView != null) {
            i = com.up366.mobile.R.id.btn_right;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_right);
            if (textView2 != null) {
                i = com.up366.mobile.R.id.content_tx;
                android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.content_tx);
                if (linearLayout != null) {
                    i = com.up366.mobile.R.id.tip_txt;
                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tip_txt);
                    if (textView3 != null) {
                        i = com.up366.mobile.R.id.tv_title;
                        android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_title);
                        if (textView4 != null) {
                            i = com.up366.mobile.R.id.wheel;
                            com.up366.view.wheelview.WheelView wheelView = (com.up366.view.wheelview.WheelView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.wheel);
                            if (wheelView != null) {
                                return new com.up366.mobile.databinding.PhotoCorrectUpdatePaperNumberDialogBinding((androidx.constraintlayout.widget.ConstraintLayout) view, textView, textView2, linearLayout, textView3, textView4, wheelView);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
