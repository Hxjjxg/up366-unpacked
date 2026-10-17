package com.up366.mobile.common.views.rotationmap;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FixedSpeedScroller extends android.widget.Scroller {
    private int mDuration;

    public FixedSpeedScroller(android.content.Context context) {
        super(context);
        this.mDuration = com.up366.medialibrary.camera.CustomCameraView.DEFAULT_MIN_RECORD_VIDEO;
    }

    public FixedSpeedScroller(android.content.Context context, android.view.animation.Interpolator interpolator) {
        super(context, interpolator);
        this.mDuration = com.up366.medialibrary.camera.CustomCameraView.DEFAULT_MIN_RECORD_VIDEO;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.mDuration);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.mDuration);
    }

    public int getmDuration() {
        return this.mDuration;
    }

    public void setmDuration(int i) {
        this.mDuration = i;
    }
}
