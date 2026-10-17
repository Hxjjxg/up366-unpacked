package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V8MuxAVHelperV2 implements com.up366.mobile.book.helper.mux.IMuxAVHelper {
    public static final com.up366.common.task.TaskExecutor executor = com.up366.common.task.TaskUtils.createSerialExecutor("muxav");
    private final android.content.Context context;
    private final com.up366.mobile.book.helper.V8ResourceHelper dataHelper;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public V8MuxAVHelperV2(android.content.Context context, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.helper.V8ResourceHelper v8ResourceHelper) {
        this.context = context;
        this.webView = studyPageWebView;
        this.dataHelper = v8ResourceHelper;
    }

    @Override // com.up366.mobile.book.helper.mux.IMuxAVHelper
    public void mux(final java.lang.String str, final com.up366.mobile.book.helper.mux.IMuxCallback iMuxCallback) {
        executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V8MuxAVHelperV2$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$mux$1(str, iMuxCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mux$1(final java.lang.String str, final com.up366.mobile.book.helper.mux.IMuxCallback iMuxCallback) throws java.lang.Exception {
        com.up366.mobile.common.onlinelog.OpLog.report("配音合成-start", str);
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getCacheDir(), "av_tmp");
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
            java.lang.String string = object.getString("outPath");
            java.lang.String string2 = object.getString("bucketId");
            com.up366.mediamuxlibrary.CombineAVsOptimized.ParamHolder paramHolder = new com.up366.mediamuxlibrary.CombineAVsOptimized.ParamHolder();
            com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin);
            new java.io.File(strJoin).mkdirs();
            paramHolder.destDir = strJoin;
            if (!paramHolder.destDir.endsWith("/")) {
                paramHolder.destDir += "/";
            }
            paramHolder.video = object.getString(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_VIDEO);
            java.lang.String string3 = object.getString("bgAudio");
            if (!com.up366.common.FileUtilsUp.isFileExists(paramHolder.video)) {
                throw new java.lang.IllegalStateException("video not exists : " + paramHolder.video);
            }
            if (!com.up366.common.FileUtilsUp.isFileExists(string3)) {
                throw new java.lang.IllegalStateException("bg-audio not exists : " + string3);
            }
            paramHolder.destVideo = string;
            paramHolder.audios.add(new com.up366.mediamuxlibrary.CombineAVsOptimized.AudioHolder(0L, 0L, string3, null, 2));
            com.up366.common.FileUtilsUp.deleteDirOrFile(paramHolder.destVideo);
            com.alibaba.fastjson.JSONArray jSONArray = object.getJSONArray("audios");
            for (int i = 0; i < jSONArray.size(); i++) {
                java.lang.String string4 = ((com.alibaba.fastjson.JSONObject) jSONArray.get(i)).getString(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
                if (string4.startsWith("http")) {
                    string4 = downloadOnlineAudioSync(string4);
                }
                java.lang.String str2 = string4;
                paramHolder.audios.add(new com.up366.mediamuxlibrary.CombineAVsOptimized.AudioHolder(r5.getIntValue("startTime"), r5.getIntValue("endTime"), str2, null, !com.up366.common.FileUtilsUp.isFileExists(str2) ? 1 : 0));
            }
            long jUptimeMillis = android.os.SystemClock.uptimeMillis();
            new com.up366.mediamuxlibrary.CombineAVsOptimized().start(this.context, paramHolder);
            com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin);
            com.up366.common.log.Logger.info("TAG - V8MuxAVHelper - mux - 配音合成时长 used-time:" + (android.os.SystemClock.uptimeMillis() - jUptimeMillis));
            com.up366.mobile.common.logic.Auth.cur().fileMgr().save(paramHolder.destVideo, ".mp4", string2, new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.book.helper.V8MuxAVHelperV2$$ExternalSyntheticLambda0
                @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
                public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                    com.up366.mobile.book.helper.V8MuxAVHelperV2.lambda$mux$0(str, iMuxCallback, fileMapInfo);
                }
            });
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - MuxAVHelper - mux - ", e);
            com.up366.mobile.common.onlinelog.OpLog.report("配音合成-error", str, e);
            com.up366.mobile.book.helper.Tools.alarmLogTrackContext.msg = e.getMessage();
            com.up366.mobile.book.helper.Tools.alarmLogTrackContext.params = str;
            com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004005001));
            iMuxCallback.onResult(1, null, null);
            com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin);
        }
    }

    static /* synthetic */ void lambda$mux$0(java.lang.String str, com.up366.mobile.book.helper.mux.IMuxCallback iMuxCallback, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        com.up366.mobile.common.onlinelog.OpLog.report("配音合成-end", str);
        iMuxCallback.onResult(0, fileMapInfo.getPath(), fileMapInfo.getUrl());
    }

    private java.lang.String downloadOnlineAudioSync(java.lang.String str) throws java.lang.InterruptedException {
        java.lang.String strNewCacheFile = com.up366.mobile.common.logic.Auth.cur().fileMgr().newCacheFile(604800000L, com.up366.common.digest.MD5.md5(str));
        com.up366.common.log.Logger.info("TAG - V8MuxAVHelper - downloadOnlineAudioSync - url = [" + str + "], dst = [" + strNewCacheFile + "]");
        if (com.up366.common.FileUtilsUp.isFileExists(strNewCacheFile)) {
            return strNewCacheFile;
        }
        java.lang.String strConvertUri = convertUri(str);
        if (com.up366.common.FileUtilsUp.isFileExists(strConvertUri)) {
            return strConvertUri;
        }
        com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
        downloadInfo.setKey(str);
        downloadInfo.setFilePath(strConvertUri);
        downloadInfo.setDownloadUrl(str);
        downloadInfo.setDownType(23);
        downloadInfo.setNeedUnzip(false);
        downloadInfo.setNeedCheck(false);
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        com.up366.common.download.DownloadManager.getInstance().addDownload(downloadInfo, new com.up366.common.download.DownloadManager.IDownloadCallback() { // from class: com.up366.mobile.book.helper.V8MuxAVHelperV2$$ExternalSyntheticLambda2
            @Override // com.up366.common.download.DownloadManager.IDownloadCallback
            public final void onStateChange(java.lang.String str2, int i, int i2, java.lang.String str3, long j, long j2, int i3, java.lang.String str4) {
                com.up366.mobile.book.helper.V8MuxAVHelperV2.lambda$downloadOnlineAudioSync$2(countDownLatch, str2, i, i2, str3, j, j2, i3, str4);
            }
        });
        countDownLatch.await(1L, java.util.concurrent.TimeUnit.MINUTES);
        if (com.up366.common.FileUtilsUp.isFileExists(strConvertUri)) {
            return strConvertUri;
        }
        throw new java.lang.IllegalStateException("download audio failed!");
    }

    static /* synthetic */ void lambda$downloadOnlineAudioSync$2(java.util.concurrent.CountDownLatch countDownLatch, java.lang.String str, int i, int i2, java.lang.String str2, long j, long j2, int i3, java.lang.String str3) {
        if (i == 4) {
            countDownLatch.countDown();
        }
        if (i == 6) {
            countDownLatch.countDown();
        }
        if (i == 5) {
            countDownLatch.countDown();
        }
    }

    public static java.lang.String convertUri(java.lang.String str) {
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoLoadSync;
        if (!str.startsWith("http") || !str.contains("oss") || (fileMapInfoLoadSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().loadSync(str, null)) == null || !com.up366.common.FileUtilsUp.isFileExists(fileMapInfoLoadSync.getPath())) {
            return str;
        }
        com.up366.common.log.Logger.info("TAG - V8MuxAVHelper - convertUri - switch to local audio file - url:" + str + " path:" + fileMapInfoLoadSync.getPath());
        return new java.io.File(fileMapInfoLoadSync.getPath()).toURI().toString();
    }
}
