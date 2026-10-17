package com.up366.medialibrary.camera.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TypeButton extends android.view.View {
    public static final int TYPE_CANCEL = 1;
    public static final int TYPE_CONFIRM = 2;
    private float button_radius;
    private int button_size;
    private int button_type;
    private float center_X;
    private float center_Y;
    private float index;
    private android.graphics.Paint mPaint;
    private android.graphics.Path path;
    private android.graphics.RectF rectF;
    private float strokeWidth;

    public TypeButton(android.content.Context context) {
        super(context);
    }

    public TypeButton(android.content.Context context, int i, int i2) {
        super(context);
        this.button_type = i;
        this.button_size = i2;
        float f = i2;
        float f2 = f / 2.0f;
        this.button_radius = f2;
        this.center_X = f2;
        this.center_Y = f2;
        this.mPaint = new android.graphics.Paint();
        this.path = new android.graphics.Path();
        this.strokeWidth = f / 50.0f;
        this.index = this.button_size / 12.0f;
        float f3 = this.center_X;
        float f4 = this.center_Y;
        float f5 = this.index;
        this.rectF = new android.graphics.RectF(f3, f4 - f5, (2.0f * f5) + f3, f4 + f5);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.button_size;
        setMeasuredDimension(i3, i3);
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (this.button_type == 1) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(-287515428);
            this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawCircle(this.center_X, this.center_Y, this.button_radius, this.mPaint);
            this.mPaint.setColor(com.up366.qmui.widget.QMUIProgressBar.DEFAULT_TEXT_COLOR);
            this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.strokeWidth);
            android.graphics.Path path = this.path;
            float f = this.center_X;
            float f2 = this.index;
            path.moveTo(f - (f2 / 7.0f), this.center_Y + f2);
            android.graphics.Path path2 = this.path;
            float f3 = this.center_X;
            float f4 = this.index;
            path2.lineTo(f3 + f4, this.center_Y + f4);
            this.path.arcTo(this.rectF, 90.0f, -180.0f);
            android.graphics.Path path3 = this.path;
            float f5 = this.center_X;
            float f6 = this.index;
            path3.lineTo(f5 - f6, this.center_Y - f6);
            canvas.drawPath(this.path, this.mPaint);
            this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
            this.path.reset();
            android.graphics.Path path4 = this.path;
            float f7 = this.center_X;
            float f8 = this.index;
            path4.moveTo(f7 - f8, (float) (((double) this.center_Y) - (((double) f8) * 1.5d)));
            android.graphics.Path path5 = this.path;
            float f9 = this.center_X;
            float f10 = this.index;
            path5.lineTo(f9 - f10, (float) (((double) this.center_Y) - (((double) f10) / 2.3d)));
            android.graphics.Path path6 = this.path;
            double d = this.center_X;
            float f11 = this.index;
            path6.lineTo((float) (d - (((double) f11) * 1.6d)), this.center_Y - f11);
            this.path.close();
            canvas.drawPath(this.path, this.mPaint);
        }
        if (this.button_type == 2) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(-1);
            this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawCircle(this.center_X, this.center_Y, this.button_radius, this.mPaint);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
            this.mPaint.setColor(-16724992);
            this.mPaint.setStrokeWidth(this.strokeWidth);
            this.path.moveTo(this.center_X - (this.button_size / 6.0f), this.center_Y);
            android.graphics.Path path7 = this.path;
            float f12 = this.center_X;
            int i = this.button_size;
            path7.lineTo(f12 - (i / 21.2f), this.center_Y + (i / 7.7f));
            android.graphics.Path path8 = this.path;
            float f13 = this.center_X;
            int i2 = this.button_size;
            path8.lineTo(f13 + (i2 / 4.0f), this.center_Y - (i2 / 8.5f));
            android.graphics.Path path9 = this.path;
            float f14 = this.center_X;
            int i3 = this.button_size;
            path9.lineTo(f14 - (i3 / 21.2f), this.center_Y + (i3 / 9.4f));
            this.path.close();
            canvas.drawPath(this.path, this.mPaint);
        }
    }
}
