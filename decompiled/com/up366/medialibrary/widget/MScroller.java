package com.up366.medialibrary.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MScroller extends android.widget.Scroller {
    private static final android.view.animation.Interpolator sInterpolator = new android.view.animation.Interpolator() { // from class: com.up366.medialibrary.widget.MScroller$$ExternalSyntheticLambda0
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return com.up366.medialibrary.widget.MScroller.lambda$static$0(f);
        }
    };
    public boolean noDuration;

    static /* synthetic */ float lambda$static$0(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }

    public MScroller(android.content.Context context) {
        this(context, sInterpolator);
    }

    public MScroller(android.content.Context context, android.view.animation.Interpolator interpolator) {
        super(context, interpolator);
    }

    public void setNoDuration(boolean z) {
        this.noDuration = z;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        if (this.noDuration) {
            super.startScroll(i, i2, i3, i4, 0);
        } else {
            super.startScroll(i, i2, i3, i4, i5);
        }
    }
}
