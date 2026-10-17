package com.up366.mobile.common.logic.log.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BatchUploadLog {
    public static final int BATCH_ACTIVITY = 2;
    public static final int BATCH_DAILY = 9;
    public static final int BATCH_ERRORNOTE = 3;
    public static final int BATCH_FEEDBACK = 7;
    public static final int BATCH_HOMEWORK = 0;
    public static final int BATCH_JS_UPLOAD = 10;
    public static final int BATCH_JS_UPLOAD_APP_LOG = 25;
    public static final int BATCH_JS_UPLOAD_APP_LOG_V9 = 27;
    public static final int BATCH_JS_UPLOAD_COMMON_V8 = 26;
    public static final int BATCH_JS_UPLOAD_COMMON_V9 = 28;
    public static final int BATCH_PULL_LOG = 23;
    public static final int BATCH_QUESTION_PUBLISH = 4;
    public static final int BATCH_QUESTION_REPLAY = 5;
    public static final int BATCH_TAKE_PHOTO = 24;
    public static final int BATCH_TASK = 1;
    public static final int BATCH_UPLOAD_COMMON = 6;
    public static final int BATCH_UPLOAD_USER_ORAL = 21;
    public static final int BATCH_UPLOAD_WRONG_WORDS = 8;
    public static final int BATCH_USER_ORAL_FEEDBACK = 22;
    public static final int STATE_FAILED = -1;
    public static final int STATE_RUNNING = 1;
    public static final int STATE_SUCCESS = 2;
    public static final int STATE_WAIT = 0;
    private long addTime;
    private java.lang.String batchId;
    private int errCode;
    private java.lang.String errHistory;
    private java.lang.String errInfo;
    private java.lang.String opLogId;
    private java.lang.String params;
    private int priority;
    private java.lang.String refKey;
    private java.lang.Long rowId;
    private int state;
    private java.lang.String studyTaskId;
    private int taskCount;
    private java.lang.String taskId;
    private transient java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadItem> tasks;
    private long totalFileSize;
    private int tryCount;
    private int type;
    private long updateTime;
    private long uploadFileSize;
    private int uploadTaskCount;

    public BatchUploadLog() {
        this.type = -1;
        this.tasks = new java.util.ArrayList();
    }

    public BatchUploadLog(int i, java.lang.String str) {
        this(i, str, 0);
    }

    public BatchUploadLog(int i, java.lang.String str, int i2) {
        this.type = -1;
        this.tasks = new java.util.ArrayList();
        this.batchId = java.util.UUID.randomUUID().toString();
        this.opLogId = java.util.UUID.randomUUID().toString();
        this.type = i;
        this.refKey = str;
        this.priority = i2;
    }

    public BatchUploadLog(java.lang.Long l, java.lang.String str, java.lang.String str2, int i, int i2, long j, long j2, int i3, int i4, java.lang.String str3, java.lang.String str4, int i5, int i6, long j3, long j4, java.lang.String str5, int i7, java.lang.String str6, java.lang.String str7, java.lang.String str8) {
        this.type = -1;
        this.tasks = new java.util.ArrayList();
        this.rowId = l;
        this.batchId = str;
        this.refKey = str2;
        this.type = i;
        this.state = i2;
        this.addTime = j;
        this.updateTime = j2;
        this.tryCount = i3;
        this.errCode = i4;
        this.errInfo = str3;
        this.errHistory = str4;
        this.taskCount = i5;
        this.uploadTaskCount = i6;
        this.totalFileSize = j3;
        this.uploadFileSize = j4;
        this.params = str5;
        this.priority = i7;
        this.taskId = str6;
        this.studyTaskId = str7;
        this.opLogId = str8;
    }

    public void addTask(com.up366.common.http.RequestParams<?> requestParams) {
        addTask(new com.up366.mobile.common.logic.log.model.BatchUploadItem(requestParams));
    }

    public void addWav(java.io.File file, java.lang.String str) {
        java.io.File file2;
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            throw new java.lang.IllegalStateException("objectId 不可为空");
        }
        java.lang.String path = file.getPath();
        if (com.up366.common.StringUtils.isEmptyOrNull(path) || path.length() <= 4 || !path.regionMatches(true, path.length() - 4, com.up366.medialibrary.common.utils.MimeTypeUtils.WAV, 0, 4)) {
            file2 = null;
        } else {
            file2 = new java.io.File(path.substring(0, path.length() - 4) + com.up366.medialibrary.common.utils.MimeTypeUtils.MP3);
        }
        boolean z = file2 != null && file2.exists() && file2.length() > 0;
        com.up366.common.log.Logger.info("TAG - BatchUploadLog - addWav  by base mp3 ?   : " + z);
        if (z) {
            addTask(new com.up366.mobile.common.logic.log.model.BatchUploadItem(file2, false, str));
        } else {
            addTask(new com.up366.mobile.common.logic.log.model.BatchUploadItem(file, true, str));
        }
    }

    public void addAsesJSONFile(java.io.File file, java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            throw new java.lang.IllegalStateException("objectId 不可为空");
        }
        addTask(new com.up366.mobile.common.logic.log.model.BatchUploadItem(file, 3, str));
    }

    public void addFile(java.io.File file, java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            throw new java.lang.IllegalStateException("objectId 不可为空");
        }
        addTask(new com.up366.mobile.common.logic.log.model.BatchUploadItem(file, false, str));
    }

    public void addTask(com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem) {
        batchUploadItem.setBatchId(this.batchId);
        this.tasks.add(batchUploadItem);
        this.taskCount++;
        this.totalFileSize += batchUploadItem.getSize();
    }

    public int getPercent() {
        initUploadFileSize();
        long j = this.totalFileSize;
        if (j == 0) {
            return 0;
        }
        return (int) ((this.uploadFileSize * 100) / j);
    }

    public void initUploadFileSize() {
        if (this.tasks.size() != 0) {
            long size = 0;
            int i = 0;
            long uploadSize = 0;
            for (com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem : this.tasks) {
                size += batchUploadItem.getSize();
                uploadSize += batchUploadItem.getUploadSize();
                if (batchUploadItem.getState() == 2) {
                    i++;
                }
            }
            this.totalFileSize = size;
            this.uploadFileSize = uploadSize;
            this.uploadTaskCount = i;
        }
    }

    public void copyFiles() throws java.lang.Throwable {
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getUserRootPath(), "uploadFiles");
        com.up366.common.FileUtilsUp.mkdirParentDir(com.up366.common.FileUtilsUp.join(strJoin, "filename"));
        java.lang.String str = java.lang.System.currentTimeMillis() + "_" + this.tasks.hashCode() + "_";
        com.up366.common.log.Logger.info("TAG - BatchUploadLog - copyFiles - prefix : " + str + " task size : " + this.tasks.size());
        int i = 0;
        for (com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem : this.tasks) {
            if (batchUploadItem.getType() != 0) {
                java.io.File file = new java.io.File(batchUploadItem.getPath());
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(str);
                int i2 = i + 1;
                sb.append(i);
                java.io.File file2 = new java.io.File(com.up366.common.FileUtilsUp.join(strJoin, sb.toString()));
                if (!file.exists()) {
                    com.up366.common.log.Logger.error("BatchUploadLog - copyFiles - error src.exists() == false");
                    com.up366.mobile.common.onlinelog.OpLog.report("BatchUploadLog-copyFiles-src-not-exists", "copy file error: " + batchUploadItem.toString());
                } else if (file.length() == 0) {
                    com.up366.common.log.Logger.error("BatchUploadLog - copyFiles - error src.length() == 0");
                    com.up366.mobile.common.onlinelog.OpLog.report("BatchUploadLog-copyFiles-src-length-is-0", "copy file error: " + batchUploadItem.toString());
                } else {
                    com.up366.common.FileUtilsUp.copyFileOrDir(file, file2);
                    batchUploadItem.setPath(file2.getPath());
                    com.up366.common.log.Logger.info("TAG - BatchUploadLog - " + batchUploadItem.getPath());
                    if (!file2.exists()) {
                        com.up366.common.log.Logger.error("BatchUploadLog - copyFiles - error target.exists() == false");
                        com.up366.mobile.common.onlinelog.OpLog.report("BatchUploadLog-copyFiles-not-exists", "copy file error: " + batchUploadItem.toString());
                    } else if (file2.length() == 0) {
                        com.up366.common.log.Logger.error("BatchUploadLog - copyFiles - error target.length() == 0");
                        com.up366.mobile.common.onlinelog.OpLog.report("BatchUploadLog-copyFiles-length-is-0", "copy file error: " + batchUploadItem.toString());
                    }
                    if (batchUploadItem.getType() == 3) {
                        com.up366.common.FileUtilsUp.deleteDirOrFile(file);
                    }
                }
                i = i2;
            }
        }
    }

    public void cleanFiles() {
        com.up366.common.log.Logger.info("TAG - BatchUploadLog - cleanFiles - tasks.size : " + this.tasks.size());
        for (com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem : this.tasks) {
            if (batchUploadItem.getType() != 0) {
                if (batchUploadItem.getType() == 1) {
                    java.lang.String str = batchUploadItem.getPath() + com.up366.medialibrary.common.utils.MimeTypeUtils.MP3;
                    com.up366.common.FileUtilsUp.deleteDirOrFile(batchUploadItem.getPath());
                    com.up366.common.FileUtilsUp.deleteDirOrFile(str);
                }
                if (batchUploadItem.getType() == 2) {
                    com.up366.common.FileUtilsUp.deleteDirOrFile(batchUploadItem.getPath());
                }
                if (batchUploadItem.getType() == 3) {
                    com.up366.common.FileUtilsUp.deleteDirOrFile(batchUploadItem.getPath());
                }
            }
        }
        com.up366.common.log.Logger.info("TAG - BatchUploadLog - cleanFiles - success.");
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }

    public java.lang.String getBatchId() {
        return this.batchId;
    }

    public java.lang.String getStudyTaskId() {
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.studyTaskId)) {
            return this.studyTaskId;
        }
        if (this.batchId.contains(";")) {
            return this.batchId.split(";")[0];
        }
        return null;
    }

    public void setBatchId(java.lang.String str) {
        this.batchId = str;
    }

    public java.lang.String getRefKey() {
        return this.refKey;
    }

    public void setRefKey(java.lang.String str) {
        this.refKey = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public void setAddTime(long j) {
        this.addTime = j;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public void setTryCount(int i) {
        this.tryCount = i;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public void setErrCode(int i) {
        this.errCode = i;
    }

    public java.lang.String getErrInfo() {
        return this.errInfo;
    }

    public void setErrInfo(java.lang.String str) {
        this.errInfo = str;
    }

    public java.lang.String getErrHistory() {
        return this.errHistory;
    }

    public void setErrHistory(java.lang.String str) {
        this.errHistory = str;
    }

    public int getTaskCount() {
        return this.taskCount;
    }

    public void setTaskCount(int i) {
        this.taskCount = i;
    }

    public int getUploadTaskCount() {
        return this.uploadTaskCount;
    }

    public void setUploadTaskCount(int i) {
        this.uploadTaskCount = i;
    }

    public long getTotalFileSize() {
        initUploadFileSize();
        return this.totalFileSize;
    }

    public void setTotalFileSize(long j) {
        this.totalFileSize = j;
    }

    public long getUploadFileSize() {
        initUploadFileSize();
        return this.uploadFileSize;
    }

    public void setUploadFileSize(long j) {
        this.uploadFileSize = j;
    }

    public java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadItem> getTasks() {
        return this.tasks;
    }

    public void setTasks(java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadItem> list) {
        this.tasks = list;
    }

    public java.lang.String getParams() {
        return this.params;
    }

    public void setParams(java.lang.String str) {
        this.params = str;
    }

    public java.lang.String toString() {
        return "BatchUploadLog{rowId=" + this.rowId + ", batchId='" + this.batchId + "', refKey='" + this.refKey + "', type=" + this.type + ", state=" + this.state + ", addTime=" + this.addTime + ", updateTime=" + this.updateTime + ", tryCount=" + this.tryCount + ", errCode=" + this.errCode + ", errInfo='" + this.errInfo + "', errHistory='" + this.errHistory + "', taskCount=" + this.taskCount + ", uploadTaskCount=" + this.uploadTaskCount + ", totalFileSize=" + this.totalFileSize + ", uploadFileSize=" + this.uploadFileSize + ", params='" + this.params + "', tasks=" + this.tasks + '}';
    }

    public java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadItem> getWaitUploadFileTasks(com.up366.greendao.DaoSession daoSession) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.HashSet hashSet = new java.util.HashSet();
        for (com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem : this.tasks) {
            if (batchUploadItem.getType() != 0 && batchUploadItem.getState() != 2) {
                if (hashSet.contains(batchUploadItem.getObjectId())) {
                    batchUploadItem.setUploadSize(batchUploadItem.getSize());
                    batchUploadItem.setState(2);
                    daoSession.getBatchUploadItemDao().update(batchUploadItem);
                    com.up366.common.log.Logger.info("TAG - BatchUploadLog - getWaitUploadFileTasks - skip upload item : " + batchUploadItem.getObjectId() + " id:" + batchUploadItem.getId());
                } else {
                    hashSet.add(batchUploadItem.getObjectId());
                    arrayList.add(batchUploadItem);
                }
            }
        }
        return arrayList;
    }

    public java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadItem> getUploadingTasks() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem : this.tasks) {
            if (batchUploadItem.getState() == 1) {
                arrayList.add(batchUploadItem);
            }
        }
        return arrayList;
    }

    public java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadItem> getWaitUploadTasks() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem : this.tasks) {
            if (batchUploadItem.getState() == 0) {
                arrayList.add(batchUploadItem);
            }
        }
        return arrayList;
    }

    public void addTryCount() {
        this.tryCount++;
    }

    public void updateHistory() {
        this.errHistory = "code:" + this.errCode + " info:" + this.errInfo + "\n" + this.errHistory;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }

    public void setStudyTaskId(java.lang.String str) {
        this.studyTaskId = str;
    }

    public java.lang.String getOpLogId() {
        return this.opLogId;
    }

    public void setOpLogId(java.lang.String str) {
        this.opLogId = str;
    }
}
