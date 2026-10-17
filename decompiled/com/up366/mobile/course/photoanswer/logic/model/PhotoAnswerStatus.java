package com.up366.mobile.course.photoanswer.logic.model;

/* JADX INFO: compiled from: ModelData.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerStatus;", "", "<init>", "()V", "ERROR_RS_LAYOUT_CHECK_FAILED", "", "ERROR_RS_2A4_ON_1A3", "NO_RS_NOT_UP366_NEW_PAPER", "HAS_DISTORT", "HAND_IN_IMAGE", "PAGE_NUMBER_ERROR", "FETCH_PAPER_CODE_NET_ERROR", "SCAN_NOT_MATCH_FIRST_PAPER_CODE", "SCAN_REPEAT_ERROR", "SCAN_ONE_PAGE_ERROR", "NO_MATCH_PAPER_CODE", "FETCH_LAYOUT_INFO_NET_ERROR", "NO_PAPER_CODE", "OK", "BLUR", "UN_RECOGNITION", "TAKE_ERROR", "ANSWER_SHEET_OLD", "ANSWER_NO_SHEET", "ANSWER_SHEET_NO_PIC", "V3_UPLOAD_NET_ERROR", "V3_RECOGNIZE_NET_ERROR", "V3_LAYOUT_INFO_NET_ERROR", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerStatus {
    public static final int ANSWER_NO_SHEET = -5;
    public static final int ANSWER_SHEET_NO_PIC = -6;
    public static final int ANSWER_SHEET_OLD = -4;
    public static final int BLUR = -1;
    public static final int ERROR_RS_2A4_ON_1A3 = -111;
    public static final int ERROR_RS_LAYOUT_CHECK_FAILED = -112;
    public static final int FETCH_LAYOUT_INFO_NET_ERROR = -101;
    public static final int FETCH_PAPER_CODE_NET_ERROR = -106;
    public static final int HAND_IN_IMAGE = -108;
    public static final int HAS_DISTORT = -109;
    public static final com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerStatus INSTANCE = new com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerStatus();
    public static final int NO_MATCH_PAPER_CODE = -102;
    public static final int NO_PAPER_CODE = -100;
    public static final int NO_RS_NOT_UP366_NEW_PAPER = -110;
    public static final int OK = 0;
    public static final int PAGE_NUMBER_ERROR = -107;
    public static final int SCAN_NOT_MATCH_FIRST_PAPER_CODE = -105;
    public static final int SCAN_ONE_PAGE_ERROR = -103;
    public static final int SCAN_REPEAT_ERROR = -104;
    public static final int TAKE_ERROR = -3;
    public static final int UN_RECOGNITION = -2;
    public static final int V3_LAYOUT_INFO_NET_ERROR = -1002;
    public static final int V3_RECOGNIZE_NET_ERROR = -1001;
    public static final int V3_UPLOAD_NET_ERROR = -1000;

    private PhotoAnswerStatus() {
    }
}
