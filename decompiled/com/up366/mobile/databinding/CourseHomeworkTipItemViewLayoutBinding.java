package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class CourseHomeworkTipItemViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView btnStart;
    public final android.widget.TextView count;
    public final android.widget.TextView countSub;
    public final com.up366.mobile.common.views.RoundImageView itemBg;
    public final android.view.View liveGuideFocusView;
    public final android.widget.TextView text;
    public final android.widget.TextView textTip;
    public final android.widget.TextView tip;
    public final android.view.View tipArrow;

    protected CourseHomeworkTipItemViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, com.up366.mobile.common.views.RoundImageView roundImageView, android.view.View view2, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, android.view.View view3) {
        super(obj, view, i);
        this.btnStart = textView;
        this.count = textView2;
        this.countSub = textView3;
        this.itemBg = roundImageView;
        this.liveGuideFocusView = view2;
        this.text = textView4;
        this.textTip = textView5;
        this.tip = textView6;
        this.tipArrow = view3;
    }

    public static com.up366.mobile.databinding.CourseHomeworkTipItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseHomeworkTipItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseHomeworkTipItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_homework_tip_item_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.CourseHomeworkTipItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseHomeworkTipItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseHomeworkTipItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_homework_tip_item_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.CourseHomeworkTipItemViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseHomeworkTipItemViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseHomeworkTipItemViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.course_homework_tip_item_view_layout);
    }
}
