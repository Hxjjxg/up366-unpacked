package com.up366.mobile.book;

/* JADX INFO: compiled from: StaticTimeStudyLoadingHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/up366/mobile/book/StaticTimeStudyLoadingHelper;", "", "<init>", "()V", "Companion", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StaticTimeStudyLoadingHelper {
    private static long endTimeDownload;
    private static long endTimeLoading;
    private static boolean hasStart;
    private static long starTime;
    private static long startTimeDownload;
    private static long startTimeLoading;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.mobile.book.StaticTimeStudyLoadingHelper.Companion INSTANCE = new com.up366.mobile.book.StaticTimeStudyLoadingHelper.Companion(null);
    private static java.lang.String taskId = "";
    private static java.lang.String bookId = "";
    private static java.util.Map<java.lang.String, java.lang.Long> loadUrlMap = new java.util.LinkedHashMap();

    /* JADX INFO: compiled from: StaticTimeStudyLoadingHelper.kt */
    @kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\rJ\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u000bJ\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/up366/mobile/book/StaticTimeStudyLoadingHelper$Companion;", "", "<init>", "()V", "starTime", "", "startTimeDownload", "startTimeLoading", "endTimeDownload", "endTimeLoading", "hasStart", "", com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, "", com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, "loadUrlMap", "", "onStart", "", "startLoading", "startDownload", "endDownload", "endLoading", "startLoadUrl", com.up366.mobile.commonui.CommonWebViewActivity.URL, "endLoadUrl", "fromError", "reset", "static", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void onStart(java.lang.String bookId, java.lang.String taskId) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bookId, com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(taskId, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID);
            if (com.up366.mobile.book.StaticTimeStudyLoadingHelper.hasStart) {
                return;
            }
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.hasStart = true;
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.starTime = java.lang.System.currentTimeMillis();
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.taskId = taskId;
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.bookId = bookId;
        }

        public final void startLoading() {
            com.up366.common.log.Logger.info("StudyLoadingHelper startLoading hasStart:" + com.up366.mobile.book.StaticTimeStudyLoadingHelper.hasStart + " taskId:" + com.up366.mobile.book.StaticTimeStudyLoadingHelper.taskId);
            if (com.up366.mobile.book.StaticTimeStudyLoadingHelper.hasStart && com.up366.mobile.book.StaticTimeStudyLoadingHelper.startTimeLoading <= 0) {
                com.up366.mobile.book.StaticTimeStudyLoadingHelper.startTimeLoading = java.lang.System.currentTimeMillis();
            }
        }

        public final void startDownload() {
            com.up366.common.log.Logger.info("StudyLoadingHelper startDownload hasStart:" + com.up366.mobile.book.StaticTimeStudyLoadingHelper.hasStart + " taskId:" + com.up366.mobile.book.StaticTimeStudyLoadingHelper.taskId);
            if (com.up366.mobile.book.StaticTimeStudyLoadingHelper.hasStart) {
                com.up366.mobile.book.StaticTimeStudyLoadingHelper.startTimeDownload = java.lang.System.currentTimeMillis();
            }
        }

        public final void endDownload() {
            com.up366.common.log.Logger.info("StudyLoadingHelper endDownload hasStart:" + com.up366.mobile.book.StaticTimeStudyLoadingHelper.hasStart + " taskId:" + com.up366.mobile.book.StaticTimeStudyLoadingHelper.taskId);
            if (com.up366.mobile.book.StaticTimeStudyLoadingHelper.hasStart) {
                com.up366.mobile.book.StaticTimeStudyLoadingHelper.endTimeDownload = java.lang.System.currentTimeMillis();
            }
        }

        public final void endLoading() {
            com.up366.common.log.Logger.info("StudyLoadingHelper endLoading hasStart:" + com.up366.mobile.book.StaticTimeStudyLoadingHelper.hasStart + " taskId:" + com.up366.mobile.book.StaticTimeStudyLoadingHelper.taskId);
            if (com.up366.mobile.book.StaticTimeStudyLoadingHelper.hasStart) {
                com.up366.mobile.book.StaticTimeStudyLoadingHelper.endTimeLoading = java.lang.System.currentTimeMillis();
                m191static();
            }
        }

        public final void startLoadUrl(java.lang.String url) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(url, com.up366.mobile.commonui.CommonWebViewActivity.URL);
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.loadUrlMap.put(url, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            com.up366.common.log.Logger.info("StudyLoadingHelper  startLoadUrl taskId:" + com.up366.mobile.book.StaticTimeStudyLoadingHelper.taskId + " loadUrl:" + url);
        }

        public static /* synthetic */ void endLoadUrl$default(com.up366.mobile.book.StaticTimeStudyLoadingHelper.Companion companion, java.lang.String str, boolean z, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            companion.endLoadUrl(str, z);
        }

        public final void endLoadUrl(java.lang.String url, boolean fromError) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(url, com.up366.mobile.commonui.CommonWebViewActivity.URL);
            java.lang.Long l = (java.lang.Long) com.up366.mobile.book.StaticTimeStudyLoadingHelper.loadUrlMap.get(url);
            if (l != null) {
                long jLongValue = l.longValue();
                com.up366.common.log.Logger.info("StudyLoadingHelper " + fromError + "  endLoadUrl taskId:" + com.up366.mobile.book.StaticTimeStudyLoadingHelper.taskId + " loadUrl:" + url + " duration:" + (java.lang.System.currentTimeMillis() - jLongValue));
            }
        }

        private final void reset() {
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.hasStart = false;
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.starTime = 0L;
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.startTimeDownload = 0L;
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.startTimeLoading = 0L;
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.endTimeDownload = 0L;
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.endTimeLoading = 0L;
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.taskId = "";
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.bookId = "";
        }

        /* JADX INFO: renamed from: static, reason: not valid java name */
        private final void m191static() {
            if (com.up366.mobile.book.StaticTimeStudyLoadingHelper.starTime != 0) {
                final long j = com.up366.mobile.book.StaticTimeStudyLoadingHelper.endTimeDownload - com.up366.mobile.book.StaticTimeStudyLoadingHelper.startTimeDownload;
                if (j >= 0 && j <= com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MINUTE_5) {
                    final long j2 = com.up366.mobile.book.StaticTimeStudyLoadingHelper.endTimeLoading - com.up366.mobile.book.StaticTimeStudyLoadingHelper.startTimeLoading;
                    if (j2 >= 0 && j2 <= 15000) {
                        final long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - com.up366.mobile.book.StaticTimeStudyLoadingHelper.starTime;
                        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 480000) {
                            com.up366.common.log.Logger.info("StudyLoadingHelperError  static totalDuration  , totalDuration:" + jCurrentTimeMillis);
                            reset();
                            return;
                        }
                        com.up366.mobile.common.onlinelog.OpLog.report(".task.loading.dur", "作答等待时长", (androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject>) new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.StaticTimeStudyLoadingHelper$Companion$$ExternalSyntheticLambda0
                            public final void accept(java.lang.Object obj) {
                                com.up366.mobile.book.StaticTimeStudyLoadingHelper.Companion.static$lambda$0(jCurrentTimeMillis, j, j2, (com.alibaba.fastjson.JSONObject) obj);
                            }
                        });
                        return;
                    }
                    com.up366.common.log.Logger.info("StudyLoadingHelperError  static loadingDuration  , loadingDuration:" + j2);
                    reset();
                    return;
                }
                com.up366.common.log.Logger.info("StudyLoadingHelperError  static downloadDuration  , downloadDuration:" + j);
                reset();
                return;
            }
            com.up366.common.log.Logger.info("StudyLoadingHelperError  static starTime == 0L");
            reset();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void static$lambda$0(long j, long j2, long j3, com.alibaba.fastjson.JSONObject jSONObject) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jSONObject, "ext");
            java.util.Map map = (java.util.Map) jSONObject;
            map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, com.up366.mobile.book.StaticTimeStudyLoadingHelper.taskId);
            map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, com.up366.mobile.book.StaticTimeStudyLoadingHelper.bookId);
            map.put("totalDuration", java.lang.Long.valueOf(j));
            map.put("downloadDuration", java.lang.Long.valueOf(j2));
            map.put("loadingDuration", java.lang.Long.valueOf(j3));
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.INSTANCE.reset();
        }
    }
}
