package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CustomWordEditText extends androidx.appcompat.widget.AppCompatEditText {
    private int editHeight;
    private int editWidth;
    private android.graphics.Rect mBound;
    private android.graphics.Paint mPaint;
    private java.lang.String maxLength;
    private android.graphics.Paint maxPaint;
    private int maxSize;
    private java.lang.String maxWordLength;
    private int numLength;
    private int numSize;
    private java.lang.String numStr;
    private int numWordLength;
    private boolean withLineBreak;

    public CustomWordEditText(android.content.Context context) {
        this(context, null);
    }

    public CustomWordEditText(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.numLength = 200;
        this.numWordLength = 100;
        this.numStr = "0";
        this.numSize = com.up366.common.DpUtilsUp.sp2px(12.0f);
        this.maxSize = com.up366.common.DpUtilsUp.sp2px(12.0f);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.CustomWordEditText);
        this.numLength = typedArrayObtainStyledAttributes.getInt(0, 200);
        this.numWordLength = typedArrayObtainStyledAttributes.getInt(1, 100);
        this.maxLength = "/" + this.numLength;
        this.maxWordLength = "/" + this.numWordLength;
        setFilters(new android.text.InputFilter[]{new android.text.InputFilter() { // from class: com.up366.mobile.common.views.CustomWordEditText$$ExternalSyntheticLambda0
            @Override // android.text.InputFilter
            public final java.lang.CharSequence filter(java.lang.CharSequence charSequence, int i, int i2, android.text.Spanned spanned, int i3, int i4) {
                return this.f$0.lambda$new$0(charSequence, i, i2, spanned, i3, i4);
            }
        }, new android.text.InputFilter() { // from class: com.up366.mobile.common.views.CustomWordEditText$$ExternalSyntheticLambda1
            @Override // android.text.InputFilter
            public final java.lang.CharSequence filter(java.lang.CharSequence charSequence, int i, int i2, android.text.Spanned spanned, int i3, int i4) {
                return this.f$0.lambda$new$1(charSequence, i, i2, spanned, i3, i4);
            }
        }, new android.text.InputFilter() { // from class: com.up366.mobile.common.views.CustomWordEditText$$ExternalSyntheticLambda2
            @Override // android.text.InputFilter
            public final java.lang.CharSequence filter(java.lang.CharSequence charSequence, int i, int i2, android.text.Spanned spanned, int i3, int i4) {
                return com.up366.mobile.common.views.CustomWordEditText.lambda$new$2(charSequence, i, i2, spanned, i3, i4);
            }
        }});
        this.mPaint = new android.graphics.Paint(1);
        this.maxPaint = new android.graphics.Paint(1);
        this.mPaint.setColor(getResources().getColor(com.up366.mobile.R.color.textDeepGray));
        this.mPaint.setTextSize(this.numSize);
        this.maxPaint.setColor(getResources().getColor(com.up366.mobile.R.color.textGray));
        this.maxPaint.setTextSize(this.maxSize);
        this.mBound = new android.graphics.Rect();
        android.graphics.Paint paint = this.mPaint;
        java.lang.String str = this.numStr;
        paint.getTextBounds(str, 0, str.length(), this.mBound);
        android.graphics.Paint paint2 = this.maxPaint;
        java.lang.String str2 = this.maxLength;
        paint2.getTextBounds(str2, 0, str2.length(), this.mBound);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.withLineBreak = z;
        if (z) {
            setPadding(com.up366.common.DpUtilsUp.dp2px(10.0f), com.up366.common.DpUtilsUp.dp2px(10.0f), com.up366.common.DpUtilsUp.dp2px(10.0f), com.up366.common.DpUtilsUp.dp2px(35.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.CharSequence lambda$new$0(java.lang.CharSequence charSequence, int i, int i2, android.text.Spanned spanned, int i3, int i4) {
        if (charSequence.length() + spanned.length() <= this.numLength) {
            return null;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.show("最多输入" + this.numLength + "个字符~");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.CharSequence lambda$new$1(java.lang.CharSequence charSequence, int i, int i2, android.text.Spanned spanned, int i3, int i4) {
        int iComputeWordNum = computeWordNum(getText().toString());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (iComputeWordNum < this.numWordLength) {
            sb.append(charSequence);
        }
        if (sb.length() == charSequence.length()) {
            return null;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.show("最多输入" + this.numWordLength + "个单词~");
        return sb.toString();
    }

    static /* synthetic */ java.lang.CharSequence lambda$new$2(java.lang.CharSequence charSequence, int i, int i2, android.text.Spanned spanned, int i3, int i4) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            if (cCharAt < 255) {
                sb.append(cCharAt);
            }
        }
        if (sb.length() == charSequence.length()) {
            return null;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.show("只能输入英文哦~~");
        return sb.toString();
    }

    private int computeWordNum(java.lang.String str) {
        int length = str.length();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = 0;
        while (i < length) {
            char cCharAt = i > 0 ? str.charAt(i - 1) : (char) 0;
            char cCharAt2 = str.charAt(i);
            char cCharAt3 = i < length + (-1) ? str.charAt(i + 1) : (char) 0;
            if (" ?!;？！。；\n".indexOf(cCharAt2) > -1) {
                if (sb.length() > 0) {
                    arrayList.add(sb.toString());
                    sb = new java.lang.StringBuilder();
                }
            } else if (cCharAt2 != ',' && cCharAt2 != '.' && cCharAt2 != '-' && cCharAt2 != ':') {
                sb.append(cCharAt2);
            } else if (cCharAt >= '0' && cCharAt <= '9' && cCharAt3 >= '0' && cCharAt3 <= '9') {
                sb.append(cCharAt2);
            } else if (sb.length() > 0) {
                arrayList.add(sb.toString());
                sb = new java.lang.StringBuilder();
            }
            i++;
        }
        if (sb.length() > 0) {
            arrayList.add(sb.toString());
        }
        return arrayList.size();
    }

    public static java.util.List<java.lang.String> splitWords(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (str != null && !str.isEmpty()) {
            for (java.lang.String str2 : str.split("(\\s+|,|\\-|–|—|，|;|；|!|！|。|\\.)")) {
                if (!str2.isEmpty()) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        float fMeasureText = this.maxPaint.measureText(this.maxWordLength);
        float fMeasureText2 = this.mPaint.measureText(this.numStr);
        int width = getWidth();
        int height = getHeight() - this.mBound.height();
        if (this.withLineBreak) {
            float f = width;
            canvas.drawText(this.numStr, ((f - fMeasureText2) - fMeasureText) - com.up366.common.DpUtilsUp.dp2px(10.0f), height - com.up366.common.DpUtilsUp.dp2px(5.0f), this.mPaint);
            canvas.drawText(this.maxWordLength, (f - fMeasureText) - com.up366.common.DpUtilsUp.dp2px(10.0f), height - com.up366.common.DpUtilsUp.dp2px(5.0f), this.maxPaint);
        } else {
            float f2 = width;
            canvas.drawText(this.numStr, ((f2 - fMeasureText2) - fMeasureText) - com.up366.common.DpUtilsUp.dp2px(10.0f), (getHeight() / 2.0f) + (this.mBound.height() / 2.0f), this.mPaint);
            canvas.drawText(this.maxWordLength, (f2 - fMeasureText) - com.up366.common.DpUtilsUp.dp2px(10.0f), (getHeight() / 2.0f) + (this.mBound.height() / 2.0f), this.maxPaint);
        }
        canvas.restore();
    }

    protected void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        this.editHeight = getHeight();
        this.numStr = computeWordNum(charSequence.toString()) + "";
        postInvalidate();
        invalidate();
    }
}
