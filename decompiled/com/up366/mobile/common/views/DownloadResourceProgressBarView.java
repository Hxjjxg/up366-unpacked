package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DownloadResourceProgressBarView extends android.view.View {
    private final androidx.dynamicanimation.animation.SpringAnimation animation;
    private int barBgColor;
    private android.graphics.Paint barBgPaint;
    private int barErrBgColor;
    private int barErrFgColor;
    private int barFgColor;
    private android.graphics.Paint barPaint;
    private int barRadius;
    private int currentPercent;
    private final androidx.dynamicanimation.animation.FloatValueHolder holder;
    private boolean isError;
    private int max;
    private com.up366.mobile.common.views.DownloadResourceProgressBarView.IOnAnimProgressUpdateListener onAnimPercentUpdateListener;
    private android.graphics.Path path;
    private android.graphics.RectF rect;
    private int textColor;
    private int textErrColor;

    public interface IOnAnimProgressUpdateListener {
        void onUpdate(int i);
    }

    public DownloadResourceProgressBarView(android.content.Context context) {
        this(context, null);
    }

    public DownloadResourceProgressBarView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadResourceProgressBarView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isError = false;
        this.textColor = getResources().getColor(com.up366.mobile.R.color.c1);
        this.textErrColor = getResources().getColor(com.up366.mobile.R.color.c3);
        this.barBgColor = -1249025;
        this.barFgColor = getResources().getColor(com.up366.mobile.R.color.c1);
        this.barErrBgColor = -3342;
        this.barErrFgColor = getResources().getColor(com.up366.mobile.R.color.c3);
        this.barRadius = 999;
        this.rect = new android.graphics.RectF();
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.barPaint = paint;
        paint.setStyle(android.graphics.Paint.Style.FILL);
        this.barBgPaint = new android.graphics.Paint(this.barPaint);
        this.path = new android.graphics.Path();
        this.currentPercent = 0;
        this.max = 100;
        androidx.dynamicanimation.animation.FloatValueHolder floatValueHolder = new androidx.dynamicanimation.animation.FloatValueHolder();
        this.holder = floatValueHolder;
        androidx.dynamicanimation.animation.SpringAnimation springAnimation = new androidx.dynamicanimation.animation.SpringAnimation(floatValueHolder);
        this.animation = springAnimation;
        springAnimation.addUpdateListener(new androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener() { // from class: com.up366.mobile.common.views.DownloadResourceProgressBarView$$ExternalSyntheticLambda0
            public final void onAnimationUpdate(androidx.dynamicanimation.animation.DynamicAnimation dynamicAnimation, float f, float f2) {
                this.f$0.lambda$new$0(dynamicAnimation, f, f2);
            }
        });
        androidx.dynamicanimation.animation.SpringForce springForce = new androidx.dynamicanimation.animation.SpringForce();
        springForce.setStiffness(3.0f);
        springForce.setDampingRatio(1.0f);
        springAnimation.setSpring(springForce);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(androidx.dynamicanimation.animation.DynamicAnimation dynamicAnimation, float f, float f2) {
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.isError) {
            this.barPaint.setColor(this.barErrFgColor);
            this.barBgPaint.setColor(this.barErrBgColor);
        } else {
            this.barPaint.setColor(this.barFgColor);
            this.barBgPaint.setColor(this.barBgColor);
        }
        float f = width;
        this.rect.set(0.0f, 0.0f, f, height);
        android.graphics.RectF rectF = this.rect;
        int i = this.barRadius;
        canvas.drawRoundRect(rectF, i, i, this.barBgPaint);
        this.path.reset();
        android.graphics.Path path = this.path;
        android.graphics.RectF rectF2 = this.rect;
        int i2 = this.barRadius;
        path.addRoundRect(rectF2, i2, i2, android.graphics.Path.Direction.CCW);
        int iSave = canvas.save();
        canvas.clipPath(this.path);
        this.rect.right = java.lang.Math.min(f, this.holder.getValue());
        this.rect.left = -height;
        int i3 = (int) ((this.rect.right * 100.0f) / f);
        if (this.currentPercent != i3) {
            this.currentPercent = i3;
            com.up366.mobile.common.views.DownloadResourceProgressBarView.IOnAnimProgressUpdateListener iOnAnimProgressUpdateListener = this.onAnimPercentUpdateListener;
            if (iOnAnimProgressUpdateListener != null) {
                iOnAnimProgressUpdateListener.onUpdate(i3);
            }
        }
        android.graphics.RectF rectF3 = this.rect;
        int i4 = this.barRadius;
        canvas.drawRoundRect(rectF3, i4, i4, this.barPaint);
        canvas.restoreToCount(iSave);
    }

    public void setProgress(int i) {
        this.animation.animateToFinalPosition(((getWidth() * 1.0f) * i) / this.max);
    }

    public int getCurrentColor() {
        if (this.isError) {
            return this.textErrColor;
        }
        return this.textColor;
    }

    public void setError(boolean z) {
        this.isError = z;
        postInvalidate();
    }

    public void setOnAnimPercentUpdateListener(com.up366.mobile.common.views.DownloadResourceProgressBarView.IOnAnimProgressUpdateListener iOnAnimProgressUpdateListener) {
        this.onAnimPercentUpdateListener = iOnAnimProgressUpdateListener;
    }
}
