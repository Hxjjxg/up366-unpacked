package com.up366.mobile.course.p1p.helper;

/* JADX INFO: compiled from: BlurHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/up366/mobile/course/p1p/helper/BlurHelper;", "", "detectLib", "Lcom/up366/papercut/DetectLib;", "<init>", "(Lcom/up366/papercut/DetectLib;)V", "blurRetryCount", "", "cacheBlurImage", "", "Lcom/up366/mobile/course/p1p/BlurData;", "checkBlur", "", "bitmap", "Landroid/graphics/Bitmap;", "imagePath", "", "getMaxBlurData", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BlurHelper {
    private int blurRetryCount;
    private java.util.List<com.up366.mobile.course.p1p.BlurData> cacheBlurImage;
    private final com.up366.papercut.DetectLib detectLib;

    public BlurHelper(com.up366.papercut.DetectLib detectLib) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(detectLib, "detectLib");
        this.detectLib = detectLib;
        this.cacheBlurImage = new java.util.ArrayList();
    }

    public final boolean checkBlur(android.graphics.Bitmap bitmap, java.lang.String imagePath) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        int i = 100 - (this.blurRetryCount * 25);
        com.up366.papercut.BlurResult blurResultCheckBlur = this.detectLib.checkBlur(bitmap, i);
        boolean isBlur = blurResultCheckBlur.getIsBlur();
        double blurValue = blurResultCheckBlur.getBlurValue();
        double wPercent = blurResultCheckBlur.getWPercent();
        if (!isBlur) {
            this.blurRetryCount = 0;
            this.cacheBlurImage.clear();
            return false;
        }
        com.up366.common.log.Logger.info("checkBlurResult  blurValue " + blurValue + " ，threshold " + i);
        this.blurRetryCount = this.blurRetryCount + 1;
        this.cacheBlurImage.add(new com.up366.mobile.course.p1p.BlurData(imagePath, blurValue, wPercent, true));
        com.up366.mobile.course.p1p.BlurData maxBlurData = getMaxBlurData();
        if (maxBlurData.getBlurValue() < i && maxBlurData.getBlurValue() < com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.getBlurMinValue()) {
            com.up366.common.log.Logger.error("checkBlur  maxBlurData " + maxBlurData.getBlurValue() + " ，threshold " + i + " ，P1pConfigDataHelper.INSTANCE.blurMinValue " + com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.getBlurMinValue());
            return true;
        }
        this.blurRetryCount = 0;
        this.cacheBlurImage.clear();
        if (!maxBlurData.getImagePath().equals(imagePath)) {
            kotlin.io.FilesKt.copyTo$default(new java.io.File(maxBlurData.getImagePath()), new java.io.File(imagePath), true, 0, 4, (java.lang.Object) null);
        }
        return false;
    }

    private final com.up366.mobile.course.p1p.BlurData getMaxBlurData() {
        java.util.List<com.up366.mobile.course.p1p.BlurData> list = this.cacheBlurImage;
        if (list.size() > 1) {
            kotlin.collections.CollectionsKt.sortWith(list, new java.util.Comparator() { // from class: com.up366.mobile.course.p1p.helper.BlurHelper$getMaxBlurData$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return kotlin.comparisons.ComparisonsKt.compareValues(java.lang.Double.valueOf(((com.up366.mobile.course.p1p.BlurData) t2).getBlurValue()), java.lang.Double.valueOf(((com.up366.mobile.course.p1p.BlurData) t).getBlurValue()));
                }
            });
        }
        return this.cacheBlurImage.get(0);
    }
}
