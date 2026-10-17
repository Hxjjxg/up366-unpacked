package com.up366.mobile.course.photoanswer.logic.helper;

/* JADX INFO: compiled from: TXPathHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/helper/TXPathHelper;", "", "<init>", "()V", "getTakePhotoPath", "", "getTakePhotoPathRoot", "getTakePhotoCropPath", com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TXPathHelper {
    public static final com.up366.mobile.course.photoanswer.logic.helper.TXPathHelper INSTANCE = new com.up366.mobile.course.photoanswer.logic.helper.TXPathHelper();

    private TXPathHelper() {
    }

    public final java.lang.String getTakePhotoPath() {
        return getTakePhotoPathRoot() + "takeImages" + java.io.File.separator;
    }

    public final java.lang.String getTakePhotoPathRoot() {
        return com.up366.mobile.common.utils.AppFileUtils.getRootResourceDir() + com.up366.mobile.common.logic.Auth.UID() + java.io.File.separator + "photoCorrect" + java.io.File.separator;
    }

    public final java.lang.String getTakePhotoCropPath(java.lang.String path) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
        java.lang.String strReplace$default = kotlin.text.StringsKt.replace$default(path, "_s.jpg", "_c.jpg", false, 4, (java.lang.Object) null);
        return new java.io.File(strReplace$default).exists() ? strReplace$default : path;
    }
}
