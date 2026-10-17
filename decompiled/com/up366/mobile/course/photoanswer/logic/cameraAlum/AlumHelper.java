package com.up366.mobile.course.photoanswer.logic.cameraAlum;

/* JADX INFO: compiled from: AlumHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u000fJD\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u000fH\u0002J\u0006\u0010\u0019\u001a\u00020\tJ\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/AlumHelper;", "", "scanSession", "Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;", "<init>", "(Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;)V", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "alumPicture", "", "mediaInfo", "Lcom/up366/medialibrary/MediaInfo;", "detectLib", "Lcom/up366/papercut/DetectLib;", "callback", "Lkotlin/Function1;", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/PhotoCorrectImageData;", "checkImage", "imagePath", "", "cropImagePath", "baseBitmap", "Landroid/graphics/Bitmap;", "rotationDegrees", "", "onDestroy", "getExifOrientation", "filepath", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AlumHelper {
    private final kotlinx.coroutines.CoroutineScope ioScope;
    private final com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session scanSession;

    public AlumHelper(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "scanSession");
        this.scanSession = session;
        this.ioScope = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(kotlinx.coroutines.Dispatchers.getIO().plus(kotlinx.coroutines.SupervisorKt.SupervisorJob$default((kotlinx.coroutines.Job) null, 1, (java.lang.Object) null)));
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.photoanswer.logic.cameraAlum.AlumHelper$alumPicture$1, reason: invalid class name */
    /* JADX INFO: compiled from: AlumHelper.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.up366.mobile.course.photoanswer.logic.cameraAlum.AlumHelper$alumPicture$1", f = "AlumHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ kotlin.jvm.functions.Function1<com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData, kotlin.Unit> $callback;
        final /* synthetic */ com.up366.papercut.DetectLib $detectLib;
        final /* synthetic */ com.up366.medialibrary.MediaInfo $mediaInfo;
        int label;
        final /* synthetic */ com.up366.mobile.course.photoanswer.logic.cameraAlum.AlumHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(com.up366.medialibrary.MediaInfo mediaInfo, kotlin.jvm.functions.Function1<? super com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData, kotlin.Unit> function1, com.up366.mobile.course.photoanswer.logic.cameraAlum.AlumHelper alumHelper, com.up366.papercut.DetectLib detectLib, kotlin.coroutines.Continuation<? super com.up366.mobile.course.photoanswer.logic.cameraAlum.AlumHelper.AnonymousClass1> continuation) {
            super(2, continuation);
            this.$mediaInfo = mediaInfo;
            this.$callback = function1;
            this.this$0 = alumHelper;
            this.$detectLib = detectLib;
        }

        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            return new com.up366.mobile.course.photoanswer.logic.cameraAlum.AlumHelper.AnonymousClass1(this.$mediaInfo, this.$callback, this.this$0, this.$detectLib, continuation);
        }

        public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        public final java.lang.Object invokeSuspend(java.lang.Object obj) throws java.lang.Throwable {
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.start();
            java.lang.String str = (com.up366.mobile.course.p1p.P1pPathHelper.INSTANCE.getTakePhotoPath() + android.os.SystemClock.uptimeMillis()) + "_hand.jpg";
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.addPhotoStatus(str, 0);
            com.up366.common.BitmapUtilsUp.compressBitmap(str, this.$mediaInfo.getRealPath(), 2800, 4000, 95);
            android.graphics.Bitmap bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile(str);
            if (bitmapDecodeFile == null) {
                com.up366.common.log.Logger.error(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("alumPicture", "decodeFile failed, mediaInfo:" + this.$mediaInfo));
                this.$callback.invoke(new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData(-6, str, 0));
                return kotlin.Unit.INSTANCE;
            }
            android.graphics.Bitmap bitmapBitmapScale = com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.bitmapScale(bitmapDecodeFile, 400);
            int width = bitmapBitmapScale.getWidth();
            int height = bitmapBitmapScale.getHeight();
            java.nio.ByteBuffer byteBufferBitmapToByteBuffer = com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.bitmapToByteBuffer(bitmapBitmapScale);
            com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.gcBitmap(bitmapBitmapScale);
            int exifOrientation = this.this$0.getExifOrientation(str);
            com.up366.common.log.Logger.info(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("alumPicture", "rotationDegrees:" + exifOrientation));
            java.util.List<com.up366.papercut.Detect> listDetectImage = this.$detectLib.detectImage(byteBufferBitmapToByteBuffer, width, height, exifOrientation);
            com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.gcByteBuffer(byteBufferBitmapToByteBuffer);
            if (listDetectImage.size() != 4) {
                com.up366.mobile.course.photoanswer.logic.cameraAlum.AlumHelper alumHelper = this.this$0;
                java.lang.String realPath = this.$mediaInfo.getRealPath();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(realPath, "getRealPath(...)");
                alumHelper.checkImage(realPath, str, bitmapDecodeFile, exifOrientation, this.$detectLib, this.$callback);
                com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.gcBitmap(bitmapDecodeFile);
                com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.end();
                return kotlin.Unit.INSTANCE;
            }
            int[] iArrDetectsToCropCoordinate = com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.detectsToCropCoordinate(listDetectImage, bitmapDecodeFile.getWidth() / width, bitmapDecodeFile.getHeight() / height);
            android.graphics.Bitmap bitmapCropCoordinateToNewBitmap = com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.cropCoordinateToNewBitmap(iArrDetectsToCropCoordinate);
            this.$detectLib.perspectiveCorrection(bitmapDecodeFile, bitmapCropCoordinateToNewBitmap, iArrDetectsToCropCoordinate);
            com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.saveBitmap(str, bitmapCropCoordinateToNewBitmap, 3600, 4800, 90, exifOrientation);
            com.up366.mobile.course.photoanswer.logic.cameraAlum.AlumHelper alumHelper2 = this.this$0;
            java.lang.String realPath2 = this.$mediaInfo.getRealPath();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(realPath2, "getRealPath(...)");
            alumHelper2.checkImage(realPath2, str, bitmapDecodeFile, exifOrientation, this.$detectLib, this.$callback);
            com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.gcBitmap(bitmapCropCoordinateToNewBitmap, bitmapDecodeFile);
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.end();
            return kotlin.Unit.INSTANCE;
        }
    }

    public final void alumPicture(com.up366.medialibrary.MediaInfo mediaInfo, com.up366.papercut.DetectLib detectLib, kotlin.jvm.functions.Function1<? super com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData, kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(detectLib, "detectLib");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        kotlinx.coroutines.BuildersKt.launch$default(this.ioScope, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new com.up366.mobile.course.photoanswer.logic.cameraAlum.AlumHelper.AnonymousClass1(mediaInfo, callback, this, detectLib, null), 3, (java.lang.Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkImage(java.lang.String imagePath, java.lang.String cropImagePath, android.graphics.Bitmap baseBitmap, int rotationDegrees, com.up366.papercut.DetectLib detectLib, kotlin.jvm.functions.Function1<? super com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData, kotlin.Unit> callback) throws java.lang.Throwable {
        com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.saveBitmap(cropImagePath, baseBitmap, 3600, 4800, 90, rotationDegrees);
        com.up366.smartscan2.ConnerData connerDataFindConner = com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE.findConner(this.scanSession, cropImagePath);
        com.up366.common.log.Logger.info(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("alumPicture", "findConner imageSize:" + baseBitmap.getWidth() + "x" + baseBitmap.getHeight() + ", rotationDegrees:" + rotationDegrees + ", result:" + connerDataFindConner));
        if (connerDataFindConner.getErrorCode() == 2) {
            callback.invoke(new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData(-4, cropImagePath, connerDataFindConner.getErrorCode()));
            return;
        }
        if (connerDataFindConner.getErrorCode() == 0 || connerDataFindConner.getConfidence()[0] < 0.6d) {
            callback.invoke(new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData(-5, cropImagePath, connerDataFindConner.getErrorCode()));
            return;
        }
        if (new com.up366.mobile.course.p1p.helper.BlurHelper(detectLib).checkBlur(baseBitmap, imagePath)) {
            callback.invoke(new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData(-1, imagePath, connerDataFindConner.getErrorCode()));
            return;
        }
        if (connerDataFindConner.getErrorCode() == 3) {
            android.graphics.Bitmap bitmapCropImage = com.up366.mobile.course.photoanswer.logic.utils.CropBitmapUtils.INSTANCE.cropImage(detectLib, baseBitmap, connerDataFindConner);
            com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.saveBitmap(cropImagePath, bitmapCropImage, 3600, 4800, 90, rotationDegrees);
            com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.gcBitmap(bitmapCropImage);
        }
        callback.invoke(new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData(0, cropImagePath, connerDataFindConner.getErrorCode()));
    }

    public final void onDestroy() {
        kotlinx.coroutines.CoroutineScopeKt.cancel$default(this.ioScope, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getExifOrientation(java.lang.String filepath) {
        try {
            int attributeInt = new android.media.ExifInterface(filepath).getAttributeInt("Orientation", -1);
            if (attributeInt == -1) {
                return 0;
            }
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (java.io.IOException e) {
            com.up366.common.log.Logger.error(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("getExifOrientation", "error:" + e.getMessage()));
            return 0;
        }
    }
}
