package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ViewHomeworkItemDateBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageButton flTaskAsk;
    public final android.widget.ImageView ivTaskAskTips;
    public final android.widget.TextView tvItemHomeworkTime;

    protected ViewHomeworkItemDateBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageButton imageButton, android.widget.ImageView imageView, android.widget.TextView textView) {
        super(obj, view, i);
        this.flTaskAsk = imageButton;
        this.ivTaskAskTips = imageView;
        this.tvItemHomeworkTime = textView;
    }

    public static com.up366.mobile.databinding.ViewHomeworkItemDateBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ViewHomeworkItemDateBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ViewHomeworkItemDateBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.view_homework_item_date, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ViewHomeworkItemDateBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ViewHomeworkItemDateBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ViewHomeworkItemDateBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.view_homework_item_date, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ViewHomeworkItemDateBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ViewHomeworkItemDateBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ViewHomeworkItemDateBinding) bind(obj, view, com.up366.mobile.R.layout.view_homework_item_date);
    }
}
