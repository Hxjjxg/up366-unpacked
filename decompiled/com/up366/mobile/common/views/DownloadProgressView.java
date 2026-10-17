package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DownloadProgressView extends androidx.appcompat.widget.AppCompatTextView {
    public static final int STATE_DOWNLOAD = 1;
    public static final int STATE_DOWNLOAD_ERROR = 3;
    public static final int STATE_LOADING = 0;
    public static final int STATE_LOADING_ERROR = 2;
    private static final java.lang.String TAG = "DownloadProgressView";
    private final androidx.dynamicanimation.animation.SpringAnimation animation;
    private int colorBgError;
    private int colorBgNormal;
    private int colorFgError;
    private int colorFgNormal;
    private int colorLoading;
    private int currentPercent;
    private final androidx.dynamicanimation.animation.FloatValueHolder holder;
    private float loadingOffset;
    private int max;
    private com.up366.mobile.common.views.DownloadProgressView.IOnAnimProgressUpdateListener onAnimPercentUpdateListener;
    private android.graphics.Paint paintBg;
    private android.graphics.Paint paintFg;
    private android.graphics.Paint paintLoading;
    private android.graphics.Path path;
    private android.graphics.Path pathRect;
    private android.graphics.RectF rect;
    private int state;

    public interface IOnAnimProgressUpdateListener {
        void onUpdate(int i);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @interface State {
    }

    public DownloadProgressView(android.content.Context context) {
        this(context, null);
    }

    public DownloadProgressView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.colorBgNormal = -1249025;
        this.colorBgError = -3342;
        this.colorFgNormal = -10715905;
        this.colorFgError = -43434;
        this.colorLoading = 872415231;
        this.state = 0;
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.paintBg = paint;
        paint.setAntiAlias(true);
        this.paintBg.setColor(this.colorBgNormal);
        android.graphics.Paint paint2 = new android.graphics.Paint(1);
        this.paintFg = paint2;
        paint2.setAntiAlias(true);
        this.paintFg.setColor(this.colorFgNormal);
        android.graphics.Paint paint3 = new android.graphics.Paint(1);
        this.paintLoading = paint3;
        paint3.setColor(this.colorLoading);
        this.paintLoading.setStyle(android.graphics.Paint.Style.FILL);
        this.rect = new android.graphics.RectF();
        this.path = new android.graphics.Path();
        this.pathRect = new android.graphics.Path();
        this.max = 100;
        androidx.dynamicanimation.animation.FloatValueHolder floatValueHolder = new androidx.dynamicanimation.animation.FloatValueHolder();
        this.holder = floatValueHolder;
        androidx.dynamicanimation.animation.SpringAnimation springAnimation = new androidx.dynamicanimation.animation.SpringAnimation(floatValueHolder);
        this.animation = springAnimation;
        springAnimation.addUpdateListener(new androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener() { // from class: com.up366.mobile.common.views.DownloadProgressView$$ExternalSyntheticLambda0
            public final void onAnimationUpdate(androidx.dynamicanimation.animation.DynamicAnimation dynamicAnimation, float f, float f2) {
                this.f$0.lambda$new$0(dynamicAnimation, f, f2);
            }
        });
        androidx.dynamicanimation.animation.SpringForce springForce = new androidx.dynamicanimation.animation.SpringForce();
        springForce.setStiffness(30.0f);
        springForce.setDampingRatio(1.0f);
        springAnimation.setSpring(springForce);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(androidx.dynamicanimation.animation.DynamicAnimation dynamicAnimation, float f, float f2) {
        postInvalidate();
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        float f = height;
        float f2 = f / 2.0f;
        float f3 = width;
        this.rect.set(0.0f, 0.0f, f3, f);
        this.path.reset();
        this.path.addRoundRect(this.rect, f2, f2, android.graphics.Path.Direction.CCW);
        canvas.save();
        canvas.clipPath(this.path);
        int i = this.state;
        if (i == 0) {
            this.paintFg.setColor(this.colorFgNormal);
            this.rect.set(0.0f, 0.0f, f3, f);
            canvas.drawRoundRect(this.rect, f2, f2, this.paintFg);
            drawLoading(canvas, width, height, f2);
            postInvalidate();
            updateProgressListener(this.rect.right, width);
        } else if (i == 1) {
            this.paintBg.setColor(this.colorBgNormal);
            this.paintFg.setColor(this.colorFgNormal);
            this.rect.set(0.0f, 0.0f, f3, f);
            canvas.drawRoundRect(this.rect, f2, f2, this.paintBg);
            this.rect.right = java.lang.Math.min(f3, this.holder.getValue());
            this.rect.left = -height;
            canvas.drawRoundRect(this.rect, f2, f2, this.paintFg);
            updateProgressListener(this.rect.right, width);
        } else if (i == 2) {
            this.paintFg.setColor(this.colorFgError);
            this.rect.set(0.0f, 0.0f, f3, f);
            canvas.drawRoundRect(this.rect, f2, f2, this.paintFg);
            drawLoading(canvas, width, height, f2);
            updateProgressListener(this.rect.right, width);
        } else if (i == 3) {
            this.paintBg.setColor(this.colorBgError);
            this.paintFg.setColor(this.colorFgError);
            this.rect.set(0.0f, 0.0f, f3, f);
            canvas.drawRoundRect(this.rect, f2, f2, this.paintBg);
            this.rect.right = java.lang.Math.min(f3, this.holder.getValue());
            this.rect.left = -height;
            canvas.drawRoundRect(this.rect, f2, f2, this.paintFg);
            updateProgressListener(this.rect.right, width);
        } else {
            throw new java.lang.IllegalStateException(java.lang.String.valueOf(this.state));
        }
        canvas.restore();
    }

    private void updateProgressListener(float f, int i) {
        int i2 = this.state;
        if (i2 == 1 || i2 == 3) {
            int i3 = (int) ((f * 100.0f) / i);
            if (this.currentPercent != i3) {
                this.currentPercent = i3;
                com.up366.mobile.common.views.DownloadProgressView.IOnAnimProgressUpdateListener iOnAnimProgressUpdateListener = this.onAnimPercentUpdateListener;
                if (iOnAnimProgressUpdateListener != null) {
                    iOnAnimProgressUpdateListener.onUpdate(i3);
                    return;
                }
                return;
            }
            return;
        }
        com.up366.mobile.common.views.DownloadProgressView.IOnAnimProgressUpdateListener iOnAnimProgressUpdateListener2 = this.onAnimPercentUpdateListener;
        if (iOnAnimProgressUpdateListener2 != null) {
            iOnAnimProgressUpdateListener2.onUpdate(-1);
        }
    }

    private void drawLoading(android.graphics.Canvas canvas, int i, int i2, float f) {
        float f2 = i2 / 2.0f;
        this.pathRect.reset();
        this.pathRect.moveTo(0.0f, 0.0f);
        this.pathRect.lineTo(f2, 0.0f);
        float f3 = f2 * 2.0f;
        this.pathRect.lineTo(0.0f, f3);
        this.pathRect.lineTo(-f2, f3);
        this.pathRect.lineTo(0.0f, 0.0f);
        this.pathRect.close();
        this.path.reset();
        float f4 = (5.0f * f2) / 3.0f;
        for (float f5 = this.loadingOffset; f5 < i + f2; f5 += f4) {
            this.path.addPath(this.pathRect, f5, 0.0f);
        }
        canvas.drawPath(this.path, this.paintLoading);
        float f6 = this.loadingOffset - 3.0f;
        this.loadingOffset = f6;
        if (f6 < (-f4) / 2.0f) {
            this.loadingOffset = f4 / 2.0f;
        }
    }

    public int getProgress() {
        return this.currentPercent;
    }

    public void setProgress(int i) {
        if (this.currentPercent - i > 50) {
            this.holder.setValue(i);
        }
        this.animation.animateToFinalPosition(((getWidth() * 1.0f) * i) / this.max);
    }

    public void setState(int i) {
        this.state = i;
        postInvalidate();
    }

    public void setOnAnimPercentUpdateListener(com.up366.mobile.common.views.DownloadProgressView.IOnAnimProgressUpdateListener iOnAnimProgressUpdateListener) {
        this.onAnimPercentUpdateListener = iOnAnimProgressUpdateListener;
    }
}
