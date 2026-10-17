package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CaptchaEditText extends androidx.appcompat.widget.AppCompatEditText {
    float dp;
    float gridHeight;
    float gridSpace;
    float gridWidth;
    float minSpace;
    private android.graphics.Paint paint;
    android.graphics.RectF rect;
    float sp;
    float strokeWidth;
    float textSize;
    private float touchX;

    public CaptchaEditText(android.content.Context context) {
        super(context);
        this.rect = new android.graphics.RectF();
        this.sp = getResources().getDisplayMetrics().scaledDensity;
        float f = getResources().getDisplayMetrics().density;
        this.dp = f;
        this.gridWidth = 41.0f * f;
        this.gridHeight = 44.0f * f;
        this.gridSpace = 10.0f * f;
        float f2 = this.sp;
        this.textSize = 18.0f * f2;
        this.strokeWidth = f * 1.0f;
        this.minSpace = f2 * 3.0f;
    }

    public CaptchaEditText(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new android.graphics.RectF();
        this.sp = getResources().getDisplayMetrics().scaledDensity;
        float f = getResources().getDisplayMetrics().density;
        this.dp = f;
        this.gridWidth = 41.0f * f;
        this.gridHeight = 44.0f * f;
        this.gridSpace = 10.0f * f;
        float f2 = this.sp;
        this.textSize = 18.0f * f2;
        this.strokeWidth = f * 1.0f;
        this.minSpace = f2 * 3.0f;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.paint = paint;
        paint.setStrokeWidth(this.strokeWidth);
        setCursorVisible(false);
        setSelected(false);
        setTextIsSelectable(false);
        setLongClickable(false);
        setImeOptions(268435456);
        setTextSize(0.0f);
        setBackground(null);
        setCustomSelectionActionModeCallback(new android.view.ActionMode.Callback() { // from class: com.up366.mobile.common.views.CaptchaEditText.1
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(android.view.ActionMode actionMode, android.view.MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(android.view.ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
                actionMode.finish();
                if (com.up366.mobile.common.views.CaptchaEditText.this.getText() == null) {
                    return false;
                }
                com.up366.mobile.common.views.CaptchaEditText captchaEditText = com.up366.mobile.common.views.CaptchaEditText.this;
                captchaEditText.setSelection(captchaEditText.getText().length());
                return false;
            }
        });
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.CaptchaEditText$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(android.view.View view) {
        int clickCharIndex = getClickCharIndex();
        if (clickCharIndex <= -1 || getText() == null || clickCharIndex > getText().length()) {
            return;
        }
        setSelection(clickCharIndex, getText().length());
    }

    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        this.touchX = motionEvent.getX();
        return super.dispatchTouchEvent(motionEvent);
    }

    public CaptchaEditText(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rect = new android.graphics.RectF();
        this.sp = getResources().getDisplayMetrics().scaledDensity;
        float f = getResources().getDisplayMetrics().density;
        this.dp = f;
        this.gridWidth = 41.0f * f;
        this.gridHeight = 44.0f * f;
        this.gridSpace = 10.0f * f;
        float f2 = this.sp;
        this.textSize = 18.0f * f2;
        this.strokeWidth = f * 1.0f;
        this.minSpace = f2 * 3.0f;
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float f = width;
        float fMin = java.lang.Math.min(this.gridWidth, ((f - (this.strokeWidth * 2.0f)) - (this.minSpace * 5.0f)) / 6.0f);
        float f2 = 6.0f * fMin;
        float fMin2 = java.lang.Math.min(this.gridSpace, ((f - (this.strokeWidth * 2.0f)) - f2) / 5.0f);
        float f3 = this.strokeWidth;
        float f4 = (height - this.gridHeight) / 2.0f;
        canvas.save();
        canvas.translate((((f - (f3 * 2.0f)) - (f2 + (5.0f * fMin2))) / 2.0f) + f3, f4);
        this.paint.setColor(872415027);
        this.paint.setTextAlign(android.graphics.Paint.Align.CENTER);
        this.paint.setTextSize(this.textSize);
        for (int i = 0; i < 6; i++) {
            this.rect.set(0.0f, 0.0f, fMin, this.gridHeight);
            this.rect.offsetTo(i * (fMin + fMin2), 0.0f);
            this.paint.setColor(872415027);
            java.lang.String charAt = getCharAt(i);
            if (charAt.length() > 0) {
                this.paint.setColor(-854792);
                this.paint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
                android.graphics.RectF rectF = this.rect;
                float f5 = this.dp;
                canvas.drawRoundRect(rectF, f5 * 4.0f, f5 * 4.0f, this.paint);
            } else {
                this.paint.setColor(503316480);
                this.paint.setStrokeWidth(this.strokeWidth);
                this.paint.setStyle(android.graphics.Paint.Style.STROKE);
                android.graphics.RectF rectF2 = this.rect;
                float f6 = this.dp;
                canvas.drawRoundRect(rectF2, f6 * 4.0f, f6 * 4.0f, this.paint);
            }
            android.graphics.Paint.FontMetrics fontMetrics = this.paint.getFontMetrics();
            float fCenterY = (this.rect.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f);
            this.paint.setColor(-13421773);
            this.paint.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawText(charAt, this.rect.centerX(), fCenterY, this.paint);
        }
        canvas.restore();
    }

    private int getClickCharIndex() {
        int width = getWidth();
        int height = getHeight();
        float f = width;
        float fMin = java.lang.Math.min(this.gridWidth, ((f - (this.strokeWidth * 2.0f)) - (this.minSpace * 5.0f)) / 6.0f);
        float f2 = 6.0f * fMin;
        float fMin2 = java.lang.Math.min(this.gridSpace, ((f - (this.strokeWidth * 2.0f)) - f2) / 5.0f);
        float f3 = this.strokeWidth;
        float f4 = (((f - (f3 * 2.0f)) - (f2 + (5.0f * fMin2))) / 2.0f) + f3;
        float f5 = (height - this.gridHeight) / 2.0f;
        for (int i = 0; i < 6; i++) {
            this.rect.set(0.0f, 0.0f, fMin, this.gridHeight);
            this.rect.offsetTo(i * (fMin + fMin2), 0.0f);
            this.rect.offset(f4, f5);
            if (this.touchX >= this.rect.left && this.touchX <= this.rect.right) {
                return i;
            }
        }
        return -1;
    }

    private java.lang.String getCharAt(int i) {
        android.text.Editable text = getText();
        if (text == null || i + 1 > text.length()) {
            return "";
        }
        return java.lang.String.valueOf(text.toString().charAt(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showSoftInput(boolean z) {
        if (z) {
            requestFocus();
            com.up366.mobile.common.utils.ViewUtil.showSoftInput(this);
        } else {
            com.up366.mobile.common.utils.ViewUtil.hideSoftInput(this);
        }
    }

    public java.lang.String getTrimText() {
        android.text.Editable text = getText();
        if (text == null) {
            return "";
        }
        return text.toString().trim();
    }
}
