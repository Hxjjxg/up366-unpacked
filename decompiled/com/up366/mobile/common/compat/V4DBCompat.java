package com.up366.mobile.common.compat;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V4DBCompat {
    public void compat() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.V4DBCompat$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$compat$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$compat$0() throws java.lang.Exception {
        synchronized (com.up366.mobile.common.compat.V4DBCompat.class) {
            java.lang.String str = "up366v4_" + com.up366.mobile.common.logic.Auth.UID() + ".db";
            if (!com.up366.common.FileUtilsUp.isFileExists(com.up366.common.global.GB.get().getApplicationContext().getDatabasePath(str))) {
                new com.up366.mobile.common.compat.V4DBCompatUpdate1().compat();
                return;
            }
            try {
                com.up366.mobile.common.onlinelog.OpLog.report("COMPAT-V4DBCompat", "doCompat:" + str);
                doCompat(str);
                new com.up366.mobile.common.compat.V4DBCompatUpdate1().compat();
            } catch (java.lang.Exception e) {
                com.up366.mobile.common.onlinelog.OpLog.report("COMPAT-V4DBCompatError", "doCompat:" + str, e);
                com.up366.common.log.Logger.error("TAG - 2020/2/7 - V4DBCompat - compat - ", e);
            }
        }
    }

    private void doCompat(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2020/2/7 - V4DBCompat - doCompat - ");
        int i = 0;
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = com.up366.common.global.GB.get().getApplicationContext().openOrCreateDatabase(str, 0, null);
        int i2 = 2;
        int i3 = 1;
        try {
            android.database.Cursor cursorRawQuery = sQLiteDatabaseOpenOrCreateDatabase.rawQuery("select guid, data, data1 from speech_data_info;", null);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            while (cursorRawQuery.moveToNext()) {
                com.up366.mobile.book.model.SpeechDataInfo speechDataInfo = new com.up366.mobile.book.model.SpeechDataInfo();
                speechDataInfo.setGuid(cursorRawQuery.getString(0));
                speechDataInfo.setData(cursorRawQuery.getString(1));
                speechDataInfo.setData1(cursorRawQuery.getString(2));
                arrayList.add(speechDataInfo);
            }
            cursorRawQuery.close();
            com.up366.mobile.common.logic.Auth.cur().db().getSpeechDataInfoDao().insertOrReplaceInTx(arrayList);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - 2020/2/7 - V4DBCompat - doCompat - ", e);
        }
        int i4 = 7;
        try {
            android.database.Cursor cursorRawQuery2 = sQLiteDatabaseOpenOrCreateDatabase.rawQuery("SELECT exercise_id,\npaper_xml,\nstandard_xml,\nanswer_xml,\nmark_xml,\nresource_dir,\nhas_submit,\nhas_mark,\ncur_page,\nscore,\nstart_time,\nsubmit_time,\nanswer_time,\nversion,\ntotal_score,\nquestion_num,\nright_num,\nwrong_word_size,\nword_ids,\nhalf_right_num,\nqst_word_map FROM exercise_data;", null);
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            while (cursorRawQuery2.moveToNext()) {
                com.up366.mobile.book.exercise.model.ExerciseData exerciseData = new com.up366.mobile.book.exercise.model.ExerciseData();
                exerciseData.setExerciseId(cursorRawQuery2.getString(0));
                exerciseData.setPaperXml(cursorRawQuery2.getString(1));
                exerciseData.setStandardXml(cursorRawQuery2.getString(2));
                exerciseData.setAnswerXml(cursorRawQuery2.getString(3));
                exerciseData.setMarkXml(cursorRawQuery2.getString(4));
                exerciseData.setResourceDir(cursorRawQuery2.getString(5));
                exerciseData.setHasSubmit(cursorRawQuery2.getInt(6));
                exerciseData.setHasMark(cursorRawQuery2.getInt(i4));
                exerciseData.setCurPage(cursorRawQuery2.getInt(8));
                exerciseData.setScore(cursorRawQuery2.getFloat(9));
                exerciseData.setStartTime(cursorRawQuery2.getLong(10));
                exerciseData.setSubmitTime(cursorRawQuery2.getLong(11));
                exerciseData.setAnswerTime(cursorRawQuery2.getLong(12));
                exerciseData.setVersion(cursorRawQuery2.getInt(13));
                exerciseData.setTotalScore(cursorRawQuery2.getFloat(14));
                exerciseData.setQuestionNum(cursorRawQuery2.getInt(15));
                exerciseData.setRightNum(cursorRawQuery2.getInt(16));
                exerciseData.setWrongWordSize(cursorRawQuery2.getInt(17));
                exerciseData.setWordIds(cursorRawQuery2.getString(18));
                exerciseData.setHalfRightNum(cursorRawQuery2.getInt(19));
                exerciseData.setQstWordMap(cursorRawQuery2.getString(20));
                arrayList2.add(exerciseData);
                i4 = 7;
            }
            cursorRawQuery2.close();
            com.up366.mobile.common.logic.Auth.cur().db().getExerciseDataDao().insertInTx(arrayList2);
        } catch (java.lang.Exception e2) {
            com.up366.common.log.Logger.error("TAG - 2020/2/7 - V4DBCompat - doCompat - ", e2);
        }
        try {
            android.database.Cursor cursorRawQuery3 = sQLiteDatabaseOpenOrCreateDatabase.rawQuery("select guid,\ntask_id,\ninsert_time,\nlog_data from book_task_log_history;", null);
            java.util.ArrayList arrayList3 = new java.util.ArrayList();
            while (cursorRawQuery3.moveToNext()) {
                com.up366.mobile.book.model.BookTaskLogHistory bookTaskLogHistory = new com.up366.mobile.book.model.BookTaskLogHistory();
                bookTaskLogHistory.setGuid(cursorRawQuery3.getString(0));
                bookTaskLogHistory.setTaskId(cursorRawQuery3.getString(1));
                bookTaskLogHistory.setInsertTime(cursorRawQuery3.getLong(2));
                bookTaskLogHistory.setLogData(cursorRawQuery3.getBlob(3));
                arrayList3.add(bookTaskLogHistory);
            }
            cursorRawQuery3.close();
            com.up366.mobile.common.logic.Auth.cur().db().getBookTaskLogHistoryDao().insertInTx(arrayList3);
        } catch (java.lang.Exception e3) {
            com.up366.common.log.Logger.error("TAG - 2020/2/7 - V4DBCompat - doCompat - ", e3);
        }
        try {
            android.database.Cursor cursorRawQuery4 = sQLiteDatabaseOpenOrCreateDatabase.rawQuery("select guid,\ninfo,\nadd_time,\nupdate_time,\ntry_count,\nerr_code,\nerr_info,\nerr_history,\ntype from common_log;", null);
            java.util.ArrayList arrayList4 = new java.util.ArrayList();
            java.util.ArrayList arrayList5 = new java.util.ArrayList();
            while (cursorRawQuery4.moveToNext()) {
                com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog();
                batchUploadLog.setBatchId(cursorRawQuery4.getString(i));
                com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(cursorRawQuery4.getString(i3));
                batchUploadLog.setRefKey(object.getString("refKey"));
                batchUploadLog.setTotalFileSize(object.getLongValue("totalFileSize"));
                batchUploadLog.setUploadFileSize(object.getLongValue("overFileSize"));
                batchUploadLog.setType(object.getIntValue("type"));
                com.alibaba.fastjson.JSONArray jSONArray = object.getJSONArray("tasks");
                int i5 = 0;
                while (i5 < jSONArray.size()) {
                    com.alibaba.fastjson.JSONObject jSONObject = jSONArray.getJSONObject(i5);
                    com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem = new com.up366.mobile.common.logic.log.model.BatchUploadItem();
                    batchUploadItem.setId(jSONObject.getIntValue(com.igexin.push.core.b.C));
                    batchUploadItem.setType(jSONObject.getIntValue("type"));
                    batchUploadItem.setSize(jSONObject.getLongValue("size"));
                    batchUploadItem.setUploadSize(jSONObject.getLongValue("curSize"));
                    batchUploadItem.setState(jSONObject.getIntValue("state"));
                    batchUploadItem.setConfigUrl(jSONObject.getString("configUrl"));
                    batchUploadItem.setPostParams(jSONObject.getString("postParams"));
                    batchUploadItem.setPath(jSONObject.getString(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH));
                    batchUploadItem.setObjectId(jSONObject.getString("objectId"));
                    batchUploadLog.addTask(batchUploadItem);
                    arrayList5.add(batchUploadItem);
                    i5++;
                    i2 = 2;
                }
                int i6 = i2;
                batchUploadLog.setAddTime(((long) cursorRawQuery4.getInt(i6)) * 1000);
                batchUploadLog.setUpdateTime(((long) cursorRawQuery4.getInt(3)) * 1000);
                batchUploadLog.setTryCount(cursorRawQuery4.getInt(4));
                batchUploadLog.setErrCode(cursorRawQuery4.getInt(5));
                batchUploadLog.setErrInfo(cursorRawQuery4.getString(6));
                batchUploadLog.setErrHistory(cursorRawQuery4.getString(7));
                batchUploadLog.setType(cursorRawQuery4.getInt(8));
                arrayList4.add(batchUploadLog);
                i3 = 1;
                i2 = i6;
                i = 0;
            }
            cursorRawQuery4.close();
            com.up366.mobile.common.logic.Auth.cur().db().getBatchUploadItemDao().insertInTx(arrayList5);
            com.up366.mobile.common.logic.Auth.cur().db().getBatchUploadLogDao().insertInTx(arrayList4);
        } catch (java.lang.Exception e4) {
            com.up366.common.log.Logger.error("TAG - 2020/2/7 - V4DBCompat - doCompat - ", e4);
        }
        sQLiteDatabaseOpenOrCreateDatabase.close();
        boolean zRenameTo = com.up366.common.global.GB.get().getApplicationContext().getDatabasePath(str).renameTo(com.up366.common.global.GB.get().getApplicationContext().getDatabasePath(str + ".bak"));
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - 2020/2/7 - V4DBCompat - doCompat - ");
        sb.append(zRenameTo);
        com.up366.common.log.Logger.info(sb.toString());
    }
}
