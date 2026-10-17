package com.up366.mobile.common.utils.alifile;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FileMgr {
    private final com.up366.greendao.DaoSession db;
    private final java.lang.Object lock = new java.lang.Object();
    private final com.up366.mobile.common.logic.Manager manager;

    public interface ISaveResult {
        void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo);
    }

    public FileMgr(com.up366.mobile.common.logic.Manager manager) {
        this.manager = manager;
        this.db = manager.db();
    }

    public com.up366.mobile.common.utils.alifile.FileMapInfo saveSync(final java.lang.String str, final java.lang.String str2, final java.lang.String str3) {
        final com.up366.mobile.common.utils.alifile.FileMapInfo[] fileMapInfoArr = new com.up366.mobile.common.utils.alifile.FileMapInfo[1];
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.alifile.FileMgr$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$saveSync$1(str, str2, str3, fileMapInfoArr);
            }
        });
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        synchronized (this.lock) {
            if (fileMapInfoArr[0] == null) {
                try {
                    this.lock.wait(com.igexin.push.config.c.s);
                } catch (java.lang.InterruptedException e) {
                    com.up366.common.log.Logger.error("TAG - FileMgr - saveSync - catch InterruptedException ", e);
                }
            }
        }
        long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
        if (jCurrentTimeMillis2 > 4000) {
            com.up366.mobile.common.onlinelog.OpLog.report("FileMgr-saveSync-timeout", java.lang.String.valueOf(jCurrentTimeMillis2));
            com.up366.common.log.Logger.info("TAG - FileMgr - saveSync - timeout : " + jCurrentTimeMillis2);
        }
        if (fileMapInfoArr[0] == null) {
            com.up366.mobile.common.onlinelog.OpLog.report("FileMgr-saveSync-failed", "path:" + str + " ext:" + str2 + " biz:" + str3);
            com.up366.common.log.Logger.error("TAG - FileMgr - saveSync - failed : path:" + str + " ext:" + str2 + " biz:" + str3);
        }
        return fileMapInfoArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveSync$1(java.lang.String str, java.lang.String str2, java.lang.String str3, final com.up366.mobile.common.utils.alifile.FileMapInfo[] fileMapInfoArr) throws java.lang.Exception {
        save(str, str2, str3, new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.common.utils.alifile.FileMgr$$ExternalSyntheticLambda8
            @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
            public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                this.f$0.lambda$saveSync$0(fileMapInfoArr, fileMapInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveSync$0(com.up366.mobile.common.utils.alifile.FileMapInfo[] fileMapInfoArr, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        fileMapInfoArr[0] = fileMapInfo;
        synchronized (this.lock) {
            this.lock.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$save$2(java.lang.String str, java.lang.String str2, java.lang.String str3, com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult iSaveResult) throws java.lang.Exception {
        save(str, str2, str3, null, iSaveResult);
    }

    public void save(final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult iSaveResult) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.alifile.FileMgr$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$save$2(str, str2, str3, iSaveResult);
            }
        });
    }

    public com.up366.mobile.common.utils.alifile.FileMapInfo saveSync(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) throws java.lang.InterruptedException {
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final com.up366.mobile.common.utils.alifile.FileMapInfo[] fileMapInfoArr = new com.up366.mobile.common.utils.alifile.FileMapInfo[1];
        save(str, str2, str3, str4, new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.common.utils.alifile.FileMgr$$ExternalSyntheticLambda9
            @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
            public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                com.up366.mobile.common.utils.alifile.FileMgr.lambda$saveSync$3(fileMapInfoArr, countDownLatch, fileMapInfo);
            }
        });
        countDownLatch.await();
        return fileMapInfoArr[0];
    }

    static /* synthetic */ void lambda$saveSync$3(com.up366.mobile.common.utils.alifile.FileMapInfo[] fileMapInfoArr, java.util.concurrent.CountDownLatch countDownLatch, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        fileMapInfoArr[0] = fileMapInfo;
        countDownLatch.countDown();
    }

    public void save(final java.lang.String str, final java.lang.String str2, final java.lang.String str3, java.lang.String str4, final com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult iSaveResult) {
        if (!com.up366.common.FileUtilsUp.isFileExists(str)) {
            throw new java.lang.IllegalStateException("文件 " + str + " 不存在");
        }
        if (com.up366.common.task.TaskUtils.isMainThread()) {
            com.up366.common.log.Logger.warn("TAG - FileMgr - save - save in MainThread", new java.lang.IllegalStateException());
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(str4)) {
            str4 = com.up366.mobile.common.utils.alifile.OssObjectKey.INSTANCE.getObjectKey(str, str2);
        }
        final java.lang.String str5 = str4;
        getDownloadUrlByFilePath(str3, str4, str, str2, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.common.utils.alifile.FileMgr$$ExternalSyntheticLambda2
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str6, java.lang.Object obj) {
                this.f$0.lambda$save$4(str3, str2, str, str5, iSaveResult, i, str6, (java.lang.String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$save$4(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult iSaveResult, int i, java.lang.String str5, java.lang.String str6) {
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo = new com.up366.mobile.common.utils.alifile.FileMapInfo();
        if (i == 0) {
            fileMapInfo.setBiz(str);
        } else {
            fileMapInfo.setBiz(com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
        }
        fileMapInfo.setAddTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        fileMapInfo.setExt(str2);
        fileMapInfo.setPath(str3);
        fileMapInfo.setObjectId(str4);
        fileMapInfo.setUrl(str6);
        this.db.getFileMapInfoDao().insertOrReplaceInTx(new com.up366.mobile.common.utils.alifile.FileMapInfo[]{fileMapInfo});
        iSaveResult.onResult(fileMapInfo);
    }

    public void load(final java.lang.String str, final java.lang.String str2, final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.utils.alifile.FileMapInfo> iCallbackCodeInfoObj) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.alifile.FileMgr$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$load$5(str, str2, iCallbackCodeInfoObj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$load$5(java.lang.String str, java.lang.String str2, com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj) throws java.lang.Exception {
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoLoadSync = loadSync(str, str2);
        iCallbackCodeInfoObj.onResult(fileMapInfoLoadSync == null ? -1 : 0, "", fileMapInfoLoadSync);
    }

    public com.up366.mobile.common.utils.alifile.FileMapInfo loadSync(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo = (com.up366.mobile.common.utils.alifile.FileMapInfo) this.db.getFileMapInfoDao().queryBuilder().whereOr(com.up366.greendao.FileMapInfoDao.Properties.Url.eq(str), com.up366.greendao.FileMapInfoDao.Properties.ObjectId.eq(str2), new org.greenrobot.greendao.query.WhereCondition[0]).unique();
        if (fileMapInfo == null) {
            java.lang.String strMd5 = com.up366.common.digest.MD5.md5(str);
            java.lang.String strLoadData = new com.up366.mobile.book.helper.DataHelper().loadData(strMd5);
            if (!com.up366.common.StringUtils.isEmptyOrNull(strLoadData)) {
                java.lang.String[] strArrSplit = strLoadData.split(";");
                if (strArrSplit.length == 2) {
                    java.lang.String str3 = strArrSplit[0];
                    java.lang.String str4 = strArrSplit[1];
                    com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo2 = new com.up366.mobile.common.utils.alifile.FileMapInfo();
                    fileMapInfo2.setBiz(com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
                    fileMapInfo2.setAddTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
                    fileMapInfo2.setExt(com.up366.mobile.common.utils.alifile.OssObjectKey.INSTANCE.getExtensionName(str4));
                    fileMapInfo2.setPath(str3);
                    fileMapInfo2.setObjectId(str4);
                    fileMapInfo2.setUrl(str);
                    this.db.getFileMapInfoDao().insertOrReplaceInTx(new com.up366.mobile.common.utils.alifile.FileMapInfo[]{fileMapInfo2});
                    new com.up366.mobile.book.helper.DataHelper().deleteData(strMd5);
                    com.up366.common.log.Logger.info("TAG - FileMgr - load - remove old record - url : " + str + " path : " + str3);
                    fileMapInfo = fileMapInfo2;
                }
            }
        }
        if (fileMapInfo == null) {
            com.up366.common.log.Logger.error("TAG - FileMgr - load error not found : url = [" + str + "], objectId = [" + str2 + "]");
        }
        return fileMapInfo;
    }

    private void getDownloadUrlByFilePath(java.lang.String str, final java.lang.String str2, java.lang.String str3, java.lang.String str4, final com.up366.common.callback.ICallbackCodeInfoObj<java.lang.String> iCallbackCodeInfoObj) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            str2 = com.up366.mobile.common.utils.alifile.OssObjectKey.INSTANCE.getObjectKey(str3, str4);
        }
        getUrlPrefix(str, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.common.utils.alifile.FileMgr$$ExternalSyntheticLambda6
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str5, java.lang.Object obj) {
                iCallbackCodeInfoObj.onResult(i, str5, ((java.lang.String) obj) + str2);
            }
        });
    }

    private void getUrlPrefix(final java.lang.String str, final com.up366.common.callback.ICallbackCodeInfoObj<java.lang.String> iCallbackCodeInfoObj) {
        this.manager.config().fetchAliTokenMap(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.common.utils.alifile.FileMgr$$ExternalSyntheticLambda4
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.mobile.common.utils.alifile.FileMgr.lambda$getUrlPrefix$7(str, iCallbackCodeInfoObj, response, (java.util.Map) obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void lambda$getUrlPrefix$7(java.lang.String r5, com.up366.common.callback.ICallbackCodeInfoObj r6, com.up366.common.http.Response r7, java.util.Map r8) {
        /*
            boolean r0 = r7.isError()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L20
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "TAG - FileMgr - getUrlPrefix - "
            r5.<init>(r8)
            java.lang.String r7 = r7.toString()
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            com.up366.common.log.Logger.error(r5)
            r3 = r1
        L1e:
            r5 = r2
            goto L65
        L20:
            java.lang.Object r0 = r8.get(r5)
            r3 = 0
            if (r0 == 0) goto L2e
            java.lang.Object r5 = r8.get(r5)
            com.up366.mobile.common.logic.model.AppConfigOssBucketInfo r5 = (com.up366.mobile.common.logic.model.AppConfigOssBucketInfo) r5
            goto L65
        L2e:
            int r0 = r8.size()
            if (r0 <= 0) goto L1e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "TAG - FileMgr - getUrlPrefix - missing biz "
            r0.<init>(r4)
            r0.append(r5)
            java.lang.String r5 = " "
            r0.append(r5)
            java.lang.String r5 = r7.toString()
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            com.up366.common.log.Logger.error(r5)
            java.util.Set r5 = r8.entrySet()
            java.util.Iterator r5 = r5.iterator()
            java.lang.Object r5 = r5.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r5 = r5.getValue()
            com.up366.mobile.common.logic.model.AppConfigOssBucketInfo r5 = (com.up366.mobile.common.logic.model.AppConfigOssBucketInfo) r5
        L65:
            if (r5 != 0) goto L68
            goto L69
        L68:
            r1 = r3
        L69:
            if (r1 == 0) goto L77
            com.up366.mobile.common.logic.Manager r5 = com.up366.mobile.common.logic.Auth.cur()
            com.up366.mobile.common.logic.AppConfigMgr r5 = r5.config()
            com.up366.mobile.common.logic.model.AppConfigOssBucketInfo r5 = r5.getDefaultBucketInfo()
        L77:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "https://"
            r7.<init>(r8)
            java.lang.String r8 = r5.getBucketname()
            r7.append(r8)
            java.lang.String r8 = "."
            r7.append(r8)
            java.lang.String r5 = r5.getDefaulthostid()
            r7.append(r5)
            java.lang.String r5 = "/"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.onResult(r1, r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.common.utils.alifile.FileMgr.lambda$getUrlPrefix$7(java.lang.String, com.up366.common.callback.ICallbackCodeInfoObj, com.up366.common.http.Response, java.util.Map):void");
    }

    public java.lang.String newCacheFile() {
        return newCacheFile(com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3, java.util.UUID.randomUUID().toString());
    }

    public java.lang.String newCacheFile(long j) {
        return newCacheFile(j, java.util.UUID.randomUUID().toString());
    }

    public java.lang.String newCacheFile(long j, java.lang.String str) {
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getUserRootPath(), "n_cache", str);
        com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin);
        com.up366.common.FileUtilsUp.mkdirParentDir(strJoin);
        this.manager.db1().saveOrUpdate(new com.up366.mobile.common.utils.alifile.FileCacheInfo(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() + j, strJoin));
        com.up366.common.log.Logger.info("TAG - FileMgr - newCacheFile - filepath:" + strJoin);
        return strJoin;
    }

    public java.lang.String getCacheFile(long j, java.lang.String str) {
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getUserRootPath(), "n_cache", str);
        com.up366.common.FileUtilsUp.mkdirParentDir(strJoin);
        this.manager.db1().saveOrUpdate(new com.up366.mobile.common.utils.alifile.FileCacheInfo(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() + j, strJoin));
        com.up366.common.log.Logger.debug("TAG - FileMgr - getCacheFile - filepath:" + strJoin);
        return strJoin;
    }

    public java.lang.String getCacheFileV2(long j, java.lang.String str) {
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getRootResourceDir(), str);
        com.up366.common.FileUtilsUp.mkdirParentDir(strJoin);
        this.manager.db1().saveOrUpdate(new com.up366.mobile.common.utils.alifile.FileCacheInfo(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() + j, strJoin));
        com.up366.common.log.Logger.info("TAG - FileMgr - getCacheFileV2 - filepath:" + strJoin);
        return strJoin;
    }

    public void cleanCacheFiles() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.alifile.FileMgr$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$cleanCacheFiles$9();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cleanCacheFiles$9() throws java.lang.Exception {
        final long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        com.up366.mobile.common.logic.DBUtil dBUtilDb1 = this.manager.db1();
        java.util.List<com.up366.mobile.common.utils.alifile.FileCacheInfo> listFind = dBUtilDb1.find(com.up366.mobile.common.utils.alifile.FileCacheInfo.class, new androidx.arch.core.util.Function() { // from class: com.up366.mobile.common.utils.alifile.FileMgr$$ExternalSyntheticLambda5
            public final java.lang.Object apply(java.lang.Object obj) {
                return ((io.objectbox.query.QueryBuilder) obj).less((io.objectbox.Property) com.up366.mobile.common.utils.alifile.FileCacheInfo_.expireTime, currentNtpTimeInMillisecond);
            }
        });
        if (listFind.size() > 0) {
            for (com.up366.mobile.common.utils.alifile.FileCacheInfo fileCacheInfo : listFind) {
                com.up366.common.log.Logger.info("TAG - FileMgr - cleanCacheFiles - " + fileCacheInfo);
                com.up366.common.FileUtilsUp.deleteDirOrFile(fileCacheInfo.path);
            }
            dBUtilDb1.remove(listFind);
        }
    }

    public com.up366.mobile.common.utils.alifile.FileMapInfo loadSyncByPath(java.lang.String str) {
        if (!com.up366.common.FileUtilsUp.isFileExists(str)) {
            return null;
        }
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo = (com.up366.mobile.common.utils.alifile.FileMapInfo) this.db.getFileMapInfoDao().queryBuilder().where(com.up366.greendao.FileMapInfoDao.Properties.Path.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).orderDesc(new org.greenrobot.greendao.Property[]{com.up366.greendao.FileMapInfoDao.Properties.AddTime}).limit(1).unique();
        if (fileMapInfo == null) {
            com.up366.common.log.Logger.info("TAG - FileMgr - loadSyncByPath not found : path = [" + str + "]");
        }
        if (fileMapInfo != null) {
            java.lang.String objectId = fileMapInfo.getObjectId();
            int iIndexOf = objectId.indexOf("u");
            java.lang.String objectKey = com.up366.mobile.common.utils.alifile.OssObjectKey.INSTANCE.getObjectKey(fileMapInfo.getPath(), fileMapInfo.getExt());
            if (!android.text.TextUtils.equals(objectKey.substring(iIndexOf), objectId.substring(iIndexOf))) {
                com.up366.common.log.Logger.error("TAG - FileMgr - loadSyncByPath - 原始本地文件已被修改: " + fileMapInfo.getUrl() + " newObjectKey: " + objectKey);
                com.up366.mobile.common.onlinelog.OpLog.report("ERROR_changeFileInfo", "oldUrl:" + fileMapInfo.getUrl() + " newObjectKey: " + objectKey);
                return null;
            }
        }
        return fileMapInfo;
    }

    public synchronized com.up366.mobile.common.utils.alifile.FileMapInfo getFileMapInfo(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) && android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoLoadSync = android.text.TextUtils.isEmpty(str) ? null : com.up366.mobile.common.logic.Auth.cur().fileMgr().loadSync(str, null);
        if (fileMapInfoLoadSync != null) {
            return fileMapInfoLoadSync;
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            fileMapInfoLoadSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().loadSyncByPath(str2);
        }
        if (fileMapInfoLoadSync != null) {
            return fileMapInfoLoadSync;
        }
        if (com.up366.common.FileUtilsUp.isFileExists(str2)) {
            java.lang.String extensionName = com.up366.mobile.common.utils.alifile.OssObjectKey.INSTANCE.getExtensionName(str2);
            if (android.text.TextUtils.equals(com.up366.medialibrary.common.utils.MimeTypeUtils.WAV, extensionName)) {
                extensionName = com.up366.medialibrary.common.utils.MimeTypeUtils.MP3;
            }
            fileMapInfoLoadSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync(str2, extensionName, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
        }
        return fileMapInfoLoadSync;
    }
}
