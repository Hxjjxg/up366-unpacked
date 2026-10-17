package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIVerticalTextView extends androidx.appcompat.widget.AppCompatTextView {
    private boolean mIsVerticalMode;
    private int[] mLineBreakIndex;
    private int mLineCount;
    private float[] mLineWidths;

    private void init() {
    }

    public QMUIVerticalTextView(android.content.Context context) {
        super(context);
        this.mIsVerticalMode = true;
        init();
    }

    public QMUIVerticalTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsVerticalMode = true;
        init();
    }

    public QMUIVerticalTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsVerticalMode = true;
        init();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        float fMeasureText;
        float f;
        super.onMeasure(i, i2);
        if (this.mIsVerticalMode) {
            int mode = android.view.View.MeasureSpec.getMode(i);
            int mode2 = android.view.View.MeasureSpec.getMode(i2);
            int size = android.view.View.MeasureSpec.getSize(i);
            int size2 = android.view.View.MeasureSpec.getSize(i2);
            float paddingLeft = getPaddingLeft() + getPaddingRight();
            float paddingTop = getPaddingTop() + getPaddingBottom();
            char[] charArray = getText().toString().toCharArray();
            android.text.TextPaint paint = getPaint();
            android.graphics.Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int paddingBottom = (mode2 == 0 ? Integer.MAX_VALUE : size2) - getPaddingBottom();
            float paddingTop2 = getPaddingTop();
            this.mLineCount = 0;
            this.mLineWidths = new float[charArray.length + 1];
            this.mLineBreakIndex = new int[charArray.length + 1];
            float f2 = paddingTop2;
            int i4 = 0;
            int i5 = 0;
            int i6 = 1;
            while (i4 < charArray.length) {
                int iCharCount = java.lang.Character.charCount(java.lang.Character.codePointAt(charArray, i4));
                if (!isCJKCharacter(r12)) {
                    i3 = size;
                    f = fontMetricsInt.descent - fontMetricsInt.ascent;
                    fMeasureText = paint.measureText(charArray, i4, iCharCount);
                } else {
                    i3 = size;
                    float fMeasureText2 = paint.measureText(charArray, i4, iCharCount);
                    fMeasureText = fontMetricsInt.descent - fontMetricsInt.ascent;
                    f = fMeasureText2;
                }
                float f3 = paddingTop2 + fMeasureText;
                android.text.TextPaint textPaint = paint;
                if (f3 <= paddingBottom || i4 <= 0) {
                    paddingTop2 = f3;
                    if (f2 < f3) {
                        f2 = paddingTop2;
                    }
                } else {
                    if (f2 >= paddingTop2) {
                        paddingTop2 = f2;
                    }
                    this.mLineBreakIndex[i5] = i4 - iCharCount;
                    paddingLeft += this.mLineWidths[i5];
                    i5++;
                    f2 = paddingTop2;
                    paddingTop2 = getPaddingTop() + fMeasureText;
                }
                float[] fArr = this.mLineWidths;
                if (fArr[i5] < f) {
                    fArr[i5] = f;
                }
                i4 += iCharCount;
                if (i4 >= charArray.length) {
                    paddingLeft += fArr[i5];
                    paddingTop = getPaddingBottom() + f2;
                }
                i6 = iCharCount;
                size = i3;
                paint = textPaint;
            }
            int i7 = size;
            if (charArray.length > 0) {
                this.mLineCount = i5 + 1;
                this.mLineBreakIndex[i5] = charArray.length - i6;
            }
            int i8 = this.mLineCount;
            if (i8 > 1) {
                int i9 = i8 - 1;
                for (int i10 = 0; i10 < i9; i10++) {
                    paddingLeft += (this.mLineWidths[i10] * (getLineSpacingMultiplier() - 1.0f)) + getLineSpacingExtra();
                }
            }
            if (mode2 == 1073741824) {
                paddingTop = size2;
            } else if (mode2 == Integer.MIN_VALUE) {
                paddingTop = java.lang.Math.min(paddingTop, size2);
            }
            if (mode == 1073741824) {
                paddingLeft = i7;
            } else if (mode == Integer.MIN_VALUE) {
                paddingLeft = java.lang.Math.min(paddingLeft, i7);
            }
            setMeasuredDimension((int) paddingLeft, (int) paddingTop);
        }
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        android.graphics.Paint.FontMetricsInt fontMetricsInt;
        if (!this.mIsVerticalMode) {
            super.onDraw(canvas);
            return;
        }
        if (this.mLineCount == 0) {
            return;
        }
        android.text.TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        android.graphics.Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        char[] charArray = getText().toString().toCharArray();
        canvas.save();
        float width = (getWidth() - getPaddingRight()) - this.mLineWidths[0];
        float lineSpacingMultiplier = width;
        float paddingTop = getPaddingTop();
        int i = 0;
        int i2 = 0;
        while (i < charArray.length) {
            int iCodePointAt = java.lang.Character.codePointAt(charArray, i);
            int iCharCount = java.lang.Character.charCount(iCodePointAt);
            boolean z = !isCJKCharacter(iCodePointAt);
            int iSave = canvas.save();
            if (z) {
                canvas.rotate(90.0f, width, paddingTop);
            }
            float f = width;
            android.graphics.Paint.FontMetricsInt fontMetricsInt3 = fontMetricsInt2;
            canvas.drawText(charArray, i, iCharCount, width, z ? (paddingTop - ((this.mLineWidths[i2] - (fontMetricsInt2.bottom - fontMetricsInt2.top)) / 2.0f)) - fontMetricsInt2.descent : paddingTop - fontMetricsInt2.ascent, paint);
            canvas.restoreToCount(iSave);
            int i3 = i + iCharCount;
            if (i3 >= charArray.length) {
                fontMetricsInt = fontMetricsInt3;
                width = f;
            } else {
                if (i + 1 > this.mLineBreakIndex[i2]) {
                    int i4 = i2 + 1;
                    float[] fArr = this.mLineWidths;
                    if (i4 < fArr.length) {
                        lineSpacingMultiplier -= (fArr[i4] * getLineSpacingMultiplier()) + getLineSpacingExtra();
                        i2 = i4;
                        paddingTop = getPaddingTop();
                        width = lineSpacingMultiplier;
                        fontMetricsInt = fontMetricsInt3;
                    }
                }
                if (z) {
                    paddingTop += paint.measureText(charArray, i, iCharCount);
                    fontMetricsInt = fontMetricsInt3;
                    width = f;
                } else {
                    fontMetricsInt = fontMetricsInt3;
                    paddingTop += fontMetricsInt.descent - fontMetricsInt.ascent;
                    width = f;
                }
            }
            fontMetricsInt2 = fontMetricsInt;
            i = i3;
        }
        canvas.restore();
    }

    private static boolean isCJKCharacter(int i) {
        java.lang.Character.UnicodeBlock unicodeBlockOf = java.lang.Character.UnicodeBlock.of(i);
        return unicodeBlockOf == java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || unicodeBlockOf == java.lang.Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || unicodeBlockOf == java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || unicodeBlockOf == java.lang.Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS || unicodeBlockOf == java.lang.Character.UnicodeBlock.HANGUL_SYLLABLES || unicodeBlockOf == java.lang.Character.UnicodeBlock.HANGUL_JAMO || unicodeBlockOf == java.lang.Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO || unicodeBlockOf == java.lang.Character.UnicodeBlock.HIRAGANA || unicodeBlockOf == java.lang.Character.UnicodeBlock.KATAKANA || unicodeBlockOf == java.lang.Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS;
    }

    public void setVerticalMode(boolean z) {
        this.mIsVerticalMode = z;
        requestLayout();
    }

    public boolean isVerticalMode() {
        return this.mIsVerticalMode;
    }
}
