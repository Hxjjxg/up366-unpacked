package com.up366.mobile.book.helper.recorder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SpeechRecordHelper {
    public static long endRecordTime;
    private com.up366.mobile.book.helper.recorder.SpeechRecordHelper.ICallBack callBack;
    private final android.content.Context context;
    private float scoreFactor;
    private final java.util.Map<java.lang.String, java.lang.Integer> cbTypeMap = new java.util.HashMap();
    private final com.up366.asecengine.asecmgr.ISpeechStatCallBack recordCallBack = new com.up366.mobile.book.helper.recorder.SpeechRecordHelper.AnonymousClass1();
    private final com.up366.mobile.book.helper.recorder.SpeechAsyncHelper speechAsyncHelper = com.up366.mobile.book.helper.recorder.SpeechAsyncHelper.getInstance();
    private final com.up366.asecengine.englishengine.AsecEngineHelper engineHelper = com.up366.asecengine.englishengine.AsecEngineHelper.create(com.up366.common.global.GB.get().getApplicationContext());

    public interface ICallBack {
        void onResult(com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder asecCallbackDataHolder);
    }

    /* JADX INFO: renamed from: com.up366.mobile.book.helper.recorder.SpeechRecordHelper$1, reason: invalid class name */
    class AnonymousClass1 implements com.up366.asecengine.asecmgr.ISpeechStatCallBack {
        AnonymousClass1() {
        }

        @Override // com.up366.asecengine.asecmgr.ISpeechStatCallBack
        public void onMediaStateResult(final com.up366.asecengine.englishengine.AsecSession asecSession, int i) {
            final com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder asecCallbackDataHolder = new com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder();
            asecCallbackDataHolder.recordName = asecSession.getRecordId();
            asecCallbackDataHolder.state = -1;
            asecCallbackDataHolder.rawState = i;
            asecCallbackDataHolder.result = "";
            asecCallbackDataHolder.score = 0.0f;
            asecCallbackDataHolder.score100 = 0.0f;
            asecCallbackDataHolder.recordUrl = "";
            asecCallbackDataHolder.duration = 0L;
            asecCallbackDataHolder.session = asecSession;
            if (asecSession.isAsync()) {
                if (i == -1) {
                    asecCallbackDataHolder.state = -1;
                    com.up366.mobile.book.helper.recorder.SpeechRecordHelper.this.callBack.onResult(asecCallbackDataHolder);
                } else if (i == 0) {
                    asecCallbackDataHolder.state = 0;
                    com.up366.mobile.book.helper.recorder.SpeechRecordHelper.this.callBack.onResult(asecCallbackDataHolder);
                } else if (i != 1) {
                    if (i == 2) {
                        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.recorder.SpeechRecordHelper$1$$ExternalSyntheticLambda0
                            @Override // com.up366.common.task.Task
                            public final void run() throws java.lang.Exception {
                                this.f$0.lambda$onMediaStateResult$0(asecSession, asecCallbackDataHolder);
                            }
                        });
                    } else if (i != 3 && i != 4) {
                        if (i == 99) {
                            asecCallbackDataHolder.state = 3;
                            com.up366.mobile.book.helper.recorder.SpeechRecordHelper.this.callBack.onResult(asecCallbackDataHolder);
                        } else {
                            com.up366.common.log.Logger.error("TAG - SpeechRecordHelper - onMediaStateResult - 未知状态 : " + i);
                        }
                    }
                }
            } else if (i == -1) {
                com.up366.mobile.book.helper.recorder.RecordResultHelper.updateRecordOver(asecSession);
                asecCallbackDataHolder.state = -1;
                com.up366.mobile.book.helper.recorder.SpeechRecordHelper.this.callBack.onResult(asecCallbackDataHolder);
            } else if (i == 0) {
                com.up366.mobile.book.helper.recorder.RecordResultHelper.updateRecordStart(asecSession);
                asecCallbackDataHolder.state = 0;
                com.up366.mobile.book.helper.recorder.SpeechRecordHelper.this.callBack.onResult(asecCallbackDataHolder);
            } else if (i == 1 || i == 2 || i == 3) {
                asecCallbackDataHolder.state = 1;
                com.up366.mobile.book.helper.recorder.SpeechRecordHelper.this.callBack.onResult(asecCallbackDataHolder);
            } else if (i == 4) {
                com.up366.mobile.book.helper.recorder.SpeechRecordHelper.this.handleStateRecordScoreOver(asecSession, 2, asecCallbackDataHolder);
            } else if (i == 99) {
                com.up366.mobile.book.helper.recorder.RecordResultHelper.updateRecordOver(asecSession);
                asecCallbackDataHolder.state = 3;
                com.up366.mobile.book.helper.recorder.SpeechRecordHelper.this.callBack.onResult(asecCallbackDataHolder);
            } else {
                com.up366.common.log.Logger.error("TAG - SpeechRecordHelper - onMediaStateResult - 未知状态 : " + i);
            }
            if (i == -1 && asecCallbackDataHolder.session.getCode() == -6) {
                com.up366.mobile.common.onlinelog.OpLog.report("ases_record_no_wav", asecSession.getRecordId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onMediaStateResult$0(com.up366.asecengine.englishengine.AsecSession asecSession, com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder asecCallbackDataHolder) throws java.lang.Exception {
            java.io.File file = new java.io.File(asecSession.getWavPath() + java.lang.Math.random() + com.up366.medialibrary.common.utils.MimeTypeUtils.WAV);
            com.up366.common.log.Logger.info("SpeechRecordHelper - onMediaStateResult - copy wav - wavFile:" + asecSession.getWavPath() + " destFile:" + file.getAbsolutePath());
            com.up366.common.FileUtilsUp.copyFileOrDir(new java.io.File(asecSession.getWavPath()), file);
            com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync(file.getPath(), com.up366.medialibrary.common.utils.MimeTypeUtils.MP3, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
            com.up366.mobile.book.helper.recorder.SpeechRecordHelper.this.speechAsyncHelper.addToAsecQueue(new com.up366.mobile.book.helper.recorder.AsecSessionModel(asecSession.getRecordId(), asecSession.getType(), asecSession.getNetFiles(), file.getPath(), asecSession.getDuration(), (java.lang.Integer) com.up366.mobile.book.helper.recorder.SpeechRecordHelper.this.cbTypeMap.get(asecSession.getRecordId()), asecSession.getSessionParams()));
            com.up366.mobile.book.helper.recorder.SpeechRecordHelper.this.cbTypeMap.remove(asecSession.getRecordId());
            asecCallbackDataHolder.state = 2;
            if (fileMapInfoSaveSync != null) {
                asecCallbackDataHolder.recordUrl = fileMapInfoSaveSync.getUrl();
            }
            com.up366.mobile.book.helper.recorder.SpeechRecordHelper.this.callBack.onResult(asecCallbackDataHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStateRecordScoreOver(final com.up366.asecengine.englishengine.AsecSession asecSession, final int i, final com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder asecCallbackDataHolder) {
        float score;
        java.lang.String result;
        com.up366.common.log.Logger.info("TAG - SpeechRecordHelper - onRecordTestResult - session ");
        int type = asecSession.getType();
        if (type != 3 && type != 4 && type != 5) {
            result = "";
            score = 0.0f;
        } else {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(asecSession.getJsonResult());
            com.up366.mobile.book.helper.recorder.ParseHtmlResultV2 parseHtmlResultV2Invoke = new com.up366.mobile.book.helper.recorder.ParseHtmlResultV2(asecSession, object.getFloatValue("score"), object.getIntValue("isReject") == 1).invoke();
            score = parseHtmlResultV2Invoke.getScore();
            result = parseHtmlResultV2Invoke.getResult();
        }
        final java.lang.String str = result;
        final float f = score;
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.recorder.SpeechRecordHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$handleStateRecordScoreOver$1(asecSession, asecCallbackDataHolder, i, str, f);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleStateRecordScoreOver$1(com.up366.asecengine.englishengine.AsecSession asecSession, final com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder asecCallbackDataHolder, int i, java.lang.String str, float f) throws java.lang.Exception {
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync(asecSession.getWavPath(), com.up366.medialibrary.common.utils.MimeTypeUtils.MP3, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
        com.up366.mobile.book.helper.recorder.RecordResultHelper.saveEngineLog(fileMapInfoSaveSync.getObjectId(), asecSession);
        this.cbTypeMap.remove(asecSession.getRecordId());
        asecCallbackDataHolder.recordName = asecSession.getRecordId();
        asecCallbackDataHolder.state = i;
        asecCallbackDataHolder.result = str;
        asecCallbackDataHolder.score = f;
        asecCallbackDataHolder.score100 = f;
        asecCallbackDataHolder.recordUrl = fileMapInfoSaveSync.getUrl();
        asecCallbackDataHolder.duration = asecSession.getDuration();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.recorder.SpeechRecordHelper$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$handleStateRecordScoreOver$0(asecCallbackDataHolder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleStateRecordScoreOver$0(com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder asecCallbackDataHolder) throws java.lang.Exception {
        this.callBack.onResult(asecCallbackDataHolder);
    }

    public SpeechRecordHelper(android.content.Context context) {
        this.context = context;
    }

    public void forceStopAll() {
        java.lang.String recordId = getRecordId();
        java.lang.Object obj = this.context;
        if (obj instanceof com.up366.mobile.book.StudyActivity) {
            if (android.text.TextUtils.equals(((com.up366.mobile.book.StudyActivity) obj).lastStartRecordId, recordId)) {
                this.engineHelper.forceStopAll();
                return;
            }
            return;
        }
        this.engineHelper.forceStopAll();
    }

    public int startRecord(java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.lang.String str4, com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener iFFTUpdateListener, com.up366.asecengine.englishengine.AsecEngineHelper.IWaveUpdateListener iWaveUpdateListener, boolean z, int i2, java.util.List<com.up366.asecengine.model.KeyValue> list, int i3, java.lang.String str5) {
        int i4 = (i == 1 && (android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.equals("undefined", str2))) ? 3 : i;
        this.cbTypeMap.put(str, java.lang.Integer.valueOf(i2));
        this.engineHelper.setOnFFTUpdateListener(iFFTUpdateListener);
        this.engineHelper.setWaveUpdateListener(iWaveUpdateListener);
        startRecord(str, str2, i4, str3, str4, z, list, i3);
        return 0;
    }

    private void startRecord(final java.lang.String str, final java.lang.String str2, final int i, final java.lang.String str3, final java.lang.String str4, boolean z, final java.util.List<com.up366.asecengine.model.KeyValue> list, final int i2) {
        final boolean z2 = !z;
        java.lang.Object obj = this.context;
        if (obj instanceof com.up366.mobile.book.StudyActivity) {
            ((com.up366.mobile.book.StudyActivity) obj).lastStartRecordId = str;
        }
        final androidx.core.util.Supplier supplier = new androidx.core.util.Supplier() { // from class: com.up366.mobile.book.helper.recorder.SpeechRecordHelper$$ExternalSyntheticLambda5
            public final java.lang.Object get() {
                return com.up366.mobile.book.helper.recorder.SpeechRecordHelper.lambda$startRecord$2(i);
            }
        };
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.recorder.SpeechRecordHelper$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$startRecord$5(str2, str4, i, str, supplier, list, str3, z2, i2);
            }
        });
    }

    static /* synthetic */ java.lang.Integer lambda$startRecord$2(int i) {
        if (i == 0) {
            return 3;
        }
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 5;
        }
        if (i == 3) {
            return 11;
        }
        if (i == 4) {
            return 6;
        }
        com.up366.mobile.common.onlinelog.OpLog.report("unhandle_record_type", "recordType:" + i);
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecord$5(java.lang.String str, java.lang.String str2, final int i, final java.lang.String str3, final androidx.core.util.Supplier supplier, final java.util.List list, final java.lang.String str4, final boolean z, final int i2) throws java.lang.Exception {
        com.up366.common.http.NetHolder<java.util.List<java.lang.String>> netHolderLoadNetFilesSync = loadNetFilesSync(str, str2, i);
        if (netHolderLoadNetFilesSync.resp.isError()) {
            com.up366.asecengine.englishengine.AsecSession asecSession = new com.up366.asecengine.englishengine.AsecSession(str3, ((java.lang.Integer) supplier.get()).intValue(), null, null, false);
            asecSession.setOnMediaStateChangeListener(this.recordCallBack);
            asecSession.destroy(-1, netHolderLoadNetFilesSync.resp.getInfo());
            return;
        }
        final java.util.List<java.lang.String> list2 = netHolderLoadNetFilesSync.info;
        if (!existsNetFile(list2, i)) {
            com.up366.asecengine.englishengine.AsecSession asecSession2 = new com.up366.asecengine.englishengine.AsecSession(str3, ((java.lang.Integer) supplier.get()).intValue(), null, null, false);
            asecSession2.setOnMediaStateChangeListener(this.recordCallBack);
            asecSession2.destroy(-1, "启动录音失败！！缺少必备文件");
            com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004004006));
            return;
        }
        if (!checkNetFileType(list2, i)) {
            com.up366.asecengine.englishengine.AsecSession asecSession3 = new com.up366.asecengine.englishengine.AsecSession(str3, ((java.lang.Integer) supplier.get()).intValue(), null, null, false);
            asecSession3.setOnMediaStateChangeListener(this.recordCallBack);
            asecSession3.destroy(-1, "启动录音失败！！net资源异常");
            com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004004007));
            return;
        }
        if (com.up366.common.FileUtilsUp.getExternalStoreAvailableSize() < 104857600) {
            com.up366.mobile.common.onlinelog.OpLog.report("口语录音", "启动录音时外部存储空间小于100M");
        }
        com.up366.mobile.common.utils.PermissionUtils.checkRecordPermission(this.context, "口语录音", new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.helper.recorder.SpeechRecordHelper$$ExternalSyntheticLambda7
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i3, java.lang.String str5) {
                this.f$0.lambda$startRecord$4(list2, i, str3, supplier, list, str4, z, i2, i3, str5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public /* synthetic */ void lambda$startRecord$4(java.util.List list, int i, java.lang.String str, androidx.core.util.Supplier supplier, java.util.List list2, java.lang.String str2, boolean z, int i2, int i3, java.lang.String str3) {
        int i4;
        int i5;
        if (i3 != 0) {
            com.up366.mobile.common.onlinelog.OpLog.report("口语录音", "拒绝麦克风权限：SpeechRecordHelper");
            new android.app.AlertDialog.Builder(this.context).setTitle("提示").setMessage(str3).setCancelable(false).setPositiveButton("确定", new android.content.DialogInterface.OnClickListener() { // from class: com.up366.mobile.book.helper.recorder.SpeechRecordHelper$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(android.content.DialogInterface dialogInterface, int i6) {
                    com.up366.common.global.GB.get().getCurrentActivity().finish();
                }
            }).show();
            return;
        }
        try {
            java.lang.String strJoin = android.text.TextUtils.join(com.igexin.push.core.b.an, list);
            if (i == 0) {
                i5 = 3;
            } else if (i == 1) {
                i5 = 4;
            } else {
                if (i == 2) {
                    i4 = 5;
                } else if (i == 3) {
                    i4 = 11;
                } else {
                    if (i != 4) {
                        com.up366.mobile.common.onlinelog.OpLog.report("口语录音", "recordType 错误：" + i);
                        new com.up366.asecengine.englishengine.AsecSession(str, ((java.lang.Integer) supplier.get()).intValue(), null, null, false).destroy(-100, "recordType 错误");
                        throw new java.lang.IllegalStateException("recordType 错误:" + i);
                    }
                    i4 = 6;
                }
                i5 = i4;
            }
            java.util.List arrayList = list2 == null ? new java.util.ArrayList() : list2;
            arrayList.add(new com.up366.asecengine.model.KeyValue("score_factor", java.lang.String.valueOf(this.scoreFactor)));
            this.engineHelper.startRecord(str, i5, strJoin, str2, z, 0, i2, arrayList);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error(e.getMessage(), e);
            com.up366.mobile.common.onlinelog.OpLog.report("口语录音", "启动录音失败：" + e.getMessage(), e);
            new com.up366.asecengine.englishengine.AsecSession(str, ((java.lang.Integer) supplier.get()).intValue(), null, null, false).destroy(-100, e.getMessage());
        }
    }

    private boolean checkNetFileType(java.util.List<java.lang.String> list, int i) {
        if (i == 0 || i == 1) {
            return com.up366.common.FileUtilsUp.isFile(list.get(0));
        }
        if (i == 2) {
            return com.up366.common.FileUtilsUp.isDir(list.get(0));
        }
        return true;
    }

    static java.lang.String findPsdataDir(java.lang.String str) {
        java.lang.String strSubstring = str.endsWith("/") ? str.substring(0, str.length() - 1) : str;
        if (strSubstring.endsWith("/net/psdata")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 7);
        }
        if (strSubstring.endsWith("/net/psdata_new")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 11);
        }
        java.lang.String str2 = strSubstring + "/psdata";
        java.lang.String str3 = strSubstring + "/psdata_new";
        if (com.up366.common.FileUtilsUp.isFileExists(str3)) {
            com.up366.mobile.common.onlinelog.OpLog.report("RECORD-check-dir-v2", str3);
            return str3;
        }
        if (com.up366.common.FileUtilsUp.isFileExists(str2)) {
            com.up366.mobile.common.onlinelog.OpLog.report("RECORD-check-dir-v1", str2);
            return str2;
        }
        if ("psdata".equals(new java.io.File(str).getName())) {
            com.up366.mobile.common.onlinelog.OpLog.report("RECORD-check-dir-name-v1", strSubstring);
        } else {
            com.up366.mobile.common.onlinelog.OpLog.report("RECORD-check-dir-name-v2", strSubstring);
        }
        return str;
    }

    private com.up366.common.http.NetHolder<java.util.List<java.lang.String>> loadNetFilesSync(java.lang.String str, java.lang.String str2, int i) throws java.lang.InterruptedException {
        final com.up366.common.http.Response response = new com.up366.common.http.Response(com.up366.common.http.Response.FAIL_NETWORK_TIME_OUT, "", "", 0, null);
        final com.up366.common.http.NetHolder<java.util.List<java.lang.String>> netHolder = new com.up366.common.http.NetHolder<>();
        netHolder.initWith(response, new java.util.ArrayList());
        boolean z = false;
        if (i == 3) {
            response.setCode(0);
            response.setInfo("success");
            netHolder.initWith(response, new java.util.ArrayList());
            return netHolder;
        }
        if (i == 4) {
            response.setCode(0);
            response.setInfo("success");
            netHolder.initWith(response, new java.util.ArrayList());
            return netHolder;
        }
        if (str.startsWith("http:") || str.startsWith("https:")) {
            java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.logic.Auth.cur().fileMgr().newCacheFile(), "nets");
            com.up366.mobile.common.utils.AppFileUtils.cleanOldFiles(strJoin);
            if (i == 2) {
                final java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(strJoin, com.up366.common.digest.MD5.md5(str) + "_psdata_new");
                com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin2);
                com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
                downloadInfo.setKey(str);
                downloadInfo.setFilePath(strJoin2);
                downloadInfo.setDownloadUrl(str);
                downloadInfo.setDownType(18);
                downloadInfo.setNeedUnzip(true);
                downloadInfo.setNeedCheck(false);
                final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
                com.up366.common.download.DownloadManager.getInstance().addDownload(downloadInfo, new com.up366.common.download.DownloadManager.IDownloadCallback() { // from class: com.up366.mobile.book.helper.recorder.SpeechRecordHelper$$ExternalSyntheticLambda2
                    @Override // com.up366.common.download.DownloadManager.IDownloadCallback
                    public final void onStateChange(java.lang.String str3, int i2, int i3, java.lang.String str4, long j, long j2, int i4, java.lang.String str5) {
                        com.up366.mobile.book.helper.recorder.SpeechRecordHelper.lambda$loadNetFilesSync$6(strJoin2, response, netHolder, countDownLatch, str3, i2, i3, str4, j, j2, i4, str5);
                    }
                });
                countDownLatch.await(1L, java.util.concurrent.TimeUnit.MINUTES);
                return netHolder;
            }
            java.lang.String[] strArrSplit = str.split(com.igexin.push.core.b.an);
            final java.util.concurrent.CountDownLatch countDownLatch2 = new java.util.concurrent.CountDownLatch(strArrSplit.length);
            final java.util.ArrayList arrayList = new java.util.ArrayList();
            final java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
            com.up366.common.download.DownloadManager.getInstance().setParallelDownloadSize(20);
            int length = strArrSplit.length;
            int i2 = 0;
            while (i2 < length) {
                java.lang.String str3 = strArrSplit[i2];
                java.lang.String strJoin3 = com.up366.common.FileUtilsUp.join(strJoin, com.up366.common.digest.MD5.md5(str3) + ".net");
                arrayList.add(strJoin3);
                com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin3);
                com.up366.common.download.DownloadInfo downloadInfo2 = new com.up366.common.download.DownloadInfo();
                downloadInfo2.setKey(str3);
                downloadInfo2.setFilePath(strJoin3);
                downloadInfo2.setDownloadUrl(str3);
                downloadInfo2.setDownType(19);
                downloadInfo2.setNeedUnzip(z);
                downloadInfo2.setNeedCheck(z);
                com.up366.common.download.DownloadManager.getInstance().addDownload(downloadInfo2, new com.up366.common.download.DownloadManager.IDownloadCallback() { // from class: com.up366.mobile.book.helper.recorder.SpeechRecordHelper$$ExternalSyntheticLambda3
                    @Override // com.up366.common.download.DownloadManager.IDownloadCallback
                    public final void onStateChange(java.lang.String str4, int i3, int i4, java.lang.String str5, long j, long j2, int i5, java.lang.String str6) {
                        com.up366.mobile.book.helper.recorder.SpeechRecordHelper.lambda$loadNetFilesSync$7(linkedHashSet, countDownLatch2, response, netHolder, arrayList, str4, i3, i4, str5, j, j2, i5, str6);
                    }
                });
                i2++;
                length = length;
                z = false;
            }
            countDownLatch2.await(1L, java.util.concurrent.TimeUnit.MINUTES);
            if (linkedHashSet.size() == strArrSplit.length) {
                com.up366.common.log.Logger.info("TAG - SpeechRecordHelper - loadNetFilesSync - success");
                response.setCode(0);
                response.setInfo("success");
                netHolder.initWith(response, arrayList);
            } else {
                com.up366.common.log.Logger.error("TAG - SpeechRecordHelper - loadNetFilesSync - failed size:" + linkedHashSet.size() + " length:" + strArrSplit.length);
            }
            com.up366.common.download.DownloadManager.getInstance().setParallelDownloadSize(2);
            return netHolder;
        }
        java.util.List<java.lang.String> listBuildLocalNetFileFullPath = buildLocalNetFileFullPath(str, str2, i);
        response.setCode(0);
        response.setInfo("success");
        netHolder.initWith(response, listBuildLocalNetFileFullPath);
        return netHolder;
    }

    static /* synthetic */ void lambda$loadNetFilesSync$6(java.lang.String str, com.up366.common.http.Response response, com.up366.common.http.NetHolder netHolder, java.util.concurrent.CountDownLatch countDownLatch, java.lang.String str2, int i, int i2, java.lang.String str3, long j, long j2, int i3, java.lang.String str4) {
        if (i == 4) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(str);
            response.setCode(0);
            response.setInfo("success");
            netHolder.initWith(response, arrayList);
            countDownLatch.countDown();
        }
        if (i == 6) {
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            response.setCode(-104);
            response.setInfo("cancel");
            netHolder.initWith(response, arrayList2);
            countDownLatch.countDown();
        }
        if (i == 5) {
            java.util.ArrayList arrayList3 = new java.util.ArrayList();
            response.setCode(i3);
            response.setInfo(str4);
            netHolder.initWith(response, arrayList3);
            countDownLatch.countDown();
        }
    }

    static /* synthetic */ void lambda$loadNetFilesSync$7(java.util.Set set, java.util.concurrent.CountDownLatch countDownLatch, com.up366.common.http.Response response, com.up366.common.http.NetHolder netHolder, java.util.List list, java.lang.String str, int i, int i2, java.lang.String str2, long j, long j2, int i3, java.lang.String str3) {
        if (i == 4 && !set.contains(str)) {
            set.add(str);
            countDownLatch.countDown();
        }
        if (i == 6) {
            response.setCode(-104);
            response.setInfo("cancel");
            netHolder.initWith(response, list);
            countDownLatch.countDown();
        }
        if (i == 5) {
            response.setCode(i3);
            response.setInfo(str3);
            netHolder.initWith(response, list);
            countDownLatch.countDown();
        }
    }

    private boolean existsNetFile(java.util.List<java.lang.String> list, int i) {
        return i == 3 || i == 4 || list.size() > 0;
    }

    private java.util.List<java.lang.String> buildLocalNetFileFullPath(java.lang.String str, java.lang.String str2, int i) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str) || "undefined".equals(str)) {
            str = "";
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (i == 3) {
            return arrayList;
        }
        java.lang.String[] strArrSplit = str.split(com.igexin.push.core.b.an);
        int length = strArrSplit.length;
        for (int i2 = 0; i2 < length; i2++) {
            java.lang.String strFindPsdataDir = strArrSplit[i2];
            java.lang.String strJoin = com.up366.common.FileUtilsUp.join(str2, strFindPsdataDir);
            if (!com.up366.common.FileUtilsUp.isFileExists(strFindPsdataDir)) {
                strFindPsdataDir = strJoin;
            }
            try {
                strFindPsdataDir = new java.io.File(strFindPsdataDir).getCanonicalPath();
            } catch (java.io.IOException e) {
                com.up366.common.log.Logger.error("TAG - SpeechRecordHelper - getNetFiles - ", e);
            }
            if (i == 2) {
                strFindPsdataDir = findPsdataDir(strFindPsdataDir);
            }
            if (i == 2 && com.up366.common.FileUtilsUp.isDir(strFindPsdataDir)) {
                arrayList.add(strFindPsdataDir);
            } else if ((i == 0 || i == 1) && com.up366.common.FileUtilsUp.isFile(strFindPsdataDir)) {
                arrayList.add(strFindPsdataDir);
            } else {
                com.up366.common.log.Logger.warn("net wen jian bu cun zai : " + strFindPsdataDir);
                com.up366.mobile.common.onlinelog.OpLog.report("缺少net文件", strFindPsdataDir);
                return new java.util.ArrayList();
            }
        }
        return arrayList;
    }

    public void endRecord(java.lang.String str) {
        endRecordTime = android.os.SystemClock.elapsedRealtime();
        this.engineHelper.endRecord(str);
        com.up366.common.log.Logger.info("endRecord id " + str + "  Time :" + java.lang.System.currentTimeMillis());
    }

    public void setCallBack(com.up366.mobile.book.helper.recorder.SpeechRecordHelper.ICallBack iCallBack) {
        this.callBack = iCallBack;
        this.engineHelper.setOnStateChangeListener(this.recordCallBack);
    }

    public boolean isRecord() {
        com.up366.asecengine.englishengine.AsecSession curSession = this.engineHelper.getCurSession();
        return curSession != null && curSession.isCurrentSession() && curSession.isRecord();
    }

    public java.lang.String getRecordId() {
        com.up366.asecengine.englishengine.AsecSession curSession = this.engineHelper.getCurSession();
        if (curSession == null || !curSession.isCurrentSession()) {
            return null;
        }
        return curSession.getRecordId();
    }

    public void setPartAScoreFactor(float f) {
        com.up366.common.log.Logger.info("TAG - SpeechRecordHelper - " + f);
        this.scoreFactor = f;
    }

    public com.up366.mobile.book.helper.recorder.AsecSessionModel findByRecordId(java.lang.String str) {
        return this.speechAsyncHelper.findByRecordId(str);
    }

    public void deleteByRecordId(java.lang.String str) {
        this.speechAsyncHelper.deleteByRecordId(str);
    }
}
