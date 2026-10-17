package com.up366.mobile.course.photoanswer.logic.cameraAlum;

/* JADX INFO: compiled from: BasePhotoAnswerCameraXManager.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020*H\u0014J\b\u0010,\u001a\u00020*H\u0002J\u0018\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J@\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020%2\u0006\u00104\u001a\u0002052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0002J\u0018\u0010:\u001a\u00020\u001b2\u0006\u00100\u001a\u0002012\u0006\u00107\u001a\u00020'H\u0002J\u0018\u0010;\u001a\u00020\u001d2\u0006\u00100\u001a\u0002012\u0006\u00107\u001a\u00020'H\u0002J\u0018\u0010<\u001a\u00020\u001f2\u0006\u00100\u001a\u0002012\u0006\u00108\u001a\u000209H\u0002J\u0018\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020'H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\r8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u0017X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerCameraXManager;", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerManager;", "previewView", "Landroidx/camera/view/PreviewView;", "detectLib", "Lcom/up366/papercut/DetectLib;", "callback", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController$CameraControllerCallback;", "scanSession", "Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;", "<init>", "(Landroidx/camera/view/PreviewView;Lcom/up366/papercut/DetectLib;Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController$CameraControllerCallback;Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;)V", "analyzeExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getAnalyzeExecutor", "()Ljava/util/concurrent/ExecutorService;", "analyzeExecutor$delegate", "Lkotlin/Lazy;", "pictureExecutor", "getPictureExecutor", "pictureExecutor$delegate", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "getIoScope", "()Lkotlinx/coroutines/CoroutineScope;", "preview", "Landroidx/camera/core/Preview;", "imageAnalysis", "Landroidx/camera/core/ImageAnalysis;", "mImageCapture", "Landroidx/camera/core/ImageCapture;", "getMImageCapture", "()Landroidx/camera/core/ImageCapture;", "setMImageCapture", "(Landroidx/camera/core/ImageCapture;)V", "mCameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "cameraBindSucceeded", "", "cameraInitInProgress", "onDestroy", "", "ensureCameraReady", "requestCameraInit", "tryBindCameraUseCases", "context", "Landroid/content/Context;", "rotation", "", "bindUseCases", "cameraProvider", "activity", "Lcom/up366/mobile/course/photoanswer/PhotoAnswerMainActivity;", "imageCapture", "simplified", "captureSize", "Landroid/util/Size;", "buildPreview", "buildImageAnalysis", "buildImageCapture", "handleInitFailure", "stage", "", "throwable", "", "clearCameraState", "unbindAll", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class BasePhotoAnswerCameraXManager extends com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager {

    /* JADX INFO: renamed from: analyzeExecutor$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy analyzeExecutor;
    private volatile boolean cameraBindSucceeded;
    private volatile boolean cameraInitInProgress;
    private androidx.camera.core.ImageAnalysis imageAnalysis;
    private final kotlinx.coroutines.CoroutineScope ioScope;
    private androidx.camera.lifecycle.ProcessCameraProvider mCameraProvider;
    private androidx.camera.core.ImageCapture mImageCapture;

    /* JADX INFO: renamed from: pictureExecutor$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy pictureExecutor;
    private androidx.camera.core.Preview preview;
    private final androidx.camera.view.PreviewView previewView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasePhotoAnswerCameraXManager(androidx.camera.view.PreviewView previewView, com.up366.papercut.DetectLib detectLib, com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController.CameraControllerCallback cameraControllerCallback, com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        super(detectLib, cameraControllerCallback, session);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(previewView, "previewView");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(detectLib, "detectLib");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cameraControllerCallback, "callback");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "scanSession");
        this.previewView = previewView;
        this.analyzeExecutor = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCameraXManager$$ExternalSyntheticLambda2
            public final java.lang.Object invoke() {
                return java.util.concurrent.Executors.newSingleThreadExecutor();
            }
        });
        this.pictureExecutor = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCameraXManager$$ExternalSyntheticLambda3
            public final java.lang.Object invoke() {
                return java.util.concurrent.Executors.newSingleThreadExecutor();
            }
        });
        this.ioScope = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(kotlinx.coroutines.Dispatchers.getIO().plus(kotlinx.coroutines.SupervisorKt.SupervisorJob$default((kotlinx.coroutines.Job) null, 1, (java.lang.Object) null)));
        requestCameraInit();
    }

    private final java.util.concurrent.ExecutorService getAnalyzeExecutor() {
        return (java.util.concurrent.ExecutorService) this.analyzeExecutor.getValue();
    }

    protected final java.util.concurrent.ExecutorService getPictureExecutor() {
        java.lang.Object value = this.pictureExecutor.getValue();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (java.util.concurrent.ExecutorService) value;
    }

    protected final kotlinx.coroutines.CoroutineScope getIoScope() {
        return this.ioScope;
    }

    protected final androidx.camera.core.ImageCapture getMImageCapture() {
        return this.mImageCapture;
    }

    protected final void setMImageCapture(androidx.camera.core.ImageCapture imageCapture) {
        this.mImageCapture = imageCapture;
    }

    @Override // com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager
    public void onDestroy() {
        setActivityIsShowing(false);
        clearCameraState(true);
        kotlinx.coroutines.CoroutineScopeKt.cancel$default(this.ioScope, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        getAnalyzeExecutor().shutdown();
        getPictureExecutor().shutdown();
        this.mCameraProvider = null;
    }

    @Override // com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager
    protected void ensureCameraReady() {
        requestCameraInit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void requestCameraInit() {
        if (this.cameraBindSucceeded || this.cameraInitInProgress) {
            return;
        }
        final android.content.Context context = this.previewView.getContext();
        com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity = context instanceof com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity ? (com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity) context : null;
        if (!this.previewView.isAttachedToWindow() || photoAnswerMainActivity == null || photoAnswerMainActivity.isFinishing() || photoAnswerMainActivity.isDestroyed()) {
            return;
        }
        this.cameraInitInProgress = true;
        final com.google.common.util.concurrent.ListenableFuture companion = androidx.camera.lifecycle.ProcessCameraProvider.Companion.getInstance(context);
        companion.addListener(new java.lang.Runnable() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCameraXManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCameraXManager.requestCameraInit$lambda$4(this.f$0, context, companion);
            }
        }, androidx.core.content.ContextCompat.getMainExecutor(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestCameraInit$lambda$4(com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCameraXManager basePhotoAnswerCameraXManager, android.content.Context context, com.google.common.util.concurrent.ListenableFuture listenableFuture) {
        java.lang.Object obj;
        android.view.WindowManager windowManager;
        try {
            if (!basePhotoAnswerCameraXManager.previewView.isAttachedToWindow()) {
                com.up366.common.log.Logger.warn("PhotoAnswer CameraX init skipped because previewView is detached");
                basePhotoAnswerCameraXManager.clearCameraState(true);
                return;
            }
            try {
                kotlin.Result.Companion companion = kotlin.Result.Companion;
                obj = kotlin.Result.constructor-impl((androidx.camera.lifecycle.ProcessCameraProvider) listenableFuture.get());
            } catch (java.lang.Throwable th) {
                kotlin.Result.Companion companion2 = kotlin.Result.Companion;
                obj = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(th));
            }
            java.lang.Throwable th2 = kotlin.Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                basePhotoAnswerCameraXManager.handleInitFailure("getCameraProvider", th2);
            }
            if (kotlin.Result.isFailure-impl(obj)) {
                obj = null;
            }
            androidx.camera.lifecycle.ProcessCameraProvider processCameraProvider = (androidx.camera.lifecycle.ProcessCameraProvider) obj;
            if (processCameraProvider == null) {
                return;
            }
            basePhotoAnswerCameraXManager.mCameraProvider = processCameraProvider;
            android.view.Display display = basePhotoAnswerCameraXManager.previewView.getDisplay();
            basePhotoAnswerCameraXManager.cameraBindSucceeded = basePhotoAnswerCameraXManager.tryBindCameraUseCases(context, (display == null && ((windowManager = (android.view.WindowManager) basePhotoAnswerCameraXManager.previewView.getContext().getSystemService(android.view.WindowManager.class)) == null || (display = windowManager.getDefaultDisplay()) == null)) ? 0 : display.getRotation());
            if (!basePhotoAnswerCameraXManager.cameraBindSucceeded) {
                com.up366.common.log.Logger.error("PhotoAnswer CameraX init failed: no compatible use case configuration");
                basePhotoAnswerCameraXManager.clearCameraState(true);
            }
        } finally {
            basePhotoAnswerCameraXManager.cameraInitInProgress = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean tryBindCameraUseCases(android.content.Context context, int rotation) {
        androidx.camera.lifecycle.ProcessCameraProvider processCameraProvider;
        com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity = context instanceof com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity ? (com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity) context : null;
        boolean z = false;
        if (photoAnswerMainActivity == null || (processCameraProvider = this.mCameraProvider) == null) {
            return false;
        }
        java.util.List<android.util.Size> captureSizeCandidates = com.up366.mobile.course.photoanswer.logic.cameraAlum.SupportSizeUtils.INSTANCE.getCaptureSizeCandidates(context);
        java.util.Iterator it = kotlin.collections.CollectionsKt.listOf(new java.lang.Boolean[]{false, true}).iterator();
        while (it.hasNext()) {
            boolean zBooleanValue = ((java.lang.Boolean) it.next()).booleanValue();
            for (android.util.Size size : captureSizeCandidates) {
                if (!this.previewView.isAttachedToWindow() || photoAnswerMainActivity.isFinishing() || photoAnswerMainActivity.isDestroyed()) {
                    com.up366.common.log.Logger.warn("PhotoAnswer CameraX bind skipped because host activity is invalid");
                    return false;
                }
                androidx.camera.core.Preview previewBuildPreview = buildPreview(rotation, zBooleanValue);
                previewBuildPreview.setSurfaceProvider(this.previewView.getSurfaceProvider());
                androidx.camera.core.ImageAnalysis imageAnalysisBuildImageAnalysis = buildImageAnalysis(rotation, zBooleanValue);
                imageAnalysisBuildImageAnalysis.setAnalyzer(getAnalyzeExecutor(), new androidx.camera.core.ImageAnalysis.Analyzer() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCameraXManager$$ExternalSyntheticLambda1
                    public final void analyze(androidx.camera.core.ImageProxy imageProxy) {
                        com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCameraXManager.tryBindCameraUseCases$lambda$5(this.f$0, imageProxy);
                    }

                    public /* synthetic */ android.util.Size getDefaultTargetResolution() {
                        return androidx.camera.core.ImageAnalysis.Analyzer.-CC.$default$getDefaultTargetResolution(this);
                    }

                    public /* synthetic */ int getTargetCoordinateSystem() {
                        return androidx.camera.core.ImageAnalysis.Analyzer.-CC.$default$getTargetCoordinateSystem(this);
                    }

                    public /* synthetic */ void updateTransform(android.graphics.Matrix matrix) {
                        androidx.camera.core.ImageAnalysis.Analyzer.-CC.$default$updateTransform(this, matrix);
                    }
                });
                androidx.camera.core.ImageCapture imageCaptureBuildImageCapture = buildImageCapture(rotation, size);
                boolean z2 = zBooleanValue;
                if (bindUseCases(processCameraProvider, photoAnswerMainActivity, previewBuildPreview, imageAnalysisBuildImageAnalysis, imageCaptureBuildImageCapture, zBooleanValue, size)) {
                    this.preview = previewBuildPreview;
                    this.imageAnalysis = imageAnalysisBuildImageAnalysis;
                    this.mImageCapture = imageCaptureBuildImageCapture;
                    return true;
                }
                imageAnalysisBuildImageAnalysis.clearAnalyzer();
                zBooleanValue = z2;
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryBindCameraUseCases$lambda$5(com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCameraXManager basePhotoAnswerCameraXManager, androidx.camera.core.ImageProxy imageProxy) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageProxy, com.igexin.push.g.q.f);
        basePhotoAnswerCameraXManager.analyze(new com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.AnalyzeData(imageProxy.getWidth(), imageProxy.getHeight(), imageProxy.getImageInfo().getRotationDegrees(), imageProxy));
    }

    private final boolean bindUseCases(androidx.camera.lifecycle.ProcessCameraProvider cameraProvider, com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity activity, androidx.camera.core.Preview preview, androidx.camera.core.ImageAnalysis imageAnalysis, androidx.camera.core.ImageCapture imageCapture, boolean simplified, android.util.Size captureSize) {
        java.lang.Object obj;
        try {
            kotlin.Result.Companion companion = kotlin.Result.Companion;
            com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCameraXManager basePhotoAnswerCameraXManager = this;
            cameraProvider.unbindAll();
            androidx.camera.core.UseCaseGroup.Builder builderAddUseCase = new androidx.camera.core.UseCaseGroup.Builder().addUseCase((androidx.camera.core.UseCase) preview).addUseCase((androidx.camera.core.UseCase) imageAnalysis).addUseCase((androidx.camera.core.UseCase) imageCapture);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(builderAddUseCase, "addUseCase(...)");
            androidx.camera.core.ViewPort viewPort = this.previewView.getViewPort();
            if (!simplified && viewPort != null) {
                builderAddUseCase.setViewPort(viewPort);
            } else if (!simplified) {
                com.up366.common.log.Logger.warn("PhotoAnswer CameraX bind missing viewPort, fallback to default crop handling");
            }
            androidx.camera.core.UseCaseGroup useCaseGroupBuild = builderAddUseCase.build();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(useCaseGroupBuild, "build(...)");
            androidx.camera.core.CameraSelector cameraSelector = androidx.camera.core.CameraSelector.DEFAULT_BACK_CAMERA;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cameraSelector, "DEFAULT_BACK_CAMERA");
            obj = kotlin.Result.constructor-impl(cameraProvider.bindToLifecycle((androidx.lifecycle.LifecycleOwner) activity, cameraSelector, useCaseGroupBuild));
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.Companion;
            obj = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(th));
        }
        java.lang.Throwable th2 = kotlin.Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            com.up366.common.log.Logger.warn("PhotoAnswer CameraX bind fallback failed simplified:" + simplified + " captureSize:" + captureSize + " " + th2.getMessage());
            cameraProvider.unbindAll();
        }
        return kotlin.Result.isSuccess-impl(obj);
    }

    private final androidx.camera.core.Preview buildPreview(int rotation, boolean simplified) {
        if (!simplified) {
            java.lang.String str = android.os.Build.MODEL;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "MODEL");
            if (kotlin.text.StringsKt.contains$default(str, "23073RPBFC", false, 2, (java.lang.Object) null)) {
                androidx.camera.core.resolutionselector.ResolutionStrategy resolutionStrategy = new androidx.camera.core.resolutionselector.ResolutionStrategy(new android.util.Size(1280, 720), 2);
                androidx.camera.core.resolutionselector.ResolutionSelector resolutionSelectorBuild = new androidx.camera.core.resolutionselector.ResolutionSelector.Builder().setResolutionStrategy(resolutionStrategy).setAspectRatioStrategy(new androidx.camera.core.resolutionselector.AspectRatioStrategy(0, 1)).setAllowedResolutionMode(0).build();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild, "build(...)");
                androidx.camera.core.Preview previewBuild = new androidx.camera.core.Preview.Builder().setTargetRotation(rotation).setResolutionSelector(resolutionSelectorBuild).build();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(previewBuild, "build(...)");
                return previewBuild;
            }
        }
        androidx.camera.core.Preview.Builder targetRotation = new androidx.camera.core.Preview.Builder().setTargetRotation(rotation);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(targetRotation, "setTargetRotation(...)");
        if (!simplified) {
            androidx.camera.core.resolutionselector.ResolutionSelector resolutionSelectorBuild2 = new androidx.camera.core.resolutionselector.ResolutionSelector.Builder().setAspectRatioStrategy(new androidx.camera.core.resolutionselector.AspectRatioStrategy(0, 1)).setAllowedResolutionMode(0).build();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild2, "build(...)");
            targetRotation.setResolutionSelector(resolutionSelectorBuild2);
        }
        androidx.camera.core.Preview previewBuild2 = targetRotation.build();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(previewBuild2, "build(...)");
        return previewBuild2;
    }

    private final androidx.camera.core.ImageAnalysis buildImageAnalysis(int rotation, boolean simplified) {
        androidx.camera.core.ImageAnalysis.Builder backpressureStrategy = new androidx.camera.core.ImageAnalysis.Builder().setTargetRotation(rotation).setOutputImageFormat(2).setBackpressureStrategy(0);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(backpressureStrategy, "setBackpressureStrategy(...)");
        if (!simplified) {
            java.lang.String str = android.os.Build.MODEL;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "MODEL");
            if (kotlin.text.StringsKt.contains$default(str, "23073RPBFC", false, 2, (java.lang.Object) null)) {
                androidx.camera.core.resolutionselector.ResolutionStrategy resolutionStrategy = new androidx.camera.core.resolutionselector.ResolutionStrategy(new android.util.Size(1280, 720), 2);
                androidx.camera.core.resolutionselector.ResolutionSelector resolutionSelectorBuild = new androidx.camera.core.resolutionselector.ResolutionSelector.Builder().setResolutionStrategy(resolutionStrategy).setAspectRatioStrategy(new androidx.camera.core.resolutionselector.AspectRatioStrategy(0, 1)).setAllowedResolutionMode(0).build();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild, "build(...)");
                backpressureStrategy.setResolutionSelector(resolutionSelectorBuild);
            } else {
                androidx.camera.core.resolutionselector.ResolutionStrategy resolutionStrategy2 = new androidx.camera.core.resolutionselector.ResolutionStrategy(new android.util.Size(640, 480), 2);
                androidx.camera.core.resolutionselector.ResolutionSelector resolutionSelectorBuild2 = new androidx.camera.core.resolutionselector.ResolutionSelector.Builder().setResolutionStrategy(resolutionStrategy2).setAspectRatioStrategy(new androidx.camera.core.resolutionselector.AspectRatioStrategy(0, 1)).setAllowedResolutionMode(0).build();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild2, "build(...)");
                backpressureStrategy.setResolutionSelector(resolutionSelectorBuild2);
            }
        }
        androidx.camera.core.ImageAnalysis imageAnalysisBuild = backpressureStrategy.build();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(imageAnalysisBuild, "build(...)");
        return imageAnalysisBuild;
    }

    private final androidx.camera.core.ImageCapture buildImageCapture(int rotation, android.util.Size captureSize) {
        androidx.camera.core.resolutionselector.ResolutionStrategy resolutionStrategy = new androidx.camera.core.resolutionselector.ResolutionStrategy(captureSize, 0);
        androidx.camera.core.resolutionselector.ResolutionSelector resolutionSelectorBuild = new androidx.camera.core.resolutionselector.ResolutionSelector.Builder().setResolutionStrategy(resolutionStrategy).setAspectRatioStrategy(new androidx.camera.core.resolutionselector.AspectRatioStrategy(0, 1)).setAllowedResolutionMode(0).build();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild, "build(...)");
        androidx.camera.core.ImageCapture imageCaptureBuild = new androidx.camera.core.ImageCapture.Builder().setTargetRotation(rotation).setResolutionSelector(resolutionSelectorBuild).setCaptureMode(0).setJpegQuality(90).setFlashMode(2).build();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(imageCaptureBuild, "build(...)");
        return imageCaptureBuild;
    }

    private final void handleInitFailure(java.lang.String stage, java.lang.Throwable throwable) {
        com.up366.common.log.Logger.error("PhotoAnswer CameraX init failed at " + stage, throwable);
        clearCameraState(true);
    }

    private final void clearCameraState(boolean unbindAll) {
        androidx.camera.lifecycle.ProcessCameraProvider processCameraProvider;
        this.cameraBindSucceeded = false;
        androidx.camera.core.ImageAnalysis imageAnalysis = this.imageAnalysis;
        if (imageAnalysis != null) {
            imageAnalysis.clearAnalyzer();
        }
        this.preview = null;
        this.imageAnalysis = null;
        if (unbindAll && (processCameraProvider = this.mCameraProvider) != null) {
            processCameraProvider.unbindAll();
        }
        this.mImageCapture = null;
    }
}
