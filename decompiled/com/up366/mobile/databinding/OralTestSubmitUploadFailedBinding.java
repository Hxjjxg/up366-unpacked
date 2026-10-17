package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class OralTestSubmitUploadFailedBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.TextView hwSubmitUploadFailedTvAgain;
    public final android.widget.TextView hwSubmitUploadFailedTvTitle;
    private final android.widget.FrameLayout rootView;

    private OralTestSubmitUploadFailedBinding(android.widget.FrameLayout frameLayout, android.widget.TextView textView, android.widget.TextView textView2) {
        this.rootView = frameLayout;
        this.hwSubmitUploadFailedTvAgain = textView;
        this.hwSubmitUploadFailedTvTitle = textView2;
    }

    public android.widget.FrameLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.OralTestSubmitUploadFailedBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.OralTestSubmitUploadFailedBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.oral_test_submit_upload_failed, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.OralTestSubmitUploadFailedBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.hw_submit_upload_failed_tv_again;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.hw_submit_upload_failed_tv_again);
        if (textView != null) {
            i = com.up366.mobile.R.id.hw_submit_upload_failed_tv_title;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.hw_submit_upload_failed_tv_title);
            if (textView2 != null) {
                return new com.up366.mobile.databinding.OralTestSubmitUploadFailedBinding((android.widget.FrameLayout) view, textView, textView2);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
