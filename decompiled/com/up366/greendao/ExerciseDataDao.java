package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ExerciseDataDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.book.exercise.model.ExerciseData, java.lang.Long> {
    public static final java.lang.String TABLENAME = "exercise_data";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property ExerciseId = new org.greenrobot.greendao.Property(1, java.lang.String.class, "exerciseId", false, "exercise_id");
        public static final org.greenrobot.greendao.Property PaperXml = new org.greenrobot.greendao.Property(2, java.lang.String.class, "paperXml", false, "paper_xml");
        public static final org.greenrobot.greendao.Property StandardXml = new org.greenrobot.greendao.Property(3, java.lang.String.class, "standardXml", false, "standard_xml");
        public static final org.greenrobot.greendao.Property AnswerXml = new org.greenrobot.greendao.Property(4, java.lang.String.class, "answerXml", false, "answer_xml");
        public static final org.greenrobot.greendao.Property MarkXml = new org.greenrobot.greendao.Property(5, java.lang.String.class, "markXml", false, "mark_xml");
        public static final org.greenrobot.greendao.Property ResourceDir = new org.greenrobot.greendao.Property(6, java.lang.String.class, "resourceDir", false, "resource_dir");
        public static final org.greenrobot.greendao.Property HasSubmit = new org.greenrobot.greendao.Property(7, java.lang.Integer.TYPE, "hasSubmit", false, "has_submit");
        public static final org.greenrobot.greendao.Property HasMark = new org.greenrobot.greendao.Property(8, java.lang.Integer.TYPE, "hasMark", false, "has_mark");
        public static final org.greenrobot.greendao.Property CurPage = new org.greenrobot.greendao.Property(9, java.lang.Integer.TYPE, "curPage", false, "cur_page");
        public static final org.greenrobot.greendao.Property Score = new org.greenrobot.greendao.Property(10, java.lang.Float.TYPE, "score", false, "score");
        public static final org.greenrobot.greendao.Property StartTime = new org.greenrobot.greendao.Property(11, java.lang.Long.TYPE, "startTime", false, "start_time");
        public static final org.greenrobot.greendao.Property SubmitTime = new org.greenrobot.greendao.Property(12, java.lang.Long.TYPE, "submitTime", false, "submit_time");
        public static final org.greenrobot.greendao.Property AnswerTime = new org.greenrobot.greendao.Property(13, java.lang.Long.TYPE, "answerTime", false, "answer_time");
        public static final org.greenrobot.greendao.Property Version = new org.greenrobot.greendao.Property(14, java.lang.Integer.TYPE, "version", false, "version");
        public static final org.greenrobot.greendao.Property TotalScore = new org.greenrobot.greendao.Property(15, java.lang.Float.TYPE, "totalScore", false, "total_score");
        public static final org.greenrobot.greendao.Property QuestionNum = new org.greenrobot.greendao.Property(16, java.lang.Integer.TYPE, "questionNum", false, "question_num");
        public static final org.greenrobot.greendao.Property RightNum = new org.greenrobot.greendao.Property(17, java.lang.Integer.TYPE, "rightNum", false, "right_num");
        public static final org.greenrobot.greendao.Property WrongWordSize = new org.greenrobot.greendao.Property(18, java.lang.Integer.TYPE, "wrongWordSize", false, "wrong_word_size");
        public static final org.greenrobot.greendao.Property WordIds = new org.greenrobot.greendao.Property(19, java.lang.String.class, "wordIds", false, "word_ids");
        public static final org.greenrobot.greendao.Property HalfRightNum = new org.greenrobot.greendao.Property(20, java.lang.Integer.TYPE, "halfRightNum", false, "half_right_num");
        public static final org.greenrobot.greendao.Property QstWordMap = new org.greenrobot.greendao.Property(21, java.lang.String.class, "qstWordMap", false, "qst_word_map");
        public static final org.greenrobot.greendao.Property EnterTime = new org.greenrobot.greendao.Property(22, java.lang.Long.TYPE, "enterTime", false, "ENTER_TIME");
        public static final org.greenrobot.greendao.Property HasPause = new org.greenrobot.greendao.Property(23, java.lang.Boolean.TYPE, "hasPause", false, "HAS_PAUSE");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public ExerciseDataDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public ExerciseDataDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"exercise_data\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"exercise_id\" TEXT,\"paper_xml\" TEXT,\"standard_xml\" TEXT,\"answer_xml\" TEXT,\"mark_xml\" TEXT,\"resource_dir\" TEXT,\"has_submit\" INTEGER NOT NULL ,\"has_mark\" INTEGER NOT NULL ,\"cur_page\" INTEGER NOT NULL ,\"score\" REAL NOT NULL ,\"start_time\" INTEGER NOT NULL ,\"submit_time\" INTEGER NOT NULL ,\"answer_time\" INTEGER NOT NULL ,\"version\" INTEGER NOT NULL ,\"total_score\" REAL NOT NULL ,\"question_num\" INTEGER NOT NULL ,\"right_num\" INTEGER NOT NULL ,\"wrong_word_size\" INTEGER NOT NULL ,\"word_ids\" TEXT,\"half_right_num\" INTEGER NOT NULL ,\"qst_word_map\" TEXT,\"ENTER_TIME\" INTEGER NOT NULL ,\"HAS_PAUSE\" INTEGER NOT NULL );");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_exercise_data_exercise_id ON \"exercise_data\" (\"exercise_id\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"exercise_data\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.book.exercise.model.ExerciseData exerciseData) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = exerciseData.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String exerciseId = exerciseData.getExerciseId();
        if (exerciseId != null) {
            databaseStatement.bindString(2, exerciseId);
        }
        java.lang.String paperXml = exerciseData.getPaperXml();
        if (paperXml != null) {
            databaseStatement.bindString(3, paperXml);
        }
        java.lang.String standardXml = exerciseData.getStandardXml();
        if (standardXml != null) {
            databaseStatement.bindString(4, standardXml);
        }
        java.lang.String answerXml = exerciseData.getAnswerXml();
        if (answerXml != null) {
            databaseStatement.bindString(5, answerXml);
        }
        java.lang.String markXml = exerciseData.getMarkXml();
        if (markXml != null) {
            databaseStatement.bindString(6, markXml);
        }
        java.lang.String resourceDir = exerciseData.getResourceDir();
        if (resourceDir != null) {
            databaseStatement.bindString(7, resourceDir);
        }
        databaseStatement.bindLong(8, exerciseData.getHasSubmit());
        databaseStatement.bindLong(9, exerciseData.getHasMark());
        databaseStatement.bindLong(10, exerciseData.getCurPage());
        databaseStatement.bindDouble(11, exerciseData.getScore());
        databaseStatement.bindLong(12, exerciseData.getStartTime());
        databaseStatement.bindLong(13, exerciseData.getSubmitTime());
        databaseStatement.bindLong(14, exerciseData.getAnswerTime());
        databaseStatement.bindLong(15, exerciseData.getVersion());
        databaseStatement.bindDouble(16, exerciseData.getTotalScore());
        databaseStatement.bindLong(17, exerciseData.getQuestionNum());
        databaseStatement.bindLong(18, exerciseData.getRightNum());
        databaseStatement.bindLong(19, exerciseData.getWrongWordSize());
        java.lang.String wordIds = exerciseData.getWordIds();
        if (wordIds != null) {
            databaseStatement.bindString(20, wordIds);
        }
        databaseStatement.bindLong(21, exerciseData.getHalfRightNum());
        java.lang.String qstWordMap = exerciseData.getQstWordMap();
        if (qstWordMap != null) {
            databaseStatement.bindString(22, qstWordMap);
        }
        databaseStatement.bindLong(23, exerciseData.getEnterTime());
        databaseStatement.bindLong(24, exerciseData.getHasPause() ? 1L : 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.book.exercise.model.ExerciseData exerciseData) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = exerciseData.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String exerciseId = exerciseData.getExerciseId();
        if (exerciseId != null) {
            sQLiteStatement.bindString(2, exerciseId);
        }
        java.lang.String paperXml = exerciseData.getPaperXml();
        if (paperXml != null) {
            sQLiteStatement.bindString(3, paperXml);
        }
        java.lang.String standardXml = exerciseData.getStandardXml();
        if (standardXml != null) {
            sQLiteStatement.bindString(4, standardXml);
        }
        java.lang.String answerXml = exerciseData.getAnswerXml();
        if (answerXml != null) {
            sQLiteStatement.bindString(5, answerXml);
        }
        java.lang.String markXml = exerciseData.getMarkXml();
        if (markXml != null) {
            sQLiteStatement.bindString(6, markXml);
        }
        java.lang.String resourceDir = exerciseData.getResourceDir();
        if (resourceDir != null) {
            sQLiteStatement.bindString(7, resourceDir);
        }
        sQLiteStatement.bindLong(8, exerciseData.getHasSubmit());
        sQLiteStatement.bindLong(9, exerciseData.getHasMark());
        sQLiteStatement.bindLong(10, exerciseData.getCurPage());
        sQLiteStatement.bindDouble(11, exerciseData.getScore());
        sQLiteStatement.bindLong(12, exerciseData.getStartTime());
        sQLiteStatement.bindLong(13, exerciseData.getSubmitTime());
        sQLiteStatement.bindLong(14, exerciseData.getAnswerTime());
        sQLiteStatement.bindLong(15, exerciseData.getVersion());
        sQLiteStatement.bindDouble(16, exerciseData.getTotalScore());
        sQLiteStatement.bindLong(17, exerciseData.getQuestionNum());
        sQLiteStatement.bindLong(18, exerciseData.getRightNum());
        sQLiteStatement.bindLong(19, exerciseData.getWrongWordSize());
        java.lang.String wordIds = exerciseData.getWordIds();
        if (wordIds != null) {
            sQLiteStatement.bindString(20, wordIds);
        }
        sQLiteStatement.bindLong(21, exerciseData.getHalfRightNum());
        java.lang.String qstWordMap = exerciseData.getQstWordMap();
        if (qstWordMap != null) {
            sQLiteStatement.bindString(22, qstWordMap);
        }
        sQLiteStatement.bindLong(23, exerciseData.getEnterTime());
        sQLiteStatement.bindLong(24, exerciseData.getHasPause() ? 1L : 0L);
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m106readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.book.exercise.model.ExerciseData m105readEntity(android.database.Cursor cursor, int i) {
        java.lang.Long lValueOf = cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i));
        int i2 = i + 1;
        java.lang.String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 2;
        java.lang.String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 3;
        java.lang.String string3 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 4;
        java.lang.String string4 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 5;
        java.lang.String string5 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 6;
        java.lang.String string6 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = cursor.getInt(i + 7);
        int i9 = cursor.getInt(i + 8);
        int i10 = cursor.getInt(i + 9);
        float f = cursor.getFloat(i + 10);
        long j = cursor.getLong(i + 11);
        long j2 = cursor.getLong(i + 12);
        long j3 = cursor.getLong(i + 13);
        int i11 = cursor.getInt(i + 14);
        float f2 = cursor.getFloat(i + 15);
        int i12 = cursor.getInt(i + 16);
        int i13 = cursor.getInt(i + 17);
        int i14 = cursor.getInt(i + 18);
        int i15 = i + 19;
        java.lang.String string7 = cursor.isNull(i15) ? null : cursor.getString(i15);
        int i16 = i + 21;
        return new com.up366.mobile.book.exercise.model.ExerciseData(lValueOf, string, string2, string3, string4, string5, string6, i8, i9, i10, f, j, j2, j3, i11, f2, i12, i13, i14, string7, cursor.getInt(i + 20), cursor.isNull(i16) ? null : cursor.getString(i16), cursor.getLong(i + 22), cursor.getShort(i + 23) != 0);
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.book.exercise.model.ExerciseData exerciseData, int i) {
        exerciseData.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        exerciseData.setExerciseId(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        exerciseData.setPaperXml(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 3;
        exerciseData.setStandardXml(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 4;
        exerciseData.setAnswerXml(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 5;
        exerciseData.setMarkXml(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 6;
        exerciseData.setResourceDir(cursor.isNull(i7) ? null : cursor.getString(i7));
        exerciseData.setHasSubmit(cursor.getInt(i + 7));
        exerciseData.setHasMark(cursor.getInt(i + 8));
        exerciseData.setCurPage(cursor.getInt(i + 9));
        exerciseData.setScore(cursor.getFloat(i + 10));
        exerciseData.setStartTime(cursor.getLong(i + 11));
        exerciseData.setSubmitTime(cursor.getLong(i + 12));
        exerciseData.setAnswerTime(cursor.getLong(i + 13));
        exerciseData.setVersion(cursor.getInt(i + 14));
        exerciseData.setTotalScore(cursor.getFloat(i + 15));
        exerciseData.setQuestionNum(cursor.getInt(i + 16));
        exerciseData.setRightNum(cursor.getInt(i + 17));
        exerciseData.setWrongWordSize(cursor.getInt(i + 18));
        int i8 = i + 19;
        exerciseData.setWordIds(cursor.isNull(i8) ? null : cursor.getString(i8));
        exerciseData.setHalfRightNum(cursor.getInt(i + 20));
        int i9 = i + 21;
        exerciseData.setQstWordMap(cursor.isNull(i9) ? null : cursor.getString(i9));
        exerciseData.setEnterTime(cursor.getLong(i + 22));
        exerciseData.setHasPause(cursor.getShort(i + 23) != 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.book.exercise.model.ExerciseData exerciseData, long j) {
        exerciseData.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.book.exercise.model.ExerciseData exerciseData) {
        if (exerciseData != null) {
            return exerciseData.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.book.exercise.model.ExerciseData exerciseData) {
        return exerciseData.getRowId() != null;
    }
}
