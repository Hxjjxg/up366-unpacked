package com.up366.mobile.course.photoanswer.logic.helper;

/* JADX INFO: compiled from: SwitchHandHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\u0006\u0010\u0017\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/helper/SwitchHandHelper;", "", "<init>", "()V", "startTime", "", "checkFirstTime", "postEventSecond", "curTakePhotoType", "", "getCurTakePhotoType", "setTakePhotoType", "", "type", "isAutoTakePhoto", "", "isHandTakePhoto", "startCheck", "checking", "connerData", "Lcom/up366/smartscan2/ConnerData;", "isAnswerSheet", "isSwitchHand", "reset", "TakePhotoType", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwitchHandHelper {
    private static long checkFirstTime;
    private static long postEventSecond;
    private static long startTime;
    public static final com.up366.mobile.course.photoanswer.logic.helper.SwitchHandHelper INSTANCE = new com.up366.mobile.course.photoanswer.logic.helper.SwitchHandHelper();
    private static int curTakePhotoType = 1;

    private SwitchHandHelper() {
    }

    /* JADX INFO: compiled from: SwitchHandHelper.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/helper/SwitchHandHelper$TakePhotoType;", "", "<init>", "()V", "HAND", "", "AUTO", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TakePhotoType {
        public static final int AUTO = 1;
        public static final int HAND = 0;
        public static final com.up366.mobile.course.photoanswer.logic.helper.SwitchHandHelper.TakePhotoType INSTANCE = new com.up366.mobile.course.photoanswer.logic.helper.SwitchHandHelper.TakePhotoType();

        private TakePhotoType() {
        }
    }

    public final int getCurTakePhotoType() {
        return curTakePhotoType;
    }

    public final void setTakePhotoType(int type) {
        curTakePhotoType = type;
        reset();
    }

    private final boolean isAutoTakePhoto() {
        return curTakePhotoType == 1;
    }

    public final boolean isHandTakePhoto() {
        return curTakePhotoType == 0;
    }

    public final void startCheck() {
        if (startTime == 0) {
            startTime = java.lang.System.currentTimeMillis();
        }
    }

    public final void checking(com.up366.smartscan2.ConnerData connerData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(connerData, "connerData");
        if (connerData.getErrorCode() == 1) {
            checking(true);
        } else {
            checking(false);
        }
    }

    private final void checking(boolean isAnswerSheet) {
        if (isAnswerSheet && checkFirstTime == 0) {
            checkFirstTime = java.lang.System.currentTimeMillis();
        }
        long jCurrentTimeMillis = (java.lang.System.currentTimeMillis() - startTime) / ((long) 1000);
        if (jCurrentTimeMillis != postEventSecond) {
            postEventSecond = jCurrentTimeMillis;
            if (isAutoTakePhoto() && isSwitchHand()) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.SwitchHandCheckEvent(true));
            }
        }
    }

    private final boolean isSwitchHand() {
        if (startTime == 0) {
            return false;
        }
        return (((java.lang.System.currentTimeMillis() - startTime) > com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.getMaxNoLabelMillSeconds() ? 1 : ((java.lang.System.currentTimeMillis() - startTime) == com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.getMaxNoLabelMillSeconds() ? 0 : -1)) > 0) || ((checkFirstTime > 0L ? 1 : (checkFirstTime == 0L ? 0 : -1)) != 0 && ((java.lang.System.currentTimeMillis() - checkFirstTime) > com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.getMaxNotPhotoMillSeconds() ? 1 : ((java.lang.System.currentTimeMillis() - checkFirstTime) == com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.getMaxNotPhotoMillSeconds() ? 0 : -1)) > 0);
    }

    public final void reset() {
        startTime = 0L;
        checkFirstTime = 0L;
    }
}
