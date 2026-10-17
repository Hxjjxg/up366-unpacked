package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PaddingShadowLinearLayout extends android.widget.LinearLayout {
    private android.graphics.Paint backgroundColorPaint;
    private float cornerRadius;
    private android.graphics.Paint paintCorner;
    private android.graphics.Paint paintLine;
    private android.graphics.RectF rectF;
    private android.graphics.RadialGradient shaderCorner;
    private android.graphics.LinearGradient shaderLine;
    private int shadowColor;
    private float shadowRadius;

    public PaddingShadowLinearLayout(android.content.Context context) {
        super(context);
    }

    public PaddingShadowLinearLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public PaddingShadowLinearLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.PaddingShadowLayout);
        this.cornerRadius = typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        this.shadowRadius = typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
        this.shadowColor = typedArrayObtainStyledAttributes.getColor(5, com.up366.qmui.widget.QMUIProgressBar.DEFAULT_PROGRESS_COLOR);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        this.rectF = new android.graphics.RectF();
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
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.shaderLine = null;
        this.shaderCorner = null;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        float width = getWidth();
        float height = getHeight();
        if (getPaddingLeft() > 0) {
            getPaddingLeft();
            float paddingTop = getPaddingTop() == 0 ? 0.0f : this.cornerRadius + getPaddingTop();
            getPaddingLeft();
            drawShadowLine(canvas, getPaddingLeft(), paddingTop, (getPaddingBottom() == 0 ? height : (height - this.cornerRadius) - getPaddingBottom()) - paddingTop, 90.0f);
        }
        if (getPaddingTop() > 0) {
            float paddingLeft = getPaddingLeft() == 0 ? 0.0f : this.cornerRadius + getPaddingLeft();
            getPaddingTop();
            float paddingRight = getPaddingRight() == 0 ? width : (width - this.cornerRadius) - getPaddingRight();
            drawShadowLine(canvas, (paddingLeft + paddingRight) - paddingLeft, getPaddingTop(), paddingRight - paddingLeft, 180.0f);
        }
        if (getPaddingRight() > 0) {
            float paddingRight2 = width - getPaddingRight();
            float paddingTop2 = getPaddingTop() == 0 ? 0.0f : this.cornerRadius + getPaddingTop();
            float paddingBottom = getPaddingBottom() == 0 ? height : (height - this.cornerRadius) - getPaddingBottom();
            drawShadowLine(canvas, paddingRight2, (paddingTop2 + paddingBottom) - paddingTop2, paddingBottom - paddingTop2, 270.0f);
        }
        if (getPaddingBottom() > 0) {
            float paddingLeft2 = getPaddingLeft() != 0 ? getPaddingLeft() + this.cornerRadius : 0.0f;
            drawShadowLine(canvas, paddingLeft2, height - getPaddingBottom(), (getPaddingRight() == 0 ? width : (width - this.cornerRadius) - getPaddingRight()) - paddingLeft2, 0.0f);
        }
        if (getPaddingLeft() > 0 && getPaddingTop() > 0) {
            drawCorner(canvas, getPaddingLeft() + this.cornerRadius, getPaddingTop() + this.cornerRadius, 0);
        }
        if (getPaddingRight() > 0 && getPaddingTop() > 0) {
            drawCorner(canvas, (width - getPaddingRight()) - this.cornerRadius, getPaddingTop() + this.cornerRadius, 90);
        }
        if (getPaddingRight() > 0 && getPaddingBottom() > 0) {
            drawCorner(canvas, (width - getPaddingRight()) - this.cornerRadius, (height - getPaddingBottom()) - this.cornerRadius, 180);
        }
        if (getPaddingLeft() > 0 && getPaddingBottom() > 0) {
            drawCorner(canvas, getPaddingLeft() + this.cornerRadius, (height - getPaddingBottom()) - this.cornerRadius, 270);
        }
        this.rectF.set(getPaddingLeft() == 0 ? -100.0f : getPaddingLeft(), getPaddingTop() != 0 ? getPaddingTop() : -100.0f, getPaddingRight() == 0 ? getWidth() + 100 : getWidth() - getPaddingRight(), getPaddingBottom() == 0 ? getHeight() + 100 : getHeight() - getPaddingBottom());
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
        int[] iArr = new int[11];
        int iAlpha = android.graphics.Color.alpha(i);
        int iRed = android.graphics.Color.red(i);
        int iGreen = android.graphics.Color.green(i);
        int iBlue = android.graphics.Color.blue(i);
        android.view.animation.DecelerateInterpolator decelerateInterpolator = new android.view.animation.DecelerateInterpolator();
        for (int i2 = 0; i2 < 11; i2++) {
            iArr[i2] = android.graphics.Color.argb((int) (iAlpha + ((0 - iAlpha) * ((float) java.lang.Math.sqrt(decelerateInterpolator.getInterpolation((i2 * 1.0f) / 10))))), iRed, iGreen, iBlue);
        }
        return iArr;
    }

    float[] positions() {
        return new float[]{0.0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
    }

    int[] colorsR() {
        int i = this.shadowColor;
        int[] iArr = new int[12];
        int iAlpha = android.graphics.Color.alpha(i);
        int iRed = android.graphics.Color.red(i);
        int iGreen = android.graphics.Color.green(i);
        int iBlue = android.graphics.Color.blue(i);
        android.view.animation.DecelerateInterpolator decelerateInterpolator = new android.view.animation.DecelerateInterpolator();
        for (int i2 = 1; i2 < 12; i2++) {
            iArr[i2] = android.graphics.Color.argb((int) (iAlpha + ((0 - iAlpha) * ((float) java.lang.Math.sqrt(decelerateInterpolator.getInterpolation(((i2 - 1) * 1.0f) / 10))))), iRed, iGreen, iBlue);
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
        float[] fArr = new float[12];
        fArr[1] = f2 / f3;
        int i = 0;
        while (i < 11) {
            int i2 = i + 1;
            fArr[i2] = (this.cornerRadius + ((this.shadowRadius * i) / 10.0f)) / f3;
            i = i2;
        }
        return fArr;
    }
}
