package com.up366.mobile.common.logic.log;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LogMgr {
    private final com.up366.greendao.DaoSession db;
    private final com.up366.common.task.TaskExecutor executor = com.up366.common.task.TaskUtils.createSerialExecutor("upload-queue");
    private java.lang.String lastBatchId;
    private java.lang.String lastUpdateKey;
    private long lastUpdateProgressTime;
    private long lastUserStartQueueTime;
    private final com.up366.mobile.common.logic.Manager manager;

    public LogMgr(com.up366.mobile.common.logic.Manager manager) {
        this.manager = manager;
        this.db = manager.db();
    }

    public java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadLog> getTaskList() {
        return this.db.getBatchUploadLogDao().loadAll();
    }

    public void getTasksNum(final int i, final com.up366.common.callback.ICallbackCodeInfoObj<java.lang.Integer> iCallbackCodeInfoObj) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.log.LogMgr$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getTasksNum$2(i, iCallbackCodeInfoObj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTasksNum$2(int i, final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj) throws java.lang.Exception {
        if (i < 0) {
            final long jCount = this.db.getBatchUploadLogDao().count();
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.log.LogMgr$$ExternalSyntheticLambda8
                @Override // com.up366.common.task.Task
                public final void run() {
                    iCallbackCodeInfoObj.onResult(0, "success", java.lang.Integer.valueOf((int) jCount));
                }
            });
        } else {
            final long jCount2 = this.db.getBatchUploadLogDao().queryBuilder().where(com.up366.greendao.BatchUploadLogDao.Properties.Type.eq(java.lang.Integer.valueOf(i)), new org.greenrobot.greendao.query.WhereCondition[0]).count();
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.log.LogMgr$$ExternalSyntheticLambda9
                @Override // com.up366.common.task.Task
                public final void run() {
                    iCallbackCodeInfoObj.onResult(0, "success", java.lang.Integer.valueOf((int) jCount2));
                }
            });
        }
    }

    public void addToBatchQueue(final com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.log.LogMgr$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$addToBatchQueue$4(batchUploadLog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addToBatchQueue$4(final com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog) throws java.lang.Exception {
        batchUploadLog.copyFiles();
        batchUploadLog.setAddTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        batchUploadLog.setUpdateTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        this.db.runInTx(new java.lang.Runnable() { // from class: com.up366.mobile.common.logic.log.LogMgr$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addToBatchQueue$3(batchUploadLog);
            }
        });
        addToHistory(batchUploadLog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addToBatchQueue$3(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog) {
        this.db.getBatchUploadLogDao().save(batchUploadLog);
        this.db.getBatchUploadItemDao().saveInTx(batchUploadLog.getTasks());
        startBatchQueue();
    }

    public void addToHistory(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog) {
        com.up366.mobile.book.model.BookTaskLogHistory bookTaskLogHistory = new com.up366.mobile.book.model.BookTaskLogHistory(batchUploadLog);
        this.db.insertOrReplace(bookTaskLogHistory);
        com.up366.mobile.common.utils.AppFileUtils.saveBinaryFileRecord(com.up366.mobile.common.utils.AppFileUtils.getAnswerBinPath(), bookTaskLogHistory.getLogData());
        com.up366.common.log.Logger.info("TAG - LogMgr - addToBatchQueue - add ok!");
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask = null;
        if (com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTaskCallback != null) {
            com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTaskCallback.run();
            com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTaskCallback = null;
        }
    }

    public void addToBatchQueueSync(final com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog) throws java.lang.Throwable {
        batchUploadLog.copyFiles();
        batchUploadLog.setAddTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        batchUploadLog.setUpdateTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        this.db.runInTx(new java.lang.Runnable() { // from class: com.up366.mobile.common.logic.log.LogMgr$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addToBatchQueueSync$5(batchUploadLog);
            }
        });
        addToHistorySync(batchUploadLog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addToBatchQueueSync$5(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog) {
        this.db.getBatchUploadLogDao().save(batchUploadLog);
        this.db.getBatchUploadItemDao().saveInTx(batchUploadLog.getTasks());
        startBatchQueue();
    }

    public void addToHistorySync(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog) {
        com.up366.mobile.book.model.BookTaskLogHistory bookTaskLogHistory = new com.up366.mobile.book.model.BookTaskLogHistory(batchUploadLog);
        this.db.insertOrReplace(bookTaskLogHistory);
        com.up366.mobile.common.utils.AppFileUtils.saveBinaryFileRecord(com.up366.mobile.common.utils.AppFileUtils.getAnswerBinPath(), bookTaskLogHistory.getLogData());
        com.up366.common.log.Logger.info("TAG - LogMgr - addToBatchQueue - add ok!");
    }

    public void decreaseTryCount() {
        java.util.List list = this.db.getBatchUploadLogDao().queryBuilder().where(com.up366.greendao.BatchUploadLogDao.Properties.TryCount.ge(100), new org.greenrobot.greendao.query.WhereCondition[0]).list();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            ((com.up366.mobile.common.logic.log.model.BatchUploadLog) it.next()).setTryCount(99);
        }
        this.db.getBatchUploadLogDao().updateInTx(list);
    }

    public void startBatchQueue() {
        this.lastUserStartQueueTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        startBatchQueueInner();
    }

    public void startBatchQueueInner() {
        this.executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.log.LogMgr$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() {
                this.f$0.doUploadSync();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUploadSync() {
        java.util.List list = this.db.getBatchUploadLogDao().queryBuilder().where(com.up366.greendao.BatchUploadLogDao.Properties.TryCount.le(100), new org.greenrobot.greendao.query.WhereCondition[]{com.up366.greendao.BatchUploadLogDao.Properties.UpdateTime.le(java.lang.Long.valueOf(this.lastUserStartQueueTime)), com.up366.greendao.BatchUploadLogDao.Properties.State.notEq(2)}).orderAsc(new org.greenrobot.greendao.Property[]{com.up366.greendao.BatchUploadLogDao.Properties.TryCount}).list();
        if (list.size() == 0) {
            com.up366.common.log.Logger.info("TAG - LogMgr - startBatchQueue - empty.");
            return;
        }
        java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.common.logic.log.LogMgr$$ExternalSyntheticLambda10
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return java.lang.Integer.compare(((com.up366.mobile.common.logic.log.model.BatchUploadLog) obj2).getPriority(), ((com.up366.mobile.common.logic.log.model.BatchUploadLog) obj).getPriority());
            }
        });
        com.up366.common.log.Logger.info("TAG - LogMgr - doUploadSync - begin log size:" + list.size());
        doUploadLogSync((com.up366.mobile.common.logic.log.model.BatchUploadLog) list.get(0));
        com.up366.common.log.Logger.info("TAG - LogMgr - doUploadSync - end");
        startBatchQueueInner();
    }

    public void testDoUploadSync(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog) {
        doUploadLogSync(batchUploadLog);
    }

    private void doUploadLogSync(final com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog) {
        java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadItem> batchUploadItems = getBatchUploadItems(this.db, batchUploadLog.getBatchId());
        batchUploadLog.setTasks(batchUploadItems);
        com.up366.common.log.Logger.info("TAG - LogMgr - doUploadLogSync - batchId:" + batchUploadLog.getBatchId() + " refKey:" + batchUploadLog.getRefKey() + " tasks size:" + batchUploadItems.size());
        for (com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem : batchUploadItems) {
            if (batchUploadItem.getState() == 1) {
                batchUploadItem.setState(0);
            }
            if (batchUploadItem.getState() == -1) {
                batchUploadItem.setState(0);
            }
        }
        batchUploadLog.addTryCount();
        batchUploadLog.setUpdateTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        batchUploadLog.setState(1);
        batchUploadLog.setErrCode(0);
        batchUploadLog.setErrInfo("");
        this.db.getBatchUploadLogDao().update(batchUploadLog);
        java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadItem> waitUploadFileTasks = batchUploadLog.getWaitUploadFileTasks(this.db);
        com.up366.common.log.Logger.info("TAG - LogMgr - doUploadLogSync - batchId:" + batchUploadLog.getBatchId() + " refKey:" + batchUploadLog.getRefKey() + " tasksFile size:" + batchUploadItems.size());
        java.util.List listStart = com.up366.mobile.common.logic.log.TaskMapRunner.create(waitUploadFileTasks, new int[]{4}).map(new com.up366.mobile.common.logic.log.TaskMapRunner.IMapRunner() { // from class: com.up366.mobile.common.logic.log.LogMgr$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.logic.log.TaskMapRunner.IMapRunner
            public final java.lang.Object run(com.up366.mobile.common.logic.log.TaskMapRunner.MapRunnerCtx mapRunnerCtx, java.lang.Object obj) {
                return this.f$0.lambda$doUploadLogSync$7(batchUploadLog, mapRunnerCtx, obj);
            }
        }).start();
        if (listStart.contains(false) || listStart.contains(null)) {
            updateUploadStatus(batchUploadLog);
            return;
        }
        java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadItem> waitUploadTasks = batchUploadLog.getWaitUploadTasks();
        com.up366.common.log.Logger.info("TAG - LogMgr - doUploadLogSync - batchId:" + batchUploadLog.getBatchId() + " refKey:" + batchUploadLog.getRefKey() + " tasksString size:" + batchUploadItems.size());
        java.util.List listStart2 = com.up366.mobile.common.logic.log.TaskMapRunner.create(waitUploadTasks, new int[]{4}).map(new com.up366.mobile.common.logic.log.TaskMapRunner.IMapRunner() { // from class: com.up366.mobile.common.logic.log.LogMgr$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.logic.log.TaskMapRunner.IMapRunner
            public final java.lang.Object run(com.up366.mobile.common.logic.log.TaskMapRunner.MapRunnerCtx mapRunnerCtx, java.lang.Object obj) {
                return this.f$0.lambda$doUploadLogSync$8(batchUploadLog, mapRunnerCtx, obj);
            }
        }).start();
        if (!listStart2.contains(false) && !listStart2.contains(null)) {
            batchUploadLog.cleanFiles();
            deleteTask(batchUploadLog.getBatchId());
        }
        updateUploadStatus(batchUploadLog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$doUploadLogSync$7(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, com.up366.mobile.common.logic.log.TaskMapRunner.MapRunnerCtx mapRunnerCtx, java.lang.Object obj) {
        boolean zUploadTaskItemSync = uploadTaskItemSync(batchUploadLog, (com.up366.mobile.common.logic.log.model.BatchUploadItem) obj);
        if (!zUploadTaskItemSync) {
            mapRunnerCtx.stop = true;
        }
        return java.lang.Boolean.valueOf(zUploadTaskItemSync);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$doUploadLogSync$8(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, com.up366.mobile.common.logic.log.TaskMapRunner.MapRunnerCtx mapRunnerCtx, java.lang.Object obj) {
        boolean zUploadTaskItemSync = uploadTaskItemSync(batchUploadLog, (com.up366.mobile.common.logic.log.model.BatchUploadItem) obj);
        if (!zUploadTaskItemSync) {
            mapRunnerCtx.stop = true;
        }
        return java.lang.Boolean.valueOf(zUploadTaskItemSync);
    }

    private boolean uploadTaskItemSync(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem) {
        if (batchUploadItem.getType() == 1) {
            batchUploadItem.setState(1);
            this.db.getBatchUploadItemDao().update(batchUploadItem);
            return doUploadFileRecordSync(batchUploadLog, batchUploadItem);
        }
        if (batchUploadItem.getType() == 3) {
            batchUploadItem.setState(1);
            this.db.getBatchUploadItemDao().update(batchUploadItem);
            return doUploadFileSync(batchUploadLog, batchUploadItem);
        }
        if (batchUploadItem.getType() == 2) {
            batchUploadItem.setState(1);
            this.db.getBatchUploadItemDao().update(batchUploadItem);
            return doUploadFileSync(batchUploadLog, batchUploadItem);
        }
        if (batchUploadItem.getType() == 0) {
            batchUploadItem.setState(1);
            return doUploadStringSync(batchUploadLog, batchUploadItem);
        }
        throw new java.lang.IllegalStateException("unknown upload item type : " + batchUploadItem.getType() + " " + batchUploadItem.toString());
    }

    private boolean doUploadFileRecordSync(final com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, final com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem) {
        if (!com.up366.common.FileUtilsUp.isFileExists(batchUploadItem.getPath())) {
            batchUploadItem.setUploadSize(batchUploadItem.getSize());
            batchUploadItem.setState(2);
            this.db.getBatchUploadItemDao().update(batchUploadItem);
            com.up366.common.log.Logger.error("LogMgr - doUploadFileRecord - 文件丢失：" + batchUploadItem.getPath());
            updateUploadStatus(batchUploadLog);
            return true;
        }
        java.lang.String path = batchUploadItem.getPath() + com.up366.medialibrary.common.utils.MimeTypeUtils.MP3;
        if (!com.up366.common.FileUtilsUp.isFileExists(path)) {
            try {
                com.up366.mobile.common.utils.Wav2mp3Util.encode(batchUploadItem.getPath(), path);
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("TAG - LogMgr - doUploadFileRecord - ", e);
                com.up366.mobile.common.onlinelog.OpLog.report("ERROR-LogMgr-Wav2mp3", e.getMessage(), e);
                path = batchUploadItem.getPath();
            }
        }
        if (new java.io.File(path).length() == 0) {
            com.up366.mobile.common.onlinelog.OpLog.report("LogMgr-upload-0-length-mp3", batchUploadItem.toString());
            com.up366.common.log.Logger.error("文件长度为 0 ：objectId:" + batchUploadItem.getObjectId() + " path:" + batchUploadItem.getPath());
            batchUploadItem.setUploadSize(batchUploadItem.getSize());
            batchUploadItem.setState(2);
            this.db.getBatchUploadItemDao().update(batchUploadItem);
            updateUploadStatus(batchUploadLog);
            return true;
        }
        final com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoLoadSync = this.manager.fileMgr().loadSync(null, batchUploadItem.getObjectId());
        if (fileMapInfoLoadSync == null) {
            batchUploadItem.setUploadSize(batchUploadItem.getSize());
            batchUploadItem.setState(2);
            this.db.getBatchUploadItemDao().update(batchUploadItem);
            com.up366.common.log.Logger.error("LogMgr - doUploadFileRecord - 没有文件记录：" + batchUploadItem.getPath());
            updateUploadStatus(batchUploadLog);
            return true;
        }
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final boolean[] zArr = {false};
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoM729clone = fileMapInfoLoadSync.m729clone();
        fileMapInfoM729clone.setPath(path);
        com.up366.mobile.common.utils.alifile.AliFileMgrV2.uploadFile(fileMapInfoM729clone, new com.up366.mobile.common.utils.alifile.IOSSCallback() { // from class: com.up366.mobile.common.logic.log.LogMgr.1
            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onSuccess() {
                com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem2 = batchUploadItem;
                batchUploadItem2.setUploadSize(batchUploadItem2.getSize());
                batchUploadItem.setState(2);
                com.up366.mobile.common.logic.log.LogMgr.this.db.getBatchUploadItemDao().update(batchUploadItem);
                fileMapInfoLoadSync.setUploaded(true);
                com.up366.mobile.common.logic.log.LogMgr.this.db.getFileMapInfoDao().update(fileMapInfoLoadSync);
                com.up366.mobile.common.logic.log.LogMgr.this.updateUploadStatus(batchUploadLog);
                zArr[0] = true;
                countDownLatch.countDown();
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onFailure(int i, java.lang.String str) {
                batchUploadItem.setUploadSize(0L);
                batchUploadItem.setState(-1);
                com.up366.mobile.common.logic.log.LogMgr.this.db.getBatchUploadItemDao().update(batchUploadItem);
                com.up366.mobile.common.logic.log.LogMgr.this.updateTaskErrorInfo(batchUploadLog, i, str);
                com.up366.mobile.common.logic.log.LogMgr.this.updateUploadStatus(batchUploadLog);
                zArr[0] = false;
                countDownLatch.countDown();
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onProgress(long j, long j2) {
                batchUploadItem.setUploadSize(j);
                com.up366.mobile.common.logic.log.LogMgr.this.db.getBatchUploadItemDao().update(batchUploadItem);
                com.up366.mobile.common.logic.log.LogMgr.this.updateUploadStatus(batchUploadLog);
            }
        });
        try {
            countDownLatch.await(1L, java.util.concurrent.TimeUnit.HOURS);
        } catch (java.lang.InterruptedException e2) {
            com.up366.common.log.Logger.info("TAG - LogMgr - doUploadFileRecordSync - ", e2);
        }
        return zArr[0];
    }

    private boolean doUploadFileSync(final com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, final com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem) {
        if (!com.up366.common.FileUtilsUp.isFileExists(batchUploadItem.getPath())) {
            batchUploadItem.setUploadSize(batchUploadItem.getSize());
            batchUploadItem.setState(2);
            this.db.getBatchUploadItemDao().update(batchUploadItem);
            com.up366.common.log.Logger.error("LogMgr - doUploadFile - 文件丢失：" + batchUploadItem.getPath());
            updateUploadStatus(batchUploadLog);
            return true;
        }
        if (new java.io.File(batchUploadItem.getPath()).length() == 0) {
            com.up366.mobile.common.onlinelog.OpLog.report("LogMgr-upload-0-length-file", batchUploadItem.toString());
            com.up366.common.log.Logger.error("文件长度为 0 ：objectId:" + batchUploadItem.getObjectId() + " path:" + batchUploadItem.getPath());
            batchUploadItem.setUploadSize(batchUploadItem.getSize());
            batchUploadItem.setState(2);
            this.db.getBatchUploadItemDao().update(batchUploadItem);
            updateUploadStatus(batchUploadLog);
            return true;
        }
        final com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoLoadSync = this.manager.fileMgr().loadSync(null, batchUploadItem.getObjectId());
        if (fileMapInfoLoadSync == null) {
            batchUploadItem.setUploadSize(batchUploadItem.getSize());
            batchUploadItem.setState(2);
            this.db.getBatchUploadItemDao().update(batchUploadItem);
            com.up366.common.log.Logger.error("LogMgr - doUploadFile - 没有文件记录：" + batchUploadItem.getPath());
            updateUploadStatus(batchUploadLog);
            return true;
        }
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoM729clone = fileMapInfoLoadSync.m729clone();
        fileMapInfoM729clone.setPath(batchUploadItem.getPath());
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final boolean[] zArr = {false};
        com.up366.mobile.common.utils.alifile.AliFileMgrV2.uploadFile(fileMapInfoM729clone, new com.up366.mobile.common.utils.alifile.IOSSCallback() { // from class: com.up366.mobile.common.logic.log.LogMgr.2
            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onSuccess() {
                com.up366.common.log.Logger.info("TAG - LogMgr - onSuccess - isMainThread : " + com.up366.common.task.TaskUtils.isMainThread());
                com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem2 = batchUploadItem;
                batchUploadItem2.setUploadSize(batchUploadItem2.getSize());
                batchUploadItem.setState(2);
                com.up366.mobile.common.logic.log.LogMgr.this.db.getBatchUploadItemDao().update(batchUploadItem);
                fileMapInfoLoadSync.setUploaded(true);
                com.up366.mobile.common.logic.log.LogMgr.this.db.getFileMapInfoDao().update(fileMapInfoLoadSync);
                com.up366.mobile.common.logic.log.LogMgr.this.updateUploadStatus(batchUploadLog);
                zArr[0] = true;
                countDownLatch.countDown();
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onFailure(int i, java.lang.String str) {
                com.up366.common.log.Logger.info("TAG - LogMgr - onFailure - isMainThread : " + com.up366.common.task.TaskUtils.isMainThread());
                batchUploadItem.setUploadSize(0L);
                batchUploadItem.setState(-1);
                com.up366.mobile.common.logic.log.LogMgr.this.db.getBatchUploadItemDao().update(batchUploadItem);
                com.up366.mobile.common.logic.log.LogMgr.this.updateTaskErrorInfo(batchUploadLog, i, str);
                com.up366.mobile.common.logic.log.LogMgr.this.updateUploadStatus(batchUploadLog);
                zArr[0] = false;
                countDownLatch.countDown();
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onProgress(long j, long j2) {
                batchUploadItem.setUploadSize(j);
                com.up366.mobile.common.logic.log.LogMgr.this.db.getBatchUploadItemDao().update(batchUploadItem);
                com.up366.mobile.common.logic.log.LogMgr.this.updateUploadStatus(batchUploadLog);
            }
        });
        try {
            countDownLatch.await(1L, java.util.concurrent.TimeUnit.HOURS);
        } catch (java.lang.InterruptedException e) {
            com.up366.common.log.Logger.info("TAG - LogMgr - doUploadFileSync - ", e);
        }
        return zArr[0];
    }

    private boolean doUploadStringSync(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem) throws java.lang.Throwable {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(batchUploadItem.getHeaders());
        okhttp3.RequestBody gZipBody = getGZipBody(object);
        okhttp3.RequestBody rawBody = getRawBody(object);
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        boolean[] zArr = {false};
        com.up366.common.http.HttpUtilsUp.post(new com.up366.mobile.common.logic.log.LogMgr.AnonymousClass3(batchUploadItem.getConfigUrl(), object, batchUploadItem, gZipBody, rawBody, batchUploadLog, zArr, countDownLatch));
        try {
            countDownLatch.await(1L, java.util.concurrent.TimeUnit.HOURS);
        } catch (java.lang.InterruptedException e) {
            com.up366.common.log.Logger.info("TAG - LogMgr - doUploadStringSync - ", e);
        }
        return zArr[0];
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.logic.log.LogMgr$3, reason: invalid class name */
    class AnonymousClass3 extends com.up366.common.http.RequestParams<java.lang.String> {
        final /* synthetic */ okhttp3.RequestBody val$gzBody;
        final /* synthetic */ com.alibaba.fastjson.JSONObject val$jsonObject;
        final /* synthetic */ java.util.concurrent.CountDownLatch val$latch;
        final /* synthetic */ com.up366.mobile.common.logic.log.model.BatchUploadLog val$log;
        final /* synthetic */ okhttp3.RequestBody val$rawBody;
        final /* synthetic */ com.up366.mobile.common.logic.log.model.BatchUploadItem val$task;
        final /* synthetic */ boolean[] val$uploadResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject, com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem, okhttp3.RequestBody requestBody, okhttp3.RequestBody requestBody2, com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, boolean[] zArr, java.util.concurrent.CountDownLatch countDownLatch) {
            super(str);
            this.val$jsonObject = jSONObject;
            this.val$task = batchUploadItem;
            this.val$gzBody = requestBody;
            this.val$rawBody = requestBody2;
            this.val$log = batchUploadLog;
            this.val$uploadResult = zArr;
            this.val$latch = countDownLatch;
        }

        @Override // com.up366.common.http.RequestParams
        public void initHeaders(java.util.Map<java.lang.String, java.lang.Object> map) {
            super.initHeaders(map);
            com.alibaba.fastjson.JSONObject jSONObject = this.val$jsonObject;
            if (jSONObject != null) {
                jSONObject.remove("u3t");
                map.putAll(this.val$jsonObject);
            }
        }

        @Override // com.up366.common.http.RequestParams
        public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(this.val$task.getPostParams());
            if (object != null) {
                map.putAll(object);
            }
        }

        @Override // com.up366.common.http.RequestParams
        public okhttp3.RequestBody getRequestBody() {
            okhttp3.RequestBody requestBody = this.val$gzBody;
            return requestBody != null ? requestBody : this.val$rawBody;
        }

        @Override // com.up366.common.http.RequestParams
        public void onResponse(final com.up366.common.http.Response response, java.lang.String str) {
            super.onResponse(response, str);
            final com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem = this.val$task;
            final com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = this.val$log;
            final boolean[] zArr = this.val$uploadResult;
            final java.util.concurrent.CountDownLatch countDownLatch = this.val$latch;
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.log.LogMgr$3$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onResponse$0(response, batchUploadItem, batchUploadLog, zArr, countDownLatch);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(com.up366.common.http.Response response, com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem, com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, boolean[] zArr, java.util.concurrent.CountDownLatch countDownLatch) throws java.lang.Exception {
            if (response.isError()) {
                batchUploadItem.setState(-1);
                com.up366.mobile.common.logic.log.LogMgr.this.db.getBatchUploadItemDao().update(batchUploadItem);
                com.up366.mobile.common.logic.log.LogMgr.this.updateTaskErrorInfo(batchUploadLog, response.getCode(), response.getInfo());
                com.up366.mobile.common.logic.log.LogMgr.this.updateUploadStatus(batchUploadLog);
                zArr[0] = false;
                countDownLatch.countDown();
                return;
            }
            batchUploadItem.setState(2);
            batchUploadItem.setUploadSize(batchUploadItem.getSize());
            com.up366.mobile.common.logic.log.LogMgr.this.db.getBatchUploadItemDao().update(batchUploadItem);
            com.up366.mobile.common.logic.log.LogMgr.this.updateUploadStatus(batchUploadLog);
            zArr[0] = true;
            countDownLatch.countDown();
        }
    }

    private okhttp3.RequestBody getGZipBody(com.alibaba.fastjson.JSONObject jSONObject) throws java.lang.Throwable {
        java.lang.String string;
        if (jSONObject == null || (string = jSONObject.getString("___gzip_content___")) == null) {
            return null;
        }
        jSONObject.remove("___gzip_content___");
        final byte[] bArrGzip = com.up366.common.ZipStringUtils.gzip(string.getBytes());
        return new okhttp3.RequestBody() { // from class: com.up366.mobile.common.logic.log.LogMgr.4
            public okhttp3.MediaType contentType() {
                return null;
            }

            public long contentLength() {
                return bArrGzip.length;
            }

            public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
                bufferedSink.write(bArrGzip);
            }
        };
    }

    private okhttp3.RequestBody getRawBody(com.alibaba.fastjson.JSONObject jSONObject) {
        java.lang.String string;
        if (jSONObject == null || (string = jSONObject.getString("___raw_content___")) == null) {
            return null;
        }
        jSONObject.remove("___raw_content___");
        final byte[] bytes = string.getBytes();
        return new okhttp3.RequestBody() { // from class: com.up366.mobile.common.logic.log.LogMgr.5
            public okhttp3.MediaType contentType() {
                return null;
            }

            public long contentLength() {
                return bytes.length;
            }

            public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
                bufferedSink.write(bytes);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTaskErrorInfo(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, int i, java.lang.String str) {
        batchUploadLog.setErrCode(i);
        batchUploadLog.setErrInfo(str);
        batchUploadLog.updateHistory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUploadStatus(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog) {
        boolean z;
        if (batchUploadLog.getState() == 2) {
            return;
        }
        batchUploadLog.setUpdateTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        java.util.Iterator<com.up366.mobile.common.logic.log.model.BatchUploadItem> it = batchUploadLog.getTasks().iterator();
        boolean z2 = true;
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            com.up366.mobile.common.logic.log.model.BatchUploadItem next = it.next();
            if (next.getState() != 2) {
                z2 = false;
            }
            if (next.getState() == -1) {
                z = true;
                break;
            }
        }
        batchUploadLog.initUploadFileSize();
        if (batchUploadLog.getState() == -1) {
            this.db.getBatchUploadLogDao().update(batchUploadLog);
            return;
        }
        if (z) {
            batchUploadLog.setState(-1);
            com.up366.common.log.Logger.error("TAG - LogMgr - upload failed - refKey : " + batchUploadLog.getRefKey() + " code:" + batchUploadLog.getErrCode() + " info:" + batchUploadLog.getErrInfo());
            com.up366.mobile.common.onlinelog.OpLog.report("上传失败", "type:" + batchUploadLog.getType() + " refKey:" + batchUploadLog.getRefKey() + " code:" + batchUploadLog.getErrCode() + " info:" + batchUploadLog.getErrInfo());
        } else if (z2) {
            batchUploadLog.setState(2);
            com.up366.common.log.Logger.info("TAG - LogMgr - upload success - refKey : " + batchUploadLog.getRefKey());
            com.up366.mobile.common.onlinelog.OpLog.report("上传成功", "type:" + batchUploadLog.getType() + " refKey:" + batchUploadLog.getRefKey());
            com.up366.mobile.book.oplog.StudyOpLogHelper.recordOpLogAfterUpload(batchUploadLog.getOpLogId());
        }
        this.db.getBatchUploadLogDao().update(batchUploadLog);
        long jUptimeMillis = android.os.SystemClock.uptimeMillis() - this.lastUpdateProgressTime;
        if (batchUploadLog.getState() == 1 && android.text.TextUtils.equals(this.lastBatchId, batchUploadLog.getBatchId()) && jUptimeMillis < 300) {
            return;
        }
        java.lang.String str = batchUploadLog.getBatchId() + batchUploadLog.getPercent();
        if (batchUploadLog.getState() == 1 && str.equals(this.lastUpdateKey)) {
            return;
        }
        this.lastUpdateKey = str;
        this.lastBatchId = batchUploadLog.getBatchId();
        this.lastUpdateProgressTime = android.os.SystemClock.uptimeMillis();
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.CommonUploadLogEvent(batchUploadLog));
    }

    public void deleteTask(final java.lang.String str) {
        this.db.runInTx(new java.lang.Runnable() { // from class: com.up366.mobile.common.logic.log.LogMgr$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteTask$9(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteTask$9(java.lang.String str) {
        this.db.getBatchUploadItemDao().queryBuilder().where(com.up366.greendao.BatchUploadItemDao.Properties.BatchId.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).buildDelete().executeDeleteWithoutDetachingEntities();
        this.db.getBatchUploadLogDao().queryBuilder().where(com.up366.greendao.BatchUploadLogDao.Properties.BatchId.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).buildDelete().executeDeleteWithoutDetachingEntities();
    }

    public static java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadItem> getBatchUploadItems(com.up366.greendao.DaoSession daoSession, java.lang.String str) {
        try {
            return daoSession.getBatchUploadItemDao().queryBuilder().where(com.up366.greendao.BatchUploadItemDao.Properties.BatchId.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).list();
        } catch (android.database.sqlite.SQLiteBlobTooBigException unused) {
            for (long j = 10485760; j < 104857600; j *= 2) {
                try {
                    com.up366.common.log.Logger.info("TAG - LogMgr - getBatchUploadItems - with window size:" + j);
                    return rawQueryBatchUploadItem(str, j);
                } catch (android.database.sqlite.SQLiteBlobTooBigException unused2) {
                }
            }
            return null;
        }
    }

    private static java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadItem> rawQueryBatchUploadItem(java.lang.String str, long j) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = (android.database.sqlite.SQLiteDatabase) com.up366.mobile.common.logic.Auth.cur().db().getDatabase().getRawDatabase();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.CursorWindow cursorWindowCreate = androidx.core.database.CursorWindowCompat.create(sQLiteDatabase.getPath(), j);
        try {
            android.database.Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select batch_id, id, type, size, upload_size, state, config_url, headers, post_params, path, object_id from batch_upload_item where batch_id = ?;", new java.lang.String[]{str});
            try {
                ((android.database.sqlite.SQLiteCursor) cursorRawQuery).setWindow(cursorWindowCreate);
                while (cursorRawQuery.moveToNext()) {
                    com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem = new com.up366.mobile.common.logic.log.model.BatchUploadItem();
                    batchUploadItem.setBatchId(cursorRawQuery.getString(0));
                    batchUploadItem.setId(cursorRawQuery.getInt(1));
                    batchUploadItem.setType(cursorRawQuery.getInt(2));
                    batchUploadItem.setSize(cursorRawQuery.getLong(3));
                    batchUploadItem.setUploadSize(cursorRawQuery.getLong(4));
                    batchUploadItem.setState(cursorRawQuery.getInt(5));
                    batchUploadItem.setConfigUrl(cursorRawQuery.getString(6));
                    batchUploadItem.setHeaders(cursorRawQuery.getString(7));
                    batchUploadItem.setPostParams(cursorRawQuery.getString(8));
                    batchUploadItem.setPath(cursorRawQuery.getString(9));
                    batchUploadItem.setObjectId(cursorRawQuery.getString(10));
                    arrayList.add(batchUploadItem);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                if (cursorWindowCreate != null) {
                    cursorWindowCreate.close();
                }
                return arrayList;
            } finally {
            }
        } catch (java.lang.Throwable th) {
            if (cursorWindowCreate != null) {
                try {
                    cursorWindowCreate.close();
                } catch (java.lang.Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
