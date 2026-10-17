package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ChapterAudioHelper extends com.up366.mobile.book.helper.V6AudioHelper {
    private final com.up366.mobile.book.helper.BookFilePathHelper bookFilePathHelper;

    public ChapterAudioHelper(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.StudyActivity studyActivity, com.up366.mobile.book.helper.ChapterRecordHelper chapterRecordHelper) {
        super(studyPageWebView, chapterRecordHelper);
        this.bookFilePathHelper = studyActivity.bookFilePathHelper;
    }

    @Override // com.up366.mobile.book.helper.V6AudioHelper
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
            audioHolder.uri = new java.io.File(com.up366.common.FileUtilsUp.join(this.bookFilePathHelper.getCatalogDir(), str2)).toURI().toString();
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
            audioHolder.uri = audioHolder.convertUri(com.up366.common.FileUtilsUp.join(this.bookFilePathHelper.getCatalogDir(), str2), str2, this.recordHelper.getRecordPath(str2), str2);
        } else {
            audioHolder.uri = audioHolder.convertUri(str2);
        }
        audioHolder.onError = new com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder.IOnError() { // from class: com.up366.mobile.book.helper.ChapterAudioHelper$$ExternalSyntheticLambda0
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
}
