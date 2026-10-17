package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class TitleBarViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView arrow;
    public final com.up366.mobile.common.views.TitleBackView back;
    public final com.up366.mobile.common.views.TitleSearchClassView findCourse;
    public final com.up366.mobile.common.views.CommonEditText input;
    public final android.widget.TextView leftText;
    public final android.view.View line;
    public final com.up366.mobile.common.views.TitleMessageView message;
    public final android.widget.LinearLayout rightBtnContainer;
    public final com.up366.mobile.common.views.TitleRightView rightIcon;
    public final android.widget.TextView rightText;
    public final com.up366.mobile.common.views.MarqueeTextView title;

    protected TitleBarViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, com.up366.mobile.common.views.TitleBackView titleBackView, com.up366.mobile.common.views.TitleSearchClassView titleSearchClassView, com.up366.mobile.common.views.CommonEditText commonEditText, android.widget.TextView textView, android.view.View view2, com.up366.mobile.common.views.TitleMessageView titleMessageView, android.widget.LinearLayout linearLayout, com.up366.mobile.common.views.TitleRightView titleRightView, android.widget.TextView textView2, com.up366.mobile.common.views.MarqueeTextView marqueeTextView) {
        super(obj, view, i);
        this.arrow = imageView;
        this.back = titleBackView;
        this.findCourse = titleSearchClassView;
        this.input = commonEditText;
        this.leftText = textView;
        this.line = view2;
        this.message = titleMessageView;
        this.rightBtnContainer = linearLayout;
        this.rightIcon = titleRightView;
        this.rightText = textView2;
        this.title = marqueeTextView;
    }

    public static com.up366.mobile.databinding.TitleBarViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TitleBarViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TitleBarViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.title_bar_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.TitleBarViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TitleBarViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TitleBarViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.title_bar_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.TitleBarViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TitleBarViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TitleBarViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.title_bar_view_layout);
    }
}
