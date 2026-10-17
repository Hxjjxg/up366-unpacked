package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class V1ExerciseQuestionViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.LinearLayout exerciseQuestionViewAnswerButton;
    public final com.up366.mobile.book.webview.StudyPageWebView exerciseQuestionWebview;

    protected V1ExerciseQuestionViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.LinearLayout linearLayout, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
        super(obj, view, i);
        this.exerciseQuestionViewAnswerButton = linearLayout;
        this.exerciseQuestionWebview = studyPageWebView;
    }

    public static com.up366.mobile.databinding.V1ExerciseQuestionViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.V1ExerciseQuestionViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.V1ExerciseQuestionViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.v1_exercise_question_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.V1ExerciseQuestionViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.V1ExerciseQuestionViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.V1ExerciseQuestionViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.v1_exercise_question_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.V1ExerciseQuestionViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.V1ExerciseQuestionViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.V1ExerciseQuestionViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.v1_exercise_question_view_layout);
    }
}
