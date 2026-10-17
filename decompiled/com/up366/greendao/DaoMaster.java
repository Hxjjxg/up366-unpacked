package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DaoMaster extends org.greenrobot.greendao.AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 17;

    public static void createAllTables(org.greenrobot.greendao.database.Database database, boolean z) {
        com.up366.greendao.ExerciseDataDao.createTable(database, z);
        com.up366.greendao.AsecSessionModelDao.createTable(database, z);
        com.up366.greendao.BookDetailInfoDao.createTable(database, z);
        com.up366.greendao.BookScheduleInfoDao.createTable(database, z);
        com.up366.greendao.BookTaskFinishedInfoDao.createTable(database, z);
        com.up366.greendao.BookTaskLogHistoryDao.createTable(database, z);
        com.up366.greendao.BookTaskLogV2Dao.createTable(database, z);
        com.up366.greendao.ChapterInfoDao.createTable(database, z);
        com.up366.greendao.CourseBookPlanDao.createTable(database, z);
        com.up366.greendao.SpeechDataInfoDao.createTable(database, z);
        com.up366.greendao.StudyTaskHistoryDao.createTable(database, z);
        com.up366.greendao.RequestTimeObjectDao.createTable(database, z);
        com.up366.greendao.BatchUploadItemDao.createTable(database, z);
        com.up366.greendao.BatchUploadLogDao.createTable(database, z);
        com.up366.greendao.MessagesDao.createTable(database, z);
        com.up366.greendao.ProductInfoDao.createTable(database, z);
        com.up366.greendao.UserOrderDao.createTable(database, z);
        com.up366.greendao.FileMapInfoDao.createTable(database, z);
        com.up366.greendao.CourseBookInfoDao.createTable(database, z);
        com.up366.greendao.CourseInfoDao.createTable(database, z);
        com.up366.greendao.TaskInfoV2Dao.createTable(database, z);
        com.up366.greendao.ReturnedInfoDao.createTable(database, z);
        com.up366.greendao.StudyPlanInfoDao.createTable(database, z);
        com.up366.greendao.TaskCompletedInfoDao.createTable(database, z);
        com.up366.greendao.GoodsInfoDao.createTable(database, z);
        com.up366.greendao.MeTeachingClassDao.createTable(database, z);
    }

    public static void dropAllTables(org.greenrobot.greendao.database.Database database, boolean z) {
        com.up366.greendao.ExerciseDataDao.dropTable(database, z);
        com.up366.greendao.AsecSessionModelDao.dropTable(database, z);
        com.up366.greendao.BookDetailInfoDao.dropTable(database, z);
        com.up366.greendao.BookScheduleInfoDao.dropTable(database, z);
        com.up366.greendao.BookTaskFinishedInfoDao.dropTable(database, z);
        com.up366.greendao.BookTaskLogHistoryDao.dropTable(database, z);
        com.up366.greendao.BookTaskLogV2Dao.dropTable(database, z);
        com.up366.greendao.ChapterInfoDao.dropTable(database, z);
        com.up366.greendao.CourseBookPlanDao.dropTable(database, z);
        com.up366.greendao.SpeechDataInfoDao.dropTable(database, z);
        com.up366.greendao.StudyTaskHistoryDao.dropTable(database, z);
        com.up366.greendao.RequestTimeObjectDao.dropTable(database, z);
        com.up366.greendao.BatchUploadItemDao.dropTable(database, z);
        com.up366.greendao.BatchUploadLogDao.dropTable(database, z);
        com.up366.greendao.MessagesDao.dropTable(database, z);
        com.up366.greendao.ProductInfoDao.dropTable(database, z);
        com.up366.greendao.UserOrderDao.dropTable(database, z);
        com.up366.greendao.FileMapInfoDao.dropTable(database, z);
        com.up366.greendao.CourseBookInfoDao.dropTable(database, z);
        com.up366.greendao.CourseInfoDao.dropTable(database, z);
        com.up366.greendao.TaskInfoV2Dao.dropTable(database, z);
        com.up366.greendao.ReturnedInfoDao.dropTable(database, z);
        com.up366.greendao.StudyPlanInfoDao.dropTable(database, z);
        com.up366.greendao.TaskCompletedInfoDao.dropTable(database, z);
        com.up366.greendao.GoodsInfoDao.dropTable(database, z);
        com.up366.greendao.MeTeachingClassDao.dropTable(database, z);
    }

    public static com.up366.greendao.DaoSession newDevSession(android.content.Context context, java.lang.String str) {
        return new com.up366.greendao.DaoMaster(new com.up366.greendao.DaoMaster.DevOpenHelper(context, str).getWritableDb()).mo103newSession();
    }

    public DaoMaster(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        this((org.greenrobot.greendao.database.Database) new org.greenrobot.greendao.database.StandardDatabase(sQLiteDatabase));
    }

    public DaoMaster(org.greenrobot.greendao.database.Database database) {
        super(database, 17);
        registerDaoClass(com.up366.greendao.ExerciseDataDao.class);
        registerDaoClass(com.up366.greendao.AsecSessionModelDao.class);
        registerDaoClass(com.up366.greendao.BookDetailInfoDao.class);
        registerDaoClass(com.up366.greendao.BookScheduleInfoDao.class);
        registerDaoClass(com.up366.greendao.BookTaskFinishedInfoDao.class);
        registerDaoClass(com.up366.greendao.BookTaskLogHistoryDao.class);
        registerDaoClass(com.up366.greendao.BookTaskLogV2Dao.class);
        registerDaoClass(com.up366.greendao.ChapterInfoDao.class);
        registerDaoClass(com.up366.greendao.CourseBookPlanDao.class);
        registerDaoClass(com.up366.greendao.SpeechDataInfoDao.class);
        registerDaoClass(com.up366.greendao.StudyTaskHistoryDao.class);
        registerDaoClass(com.up366.greendao.RequestTimeObjectDao.class);
        registerDaoClass(com.up366.greendao.BatchUploadItemDao.class);
        registerDaoClass(com.up366.greendao.BatchUploadLogDao.class);
        registerDaoClass(com.up366.greendao.MessagesDao.class);
        registerDaoClass(com.up366.greendao.ProductInfoDao.class);
        registerDaoClass(com.up366.greendao.UserOrderDao.class);
        registerDaoClass(com.up366.greendao.FileMapInfoDao.class);
        registerDaoClass(com.up366.greendao.CourseBookInfoDao.class);
        registerDaoClass(com.up366.greendao.CourseInfoDao.class);
        registerDaoClass(com.up366.greendao.TaskInfoV2Dao.class);
        registerDaoClass(com.up366.greendao.ReturnedInfoDao.class);
        registerDaoClass(com.up366.greendao.StudyPlanInfoDao.class);
        registerDaoClass(com.up366.greendao.TaskCompletedInfoDao.class);
        registerDaoClass(com.up366.greendao.GoodsInfoDao.class);
        registerDaoClass(com.up366.greendao.MeTeachingClassDao.class);
    }

    @Override // 
    /* JADX INFO: renamed from: newSession */
    public com.up366.greendao.DaoSession mo103newSession() {
        return new com.up366.greendao.DaoSession(this.db, org.greenrobot.greendao.identityscope.IdentityScopeType.Session, this.daoConfigMap);
    }

    /* JADX INFO: renamed from: newSession, reason: merged with bridge method [inline-methods] */
    public com.up366.greendao.DaoSession m104newSession(org.greenrobot.greendao.identityscope.IdentityScopeType identityScopeType) {
        return new com.up366.greendao.DaoSession(this.db, identityScopeType, this.daoConfigMap);
    }

    public static abstract class OpenHelper extends org.greenrobot.greendao.database.DatabaseOpenHelper {
        public OpenHelper(android.content.Context context, java.lang.String str) {
            super(context, str, 17);
        }

        public OpenHelper(android.content.Context context, java.lang.String str, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory, 17);
        }

        public void onCreate(org.greenrobot.greendao.database.Database database) {
            android.util.Log.i("greenDAO", "Creating tables for schema version 17");
            com.up366.greendao.DaoMaster.createAllTables(database, false);
        }
    }

    public static class DevOpenHelper extends com.up366.greendao.DaoMaster.OpenHelper {
        public DevOpenHelper(android.content.Context context, java.lang.String str) {
            super(context, str);
        }

        public DevOpenHelper(android.content.Context context, java.lang.String str, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory);
        }

        public void onUpgrade(org.greenrobot.greendao.database.Database database, int i, int i2) {
            android.util.Log.i("greenDAO", "Upgrading schema from version " + i + " to " + i2 + " by dropping all tables");
            com.up366.greendao.DaoMaster.dropAllTables(database, true);
            onCreate(database);
        }
    }
}
