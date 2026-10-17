package com.up366.mobile.book.dict.js;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DictHelper {
    private final com.up366.mobile.book.StudyActivity context;
    private final com.up366.mobile.book.dict.DictDataHelper dataHelper;
    private java.util.Map<java.lang.String, android.database.sqlite.SQLiteDatabase> databaseMap = new java.util.HashMap();
    private final com.up366.mobile.book.dict.DictHtmlView dictHtmlView;

    public DictHelper(com.up366.mobile.book.dict.DictHtmlView dictHtmlView, com.up366.mobile.book.dict.DictDataHelper dictDataHelper, com.up366.mobile.book.StudyActivity studyActivity) {
        this.dictHtmlView = dictHtmlView;
        this.dataHelper = dictDataHelper;
        this.context = studyActivity;
    }

    public com.alibaba.fastjson.JSONObject getPageParams() {
        return this.dataHelper.dataHolder.exerciseData;
    }

    public java.lang.String getPageParamValue(java.lang.String str) {
        return this.dataHelper.dataHolder.exerciseData.getString(str);
    }

    public void launchXotEngine(java.lang.String str, java.lang.String str2, boolean z) {
        if (z) {
            android.content.Intent intent = new android.content.Intent((android.content.Context) this.context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
            intent.putExtra("exercise_type", str);
            intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, str2);
            this.context.startActivity(intent);
            return;
        }
        this.dataHelper.dataHolder.init(str, str2);
        this.dictHtmlView.refresh();
    }

    public java.lang.String getLoadingTitle() {
        return "天学词典";
    }

    public void searchDB(final java.lang.String str, final java.lang.String str2, final com.up366.common.callback.ICallbackCodeInfoObj<com.alibaba.fastjson.JSONArray> iCallbackCodeInfoObj) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.dict.js.DictHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$searchDB$3(str, iCallbackCodeInfoObj, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchDB$3(java.lang.String str, final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, java.lang.String str2) throws java.lang.Exception {
        android.database.sqlite.SQLiteDatabase dbInstance = getDbInstance(str);
        if (dbInstance == null) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.dict.js.DictHelper$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() {
                    iCallbackCodeInfoObj.onResult(-4, "db file open failed", null);
                }
            });
            return;
        }
        android.database.Cursor cursorRawQuery = null;
        try {
            try {
                final com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
                cursorRawQuery = dbInstance.rawQuery(str2, null);
                int columnCount = cursorRawQuery.getColumnCount();
                while (cursorRawQuery.moveToNext()) {
                    com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                    for (int i = 0; i < columnCount; i++) {
                        jSONObject.put(cursorRawQuery.getColumnName(i), getValue(cursorRawQuery, i, cursorRawQuery.getType(i)));
                    }
                    jSONArray.add(jSONObject);
                }
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.dict.js.DictHelper$$ExternalSyntheticLambda2
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        iCallbackCodeInfoObj.onResult(0, "success", jSONArray);
                    }
                });
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("TAG - DictHelper - searchDB - error : ", e);
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.dict.js.DictHelper$$ExternalSyntheticLambda3
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        iCallbackCodeInfoObj.onResult(-5, e.getMessage(), null);
                    }
                });
            }
        } finally {
            com.up366.mobile.common.utils.IOUtils.close(cursorRawQuery);
        }
    }

    private java.lang.Object getValue(android.database.Cursor cursor, int i, int i2) {
        if (i2 == 0) {
            return null;
        }
        if (i2 == 1) {
            return java.lang.Integer.valueOf(cursor.getInt(i));
        }
        if (i2 == 2) {
            return java.lang.Float.valueOf(cursor.getFloat(i));
        }
        if (i2 == 3) {
            return cursor.getString(i);
        }
        if (i2 == 4) {
            return cursor.getBlob(i);
        }
        com.up366.common.log.Logger.warn("TAG - DictHelper - getValue - unknown type : " + i2);
        return null;
    }

    private android.database.sqlite.SQLiteDatabase getDbInstance(java.lang.String str) throws java.lang.Throwable {
        try {
            android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.databaseMap.get(str);
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                return sQLiteDatabase;
            }
            java.lang.String dbPath = this.dataHelper.getDbPath(str);
            if (!com.up366.common.FileUtilsUp.isFileExists(dbPath)) {
                com.up366.common.log.Logger.error("TAG - DictHelper - getDbInstance - db文件不存在 : " + dbPath);
                return null;
            }
            java.lang.String str2 = dbPath + "_tmp";
            com.up366.common.FileUtilsUp.deleteDirOrFile(str2);
            com.up366.common.FileUtilsUp.copyFileOrDir(dbPath, str2);
            android.database.sqlite.SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = com.up366.common.global.GB.get().getApplicationContext().openOrCreateDatabase(str2, 0, null);
            if (sQLiteDatabaseOpenOrCreateDatabase != null) {
                this.databaseMap.put(str, sQLiteDatabaseOpenOrCreateDatabase);
            }
            return sQLiteDatabaseOpenOrCreateDatabase;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - DictHelper - getDbInstance - error : ", e);
            return null;
        }
    }

    public void closeDb() {
        try {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, android.database.sqlite.SQLiteDatabase>> it = this.databaseMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().close();
            }
            this.databaseMap.clear();
            this.databaseMap = null;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - DictHelper - closeDb - ", e);
        }
    }
}
