package com.up366.mobile.common.compat;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V4DBCompatUpdate1 {
    public void compat() {
        java.lang.String str = "up366v4_" + com.up366.mobile.common.logic.Auth.UID() + ".db.bak";
        if (!com.up366.common.FileUtilsUp.isFileExists(com.up366.common.global.GB.get().getApplicationContext().getDatabasePath(str))) {
            new com.up366.mobile.common.compat.V4DBCompatUpdate2().compat();
            return;
        }
        try {
            com.up366.mobile.common.onlinelog.OpLog.report("COMPAT-V4DBCompatUpdate1", "doCompat:" + str);
            doCompat(str);
            new com.up366.mobile.common.compat.V4DBCompatUpdate2().compat();
        } catch (java.lang.Exception e) {
            com.up366.mobile.common.onlinelog.OpLog.report("COMPAT-V4DBCompatUpdate1Error", "doCompat:" + str, e);
            com.up366.common.log.Logger.error("TAG - V4DBCompatUpdate1 - compat - ", e);
        }
    }

    private void doCompat(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - V4DBCompatUpdate1 - doCompat - ");
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = com.up366.common.global.GB.get().getApplicationContext().openOrCreateDatabase(str, 0, null);
        try {
            android.database.Cursor cursorRawQuery = sQLiteDatabaseOpenOrCreateDatabase.rawQuery("select record_id,\ntype,\nnet_files,\nwav_path,\nduration,\nstate,\nresult,\nerr_count,\nadd_time,\nparams,\ncb_type from asec_session_model;", null);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            while (cursorRawQuery.moveToNext()) {
                com.up366.mobile.book.helper.recorder.AsecSessionModel asecSessionModel = new com.up366.mobile.book.helper.recorder.AsecSessionModel();
                asecSessionModel.setRecordId(cursorRawQuery.getString(0));
                asecSessionModel.setType(cursorRawQuery.getInt(1));
                asecSessionModel.setNetFiles(cursorRawQuery.getString(2));
                asecSessionModel.setWavPath(cursorRawQuery.getString(3));
                asecSessionModel.setDuration(cursorRawQuery.getLong(4));
                asecSessionModel.setState(cursorRawQuery.getInt(5));
                asecSessionModel.setResult(cursorRawQuery.getString(6));
                asecSessionModel.setErrCount(cursorRawQuery.getInt(7));
                asecSessionModel.setAddTime(cursorRawQuery.getLong(8));
                asecSessionModel.setParams(cursorRawQuery.getString(9));
                asecSessionModel.setCbType(cursorRawQuery.getInt(10));
                arrayList.add(asecSessionModel);
            }
            cursorRawQuery.close();
            com.up366.mobile.common.logic.Auth.cur().db().getAsecSessionModelDao().insertOrReplaceInTx(arrayList);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - V4DBCompatUpdate1 - doCompat - ", e);
        }
        sQLiteDatabaseOpenOrCreateDatabase.close();
        boolean zRenameTo = com.up366.common.global.GB.get().getApplicationContext().getDatabasePath(str).renameTo(com.up366.common.global.GB.get().getApplicationContext().getDatabasePath(str + ".bak"));
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - V4DBCompatUpdate1 - doCompat - ");
        sb.append(zRenameTo);
        com.up366.common.log.Logger.info(sb.toString());
    }
}
