package com.up366.multimediav2.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class DialogAnswerSmartCameraGuideBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageButton ibClose;
    public final android.widget.TextView tvOperationTips;
    public final android.widget.TextView tvTitle;
    public final com.up366.view.RotationMapCirclePointView viewPagerIndex;
    public final androidx.viewpager.widget.ViewPager vpContentShow;

    protected DialogAnswerSmartCameraGuideBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageButton imageButton, android.widget.TextView textView, android.widget.TextView textView2, com.up366.view.RotationMapCirclePointView rotationMapCirclePointView, androidx.viewpager.widget.ViewPager viewPager) {
        super(obj, view, i);
        this.ibClose = imageButton;
        this.tvOperationTips = textView;
        this.tvTitle = textView2;
        this.viewPagerIndex = rotationMapCirclePointView;
        this.vpContentShow = viewPager;
    }

    public static com.up366.multimediav2.databinding.DialogAnswerSmartCameraGuideBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.multimediav2.databinding.DialogAnswerSmartCameraGuideBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.multimediav2.databinding.DialogAnswerSmartCameraGuideBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.multimediav2.R.layout.dialog_answer_smart_camera_guide, viewGroup, z, obj);
    }

    public static com.up366.multimediav2.databinding.DialogAnswerSmartCameraGuideBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.multimediav2.databinding.DialogAnswerSmartCameraGuideBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.multimediav2.databinding.DialogAnswerSmartCameraGuideBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.multimediav2.R.layout.dialog_answer_smart_camera_guide, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.multimediav2.databinding.DialogAnswerSmartCameraGuideBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.multimediav2.databinding.DialogAnswerSmartCameraGuideBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.multimediav2.databinding.DialogAnswerSmartCameraGuideBinding) bind(obj, view, com.up366.multimediav2.R.layout.dialog_answer_smart_camera_guide);
    }
}
