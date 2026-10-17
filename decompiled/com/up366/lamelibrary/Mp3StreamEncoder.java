package com.up366.lamelibrary;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class Mp3StreamEncoder implements java.lang.AutoCloseable {
    public static final int DEFAULT_BIT_RATE_KBPS = 32;
    public static final int DEFAULT_MODE = 1;
    public static final int DEFAULT_QUALITY = 1;
    public static final int MODE_DUAL_CHANNEL = 2;
    public static final int MODE_JOINT_STEREO = 1;
    public static final int MODE_MONO = 3;
    public static final int MODE_STEREO = 0;
    private final int bitRate;
    private final int mode;
    private long nativeHandle;
    private final int numChannels;
    private final java.lang.String outputPath;
    private final int quality;
    private final int sampleRate;

    public Mp3StreamEncoder(java.lang.String str, int i, int i2, int i3) {
        this(str, i, i2, i3, 1, 1);
    }

    public Mp3StreamEncoder(java.lang.String str, int i, int i2, int i3, int i4, int i5) {
        if (str == null || str.trim().length() == 0) {
            throw new java.lang.IllegalArgumentException("outputPath is empty");
        }
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("sampleRate must be positive");
        }
        if (i2 <= 0 || i2 > 2) {
            throw new java.lang.IllegalArgumentException("numChannels must be 1 or 2");
        }
        if (i3 <= 0) {
            throw new java.lang.IllegalArgumentException("bitRate must be positive");
        }
        this.outputPath = str;
        this.sampleRate = i;
        this.numChannels = i2;
        this.bitRate = i3;
        this.mode = i4;
        this.quality = i5;
    }

    public synchronized boolean init() {
        if (this.nativeHandle > 0) {
            return true;
        }
        java.io.File parentFile = new java.io.File(this.outputPath).getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        long jInitStreamEncoder = com.up366.lamelibrary.LameUtil.initStreamEncoder(this.outputPath, this.numChannels, this.sampleRate, this.bitRate, this.mode, this.quality);
        this.nativeHandle = jInitStreamEncoder;
        return jInitStreamEncoder > 0;
    }

    public synchronized int encodePcm(byte[] bArr, int i) {
        long j = this.nativeHandle;
        if (j <= 0) {
            throw new java.lang.IllegalStateException("stream encoder not initialized");
        }
        if (bArr != null && i > 0) {
            return com.up366.lamelibrary.LameUtil.encodeStream(j, bArr, i);
        }
        return 0;
    }

    public synchronized int flush() {
        long j = this.nativeHandle;
        if (j <= 0) {
            return 0;
        }
        return com.up366.lamelibrary.LameUtil.flushStreamEncoder(j);
    }

    public synchronized java.lang.String getOutputPath() {
        return this.outputPath;
    }

    @Override // java.lang.AutoCloseable
    public synchronized void close() {
        long j = this.nativeHandle;
        if (j <= 0) {
            return;
        }
        this.nativeHandle = 0L;
        com.up366.lamelibrary.LameUtil.closeStreamEncoder(j);
    }
}
