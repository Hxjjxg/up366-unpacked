package com.up366.multimediav2.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ActivityCropBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.view.crop.AutoCropImageView autoCropView;
    public final androidx.constraintlayout.widget.ConstraintLayout cropBottom;
    public final androidx.constraintlayout.widget.ConstraintLayout frame;
    public final android.widget.ImageButton ibAutoTips;
    public final android.widget.ImageButton ibCropBack;
    public final android.widget.ImageButton ibCropRotate;
    public final android.widget.TextView ibCropTakePicture;
    public final android.widget.LinearLayout llAutoTitle;
    public final android.widget.ImageView pbLoading;
    public final androidx.constraintlayout.widget.ConstraintLayout rlRoot;
    public final android.widget.TextView tvDesc;
    public final android.widget.TextView tvRetry;
    public final android.widget.TextView tvTitle;
    public final com.up366.view.crop.view.UCropView ucrop;

    protected ActivityCropBinding(java.lang.Object obj, android.view.View view, int i, com.up366.view.crop.AutoCropImageView autoCropImageView, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, android.widget.ImageButton imageButton, android.widget.ImageButton imageButton2, android.widget.ImageButton imageButton3, android.widget.TextView textView, android.widget.LinearLayout linearLayout, android.widget.ImageView imageView, androidx.constraintlayout.widget.ConstraintLayout constraintLayout3, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, com.up366.view.crop.view.UCropView uCropView) {
        super(obj, view, i);
        this.autoCropView = autoCropImageView;
        this.cropBottom = constraintLayout;
        this.frame = constraintLayout2;
        this.ibAutoTips = imageButton;
        this.ibCropBack = imageButton2;
        this.ibCropRotate = imageButton3;
        this.ibCropTakePicture = textView;
        this.llAutoTitle = linearLayout;
        this.pbLoading = imageView;
        this.rlRoot = constraintLayout3;
        this.tvDesc = textView2;
        this.tvRetry = textView3;
        this.tvTitle = textView4;
        this.ucrop = uCropView;
    }

    public static com.up366.multimediav2.databinding.ActivityCropBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.multimediav2.databinding.ActivityCropBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.multimediav2.databinding.ActivityCropBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.multimediav2.R.layout.activity_crop, viewGroup, z, obj);
    }

    public static com.up366.multimediav2.databinding.ActivityCropBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.multimediav2.databinding.ActivityCropBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.multimediav2.databinding.ActivityCropBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.multimediav2.R.layout.activity_crop, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.multimediav2.databinding.ActivityCropBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.multimediav2.databinding.ActivityCropBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.multimediav2.databinding.ActivityCropBinding) bind(obj, view, com.up366.multimediav2.R.layout.activity_crop);
    }
}
