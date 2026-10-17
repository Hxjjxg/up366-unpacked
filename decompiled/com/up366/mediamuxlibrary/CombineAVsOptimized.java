package com.up366.mediamuxlibrary;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CombineAVsOptimized {
    private static final java.lang.String TAG = "CombineAVsOpt";

    public static class ParamHolder {
        public java.util.List<com.up366.mediamuxlibrary.CombineAVsOptimized.AudioHolder> audios = new java.util.ArrayList();
        public java.lang.String destDir;
        public java.lang.String destVideo;
        public java.lang.String video;
    }

    public void start(android.content.Context context, com.up366.mediamuxlibrary.CombineAVsOptimized.ParamHolder paramHolder) throws java.lang.InterruptedException, java.io.IOException {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String str = paramHolder.destDir;
        android.util.Log.d(TAG, "start: 转换音频编码 start");
        java.util.List<com.up366.mediamuxlibrary.CombineAVsOptimized.AudioHolder> list = paramHolder.audios;
        for (int i = 0; i < list.size(); i++) {
            com.up366.mediamuxlibrary.CombineAVsOptimized.AudioHolder audioHolder = list.get(i);
            if (audioHolder.type != 1) {
                audioHolder.convertPath = str + "c_" + i + com.up366.medialibrary.common.utils.MimeTypeUtils.WAV;
                exec(new java.lang.String[]{"ffmpeg", "-i", audioHolder.rawPath, "-ar", "32000", "-ac", "1", "-map_metadata", "-1", audioHolder.convertPath});
            }
        }
        android.util.Log.d(TAG, "start: 转换音频编码 end");
        android.util.Log.d(TAG, "start: 提取视频中的音频 start");
        java.lang.String str2 = str + "va.wav";
        exec(new java.lang.String[]{"ffmpeg", "-i", paramHolder.video, "-vn", "-ar", "32000", "-ac", "1", "-map_metadata", "-1", str2});
        paramHolder.audios.add(new com.up366.mediamuxlibrary.CombineAVsOptimized.AudioHolder(0L, 0L, "", str2, 3));
        android.util.Log.d(TAG, "start: 提取视频中的音频 end");
        android.util.Log.d(TAG, "start: 合并音频文件 start");
        java.lang.String strCombineAudios = new com.up366.mediamuxlibrary.AudioCombiner().combineAudios(str, paramHolder.audios);
        android.util.Log.d(TAG, "start: 合并音频文件 end");
        android.util.Log.d(TAG, "start: 合并音视频文件 start");
        exec(new java.lang.String[]{"ffmpeg", "-i", paramHolder.video, "-i", strCombineAudios, "-c:v", "copy", "-c:a", "aac", "-y", "-strict", "experimental", "-map", "0:v:0", "-map", "1:a:0", paramHolder.destVideo});
        android.util.Log.d(TAG, "start: 合并音视频文件 end");
        android.util.Log.i(TAG, "start: combine over! used time : " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
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
        public java.lang.String convertPath;
        private long endMilliSeconds;
        public java.io.RandomAccessFile ins;
        private boolean isEOF;
        public java.lang.String rawPath;
        public long startMilliSeconds;
        public int type;
        private int frameNum = 0;
        private int pcmDataOffset = 78;
        private int startFrame = 0;
        private int endFrame = 0;

        public AudioHolder(long j, long j2, java.lang.String str, java.lang.String str2, int i) {
            this.isEOF = false;
            this.rawPath = str;
            this.convertPath = str2;
            this.startMilliSeconds = j;
            this.endMilliSeconds = j2;
            this.type = i;
            if (i == 1) {
                this.isEOF = true;
            }
        }

        public java.lang.String getRawPath() {
            return this.rawPath;
        }

        public java.lang.String getConvertPath() {
            return this.convertPath;
        }

        public long getStartMilliSeconds() {
            return this.startMilliSeconds;
        }

        public long getEndMilliSeconds() {
            return this.endMilliSeconds;
        }

        public int getType() {
            return this.type;
        }

        public int getFrameNum() {
            return this.frameNum;
        }

        public void setFrameNum(int i) {
            this.frameNum = i;
        }

        public int getPcmDataOffset() {
            return this.pcmDataOffset;
        }

        public void setPcmDataOffset(int i) {
            this.pcmDataOffset = i;
        }

        public int getStartFrame() {
            return this.startFrame;
        }

        public void setStartFrame(int i) {
            this.startFrame = i;
        }

        public int getEndFrame() {
            return this.endFrame;
        }

        public void setEndFrame(int i) {
            this.endFrame = i;
        }

        public java.io.RandomAccessFile getIns() {
            return this.ins;
        }

        public void setIns(java.io.RandomAccessFile randomAccessFile) {
            this.ins = randomAccessFile;
        }

        public boolean isEOF() {
            return this.isEOF;
        }

        public void setEOF(boolean z) {
            this.isEOF = z;
        }
    }
}
