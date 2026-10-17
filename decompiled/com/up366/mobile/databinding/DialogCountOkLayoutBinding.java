package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class DialogCountOkLayoutBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.TextView dialogCommonConfirm;
    public final android.widget.ImageView dialogCommonImg;
    public final android.widget.TextView dialogCommonMsg;
    public final android.widget.TextView dialogCommonTitle;
    private final android.widget.FrameLayout rootView;

    private DialogCountOkLayoutBinding(android.widget.FrameLayout frameLayout, android.widget.TextView textView, android.widget.ImageView imageView, android.widget.TextView textView2, android.widget.TextView textView3) {
        this.rootView = frameLayout;
        this.dialogCommonConfirm = textView;
        this.dialogCommonImg = imageView;
        this.dialogCommonMsg = textView2;
        this.dialogCommonTitle = textView3;
    }

    public android.widget.FrameLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.DialogCountOkLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.DialogCountOkLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.dialog_count_ok_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.DialogCountOkLayoutBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.dialog_common_confirm;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.dialog_common_confirm);
        if (textView != null) {
            i = com.up366.mobile.R.id.dialog_common_img;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.dialog_common_img);
            if (imageView != null) {
                i = com.up366.mobile.R.id.dialog_common_msg;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.dialog_common_msg);
                if (textView2 != null) {
                    i = com.up366.mobile.R.id.dialog_common_title;
                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.dialog_common_title);
                    if (textView3 != null) {
                        return new com.up366.mobile.databinding.DialogCountOkLayoutBinding((android.widget.FrameLayout) view, textView, imageView, textView2, textView3);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
