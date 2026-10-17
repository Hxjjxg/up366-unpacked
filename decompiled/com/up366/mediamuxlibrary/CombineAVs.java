package com.up366.mediamuxlibrary;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CombineAVs {
    private static final java.lang.String TAG = "CombineAVs";

    public static class ParamHolder {
        public java.util.List<com.up366.mediamuxlibrary.CombineAVs.AudioHolder> audios = new java.util.ArrayList();
        public java.lang.String destDir;
        public java.lang.String destVideo;
        public java.lang.String video;
    }

    public void start(android.content.Context context, com.up366.mediamuxlibrary.CombineAVs.ParamHolder paramHolder) throws java.lang.InterruptedException, java.io.IOException {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String str = paramHolder.destDir;
        android.util.Log.d(TAG, "start: 转换音频编码 start");
        java.util.List<com.up366.mediamuxlibrary.CombineAVs.AudioHolder> list = paramHolder.audios;
        for (int i = 0; i < list.size(); i++) {
            com.up366.mediamuxlibrary.CombineAVs.AudioHolder audioHolder = list.get(i);
            if (audioHolder.type != 1) {
                audioHolder.convertPath = str + "c_" + i + com.up366.medialibrary.common.utils.MimeTypeUtils.WAV;
                exec(new java.lang.String[]{"ffmpeg", "-i", audioHolder.rawPath, "-ar", "32000", "-ac", "1", "-map_metadata", "-1", audioHolder.convertPath});
            }
        }
        android.util.Log.d(TAG, "start: 转换音频编码 end");
        android.util.Log.d(TAG, "start: 提取视频中的音频 start");
        java.lang.String str2 = str + "va.wav";
        exec(new java.lang.String[]{"ffmpeg", "-i", paramHolder.video, "-vn", "-ar", "32000", "-ac", "1", "-map_metadata", "-1", str2});
        paramHolder.audios.add(new com.up366.mediamuxlibrary.CombineAVs.AudioHolder(0L, 0L, "", str2, 3));
        android.util.Log.d(TAG, "start: 提取视频中的音频 end");
        android.util.Log.d(TAG, "start: 合并音频文件 start");
        java.lang.String strCombineAudios = combineAudios(str, paramHolder.audios);
        android.util.Log.d(TAG, "start: 合并音频文件 end");
        android.util.Log.d(TAG, "start: 合并音视频文件 start");
        exec(new java.lang.String[]{"ffmpeg", "-i", paramHolder.video, "-i", strCombineAudios, "-c:v", "copy", "-c:a", "aac", "-y", "-strict", "experimental", "-map", "0:v:0", "-map", "1:a:0", paramHolder.destVideo});
        android.util.Log.d(TAG, "start: 合并音视频文件 end");
        android.util.Log.i(TAG, "start: combine over! used time : " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v2 */
    private java.lang.String combineAudios(java.lang.String str, java.util.List<com.up366.mediamuxlibrary.CombineAVs.AudioHolder> list) throws java.io.IOException {
        ?? r4;
        byte[] bArr;
        boolean z;
        com.up366.mediamuxlibrary.CombineAVs combineAVs = this;
        java.lang.String str2 = str + "dest.wav";
        java.util.Iterator<com.up366.mediamuxlibrary.CombineAVs.AudioHolder> it = list.iterator();
        while (true) {
            r4 = 1;
            if (!it.hasNext()) {
                break;
            }
            com.up366.mediamuxlibrary.CombineAVs.AudioHolder next = it.next();
            long j = next.startMilliSeconds;
            long j2 = com.up366.mediamuxlibrary.AudioCombiner.SAMPLE_RATE;
            next.startFrame = (j * j2) / 1000;
            next.endFrame = (next.endMilliSeconds * j2) / 1000;
            if (next.type != 1) {
                next.ins = new java.io.BufferedInputStream(new java.io.FileInputStream(next.convertPath));
                combineAVs.skipToPCMStart(next.ins);
            }
        }
        java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(str2));
        bufferedOutputStream.write(combineAVs.getWaveHeader(1024L));
        byte[] bArr2 = new byte[2];
        byte[] bArr3 = new byte[2];
        byte[] bArr4 = new byte[2];
        java.util.ArrayList<com.up366.mediamuxlibrary.CombineAVs.AudioHolder> arrayList = new java.util.ArrayList();
        com.up366.mediamuxlibrary.CombineAVs.AudioHolder audioHolder = null;
        com.up366.mediamuxlibrary.CombineAVs.AudioHolder audioHolder2 = null;
        for (com.up366.mediamuxlibrary.CombineAVs.AudioHolder audioHolder3 : list) {
            if (audioHolder3.type == 3) {
                audioHolder = audioHolder3;
            }
            if (audioHolder3.type == 2) {
                audioHolder2 = audioHolder3;
            }
            if (audioHolder3.type == 0 || audioHolder3.type == 1) {
                arrayList.add(audioHolder3);
            }
        }
        audioHolder.getClass();
        audioHolder2.getClass();
        byte b = 0;
        int i = 0;
        while (true) {
            if (!audioHolder.isEOF && audioHolder.ins.read(bArr2) != 2) {
                break;
            }
            if (!audioHolder2.isEOF && audioHolder2.ins.read(bArr3) != 2) {
                audioHolder2.isEOF = r4;
                bArr3[b] = b;
                bArr3[r4] = b;
            }
            float f = 0.0f;
            int i2 = b;
            int i3 = i2;
            for (com.up366.mediamuxlibrary.CombineAVs.AudioHolder audioHolder4 : arrayList) {
                byte[] bArr5 = bArr2;
                java.lang.String str3 = str2;
                long j3 = i;
                if (audioHolder4.startFrame <= j3) {
                    if (audioHolder4.isEOF) {
                        if (audioHolder4.endFrame >= j3) {
                            i2++;
                            i3++;
                        }
                    } else if (audioHolder4.endFrame >= j3) {
                        if (audioHolder4.ins.read(bArr4) == 2) {
                            i2++;
                            f += java.nio.ByteBuffer.wrap(bArr4).order(java.nio.ByteOrder.LITTLE_ENDIAN).getShort();
                        } else {
                            audioHolder4.isEOF = true;
                        }
                    }
                }
                bArr2 = bArr5;
                str2 = str3;
            }
            java.lang.String str4 = str2;
            byte[] bArr6 = bArr2;
            if (i2 > 0) {
                z = true;
                bufferedOutputStream.write(java.nio.ByteBuffer.allocate(2).order(java.nio.ByteOrder.LITTLE_ENDIAN).putShort((short) ((f + java.nio.ByteBuffer.wrap(bArr3).order(java.nio.ByteOrder.LITTLE_ENDIAN).getShort()) / ((i2 - i3) + 1))).array());
                bArr = bArr6;
            } else {
                bArr = bArr6;
                z = true;
                bufferedOutputStream.write(bArr);
            }
            i++;
            r4 = z;
            bArr2 = bArr;
            str2 = str4;
            b = 0;
            combineAVs = this;
        }
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        for (com.up366.mediamuxlibrary.CombineAVs.AudioHolder audioHolder5 : list) {
            if (audioHolder5.type != r4) {
                audioHolder5.ins.close();
            }
        }
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(str2, "rw");
        randomAccessFile.seek(0L);
        randomAccessFile.write(combineAVs.getWaveHeader(i * 2));
        randomAccessFile.close();
        return str2;
    }

    private void skipToPCMStart(java.io.BufferedInputStream bufferedInputStream) throws java.io.IOException {
        bufferedInputStream.read(new byte[36]);
        byte[] bArr = new byte[4];
        bufferedInputStream.read(bArr);
        if (new java.lang.String(bArr).equals("LIST")) {
            bufferedInputStream.read(bArr);
            bufferedInputStream.read(new byte[java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.LITTLE_ENDIAN).getInt()]);
            bufferedInputStream.read(bArr);
        }
        if (new java.lang.String(bArr).equals("data")) {
            bufferedInputStream.read(bArr);
            android.util.Log.i(TAG, "skipToPCMStart: dataLength : " + java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.LITTLE_ENDIAN).getInt());
        }
    }

    private byte[] getWaveHeader(long j) {
        long j2 = j + 36;
        long j3 = (512000 * ((long) 1)) / 8;
        return new byte[]{82, 73, 70, 70, (byte) (j2 & 255), (byte) ((j2 >> 8) & 255), (byte) ((j2 >> 16) & 255), (byte) ((j2 >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) 1, 0, (byte) 0, (byte) 125, (byte) 0, (byte) 0, (byte) (j3 & 255), (byte) ((j3 >> 8) & 255), (byte) ((j3 >> 16) & 255), (byte) ((j3 >> 24) & 255), 4, 0, 16, 0, 100, 97, 116, 97, (byte) (j & 255), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255)};
    }

    private void exec(java.lang.String[] strArr) throws java.lang.InterruptedException, java.io.IOException {
        android.util.Log.d(TAG, "exec: params :" + java.util.Arrays.toString(strArr));
        android.util.Log.i(TAG, "run: start...");
        com.up366.mediamuxlibrary.FFJni.exec(strArr.length, strArr);
        android.util.Log.i(TAG, "run: end.");
    }

    public static class AudioHolder {
        public static final int TYPE_BACKGROUND = 2;
        public static final int TYPE_MP4_AAC = 3;
        public static final int TYPE_WAV = 0;
        public static final int TYPE_WAV_NONE = 1;
        java.lang.String convertPath;
        public long endFrame;
        long endMilliSeconds;
        public java.io.BufferedInputStream ins;
        public boolean isEOF;
        java.lang.String rawPath;
        public long startFrame;
        long startMilliSeconds;
        int type;

        public AudioHolder(long j, long j2, java.lang.String str, java.lang.String str2, int i) {
            this.rawPath = str;
            this.convertPath = str2;
            this.startMilliSeconds = j;
            this.endMilliSeconds = j2;
            this.type = i;
            if (i == 1) {
                this.isEOF = true;
            }
        }
    }
}
