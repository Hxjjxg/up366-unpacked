package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class V1WellDownViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.Button gameOverBackCatalog;
    public final android.widget.Button gameOverNextUnit;

    protected V1WellDownViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.Button button, android.widget.Button button2) {
        super(obj, view, i);
        this.gameOverBackCatalog = button;
        this.gameOverNextUnit = button2;
    }

    public static com.up366.mobile.databinding.V1WellDownViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.V1WellDownViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.V1WellDownViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.v1_well_down_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.V1WellDownViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.V1WellDownViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.V1WellDownViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.v1_well_down_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.V1WellDownViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.V1WellDownViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.V1WellDownViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.v1_well_down_view_layout);
    }
}
