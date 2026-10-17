package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class V1ExerciseChapterPlayViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView chapterPlayContentAnim;
    public final android.widget.ImageView chapterPlayContentBeginBtn;
    public final android.widget.TextView chapterPlayContentChapterName;
    public final android.widget.ImageView chapterPlayContentLastBtn;
    public final android.widget.ImageView chapterPlayContentNextBtn;
    public final android.widget.TextView chapterPlayContentNowTime;
    public final android.widget.ProgressBar chapterPlayContentProgressBar;
    public final android.widget.TextView chapterPlayContentTotalTime;

    protected V1ExerciseChapterPlayViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.ImageView imageView2, android.widget.TextView textView, android.widget.ImageView imageView3, android.widget.ImageView imageView4, android.widget.TextView textView2, android.widget.ProgressBar progressBar, android.widget.TextView textView3) {
        super(obj, view, i);
        this.chapterPlayContentAnim = imageView;
        this.chapterPlayContentBeginBtn = imageView2;
        this.chapterPlayContentChapterName = textView;
        this.chapterPlayContentLastBtn = imageView3;
        this.chapterPlayContentNextBtn = imageView4;
        this.chapterPlayContentNowTime = textView2;
        this.chapterPlayContentProgressBar = progressBar;
        this.chapterPlayContentTotalTime = textView3;
    }

    public static com.up366.mobile.databinding.V1ExerciseChapterPlayViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.V1ExerciseChapterPlayViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.V1ExerciseChapterPlayViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.v1_exercise_chapter_play_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.V1ExerciseChapterPlayViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.V1ExerciseChapterPlayViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.V1ExerciseChapterPlayViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.v1_exercise_chapter_play_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.V1ExerciseChapterPlayViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.V1ExerciseChapterPlayViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.V1ExerciseChapterPlayViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.v1_exercise_chapter_play_view_layout);
    }
}
