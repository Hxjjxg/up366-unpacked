package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class PhotoCorrectNoRegisterBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageView bottomTipImg;
    public final android.widget.TextView btnLeft;
    public final android.widget.TextView btnRight;
    private final android.widget.LinearLayout rootView;
    public final android.widget.TextView tipTxt1;
    public final android.widget.TextView tvTitle;

    private PhotoCorrectNoRegisterBinding(android.widget.LinearLayout linearLayout, android.widget.ImageView imageView, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4) {
        this.rootView = linearLayout;
        this.bottomTipImg = imageView;
        this.btnLeft = textView;
        this.btnRight = textView2;
        this.tipTxt1 = textView3;
        this.tvTitle = textView4;
    }

    public android.widget.LinearLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.PhotoCorrectNoRegisterBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.PhotoCorrectNoRegisterBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.photo_correct_no_register, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.PhotoCorrectNoRegisterBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.bottom_tip_img;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.bottom_tip_img);
        if (imageView != null) {
            i = com.up366.mobile.R.id.btn_left;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_left);
            if (textView != null) {
                i = com.up366.mobile.R.id.btn_right;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_right);
                if (textView2 != null) {
                    i = com.up366.mobile.R.id.tip_txt1;
                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tip_txt1);
                    if (textView3 != null) {
                        i = com.up366.mobile.R.id.tv_title;
                        android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_title);
                        if (textView4 != null) {
                            return new com.up366.mobile.databinding.PhotoCorrectNoRegisterBinding((android.widget.LinearLayout) view, imageView, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
