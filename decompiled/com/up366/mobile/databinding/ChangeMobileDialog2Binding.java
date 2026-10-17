package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ChangeMobileDialog2Binding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView btnCancel;
    public final android.widget.TextView btnConfirmChange;
    public final android.widget.TextView title;

    protected ChangeMobileDialog2Binding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3) {
        super(obj, view, i);
        this.btnCancel = textView;
        this.btnConfirmChange = textView2;
        this.title = textView3;
    }

    public static com.up366.mobile.databinding.ChangeMobileDialog2Binding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ChangeMobileDialog2Binding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ChangeMobileDialog2Binding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.change_mobile_dialog2, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ChangeMobileDialog2Binding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ChangeMobileDialog2Binding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ChangeMobileDialog2Binding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.change_mobile_dialog2, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ChangeMobileDialog2Binding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ChangeMobileDialog2Binding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ChangeMobileDialog2Binding) bind(obj, view, com.up366.mobile.R.layout.change_mobile_dialog2);
    }
}
