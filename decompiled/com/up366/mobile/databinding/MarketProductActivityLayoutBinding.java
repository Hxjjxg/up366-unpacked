package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MarketProductActivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.airbnb.lottie.LottieAnimationView anim;
    public final android.widget.LinearLayout bottomBtnGroup;
    public final android.widget.TextView buyCount;
    public final android.widget.Button buyIt;
    public final android.widget.LinearLayout contentLayout;
    public final android.widget.LinearLayout daysTip;
    public final android.widget.ImageView error;
    public final android.widget.ImageView image;
    public final android.widget.LinearLayout loading;
    public final android.widget.TextView name;
    public final android.widget.Button rePay;
    public final android.widget.TextView remain;
    public final com.up366.mobile.common.views.ScrollViewWithScrollChangeListener scrollView;
    public final android.widget.Button studyIt;
    public final android.widget.TextView tip;
    public final com.up366.mobile.common.views.TitleBarView titleBar;
    public final androidx.constraintlayout.widget.ConstraintLayout top;
    public final android.widget.Button tryIt;
    public final com.up366.mobile.book.webview.StudyPageWebView webview;

    protected MarketProductActivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.airbnb.lottie.LottieAnimationView lottieAnimationView, android.widget.LinearLayout linearLayout, android.widget.TextView textView, android.widget.Button button, android.widget.LinearLayout linearLayout2, android.widget.LinearLayout linearLayout3, android.widget.ImageView imageView, android.widget.ImageView imageView2, android.widget.LinearLayout linearLayout4, android.widget.TextView textView2, android.widget.Button button2, android.widget.TextView textView3, com.up366.mobile.common.views.ScrollViewWithScrollChangeListener scrollViewWithScrollChangeListener, android.widget.Button button3, android.widget.TextView textView4, com.up366.mobile.common.views.TitleBarView titleBarView, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.Button button4, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
        super(obj, view, i);
        this.anim = lottieAnimationView;
        this.bottomBtnGroup = linearLayout;
        this.buyCount = textView;
        this.buyIt = button;
        this.contentLayout = linearLayout2;
        this.daysTip = linearLayout3;
        this.error = imageView;
        this.image = imageView2;
        this.loading = linearLayout4;
        this.name = textView2;
        this.rePay = button2;
        this.remain = textView3;
        this.scrollView = scrollViewWithScrollChangeListener;
        this.studyIt = button3;
        this.tip = textView4;
        this.titleBar = titleBarView;
        this.top = constraintLayout;
        this.tryIt = button4;
        this.webview = studyPageWebView;
    }

    public static com.up366.mobile.databinding.MarketProductActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MarketProductActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MarketProductActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.market_product_activity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MarketProductActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MarketProductActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MarketProductActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.market_product_activity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MarketProductActivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MarketProductActivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MarketProductActivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.market_product_activity_layout);
    }
}
