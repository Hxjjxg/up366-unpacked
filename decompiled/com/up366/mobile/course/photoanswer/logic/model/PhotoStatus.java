package com.up366.mobile.course.photoanswer.logic.model;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ModelData.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/model/PhotoStatus;", "", "<init>", "(Ljava/lang/String;I)V", "BLUR", "UN_RECOGNITION", "TAKE_ERROR", "SUCCESS", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoStatus {
    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES;
    private static final /* synthetic */ com.up366.mobile.course.photoanswer.logic.model.PhotoStatus[] $VALUES;
    public static final com.up366.mobile.course.photoanswer.logic.model.PhotoStatus BLUR = new com.up366.mobile.course.photoanswer.logic.model.PhotoStatus("BLUR", 0);
    public static final com.up366.mobile.course.photoanswer.logic.model.PhotoStatus UN_RECOGNITION = new com.up366.mobile.course.photoanswer.logic.model.PhotoStatus("UN_RECOGNITION", 1);
    public static final com.up366.mobile.course.photoanswer.logic.model.PhotoStatus TAKE_ERROR = new com.up366.mobile.course.photoanswer.logic.model.PhotoStatus("TAKE_ERROR", 2);
    public static final com.up366.mobile.course.photoanswer.logic.model.PhotoStatus SUCCESS = new com.up366.mobile.course.photoanswer.logic.model.PhotoStatus("SUCCESS", 3);

    private static final /* synthetic */ com.up366.mobile.course.photoanswer.logic.model.PhotoStatus[] $values() {
        return new com.up366.mobile.course.photoanswer.logic.model.PhotoStatus[]{BLUR, UN_RECOGNITION, TAKE_ERROR, SUCCESS};
    }

    public static kotlin.enums.EnumEntries<com.up366.mobile.course.photoanswer.logic.model.PhotoStatus> getEntries() {
        return $ENTRIES;
    }

    private PhotoStatus(java.lang.String str, int i) {
    }

    static {
        com.up366.mobile.course.photoanswer.logic.model.PhotoStatus[] photoStatusArr$values = $values();
        $VALUES = photoStatusArr$values;
        $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(photoStatusArr$values);
    }

    public static com.up366.mobile.course.photoanswer.logic.model.PhotoStatus valueOf(java.lang.String str) {
        return (com.up366.mobile.course.photoanswer.logic.model.PhotoStatus) java.lang.Enum.valueOf(com.up366.mobile.course.photoanswer.logic.model.PhotoStatus.class, str);
    }

    public static com.up366.mobile.course.photoanswer.logic.model.PhotoStatus[] values() {
        return (com.up366.mobile.course.photoanswer.logic.model.PhotoStatus[]) $VALUES.clone();
    }
}
