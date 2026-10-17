package com.up366.mobile.course.photoanswer.logic.cameraAlum;

/* JADX INFO: compiled from: PhotoAnswerCameraXManager.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCameraXManager$toTakePicture$1$onCaptureSuccess$1", f = "PhotoAnswerCameraXManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PhotoAnswerCameraXManager$toTakePicture$1$onCaptureSuccess$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ com.up366.common.callback.ICallbackCodeInfo $callback;
    final /* synthetic */ androidx.camera.core.ImageProxy $image;
    int label;
    final /* synthetic */ com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCameraXManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PhotoAnswerCameraXManager$toTakePicture$1$onCaptureSuccess$1(androidx.camera.core.ImageProxy imageProxy, com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCameraXManager photoAnswerCameraXManager, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo, kotlin.coroutines.Continuation<? super com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCameraXManager$toTakePicture$1$onCaptureSuccess$1> continuation) {
        super(2, continuation);
        this.$image = imageProxy;
        this.this$0 = photoAnswerCameraXManager;
        this.$callback = iCallbackCodeInfo;
    }

    public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
        return new com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoAnswerCameraXManager$toTakePicture$1$onCaptureSuccess$1(this.$image, this.this$0, this.$callback, continuation);
    }

    public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    public final java.lang.Object invokeSuspend(java.lang.Object obj) {
        java.lang.String str;
        java.lang.String str2;
        int rotationDegrees;
        android.graphics.Bitmap bitmapCreateBitmapFromImageProxy;
        kotlin.Unit unit;
        kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.ResultKt.throwOnFailure(obj);
        try {
            java.lang.String str3 = com.up366.mobile.course.photoanswer.logic.helper.TXPathHelper.INSTANCE.getTakePhotoPath() + android.os.SystemClock.uptimeMillis();
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.addPhotoStatus(str3, com.up366.mobile.course.photoanswer.logic.helper.SwitchHandHelper.INSTANCE.getCurTakePhotoType());
            str = str3 + "_s.jpg";
            str2 = str3 + "_c.jpg";
            rotationDegrees = this.$image.getImageInfo().getRotationDegrees();
            bitmapCreateBitmapFromImageProxy = androidx.camera.core.internal.utils.ImageUtil.createBitmapFromImageProxy(this.$image);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmapFromImageProxy, "createBitmapFromImageProxy(...)");
            com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.saveBitmap(str, bitmapCreateBitmapFromImageProxy, 2100, 2800, 75, rotationDegrees);
        } finally {
            try {
            } finally {
            }
        }
        if (this.this$0.getBlurHelper().checkBlur(bitmapCreateBitmapFromImageProxy, str)) {
            this.$callback.onResult(-1, str);
            com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.gcBitmap(bitmapCreateBitmapFromImageProxy);
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.end();
            unit = kotlin.Unit.INSTANCE;
        } else {
            com.up366.smartscan2.ConnerData connerDataFindConner = com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE.findConner(this.this$0.getScanSession(), com.up366.mobile.course.photoanswer.logic.utils.ImageProxyUtils.INSTANCE.convertBitmapRgbaToRgb(bitmapCreateBitmapFromImageProxy), bitmapCreateBitmapFromImageProxy.getWidth(), bitmapCreateBitmapFromImageProxy.getHeight());
            if (connerDataFindConner.getErrorCode() == 2) {
                com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.gcBitmap(bitmapCreateBitmapFromImageProxy);
                this.$callback.onResult(-4, str);
                com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.end();
                unit = kotlin.Unit.INSTANCE;
            } else {
                if (connerDataFindConner.getErrorCode() == 1 || connerDataFindConner.getErrorCode() == 3) {
                    android.graphics.Bitmap bitmapCropImage = com.up366.mobile.course.photoanswer.logic.utils.CropBitmapUtils.INSTANCE.cropImage(this.this$0.detectLib, bitmapCreateBitmapFromImageProxy, connerDataFindConner);
                    com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.saveBitmap(str2, bitmapCropImage, 2100, 2800, 75, rotationDegrees);
                    com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.gcBitmap(bitmapCropImage);
                }
                com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.gcBitmap(bitmapCreateBitmapFromImageProxy);
                if (connerDataFindConner.getErrorCode() == 3) {
                    str = str2;
                }
                this.$callback.onResult(0, str);
                com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.end();
                this.$image.close();
                return kotlin.Unit.INSTANCE;
            }
        }
        return unit;
    }
}
