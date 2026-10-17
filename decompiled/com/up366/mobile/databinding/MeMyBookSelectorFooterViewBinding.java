package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeMyBookSelectorFooterViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView footerText;
    public final android.view.View line;

    protected MeMyBookSelectorFooterViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.view.View view2) {
        super(obj, view, i);
        this.footerText = textView;
        this.line = view2;
    }

    public static com.up366.mobile.databinding.MeMyBookSelectorFooterViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeMyBookSelectorFooterViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeMyBookSelectorFooterViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_my_book_selector_footer_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeMyBookSelectorFooterViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeMyBookSelectorFooterViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeMyBookSelectorFooterViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_my_book_selector_footer_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeMyBookSelectorFooterViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeMyBookSelectorFooterViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeMyBookSelectorFooterViewBinding) bind(obj, view, com.up366.mobile.R.layout.me_my_book_selector_footer_view);
    }
}
