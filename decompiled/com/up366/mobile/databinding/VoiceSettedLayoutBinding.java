package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class VoiceSettedLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.airbnb.lottie.LottieAnimationView anim;
    public final com.up366.mobile.common.views.TitleBackView back;
    public final com.up366.mobile.common.views.SettingItemView btnCheck;
    public final android.widget.TextView btnDelete;
    public final com.up366.mobile.common.views.SettingItemView btnReRecord;
    public final com.up366.mobile.common.views.PaddingShadowLayout shadow;
    public final android.widget.TextView text1;
    public final android.widget.TextView title;

    protected VoiceSettedLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.airbnb.lottie.LottieAnimationView lottieAnimationView, com.up366.mobile.common.views.TitleBackView titleBackView, com.up366.mobile.common.views.SettingItemView settingItemView, android.widget.TextView textView, com.up366.mobile.common.views.SettingItemView settingItemView2, com.up366.mobile.common.views.PaddingShadowLayout paddingShadowLayout, android.widget.TextView textView2, android.widget.TextView textView3) {
        super(obj, view, i);
        this.anim = lottieAnimationView;
        this.back = titleBackView;
        this.btnCheck = settingItemView;
        this.btnDelete = textView;
        this.btnReRecord = settingItemView2;
        this.shadow = paddingShadowLayout;
        this.text1 = textView2;
        this.title = textView3;
    }

    public static com.up366.mobile.databinding.VoiceSettedLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.VoiceSettedLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.VoiceSettedLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.voice_setted_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.VoiceSettedLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.VoiceSettedLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.VoiceSettedLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.voice_setted_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.VoiceSettedLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.VoiceSettedLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.VoiceSettedLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.voice_setted_layout);
    }
}
