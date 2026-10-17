package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AccountForgetItemView extends com.up366.mobile.common.views.PaddingShadowLayout {
    private final com.up366.mobile.databinding.AccountForgetItemViewLayoutBinding b;
    private final int colorCircle;
    private final int colorPie;
    private final float dp;
    private final android.graphics.Paint paint;

    public AccountForgetItemView(android.content.Context context) {
        this(context, null);
    }

    public AccountForgetItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccountForgetItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dp = getResources().getDisplayMetrics().density;
        com.up366.mobile.databinding.AccountForgetItemViewLayoutBinding accountForgetItemViewLayoutBinding = (com.up366.mobile.databinding.AccountForgetItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.account_forget_item_view_layout, this, true);
        this.b = accountForgetItemViewLayoutBinding;
        setWillNotDraw(false);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.AccountForgetItemView);
        java.lang.String string = typedArrayObtainStyledAttributes.getString(2);
        this.colorPie = typedArrayObtainStyledAttributes.getColor(1, -1);
        this.colorCircle = typedArrayObtainStyledAttributes.getColor(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        accountForgetItemViewLayoutBinding.name.setText(string);
        this.paint = new android.graphics.Paint(1);
    }

    @Override // com.up366.mobile.common.views.PaddingShadowLayout, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.save();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        canvas.clipRect(paddingLeft, paddingTop, width - paddingRight, height - paddingBottom);
        canvas.translate(paddingLeft, paddingTop);
        int i = (height - paddingTop) - paddingBottom;
        this.paint.setStyle(android.graphics.Paint.Style.FILL);
        this.paint.setColor(this.colorPie);
        float f = (width - paddingLeft) - paddingRight;
        float f2 = (-i) * 0.7f;
        float f3 = i;
        canvas.drawCircle(0.3f * f, f2, f3, this.paint);
        this.paint.setStyle(android.graphics.Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.dp * 20.0f);
        this.paint.setColor(this.colorCircle);
        canvas.drawCircle(f, 1.2f * f3, f3 * 0.5f, this.paint);
        canvas.restore();
    }
}
