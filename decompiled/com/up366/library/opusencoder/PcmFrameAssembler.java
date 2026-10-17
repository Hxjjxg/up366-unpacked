package com.up366.library.opusencoder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PcmFrameAssembler {
    private int bufPos;
    private short[] buffer;
    private final int channels;
    private final int frameSize;
    private final int sampleRate;

    public PcmFrameAssembler(com.up366.library.opusencoder.OpusParams opusParams) {
        int sampleRate = opusParams.getSampleRate();
        this.sampleRate = sampleRate;
        this.channels = opusParams.getChannels();
        int frameMs = (sampleRate / 1000) * opusParams.getFrameMs();
        this.frameSize = frameMs;
        if (frameMs <= 0) {
            throw new java.lang.IllegalArgumentException("invalid frameMs or sampleRate; result frameSize <= 0");
        }
        this.buffer = new short[frameMs * 10];
        this.bufPos = 0;
    }

    public PcmFrameAssembler(int i, int i2, int i3) {
        this.sampleRate = i;
        this.channels = i2;
        int i4 = (i / 1000) * i3;
        this.frameSize = i4;
        if (i4 <= 0) {
            throw new java.lang.IllegalArgumentException("invalid frameMs or sampleRate; result frameSize <= 0");
        }
        this.buffer = new short[i4 * 10];
        this.bufPos = 0;
    }

    public java.util.List<short[]> feed(short[] sArr, int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (i <= 0) {
            return arrayList;
        }
        ensureCapacity(this.bufPos + i);
        java.lang.System.arraycopy(sArr, 0, this.buffer, this.bufPos, i);
        this.bufPos += i;
        while (true) {
            int i2 = this.bufPos;
            int i3 = this.frameSize;
            if (i2 < i3) {
                return arrayList;
            }
            short[] sArr2 = new short[i3];
            java.lang.System.arraycopy(this.buffer, 0, sArr2, 0, i3);
            arrayList.add(sArr2);
            int i4 = this.bufPos;
            int i5 = this.frameSize;
            int i6 = i4 - i5;
            if (i6 > 0) {
                short[] sArr3 = this.buffer;
                java.lang.System.arraycopy(sArr3, i5, sArr3, 0, i6);
            }
            this.bufPos = i6;
        }
    }

    public java.util.List<short[]> flush() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = this.bufPos;
        if (i > 0) {
            short[] sArr = new short[this.frameSize];
            java.lang.System.arraycopy(this.buffer, 0, sArr, 0, i);
            for (int i2 = this.bufPos; i2 < this.frameSize; i2++) {
                sArr[i2] = 0;
            }
            arrayList.add(sArr);
            this.bufPos = 0;
        }
        return arrayList;
    }

    private void ensureCapacity(int i) {
        short[] sArr = this.buffer;
        if (i <= sArr.length) {
            return;
        }
        int length = sArr.length;
        while (length < i) {
            length *= 2;
        }
        short[] sArr2 = new short[length];
        java.lang.System.arraycopy(this.buffer, 0, sArr2, 0, this.bufPos);
        this.buffer = sArr2;
    }

    public int pendingSamples() {
        return this.bufPos;
    }
}
