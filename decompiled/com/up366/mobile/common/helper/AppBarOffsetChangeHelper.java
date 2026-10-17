package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppBarOffsetChangeHelper {
    private com.google.android.material.appbar.AppBarLayout appBar;
    private float percent;
    private com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;
    private android.view.View[] leftViews = new android.view.View[0];
    private android.view.View[] rightViews = new android.view.View[0];

    public interface IOnOffsetChangeListener {
        void onChange(int i, float f);
    }

    public com.up366.mobile.common.helper.AppBarOffsetChangeHelper with(com.google.android.material.appbar.AppBarLayout appBarLayout, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        this.appBar = appBarLayout;
        this.toolbarLayout = collapsingToolbarLayout;
        return this;
    }

    public com.up366.mobile.common.helper.AppBarOffsetChangeHelper left(android.view.View... viewArr) {
        this.leftViews = viewArr;
        return this;
    }

    public com.up366.mobile.common.helper.AppBarOffsetChangeHelper right(android.view.View... viewArr) {
        this.rightViews = viewArr;
        return this;
    }

    public void onOffsetChange(final com.up366.mobile.common.helper.AppBarOffsetChangeHelper.IOnOffsetChangeListener iOnOffsetChangeListener) {
        this.appBar.addOnOffsetChangedListener(new com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener() { // from class: com.up366.mobile.common.helper.AppBarOffsetChangeHelper$$ExternalSyntheticLambda3
            public final void onOffsetChanged(com.google.android.material.appbar.AppBarLayout appBarLayout, int i) {
                this.f$0.lambda$onOffsetChange$0(iOnOffsetChangeListener, appBarLayout, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onOffsetChange$0(com.up366.mobile.common.helper.AppBarOffsetChangeHelper.IOnOffsetChangeListener iOnOffsetChangeListener, com.google.android.material.appbar.AppBarLayout appBarLayout, int i) {
        float totalScrollRange = ((-i) * 1.0f) / this.appBar.getTotalScrollRange();
        if (this.percent == totalScrollRange || this.appBar.getWidth() <= 0) {
            return;
        }
        this.percent = totalScrollRange;
        iOnOffsetChangeListener.onChange(i, totalScrollRange);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public java.lang.Runnable bind(final android.widget.TextView textView) {
        final float[] fArr = new float[2];
        final com.up366.mobile.common.helper.AppBarOffsetChangeHelper.IOnOffsetChangeListener iOnOffsetChangeListener = new com.up366.mobile.common.helper.AppBarOffsetChangeHelper.IOnOffsetChangeListener() { // from class: com.up366.mobile.common.helper.AppBarOffsetChangeHelper$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.helper.AppBarOffsetChangeHelper.IOnOffsetChangeListener
            public final void onChange(int i, float f) {
                this.f$0.lambda$bind$1(fArr, textView, i, f);
            }
        };
        onOffsetChange(iOnOffsetChangeListener);
        if (textView instanceof com.up366.mobile.common.views.MarqueeTextView) {
            ((com.up366.mobile.common.views.MarqueeTextView) textView).setOnTextChangedListener(new java.lang.Runnable() { // from class: com.up366.mobile.common.helper.AppBarOffsetChangeHelper$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.mobile.common.helper.AppBarOffsetChangeHelper.IOnOffsetChangeListener iOnOffsetChangeListener2 = iOnOffsetChangeListener;
                    float[] fArr2 = fArr;
                    iOnOffsetChangeListener2.onChange((int) fArr2[0], fArr2[1]);
                }
            });
        }
        return new java.lang.Runnable() { // from class: com.up366.mobile.common.helper.AppBarOffsetChangeHelper$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$bind$4(iOnOffsetChangeListener);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bind$1(float[] fArr, android.widget.TextView textView, int i, float f) {
        float width;
        float f2;
        fArr[0] = i;
        fArr[1] = f;
        float dimension = textView.getResources().getDimension(com.up366.mobile.R.dimen.font_size_T3_18);
        float dimension2 = textView.getResources().getDimension(com.up366.mobile.R.dimen.font_size_T1_28);
        android.graphics.Rect rect = new android.graphics.Rect();
        int iMax = 0;
        for (android.view.View view : this.leftViews) {
            view.getGlobalVisibleRect(rect);
            iMax = java.lang.Math.max(iMax, rect.right);
        }
        int width2 = this.appBar.getWidth();
        for (android.view.View view2 : this.rightViews) {
            view2.getGlobalVisibleRect(rect);
            width2 = java.lang.Math.min(width2, rect.left);
        }
        int i2 = ((android.view.ViewGroup.MarginLayoutParams) textView.getLayoutParams()).leftMargin;
        float f3 = width2 - i2;
        textView.getPaint().setTextSize(dimension2 - ((dimension2 - dimension) * f));
        float fMeasureText = textView.getPaint().measureText(textView.getText().toString());
        float f4 = f3 - ((f3 - (width2 - iMax)) * f);
        if (fMeasureText < f4) {
            float f5 = fMeasureText / 2.0f;
            float f6 = width2;
            if ((this.appBar.getWidth() / 2.0f) + f5 < f6) {
                width = ((this.appBar.getWidth() / 2.0f) - f5) - i2;
            } else {
                f2 = ((f6 - fMeasureText) - i2) * f;
                textView.setTranslationX(f2);
                textView.setMaxWidth((int) f4);
            }
        } else {
            width = iMax - i2;
        }
        f2 = width * f;
        textView.setTranslationX(f2);
        textView.setMaxWidth((int) f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bind$4(final com.up366.mobile.common.helper.AppBarOffsetChangeHelper.IOnOffsetChangeListener iOnOffsetChangeListener) {
        this.appBar.post(new java.lang.Runnable() { // from class: com.up366.mobile.common.helper.AppBarOffsetChangeHelper$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                iOnOffsetChangeListener.onChange(0, 1.0f);
            }
        });
    }
}
