package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class PermissionDialogBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView permissionContent;
    public final android.widget.TextView permissionTitle;

    protected PermissionDialogBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2) {
        super(obj, view, i);
        this.permissionContent = textView;
        this.permissionTitle = textView2;
    }

    public static com.up366.mobile.databinding.PermissionDialogBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.PermissionDialogBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.PermissionDialogBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.permission_dialog, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.PermissionDialogBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.PermissionDialogBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.PermissionDialogBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.permission_dialog, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.PermissionDialogBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.PermissionDialogBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.PermissionDialogBinding) bind(obj, view, com.up366.mobile.R.layout.permission_dialog);
    }
}
