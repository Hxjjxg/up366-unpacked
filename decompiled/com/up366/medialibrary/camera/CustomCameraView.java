package com.up366.medialibrary.camera;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CustomCameraView extends android.widget.RelativeLayout {
    public static final int DEFAULT_MIN_RECORD_VIDEO = 1500;
    private static final int TYPE_FLASH_AUTO = 33;
    private static final int TYPE_FLASH_OFF = 35;
    private static final int TYPE_FLASH_ON = 34;
    private int lensFacing;
    private com.up366.medialibrary.camera.listener.CameraListener mCameraListener;
    private androidx.camera.view.PreviewView mCameraPreviewView;
    private androidx.camera.lifecycle.ProcessCameraProvider mCameraProvider;
    private com.up366.medialibrary.camera.view.CaptureLayout mCaptureLayout;
    private com.up366.medialibrary.config.PictureSelectionConfig mConfig;
    private android.widget.ImageView mFlashLamp;
    private com.up366.medialibrary.camera.listener.ImageCallbackListener mImageCallbackListener;
    private androidx.camera.core.ImageCapture mImageCapture;
    private android.widget.ImageView mImagePreview;
    private android.media.MediaPlayer mMediaPlayer;
    private com.up366.medialibrary.camera.listener.ClickListener mOnClickListener;
    private android.widget.ImageView mSwitchCamera;
    private android.view.TextureView mTextureView;
    private androidx.camera.core.VideoCapture mVideoCapture;
    private long recordTime;
    private final android.view.TextureView.SurfaceTextureListener surfaceTextureListener;
    private int type_flash;
    private int useCameraCases;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isImageCaptureEnabled() {
        return this.useCameraCases == 1;
    }

    public CustomCameraView(android.content.Context context) {
        super(context);
        this.type_flash = 35;
        this.useCameraCases = 1;
        this.lensFacing = 1;
        this.recordTime = 0L;
        this.surfaceTextureListener = new android.view.TextureView.SurfaceTextureListener() { // from class: com.up366.medialibrary.camera.CustomCameraView.6
            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
                com.up366.medialibrary.camera.CustomCameraView customCameraView = com.up366.medialibrary.camera.CustomCameraView.this;
                customCameraView.startVideoPlay(customCameraView.mConfig.cameraPath);
            }
        };
        initView();
    }

    public CustomCameraView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type_flash = 35;
        this.useCameraCases = 1;
        this.lensFacing = 1;
        this.recordTime = 0L;
        this.surfaceTextureListener = new android.view.TextureView.SurfaceTextureListener() { // from class: com.up366.medialibrary.camera.CustomCameraView.6
            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
                com.up366.medialibrary.camera.CustomCameraView customCameraView = com.up366.medialibrary.camera.CustomCameraView.this;
                customCameraView.startVideoPlay(customCameraView.mConfig.cameraPath);
            }
        };
        initView();
    }

    public CustomCameraView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type_flash = 35;
        this.useCameraCases = 1;
        this.lensFacing = 1;
        this.recordTime = 0L;
        this.surfaceTextureListener = new android.view.TextureView.SurfaceTextureListener() { // from class: com.up366.medialibrary.camera.CustomCameraView.6
            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i2, int i22) {
                com.up366.medialibrary.camera.CustomCameraView customCameraView = com.up366.medialibrary.camera.CustomCameraView.this;
                customCameraView.startVideoPlay(customCameraView.mConfig.cameraPath);
            }
        };
        initView();
    }

    private void initView() {
        inflate(getContext(), com.up366.medialibrary.R.layout.picture_camera_view, this);
        setBackgroundColor(androidx.core.content.ContextCompat.getColor(getContext(), com.up366.medialibrary.R.color.picture_color_black));
        this.mCameraPreviewView = findViewById(com.up366.medialibrary.R.id.cameraPreviewView);
        this.mTextureView = (android.view.TextureView) findViewById(com.up366.medialibrary.R.id.video_play_preview);
        this.mImagePreview = (android.widget.ImageView) findViewById(com.up366.medialibrary.R.id.image_preview);
        this.mSwitchCamera = (android.widget.ImageView) findViewById(com.up366.medialibrary.R.id.image_switch);
        this.mFlashLamp = (android.widget.ImageView) findViewById(com.up366.medialibrary.R.id.image_flash);
        this.mCaptureLayout = (com.up366.medialibrary.camera.view.CaptureLayout) findViewById(com.up366.medialibrary.R.id.capture_layout);
        this.mSwitchCamera.setImageResource(com.up366.medialibrary.R.drawable.picture_ic_camera);
        this.mFlashLamp.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.camera.CustomCameraView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m165lambda$initView$0$comup366medialibrarycameraCustomCameraView(view);
            }
        });
        this.mCaptureLayout.setDuration(15000);
        this.mSwitchCamera.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.camera.CustomCameraView.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.up366.medialibrary.camera.CustomCameraView.this.toggleCamera();
            }
        });
        this.mCaptureLayout.setCaptureListener(new com.up366.medialibrary.camera.listener.CaptureListener() { // from class: com.up366.medialibrary.camera.CustomCameraView.2
            @Override // com.up366.medialibrary.camera.listener.CaptureListener
            public void recordZoom(float f) {
            }

            @Override // com.up366.medialibrary.camera.listener.CaptureListener
            public void takePictures() {
                java.lang.String strRename;
                androidx.camera.core.ImageCapture.OutputFileOptions outputFileOptionsBuild;
                if (!com.up366.medialibrary.camera.CustomCameraView.this.mCameraProvider.isBound(com.up366.medialibrary.camera.CustomCameraView.this.mImageCapture)) {
                    com.up366.medialibrary.camera.CustomCameraView.this.bindCameraImageUseCases();
                }
                com.up366.medialibrary.camera.CustomCameraView.this.useCameraCases = 1;
                com.up366.medialibrary.camera.CustomCameraView.this.mCaptureLayout.setButtonCaptureEnabled(false);
                com.up366.medialibrary.camera.CustomCameraView.this.mSwitchCamera.setVisibility(4);
                com.up366.medialibrary.camera.CustomCameraView.this.mFlashLamp.setVisibility(4);
                if (!android.text.TextUtils.isEmpty(com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraFileName)) {
                    boolean zIsSuffixOfImage = com.up366.medialibrary.common.utils.MimeTypeUtils.isSuffixOfImage(com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraFileName);
                    com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraFileName = !zIsSuffixOfImage ? com.up366.medialibrary.common.utils.StringUtils.renameSuffix(com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraFileName, com.up366.medialibrary.common.utils.MimeTypeUtils.JPG) : com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraFileName;
                    strRename = com.up366.medialibrary.camera.CustomCameraView.this.mConfig.camera ? com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraFileName : com.up366.medialibrary.common.utils.StringUtils.rename(com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraFileName);
                } else {
                    strRename = "";
                }
                if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() && android.text.TextUtils.isEmpty(com.up366.medialibrary.camera.CustomCameraView.this.mConfig.outPutCameraPath)) {
                    outputFileOptionsBuild = new androidx.camera.core.ImageCapture.OutputFileOptions.Builder(com.up366.medialibrary.camera.CustomCameraView.this.getContext().getContentResolver(), android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, com.up366.medialibrary.common.utils.CameraFileUtils.buildImageContentValues(strRename, com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraImageFormatForQ)).build();
                } else {
                    outputFileOptionsBuild = new androidx.camera.core.ImageCapture.OutputFileOptions.Builder(com.up366.medialibrary.common.utils.PictureFileUtils.createCameraFile(com.up366.medialibrary.camera.CustomCameraView.this.getContext(), 1, strRename, com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraImageFormat, com.up366.medialibrary.camera.CustomCameraView.this.mConfig.outPutCameraPath)).build();
                }
                com.up366.medialibrary.camera.CustomCameraView.this.mImageCapture.takePicture(outputFileOptionsBuild, androidx.core.content.ContextCompat.getMainExecutor(com.up366.medialibrary.camera.CustomCameraView.this.getContext()), new com.up366.medialibrary.camera.CustomCameraView.MyImageResultCallback(com.up366.medialibrary.camera.CustomCameraView.this.mImagePreview, com.up366.medialibrary.camera.CustomCameraView.this.mCaptureLayout, com.up366.medialibrary.camera.CustomCameraView.this.mImageCallbackListener, com.up366.medialibrary.camera.CustomCameraView.this.mCameraListener, com.up366.medialibrary.camera.CustomCameraView.this.mConfig));
            }

            @Override // com.up366.medialibrary.camera.listener.CaptureListener
            public void recordStart() {
                java.lang.String strRename;
                androidx.camera.core.VideoCapture.OutputFileOptions outputFileOptionsBuild;
                if (!com.up366.medialibrary.camera.CustomCameraView.this.mCameraProvider.isBound(com.up366.medialibrary.camera.CustomCameraView.this.mVideoCapture)) {
                    com.up366.medialibrary.camera.CustomCameraView.this.bindCameraVideoUseCases();
                }
                com.up366.medialibrary.camera.CustomCameraView.this.useCameraCases = 4;
                com.up366.medialibrary.camera.CustomCameraView.this.mSwitchCamera.setVisibility(4);
                com.up366.medialibrary.camera.CustomCameraView.this.mFlashLamp.setVisibility(4);
                if (!android.text.TextUtils.isEmpty(com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraFileName)) {
                    boolean zIsSuffixOfImage = com.up366.medialibrary.common.utils.MimeTypeUtils.isSuffixOfImage(com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraFileName);
                    com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraFileName = zIsSuffixOfImage ? com.up366.medialibrary.common.utils.StringUtils.renameSuffix(com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraFileName, ".mp4") : com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraFileName;
                    strRename = com.up366.medialibrary.camera.CustomCameraView.this.mConfig.camera ? com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraFileName : com.up366.medialibrary.common.utils.StringUtils.rename(com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraFileName);
                } else {
                    strRename = "";
                }
                if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() && android.text.TextUtils.isEmpty(com.up366.medialibrary.camera.CustomCameraView.this.mConfig.outPutCameraPath)) {
                    outputFileOptionsBuild = new androidx.camera.core.VideoCapture.OutputFileOptions.Builder(com.up366.medialibrary.camera.CustomCameraView.this.getContext().getContentResolver(), android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI, com.up366.medialibrary.common.utils.CameraFileUtils.buildVideoContentValues(strRename, com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraImageFormatForQ)).build();
                } else {
                    outputFileOptionsBuild = new androidx.camera.core.VideoCapture.OutputFileOptions.Builder(com.up366.medialibrary.common.utils.PictureFileUtils.createCameraFile(com.up366.medialibrary.camera.CustomCameraView.this.getContext(), 2, strRename, com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraVideoFormat, com.up366.medialibrary.camera.CustomCameraView.this.mConfig.outPutCameraPath)).build();
                }
                com.up366.medialibrary.camera.CustomCameraView.this.mVideoCapture.startRecording(outputFileOptionsBuild, androidx.core.content.ContextCompat.getMainExecutor(com.up366.medialibrary.camera.CustomCameraView.this.getContext()), new androidx.camera.core.VideoCapture.OnVideoSavedCallback() { // from class: com.up366.medialibrary.camera.CustomCameraView.2.1
                    public void onVideoSaved(androidx.camera.core.VideoCapture.OutputFileResults outputFileResults) {
                        if (com.up366.medialibrary.camera.CustomCameraView.this.recordTime < (com.up366.medialibrary.camera.CustomCameraView.this.mConfig.recordVideoMinSecond <= 0 ? 1500L : ((long) com.up366.medialibrary.camera.CustomCameraView.this.mConfig.recordVideoMinSecond) * 1000) || outputFileResults.getSavedUri() == null) {
                            return;
                        }
                        android.net.Uri savedUri = outputFileResults.getSavedUri();
                        java.lang.String string = savedUri.toString();
                        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = com.up366.medialibrary.camera.CustomCameraView.this.mConfig;
                        if (!com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(string)) {
                            string = savedUri.getPath();
                        }
                        pictureSelectionConfig.cameraPath = string;
                        com.up366.medialibrary.camera.CustomCameraView.this.mTextureView.setVisibility(0);
                        com.up366.medialibrary.camera.CustomCameraView.this.mCameraPreviewView.setVisibility(4);
                        if (com.up366.medialibrary.camera.CustomCameraView.this.mTextureView.isAvailable()) {
                            com.up366.medialibrary.camera.CustomCameraView.this.startVideoPlay(com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraPath);
                        } else {
                            com.up366.medialibrary.camera.CustomCameraView.this.mTextureView.setSurfaceTextureListener(com.up366.medialibrary.camera.CustomCameraView.this.surfaceTextureListener);
                        }
                    }

                    public void onError(int i, java.lang.String str, java.lang.Throwable th) {
                        if (com.up366.medialibrary.camera.CustomCameraView.this.mCameraListener != null) {
                            com.up366.medialibrary.camera.CustomCameraView.this.mCameraListener.onError(i, str, th);
                        }
                    }
                });
            }

            @Override // com.up366.medialibrary.camera.listener.CaptureListener
            public void recordShort(long j) {
                com.up366.medialibrary.camera.CustomCameraView.this.recordTime = j;
                com.up366.medialibrary.camera.CustomCameraView.this.mSwitchCamera.setVisibility(0);
                com.up366.medialibrary.camera.CustomCameraView.this.mFlashLamp.setVisibility(0);
                com.up366.medialibrary.camera.CustomCameraView.this.mCaptureLayout.resetCaptureLayout();
                com.up366.medialibrary.camera.CustomCameraView.this.mCaptureLayout.setTextWithAnimation(com.up366.medialibrary.camera.CustomCameraView.this.getContext().getString(com.up366.medialibrary.R.string.picture_recording_time_is_short));
                com.up366.medialibrary.camera.CustomCameraView.this.mVideoCapture.stopRecording();
            }

            @Override // com.up366.medialibrary.camera.listener.CaptureListener
            public void recordEnd(long j) {
                com.up366.medialibrary.camera.CustomCameraView.this.recordTime = j;
                com.up366.medialibrary.camera.CustomCameraView.this.mVideoCapture.stopRecording();
            }

            @Override // com.up366.medialibrary.camera.listener.CaptureListener
            public void recordError() {
                if (com.up366.medialibrary.camera.CustomCameraView.this.mCameraListener != null) {
                    com.up366.medialibrary.camera.CustomCameraView.this.mCameraListener.onError(0, "An unknown error", null);
                }
            }
        });
        this.mCaptureLayout.setTypeListener(new com.up366.medialibrary.camera.listener.TypeListener() { // from class: com.up366.medialibrary.camera.CustomCameraView.3
            @Override // com.up366.medialibrary.camera.listener.TypeListener
            public void cancel() {
                com.up366.medialibrary.camera.CustomCameraView.this.onCancelMedia();
            }

            @Override // com.up366.medialibrary.camera.listener.TypeListener
            public void confirm() {
                if (com.up366.medialibrary.camera.CustomCameraView.this.isImageCaptureEnabled()) {
                    com.up366.medialibrary.camera.CustomCameraView.this.mImagePreview.setVisibility(4);
                    if (com.up366.medialibrary.camera.CustomCameraView.this.mCameraListener != null) {
                        com.up366.medialibrary.camera.CustomCameraView.this.mCameraListener.onPictureSuccess(com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraPath);
                        return;
                    }
                    return;
                }
                com.up366.medialibrary.camera.CustomCameraView.this.stopVideoPlay();
                if (com.up366.medialibrary.camera.CustomCameraView.this.mCameraListener != null) {
                    com.up366.medialibrary.camera.CustomCameraView.this.mCameraListener.onRecordSuccess(com.up366.medialibrary.camera.CustomCameraView.this.mConfig.cameraPath);
                }
            }
        });
        this.mCaptureLayout.setLeftClickListener(new com.up366.medialibrary.camera.listener.ClickListener() { // from class: com.up366.medialibrary.camera.CustomCameraView.4
            @Override // com.up366.medialibrary.camera.listener.ClickListener
            public void onClick() {
                if (com.up366.medialibrary.camera.CustomCameraView.this.mOnClickListener != null) {
                    com.up366.medialibrary.camera.CustomCameraView.this.mOnClickListener.onClick();
                }
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initView$0$com-up366-medialibrary-camera-CustomCameraView, reason: not valid java name */
    /* synthetic */ void m165lambda$initView$0$comup366medialibrarycameraCustomCameraView(android.view.View view) {
        int i = this.type_flash + 1;
        this.type_flash = i;
        if (i > 35) {
            this.type_flash = 33;
        }
        setFlashMode();
    }

    public void initCamera() {
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = com.up366.medialibrary.config.PictureSelectionConfig.getInstance();
        this.mConfig = pictureSelectionConfig;
        this.lensFacing = !pictureSelectionConfig.isCameraAroundState ? 1 : 0;
        if (androidx.core.app.ActivityCompat.checkSelfPermission(getContext(), com.up366.mobile.common.utils.permissions.Permission.CAMERA) == 0) {
            final com.google.common.util.concurrent.ListenableFuture processCameraProvider = androidx.camera.lifecycle.ProcessCameraProvider.getInstance(getContext());
            processCameraProvider.addListener(new java.lang.Runnable() { // from class: com.up366.medialibrary.camera.CustomCameraView.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.up366.medialibrary.camera.CustomCameraView.this.mCameraProvider = (androidx.camera.lifecycle.ProcessCameraProvider) processCameraProvider.get();
                        com.up366.medialibrary.camera.CustomCameraView.this.bindCameraUseCases();
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }, androidx.core.content.ContextCompat.getMainExecutor(getContext()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindCameraUseCases() {
        if (this.mConfig.buttonFeatures == 259 || this.mConfig.buttonFeatures == 257) {
            bindCameraImageUseCases();
        } else {
            bindCameraVideoUseCases();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindCameraImageUseCases() {
        try {
            int iAspectRatio = aspectRatio(com.up366.medialibrary.common.utils.ScreenUtils.getScreenWidth(getContext()), com.up366.medialibrary.common.utils.ScreenUtils.getScreenHeight(getContext()));
            androidx.camera.core.CameraSelector cameraSelectorBuild = new androidx.camera.core.CameraSelector.Builder().requireLensFacing(this.lensFacing).build();
            androidx.camera.core.UseCase useCaseBuild = new androidx.camera.core.Preview.Builder().setTargetAspectRatio(iAspectRatio).build();
            this.mImageCapture = new androidx.camera.core.ImageCapture.Builder().setCaptureMode(1).setTargetAspectRatio(iAspectRatio).build();
            androidx.camera.core.UseCase useCaseBuild2 = new androidx.camera.core.ImageAnalysis.Builder().setTargetAspectRatio(iAspectRatio).build();
            this.mCameraProvider.unbindAll();
            this.mCameraProvider.bindToLifecycle(getContext(), cameraSelectorBuild, new androidx.camera.core.UseCase[]{useCaseBuild, this.mImageCapture, useCaseBuild2});
            useCaseBuild.setSurfaceProvider(this.mCameraPreviewView.getSurfaceProvider());
            setFlashMode();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindCameraVideoUseCases() {
        try {
            androidx.camera.core.CameraSelector cameraSelectorBuild = new androidx.camera.core.CameraSelector.Builder().requireLensFacing(this.lensFacing).build();
            androidx.camera.core.UseCase useCaseBuild = new androidx.camera.core.Preview.Builder().build();
            this.mVideoCapture = new androidx.camera.core.VideoCapture.Builder().build();
            this.mCameraProvider.unbindAll();
            this.mCameraProvider.bindToLifecycle(getContext(), cameraSelectorBuild, new androidx.camera.core.UseCase[]{useCaseBuild, this.mVideoCapture});
            useCaseBuild.setSurfaceProvider(this.mCameraPreviewView.getSurfaceProvider());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private int aspectRatio(int i, int i2) {
        double dMax = java.lang.Math.max(i, i2) / java.lang.Math.min(i, i2);
        return java.lang.Math.abs(dMax - 1.3333333333333333d) <= java.lang.Math.abs(dMax - 1.7777777777777777d) ? 0 : 1;
    }

    private static class MyImageResultCallback implements androidx.camera.core.ImageCapture.OnImageSavedCallback {
        private final java.lang.ref.WeakReference<com.up366.medialibrary.camera.listener.CameraListener> mCameraListenerReference;
        private final java.lang.ref.WeakReference<com.up366.medialibrary.camera.view.CaptureLayout> mCaptureLayoutReference;
        private final java.lang.ref.WeakReference<com.up366.medialibrary.config.PictureSelectionConfig> mConfigReference;
        private final java.lang.ref.WeakReference<com.up366.medialibrary.camera.listener.ImageCallbackListener> mImageCallbackListenerReference;
        private final java.lang.ref.WeakReference<android.widget.ImageView> mImagePreviewReference;

        public /* synthetic */ void onCaptureProcessProgressed(int i) {
            androidx.camera.core.ImageCapture.OnImageSavedCallback.-CC.$default$onCaptureProcessProgressed(this, i);
        }

        public /* synthetic */ void onCaptureStarted() {
            androidx.camera.core.ImageCapture.OnImageSavedCallback.-CC.$default$onCaptureStarted(this);
        }

        public /* synthetic */ void onPostviewBitmapAvailable(android.graphics.Bitmap bitmap) {
            androidx.camera.core.ImageCapture.OnImageSavedCallback.-CC.$default$onPostviewBitmapAvailable(this, bitmap);
        }

        public MyImageResultCallback(android.widget.ImageView imageView, com.up366.medialibrary.camera.view.CaptureLayout captureLayout, com.up366.medialibrary.camera.listener.ImageCallbackListener imageCallbackListener, com.up366.medialibrary.camera.listener.CameraListener cameraListener, com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig) {
            this.mImagePreviewReference = new java.lang.ref.WeakReference<>(imageView);
            this.mCaptureLayoutReference = new java.lang.ref.WeakReference<>(captureLayout);
            this.mImageCallbackListenerReference = new java.lang.ref.WeakReference<>(imageCallbackListener);
            this.mCameraListenerReference = new java.lang.ref.WeakReference<>(cameraListener);
            this.mConfigReference = new java.lang.ref.WeakReference<>(pictureSelectionConfig);
        }

        public void onImageSaved(androidx.camera.core.ImageCapture.OutputFileResults outputFileResults) {
            if (outputFileResults.getSavedUri() == null) {
                return;
            }
            android.net.Uri savedUri = outputFileResults.getSavedUri();
            java.lang.String string = savedUri.toString();
            if (this.mConfigReference.get() != null) {
                this.mConfigReference.get().cameraPath = com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(string) ? string : savedUri.getPath();
            }
            if (this.mCaptureLayoutReference.get() != null) {
                this.mCaptureLayoutReference.get().setButtonCaptureEnabled(true);
            }
            if (this.mImageCallbackListenerReference.get() != null && this.mImagePreviewReference.get() != null) {
                this.mImageCallbackListenerReference.get().onLoadImage(string, this.mImagePreviewReference.get());
            }
            if (this.mImagePreviewReference.get() != null) {
                this.mImagePreviewReference.get().setVisibility(0);
            }
            if (this.mCaptureLayoutReference.get() != null) {
                this.mCaptureLayoutReference.get().startTypeBtnAnimator();
            }
        }

        public void onError(androidx.camera.core.ImageCaptureException imageCaptureException) {
            if (this.mCaptureLayoutReference.get() != null) {
                this.mCaptureLayoutReference.get().setButtonCaptureEnabled(true);
            }
            if (this.mCameraListenerReference.get() != null) {
                this.mCameraListenerReference.get().onError(imageCaptureException.getImageCaptureError(), imageCaptureException.getMessage(), imageCaptureException.getCause());
            }
        }
    }

    public void setCameraListener(com.up366.medialibrary.camera.listener.CameraListener cameraListener) {
        this.mCameraListener = cameraListener;
    }

    public void setRecordVideoMaxTime(int i) {
        this.mCaptureLayout.setDuration(i * 1000);
    }

    public void setRecordVideoMinTime(int i) {
        this.mCaptureLayout.setMinDuration(i * 1000);
    }

    public void setCaptureLoadingColor(int i) {
        this.mCaptureLayout.setCaptureLoadingColor(i);
    }

    public void toggleCamera() {
        this.lensFacing = this.lensFacing == 0 ? 1 : 0;
        bindCameraUseCases();
    }

    private void setFlashMode() {
        if (this.mImageCapture == null) {
        }
        switch (this.type_flash) {
            case 33:
                this.mFlashLamp.setImageResource(com.up366.medialibrary.R.drawable.picture_ic_flash_auto);
                this.mImageCapture.setFlashMode(0);
                break;
            case 34:
                this.mFlashLamp.setImageResource(com.up366.medialibrary.R.drawable.picture_ic_flash_on);
                this.mImageCapture.setFlashMode(1);
                break;
            case 35:
                this.mFlashLamp.setImageResource(com.up366.medialibrary.R.drawable.picture_ic_flash_off);
                this.mImageCapture.setFlashMode(2);
                break;
        }
    }

    public void setOnClickListener(com.up366.medialibrary.camera.listener.ClickListener clickListener) {
        this.mOnClickListener = clickListener;
    }

    public void setImageCallbackListener(com.up366.medialibrary.camera.listener.ImageCallbackListener imageCallbackListener) {
        this.mImageCallbackListener = imageCallbackListener;
    }

    public com.up366.medialibrary.camera.view.CaptureLayout getCaptureLayout() {
        return this.mCaptureLayout;
    }

    private void resetState() {
        if (isImageCaptureEnabled()) {
            this.mImagePreview.setVisibility(4);
        } else {
            this.mVideoCapture.stopRecording();
        }
        this.mSwitchCamera.setVisibility(0);
        this.mFlashLamp.setVisibility(0);
        this.mCameraPreviewView.setVisibility(0);
        this.mCaptureLayout.resetCaptureLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVideoPlay(java.lang.String str) {
        try {
            android.media.MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer == null) {
                this.mMediaPlayer = new android.media.MediaPlayer();
            } else {
                mediaPlayer.reset();
            }
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(str)) {
                this.mMediaPlayer.setDataSource(getContext(), android.net.Uri.parse(str));
            } else {
                this.mMediaPlayer.setDataSource(str);
            }
            this.mMediaPlayer.setSurface(new android.view.Surface(this.mTextureView.getSurfaceTexture()));
            this.mMediaPlayer.setVideoScalingMode(1);
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setOnVideoSizeChangedListener(new android.media.MediaPlayer.OnVideoSizeChangedListener() { // from class: com.up366.medialibrary.camera.CustomCameraView.7
                @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
                public void onVideoSizeChanged(android.media.MediaPlayer mediaPlayer2, int i, int i2) {
                    com.up366.medialibrary.camera.CustomCameraView.this.updateVideoViewSize(r1.mMediaPlayer.getVideoWidth(), com.up366.medialibrary.camera.CustomCameraView.this.mMediaPlayer.getVideoHeight());
                }
            });
            this.mMediaPlayer.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() { // from class: com.up366.medialibrary.camera.CustomCameraView.8
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(android.media.MediaPlayer mediaPlayer2) {
                    if (com.up366.medialibrary.camera.CustomCameraView.this.mMediaPlayer != null) {
                        com.up366.medialibrary.camera.CustomCameraView.this.mMediaPlayer.start();
                    }
                }
            });
            this.mMediaPlayer.setLooping(true);
            this.mMediaPlayer.prepareAsync();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoViewSize(float f, float f2) {
        if (f > f2) {
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, (int) ((f2 / f) * getWidth()));
            layoutParams.gravity = 17;
            this.mTextureView.setLayoutParams(layoutParams);
        }
    }

    public void onCancelMedia() {
        stopVideoPlay();
        resetState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVideoPlay() {
        android.media.MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.mMediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
        this.mTextureView.setVisibility(8);
    }
}
