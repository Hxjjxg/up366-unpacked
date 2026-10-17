package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StudyPlanInfoDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.course.task.model.StudyPlanInfo, java.lang.Long> {
    public static final java.lang.String TABLENAME = "study_plan_info";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property StudyPlanId = new org.greenrobot.greendao.Property(1, java.lang.Long.TYPE, "studyPlanId", false, "study_plan_id");
        public static final org.greenrobot.greendao.Property Flevel = new org.greenrobot.greendao.Property(2, java.lang.Integer.TYPE, "flevel", false, "flevel");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public StudyPlanInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public StudyPlanInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"study_plan_info\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"study_plan_id\" INTEGER NOT NULL ,\"flevel\" INTEGER NOT NULL );");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_study_plan_info_study_plan_id ON \"study_plan_info\" (\"study_plan_id\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"study_plan_info\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.course.task.model.StudyPlanInfo studyPlanInfo) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = studyPlanInfo.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        databaseStatement.bindLong(2, studyPlanInfo.getStudyPlanId());
        databaseStatement.bindLong(3, studyPlanInfo.getFlevel());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.course.task.model.StudyPlanInfo studyPlanInfo) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = studyPlanInfo.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        sQLiteStatement.bindLong(2, studyPlanInfo.getStudyPlanId());
        sQLiteStatement.bindLong(3, studyPlanInfo.getFlevel());
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m124readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.course.task.model.StudyPlanInfo m123readEntity(android.database.Cursor cursor, int i) {
        return new com.up366.mobile.course.task.model.StudyPlanInfo(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)), cursor.getLong(i + 1), cursor.getInt(i + 2));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.course.task.model.StudyPlanInfo studyPlanInfo, int i) {
        studyPlanInfo.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        studyPlanInfo.setStudyPlanId(cursor.getLong(i + 1));
        studyPlanInfo.setFlevel(cursor.getInt(i + 2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.course.task.model.StudyPlanInfo studyPlanInfo, long j) {
        studyPlanInfo.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.course.task.model.StudyPlanInfo studyPlanInfo) {
        if (studyPlanInfo != null) {
            return studyPlanInfo.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.course.task.model.StudyPlanInfo studyPlanInfo) {
        return studyPlanInfo.getRowId() != null;
    }
}
