package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class UpdateDownloadCustomProgressBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ProgressBar customProgress;
    public final android.widget.TextView progressMessage;
    public final android.widget.TextView progressPercent;
    public final android.widget.TextView progressTotalSize;
    private final android.widget.LinearLayout rootView;

    private UpdateDownloadCustomProgressBinding(android.widget.LinearLayout linearLayout, android.widget.ProgressBar progressBar, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3) {
        this.rootView = linearLayout;
        this.customProgress = progressBar;
        this.progressMessage = textView;
        this.progressPercent = textView2;
        this.progressTotalSize = textView3;
    }

    public android.widget.LinearLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.UpdateDownloadCustomProgressBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.UpdateDownloadCustomProgressBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.update_download_custom_progress, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.UpdateDownloadCustomProgressBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.custom_progress;
        android.widget.ProgressBar progressBar = (android.widget.ProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.custom_progress);
        if (progressBar != null) {
            i = com.up366.mobile.R.id.progress_message;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.progress_message);
            if (textView != null) {
                i = com.up366.mobile.R.id.progress_percent;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.progress_percent);
                if (textView2 != null) {
                    i = com.up366.mobile.R.id.progress_total_size;
                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.progress_total_size);
                    if (textView3 != null) {
                        return new com.up366.mobile.databinding.UpdateDownloadCustomProgressBinding((android.widget.LinearLayout) view, progressBar, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
