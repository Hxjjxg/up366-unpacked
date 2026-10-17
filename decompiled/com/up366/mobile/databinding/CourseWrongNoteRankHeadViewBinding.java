package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class CourseWrongNoteRankHeadViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView killCount;
    public final android.widget.TextView killRecentCount;
    public final android.widget.TextView tvRankName;
    public final android.widget.TextView wrongCount;

    protected CourseWrongNoteRankHeadViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4) {
        super(obj, view, i);
        this.killCount = textView;
        this.killRecentCount = textView2;
        this.tvRankName = textView3;
        this.wrongCount = textView4;
    }

    public static com.up366.mobile.databinding.CourseWrongNoteRankHeadViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseWrongNoteRankHeadViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseWrongNoteRankHeadViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_wrong_note_rank_head_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.CourseWrongNoteRankHeadViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseWrongNoteRankHeadViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseWrongNoteRankHeadViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_wrong_note_rank_head_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.CourseWrongNoteRankHeadViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseWrongNoteRankHeadViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseWrongNoteRankHeadViewBinding) bind(obj, view, com.up366.mobile.R.layout.course_wrong_note_rank_head_view);
    }
}
