package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class BottomDatePickerViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.Button cancel;
    public final android.widget.Button ok;
    public final com.contrarywind.view.WheelView wvSelectDay;
    public final com.contrarywind.view.WheelView wvSelectMonth;
    public final com.contrarywind.view.WheelView wvSelectYear;

    protected BottomDatePickerViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.Button button, android.widget.Button button2, com.contrarywind.view.WheelView wheelView, com.contrarywind.view.WheelView wheelView2, com.contrarywind.view.WheelView wheelView3) {
        super(obj, view, i);
        this.cancel = button;
        this.ok = button2;
        this.wvSelectDay = wheelView;
        this.wvSelectMonth = wheelView2;
        this.wvSelectYear = wheelView3;
    }

    public static com.up366.mobile.databinding.BottomDatePickerViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BottomDatePickerViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BottomDatePickerViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.bottom_date_picker_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.BottomDatePickerViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BottomDatePickerViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BottomDatePickerViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.bottom_date_picker_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.BottomDatePickerViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BottomDatePickerViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BottomDatePickerViewBinding) bind(obj, view, com.up366.mobile.R.layout.bottom_date_picker_view);
    }
}
