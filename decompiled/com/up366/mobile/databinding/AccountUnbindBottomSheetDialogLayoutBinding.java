package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountUnbindBottomSheetDialogLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView btnClose;
    public final android.widget.TextView btnUnbind;
    public final android.widget.TextView message;
    public final android.widget.TextView title;

    protected AccountUnbindBottomSheetDialogLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3) {
        super(obj, view, i);
        this.btnClose = imageView;
        this.btnUnbind = textView;
        this.message = textView2;
        this.title = textView3;
    }

    public static com.up366.mobile.databinding.AccountUnbindBottomSheetDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountUnbindBottomSheetDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountUnbindBottomSheetDialogLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_unbind_bottom_sheet_dialog_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountUnbindBottomSheetDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountUnbindBottomSheetDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountUnbindBottomSheetDialogLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_unbind_bottom_sheet_dialog_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountUnbindBottomSheetDialogLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountUnbindBottomSheetDialogLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountUnbindBottomSheetDialogLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_unbind_bottom_sheet_dialog_layout);
    }
}
