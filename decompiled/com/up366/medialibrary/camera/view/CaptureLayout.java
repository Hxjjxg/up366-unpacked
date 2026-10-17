package com.up366.medialibrary.camera.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CaptureLayout extends android.widget.FrameLayout {
    private com.up366.medialibrary.camera.view.TypeButton btn_cancel;
    private com.up366.medialibrary.camera.view.CaptureButton btn_capture;
    private com.up366.medialibrary.camera.view.TypeButton btn_confirm;
    private com.up366.medialibrary.camera.view.ReturnButton btn_return;
    private final int button_size;
    private com.up366.medialibrary.camera.listener.CaptureListener captureListener;
    private int iconLeft;
    private int iconRight;
    private android.widget.ImageView iv_custom_left;
    private android.widget.ImageView iv_custom_right;
    private final int layout_height;
    private final int layout_width;
    private com.up366.medialibrary.camera.listener.ClickListener leftClickListener;
    private android.widget.ProgressBar progress_bar;
    private com.up366.medialibrary.camera.listener.ClickListener rightClickListener;
    private android.widget.TextView txt_tip;
    private com.up366.medialibrary.camera.listener.TypeListener typeListener;

    public void setTypeListener(com.up366.medialibrary.camera.listener.TypeListener typeListener) {
        this.typeListener = typeListener;
    }

    public void setCaptureListener(com.up366.medialibrary.camera.listener.CaptureListener captureListener) {
        this.captureListener = captureListener;
    }

    public CaptureLayout(android.content.Context context) {
        this(context, null);
    }

    public CaptureLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CaptureLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iconLeft = 0;
        this.iconRight = 0;
        int screenWidth = com.up366.medialibrary.common.utils.ScreenUtils.getScreenWidth(getContext());
        if (getResources().getConfiguration().orientation == 1) {
            this.layout_width = screenWidth;
        } else {
            this.layout_width = screenWidth / 2;
        }
        int i2 = (int) (this.layout_width / 4.5f);
        this.button_size = i2;
        this.layout_height = i2 + ((i2 / 5) * 2) + 100;
        initView();
        initEvent();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.layout_width, this.layout_height);
    }

    public void initEvent() {
        this.iv_custom_right.setVisibility(8);
        this.btn_cancel.setVisibility(8);
        this.btn_confirm.setVisibility(8);
    }

    public void startTypeBtnAnimator() {
        if (this.iconLeft != 0) {
            this.iv_custom_left.setVisibility(8);
        } else {
            this.btn_return.setVisibility(8);
        }
        if (this.iconRight != 0) {
            this.iv_custom_right.setVisibility(8);
        }
        this.btn_capture.setVisibility(8);
        this.btn_cancel.setVisibility(0);
        this.btn_confirm.setVisibility(0);
        this.btn_cancel.setClickable(false);
        this.btn_confirm.setClickable(false);
        this.iv_custom_left.setVisibility(8);
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.btn_cancel, "translationX", this.layout_width / 4, 0.0f);
        android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.btn_confirm, "translationX", (-this.layout_width) / 4, 0.0f);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.up366.medialibrary.camera.view.CaptureLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                super.onAnimationEnd(animator);
                com.up366.medialibrary.camera.view.CaptureLayout.this.btn_cancel.setClickable(true);
                com.up366.medialibrary.camera.view.CaptureLayout.this.btn_confirm.setClickable(true);
            }
        });
        animatorSet.setDuration(500L);
        animatorSet.start();
    }

    private void initView() {
        setWillNotDraw(false);
        this.progress_bar = new android.widget.ProgressBar(getContext());
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.progress_bar.setLayoutParams(layoutParams);
        this.progress_bar.setVisibility(8);
        this.btn_capture = new com.up366.medialibrary.camera.view.CaptureButton(getContext(), this.button_size);
        android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        this.btn_capture.setLayoutParams(layoutParams2);
        this.btn_capture.setCaptureListener(new com.up366.medialibrary.camera.listener.CaptureListener() { // from class: com.up366.medialibrary.camera.view.CaptureLayout.2
            @Override // com.up366.medialibrary.camera.listener.CaptureListener
            public void takePictures() {
                if (com.up366.medialibrary.camera.view.CaptureLayout.this.captureListener != null) {
                    com.up366.medialibrary.camera.view.CaptureLayout.this.captureListener.takePictures();
                }
                com.up366.medialibrary.camera.view.CaptureLayout.this.startAlphaAnimation();
            }

            @Override // com.up366.medialibrary.camera.listener.CaptureListener
            public void recordShort(long j) {
                if (com.up366.medialibrary.camera.view.CaptureLayout.this.captureListener != null) {
                    com.up366.medialibrary.camera.view.CaptureLayout.this.captureListener.recordShort(j);
                }
            }

            @Override // com.up366.medialibrary.camera.listener.CaptureListener
            public void recordStart() {
                if (com.up366.medialibrary.camera.view.CaptureLayout.this.captureListener != null) {
                    com.up366.medialibrary.camera.view.CaptureLayout.this.captureListener.recordStart();
                }
                com.up366.medialibrary.camera.view.CaptureLayout.this.startAlphaAnimation();
            }

            @Override // com.up366.medialibrary.camera.listener.CaptureListener
            public void recordEnd(long j) {
                if (com.up366.medialibrary.camera.view.CaptureLayout.this.captureListener != null) {
                    com.up366.medialibrary.camera.view.CaptureLayout.this.captureListener.recordEnd(j);
                }
                com.up366.medialibrary.camera.view.CaptureLayout.this.startTypeBtnAnimator();
            }

            @Override // com.up366.medialibrary.camera.listener.CaptureListener
            public void recordZoom(float f) {
                if (com.up366.medialibrary.camera.view.CaptureLayout.this.captureListener != null) {
                    com.up366.medialibrary.camera.view.CaptureLayout.this.captureListener.recordZoom(f);
                }
            }

            @Override // com.up366.medialibrary.camera.listener.CaptureListener
            public void recordError() {
                if (com.up366.medialibrary.camera.view.CaptureLayout.this.captureListener != null) {
                    com.up366.medialibrary.camera.view.CaptureLayout.this.captureListener.recordError();
                }
            }
        });
        this.btn_cancel = new com.up366.medialibrary.camera.view.TypeButton(getContext(), 1, this.button_size);
        android.widget.FrameLayout.LayoutParams layoutParams3 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 16;
        layoutParams3.setMargins((this.layout_width / 4) - (this.button_size / 2), 0, 0, 0);
        this.btn_cancel.setLayoutParams(layoutParams3);
        this.btn_cancel.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.camera.view.CaptureLayout$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m169x2b2104c1(view);
            }
        });
        this.btn_confirm = new com.up366.medialibrary.camera.view.TypeButton(getContext(), 2, this.button_size);
        android.widget.FrameLayout.LayoutParams layoutParams4 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams4.gravity = 21;
        layoutParams4.setMargins(0, 0, (this.layout_width / 4) - (this.button_size / 2), 0);
        this.btn_confirm.setLayoutParams(layoutParams4);
        this.btn_confirm.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.camera.view.CaptureLayout$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m170x1ccaaae0(view);
            }
        });
        this.btn_return = new com.up366.medialibrary.camera.view.ReturnButton(getContext(), (int) (this.button_size / 2.5f));
        android.widget.FrameLayout.LayoutParams layoutParams5 = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.setMargins(this.layout_width / 6, 0, 0, 0);
        this.btn_return.setLayoutParams(layoutParams5);
        this.btn_return.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.camera.view.CaptureLayout$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m171xe7450ff(view);
            }
        });
        this.iv_custom_left = new android.widget.ImageView(getContext());
        int i = this.button_size;
        android.widget.FrameLayout.LayoutParams layoutParams6 = new android.widget.FrameLayout.LayoutParams((int) (i / 2.5f), (int) (i / 2.5f));
        layoutParams6.gravity = 16;
        layoutParams6.setMargins(this.layout_width / 6, 0, 0, 0);
        this.iv_custom_left.setLayoutParams(layoutParams6);
        this.iv_custom_left.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.camera.view.CaptureLayout$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m172x1df71e(view);
            }
        });
        this.iv_custom_right = new android.widget.ImageView(getContext());
        int i2 = this.button_size;
        android.widget.FrameLayout.LayoutParams layoutParams7 = new android.widget.FrameLayout.LayoutParams((int) (i2 / 2.5f), (int) (i2 / 2.5f));
        layoutParams7.gravity = 21;
        layoutParams7.setMargins(0, 0, this.layout_width / 6, 0);
        this.iv_custom_right.setLayoutParams(layoutParams7);
        this.iv_custom_right.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.camera.view.CaptureLayout$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m173xf1c79d3d(view);
            }
        });
        this.txt_tip = new android.widget.TextView(getContext());
        android.widget.FrameLayout.LayoutParams layoutParams8 = new android.widget.FrameLayout.LayoutParams(-1, -2);
        layoutParams8.gravity = 1;
        layoutParams8.setMargins(0, 0, 0, 0);
        this.txt_tip.setText(getCaptureTip());
        this.txt_tip.setTextColor(-1);
        this.txt_tip.setGravity(17);
        this.txt_tip.setLayoutParams(layoutParams8);
        addView(this.btn_capture);
        addView(this.progress_bar);
        addView(this.btn_cancel);
        addView(this.btn_confirm);
        addView(this.btn_return);
        addView(this.iv_custom_left);
        addView(this.iv_custom_right);
        addView(this.txt_tip);
    }

    /* JADX INFO: renamed from: lambda$initView$0$com-up366-medialibrary-camera-view-CaptureLayout, reason: not valid java name */
    /* synthetic */ void m169x2b2104c1(android.view.View view) {
        com.up366.medialibrary.camera.listener.TypeListener typeListener = this.typeListener;
        if (typeListener != null) {
            typeListener.cancel();
        }
    }

    /* JADX INFO: renamed from: lambda$initView$1$com-up366-medialibrary-camera-view-CaptureLayout, reason: not valid java name */
    /* synthetic */ void m170x1ccaaae0(android.view.View view) {
        com.up366.medialibrary.camera.listener.TypeListener typeListener = this.typeListener;
        if (typeListener != null) {
            typeListener.confirm();
        }
    }

    /* JADX INFO: renamed from: lambda$initView$2$com-up366-medialibrary-camera-view-CaptureLayout, reason: not valid java name */
    /* synthetic */ void m171xe7450ff(android.view.View view) {
        com.up366.medialibrary.camera.listener.ClickListener clickListener = this.leftClickListener;
        if (clickListener != null) {
            clickListener.onClick();
        }
    }

    /* JADX INFO: renamed from: lambda$initView$3$com-up366-medialibrary-camera-view-CaptureLayout, reason: not valid java name */
    /* synthetic */ void m172x1df71e(android.view.View view) {
        com.up366.medialibrary.camera.listener.ClickListener clickListener = this.leftClickListener;
        if (clickListener != null) {
            clickListener.onClick();
        }
    }

    /* JADX INFO: renamed from: lambda$initView$4$com-up366-medialibrary-camera-view-CaptureLayout, reason: not valid java name */
    /* synthetic */ void m173xf1c79d3d(android.view.View view) {
        com.up366.medialibrary.camera.listener.ClickListener clickListener = this.rightClickListener;
        if (clickListener != null) {
            clickListener.onClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getCaptureTip() {
        int buttonFeatures = this.btn_capture.getButtonFeatures();
        if (buttonFeatures == 257) {
            return getContext().getString(com.up366.medialibrary.R.string.picture_photo_pictures);
        }
        if (buttonFeatures == 258) {
            return getContext().getString(com.up366.medialibrary.R.string.picture_photo_recording);
        }
        return getContext().getString(com.up366.medialibrary.R.string.picture_photo_camera);
    }

    public void setButtonCaptureEnabled(boolean z) {
        this.progress_bar.setVisibility(z ? 8 : 0);
        this.btn_capture.setButtonCaptureEnabled(z);
    }

    public void setCaptureLoadingColor(int i) {
        this.progress_bar.getIndeterminateDrawable().setColorFilter(androidx.core.graphics.BlendModeColorFilterCompat.createBlendModeColorFilterCompat(i, androidx.core.graphics.BlendModeCompat.SRC_IN));
    }

    public void resetCaptureLayout() {
        this.btn_capture.resetState();
        this.btn_cancel.setVisibility(8);
        this.btn_confirm.setVisibility(8);
        this.btn_capture.setVisibility(0);
        this.txt_tip.setText(getCaptureTip());
        this.txt_tip.setVisibility(0);
        if (this.iconLeft != 0) {
            this.iv_custom_left.setVisibility(0);
        } else {
            this.btn_return.setVisibility(0);
        }
        if (this.iconRight != 0) {
            this.iv_custom_right.setVisibility(0);
        }
    }

    public void startAlphaAnimation() {
        this.txt_tip.setVisibility(4);
    }

    public void setTextWithAnimation(java.lang.String str) {
        this.txt_tip.setText(str);
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.txt_tip, com.up366.qmui.skin.QMUISkinValueBuilder.ALPHA, 0.0f, 1.0f, 1.0f, 0.0f);
        objectAnimatorOfFloat.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.up366.medialibrary.camera.view.CaptureLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                super.onAnimationEnd(animator);
                com.up366.medialibrary.camera.view.CaptureLayout.this.txt_tip.setText(com.up366.medialibrary.camera.view.CaptureLayout.this.getCaptureTip());
                com.up366.medialibrary.camera.view.CaptureLayout.this.txt_tip.setAlpha(1.0f);
            }
        });
        objectAnimatorOfFloat.setDuration(2500L);
        objectAnimatorOfFloat.start();
    }

    public void setDuration(int i) {
        this.btn_capture.setDuration(i);
    }

    public void setMinDuration(int i) {
        this.btn_capture.setMinDuration(i);
    }

    public void setButtonFeatures(int i) {
        this.btn_capture.setButtonFeatures(i);
        this.txt_tip.setText(getCaptureTip());
    }

    public void setTip(java.lang.String str) {
        this.txt_tip.setText(str);
    }

    public void showTip() {
        this.txt_tip.setVisibility(0);
    }

    public void setIconSrc(int i, int i2) {
        this.iconLeft = i;
        this.iconRight = i2;
        if (i != 0) {
            this.iv_custom_left.setImageResource(i);
            this.iv_custom_left.setVisibility(0);
            this.btn_return.setVisibility(8);
        } else {
            this.iv_custom_left.setVisibility(8);
            this.btn_return.setVisibility(0);
        }
        if (this.iconRight != 0) {
            this.iv_custom_right.setImageResource(i2);
            this.iv_custom_right.setVisibility(0);
        } else {
            this.iv_custom_right.setVisibility(8);
        }
    }

    public void setLeftClickListener(com.up366.medialibrary.camera.listener.ClickListener clickListener) {
        this.leftClickListener = clickListener;
    }

    public void setRightClickListener(com.up366.medialibrary.camera.listener.ClickListener clickListener) {
        this.rightClickListener = clickListener;
    }
}
