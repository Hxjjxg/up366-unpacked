package com.up366.asecengine.englishengine;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class EngineV2Wrapper {
    private static final int ENGINE_ERROR_FAILED_NEW = 4;
    private static final int ENGINE_ERROR_FAILED_OPEN_FILE = 3;
    private static final java.lang.String TAG = "TAG - EngineV2Wrapper";
    private final com.up366.asecengine.jni.AsesJni asesJni;
    private final android.content.Context context;
    private java.lang.String engineId;
    private final com.up366.common.task.TaskExecutor executorEngine;

    EngineV2Wrapper(android.content.Context context, com.up366.asecengine.jni.AsesJni asesJni, com.up366.common.task.TaskExecutor taskExecutor) {
        this.context = context;
        this.asesJni = asesJni;
        this.executorEngine = taskExecutor;
    }

    public void setEngineParam(final java.util.List<com.up366.asecengine.model.KeyValue> list) {
        if (list == null) {
            return;
        }
        this.executorEngine.post(new com.up366.common.task.Task() { // from class: com.up366.asecengine.englishengine.EngineV2Wrapper.1
            @Override // com.up366.common.task.Task
            public void run() {
                if (!com.up366.asecengine.englishengine.EngineV2Wrapper.this.ensureEngineStarted(true, "setEngineParam")) {
                    com.up366.common.global.GB.get().sendLog("ASES-ERROR-engine-start-error-1", "评分引擎启动失败！");
                    throw new java.lang.IllegalStateException("评分引擎启动失败！");
                }
                for (com.up366.asecengine.model.KeyValue keyValue : list) {
                    int iLsxAsesSetParam = com.up366.asecengine.englishengine.EngineV2Wrapper.this.asesJni.LsxAsesSetParam(com.up366.asecengine.englishengine.EngineV2Wrapper.this.engineId, keyValue.key, keyValue.value);
                    com.up366.asecengine.englishengine.EngineV2Wrapper.this.asesJni.getEngineErrorCode();
                    com.up366.asecengine.englishengine.EngineV2Wrapper.this.asesJni.checkEngineState();
                    com.up366.common.log.Logger.info("TAG - EngineV2Wrapper - setEngineParam key:" + keyValue.key + " value:" + keyValue.value + " result:" + iLsxAsesSetParam);
                }
            }
        });
    }

    public void startRecord2(final com.up366.asecengine.englishengine.AsecSession asecSession) {
        this.executorEngine.post(new com.up366.common.task.Task() { // from class: com.up366.asecengine.englishengine.EngineV2Wrapper.2
            @Override // com.up366.common.task.Task
            public void run() {
                if (!com.up366.asecengine.englishengine.EngineV2Wrapper.this.ensureEngineStarted(true, "startRecord2")) {
                    com.up366.asecengine.englishengine.EngineV2Wrapper.this.failSessionForEngineInit(asecSession, "评分引擎启动失败！");
                    com.up366.common.global.GB.get().sendLog("ASES-ERROR-engine-start-error-2", "评分引擎启动失败！");
                    throw new java.lang.IllegalStateException(com.up366.asecengine.englishengine.EngineV2Wrapper.this.buildEngineFailureMessage("评分引擎启动失败！"));
                }
                int type = asecSession.getType();
                java.lang.String str = "netfile";
                java.lang.String str2 = "parta";
                if (type != 3) {
                    if (type == 4) {
                        str2 = "partb";
                    } else if (type == 5) {
                        str2 = "partc";
                        str = com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH;
                    } else if (type == 6) {
                        str2 = "ASR";
                        str = "";
                    } else if (type == 7) {
                        str = "spoken_ans";
                    }
                }
                java.lang.String strBeginSession = com.up366.asecengine.englishengine.EngineV2Wrapper.this.beginSession(str2, true, "startRecord2");
                if (com.up366.common.StringUtils.isEmptyOrNull(strBeginSession)) {
                    com.up366.asecengine.englishengine.EngineV2Wrapper.this.failSessionForEngineInit(asecSession, "评分引擎启动失败！-1");
                    throw new java.lang.IllegalStateException(com.up366.asecengine.englishengine.EngineV2Wrapper.this.buildEngineFailureMessage("评分引擎启动失败！-1"));
                }
                for (com.up366.asecengine.model.KeyValue keyValue : asecSession.getSessionParams()) {
                    int iLsxAsesSessionSetParam = com.up366.asecengine.englishengine.EngineV2Wrapper.this.asesJni.LsxAsesSessionSetParam(strBeginSession, keyValue.key, keyValue.value);
                    com.up366.asecengine.englishengine.EngineV2Wrapper.this.asesJni.getEngineErrorCode();
                    com.up366.asecengine.englishengine.EngineV2Wrapper.this.asesJni.checkEngineState();
                    if (iLsxAsesSessionSetParam != 0) {
                        com.up366.common.log.Logger.warn("TAG - EngineV2Wrapper - LsxAsesSessionSetParam key:" + keyValue.key + " value:" + keyValue.value + " result:" + iLsxAsesSessionSetParam);
                    }
                }
                if (asecSession.getType() == 7) {
                    com.up366.asecengine.englishengine.EngineV2Wrapper.this.loadParagraphData(asecSession, strBeginSession);
                } else if (asecSession.getType() != 6) {
                    com.up366.asecengine.englishengine.EngineV2Wrapper.this.loadNetData(asecSession, strBeginSession, com.up366.asecengine.englishengine.EngineV2Wrapper.this.getNetList(strBeginSession, asecSession), str);
                }
                com.up366.asecengine.englishengine.EngineV2Wrapper.this.startFile(asecSession, strBeginSession);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFile(com.up366.asecengine.englishengine.AsecSession asecSession, java.lang.String str) {
        java.io.File file = new java.io.File(asecSession.wavPath);
        if (!file.isFile()) {
            failFileSpeechIn(asecSession, str, -6, "WAV文件不存在：" + asecSession.wavPath, false);
            return;
        }
        com.up366.common.log.Logger.info("TAG - EngineV2Wrapper - startFile - wavPath=" + asecSession.wavPath + ", fileSize=" + file.length());
        int[] iArrLsxAsesSessionSpeechIn = this.asesJni.LsxAsesSessionSpeechIn(str, createNullTerminatedUtf8(asecSession.wavPath), 0, "wavfile");
        this.asesJni.checkEngineState();
        int engineErrorCode = (iArrLsxAsesSessionSpeechIn == null || iArrLsxAsesSessionSpeechIn.length <= 0) ? this.asesJni.getEngineErrorCode() : iArrLsxAsesSessionSpeechIn[0];
        if (engineErrorCode != 0) {
            failFileSpeechIn(asecSession, str, engineErrorCode, "文件评分读取WAV失败：" + this.asesJni.LsxAsesGetErrorInfo(engineErrorCode) + "(" + engineErrorCode + ")", true);
            return;
        }
        if (!asecSession.isCurrentSession()) {
            com.up366.asecengine.englishengine.AsesLogHelper.closeLog(this.asesJni, str);
            this.asesJni.LsxAsesSessionEnd(str);
            this.asesJni.checkEngineState();
            com.up366.asecengine.englishengine.AsesLogHelper.cleanLog(asecSession);
            return;
        }
        if (asecSession.isGiveUpScoring() || !asecSession.isLocalScoringEnabled()) {
            com.up366.asecengine.englishengine.AsesLogHelper.closeLog(this.asesJni, str);
            this.asesJni.LsxAsesSessionEnd(str);
            this.asesJni.checkEngineState();
            return;
        }
        asecSession.onRecordStateChange(3);
        java.lang.String strLsxAsesSessionGetResult = this.asesJni.LsxAsesSessionGetResult(str, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
        this.asesJni.checkEngineState();
        int engineErrorCode2 = this.asesJni.getEngineErrorCode();
        if (engineErrorCode2 != 0) {
            java.lang.String strLsxAsesGetErrorInfo = this.asesJni.LsxAsesGetErrorInfo(engineErrorCode2);
            com.up366.asecengine.englishengine.AsesLogHelper.closeLog(this.asesJni, str);
            asecSession.setError(engineErrorCode2);
            this.asesJni.LsxAsesSessionEnd(str);
            this.asesJni.checkEngineState();
            asecSession.destroy(-100, "评分失败：" + strLsxAsesGetErrorInfo + "(" + engineErrorCode2 + ")");
            return;
        }
        com.up366.asecengine.englishengine.AsesLogHelper.closeLog(this.asesJni, str);
        this.asesJni.LsxAsesSessionEnd(str);
        this.asesJni.checkEngineState();
        attachDefaultWavCheckerResult(asecSession);
        asecSession.setJsonResult(strLsxAsesSessionGetResult);
        asecSession.onRecordStateChange(4);
    }

    static byte[] createNullTerminatedUtf8(java.lang.String str) {
        byte[] bytes = str.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        return java.util.Arrays.copyOf(bytes, bytes.length + 1);
    }

    private void failFileSpeechIn(com.up366.asecengine.englishengine.AsecSession asecSession, java.lang.String str, int i, java.lang.String str2, boolean z) {
        com.up366.asecengine.englishengine.AsesLogHelper.closeLog(this.asesJni, str);
        if (z) {
            asecSession.setError(i);
        }
        this.asesJni.LsxAsesSessionEnd(str);
        this.asesJni.checkEngineState();
        if (z) {
            i = -100;
        }
        asecSession.destroy(i, str2);
    }

    public void startRecord(final com.up366.asecengine.englishengine.AsecSession asecSession) {
        this.executorEngine.post(new com.up366.common.task.Task() { // from class: com.up366.asecengine.englishengine.EngineV2Wrapper.3
            @Override // com.up366.common.task.Task
            public void run() {
                if (!com.up366.asecengine.englishengine.EngineV2Wrapper.this.ensureEngineStarted(true, "startRecord")) {
                    com.up366.asecengine.englishengine.EngineV2Wrapper.this.failSessionForEngineInit(asecSession, "评分引擎启动失败！");
                    com.up366.common.global.GB.get().sendLog("ASES-ERROR-engine-start-error-2", "评分引擎启动失败！");
                    throw new java.lang.IllegalStateException(com.up366.asecengine.englishengine.EngineV2Wrapper.this.buildEngineFailureMessage("评分引擎启动失败！"));
                }
                int type = asecSession.getType();
                java.lang.String str = "netfile";
                java.lang.String str2 = "parta";
                if (type != 3) {
                    if (type == 4) {
                        str2 = "partb";
                    } else if (type == 5) {
                        str2 = "partc";
                        str = com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH;
                    } else if (type == 6) {
                        str2 = "ASR";
                        str = "";
                    } else if (type == 7) {
                        str = "spoken_ans";
                    }
                }
                java.lang.String strBeginSession = com.up366.asecengine.englishengine.EngineV2Wrapper.this.beginSession(str2, true, "startRecord");
                if (com.up366.common.StringUtils.isEmptyOrNull(strBeginSession)) {
                    com.up366.asecengine.englishengine.EngineV2Wrapper.this.failSessionForEngineInit(asecSession, "评分引擎启动失败！-1");
                    throw new java.lang.IllegalStateException(com.up366.asecengine.englishengine.EngineV2Wrapper.this.buildEngineFailureMessage("评分引擎启动失败！-1"));
                }
                for (com.up366.asecengine.model.KeyValue keyValue : asecSession.getSessionParams()) {
                    int iLsxAsesSessionSetParam = com.up366.asecengine.englishengine.EngineV2Wrapper.this.asesJni.LsxAsesSessionSetParam(strBeginSession, keyValue.key, keyValue.value);
                    com.up366.asecengine.englishengine.EngineV2Wrapper.this.asesJni.getEngineErrorCode();
                    com.up366.asecengine.englishengine.EngineV2Wrapper.this.asesJni.checkEngineState();
                    if (iLsxAsesSessionSetParam != 0) {
                        com.up366.common.log.Logger.warn("TAG - EngineV2Wrapper - LsxAsesSessionSetParam key:" + keyValue.key + " value:" + keyValue.value + " result:" + iLsxAsesSessionSetParam);
                    }
                }
                if (asecSession.getType() == 7) {
                    com.up366.asecengine.englishengine.EngineV2Wrapper.this.loadParagraphData(asecSession, strBeginSession);
                } else if (asecSession.getType() != 6) {
                    com.up366.asecengine.englishengine.EngineV2Wrapper.this.loadNetData(asecSession, strBeginSession, com.up366.asecengine.englishengine.EngineV2Wrapper.this.getNetList(strBeginSession, asecSession), str);
                }
                com.up366.asecengine.englishengine.EngineV2Wrapper.this.startPushAudioStream(asecSession, strBeginSession);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPushAudioStream(com.up366.asecengine.englishengine.AsecSession asecSession, java.lang.String str) {
        while (asecSession.isCurrentSession()) {
            if (asecSession.state == 99) {
                com.up366.asecengine.englishengine.AsesLogHelper.closeLog(this.asesJni, str);
                com.up366.asecengine.englishengine.AsesLogHelper.cleanLog(asecSession);
                this.asesJni.LsxAsesSessionEnd(str);
                this.asesJni.checkEngineState();
                return;
            }
            if (asecSession.state == -1) {
                com.up366.asecengine.englishengine.AsesLogHelper.closeLog(this.asesJni, str);
                com.up366.asecengine.englishengine.AsesLogHelper.cleanLog(asecSession);
                this.asesJni.LsxAsesSessionEnd(str);
                this.asesJni.checkEngineState();
                return;
            }
            byte[] data = asecSession.readData();
            if (data == null) {
                if (asecSession.state == 2) {
                    if (!asecSession.isCurrentSession()) {
                        com.up366.asecengine.englishengine.AsesLogHelper.closeLog(this.asesJni, str);
                        this.asesJni.LsxAsesSessionEnd(str);
                        this.asesJni.checkEngineState();
                        com.up366.asecengine.englishengine.AsesLogHelper.cleanLog(asecSession);
                        return;
                    }
                    if (asecSession.isGiveUpScoring() || !asecSession.isLocalScoringEnabled()) {
                        com.up366.asecengine.englishengine.AsesLogHelper.closeLog(this.asesJni, str);
                        this.asesJni.LsxAsesSessionEnd(str);
                        this.asesJni.checkEngineState();
                        return;
                    }
                    asecSession.onRecordStateChange(3);
                    java.lang.String strLsxAsesSessionGetResult = this.asesJni.LsxAsesSessionGetResult(str, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
                    this.asesJni.checkEngineState();
                    int engineErrorCode = this.asesJni.getEngineErrorCode();
                    if (engineErrorCode != 0) {
                        java.lang.String strLsxAsesGetErrorInfo = this.asesJni.LsxAsesGetErrorInfo(engineErrorCode);
                        com.up366.asecengine.englishengine.AsesLogHelper.closeLog(this.asesJni, str);
                        asecSession.setError(engineErrorCode);
                        this.asesJni.LsxAsesSessionEnd(str);
                        this.asesJni.checkEngineState();
                        asecSession.destroy(-100, "评分失败：" + strLsxAsesGetErrorInfo + "(" + engineErrorCode + ")");
                        return;
                    }
                    com.up366.asecengine.englishengine.AsesLogHelper.closeLog(this.asesJni, str);
                    this.asesJni.LsxAsesSessionEnd(str);
                    this.asesJni.checkEngineState();
                    attachDefaultWavCheckerResult(asecSession);
                    asecSession.setJsonResult(strLsxAsesSessionGetResult);
                    asecSession.onRecordStateChange(4);
                    return;
                }
            } else {
                int[] iArrLsxAsesSessionSpeechIn = this.asesJni.LsxAsesSessionSpeechIn(str, data, data.length, "wav");
                this.asesJni.checkEngineState();
                int i = iArrLsxAsesSessionSpeechIn[1];
            }
        }
        com.up366.asecengine.englishengine.AsesLogHelper.closeLog(this.asesJni, str);
        com.up366.asecengine.englishengine.AsesLogHelper.cleanLog(asecSession);
        this.asesJni.LsxAsesSessionEnd(str);
        this.asesJni.checkEngineState();
    }

    public java.lang.String getNetText(java.util.List<java.lang.String> list) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str : list) {
            if (com.up366.common.FileUtilsUp.isFile(str)) {
                java.lang.String strLsxAsesVoasLoadNet = this.asesJni.LsxAsesVoasLoadNet(str.getBytes(), str.length(), "netfile");
                this.asesJni.checkEngineState();
                java.lang.String strLsxAsesVoasGetText = this.asesJni.LsxAsesVoasGetText(strLsxAsesVoasLoadNet);
                this.asesJni.checkEngineState();
                int iLsxAsesVoasUnLoadNet = this.asesJni.LsxAsesVoasUnLoadNet(strLsxAsesVoasLoadNet);
                this.asesJni.checkEngineState();
                com.up366.common.log.Logger.debug("TAG - EngineV2Wrapper - getNetText - " + iLsxAsesVoasUnLoadNet);
                sb.append(strLsxAsesVoasGetText);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNetData(com.up366.asecengine.englishengine.AsecSession asecSession, java.lang.String str, java.util.List<java.lang.String> list, java.lang.String str2) {
        for (int i = 0; i < list.size(); i++) {
            try {
                java.lang.String str3 = list.get(i);
                int iLsxAsesSessionDataIn = this.asesJni.LsxAsesSessionDataIn(str, str3, 0, str2);
                this.asesJni.checkEngineState();
                com.up366.common.log.Logger.info("Load net result: " + iLsxAsesSessionDataIn + " netFile:" + str3);
                if (iLsxAsesSessionDataIn != 0) {
                    throw new java.lang.IllegalStateException();
                }
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error(e.getMessage(), e);
                com.up366.asecengine.englishengine.AsesLogHelper.closeLog(this.asesJni, str);
                com.up366.asecengine.englishengine.AsesLogHelper.cleanLog(asecSession);
                this.asesJni.LsxAsesSessionEnd(str);
                this.asesJni.checkEngineState();
                asecSession.destroy(-1, "评分文件加载失败! - 2");
                throw new java.lang.IllegalStateException("评分文件加载失败! - 2");
            }
        }
        if (asecSession.getType() == 4 && list.size() > 0) {
            java.lang.String strJoin = com.up366.common.FileUtilsUp.join(new java.io.File(list.get(0)).getParent(), "psdata_partb/");
            if (com.up366.common.FileUtilsUp.isFileExists(strJoin)) {
                int iLsxAsesSessionDataIn2 = this.asesJni.LsxAsesSessionDataIn(str, strJoin, 0, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
                this.asesJni.checkEngineState();
                com.up366.common.log.Logger.info("TAG - EngineV2Wrapper - loadNetData - psdata_partb : " + iLsxAsesSessionDataIn2);
            }
        }
        if (asecSession.getType() != 3 || list.size() <= 0) {
            return;
        }
        java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(new java.io.File(list.get(0)).getParent(), "psdata/");
        if (com.up366.common.FileUtilsUp.isFileExists(strJoin2)) {
            int iLsxAsesSessionDataIn3 = this.asesJni.LsxAsesSessionDataIn(str, strJoin2, 0, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
            this.asesJni.checkEngineState();
            com.up366.common.log.Logger.info("TAG - EngineV2Wrapper - loadNetData - psdata : " + iLsxAsesSessionDataIn3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadParagraphData(com.up366.asecengine.englishengine.AsecSession asecSession, java.lang.String str) {
        java.lang.String sourceData;
        java.lang.String sourceDataType;
        try {
            com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig paragraphScoringConfig = asecSession.getParagraphScoringConfig();
            if (paragraphScoringConfig == null) {
                throw new java.lang.IllegalArgumentException("缺少段落评分配置");
            }
            paragraphScoringConfig.validate();
            validateParagraphPath("段落原始评分资源", paragraphScoringConfig.getSourceData(), paragraphScoringConfig.getSourceDataType());
            if (paragraphScoringConfig.getScope() == 1) {
                validateParagraphPath("段落子资源规则", paragraphScoringConfig.getRuleData(), paragraphScoringConfig.getRuleDataType());
            }
            if (paragraphScoringConfig.getScope() == 1) {
                sourceData = this.asesJni.LsxAsesSessionGetSubResource(str, paragraphScoringConfig.getSourceData(), paragraphScoringConfig.getSourceDataType(), paragraphScoringConfig.getRuleData(), paragraphScoringConfig.getRuleDataType());
                if (com.up366.common.StringUtils.isEmptyOrNull(sourceData)) {
                    throw new java.lang.IllegalStateException("段落子资源生成失败");
                }
                sourceDataType = com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_JSON;
            } else {
                sourceData = paragraphScoringConfig.getSourceData();
                sourceDataType = paragraphScoringConfig.getSourceDataType();
            }
            com.up366.asecengine.englishengine.EngineV2Wrapper.ParagraphDataInput paragraphDataInputCreateParagraphDataInput = createParagraphDataInput(sourceData, sourceDataType);
            int iLsxAsesSessionDataIn = this.asesJni.LsxAsesSessionDataIn(str, paragraphDataInputCreateParagraphDataInput.data, paragraphDataInputCreateParagraphDataInput.dataLength, paragraphDataInputCreateParagraphDataInput.params);
            this.asesJni.checkEngineState();
            com.up366.common.log.Logger.info("TAG - EngineV2Wrapper - loadParagraphData - scope=" + paragraphScoringConfig.getScope() + ", dataType=" + sourceDataType + ", dataLength=" + paragraphDataInputCreateParagraphDataInput.dataLength + ", result=" + iLsxAsesSessionDataIn);
            if (iLsxAsesSessionDataIn == 0) {
                return;
            }
            asecSession.setError(iLsxAsesSessionDataIn);
            throw new java.lang.IllegalStateException("段落评分资源加载失败，引擎错误码：" + iLsxAsesSessionDataIn);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - EngineV2Wrapper - loadParagraphData - " + e.getMessage(), e);
            com.up366.asecengine.englishengine.AsesLogHelper.closeLog(this.asesJni, str);
            com.up366.asecengine.englishengine.AsesLogHelper.cleanLog(asecSession);
            this.asesJni.LsxAsesSessionEnd(str);
            this.asesJni.checkEngineState();
            asecSession.destroy(-13, e.getMessage());
            throw new java.lang.IllegalStateException(e.getMessage(), e);
        }
    }

    static com.up366.asecengine.englishengine.EngineV2Wrapper.ParagraphDataInput createParagraphDataInput(java.lang.String str, java.lang.String str2) {
        if (com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_JSON.equals(str2)) {
            return new com.up366.asecengine.englishengine.EngineV2Wrapper.ParagraphDataInput(str, str.getBytes(java.nio.charset.StandardCharsets.UTF_8).length, "spoken_ans_buf");
        }
        return new com.up366.asecengine.englishengine.EngineV2Wrapper.ParagraphDataInput(str, 0, "spoken_ans");
    }

    static final class ParagraphDataInput {
        final java.lang.String data;
        final int dataLength;
        final java.lang.String params;

        ParagraphDataInput(java.lang.String str, int i, java.lang.String str2) {
            this.data = str;
            this.dataLength = i;
            this.params = str2;
        }
    }

    private void validateParagraphPath(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH.equals(str3)) {
            if (str2 == null || !new java.io.File(str2).isFile()) {
                throw new java.lang.IllegalArgumentException(str + "文件不存在：" + str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.util.List<java.lang.String> getNetList(java.lang.String str, com.up366.asecengine.englishengine.AsecSession asecSession) {
        if (asecSession.netFiles == null) {
            com.up366.asecengine.englishengine.AsesLogHelper.closeLog(this.asesJni, str);
            com.up366.asecengine.englishengine.AsesLogHelper.cleanLog(asecSession);
            this.asesJni.LsxAsesSessionEnd(str);
            this.asesJni.checkEngineState();
            asecSession.destroy(-1, "评分文件加载失败!");
            throw new java.lang.IllegalStateException("评分文件加载失败!");
        }
        java.lang.String[] strArrSplit = asecSession.netFiles.split(com.igexin.push.core.b.an);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < strArrSplit.length; i++) {
            java.lang.String str2 = strArrSplit[i];
            if (!com.up366.common.FileUtilsUp.isFileExists(str2)) {
                com.up366.asecengine.englishengine.AsesLogHelper.closeLog(this.asesJni, str);
                com.up366.asecengine.englishengine.AsesLogHelper.cleanLog(asecSession);
                this.asesJni.LsxAsesSessionEnd(str);
                this.asesJni.checkEngineState();
                asecSession.destroy(-1, "评分文件加载失败");
                throw new java.lang.IllegalStateException("评分文件加载失败 - " + i);
            }
            arrayList.add(str2);
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        com.up366.asecengine.englishengine.AsesLogHelper.closeLog(this.asesJni, str);
        com.up366.asecengine.englishengine.AsesLogHelper.cleanLog(asecSession);
        this.asesJni.LsxAsesSessionEnd(str);
        this.asesJni.checkEngineState();
        asecSession.destroy(-1, "评分文件加载失败");
        throw new java.lang.IllegalStateException("评分文件加载失败!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ensureEngineStarted(boolean z, java.lang.String str) {
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.engineId) || startEngine(str)) {
            return true;
        }
        if (!z) {
            return false;
        }
        if (!tryRepairModel(str + "-engine-start")) {
            return false;
        }
        return startEngine(str + "-retry");
    }

    private boolean startEngine(java.lang.String str) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String modelDir = com.up366.asecengine.englishengine.AsesModelHelper.create().getModelDir();
        long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
        java.lang.String strLsxAsesStart = this.asesJni.LsxAsesStart(modelDir);
        int engineErrorCode = this.asesJni.getEngineErrorCode();
        this.asesJni.checkEngineState();
        com.up366.common.log.Logger.info(str + " init and start engine over : timeLoad : " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + " timeStart : " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis2));
        if (engineErrorCode == 0 && !com.up366.common.StringUtils.isEmptyOrNull(strLsxAsesStart)) {
            this.engineId = strLsxAsesStart;
            return true;
        }
        com.up366.common.log.Logger.error("TAG - EngineV2Wrapper - startEngine - failed, stage=" + str + ", modelDir=" + modelDir + ", engineId=" + strLsxAsesStart + ", code=" + engineErrorCode + ", info=" + getEngineErrorInfo(engineErrorCode));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append("-cleanup");
        stopEngine(strLsxAsesStart, sb.toString());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String beginSession(java.lang.String str, boolean z, java.lang.String str2) {
        java.lang.String strBeginSessionInternal = beginSessionInternal(str, str2);
        if (!com.up366.common.StringUtils.isEmptyOrNull(strBeginSessionInternal)) {
            return strBeginSessionInternal;
        }
        if (z) {
            if (tryRepairModel(str2 + "-session-begin")) {
                if (!ensureEngineStarted(false, str2 + "-session-begin-retry")) {
                    return null;
                }
                return beginSessionInternal(str, str2 + "-session-begin-retry");
            }
        }
        stopEngine(this.engineId, str2 + "-session-begin-reset");
        return null;
    }

    private java.lang.String beginSessionInternal(java.lang.String str, java.lang.String str2) {
        java.lang.String strLsxAsesSessionBegin = this.asesJni.LsxAsesSessionBegin(this.engineId, str);
        int engineErrorCode = this.asesJni.getEngineErrorCode();
        this.asesJni.checkEngineState();
        if (engineErrorCode == 0 && !com.up366.common.StringUtils.isEmptyOrNull(strLsxAsesSessionBegin)) {
            return strLsxAsesSessionBegin;
        }
        com.up366.common.log.Logger.error("TAG - EngineV2Wrapper - beginSessionInternal - failed, stage=" + str2 + ", engineId=" + this.engineId + ", params=" + str + ", sessionId=" + strLsxAsesSessionBegin + ", code=" + engineErrorCode + ", info=" + getEngineErrorInfo(engineErrorCode));
        return null;
    }

    private boolean tryRepairModel(java.lang.String str) {
        int engineErrorCode = this.asesJni.getEngineErrorCode();
        java.lang.String engineErrorInfo = getEngineErrorInfo(engineErrorCode);
        if (!shouldRepairModel(engineErrorCode, engineErrorInfo)) {
            return false;
        }
        java.lang.String modelDir = com.up366.asecengine.englishengine.AsesModelHelper.create().getModelDir();
        com.up366.common.log.Logger.warn("TAG - EngineV2Wrapper - tryRepairModel - begin, stage=" + str + ", code=" + engineErrorCode + ", info=" + engineErrorInfo + ", modelDir=" + modelDir);
        java.lang.String str2 = this.engineId;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append("-before-repair");
        stopEngine(str2, sb.toString());
        if (!com.up366.asecengine.englishengine.OralModelHelper.hasBundledModel(this.context)) {
            com.up366.asecengine.englishengine.AsesModelHelper.create().invalidateModel();
            com.up366.common.log.Logger.warn("TAG - EngineV2Wrapper - tryRepairModel - skip restore, bundled model missing, stage=" + str + ", modelDir=" + modelDir + ", invalidate local check file for next download");
            return false;
        }
        boolean zRestoreModelDirFromAssets = com.up366.asecengine.englishengine.OralModelHelper.restoreModelDirFromAssets(this.context, modelDir);
        com.up366.common.log.Logger.info("TAG - EngineV2Wrapper - tryRepairModel - result=" + zRestoreModelDirFromAssets + ", stage=" + str + ", code=" + engineErrorCode + ", info=" + engineErrorInfo + ", modelDir=" + modelDir);
        return zRestoreModelDirFromAssets;
    }

    private boolean shouldRepairModel(int i, java.lang.String str) {
        if (i == 3 || i == 4) {
            return true;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return false;
        }
        return str.contains("Failed to open the file") || str.contains("Failed to new");
    }

    private void stopEngine(java.lang.String str, java.lang.String str2) {
        this.engineId = null;
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return;
        }
        try {
            this.asesJni.LsxAsesStop(str);
            this.asesJni.checkEngineState();
            com.up366.common.log.Logger.info("TAG - EngineV2Wrapper - stopEngine - success, stage=" + str2 + ", engineId=" + str);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - EngineV2Wrapper - stopEngine - failed, stage=" + str2 + ", engineId=" + str, e);
        }
    }

    private java.lang.String getEngineErrorInfo(int i) {
        if (i == 0) {
            return "";
        }
        try {
            return this.asesJni.LsxAsesGetErrorInfo(i);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - EngineV2Wrapper - getEngineErrorInfo - code=" + i, e);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failSessionForEngineInit(com.up366.asecengine.englishengine.AsecSession asecSession, java.lang.String str) {
        int engineErrorCode = this.asesJni.getEngineErrorCode();
        if (engineErrorCode != 0) {
            asecSession.setError(engineErrorCode);
        }
        asecSession.destroy(shouldRepairModel(engineErrorCode, getEngineErrorInfo(engineErrorCode)) ? -3 : -100, buildEngineFailureMessage(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String buildEngineFailureMessage(java.lang.String str) {
        java.lang.String str2;
        int engineErrorCode = this.asesJni.getEngineErrorCode();
        java.lang.String engineErrorInfo = getEngineErrorInfo(engineErrorCode);
        if (shouldRepairModel(engineErrorCode, engineErrorInfo) && !com.up366.asecengine.englishengine.OralModelHelper.hasBundledModel(this.context)) {
            if (com.up366.common.StringUtils.isEmptyOrNull(engineErrorInfo)) {
                str2 = "";
            } else {
                str2 = "，底层错误：" + engineErrorInfo + "(" + engineErrorCode + ")";
            }
            return str + "：当前安装包不包含内置模型，请退出学习页后重新进入以触发模型下载" + str2;
        }
        if (engineErrorCode == 0 || com.up366.common.StringUtils.isEmptyOrNull(engineErrorInfo)) {
            return str;
        }
        return str + "：" + engineErrorInfo + "(" + engineErrorCode + ")";
    }

    public void startRecordPart_No_Score(final com.up366.asecengine.englishengine.AsecSession asecSession) {
        this.executorEngine.post(new com.up366.common.task.Task() { // from class: com.up366.asecengine.englishengine.EngineV2Wrapper.4
            @Override // com.up366.common.task.Task
            public void run() throws java.lang.Exception {
                while (asecSession.isCurrentSession() && asecSession.state != 99) {
                    if (asecSession.state == 1 || asecSession.state == 2) {
                        asecSession.readData();
                        if (asecSession.isCurrentSession() && asecSession.state != 99) {
                            com.up366.asecengine.englishengine.EngineV2Wrapper.this.attachDefaultWavCheckerResult(asecSession);
                            asecSession.onRecordStateChange(4);
                            return;
                        }
                        return;
                    }
                    asecSession.readData();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attachDefaultWavCheckerResult(com.up366.asecengine.englishengine.AsecSession asecSession) {
        if (com.up366.common.StringUtils.isEmptyOrNull(asecSession.getWavCheckerJsonResult())) {
            asecSession.setWavCheckerJsonResult(com.up366.asecengine.englishengine.WavCheckerCompat.compat(null));
        }
    }

    public void startRecordWavConsumer(final com.up366.asecengine.englishengine.AsecSession asecSession) {
        this.executorEngine.post(new com.up366.common.task.Task() { // from class: com.up366.asecengine.englishengine.EngineV2Wrapper.5
            @Override // com.up366.common.task.Task
            public void run() {
                while (asecSession.isCurrentSession() && asecSession.state != 99) {
                    if (asecSession.state == 1 || asecSession.state == 2) {
                        asecSession.readData();
                        return;
                    }
                    asecSession.readData();
                }
            }
        });
    }
}
