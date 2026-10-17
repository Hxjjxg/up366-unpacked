package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class VoiceRecordLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.common.views.TitleBackView back;
    public final android.widget.TextView content;
    public final com.up366.mobile.user.account.voice.RecordButton record;
    public final com.up366.mobile.common.views.PaddingShadowLayout shadow;
    public final com.up366.mobile.common.views.PaddingShadowLayout tipBg;
    public final android.widget.TextView tipMessage;
    public final android.widget.TextView tipUsername;
    public final android.widget.TextView title;

    protected VoiceRecordLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.common.views.TitleBackView titleBackView, android.widget.TextView textView, com.up366.mobile.user.account.voice.RecordButton recordButton, com.up366.mobile.common.views.PaddingShadowLayout paddingShadowLayout, com.up366.mobile.common.views.PaddingShadowLayout paddingShadowLayout2, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4) {
        super(obj, view, i);
        this.back = titleBackView;
        this.content = textView;
        this.record = recordButton;
        this.shadow = paddingShadowLayout;
        this.tipBg = paddingShadowLayout2;
        this.tipMessage = textView2;
        this.tipUsername = textView3;
        this.title = textView4;
    }

    public static com.up366.mobile.databinding.VoiceRecordLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.VoiceRecordLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.VoiceRecordLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.voice_record_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.VoiceRecordLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.VoiceRecordLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.VoiceRecordLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.voice_record_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.VoiceRecordLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.VoiceRecordLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.VoiceRecordLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.voice_record_layout);
    }
}
