package com.up366.qrcode.view.camera;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class PreviewCallback implements android.hardware.Camera.PreviewCallback {
    private static final java.lang.String TAG = "PreviewCallback";
    private final com.up366.qrcode.view.camera.CameraConfigurationManager configManager;
    private android.os.Handler previewHandler;
    private int previewMessage;
    private final boolean useOneShotPreviewCallback;

    PreviewCallback(com.up366.qrcode.view.camera.CameraConfigurationManager cameraConfigurationManager, boolean z) {
        this.configManager = cameraConfigurationManager;
        this.useOneShotPreviewCallback = z;
    }

    public void setHandler(android.os.Handler handler, int i) {
        this.previewHandler = handler;
        this.previewMessage = i;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, android.hardware.Camera camera) {
        android.graphics.Point cameraResolution = this.configManager.getCameraResolution();
        if (!this.useOneShotPreviewCallback) {
            camera.setPreviewCallback(null);
        }
        android.os.Handler handler = this.previewHandler;
        if (handler != null) {
            handler.obtainMessage(this.previewMessage, cameraResolution.x, cameraResolution.y, bArr).sendToTarget();
            this.previewHandler = null;
        } else {
            android.util.Log.d(TAG, "Got preview callback, but no handler for it");
        }
    }
}
