package com.up366.mobile.book.helper.recorder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SpeechAsyncHelper {
    private static com.up366.mobile.book.helper.recorder.SpeechAsyncHelper instance;
    private static final java.lang.Object waitLock = new java.lang.Object();
    private java.lang.String currentRecordId;
    private com.up366.asecengine.englishengine.AsecEngineAsyncHelper engineHelper;

    private SpeechAsyncHelper(android.content.Context context) {
        if (this.engineHelper == null) {
            this.engineHelper = com.up366.asecengine.englishengine.AsecEngineAsyncHelper.create(context);
            com.up366.common.task.TaskUtils.createSerialExecutor("ases-score-queue").post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.recorder.SpeechAsyncHelper$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.InterruptedException {
                    this.f$0.startAsesQueue();
                }
            });
        }
    }

    public static com.up366.mobile.book.helper.recorder.SpeechAsyncHelper getInstance() {
        if (instance == null) {
            instance = new com.up366.mobile.book.helper.recorder.SpeechAsyncHelper(com.up366.common.global.GB.get().getApplicationContext());
        }
        return instance;
    }

    public void addToAsecQueue(com.up366.mobile.book.helper.recorder.AsecSessionModel asecSessionModel) {
        com.up366.common.log.Logger.info("TAG - SpeechAsyncHelper - add to queue - wav duration : " + asecSessionModel.getDuration());
        java.util.List list = com.up366.mobile.common.logic.Auth.cur().db().getAsecSessionModelDao().queryBuilder().where(com.up366.greendao.AsecSessionModelDao.Properties.RecordId.eq(asecSessionModel.getRecordId()), new org.greenrobot.greendao.query.WhereCondition[0]).list();
        com.up366.mobile.common.logic.Auth.cur().db().insertOrReplace(asecSessionModel);
        if (list.size() > 0 && ((com.up366.mobile.book.helper.recorder.AsecSessionModel) list.get(0)).getState() == 1) {
            this.engineHelper.forceStopAll();
        }
        notifyTask();
    }

    private void notifyTask() {
        com.up366.common.log.Logger.info("TAG - SpeechAsyncHelper - require release lock - ");
        java.lang.Object obj = waitLock;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private void waitTask() {
        com.up366.common.log.Logger.info("TAG - SpeechAsyncHelper - wait lock - ");
        java.lang.Object obj = waitLock;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (java.lang.Exception unused) {
            }
        }
        com.up366.common.log.Logger.info("TAG - SpeechAsyncHelper - release lock - ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAsesQueue() throws java.lang.InterruptedException {
        while (true) {
            com.up366.common.log.Logger.info("TAG - SpeechAsyncHelper - start loop  - ");
            com.up366.mobile.book.helper.recorder.AsecSessionModel asecSessionModelFindScoreModel = findScoreModel(this.currentRecordId);
            this.currentRecordId = null;
            if (asecSessionModelFindScoreModel == null) {
                com.up366.common.log.Logger.info("TAG - SpeechAsyncHelper - startAsesQueue - 待评分队列已空");
                waitTask();
            } else {
                com.up366.common.log.Logger.info("TAG - SpeechAsyncHelper - do score - " + asecSessionModelFindScoreModel.getRecordId());
                com.up366.common.log.Logger.info("TAG - SpeechAsyncHelper - start do score - ");
                boolean zDoScore = doScore(asecSessionModelFindScoreModel);
                com.up366.common.log.Logger.info("TAG - SpeechAsyncHelper - end do score - " + zDoScore);
                if (!zDoScore) {
                    waitTask();
                }
            }
        }
    }

    private void showGlobalDialog(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.recorder.SpeechAsyncHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.recorder.SpeechAsyncHelper.lambda$showGlobalDialog$1(str);
            }
        });
    }

    static /* synthetic */ void lambda$showGlobalDialog$1(java.lang.String str) throws java.lang.Exception {
        final android.app.Activity currentActivity = com.up366.common.global.GB.get().getCurrentActivity();
        if (currentActivity instanceof com.up366.mobile.book.StudyActivity) {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.PhoneState(1));
            com.up366.mobile.common.dialog.DialogOkCancleV2.create(currentActivity).setCancelable(false).title("评分失败").message(str).hideCancel().ok("退出", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.helper.recorder.SpeechAsyncHelper$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.book.helper.recorder.SpeechAsyncHelper.lambda$showGlobalDialog$0(currentActivity, view);
                }
            }).show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$showGlobalDialog$0(android.content.Context context, android.view.View view) {
        final com.up366.mobile.book.StudyActivity studyActivity = (com.up366.mobile.book.StudyActivity) context;
        java.util.Objects.requireNonNull(studyActivity);
        com.up366.common.task.TaskUtils.postLazyTaskGlobal("SpeechAsyncHelper", 100, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.recorder.SpeechAsyncHelper$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() {
                studyActivity.finish();
            }
        });
    }

    private void buildAndSaveResult(com.up366.asecengine.englishengine.AsecSession asecSession, com.alibaba.fastjson.JSONObject jSONObject, com.up366.mobile.book.helper.recorder.AsecSessionModel asecSessionModel) {
        if (asecSessionModel.getCbType() == 1) {
            jSONObject.put("result", asecSession.getJsonResult());
        }
        asecSessionModel.setResult(jSONObject.toJSONString());
        asecSessionModel.setState(2);
        com.up366.mobile.common.logic.Auth.cur().db().insertOrReplace(asecSessionModel);
        com.up366.common.log.Logger.info("TAG - SpeechAsyncHelper - score success : " + asecSessionModel.getRecordId());
    }

    private boolean doScore(com.up366.mobile.book.helper.recorder.AsecSessionModel asecSessionModel) throws java.lang.InterruptedException {
        asecSessionModel.setState(1);
        com.up366.mobile.common.logic.Auth.cur().db().update(asecSessionModel);
        return doScoreImpl(convertToAsesSession(asecSessionModel), asecSessionModel);
    }

    private boolean doScoreImpl(com.up366.asecengine.englishengine.AsecSession asecSession, final com.up366.mobile.book.helper.recorder.AsecSessionModel asecSessionModel) throws java.lang.Exception {
        final java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
        if (asecSession.getType() == 11) {
            com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync(asecSession.getWavPath(), com.up366.medialibrary.common.utils.MimeTypeUtils.MP3, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
            if (fileMapInfoSaveSync == null) {
                com.up366.common.log.Logger.error("TAG - SpeechAsyncHelper - saveSync - failed!");
                atomicBoolean.set(false);
            } else {
                com.up366.mobile.book.helper.recorder.RecordResultHelper.saveEngineLog(fileMapInfoSaveSync.getObjectId(), asecSession);
                com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                jSONObject.put("code", 0);
                jSONObject.put("recordId", asecSession.getRecordId());
                asecSession.setJsonResult("{}");
                jSONObject.put("score", 0);
                jSONObject.put("score100", 0);
                jSONObject.put("uploadURL", fileMapInfoSaveSync.getUrl());
                jSONObject.put("durationInMs", java.lang.Long.valueOf(asecSession.getDuration()));
                buildAndSaveResult(asecSession, jSONObject, asecSessionModel);
                atomicBoolean.set(true);
            }
            return atomicBoolean.get();
        }
        com.up366.mobile.book.helper.recorder.RecordResultHelper.checkIsAsesCrash(asecSession);
        if (!com.up366.common.FileUtilsUp.isFileExists(asecSession.getWavPath())) {
            com.up366.common.log.Logger.error("TAG - SpeechAsyncHelper - doScoreImpl - 未找到录音文件 " + asecSession);
            asecSessionModel.setState(3);
            asecSessionModel.setErrCount(asecSessionModel.getErrCount() + 1);
            com.up366.mobile.common.logic.Auth.cur().db().getAsecSessionModelDao().update(asecSessionModel);
            com.up366.mobile.common.logic.Auth.cur().db().delete(asecSessionModel);
            showFailedTipDialog(asecSession);
            atomicBoolean.set(false);
            return atomicBoolean.get();
        }
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        this.engineHelper.setOnStateChangeListener(new com.up366.asecengine.asecmgr.ISpeechStatCallBack() { // from class: com.up366.mobile.book.helper.recorder.SpeechAsyncHelper$$ExternalSyntheticLambda1
            @Override // com.up366.asecengine.asecmgr.ISpeechStatCallBack
            public final void onMediaStateResult(com.up366.asecengine.englishengine.AsecSession asecSession2, int i) {
                this.f$0.lambda$doScoreImpl$3(asecSessionModel, atomicBoolean, countDownLatch, asecSession2, i);
            }
        });
        this.engineHelper.startTestSession(asecSession);
        countDownLatch.await();
        com.up366.mobile.book.helper.recorder.RecordResultHelper.cleanCheckIsAsesCrashState();
        return atomicBoolean.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doScoreImpl$3(final com.up366.mobile.book.helper.recorder.AsecSessionModel asecSessionModel, final java.util.concurrent.atomic.AtomicBoolean atomicBoolean, final java.util.concurrent.CountDownLatch countDownLatch, final com.up366.asecengine.englishengine.AsecSession asecSession, final int i) {
        com.up366.common.log.Logger.info("TAG - SpeechAsyncHelper - onMediaStateResult:" + i);
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.recorder.SpeechAsyncHelper$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$doScoreImpl$2(i, asecSession, asecSessionModel, atomicBoolean, countDownLatch);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doScoreImpl$2(int i, com.up366.asecengine.englishengine.AsecSession asecSession, com.up366.mobile.book.helper.recorder.AsecSessionModel asecSessionModel, java.util.concurrent.atomic.AtomicBoolean atomicBoolean, java.util.concurrent.CountDownLatch countDownLatch) throws java.lang.Exception {
        com.alibaba.fastjson.JSONObject object;
        float floatValue;
        if (i == 0) {
            com.up366.mobile.book.helper.recorder.RecordResultHelper.updateRecordStart(asecSession);
        }
        if (i == -1) {
            com.up366.mobile.book.helper.recorder.RecordResultHelper.updateRecordOver(asecSession);
            if (asecSessionModel.getState() == 1) {
                asecSessionModel.setState(3);
                asecSessionModel.setErrCount(asecSessionModel.getErrCount() + 1);
                com.up366.mobile.common.logic.Auth.cur().db().getAsecSessionModelDao().update(asecSessionModel);
                showFailedTipDialog(asecSession);
            }
            atomicBoolean.set(false);
            countDownLatch.countDown();
            return;
        }
        if (i == 99) {
            com.up366.mobile.book.helper.recorder.RecordResultHelper.updateRecordOver(asecSession);
            com.up366.common.log.Logger.info("TAG - SpeechAsyncHelper - onMediaStateResult - RECORD_STATE_FORCE_OVER");
            atomicBoolean.set(false);
            countDownLatch.countDown();
            return;
        }
        if (i == 4) {
            int type = asecSession.getType();
            if (type == 3 || type == 4 || type == 5 || type == 6) {
                com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                float f = 0.0f;
                if (!com.up366.common.StringUtils.isEmptyOrNull(asecSession.getJsonResult())) {
                    try {
                        object = com.alibaba.fastjson.JSON.parseObject(asecSession.getJsonResult());
                        floatValue = object.getFloatValue("score");
                    } catch (java.lang.Exception e) {
                        e = e;
                    }
                    try {
                        if (object.getIntValue("isReject") != 1) {
                            f = floatValue;
                        }
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        f = floatValue;
                        com.up366.mobile.common.onlinelog.OpLog.report("ERROR_ASES_JSON_FORMAT", "session:" + asecSession);
                        com.up366.common.log.Logger.error("TAG - SpeechAsyncHelper - onMediaStateResult - json:" + asecSession.getJsonResult(), e);
                        com.up366.mobile.book.helper.recorder.RecordResultHelper.uploadEngineLog(asecSession);
                    }
                }
                java.lang.String strReplaceAll = asecSession.getHtmlResult().replaceAll("'", "\\'");
                com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync(asecSession.getWavPath(), com.up366.medialibrary.common.utils.MimeTypeUtils.MP3, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
                if (fileMapInfoSaveSync == null) {
                    com.up366.common.log.Logger.error("TAG - SpeechAsyncHelper - saveSync - failed!");
                    atomicBoolean.set(false);
                } else {
                    com.up366.mobile.book.helper.recorder.RecordResultHelper.saveEngineLog(fileMapInfoSaveSync.getObjectId(), asecSession);
                    jSONObject.put("code", 0);
                    jSONObject.put("recordId", asecSession.getRecordId());
                    jSONObject.put("result", strReplaceAll);
                    jSONObject.put("score", java.lang.Float.valueOf(f));
                    jSONObject.put("score100", java.lang.Float.valueOf(f));
                    jSONObject.put("uploadURL", fileMapInfoSaveSync.getUrl());
                    jSONObject.put("durationInMs", java.lang.Long.valueOf(asecSession.getDuration()));
                    buildAndSaveResult(asecSession, jSONObject, asecSessionModel);
                    atomicBoolean.set(true);
                }
                countDownLatch.countDown();
            }
        }
    }

    private void showFailedTipDialog(com.up366.asecengine.englishengine.AsecSession asecSession) {
        com.up366.common.log.Logger.error("TAG - SpeechAsyncHelper - showFailedTipDialog - session = [" + asecSession + "]");
        int code = asecSession.getCode();
        if (code != -5) {
            if (code != -3) {
                if (code == -1) {
                    showGlobalDialog("（AX02）评分资源加载失败。请联系助教老师");
                    return;
                } else {
                    showGlobalDialog("（AX03）未知错误。请重启设备，然后重新进入");
                    return;
                }
            }
            if (asecSession.getMessage() != null && asecSession.getMessage().contains("当前安装包不包含内置模型")) {
                showGlobalDialog("评分模型需要重新下载。\n请退出学习页后重新进入，以触发模型下载。");
                return;
            }
        }
        showGlobalDialog("（AX01）存储空间不足，无法完成评分。\n请退出，清理存储空间后重试。\n尽可能卸载不用的App；删除无用的图片和视频。");
    }

    private com.up366.asecengine.englishengine.AsecSession convertToAsesSession(com.up366.mobile.book.helper.recorder.AsecSessionModel asecSessionModel) {
        int type = asecSessionModel.getType();
        java.lang.String netFiles = asecSessionModel.getNetFiles();
        int type2 = asecSessionModel.getType();
        if (type2 == 0) {
            type = 3;
        } else if (type2 == 1) {
            type = 4;
        } else if (type2 == 2) {
            netFiles = com.up366.mobile.book.helper.recorder.SpeechRecordHelper.findPsdataDir(netFiles);
            type = 5;
        }
        int i = type;
        java.lang.String str = netFiles;
        if (i != asecSessionModel.getType()) {
            com.up366.common.log.Logger.info("TAG - SpeechAsyncHelper - convertToAsesSession - compat result : type:" + i + " net:" + str + " rawType:" + asecSessionModel.getType() + " rawNet:" + asecSessionModel.getNetFiles());
        }
        com.up366.asecengine.englishengine.AsecSession asecSession = new com.up366.asecengine.englishengine.AsecSession(asecSessionModel.getRecordId(), i, str, asecSessionModel.getWavPath(), false);
        asecSession.setDuration(asecSessionModel.getDuration());
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!com.up366.common.StringUtils.isEmptyOrNull(asecSessionModel.getParams())) {
            com.alibaba.fastjson.JSONArray array = com.alibaba.fastjson.JSON.parseArray(asecSessionModel.getParams());
            for (int i2 = 0; i2 < array.size(); i2++) {
                com.alibaba.fastjson.JSONObject jSONObject = array.getJSONObject(i2);
                arrayList.add(new com.up366.asecengine.model.KeyValue(jSONObject.getString("key"), jSONObject.getString("value")));
            }
            asecSession.setSessionParams(arrayList);
        }
        return asecSession;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    com.up366.mobile.book.helper.recorder.AsecSessionModel findScoreModel(java.lang.String r11) {
        /*
            r10 = this;
            boolean r0 = com.up366.common.StringUtils.isEmptyOrNull(r11)
            r1 = 2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L42
            com.up366.mobile.common.logic.Manager r0 = com.up366.mobile.common.logic.Auth.cur()
            com.up366.greendao.DaoSession r0 = r0.db()
            com.up366.greendao.AsecSessionModelDao r0 = r0.getAsecSessionModelDao()
            org.greenrobot.greendao.query.QueryBuilder r0 = r0.queryBuilder()
            org.greenrobot.greendao.Property r5 = com.up366.greendao.AsecSessionModelDao.Properties.RecordId
            org.greenrobot.greendao.query.WhereCondition r11 = r5.eq(r11)
            org.greenrobot.greendao.query.WhereCondition[] r5 = new org.greenrobot.greendao.query.WhereCondition[r3]
            org.greenrobot.greendao.Property r6 = com.up366.greendao.AsecSessionModelDao.Properties.State
            org.greenrobot.greendao.query.WhereCondition r6 = r6.notEq(r2)
            r5[r4] = r6
            org.greenrobot.greendao.query.QueryBuilder r11 = r0.where(r11, r5)
            java.util.List r11 = r11.list()
            int r0 = r11.size()
            if (r0 <= 0) goto L42
            java.lang.Object r11 = r11.get(r4)
            com.up366.mobile.book.helper.recorder.AsecSessionModel r11 = (com.up366.mobile.book.helper.recorder.AsecSessionModel) r11
            goto L43
        L42:
            r11 = 0
        L43:
            if (r11 != 0) goto L9c
            com.up366.mobile.common.logic.Manager r0 = com.up366.mobile.common.logic.Auth.cur()
            com.up366.greendao.DaoSession r0 = r0.db()
            com.up366.greendao.AsecSessionModelDao r0 = r0.getAsecSessionModelDao()
            org.greenrobot.greendao.query.QueryBuilder r0 = r0.queryBuilder()
            org.greenrobot.greendao.Property r5 = com.up366.greendao.AsecSessionModelDao.Properties.State
            org.greenrobot.greendao.query.WhereCondition r2 = r5.notEq(r2)
            org.greenrobot.greendao.query.WhereCondition[] r1 = new org.greenrobot.greendao.query.WhereCondition[r1]
            org.greenrobot.greendao.Property r5 = com.up366.greendao.AsecSessionModelDao.Properties.ErrCount
            r6 = 5
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            org.greenrobot.greendao.query.WhereCondition r5 = r5.lt(r6)
            r1[r4] = r5
            org.greenrobot.greendao.Property r5 = com.up366.greendao.AsecSessionModelDao.Properties.AddTime
            long r6 = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()
            r8 = 172800000(0xa4cb800, double:8.53745436E-316)
            long r6 = r6 - r8
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            org.greenrobot.greendao.query.WhereCondition r5 = r5.gt(r6)
            r1[r3] = r5
            org.greenrobot.greendao.query.QueryBuilder r0 = r0.where(r2, r1)
            org.greenrobot.greendao.Property[] r1 = new org.greenrobot.greendao.Property[r3]
            org.greenrobot.greendao.Property r2 = com.up366.greendao.AsecSessionModelDao.Properties.ErrCount
            r1[r4] = r2
            org.greenrobot.greendao.query.QueryBuilder r0 = r0.orderAsc(r1)
            java.util.List r0 = r0.list()
            int r1 = r0.size()
            if (r1 <= 0) goto L9c
            java.lang.Object r11 = r0.get(r4)
            com.up366.mobile.book.helper.recorder.AsecSessionModel r11 = (com.up366.mobile.book.helper.recorder.AsecSessionModel) r11
        L9c:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.helper.recorder.SpeechAsyncHelper.findScoreModel(java.lang.String):com.up366.mobile.book.helper.recorder.AsecSessionModel");
    }

    com.up366.mobile.book.helper.recorder.AsecSessionModel findByRecordId(java.lang.String str) {
        this.currentRecordId = str;
        java.util.List list = com.up366.mobile.common.logic.Auth.cur().db().getAsecSessionModelDao().queryBuilder().where(com.up366.greendao.AsecSessionModelDao.Properties.RecordId.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).list();
        if (list.size() == 0) {
            return null;
        }
        com.up366.mobile.book.helper.recorder.AsecSessionModel asecSessionModel = (com.up366.mobile.book.helper.recorder.AsecSessionModel) list.get(0);
        if (asecSessionModel != null && asecSessionModel.getState() != 2) {
            com.up366.common.log.Logger.info("TAG - SpeechAsyncHelper - re try scoring : " + str + " errorCount:" + asecSessionModel.getErrCount());
            notifyTask();
        }
        return asecSessionModel;
    }

    void deleteByRecordId(java.lang.String str) {
        com.up366.mobile.common.logic.Auth.cur().db().getAsecSessionModelDao().queryBuilder().where(com.up366.greendao.AsecSessionModelDao.Properties.RecordId.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).buildDelete().executeDeleteWithoutDetachingEntities();
    }
}
