package com.up366.mobile.course.photoanswer.logic.cameraAlum;

/* JADX INFO: compiled from: CameraController.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0015J\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0015J\"\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\r0!J\u0006\u0010#\u001a\u00020\rJ\u0006\u0010$\u001a\u00020\rJ\u0006\u0010%\u001a\u00020\u0015J\u000e\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController;", "", "scanSession", "Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;", "<init>", "(Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;)V", "cameraXManager", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerManager;", "alumHelper", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/AlumHelper;", "detectLib", "Lcom/up366/papercut/DetectLib;", "init", "", "previewView", "Landroidx/camera/view/PreviewView;", "textureView", "Landroid/view/TextureView;", "callback", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController$CameraControllerCallback;", "userCameraX", "", "context", "Landroid/content/Context;", "startAnalyze", "stopAnalyze", "setActivityIsShowing", "isShowing", "setActiveCamera", "isFront", "alumPicture", "mediaInfo", "Lcom/up366/medialibrary/MediaInfo;", "Lkotlin/Function1;", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/PhotoCorrectImageData;", "onDestroy", "takePicture", "getNeedUpdateTransform", "setNeedUpdateTransform", "b", "CameraControllerCallback", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CameraController {
    private com.up366.mobile.course.photoanswer.logic.cameraAlum.AlumHelper alumHelper;
    private com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager cameraXManager;
    private com.up366.papercut.DetectLib detectLib;
    private final com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session scanSession;

    /* JADX INFO: compiled from: CameraController.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController$CameraControllerCallback;", "", "onTakePhotoCallback", "", "pageData", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/PhotoCorrectImageData;", "analyzeResult", "Lcom/up366/mobile/course/p1p/PaperRecognitionResult;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface CameraControllerCallback {
        void analyzeResult(com.up366.mobile.course.p1p.PaperRecognitionResult analyzeResult);

        void onTakePhotoCallback(com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData pageData);
    }

    public CameraController(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "scanSession");
        this.scanSession = session;
        this.alumHelper = new com.up366.mobile.course.photoanswer.logic.cameraAlum.AlumHelper(session);
    }

    public final void init(androidx.camera.view.PreviewView previewView, android.view.TextureView textureView, com.up366.papercut.DetectLib detectLib, com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController.CameraControllerCallback callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(previewView, "previewView");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(textureView, "textureView");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(detectLib, "detectLib");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        this.detectLib = detectLib;
        android.content.Context context = previewView.getContext();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (userCameraX(context)) {
            com.up366.common.log.Logger.info("CameraController use CameraX");
            textureView.setVisibility(8);
            this.cameraXManager = new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCameraXManager(previewView, detectLib, callback, this.scanSession);
        } else {
            com.up366.common.log.Logger.info("CameraController use Camera2");
            previewView.setVisibility(8);
            com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCamera2Manager photoAnswerCamera2Manager = new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCamera2Manager(textureView, detectLib, callback, this.scanSession);
            this.cameraXManager = photoAnswerCamera2Manager;
            kotlin.jvm.internal.Intrinsics.checkNotNull(photoAnswerCamera2Manager, "null cannot be cast to non-null type com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCamera2Manager");
            photoAnswerCamera2Manager.initializeCamera();
        }
    }

    private final boolean userCameraX(android.content.Context context) {
        java.lang.String str = android.os.Build.MODEL;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "MODEL");
        return kotlin.text.StringsKt.contains$default(str, "23073RPBFC", false, 2, (java.lang.Object) null) || !com.up366.mobile.common.utils.PadUtils.isTablet(context) || com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isUseCameraX();
    }

    public final void startAnalyze() {
        if (com.up366.mobile.course.photoanswer.logic.helper.SwitchHandHelper.INSTANCE.isHandTakePhoto()) {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.SwitchHandCheckEvent(true));
            return;
        }
        com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager basePhotoAnswerManager = this.cameraXManager;
        if (basePhotoAnswerManager != null) {
            basePhotoAnswerManager.startAnalyzer();
        }
        com.up366.mobile.course.photoanswer.logic.helper.SwitchHandHelper.INSTANCE.startCheck();
    }

    public final void stopAnalyze() {
        com.up366.mobile.course.photoanswer.logic.helper.SwitchHandHelper.INSTANCE.reset();
        com.up366.mobile.course.p1p.helper.P1pStatusHelper.INSTANCE.reset();
        com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager basePhotoAnswerManager = this.cameraXManager;
        if (basePhotoAnswerManager != null) {
            com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.stopAnalyzer$default(basePhotoAnswerManager, false, 1, null);
        }
    }

    public final void setActivityIsShowing(boolean isShowing) {
        com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager basePhotoAnswerManager = this.cameraXManager;
        if (basePhotoAnswerManager != null) {
            basePhotoAnswerManager.setActivityIsShowing(isShowing);
        }
    }

    public final void setActiveCamera(boolean isFront) {
        com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager basePhotoAnswerManager = this.cameraXManager;
        if (basePhotoAnswerManager != null) {
            basePhotoAnswerManager.setActiveCamera(isFront);
        }
    }

    public final void alumPicture(com.up366.medialibrary.MediaInfo mediaInfo, kotlin.jvm.functions.Function1<? super com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData, kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.detectLib == null) {
            com.up366.common.log.Logger.error("detectLib is null");
            return;
        }
        com.up366.mobile.course.photoanswer.logic.cameraAlum.AlumHelper alumHelper = this.alumHelper;
        kotlin.jvm.internal.Intrinsics.checkNotNull(alumHelper);
        com.up366.papercut.DetectLib detectLib = this.detectLib;
        kotlin.jvm.internal.Intrinsics.checkNotNull(detectLib);
        alumHelper.alumPicture(mediaInfo, detectLib, callback);
    }

    public final void onDestroy() {
        this.alumHelper.onDestroy();
        com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager basePhotoAnswerManager = this.cameraXManager;
        if (basePhotoAnswerManager != null) {
            basePhotoAnswerManager.onDestroy();
        }
        this.cameraXManager = null;
        this.detectLib = null;
    }

    public final void takePicture() {
        com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager basePhotoAnswerManager = this.cameraXManager;
        if (basePhotoAnswerManager != null) {
            basePhotoAnswerManager.takePicture();
        }
    }

    public final boolean getNeedUpdateTransform() {
        com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager basePhotoAnswerManager = this.cameraXManager;
        if (basePhotoAnswerManager != null) {
            return basePhotoAnswerManager.getNeedUpdateTransformation();
        }
        return false;
    }

    public final void setNeedUpdateTransform(boolean b) {
        com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager basePhotoAnswerManager = this.cameraXManager;
        if (basePhotoAnswerManager != null) {
            basePhotoAnswerManager.setNeedUpdateTransformation(b);
        }
    }
}
