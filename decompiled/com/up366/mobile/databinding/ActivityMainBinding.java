package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ActivityMainBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.FrameLayout btnPromotion;
    public final com.up366.mobile.common.views.ShapeableTextView btnSkip;
    public final com.up366.mobile.common.views.WindowInsetsFrameLayout content;
    public final android.view.View maskView;
    public final android.widget.ImageView promotion;
    public final android.view.View splashMask;
    public final com.up366.mobile.common.views.MainBottomTabView tab;
    public final com.up366.mobile.common.views.ShapeableTextView timer;
    public final androidx.constraintlayout.widget.ConstraintLayout topLayout;

    protected ActivityMainBinding(java.lang.Object obj, android.view.View view, int i, android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.ShapeableTextView shapeableTextView, com.up366.mobile.common.views.WindowInsetsFrameLayout windowInsetsFrameLayout, android.view.View view2, android.widget.ImageView imageView, android.view.View view3, com.up366.mobile.common.views.MainBottomTabView mainBottomTabView, com.up366.mobile.common.views.ShapeableTextView shapeableTextView2, androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.btnPromotion = frameLayout;
        this.btnSkip = shapeableTextView;
        this.content = windowInsetsFrameLayout;
        this.maskView = view2;
        this.promotion = imageView;
        this.splashMask = view3;
        this.tab = mainBottomTabView;
        this.timer = shapeableTextView2;
        this.topLayout = constraintLayout;
    }

    public static com.up366.mobile.databinding.ActivityMainBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityMainBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityMainBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_main, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ActivityMainBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityMainBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityMainBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_main, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ActivityMainBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityMainBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityMainBinding) bind(obj, view, com.up366.mobile.R.layout.activity_main);
    }
}
