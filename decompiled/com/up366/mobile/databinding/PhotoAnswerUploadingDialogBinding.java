package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class PhotoAnswerUploadingDialogBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView closeBtn;
    public final android.widget.ImageView givLoading;
    public final com.up366.mobile.common.views.DownloadProgressView progressBar;
    public final android.widget.TextView progressValue;
    public final android.widget.TextView tvLoadingTips;

    protected PhotoAnswerUploadingDialogBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.ImageView imageView2, com.up366.mobile.common.views.DownloadProgressView downloadProgressView, android.widget.TextView textView, android.widget.TextView textView2) {
        super(obj, view, i);
        this.closeBtn = imageView;
        this.givLoading = imageView2;
        this.progressBar = downloadProgressView;
        this.progressValue = textView;
        this.tvLoadingTips = textView2;
    }

    public static com.up366.mobile.databinding.PhotoAnswerUploadingDialogBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.PhotoAnswerUploadingDialogBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.PhotoAnswerUploadingDialogBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.photo_answer_uploading_dialog, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.PhotoAnswerUploadingDialogBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.PhotoAnswerUploadingDialogBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.PhotoAnswerUploadingDialogBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.photo_answer_uploading_dialog, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.PhotoAnswerUploadingDialogBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.PhotoAnswerUploadingDialogBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.PhotoAnswerUploadingDialogBinding) bind(obj, view, com.up366.mobile.R.layout.photo_answer_uploading_dialog);
    }
}
