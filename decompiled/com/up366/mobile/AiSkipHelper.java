package com.up366.mobile;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AiSkipHelper {
    private static final java.lang.String FROM_AI_SKIP = "ai_skip";
    private static final java.lang.String MOLIYING_BOOK_ID = "D3C41EE252CD2A672E3B2ACF64781464";
    private static boolean hasShowAppUpdateDialog;

    public static void skipToMain(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
        bookInfoStudy.setBookId(MOLIYING_BOOK_ID);
        bookInfoStudy.setBookType(1);
        bookInfoStudy.setPackType(8);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("scenario", "_STANDARD_BOOK_");
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, MOLIYING_BOOK_ID);
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, -1);
        jSONObject.put("bookType", 1);
        bookInfoStudy.setJumpCommonParams(jSONObject.toJSONString());
        intent.putExtra("book", bookInfoStudy);
        intent.putExtra("from", FROM_AI_SKIP);
        context.startActivity(intent);
    }

    public static boolean isMoLiYingBook(java.lang.String str) {
        return MOLIYING_BOOK_ID.equals(str);
    }

    public static boolean isMoLiSkip(java.lang.String str) {
        return FROM_AI_SKIP.equals(str);
    }

    public static void setHasShowAppUpdateDialog(boolean z) {
        hasShowAppUpdateDialog = z;
    }

    public static boolean isHasShowAppUpdateDialog() {
        return hasShowAppUpdateDialog;
    }
}
