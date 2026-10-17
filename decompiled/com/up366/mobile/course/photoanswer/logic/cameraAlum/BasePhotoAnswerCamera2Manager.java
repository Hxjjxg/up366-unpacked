package com.up366.mobile.course.photoanswer.logic.cameraAlum;

/* JADX INFO: compiled from: BasePhotoAnswerCamera2Manager.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000»\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001+\b&\u0018\u0000 Q2\u00020\u0001:\u0001QB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010-\u001a\u00020.H\u0002J\u0006\u0010/\u001a\u00020.J\b\u00100\u001a\u00020.H\u0002J\b\u00101\u001a\u00020.H\u0002J\b\u00102\u001a\u00020.H\u0003J\u0010\u00103\u001a\u00020.2\u0006\u00104\u001a\u000205H\u0002J\u0014\u00106\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"07H\u0002J\u0010\u00108\u001a\u00020.2\u0006\u0010\u0006\u001a\u000209H\u0016J+\u0010:\u001a\u00020\u00182\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00180<2\u0006\u0010=\u001a\u00020\"2\u0006\u0010>\u001a\u00020\"H\u0002¢\u0006\u0002\u0010?J\u0018\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020\u00182\u0006\u0010B\u001a\u00020CH\u0002J\u0012\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020.H\u0002J\b\u0010I\u001a\u00020.H\u0002J\b\u0010J\u001a\u00020.H\u0016J\b\u0010K\u001a\u00020.H\u0002J\b\u0010L\u001a\u00020.H\u0002J\b\u0010M\u001a\u00020.H\u0002J\u0018\u0010N\u001a\u00020.2\u0006\u0010O\u001a\u00020P2\u0006\u0010\u0006\u001a\u000209H&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,¨\u0006R"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerCamera2Manager;", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerManager;", "textureView", "Landroid/view/TextureView;", "detectLib", "Lcom/up366/papercut/DetectLib;", "callback", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController$CameraControllerCallback;", "scanSession", "Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;", "<init>", "(Landroid/view/TextureView;Lcom/up366/papercut/DetectLib;Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController$CameraControllerCallback;Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;)V", "cameraDevice", "Landroid/hardware/camera2/CameraDevice;", "captureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "previewImageReader", "Landroid/media/ImageReader;", "captureImageReader", "backgroundHandler", "Landroid/os/Handler;", "backgroundThread", "Landroid/os/HandlerThread;", "captureSize", "Landroid/util/Size;", "previewSurface", "Landroid/view/Surface;", "isCameraClosed", "", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "getIoScope", "()Lkotlinx/coroutines/CoroutineScope;", "deviceRotation", "", "getDeviceRotation", "()I", "previewListener", "Landroid/media/ImageReader$OnImageAvailableListener;", "captureListener", "deviceCallback", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "surfaceTextureListener", "com/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerCamera2Manager$surfaceTextureListener$1", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerCamera2Manager$surfaceTextureListener$1;", "handleSurfaceChange", "", "initializeCamera", "updateResourcesAndRestartSession", "closeSessionAndResources", "performFullInitialization", "setupCameraResources", "characteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "getAdjustedViewSize", "Lkotlin/Pair;", "toTakePicture", "Lcom/up366/common/callback/ICallbackCodeInfo;", "chooseOptimalSize", "choices", "", "textureWidth", "textureHeight", "([Landroid/util/Size;II)Landroid/util/Size;", "ratioMatch", "size", "target", "", "getBackCameraId", "", "manager", "Landroid/hardware/camera2/CameraManager;", "startDualSession", "startPreviewSafe", "onDestroy", "closeCameraSafe", "startBackgroundThread", "stopBackgroundThread", "handleTakePicture", com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE, "Landroid/media/Image;", "Companion", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class BasePhotoAnswerCamera2Manager extends com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager {
    private static final double ASPECT_TOLERANCE = 0.01d;
    private static final int CAPTURE_FORMAT = 256;
    private static final int PREVIEW_FORMAT = 35;
    private android.os.Handler backgroundHandler;
    private android.os.HandlerThread backgroundThread;
    private final com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController.CameraControllerCallback callback;
    private android.hardware.camera2.CameraDevice cameraDevice;
    private android.media.ImageReader captureImageReader;
    private final android.media.ImageReader.OnImageAvailableListener captureListener;
    private android.hardware.camera2.CameraCaptureSession captureSession;
    private android.util.Size captureSize;
    private final android.hardware.camera2.CameraDevice.StateCallback deviceCallback;
    private final kotlinx.coroutines.CoroutineScope ioScope;
    private boolean isCameraClosed;
    private android.media.ImageReader previewImageReader;
    private final android.media.ImageReader.OnImageAvailableListener previewListener;
    private android.view.Surface previewSurface;
    private final com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager$surfaceTextureListener$1 surfaceTextureListener;
    private final android.view.TextureView textureView;

    public abstract void handleTakePicture(android.media.Image image, com.up366.common.callback.ICallbackCodeInfo callback);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager$surfaceTextureListener$1] */
    public BasePhotoAnswerCamera2Manager(android.view.TextureView textureView, com.up366.papercut.DetectLib detectLib, com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController.CameraControllerCallback cameraControllerCallback, final com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        super(detectLib, cameraControllerCallback, session);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(textureView, "textureView");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(detectLib, "detectLib");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cameraControllerCallback, "callback");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "scanSession");
        this.textureView = textureView;
        this.callback = cameraControllerCallback;
        this.ioScope = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(kotlinx.coroutines.Dispatchers.getIO().plus(kotlinx.coroutines.SupervisorKt.SupervisorJob$default((kotlinx.coroutines.Job) null, 1, (java.lang.Object) null)));
        this.previewListener = new android.media.ImageReader.OnImageAvailableListener() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager$$ExternalSyntheticLambda0
            @Override // android.media.ImageReader.OnImageAvailableListener
            public final void onImageAvailable(android.media.ImageReader imageReader) {
                com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager.previewListener$lambda$0(this.f$0, imageReader);
            }
        };
        this.captureListener = new android.media.ImageReader.OnImageAvailableListener() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager$$ExternalSyntheticLambda1
            @Override // android.media.ImageReader.OnImageAvailableListener
            public final void onImageAvailable(android.media.ImageReader imageReader) {
                com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager.captureListener$lambda$2(this.f$0, session, imageReader);
            }
        };
        this.deviceCallback = new android.hardware.camera2.CameraDevice.StateCallback() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager$deviceCallback$1
            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onOpened(android.hardware.camera2.CameraDevice camera) throws android.hardware.camera2.CameraAccessException {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(camera, "camera");
                this.this$0.cameraDevice = camera;
                this.this$0.isCameraClosed = false;
                this.this$0.startDualSession();
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onDisconnected(android.hardware.camera2.CameraDevice camera) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(camera, "camera");
                com.up366.common.log.Logger.error("Camera device disconnected");
                this.this$0.closeCameraSafe();
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onError(android.hardware.camera2.CameraDevice camera, int error) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(camera, "camera");
                com.up366.common.log.Logger.error("Camera device error: " + error);
                this.this$0.closeCameraSafe();
            }
        };
        ?? r3 = new android.view.TextureView.SurfaceTextureListener() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager$surfaceTextureListener$1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surface) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(surface, "surface");
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surface, int width, int height) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(surface, "surface");
                com.up366.common.log.Logger.info("ViewWidth Surface texture available: " + width + " x " + height);
                this.this$0.initializeCamera();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surface, int width, int height) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(surface, "surface");
                com.up366.common.log.Logger.info("Surface texture size changed: " + width + " x " + height);
                this.this$0.handleSurfaceChange();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surface) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(surface, "surface");
                this.this$0.closeCameraSafe();
                return true;
            }
        };
        this.surfaceTextureListener = r3;
        textureView.setSurfaceTextureListener((android.view.TextureView.SurfaceTextureListener) r3);
    }

    protected final kotlinx.coroutines.CoroutineScope getIoScope() {
        return this.ioScope;
    }

    protected final int getDeviceRotation() {
        java.lang.Object systemService = this.textureView.getContext().getSystemService("window");
        kotlin.jvm.internal.Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        return getOrientationMap().get(((android.view.WindowManager) systemService).getDefaultDisplay().getRotation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewListener$lambda$0(com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager basePhotoAnswerCamera2Manager, android.media.ImageReader imageReader) {
        android.media.Image imageAcquireNextImage = imageReader.acquireNextImage();
        try {
            if (imageAcquireNextImage == null) {
                return;
            }
            try {
                basePhotoAnswerCamera2Manager.analyze(new com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.AnalyzeData(imageAcquireNextImage.getWidth(), imageAcquireNextImage.getHeight(), basePhotoAnswerCamera2Manager.getJpegOrientation(basePhotoAnswerCamera2Manager.getDeviceRotation()), imageAcquireNextImage));
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("Preview analysis failed: " + e.getMessage());
            }
        } finally {
            imageAcquireNextImage.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void captureListener$lambda$2(final com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager basePhotoAnswerCamera2Manager, final com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session, android.media.ImageReader imageReader) {
        android.media.Image imageAcquireNextImage = imageReader.acquireNextImage();
        kotlin.jvm.internal.Intrinsics.checkNotNull(imageAcquireNextImage);
        basePhotoAnswerCamera2Manager.handleTakePicture(imageAcquireNextImage, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager$$ExternalSyntheticLambda2
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str) {
                com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager.captureListener$lambda$2$lambda$1(this.f$0, session, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void captureListener$lambda$2$lambda$1(com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager basePhotoAnswerCamera2Manager, com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session, int i, java.lang.String str) {
        basePhotoAnswerCamera2Manager.callback.onTakePhotoCallback(new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData(i, str, com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE.getLastImageType(session)));
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager$handleSurfaceChange$1, reason: invalid class name */
    /* JADX INFO: compiled from: BasePhotoAnswerCamera2Manager.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager$handleSurfaceChange$1", f = "BasePhotoAnswerCamera2Manager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        int label;

        AnonymousClass1(kotlin.coroutines.Continuation<? super com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager.AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            return com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager.this.new AnonymousClass1(continuation);
        }

        public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.ResultKt.throwOnFailure(obj);
                if (com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager.this.cameraDevice != null) {
                    com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager.this.updateResourcesAndRestartSession();
                } else {
                    com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager.this.initializeCamera();
                }
                com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager.this.setNeedUpdateTransformation(true);
                return kotlin.Unit.INSTANCE;
            }
            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSurfaceChange() {
        kotlinx.coroutines.BuildersKt.launch$default(this.ioScope, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager.AnonymousClass1(null), 3, (java.lang.Object) null);
    }

    public final void initializeCamera() {
        if (this.textureView.getSurfaceTexture() == null) {
            return;
        }
        startBackgroundThread();
        if (this.cameraDevice == null) {
            performFullInitialization();
        } else {
            updateResourcesAndRestartSession();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateResourcesAndRestartSession() {
        try {
            java.lang.Object systemService = this.textureView.getContext().getSystemService("camera");
            kotlin.jvm.internal.Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
            android.hardware.camera2.CameraManager cameraManager = (android.hardware.camera2.CameraManager) systemService;
            java.lang.String backCameraId = getBackCameraId(cameraManager);
            if (backCameraId == null) {
                return;
            }
            android.hardware.camera2.CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(backCameraId);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cameraCharacteristics, "getCameraCharacteristics(...)");
            closeSessionAndResources();
            setupCameraResources(cameraCharacteristics);
            startDualSession();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("Resource update failed: " + e.getMessage());
            closeCameraSafe();
        }
    }

    private final void closeSessionAndResources() {
        try {
            android.hardware.camera2.CameraCaptureSession cameraCaptureSession = this.captureSession;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.warn("captureSession close failed: " + e.getMessage());
        }
        android.media.ImageReader imageReader = this.previewImageReader;
        if (imageReader != null) {
            imageReader.setOnImageAvailableListener(null, null);
        }
        android.media.ImageReader imageReader2 = this.previewImageReader;
        if (imageReader2 != null) {
            imageReader2.close();
        }
        this.previewImageReader = null;
        android.media.ImageReader imageReader3 = this.captureImageReader;
        if (imageReader3 != null) {
            imageReader3.setOnImageAvailableListener(null, null);
        }
        android.media.ImageReader imageReader4 = this.captureImageReader;
        if (imageReader4 != null) {
            imageReader4.close();
        }
        this.captureImageReader = null;
        android.view.Surface surface = this.previewSurface;
        if (surface != null) {
            surface.release();
        }
        this.previewSurface = null;
        this.captureSession = null;
    }

    private final void performFullInitialization() {
        try {
            java.lang.Object systemService = this.textureView.getContext().getSystemService("camera");
            kotlin.jvm.internal.Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
            android.hardware.camera2.CameraManager cameraManager = (android.hardware.camera2.CameraManager) systemService;
            java.lang.String backCameraId = getBackCameraId(cameraManager);
            if (backCameraId == null) {
                return;
            }
            android.hardware.camera2.CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(backCameraId);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cameraCharacteristics, "getCameraCharacteristics(...)");
            setupCameraResources(cameraCharacteristics);
            cameraManager.openCamera(backCameraId, this.deviceCallback, this.backgroundHandler);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("Camera initialization failed: " + e.getMessage());
            closeCameraSafe();
        }
    }

    private final void setupCameraResources(android.hardware.camera2.CameraCharacteristics characteristics) {
        java.lang.Object obj = characteristics.get(android.hardware.camera2.CameraCharacteristics.SENSOR_ORIENTATION);
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj);
        setSensorOrientation(((java.lang.Number) obj).intValue());
        kotlin.Pair<java.lang.Integer, java.lang.Integer> adjustedViewSize = getAdjustedViewSize();
        int iIntValue = ((java.lang.Number) adjustedViewSize.component1()).intValue();
        int iIntValue2 = ((java.lang.Number) adjustedViewSize.component2()).intValue();
        java.lang.Object obj2 = characteristics.get(android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj2);
        android.hardware.camera2.params.StreamConfigurationMap streamConfigurationMap = (android.hardware.camera2.params.StreamConfigurationMap) obj2;
        android.util.Size[] outputSizes = streamConfigurationMap.getOutputSizes(android.graphics.SurfaceTexture.class);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(outputSizes, "getOutputSizes(...)");
        android.util.Size sizeChooseOptimalSize = chooseOptimalSize(outputSizes, iIntValue, iIntValue2);
        getCameraPreviewData().setViewSize(new android.util.Size(iIntValue, iIntValue2));
        getCameraPreviewData().setPreviewSize(sizeChooseOptimalSize);
        android.graphics.SurfaceTexture surfaceTexture = this.textureView.getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(sizeChooseOptimalSize.getWidth(), sizeChooseOptimalSize.getHeight());
        }
        this.previewSurface = new android.view.Surface(this.textureView.getSurfaceTexture());
        android.media.ImageReader imageReaderNewInstance = android.media.ImageReader.newInstance(sizeChooseOptimalSize.getWidth(), sizeChooseOptimalSize.getHeight(), 35, 3);
        imageReaderNewInstance.setOnImageAvailableListener(this.previewListener, this.backgroundHandler);
        this.previewImageReader = imageReaderNewInstance;
        android.util.Size[] outputSizes2 = streamConfigurationMap.getOutputSizes(256);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(outputSizes2, "getOutputSizes(...)");
        java.util.List arrayList = new java.util.ArrayList();
        for (android.util.Size size : outputSizes2) {
            android.util.Size size2 = size;
            if (kotlin.jvm.internal.Intrinsics.areEqual(new android.util.Rational(size2.getWidth(), size2.getHeight()), new android.util.Rational(sizeChooseOptimalSize.getWidth(), sizeChooseOptimalSize.getHeight()))) {
                arrayList.add(size);
            }
        }
        java.util.List list = arrayList;
        if (list.isEmpty()) {
            android.util.Size[] outputSizes3 = streamConfigurationMap.getOutputSizes(256);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(outputSizes3, "getOutputSizes(...)");
            list = kotlin.collections.ArraysKt.toList(outputSizes3);
        }
        android.util.Size size3 = (android.util.Size) java.util.Collections.max(kotlin.collections.CollectionsKt.toList(list), new com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.CompareSizesByArea());
        this.captureSize = size3;
        kotlin.jvm.internal.Intrinsics.checkNotNull(size3);
        int width = size3.getWidth();
        android.util.Size size4 = this.captureSize;
        kotlin.jvm.internal.Intrinsics.checkNotNull(size4);
        android.media.ImageReader imageReaderNewInstance2 = android.media.ImageReader.newInstance(width, size4.getHeight(), 256, 2);
        imageReaderNewInstance2.setOnImageAvailableListener(this.captureListener, this.backgroundHandler);
        this.captureImageReader = imageReaderNewInstance2;
    }

    private final kotlin.Pair<java.lang.Integer, java.lang.Integer> getAdjustedViewSize() {
        android.view.TextureView textureView = this.textureView;
        int width = textureView.getWidth();
        int height = textureView.getHeight();
        int sensorOrientation = getSensorOrientation();
        if (sensorOrientation == 90 || sensorOrientation == 270) {
            return kotlin.TuplesKt.to(java.lang.Integer.valueOf(height), java.lang.Integer.valueOf(width));
        }
        return kotlin.TuplesKt.to(java.lang.Integer.valueOf(width), java.lang.Integer.valueOf(height));
    }

    @Override // com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager
    public void toTakePicture(final com.up366.common.callback.ICallbackCodeInfo callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        android.hardware.camera2.CameraCaptureSession cameraCaptureSession = this.captureSession;
        if (cameraCaptureSession == null || this.isCameraClosed) {
            com.up366.common.log.Logger.error("Capture session is null or camera closed");
            callback.onResult(-3, "");
            return;
        }
        try {
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.stopRepeating();
                } catch (java.lang.Exception unused) {
                    com.up366.common.log.Logger.warn("stopRepeating skipped due to camera error");
                }
            }
            android.hardware.camera2.CameraDevice cameraDevice = this.cameraDevice;
            kotlin.jvm.internal.Intrinsics.checkNotNull(cameraDevice);
            android.hardware.camera2.CaptureRequest.Builder builderCreateCaptureRequest = cameraDevice.createCaptureRequest(2);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(builderCreateCaptureRequest, "createCaptureRequest(...)");
            android.media.ImageReader imageReader = this.captureImageReader;
            kotlin.jvm.internal.Intrinsics.checkNotNull(imageReader);
            builderCreateCaptureRequest.addTarget(imageReader.getSurface());
            builderCreateCaptureRequest.set(android.hardware.camera2.CaptureRequest.JPEG_ORIENTATION, java.lang.Integer.valueOf(getJpegOrientation(getDeviceRotation())));
            builderCreateCaptureRequest.set(android.hardware.camera2.CaptureRequest.CONTROL_MODE, 2);
            android.hardware.camera2.CameraCaptureSession cameraCaptureSession2 = this.captureSession;
            if (cameraCaptureSession2 != null) {
                cameraCaptureSession2.capture(builderCreateCaptureRequest.build(), new android.hardware.camera2.CameraCaptureSession.CaptureCallback() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager.toTakePicture.1
                    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                    public void onCaptureCompleted(android.hardware.camera2.CameraCaptureSession session, android.hardware.camera2.CaptureRequest request, android.hardware.camera2.TotalCaptureResult result) {
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "session");
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(request, "request");
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
                        com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager.this.startPreviewSafe();
                    }

                    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                    public void onCaptureFailed(android.hardware.camera2.CameraCaptureSession session, android.hardware.camera2.CaptureRequest request, android.hardware.camera2.CaptureFailure failure) {
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "session");
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(request, "request");
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(failure, "failure");
                        com.up366.common.log.Logger.error("Capture failed: " + failure.getReason());
                        callback.onResult(-3, "Capture failed");
                        com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager.this.startPreviewSafe();
                    }
                }, this.backgroundHandler);
            }
        } catch (android.hardware.camera2.CameraAccessException e) {
            com.up366.common.log.Logger.error("Capture failed: " + e.getMessage());
            java.lang.String message = e.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            callback.onResult(-3, message);
        }
    }

    private final boolean ratioMatch(android.util.Size size, double target) {
        return java.lang.Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - target) < ASPECT_TOLERANCE;
    }

    private final java.lang.String getBackCameraId(android.hardware.camera2.CameraManager manager) throws android.hardware.camera2.CameraAccessException {
        for (java.lang.String str : manager.getCameraIdList()) {
            android.hardware.camera2.CameraCharacteristics cameraCharacteristics = manager.getCameraCharacteristics(str);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cameraCharacteristics, "getCameraCharacteristics(...)");
            java.lang.Integer num = (java.lang.Integer) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.LENS_FACING);
            if (num != null && num.intValue() == 1) {
                return str;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startDualSession() throws android.hardware.camera2.CameraAccessException {
        if (this.isCameraClosed) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.media.ImageReader imageReader = this.previewImageReader;
        kotlin.jvm.internal.Intrinsics.checkNotNull(imageReader);
        arrayList.add(imageReader.getSurface());
        android.media.ImageReader imageReader2 = this.captureImageReader;
        kotlin.jvm.internal.Intrinsics.checkNotNull(imageReader2);
        arrayList.add(imageReader2.getSurface());
        arrayList.add(this.previewSurface);
        android.hardware.camera2.CameraDevice cameraDevice = this.cameraDevice;
        if (cameraDevice != null) {
            cameraDevice.createCaptureSession(arrayList, new android.hardware.camera2.CameraCaptureSession.StateCallback() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager.startDualSession.1
                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigured(android.hardware.camera2.CameraCaptureSession session) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "session");
                    com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager.this.captureSession = session;
                    com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager.this.startPreviewSafe();
                }

                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigureFailed(android.hardware.camera2.CameraCaptureSession session) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "session");
                    com.up366.common.log.Logger.error("Session configuration failed");
                    com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager.this.closeCameraSafe();
                }
            }, this.backgroundHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startPreviewSafe() {
        android.hardware.camera2.CameraDevice cameraDevice;
        if (this.captureSession == null || (cameraDevice = this.cameraDevice) == null || this.isCameraClosed) {
            return;
        }
        try {
            kotlin.jvm.internal.Intrinsics.checkNotNull(cameraDevice);
            android.hardware.camera2.CaptureRequest.Builder builderCreateCaptureRequest = cameraDevice.createCaptureRequest(1);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(builderCreateCaptureRequest, "createCaptureRequest(...)");
            android.media.ImageReader imageReader = this.previewImageReader;
            kotlin.jvm.internal.Intrinsics.checkNotNull(imageReader);
            builderCreateCaptureRequest.addTarget(imageReader.getSurface());
            android.view.Surface surface = this.previewSurface;
            kotlin.jvm.internal.Intrinsics.checkNotNull(surface);
            builderCreateCaptureRequest.addTarget(surface);
            builderCreateCaptureRequest.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, 4);
            try {
                android.hardware.camera2.CameraCaptureSession cameraCaptureSession = this.captureSession;
                kotlin.jvm.internal.Intrinsics.checkNotNull(cameraCaptureSession);
                java.lang.Integer.valueOf(cameraCaptureSession.setRepeatingRequest(builderCreateCaptureRequest.build(), null, this.backgroundHandler));
            } catch (java.lang.Exception unused) {
                com.up366.common.log.Logger.warn("setRepeatingRequest skipped due to camera error");
                kotlin.Unit unit = kotlin.Unit.INSTANCE;
            }
        } catch (android.hardware.camera2.CameraAccessException e) {
            com.up366.common.log.Logger.error("Preview failed: " + e.getMessage());
        }
    }

    @Override // com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager
    public void onDestroy() {
        setActivityIsShowing(false);
        kotlinx.coroutines.CoroutineScopeKt.cancel$default(this.ioScope, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        closeCameraSafe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeCameraSafe() {
        if (this.isCameraClosed) {
            return;
        }
        this.isCameraClosed = true;
        try {
            android.hardware.camera2.CameraCaptureSession cameraCaptureSession = this.captureSession;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.stopRepeating();
            }
        } catch (java.lang.Exception unused) {
            com.up366.common.log.Logger.warn("stopRepeating skipped due to camera error");
        }
        closeSessionAndResources();
        try {
            android.hardware.camera2.CameraDevice cameraDevice = this.cameraDevice;
            if (cameraDevice != null) {
                cameraDevice.close();
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("cameraDevice close failed: " + e.getMessage());
        }
        this.cameraDevice = null;
        stopBackgroundThread();
    }

    private final void startBackgroundThread() {
        android.os.HandlerThread handlerThread = this.backgroundThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            android.os.HandlerThread handlerThread2 = new android.os.HandlerThread("CameraBackground");
            handlerThread2.start();
            this.backgroundHandler = new android.os.Handler(handlerThread2.getLooper());
            this.backgroundThread = handlerThread2;
        }
    }

    private final void stopBackgroundThread() {
        android.os.HandlerThread handlerThread = this.backgroundThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.backgroundThread = null;
        this.backgroundHandler = null;
    }

    private final android.util.Size chooseOptimalSize(android.util.Size[] choices, int textureWidth, int textureHeight) {
        java.lang.Object next;
        java.lang.Object next2;
        java.lang.Object next3;
        double d = ((double) textureWidth) / ((double) textureHeight);
        int i = textureWidth * textureHeight;
        java.util.List listSortedWith = kotlin.collections.ArraysKt.sortedWith(choices, new java.util.Comparator() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager$chooseOptimalSize$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                android.util.Size size = (android.util.Size) t;
                android.util.Size size2 = (android.util.Size) t2;
                return kotlin.comparisons.ComparisonsKt.compareValues(java.lang.Integer.valueOf(size.getWidth() * size.getHeight()), java.lang.Integer.valueOf(size2.getWidth() * size2.getHeight()));
            }
        });
        java.util.Iterator it = listSortedWith.iterator();
        while (true) {
            next = null;
            if (!it.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it.next();
            android.util.Size size = (android.util.Size) next2;
            if (size.getWidth() >= textureWidth && size.getHeight() >= textureHeight && ratioMatch(size, d)) {
                break;
            }
        }
        android.util.Size size2 = (android.util.Size) next2;
        if (size2 == null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.Object obj : listSortedWith) {
                android.util.Size size3 = (android.util.Size) obj;
                if (size3.getWidth() >= textureWidth && size3.getHeight() >= textureHeight) {
                    arrayList.add(obj);
                }
            }
            java.util.Iterator it2 = arrayList.iterator();
            if (it2.hasNext()) {
                next3 = it2.next();
                if (it2.hasNext()) {
                    android.util.Size size4 = (android.util.Size) next3;
                    int iAbs = java.lang.Math.abs((size4.getWidth() * size4.getHeight()) - i);
                    do {
                        java.lang.Object next4 = it2.next();
                        android.util.Size size5 = (android.util.Size) next4;
                        int iAbs2 = java.lang.Math.abs((size5.getWidth() * size5.getHeight()) - i);
                        if (iAbs > iAbs2) {
                            next3 = next4;
                            iAbs = iAbs2;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next3 = null;
            }
            size2 = (android.util.Size) next3;
            if (size2 == null) {
                java.util.Iterator it3 = listSortedWith.iterator();
                if (it3.hasNext()) {
                    next = it3.next();
                    if (it3.hasNext()) {
                        android.util.Size size6 = (android.util.Size) next;
                        int width = size6.getWidth() * size6.getHeight();
                        do {
                            java.lang.Object next5 = it3.next();
                            android.util.Size size7 = (android.util.Size) next5;
                            int width2 = size7.getWidth() * size7.getHeight();
                            if (width < width2) {
                                next = next5;
                                width = width2;
                            }
                        } while (it3.hasNext());
                    }
                }
                kotlin.jvm.internal.Intrinsics.checkNotNull(next);
                size2 = (android.util.Size) next;
            }
        }
        com.up366.common.log.Logger.debug("Chosen size: " + size2.getWidth() + "x" + size2.getHeight() + " for view " + textureWidth + " x " + textureHeight);
        return size2;
    }
}
