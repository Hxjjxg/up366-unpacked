package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ActivityUserMessageDetailBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.book.webview.StudyPageWebView massageDetailWebview;
    public final android.widget.TextView tvMessageTitle;

    protected ActivityUserMessageDetailBinding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, android.widget.TextView textView) {
        super(obj, view, i);
        this.massageDetailWebview = studyPageWebView;
        this.tvMessageTitle = textView;
    }

    public static com.up366.mobile.databinding.ActivityUserMessageDetailBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityUserMessageDetailBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityUserMessageDetailBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_user_message_detail, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ActivityUserMessageDetailBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityUserMessageDetailBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityUserMessageDetailBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_user_message_detail, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ActivityUserMessageDetailBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityUserMessageDetailBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityUserMessageDetailBinding) bind(obj, view, com.up366.mobile.R.layout.activity_user_message_detail);
    }
}
