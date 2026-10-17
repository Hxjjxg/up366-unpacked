package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class CourseWordNoteRankItemViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView ivRankNo;
    public final android.widget.LinearLayout rankLL;
    public final android.widget.TextView tvKilledCount;
    public final android.widget.TextView tvKilledCountLately;
    public final android.widget.TextView tvName;
    public final android.widget.TextView tvNo;
    public final android.widget.TextView tvWrongCount;

    protected CourseWordNoteRankItemViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.LinearLayout linearLayout, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5) {
        super(obj, view, i);
        this.ivRankNo = imageView;
        this.rankLL = linearLayout;
        this.tvKilledCount = textView;
        this.tvKilledCountLately = textView2;
        this.tvName = textView3;
        this.tvNo = textView4;
        this.tvWrongCount = textView5;
    }

    public static com.up366.mobile.databinding.CourseWordNoteRankItemViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseWordNoteRankItemViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseWordNoteRankItemViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_word_note_rank_item_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.CourseWordNoteRankItemViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseWordNoteRankItemViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseWordNoteRankItemViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_word_note_rank_item_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.CourseWordNoteRankItemViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseWordNoteRankItemViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseWordNoteRankItemViewBinding) bind(obj, view, com.up366.mobile.R.layout.course_word_note_rank_item_view);
    }
}
