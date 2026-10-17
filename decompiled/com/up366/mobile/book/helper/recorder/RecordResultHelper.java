package com.up366.mobile.book.helper.recorder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RecordResultHelper {
    private static final java.lang.String KEY_RECORD_LOG = "==KEY_RECORD_LOG==";
    private static final com.up366.common.task.TaskExecutor serialExecutor = com.up366.common.task.TaskUtils.createSerialExecutor("saveRecordResultToLog");

    static void saveEngineLog(final java.lang.String str, final com.up366.asecengine.englishengine.AsecSession asecSession) {
        com.up366.common.log.Logger.info("TAG - RecordResultHelper - saveEngineLog - objectId:" + str);
        updateRecordOver(asecSession);
        if (com.up366.mobile.common.compat.SpecialUserUtils.isOralTester()) {
            com.up366.mobile.common.compat.ZipOralDataToShareCompat.saveAnswer(asecSession);
        }
        serialExecutor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.recorder.RecordResultHelper$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.recorder.RecordResultHelper.lambda$saveEngineLog$2(asecSession, str);
            }
        });
    }

    static /* synthetic */ void lambda$saveEngineLog$2(com.up366.asecengine.englishengine.AsecSession asecSession, java.lang.String str) throws java.lang.Exception {
        java.lang.String wavPath = asecSession.getWavPath();
        java.lang.String netFiles = asecSession.getNetFiles();
        java.lang.String recordId = asecSession.getRecordId();
        long duration = asecSession.getDuration();
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(asecSession.getJsonResult());
        if (object == null) {
            object = new com.alibaba.fastjson.JSONObject();
            object.put("app_engine_error_code", java.lang.Integer.valueOf(asecSession.getEngineErrorCode()));
            object.put("app_engine_error_stack", asecSession.getEngineErrorStack());
        }
        com.alibaba.fastjson.JSONObject object2 = com.alibaba.fastjson.JSON.parseObject(asecSession.getWavCheckerJsonResult());
        object.put("app_time", java.lang.Long.valueOf(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()));
        object.put("app_wav", wavPath);
        object.put("app_net", netFiles);
        object.put("app_object_id", str);
        object.put("app_record_id", recordId);
        object.put("app_duration", java.lang.Long.valueOf(duration));
        object.put("app_engine_wavchecker", object2);
        java.lang.String recordBinPath = com.up366.mobile.common.utils.AppFileUtils.getRecordBinPath();
        byte[] bArrGzip = com.up366.common.ZipStringUtils.gzip(object.toJSONString().getBytes());
        com.up366.mobile.common.utils.AppFileUtils.saveBinaryFileRecord(recordBinPath, bArrGzip);
        com.up366.mobile.common.logic.Auth.cur().db1().saveOrUpdate(new com.up366.mobile.book.helper.recorder.RecordResultHistory(str, bArrGzip));
        com.up366.common.log.Logger.info("asesEngineLog - " + object.toJSONString());
        uploadRecordJson(object.toJSONString(), str);
        if (asecSession.getType() == 11) {
            return;
        }
        if (object.getBooleanValue("abnormal")) {
            com.up366.mobile.common.onlinelog.OpLog.report("speech-engine-error-abnormal-json", object.toJSONString());
            if (com.up366.common.NetworkUtilsUp.isWifiConnect()) {
                com.up366.mobile.common.logic.Auth.cur().fileMgr().save(getZipFile(asecSession.getWavPath(), asecSession.getNetFiles().split(com.igexin.push.core.b.an), asecSession.getJsonResult(), com.up366.asecengine.englishengine.AsesLogHelper.getLogFile(asecSession)), ".zip", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.book.helper.recorder.RecordResultHelper$$ExternalSyntheticLambda5
                    @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
                    public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                        com.up366.mobile.book.helper.recorder.RecordResultHelper.lambda$saveEngineLog$0(fileMapInfo);
                    }
                });
            }
        }
        if (asecSession.getEngineErrorCode() != 0) {
            com.up366.common.log.Logger.error("TAG - RecordResultHelper - saveEngineLog - session.getEngineErrorCode() = " + asecSession.getEngineErrorCode());
            com.up366.mobile.common.onlinelog.OpLog.record("speech-engine-error", "netType:" + com.up366.common.NetworkUtilsUp.getNetType());
            com.up366.mobile.common.onlinelog.OpLog.record("speech-engine-error", "EngineErrorCode:" + asecSession.getEngineErrorCode());
            if (com.up366.common.NetworkUtilsUp.isWifiConnect()) {
                com.up366.mobile.common.logic.Auth.cur().fileMgr().save(getZipFile(asecSession.getWavPath(), asecSession.getNetFiles().split(com.igexin.push.core.b.an), asecSession.getJsonResult()), ".zip", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.book.helper.recorder.RecordResultHelper$$ExternalSyntheticLambda6
                    @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
                    public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                        com.up366.mobile.book.helper.recorder.RecordResultHelper.lambda$saveEngineLog$1(fileMapInfo);
                    }
                });
            }
            com.up366.mobile.common.onlinelog.OpLog.report("speech-engine-error", object.toJSONString());
        }
        com.up366.asecengine.englishengine.AsesLogHelper.cleanLog(asecSession);
    }

    static /* synthetic */ void lambda$saveEngineLog$0(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        com.up366.mobile.common.onlinelog.OpLog.record("speech-engine-error-abnormal-file", "url:" + fileMapInfo.getUrl());
        uploadRecordFile("speech-engine-error-abnormal-file", fileMapInfo);
    }

    static /* synthetic */ void lambda$saveEngineLog$1(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        com.up366.mobile.common.onlinelog.OpLog.record("speech-engine-error", "url:" + fileMapInfo.getUrl());
        uploadRecordFile("speech-engine-error", fileMapInfo);
    }

    private static void uploadRecordJson(final java.lang.String str, final java.lang.String str2) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.recorder.RecordResultHelper$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.recorder.RecordResultHelper.lambda$uploadRecordJson$3(str, str2);
            }
        });
    }

    static /* synthetic */ void lambda$uploadRecordJson$3(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getAppInternalCacheDir(), com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() + "_" + com.up366.common.digest.MD5.md5(str));
        com.up366.common.FileUtilsUp.saveContentToFile(strJoin, str);
        java.lang.String str3 = str2 + ".json";
        if (!com.up366.common.FileUtilsUp.isFileExists(strJoin)) {
            com.up366.common.log.Logger.info("RecordResultHelper - uploadRecordJson - error tmpFilePath no exists " + str2);
            return;
        }
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync(strJoin, ".json", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, str3);
        if (fileMapInfoSaveSync == null) {
            com.up366.common.log.Logger.info("RecordResultHelper - uploadRecordJson - error fileMap is null " + str2);
        } else {
            com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(2, fileMapInfoSaveSync.getPath(), -1);
            batchUploadLog.addFile(new java.io.File(fileMapInfoSaveSync.getPath()), fileMapInfoSaveSync.getObjectId());
            com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
            com.up366.common.log.Logger.info("uploadRecordJson  : " + fileMapInfoSaveSync.getUrl());
        }
    }

    static class ASESLogHolder {
        public int engineErrorCode;
        public java.lang.String logFile;
        public java.lang.String net;
        public java.lang.String recordId;
        public long time;
        public int type;
        public java.lang.String wav;

        ASESLogHolder() {
        }
    }

    public static void updateRecordStart(com.up366.asecengine.englishengine.AsecSession asecSession) {
        com.up366.common.log.Logger.info("TAG - RecordResultHelper - updateRecordStart");
        com.up366.mobile.book.helper.recorder.RecordResultHelper.ASESLogHolder aSESLogHolder = new com.up366.mobile.book.helper.recorder.RecordResultHelper.ASESLogHolder();
        aSESLogHolder.recordId = asecSession.getRecordId();
        aSESLogHolder.wav = asecSession.getWavPath();
        aSESLogHolder.net = asecSession.getNetFiles();
        aSESLogHolder.type = asecSession.getType();
        aSESLogHolder.time = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        aSESLogHolder.logFile = com.up366.asecengine.englishengine.AsesLogHelper.getLogFile(asecSession);
        aSESLogHolder.engineErrorCode = asecSession.getEngineErrorCode();
        com.up366.mobile.common.utils.PreferenceUtils.putString(KEY_RECORD_LOG, com.alibaba.fastjson.JSON.toJSONString(aSESLogHolder));
    }

    public static void updateRecordOver(com.up366.asecengine.englishengine.AsecSession asecSession) {
        com.up366.common.log.Logger.info("TAG - RecordResultHelper - updateRecordOver");
        com.up366.mobile.common.utils.PreferenceUtils.putString(KEY_RECORD_LOG, "{}");
        if (asecSession.getEngineErrorCode() != 0) {
            com.up366.mobile.book.helper.recorder.RecordResultHelper.ASESLogHolder aSESLogHolder = new com.up366.mobile.book.helper.recorder.RecordResultHelper.ASESLogHolder();
            aSESLogHolder.recordId = asecSession.getRecordId();
            aSESLogHolder.wav = asecSession.getWavPath();
            aSESLogHolder.net = asecSession.getNetFiles();
            aSESLogHolder.type = asecSession.getType();
            aSESLogHolder.time = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
            aSESLogHolder.logFile = com.up366.asecengine.englishengine.AsesLogHelper.getLogFile(asecSession);
            aSESLogHolder.engineErrorCode = asecSession.getEngineErrorCode();
            uploadEngineLog(aSESLogHolder);
        }
    }

    public static void resetRecordLog() {
        com.up366.common.log.Logger.info("TAG - RecordResultHelper - resetRecordLog - ");
        com.up366.mobile.common.utils.PreferenceUtils.putString(KEY_RECORD_LOG, "{}");
    }

    public static void reportEngineError() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.recorder.RecordResultHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.recorder.RecordResultHelper.lambda$reportEngineError$5();
            }
        });
    }

    static /* synthetic */ void lambda$reportEngineError$5() throws java.lang.Exception {
        com.up366.asecengine.englishengine.AsesLogHelper.setLogDir(com.up366.mobile.common.utils.AppFileUtils.getLogPath());
        com.up366.common.FileUtilsUp.deleteDirOrFile(com.up366.common.FileUtilsUp.join(com.up366.asecengine.englishengine.AsesModelHelper.create().getModelDir(), "config/ases_log.conf"));
        java.lang.String string = com.up366.mobile.common.utils.PreferenceUtils.getString(KEY_RECORD_LOG, "{}");
        com.up366.mobile.book.helper.recorder.RecordResultHelper.ASESLogHolder aSESLogHolder = (com.up366.mobile.book.helper.recorder.RecordResultHelper.ASESLogHolder) com.alibaba.fastjson.JSON.parseObject(string, com.up366.mobile.book.helper.recorder.RecordResultHelper.ASESLogHolder.class);
        if (aSESLogHolder.time > 0) {
            com.up366.mobile.book.helper.Tools.alarmLogTrackContext.params = string;
            uploadEngineLog(aSESLogHolder);
            resetRecordLog();
        }
        com.up366.common.task.TaskUtils.postLazyTaskGlobal("clean engine log file", 1000, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.recorder.RecordResultHelper$$ExternalSyntheticLambda8
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.recorder.RecordResultHelper.lambda$reportEngineError$4();
            }
        });
    }

    static /* synthetic */ void lambda$reportEngineError$4() throws java.lang.Exception {
        java.util.List<java.lang.String> listListLogs = com.up366.asecengine.englishengine.AsesLogHelper.listLogs();
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        for (java.lang.String str : listListLogs) {
            if (new java.io.File(str).lastModified() + 432000000 < currentNtpTimeInMillisecond) {
                com.up366.common.FileUtilsUp.deleteDirOrFile(str);
            }
        }
    }

    static void uploadEngineLog(final com.up366.asecengine.englishengine.AsecSession asecSession) {
        serialExecutor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.recorder.RecordResultHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.recorder.RecordResultHelper.lambda$uploadEngineLog$7(asecSession);
            }
        });
    }

    static /* synthetic */ void lambda$uploadEngineLog$7(com.up366.asecengine.englishengine.AsecSession asecSession) throws java.lang.Exception {
        java.lang.String md5Str = asecSession.getMd5Str();
        java.lang.String wavPath = asecSession.getWavPath();
        java.lang.String netFiles = asecSession.getNetFiles();
        java.lang.String recordId = asecSession.getRecordId();
        long duration = asecSession.getDuration();
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(asecSession.getJsonResult());
        if (object == null) {
            object = new com.alibaba.fastjson.JSONObject();
            object.put("app_engine_error_code", java.lang.Integer.valueOf(asecSession.getEngineErrorCode()));
            object.put("app_engine_error_stack", asecSession.getEngineErrorStack());
        }
        object.put("app_time", java.lang.Long.valueOf(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()));
        object.put("app_md5", md5Str);
        object.put("app_wav", wavPath);
        object.put("app_net", netFiles);
        object.put("app_record_id", recordId);
        object.put("app_duration", java.lang.Long.valueOf(duration));
        com.up366.mobile.common.utils.AppFileUtils.saveBinaryFileRecord(com.up366.mobile.common.utils.AppFileUtils.getRecordBinPath(), com.up366.common.ZipStringUtils.gzip(object.toJSONString().getBytes()));
        if (asecSession.getType() == 11) {
            return;
        }
        com.up366.common.log.Logger.info("TAG - RecordResultHelper - uploadEngineLog - netType:" + com.up366.common.NetworkUtilsUp.getNetType());
        com.up366.mobile.common.onlinelog.OpLog.record("ENGINE_ERROR_RECORD", "netType:" + com.up366.common.NetworkUtilsUp.getNetType());
        com.up366.mobile.common.onlinelog.OpLog.record("ENGINE_ERROR_RECORD", "EngineErrorCode:" + asecSession.getEngineErrorCode());
        if (com.up366.common.NetworkUtilsUp.isWifiConnect()) {
            com.up366.mobile.common.logic.Auth.cur().fileMgr().save(getZipFile(asecSession.getWavPath(), asecSession.getNetFiles().split(com.igexin.push.core.b.an), asecSession.getJsonResult()), ".zip", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.book.helper.recorder.RecordResultHelper$$ExternalSyntheticLambda7
                @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
                public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                    com.up366.mobile.book.helper.recorder.RecordResultHelper.lambda$uploadEngineLog$6(fileMapInfo);
                }
            });
        }
        com.up366.mobile.common.onlinelog.OpLog.report("ENGINE_ERROR_RECORD", object.toJSONString());
    }

    static /* synthetic */ void lambda$uploadEngineLog$6(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        com.up366.mobile.common.onlinelog.OpLog.record("ENGINE_ERROR_RECORD", "url:" + fileMapInfo.getUrl());
        uploadRecordFile("ENGINE_ERROR_RECORD", fileMapInfo);
    }

    static void uploadEngineLog(final com.up366.mobile.book.helper.recorder.RecordResultHelper.ASESLogHolder aSESLogHolder) {
        if (aSESLogHolder.time < 1000) {
            return;
        }
        serialExecutor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.recorder.RecordResultHelper$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.recorder.RecordResultHelper.lambda$uploadEngineLog$8(aSESLogHolder);
            }
        });
    }

    static /* synthetic */ void lambda$uploadEngineLog$8(com.up366.mobile.book.helper.recorder.RecordResultHelper.ASESLogHolder aSESLogHolder) throws java.lang.Exception {
        java.lang.String str = aSESLogHolder.recordId;
        int i = aSESLogHolder.type;
        long j = aSESLogHolder.time;
        java.lang.String str2 = aSESLogHolder.wav;
        java.lang.String str3 = aSESLogHolder.net;
        java.lang.String str4 = aSESLogHolder.logFile;
        java.lang.String netType = com.up366.common.NetworkUtilsUp.getNetType();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("recordId", str);
        jSONObject.put("type", java.lang.Integer.valueOf(i));
        jSONObject.put("time", java.lang.Long.valueOf(j));
        jSONObject.put("wav", str2);
        jSONObject.put("net", str3);
        jSONObject.put("logFile", str4);
        jSONObject.put("netType", netType);
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync(getZipFile(str2, str3, str4, jSONObject.toJSONString()), ".zip", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
        jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, fileMapInfoSaveSync.getUrl());
        jSONObject.put(com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE, "ASES_ENGINE_ERROR_RECORD");
        jSONObject.put("engineVersion", com.up366.mobile.user.setting.VersionHelper.getAsesVersion());
        jSONObject.put("errorInfo", "error, errorCode:" + aSESLogHolder.engineErrorCode);
        com.up366.mobile.book.helper.Tools.alarmLogTrackContext.extData = jSONObject.toJSONString();
        com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004004008));
        uploadRecordFile(fileMapInfoSaveSync);
    }

    private static java.lang.String getZipFile(java.lang.String str, java.lang.String[] strArr, java.lang.String str2) throws java.lang.Throwable {
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getAppExternalCacheDir(), "ases", java.lang.String.valueOf(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() + java.lang.Math.random()));
        java.lang.String str3 = strJoin + ".zip";
        com.up366.common.FileUtilsUp.copyFileOrDir(str, com.up366.common.FileUtilsUp.join(strJoin, new java.io.File(str).getName()));
        for (java.lang.String str4 : strArr) {
            java.io.File file = new java.io.File(str4);
            com.up366.common.FileUtilsUp.copyFileOrDir(file, new java.io.File(com.up366.common.FileUtilsUp.join(strJoin, file.getName())));
        }
        com.up366.common.FileUtilsUp.saveContentToFile(com.up366.common.FileUtilsUp.join(strJoin, "result.json"), str2);
        if (com.up366.common.FileUtilsUp.zip(strJoin, str3)) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin);
        }
        return str3;
    }

    private static java.lang.String getZipFile(java.lang.String str, java.lang.String[] strArr, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getAppExternalCacheDir(), "ases", java.lang.String.valueOf(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() + java.lang.Math.random()));
        java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(strJoin, new java.io.File(str).getName());
        java.lang.String str4 = strJoin + ".zip";
        if (com.up366.common.FileUtilsUp.isFileExists(str3)) {
            com.up366.common.FileUtilsUp.copyFileOrDir(str3, com.up366.common.FileUtilsUp.join(strJoin, new java.io.File(str3).getName()));
        }
        com.up366.common.FileUtilsUp.copyFileOrDir(str, strJoin2);
        if (strArr.length > 0) {
            java.lang.String strJoin3 = com.up366.common.FileUtilsUp.join(strJoin, "net");
            java.lang.String str5 = strArr[0];
            if (com.up366.common.FileUtilsUp.isDir(str5)) {
                com.up366.common.FileUtilsUp.copyFileOrDir(str5, strJoin3);
            }
            if (com.up366.common.FileUtilsUp.isFile(str5)) {
                com.up366.common.FileUtilsUp.copyFileOrDir(new java.io.File(str5).getParent(), strJoin3);
            }
        }
        com.up366.common.FileUtilsUp.saveContentToFile(com.up366.common.FileUtilsUp.join(strJoin, "result.json"), str2);
        if (com.up366.common.FileUtilsUp.zip(strJoin, str4)) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin);
        }
        return str4;
    }

    private static java.lang.String getZipFile(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) throws java.lang.Throwable {
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getAppExternalCacheDir(), "ases", java.lang.String.valueOf(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() + java.lang.Math.random()));
        java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(strJoin, new java.io.File(str).getName());
        java.lang.String str5 = strJoin + ".zip";
        if (com.up366.common.FileUtilsUp.isFileExists(str3)) {
            com.up366.common.FileUtilsUp.copyFileOrDir(str3, com.up366.common.FileUtilsUp.join(strJoin, new java.io.File(str3).getName()));
        }
        com.up366.common.FileUtilsUp.copyFileOrDir(str, strJoin2);
        java.lang.String[] strArrSplit = str2.split(com.igexin.push.core.b.an);
        if (strArrSplit.length > 0) {
            java.lang.String strJoin3 = com.up366.common.FileUtilsUp.join(strJoin, "net");
            java.lang.String str6 = strArrSplit[0];
            if (com.up366.common.FileUtilsUp.isDir(str6)) {
                com.up366.common.FileUtilsUp.copyFileOrDir(str6, strJoin3);
            }
            if (com.up366.common.FileUtilsUp.isFile(str6)) {
                com.up366.common.FileUtilsUp.copyFileOrDir(new java.io.File(str6).getParent(), strJoin3);
            }
        }
        com.up366.common.FileUtilsUp.saveContentToFile(com.up366.common.FileUtilsUp.join(strJoin, "detail.json"), str4);
        if (com.up366.common.FileUtilsUp.zip(strJoin, str5)) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin);
        }
        return str5;
    }

    private static void uploadRecordFile(final java.lang.String str, final com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        com.up366.mobile.common.onlinelog.OpLog.record(str, "start: url:" + fileMapInfo.getUrl() + " zip:" + fileMapInfo.getPath() + " time:" + com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        com.up366.mobile.common.utils.alifile.AliFileMgrV2.uploadFile(fileMapInfo, new com.up366.mobile.common.utils.alifile.IOSSCallback() { // from class: com.up366.mobile.book.helper.recorder.RecordResultHelper.1
            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onProgress(long j, long j2) {
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onSuccess() {
                com.up366.mobile.common.onlinelog.OpLog.report(str, "success");
                com.up366.common.FileUtilsUp.deleteDirOrFile(fileMapInfo.getPath());
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onFailure(int i, java.lang.String str2) {
                com.up366.common.log.Logger.error("TAG - RecordResultHelper - onFailure - code = [" + i + "], info = [" + str2 + "] logKey:" + str);
                com.up366.mobile.common.onlinelog.OpLog.report(str, "error! code = [" + i + "], info = [" + str2 + "]");
                com.up366.common.FileUtilsUp.deleteDirOrFile(fileMapInfo.getPath());
            }
        });
    }

    private static void uploadRecordFile(final com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        com.up366.mobile.common.utils.alifile.AliFileMgrV2.uploadFile(fileMapInfo, new com.up366.mobile.common.utils.alifile.IOSSCallback() { // from class: com.up366.mobile.book.helper.recorder.RecordResultHelper.2
            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onProgress(long j, long j2) {
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onSuccess() {
                com.up366.common.FileUtilsUp.deleteDirOrFile(fileMapInfo.getPath());
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onFailure(int i, java.lang.String str) {
                com.up366.common.log.Logger.error("TAG - RecordResultHelper - onFailure - code = [" + i + "], info = [" + str + "]");
                com.up366.common.FileUtilsUp.deleteDirOrFile(fileMapInfo.getPath());
            }
        });
    }

    private static boolean uploadRecordFileSync(java.lang.String str, final com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) throws java.lang.InterruptedException {
        final java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        com.up366.mobile.common.utils.alifile.AliFileMgrV2.uploadFile(fileMapInfo, new com.up366.mobile.common.utils.alifile.IOSSCallback() { // from class: com.up366.mobile.book.helper.recorder.RecordResultHelper.3
            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onProgress(long j, long j2) {
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onSuccess() {
                com.up366.common.log.Logger.info("TAG - RecordResultHelper uploadRecordFileSync onSuccess url:" + fileMapInfo.getUrl());
                com.up366.common.FileUtilsUp.deleteDirOrFile(fileMapInfo.getPath());
                atomicBoolean.set(true);
                countDownLatch.countDown();
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onFailure(int i, java.lang.String str2) {
                com.up366.common.log.Logger.error("TAG - RecordResultHelper - onFailure - code = [" + i + "], info = [" + str2 + "] url:" + fileMapInfo.getUrl());
                com.up366.common.FileUtilsUp.deleteDirOrFile(fileMapInfo.getPath());
                countDownLatch.countDown();
            }
        });
        countDownLatch.await(30L, java.util.concurrent.TimeUnit.SECONDS);
        return atomicBoolean.get();
    }

    private static boolean uploadWavNet(com.up366.asecengine.englishengine.AsecSession asecSession) throws java.lang.Throwable {
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync(getZipFile(asecSession.getWavPath(), asecSession.getNetFiles().split(com.igexin.push.core.b.an), asecSession.getJsonResult(), com.up366.asecengine.englishengine.AsesLogHelper.getLogFile(asecSession)), ".zip", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("engineVersion", com.up366.mobile.user.setting.VersionHelper.getAsesVersion());
        jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, fileMapInfoSaveSync.getUrl());
        jSONObject.put("net", asecSession.getNetFiles());
        jSONObject.put("errorInfo", "crash, errorCode:" + asecSession.getEngineErrorCode());
        jSONObject.put(com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE, "speech-engine-error-crash");
        com.up366.mobile.book.helper.Tools.alarmLogTrackContext.extData = jSONObject.toJSONString();
        com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004004008));
        return uploadRecordFileSync("speech-engine-error-crash", fileMapInfoSaveSync);
    }

    public static void checkIsAsesCrash(com.up366.asecengine.englishengine.AsecSession asecSession) {
        try {
            java.lang.String recordId = asecSession.getRecordId();
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(com.up366.mobile.common.utils.PreferenceUtils.getString("ases_crash_state", "{}"));
            java.lang.String string = object.getString("recordId");
            int intValue = object.getIntValue("crashCount");
            long longValue = object.getLongValue("startTime");
            int i = intValue + 1;
            object.put("crashCount", java.lang.Integer.valueOf(i));
            object.put("startTime", java.lang.Long.valueOf(android.os.SystemClock.uptimeMillis()));
            object.put("recordId", recordId);
            com.up366.mobile.common.utils.PreferenceUtils.putString("ases_crash_state", object.toJSONString());
            if (i <= 10 && android.text.TextUtils.equals(recordId, string) && android.os.SystemClock.uptimeMillis() - longValue < com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MINUTE_5 && i > 1) {
                com.up366.common.log.Logger.error("TAG - RecordResultHelper - checkIsAsesCrash - find abort state:" + asecSession);
                if (!uploadWavNet(asecSession) || i <= 5) {
                    return;
                }
                java.lang.String wavPath = asecSession.getWavPath();
                com.up366.common.log.Logger.error("TAG - RecordResultHelper - checkIsAsesCrash - delete crash wav " + wavPath);
                com.up366.common.FileUtilsUp.deleteDirOrFile(wavPath);
                if (android.text.TextUtils.isEmpty(wavPath) || !wavPath.endsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.WAV)) {
                    return;
                }
                java.lang.String str = wavPath.substring(0, wavPath.length() - 4) + com.up366.medialibrary.common.utils.MimeTypeUtils.MP3;
                if (com.up366.common.FileUtilsUp.isFileExists(str)) {
                    com.up366.common.log.Logger.error("TAG - RecordResultHelper - checkIsAsesCrash - delete crash mp3 " + str);
                    com.up366.common.FileUtilsUp.deleteDirOrFile(str);
                }
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - RecordResultHelper - checkIsAsesCrash - ", e);
        }
    }

    public static void cleanCheckIsAsesCrashState() {
        com.up366.mobile.common.utils.PreferenceUtils.putString("ases_crash_state", "{}");
    }
}
