package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppResourceUpdateHelper {
    private static com.up366.mobile.common.helper.AppResourceUpdateHelper instance;
    boolean hasPrintLibVersions = false;
    private final com.up366.asecengine.englishengine.AsesModelHelper modelHelper = com.up366.asecengine.englishengine.AsesModelHelper.create();
    private final com.up366.common.task.TaskExecutor executor = com.up366.common.task.TaskUtils.createSerialExecutor("check-resource");

    private AppResourceUpdateHelper() {
    }

    public static com.up366.mobile.common.helper.AppResourceUpdateHelper getInstance() {
        com.up366.mobile.common.helper.AppResourceUpdateHelper appResourceUpdateHelper = instance;
        if (appResourceUpdateHelper != null) {
            return appResourceUpdateHelper;
        }
        com.up366.mobile.common.helper.AppResourceUpdateHelper appResourceUpdateHelper2 = new com.up366.mobile.common.helper.AppResourceUpdateHelper();
        instance = appResourceUpdateHelper2;
        return appResourceUpdateHelper2;
    }

    public boolean checkResourceAses() {
        return this.modelHelper.hasModel();
    }

    public boolean checkResourceXot() {
        return com.up366.mobile.book.exercise.ExerciseResourceHelper.isTestDir() || com.up366.mobile.book.exercise.ExerciseResourceHelper.isExistResource();
    }

    public boolean checkResourceDict() {
        return com.up366.mobile.book.dict.DictResourceHelper.isTestDir() || com.up366.mobile.book.dict.DictResourceHelper.isExistResource();
    }

    public boolean checkUpdateAses() {
        printLibVersions();
        com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> asesModelDownloadInfo = getAsesModelDownloadInfo();
        if (!asesModelDownloadInfo.resp.isError()) {
            return asesModelDownloadInfo.info != null && this.modelHelper.hasUpdate(asesModelDownloadInfo.info.getFileVersion());
        }
        com.up366.common.log.Logger.error("TAG - EngineResourceUpdateHelper - checkResources - error " + asesModelDownloadInfo.resp.toString());
        return false;
    }

    public com.up366.common.download.DownloadInfo fetchAsesModelDownloadInfoSync() {
        com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> asesModelDownloadInfo = getAsesModelDownloadInfo();
        if (asesModelDownloadInfo.resp.getCode() == -3 && getAsesModelVersion() == 0) {
            try {
                try {
                    com.up366.common.log.Logger.info("TAG - AppResourceUpdateHelper - fetchAsesModelDownloadInfoSync - try fetchAllSync");
                    com.up366.mobile.common.logic.Auth.cur().config().fetchAllSync();
                } catch (java.lang.InterruptedException e) {
                    com.up366.common.log.Logger.error("TAG - AppResourceUpdateHelper - fetchAsesModelDownloadInfoSync - ", e);
                }
            } finally {
                getAsesModelDownloadInfo();
            }
        }
        if (asesModelDownloadInfo.resp.isError()) {
            com.up366.common.log.Logger.error("TAG - EngineResourceUpdateHelper - checkResources - error " + asesModelDownloadInfo.resp.toString());
            com.up366.mobile.common.utils.ViewDataInvalidRecord.putCache("no-ases", 3000);
            return null;
        }
        if (asesModelDownloadInfo.info == null) {
            com.up366.mobile.common.utils.ViewDataInvalidRecord.putCache("no-ases", 3000);
            return null;
        }
        com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> diffAsesModelDownloadInfo = getDiffAsesModelDownloadInfo();
        if (diffAsesModelDownloadInfo.info != null) {
            com.up366.common.log.Logger.info("TAG- AppResourceUpdateHelper - fetchAsesModelDownloadInfoSync - diff info:" + diffAsesModelDownloadInfo.info);
            return diffAsesModelDownloadInfo.info;
        }
        return asesModelDownloadInfo.info;
    }

    public boolean checkUpdateXot() {
        if (com.up366.mobile.book.exercise.ExerciseResourceHelper.isTestDir()) {
            return false;
        }
        com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> xotEngineDownloadInfo = getXotEngineDownloadInfo();
        if (!xotEngineDownloadInfo.resp.isError()) {
            return xotEngineDownloadInfo.info != null && com.up366.mobile.book.exercise.ExerciseResourceHelper.hasUpdate(xotEngineDownloadInfo.info.getFileVersion());
        }
        com.up366.common.log.Logger.error("TAG - EngineResourceUpdateHelper - checkResources - error " + xotEngineDownloadInfo.resp.toString());
        return false;
    }

    public com.up366.common.download.DownloadInfo fetchXotEngineDownloadInfoSync() {
        com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> xotEngineDownloadInfo = getXotEngineDownloadInfo();
        if (xotEngineDownloadInfo.resp.isError()) {
            com.up366.common.log.Logger.error("TAG - EngineResourceUpdateHelper - checkResources - error " + xotEngineDownloadInfo.resp.toString());
            com.up366.mobile.common.utils.ViewDataInvalidRecord.putCache("no-xot", 3000);
            return null;
        }
        if (xotEngineDownloadInfo.info == null) {
            com.up366.mobile.common.utils.ViewDataInvalidRecord.putCache("no-xot", 3000);
            return null;
        }
        return xotEngineDownloadInfo.info;
    }

    public boolean checkUpdateDict() {
        if (com.up366.mobile.book.dict.DictResourceHelper.isTestDir()) {
            return false;
        }
        com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> dictModelDownloadInfo = getDictModelDownloadInfo();
        if (!dictModelDownloadInfo.resp.isError()) {
            return dictModelDownloadInfo.info != null && com.up366.mobile.book.dict.DictResourceHelper.hasUpdate(dictModelDownloadInfo.info.getFileVersion());
        }
        com.up366.common.log.Logger.error("TAG - EngineResourceUpdateHelper - checkResources - error " + dictModelDownloadInfo.resp.toString());
        return false;
    }

    public com.up366.common.download.DownloadInfo fetchDictModelDownloadInfoSync() {
        com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> dictModelDownloadInfo = getDictModelDownloadInfo();
        if (dictModelDownloadInfo.resp.isError()) {
            com.up366.common.log.Logger.error("TAG - EngineResourceUpdateHelper - checkResources - error " + dictModelDownloadInfo.resp.toString());
        }
        return dictModelDownloadInfo.info;
    }

    public boolean checkValidAses() {
        java.lang.String modelDir = this.modelHelper.getModelDir();
        boolean zValidSync = validSync(modelDir);
        if (zValidSync) {
            zValidSync = validFileByFilePathJson(modelDir);
        }
        if (!zValidSync) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(modelDir);
            com.up366.common.log.Logger.error("TAG - AppResourceUpdateHelper - checkValidAses - false");
        }
        return zValidSync;
    }

    private boolean validFileByFilePathJson(java.lang.String str) {
        boolean z = false;
        try {
            long jUptimeMillis = android.os.SystemClock.uptimeMillis();
            java.lang.String strJoin = com.up366.common.FileUtilsUp.join(str, "filePath.json");
            if (!com.up366.common.FileUtilsUp.isFileExists(strJoin)) {
                return true;
            }
            com.alibaba.fastjson.JSONArray array = com.alibaba.fastjson.JSON.parseArray(com.up366.common.FileUtilsUp.getFileContent(strJoin));
            int i = 0;
            while (i < array.size()) {
                com.alibaba.fastjson.JSONObject jSONObject = array.getJSONObject(i);
                java.lang.String string = jSONObject.getString(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
                long longValue = jSONObject.getLongValue("size");
                java.lang.String string2 = jSONObject.getString("md5");
                java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(str, string);
                if (!com.up366.common.FileUtilsUp.isFileExists(strJoin2)) {
                    com.up366.common.log.Logger.error("TAG - AppResourceUpdateHelper - validFileByFilePathJson - file not exists : file:" + strJoin2);
                    com.up366.mobile.common.onlinelog.OpLog.report("ases_valid_file_path_json_error", "file not exists : file:" + strJoin2);
                    return z;
                }
                java.io.File file = new java.io.File(strJoin2);
                long length = file.length();
                if (longValue != length) {
                    com.up366.common.log.Logger.error("TAG - AppResourceUpdateHelper - validFileByFilePathJson - file size is :" + length + " require:" + longValue + " file:" + strJoin2);
                    com.up366.mobile.common.onlinelog.OpLog.report("ases_valid_file_path_json_error", "file size is :" + length + " require:" + longValue + " file:" + strJoin2);
                    return false;
                }
                if (length < 512000) {
                    java.lang.String strMd5 = com.up366.common.digest.MD5.md5(file);
                    if (!strMd5.equalsIgnoreCase(string2)) {
                        com.up366.common.log.Logger.error("TAG - AppResourceUpdateHelper - validFileByFilePathJson - file md5 is :" + strMd5 + " require:" + string2 + " file:" + strJoin2);
                        com.up366.mobile.common.onlinelog.OpLog.report("ases_valid_file_path_json_error", "file md5 is :" + strMd5 + " require:" + string2 + " file:" + strJoin2);
                        return false;
                    }
                }
                i++;
                z = false;
            }
            com.up366.common.log.Logger.info("TAG - AppResourceUpdateHelper - validFileByFilePathJson - success : time : " + (android.os.SystemClock.uptimeMillis() - jUptimeMillis));
            return true;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - AppResourceUpdateHelper - validFileByFilePathJson - ", e);
            com.up366.mobile.common.onlinelog.OpLog.report("ases_valid_file_path_json_error", e.getMessage(), e);
            return false;
        }
    }

    public boolean checkValidXot() {
        if (com.up366.mobile.book.exercise.ExerciseResourceHelper.isTestDir()) {
            return true;
        }
        boolean zValidSync = validSync(com.up366.mobile.book.exercise.ExerciseResourceHelper.getExerciseRootDir());
        if (!zValidSync) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(com.up366.mobile.book.exercise.ExerciseResourceHelper.getExerciseRootDir());
        }
        return zValidSync;
    }

    public boolean checkValidDict() {
        if (com.up366.mobile.book.dict.DictResourceHelper.isTestDir()) {
            return true;
        }
        boolean zValidSync = validSync(com.up366.mobile.book.dict.DictResourceHelper.getDictRootDir());
        if (!zValidSync) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(com.up366.mobile.book.dict.DictResourceHelper.getDictRootDir());
        }
        return zValidSync;
    }

    public void post(final com.up366.common.task.Task task) {
        this.executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.helper.AppResourceUpdateHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.helper.AppResourceUpdateHelper.lambda$post$0(task);
            }
        });
    }

    static /* synthetic */ void lambda$post$0(com.up366.common.task.Task task) throws java.lang.Exception {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        task.run();
        com.up366.common.log.Logger.debug("count AppResourceUpdateHelper.post time : " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
    }

    public static int getAsesModelVersion() {
        try {
            com.up366.asecengine.englishengine.AsesModelHelper asesModelHelperCreate = com.up366.asecengine.englishengine.AsesModelHelper.create();
            java.lang.String strJoin = com.up366.common.FileUtilsUp.join(asesModelHelperCreate.getModelDir(), "config.json");
            if (com.up366.common.FileUtilsUp.isFileExists(strJoin) && asesModelHelperCreate.hasModel()) {
                return com.alibaba.fastjson.JSON.parseObject(com.up366.common.FileUtilsUp.getFileContent(strJoin)).getIntValue("versionNo");
            }
            return 0;
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    public static com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> getAsesModelDownloadInfo() {
        final com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.AppConfigLastVersion> modelMap = com.up366.mobile.common.logic.Auth.cur().config().getModelMap(com.up366.mobile.BuildConfig.ASES_MODEL, getAsesModelVersion());
        com.up366.asecengine.englishengine.AsesModelHelper asesModelHelperCreate = com.up366.asecengine.englishengine.AsesModelHelper.create();
        com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> netHolder = new com.up366.common.http.NetHolder<>();
        if (modelMap.resp.isError()) {
            if (modelMap.resp.getCode() == -3 && asesModelHelperCreate.hasModel()) {
                netHolder.initWith(new com.up366.common.http.Response(0, "", "", 0, null), null);
            } else {
                netHolder.initWith(modelMap.resp, null);
            }
        } else if (modelMap.info.getStatus() == 1 || !asesModelHelperCreate.hasModel()) {
            com.up366.common.download.DownloadInfo downloadInfo = asesModelHelperCreate.getDownloadInfo("ases-model", 15, java.lang.String.valueOf(modelMap.info.getVersion()), modelMap.info.getUrl(), modelMap.info.getApkMd5(), modelMap.info.getApkSize());
            netHolder.initWith(modelMap.resp, downloadInfo);
            com.up366.mobile.common.utils.FileDownloadRecord.add(downloadInfo.getKey(), new androidx.core.util.Consumer() { // from class: com.up366.mobile.common.helper.AppResourceUpdateHelper$$ExternalSyntheticLambda2
                public final void accept(java.lang.Object obj) {
                    ((com.alibaba.fastjson.JSONObject) obj).put("ases-model", ((com.up366.mobile.common.logic.model.AppConfigLastVersion) modelMap.info).getVersionName());
                }
            });
        } else {
            netHolder.initWith(modelMap.resp, null);
        }
        return netHolder;
    }

    public static com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> getDiffAsesModelDownloadInfo() {
        final com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.AppConfigLastVersion> modelMap = com.up366.mobile.common.logic.Auth.cur().config().getModelMap(com.up366.mobile.BuildConfig.ASES_MODEL, getAsesModelVersion());
        com.up366.asecengine.englishengine.AsesModelHelper asesModelHelperCreate = com.up366.asecengine.englishengine.AsesModelHelper.create();
        com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> netHolder = new com.up366.common.http.NetHolder<>();
        if (modelMap.resp.isError()) {
            if (modelMap.resp.getCode() == -3 && asesModelHelperCreate.hasModel()) {
                netHolder.initWith(new com.up366.common.http.Response(0, "", "", 0, null), null);
            } else {
                netHolder.initWith(modelMap.resp, null);
            }
        } else if (modelMap.info.getStatus() == 1 || !asesModelHelperCreate.hasModel()) {
            com.up366.mobile.common.logic.model.AppConfigLastVersion.DiffApkInfo diffApkInfo = modelMap.info.getDiffApkInfo();
            if (diffApkInfo == null) {
                netHolder.initWith(modelMap.resp, null);
                return netHolder;
            }
            com.up366.common.download.DownloadInfo downloadInfo = asesModelHelperCreate.getDownloadInfo("ases-model-diff", 17, java.lang.String.valueOf(modelMap.info.getVersion()), diffApkInfo.getUrl(), diffApkInfo.getApkMd5(), diffApkInfo.getApkSize());
            java.lang.String modelDir = asesModelHelperCreate.getModelDir();
            if (modelDir.endsWith("/")) {
                modelDir = modelDir.substring(0, modelDir.length() - 1);
            }
            downloadInfo.setFilePath(modelDir + "_diff");
            netHolder.initWith(modelMap.resp, downloadInfo);
            com.up366.mobile.common.utils.FileDownloadRecord.add(downloadInfo.getKey(), new androidx.core.util.Consumer() { // from class: com.up366.mobile.common.helper.AppResourceUpdateHelper$$ExternalSyntheticLambda0
                public final void accept(java.lang.Object obj) {
                    ((com.alibaba.fastjson.JSONObject) obj).put("ases-model-diff", ((com.up366.mobile.common.logic.model.AppConfigLastVersion) modelMap.info).getVersionName());
                }
            });
        } else {
            netHolder.initWith(modelMap.resp, null);
        }
        return netHolder;
    }

    public static com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> getXotEngineDownloadInfo() {
        com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.AppConfigLastVersion> modelMap = com.up366.mobile.common.logic.Auth.cur().config().getModelMap(com.up366.mobile.BuildConfig.EXERCISE_MODEL, com.up366.mobile.book.exercise.ExerciseResourceHelper.getVersionNo());
        com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> netHolder = new com.up366.common.http.NetHolder<>();
        if (modelMap.resp.isError()) {
            if (modelMap.resp.getCode() == -3 && com.up366.mobile.book.exercise.ExerciseResourceHelper.isExistResource()) {
                netHolder.initWith(new com.up366.common.http.Response(0, "", "", 0, null), null);
            } else {
                netHolder.initWith(modelMap.resp, null);
            }
        } else if (modelMap.info.getStatus() == 1 || !com.up366.mobile.book.exercise.ExerciseResourceHelper.isExistResource()) {
            netHolder.initWith(modelMap.resp, com.up366.mobile.book.exercise.ExerciseResourceHelper.getDownloadInfo("xot-resource", 14, java.lang.String.valueOf(modelMap.info.getVersion()), modelMap.info.getUrl(), modelMap.info.getApkMd5(), modelMap.info.getApkSize()));
        } else {
            netHolder.initWith(modelMap.resp, null);
        }
        return netHolder;
    }

    public static com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> getDictModelDownloadInfo() {
        com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.AppConfigLastVersion> modelMap = com.up366.mobile.common.logic.Auth.cur().config().getModelMap(com.up366.mobile.BuildConfig.DICT_MODEL, com.up366.mobile.book.dict.DictResourceHelper.getVersionNo());
        com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> netHolder = new com.up366.common.http.NetHolder<>();
        if (modelMap.resp.isError()) {
            if (modelMap.resp.getCode() == -3 && com.up366.mobile.book.dict.DictResourceHelper.isExistResource()) {
                netHolder.initWith(new com.up366.common.http.Response(0, "", "", 0, null), null);
            } else {
                com.up366.mobile.common.utils.ViewDataInvalidRecord.putCache("no-dict", 3000);
                netHolder.initWith(modelMap.resp, null);
            }
        } else if (modelMap.info.getStatus() == 1 || !com.up366.mobile.book.dict.DictResourceHelper.isExistResource()) {
            netHolder.initWith(modelMap.resp, com.up366.mobile.book.dict.DictResourceHelper.getDownloadInfo("dict-resource", 16, java.lang.String.valueOf(modelMap.info.getVersion()), modelMap.info.getUrl(), modelMap.info.getApkMd5(), modelMap.info.getApkSize()));
        } else {
            netHolder.initWith(modelMap.resp, null);
        }
        return netHolder;
    }

    private boolean validSync(java.lang.String str) {
        return com.up366.common.utils.EncryptUtil.valid(str);
    }

    public boolean isUpdateAsesModelByAssets() {
        int version;
        com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.AppConfigLastVersion> modelMap = com.up366.mobile.common.logic.Auth.cur().config().getModelMap(com.up366.mobile.BuildConfig.ASES_MODEL, getAsesModelVersion());
        if (modelMap.resp.isError()) {
            com.up366.common.log.Logger.error("TAG - AppResourceUpdateHelper - updateAsesByAssets - " + modelMap.resp);
            version = 0;
        } else {
            version = modelMap.info.getVersion();
        }
        int asesModelVersion = getAsesModelVersion();
        int asesModelVersionNo = com.up366.asecengine.englishengine.OralModelHelper.getAsesModelVersionNo(com.up366.common.global.GB.get().getApplicationContext());
        if (asesModelVersionNo <= asesModelVersion || asesModelVersionNo < version) {
            return false;
        }
        com.up366.common.log.Logger.info("TAG - AppResourceUpdateHelper - updateAsesByAssets - versionNumberAssets:" + asesModelVersionNo + " versionNumberLocal:" + asesModelVersion + " versionNumberUpdate:" + version);
        return true;
    }

    public boolean initAsesModelFromAssets() {
        int asesModelVersionNo = com.up366.asecengine.englishengine.OralModelHelper.getAsesModelVersionNo(com.up366.common.global.GB.get().getApplicationContext());
        return initAsesModelFromAssets(com.up366.asecengine.englishengine.AsesModelHelper.create().getModelDir(), asesModelVersionNo + "###202511");
    }

    public boolean initAsesModelFromAssets(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - AppResourceUpdateHelper - initAsesModelFromAssets - modelDir = [" + str + "], fileVersion = [" + str2 + "]");
        android.content.Context applicationContext = com.up366.common.global.GB.get().getApplicationContext();
        try {
            int i = java.lang.Integer.parseInt(str2.split("###")[0]);
            int asesModelVersionNo = com.up366.asecengine.englishengine.OralModelHelper.getAsesModelVersionNo(applicationContext);
            if (asesModelVersionNo < i) {
                com.up366.common.log.Logger.error("TAG - AppResourceUpdateHelper - initAsesModelFromAssets - versionNumberAssets(" + asesModelVersionNo + ") < versionNumberFromFileVersion(" + i + ")");
                return false;
            }
            java.lang.String strJoin = com.up366.common.FileUtilsUp.join(str, "tem.zip");
            com.up366.asecengine.englishengine.OralModelHelper.copyAssetsModel(applicationContext, strJoin);
            com.up366.common.download.UnzipEngine unzipEngine = new com.up366.common.download.UnzipEngine(str, str, strJoin, str2);
            final java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
            unzipEngine.setListener(new com.up366.common.download.IUnZipListener() { // from class: com.up366.mobile.common.helper.AppResourceUpdateHelper$$ExternalSyntheticLambda3
                @Override // com.up366.common.download.IUnZipListener
                public final void onUnzip(java.lang.String str3, int i2, int i3, int i4, int i5, java.lang.String str4) {
                    com.up366.mobile.common.helper.AppResourceUpdateHelper.lambda$initAsesModelFromAssets$3(atomicBoolean, str3, i2, i3, i4, i5, str4);
                }
            });
            unzipEngine.start();
            com.up366.common.log.Logger.info("TAG - AppResourceUpdateHelper - initAsesModelFromAssets - unzip result : " + atomicBoolean.get());
            return atomicBoolean.get();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - AppResourceUpdateHelper - initAsesModelFromAssets - ", e);
            return false;
        }
    }

    static /* synthetic */ void lambda$initAsesModelFromAssets$3(java.util.concurrent.atomic.AtomicBoolean atomicBoolean, java.lang.String str, int i, int i2, int i3, int i4, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - AppResourceUpdateHelper - initAsesModelFromAssets - unzip state : " + i);
        if (i != 0) {
            if (i == 1) {
                atomicBoolean.set(true);
            } else {
                if (i == 2) {
                    return;
                }
                throw new java.lang.IllegalStateException("un known state :" + i);
            }
        }
    }

    public void printLibVersions() {
        if (this.hasPrintLibVersions) {
            return;
        }
        this.hasPrintLibVersions = true;
        com.up366.common.log.Logger.info("LIB_VERSIONS : " + com.up366.mobile.user.setting.VersionHelper.getVersionInfo().replaceAll("\\n", " "));
    }
}
