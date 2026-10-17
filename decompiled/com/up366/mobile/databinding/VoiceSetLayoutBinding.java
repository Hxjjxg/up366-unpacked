package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class VoiceSetLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView anim;
    public final com.up366.mobile.common.views.TitleBackView back;
    public final android.widget.TextView btnRecord;
    public final com.up366.mobile.common.views.PaddingShadowLayout shadow;
    public final android.widget.TextView text1;
    public final android.widget.TextView text2;
    public final android.widget.TextView title;

    protected VoiceSetLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, com.up366.mobile.common.views.TitleBackView titleBackView, android.widget.TextView textView, com.up366.mobile.common.views.PaddingShadowLayout paddingShadowLayout, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4) {
        super(obj, view, i);
        this.anim = imageView;
        this.back = titleBackView;
        this.btnRecord = textView;
        this.shadow = paddingShadowLayout;
        this.text1 = textView2;
        this.text2 = textView3;
        this.title = textView4;
    }

    public static com.up366.mobile.databinding.VoiceSetLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.VoiceSetLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.VoiceSetLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.voice_set_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.VoiceSetLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.VoiceSetLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.VoiceSetLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.voice_set_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.VoiceSetLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.VoiceSetLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.VoiceSetLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.voice_set_layout);
    }
}
