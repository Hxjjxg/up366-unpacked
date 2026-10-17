package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeBindingParentAcivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.common.views.TitleBackView backBtn;
    public final com.up366.mobile.common.views.GuidePointView guide;
    public final androidx.recyclerview.widget.RecyclerView recycleView;
    public final android.widget.Button shareBtn;
    public final android.widget.TextView title;

    protected MeBindingParentAcivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.common.views.TitleBackView titleBackView, com.up366.mobile.common.views.GuidePointView guidePointView, androidx.recyclerview.widget.RecyclerView recyclerView, android.widget.Button button, android.widget.TextView textView) {
        super(obj, view, i);
        this.backBtn = titleBackView;
        this.guide = guidePointView;
        this.recycleView = recyclerView;
        this.shareBtn = button;
        this.title = textView;
    }

    public static com.up366.mobile.databinding.MeBindingParentAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeBindingParentAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeBindingParentAcivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_binding_parent_acivity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeBindingParentAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeBindingParentAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeBindingParentAcivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_binding_parent_acivity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeBindingParentAcivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeBindingParentAcivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeBindingParentAcivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_binding_parent_acivity_layout);
    }
}
