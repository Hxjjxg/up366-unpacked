package com.up366.mobile.book.exercise.js.v2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AudioHelperV2 {
    private static final int AUDIO_STATE_LOADING = 3;
    private com.up366.mobile.book.helper.CommonAudioHelper audioMgr;
    private final com.up366.mobile.book.exercise.js.PathHelper pathHelper;
    private final com.up366.mobile.book.exercise.js.v2.RegisterHelperV2 registerHelper;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    /* JADX INFO: Access modifiers changed from: private */
    public int convertAudioState(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i != 4) {
            return i != 9 ? -1 : 0;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.alibaba.fastjson.JSONObject buildJsonStatus(java.lang.String str, int i, int i2, int i3, java.lang.String str2, int i4) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.igexin.push.core.b.C, str);
        if (i4 == 1) {
            i = 4;
        }
        jSONObject.put("state", java.lang.Integer.valueOf(i));
        jSONObject.put("duration", java.lang.Integer.valueOf(i2));
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("code", java.lang.Integer.valueOf(i3));
        jSONObject2.put("msg", str2);
        jSONObject.put("errorInfo", jSONObject2);
        return jSONObject;
    }

    public AudioHelperV2(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.exercise.js.PathHelper pathHelper, com.up366.mobile.book.exercise.js.v2.RegisterHelperV2 registerHelperV2) {
        this.audioMgr = null;
        this.webView = studyPageWebView;
        this.pathHelper = pathHelper;
        this.registerHelper = registerHelperV2;
        this.audioMgr = new com.up366.mobile.book.helper.CommonAudioHelper(studyPageWebView.getContext());
    }

    public int playAudioWithParams(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final java.lang.String string = object.getString(com.igexin.push.core.b.C);
        java.lang.String string2 = object.getString(com.up366.qmui.skin.QMUISkinValueBuilder.SRC);
        int intValue = object.getIntValue("type");
        int intValue2 = object.getIntValue("seek");
        int intValue3 = object.getIntValue("fftStyle");
        int intValue4 = object.getIntValue("samplingRate");
        boolean booleanValue = object.getBooleanValue("autoDestroy");
        float floatValue = object.containsKey("rate") ? object.getFloatValue("rate") : 1.0f;
        boolean z = false;
        boolean z2 = intValue3 == 1;
        if (intValue3 == 2) {
            z2 = false;
            z = true;
        }
        com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder audioHolder = new com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder();
        audioHolder.audioId = string;
        audioHolder.isWAV = z;
        audioHolder.isFFT = z2;
        audioHolder.autoDestroy = booleanValue;
        audioHolder.samplingRate = intValue4;
        audioHolder.rate = floatValue;
        audioHolder.volume = 1.0f;
        audioHolder.seek = intValue2;
        audioHolder.callBack = getAudioCallBack();
        if (intValue == 1) {
            audioHolder.uri = new java.io.File(com.up366.common.FileUtilsUp.join(this.pathHelper.getCurrentPath(), string2)).toURI().toString();
        } else if (intValue == 2) {
            audioHolder.uri = new java.io.File(this.pathHelper.getVoiceRecordPath(string2)).toURI().toString();
        } else if (intValue == 3) {
            audioHolder.uri = audioHolder.convertUri(string2);
        } else if (intValue == 4) {
            if (!com.up366.common.FileUtilsUp.isFileExists(string2)) {
                com.up366.mobile.book.helper.Tools.alarmLogTrackContext.src = string2;
                com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004004001));
                com.up366.mobile.common.utils.ToastPopupUtil.show(this.webView, "音频文件不存在，不能播放。。。");
            } else {
                audioHolder.uri = new java.io.File(string2).toURI().toString();
            }
        } else if (intValue == 5) {
            audioHolder.uri = audioHolder.convertUri(com.up366.common.FileUtilsUp.join(this.pathHelper.getCurrentPath(), string2), string2, this.pathHelper.getVoiceRecordPath(string2), string2);
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.show(this.webView, "无法播放未知的音频类型：" + intValue);
        }
        audioHolder.onError = new com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder.IOnError() { // from class: com.up366.mobile.book.exercise.js.v2.AudioHelperV2$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder.IOnError
            public final void onError(java.lang.Exception exc) {
                this.f$0.lambda$playAudioWithParams$0(string, exc);
            }
        };
        this.audioMgr.play(audioHolder);
        return this.audioMgr.waitDuration(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playAudioWithParams$0(java.lang.String str, java.lang.Exception exc) {
        com.alibaba.fastjson.JSONObject jSONObjectBuildJsonStatus = buildJsonStatus(str, convertAudioState(-1), 0, -500, "(" + exc.getMessage() + ")", 0);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("AudioHelperV2 playAudioWithParams  audioMgr.setListener  status = ");
        sb.append(jSONObjectBuildJsonStatus.toJSONString());
        com.up366.common.log.Logger.info(sb.toString());
        this.registerHelper.callJsEvent("audiostatechange", "(%s)", jSONObjectBuildJsonStatus.toJSONString());
    }

    private com.up366.mobile.book.helper.ICommonAudioCallBack getAudioCallBack() {
        return new com.up366.mobile.book.helper.ICommonAudioCallBack() { // from class: com.up366.mobile.book.exercise.js.v2.AudioHelperV2.1
            @Override // com.up366.mobile.book.helper.ICommonAudioCallBack
            public void onWavUpdate(java.lang.String str, byte[] bArr) {
                if (com.up366.mobile.book.exercise.js.v2.AudioHelperV2.this.registerHelper.hasRegister("audiofftupdate")) {
                    int[] iArr = new int[bArr.length];
                    for (int i = 0; i < bArr.length; i++) {
                        iArr[i] = bArr[i];
                    }
                    com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                    jSONObject.put(com.igexin.push.core.b.C, str);
                    jSONObject.put("datas", iArr);
                    com.up366.mobile.book.exercise.js.v2.AudioHelperV2.this.registerHelper.callJsEvent("audiofftupdate", "(%s)", jSONObject.toJSONString());
                }
            }

            @Override // com.up366.mobile.book.helper.ICommonAudioCallBack
            public void onMediaStateResult(java.lang.String str, int i, int i2) {
                if (com.up366.mobile.book.exercise.js.v2.AudioHelperV2.this.registerHelper.hasRegister("audiostatechange")) {
                    if (i2 == 1) {
                        i = 3;
                    }
                    com.alibaba.fastjson.JSONObject jSONObjectBuildJsonStatus = com.up366.mobile.book.exercise.js.v2.AudioHelperV2.this.buildJsonStatus(str, com.up366.mobile.book.exercise.js.v2.AudioHelperV2.this.convertAudioState(i2 != 2 ? i : 3), com.up366.mobile.book.exercise.js.v2.AudioHelperV2.this.audioMgr.getDuration(str), 0, "", i2 > 0 ? 1 : 0);
                    com.up366.common.log.Logger.info("AudioHelperV2 audioCallBack  onMediaStateResult  status = " + jSONObjectBuildJsonStatus.toJSONString());
                    com.up366.mobile.book.exercise.js.v2.AudioHelperV2.this.registerHelper.callJsEvent("audiostatechange", "(%s)", jSONObjectBuildJsonStatus.toJSONString());
                }
            }
        };
    }

    public void pausePlayAudio(java.lang.String str) {
        this.audioMgr.pause(str);
    }

    public void resumePlayAudio(java.lang.String str) {
        this.audioMgr.resume(str);
    }

    public void stopPlayAudio(java.lang.String str) {
        this.audioMgr.stop(str);
    }

    public int getAudioCurrentTime(java.lang.String str) {
        return this.audioMgr.getCurrentTime(str);
    }

    public void seekPlayAudio(java.lang.String str, int i) {
        this.audioMgr.seek(str, i);
    }

    public void release() {
        this.audioMgr.release();
    }

    public void pauseAll() {
        this.audioMgr.pauseAll();
    }

    public void setRate(java.lang.String str, float f) {
        this.audioMgr.setRate(str, f);
    }

    public float getRate(java.lang.String str) {
        return this.audioMgr.getRate(str);
    }
}
