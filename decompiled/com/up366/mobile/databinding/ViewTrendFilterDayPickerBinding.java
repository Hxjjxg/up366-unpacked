package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ViewTrendFilterDayPickerBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.Button bottomConfirm;
    public final android.widget.Button btEndTime;
    public final android.widget.Button btStartTime;
    public final android.widget.ImageButton ibClose;
    public final android.widget.RelativeLayout rlTitle;
    public final com.up366.view.wheelview.WheelView wvMonth;
    public final com.up366.view.wheelview.WheelView wvYear;

    protected ViewTrendFilterDayPickerBinding(java.lang.Object obj, android.view.View view, int i, android.widget.Button button, android.widget.Button button2, android.widget.Button button3, android.widget.ImageButton imageButton, android.widget.RelativeLayout relativeLayout, com.up366.view.wheelview.WheelView wheelView, com.up366.view.wheelview.WheelView wheelView2) {
        super(obj, view, i);
        this.bottomConfirm = button;
        this.btEndTime = button2;
        this.btStartTime = button3;
        this.ibClose = imageButton;
        this.rlTitle = relativeLayout;
        this.wvMonth = wheelView;
        this.wvYear = wheelView2;
    }

    public static com.up366.mobile.databinding.ViewTrendFilterDayPickerBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ViewTrendFilterDayPickerBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ViewTrendFilterDayPickerBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.view_trend_filter_day_picker, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ViewTrendFilterDayPickerBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ViewTrendFilterDayPickerBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ViewTrendFilterDayPickerBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.view_trend_filter_day_picker, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ViewTrendFilterDayPickerBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ViewTrendFilterDayPickerBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ViewTrendFilterDayPickerBinding) bind(obj, view, com.up366.mobile.R.layout.view_trend_filter_day_picker);
    }
}
