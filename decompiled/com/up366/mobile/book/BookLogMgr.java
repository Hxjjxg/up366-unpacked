package com.up366.mobile.book;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookLogMgr {
    private com.up366.mobile.book.helper.DataHelper dataHelper = new com.up366.mobile.book.helper.DataHelper();
    private final com.up366.greendao.DaoSession db;
    private final com.up366.mobile.common.logic.Manager manager;

    public BookLogMgr(com.up366.mobile.common.logic.Manager manager) {
        this.manager = manager;
        this.db = manager.db();
    }

    public void addBookTaskLog(com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2) {
        updateTaskScoreFinished(bookTaskLogV2);
        addSubmitTaskToQueue(bookTaskLogV2, bookTaskLogV2.getTaskId());
        saveToStudyTaskHistory(bookTaskLogV2);
        com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent(bookTaskLogV2.getTaskId(), bookTaskLogV2.getStudyTaskId());
    }

    public void addTaskLog(java.lang.String str, com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2) throws java.lang.Throwable {
        addSubmitTaskToQueue(bookTaskLogV2, str);
        saveToStudyTaskHistory(bookTaskLogV2);
        com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent(bookTaskLogV2.getTaskId(), bookTaskLogV2.getStudyTaskId());
    }

    public void addPersonalPracticeLog(com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2) throws java.lang.Throwable {
        addSubmitTaskToQueue(bookTaskLogV2, bookTaskLogV2.getGuid());
    }

    public void saveToStudyTaskHistory(final com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.BookLogMgr$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$saveToStudyTaskHistory$0(bookTaskLogV2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveToStudyTaskHistory$0(com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2) throws java.lang.Exception {
        this.db.getStudyTaskHistoryDao().insert(new com.up366.mobile.book.model.StudyTaskHistory(bookTaskLogV2));
    }

    public void saveToStudyTaskHistory(final com.up366.mobile.book.model.StudyTaskHistory studyTaskHistory) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.BookLogMgr$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$saveToStudyTaskHistory$1(studyTaskHistory);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveToStudyTaskHistory$1(com.up366.mobile.book.model.StudyTaskHistory studyTaskHistory) throws java.lang.Exception {
        this.db.getStudyTaskHistoryDao().insert(studyTaskHistory);
    }

    private void addSubmitTaskToQueue(final com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2, java.lang.String str) throws java.lang.Throwable {
        com.up366.common.http.RequestParams<?> requestParams;
        com.up366.mobile.common.onlinelog.OpLog.report("task提交", "jobId:" + bookTaskLogV2.getStudyTaskId() + ", taskId:" + bookTaskLogV2.getTaskId() + ", score:" + bookTaskLogV2.getScore() + ", submitType:" + bookTaskLogV2.getSubmitType());
        com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(1, str);
        batchUploadLog.setTaskId(bookTaskLogV2.getTaskId());
        batchUploadLog.setStudyTaskId(bookTaskLogV2.getStudyTaskId());
        java.lang.String studyTaskId = bookTaskLogV2.getStudyTaskId();
        if (!android.text.TextUtils.isEmpty(studyTaskId)) {
            batchUploadLog.setBatchId(studyTaskId + ";" + batchUploadLog.getBatchId());
        }
        java.lang.String fileUrls = bookTaskLogV2.getFileUrls();
        if (!com.up366.common.StringUtils.isEmptyOrNull(fileUrls)) {
            java.lang.String[] strArrSplit = fileUrls.split(";");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.String str2 : strArrSplit) {
                if (!com.up366.common.StringUtils.isEmptyOrNull(str2) && !arrayList.contains(str2)) {
                    arrayList.add(str2);
                    com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoLoadSync = this.manager.fileMgr().loadSync(str2, null);
                    if (fileMapInfoLoadSync == null) {
                        com.up366.common.log.Logger.error("TAG - BookLogMgr - addSubmitTaskToQueue - not find local file : " + str2);
                    } else if (isRecordWavPath(fileMapInfoLoadSync.getPath())) {
                        addRecordBatchUploadFile(batchUploadLog, fileMapInfoLoadSync);
                    } else {
                        addBatchUploadFile(batchUploadLog, fileMapInfoLoadSync);
                    }
                }
            }
        }
        final java.lang.String str3 = "[" + bookTaskLogV2.getAnswers() + "]";
        final java.lang.String utV2 = com.up366.common.StringUtils.getUtV2(str3, "submitTaskToken");
        if (str3.length() > 2048) {
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("tasksJson", str3);
            jSONObject.put("ut", utV2);
            jSONObject.put("submitType", java.lang.Integer.valueOf(bookTaskLogV2.getSubmitType()));
            final java.lang.String string = jSONObject.toString();
            requestParams = new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.addTasksScoresGzip) { // from class: com.up366.mobile.book.BookLogMgr.1
                @Override // com.up366.common.http.RequestParams
                public void initHeaders(java.util.Map<java.lang.String, java.lang.Object> map) {
                    super.initHeaders(map);
                    map.put("Content-Type", "application/json;charset=UTF-8");
                    map.put("Content-Encoding", "gzip");
                    map.put("___gzip_content___", string);
                }
            };
        } else {
            requestParams = new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.addTasksScores) { // from class: com.up366.mobile.book.BookLogMgr.2
                @Override // com.up366.common.http.RequestParams
                public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                    super.initParams(map);
                    map.put("tasksJson", str3);
                    map.put("ut", utV2);
                    map.put("submitType", java.lang.Integer.valueOf(bookTaskLogV2.getSubmitType()));
                }
            };
        }
        batchUploadLog.addTask(requestParams);
        if (com.up366.mobile.common.logic.Auth.isAuth()) {
            com.up366.mobile.book.oplog.StudyOpLogHelper.recordOpLog(batchUploadLog.getOpLogId(), bookTaskLogV2.getStudyTaskId(), bookTaskLogV2.getTaskId(), bookTaskLogV2.getBookId());
            this.manager.logMgr().addToBatchQueue(batchUploadLog);
        } else {
            this.manager.logMgr().addToHistory(batchUploadLog);
        }
    }

    public void addBatchUploadFile(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        if (batchUploadLog == null || fileMapInfo == null) {
            return;
        }
        java.lang.String path = fileMapInfo.getPath();
        java.lang.String objectId = fileMapInfo.getObjectId();
        if (com.up366.common.StringUtils.isEmptyOrNull(path) || com.up366.common.StringUtils.isEmptyOrNull(objectId)) {
            com.up366.common.log.Logger.error("TAG - BookLogMgr - addBatchUploadFile - invalid file info : " + fileMapInfo);
        } else if (isRecordWavPath(path)) {
            batchUploadLog.addWav(new java.io.File(path), objectId);
        } else {
            batchUploadLog.addFile(new java.io.File(path), objectId);
        }
    }

    public void addRecordBatchUploadFile(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) throws java.lang.Throwable {
        if (batchUploadLog == null || fileMapInfo == null) {
            return;
        }
        addBatchUploadFile(batchUploadLog, fileMapInfo);
        java.lang.String path = fileMapInfo.getPath();
        java.lang.String objectId = fileMapInfo.getObjectId();
        if (com.up366.common.StringUtils.isEmptyOrNull(path) || com.up366.common.StringUtils.isEmptyOrNull(objectId) || !isRecordAudioPath(path)) {
            return;
        }
        java.lang.String str = objectId + ".json";
        java.io.File fileFindRecordJSONFile = findRecordJSONFile(objectId, str);
        if (fileFindRecordJSONFile != null) {
            batchUploadLog.addAsesJSONFile(fileFindRecordJSONFile, str);
        }
        addRecordOpusFile(batchUploadLog, path, objectId);
    }

    private void addRecordOpusFile(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, java.lang.String str, java.lang.String str2) {
        java.lang.String strBuildSiblingPath = buildSiblingPath(str, ".ogg");
        if (com.up366.common.FileUtilsUp.isFileExists(strBuildSiblingPath)) {
            java.lang.String strBuildSiblingPath2 = buildSiblingPath(str2, ".ogg");
            try {
                if (this.manager.fileMgr().saveSync(strBuildSiblingPath, ".ogg", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, strBuildSiblingPath2) != null) {
                    batchUploadLog.addFile(new java.io.File(strBuildSiblingPath), strBuildSiblingPath2);
                }
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.info("TAG - BookLogMgr - addRecordOpusFile - " + e.getMessage());
            }
        }
    }

    private boolean isRecordWavPath(java.lang.String str) {
        return !com.up366.common.StringUtils.isEmptyOrNull(str) && str.toLowerCase().endsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.WAV);
    }

    private boolean isRecordAudioPath(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return false;
        }
        java.lang.String lowerCase = str.toLowerCase();
        return lowerCase.endsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.WAV) || lowerCase.endsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.MP3);
    }

    private java.lang.String buildSiblingPath(java.lang.String str, java.lang.String str2) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return str;
        }
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf <= 0) {
            return str + str2;
        }
        return str.substring(0, iLastIndexOf) + str2;
    }

    public java.io.File findRecordJSONFile(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        try {
            com.up366.mobile.book.helper.recorder.RecordResultHistory recordResultHistory = (com.up366.mobile.book.helper.recorder.RecordResultHistory) this.manager.db1().findOne(com.up366.mobile.book.helper.recorder.RecordResultHistory_.objectId, str);
            if (recordResultHistory == null) {
                return null;
            }
            java.lang.String str3 = new java.lang.String(com.up366.common.ZipStringUtils.gunzip(recordResultHistory.buffer));
            if (android.text.TextUtils.isEmpty(str3)) {
                return null;
            }
            java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getAppInternalCacheDir(), com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() + "_" + com.up366.common.digest.MD5.md5(str3));
            com.up366.common.FileUtilsUp.saveContentToFile(strJoin, str3);
            if (com.up366.common.FileUtilsUp.isFileExists(strJoin) && this.manager.fileMgr().saveSync(strJoin, ".json", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, str2) != null) {
                return new java.io.File(strJoin);
            }
        } catch (java.lang.Exception unused) {
            com.up366.common.log.Logger.info("TAG - BookLogMgr - findRecordJSONFile - ");
        }
        return null;
    }

    private void updateTaskScoreFinished(com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2) {
        com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo = (com.up366.mobile.book.model.BookTaskFinishedInfo) this.db.getBookTaskFinishedInfoDao().queryBuilder().where(com.up366.greendao.BookTaskFinishedInfoDao.Properties.TaskId.eq(bookTaskLogV2.getTaskId()), new org.greenrobot.greendao.query.WhereCondition[0]).unique();
        if (bookTaskFinishedInfo == null) {
            bookTaskFinishedInfo = new com.up366.mobile.book.model.BookTaskFinishedInfo();
            bookTaskFinishedInfo.setTaskId(bookTaskLogV2.getTaskId());
            bookTaskFinishedInfo.setUid(com.up366.mobile.common.logic.Auth.UID());
            bookTaskFinishedInfo.setAddDate(bookTaskLogV2.getAddTime());
            bookTaskFinishedInfo.setBookId(bookTaskLogV2.getBookId());
        }
        bookTaskFinishedInfo.setScore(bookTaskLogV2.getScore());
        bookTaskFinishedInfo.setStudyDate(bookTaskLogV2.getStudyDate());
        bookTaskFinishedInfo.setPercent(bookTaskLogV2.getPercent());
        this.db.insertOrReplace(bookTaskFinishedInfo);
    }

    public java.lang.String getStudyInfo(java.lang.String str) {
        com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo = this.manager.bookProgress().get(str);
        if (bookScheduleInfo.getLastStudyTime() == 0) {
            return "无";
        }
        return com.up366.common.TimeUtils.formatTime(bookScheduleInfo.getLastStudyTime(), "yyyy-MM-dd HH:mm");
    }
}
