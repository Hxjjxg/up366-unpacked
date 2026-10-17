package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V9ResourceHelper {
    public static final java.lang.String DIR_ALL_QUESTIONS = "allQuestions";
    public static final java.lang.String DIR_BOOKS = "books";
    public static final java.lang.String DIR_CHAPTERS = "chapters";
    public static final java.lang.String DIR_EXTEND = "extend";
    public static final java.lang.String DIR_GLOBAL = "global";
    public static final java.lang.String DIR_QUESTIONS = "questions";
    private final java.util.Map<java.lang.String, android.database.sqlite.SQLiteDatabase> databaseMap = new java.util.HashMap();

    public com.up366.common.download.DownloadInfo fetchResourceDownloadInfoSync(java.lang.String str, java.lang.String str2) throws java.lang.InterruptedException {
        return fetchDownloadInfoByFileIdSync(getDownloadInfo(str, "name", str, str2), str);
    }

    public com.up366.common.download.DownloadInfo fetchResourceDownloadQuestionsInfoSync(java.lang.String str, java.lang.String str2) throws java.lang.InterruptedException {
        return fetchDownloadInfoByFileIdSync(getDownloadInfoQuestions(str, "name", str, str2), str);
    }

    public com.up366.common.download.DownloadInfo getDownloadInfo(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
        downloadInfo.setKey(str);
        downloadInfo.setFilePath(filePath(str, str4));
        downloadInfo.setNeedUnzip(true);
        downloadInfo.setName(str2);
        downloadInfo.setDownType(26);
        downloadInfo.setNeedCheck(true);
        downloadInfo.setFileVersion(java.lang.String.valueOf(str3));
        downloadInfo.setDownloadUrl("?");
        downloadInfo.setFileMD5("?");
        downloadInfo.setFileSize(-1L);
        downloadInfo.setState(1);
        return downloadInfo;
    }

    public com.up366.common.download.DownloadInfo getDownloadInfoQuestions(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
        downloadInfo.setKey(str);
        downloadInfo.setFilePath(filePath(str, str4));
        downloadInfo.setNeedUnzip(true);
        downloadInfo.setName(str2);
        downloadInfo.setDownType(27);
        downloadInfo.setNeedCheck(true);
        downloadInfo.setFileVersion(java.lang.String.valueOf(str3));
        downloadInfo.setDownloadUrl("?");
        downloadInfo.setFileMD5("?");
        downloadInfo.setFileSize(-1L);
        downloadInfo.setState(1);
        return downloadInfo;
    }

    private java.lang.String filePath(java.lang.String str, java.lang.String str2) {
        com.up366.mobile.book.helper.V9FilePathHelper v9FilePathHelper = new com.up366.mobile.book.helper.V9FilePathHelper();
        if (str2.equals(DIR_GLOBAL)) {
            return com.up366.common.FileUtilsUp.join(com.up366.mobile.book.helper.V9FilePathHelper.getGlobalPath(), str, "/");
        }
        if (str2.equals(DIR_BOOKS)) {
            return com.up366.common.FileUtilsUp.join(v9FilePathHelper.getBooksPath(), str, "/");
        }
        if (str2.equals(DIR_CHAPTERS)) {
            return com.up366.common.FileUtilsUp.join(v9FilePathHelper.getChaptersPath(), str, "/");
        }
        if (str2.equals(DIR_QUESTIONS)) {
            return com.up366.common.FileUtilsUp.join(com.up366.mobile.book.helper.V9FilePathHelper.getQuestionsPath(), str, "/");
        }
        if (str2.equals(DIR_EXTEND)) {
            return com.up366.common.FileUtilsUp.join(v9FilePathHelper.getExtendPath(), str, "/");
        }
        if (str2.equals(DIR_ALL_QUESTIONS)) {
            return com.up366.mobile.book.helper.V9FilePathHelper.getQuestionsPath();
        }
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.book.helper.V9FilePathHelper.getV9RootResourceDir(), str, "/");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.up366.common.download.DownloadInfo fetchDownloadInfoByFileIdSync(final com.up366.common.download.DownloadInfo downloadInfo, java.lang.String str) throws java.lang.InterruptedException {
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final com.up366.common.http.NetHolder netHolder = new com.up366.common.http.NetHolder();
        com.up366.mobile.common.logic.Auth.cur().book().fetchFileInfo(str, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.book.helper.V9ResourceHelper$$ExternalSyntheticLambda5
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.mobile.book.helper.V9ResourceHelper.lambda$fetchDownloadInfoByFileIdSync$0(netHolder, downloadInfo, countDownLatch, response, (com.up366.mobile.book.model.FileInfo) obj);
            }
        });
        countDownLatch.await();
        return (com.up366.common.download.DownloadInfo) netHolder.info;
    }

    static /* synthetic */ void lambda$fetchDownloadInfoByFileIdSync$0(com.up366.common.http.NetHolder netHolder, com.up366.common.download.DownloadInfo downloadInfo, java.util.concurrent.CountDownLatch countDownLatch, com.up366.common.http.Response response, com.up366.mobile.book.model.FileInfo fileInfo) {
        if (response.isError()) {
            com.up366.common.log.Logger.error("TAG - ContentDownloadHelper - fetchDownloadInfoByFileIdSync - error : " + response);
            netHolder.initWith(response, null);
        } else {
            downloadInfo.setDownloadUrl(fileInfo.getDownloadUrl());
            downloadInfo.setFileMD5(fileInfo.getFileMd5());
            downloadInfo.setFileSize(fileInfo.getFileSize());
            com.up366.mobile.book.helper.DownloadExtHelper.apply(downloadInfo, fileInfo);
            netHolder.initWith(response, downloadInfo);
        }
        countDownLatch.countDown();
    }

    public java.util.List<com.up366.common.download.DownloadInfo> fetchDownloadInfoByFileIdBatchSync(java.lang.String str, final java.lang.String str2) throws java.lang.InterruptedException {
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final com.up366.common.http.NetHolder netHolder = new com.up366.common.http.NetHolder();
        com.up366.mobile.common.logic.Auth.cur().book().fetchFileInfoBatch(str, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.book.helper.V9ResourceHelper$$ExternalSyntheticLambda4
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$fetchDownloadInfoByFileIdBatchSync$1(netHolder, str2, countDownLatch, response, (java.util.List) obj);
            }
        });
        countDownLatch.await();
        return (java.util.List) netHolder.info;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchDownloadInfoByFileIdBatchSync$1(com.up366.common.http.NetHolder netHolder, java.lang.String str, java.util.concurrent.CountDownLatch countDownLatch, com.up366.common.http.Response response, java.util.List list) {
        if (response.isError()) {
            com.up366.common.log.Logger.error("TAG - ContentDownloadHelper - fetchDownloadInfoByFileIdBatchSync - error : " + response);
            netHolder.initWith(response, null);
        } else {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                com.up366.mobile.book.model.FileInfo fileInfo = (com.up366.mobile.book.model.FileInfo) it.next();
                com.up366.common.download.DownloadInfo downloadInfo = getDownloadInfo(fileInfo.getFileId(), "name", fileInfo.getFileId(), str);
                downloadInfo.setDownloadUrl(fileInfo.getDownloadUrl());
                downloadInfo.setFileMD5(fileInfo.getFileMd5());
                downloadInfo.setFileSize(fileInfo.getFileSize());
                com.up366.mobile.book.helper.DownloadExtHelper.apply(downloadInfo, fileInfo);
                arrayList.add(downloadInfo);
            }
            netHolder.initWith(response, arrayList);
        }
        countDownLatch.countDown();
    }

    public boolean checkResource(java.lang.String str, java.lang.String str2) {
        java.lang.String strJoin;
        com.up366.mobile.book.helper.V9FilePathHelper v9FilePathHelper = new com.up366.mobile.book.helper.V9FilePathHelper();
        if (str2.equals(DIR_GLOBAL)) {
            strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.book.helper.V9FilePathHelper.getGlobalPath(), str, "/");
        } else if (str2.equals(DIR_BOOKS)) {
            strJoin = com.up366.common.FileUtilsUp.join(v9FilePathHelper.getBooksPath(), str, "/");
        } else if (str2.equals(DIR_CHAPTERS)) {
            strJoin = com.up366.common.FileUtilsUp.join(v9FilePathHelper.getChaptersPath(), str, "/");
        } else if (str2.equals(DIR_QUESTIONS)) {
            strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.book.helper.V9FilePathHelper.getQuestionsPath(), str, "/");
        } else if (!str2.equals(DIR_EXTEND)) {
            strJoin = "";
        } else {
            strJoin = com.up366.common.FileUtilsUp.join(v9FilePathHelper.getExtendPath(), str, "/");
        }
        return com.up366.common.FileUtilsUp.isCheckFileExists(strJoin);
    }

    public boolean checkValid(java.lang.String str, java.lang.String str2) {
        java.lang.String strJoin;
        com.up366.mobile.book.helper.V9FilePathHelper v9FilePathHelper = new com.up366.mobile.book.helper.V9FilePathHelper();
        if (str2.equals(DIR_GLOBAL)) {
            strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.book.helper.V9FilePathHelper.getGlobalPath(), str, "/");
        } else if (str2.equals(DIR_BOOKS)) {
            strJoin = com.up366.common.FileUtilsUp.join(v9FilePathHelper.getBooksPath(), str, "/");
        } else if (str2.equals(DIR_CHAPTERS)) {
            strJoin = com.up366.common.FileUtilsUp.join(v9FilePathHelper.getChaptersPath(), str, "/");
        } else if (str2.equals(DIR_QUESTIONS)) {
            strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.book.helper.V9FilePathHelper.getQuestionsPath(), str, "/");
        } else if (!str2.equals(DIR_EXTEND)) {
            strJoin = "";
        } else {
            strJoin = com.up366.common.FileUtilsUp.join(v9FilePathHelper.getExtendPath(), str, "/");
        }
        boolean zValidSync = validSync(strJoin);
        if (!zValidSync) {
            com.up366.common.log.Logger.error("TAG - V9ResourceHelper - checkValid - false! resourceDir:" + strJoin);
            com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin);
        }
        return zValidSync;
    }

    private boolean validSync(java.lang.String str) {
        return com.up366.common.utils.EncryptUtil.valid(str);
    }

    public void searchDB(final java.lang.String str, final java.lang.String str2, final com.up366.common.callback.ICallbackCodeInfoObj<com.alibaba.fastjson.JSONArray> iCallbackCodeInfoObj) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V9ResourceHelper$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$searchDB$5(str, iCallbackCodeInfoObj, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchDB$5(java.lang.String str, final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, java.lang.String str2) throws java.lang.Exception {
        android.database.sqlite.SQLiteDatabase dbInstance = getDbInstance(str);
        if (dbInstance == null) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V9ResourceHelper$$ExternalSyntheticLambda0
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
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V9ResourceHelper$$ExternalSyntheticLambda1
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        iCallbackCodeInfoObj.onResult(0, "success", jSONArray);
                    }
                });
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("TAG - V9ResourceHelper - searchDB - error : ", e);
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V9ResourceHelper$$ExternalSyntheticLambda2
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
        com.up366.common.log.Logger.warn("TAG - V9ResourceHelper - getValue - unknown type : " + i2);
        return null;
    }

    private android.database.sqlite.SQLiteDatabase getDbInstance(java.lang.String str) throws java.lang.Throwable {
        try {
            android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.databaseMap.get(str);
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                return sQLiteDatabase;
            }
            if (!com.up366.common.FileUtilsUp.isFileExists(str)) {
                com.up366.common.log.Logger.error("TAG - V9ResourceHelper - getDbInstance - db文件不存在 : " + str);
                return null;
            }
            java.lang.String str2 = str + "_tmp";
            com.up366.common.FileUtilsUp.deleteDirOrFile(str2);
            com.up366.common.FileUtilsUp.copyFileOrDir(str, str2);
            android.database.sqlite.SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = com.up366.common.global.GB.get().getApplicationContext().openOrCreateDatabase(str2, 0, null);
            if (sQLiteDatabaseOpenOrCreateDatabase != null) {
                this.databaseMap.put(str, sQLiteDatabaseOpenOrCreateDatabase);
            }
            return sQLiteDatabaseOpenOrCreateDatabase;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - V9ResourceHelper - getDbInstance - error : ", e);
            return null;
        }
    }
}
