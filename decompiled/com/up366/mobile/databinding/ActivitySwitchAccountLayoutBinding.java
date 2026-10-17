package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ActivitySwitchAccountLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.common.views.TitleBackView back;
    public final android.widget.TextView manageBtn;
    public final androidx.recyclerview.widget.RecyclerView recycleView;
    public final android.widget.TextView subTip;
    public final android.widget.TextView tip;
    public final android.widget.LinearLayout titleBarLayout;

    protected ActivitySwitchAccountLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.common.views.TitleBackView titleBackView, android.widget.TextView textView, androidx.recyclerview.widget.RecyclerView recyclerView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.LinearLayout linearLayout) {
        super(obj, view, i);
        this.back = titleBackView;
        this.manageBtn = textView;
        this.recycleView = recyclerView;
        this.subTip = textView2;
        this.tip = textView3;
        this.titleBarLayout = linearLayout;
    }

    public static com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_switch_account_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_switch_account_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.activity_switch_account_layout);
    }
}
