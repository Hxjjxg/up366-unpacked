package com.up366.asecengine.asecmgr;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class RecordFactory3 {
    private static final int AUDIO_FORMAT = 2;
    private static final int CHANNEL_CONFIG = 16;
    private static final int SAMPLE_RATE = 16000;
    private static android.media.AudioManager audioManager;
    private static android.media.AudioRecord audioRecord;
    private static boolean isRecording;

    private RecordFactory3() {
    }

    public static void init(android.content.Context context) {
        audioManager = (android.media.AudioManager) context.getSystemService(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_AUDIO);
    }

    public static synchronized android.media.AudioRecord create() {
        android.media.AudioRecord audioRecord2 = audioRecord;
        if (audioRecord2 != null && audioRecord2.getState() == 1) {
            return audioRecord;
        }
        android.media.AudioRecord audioRecord3 = new android.media.AudioRecord(1, 16000, 16, 2, java.lang.Math.max(android.media.AudioRecord.getMinBufferSize(16000, 16, 2) * 4, io.objectbox.model.PropertyFlags.UNSIGNED));
        audioRecord = audioRecord3;
        if (audioRecord3.getState() != 1) {
            throw new java.lang.IllegalStateException("AudioRecord init failed");
        }
        return audioRecord;
    }

    public static synchronized void startRecording() {
        com.up366.common.log.Logger.info("Starting recording...");
        if (audioRecord == null) {
            create();
        }
        if (isRecording) {
            com.up366.common.log.Logger.warn("startRecording called but already recording");
            return;
        }
        boolean zIsBluetoothScoAvailable = isBluetoothScoAvailable();
        android.media.AudioManager audioManager2 = audioManager;
        if (audioManager2 != null && zIsBluetoothScoAvailable) {
            audioManager2.setMode(3);
            try {
                audioManager.startBluetoothSco();
                audioManager.setBluetoothScoOn(true);
            } catch (java.lang.Exception unused) {
                com.up366.common.log.Logger.info("startBluetoothSco failed, fallback to normal mode");
            }
        }
        audioRecord.startRecording();
        isRecording = true;
        com.up366.common.log.Logger.info("Recording started. Bluetooth SCO ".concat(zIsBluetoothScoAvailable ? "enabled" : "not available"));
    }

    public static synchronized void stopRecording() {
        com.up366.common.log.Logger.info("Stopping recording...");
        if (isRecording) {
            try {
                audioRecord.stop();
            } catch (java.lang.Exception unused) {
                com.up366.common.log.Logger.info("AudioRecord stop failed, maybe already stopped");
            }
            android.media.AudioManager audioManager2 = audioManager;
            if (audioManager2 != null) {
                try {
                    audioManager2.stopBluetoothSco();
                } catch (java.lang.Exception unused2) {
                    com.up366.common.log.Logger.info("stopBluetoothSco failed, maybe already stopped");
                }
                audioManager.setBluetoothScoOn(false);
                audioManager.setMode(0);
                isRecording = false;
                com.up366.common.log.Logger.info("Recording stopped, audio mode reset to normal");
                return;
            }
            isRecording = false;
            com.up366.common.log.Logger.info("Recording stopped, audio mode reset to normal");
            return;
        }
    }

    public static synchronized void release() {
        com.up366.common.log.Logger.info("Releasing AudioRecord resources...");
        stopRecording();
        android.media.AudioRecord audioRecord2 = audioRecord;
        if (audioRecord2 != null) {
            audioRecord2.release();
            audioRecord = null;
        }
    }

    private static boolean isBluetoothScoAvailable() {
        android.media.AudioManager audioManager2 = audioManager;
        if (audioManager2 == null) {
            return false;
        }
        try {
            for (android.media.AudioDeviceInfo audioDeviceInfo : audioManager2.getDevices(1)) {
                if (audioDeviceInfo.getType() == 7) {
                    return true;
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return false;
    }

    public static void ensureMediaMode(android.content.Context context) {
        android.media.AudioManager audioManager2;
        if (context == null || (audioManager2 = (android.media.AudioManager) context.getSystemService(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_AUDIO)) == null || audioManager2.getMode() == 0) {
            return;
        }
        try {
            audioManager2.stopBluetoothSco();
        } catch (java.lang.Exception unused) {
        }
        audioManager2.setBluetoothScoOn(false);
        audioManager2.setMode(0);
    }
}
