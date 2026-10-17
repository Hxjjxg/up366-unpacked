package com.up366.mobile.common.compat;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V4DBCompatUpdate2 {
    public void compat() {
        if (!com.up366.mobile.common.utils.PreferenceUtils.getBoolean("has-clean-book-tree-version" + com.up366.mobile.common.logic.Auth.UID(), false)) {
            com.up366.common.log.Logger.info("TAG - V4DBCompatUpdate2 - compat - clean-book-tree-version");
            cleanChapterTreeCache();
            com.up366.mobile.common.utils.PreferenceUtils.putBoolean("has-clean-book-tree-version" + com.up366.mobile.common.logic.Auth.UID(), true);
        }
        java.lang.String str = "up366v4_" + com.up366.mobile.common.logic.Auth.UID() + ".db.bak.bak";
        if (com.up366.common.FileUtilsUp.isFileExists(com.up366.common.global.GB.get().getApplicationContext().getDatabasePath(str))) {
            try {
                com.up366.mobile.common.onlinelog.OpLog.report("COMPAT-V4DBCompatUpdate2", "doCompat:" + str);
                doCompat(str);
            } catch (java.lang.Exception e) {
                com.up366.mobile.common.onlinelog.OpLog.report("COMPAT-V4DBCompatUpdate2Error", "doCompat:" + str, e);
                com.up366.common.log.Logger.error("TAG - V4DBCompatUpdate2 - compat - ", e);
            }
        }
    }

    private void cleanChapterTreeCache() {
        for (com.up366.mobile.common.logic.model.AppCacheInfo appCacheInfo : com.up366.mobile.common.logic.Auth.cur().getBox(com.up366.mobile.common.logic.model.AppCacheInfo.class).getAll()) {
            if (appCacheInfo.getKey().startsWith("book-tree-version")) {
                com.up366.mobile.common.logic.Auth.cur().getBox(com.up366.mobile.common.logic.model.AppCacheInfo.class).remove(appCacheInfo);
                com.up366.common.log.Logger.info("TAG - V4DBCompatUpdate2 - cleanChapterTreeCache - clean : " + appCacheInfo.getKey());
            }
        }
    }

    private void doCompat(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - V4DBCompatUpdate2 - doCompat - ");
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = com.up366.common.global.GB.get().getApplicationContext().openOrCreateDatabase(str, 0, null);
        try {
            android.database.Cursor cursorRawQuery = sQLiteDatabaseOpenOrCreateDatabase.rawQuery("select guid,\ntask_id,\ninsert_time,\nscore,\nstudy_task_id,\nkill_by from study_task_history;", null);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            while (cursorRawQuery.moveToNext()) {
                com.up366.mobile.book.model.StudyTaskHistory studyTaskHistory = new com.up366.mobile.book.model.StudyTaskHistory();
                studyTaskHistory.setGuid(cursorRawQuery.getString(0));
                studyTaskHistory.setTaskId(cursorRawQuery.getString(1));
                studyTaskHistory.setInsertTime(cursorRawQuery.getLong(2));
                studyTaskHistory.setScore(cursorRawQuery.getFloat(3));
                studyTaskHistory.setStudyTaskId(cursorRawQuery.getString(4));
                studyTaskHistory.setKillBy(cursorRawQuery.getInt(5));
                arrayList.add(studyTaskHistory);
            }
            cursorRawQuery.close();
            com.up366.mobile.common.logic.Auth.cur().db().getStudyTaskHistoryDao().insertOrReplaceInTx(arrayList);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - V4DBCompatUpdate2 - doCompat - ", e);
        }
        sQLiteDatabaseOpenOrCreateDatabase.close();
        boolean zRenameTo = com.up366.common.global.GB.get().getApplicationContext().getDatabasePath(str).renameTo(com.up366.common.global.GB.get().getApplicationContext().getDatabasePath(str + ".bak"));
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - V4DBCompatUpdate2 - doCompat - ");
        sb.append(zRenameTo);
        com.up366.common.log.Logger.info(sb.toString());
    }
}
