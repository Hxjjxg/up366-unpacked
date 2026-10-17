package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIFontFitTextView extends androidx.appcompat.widget.AppCompatTextView {
    private android.graphics.Paint mTestPaint;
    private float maxSize;
    private float minSize;

    public QMUIFontFitTextView(android.content.Context context) {
        this(context, null);
    }

    public QMUIFontFitTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mTestPaint = paint;
        paint.set(getPaint());
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUIFontFitTextView);
        this.minSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIFontFitTextView_qmui_minTextSize, java.lang.Math.round(com.up366.qmui.util.QMUIDisplayHelper.DENSITY * 14.0f));
        this.maxSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIFontFitTextView_qmui_maxTextSize, java.lang.Math.round(com.up366.qmui.util.QMUIDisplayHelper.DENSITY * 18.0f));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void refitText(java.lang.String str, int i) {
        if (i <= 0) {
            return;
        }
        int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
        float f = this.maxSize;
        float f2 = this.minSize;
        this.mTestPaint.set(getPaint());
        this.mTestPaint.setTextSize(this.maxSize);
        float f3 = paddingLeft;
        if (this.mTestPaint.measureText(str) <= f3) {
            f2 = this.maxSize;
        } else {
            this.mTestPaint.setTextSize(this.minSize);
            if (this.mTestPaint.measureText(str) < f3) {
                while (f - f2 > 0.5f) {
                    float f4 = (f + f2) / 2.0f;
                    this.mTestPaint.setTextSize(f4);
                    if (this.mTestPaint.measureText(str) >= f3) {
                        f = f4;
                    } else {
                        f2 = f4;
                    }
                }
            }
        }
        setTextSize(0, f2);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = android.view.View.MeasureSpec.getSize(i);
        int measuredHeight = getMeasuredHeight();
        refitText(getText().toString(), size);
        setMeasuredDimension(size, measuredHeight);
    }

    protected void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        refitText(charSequence.toString(), getWidth());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i != i3) {
            refitText(getText().toString(), i);
        }
    }
}
