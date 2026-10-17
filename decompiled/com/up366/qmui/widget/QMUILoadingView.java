package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUILoadingView extends android.view.View implements com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider {
    private static final int DEGREE_PER_LINE = 30;
    private static final int LINE_COUNT = 12;
    private static androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> sDefaultAttrs;
    private int mAnimateValue;
    private android.animation.ValueAnimator mAnimator;
    private android.graphics.Paint mPaint;
    private int mPaintColor;
    private int mSize;
    private android.animation.ValueAnimator.AnimatorUpdateListener mUpdateListener;

    static {
        androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> simpleArrayMap = new androidx.collection.SimpleArrayMap<>();
        sDefaultAttrs = simpleArrayMap;
        simpleArrayMap.put(com.up366.qmui.skin.QMUISkinValueBuilder.TINT_COLOR, java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_loading_color));
    }

    public QMUILoadingView(android.content.Context context) {
        this(context, null);
    }

    public QMUILoadingView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.qmuiteam.qmui.R.attr.QMUILoadingStyle);
    }

    public QMUILoadingView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAnimateValue = 0;
        this.mUpdateListener = new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.qmui.widget.QMUILoadingView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.up366.qmui.widget.QMUILoadingView.this.mAnimateValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                com.up366.qmui.widget.QMUILoadingView.this.invalidate();
            }
        };
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUILoadingView, i, 0);
        this.mSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUILoadingView_qmui_loading_view_size, com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 32));
        this.mPaintColor = typedArrayObtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUILoadingView_android_color, -1);
        typedArrayObtainStyledAttributes.recycle();
        initPaint();
    }

    public QMUILoadingView(android.content.Context context, int i, int i2) {
        super(context);
        this.mAnimateValue = 0;
        this.mUpdateListener = new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.qmui.widget.QMUILoadingView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.up366.qmui.widget.QMUILoadingView.this.mAnimateValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                com.up366.qmui.widget.QMUILoadingView.this.invalidate();
            }
        };
        this.mSize = i;
        this.mPaintColor = i2;
        initPaint();
    }

    private void initPaint() {
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mPaint = paint;
        paint.setColor(this.mPaintColor);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
    }

    public void setColor(int i) {
        this.mPaintColor = i;
        this.mPaint.setColor(i);
        invalidate();
    }

    public void setSize(int i) {
        this.mSize = i;
        requestLayout();
    }

    public void start() {
        android.animation.ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator == null) {
            android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(0, 11);
            this.mAnimator = valueAnimatorOfInt;
            valueAnimatorOfInt.addUpdateListener(this.mUpdateListener);
            this.mAnimator.setDuration(600L);
            this.mAnimator.setRepeatMode(1);
            this.mAnimator.setRepeatCount(-1);
            this.mAnimator.setInterpolator(new android.view.animation.LinearInterpolator());
            this.mAnimator.start();
            return;
        }
        if (valueAnimator.isStarted()) {
            return;
        }
        this.mAnimator.start();
    }

    public void stop() {
        android.animation.ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeUpdateListener(this.mUpdateListener);
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
    }

    private void drawLoading(android.graphics.Canvas canvas, int i) {
        int i2 = this.mSize;
        int i3 = i2 / 12;
        int i4 = i2 / 6;
        this.mPaint.setStrokeWidth(i3);
        int i5 = this.mSize;
        canvas.rotate(i, i5 / 2, i5 / 2);
        int i6 = this.mSize;
        canvas.translate(i6 / 2, i6 / 2);
        int i7 = 0;
        while (i7 < 12) {
            canvas.rotate(30.0f);
            i7++;
            this.mPaint.setAlpha((int) ((i7 * 255.0f) / 12.0f));
            int i8 = i3 / 2;
            canvas.translate(0.0f, ((-this.mSize) / 2) + i8);
            canvas.drawLine(0.0f, 0.0f, 0.0f, i4, this.mPaint);
            canvas.translate(0.0f, (this.mSize / 2) - i8);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.mSize;
        setMeasuredDimension(i3, i3);
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        drawLoading(canvas, this.mAnimateValue * 30);
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        start();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            start();
        } else {
            stop();
        }
    }

    @Override // com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
    public androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> getDefaultSkinAttrs() {
        return sDefaultAttrs;
    }
}
