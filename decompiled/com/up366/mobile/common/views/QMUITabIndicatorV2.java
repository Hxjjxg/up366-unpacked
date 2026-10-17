package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class QMUITabIndicatorV2 extends com.up366.qmui.widget.tab.QMUITabIndicator {
    private static final int DEFAULT_MOVIE_DURATION = 1000;
    private static final int PAINT_STROKE_WIDTH = 20;
    private int angle;
    private android.animation.ValueAnimator animator;
    private android.view.View hostview;
    private android.graphics.Paint mPaint;
    private int tabheidht;
    private int tabwidth;
    private android.graphics.RectF rectF = new android.graphics.RectF();
    private boolean start = false;
    private float paintWidth = 0.0f;
    private int status = -2;
    private float bili = (float) java.lang.Math.cos(java.lang.Math.toRadians(25.0d));

    public QMUITabIndicatorV2() {
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mPaint = paint;
        paint.setColor(android.graphics.Color.parseColor("#5C7CFF"));
        this.mPaint.setStrokeWidth(20.0f);
        this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(0, 55);
        this.animator = valueAnimatorOfInt;
        valueAnimatorOfInt.setInterpolator(new android.view.animation.LinearInterpolator());
        this.animator.setDuration(50L);
        this.animator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.mobile.common.views.QMUITabIndicatorV2$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f$0.lambda$new$0(valueAnimator);
            }
        });
        this.animator.addListener(new com.up366.mobile.common.views.QMUITabIndicatorV2.AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(android.animation.ValueAnimator valueAnimator) {
        this.angle = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
        android.view.View view = this.hostview;
        if (view != null) {
            view.postInvalidate();
        }
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.views.QMUITabIndicatorV2$1, reason: invalid class name */
    class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            super.onAnimationEnd(animator);
            com.up366.common.task.TaskUtils.postMainTaskDelay(20L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.QMUITabIndicatorV2$1$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onAnimationEnd$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAnimationEnd$0() throws java.lang.Exception {
            com.up366.mobile.common.views.QMUITabIndicatorV2.this.start = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            super.onAnimationStart(animator);
            com.up366.mobile.common.views.QMUITabIndicatorV2.this.start = true;
        }
    }

    @Override // com.up366.qmui.widget.tab.QMUITabIndicator
    public com.up366.qmui.widget.tab.QMUITabIndicator setmIndicatorHeight(int i) {
        this.tabheidht = i;
        float f = i / 2.5f;
        this.paintWidth = f;
        this.mPaint.setStrokeWidth(f);
        return super.setmIndicatorHeight(i);
    }

    @Override // com.up366.qmui.widget.tab.QMUITabIndicator
    public com.up366.qmui.widget.tab.QMUITabIndicator setmIndicatorWidth(int i) {
        this.tabwidth = i;
        return super.setmIndicatorWidth(i);
    }

    @Override // com.up366.qmui.widget.tab.QMUITabIndicator
    protected void draw(android.view.View view, android.graphics.Canvas canvas, int i, int i2) {
        this.hostview = view;
        updateDrawRect(view, canvas, i, i2);
        this.rectF.set(getmIndicatorRect());
        android.graphics.RectF rectF = this.rectF;
        rectF.left = (rectF.left + (this.rectF.width() / 2.0f)) - (this.tabwidth / 2);
        android.graphics.RectF rectF2 = this.rectF;
        rectF2.right = rectF2.left + this.tabwidth;
        float fWidth = ((this.rectF.width() / 2.0f) / this.bili) * 2.0f;
        this.rectF.left -= (fWidth - this.tabwidth) / 2.0f;
        android.graphics.RectF rectF3 = this.rectF;
        rectF3.right = rectF3.left + fWidth;
        android.graphics.RectF rectF4 = this.rectF;
        rectF4.top = rectF4.bottom - fWidth;
        android.graphics.RectF rectF5 = this.rectF;
        float f = this.paintWidth;
        rectF5.inset(f / 2.0f, f / 2.0f);
        if (getStatus() == 1) {
            if (!this.animator.isStarted() && !this.start && this.status != 1) {
                this.animator.start();
            }
            this.status = 1;
            android.graphics.RectF rectF6 = this.rectF;
            int i3 = this.angle;
            canvas.drawArc(rectF6, i3 + 25, 130 - (i3 * 2), false, this.mPaint);
            return;
        }
        if (getStatus() == 2) {
            if (!this.animator.isStarted() && !this.start && this.status != 2) {
                this.animator.reverse();
            }
            this.status = 2;
            android.graphics.RectF rectF7 = this.rectF;
            int i4 = this.angle;
            canvas.drawArc(rectF7, i4 + 25, 130 - (i4 * 2), false, this.mPaint);
            return;
        }
        if (!this.animator.isStarted()) {
            canvas.drawArc(this.rectF, 80.0f, 20.0f, false, this.mPaint);
        }
        this.status = 0;
    }
}
