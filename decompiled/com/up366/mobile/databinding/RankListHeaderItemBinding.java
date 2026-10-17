package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class RankListHeaderItemBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.FrameLayout flHasDestroyWord;
    public final android.widget.FrameLayout flName;
    public final android.widget.FrameLayout flRemainWord;
    public final android.widget.FrameLayout flTodayDestroyWord;
    public final android.widget.TextView tvHasDestroyWord;
    public final android.widget.TextView tvName;
    public final android.widget.TextView tvRemainWord;
    public final android.widget.TextView tvTodayDestroyWord;

    protected RankListHeaderItemBinding(java.lang.Object obj, android.view.View view, int i, android.widget.FrameLayout frameLayout, android.widget.FrameLayout frameLayout2, android.widget.FrameLayout frameLayout3, android.widget.FrameLayout frameLayout4, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4) {
        super(obj, view, i);
        this.flHasDestroyWord = frameLayout;
        this.flName = frameLayout2;
        this.flRemainWord = frameLayout3;
        this.flTodayDestroyWord = frameLayout4;
        this.tvHasDestroyWord = textView;
        this.tvName = textView2;
        this.tvRemainWord = textView3;
        this.tvTodayDestroyWord = textView4;
    }

    public static com.up366.mobile.databinding.RankListHeaderItemBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.RankListHeaderItemBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.RankListHeaderItemBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.rank_list_header_item, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.RankListHeaderItemBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.RankListHeaderItemBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.RankListHeaderItemBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.rank_list_header_item, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.RankListHeaderItemBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.RankListHeaderItemBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.RankListHeaderItemBinding) bind(obj, view, com.up366.mobile.R.layout.rank_list_header_item);
    }
}
