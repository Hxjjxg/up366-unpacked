package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class C0064u extends android.widget.VideoView {
    public C0064u(android.content.Context context) {
        super(context);
    }

    @Override // android.widget.VideoView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(android.view.View.getDefaultSize(0, i), android.view.View.getDefaultSize(0, i2));
    }

    @Override // android.widget.VideoView
    public void setOnPreparedListener(android.media.MediaPlayer.OnPreparedListener onPreparedListener) {
        super.setOnPreparedListener(onPreparedListener);
    }
}
