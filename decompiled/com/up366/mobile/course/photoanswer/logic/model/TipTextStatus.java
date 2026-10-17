package com.up366.mobile.course.photoanswer.logic.model;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ModelData.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/model/TipTextStatus;", "", "<init>", "(Ljava/lang/String;I)V", "GONE", "NO_ANSWER_SHEET", "TAKE_PHOTO_SUCCESS_TO_NEXT", "WAIT_TAKE_PHOTO", "PHOTO_OUT_SCREEN", "PHOTO_TOO_SMALL", "PHOTO_UPDATE_PAPER", "IS_NOT_RECTANGLE", "PAGE_REPEATED", "SUBMIT_AFTER_TAKE_PHOTO", "HAND_IN_IMAGE", "HAND_TAKE_PHOTO", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TipTextStatus {
    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES;
    private static final /* synthetic */ com.up366.mobile.course.photoanswer.logic.model.TipTextStatus[] $VALUES;
    public static final com.up366.mobile.course.photoanswer.logic.model.TipTextStatus GONE = new com.up366.mobile.course.photoanswer.logic.model.TipTextStatus("GONE", 0);
    public static final com.up366.mobile.course.photoanswer.logic.model.TipTextStatus NO_ANSWER_SHEET = new com.up366.mobile.course.photoanswer.logic.model.TipTextStatus("NO_ANSWER_SHEET", 1);
    public static final com.up366.mobile.course.photoanswer.logic.model.TipTextStatus TAKE_PHOTO_SUCCESS_TO_NEXT = new com.up366.mobile.course.photoanswer.logic.model.TipTextStatus("TAKE_PHOTO_SUCCESS_TO_NEXT", 2);
    public static final com.up366.mobile.course.photoanswer.logic.model.TipTextStatus WAIT_TAKE_PHOTO = new com.up366.mobile.course.photoanswer.logic.model.TipTextStatus("WAIT_TAKE_PHOTO", 3);
    public static final com.up366.mobile.course.photoanswer.logic.model.TipTextStatus PHOTO_OUT_SCREEN = new com.up366.mobile.course.photoanswer.logic.model.TipTextStatus("PHOTO_OUT_SCREEN", 4);
    public static final com.up366.mobile.course.photoanswer.logic.model.TipTextStatus PHOTO_TOO_SMALL = new com.up366.mobile.course.photoanswer.logic.model.TipTextStatus("PHOTO_TOO_SMALL", 5);
    public static final com.up366.mobile.course.photoanswer.logic.model.TipTextStatus PHOTO_UPDATE_PAPER = new com.up366.mobile.course.photoanswer.logic.model.TipTextStatus("PHOTO_UPDATE_PAPER", 6);
    public static final com.up366.mobile.course.photoanswer.logic.model.TipTextStatus IS_NOT_RECTANGLE = new com.up366.mobile.course.photoanswer.logic.model.TipTextStatus("IS_NOT_RECTANGLE", 7);
    public static final com.up366.mobile.course.photoanswer.logic.model.TipTextStatus PAGE_REPEATED = new com.up366.mobile.course.photoanswer.logic.model.TipTextStatus("PAGE_REPEATED", 8);
    public static final com.up366.mobile.course.photoanswer.logic.model.TipTextStatus SUBMIT_AFTER_TAKE_PHOTO = new com.up366.mobile.course.photoanswer.logic.model.TipTextStatus("SUBMIT_AFTER_TAKE_PHOTO", 9);
    public static final com.up366.mobile.course.photoanswer.logic.model.TipTextStatus HAND_IN_IMAGE = new com.up366.mobile.course.photoanswer.logic.model.TipTextStatus("HAND_IN_IMAGE", 10);
    public static final com.up366.mobile.course.photoanswer.logic.model.TipTextStatus HAND_TAKE_PHOTO = new com.up366.mobile.course.photoanswer.logic.model.TipTextStatus("HAND_TAKE_PHOTO", 11);

    private static final /* synthetic */ com.up366.mobile.course.photoanswer.logic.model.TipTextStatus[] $values() {
        return new com.up366.mobile.course.photoanswer.logic.model.TipTextStatus[]{GONE, NO_ANSWER_SHEET, TAKE_PHOTO_SUCCESS_TO_NEXT, WAIT_TAKE_PHOTO, PHOTO_OUT_SCREEN, PHOTO_TOO_SMALL, PHOTO_UPDATE_PAPER, IS_NOT_RECTANGLE, PAGE_REPEATED, SUBMIT_AFTER_TAKE_PHOTO, HAND_IN_IMAGE, HAND_TAKE_PHOTO};
    }

    public static kotlin.enums.EnumEntries<com.up366.mobile.course.photoanswer.logic.model.TipTextStatus> getEntries() {
        return $ENTRIES;
    }

    private TipTextStatus(java.lang.String str, int i) {
    }

    static {
        com.up366.mobile.course.photoanswer.logic.model.TipTextStatus[] tipTextStatusArr$values = $values();
        $VALUES = tipTextStatusArr$values;
        $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(tipTextStatusArr$values);
    }

    public static com.up366.mobile.course.photoanswer.logic.model.TipTextStatus valueOf(java.lang.String str) {
        return (com.up366.mobile.course.photoanswer.logic.model.TipTextStatus) java.lang.Enum.valueOf(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.class, str);
    }

    public static com.up366.mobile.course.photoanswer.logic.model.TipTextStatus[] values() {
        return (com.up366.mobile.course.photoanswer.logic.model.TipTextStatus[]) $VALUES.clone();
    }
}
