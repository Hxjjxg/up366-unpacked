package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class RankListItemViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.LinearLayout bgLayout;
    public final android.widget.ImageView ivRank;
    public final android.widget.TextView tvHasDestroyCount;
    public final android.widget.TextView tvRank;
    public final android.widget.TextView tvRankName;
    public final android.widget.TextView tvRemainCount;
    public final android.widget.TextView tvTodayDestroyCount;

    protected RankListItemViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.LinearLayout linearLayout, android.widget.ImageView imageView, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5) {
        super(obj, view, i);
        this.bgLayout = linearLayout;
        this.ivRank = imageView;
        this.tvHasDestroyCount = textView;
        this.tvRank = textView2;
        this.tvRankName = textView3;
        this.tvRemainCount = textView4;
        this.tvTodayDestroyCount = textView5;
    }

    public static com.up366.mobile.databinding.RankListItemViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.RankListItemViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.RankListItemViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.rank_list_item_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.RankListItemViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.RankListItemViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.RankListItemViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.rank_list_item_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.RankListItemViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.RankListItemViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.RankListItemViewBinding) bind(obj, view, com.up366.mobile.R.layout.rank_list_item_view);
    }
}
