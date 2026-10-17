package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class WordSourceContentItemBinding extends androidx.databinding.ViewDataBinding {
    public final androidx.constraintlayout.widget.ConstraintLayout foldContainer;
    public final android.widget.ImageView ivArrow;
    public final android.widget.LinearLayout llContainer;
    public final android.widget.TextView tvAbstract;
    public final android.widget.TextView tvAddTime;
    public final android.widget.TextView tvSourceType;
    public final android.view.View vLine;

    protected WordSourceContentItemBinding(java.lang.Object obj, android.view.View view, int i, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageView imageView, android.widget.LinearLayout linearLayout, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.view.View view2) {
        super(obj, view, i);
        this.foldContainer = constraintLayout;
        this.ivArrow = imageView;
        this.llContainer = linearLayout;
        this.tvAbstract = textView;
        this.tvAddTime = textView2;
        this.tvSourceType = textView3;
        this.vLine = view2;
    }

    public static com.up366.mobile.databinding.WordSourceContentItemBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.WordSourceContentItemBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.WordSourceContentItemBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.word_source_content_item, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.WordSourceContentItemBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.WordSourceContentItemBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.WordSourceContentItemBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.word_source_content_item, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.WordSourceContentItemBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.WordSourceContentItemBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.WordSourceContentItemBinding) bind(obj, view, com.up366.mobile.R.layout.word_source_content_item);
    }
}
