package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V7MuxAVHelper implements com.up366.mobile.book.helper.mux.IMuxAVHelper {
    public static final com.up366.common.task.TaskExecutor executor = com.up366.common.task.TaskUtils.createSerialExecutor("muxav");
    private final android.app.Activity context;
    private final com.up366.mobile.book.helper.V7ChapterDataHelper dataHelper;
    private final com.up366.mobile.book.model.CatalogPage page;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public V7MuxAVHelper(com.up366.mobile.book.StudyActivityInterface studyActivityInterface, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.helper.V7ChapterDataHelper v7ChapterDataHelper, com.up366.mobile.book.model.CatalogPage catalogPage) {
        this.context = studyActivityInterface.m1148getContext();
        this.webView = studyPageWebView;
        this.dataHelper = v7ChapterDataHelper;
        this.page = catalogPage;
    }

    @Override // com.up366.mobile.book.helper.mux.IMuxAVHelper
    public void mux(final java.lang.String str, final com.up366.mobile.book.helper.mux.IMuxCallback iMuxCallback) {
        executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V7MuxAVHelper$$ExternalSyntheticLambda0
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
            com.up366.mediamuxlibrary.CombineAVs.ParamHolder paramHolder = new com.up366.mediamuxlibrary.CombineAVs.ParamHolder();
            com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin);
            new java.io.File(strJoin).mkdirs();
            paramHolder.destDir = strJoin;
            if (!paramHolder.destDir.endsWith("/")) {
                paramHolder.destDir += "/";
            }
            paramHolder.video = com.up366.common.FileUtilsUp.join(this.webView.getCurrentDir(), object.getString(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_VIDEO));
            if (!com.up366.common.FileUtilsUp.isFile(paramHolder.video)) {
                throw new java.lang.IllegalStateException("缺少视频文件:" + paramHolder.video);
            }
            java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(this.webView.getCurrentDir(), object.getString("bgAudio"));
            if (!com.up366.common.FileUtilsUp.isFile(strJoin2)) {
                throw new java.lang.IllegalStateException("缺少音频文件:" + strJoin2);
            }
            paramHolder.destVideo = com.up366.common.FileUtilsUp.join(this.dataHelper.getChapterRootDataDir(this.page), this.page.obj.getId(), paramHolder.video.replaceFirst("^.*/", ""));
            paramHolder.audios.add(new com.up366.mediamuxlibrary.CombineAVs.AudioHolder(0L, 0L, strJoin2, null, 2));
            com.up366.common.FileUtilsUp.deleteDirOrFile(paramHolder.destVideo);
            com.alibaba.fastjson.JSONArray jSONArray = object.getJSONArray("audios");
            for (int i = 0; i < jSONArray.size(); i++) {
                java.lang.String string = ((com.alibaba.fastjson.JSONObject) jSONArray.get(i)).getString("recordId");
                java.lang.String strJoin3 = com.up366.common.StringUtils.isEmptyOrNull(string) ? null : com.up366.common.FileUtilsUp.join(this.dataHelper.getChapterRootDataDir(this.page), this.page.obj.getId(), string + com.up366.medialibrary.common.utils.MimeTypeUtils.WAV);
                paramHolder.audios.add(new com.up366.mediamuxlibrary.CombineAVs.AudioHolder(r5.getIntValue("startTime"), r5.getIntValue("endTime"), strJoin3, null, !com.up366.common.FileUtilsUp.isFileExists(strJoin3) ? 1 : 0));
            }
            long jUptimeMillis = android.os.SystemClock.uptimeMillis();
            new com.up366.mediamuxlibrary.CombineAVs().start(this.context, paramHolder);
            com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin);
            com.up366.common.log.Logger.info("TAG - V7MuxAVHelper - mux - 配音合成时长 used-time:" + (android.os.SystemClock.uptimeMillis() - jUptimeMillis));
            com.up366.mobile.common.logic.Auth.cur().fileMgr().save(paramHolder.destVideo, ".mp4", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_VIDEO, new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.book.helper.V7MuxAVHelper$$ExternalSyntheticLambda1
                @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
                public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                    com.up366.mobile.book.helper.V7MuxAVHelper.lambda$mux$0(str, iMuxCallback, fileMapInfo);
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
}
