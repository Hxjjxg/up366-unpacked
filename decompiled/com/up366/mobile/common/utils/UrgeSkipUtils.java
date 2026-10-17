package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UrgeSkipUtils {
    public static void skip(final java.lang.String str, final java.lang.String str2, final int i, final com.up366.common.callback.ICallbackCode iCallbackCode) {
        final android.app.Activity currentActivity = com.up366.common.global.GB.get().getCurrentActivity();
        java.util.List<java.lang.String> withInCourseBooks = com.up366.mobile.common.logic.Auth.cur().config().getWithInCourseBooks();
        if (withInCourseBooks != null && withInCourseBooks.contains(str)) {
            openStudyPage(com.up366.common.global.GB.get().getCurrentActivity(), str, str2, i, 0);
        } else {
            com.up366.mobile.common.logic.Auth.cur().cache().load(com.up366.mobile.common.dialog.InterestSelectCourseDialog.CACHE_KEY, com.up366.mobile.course.mgr.CourseInfo.class, new com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache() { // from class: com.up366.mobile.common.utils.UrgeSkipUtils$$ExternalSyntheticLambda0
                @Override // com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache
                public final void onLoad(java.lang.Object obj) {
                    com.up366.mobile.common.utils.UrgeSkipUtils.lambda$skip$1(currentActivity, str, str2, i, iCallbackCode, (com.up366.mobile.course.mgr.CourseInfo) obj);
                }
            });
        }
    }

    static /* synthetic */ void lambda$skip$1(final android.content.Context context, final java.lang.String str, final java.lang.String str2, final int i, final com.up366.common.callback.ICallbackCode iCallbackCode, com.up366.mobile.course.mgr.CourseInfo courseInfo) {
        if (courseInfo == null) {
            new com.up366.mobile.common.dialog.InterestSelectCourseDialog((android.app.Activity) context).show(0, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.common.utils.UrgeSkipUtils$$ExternalSyntheticLambda1
                @Override // com.up366.common.callback.ICallbackCodeInfoObj
                public final void onResult(int i2, java.lang.String str3, java.lang.Object obj) {
                    com.up366.mobile.common.utils.UrgeSkipUtils.lambda$skip$0(context, str, str2, i, iCallbackCode, i2, str3, (com.up366.mobile.course.mgr.CourseInfo) obj);
                }
            });
        } else {
            openStudyPage(context, str, str2, i, courseInfo, iCallbackCode);
        }
    }

    static /* synthetic */ void lambda$skip$0(android.content.Context context, java.lang.String str, java.lang.String str2, int i, com.up366.common.callback.ICallbackCode iCallbackCode, int i2, java.lang.String str3, com.up366.mobile.course.mgr.CourseInfo courseInfo) {
        if (i2 == 0) {
            openStudyPage(context, str, str2, i, courseInfo, iCallbackCode);
        }
    }

    public static void skipByDialog(java.lang.String str, java.lang.String str2, int i, java.lang.String str3) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str3)) {
            skip(str, str2, i, null);
        } else {
            openStudyPage(com.up366.common.global.GB.get().getCurrentActivity(), str, str2, i, java.lang.Integer.parseInt(str3));
        }
    }

    private static void openStudyPage(android.content.Context context, java.lang.String str, java.lang.String str2, int i, com.up366.mobile.course.mgr.CourseInfo courseInfo, com.up366.common.callback.ICallbackCode iCallbackCode) {
        if (courseInfo.getCourseId() > 0) {
            com.up366.mobile.common.logic.Auth.cur().cache().put(com.up366.mobile.common.dialog.InterestSelectCourseDialog.CACHE_KEY, courseInfo, com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_6);
        }
        openStudyPage(context, str, str2, i, courseInfo.getCourseId());
        if (iCallbackCode != null) {
            iCallbackCode.onResult(0);
        }
    }

    private static void openStudyPage(android.content.Context context, java.lang.String str, java.lang.String str2, int i, int i2) {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
        bookInfoStudy.setBookId(str);
        bookInfoStudy.setCourseId(i2);
        bookInfoStudy.setBookName(str2);
        bookInfoStudy.setBookType(i);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("scenario", "_STANDARD_BOOK_");
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookInfoStudy.getBookId());
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(bookInfoStudy.getCourseId()));
        jSONObject.put("bookType", java.lang.Integer.valueOf(bookInfoStudy.getBookType()));
        bookInfoStudy.setJumpCommonParams(jSONObject.toJSONString());
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("book", bookInfoStudy);
        context.startActivity(intent);
    }
}
