package com.up366.mobile.commonui.webview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CommonWebOpenHelper {
    private final android.content.Context context;

    public CommonWebOpenHelper(android.content.Context context) {
        this.context = context;
    }

    public void launchXotEngine(java.lang.String str, java.lang.String str2, boolean z) {
        android.content.Intent intent = new android.content.Intent(this.context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("exercise_type", str);
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, com.alibaba.fastjson.JSON.parseObject(str2).toJSONString());
        this.context.startActivity(intent);
    }
}
