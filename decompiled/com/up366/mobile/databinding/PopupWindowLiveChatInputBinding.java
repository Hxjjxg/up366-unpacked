package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class PopupWindowLiveChatInputBinding implements androidx.viewbinding.ViewBinding {
    public final com.sunhapper.x.spedit.view.SpXEditText etInputMsg;
    public final android.widget.ImageButton ibFaceMsg;
    public final android.widget.ImageButton ibMsgSend;
    public final androidx.constraintlayout.widget.ConstraintLayout llInputSend;
    private final android.widget.FrameLayout rootView;

    private PopupWindowLiveChatInputBinding(android.widget.FrameLayout frameLayout, com.sunhapper.x.spedit.view.SpXEditText spXEditText, android.widget.ImageButton imageButton, android.widget.ImageButton imageButton2, androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        this.rootView = frameLayout;
        this.etInputMsg = spXEditText;
        this.ibFaceMsg = imageButton;
        this.ibMsgSend = imageButton2;
        this.llInputSend = constraintLayout;
    }

    public android.widget.FrameLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.PopupWindowLiveChatInputBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.PopupWindowLiveChatInputBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.popup_window_live_chat_input, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.PopupWindowLiveChatInputBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.et_input_msg;
        com.sunhapper.x.spedit.view.SpXEditText spXEditText = (com.sunhapper.x.spedit.view.SpXEditText) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.et_input_msg);
        if (spXEditText != null) {
            i = com.up366.mobile.R.id.ib_face_msg;
            android.widget.ImageButton imageButton = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.ib_face_msg);
            if (imageButton != null) {
                i = com.up366.mobile.R.id.ib_msg_send;
                android.widget.ImageButton imageButton2 = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.ib_msg_send);
                if (imageButton2 != null) {
                    i = com.up366.mobile.R.id.ll_input_send;
                    androidx.constraintlayout.widget.ConstraintLayout constraintLayoutFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.ll_input_send);
                    if (constraintLayoutFindChildViewById != null) {
                        return new com.up366.mobile.databinding.PopupWindowLiveChatInputBinding((android.widget.FrameLayout) view, spXEditText, imageButton, imageButton2, constraintLayoutFindChildViewById);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
