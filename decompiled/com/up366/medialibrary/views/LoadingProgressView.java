package com.up366.medialibrary.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LoadingProgressView extends android.view.View {
    private com.up366.medialibrary.views.LoadingProgressView.CircleBarAnim anim;
    private float barWidth;
    private int bgColor;
    private android.graphics.Paint bgPaint;
    private int defaultSize;
    private android.graphics.RectF mRectF;
    private float maxNum;
    private com.up366.medialibrary.views.LoadingProgressView.OnAnimationListener onAnimationListener;
    private int progressColor;
    private float progressNum;
    private android.graphics.Paint progressPaint;
    private float progressSweepAngle;
    private float startAngle;
    private float sweepAngle;
    private android.widget.TextView textView;

    public interface OnAnimationListener {
        void howTiChangeProgressColor(android.graphics.Paint paint, float f, float f2, float f3);

        java.lang.String howToChangeText(float f, float f2, float f3);
    }

    public LoadingProgressView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onAnimationListener = new com.up366.medialibrary.views.LoadingProgressView.OnAnimationListener() { // from class: com.up366.medialibrary.views.LoadingProgressView.1
            @Override // com.up366.medialibrary.views.LoadingProgressView.OnAnimationListener
            public void howTiChangeProgressColor(android.graphics.Paint paint, float f, float f2, float f3) {
            }

            @Override // com.up366.medialibrary.views.LoadingProgressView.OnAnimationListener
            public java.lang.String howToChangeText(float f, float f2, float f3) {
                return ((int) ((f2 * 100.0f) / f3)) + "%";
            }
        };
        init(context, attributeSet);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.medialibrary.R.styleable.media_CircleBarView);
        this.progressColor = typedArrayObtainStyledAttributes.getColor(com.up366.medialibrary.R.styleable.media_CircleBarView_media_progress_color, -10844161);
        this.bgColor = typedArrayObtainStyledAttributes.getColor(com.up366.medialibrary.R.styleable.media_CircleBarView_media_bg_color, com.up366.qmui.widget.QMUIProgressBar.DEFAULT_BACKGROUND_COLOR);
        this.startAngle = typedArrayObtainStyledAttributes.getFloat(com.up366.medialibrary.R.styleable.media_CircleBarView_media_start_angle, 0.0f);
        this.sweepAngle = typedArrayObtainStyledAttributes.getFloat(com.up366.medialibrary.R.styleable.media_CircleBarView_media_sweep_angle, 360.0f);
        this.barWidth = typedArrayObtainStyledAttributes.getDimension(com.up366.medialibrary.R.styleable.media_CircleBarView_media_bar_width, com.up366.common.DpUtilsUp.dp2px(5.0f));
        typedArrayObtainStyledAttributes.recycle();
        this.progressNum = 0.0f;
        this.maxNum = 100.0f;
        this.defaultSize = com.up366.common.DpUtilsUp.dp2px(100.0f);
        this.mRectF = new android.graphics.RectF();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.progressPaint = paint;
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        this.progressPaint.setColor(this.progressColor);
        this.progressPaint.setAntiAlias(true);
        this.progressPaint.setStrokeWidth(this.barWidth);
        this.progressPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.bgPaint = paint2;
        paint2.setStyle(android.graphics.Paint.Style.STROKE);
        this.bgPaint.setColor(this.bgColor);
        this.bgPaint.setAntiAlias(true);
        this.bgPaint.setStrokeWidth(this.barWidth);
        this.bgPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.anim = new com.up366.medialibrary.views.LoadingProgressView.CircleBarAnim();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iMin = java.lang.Math.min(measureSize(this.defaultSize, i), measureSize(this.defaultSize, i2));
        setMeasuredDimension(iMin, iMin);
        float f = iMin;
        float f2 = this.barWidth;
        if (f >= f2 * 2.0f) {
            this.mRectF.set(f2 / 2.0f, f2 / 2.0f, f - (f2 / 2.0f), f - (f2 / 2.0f));
        }
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.mRectF, this.startAngle, this.sweepAngle, false, this.bgPaint);
        canvas.drawArc(this.mRectF, this.startAngle, this.progressSweepAngle, false, this.progressPaint);
    }

    public class CircleBarAnim extends android.view.animation.Animation {
        public CircleBarAnim() {
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, android.view.animation.Transformation transformation) {
            super.applyTransformation(f, transformation);
            com.up366.medialibrary.views.LoadingProgressView loadingProgressView = com.up366.medialibrary.views.LoadingProgressView.this;
            loadingProgressView.progressSweepAngle = ((loadingProgressView.sweepAngle * f) * com.up366.medialibrary.views.LoadingProgressView.this.progressNum) / com.up366.medialibrary.views.LoadingProgressView.this.maxNum;
            if (com.up366.medialibrary.views.LoadingProgressView.this.onAnimationListener != null) {
                if (com.up366.medialibrary.views.LoadingProgressView.this.textView != null) {
                    com.up366.medialibrary.views.LoadingProgressView.this.textView.setText(com.up366.medialibrary.views.LoadingProgressView.this.onAnimationListener.howToChangeText(f, com.up366.medialibrary.views.LoadingProgressView.this.progressNum, com.up366.medialibrary.views.LoadingProgressView.this.maxNum));
                }
                com.up366.medialibrary.views.LoadingProgressView.this.onAnimationListener.howTiChangeProgressColor(com.up366.medialibrary.views.LoadingProgressView.this.progressPaint, f, com.up366.medialibrary.views.LoadingProgressView.this.progressNum, com.up366.medialibrary.views.LoadingProgressView.this.maxNum);
            }
            com.up366.medialibrary.views.LoadingProgressView.this.postInvalidate();
        }
    }

    private int measureSize(int i, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i2);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? java.lang.Math.min(i, size) : i;
    }

    public void setMaxNum(float f) {
        this.maxNum = f;
    }

    public void setProgressNum(float f, int i) {
        this.progressNum = f;
        this.anim.setDuration(i);
        startAnimation(this.anim);
    }

    public void setTextView(android.widget.TextView textView) {
        this.textView = textView;
    }

    public void setOnAnimationListener(com.up366.medialibrary.views.LoadingProgressView.OnAnimationListener onAnimationListener) {
        this.onAnimationListener = onAnimationListener;
    }
}
