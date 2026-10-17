package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class WordNoteListContentItemBinding extends androidx.databinding.ViewDataBinding {
    public final androidx.constraintlayout.widget.Barrier barrier;
    public final androidx.constraintlayout.widget.ConstraintLayout clContent;
    public final android.widget.TextView deleteBtn;
    public final com.airbnb.lottie.LottieAnimationView ivPlayIcon;
    public final com.up366.mobile.common.views.ListItemDragLayout listItemDragLayout;
    public final android.widget.TextView tvAddCount;
    public final android.widget.TextView tvFinishCount;
    public final android.widget.TextView tvWordCategory;
    public final android.widget.TextView tvWordContent;
    public final android.widget.TextView tvWordExplain;
    public final android.view.View vBottomLine;

    protected WordNoteListContentItemBinding(java.lang.Object obj, android.view.View view, int i, androidx.constraintlayout.widget.Barrier barrier, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView, com.airbnb.lottie.LottieAnimationView lottieAnimationView, com.up366.mobile.common.views.ListItemDragLayout listItemDragLayout, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, android.view.View view2) {
        super(obj, view, i);
        this.barrier = barrier;
        this.clContent = constraintLayout;
        this.deleteBtn = textView;
        this.ivPlayIcon = lottieAnimationView;
        this.listItemDragLayout = listItemDragLayout;
        this.tvAddCount = textView2;
        this.tvFinishCount = textView3;
        this.tvWordCategory = textView4;
        this.tvWordContent = textView5;
        this.tvWordExplain = textView6;
        this.vBottomLine = view2;
    }

    public static com.up366.mobile.databinding.WordNoteListContentItemBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.WordNoteListContentItemBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.WordNoteListContentItemBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.word_note_list_content_item, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.WordNoteListContentItemBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.WordNoteListContentItemBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.WordNoteListContentItemBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.word_note_list_content_item, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.WordNoteListContentItemBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.WordNoteListContentItemBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.WordNoteListContentItemBinding) bind(obj, view, com.up366.mobile.R.layout.word_note_list_content_item);
    }
}
