package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ViewWrongNoteSortTypeBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView knowledge;
    public final android.widget.TextView queType;
    public final android.widget.TextView wrongCount;

    protected ViewWrongNoteSortTypeBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3) {
        super(obj, view, i);
        this.knowledge = textView;
        this.queType = textView2;
        this.wrongCount = textView3;
    }

    public static com.up366.mobile.databinding.ViewWrongNoteSortTypeBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ViewWrongNoteSortTypeBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ViewWrongNoteSortTypeBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.view_wrong_note_sort_type, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ViewWrongNoteSortTypeBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ViewWrongNoteSortTypeBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ViewWrongNoteSortTypeBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.view_wrong_note_sort_type, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ViewWrongNoteSortTypeBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ViewWrongNoteSortTypeBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ViewWrongNoteSortTypeBinding) bind(obj, view, com.up366.mobile.R.layout.view_wrong_note_sort_type);
    }
}
