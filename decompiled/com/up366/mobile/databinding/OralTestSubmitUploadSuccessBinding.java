package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class OralTestSubmitUploadSuccessBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.TextView hwSubmitUploadSuccessTvSure;
    private final android.widget.FrameLayout rootView;
    public final android.widget.TextView uploadText;

    private OralTestSubmitUploadSuccessBinding(android.widget.FrameLayout frameLayout, android.widget.TextView textView, android.widget.TextView textView2) {
        this.rootView = frameLayout;
        this.hwSubmitUploadSuccessTvSure = textView;
        this.uploadText = textView2;
    }

    public android.widget.FrameLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.OralTestSubmitUploadSuccessBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.OralTestSubmitUploadSuccessBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.oral_test_submit_upload_success, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.OralTestSubmitUploadSuccessBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.hw_submit_upload_success_tv_sure;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.hw_submit_upload_success_tv_sure);
        if (textView != null) {
            i = com.up366.mobile.R.id.upload_text;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.upload_text);
            if (textView2 != null) {
                return new com.up366.mobile.databinding.OralTestSubmitUploadSuccessBinding((android.widget.FrameLayout) view, textView, textView2);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
