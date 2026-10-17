package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class V1ExerciseHeadPagerViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView exerciseBigAudio;
    public final android.widget.LinearLayout exerciseHeadCircleLayout;

    protected V1ExerciseHeadPagerViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.LinearLayout linearLayout) {
        super(obj, view, i);
        this.exerciseBigAudio = imageView;
        this.exerciseHeadCircleLayout = linearLayout;
    }

    public static com.up366.mobile.databinding.V1ExerciseHeadPagerViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.V1ExerciseHeadPagerViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.V1ExerciseHeadPagerViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.v1_exercise_head_pager_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.V1ExerciseHeadPagerViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.V1ExerciseHeadPagerViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.V1ExerciseHeadPagerViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.v1_exercise_head_pager_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.V1ExerciseHeadPagerViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.V1ExerciseHeadPagerViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.V1ExerciseHeadPagerViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.v1_exercise_head_pager_view_layout);
    }
}
