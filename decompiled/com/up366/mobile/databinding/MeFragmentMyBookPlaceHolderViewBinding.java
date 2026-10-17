package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeFragmentMyBookPlaceHolderViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView bookPictureName;

    protected MeFragmentMyBookPlaceHolderViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView) {
        super(obj, view, i);
        this.bookPictureName = textView;
    }

    public static com.up366.mobile.databinding.MeFragmentMyBookPlaceHolderViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeFragmentMyBookPlaceHolderViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeFragmentMyBookPlaceHolderViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_fragment_my_book_place_holder_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeFragmentMyBookPlaceHolderViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeFragmentMyBookPlaceHolderViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeFragmentMyBookPlaceHolderViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_fragment_my_book_place_holder_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeFragmentMyBookPlaceHolderViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeFragmentMyBookPlaceHolderViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeFragmentMyBookPlaceHolderViewBinding) bind(obj, view, com.up366.mobile.R.layout.me_fragment_my_book_place_holder_view);
    }
}
