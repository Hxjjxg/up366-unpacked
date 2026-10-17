package com.up366.mobile.course.photoanswer.logic.cameraAlum;

/* JADX INFO: compiled from: PhotoAnswerCamera2Manager.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/PhotoAnswerCamera2Manager;", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerCamera2Manager;", "textureView", "Landroid/view/TextureView;", "detectLib", "Lcom/up366/papercut/DetectLib;", "callback", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController$CameraControllerCallback;", "scanSession", "Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;", "<init>", "(Landroid/view/TextureView;Lcom/up366/papercut/DetectLib;Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController$CameraControllerCallback;Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;)V", "handleAnalyse", "Lcom/up366/mobile/course/p1p/PaperRecognitionResult;", "data", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerManager$AnalyzeData;", "handleTakePicture", "", com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE, "Landroid/media/Image;", "Lcom/up366/common/callback/ICallbackCodeInfo;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerCamera2Manager extends com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager {
    private final com.up366.papercut.DetectLib detectLib;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoAnswerCamera2Manager(android.view.TextureView textureView, com.up366.papercut.DetectLib detectLib, com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController.CameraControllerCallback cameraControllerCallback, com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        super(textureView, detectLib, cameraControllerCallback, session);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(textureView, "textureView");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(detectLib, "detectLib");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cameraControllerCallback, "callback");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "scanSession");
        this.detectLib = detectLib;
    }

    @Override // com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager
    public com.up366.mobile.course.p1p.PaperRecognitionResult handleAnalyse(com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.AnalyzeData data) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        java.lang.Object image = data.getImage();
        kotlin.jvm.internal.Intrinsics.checkNotNull(image, "null cannot be cast to non-null type android.media.Image");
        android.media.Image image2 = (android.media.Image) image;
        int degrees = data.getDegrees();
        com.up366.smartscan2.ConnerData connerDataFindConner = com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE.findConner(getScanSession(), getRgbData(image2), image2.getWidth(), image2.getHeight());
        int width = image2.getWidth();
        int height = image2.getHeight();
        android.graphics.Rect cropRect = image2.getCropRect();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cropRect, "getCropRect(...)");
        com.up366.mobile.course.p1p.PaperRecognitionResult paperRecognitionResult = new com.up366.mobile.course.p1p.PaperRecognitionResult(width, height, degrees, cropRect);
        paperRecognitionResult.setConnerData(connerDataFindConner, getCameraPreviewData());
        com.up366.mobile.course.photoanswer.logic.helper.SwitchHandHelper.INSTANCE.checking(connerDataFindConner);
        return paperRecognitionResult;
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCamera2Manager$handleTakePicture$1, reason: invalid class name */
    /* JADX INFO: compiled from: PhotoAnswerCamera2Manager.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCamera2Manager$handleTakePicture$1", f = "PhotoAnswerCamera2Manager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ com.up366.common.callback.ICallbackCodeInfo $callback;
        final /* synthetic */ android.media.Image $image;
        int label;
        final /* synthetic */ com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCamera2Manager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(android.media.Image image, com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCamera2Manager photoAnswerCamera2Manager, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo, kotlin.coroutines.Continuation<? super com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCamera2Manager.AnonymousClass1> continuation) {
            super(2, continuation);
            this.$image = image;
            this.this$0 = photoAnswerCamera2Manager;
            this.$callback = iCallbackCodeInfo;
        }

        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            return new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCamera2Manager.AnonymousClass1(this.$image, this.this$0, this.$callback, continuation);
        }

        public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            java.lang.String str;
            java.lang.String str2;
            java.lang.String str3;
            int deviceRotation;
            android.graphics.Bitmap bitmapDecodeByteArray;
            int i;
            kotlin.Unit unit;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            try {
                java.nio.ByteBuffer buffer = this.$image.getPlanes()[0].getBuffer();
                int iRemaining = buffer.remaining();
                byte[] bArr = new byte[iRemaining];
                buffer.get(bArr);
                str = com.up366.mobile.course.photoanswer.logic.helper.TXPathHelper.INSTANCE.getTakePhotoPath() + android.os.SystemClock.uptimeMillis();
                str2 = str + "_s.jpg";
                str3 = str + "_c.jpg";
                deviceRotation = this.this$0.getDeviceRotation();
                bitmapDecodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArr, 0, iRemaining);
            } finally {
                try {
                } finally {
                }
            }
            if (bitmapDecodeByteArray == null) {
                com.up366.common.log.Logger.error("takePictureError: baseBitmap is null");
                com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.reset();
                this.$callback.onResult(-3, "");
                unit = kotlin.Unit.INSTANCE;
            } else {
                com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.addPhotoStatus(str, com.up366.mobile.course.photoanswer.logic.helper.SwitchHandHelper.INSTANCE.getCurTakePhotoType());
                com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.saveBitmap(str2, bitmapDecodeByteArray, 2100, 2800, 75, deviceRotation);
                if (this.this$0.getBlurHelper().checkBlur(bitmapDecodeByteArray, str2)) {
                    this.$callback.onResult(-1, str2);
                    com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.gcBitmap(bitmapDecodeByteArray);
                    com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.end();
                    unit = kotlin.Unit.INSTANCE;
                } else {
                    com.up366.smartscan2.ConnerData connerDataFindConner = com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE.findConner(this.this$0.getScanSession(), com.up366.mobile.course.photoanswer.logic.utils.ImageProxyUtils.INSTANCE.convertBitmapRgbaToRgb(bitmapDecodeByteArray), bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight());
                    if (connerDataFindConner.getErrorCode() == 2) {
                        com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.gcBitmap(bitmapDecodeByteArray);
                        this.$callback.onResult(-4, str2);
                        com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.end();
                        unit = kotlin.Unit.INSTANCE;
                    } else {
                        if (connerDataFindConner.getErrorCode() == 1 || connerDataFindConner.getErrorCode() == 3) {
                            android.graphics.Bitmap bitmapCropImage = com.up366.mobile.course.photoanswer.logic.utils.CropBitmapUtils.INSTANCE.cropImage(this.this$0.detectLib, bitmapDecodeByteArray, connerDataFindConner);
                            i = 3;
                            com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.saveBitmap(str3, bitmapCropImage, 2100, 2800, 75, deviceRotation);
                            com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.gcBitmap(bitmapCropImage);
                        } else {
                            i = 3;
                        }
                        com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.gcBitmap(bitmapDecodeByteArray);
                        if (connerDataFindConner.getErrorCode() == i) {
                            str2 = str3;
                        }
                        this.$callback.onResult(0, str2);
                        com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.end();
                        this.$image.close();
                        return kotlin.Unit.INSTANCE;
                    }
                }
            }
            return unit;
        }
    }

    @Override // com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerCamera2Manager
    public void handleTakePicture(android.media.Image image, com.up366.common.callback.ICallbackCodeInfo callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(image, com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        kotlinx.coroutines.BuildersKt.launch$default(getIoScope(), (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCamera2Manager.AnonymousClass1(image, this, callback, null), 3, (java.lang.Object) null);
    }
}
