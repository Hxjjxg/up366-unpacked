package com.up366.qrcode.view.camera;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class CameraManager {
    public static int FRAME_HEIGHT = -1;
    public static int FRAME_MARGINTOP = -1;
    public static int FRAME_WIDTH = -1;
    static final int SDK_INT;
    private static final java.lang.String TAG = "CameraManager";
    private static com.up366.qrcode.view.camera.CameraManager cameraManager;
    private final com.up366.qrcode.view.camera.AutoFocusCallback autoFocusCallback;
    private android.hardware.Camera camera;
    private final com.up366.qrcode.view.camera.CameraConfigurationManager configManager;
    private final android.content.Context context;
    private android.graphics.Rect framingRect;
    private android.graphics.Rect framingRectInPreview;
    private boolean initialized;
    private final com.up366.qrcode.view.camera.PreviewCallback previewCallback;
    private boolean previewing;
    private final boolean useOneShotPreviewCallback;

    static {
        int i;
        try {
            i = java.lang.Integer.parseInt(android.os.Build.VERSION.SDK);
        } catch (java.lang.NumberFormatException unused) {
            i = 10000;
        }
        SDK_INT = i;
    }

    public static void init(android.content.Context context) {
        if (cameraManager == null) {
            cameraManager = new com.up366.qrcode.view.camera.CameraManager(context);
        }
    }

    public static com.up366.qrcode.view.camera.CameraManager get() {
        return cameraManager;
    }

    private CameraManager(android.content.Context context) {
        this.context = context;
        com.up366.qrcode.view.camera.CameraConfigurationManager cameraConfigurationManager = new com.up366.qrcode.view.camera.CameraConfigurationManager(context);
        this.configManager = cameraConfigurationManager;
        boolean z = java.lang.Integer.parseInt(android.os.Build.VERSION.SDK) > 3;
        this.useOneShotPreviewCallback = z;
        this.previewCallback = new com.up366.qrcode.view.camera.PreviewCallback(cameraConfigurationManager, z);
        this.autoFocusCallback = new com.up366.qrcode.view.camera.AutoFocusCallback();
    }

    public void openDriver(android.view.SurfaceHolder surfaceHolder) throws java.io.IOException {
        if (this.camera == null) {
            android.hardware.Camera cameraOpen = android.hardware.Camera.open();
            this.camera = cameraOpen;
            if (cameraOpen == null) {
                throw new java.io.IOException();
            }
            cameraOpen.setPreviewDisplay(surfaceHolder);
            if (!this.initialized) {
                this.initialized = true;
                this.configManager.initFromCameraParameters(this.camera);
            }
            this.configManager.setDesiredCameraParameters(this.camera);
            com.up366.qrcode.view.camera.FlashlightManager.enableFlashlight();
        }
    }

    public void closeDriver() {
        if (this.camera != null) {
            com.up366.qrcode.view.camera.FlashlightManager.disableFlashlight();
            this.camera.release();
            this.camera = null;
        }
    }

    public void startPreview() {
        android.hardware.Camera camera = this.camera;
        if (camera == null || this.previewing) {
            return;
        }
        camera.startPreview();
        this.previewing = true;
    }

    public void stopPreview() {
        android.hardware.Camera camera = this.camera;
        if (camera == null || !this.previewing) {
            return;
        }
        if (!this.useOneShotPreviewCallback) {
            camera.setPreviewCallback(null);
        }
        this.camera.stopPreview();
        this.previewCallback.setHandler(null, 0);
        this.autoFocusCallback.setHandler(null, 0);
        this.previewing = false;
    }

    public void requestPreviewFrame(android.os.Handler handler, int i) {
        if (this.camera == null || !this.previewing) {
            return;
        }
        this.previewCallback.setHandler(handler, i);
        if (this.useOneShotPreviewCallback) {
            this.camera.setOneShotPreviewCallback(this.previewCallback);
        } else {
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    public void requestAutoFocus(android.os.Handler handler, int i) {
        if (this.camera == null || !this.previewing) {
            return;
        }
        this.autoFocusCallback.setHandler(handler, i);
        this.camera.autoFocus(this.autoFocusCallback);
    }

    public android.graphics.Rect getFramingRect() {
        try {
            android.graphics.Point screenResolution = this.configManager.getScreenResolution();
            if (this.camera == null) {
                return null;
            }
            int i = (screenResolution.x - FRAME_WIDTH) / 2;
            int i2 = FRAME_MARGINTOP;
            if (i2 == -1) {
                i2 = (screenResolution.y - FRAME_HEIGHT) / 2;
            }
            android.graphics.Rect rect = new android.graphics.Rect(i, i2, FRAME_WIDTH + i, FRAME_HEIGHT + i2);
            this.framingRect = rect;
            return rect;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public android.graphics.Rect getFramingRectInPreview() {
        if (this.framingRectInPreview == null) {
            android.graphics.Rect rect = new android.graphics.Rect(getFramingRect());
            android.graphics.Point cameraResolution = this.configManager.getCameraResolution();
            android.graphics.Point screenResolution = this.configManager.getScreenResolution();
            rect.left = (rect.left * cameraResolution.y) / screenResolution.x;
            rect.right = (rect.right * cameraResolution.y) / screenResolution.x;
            rect.top = (rect.top * cameraResolution.x) / screenResolution.y;
            rect.bottom = (rect.bottom * cameraResolution.x) / screenResolution.y;
            this.framingRectInPreview = rect;
        }
        return this.framingRectInPreview;
    }

    public com.up366.qrcode.view.camera.PlanarYUVLuminanceSource buildLuminanceSource(byte[] bArr, int i, int i2) {
        android.graphics.Rect framingRectInPreview = getFramingRectInPreview();
        int previewFormat = this.configManager.getPreviewFormat();
        java.lang.String previewFormatString = this.configManager.getPreviewFormatString();
        if (previewFormat == 16 || previewFormat == 17) {
            if ((framingRectInPreview.left - 100) + framingRectInPreview.width() + 200 < i && (framingRectInPreview.top - 100) + framingRectInPreview.height() < i2) {
                return new com.up366.qrcode.view.camera.PlanarYUVLuminanceSource(bArr, i, i2, framingRectInPreview.left - 100, framingRectInPreview.top - 100, framingRectInPreview.width() + 200, framingRectInPreview.height() + 200);
            }
            return new com.up366.qrcode.view.camera.PlanarYUVLuminanceSource(bArr, i, i2, framingRectInPreview.left, framingRectInPreview.top, framingRectInPreview.width(), framingRectInPreview.height());
        }
        if ("yuv420p".equals(previewFormatString)) {
            if ((framingRectInPreview.left - 100) + framingRectInPreview.width() + 200 < i && (framingRectInPreview.top - 100) + framingRectInPreview.height() < i2) {
                return new com.up366.qrcode.view.camera.PlanarYUVLuminanceSource(bArr, i, i2, framingRectInPreview.left - 100, framingRectInPreview.top - 100, framingRectInPreview.width() + 200, framingRectInPreview.height() + 200);
            }
            return new com.up366.qrcode.view.camera.PlanarYUVLuminanceSource(bArr, i, i2, framingRectInPreview.left, framingRectInPreview.top, framingRectInPreview.width(), framingRectInPreview.height());
        }
        throw new java.lang.IllegalArgumentException("Unsupported picture format: " + previewFormat + '/' + previewFormatString);
    }

    public android.content.Context getContext() {
        return this.context;
    }

    public android.hardware.Camera getCamera() {
        return this.camera;
    }

    public boolean isPreviewing() {
        return this.previewing;
    }

    public boolean isUseOneShotPreviewCallback() {
        return this.useOneShotPreviewCallback;
    }

    public com.up366.qrcode.view.camera.PreviewCallback getPreviewCallback() {
        return this.previewCallback;
    }

    public com.up366.qrcode.view.camera.AutoFocusCallback getAutoFocusCallback() {
        return this.autoFocusCallback;
    }

    public void setPreviewing(boolean z) {
        this.previewing = z;
    }
}
