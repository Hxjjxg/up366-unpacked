package com.up366.mobile.common.onlinelog;

/* JADX INFO: compiled from: OpLogData.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u0000 \u00062\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u000b"}, d2 = {"Lcom/up366/mobile/common/onlinelog/OpLogData;", "", "<init>", "()V", "Behavior", "ExerciseType", "Companion", "Page", "Event", "Control", "OpLogEvent", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OpLogData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.mobile.common.onlinelog.OpLogData.Companion INSTANCE = new com.up366.mobile.common.onlinelog.OpLogData.Companion(null);

    /* JADX INFO: compiled from: OpLogData.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/up366/mobile/common/onlinelog/OpLogData$OpLogEvent;", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(kotlin.annotation.AnnotationRetention.SOURCE)
    public @interface OpLogEvent {
    }

    /* JADX INFO: compiled from: OpLogData.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/up366/mobile/common/onlinelog/OpLogData$Behavior;", "", "<init>", "()V", "BOOK_ID", "", "TASK_ID", "STUDY_TASK_ID", "IS_REPORT", "IS_FINISH", "COURSE_ID", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Behavior {
        public static final java.lang.String BOOK_ID = "bookId";
        public static final java.lang.String COURSE_ID = "courseId";
        public static final com.up366.mobile.common.onlinelog.OpLogData.Behavior INSTANCE = new com.up366.mobile.common.onlinelog.OpLogData.Behavior();
        public static final java.lang.String IS_FINISH = "isFinish";
        public static final java.lang.String IS_REPORT = "isReport";
        public static final java.lang.String STUDY_TASK_ID = "studyTaskId";
        public static final java.lang.String TASK_ID = "taskId";

        private Behavior() {
        }
    }

    /* JADX INFO: compiled from: OpLogData.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/up366/mobile/common/onlinelog/OpLogData$ExerciseType;", "", "<init>", "()V", "REDIRECT", "", "STU_PAPER_VIEW", "HOMEWORK_REPORT", "SIMILAR", "STATISTIC_REPORT", "WRONG_NOTE", "WRONG_NOTE_REVIEW", "DICT_PRACTICE", "WORD_NOTE", "TEA_TLPY_TSPY_PERSONAL_REPORT", "QUESTION_TEXT", "STU_TLPY_TSPY_PERSONAL_PRACTICE", "TX_DICT", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ExerciseType {
        public static final java.lang.String DICT_PRACTICE = "dict_practice";
        public static final java.lang.String HOMEWORK_REPORT = "homework_report";
        public static final com.up366.mobile.common.onlinelog.OpLogData.ExerciseType INSTANCE = new com.up366.mobile.common.onlinelog.OpLogData.ExerciseType();
        public static final java.lang.String QUESTION_TEXT = "question_text";
        public static final java.lang.String REDIRECT = "redirect";
        public static final java.lang.String SIMILAR = "similar";
        public static final java.lang.String STATISTIC_REPORT = "statistic_report";
        public static final java.lang.String STU_PAPER_VIEW = "stu_paper_view";
        public static final java.lang.String STU_TLPY_TSPY_PERSONAL_PRACTICE = "stu_tlpy_tspy_personal_practice";
        public static final java.lang.String TEA_TLPY_TSPY_PERSONAL_REPORT = "tea_tlpy_tspy_personal_report";
        public static final java.lang.String TX_DICT = "_TX-DICT_";
        public static final java.lang.String WORD_NOTE = "wordnote";
        public static final java.lang.String WRONG_NOTE = "wrongnote";
        public static final java.lang.String WRONG_NOTE_REVIEW = "wrongnote_review";

        private ExerciseType() {
        }
    }

    /* JADX INFO: compiled from: OpLogData.kt */
    @kotlin.Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002JD\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001cJ>\u0010\u001d\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J \u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u0015¨\u0006!"}, d2 = {"Lcom/up366/mobile/common/onlinelog/OpLogData$Companion;", "", "<init>", "()V", "addBehavior", "", "openConfig", "Lcom/up366/mobile/book/model/OpenConfigInfo;", "behaviorStr", "", "exerciseType", "exerciseData", com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, "", com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, com.up366.mobile.common.onlinelog.OpLogData.Behavior.IS_FINISH, "", com.up366.mobile.common.onlinelog.OpLogData.Behavior.IS_REPORT, "intent", "Landroid/content/Intent;", "taskInfo", "Lcom/up366/mobile/course/task/TaskInfoV2;", "bookStudy", "Lcom/up366/mobile/book/model/BookInfoStudy;", "params", "Lcom/up366/mobile/book/helper/model/V8OpenWebViewParams;", "Lcom/up366/mobile/book/helper/model/V9OpenWebViewParams;", "buildBehavior", "setupBehavior", "cfg", "book", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00c0 A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:11:0x002a, B:13:0x0039, B:17:0x004c, B:20:0x0057, B:25:0x006b, B:26:0x006e, B:30:0x0081, B:31:0x0084, B:78:0x0170, B:32:0x008c, B:41:0x00ac, B:46:0x00c0, B:47:0x00c7, B:49:0x00d7, B:53:0x00e0, B:35:0x0097, B:38:0x00a1, B:54:0x00e5, B:57:0x00ee, B:59:0x0101, B:61:0x0114, B:63:0x011a, B:65:0x0123, B:66:0x0129, B:68:0x0139, B:70:0x013f, B:72:0x0148, B:74:0x0151, B:76:0x0157, B:77:0x015b), top: B:85:0x002a }] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00d7 A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:11:0x002a, B:13:0x0039, B:17:0x004c, B:20:0x0057, B:25:0x006b, B:26:0x006e, B:30:0x0081, B:31:0x0084, B:78:0x0170, B:32:0x008c, B:41:0x00ac, B:46:0x00c0, B:47:0x00c7, B:49:0x00d7, B:53:0x00e0, B:35:0x0097, B:38:0x00a1, B:54:0x00e5, B:57:0x00ee, B:59:0x0101, B:61:0x0114, B:63:0x011a, B:65:0x0123, B:66:0x0129, B:68:0x0139, B:70:0x013f, B:72:0x0148, B:74:0x0151, B:76:0x0157, B:77:0x015b), top: B:85:0x002a }] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00e0 A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:11:0x002a, B:13:0x0039, B:17:0x004c, B:20:0x0057, B:25:0x006b, B:26:0x006e, B:30:0x0081, B:31:0x0084, B:78:0x0170, B:32:0x008c, B:41:0x00ac, B:46:0x00c0, B:47:0x00c7, B:49:0x00d7, B:53:0x00e0, B:35:0x0097, B:38:0x00a1, B:54:0x00e5, B:57:0x00ee, B:59:0x0101, B:61:0x0114, B:63:0x011a, B:65:0x0123, B:66:0x0129, B:68:0x0139, B:70:0x013f, B:72:0x0148, B:74:0x0151, B:76:0x0157, B:77:0x015b), top: B:85:0x002a }] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x015b A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:11:0x002a, B:13:0x0039, B:17:0x004c, B:20:0x0057, B:25:0x006b, B:26:0x006e, B:30:0x0081, B:31:0x0084, B:78:0x0170, B:32:0x008c, B:41:0x00ac, B:46:0x00c0, B:47:0x00c7, B:49:0x00d7, B:53:0x00e0, B:35:0x0097, B:38:0x00a1, B:54:0x00e5, B:57:0x00ee, B:59:0x0101, B:61:0x0114, B:63:0x011a, B:65:0x0123, B:66:0x0129, B:68:0x0139, B:70:0x013f, B:72:0x0148, B:74:0x0151, B:76:0x0157, B:77:0x015b), top: B:85:0x002a }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void addBehavior(com.up366.mobile.book.model.OpenConfigInfo r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
            /*
                Method dump skipped, instruction units count: 438
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.common.onlinelog.OpLogData.Companion.addBehavior(com.up366.mobile.book.model.OpenConfigInfo, java.lang.String, java.lang.String, java.lang.String):void");
        }

        public final void addBehavior(int courseId, java.lang.String bookId, java.lang.String taskId, java.lang.String studyTaskId, boolean isFinish, boolean isReport, android.content.Intent intent) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intent, "intent");
            intent.putExtra("behavior", buildBehavior(courseId, bookId, taskId, studyTaskId, isFinish, isReport));
        }

        public final void addBehavior(com.up366.mobile.course.task.TaskInfoV2 taskInfo, android.content.Intent intent, boolean isReport, boolean isFinish) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intent, "intent");
            intent.putExtra("behavior", buildBehavior(taskInfo.getCourseId(), taskInfo.getExtParam().getBookId(), taskInfo.getContentId(), taskInfo.getJobId(), isFinish, isReport));
        }

        public final void addBehavior(com.up366.mobile.course.task.TaskInfoV2 taskInfo, com.up366.mobile.book.model.BookInfoStudy bookStudy, boolean isReport, boolean isFinish) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bookStudy, "bookStudy");
            java.lang.String bookId = taskInfo.getExtParam().getBookId();
            if (bookId == null) {
                bookId = bookStudy.getBookId();
            }
            bookStudy.setJumpBehavior(buildBehavior(taskInfo.getCourseId(), bookId, taskInfo.getContentId(), taskInfo.getJobId(), isFinish, isReport));
        }

        public final void addBehavior(com.up366.mobile.book.model.BookInfoStudy bookStudy, com.up366.mobile.book.model.OpenConfigInfo openConfig, com.up366.mobile.book.helper.model.V8OpenWebViewParams params) throws org.json.JSONException {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bookStudy, "bookStudy");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(openConfig, "openConfig");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(params, "params");
            java.lang.String strBuildBehavior = buildBehavior(params.getCourseId(), params.getBookId(), params.getTaskId(), params.getStudyTaskId(), params.fromHistory(), params.isReport());
            bookStudy.setJumpBehavior(strBuildBehavior);
            openConfig.behavior = strBuildBehavior;
        }

        public final void addBehavior(com.up366.mobile.book.model.BookInfoStudy bookStudy, com.up366.mobile.book.model.OpenConfigInfo openConfig, com.up366.mobile.book.helper.model.V9OpenWebViewParams params) throws org.json.JSONException {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bookStudy, "bookStudy");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(openConfig, "openConfig");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(params, "params");
            java.lang.String strBuildBehavior = buildBehavior(params.getCourseId(), params.getBookId(), params.getTaskId(), params.getStudyTaskId(), params.fromHistory(), params.isReport());
            bookStudy.setJumpBehavior(strBuildBehavior);
            openConfig.behavior = strBuildBehavior;
        }

        private final java.lang.String buildBehavior(int courseId, java.lang.String bookId, java.lang.String taskId, java.lang.String studyTaskId, boolean isFinish, boolean isReport) throws org.json.JSONException {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            if (!com.up366.common.StringUtils.isEmptyOrNull(taskId)) {
                jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, taskId);
            }
            if (!com.up366.common.StringUtils.isEmptyOrNull(studyTaskId)) {
                jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, studyTaskId);
            }
            if (!com.up366.common.StringUtils.isEmptyOrNull(bookId)) {
                jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookId);
            }
            if (courseId > 0) {
                jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, courseId);
            }
            jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.IS_REPORT, isReport);
            jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.IS_FINISH, isFinish);
            java.lang.String string = jSONObject.toString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0095  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void setupBehavior(com.up366.mobile.book.model.OpenConfigInfo r10, com.up366.mobile.book.model.BookInfoStudy r11, android.content.Intent r12) {
            /*
                Method dump skipped, instruction units count: 240
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.common.onlinelog.OpLogData.Companion.setupBehavior(com.up366.mobile.book.model.OpenConfigInfo, com.up366.mobile.book.model.BookInfoStudy, android.content.Intent):void");
        }
    }

    /* JADX INFO: compiled from: OpLogData.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/up366/mobile/common/onlinelog/OpLogData$Page;", "", "<init>", "()V", "APP", "", "MESSAGE_DETAIL", "SMART_PAPER", "BOOK_TASK", "BOOK_HOME", "TASK_REPORT", "USER", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Page {
        public static final java.lang.String APP = ".def.app";
        public static final java.lang.String BOOK_HOME = ".def.book.home";
        public static final java.lang.String BOOK_TASK = ".def.book.task";
        public static final com.up366.mobile.common.onlinelog.OpLogData.Page INSTANCE = new com.up366.mobile.common.onlinelog.OpLogData.Page();
        public static final java.lang.String MESSAGE_DETAIL = ".def.message.detail";
        public static final java.lang.String SMART_PAPER = ".def.photo.smartpaper";
        public static final java.lang.String TASK_REPORT = ".def.task.report";
        public static final java.lang.String USER = ".def.user";

        private Page() {
        }
    }

    /* JADX INFO: compiled from: OpLogData.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/up366/mobile/common/onlinelog/OpLogData$Event;", "", "<init>", "()V", com.up366.mobile.common.onlinelog.OpLogData.Event.BOOT_APP, "", com.up366.mobile.common.onlinelog.OpLogData.Event.RESIGN_ACTIVE, com.up366.mobile.common.onlinelog.OpLogData.Event.BECOME_ACTIVE, com.up366.mobile.common.onlinelog.OpLogData.Event.EXIT_APP, com.up366.mobile.common.onlinelog.OpLogData.Event.ENTER_PAGE, com.up366.mobile.common.onlinelog.OpLogData.Event.PAUSE_PAGE, com.up366.mobile.common.onlinelog.OpLogData.Event.RESUME_PAGE, com.up366.mobile.common.onlinelog.OpLogData.Event.LEAVE_PAGE, com.up366.mobile.common.onlinelog.OpLogData.Event.SUBMIT_OK, "SUBMIT_OK", com.up366.mobile.common.onlinelog.OpLogData.Event.CLICK, com.up366.mobile.common.onlinelog.OpLogData.Event.OTHER, com.up366.mobile.common.onlinelog.OpLogData.Event.NAVIGATE, com.up366.mobile.common.onlinelog.OpLogData.Event.LOG_IN, com.up366.mobile.common.onlinelog.OpLogData.Event.LOG_OUT, "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Event {
        public static final java.lang.String BECOME_ACTIVE = "BECOME_ACTIVE";
        public static final java.lang.String BOOT_APP = "BOOT_APP";
        public static final java.lang.String CLICK = "CLICK";
        public static final java.lang.String ENTER_PAGE = "ENTER_PAGE";
        public static final java.lang.String EXIT_APP = "EXIT_APP";
        public static final com.up366.mobile.common.onlinelog.OpLogData.Event INSTANCE = new com.up366.mobile.common.onlinelog.OpLogData.Event();
        public static final java.lang.String LEAVE_PAGE = "LEAVE_PAGE";
        public static final java.lang.String LOG_IN = "LOG_IN";
        public static final java.lang.String LOG_OUT = "LOG_OUT";
        public static final java.lang.String NAVIGATE = "NAVIGATE";
        public static final java.lang.String OTHER = "OTHER";
        public static final java.lang.String PAUSE_PAGE = "PAUSE_PAGE";
        public static final java.lang.String RESIGN_ACTIVE = "RESIGN_ACTIVE";
        public static final java.lang.String RESUME_PAGE = "RESUME_PAGE";
        public static final java.lang.String SUBMIT = "SUBMIT_LAUNCH";
        public static final java.lang.String SUBMIT_OK = "SUBMIT";

        private Event() {
        }
    }

    /* JADX INFO: compiled from: OpLogData.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/up366/mobile/common/onlinelog/OpLogData$Control;", "", "<init>", "()V", "HOME_PAGE", "", "BACK_GROUND", "FOREGROUND", "TERMINATION", "MESSAGE_DETAIL", "PHOTO_TASK", "STUDY_PAGE", "REPORT_PAGE", "REVIEW_PAGE", "NAVIGATION_PUSH", "NAVIGATION_POP", "NAVIGATION_REPLACE", "CATALOG_PAGE", "WRONG_NOTE", "WORD_NOTE", "LOGIN_STATE", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Control {
        public static final java.lang.String BACK_GROUND = "background";
        public static final java.lang.String CATALOG_PAGE = "catalog_page";
        public static final java.lang.String FOREGROUND = "foreground";
        public static final java.lang.String HOME_PAGE = "homepage";
        public static final com.up366.mobile.common.onlinelog.OpLogData.Control INSTANCE = new com.up366.mobile.common.onlinelog.OpLogData.Control();
        public static final java.lang.String LOGIN_STATE = "login_state";
        public static final java.lang.String MESSAGE_DETAIL = "message_detail";
        public static final java.lang.String NAVIGATION_POP = "pop";
        public static final java.lang.String NAVIGATION_PUSH = "push";
        public static final java.lang.String NAVIGATION_REPLACE = "replace";
        public static final java.lang.String PHOTO_TASK = "photo_task";
        public static final java.lang.String REPORT_PAGE = "report_page";
        public static final java.lang.String REVIEW_PAGE = "review_page";
        public static final java.lang.String STUDY_PAGE = "study_page";
        public static final java.lang.String TERMINATION = "termination";
        public static final java.lang.String WORD_NOTE = "wordnote";
        public static final java.lang.String WRONG_NOTE = "wrongnote";

        private Control() {
        }
    }
}
