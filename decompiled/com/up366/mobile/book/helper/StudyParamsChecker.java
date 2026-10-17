package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StudyParamsChecker {
    private static void assertTrue(boolean z) {
        if (z) {
            return;
        }
        com.up366.mobile.common.onlinelog.OpLog.report("ERROR-assertTrue", "状态错误！！！", new java.lang.IllegalStateException());
        throw new java.lang.IllegalStateException("状态错误！！！");
    }

    public static void check(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo, android.content.Intent intent) {
        if (openConfigInfo.isExercise()) {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(openConfigInfo.exerciseData);
            java.lang.String str = openConfigInfo.exerciseType;
            str.hashCode();
            if (str.equals("weaktraining")) {
                assertTrue(object.containsKey("fromJob"));
                assertTrue(object.containsKey(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID));
                assertTrue(object.containsKey("type"));
                assertTrue(object.containsKey("difficulty"));
            }
        }
    }
}
