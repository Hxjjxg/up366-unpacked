package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CustomEditText extends com.up366.mobile.common.views.CommonEditText {
    private int editHeight;
    private int editWidth;
    private android.graphics.Rect mBound;
    private android.graphics.Paint mPaint;
    private java.lang.String maxLength;
    private android.graphics.Paint maxPaint;
    private int maxSize;
    private int numLength;
    private int numSize;
    private java.lang.String numStr;
    private boolean withLineBreak;

    public CustomEditText(android.content.Context context) {
        this(context, null);
    }

    public CustomEditText(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.numLength = 200;
        this.numStr = "0";
        this.numSize = com.up366.common.DpUtilsUp.sp2px(12.0f);
        this.maxSize = com.up366.common.DpUtilsUp.sp2px(12.0f);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.CustomEditText);
        this.numLength = typedArrayObtainStyledAttributes.getInt(0, 200);
        int color = typedArrayObtainStyledAttributes.getColor(1, getResources().getColor(com.up366.mobile.R.color.textDeepGray));
        this.maxLength = "/" + this.numLength;
        setFilters(new android.text.InputFilter[]{new android.text.InputFilter.LengthFilter(this.numLength)});
        this.mPaint = new android.graphics.Paint(1);
        this.maxPaint = new android.graphics.Paint(1);
        this.mPaint.setColor(color);
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
        setCustomSelectionActionModeCallback(new android.view.ActionMode.Callback() { // from class: com.up366.mobile.common.views.CustomEditText.1
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(android.view.ActionMode actionMode, android.view.MenuItem menuItem) {
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(android.view.ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
                return false;
            }
        });
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        float fMeasureText = this.maxPaint.measureText(this.maxLength);
        float fMeasureText2 = this.mPaint.measureText(this.numStr);
        int width = getWidth();
        int height = getHeight() - this.mBound.height();
        if (this.withLineBreak) {
            float f = width;
            canvas.drawText(this.numStr, ((f - fMeasureText2) - fMeasureText) - com.up366.common.DpUtilsUp.dp2px(10.0f), height - com.up366.common.DpUtilsUp.dp2px(5.0f), this.mPaint);
            canvas.drawText(this.maxLength, (f - fMeasureText) - com.up366.common.DpUtilsUp.dp2px(10.0f), height - com.up366.common.DpUtilsUp.dp2px(5.0f), this.maxPaint);
        } else {
            float f2 = width;
            canvas.drawText(this.numStr, ((f2 - fMeasureText2) - fMeasureText) - com.up366.common.DpUtilsUp.dp2px(10.0f), (getHeight() / 2.0f) + (this.mBound.height() / 2.0f), this.mPaint);
            canvas.drawText(this.maxLength, (f2 - fMeasureText) - com.up366.common.DpUtilsUp.dp2px(10.0f), (getHeight() / 2.0f) + (this.mBound.height() / 2.0f), this.maxPaint);
        }
        canvas.restore();
    }

    protected void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        this.editHeight = getHeight();
        this.numStr = charSequence.length() + "";
        postInvalidate();
        invalidate();
    }
}
