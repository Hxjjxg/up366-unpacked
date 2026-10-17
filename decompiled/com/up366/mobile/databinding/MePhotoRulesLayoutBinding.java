package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MePhotoRulesLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView closeBtn;
    public final android.widget.TextView copyright;
    public final android.widget.TextView tip1Title;
    public final android.widget.TextView tip1Tv;
    public final android.widget.TextView tip2Title;
    public final android.widget.TextView tip2Tv;
    public final android.widget.TextView title;

    protected MePhotoRulesLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, android.widget.TextView textView7) {
        super(obj, view, i);
        this.closeBtn = textView;
        this.copyright = textView2;
        this.tip1Title = textView3;
        this.tip1Tv = textView4;
        this.tip2Title = textView5;
        this.tip2Tv = textView6;
        this.title = textView7;
    }

    public static com.up366.mobile.databinding.MePhotoRulesLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MePhotoRulesLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MePhotoRulesLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_photo_rules_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MePhotoRulesLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MePhotoRulesLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MePhotoRulesLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_photo_rules_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MePhotoRulesLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MePhotoRulesLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MePhotoRulesLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_photo_rules_layout);
    }
}
