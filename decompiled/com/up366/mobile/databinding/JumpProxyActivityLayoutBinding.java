package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class JumpProxyActivityLayoutBinding implements androidx.viewbinding.ViewBinding {
    public final androidx.constraintlayout.widget.ConstraintLayout rootView;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView_;

    private JumpProxyActivityLayoutBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, androidx.constraintlayout.widget.ConstraintLayout constraintLayout2) {
        this.rootView_ = constraintLayout;
        this.rootView = constraintLayout2;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView_;
    }

    public static com.up366.mobile.databinding.JumpProxyActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.JumpProxyActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.jump_proxy_activity_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.JumpProxyActivityLayoutBinding bind(android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) view;
        return new com.up366.mobile.databinding.JumpProxyActivityLayoutBinding(constraintLayout, constraintLayout);
    }
}
