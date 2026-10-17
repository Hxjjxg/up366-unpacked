package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class BooksSelectViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView bookName;
    public final android.widget.LinearLayout llItem;
    public final android.widget.TextView selectBtn;

    protected BooksSelectViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.LinearLayout linearLayout, android.widget.TextView textView2) {
        super(obj, view, i);
        this.bookName = textView;
        this.llItem = linearLayout;
        this.selectBtn = textView2;
    }

    public static com.up366.mobile.databinding.BooksSelectViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BooksSelectViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BooksSelectViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.books_select_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.BooksSelectViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BooksSelectViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BooksSelectViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.books_select_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.BooksSelectViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BooksSelectViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BooksSelectViewBinding) bind(obj, view, com.up366.mobile.R.layout.books_select_view);
    }
}
