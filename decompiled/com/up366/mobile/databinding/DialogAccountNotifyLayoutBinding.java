package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class DialogAccountNotifyLayoutBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.TextView accountTx;
    public final android.widget.LinearLayout contentTx;
    public final android.widget.TextView dialogCommonConfirm;
    public final android.widget.TextView realnameTx;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView title;
    public final android.widget.TextView tp1;
    public final android.widget.TextView tp2;

    private DialogAccountNotifyLayoutBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView, android.widget.LinearLayout linearLayout, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6) {
        this.rootView = constraintLayout;
        this.accountTx = textView;
        this.contentTx = linearLayout;
        this.dialogCommonConfirm = textView2;
        this.realnameTx = textView3;
        this.title = textView4;
        this.tp1 = textView5;
        this.tp2 = textView6;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.DialogAccountNotifyLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.DialogAccountNotifyLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.dialog_account_notify_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.DialogAccountNotifyLayoutBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.account_tx;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.account_tx);
        if (textView != null) {
            i = com.up366.mobile.R.id.content_tx;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.content_tx);
            if (linearLayout != null) {
                i = com.up366.mobile.R.id.dialog_common_confirm;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.dialog_common_confirm);
                if (textView2 != null) {
                    i = com.up366.mobile.R.id.realname_tx;
                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.realname_tx);
                    if (textView3 != null) {
                        i = 2131363459;
                        android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131363459);
                        if (textView4 != null) {
                            i = com.up366.mobile.R.id.tp1;
                            android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tp1);
                            if (textView5 != null) {
                                i = com.up366.mobile.R.id.tp2;
                                android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tp2);
                                if (textView6 != null) {
                                    return new com.up366.mobile.databinding.DialogAccountNotifyLayoutBinding((androidx.constraintlayout.widget.ConstraintLayout) view, textView, linearLayout, textView2, textView3, textView4, textView5, textView6);
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
