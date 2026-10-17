package com.up366.mobile.course.photoanswer.logic.cameraAlum;

/* JADX INFO: compiled from: CheckHandHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CheckHandHelper;", "", "<init>", "()V", "imageLabeler", "Lcom/google/mlkit/vision/label/ImageLabeler;", "checkImage", "", "bitmap", "Landroid/graphics/Bitmap;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CheckHandHelper {
    public static final com.up366.mobile.course.photoanswer.logic.cameraAlum.CheckHandHelper INSTANCE = new com.up366.mobile.course.photoanswer.logic.cameraAlum.CheckHandHelper();
    private static final com.google.mlkit.vision.label.ImageLabeler imageLabeler;

    private CheckHandHelper() {
    }

    static {
        com.google.mlkit.vision.label.ImageLabeler client = com.google.mlkit.vision.label.ImageLabeling.getClient(com.google.mlkit.vision.label.defaults.ImageLabelerOptions.DEFAULT_OPTIONS);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        imageLabeler = client;
    }

    public final boolean checkImage(android.graphics.Bitmap bitmap) throws java.lang.InterruptedException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final kotlin.jvm.internal.Ref.BooleanRef booleanRef = new kotlin.jvm.internal.Ref.BooleanRef();
        com.google.android.gms.tasks.Task taskProcess = imageLabeler.process(com.google.mlkit.vision.common.InputImage.fromBitmap(bitmap, 0));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(taskProcess, "process(...)");
        taskProcess.addOnCompleteListener(new com.google.android.gms.tasks.OnCompleteListener() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.CheckHandHelper$$ExternalSyntheticLambda0
            public final void onComplete(com.google.android.gms.tasks.Task task) {
                com.up366.mobile.course.photoanswer.logic.cameraAlum.CheckHandHelper.checkImage$lambda$1(booleanRef, countDownLatch, task);
            }
        });
        countDownLatch.await();
        return booleanRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkImage$lambda$1(kotlin.jvm.internal.Ref.BooleanRef booleanRef, java.util.concurrent.CountDownLatch countDownLatch, com.google.android.gms.tasks.Task task) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(task, "task1");
        boolean z = false;
        if (task.getResult() == null) {
            booleanRef.element = false;
            countDownLatch.countDown();
            return;
        }
        java.lang.Object result = task.getResult();
        kotlin.jvm.internal.Intrinsics.checkNotNull(result);
        java.lang.Iterable iterable = (java.lang.Iterable) result;
        if (!(iterable instanceof java.util.Collection) || !((java.util.Collection) iterable).isEmpty()) {
            java.util.Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                java.lang.String text = ((com.google.mlkit.vision.label.ImageLabel) it.next()).getText();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                if (kotlin.text.StringsKt.contains$default(text, "Hand", false, 2, (java.lang.Object) null)) {
                    z = true;
                    break;
                }
            }
        }
        booleanRef.element = z;
        countDownLatch.countDown();
    }
}
