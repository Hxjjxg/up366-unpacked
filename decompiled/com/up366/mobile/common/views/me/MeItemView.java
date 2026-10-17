package com.up366.mobile.common.views.me;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MeItemView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.MeItemViewLayoutBinding b;
    private com.up366.mobile.me.views.MeItemData data;

    public MeItemView(android.content.Context context) {
        super(context);
        initAttr(context, null, 0);
    }

    public MeItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        initAttr(context, attributeSet, 0);
    }

    public MeItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttr(context, attributeSet, i);
    }

    private void initAttr(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        this.b = (com.up366.mobile.databinding.MeItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.me_item_view_layout, this, true);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.MeItemView);
        android.graphics.drawable.Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.getDrawable(2);
        java.lang.String string = typedArrayObtainStyledAttributes.getString(3);
        java.lang.String string2 = typedArrayObtainStyledAttributes.getString(1);
        typedArrayObtainStyledAttributes.recycle();
        this.b.redPoint.showRedPoint(false);
        this.b.image.setImageDrawable(drawable);
        this.b.text.setText(string);
        this.b.textRight.setText(string2);
    }

    public void setRightText(java.lang.String str) {
        this.b.textRight.setText(str);
    }

    public void showRedPoint(boolean z) {
        this.b.redPoint.showRedPoint(z);
    }

    public void setData(com.up366.mobile.me.views.MeItemData meItemData) {
        this.data = meItemData;
        this.b.image.setImageResource(meItemData.getLeftDrawableId());
        this.b.text.setText(meItemData.getTitle());
        this.b.textRight.setText(meItemData.getRightTip());
        if (meItemData.getRightTipColor() != 0) {
            this.b.textRight.setTextColor(meItemData.getRightTipColor());
        }
    }
}
