package com.up366.asecengine.asecmgr;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MediaUtils {
    public static byte[] getWaveHeader(long j) {
        long j2 = j + 36;
        long j3 = (256000 * ((long) 1)) / 8;
        return new byte[]{82, 73, 70, 70, (byte) (j2 & 255), (byte) ((j2 >> 8) & 255), (byte) ((j2 >> 16) & 255), (byte) ((j2 >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) 1, 0, (byte) 128, (byte) 62, (byte) 0, (byte) 0, (byte) (j3 & 255), (byte) ((j3 >> 8) & 255), (byte) ((j3 >> 16) & 255), (byte) ((j3 >> 24) & 255), (byte) 2, 0, 16, 0, 100, 97, 116, 97, (byte) (j & 255), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255)};
    }

    public static com.up366.asecengine.asecmgr.WaveHeader getWaveHeader(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        com.up366.asecengine.asecmgr.WaveHeader waveHeader = null;
        if (!file.exists()) {
            return null;
        }
        try {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "r");
            byte[] bArr = new byte[4];
            while (randomAccessFile.read(bArr) > 0 && !new java.lang.String(bArr).equals("RIFF")) {
            }
            if (randomAccessFile.read(bArr) != 4) {
                return null;
            }
            com.up366.asecengine.asecmgr.WaveHeader waveHeader2 = new com.up366.asecengine.asecmgr.WaveHeader();
            try {
                waveHeader2.totalSize = getSize(bArr);
                randomAccessFile.skipBytes(4);
                randomAccessFile.skipBytes(4);
                randomAccessFile.skipBytes(4);
                if (randomAccessFile.read(bArr) == 4) {
                    waveHeader2.format = bArr[0];
                    waveHeader2.channelNum = bArr[2];
                    if (randomAccessFile.read(bArr) == 4) {
                        waveHeader2.sampleRate = getSize(bArr);
                        if (randomAccessFile.read(bArr) == 4) {
                            waveHeader2.byteRate = getSize(bArr);
                            if (randomAccessFile.read(bArr) == 4) {
                                waveHeader2.blockAlign = bArr[0];
                                waveHeader2.bitsPerSample = bArr[2];
                                randomAccessFile.skipBytes(4);
                                if (randomAccessFile.read(bArr) == 4) {
                                    waveHeader2.audioSize = getSize(bArr);
                                    randomAccessFile.close();
                                }
                            }
                        }
                    }
                }
                return waveHeader2;
            } catch (java.io.IOException e) {
                e = e;
                waveHeader = waveHeader2;
            }
        } catch (java.io.IOException e2) {
            e = e2;
        }
        e.printStackTrace();
        return waveHeader;
    }

    public static long getSize(byte[] bArr) {
        if (bArr.length != 4) {
            return 0L;
        }
        int i = bArr[0] & 255;
        int i2 = bArr[1] & 255;
        int i3 = bArr[2] & 255;
        return ((bArr[3] & 255) << 24) | i | (i2 << 8) | (i3 << 16);
    }

    public static int getMediaDuration(java.lang.String str) {
        android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
        int duration = 0;
        try {
            mediaPlayer.setDataSource(str);
            mediaPlayer.prepare();
            duration = mediaPlayer.getDuration();
            mediaPlayer.release();
            return duration;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return duration;
        }
    }
}
