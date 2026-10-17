package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ViewTrendViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView ivLastCompare;
    public final android.widget.ImageView ivTrendTitle;
    public final com.up366.mobile.common.views.LineSheetViewV3 lsvShowChart;
    public final android.widget.RadioButton rbEarthLineColor;
    public final android.widget.RadioButton rbMyLineColor;
    public final android.widget.RadioButton rbSchoolLineColor;
    public final android.widget.TextView tvChartYTitle;
    public final android.widget.TextView tvLastCompare;
    public final android.widget.TextView tvTrendTitle;

    protected ViewTrendViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.ImageView imageView2, com.up366.mobile.common.views.LineSheetViewV3 lineSheetViewV3, android.widget.RadioButton radioButton, android.widget.RadioButton radioButton2, android.widget.RadioButton radioButton3, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3) {
        super(obj, view, i);
        this.ivLastCompare = imageView;
        this.ivTrendTitle = imageView2;
        this.lsvShowChart = lineSheetViewV3;
        this.rbEarthLineColor = radioButton;
        this.rbMyLineColor = radioButton2;
        this.rbSchoolLineColor = radioButton3;
        this.tvChartYTitle = textView;
        this.tvLastCompare = textView2;
        this.tvTrendTitle = textView3;
    }

    public static com.up366.mobile.databinding.ViewTrendViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ViewTrendViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ViewTrendViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.view_trend_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ViewTrendViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ViewTrendViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ViewTrendViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.view_trend_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ViewTrendViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ViewTrendViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ViewTrendViewBinding) bind(obj, view, com.up366.mobile.R.layout.view_trend_view);
    }
}
