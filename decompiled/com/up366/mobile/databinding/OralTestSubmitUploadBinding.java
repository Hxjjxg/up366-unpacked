package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class OralTestSubmitUploadBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.TextView hwSubmitUploadTvPercent;
    public final android.widget.TextView hwSubmitUploadTvSize;
    public final android.widget.ProgressBar myProgress;
    public final android.widget.TextView oralTestSubmitUploadTvTitle;
    private final android.widget.FrameLayout rootView;

    private OralTestSubmitUploadBinding(android.widget.FrameLayout frameLayout, android.widget.TextView textView, android.widget.TextView textView2, android.widget.ProgressBar progressBar, android.widget.TextView textView3) {
        this.rootView = frameLayout;
        this.hwSubmitUploadTvPercent = textView;
        this.hwSubmitUploadTvSize = textView2;
        this.myProgress = progressBar;
        this.oralTestSubmitUploadTvTitle = textView3;
    }

    public android.widget.FrameLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.OralTestSubmitUploadBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.OralTestSubmitUploadBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.oral_test_submit_upload, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.OralTestSubmitUploadBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.hw_submit_upload_tv_percent;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.hw_submit_upload_tv_percent);
        if (textView != null) {
            i = com.up366.mobile.R.id.hw_submit_upload_tv_size;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.hw_submit_upload_tv_size);
            if (textView2 != null) {
                i = com.up366.mobile.R.id.my_progress;
                android.widget.ProgressBar progressBar = (android.widget.ProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.my_progress);
                if (progressBar != null) {
                    i = com.up366.mobile.R.id.oral_test_submit_upload_tv_title;
                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.oral_test_submit_upload_tv_title);
                    if (textView3 != null) {
                        return new com.up366.mobile.databinding.OralTestSubmitUploadBinding((android.widget.FrameLayout) view, textView, textView2, progressBar, textView3);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
