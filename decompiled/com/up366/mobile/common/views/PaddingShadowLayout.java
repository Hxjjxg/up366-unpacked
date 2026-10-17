package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PaddingShadowLayout extends android.widget.FrameLayout {
    private static final boolean DEBUG = false;
    private static final java.lang.String TAG = "PaddingShadowLayout";
    private android.graphics.Paint backgroundColorPaint;
    float controlX1;
    float controlX2;
    float controlY1;
    float controlY2;
    private float cornerRadius;
    private android.graphics.Paint paintChart;
    private android.graphics.Paint paintCorner;
    private android.graphics.Paint paintLine;
    private float pslPaddingBottom;
    private float pslPaddingLeft;
    private float pslPaddingRight;
    private float pslPaddingTop;
    private android.graphics.RectF rectF;
    private int segment;
    private android.graphics.RadialGradient shaderCorner;
    private android.graphics.LinearGradient shaderLine;
    private int shadowColor;
    private float shadowRadius;

    public PaddingShadowLayout(android.content.Context context) {
        super(context);
        this.segment = 9;
        this.controlX1 = 0.35f;
        this.controlY1 = 1.0f;
        this.controlX2 = 1.0f;
        this.controlY2 = 1.0f;
    }

    public PaddingShadowLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.segment = 9;
        this.controlX1 = 0.35f;
        this.controlY1 = 1.0f;
        this.controlX2 = 1.0f;
        this.controlY2 = 1.0f;
        init(context, attributeSet);
    }

    public PaddingShadowLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.segment = 9;
        this.controlX1 = 0.35f;
        this.controlY1 = 1.0f;
        this.controlX2 = 1.0f;
        this.controlY2 = 1.0f;
        init(context, attributeSet);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.PaddingShadowLayout);
        this.cornerRadius = typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        this.shadowRadius = typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
        this.shadowColor = typedArrayObtainStyledAttributes.getColor(5, com.up366.qmui.widget.QMUIProgressBar.DEFAULT_PROGRESS_COLOR);
        this.pslPaddingLeft = typedArrayObtainStyledAttributes.getDimension(2, 0.0f);
        this.pslPaddingTop = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
        this.pslPaddingRight = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
        this.pslPaddingBottom = typedArrayObtainStyledAttributes.getDimension(1, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        this.rectF = new android.graphics.RectF();
        this.segment = java.lang.Math.max(3, (int) ((this.shadowRadius / 2.0f) / getResources().getDisplayMetrics().density));
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.paintLine = paint;
        paint.setStyle(android.graphics.Paint.Style.FILL);
        android.graphics.Paint paint2 = new android.graphics.Paint(1);
        this.paintCorner = paint2;
        paint2.setStyle(android.graphics.Paint.Style.STROKE);
        this.backgroundColorPaint = new android.graphics.Paint(1);
        android.graphics.drawable.Drawable background = getBackground();
        int color = background instanceof android.graphics.drawable.ColorDrawable ? ((android.graphics.drawable.ColorDrawable) background).getColor() : 16777215;
        setBackground(new android.graphics.drawable.ColorDrawable(16777215));
        this.backgroundColorPaint.setColor(color);
        android.graphics.Paint paint3 = new android.graphics.Paint(1);
        this.paintChart = paint3;
        paint3.setColor(-65536);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.shaderLine = null;
        this.shaderCorner = null;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        java.lang.System.currentTimeMillis();
        float width = getWidth();
        float height = getHeight();
        if (getPaddingLeftCustom() != 0.0f) {
            getPaddingLeftCustom();
            float paddingTopCustom = getPaddingTopCustom() == 0.0f ? 0.0f : this.cornerRadius + getPaddingTopCustom();
            getPaddingLeftCustom();
            drawShadowLine(canvas, getPaddingLeftCustom(), paddingTopCustom, (getPaddingBottomCustom() == 0.0f ? height : (height - this.cornerRadius) - getPaddingBottomCustom()) - paddingTopCustom, 90.0f);
        }
        if (getPaddingTopCustom() != 0.0f) {
            float paddingLeftCustom = getPaddingLeftCustom() == 0.0f ? 0.0f : this.cornerRadius + getPaddingLeftCustom();
            getPaddingTopCustom();
            float paddingRightCustom = getPaddingRightCustom() == 0.0f ? width : (width - this.cornerRadius) - getPaddingRightCustom();
            drawShadowLine(canvas, (paddingLeftCustom + paddingRightCustom) - paddingLeftCustom, getPaddingTopCustom(), paddingRightCustom - paddingLeftCustom, 180.0f);
        }
        if (getPaddingRightCustom() != 0.0f) {
            float paddingRightCustom2 = width - getPaddingRightCustom();
            float paddingTopCustom2 = getPaddingTopCustom() == 0.0f ? 0.0f : this.cornerRadius + getPaddingTopCustom();
            float paddingBottomCustom = getPaddingBottomCustom() == 0.0f ? height : (height - this.cornerRadius) - getPaddingBottomCustom();
            drawShadowLine(canvas, paddingRightCustom2, (paddingTopCustom2 + paddingBottomCustom) - paddingTopCustom2, paddingBottomCustom - paddingTopCustom2, 270.0f);
        }
        if (getPaddingBottomCustom() != 0.0f) {
            float paddingLeftCustom2 = getPaddingLeftCustom() == 0.0f ? 0.0f : this.cornerRadius + getPaddingLeftCustom();
            drawShadowLine(canvas, paddingLeftCustom2, height - getPaddingBottomCustom(), (getPaddingRightCustom() == 0.0f ? width : (width - this.cornerRadius) - getPaddingRightCustom()) - paddingLeftCustom2, 0.0f);
        }
        if (getPaddingLeftCustom() != 0.0f && getPaddingTopCustom() != 0.0f) {
            drawCorner(canvas, getPaddingLeftCustom() + this.cornerRadius, getPaddingTopCustom() + this.cornerRadius, 0);
        }
        if (getPaddingRightCustom() != 0.0f && getPaddingTopCustom() != 0.0f) {
            drawCorner(canvas, (width - getPaddingRightCustom()) - this.cornerRadius, getPaddingTopCustom() + this.cornerRadius, 90);
        }
        if (getPaddingRightCustom() != 0.0f && getPaddingBottomCustom() != 0.0f) {
            drawCorner(canvas, (width - getPaddingRightCustom()) - this.cornerRadius, (height - getPaddingBottomCustom()) - this.cornerRadius, 180);
        }
        if (getPaddingLeftCustom() != 0.0f && getPaddingBottomCustom() != 0.0f) {
            drawCorner(canvas, getPaddingLeftCustom() + this.cornerRadius, (height - getPaddingBottomCustom()) - this.cornerRadius, 270);
        }
        this.rectF.set(getPaddingLeftCustom() == 0.0f ? -100.0f : getPaddingLeftCustom(), getPaddingTopCustom() != 0.0f ? getPaddingTopCustom() : -100.0f, getPaddingRightCustom() == 0.0f ? getWidth() + 100 : getWidth() - getPaddingRightCustom(), getPaddingBottomCustom() == 0.0f ? getHeight() + 100 : getHeight() - getPaddingBottomCustom());
        android.graphics.RectF rectF = this.rectF;
        float f = this.cornerRadius;
        canvas.drawRoundRect(rectF, f, f, this.backgroundColorPaint);
    }

    private void drawShadowLine(android.graphics.Canvas canvas, float f, float f2, float f3, float f4) {
        canvas.save();
        canvas.translate(f, f2);
        canvas.rotate(f4);
        this.rectF.set(0.0f, 0.0f, f3, this.shadowRadius);
        if (this.shaderLine == null) {
            this.shaderLine = new android.graphics.LinearGradient(0.0f, 0.0f, 0.0f, this.shadowRadius, colors(), positions(), android.graphics.Shader.TileMode.CLAMP);
        }
        this.paintLine.setShader(this.shaderLine);
        this.paintLine.setStyle(android.graphics.Paint.Style.FILL);
        canvas.drawRect(this.rectF, this.paintLine);
        canvas.restore();
    }

    private void drawCorner(android.graphics.Canvas canvas, float f, float f2, int i) {
        canvas.save();
        canvas.translate(f, f2);
        canvas.rotate(i);
        float f3 = this.shadowRadius;
        float f4 = this.cornerRadius;
        float f5 = ((-f3) - f4) + (f3 / 2.0f);
        float f6 = ((-f3) - f4) + (f3 / 2.0f);
        float f7 = (f3 + f4) - (f3 / 2.0f);
        float f8 = (f4 + f3) - (f3 / 2.0f);
        this.rectF.set(f5, f6, f7, f8);
        this.paintCorner.setStrokeWidth(this.shadowRadius);
        if (this.shaderCorner == null) {
            this.shaderCorner = new android.graphics.RadialGradient(-1.0f, -1.0f, this.shadowRadius + this.cornerRadius, colorsR(), positionsR(), android.graphics.Shader.TileMode.CLAMP);
        }
        this.paintCorner.setShader(this.shaderCorner);
        android.graphics.Path path = new android.graphics.Path();
        path.reset();
        path.moveTo(f5, f8);
        path.arcTo(this.rectF, 180.0f, 90.0f, true);
        canvas.drawPath(path, this.paintCorner);
        canvas.restore();
    }

    int[] colors() {
        int i = this.shadowColor;
        int i2 = this.segment;
        int[] iArr = new int[i2];
        int iAlpha = android.graphics.Color.alpha(i);
        int iRed = android.graphics.Color.red(i);
        int iGreen = android.graphics.Color.green(i);
        int iBlue = android.graphics.Color.blue(i);
        com.up366.mobile.common.views.PaddingShadowLayout.ShadowColorInterpolator shadowColorInterpolator = new com.up366.mobile.common.views.PaddingShadowLayout.ShadowColorInterpolator();
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = android.graphics.Color.argb((int) (iAlpha + ((0 - iAlpha) * shadowColorInterpolator.getInterpolation((i3 * 1.0f) / (i2 - 1)))), iRed, iGreen, iBlue);
        }
        return iArr;
    }

    float[] positions() {
        float[] fArr = new float[this.segment];
        int i = 1;
        while (true) {
            if (i >= this.segment) {
                return fArr;
            }
            fArr[i] = (i * 1.0f) / (r2 - 1);
            i++;
        }
    }

    int[] colorsR() {
        int i = this.shadowColor;
        int i2 = this.segment + 1;
        int[] iArr = new int[i2];
        int iAlpha = android.graphics.Color.alpha(i);
        int iRed = android.graphics.Color.red(i);
        int iGreen = android.graphics.Color.green(i);
        int iBlue = android.graphics.Color.blue(i);
        com.up366.mobile.common.views.PaddingShadowLayout.ShadowColorInterpolator shadowColorInterpolator = new com.up366.mobile.common.views.PaddingShadowLayout.ShadowColorInterpolator();
        for (int i3 = 2; i3 < i2; i3++) {
            iArr[i3] = android.graphics.Color.argb((int) (iAlpha + ((0 - iAlpha) * shadowColorInterpolator.getInterpolation((i3 * 1.0f) / (r1 - 1)))), iRed, iGreen, iBlue);
        }
        int iArgb = android.graphics.Color.argb(iAlpha, iRed, iGreen, iBlue);
        iArr[1] = iArgb;
        iArr[0] = iArgb;
        return iArr;
    }

    float[] positionsR() {
        float f = this.shadowRadius;
        float f2 = this.cornerRadius;
        float f3 = f + f2;
        int i = this.segment;
        float[] fArr = new float[i + 1];
        fArr[1] = f2 / f3;
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            fArr[i3] = (this.cornerRadius + ((this.shadowRadius * i2) / (i - 1))) / f3;
            i2 = i3;
        }
        return fArr;
    }

    private float getPaddingLeftCustom() {
        float f = this.pslPaddingLeft;
        return f != 0.0f ? f : getPaddingLeft();
    }

    private float getPaddingTopCustom() {
        float f = this.pslPaddingTop;
        return f != 0.0f ? f : getPaddingTop();
    }

    private float getPaddingRightCustom() {
        float f = this.pslPaddingRight;
        return f != 0.0f ? f : getPaddingRight();
    }

    private float getPaddingBottomCustom() {
        float f = this.pslPaddingBottom;
        return f != 0.0f ? f : getPaddingBottom();
    }

    private class ShadowColorInterpolator implements android.view.animation.Interpolator {
        android.view.animation.Interpolator interpolator;

        ShadowColorInterpolator() {
            this.interpolator = androidx.core.view.animation.PathInterpolatorCompat.create(com.up366.mobile.common.views.PaddingShadowLayout.this.controlX1, com.up366.mobile.common.views.PaddingShadowLayout.this.controlY1, com.up366.mobile.common.views.PaddingShadowLayout.this.controlX2, com.up366.mobile.common.views.PaddingShadowLayout.this.controlY2);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return this.interpolator.getInterpolation(f);
        }
    }

    public void setControl1(float f, float f2) {
        this.controlX1 = f;
        this.controlY1 = f2;
        this.shaderCorner = null;
        this.shaderLine = null;
        postInvalidate();
    }

    public void setControl2(float f, float f2) {
        this.controlX2 = f;
        this.controlY2 = f2;
        this.shaderCorner = null;
        this.shaderLine = null;
        postInvalidate();
    }

    public void setInnerBackgroundColor(int i) {
        this.backgroundColorPaint.setColor(i);
        postInvalidate();
    }

    public void setPslPaddingLeft(float f) {
        this.pslPaddingLeft = f;
    }

    public void setPslPaddingTop(float f) {
        this.pslPaddingTop = f;
    }

    public void setPslPaddingRight(float f) {
        this.pslPaddingRight = f;
    }

    public void setPslPaddingBottom(float f) {
        this.pslPaddingBottom = f;
    }

    public android.graphics.RectF getRectF() {
        return this.rectF;
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public android.graphics.Paint getBackgroundColorPaint() {
        return this.backgroundColorPaint;
    }
}
