package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PaddingShadowLayoutV2 extends com.up366.mobile.common.views.PaddingShadowLayout {
    private static final java.lang.String TAG = "PaddingShadowLayoutV2";
    private java.lang.String noCorner;

    public PaddingShadowLayoutV2(android.content.Context context) {
        super(context);
    }

    public PaddingShadowLayoutV2(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public PaddingShadowLayoutV2(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.PaddingShadowLayoutV2);
        this.noCorner = typedArrayObtainStyledAttributes.getString(0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.up366.mobile.common.views.PaddingShadowLayout, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        java.lang.String str = this.noCorner;
        if (str == null || str.length() == 0) {
            return;
        }
        if (this.noCorner.contains("0")) {
            canvas.drawRect(new android.graphics.RectF(getRectF().left, getRectF().top, getRectF().left + (getCornerRadius() * 2.0f), getTop() + (getCornerRadius() * 2.0f)), getBackgroundColorPaint());
        }
        if (this.noCorner.contains("1")) {
            canvas.drawRect(new android.graphics.RectF(getRectF().right - (getCornerRadius() * 2.0f), getRectF().top, getRectF().right, getTop() + (getCornerRadius() * 2.0f)), getBackgroundColorPaint());
        }
        if (this.noCorner.contains("2")) {
            canvas.drawRect(new android.graphics.RectF(getRectF().right - (getCornerRadius() * 2.0f), getRectF().bottom - (getCornerRadius() * 2.0f), getRectF().right, getRectF().bottom), getBackgroundColorPaint());
        }
        if (this.noCorner.contains("3")) {
            canvas.drawRect(new android.graphics.RectF(getRectF().left, getRectF().bottom - (getCornerRadius() * 2.0f), getRectF().left + (getCornerRadius() * 2.0f), getRectF().bottom), getBackgroundColorPaint());
        }
    }
}
