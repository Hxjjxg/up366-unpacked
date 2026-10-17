package com.up366.qrcode.view.camera;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class AutoFocusCallback implements android.hardware.Camera.AutoFocusCallback {
    private static final long AUTOFOCUS_INTERVAL_MS = 1500;
    private static final java.lang.String TAG = "AutoFocusCallback";
    private android.os.Handler autoFocusHandler;
    private int autoFocusMessage;

    public void setHandler(android.os.Handler handler, int i) {
        this.autoFocusHandler = handler;
        this.autoFocusMessage = i;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z, android.hardware.Camera camera) {
        android.os.Handler handler = this.autoFocusHandler;
        if (handler != null) {
            this.autoFocusHandler.sendMessageDelayed(handler.obtainMessage(this.autoFocusMessage, java.lang.Boolean.valueOf(z)), 1500L);
            this.autoFocusHandler = null;
            return;
        }
        android.util.Log.d(TAG, "Got auto-focus callback, but no handler for it");
    }
}
