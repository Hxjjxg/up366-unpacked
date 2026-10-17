package com.up366.medialibrary.camera.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CaptureButton extends android.view.View {
    public static final int STATE_BAN = 5;
    public static final int STATE_IDLE = 1;
    public static final int STATE_LONG_PRESS = 3;
    public static final int STATE_PRESS = 2;
    public static final int STATE_RECORDERING = 4;
    private float button_inside_radius;
    private float button_outside_radius;
    private float button_radius;
    private int button_size;
    private int button_state;
    private com.up366.medialibrary.camera.listener.CaptureListener captureLisenter;
    private float center_X;
    private float center_Y;
    private int duration;
    private float event_Y;
    private int inside_color;
    private int inside_reduce_size;
    private boolean isTakeCamera;
    private com.up366.medialibrary.camera.view.CaptureButton.LongPressRunnable longPressRunnable;
    private android.graphics.Paint mPaint;
    private int min_duration;
    private int outside_add_size;
    private int outside_color;
    private float progress;
    private int progress_color;
    private int recorded_time;
    private android.graphics.RectF rectF;
    private int state;
    private float strokeWidth;
    private com.up366.medialibrary.camera.view.CaptureButton.RecordCountDownTimer timer;

    public CaptureButton(android.content.Context context) {
        super(context);
        this.progress_color = -300503530;
        this.outside_color = -287515428;
        this.inside_color = -1;
        this.isTakeCamera = true;
    }

    public CaptureButton(android.content.Context context, int i) {
        super(context);
        this.progress_color = -300503530;
        this.outside_color = -287515428;
        this.inside_color = -1;
        this.isTakeCamera = true;
        this.button_size = i;
        float f = i / 2.0f;
        this.button_radius = f;
        this.button_outside_radius = f;
        this.button_inside_radius = f * 0.75f;
        this.strokeWidth = i / 15;
        int i2 = i / 8;
        this.outside_add_size = i2;
        this.inside_reduce_size = i2;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.progress = 0.0f;
        this.longPressRunnable = new com.up366.medialibrary.camera.view.CaptureButton.LongPressRunnable();
        this.state = 1;
        this.button_state = com.up366.medialibrary.camera.CustomCameraType.BUTTON_STATE_BOTH;
        this.duration = 10000;
        this.min_duration = com.up366.medialibrary.camera.CustomCameraView.DEFAULT_MIN_RECORD_VIDEO;
        int i3 = this.button_size;
        int i4 = this.outside_add_size;
        this.center_X = ((i4 * 2) + i3) / 2;
        this.center_Y = (i3 + (i4 * 2)) / 2;
        float f2 = this.center_X;
        float f3 = this.button_radius;
        int i5 = this.outside_add_size;
        float f4 = this.strokeWidth;
        float f5 = this.center_Y;
        this.rectF = new android.graphics.RectF(f2 - ((i5 + f3) - (f4 / 2.0f)), f5 - ((i5 + f3) - (f4 / 2.0f)), f2 + ((i5 + f3) - (f4 / 2.0f)), f5 + ((f3 + i5) - (f4 / 2.0f)));
        this.timer = new com.up366.medialibrary.camera.view.CaptureButton.RecordCountDownTimer(this.duration, r15 / 360);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.button_size;
        int i4 = this.outside_add_size;
        setMeasuredDimension((i4 * 2) + i3, i3 + (i4 * 2));
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.mPaint.setColor(this.outside_color);
        canvas.drawCircle(this.center_X, this.center_Y, this.button_outside_radius, this.mPaint);
        this.mPaint.setColor(this.inside_color);
        canvas.drawCircle(this.center_X, this.center_Y, this.button_inside_radius, this.mPaint);
        if (this.state == 4) {
            this.mPaint.setColor(this.progress_color);
            this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.strokeWidth);
            canvas.drawArc(this.rectF, -90.0f, this.progress, false, this.mPaint);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        com.up366.medialibrary.camera.listener.CaptureListener captureListener;
        int i;
        if (this.isTakeCamera) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    handlerPressByState();
                } else if (action == 2 && (captureListener = this.captureLisenter) != null && this.state == 4 && ((i = this.button_state) == 258 || i == 259)) {
                    captureListener.recordZoom(this.event_Y - motionEvent.getY());
                }
            } else if (motionEvent.getPointerCount() <= 1 && this.state == 1) {
                this.event_Y = motionEvent.getY();
                this.state = 2;
                int i2 = this.button_state;
                if (i2 == 258 || i2 == 259) {
                    postDelayed(this.longPressRunnable, 500L);
                }
            }
        }
        return true;
    }

    private void handlerPressByState() {
        int i;
        removeCallbacks(this.longPressRunnable);
        int i2 = this.state;
        if (i2 != 2) {
            if (i2 == 3 || i2 == 4) {
                this.timer.cancel();
                recordEnd();
            }
        } else if (this.captureLisenter != null && ((i = this.button_state) == 257 || i == 259)) {
            startCaptureAnimation(this.button_inside_radius);
        } else {
            this.state = 1;
        }
        this.state = 1;
    }

    public void recordEnd() {
        com.up366.medialibrary.camera.listener.CaptureListener captureListener = this.captureLisenter;
        if (captureListener != null) {
            int i = this.recorded_time;
            if (i < this.min_duration) {
                captureListener.recordShort(i);
            } else {
                captureListener.recordEnd(i);
            }
        }
        resetRecordAnim();
    }

    private void resetRecordAnim() {
        this.state = 5;
        this.progress = 0.0f;
        invalidate();
        float f = this.button_outside_radius;
        float f2 = this.button_radius;
        startRecordAnimation(f, f2, this.button_inside_radius, 0.75f * f2);
    }

    private void startCaptureAnimation(float f) {
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(f, 0.75f * f, f);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.medialibrary.camera.view.CaptureButton$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f$0.m166x5d4fe6f8(valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.up366.medialibrary.camera.view.CaptureButton.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                super.onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                super.onAnimationStart(animator);
                if (com.up366.medialibrary.camera.view.CaptureButton.this.captureLisenter != null) {
                    com.up366.medialibrary.camera.view.CaptureButton.this.captureLisenter.takePictures();
                }
                com.up366.medialibrary.camera.view.CaptureButton.this.state = 5;
            }
        });
        valueAnimatorOfFloat.setDuration(50L);
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: renamed from: lambda$startCaptureAnimation$0$com-up366-medialibrary-camera-view-CaptureButton, reason: not valid java name */
    /* synthetic */ void m166x5d4fe6f8(android.animation.ValueAnimator valueAnimator) {
        this.button_inside_radius = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecordAnimation(float f, float f2, float f3, float f4) {
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(f, f2);
        android.animation.ValueAnimator valueAnimatorOfFloat2 = android.animation.ValueAnimator.ofFloat(f3, f4);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.medialibrary.camera.view.CaptureButton$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f$0.m167xccefb4c(valueAnimator);
            }
        });
        valueAnimatorOfFloat2.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.medialibrary.camera.view.CaptureButton$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f$0.m168xfe78a16b(valueAnimator);
            }
        });
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.up366.medialibrary.camera.view.CaptureButton.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                super.onAnimationEnd(animator);
                if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick()) {
                    return;
                }
                if (com.up366.medialibrary.camera.view.CaptureButton.this.state == 3) {
                    if (com.up366.medialibrary.camera.view.CaptureButton.this.captureLisenter != null) {
                        com.up366.medialibrary.camera.view.CaptureButton.this.captureLisenter.recordStart();
                    }
                    com.up366.medialibrary.camera.view.CaptureButton.this.state = 4;
                    com.up366.medialibrary.camera.view.CaptureButton.this.timer.start();
                    return;
                }
                com.up366.medialibrary.camera.view.CaptureButton.this.state = 1;
            }
        });
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        animatorSet.setDuration(100L);
        animatorSet.start();
    }

    /* JADX INFO: renamed from: lambda$startRecordAnimation$1$com-up366-medialibrary-camera-view-CaptureButton, reason: not valid java name */
    /* synthetic */ void m167xccefb4c(android.animation.ValueAnimator valueAnimator) {
        this.button_outside_radius = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: renamed from: lambda$startRecordAnimation$2$com-up366-medialibrary-camera-view-CaptureButton, reason: not valid java name */
    /* synthetic */ void m168xfe78a16b(android.animation.ValueAnimator valueAnimator) {
        this.button_inside_radius = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(long j) {
        int i = this.duration;
        this.recorded_time = (int) (((long) i) - j);
        this.progress = 360.0f - ((j / i) * 360.0f);
        invalidate();
    }

    private class RecordCountDownTimer extends android.os.CountDownTimer {
        RecordCountDownTimer(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            com.up366.medialibrary.camera.view.CaptureButton.this.updateProgress(j);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            com.up366.medialibrary.camera.view.CaptureButton.this.recordEnd();
        }
    }

    private class LongPressRunnable implements java.lang.Runnable {
        private LongPressRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.up366.medialibrary.camera.view.CaptureButton.this.state = 3;
            if (com.up366.medialibrary.camera.CheckPermission.getRecordState() != 1) {
                com.up366.medialibrary.camera.view.CaptureButton.this.state = 1;
                if (com.up366.medialibrary.camera.view.CaptureButton.this.captureLisenter != null) {
                    com.up366.medialibrary.camera.view.CaptureButton.this.captureLisenter.recordError();
                    return;
                }
            }
            com.up366.medialibrary.camera.view.CaptureButton captureButton = com.up366.medialibrary.camera.view.CaptureButton.this;
            captureButton.startRecordAnimation(captureButton.button_outside_radius, com.up366.medialibrary.camera.view.CaptureButton.this.button_outside_radius + com.up366.medialibrary.camera.view.CaptureButton.this.outside_add_size, com.up366.medialibrary.camera.view.CaptureButton.this.button_inside_radius, com.up366.medialibrary.camera.view.CaptureButton.this.button_inside_radius - com.up366.medialibrary.camera.view.CaptureButton.this.inside_reduce_size);
        }
    }

    public void setDuration(int i) {
        this.duration = i;
        this.timer = new com.up366.medialibrary.camera.view.CaptureButton.RecordCountDownTimer(i, i / 360);
    }

    public void setMinDuration(int i) {
        this.min_duration = i;
    }

    public void setCaptureListener(com.up366.medialibrary.camera.listener.CaptureListener captureListener) {
        this.captureLisenter = captureListener;
    }

    public void setButtonFeatures(int i) {
        this.button_state = i;
    }

    public int getButtonFeatures() {
        return this.button_state;
    }

    public boolean isIdle() {
        return this.state == 1;
    }

    public void setButtonCaptureEnabled(boolean z) {
        this.isTakeCamera = z;
    }

    public void resetState() {
        this.state = 1;
    }
}
