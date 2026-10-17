package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class NinePatchLayout extends android.widget.FrameLayout {
    private android.graphics.Bitmap bitmap;
    private android.graphics.Canvas canvas;
    private final android.graphics.Paint paint;
    private final android.graphics.Paint paintLine;
    private android.graphics.Rect rect1;
    private android.graphics.Rect rect2;
    private float[] xs;
    private float[] ys;

    public NinePatchLayout(android.content.Context context) {
        this(context, null);
    }

    public NinePatchLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NinePatchLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = 0;
        this.xs = new float[0];
        this.ys = new float[0];
        this.paint = new android.graphics.Paint(1);
        android.graphics.Paint paint = new android.graphics.Paint();
        this.paintLine = paint;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.NinePatchLayout);
        java.lang.String string = typedArrayObtainStyledAttributes.getString(1);
        java.lang.String string2 = typedArrayObtainStyledAttributes.getString(2);
        paint.setColor(typedArrayObtainStyledAttributes.getColor(0, -1996554240));
        if (string != null) {
            java.lang.String[] strArrSplit = string.split(com.igexin.push.core.b.an);
            float[] fArr = new float[strArrSplit.length + 2];
            this.xs = fArr;
            fArr[0] = 0.0f;
            int i3 = 0;
            while (i3 < strArrSplit.length) {
                int i4 = i3 + 1;
                this.xs[i4] = java.lang.Float.parseFloat(strArrSplit[i3]);
                i3 = i4;
            }
            this.xs[strArrSplit.length + 1] = 1.0f;
        }
        if (string2 != null) {
            java.lang.String[] strArrSplit2 = string2.split(com.igexin.push.core.b.an);
            float[] fArr2 = new float[strArrSplit2.length + 2];
            this.ys = fArr2;
            fArr2[0] = 0.0f;
            while (i2 < strArrSplit2.length) {
                int i5 = i2 + 1;
                this.ys[i5] = java.lang.Float.parseFloat(strArrSplit2[i2]);
                i2 = i5;
            }
            this.ys[strArrSplit2.length + 1] = 1.0f;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            android.view.View childAt = getChildAt(0);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredWidth <= 0 || measuredHeight <= 0) {
                return;
            }
            android.graphics.Bitmap bitmap = this.bitmap;
            if (bitmap != null && bitmap.getWidth() == measuredWidth && this.bitmap.getHeight() == measuredHeight) {
                return;
            }
            this.bitmap = android.graphics.Bitmap.createBitmap(measuredWidth, measuredHeight, android.graphics.Bitmap.Config.ARGB_8888);
            this.canvas = new android.graphics.Canvas(this.bitmap);
            this.rect1 = new android.graphics.Rect();
            this.rect2 = new android.graphics.Rect();
            this.rect1.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.rect2.set(0, 0, measuredWidth, measuredHeight);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        android.graphics.Canvas canvas2 = this.canvas;
        if (canvas2 != null) {
            super.dispatchDraw(canvas2);
            drawNinePatch(canvas);
        }
    }

    private void drawNinePatch(android.graphics.Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        int i;
        float f6;
        float f7;
        int width = getWidth();
        int height = getHeight();
        int width2 = this.bitmap.getWidth();
        int height2 = this.bitmap.getHeight();
        int i2 = 0;
        float f8 = 0.0f;
        while (true) {
            float[] fArr = this.xs;
            if (i2 >= fArr.length - 2) {
                break;
            }
            int i3 = i2 + 2;
            f8 += fArr[i3] - fArr[i2 + 1];
            i2 = i3;
        }
        int i4 = 0;
        float f9 = 0.0f;
        while (true) {
            float[] fArr2 = this.ys;
            if (i4 >= fArr2.length - 2) {
                break;
            }
            int i5 = i4 + 2;
            f9 += fArr2[i5] - fArr2[i4 + 1];
            i4 = i5;
        }
        int i6 = 0;
        float f10 = 0.0f;
        while (true) {
            float[] fArr3 = this.ys;
            int i7 = 1;
            if (i6 >= fArr3.length - 1) {
                break;
            }
            float f11 = fArr3[i6];
            int i8 = i6 + 1;
            float f12 = fArr3[i8];
            if (i6 % 2 == 0) {
                f5 = ((f12 - f11) * height2) + f10;
            } else {
                float f13 = f12 - f11;
                f5 = (f13 * ((height - height2) / f9)) + (height2 * f13) + f10;
            }
            int i9 = 0;
            float f14 = 0.0f;
            while (true) {
                float[] fArr4 = this.xs;
                i = i8;
                if (i9 < fArr4.length - i7) {
                    float f15 = fArr4[i9];
                    int i10 = i9 + 1;
                    float f16 = fArr4[i10];
                    if (i9 % 2 == i7) {
                        float f17 = f16 - f15;
                        f6 = f9;
                        f7 = (width2 * f17) + f14 + (f17 * ((width - width2) / f8));
                    } else {
                        f6 = f9;
                        f7 = f14 + ((f16 - f15) * width2);
                    }
                    float f18 = f7;
                    this.rect1.set((int) f14, (int) f10, (int) f7, (int) f5);
                    float f19 = width2;
                    float f20 = height2;
                    this.rect2.set((int) (f15 * f19), (int) (f11 * f20), (int) (f16 * f19), (int) (f20 * f12));
                    canvas.drawBitmap(this.bitmap, this.rect2, this.rect1, this.paint);
                    i8 = i;
                    i9 = i10;
                    f9 = f6;
                    f10 = f10;
                    f14 = f18;
                    i7 = 1;
                }
            }
            f10 = f5;
            i6 = i;
        }
        float f21 = f9;
        if (!isInEditMode()) {
            return;
        }
        int i11 = 0;
        float f22 = 0.0f;
        while (true) {
            float[] fArr5 = this.ys;
            if (i11 >= fArr5.length - 2) {
                break;
            }
            float f23 = fArr5[i11];
            int i12 = i11 + 1;
            float f24 = fArr5[i12];
            if (i11 % 2 == 0) {
                f3 = f24 - f23;
                f4 = height2;
            } else {
                f3 = f24 - f23;
                f22 += height2 * f3;
                f4 = (height - height2) / f21;
            }
            f22 += f3 * f4;
            canvas.drawLine(0.0f, f22, width, f22, this.paintLine);
            i11 = i12;
        }
        float f25 = 0.0f;
        int i13 = 0;
        while (true) {
            float[] fArr6 = this.xs;
            if (i13 >= fArr6.length - 2) {
                return;
            }
            float f26 = fArr6[i13];
            int i14 = i13 + 1;
            float f27 = fArr6[i14];
            if (i13 % 2 == 1) {
                f = f27 - f26;
                f25 += width2 * f;
                f2 = (width - width2) / f8;
            } else {
                f = f27 - f26;
                f2 = width2;
            }
            f25 += f * f2;
            canvas.drawLine(f25, 0.0f, f25, height, this.paintLine);
            i13 = i14;
        }
    }
}
