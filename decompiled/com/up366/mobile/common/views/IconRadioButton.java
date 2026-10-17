package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class IconRadioButton extends androidx.appcompat.widget.AppCompatRadioButton {
    private android.graphics.Paint textPaint;

    public IconRadioButton(android.content.Context context) {
        super(context);
        this.textPaint = new android.graphics.Paint();
    }

    public IconRadioButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.textPaint = new android.graphics.Paint();
    }

    public IconRadioButton(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.textPaint = new android.graphics.Paint();
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        this.textPaint.setTextSize(getTextSize());
        float fMeasureText = this.textPaint.measureText(getText().toString());
        android.graphics.drawable.Drawable drawable = getCompoundDrawables()[0];
        int width = ((int) ((getWidth() - fMeasureText) / 2.0f)) - drawable.getMinimumWidth();
        drawable.setBounds(width, 0, drawable.getMinimumWidth() + width, drawable.getMinimumHeight());
        super.onDraw(canvas);
    }
}
