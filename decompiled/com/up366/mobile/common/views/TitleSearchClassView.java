package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TitleSearchClassView extends androidx.appcompat.widget.AppCompatImageView {
    public TitleSearchClassView(android.content.Context context) {
        super(context);
        init(null);
    }

    public TitleSearchClassView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public TitleSearchClassView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(android.util.AttributeSet attributeSet) {
        int i = com.up366.mobile.R.drawable.title_search_black_icon;
        if (attributeSet == null) {
            setImageResource(com.up366.mobile.R.drawable.title_search_black_icon);
            return;
        }
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.titleViewStyle);
        int i2 = typedArrayObtainStyledAttributes.getInt(0, 1);
        typedArrayObtainStyledAttributes.recycle();
        setScaleType(android.widget.ImageView.ScaleType.CENTER);
        if (i2 == 1) {
            i = com.up366.mobile.R.drawable.title_search_white_icon;
        }
        setImageResource(i);
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.TitleSearchClassView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.common.utils.ViewUtil.clickView(view);
            }
        });
    }

    public void setType(int i) {
        setImageResource(i == 1 ? com.up366.mobile.R.drawable.title_search_white_icon : com.up366.mobile.R.drawable.title_search_black_icon);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(android.view.View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelSize(com.up366.mobile.R.dimen.title_bar_height), 0), android.view.View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelSize(com.up366.mobile.R.dimen.title_bar_height), 0));
    }
}
