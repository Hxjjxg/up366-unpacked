package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISeekBar extends com.up366.qmui.widget.QMUISlider {
    private static androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> sDefaultSkinAttrs;
    private int mTickHeight;
    private int mTickWidth;

    static {
        androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> simpleArrayMap = new androidx.collection.SimpleArrayMap<>(2);
        sDefaultSkinAttrs = simpleArrayMap;
        simpleArrayMap.put("background", java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_seek_bar_color));
        sDefaultSkinAttrs.put(com.up366.qmui.skin.QMUISkinValueBuilder.PROGRESS_COLOR, java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_seek_bar_color));
    }

    public QMUISeekBar(android.content.Context context) {
        this(context, null);
    }

    public QMUISeekBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.qmuiteam.qmui.R.attr.QMUISeekBarStyle);
    }

    public QMUISeekBar(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUISeekBar, i, 0);
        this.mTickWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUISeekBar_qmui_seek_bar_tick_width, com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 1));
        this.mTickHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUISeekBar_qmui_seek_bar_tick_height, com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 4));
        typedArrayObtainStyledAttributes.recycle();
        setClickToChangeProgress(true);
    }

    public void setTickHeight(int i) {
        this.mTickHeight = i;
        invalidate();
    }

    public void setTickWidth(int i) {
        this.mTickWidth = i;
        invalidate();
    }

    public int getTickHeight() {
        return this.mTickHeight;
    }

    @Override // com.up366.qmui.widget.QMUISlider
    protected void drawRect(android.graphics.Canvas canvas, android.graphics.RectF rectF, int i, android.graphics.Paint paint, boolean z) {
        canvas.drawRect(rectF, paint);
    }

    @Override // com.up366.qmui.widget.QMUISlider
    protected void drawTick(android.graphics.Canvas canvas, int i, int i2, int i3, int i4, float f, android.graphics.Paint paint, int i5, int i6) {
        int i7;
        int i8 = this.mTickHeight;
        if (i8 <= 0 || (i7 = this.mTickWidth) <= 0 || i2 < 1) {
            return;
        }
        float f2 = ((i4 - i3) - i7) / i2;
        float f3 = f - (i8 / 2.0f);
        float f4 = f + (i8 / 2.0f);
        float f5 = i3 + (i7 / 2.0f);
        int i9 = 0;
        while (i9 <= i2) {
            int i10 = this.mTickWidth;
            float f6 = f5 - (i10 / 2.0f);
            float f7 = f5 + (i10 / 2.0f);
            paint.setColor(i9 <= i ? i6 : i5);
            paint.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawRect(f6, f3, f7, f4, paint);
            f5 += f2;
            i9++;
        }
    }

    @Override // com.up366.qmui.widget.QMUISlider, com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
    public androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> getDefaultSkinAttrs() {
        return sDefaultSkinAttrs;
    }
}
