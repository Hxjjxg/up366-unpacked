package com.up366.asecengine.asecmgr;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class WaveHeader {
    long totalSize = 0;
    long audioSize = 0;
    long sampleRate = 0;
    long byteRate = 0;
    int format = 0;
    int channelNum = 0;
    int blockAlign = 0;
    int bitsPerSample = 0;

    WaveHeader() {
    }

    public int getDuration() {
        return (int) (this.audioSize / this.byteRate);
    }
}
