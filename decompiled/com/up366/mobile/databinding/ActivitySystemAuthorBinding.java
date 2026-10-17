package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ActivitySystemAuthorBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView audio;
    public final android.widget.TextView audioManage;
    public final android.widget.TextView audioTip;
    public final android.widget.TextView camara;
    public final android.widget.TextView camaraManage;
    public final android.widget.TextView camaraTip;
    public final android.widget.TextView flow;
    public final android.widget.TextView flowManage;
    public final android.widget.TextView flowTip;
    public final android.widget.TextView install;
    public final android.widget.TextView installManage;
    public final android.widget.TextView installTip;
    public final android.widget.TextView storage;
    public final android.widget.TextView storageManage;
    public final android.widget.TextView storageTip;
    public final android.widget.TextView tip;
    public final com.up366.mobile.common.views.TitleBarView titleBar;

    protected ActivitySystemAuthorBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, android.widget.TextView textView7, android.widget.TextView textView8, android.widget.TextView textView9, android.widget.TextView textView10, android.widget.TextView textView11, android.widget.TextView textView12, android.widget.TextView textView13, android.widget.TextView textView14, android.widget.TextView textView15, android.widget.TextView textView16, com.up366.mobile.common.views.TitleBarView titleBarView) {
        super(obj, view, i);
        this.audio = textView;
        this.audioManage = textView2;
        this.audioTip = textView3;
        this.camara = textView4;
        this.camaraManage = textView5;
        this.camaraTip = textView6;
        this.flow = textView7;
        this.flowManage = textView8;
        this.flowTip = textView9;
        this.install = textView10;
        this.installManage = textView11;
        this.installTip = textView12;
        this.storage = textView13;
        this.storageManage = textView14;
        this.storageTip = textView15;
        this.tip = textView16;
        this.titleBar = titleBarView;
    }

    public static com.up366.mobile.databinding.ActivitySystemAuthorBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivitySystemAuthorBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivitySystemAuthorBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_system_author, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ActivitySystemAuthorBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivitySystemAuthorBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivitySystemAuthorBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_system_author, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ActivitySystemAuthorBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivitySystemAuthorBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivitySystemAuthorBinding) bind(obj, view, com.up366.mobile.R.layout.activity_system_author);
    }
}
