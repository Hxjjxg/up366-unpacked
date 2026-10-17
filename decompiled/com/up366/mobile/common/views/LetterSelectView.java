package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LetterSelectView extends android.view.View {
    private static final java.lang.String TAG = "LetterSelectView";
    private int currentIndex;
    private int lastSelect;
    private java.util.List<java.lang.String> letters;
    private float lineSpace;
    private com.up366.mobile.common.views.LetterSelectView.IOnSelectListener listener;
    private float maxTextSize;
    private final android.graphics.Paint paint;
    private android.graphics.Paint paintSel;
    private final float scaledDensity;
    private float textHeight;

    public interface IOnSelectListener {
        void onSelect(java.lang.String str);
    }

    public LetterSelectView(android.content.Context context) {
        this(context, null);
    }

    public LetterSelectView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LetterSelectView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.letters = new java.util.ArrayList();
        this.maxTextSize = 80.0f;
        this.currentIndex = -1;
        this.lastSelect = -1;
        float f = getResources().getDisplayMetrics().scaledDensity;
        this.scaledDensity = f;
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.paint = paint;
        paint.setTextSize(86.0f * f);
        paint.setColor(-6378817);
        android.graphics.Paint paint2 = new android.graphics.Paint(1);
        this.paintSel = paint2;
        paint2.setColor(-21825);
        this.paintSel.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
        this.maxTextSize = context.getResources().getDimensionPixelSize(com.up366.mobile.R.dimen.font_size_T8_11);
        this.lineSpace = f * 8.0f;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() - getPaddingBottom();
        float f = height;
        this.paint.setTextSize(f);
        int size = this.letters.size();
        for (int i = height / 2; i > 0; i /= 2) {
            android.graphics.Paint.FontMetrics fontMetrics = this.paint.getFontMetrics();
            height += (((fontMetrics.bottom - fontMetrics.top) + this.lineSpace) * ((float) size) > f ? -1 : 1) * i;
            this.paint.setTextSize(height);
        }
        android.graphics.Paint paint = this.paint;
        paint.setTextSize(java.lang.Math.min(paint.getTextSize(), this.maxTextSize));
        this.paintSel.setTextSize((this.paint.getTextSize() / 4.0f) * 6.0f);
        android.graphics.Paint.FontMetrics fontMetrics2 = this.paint.getFontMetrics();
        float f2 = 0.0f - fontMetrics2.top;
        this.textHeight = (fontMetrics2.bottom - fontMetrics2.top) + this.lineSpace;
        int paddingLeft = getPaddingLeft();
        for (int i2 = 0; i2 < this.letters.size(); i2++) {
            float f3 = (i2 * this.textHeight) + f2;
            if (i2 == this.currentIndex) {
                canvas.drawText(this.letters.get(i2), paddingLeft, f3, this.paintSel);
            } else {
                canvas.drawText(this.letters.get(i2), paddingLeft, f3, this.paint);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        float y = motionEvent.getY();
        if (y < this.textHeight * this.letters.size()) {
            int i = (int) (y / this.textHeight);
            this.currentIndex = i;
            if (i > -1 && i < this.letters.size()) {
                int i2 = this.lastSelect;
                int i3 = this.currentIndex;
                if (i2 != i3) {
                    this.lastSelect = i3;
                    com.up366.mobile.common.views.LetterSelectView.IOnSelectListener iOnSelectListener = this.listener;
                    if (iOnSelectListener != null) {
                        iOnSelectListener.onSelect(this.letters.get(i3));
                    }
                }
            }
        }
        if (motionEvent.getAction() == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (motionEvent.getAction() == 1) {
            this.currentIndex = -1;
            this.lastSelect = -1;
            performClick();
            com.up366.mobile.common.views.LetterSelectView.IOnSelectListener iOnSelectListener2 = this.listener;
            if (iOnSelectListener2 != null) {
                iOnSelectListener2.onSelect(null);
            }
        }
        postInvalidate();
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setOnSelectListener(com.up366.mobile.common.views.LetterSelectView.IOnSelectListener iOnSelectListener) {
        this.listener = iOnSelectListener;
    }

    public void setLetters(java.util.List<java.lang.String> list) {
        this.letters = list;
    }
}
