package com.up366.mobile.course.photoanswer.logic.cameraAlum;

/* JADX INFO: compiled from: BasePhotoAnswerManager.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001:\u0003EFGB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020/2\u0006\u00101\u001a\u000202J\u0010\u00103\u001a\u0002042\u0006\u00101\u001a\u000202H&J\u0010\u00105\u001a\u00020/2\u0006\u0010\u0004\u001a\u000206H&J\b\u00107\u001a\u00020/H&J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0004J\u0010\u0010<\u001a\u00020=2\u0006\u0010:\u001a\u00020;H\u0004J\u0010\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u0018H\u0004J\u0006\u0010\u0012\u001a\u00020/J\b\u0010@\u001a\u00020/H\u0014J\u0010\u0010A\u001a\u00020/2\b\b\u0002\u0010B\u001a\u00020\rJ\u000e\u0010C\u001a\u00020/2\u0006\u0010D\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006H"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerManager;", "", "detectLib", "Lcom/up366/papercut/DetectLib;", "callback", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController$CameraControllerCallback;", "scanSession", "Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;", "<init>", "(Lcom/up366/papercut/DetectLib;Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController$CameraControllerCallback;Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;)V", "getScanSession", "()Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;", "activityIsShowing", "", "getActivityIsShowing", "()Z", "setActivityIsShowing", "(Z)V", "startAnalyzer", "stopTime", "", "isCameraActive", "lastAnalyzerTime", "sensorOrientation", "", "getSensorOrientation", "()I", "setSensorOrientation", "(I)V", "needUpdateTransformation", "getNeedUpdateTransformation", "setNeedUpdateTransformation", "cameraPreviewData", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerManager$CameraPreviewData;", "getCameraPreviewData", "()Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerManager$CameraPreviewData;", "setCameraPreviewData", "(Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerManager$CameraPreviewData;)V", "orientationMap", "Landroid/util/SparseIntArray;", "getOrientationMap", "()Landroid/util/SparseIntArray;", "blurHelper", "Lcom/up366/mobile/course/p1p/helper/BlurHelper;", "getBlurHelper", "()Lcom/up366/mobile/course/p1p/helper/BlurHelper;", "takePicture", "", "analyze", "data", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerManager$AnalyzeData;", "handleAnalyse", "Lcom/up366/mobile/course/p1p/PaperRecognitionResult;", "toTakePicture", "Lcom/up366/common/callback/ICallbackCodeInfo;", "onDestroy", "getRgbData", "", com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE, "Landroid/media/Image;", "getRgbDataByteBuffer", "Ljava/nio/ByteBuffer;", "getJpegOrientation", "deviceRotation", "ensureCameraReady", "stopAnalyzer", "resetStaticTime", "setActiveCamera", "front", "AnalyzeData", "CompareSizesByArea", "CameraPreviewData", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class BasePhotoAnswerManager {
    private volatile boolean activityIsShowing;
    private final com.up366.mobile.course.p1p.helper.BlurHelper blurHelper;
    private final com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController.CameraControllerCallback callback;
    private com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.CameraPreviewData cameraPreviewData;
    private final com.up366.papercut.DetectLib detectLib;
    private boolean isCameraActive;
    private long lastAnalyzerTime;
    private boolean needUpdateTransformation;
    private final android.util.SparseIntArray orientationMap;
    private final com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session scanSession;
    private int sensorOrientation;
    private volatile boolean startAnalyzer;
    private long stopTime;

    protected void ensureCameraReady() {
    }

    public abstract com.up366.mobile.course.p1p.PaperRecognitionResult handleAnalyse(com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.AnalyzeData data);

    public abstract void onDestroy();

    public abstract void toTakePicture(com.up366.common.callback.ICallbackCodeInfo callback);

    public BasePhotoAnswerManager(com.up366.papercut.DetectLib detectLib, com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController.CameraControllerCallback cameraControllerCallback, com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(detectLib, "detectLib");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cameraControllerCallback, "callback");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "scanSession");
        this.detectLib = detectLib;
        this.callback = cameraControllerCallback;
        this.scanSession = session;
        this.activityIsShowing = true;
        this.isCameraActive = true;
        this.needUpdateTransformation = true;
        this.cameraPreviewData = new com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.CameraPreviewData(new android.util.Size(0, 0), new android.util.Size(0, 0));
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        this.orientationMap = sparseIntArray;
        this.blurHelper = new com.up366.mobile.course.p1p.helper.BlurHelper(detectLib);
        sparseIntArray.append(0, 0);
        sparseIntArray.append(90, 90);
        sparseIntArray.append(180, 180);
        sparseIntArray.append(270, 270);
    }

    protected final com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session getScanSession() {
        return this.scanSession;
    }

    public final boolean getActivityIsShowing() {
        return this.activityIsShowing;
    }

    public final void setActivityIsShowing(boolean z) {
        this.activityIsShowing = z;
    }

    protected final int getSensorOrientation() {
        return this.sensorOrientation;
    }

    protected final void setSensorOrientation(int i) {
        this.sensorOrientation = i;
    }

    public final boolean getNeedUpdateTransformation() {
        return this.needUpdateTransformation;
    }

    public final void setNeedUpdateTransformation(boolean z) {
        this.needUpdateTransformation = z;
    }

    public final com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.CameraPreviewData getCameraPreviewData() {
        return this.cameraPreviewData;
    }

    public final void setCameraPreviewData(com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.CameraPreviewData cameraPreviewData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cameraPreviewData, "<set-?>");
        this.cameraPreviewData = cameraPreviewData;
    }

    protected final android.util.SparseIntArray getOrientationMap() {
        return this.orientationMap;
    }

    protected final com.up366.mobile.course.p1p.helper.BlurHelper getBlurHelper() {
        return this.blurHelper;
    }

    /* JADX INFO: compiled from: BasePhotoAnswerManager.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerManager$AnalyzeData;", "", "width", "", "height", "degrees", com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE, "<init>", "(IIILjava/lang/Object;)V", "getWidth", "()I", "getHeight", "getDegrees", "getImage", "()Ljava/lang/Object;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnalyzeData {
        private final int degrees;
        private final int height;
        private final java.lang.Object image;
        private final int width;

        public AnalyzeData(int i, int i2, int i3, java.lang.Object obj) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(obj, com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE);
            this.width = i;
            this.height = i2;
            this.degrees = i3;
            this.image = obj;
        }

        public final int getDegrees() {
            return this.degrees;
        }

        public final int getHeight() {
            return this.height;
        }

        public final java.lang.Object getImage() {
            return this.image;
        }

        public final int getWidth() {
            return this.width;
        }
    }

    public final void takePicture() {
        stopAnalyzer(false);
        if (!this.activityIsShowing || this.scanSession.isClosed()) {
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.reset();
            return;
        }
        if (!this.isCameraActive) {
            com.up366.common.log.Logger.error("Camera is inactive, skipping handleAnalyse");
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.reset();
            this.callback.onTakePhotoCallback(new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData(-3, "", 0));
        } else {
            ensureCameraReady();
            com.up366.mobile.course.photoanswer.logic.helper.SwitchHandHelper.INSTANCE.reset();
            com.up366.mobile.course.p1p.helper.P1pStatusHelper.INSTANCE.takingPhoto();
            toTakePicture(new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager$$ExternalSyntheticLambda0
                @Override // com.up366.common.callback.ICallbackCodeInfo
                public final void onResult(int i, java.lang.String str) {
                    com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.takePicture$lambda$1(this.f$0, i, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void takePicture$lambda$1(final com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager basePhotoAnswerManager, int i, java.lang.String str) {
        com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLogWithUploadFile("scanOneImage", "status:" + i + " ", str);
        com.up366.mobile.course.p1p.helper.P1pStatusHelper.INSTANCE.reset();
        if (basePhotoAnswerManager.activityIsShowing) {
            if (i == -108) {
                basePhotoAnswerManager.callback.onTakePhotoCallback(new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData(-108, str, com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE.getLastImageType(basePhotoAnswerManager.scanSession)));
                com.up366.common.task.TaskUtils.postMainTaskDelay(1500L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager$$ExternalSyntheticLambda1
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        this.f$0.startAnalyzer();
                    }
                });
                return;
            }
            if (i == -4) {
                basePhotoAnswerManager.callback.onTakePhotoCallback(new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData(-4, str, com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE.getLastImageType(basePhotoAnswerManager.scanSession)));
                return;
            }
            if (i == -2 || i == -1) {
                basePhotoAnswerManager.callback.onTakePhotoCallback(new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData(i, str, com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE.getLastImageType(basePhotoAnswerManager.scanSession)));
                basePhotoAnswerManager.startAnalyzer();
            } else {
                if (i == -3) {
                    basePhotoAnswerManager.startAnalyzer();
                    return;
                }
                if (i == -5) {
                    basePhotoAnswerManager.callback.onTakePhotoCallback(new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData(-5, str, com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE.getLastImageType(basePhotoAnswerManager.scanSession)));
                } else {
                    if (com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE.isShowing()) {
                        return;
                    }
                    com.up366.mobile.course.photoanswer.common.PhotoCorrectMediaUtils.INSTANCE.takePictureVoice();
                    basePhotoAnswerManager.callback.onTakePhotoCallback(new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData(0, str, com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE.getLastImageType(basePhotoAnswerManager.scanSession)));
                }
            }
        }
    }

    public final void analyze(com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.AnalyzeData data) {
        java.lang.Object image;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        try {
            try {
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("analyzeErrorV2 " + e.getMessage(), e);
                image = data.getImage();
                if (image instanceof androidx.camera.core.ImageProxy) {
                    ((androidx.camera.core.ImageProxy) image).close();
                }
                if (!(image instanceof android.media.Image)) {
                    return;
                }
            }
            if (this.activityIsShowing && !this.scanSession.isClosed() && !com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE.isShowing()) {
                if (!this.startAnalyzer) {
                    java.lang.Object image2 = data.getImage();
                    if (image2 instanceof androidx.camera.core.ImageProxy) {
                        ((androidx.camera.core.ImageProxy) image2).close();
                    }
                    if (image2 instanceof android.media.Image) {
                        ((android.media.Image) image2).close();
                        return;
                    }
                    return;
                }
                if (data.getWidth() > 0 && data.getHeight() > 0 && data.getDegrees() >= 0) {
                    if (com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - this.lastAnalyzerTime < 150) {
                        java.lang.Object image3 = data.getImage();
                        if (image3 instanceof androidx.camera.core.ImageProxy) {
                            ((androidx.camera.core.ImageProxy) image3).close();
                        }
                        if (image3 instanceof android.media.Image) {
                            ((android.media.Image) image3).close();
                            return;
                        }
                        return;
                    }
                    this.lastAnalyzerTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
                    if (!this.isCameraActive) {
                        com.up366.common.log.Logger.error("Camera is inactive, skipping handleAnalyse");
                        java.lang.Object image4 = data.getImage();
                        if (image4 instanceof androidx.camera.core.ImageProxy) {
                            ((androidx.camera.core.ImageProxy) image4).close();
                        }
                        if (image4 instanceof android.media.Image) {
                            ((android.media.Image) image4).close();
                            return;
                        }
                        return;
                    }
                    com.up366.mobile.course.p1p.PaperRecognitionResult paperRecognitionResultHandleAnalyse = handleAnalyse(data);
                    if (paperRecognitionResultHandleAnalyse.getStatus() == 0) {
                        com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.start();
                    }
                    this.callback.analyzeResult(paperRecognitionResultHandleAnalyse);
                    image = data.getImage();
                    if (image instanceof androidx.camera.core.ImageProxy) {
                        ((androidx.camera.core.ImageProxy) image).close();
                    }
                    if (!(image instanceof android.media.Image)) {
                        return;
                    }
                    ((android.media.Image) image).close();
                    return;
                }
                java.lang.Object image5 = data.getImage();
                if (image5 instanceof androidx.camera.core.ImageProxy) {
                    ((androidx.camera.core.ImageProxy) image5).close();
                }
                if (image5 instanceof android.media.Image) {
                    ((android.media.Image) image5).close();
                    return;
                }
                return;
            }
            java.lang.Object image6 = data.getImage();
            if (image6 instanceof androidx.camera.core.ImageProxy) {
                ((androidx.camera.core.ImageProxy) image6).close();
            }
            if (image6 instanceof android.media.Image) {
                ((android.media.Image) image6).close();
            }
        } catch (java.lang.Throwable th) {
            java.lang.Object image7 = data.getImage();
            if (image7 instanceof androidx.camera.core.ImageProxy) {
                ((androidx.camera.core.ImageProxy) image7).close();
            }
            if (image7 instanceof android.media.Image) {
                ((android.media.Image) image7).close();
            }
            throw th;
        }
    }

    protected final byte[] getRgbData(android.media.Image image) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(image, com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE);
        java.nio.ByteBuffer rgbDataByteBuffer = getRgbDataByteBuffer(image);
        byte[] bArr = new byte[rgbDataByteBuffer.remaining()];
        rgbDataByteBuffer.get(bArr);
        return bArr;
    }

    protected final java.nio.ByteBuffer getRgbDataByteBuffer(android.media.Image image) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(image, com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE);
        android.media.Image.Plane[] planes = image.getPlanes();
        int width = image.getWidth();
        int height = image.getHeight();
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(width * height * 3);
        com.up366.yuv.YuvUtils yuvUtils = com.up366.yuv.YuvUtils.INSTANCE;
        java.nio.ByteBuffer buffer = planes[0].getBuffer();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(buffer, "getBuffer(...)");
        java.nio.ByteBuffer buffer2 = planes[1].getBuffer();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(buffer2, "getBuffer(...)");
        java.nio.ByteBuffer buffer3 = planes[2].getBuffer();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(buffer3, "getBuffer(...)");
        int rowStride = planes[0].getRowStride();
        int rowStride2 = planes[1].getRowStride();
        int rowStride3 = planes[2].getRowStride();
        int pixelStride = planes[1].getPixelStride();
        int pixelStride2 = planes[2].getPixelStride();
        kotlin.jvm.internal.Intrinsics.checkNotNull(byteBufferAllocateDirect);
        yuvUtils.convertYUV420ToRGB(buffer, buffer2, buffer3, width, height, rowStride, rowStride2, rowStride3, pixelStride, pixelStride2, byteBufferAllocateDirect);
        return byteBufferAllocateDirect;
    }

    protected final int getJpegOrientation(int deviceRotation) {
        return ((this.sensorOrientation - deviceRotation) + 360) % 360;
    }

    public final void startAnalyzer() {
        ensureCameraReady();
        this.startAnalyzer = true;
    }

    public static /* synthetic */ void stopAnalyzer$default(com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager basePhotoAnswerManager, boolean z, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopAnalyzer");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        basePhotoAnswerManager.stopAnalyzer(z);
    }

    public final void stopAnalyzer(boolean resetStaticTime) {
        if (resetStaticTime) {
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.reset();
        }
        this.startAnalyzer = false;
        this.stopTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
    }

    public final void setActiveCamera(boolean front) {
        this.isCameraActive = front;
    }

    /* JADX INFO: compiled from: BasePhotoAnswerManager.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerManager$CompareSizesByArea;", "Ljava/util/Comparator;", "Landroid/util/Size;", "Lkotlin/Comparator;", "<init>", "()V", "compare", "", "lhs", "rhs", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CompareSizesByArea implements java.util.Comparator<android.util.Size> {
        @Override // java.util.Comparator
        public int compare(android.util.Size lhs, android.util.Size rhs) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lhs, "lhs");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rhs, "rhs");
            return java.lang.Long.signum((((long) lhs.getWidth()) * ((long) lhs.getHeight())) - (((long) rhs.getWidth()) * ((long) rhs.getHeight())));
        }
    }

    /* JADX INFO: compiled from: BasePhotoAnswerManager.kt */
    @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerManager$CameraPreviewData;", "", "viewSize", "Landroid/util/Size;", "previewSize", "<init>", "(Landroid/util/Size;Landroid/util/Size;)V", "getViewSize", "()Landroid/util/Size;", "setViewSize", "(Landroid/util/Size;)V", "getPreviewSize", "setPreviewSize", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class CameraPreviewData {
        private android.util.Size previewSize;
        private android.util.Size viewSize;

        public static /* synthetic */ com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.CameraPreviewData copy$default(com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.CameraPreviewData cameraPreviewData, android.util.Size size, android.util.Size size2, int i, java.lang.Object obj) {
            if ((i & 1) != 0) {
                size = cameraPreviewData.viewSize;
            }
            if ((i & 2) != 0) {
                size2 = cameraPreviewData.previewSize;
            }
            return cameraPreviewData.copy(size, size2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final android.util.Size getViewSize() {
            return this.viewSize;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final android.util.Size getPreviewSize() {
            return this.previewSize;
        }

        public final com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.CameraPreviewData copy(android.util.Size viewSize, android.util.Size previewSize) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewSize, "viewSize");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(previewSize, "previewSize");
            return new com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.CameraPreviewData(viewSize, previewSize);
        }

        public boolean equals(java.lang.Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.CameraPreviewData)) {
                return false;
            }
            com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.CameraPreviewData cameraPreviewData = (com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.CameraPreviewData) other;
            return kotlin.jvm.internal.Intrinsics.areEqual(this.viewSize, cameraPreviewData.viewSize) && kotlin.jvm.internal.Intrinsics.areEqual(this.previewSize, cameraPreviewData.previewSize);
        }

        public int hashCode() {
            return (this.viewSize.hashCode() * 31) + this.previewSize.hashCode();
        }

        public java.lang.String toString() {
            return "CameraPreviewData(viewSize=" + this.viewSize + ", previewSize=" + this.previewSize + ")";
        }

        public CameraPreviewData(android.util.Size size, android.util.Size size2) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(size, "viewSize");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(size2, "previewSize");
            this.viewSize = size;
            this.previewSize = size2;
        }

        public final android.util.Size getPreviewSize() {
            return this.previewSize;
        }

        public final android.util.Size getViewSize() {
            return this.viewSize;
        }

        public final void setPreviewSize(android.util.Size size) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(size, "<set-?>");
            this.previewSize = size;
        }

        public final void setViewSize(android.util.Size size) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(size, "<set-?>");
            this.viewSize = size;
        }
    }
}
