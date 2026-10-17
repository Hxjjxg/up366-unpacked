package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class SettingItemViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.common.views.SwitchButton btnSwitch;
    public final android.widget.ImageView cursor;
    public final android.view.View line;
    public final com.up366.mobile.common.views.RedPointImageView redPoint;
    public final android.widget.TextView text;
    public final android.widget.TextView textRight;

    protected SettingItemViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.common.views.SwitchButton switchButton, android.widget.ImageView imageView, android.view.View view2, com.up366.mobile.common.views.RedPointImageView redPointImageView, android.widget.TextView textView, android.widget.TextView textView2) {
        super(obj, view, i);
        this.btnSwitch = switchButton;
        this.cursor = imageView;
        this.line = view2;
        this.redPoint = redPointImageView;
        this.text = textView;
        this.textRight = textView2;
    }

    public static com.up366.mobile.databinding.SettingItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.SettingItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.SettingItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.setting_item_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.SettingItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.SettingItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.SettingItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.setting_item_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.SettingItemViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.SettingItemViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.SettingItemViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.setting_item_view_layout);
    }
}
