package com.up366.medialibrary.camera.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ReturnButton extends android.view.View {
    private int center_X;
    private int center_Y;
    private android.graphics.Paint paint;
    android.graphics.Path path;
    private int size;
    private float strokeWidth;

    public ReturnButton(android.content.Context context, int i) {
        this(context);
        this.size = i;
        int i2 = i / 2;
        this.center_X = i2;
        this.center_Y = i2;
        this.strokeWidth = i / 15.0f;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setColor(-1);
        this.paint.setStyle(android.graphics.Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.strokeWidth);
        this.path = new android.graphics.Path();
    }

    public ReturnButton(android.content.Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.size;
        setMeasuredDimension(i3, i3 / 2);
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        android.graphics.Path path = this.path;
        float f = this.strokeWidth;
        path.moveTo(f, f / 2.0f);
        this.path.lineTo(this.center_X, this.center_Y - (this.strokeWidth / 2.0f));
        android.graphics.Path path2 = this.path;
        float f2 = this.size;
        float f3 = this.strokeWidth;
        path2.lineTo(f2 - f3, f3 / 2.0f);
        canvas.drawPath(this.path, this.paint);
    }
}
