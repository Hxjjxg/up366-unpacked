package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TitleRightView extends androidx.appcompat.widget.AppCompatImageView {
    public TitleRightView(android.content.Context context) {
        super(context);
        init(null);
    }

    public TitleRightView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public TitleRightView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(android.util.AttributeSet attributeSet) {
        setScaleType(android.widget.ImageView.ScaleType.CENTER);
        if (attributeSet == null) {
            setImageResource(com.up366.mobile.R.drawable.title_message_black_icon);
        }
    }

    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelSize(com.up366.mobile.R.dimen.title_bar_height), 0);
        int iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelSize(com.up366.mobile.R.dimen.title_bar_height), 0);
        super.onMeasure(i, i2);
        setMeasuredDimension(iMakeMeasureSpec, iMakeMeasureSpec2);
    }
}
