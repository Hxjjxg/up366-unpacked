package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ChapterRecordHelper extends com.up366.mobile.book.helper.V6RecordHelper {
    public ChapterRecordHelper(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.helper.V6ChapterDataHelper v6ChapterDataHelper, com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper) {
        this.webView = studyPageWebView;
        this.dataHelper = v6ChapterDataHelper;
        this.speechRecordHelper = speechRecordHelper;
    }

    @Override // com.up366.mobile.book.helper.V6RecordHelper
    protected java.lang.String getCurrentPath() {
        return this.dataHelper.getBookPath();
    }

    @Override // com.up366.mobile.book.helper.V6RecordHelper
    public java.lang.String getRecordPath(java.lang.String str) {
        return com.up366.common.FileUtilsUp.join(this.dataHelper.getBookDataPath(), "catalog", str + com.up366.medialibrary.common.utils.MimeTypeUtils.WAV);
    }
}
