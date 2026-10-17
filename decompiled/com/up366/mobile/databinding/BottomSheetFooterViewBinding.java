package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class BottomSheetFooterViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView footerBtn;

    protected BottomSheetFooterViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView) {
        super(obj, view, i);
        this.footerBtn = textView;
    }

    public static com.up366.mobile.databinding.BottomSheetFooterViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BottomSheetFooterViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BottomSheetFooterViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.bottom_sheet_footer_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.BottomSheetFooterViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BottomSheetFooterViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BottomSheetFooterViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.bottom_sheet_footer_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.BottomSheetFooterViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BottomSheetFooterViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BottomSheetFooterViewBinding) bind(obj, view, com.up366.mobile.R.layout.bottom_sheet_footer_view);
    }
}
