package com.up366.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class RotationMapCirclePointView extends android.view.View {
    private int count;
    private int normalColor;
    private android.graphics.Paint paint;
    private int pointMargin;
    private java.util.List<android.graphics.PointF> points;
    private int position;
    private int selectColor;

    public RotationMapCirclePointView(android.content.Context context) {
        this(context, null);
    }

    public RotationMapCirclePointView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RotationMapCirclePointView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.count = 3;
        this.pointMargin = 0;
        this.normalColor = 1728053247;
        this.selectColor = -1;
        this.position = 0;
        this.points = new java.util.ArrayList();
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.view.R.styleable.RotationMapCirclePointView, 0, 0);
            this.count = typedArrayObtainStyledAttributes.getInt(com.up366.view.R.styleable.RotationMapCirclePointView_point_count, 3);
            this.normalColor = typedArrayObtainStyledAttributes.getColor(com.up366.view.R.styleable.RotationMapCirclePointView_normal_color, -986896);
            this.selectColor = typedArrayObtainStyledAttributes.getColor(com.up366.view.R.styleable.RotationMapCirclePointView_select_color, -11044097);
            this.pointMargin = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.up366.view.R.styleable.RotationMapCirclePointView_point_margin, 0);
        }
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.paint = paint;
        paint.setDither(true);
        this.paint.setColor(this.normalColor);
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.count == 0) {
            return;
        }
        obtainPointLocation();
        drawByCache(canvas);
    }

    private void drawByCache(android.graphics.Canvas canvas) {
        if (this.points.size() != 0) {
            float height = getHeight() / 2.0f;
            this.paint.setColor(this.normalColor);
            for (android.graphics.PointF pointF : this.points) {
                canvas.drawCircle(pointF.x, pointF.y, height, this.paint);
            }
            this.paint.setColor(this.selectColor);
            android.graphics.PointF pointF2 = this.points.get(this.position);
            canvas.drawCircle(pointF2.x, pointF2.y, height, this.paint);
        }
    }

    private void obtainPointLocation() {
        float f;
        if (this.points.size() == 0) {
            float height = getHeight() / 2.0f;
            int width = getWidth() / 2;
            int i = this.count;
            int i2 = i / 2;
            if (i % 2 == 0) {
                int i3 = this.pointMargin;
                f = (width - (i3 / 2)) - (i3 * (i2 - 1));
            } else {
                f = (width - height) - (this.pointMargin * i2);
            }
            float f2 = f - ((height * 2.0f) * i2);
            for (int i4 = 0; i4 < this.count; i4++) {
                android.graphics.PointF pointF = new android.graphics.PointF(0.0f, height);
                pointF.x = f2 + height + (height * 2.0f * i4) + (this.pointMargin * i4);
                this.points.add(pointF);
            }
        }
    }

    public void setCount(int i) {
        this.count = i;
        this.points.clear();
        invalidate();
    }

    public void setPosition(int i) {
        this.position = i;
        invalidate();
    }
}
