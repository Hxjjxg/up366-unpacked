package com.up366.multimediav2.camera;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class Camera2Manager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_PREVIEW_HEIGHT = 1080;
    private static final int MAX_PREVIEW_WIDTH = 2400;
    private static final android.util.SparseIntArray ORIENTATIONS;
    private static final java.lang.String TAG = "Camera2Manager";
    private final android.app.Activity activity;
    private final android.hardware.camera2.CameraManager cameraManager;
    private android.os.Handler mBackgroundHandler;
    private android.os.HandlerThread mBackgroundThread;
    private com.up366.multimediav2.camera.Camera2Manager.Callback mCallback;
    private android.hardware.camera2.CameraDevice mCameraDevice;
    private android.hardware.camera2.CameraCaptureSession mCaptureSession;
    private android.media.ImageReader mImageReader;
    private android.hardware.camera2.CaptureRequest mPreviewRequest;
    private android.hardware.camera2.CaptureRequest.Builder mPreviewRequestBuilder;
    private android.util.Size mPreviewSize;
    private android.view.Surface mPreviewSurface;
    private int mSensorOrientation;
    private com.up366.multimediav2.views.CameraTextureView mTextureView;
    private final java.util.concurrent.Semaphore mCameraOpenCloseLock = new java.util.concurrent.Semaphore(1);
    private java.lang.String mCameraId = java.lang.Integer.toString(0);
    private final android.hardware.camera2.CameraDevice.StateCallback mStateCallback = new android.hardware.camera2.CameraDevice.StateCallback() { // from class: com.up366.multimediav2.camera.Camera2Manager.1
        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(android.hardware.camera2.CameraDevice cameraDevice) {
            com.up366.multimediav2.camera.Camera2Manager.this.mCameraOpenCloseLock.release();
            com.up366.multimediav2.camera.Camera2Manager.this.mCameraDevice = cameraDevice;
            com.up366.common.log.Logger.info("Camera2Manager  onOpened  " + (com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - com.up366.multimediav2.camera.Camera2Manager.this.startTime));
            com.up366.multimediav2.camera.Camera2Manager.this.createCameraPreviewSession();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(android.hardware.camera2.CameraDevice cameraDevice) {
            com.up366.multimediav2.camera.Camera2Manager.this.mCameraOpenCloseLock.release();
            cameraDevice.close();
            com.up366.multimediav2.camera.Camera2Manager.this.mCameraDevice = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(android.hardware.camera2.CameraDevice cameraDevice, int i) {
            com.up366.multimediav2.camera.Camera2Manager.this.mCameraOpenCloseLock.release();
            cameraDevice.close();
            com.up366.multimediav2.camera.Camera2Manager.this.mCameraDevice = null;
            android.util.Log.e(com.up366.multimediav2.camera.Camera2Manager.TAG, "onError: error=" + i);
            com.up366.multimediav2.camera.Camera2Manager.this.stop();
            if (com.up366.multimediav2.camera.Camera2Manager.this.mCallback != null) {
                com.up366.multimediav2.camera.Camera2Manager.this.mCallback.onError(new java.lang.Exception("camera can't open"));
            }
        }
    };
    private final android.view.TextureView.SurfaceTextureListener mSurfaceTextureListener = new android.view.TextureView.SurfaceTextureListener() { // from class: com.up366.multimediav2.camera.Camera2Manager.2
        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            com.up366.common.log.Logger.info("Camera2Manager  onSurfaceTextureAvailable  " + (com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - com.up366.multimediav2.camera.Camera2Manager.this.startTime));
            com.up366.multimediav2.camera.Camera2Manager.this.openCamera(i, i2);
            com.up366.common.log.Logger.info("Camera2Manager  onSurfaceTextureAvailable1  " + (com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - com.up366.multimediav2.camera.Camera2Manager.this.startTime));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            com.up366.multimediav2.camera.Camera2Manager.this.configureTransform(i, i2);
        }
    };
    private final android.media.ImageReader.OnImageAvailableListener mOnImageAvailableListener = new android.media.ImageReader.OnImageAvailableListener() { // from class: com.up366.multimediav2.camera.Camera2Manager.3
        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(android.media.ImageReader imageReader) {
            com.up366.common.log.Logger.info("Camera2Manager take a picture end");
            android.media.Image imageAcquireNextImage = imageReader.acquireNextImage();
            if (com.up366.multimediav2.camera.Camera2Manager.this.mCallback != null) {
                com.up366.multimediav2.camera.Camera2Manager.this.mCallback.obtainImage(imageAcquireNextImage);
            } else {
                imageAcquireNextImage.close();
            }
        }
    };
    private final long startTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();

    public interface Callback {
        void obtainImage(android.media.Image image);

        void onError(java.lang.Exception exc);
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        ORIENTATIONS = sparseIntArray;
        sparseIntArray.append(0, 90);
        sparseIntArray.append(1, 0);
        sparseIntArray.append(2, 270);
        sparseIntArray.append(3, 180);
    }

    public Camera2Manager(android.app.Activity activity, com.up366.multimediav2.views.CameraTextureView cameraTextureView) {
        this.activity = activity;
        this.mTextureView = cameraTextureView;
        this.cameraManager = (android.hardware.camera2.CameraManager) activity.getSystemService("camera");
    }

    public void setCallback(com.up366.multimediav2.camera.Camera2Manager.Callback callback) {
        this.mCallback = callback;
    }

    public void start() {
        com.up366.common.log.Logger.info("Camera2Manager  start  " + (com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - this.startTime));
        startBackgroundThread();
        if (this.mTextureView.isAvailable()) {
            openCamera(this.mTextureView.getWidth(), this.mTextureView.getHeight());
            com.up366.common.log.Logger.info("Camera2Manager  start1   " + (com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - this.startTime));
            return;
        }
        this.mTextureView.setSurfaceTextureListener(this.mSurfaceTextureListener);
    }

    public void stop() {
        com.up366.common.log.Logger.info("Camera2Manager stop");
        closeCamera();
        stopBackgroundThread();
    }

    public void openCamera(int i, int i2) {
        com.up366.common.log.Logger.info("Camera2Manager openCamera width=" + i + "  height=" + i2);
        if (androidx.core.content.ContextCompat.checkSelfPermission(this.activity, com.up366.mobile.common.utils.permissions.Permission.CAMERA) != 0) {
            com.up366.multimediav2.camera.Camera2Manager.Callback callback = this.mCallback;
            if (callback != null) {
                callback.onError(new java.lang.Exception("no camera permission"));
                stop();
                return;
            }
            return;
        }
        setUpCameraOutputs(i, i2);
        configureTransform(i, i2);
        try {
            if (!this.mCameraOpenCloseLock.tryAcquire(2500L, java.util.concurrent.TimeUnit.MILLISECONDS)) {
                throw new java.lang.RuntimeException("Time out waiting to lock camera opening.");
            }
            com.up366.common.log.Logger.info("Camera2Manager  openCamera1 " + (com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - this.startTime));
            this.cameraManager.openCamera(this.mCameraId, this.mStateCallback, this.mBackgroundHandler);
            com.up366.common.log.Logger.info("Camera2Manager  openCamera2 " + (com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - this.startTime));
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("openCamera error " + e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configureTransform(int i, int i2) {
        android.app.Activity activity;
        if (this.mTextureView == null || this.mPreviewSize == null || (activity = this.activity) == null) {
            return;
        }
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        float f = i;
        float f2 = i2;
        android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, f, f2);
        android.graphics.RectF rectF2 = new android.graphics.RectF(0.0f, 0.0f, this.mPreviewSize.getHeight(), this.mPreviewSize.getWidth());
        float fCenterX = rectF.centerX();
        float fCenterY = rectF.centerY();
        if (1 == rotation || 3 == rotation) {
            rectF2.offset(fCenterX - rectF2.centerX(), fCenterY - rectF2.centerY());
            matrix.setRectToRect(rectF, rectF2, android.graphics.Matrix.ScaleToFit.FILL);
            float fMax = java.lang.Math.max(f2 / this.mPreviewSize.getHeight(), f / this.mPreviewSize.getWidth());
            matrix.postScale(fMax, fMax, fCenterX, fCenterY);
            matrix.postRotate((rotation - 2) * 90, fCenterX, fCenterY);
        } else if (2 == rotation) {
            matrix.postRotate(180.0f, fCenterX, fCenterY);
        }
        this.mTextureView.setTransform(matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createCameraPreviewSession() {
        try {
            com.up366.common.log.Logger.info("Camera2Manager  createCameraPreviewSession " + (com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - this.startTime));
            android.graphics.SurfaceTexture surfaceTexture = this.mTextureView.getSurfaceTexture();
            surfaceTexture.setDefaultBufferSize(this.mPreviewSize.getWidth(), this.mPreviewSize.getHeight());
            this.mPreviewSurface = new android.view.Surface(surfaceTexture);
            android.hardware.camera2.CaptureRequest.Builder builderCreateCaptureRequest = this.mCameraDevice.createCaptureRequest(1);
            this.mPreviewRequestBuilder = builderCreateCaptureRequest;
            builderCreateCaptureRequest.addTarget(this.mPreviewSurface);
            this.mCameraDevice.createCaptureSession(java.util.Arrays.asList(this.mPreviewSurface, this.mImageReader.getSurface()), new android.hardware.camera2.CameraCaptureSession.StateCallback() { // from class: com.up366.multimediav2.camera.Camera2Manager.4
                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigured(android.hardware.camera2.CameraCaptureSession cameraCaptureSession) {
                    if (com.up366.multimediav2.camera.Camera2Manager.this.mCameraDevice == null) {
                        return;
                    }
                    com.up366.multimediav2.camera.Camera2Manager.this.mCaptureSession = cameraCaptureSession;
                    try {
                        com.up366.multimediav2.camera.Camera2Manager.this.mPreviewRequestBuilder.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, 4);
                        com.up366.multimediav2.camera.Camera2Manager camera2Manager = com.up366.multimediav2.camera.Camera2Manager.this;
                        camera2Manager.mPreviewRequest = camera2Manager.mPreviewRequestBuilder.build();
                        com.up366.multimediav2.camera.Camera2Manager.this.mCaptureSession.setRepeatingRequest(com.up366.multimediav2.camera.Camera2Manager.this.mPreviewRequest, null, com.up366.multimediav2.camera.Camera2Manager.this.mBackgroundHandler);
                    } catch (java.lang.Exception e) {
                        com.up366.common.log.Logger.error("onConfigured error " + e.getMessage(), e);
                    }
                }

                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigureFailed(android.hardware.camera2.CameraCaptureSession cameraCaptureSession) {
                    if (com.up366.multimediav2.camera.Camera2Manager.this.mCallback != null) {
                        com.up366.multimediav2.camera.Camera2Manager.this.mCallback.onError(new java.lang.Exception("createCaptureSession error"));
                    }
                }
            }, null);
            com.up366.common.log.Logger.info("Camera2Manager  createCameraPreviewSession2 " + (com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - this.startTime));
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("createCameraPreviewSession error " + e.getMessage(), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setUpCameraOutputs(int r6, int r7) {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.multimediav2.camera.Camera2Manager.setUpCameraOutputs(int, int):void");
    }

    boolean cacPreviewSize(int i, int i2) {
        android.util.Log.i(TAG, "cacPreviewSize: " + i + "x" + i2);
        this.mPreviewSize = new android.util.Size(i, i2);
        try {
            float f = i / i2;
            int i3 = 0;
            int i4 = 0;
            for (android.util.Size size : ((android.hardware.camera2.params.StreamConfigurationMap) ((android.hardware.camera2.CameraManager) this.activity.getSystemService("camera")).getCameraCharacteristics(this.mCameraId).get(android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(android.graphics.SurfaceTexture.class)) {
                int width = size.getWidth();
                int height = size.getHeight();
                if (i >= width && i2 >= height && i3 <= width && i4 <= height && java.lang.Math.abs(f - (width / height)) < 0.2d) {
                    i4 = height;
                    i3 = width;
                }
            }
            android.util.Log.i(TAG, "best size: " + i3 + "x" + i4);
            if (i3 != 0 && i4 != 0 && (this.mPreviewSize.getWidth() != i3 || this.mPreviewSize.getHeight() != i4)) {
                this.mPreviewSize = new android.util.Size(i3, i4);
                return true;
            }
            return false;
        } catch (java.lang.Exception e) {
            android.util.Log.e(TAG, "cacPreviewSize -  Exception " + e.getMessage(), e);
            return false;
        }
    }

    private int getOrientation(int i) {
        return ((ORIENTATIONS.get(i) + this.mSensorOrientation) + 270) % 360;
    }

    public void obtainPicture(boolean z) {
        if (this.activity == null || this.mCameraDevice == null || this.mCaptureSession == null) {
            return;
        }
        try {
            com.up366.common.log.Logger.info("Camera2Manager start obtain picture  open light " + z);
            android.hardware.camera2.CaptureRequest.Builder builderCreateCaptureRequest = this.mCameraDevice.createCaptureRequest(2);
            builderCreateCaptureRequest.addTarget(this.mImageReader.getSurface());
            builderCreateCaptureRequest.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, 4);
            if (z) {
                builderCreateCaptureRequest.set(android.hardware.camera2.CaptureRequest.FLASH_MODE, 2);
            }
            builderCreateCaptureRequest.set(android.hardware.camera2.CaptureRequest.JPEG_ORIENTATION, java.lang.Integer.valueOf(getOrientation(this.activity.getWindowManager().getDefaultDisplay().getRotation())));
            this.mCaptureSession.stopRepeating();
            this.mCaptureSession.capture(builderCreateCaptureRequest.build(), new android.hardware.camera2.CameraCaptureSession.CaptureCallback() { // from class: com.up366.multimediav2.camera.Camera2Manager.5
                @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                public void onCaptureCompleted(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
                    try {
                        com.up366.multimediav2.camera.Camera2Manager.this.mCaptureSession.setRepeatingRequest(com.up366.multimediav2.camera.Camera2Manager.this.mPreviewRequest, null, com.up366.multimediav2.camera.Camera2Manager.this.mBackgroundHandler);
                    } catch (java.lang.Exception e) {
                        com.up366.common.log.Logger.error("onCaptureCompleted error " + e.getMessage(), e);
                    }
                }
            }, null);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("obtainPicture error " + e.getMessage(), e);
        }
    }

    private void closeCamera() {
        try {
            try {
                this.mCameraOpenCloseLock.acquire();
                android.hardware.camera2.CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
                if (cameraCaptureSession != null) {
                    cameraCaptureSession.close();
                    this.mCaptureSession = null;
                }
                android.hardware.camera2.CameraDevice cameraDevice = this.mCameraDevice;
                if (cameraDevice != null) {
                    cameraDevice.close();
                    this.mCameraDevice = null;
                }
                android.media.ImageReader imageReader = this.mImageReader;
                if (imageReader != null) {
                    imageReader.close();
                    this.mImageReader = null;
                }
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("Interrupted while trying to lock camera closing." + e.getMessage(), e);
            }
        } finally {
            this.mCameraOpenCloseLock.release();
        }
    }

    private void startBackgroundThread() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("CameraBackground");
        this.mBackgroundThread = handlerThread;
        handlerThread.start();
        this.mBackgroundHandler = new android.os.Handler(this.mBackgroundThread.getLooper());
    }

    private void stopBackgroundThread() {
        if (this.mBackgroundHandler != null) {
            this.mBackgroundThread.quitSafely();
            try {
                android.util.Log.e(TAG, "stopBackgroundThread: " + java.lang.System.currentTimeMillis());
                this.mBackgroundThread.join();
                android.util.Log.e(TAG, "stopBackgroundThread: " + java.lang.System.currentTimeMillis());
                this.mBackgroundThread = null;
                this.mBackgroundHandler = null;
            } catch (java.lang.Exception e) {
                android.util.Log.e(TAG, "stopBackgroundThread: e=" + e.getMessage());
            }
        }
    }

    public void openLight(boolean z) {
        com.up366.common.log.Logger.info("Camera2Manager control open light " + z);
        try {
            if (this.activity != null && this.mCameraDevice != null && this.mCaptureSession != null) {
                if (z) {
                    this.mPreviewRequestBuilder.set(android.hardware.camera2.CaptureRequest.FLASH_MODE, 2);
                } else {
                    this.mPreviewRequestBuilder.set(android.hardware.camera2.CaptureRequest.FLASH_MODE, 0);
                }
                this.mCaptureSession.setRepeatingRequest(this.mPreviewRequestBuilder.build(), null, null);
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("openLight error " + e.getMessage(), e);
        }
    }
}
