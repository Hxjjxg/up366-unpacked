package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class QuestionTextActivityContentBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView questionTextActivityPlayButton;
    public final android.widget.ProgressBar questionTextActivityProgressBar;
    public final com.up366.mobile.book.webview.StudyPageWebView questionTextActivityWebview;

    protected QuestionTextActivityContentBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.ProgressBar progressBar, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
        super(obj, view, i);
        this.questionTextActivityPlayButton = imageView;
        this.questionTextActivityProgressBar = progressBar;
        this.questionTextActivityWebview = studyPageWebView;
    }

    public static com.up366.mobile.databinding.QuestionTextActivityContentBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.QuestionTextActivityContentBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.QuestionTextActivityContentBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.question_text_activity_content, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.QuestionTextActivityContentBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.QuestionTextActivityContentBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.QuestionTextActivityContentBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.question_text_activity_content, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.QuestionTextActivityContentBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.QuestionTextActivityContentBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.QuestionTextActivityContentBinding) bind(obj, view, com.up366.mobile.R.layout.question_text_activity_content);
    }
}
