package com.up366.mobile.course.photoanswer.logic.cameraAlum;

/* JADX INFO: compiled from: PhotoAnswerCameraXManager.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/PhotoAnswerCameraXManager;", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerCameraXManager;", "previewView", "Landroidx/camera/view/PreviewView;", "detectLib", "Lcom/up366/papercut/DetectLib;", "callback", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController$CameraControllerCallback;", "scanSession", "Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;", "<init>", "(Landroidx/camera/view/PreviewView;Lcom/up366/papercut/DetectLib;Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController$CameraControllerCallback;Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;)V", "handleAnalyse", "Lcom/up366/mobile/course/p1p/PaperRecognitionResult;", "data", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerManager$AnalyzeData;", "toTakePicture", "", "Lcom/up366/common/callback/ICallbackCodeInfo;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerCameraXManager extends com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCameraXManager {
    private final com.up366.papercut.DetectLib detectLib;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoAnswerCameraXManager(androidx.camera.view.PreviewView previewView, com.up366.papercut.DetectLib detectLib, com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController.CameraControllerCallback cameraControllerCallback, com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        super(previewView, detectLib, cameraControllerCallback, session);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(previewView, "previewView");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(detectLib, "detectLib");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cameraControllerCallback, "callback");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "scanSession");
        this.detectLib = detectLib;
    }

    @Override // com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager
    public com.up366.mobile.course.p1p.PaperRecognitionResult handleAnalyse(com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.AnalyzeData data) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        java.lang.Object image = data.getImage();
        kotlin.jvm.internal.Intrinsics.checkNotNull(image, "null cannot be cast to non-null type androidx.camera.core.ImageProxy");
        androidx.camera.core.ImageProxy imageProxy = (androidx.camera.core.ImageProxy) image;
        int degrees = data.getDegrees();
        java.nio.ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(buffer, "getBuffer(...)");
        byte[] bArr = new byte[buffer.remaining()];
        buffer.get(bArr);
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        android.graphics.Rect cropRect = imageProxy.getCropRect();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cropRect, "getCropRect(...)");
        com.up366.mobile.course.p1p.PaperRecognitionResult paperRecognitionResult = new com.up366.mobile.course.p1p.PaperRecognitionResult(width, height, degrees, cropRect);
        com.up366.smartscan2.ConnerData connerDataFindConner = com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE.findConner(getScanSession(), com.up366.mobile.course.photoanswer.logic.utils.ImageProxyUtils.INSTANCE.convertRgbaToRgb(bArr, imageProxy.getWidth(), imageProxy.getHeight()), imageProxy.getWidth(), imageProxy.getHeight());
        paperRecognitionResult.setConnerData(connerDataFindConner, null);
        com.up366.mobile.course.photoanswer.logic.helper.SwitchHandHelper.INSTANCE.checking(connerDataFindConner);
        return paperRecognitionResult;
    }

    @Override // com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager
    public void toTakePicture(final com.up366.common.callback.ICallbackCodeInfo callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        androidx.camera.core.ImageCapture mImageCapture = getMImageCapture();
        if (mImageCapture == null) {
            ensureCameraReady();
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.reset();
            callback.onResult(-3, "");
            com.up366.common.log.Logger.error(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("takePictureError", "CameraX is not ready"));
            return;
        }
        mImageCapture.takePicture(getPictureExecutor(), new androidx.camera.core.ImageCapture.OnImageCapturedCallback() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCameraXManager.toTakePicture.1
            public void onError(androidx.camera.core.ImageCaptureException exception) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(exception, "exception");
                com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.reset();
                callback.onResult(-3, "");
                com.up366.common.log.Logger.error(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("takePictureError", java.lang.String.valueOf(exception.getMessage())), (java.lang.Throwable) exception);
            }

            public void onCaptureSuccess(androidx.camera.core.ImageProxy image) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(image, com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE);
                super.onCaptureSuccess(image);
                kotlinx.coroutines.BuildersKt.launch$default(this.getIoScope(), (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCameraXManager$toTakePicture$1$onCaptureSuccess$1(image, this, callback, null), 3, (java.lang.Object) null);
            }
        });
    }
}
