package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ShapeView extends android.view.View {
    private final int backgroundColor;
    private int borderColor;
    private float borderWidth;
    private float offsetX;
    private float offsetY;
    private final android.graphics.Paint paintBackground;
    private final android.graphics.Paint paintBorder;
    private final android.graphics.Path path;
    private final float[] radiusArray;
    private float radiusLB;
    private float radiusLT;
    private float radiusRB;
    private float radiusRT;
    private final android.graphics.RectF rect;
    private float scale;

    public ShapeView(android.content.Context context) {
        this(context, null);
    }

    public ShapeView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShapeView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.scale = 1.0f;
        this.rect = new android.graphics.RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.path = new android.graphics.Path();
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.paintBackground = paint;
        paint.setStrokeWidth(1.0f);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        android.graphics.Paint paint2 = new android.graphics.Paint(1);
        this.paintBorder = paint2;
        paint2.setStrokeWidth(1.0f);
        paint2.setStyle(android.graphics.Paint.Style.STROKE);
        android.graphics.drawable.Drawable background = getBackground();
        if (background instanceof android.graphics.drawable.ColorDrawable) {
            this.backgroundColor = ((android.graphics.drawable.ColorDrawable) background).getColor();
        } else {
            this.backgroundColor = 16777215;
        }
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.ShapeView);
            float dimension = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
            this.radiusLT = typedArrayObtainStyledAttributes.getDimension(6, dimension);
            this.radiusRT = typedArrayObtainStyledAttributes.getDimension(8, dimension);
            this.radiusLB = typedArrayObtainStyledAttributes.getDimension(5, dimension);
            this.radiusRB = typedArrayObtainStyledAttributes.getDimension(7, dimension);
            this.scale = typedArrayObtainStyledAttributes.getFloat(9, 1.0f);
            this.offsetX = typedArrayObtainStyledAttributes.getDimension(2, 0.0f);
            this.offsetY = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
            this.borderWidth = typedArrayObtainStyledAttributes.getDimension(1, 0.0f);
            this.borderColor = typedArrayObtainStyledAttributes.getColor(0, 16777215);
            typedArrayObtainStyledAttributes.recycle();
        }
        setBackgroundColor(16777215);
        float f = this.radiusLT;
        float f2 = this.radiusRT;
        float f3 = this.radiusRB;
        float f4 = this.radiusLB;
        this.radiusArray = new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        canvas.save();
        float f = this.scale;
        canvas.scale(f, f);
        canvas.translate(this.offsetX, this.offsetY);
        this.path.reset();
        float f2 = width;
        float f3 = height;
        this.rect.set(0.0f, 0.0f, f2, f3);
        this.path.addRoundRect(this.rect, this.radiusArray, android.graphics.Path.Direction.CW);
        this.paintBackground.setColor(this.backgroundColor);
        canvas.drawPath(this.path, this.paintBackground);
        float f4 = this.borderWidth;
        if (f4 > 0.0f) {
            float f5 = f4 / 2.0f;
            this.path.reset();
            this.rect.set(f5, f5, f2 - f5, f3 - f5);
            this.path.addRoundRect(this.rect, this.radiusArray, android.graphics.Path.Direction.CW);
            this.paintBorder.setColor(this.borderColor);
            this.paintBorder.setStrokeWidth(this.borderWidth);
            canvas.drawPath(this.path, this.paintBorder);
        }
        canvas.restore();
        super.onDraw(canvas);
    }
}
