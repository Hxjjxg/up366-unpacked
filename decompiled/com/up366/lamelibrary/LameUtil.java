package com.up366.lamelibrary;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LameUtil {
    private static final java.lang.String TAG = "LameUtil";
    private static int avgIndex;
    private static int[] avgs;
    private static boolean isDelNoice;
    private static com.up366.lamelibrary.LameUtil lameUtil;
    int bitsPerSample = 0;
    int channelNumber = 0;
    int totalFrames = 0;
    int duration = 0;
    byte[] pcmBuffer = new byte[io.objectbox.model.PropertyFlags.UNSIGNED];

    public static native int closeStreamEncoder(long j);

    private native boolean convert2wav(long j, java.lang.String str);

    private native int decodeframe(long j, int i, byte[] bArr);

    public static native int destroyEncoder();

    public static native int encodeFile(java.lang.String str, java.lang.String str2);

    public static native int encodeStream(long j, byte[] bArr, int i);

    private native void finish(long j);

    public static native int flushStreamEncoder(long j);

    private native int getFrames(long j);

    private native int getbits(long j);

    private native int getchannel(long j);

    private native int getduration(long j);

    private native long init(java.lang.String str);

    public static native int initEncoder(int i, int i2, int i3, int i4, int i5, boolean z);

    public static native long initStreamEncoder(java.lang.String str, int i, int i2, int i3, int i4, int i5);

    public native boolean ProcessWavBufferFFT(byte b, byte b2, byte[] bArr, int i, byte[] bArr2, int i2);

    public native void delNoice(byte[] bArr, int i, int i2);

    static {
        java.lang.System.loadLibrary("lame-mad-lib");
        lameUtil = new com.up366.lamelibrary.LameUtil();
        isDelNoice = false;
        avgIndex = 0;
        avgs = new int[5];
    }

    public static void fft(byte b, byte b2, byte[] bArr, int i, byte[] bArr2, int i2) {
        lameUtil.ProcessWavBufferFFT(b, b2, bArr, i, bArr2, i2);
    }

    public static void fftMp3(java.lang.String str, int i, byte[] bArr) {
        long jInitDecoder = lameUtil.initDecoder(str);
        if (jInitDecoder < 1) {
            android.util.Log.e(TAG, "fftMp3: initDecoder error! : " + str);
        } else {
            lameUtil.fft4FrameByTime(jInitDecoder, i, bArr, bArr.length);
            lameUtil.releaseDecoder(jInitDecoder);
            if (isDelNoice) {
                deleteNoice(bArr);
            }
        }
    }

    public static boolean convertMp3ToWav(java.lang.String str, java.lang.String str2) {
        long jInitDecoder = lameUtil.initDecoder(str);
        if (jInitDecoder < 1) {
            android.util.Log.e(TAG, "fftMp3: initDecoder error! : " + str);
            return false;
        }
        lameUtil.convert2wav(jInitDecoder, str2);
        lameUtil.releaseDecoder(jInitDecoder);
        return true;
    }

    public static void setDelNoice(boolean z) {
        isDelNoice = z;
    }

    private static void deleteNoice(byte[] bArr) {
        avgs[avgIndex] = 0;
        for (byte b : bArr) {
            int[] iArr = avgs;
            int i = avgIndex;
            iArr[i] = iArr[i] + b;
        }
        int[] iArr2 = avgs;
        int i2 = avgIndex;
        iArr2[i2] = iArr2[i2] / bArr.length;
        int i3 = i2 + 1;
        avgIndex = i3;
        avgIndex = i3 % iArr2.length;
        int i4 = 0;
        for (int i5 : iArr2) {
            i4 += i5;
        }
        int length = i4 / avgs.length;
        int i6 = length <= 50 ? length : 50;
        if (length < 20) {
            i6 = 20;
        }
        lameUtil.delNoice(bArr, bArr.length, i6);
    }

    public long initDecoder(java.lang.String str) {
        long jInit = init(str);
        if (jInit > 0) {
            this.bitsPerSample = getbits(jInit);
            this.channelNumber = getchannel(jInit);
            this.totalFrames = getFrames(jInit);
            this.duration = getduration(jInit);
        }
        return jInit;
    }

    public void releaseDecoder(long j) {
        finish(j);
    }

    public boolean fft4FrameByTime(long j, int i, byte[] bArr, int i2) {
        return fft4FrameByFrameNo(j, (int) (((((double) this.totalFrames) * 1.0d) * ((double) i)) / ((double) this.duration)), bArr, i2);
    }

    public boolean fft4FrameByFrameNo(long j, int i, byte[] bArr, int i2) {
        int iDecodeframe = decodeframe(j, i, this.pcmBuffer);
        int i3 = this.channelNumber;
        if ((i3 != 1 || iDecodeframe < 1024) && (i3 != 2 || iDecodeframe < 2048)) {
            return false;
        }
        return ProcessWavBufferFFT((byte) i3, (byte) this.bitsPerSample, this.pcmBuffer, iDecodeframe, bArr, i2);
    }
}
