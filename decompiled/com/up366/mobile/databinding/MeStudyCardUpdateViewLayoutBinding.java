package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeStudyCardUpdateViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final androidx.constraintlayout.widget.ConstraintLayout courseViewTextBtn;
    public final android.widget.TextView toUpdateBtn;
    public final android.widget.TextView toUpdateBtnDown;
    public final android.widget.TextView toUpdateBtnUp;

    protected MeStudyCardUpdateViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3) {
        super(obj, view, i);
        this.courseViewTextBtn = constraintLayout;
        this.toUpdateBtn = textView;
        this.toUpdateBtnDown = textView2;
        this.toUpdateBtnUp = textView3;
    }

    public static com.up366.mobile.databinding.MeStudyCardUpdateViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeStudyCardUpdateViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeStudyCardUpdateViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_study_card_update_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeStudyCardUpdateViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeStudyCardUpdateViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeStudyCardUpdateViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_study_card_update_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeStudyCardUpdateViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeStudyCardUpdateViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeStudyCardUpdateViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_study_card_update_view_layout);
    }
}
