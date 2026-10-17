package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ActivityImageEssayRecognitionBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.Button btRecognitionLow;
    public final androidx.constraintlayout.widget.ConstraintLayout clRecognitionBottom;
    public final android.widget.ImageButton ibAfterRecognitionBack;
    public final android.widget.ImageButton ibBeforeRecognitionBack;
    public final android.widget.ImageButton ibConfirmRecognitionResult;
    public final pl.droidsonroids.gif.GifImageView ivRecognitionDoing;
    public final android.widget.ImageView ivRecognitionImage;
    public final android.widget.RelativeLayout rlRecognitionResult;
    private final android.widget.RelativeLayout rootView;
    public final android.widget.TextView tvRecognitionResult;
    public final android.widget.TextView tvRecognitionToast;

    private ActivityImageEssayRecognitionBinding(android.widget.RelativeLayout relativeLayout, android.widget.Button button, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageButton imageButton, android.widget.ImageButton imageButton2, android.widget.ImageButton imageButton3, pl.droidsonroids.gif.GifImageView gifImageView, android.widget.ImageView imageView, android.widget.RelativeLayout relativeLayout2, android.widget.TextView textView, android.widget.TextView textView2) {
        this.rootView = relativeLayout;
        this.btRecognitionLow = button;
        this.clRecognitionBottom = constraintLayout;
        this.ibAfterRecognitionBack = imageButton;
        this.ibBeforeRecognitionBack = imageButton2;
        this.ibConfirmRecognitionResult = imageButton3;
        this.ivRecognitionDoing = gifImageView;
        this.ivRecognitionImage = imageView;
        this.rlRecognitionResult = relativeLayout2;
        this.tvRecognitionResult = textView;
        this.tvRecognitionToast = textView2;
    }

    public android.widget.RelativeLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.ActivityImageEssayRecognitionBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.ActivityImageEssayRecognitionBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.activity_image_essay_recognition, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.ActivityImageEssayRecognitionBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.bt_recognition_low;
        android.widget.Button button = (android.widget.Button) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.bt_recognition_low);
        if (button != null) {
            i = com.up366.mobile.R.id.cl_recognition_bottom;
            androidx.constraintlayout.widget.ConstraintLayout constraintLayoutFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.cl_recognition_bottom);
            if (constraintLayoutFindChildViewById != null) {
                i = com.up366.mobile.R.id.ib_after_recognition_back;
                android.widget.ImageButton imageButton = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.ib_after_recognition_back);
                if (imageButton != null) {
                    i = com.up366.mobile.R.id.ib_before_recognition_back;
                    android.widget.ImageButton imageButton2 = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.ib_before_recognition_back);
                    if (imageButton2 != null) {
                        i = com.up366.mobile.R.id.ib_confirm_recognition_result;
                        android.widget.ImageButton imageButton3 = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.ib_confirm_recognition_result);
                        if (imageButton3 != null) {
                            i = com.up366.mobile.R.id.iv_recognition_doing;
                            pl.droidsonroids.gif.GifImageView gifImageViewFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.iv_recognition_doing);
                            if (gifImageViewFindChildViewById != null) {
                                i = com.up366.mobile.R.id.iv_recognition_image;
                                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.iv_recognition_image);
                                if (imageView != null) {
                                    i = com.up366.mobile.R.id.rl_recognition_result;
                                    android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.rl_recognition_result);
                                    if (relativeLayout != null) {
                                        i = com.up366.mobile.R.id.tv_recognition_result;
                                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_recognition_result);
                                        if (textView != null) {
                                            i = com.up366.mobile.R.id.tv_recognition_toast;
                                            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_recognition_toast);
                                            if (textView2 != null) {
                                                return new com.up366.mobile.databinding.ActivityImageEssayRecognitionBinding((android.widget.RelativeLayout) view, button, constraintLayoutFindChildViewById, imageButton, imageButton2, imageButton3, gifImageViewFindChildViewById, imageView, relativeLayout, textView, textView2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
