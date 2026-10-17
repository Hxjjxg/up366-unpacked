package com.up366.mobile.course.p1p.helper;

/* JADX INFO: compiled from: P1pStatusHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/up366/mobile/course/p1p/helper/P1pStatusHelper;", "", "<init>", "()V", "STATUS_NORMAL", "", "STATUS_TAKING_PHOTO", "STATUS_ANALYSIS_BY_SPLIT_ENGIN", "status", "dialogIsShowing", "", "setDialogIsShowing", "", "showing", "reset", "canTakePicture", "takingPhoto", "enginAnalysis", "curStatus", "isAnalysising", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class P1pStatusHelper {
    public static final com.up366.mobile.course.p1p.helper.P1pStatusHelper INSTANCE = new com.up366.mobile.course.p1p.helper.P1pStatusHelper();
    private static final int STATUS_ANALYSIS_BY_SPLIT_ENGIN = 3;
    private static final int STATUS_NORMAL = 1;
    private static final int STATUS_TAKING_PHOTO = 2;
    private static volatile boolean dialogIsShowing;
    private static volatile int status;

    private P1pStatusHelper() {
    }

    public final boolean dialogIsShowing() {
        return dialogIsShowing;
    }

    public final void setDialogIsShowing(boolean showing) {
        dialogIsShowing = showing;
    }

    public final void reset() {
        status = 1;
    }

    public final boolean canTakePicture() {
        return status == 1;
    }

    public final void takingPhoto() {
        status = 2;
    }

    public final void enginAnalysis() {
        status = 3;
    }

    public final int curStatus() {
        return status;
    }

    public final boolean isAnalysising() {
        return status == 3;
    }
}
