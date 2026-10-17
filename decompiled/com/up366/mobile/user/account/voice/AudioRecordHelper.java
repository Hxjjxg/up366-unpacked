package com.up366.mobile.user.account.voice;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AudioRecordHelper {
    private java.lang.String recordId;
    private final com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper;
    private final java.lang.String recordDir = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getAppExternalFilesDir(), "voice-record");
    private final java.lang.String curPath = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getAppExternalFilesDir(), "net");

    public AudioRecordHelper(android.content.Context context) {
        this.speechRecordHelper = new com.up366.mobile.book.helper.recorder.SpeechRecordHelper(context);
    }

    public void start(final androidx.core.util.Consumer<java.lang.Float> consumer, final androidx.core.util.Consumer<com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder> consumer2) {
        com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener iFFTUpdateListener = new com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener() { // from class: com.up366.mobile.user.account.voice.AudioRecordHelper$$ExternalSyntheticLambda0
            @Override // com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener
            public final void update(byte[] bArr, int i) {
                com.up366.mobile.user.account.voice.AudioRecordHelper.lambda$start$0(consumer, bArr, i);
            }
        };
        com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper = this.speechRecordHelper;
        java.util.Objects.requireNonNull(consumer2);
        speechRecordHelper.setCallBack(new com.up366.mobile.book.helper.recorder.SpeechRecordHelper.ICallBack() { // from class: com.up366.mobile.user.account.voice.AudioRecordHelper$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.book.helper.recorder.SpeechRecordHelper.ICallBack
            public final void onResult(com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder asecCallbackDataHolder) {
                consumer2.accept(asecCallbackDataHolder);
            }
        });
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(this.recordDir, "rec.wav");
        java.lang.String str = "voice-record" + java.util.UUID.randomUUID();
        this.recordId = str;
        this.speechRecordHelper.startRecord(str, null, 4, strJoin, this.curPath, iFFTUpdateListener, null, true, 1, null, 12, null);
    }

    static /* synthetic */ void lambda$start$0(androidx.core.util.Consumer consumer, byte[] bArr, int i) {
        com.up366.common.log.Logger.info("TAG - 2022-09-05 - AudioRecordHelper2 - start - " + java.util.Arrays.toString(bArr));
        consumer.accept(java.lang.Float.valueOf(((((float) bArr[5]) / 100.0f) * 0.5f) + 0.5f));
    }

    public void stop() {
        this.speechRecordHelper.endRecord(this.recordId);
    }

    public void stopAll() {
        this.speechRecordHelper.forceStopAll();
    }
}
