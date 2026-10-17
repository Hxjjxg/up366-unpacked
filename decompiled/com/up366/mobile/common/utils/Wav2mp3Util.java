package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class Wav2mp3Util {
    public static final int BITRATE = 96;
    public static final int MODE = 1;
    public static final int NUM_CHANNELS = 1;
    public static final int QUALITY = 1;
    public static final int SAMPLE_RATE = 16000;

    public static synchronized void encode(java.lang.String str, java.lang.String str2) throws com.up366.mobile.common.utils.Wav2mp3Util.Wav2mp3Exception {
        com.up366.common.FileUtilsUp.mkdirParentDir(str2);
        java.lang.String str3 = str2 + java.lang.Math.random();
        int iInitEncoder = com.up366.lamelibrary.LameUtil.initEncoder(1, 16000, 96, 1, 1, true);
        if (iInitEncoder != 0) {
            throw new com.up366.mobile.common.utils.Wav2mp3Util.Wav2mp3Exception("initEncoder error : " + iInitEncoder);
        }
        int iEncodeFile = com.up366.lamelibrary.LameUtil.encodeFile(str, str3);
        if (iEncodeFile != 0) {
            throw new com.up366.mobile.common.utils.Wav2mp3Util.Wav2mp3Exception("encodeFile error : " + iEncodeFile);
        }
        int iDestroyEncoder = com.up366.lamelibrary.LameUtil.destroyEncoder();
        if (iDestroyEncoder != 0) {
            throw new com.up366.mobile.common.utils.Wav2mp3Util.Wav2mp3Exception("destroyEncoder error : " + iDestroyEncoder);
        }
        if (com.up366.common.FileUtilsUp.isFileExists(str2)) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(str3);
        } else {
            if (!new java.io.File(str3).renameTo(new java.io.File(str2))) {
                com.up366.common.log.Logger.error("rename mp3 error! : " + str3);
            }
        }
    }

    private static class Wav2mp3Exception extends java.lang.Exception {
        public Wav2mp3Exception(java.lang.String str) {
            super(str);
        }
    }
}
