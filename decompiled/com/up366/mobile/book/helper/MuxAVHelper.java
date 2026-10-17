package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MuxAVHelper {
    private final com.up366.mobile.book.StudyActivity context;
    private final com.up366.mobile.book.helper.V6ChapterDataHelper dataHelper;
    private final com.up366.common.task.TaskExecutor executor = com.up366.mobile.book.helper.V7MuxAVHelper.executor;
    private final com.up366.mobile.book.model.CatalogPage page;
    private final com.up366.mobile.book.helper.V6RegisterHelper registerHelper;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public MuxAVHelper(com.up366.mobile.book.StudyActivity studyActivity, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.helper.V6ChapterDataHelper v6ChapterDataHelper, com.up366.mobile.book.model.CatalogPage catalogPage, com.up366.mobile.book.helper.V6RegisterHelper v6RegisterHelper) {
        this.context = studyActivity;
        this.webView = studyPageWebView;
        this.dataHelper = v6ChapterDataHelper;
        this.registerHelper = v6RegisterHelper;
        this.page = catalogPage;
    }

    public void mux(final java.lang.String str) {
        this.executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.MuxAVHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$mux$1(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v7, types: [boolean] */
    public /* synthetic */ void lambda$mux$1(final java.lang.String str) throws java.lang.Exception {
        java.lang.String strIsFile;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        com.alibaba.fastjson.JSONArray jSONArray;
        java.lang.String strJoin;
        int i;
        int intValue;
        long intValue2;
        java.lang.String str5 = str;
        java.lang.String str6 = com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH;
        java.lang.String str7 = "code";
        java.lang.String str8 = "";
        com.up366.mobile.common.onlinelog.OpLog.report("配音合成-start", str5);
        java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getCacheDir(), "av_tmp");
        final com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
            com.up366.mediamuxlibrary.CombineAVs.ParamHolder paramHolder = new com.up366.mediamuxlibrary.CombineAVs.ParamHolder();
            com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin2);
            new java.io.File(strJoin2).mkdirs();
            paramHolder.destDir = strJoin2;
            if (!paramHolder.destDir.endsWith("/")) {
                paramHolder.destDir += "/";
            }
            paramHolder.video = com.up366.common.FileUtilsUp.join(this.webView.getCurrentDir(), object.getString(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_VIDEO));
            java.lang.String strJoin3 = com.up366.common.FileUtilsUp.join(this.webView.getCurrentDir(), object.getString("bgAudio"));
            strIsFile = com.up366.common.FileUtilsUp.isFile(paramHolder.video);
            try {
                if (strIsFile == 0) {
                    throw new java.lang.IllegalStateException("缺少视频文件:" + paramHolder.video);
                }
                if (!com.up366.common.FileUtilsUp.isFile(strJoin3)) {
                    throw new java.lang.IllegalStateException("缺少音频文件:" + strJoin3);
                }
                paramHolder.destVideo = com.up366.common.FileUtilsUp.join(this.dataHelper.getChapterRootDataDir(this.page), this.page.obj.getId(), paramHolder.video.replaceFirst("^.*/", ""));
                paramHolder.audios.add(new com.up366.mediamuxlibrary.CombineAVs.AudioHolder(0L, 0L, strJoin3, null, 2));
                com.up366.common.FileUtilsUp.deleteDirOrFile(paramHolder.destVideo);
                com.alibaba.fastjson.JSONArray jSONArray2 = object.getJSONArray("audios");
                long jMax = 0;
                int i2 = 0;
                while (i2 < jSONArray2.size()) {
                    try {
                        com.alibaba.fastjson.JSONObject jSONObject2 = (com.alibaba.fastjson.JSONObject) jSONArray2.get(i2);
                        java.lang.String string = jSONObject2.getString("recordId");
                        if (com.up366.common.StringUtils.isEmptyOrNull(string)) {
                            jSONArray = jSONArray2;
                            str2 = str8;
                            strJoin = null;
                        } else {
                            try {
                                jSONArray = jSONArray2;
                                str2 = str8;
                            } catch (java.lang.Exception e) {
                                e = e;
                                str2 = str8;
                            }
                            try {
                                strJoin = com.up366.common.FileUtilsUp.join(this.dataHelper.getChapterRootDataDir(this.page), this.page.obj.getId(), string + com.up366.medialibrary.common.utils.MimeTypeUtils.WAV);
                            } catch (java.lang.Exception e2) {
                                e = e2;
                                strIsFile = str5;
                                str5 = str7;
                                com.up366.common.log.Logger.error("TAG - MuxAVHelper - mux - ", e);
                                com.up366.mobile.common.onlinelog.OpLog.report("配音合成-error", strIsFile, e);
                                com.up366.mobile.book.helper.Tools.alarmLogTrackContext.msg = e.getMessage();
                                com.up366.mobile.book.helper.Tools.alarmLogTrackContext.params = strIsFile;
                                com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004005001));
                                jSONObject.put(str5, 1);
                                java.lang.String str9 = str2;
                                jSONObject.put(str6, str9);
                                jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, str9);
                                this.registerHelper.callJsEvent(com.up366.mobile.book.helper.V6RegisterHelper.EVT_MIX_AUDIO_VIDEO, "(%s)", jSONObject.toJSONString());
                                com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin2);
                            }
                        }
                        java.lang.String str10 = strJoin;
                        try {
                            i = !com.up366.common.FileUtilsUp.isFileExists(str10) ? 1 : 0;
                            intValue = jSONObject2.getIntValue("startTime");
                            str3 = str6;
                            str4 = str7;
                            intValue2 = jSONObject2.getIntValue("endTime");
                        } catch (java.lang.Exception e3) {
                            e = e3;
                            str4 = str7;
                            strIsFile = str;
                            str5 = str4;
                            com.up366.common.log.Logger.error("TAG - MuxAVHelper - mux - ", e);
                            com.up366.mobile.common.onlinelog.OpLog.report("配音合成-error", strIsFile, e);
                            com.up366.mobile.book.helper.Tools.alarmLogTrackContext.msg = e.getMessage();
                            com.up366.mobile.book.helper.Tools.alarmLogTrackContext.params = strIsFile;
                            com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004005001));
                            jSONObject.put(str5, 1);
                            java.lang.String str92 = str2;
                            jSONObject.put(str6, str92);
                            jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, str92);
                            this.registerHelper.callJsEvent(com.up366.mobile.book.helper.V6RegisterHelper.EVT_MIX_AUDIO_VIDEO, "(%s)", jSONObject.toJSONString());
                            com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin2);
                        }
                        try {
                            paramHolder.audios.add(new com.up366.mediamuxlibrary.CombineAVs.AudioHolder(intValue, intValue2, str10, null, i));
                            jMax = java.lang.Math.max(jMax, intValue2);
                            i2++;
                            str5 = str;
                            str6 = str3;
                            jSONArray2 = jSONArray;
                            str8 = str2;
                            str7 = str4;
                        } catch (java.lang.Exception e4) {
                            e = e4;
                            strIsFile = str;
                            str6 = str3;
                            str5 = str4;
                            com.up366.common.log.Logger.error("TAG - MuxAVHelper - mux - ", e);
                            com.up366.mobile.common.onlinelog.OpLog.report("配音合成-error", strIsFile, e);
                            com.up366.mobile.book.helper.Tools.alarmLogTrackContext.msg = e.getMessage();
                            com.up366.mobile.book.helper.Tools.alarmLogTrackContext.params = strIsFile;
                            com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004005001));
                            jSONObject.put(str5, 1);
                            java.lang.String str922 = str2;
                            jSONObject.put(str6, str922);
                            jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, str922);
                            this.registerHelper.callJsEvent(com.up366.mobile.book.helper.V6RegisterHelper.EVT_MIX_AUDIO_VIDEO, "(%s)", jSONObject.toJSONString());
                            com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin2);
                        }
                    } catch (java.lang.Exception e5) {
                        e = e5;
                        str4 = str7;
                        str2 = str8;
                    }
                }
                str3 = str6;
                str4 = str7;
                str2 = str8;
                long jUptimeMillis = android.os.SystemClock.uptimeMillis();
                new com.up366.mediamuxlibrary.CombineAVs().start(this.context, paramHolder);
                com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin2);
                long jUptimeMillis2 = android.os.SystemClock.uptimeMillis() - jUptimeMillis;
                com.up366.mobile.common.onlinelog.OpLog.report("配音合成时长", "duration:" + jMax + ",used-time:" + jUptimeMillis2);
                com.up366.common.log.Logger.info("TAG - MuxAVHelper - mux - 配音合成时长 duration:" + jMax + ",used-time:" + jUptimeMillis2);
                str5 = str4;
                try {
                    jSONObject.put(str5, 0);
                    str6 = str3;
                    try {
                        jSONObject.put(str6, paramHolder.destVideo);
                        com.up366.mobile.common.logic.Auth.cur().fileMgr().save(paramHolder.destVideo, ".mp4", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_VIDEO, new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.book.helper.MuxAVHelper$$ExternalSyntheticLambda0
                            @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
                            public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                                this.f$0.lambda$mux$0(jSONObject, str, fileMapInfo);
                            }
                        });
                        return;
                    } catch (java.lang.Exception e6) {
                        e = e6;
                        strIsFile = str;
                    }
                } catch (java.lang.Exception e7) {
                    e = e7;
                    strIsFile = str;
                    str6 = str3;
                }
            } catch (java.lang.Exception e8) {
                e = e8;
            }
        } catch (java.lang.Exception e9) {
            e = e9;
            strIsFile = str5;
            str5 = str7;
            str2 = str8;
        }
        com.up366.common.log.Logger.error("TAG - MuxAVHelper - mux - ", e);
        com.up366.mobile.common.onlinelog.OpLog.report("配音合成-error", strIsFile, e);
        com.up366.mobile.book.helper.Tools.alarmLogTrackContext.msg = e.getMessage();
        com.up366.mobile.book.helper.Tools.alarmLogTrackContext.params = strIsFile;
        com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004005001));
        jSONObject.put(str5, 1);
        java.lang.String str9222 = str2;
        jSONObject.put(str6, str9222);
        jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, str9222);
        this.registerHelper.callJsEvent(com.up366.mobile.book.helper.V6RegisterHelper.EVT_MIX_AUDIO_VIDEO, "(%s)", jSONObject.toJSONString());
        com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mux$0(com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, fileMapInfo.getUrl());
        com.up366.mobile.common.onlinelog.OpLog.report("配音合成-end", str);
        this.registerHelper.callJsEvent(com.up366.mobile.book.helper.V6RegisterHelper.EVT_MIX_AUDIO_VIDEO, "(%s)", jSONObject.toJSONString());
    }
}
