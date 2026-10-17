package com.up366.mobile.course.photoanswer.logic.helper;

/* JADX INFO: compiled from: RecognitionEdgeV2Helper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0006J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/helper/RecognitionEdgeV2Helper;", "", "<init>", "()V", "resultList", "", "Lcom/up366/mobile/course/p1p/PaperRecognitionResult;", "radiusRange", "", "LIST_SIZE", "TIME_LIMIT", "lastTakePhotoTime", "", "hasInitRadiusRange", "", "handleRecognitionEdgeResult", "analyzeResult", "checkDistance", "isNearResult", "first", "result", "pointDistance", "Landroid/graphics/PointF;", "second", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecognitionEdgeV2Helper {
    private static final int LIST_SIZE = 4;
    private static final int TIME_LIMIT = 550;
    private static boolean hasInitRadiusRange;
    private static long lastTakePhotoTime;
    public static final com.up366.mobile.course.photoanswer.logic.helper.RecognitionEdgeV2Helper INSTANCE = new com.up366.mobile.course.photoanswer.logic.helper.RecognitionEdgeV2Helper();
    private static final java.util.List<com.up366.mobile.course.p1p.PaperRecognitionResult> resultList = new java.util.ArrayList();
    private static int radiusRange = 20;

    private RecognitionEdgeV2Helper() {
    }

    public final int handleRecognitionEdgeResult(com.up366.mobile.course.p1p.PaperRecognitionResult analyzeResult) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(analyzeResult, "analyzeResult");
        if (!hasInitRadiusRange && analyzeResult.getRealCropRect().width() > 100) {
            radiusRange = analyzeResult.getRealCropRect().width() / 25;
            hasInitRadiusRange = true;
        }
        java.util.List<com.up366.mobile.course.p1p.PaperRecognitionResult> list = resultList;
        list.add(analyzeResult);
        int status = 0;
        if (list.size() > 4) {
            list.remove(0);
        }
        int status2 = analyzeResult.getStatus();
        if (status2 != 0) {
            return status2;
        }
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            status += ((com.up366.mobile.course.p1p.PaperRecognitionResult) it.next()).getStatus();
        }
        if (status < 0 || !checkDistance() || java.lang.System.currentTimeMillis() - lastTakePhotoTime < 550) {
            return 1;
        }
        lastTakePhotoTime = java.lang.System.currentTimeMillis();
        return 2;
    }

    private final boolean checkDistance() {
        int i;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int size = resultList.size() - 1;
        int i2 = 0;
        while (i2 < size) {
            java.util.List<com.up366.mobile.course.p1p.PaperRecognitionResult> list = resultList;
            com.up366.mobile.course.p1p.PaperRecognitionResult paperRecognitionResult = list.get(i2);
            i2++;
            arrayList.add(java.lang.Boolean.valueOf(isNearResult(paperRecognitionResult, list.get(i2))));
        }
        java.util.List<com.up366.mobile.course.p1p.PaperRecognitionResult> list2 = resultList;
        arrayList.add(java.lang.Boolean.valueOf(isNearResult(list2.get(0), list2.get(list2.size() - 1))));
        java.util.ArrayList arrayList2 = arrayList;
        if ((arrayList2 instanceof java.util.Collection) && arrayList2.isEmpty()) {
            i = 0;
        } else {
            java.util.Iterator it = arrayList2.iterator();
            i = 0;
            while (it.hasNext()) {
                if (((java.lang.Boolean) it.next()).booleanValue() && (i = i + 1) < 0) {
                    kotlin.collections.CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i >= 4;
    }

    private final boolean isNearResult(com.up366.mobile.course.p1p.PaperRecognitionResult first, com.up366.mobile.course.p1p.PaperRecognitionResult result) {
        if (first.getMPoints().size() != 4 || result.getMPoints().size() != 4) {
            return false;
        }
        java.util.List<android.graphics.PointF> mPoints = result.getMPoints();
        java.util.List<android.graphics.PointF> mPoints2 = first.getMPoints();
        return pointDistance(mPoints2.get(0), mPoints.get(0)) <= radiusRange && pointDistance(mPoints2.get(1), mPoints.get(1)) <= radiusRange && pointDistance(mPoints2.get(2), mPoints.get(2)) <= radiusRange && pointDistance(mPoints2.get(3), mPoints.get(3)) <= radiusRange;
    }

    private final int pointDistance(android.graphics.PointF first, android.graphics.PointF second) {
        double d = 2.0f;
        return (int) java.lang.Math.sqrt(((float) java.lang.Math.pow(first.x - second.x, d)) + ((float) java.lang.Math.pow(first.y - second.y, d)));
    }
}
