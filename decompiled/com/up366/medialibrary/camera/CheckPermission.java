package com.up366.medialibrary.camera;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CheckPermission {
    public static final int STATE_NO_PERMISSION = -2;
    public static final int STATE_RECORDING = -1;
    public static final int STATE_SUCCESS = 1;

    public static int getRecordState() {
        int minBufferSize = android.media.AudioRecord.getMinBufferSize(44100, 16, 2);
        android.media.AudioRecord audioRecord = new android.media.AudioRecord(0, 44100, 16, 2, minBufferSize * 100);
        short[] sArr = new short[minBufferSize];
        try {
            audioRecord.startRecording();
            if (audioRecord.getRecordingState() != 3) {
                audioRecord.stop();
                audioRecord.release();
                return -1;
            }
            if (audioRecord.read(sArr, 0, minBufferSize) <= 0) {
                audioRecord.stop();
                audioRecord.release();
                return -2;
            }
            audioRecord.stop();
            audioRecord.release();
            return 1;
        } catch (java.lang.Exception unused) {
            audioRecord.release();
            return -2;
        }
    }
}
