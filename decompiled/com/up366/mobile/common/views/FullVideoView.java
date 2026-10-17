package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FullVideoView extends android.widget.VideoView {
    public FullVideoView(android.content.Context context) {
        super(context);
    }

    public FullVideoView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FullVideoView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        android.view.WindowManager windowManager = (android.view.WindowManager) getContext().getSystemService("window");
        setMeasuredDimension(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
    }
}
