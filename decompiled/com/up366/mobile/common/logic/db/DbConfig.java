package com.up366.mobile.common.logic.db;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DbConfig {
    private static final java.lang.String kDatabasePrefix = "up366v5";
    private static final java.lang.String kDatabaseSuffix = ".db";

    public static org.greenrobot.greendao.database.Database getDb(int i) {
        return new com.up366.mobile.common.logic.db.DbConfig.DbOpenHelper(com.up366.common.global.GB.get().getApplicationContext(), "up366v5_" + i + kDatabaseSuffix).getWritableDb();
    }

    public static class DbOpenHelper extends com.up366.greendao.DaoMaster.OpenHelper {
        DbOpenHelper(android.content.Context context, java.lang.String str) {
            super(context, str);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public void onUpgrade(org.greenrobot.greendao.database.Database database, int i, int i2) {
            com.up366.common.log.Logger.info("TAG - DbOpenHelper - onUpgrade - Upgrading schema from version " + i + " to " + i2);
            com.up366.greendao.DaoMaster.createAllTables(database, true);
            switch (i) {
                case 1:
                case 2:
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table task_info add column statement TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column configs TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table asec_session_model add column fingerprint_json_filepath TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_task_log_v2 add column submit_type INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table task_completed_info add column mark_status INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column params TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column paper_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column priority INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table file_map_info add uploaded priority BOOLEAN;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table returned_info add column return_code INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column is_shelf INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column study_task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column open_url TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column gray_config TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column op_log_id TEXT;");
                    break;
                case 3:
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column configs TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table asec_session_model add column fingerprint_json_filepath TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_task_log_v2 add column submit_type INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table task_completed_info add column mark_status INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column params TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column paper_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column priority INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table file_map_info add uploaded priority BOOLEAN;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table returned_info add column return_code INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column is_shelf INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column study_task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column open_url TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column gray_config TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column op_log_id TEXT;");
                    break;
                case 4:
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_task_log_v2 add column submit_type INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table task_completed_info add column mark_status INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column params TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column paper_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column priority INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table file_map_info add uploaded priority BOOLEAN;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table returned_info add column return_code INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column is_shelf INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column study_task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column open_url TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column gray_config TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column op_log_id TEXT;");
                    break;
                case 5:
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table task_completed_info add column mark_status INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column params TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column paper_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column priority INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table file_map_info add uploaded priority BOOLEAN;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table returned_info add column return_code INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column is_shelf INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column study_task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column open_url TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column gray_config TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column op_log_id TEXT;");
                    break;
                case 6:
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column params TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column paper_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column priority INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table file_map_info add uploaded priority BOOLEAN;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table returned_info add column return_code INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column is_shelf INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column study_task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column open_url TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column gray_config TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column op_log_id TEXT;");
                    break;
                case 7:
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column paper_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column priority INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table file_map_info add uploaded priority BOOLEAN;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table returned_info add column return_code INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column is_shelf INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column study_task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column open_url TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column gray_config TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column op_log_id TEXT;");
                    break;
                case 9:
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column priority INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table file_map_info add uploaded priority BOOLEAN;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table returned_info add column return_code INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column is_shelf INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column study_task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column open_url TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column gray_config TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column op_log_id TEXT;");
                    break;
                case 10:
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table file_map_info add uploaded priority BOOLEAN;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table returned_info add column return_code INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column is_shelf INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column study_task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column open_url TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column gray_config TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column op_log_id TEXT;");
                    break;
                case 11:
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table returned_info add column return_code INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column is_shelf INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column study_task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column open_url TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column gray_config TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column op_log_id TEXT;");
                    break;
                case 12:
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column is_shelf INTEGER;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column study_task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column open_url TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column gray_config TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column op_log_id TEXT;");
                    break;
                case 13:
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column study_task_id TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column open_url TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column gray_config TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column op_log_id TEXT;");
                    break;
                case 14:
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column resource_list TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table book_detail_info add column open_url TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column gray_config TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column op_log_id TEXT;");
                    break;
                case 15:
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table chapter_info add column gray_config TEXT;");
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column op_log_id TEXT;");
                    break;
                case 16:
                    com.up366.mobile.common.logic.db.DbConfig.safeExec(database, "alter table batch_upload_log add column op_log_id TEXT;");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void safeExec(org.greenrobot.greendao.database.Database database, java.lang.String str) {
        try {
            database.execSQL(str);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("updateDB   ... error\n" + e.getMessage(), e);
            com.up366.mobile.common.onlinelog.OpLog.report("DBError-safeExec", str, e);
        }
    }
}
