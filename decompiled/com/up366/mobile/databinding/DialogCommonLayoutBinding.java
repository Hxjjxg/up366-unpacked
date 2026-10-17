package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class DialogCommonLayoutBinding implements androidx.viewbinding.ViewBinding {
    public final android.view.View btnHorSpilt;
    public final android.widget.LinearLayout dialogBtnLayout;
    public final android.widget.TextView dialogCommonCancel;
    public final android.widget.TextView dialogCommonConfirm;
    public final android.widget.TextView dialogCommonMsg;
    public final android.widget.TextView dialogCommonTitle;
    public final android.view.View dialogMsgBtnLine;
    private final android.widget.FrameLayout rootView;

    private DialogCommonLayoutBinding(android.widget.FrameLayout frameLayout, android.view.View view, android.widget.LinearLayout linearLayout, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.view.View view2) {
        this.rootView = frameLayout;
        this.btnHorSpilt = view;
        this.dialogBtnLayout = linearLayout;
        this.dialogCommonCancel = textView;
        this.dialogCommonConfirm = textView2;
        this.dialogCommonMsg = textView3;
        this.dialogCommonTitle = textView4;
        this.dialogMsgBtnLine = view2;
    }

    public android.widget.FrameLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.DialogCommonLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.DialogCommonLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.dialog_common_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.DialogCommonLayoutBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.btn_hor_spilt;
        android.view.View viewFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_hor_spilt);
        if (viewFindChildViewById != null) {
            i = com.up366.mobile.R.id.dialog_btn_layout;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.dialog_btn_layout);
            if (linearLayout != null) {
                i = com.up366.mobile.R.id.dialog_common_cancel;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.dialog_common_cancel);
                if (textView != null) {
                    i = com.up366.mobile.R.id.dialog_common_confirm;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.dialog_common_confirm);
                    if (textView2 != null) {
                        i = com.up366.mobile.R.id.dialog_common_msg;
                        android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.dialog_common_msg);
                        if (textView3 != null) {
                            i = com.up366.mobile.R.id.dialog_common_title;
                            android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.dialog_common_title);
                            if (textView4 != null) {
                                i = com.up366.mobile.R.id.dialog_msg_btn_line;
                                android.view.View viewFindChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.dialog_msg_btn_line);
                                if (viewFindChildViewById2 != null) {
                                    return new com.up366.mobile.databinding.DialogCommonLayoutBinding((android.widget.FrameLayout) view, viewFindChildViewById, linearLayout, textView, textView2, textView3, textView4, viewFindChildViewById2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
