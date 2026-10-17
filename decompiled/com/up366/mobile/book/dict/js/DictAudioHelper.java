package com.up366.mobile.book.dict.js;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DictAudioHelper {
    private com.up366.mobile.book.helper.CommonAudioHelper audioHelper;
    private final com.up366.mobile.book.dict.js.DictRecordHelper recordHelper;
    private final com.up366.mobile.book.dict.js.DictRegisterHelper registerHelper;
    final com.up366.mobile.book.webview.StudyPageWebView webView;

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

    public DictAudioHelper(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.dict.js.DictRecordHelper dictRecordHelper, com.up366.mobile.book.dict.js.DictRegisterHelper dictRegisterHelper) {
        this.webView = studyPageWebView;
        this.audioHelper = new com.up366.mobile.book.helper.CommonAudioHelper(studyPageWebView.getContext());
        this.recordHelper = dictRecordHelper;
        this.registerHelper = dictRegisterHelper;
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
        boolean booleanValue = object.containsKey("autoDestroy") ? object.getBooleanValue("autoDestroy") : true;
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
            audioHolder.uri = new java.io.File(com.up366.common.FileUtilsUp.join(this.webView.getCurrentDir(), string2)).toURI().toString();
        } else if (intValue == 2) {
            audioHolder.uri = new java.io.File(this.recordHelper.getRecordPath(string2)).toURI().toString();
        } else if (intValue == 3) {
            audioHolder.uri = audioHolder.convertUri(string2);
        } else if (intValue == 4) {
            if (!com.up366.common.FileUtilsUp.isFileExists(string2)) {
                com.up366.mobile.book.helper.Tools.alarmLogTrackContext.src = string2;
                com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004004001));
                com.up366.mobile.common.utils.ToastPopupUtil.show(this.webView, "音频文件不存在，播放失败");
            } else {
                audioHolder.uri = new java.io.File(string2).toURI().toString();
            }
        } else if (intValue == 5) {
            audioHolder.uri = audioHolder.convertUri(com.up366.common.FileUtilsUp.join(this.webView.getCurrentDir(), string2), string2, this.recordHelper.getRecordPath(string2), string2);
        } else {
            audioHolder.uri = audioHolder.convertUri(string2);
        }
        audioHolder.onError = new com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder.IOnError() { // from class: com.up366.mobile.book.dict.js.DictAudioHelper$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder.IOnError
            public final void onError(java.lang.Exception exc) {
                this.f$0.lambda$playAudioWithParams$0(string, exc);
            }
        };
        this.audioHelper.play(audioHolder);
        return this.audioHelper.waitDuration(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playAudioWithParams$0(java.lang.String str, java.lang.Exception exc) {
        this.registerHelper.callJsEvent("audiostatechange", "(%s)", buildJsonStatus(str, convertAudioState(-1), 0, -500, "(" + exc.getMessage() + ")", 0).toJSONString());
    }

    private com.up366.mobile.book.helper.ICommonAudioCallBack getAudioCallBack() {
        return new com.up366.mobile.book.helper.ICommonAudioCallBack() { // from class: com.up366.mobile.book.dict.js.DictAudioHelper.1
            @Override // com.up366.mobile.book.helper.ICommonAudioCallBack
            public void onWavUpdate(java.lang.String str, byte[] bArr) {
                int[] iArr = new int[bArr.length];
                for (int i = 0; i < bArr.length; i++) {
                    iArr[i] = bArr[i];
                }
                com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                jSONObject.put(com.igexin.push.core.b.C, str);
                jSONObject.put("datas", iArr);
                com.up366.mobile.book.dict.js.DictAudioHelper.this.registerHelper.callJsEvent("audiofftupdate", "(%s)", jSONObject.toJSONString());
            }

            @Override // com.up366.mobile.book.helper.ICommonAudioCallBack
            public void onMediaStateResult(java.lang.String str, int i, int i2) {
                if (i2 == 1) {
                    i = 3;
                }
                com.up366.mobile.book.dict.js.DictAudioHelper.this.registerHelper.callJsEvent("audiostatechange", "(%s)", com.up366.mobile.book.dict.js.DictAudioHelper.this.buildJsonStatus(str, com.up366.mobile.book.dict.js.DictAudioHelper.this.convertAudioState(i2 != 2 ? i : 3), com.up366.mobile.book.dict.js.DictAudioHelper.this.audioHelper.getDuration(str), 0, "", i2 > 0 ? 1 : 0).toJSONString());
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
