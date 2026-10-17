package com.up366.mobile.common.views.rotationmap;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RotationMapCirclePointView extends android.view.View {
    private final int color;
    private final int colorC;
    private int count;
    private boolean hideHeadEnd;
    private android.graphics.Paint paint;
    private android.graphics.Paint paintC;
    private int position;
    private java.util.Map<java.lang.Integer, android.graphics.RectF> rectFMap;

    public RotationMapCirclePointView(android.content.Context context) {
        this(context, null);
    }

    public RotationMapCirclePointView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RotationMapCirclePointView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.count = 3;
        this.color = 1728053247;
        this.colorC = -1;
        this.position = 0;
        this.rectFMap = new java.util.HashMap();
        this.hideHeadEnd = false;
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.paint = paint;
        paint.setDither(true);
        this.paint.setColor(1728053247);
        android.graphics.Paint paint2 = new android.graphics.Paint(this.paint);
        this.paintC = paint2;
        paint2.setColor(-1);
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        android.graphics.RectF rectF;
        float height = getHeight();
        float f = height / 2.0f;
        if (this.count == 0) {
            return;
        }
        if (this.rectFMap.size() != 0) {
            java.util.Iterator<android.graphics.RectF> it = this.rectFMap.values().iterator();
            while (it.hasNext()) {
                canvas.drawRoundRect(it.next(), f, f, this.paint);
            }
            android.graphics.RectF rectF2 = this.rectFMap.get(java.lang.Integer.valueOf(this.position));
            if (rectF2 != null) {
                canvas.drawRoundRect(rectF2, f, f, this.paintC);
                return;
            }
            return;
        }
        float width = getWidth();
        float f2 = (height / 3.0f) * 8.0f;
        for (int i = this.count - 1; i >= 0; i--) {
            if (!this.hideHeadEnd || (i != 0 && i != this.count - 1)) {
                float f3 = width - f2;
                float f4 = f3 - height;
                this.rectFMap.put(java.lang.Integer.valueOf(i), new android.graphics.RectF(f3, 0.0f, width, height));
                android.graphics.RectF rectF3 = this.rectFMap.get(java.lang.Integer.valueOf(i));
                if (rectF3 != null) {
                    canvas.drawRoundRect(rectF3, f, f, this.paint);
                }
                width = f4;
            }
        }
        if (this.hideHeadEnd) {
            if (this.rectFMap.size() == 0) {
                return;
            }
            this.rectFMap.put(0, this.rectFMap.get(java.lang.Integer.valueOf(this.count - 2)));
            this.rectFMap.put(java.lang.Integer.valueOf(this.count - 1), this.rectFMap.get(1));
        }
        if (this.rectFMap.get(java.lang.Integer.valueOf(this.position)) == null || (rectF = this.rectFMap.get(java.lang.Integer.valueOf(this.position))) == null) {
            return;
        }
        canvas.drawRoundRect(rectF, f, f, this.paintC);
    }

    public void setCount(int i) {
        this.count = i;
        this.rectFMap.clear();
        invalidate();
    }

    public void setPosition(int i) {
        this.position = i;
        invalidate();
    }

    public void setHideHeadEnd(boolean z) {
        this.hideHeadEnd = z;
    }
}
