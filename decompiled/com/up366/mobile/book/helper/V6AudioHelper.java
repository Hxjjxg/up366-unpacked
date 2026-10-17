package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V6AudioHelper {
    com.up366.mobile.book.helper.CommonAudioHelper audioHelper;
    final com.up366.mobile.book.helper.V6RecordHelper recordHelper;
    final com.up366.mobile.book.webview.StudyPageWebView webView;

    public V6AudioHelper(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.helper.V6RecordHelper v6RecordHelper) {
        this.webView = studyPageWebView;
        this.audioHelper = new com.up366.mobile.book.helper.CommonAudioHelper(studyPageWebView.getContext());
        this.recordHelper = v6RecordHelper;
    }

    public int playAudio(final java.lang.String str, java.lang.String str2, int i, int i2) {
        com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder audioHolder = new com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder();
        audioHolder.audioId = str;
        audioHolder.isWAV = false;
        audioHolder.isFFT = false;
        audioHolder.autoDestroy = false;
        audioHolder.rate = 1.0f;
        audioHolder.volume = 1.0f;
        audioHolder.seek = i2;
        audioHolder.callBack = getAudioCallBack(0);
        if (i == 1) {
            audioHolder.uri = new java.io.File(com.up366.common.FileUtilsUp.join(this.webView.getCurrentDir(), str2)).toURI().toString();
        } else if (i == 2) {
            audioHolder.uri = new java.io.File(this.recordHelper.getRecordPath(str2)).toURI().toString();
        } else if (i == 3) {
            audioHolder.uri = audioHolder.convertUri(str2);
        } else if (i == 4) {
            if (!com.up366.common.FileUtilsUp.isFileExists(str2)) {
                com.up366.mobile.book.helper.Tools.alarmLogTrackContext.src = str2;
                com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004004001));
                com.up366.mobile.common.utils.ToastPopupUtil.show(this.webView, "音频文件不存在，不能播放。。。");
            } else {
                audioHolder.uri = new java.io.File(str2).toURI().toString();
            }
        } else if (i == 5) {
            audioHolder.uri = audioHolder.convertUri(com.up366.common.FileUtilsUp.join(this.webView.getCurrentDir(), str2), str2, this.recordHelper.getRecordPath(str2), str2);
        } else {
            audioHolder.uri = audioHolder.convertUri(str2);
        }
        audioHolder.onError = new com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder.IOnError() { // from class: com.up366.mobile.book.helper.V6AudioHelper$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder.IOnError
            public final void onError(java.lang.Exception exc) {
                this.f$0.lambda$playAudio$0(str, exc);
            }
        };
        this.audioHelper.play(audioHolder);
        return this.audioHelper.waitDuration(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playAudio$0(java.lang.String str, java.lang.Exception exc) {
        this.webView.callJSMethod("onAudioStateChange('%s',%d,%d)", str, 4, 1);
    }

    public int getCurrentTime(java.lang.String str) {
        return this.audioHelper.getCurrentTime(str);
    }

    public void resumePlaying(java.lang.String str) {
        this.audioHelper.resume(str);
    }

    public void seekPlay(java.lang.String str, int i) {
        this.audioHelper.resume(str);
        this.audioHelper.seek(str, i);
    }

    public void pausePlay(java.lang.String str) {
        this.audioHelper.pause(str);
    }

    public void stopPlay(java.lang.String str) {
        this.audioHelper.stop(str);
    }

    public int playAudioWithParams(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final java.lang.String string = object.getString(com.igexin.push.core.b.C);
        java.lang.String string2 = object.getString(com.up366.qmui.skin.QMUISkinValueBuilder.SRC);
        int intValue = object.getIntValue("type");
        int intValue2 = object.getIntValue("seek");
        int intValue3 = object.getIntValue("fftStyle");
        int intValue4 = object.getIntValue("samplingRate");
        boolean z = false;
        final int intValue5 = object.containsKey("cbType") ? object.getIntValue("cbType") : 0;
        float floatValue = object.containsKey("rate") ? object.getFloatValue("rate") : 1.0f;
        int intValue6 = object.getIntValue("autoDestroy");
        float floatValue2 = object.containsKey("volume") ? object.getFloatValue("volume") : 1.0f;
        boolean z2 = intValue6 == 1;
        boolean z3 = intValue3 == 1;
        if (intValue3 == 2) {
            z3 = false;
            z = true;
        }
        com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder audioHolder = new com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder();
        audioHolder.audioId = string;
        audioHolder.isWAV = z;
        audioHolder.isFFT = z3;
        audioHolder.autoDestroy = z2;
        audioHolder.samplingRate = intValue4;
        audioHolder.rate = floatValue;
        audioHolder.volume = floatValue2;
        audioHolder.seek = intValue2;
        audioHolder.callBack = getAudioCallBack(intValue5);
        if (intValue == 1) {
            audioHolder.uri = new java.io.File(com.up366.common.FileUtilsUp.join(this.webView.getCurrentDir(), string2)).toURI().toString();
        } else if (intValue == 2) {
            audioHolder.uri = new java.io.File(this.recordHelper.getRecordPath(string2)).toURI().toString();
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
            audioHolder.uri = audioHolder.convertUri(com.up366.common.FileUtilsUp.join(this.webView.getCurrentDir(), string2), string2, this.recordHelper.getRecordPath(string2), string2);
        } else {
            audioHolder.uri = audioHolder.convertUri(string2);
        }
        audioHolder.onError = new com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder.IOnError() { // from class: com.up366.mobile.book.helper.V6AudioHelper$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder.IOnError
            public final void onError(java.lang.Exception exc) {
                this.f$0.lambda$playAudioWithParams$1(intValue5, string, exc);
            }
        };
        this.audioHelper.play(audioHolder);
        return this.audioHelper.waitDuration(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playAudioWithParams$1(int i, java.lang.String str, java.lang.Exception exc) {
        if (i == 1) {
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put(com.igexin.push.core.b.C, str);
            jSONObject.put("state", -1);
            jSONObject.put("isForce", 1);
            jSONObject.put("duration", 0);
            jSONObject.put("msg", "(" + exc.getMessage() + ")");
            this.webView.callJSMethod("onAudioStateChangeV1(%s)", jSONObject.toJSONString());
        } else {
            this.webView.callJSMethod("onAudioStateChange('%s',%d,%d)", str, 4, 1);
        }
        com.up366.common.log.Logger.error("TAG - V6AudioHelper - playAudioWithParams - exception : " + exc.getMessage());
    }

    public com.up366.mobile.book.helper.ICommonAudioCallBack getAudioCallBack(final int i) {
        return new com.up366.mobile.book.helper.ICommonAudioCallBack() { // from class: com.up366.mobile.book.helper.V6AudioHelper.1
            @Override // com.up366.mobile.book.helper.ICommonAudioCallBack
            public void onWavUpdate(java.lang.String str, byte[] bArr) {
                com.up366.mobile.book.helper.V6AudioHelper.this.webView.callJSMethod("onAudioFFTUpdate('%s',%s)", str, java.util.Arrays.toString(bArr));
            }

            @Override // com.up366.mobile.book.helper.ICommonAudioCallBack
            public void onMediaStateResult(java.lang.String str, int i2, int i3) {
                if (i == 1) {
                    if (i3 == 1) {
                        i2 = 3;
                    }
                    int i4 = i3 != 2 ? i2 : 3;
                    com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                    jSONObject.put(com.igexin.push.core.b.C, str);
                    jSONObject.put("state", java.lang.Integer.valueOf(i4));
                    jSONObject.put("isForce", java.lang.Integer.valueOf(i3 > 0 ? 1 : 0));
                    jSONObject.put("duration", java.lang.Integer.valueOf(com.up366.mobile.book.helper.V6AudioHelper.this.audioHelper.getDuration(str)));
                    jSONObject.put("msg", "");
                    com.up366.mobile.book.helper.V6AudioHelper.this.webView.callJSMethod("onAudioStateChangeV1(%s)", jSONObject.toJSONString());
                    return;
                }
                com.up366.mobile.book.helper.V6AudioHelper.this.webView.callJSMethod("onAudioStateChange('%s',%d, %d)", str, java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3 > 0 ? 1 : 0));
            }
        };
    }

    public void setVolume(java.lang.String str, int i) {
        this.audioHelper.setVolume(str, i);
    }

    public void release() {
        this.audioHelper.release();
    }

    public void pauseAll() {
        this.audioHelper.pauseAll();
    }

    public void setRate(java.lang.String str, float f) {
        this.audioHelper.setRate(str, f);
    }

    public float getRate(java.lang.String str) {
        return this.audioHelper.getRate(str);
    }
}
