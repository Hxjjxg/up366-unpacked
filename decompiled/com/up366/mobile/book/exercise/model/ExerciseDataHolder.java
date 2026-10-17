package com.up366.mobile.book.exercise.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ExerciseDataHolder {
    public com.up366.mobile.book.model.CatalogPage catalogPage;
    public com.alibaba.fastjson.JSONObject exerciseData;
    public java.lang.String exerciseId;
    public java.lang.String exerciseType;

    public ExerciseDataHolder(java.lang.String str, java.lang.String str2) {
        init(str, str2);
    }

    public void init(java.lang.String str, java.lang.String str2) {
        this.exerciseType = str;
        this.exerciseData = com.alibaba.fastjson.JSON.parseObject(str2);
        initExerciseId();
    }

    private void initExerciseId() {
        java.lang.String str = this.exerciseType;
        str.hashCode();
        switch (str) {
            case "textbook":
                compatWrongExerciseData();
                this.exerciseId = generateExerciseId(this.exerciseData.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID), 5);
                break;
            case "homework":
            case "homework_report":
                this.exerciseId = generateExerciseId(this.exerciseData.getString("testId"), 1);
                break;
            default:
                this.exerciseId = this.exerciseType;
                break;
        }
    }

    private void compatWrongExerciseData() {
        java.lang.String string = this.exerciseData.getString("chapterId");
        java.lang.Object string2 = this.exerciseData.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID);
        if (string.equals(string2)) {
            return;
        }
        com.up366.greendao.DaoSession daoSessionDb = com.up366.mobile.common.logic.Auth.cur().db();
        java.lang.String strGenerateExerciseId = generateExerciseId(string, 5);
        java.lang.String strGenerateExerciseId2 = generateExerciseId(string2, 5);
        com.up366.mobile.book.exercise.model.ExerciseData exerciseData = (com.up366.mobile.book.exercise.model.ExerciseData) daoSessionDb.getExerciseDataDao().queryBuilder().where(com.up366.greendao.ExerciseDataDao.Properties.ExerciseId.eq(strGenerateExerciseId), new org.greenrobot.greendao.query.WhereCondition[0]).unique();
        if (exerciseData != null) {
            com.up366.common.log.Logger.error("TAG - ExerciseDataHolder - compatWrongExerciseData - compat old data:" + com.alibaba.fastjson.JSON.toJSONString(exerciseData));
            exerciseData.setExerciseId(strGenerateExerciseId2);
            daoSessionDb.getExerciseDataDao().insertOrReplace(exerciseData);
            com.up366.mobile.book.exercise.model.ExerciseData exerciseData2 = new com.up366.mobile.book.exercise.model.ExerciseData();
            exerciseData2.setExerciseId(strGenerateExerciseId);
            com.up366.mobile.common.logic.Auth.cur().db().getExerciseDataDao().queryBuilder().where(com.up366.greendao.ExerciseDataDao.Properties.ExerciseId.eq(exerciseData2.getExerciseId()), new org.greenrobot.greendao.query.WhereCondition[0]).buildDelete().executeDeleteWithoutDetachingEntities();
        }
    }

    private java.lang.String generateExerciseId(java.lang.Object obj, int i) {
        if (i == 1) {
            return "A-" + obj;
        }
        if (i == 5) {
            if (obj instanceof java.lang.String) {
                return i + "-" + obj;
            }
            return i + "-" + ((com.up366.mobile.book.model.ChapterInfo) obj).getId();
        }
        return i + "-" + obj;
    }
}
