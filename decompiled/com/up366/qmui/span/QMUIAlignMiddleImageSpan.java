package com.up366.qmui.span;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIAlignMiddleImageSpan extends android.text.style.ImageSpan implements com.up366.qmui.skin.IQMUISkinHandlerSpan {
    public static final int ALIGN_MIDDLE = -100;
    private boolean mAvoidSuperChangeFontMetrics;
    private android.graphics.drawable.Drawable mDrawable;
    private int mDrawableTintColorAttr;
    private float mFontWidthMultiple;
    private int mWidth;

    public QMUIAlignMiddleImageSpan(android.graphics.drawable.Drawable drawable, int i) {
        this(drawable, i, 0.0f);
    }

    public QMUIAlignMiddleImageSpan(android.graphics.drawable.Drawable drawable, int i, float f) {
        super(drawable.mutate(), i);
        this.mFontWidthMultiple = -1.0f;
        this.mAvoidSuperChangeFontMetrics = false;
        this.mDrawable = getDrawable();
        if (f >= 0.0f) {
            this.mFontWidthMultiple = f;
        }
    }

    public void setSkinSupportWithTintColor(android.view.View view, int i) {
        this.mDrawableTintColorAttr = i;
        android.graphics.drawable.Drawable drawable = this.mDrawable;
        if (drawable == null || view == null || i == 0) {
            return;
        }
        com.up366.qmui.util.QMUIDrawableHelper.setDrawableTintColor(drawable, com.up366.qmui.skin.QMUISkinHelper.getSkinColor(view, i));
        view.invalidate();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(android.graphics.Paint paint, java.lang.CharSequence charSequence, int i, int i2, android.graphics.Paint.FontMetricsInt fontMetricsInt) {
        if (this.mAvoidSuperChangeFontMetrics) {
            this.mWidth = getDrawable().getBounds().right;
        } else {
            this.mWidth = super.getSize(paint, charSequence, i, i2, fontMetricsInt);
        }
        if (this.mFontWidthMultiple > 0.0f) {
            this.mWidth = (int) (paint.measureText("子") * this.mFontWidthMultiple);
        }
        return this.mWidth;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(android.graphics.Canvas canvas, java.lang.CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, android.graphics.Paint paint) {
        if (this.mVerticalAlignment == -100) {
            android.graphics.drawable.Drawable drawable = this.mDrawable;
            canvas.save();
            android.graphics.Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.translate(f, i4 + fontMetricsInt.top + (((fontMetricsInt.bottom - fontMetricsInt.top) - (drawable.getBounds().bottom - drawable.getBounds().top)) / 2));
            drawable.draw(canvas);
            canvas.restore();
            return;
        }
        super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
    }

    public void setAvoidSuperChangeFontMetrics(boolean z) {
        this.mAvoidSuperChangeFontMetrics = z;
    }

    @Override // com.up366.qmui.skin.IQMUISkinHandlerSpan
    public void handle(android.view.View view, com.up366.qmui.skin.QMUISkinManager qMUISkinManager, int i, android.content.res.Resources.Theme theme) {
        int i2 = this.mDrawableTintColorAttr;
        if (i2 != 0) {
            com.up366.qmui.util.QMUIDrawableHelper.setDrawableTintColor(this.mDrawable, com.up366.qmui.util.QMUIResHelper.getAttrColor(theme, i2));
        }
    }
}
