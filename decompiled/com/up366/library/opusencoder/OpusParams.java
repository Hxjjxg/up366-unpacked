package com.up366.library.opusencoder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OpusParams {
    private int bitrate;
    private int channels;
    private boolean enable;
    private int frameMs;
    private int sampleRate;

    public OpusParams() {
        this.enable = true;
        this.sampleRate = 16000;
        this.channels = 1;
        this.bitrate = com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.ONLINE_BITRATE;
        this.frameMs = 20;
    }

    public OpusParams(boolean z, int i, int i2, int i3, int i4) {
        this.enable = z;
        this.sampleRate = i;
        this.channels = i2;
        this.bitrate = i3;
        this.frameMs = i4;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public int getChannels() {
        return this.channels;
    }

    public void setChannels(int i) {
        this.channels = i;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public void setBitrate(int i) {
        this.bitrate = i;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public int getFrameMs() {
        return this.frameMs;
    }

    public void setFrameMs(int i) {
        this.frameMs = i;
    }

    public java.lang.String toString() {
        return "OpusParams{enable=" + this.enable + ", sampleRate=" + this.sampleRate + ", channels=" + this.channels + ", bitrate=" + this.bitrate + ", frameMs=" + this.frameMs + '}';
    }
}
