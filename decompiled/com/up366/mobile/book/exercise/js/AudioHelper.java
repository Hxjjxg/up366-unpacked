package com.up366.mobile.book.exercise.js;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AudioHelper {
    private static final int AUDIO_STATE_LOADING = 3;
    private com.up366.mobile.book.helper.CommonAudioHelper audioMgr;
    private final com.up366.mobile.book.exercise.js.PathHelper pathHelper;
    private final com.up366.mobile.book.exercise.js.RegisterHelper registerHelper;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public AudioHelper(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.exercise.js.PathHelper pathHelper, com.up366.mobile.book.exercise.js.RegisterHelper registerHelper) {
        this.audioMgr = null;
        this.webView = studyPageWebView;
        this.pathHelper = pathHelper;
        this.registerHelper = registerHelper;
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
        int intValue5 = object.getIntValue("autoDestroy");
        float floatValue = object.containsKey("rate") ? object.getFloatValue("rate") : 1.0f;
        boolean z = false;
        boolean z2 = intValue5 == 1;
        boolean z3 = intValue3 == 1;
        if (intValue3 == 2) {
            z3 = false;
            z = true;
        }
        final com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder audioHolder = new com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder();
        audioHolder.audioId = string;
        audioHolder.isWAV = z;
        audioHolder.isFFT = z3;
        audioHolder.autoDestroy = z2;
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
        audioHolder.onError = new com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder.IOnError() { // from class: com.up366.mobile.book.exercise.js.AudioHelper$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder.IOnError
            public final void onError(java.lang.Exception exc) {
                audioHolder.callBack.onMediaStateResult(string, 4, 2);
            }
        };
        this.audioMgr.play(audioHolder);
        return this.audioMgr.waitDuration(string);
    }

    private com.up366.mobile.book.helper.ICommonAudioCallBack getAudioCallBack() {
        return new com.up366.mobile.book.helper.ICommonAudioCallBack() { // from class: com.up366.mobile.book.exercise.js.AudioHelper.1
            @Override // com.up366.mobile.book.helper.ICommonAudioCallBack
            public void onWavUpdate(java.lang.String str, byte[] bArr) {
                if (com.up366.mobile.book.exercise.js.AudioHelper.this.registerHelper.hasRegister("audiofftupdate")) {
                    com.up366.mobile.book.exercise.js.AudioHelper.this.registerHelper.callJsEvent("audiofftupdate", "('%s',%s)", str, java.util.Arrays.toString(bArr));
                }
            }

            @Override // com.up366.mobile.book.helper.ICommonAudioCallBack
            public void onMediaStateResult(java.lang.String str, int i, int i2) {
                if (com.up366.mobile.book.exercise.js.AudioHelper.this.registerHelper.hasRegister("audiostatechange")) {
                    int duration = i == 0 ? com.up366.mobile.book.exercise.js.AudioHelper.this.audioMgr.getDuration(str) : 0;
                    if (i == 9) {
                        i = 3;
                    }
                    com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                    jSONObject.put(com.igexin.push.core.b.C, str);
                    jSONObject.put("state", java.lang.Integer.valueOf(i));
                    jSONObject.put("duration", java.lang.Integer.valueOf(duration));
                    com.up366.mobile.book.exercise.js.AudioHelper.this.registerHelper.callJsEvent("audiostatechange", "(%s)", jSONObject.toJSONString());
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
