package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class WordNoteListHeaderItemBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView tvHasKilled;
    public final android.widget.TextView tvHasKilledCount;
    public final android.widget.TextView tvRemain;
    public final android.widget.TextView tvRemainCount;
    public final android.widget.TextView tvTodayKilled;
    public final android.widget.TextView tvTodayKilledCount;
    public final android.view.View vEnd;
    public final android.view.View vMask;
    public final android.view.View vStart;

    protected WordNoteListHeaderItemBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, android.view.View view2, android.view.View view3, android.view.View view4) {
        super(obj, view, i);
        this.tvHasKilled = textView;
        this.tvHasKilledCount = textView2;
        this.tvRemain = textView3;
        this.tvRemainCount = textView4;
        this.tvTodayKilled = textView5;
        this.tvTodayKilledCount = textView6;
        this.vEnd = view2;
        this.vMask = view3;
        this.vStart = view4;
    }

    public static com.up366.mobile.databinding.WordNoteListHeaderItemBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.WordNoteListHeaderItemBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.WordNoteListHeaderItemBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.word_note_list_header_item, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.WordNoteListHeaderItemBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.WordNoteListHeaderItemBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.WordNoteListHeaderItemBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.word_note_list_header_item, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.WordNoteListHeaderItemBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.WordNoteListHeaderItemBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.WordNoteListHeaderItemBinding) bind(obj, view, com.up366.mobile.R.layout.word_note_list_header_item);
    }
}
