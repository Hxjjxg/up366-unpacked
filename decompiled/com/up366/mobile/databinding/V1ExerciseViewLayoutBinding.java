package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class V1ExerciseViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView exerciseActivityPlayButton;
    public final android.widget.ProgressBar exerciseActivityProgressBar;
    public final com.up366.mobile.book.studyviews.model.V1ChildViewPager exerciseContentViewpager;
    public final com.up366.mobile.book.studyviews.view.V1ExerciseHeadPagerView page;
    public final com.up366.mobile.common.views.TitleBarView titleBar;

    protected V1ExerciseViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.ProgressBar progressBar, com.up366.mobile.book.studyviews.model.V1ChildViewPager v1ChildViewPager, com.up366.mobile.book.studyviews.view.V1ExerciseHeadPagerView v1ExerciseHeadPagerView, com.up366.mobile.common.views.TitleBarView titleBarView) {
        super(obj, view, i);
        this.exerciseActivityPlayButton = imageView;
        this.exerciseActivityProgressBar = progressBar;
        this.exerciseContentViewpager = v1ChildViewPager;
        this.page = v1ExerciseHeadPagerView;
        this.titleBar = titleBarView;
    }

    public static com.up366.mobile.databinding.V1ExerciseViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.V1ExerciseViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.V1ExerciseViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.v1_exercise_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.V1ExerciseViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.V1ExerciseViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.V1ExerciseViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.v1_exercise_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.V1ExerciseViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.V1ExerciseViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.V1ExerciseViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.v1_exercise_view_layout);
    }
}
