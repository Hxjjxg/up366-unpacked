package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class BookChapterHeadLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView bookPic;
    public final android.widget.Button buyBtn;
    public final android.view.View buyContentLine;
    public final android.widget.LinearLayout continueLearn;
    public final android.widget.ImageView cursor;
    public final android.widget.LinearLayout downloadAll;
    public final android.view.View downloadAllLine;
    public final android.widget.LinearLayout hasBuyTipContent;
    public final android.widget.TextView lastPosition;
    public final android.widget.TextView lastTime;
    public final android.widget.LinearLayout noBuyText;
    public final android.widget.TextView price;
    public final android.widget.TextView remainTime;
    public final android.widget.TextView timeTip;

    protected BookChapterHeadLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.Button button, android.view.View view2, android.widget.LinearLayout linearLayout, android.widget.ImageView imageView2, android.widget.LinearLayout linearLayout2, android.view.View view3, android.widget.LinearLayout linearLayout3, android.widget.TextView textView, android.widget.TextView textView2, android.widget.LinearLayout linearLayout4, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5) {
        super(obj, view, i);
        this.bookPic = imageView;
        this.buyBtn = button;
        this.buyContentLine = view2;
        this.continueLearn = linearLayout;
        this.cursor = imageView2;
        this.downloadAll = linearLayout2;
        this.downloadAllLine = view3;
        this.hasBuyTipContent = linearLayout3;
        this.lastPosition = textView;
        this.lastTime = textView2;
        this.noBuyText = linearLayout4;
        this.price = textView3;
        this.remainTime = textView4;
        this.timeTip = textView5;
    }

    public static com.up366.mobile.databinding.BookChapterHeadLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BookChapterHeadLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BookChapterHeadLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.book_chapter_head_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.BookChapterHeadLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BookChapterHeadLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BookChapterHeadLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.book_chapter_head_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.BookChapterHeadLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BookChapterHeadLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BookChapterHeadLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.book_chapter_head_layout);
    }
}
