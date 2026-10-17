package com.up366.smart.paper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PaperBorderView extends android.widget.FrameLayout {
    public static final float DENSITY = android.content.res.Resources.getSystem().getDisplayMetrics().density;
    private boolean allowArea;
    private android.graphics.Paint mPaint;
    private java.util.List<org.opencv.core.Point> mPoints;
    private android.graphics.Path path;

    public PaperBorderView(android.content.Context context) {
        this(context, null);
    }

    public PaperBorderView(android.content.Context context, android.util.AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaperBorderView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mPoints = new java.util.ArrayList();
        this.path = new android.graphics.Path();
        this.allowArea = false;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mPaint = paint;
        paint.setColor(-65536);
        this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(dpToPx(4));
    }

    public void setPaintWidth(int dp) {
        this.mPaint.setStrokeWidth(dpToPx(dp));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setPoints(java.util.List<org.opencv.core.Point> points, boolean allowArea) {
        this.allowArea = allowArea;
        if (points == null || points.size() < 4) {
            this.mPoints.clear();
            invalidate();
        } else {
            this.mPoints.clear();
            this.mPoints.addAll(points);
            invalidate();
        }
    }

    public void reset() {
        this.mPoints.clear();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPoints.size() < 4) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (this.mPoints.get(i) == null) {
                return;
            }
        }
        if (this.allowArea) {
            this.mPaint.setColor(android.graphics.Color.parseColor("#4D01E6B7"));
            this.mPaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
            this.path.reset();
            this.path.moveTo((float) this.mPoints.get(0).x, (float) this.mPoints.get(0).y);
            this.path.lineTo((float) this.mPoints.get(1).x, (float) this.mPoints.get(1).y);
            this.path.lineTo((float) this.mPoints.get(2).x, (float) this.mPoints.get(2).y);
            this.path.lineTo((float) this.mPoints.get(3).x, (float) this.mPoints.get(3).y);
            this.path.close();
            canvas.drawPath(this.path, this.mPaint);
            this.mPaint.setColor(android.graphics.Color.parseColor("#01E6B7"));
        } else {
            this.mPaint.setColor(android.graphics.Color.parseColor("#FF7B11"));
        }
        this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.path.reset();
        this.path.moveTo((float) this.mPoints.get(0).x, (float) this.mPoints.get(0).y);
        this.path.lineTo((float) this.mPoints.get(1).x, (float) this.mPoints.get(1).y);
        this.path.lineTo((float) this.mPoints.get(2).x, (float) this.mPoints.get(2).y);
        this.path.lineTo((float) this.mPoints.get(3).x, (float) this.mPoints.get(3).y);
        this.path.close();
        canvas.drawPath(this.path, this.mPaint);
    }

    public int dpToPx(int dpValue) {
        return (int) ((dpValue * DENSITY) + 0.5f);
    }
}
