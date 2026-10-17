package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class IsBookVActivityMainBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView isbvamTitleBack;
    public final com.up366.mobile.book.studyviews.view.video.AnswerVideoView video;

    protected IsBookVActivityMainBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, com.up366.mobile.book.studyviews.view.video.AnswerVideoView answerVideoView) {
        super(obj, view, i);
        this.isbvamTitleBack = imageView;
        this.video = answerVideoView;
    }

    public static com.up366.mobile.databinding.IsBookVActivityMainBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.IsBookVActivityMainBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.IsBookVActivityMainBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.is_book_v_activity_main, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.IsBookVActivityMainBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.IsBookVActivityMainBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.IsBookVActivityMainBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.is_book_v_activity_main, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.IsBookVActivityMainBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.IsBookVActivityMainBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.IsBookVActivityMainBinding) bind(obj, view, com.up366.mobile.R.layout.is_book_v_activity_main);
    }
}
