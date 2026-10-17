package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TitleBackView extends androidx.appcompat.widget.AppCompatImageView {
    public TitleBackView(android.content.Context context) {
        super(context);
        init(null);
    }

    public TitleBackView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public TitleBackView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(android.util.AttributeSet attributeSet) {
        int i = com.up366.mobile.R.drawable.icon_return;
        if (attributeSet == null) {
            setImageResource(com.up366.mobile.R.drawable.icon_return);
            return;
        }
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.titleViewStyle);
        int i2 = typedArrayObtainStyledAttributes.getInt(0, 1);
        typedArrayObtainStyledAttributes.recycle();
        setScaleType(android.widget.ImageView.ScaleType.CENTER);
        if (i2 != 1) {
            i = com.up366.mobile.R.drawable.icon_return_white;
        }
        setImageResource(i);
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.TitleBackView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$0(view);
            }
        });
        android.content.res.TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(com.up366.mobile.R.style.selectableItemBackgroundBorderless, new int[]{android.R.attr.background});
        setBackground(typedArrayObtainStyledAttributes2.getDrawable(0));
        typedArrayObtainStyledAttributes2.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(android.view.View view) {
        if (getContext() instanceof android.app.Activity) {
            ((android.app.Activity) getContext()).onBackPressed();
            return;
        }
        if (getContext() instanceof android.content.ContextWrapper) {
            androidx.appcompat.view.ContextThemeWrapper baseContext = ((android.content.ContextWrapper) getContext()).getBaseContext();
            if (baseContext instanceof androidx.appcompat.view.ContextThemeWrapper) {
                ((android.app.Activity) baseContext.getBaseContext()).onBackPressed();
                return;
            }
            try {
                ((android.app.Activity) baseContext).onBackPressed();
                return;
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("((Activity) context).onBackPressed() error  " + e.getMessage());
                com.up366.common.global.GB.get().getCurrentActivity().onBackPressed();
                return;
            }
        }
        com.up366.common.global.GB.get().getCurrentActivity().onBackPressed();
        com.up366.common.log.Logger.error("TAG - 2018/5/17 - TitleBackView - onClick - ");
    }

    public void setType(int i) {
        if (i == 1) {
            setImageResource(com.up366.mobile.R.drawable.icon_return);
        } else {
            setImageResource(com.up366.mobile.R.drawable.icon_return_white);
        }
    }

    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelSize(com.up366.mobile.R.dimen.title_bar_height), 0);
        int iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelSize(com.up366.mobile.R.dimen.title_bar_height), 0);
        super.onMeasure(i, i2);
        setMeasuredDimension(iMakeMeasureSpec, iMakeMeasureSpec2);
    }
}
