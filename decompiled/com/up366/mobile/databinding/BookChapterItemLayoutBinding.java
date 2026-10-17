package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class BookChapterItemLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView chapterName;
    public final android.widget.ImageView cursor;
    public final android.widget.ImageView headFlag;
    public final android.widget.LinearLayout item;
    public final android.widget.ImageView lock;
    public final android.widget.TextView score;
    public final android.widget.Space space;

    protected BookChapterItemLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.ImageView imageView, android.widget.ImageView imageView2, android.widget.LinearLayout linearLayout, android.widget.ImageView imageView3, android.widget.TextView textView2, android.widget.Space space) {
        super(obj, view, i);
        this.chapterName = textView;
        this.cursor = imageView;
        this.headFlag = imageView2;
        this.item = linearLayout;
        this.lock = imageView3;
        this.score = textView2;
        this.space = space;
    }

    public static com.up366.mobile.databinding.BookChapterItemLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BookChapterItemLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BookChapterItemLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.book_chapter_item_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.BookChapterItemLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BookChapterItemLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BookChapterItemLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.book_chapter_item_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.BookChapterItemLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BookChapterItemLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BookChapterItemLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.book_chapter_item_layout);
    }
}
