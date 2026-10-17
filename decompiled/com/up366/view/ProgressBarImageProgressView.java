package com.up366.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ProgressBarImageProgressView extends android.view.View {
    private android.graphics.RectF backgroundRect;
    private android.graphics.Paint bgPaint;
    private int corner;
    private final float dp;
    private android.graphics.Paint dynamicEffectPaint;
    private float dynamicEffectProgress;
    private boolean fullShowImage;
    private float imageDisparity;
    private android.graphics.Rect imageRect;
    private java.lang.String leftText;
    private int mBackgroundColor;
    private int mHeight;
    private int mMaxValue;
    private int mProgressColor;
    private int mTextColor;
    private int mTextSize;
    private int mValue;
    private int mWidth;
    private android.graphics.Path path;
    private int progressAnimColor;
    private float[] progressAnimCorners;
    private android.graphics.RectF progressAnimRect;
    private android.graphics.drawable.Drawable progressImage;
    private android.graphics.Paint progressPaint;
    private android.graphics.RectF progressRect;
    private android.graphics.LinearGradient shaderLeft;
    private android.graphics.LinearGradient shaderRight;
    private boolean showProgressAnim;
    private boolean showText;
    private android.graphics.Paint textPaint;
    private android.animation.ValueAnimator valueAnimator;

    public ProgressBarImageProgressView(android.content.Context context) {
        this(context, null);
    }

    public ProgressBarImageProgressView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressBarImageProgressView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.backgroundRect = new android.graphics.RectF();
        this.progressRect = new android.graphics.RectF();
        this.imageRect = new android.graphics.Rect();
        this.showText = true;
        this.fullShowImage = false;
        this.showProgressAnim = false;
        this.dynamicEffectProgress = 0.0f;
        this.progressAnimColor = 0;
        this.dp = getResources().getDisplayMetrics().density;
        initAttrs(context, attributeSet);
    }

    private void initAttrs(android.content.Context context, android.util.AttributeSet attributeSet) {
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.view.R.styleable.ProgressBarImageProgressView);
            this.progressImage = typedArrayObtainStyledAttributes.getDrawable(com.up366.view.R.styleable.ProgressBarImageProgressView_process_image);
            this.mBackgroundColor = typedArrayObtainStyledAttributes.getColor(com.up366.view.R.styleable.ProgressBarImageProgressView_background_color, com.up366.qmui.widget.QMUIProgressBar.DEFAULT_TEXT_COLOR);
            this.mProgressColor = typedArrayObtainStyledAttributes.getColor(com.up366.view.R.styleable.ProgressBarImageProgressView_progress_color, -1);
            this.leftText = typedArrayObtainStyledAttributes.getString(com.up366.view.R.styleable.ProgressBarImageProgressView_left_text);
            this.mTextColor = typedArrayObtainStyledAttributes.getColor(com.up366.view.R.styleable.ProgressBarImageProgressView_text_color, com.up366.qmui.widget.QMUIProgressBar.DEFAULT_PROGRESS_COLOR);
            this.mTextSize = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.up366.view.R.styleable.ProgressBarImageProgressView_text_size, 36);
            this.mMaxValue = typedArrayObtainStyledAttributes.getInt(com.up366.view.R.styleable.ProgressBarImageProgressView_max, 100);
            this.mValue = typedArrayObtainStyledAttributes.getInt(com.up366.view.R.styleable.ProgressBarImageProgressView_progress, 50);
            this.corner = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.up366.view.R.styleable.ProgressBarImageProgressView_corner, 0);
            this.showProgressAnim = typedArrayObtainStyledAttributes.getBoolean(com.up366.view.R.styleable.ProgressBarImageProgressView_show_progress_anim, false);
            this.progressAnimColor = typedArrayObtainStyledAttributes.getColor(com.up366.view.R.styleable.ProgressBarImageProgressView_progress_anim_color, 0);
        }
        this.imageDisparity = (float) (((double) (getContext().getResources().getDisplayMetrics().density * 5.0f)) + 0.5d);
        android.graphics.Paint paint = new android.graphics.Paint();
        this.bgPaint = paint;
        paint.setColor(this.mBackgroundColor);
        this.bgPaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        this.bgPaint.setAntiAlias(true);
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.progressPaint = paint2;
        paint2.setColor(this.mProgressColor);
        this.progressPaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        this.progressPaint.setAntiAlias(true);
        android.graphics.Paint paint3 = new android.graphics.Paint();
        this.textPaint = paint3;
        paint3.setColor(this.mTextColor);
        this.textPaint.setTextSize(this.mTextSize);
        this.textPaint.setAntiAlias(true);
        this.path = new android.graphics.Path();
        android.graphics.Paint paint4 = new android.graphics.Paint(1);
        this.dynamicEffectPaint = paint4;
        paint4.setStyle(android.graphics.Paint.Style.FILL);
        this.dynamicEffectPaint.setColor(this.progressAnimColor);
        this.progressAnimRect = new android.graphics.RectF(0.0f, 0.0f, 0.0f, 0.0f);
        int iMin = (java.lang.Math.min(255, java.lang.Math.max(0, 0)) << 24) + (16777215 & this.progressAnimColor);
        this.shaderLeft = new android.graphics.LinearGradient(0.0f, 0.0f, this.dp * 40.0f, 0.0f, iMin, this.progressAnimColor, android.graphics.Shader.TileMode.CLAMP);
        float f = this.dp;
        this.shaderRight = new android.graphics.LinearGradient(f * 40.0f, 0.0f, f * 55.0f, 0.0f, this.progressAnimColor, iMin, android.graphics.Shader.TileMode.CLAMP);
        int i = this.corner;
        this.progressAnimCorners = new float[]{i, i, i, i, i, i, i, i};
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.mHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.valueAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new android.view.animation.AccelerateInterpolator());
        this.valueAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.view.ProgressBarImageProgressView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f$0.m1390xd15cf141(valueAnimator);
            }
        });
        this.valueAnimator.setDuration(1200L);
        this.valueAnimator.setRepeatMode(1);
        this.valueAnimator.setRepeatCount(-1);
        this.valueAnimator.start();
    }

    /* JADX INFO: renamed from: lambda$onAttachedToWindow$0$com-up366-view-ProgressBarImageProgressView, reason: not valid java name */
    /* synthetic */ void m1390xd15cf141(android.animation.ValueAnimator valueAnimator) {
        this.dynamicEffectProgress = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        android.animation.ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.valueAnimator = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        float paddingLeft = getPaddingLeft();
        float paddingTop = getPaddingTop();
        float f = this.imageDisparity;
        float f2 = paddingTop + f;
        float f3 = (this.mHeight - (f * 2.0f)) + f2;
        this.backgroundRect.left = paddingLeft;
        this.backgroundRect.top = f2;
        this.backgroundRect.right = this.mWidth + paddingLeft;
        this.backgroundRect.bottom = f3;
        android.graphics.RectF rectF = this.backgroundRect;
        int i = this.corner;
        canvas.drawRoundRect(rectF, i, i, this.bgPaint);
        float f4 = ((this.mWidth * this.mValue) / this.mMaxValue) + paddingLeft;
        this.progressRect.set(this.backgroundRect);
        this.progressRect.right = f4;
        android.graphics.RectF rectF2 = this.progressRect;
        int i2 = this.corner;
        canvas.drawRoundRect(rectF2, i2, i2, this.progressPaint);
        int i3 = (this.mValue * 100) / this.mMaxValue;
        if (this.showText) {
            android.graphics.Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            canvas.drawText(i3 + "%", this.backgroundRect.left + this.corner, (this.backgroundRect.bottom - ((this.backgroundRect.height() - (fontMetrics.descent - fontMetrics.ascent)) / 2.0f)) - fontMetrics.descent, this.textPaint);
        }
        if (this.fullShowImage || i3 != 100) {
            if (this.showProgressAnim && i3 != 100) {
                this.progressAnimRect.set(paddingLeft, f2, f4 - (this.imageRect.width() / 2), f3);
                int i4 = (int) (this.progressAnimRect.right + (this.dp * 100.0f));
                canvas.save();
                this.path.reset();
                this.path.addRoundRect(this.progressRect, this.progressAnimCorners, android.graphics.Path.Direction.CCW);
                canvas.clipPath(this.path);
                this.progressAnimRect.right = this.dp * 40.0f;
                canvas.translate((int) ((this.dynamicEffectProgress * i4) - (this.dp * 60.0f)), 0.0f);
                this.dynamicEffectPaint.setShader(this.shaderLeft);
                canvas.drawRect(this.progressAnimRect, this.dynamicEffectPaint);
                this.progressAnimRect.left = this.dp * 40.0f;
                this.progressAnimRect.right = this.dp * 55.0f;
                this.dynamicEffectPaint.setShader(this.shaderRight);
                canvas.drawRect(this.progressAnimRect, this.dynamicEffectPaint);
                canvas.restore();
            }
            this.imageRect.top = getPaddingTop();
            this.imageRect.bottom = getPaddingTop() + this.mHeight;
            float f5 = (this.mHeight * 36.0f) / 26.0f;
            this.imageRect.left = (int) (f4 - (f5 / 2.0f));
            this.imageRect.right = (int) (r1.left + f5);
            if (this.imageRect.right >= this.backgroundRect.right) {
                this.imageRect.left = (int) ((this.backgroundRect.right - f5) + 10.0f);
            }
            if (this.imageRect.left <= 0) {
                this.imageRect.left = ((int) this.backgroundRect.left) - 10;
            }
            this.imageRect.right = (int) (r1.left + f5);
            this.progressImage.setBounds(this.imageRect);
            this.progressImage.draw(canvas);
        }
    }

    public int getmProgressColor() {
        return this.mProgressColor;
    }

    public void setmProgressColor(int i) {
        this.mProgressColor = i;
        postInvalidate();
    }

    public int getmBackgroundColor() {
        return this.mBackgroundColor;
    }

    public void setmBackgroundColor(int i) {
        this.mBackgroundColor = i;
        postInvalidate();
    }

    public int getmMaxValue() {
        return this.mMaxValue;
    }

    public void setmMaxValue(int i) {
        this.mMaxValue = i;
        postInvalidate();
    }

    public int getmValue() {
        return this.mValue;
    }

    public void setmValue(int i) {
        this.mValue = i;
        postInvalidate();
    }

    public java.lang.String getLeftText() {
        return this.leftText;
    }

    public void setLeftText(java.lang.String str) {
        this.leftText = str;
        postInvalidate();
    }

    public int getmTextSize() {
        return this.mTextSize;
    }

    public void setmTextSize(int i) {
        this.mTextSize = i;
        this.textPaint.setTextSize(i);
        postInvalidate();
    }

    public int getmTextColor() {
        return this.mTextColor;
    }

    public void setmTextColor(int i) {
        this.mTextColor = i;
        this.textPaint.setColor(i);
        postInvalidate();
    }

    public android.graphics.drawable.Drawable getProgressImage() {
        return this.progressImage;
    }

    public void setProgressImage(android.graphics.drawable.Drawable drawable) {
        this.progressImage = drawable;
        postInvalidate();
    }

    public void setProcessImage(int i) {
        this.progressImage = getContext().getDrawable(i);
        postInvalidate();
    }

    public int getCorner() {
        return this.corner;
    }

    public void setCorner(int i) {
        this.corner = i;
        float f = i;
        this.progressAnimCorners = new float[]{f, f, f, f, f, f, f, f};
        postInvalidate();
    }

    public void setShowText(boolean z) {
        this.showText = z;
        postInvalidate();
    }

    public boolean isFullShowImage() {
        return this.fullShowImage;
    }

    public void setFullShowImage(boolean z) {
        this.fullShowImage = z;
        postInvalidate();
    }

    public boolean isShowProgressAnim() {
        return this.showProgressAnim;
    }

    public void setShowProgressAnim(boolean z) {
        this.showProgressAnim = z;
        postInvalidate();
    }
}
