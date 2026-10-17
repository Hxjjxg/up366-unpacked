package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CircularRevealLayout extends android.widget.FrameLayout {
    private static final java.lang.String TAG = "CircularRevealLayout";
    private final android.graphics.Path path;
    private float realRadius;
    private final android.graphics.RectF rect;
    private float touchX;
    private float touchY;

    public CircularRevealLayout(android.content.Context context) {
        this(context, null);
    }

    public CircularRevealLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularRevealLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.realRadius = -1.0f;
        this.rect = new android.graphics.RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.path = new android.graphics.Path();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        if (this.realRadius < 0.0f) {
            super.dispatchDraw(canvas);
            return;
        }
        this.path.reset();
        android.graphics.RectF rectF = this.rect;
        float f = this.realRadius;
        rectF.set(0.0f, 0.0f, f * 2.0f, f * 2.0f);
        android.graphics.RectF rectF2 = this.rect;
        float f2 = this.touchX;
        float f3 = this.realRadius;
        rectF2.offsetTo(f2 - f3, this.touchY - f3);
        this.path.addOval(this.rect, android.graphics.Path.Direction.CCW);
        canvas.save();
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public void start(int i, int i2) {
        getLocationOnScreen(new int[2]);
        this.touchX = i - r1[0];
        this.touchY = i2 - r1[1];
        final int iHypot = (int) java.lang.Math.hypot(getWidth(), getHeight());
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(800L);
        valueAnimatorOfFloat.setInterpolator(new android.view.animation.DecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.mobile.common.views.CircularRevealLayout$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f$0.lambda$start$0(iHypot, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.up366.mobile.common.views.CircularRevealLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                super.onAnimationEnd(animator);
                com.up366.mobile.common.views.CircularRevealLayout.this.realRadius = -1.0f;
            }
        });
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$0(int i, android.animation.ValueAnimator valueAnimator) {
        this.realRadius = i * valueAnimator.getAnimatedFraction();
        postInvalidate();
    }
}
