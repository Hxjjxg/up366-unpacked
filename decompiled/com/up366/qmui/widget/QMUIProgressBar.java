package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIProgressBar extends android.view.View {
    public static final int DEFAULT_BACKGROUND_COLOR = -7829368;
    public static final int DEFAULT_PROGRESS_COLOR = -16776961;
    public static int DEFAULT_STROKE_WIDTH = com.up366.qmui.util.QMUIDisplayHelper.dpToPx(40);
    public static final int DEFAULT_TEXT_COLOR = -16777216;
    public static final int DEFAULT_TEXT_SIZE = 20;
    private static final int PENDING_VALUE_NOT_SET = -1;
    public static final int TOTAL_DURATION = 1000;
    public static final int TYPE_CIRCLE = 1;
    public static final int TYPE_RECT = 0;
    public static final int TYPE_ROUND_RECT = 2;
    private int mAnimationDistance;
    private int mAnimationDuration;
    private long mAnimationStartTime;
    private android.graphics.RectF mArcOval;
    private int mBackgroundColor;
    private android.graphics.Paint mBackgroundPaint;
    android.graphics.RectF mBgRect;
    private android.graphics.Point mCenterPoint;
    private int mCircleRadius;
    private int mHeight;
    private int mMaxValue;
    private java.lang.Runnable mNotifyProgressChangeAction;
    private com.up366.qmui.widget.QMUIProgressBar.OnProgressChangeListener mOnProgressChangeListener;
    private android.graphics.Paint mPaint;
    private int mPendingValue;
    private int mProgressColor;
    android.graphics.RectF mProgressRect;
    com.up366.qmui.widget.QMUIProgressBar.QMUIProgressBarTextGenerator mQMUIProgressBarTextGenerator;
    private boolean mRoundCap;
    private int mStrokeWidth;
    private java.lang.String mText;
    private int mTextColor;
    private android.graphics.Paint mTextPaint;
    private int mTextSize;
    private int mType;
    private int mValue;
    private int mWidth;

    public interface OnProgressChangeListener {
        void onProgressChange(com.up366.qmui.widget.QMUIProgressBar qMUIProgressBar, int i, int i2);
    }

    public interface QMUIProgressBarTextGenerator {
        java.lang.String generateText(com.up366.qmui.widget.QMUIProgressBar qMUIProgressBar, int i, int i2);
    }

    public QMUIProgressBar(android.content.Context context) {
        super(context);
        this.mBackgroundPaint = new android.graphics.Paint();
        this.mPaint = new android.graphics.Paint();
        this.mTextPaint = new android.graphics.Paint(1);
        this.mArcOval = new android.graphics.RectF();
        this.mText = "";
        this.mNotifyProgressChangeAction = new java.lang.Runnable() { // from class: com.up366.qmui.widget.QMUIProgressBar.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.up366.qmui.widget.QMUIProgressBar.this.mOnProgressChangeListener != null) {
                    com.up366.qmui.widget.QMUIProgressBar.OnProgressChangeListener onProgressChangeListener = com.up366.qmui.widget.QMUIProgressBar.this.mOnProgressChangeListener;
                    com.up366.qmui.widget.QMUIProgressBar qMUIProgressBar = com.up366.qmui.widget.QMUIProgressBar.this;
                    onProgressChangeListener.onProgressChange(qMUIProgressBar, qMUIProgressBar.mValue, com.up366.qmui.widget.QMUIProgressBar.this.mMaxValue);
                }
            }
        };
        setup(context, null);
    }

    public QMUIProgressBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBackgroundPaint = new android.graphics.Paint();
        this.mPaint = new android.graphics.Paint();
        this.mTextPaint = new android.graphics.Paint(1);
        this.mArcOval = new android.graphics.RectF();
        this.mText = "";
        this.mNotifyProgressChangeAction = new java.lang.Runnable() { // from class: com.up366.qmui.widget.QMUIProgressBar.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.up366.qmui.widget.QMUIProgressBar.this.mOnProgressChangeListener != null) {
                    com.up366.qmui.widget.QMUIProgressBar.OnProgressChangeListener onProgressChangeListener = com.up366.qmui.widget.QMUIProgressBar.this.mOnProgressChangeListener;
                    com.up366.qmui.widget.QMUIProgressBar qMUIProgressBar = com.up366.qmui.widget.QMUIProgressBar.this;
                    onProgressChangeListener.onProgressChange(qMUIProgressBar, qMUIProgressBar.mValue, com.up366.qmui.widget.QMUIProgressBar.this.mMaxValue);
                }
            }
        };
        setup(context, attributeSet);
    }

    public QMUIProgressBar(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBackgroundPaint = new android.graphics.Paint();
        this.mPaint = new android.graphics.Paint();
        this.mTextPaint = new android.graphics.Paint(1);
        this.mArcOval = new android.graphics.RectF();
        this.mText = "";
        this.mNotifyProgressChangeAction = new java.lang.Runnable() { // from class: com.up366.qmui.widget.QMUIProgressBar.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.up366.qmui.widget.QMUIProgressBar.this.mOnProgressChangeListener != null) {
                    com.up366.qmui.widget.QMUIProgressBar.OnProgressChangeListener onProgressChangeListener = com.up366.qmui.widget.QMUIProgressBar.this.mOnProgressChangeListener;
                    com.up366.qmui.widget.QMUIProgressBar qMUIProgressBar = com.up366.qmui.widget.QMUIProgressBar.this;
                    onProgressChangeListener.onProgressChange(qMUIProgressBar, qMUIProgressBar.mValue, com.up366.qmui.widget.QMUIProgressBar.this.mMaxValue);
                }
            }
        };
        setup(context, attributeSet);
    }

    public void setup(android.content.Context context, android.util.AttributeSet attributeSet) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUIProgressBar);
        this.mType = typedArrayObtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUIProgressBar_qmui_type, 0);
        this.mProgressColor = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUIProgressBar_qmui_progress_color, DEFAULT_PROGRESS_COLOR);
        this.mBackgroundColor = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUIProgressBar_qmui_background_color, DEFAULT_BACKGROUND_COLOR);
        this.mMaxValue = typedArrayObtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUIProgressBar_qmui_max_value, 100);
        this.mValue = typedArrayObtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUIProgressBar_qmui_value, 0);
        this.mRoundCap = typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUIProgressBar_qmui_stroke_round_cap, false);
        this.mTextSize = 20;
        if (typedArrayObtainStyledAttributes.hasValue(com.qmuiteam.qmui.R.styleable.QMUIProgressBar_android_textSize)) {
            this.mTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIProgressBar_android_textSize, 20);
        }
        this.mTextColor = DEFAULT_TEXT_COLOR;
        if (typedArrayObtainStyledAttributes.hasValue(com.qmuiteam.qmui.R.styleable.QMUIProgressBar_android_textColor)) {
            this.mTextColor = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUIProgressBar_android_textColor, DEFAULT_TEXT_COLOR);
        }
        if (this.mType == 1) {
            this.mStrokeWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIProgressBar_qmui_stroke_width, DEFAULT_STROKE_WIDTH);
        }
        typedArrayObtainStyledAttributes.recycle();
        configPaint(this.mTextColor, this.mTextSize, this.mRoundCap);
        setProgress(this.mValue);
    }

    public void setOnProgressChangeListener(com.up366.qmui.widget.QMUIProgressBar.OnProgressChangeListener onProgressChangeListener) {
        this.mOnProgressChangeListener = onProgressChangeListener;
    }

    private void configShape() {
        int i = this.mType;
        if (i == 0 || i == 2) {
            this.mBgRect = new android.graphics.RectF(getPaddingLeft(), getPaddingTop(), this.mWidth + getPaddingLeft(), this.mHeight + getPaddingTop());
            this.mProgressRect = new android.graphics.RectF();
        } else {
            this.mCircleRadius = (java.lang.Math.min(this.mWidth, this.mHeight) - this.mStrokeWidth) / 2;
            this.mCenterPoint = new android.graphics.Point(this.mWidth / 2, this.mHeight / 2);
        }
    }

    private void configPaint(int i, int i2, boolean z) {
        this.mPaint.setColor(this.mProgressColor);
        this.mBackgroundPaint.setColor(this.mBackgroundColor);
        int i3 = this.mType;
        if (i3 == 0 || i3 == 2) {
            this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
            this.mBackgroundPaint.setStyle(android.graphics.Paint.Style.FILL);
        } else {
            this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mStrokeWidth);
            this.mPaint.setAntiAlias(true);
            if (z) {
                this.mPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
            }
            this.mBackgroundPaint.setStyle(android.graphics.Paint.Style.STROKE);
            this.mBackgroundPaint.setStrokeWidth(this.mStrokeWidth);
            this.mBackgroundPaint.setAntiAlias(true);
        }
        this.mTextPaint.setColor(i);
        this.mTextPaint.setTextSize(i2);
        this.mTextPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
    }

    public void setType(int i) {
        this.mType = i;
        configPaint(this.mTextColor, this.mTextSize, this.mRoundCap);
        invalidate();
    }

    public void setBarColor(int i, int i2) {
        this.mBackgroundColor = i;
        this.mProgressColor = i2;
        this.mBackgroundPaint.setColor(i);
        this.mPaint.setColor(this.mProgressColor);
        invalidate();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        this.mBackgroundPaint.setColor(i);
        invalidate();
    }

    public void setProgressColor(int i) {
        this.mProgressColor = i;
        this.mPaint.setColor(i);
        invalidate();
    }

    public void setTextSize(int i) {
        this.mTextPaint.setTextSize(i);
        invalidate();
    }

    public void setTextColor(int i) {
        this.mTextPaint.setColor(i);
        invalidate();
    }

    public void setStrokeRoundCap(boolean z) {
        this.mPaint.setStrokeCap(z ? android.graphics.Paint.Cap.ROUND : android.graphics.Paint.Cap.BUTT);
        invalidate();
    }

    public void setQMUIProgressBarTextGenerator(com.up366.qmui.widget.QMUIProgressBar.QMUIProgressBarTextGenerator qMUIProgressBarTextGenerator) {
        this.mQMUIProgressBarTextGenerator = qMUIProgressBarTextGenerator;
    }

    public com.up366.qmui.widget.QMUIProgressBar.QMUIProgressBarTextGenerator getQMUIProgressBarTextGenerator() {
        return this.mQMUIProgressBarTextGenerator;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.mPendingValue != -1) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - this.mAnimationStartTime;
            int i = this.mAnimationDuration;
            if (jCurrentTimeMillis >= i) {
                this.mValue = this.mPendingValue;
                post(this.mNotifyProgressChangeAction);
                this.mPendingValue = -1;
            } else {
                this.mValue = (int) (this.mPendingValue - ((1.0f - (jCurrentTimeMillis / i)) * this.mAnimationDistance));
                post(this.mNotifyProgressChangeAction);
                androidx.core.view.ViewCompat.postInvalidateOnAnimation(this);
            }
        }
        com.up366.qmui.widget.QMUIProgressBar.QMUIProgressBarTextGenerator qMUIProgressBarTextGenerator = this.mQMUIProgressBarTextGenerator;
        if (qMUIProgressBarTextGenerator != null) {
            this.mText = qMUIProgressBarTextGenerator.generateText(this, this.mValue, this.mMaxValue);
        }
        int i2 = this.mType;
        if (((i2 == 0 || i2 == 2) && this.mBgRect == null) || (i2 == 1 && this.mCenterPoint == null)) {
            configShape();
        }
        int i3 = this.mType;
        if (i3 == 0) {
            drawRect(canvas);
        } else if (i3 == 2) {
            drawRoundRect(canvas);
        } else {
            drawCircle(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.mHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        configShape();
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    private void drawRect(android.graphics.Canvas canvas) {
        canvas.drawRect(this.mBgRect, this.mBackgroundPaint);
        this.mProgressRect.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + parseValueToWidth(), getPaddingTop() + this.mHeight);
        canvas.drawRect(this.mProgressRect, this.mPaint);
        java.lang.String str = this.mText;
        if (str == null || str.length() <= 0) {
            return;
        }
        android.graphics.Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        canvas.drawText(this.mText, this.mBgRect.centerX(), (this.mBgRect.top + (((this.mBgRect.height() - fontMetricsInt.bottom) + fontMetricsInt.top) / 2.0f)) - fontMetricsInt.top, this.mTextPaint);
    }

    private void drawRoundRect(android.graphics.Canvas canvas) {
        float f = this.mHeight / 2.0f;
        canvas.drawRoundRect(this.mBgRect, f, f, this.mBackgroundPaint);
        this.mProgressRect.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + parseValueToWidth(), getPaddingTop() + this.mHeight);
        canvas.drawRoundRect(this.mProgressRect, f, f, this.mPaint);
        java.lang.String str = this.mText;
        if (str == null || str.length() <= 0) {
            return;
        }
        android.graphics.Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        canvas.drawText(this.mText, this.mBgRect.centerX(), (this.mBgRect.top + (((this.mBgRect.height() - fontMetricsInt.bottom) + fontMetricsInt.top) / 2.0f)) - fontMetricsInt.top, this.mTextPaint);
    }

    private void drawCircle(android.graphics.Canvas canvas) {
        canvas.drawCircle(this.mCenterPoint.x, this.mCenterPoint.y, this.mCircleRadius, this.mBackgroundPaint);
        this.mArcOval.left = this.mCenterPoint.x - this.mCircleRadius;
        this.mArcOval.right = this.mCenterPoint.x + this.mCircleRadius;
        this.mArcOval.top = this.mCenterPoint.y - this.mCircleRadius;
        this.mArcOval.bottom = this.mCenterPoint.y + this.mCircleRadius;
        int i = this.mValue;
        if (i > 0) {
            canvas.drawArc(this.mArcOval, 270.0f, (i * 360.0f) / this.mMaxValue, false, this.mPaint);
        }
        java.lang.String str = this.mText;
        if (str == null || str.length() <= 0) {
            return;
        }
        android.graphics.Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        canvas.drawText(this.mText, this.mCenterPoint.x, (this.mArcOval.top + (((this.mArcOval.height() - fontMetricsInt.bottom) + fontMetricsInt.top) / 2.0f)) - fontMetricsInt.top, this.mTextPaint);
    }

    private int parseValueToWidth() {
        return (this.mWidth * this.mValue) / this.mMaxValue;
    }

    public int getProgress() {
        return this.mValue;
    }

    public void setProgress(int i) {
        setProgress(i, true);
    }

    public void setProgress(int i, boolean z) {
        int i2 = this.mMaxValue;
        if (i > i2 || i < 0) {
            return;
        }
        int i3 = this.mPendingValue;
        if (i3 == -1 && this.mValue == i) {
            return;
        }
        if (i3 == -1 || i3 != i) {
            if (!z) {
                this.mPendingValue = -1;
                this.mValue = i;
                this.mNotifyProgressChangeAction.run();
                invalidate();
                return;
            }
            this.mAnimationDuration = java.lang.Math.abs((int) (((this.mValue - i) * 1000) / i2));
            this.mAnimationStartTime = java.lang.System.currentTimeMillis();
            this.mAnimationDistance = i - this.mValue;
            this.mPendingValue = i;
            invalidate();
        }
    }

    public int getMaxValue() {
        return this.mMaxValue;
    }

    public void setMaxValue(int i) {
        this.mMaxValue = i;
    }
}
