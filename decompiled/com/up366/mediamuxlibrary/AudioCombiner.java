package com.up366.mediamuxlibrary;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AudioCombiner {
    public static final int SAMPLE_RATE = 32000;

    public java.lang.String combineAudios(java.lang.String str, java.util.List<com.up366.mediamuxlibrary.CombineAVsOptimized.AudioHolder> list) throws java.io.IOException {
        com.up366.mediamuxlibrary.CombineAVsOptimized.AudioHolder audioHolder;
        com.up366.mediamuxlibrary.CombineAVsOptimized.AudioHolder audioHolder2;
        int i;
        com.up366.mediamuxlibrary.CombineAVsOptimized.AudioHolder audioHolder3;
        int iMin;
        for (com.up366.mediamuxlibrary.CombineAVsOptimized.AudioHolder audioHolder4 : list) {
            audioHolder4.setStartFrame((int) ((audioHolder4.getStartMilliSeconds() * 32000) / 1000));
            audioHolder4.setEndFrame((int) ((audioHolder4.getEndMilliSeconds() * 32000) / 1000));
            if (audioHolder4.getType() != 1) {
                try {
                    java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(new java.io.File(audioHolder4.getConvertPath()), "rw");
                    audioHolder4.setIns(randomAccessFile);
                    int[] iArrSkipToPCMStartAndReturnFrameNumAndPCMDataOffset = skipToPCMStartAndReturnFrameNumAndPCMDataOffset(randomAccessFile);
                    audioHolder4.setFrameNum(iArrSkipToPCMStartAndReturnFrameNumAndPCMDataOffset[0]);
                    audioHolder4.setPcmDataOffset(iArrSkipToPCMStartAndReturnFrameNumAndPCMDataOffset[1]);
                } catch (java.lang.Exception e) {
                    throw new java.io.IOException("Create ReadStream Error: " + e.getMessage(), e);
                }
            }
        }
        int i2 = 0;
        while (true) {
            audioHolder = null;
            if (i2 >= list.size()) {
                audioHolder2 = null;
                break;
            }
            audioHolder2 = list.get(i2);
            if (audioHolder2.getType() == 3) {
                break;
            }
            i2++;
        }
        int i3 = 0;
        while (true) {
            i = 2;
            if (i3 >= list.size()) {
                break;
            }
            com.up366.mediamuxlibrary.CombineAVsOptimized.AudioHolder audioHolder5 = list.get(i3);
            if (audioHolder5.getType() == 2) {
                audioHolder = audioHolder5;
                break;
            }
            i3++;
        }
        java.util.ArrayList<com.up366.mediamuxlibrary.CombineAVsOptimized.AudioHolder> arrayList = new java.util.ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            com.up366.mediamuxlibrary.CombineAVsOptimized.AudioHolder audioHolder6 = list.get(i4);
            int type = audioHolder6.getType();
            if (type == 0 || type == 1) {
                arrayList.add(audioHolder6);
            }
        }
        if (audioHolder2 == null || audioHolder2.isEOF()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Missing video audio, or isEOF=");
            sb.append(audioHolder2 != null && audioHolder2.isEOF());
            throw new java.lang.IllegalStateException(sb.toString());
        }
        if (audioHolder == null) {
            throw new java.lang.IllegalStateException("Missing background audio");
        }
        java.lang.String convertPath = audioHolder2.getConvertPath();
        try {
            try {
                for (com.up366.mediamuxlibrary.CombineAVsOptimized.AudioHolder audioHolder7 : arrayList) {
                    int iMin2 = java.lang.Math.min(java.lang.Math.min(audioHolder.getFrameNum(), audioHolder2.getFrameNum()), audioHolder7.getEndFrame());
                    if (audioHolder7.getStartFrame() < iMin2) {
                        int startFrame = (iMin2 - audioHolder7.getStartFrame()) * i;
                        byte[] bArr = new byte[startFrame];
                        audioHolder3 = audioHolder;
                        audioHolder.getIns().seek((((long) audioHolder7.getStartFrame()) * 2) + ((long) audioHolder7.getPcmDataOffset()));
                        if (audioHolder3.getIns().read(bArr) == startFrame) {
                            audioHolder2.getIns().seek((((long) audioHolder7.getStartFrame()) * 2) + ((long) audioHolder7.getPcmDataOffset()));
                            audioHolder2.getIns().write(bArr);
                        }
                    } else {
                        audioHolder3 = audioHolder;
                    }
                    if (audioHolder7.getFrameNum() > 0 && audioHolder7.getStartFrame() < (iMin = java.lang.Math.min(iMin2, audioHolder7.getStartFrame() + audioHolder7.getFrameNum()))) {
                        int startFrame2 = iMin - audioHolder7.getStartFrame();
                        int i5 = startFrame2 * 2;
                        byte[] bArr2 = new byte[i5];
                        audioHolder7.getIns().seek(audioHolder7.getPcmDataOffset());
                        int i6 = audioHolder7.getIns().read(bArr2);
                        byte[] bArr3 = new byte[i5];
                        audioHolder2.getIns().seek((((long) audioHolder7.getStartFrame()) * 2) + ((long) audioHolder7.getPcmDataOffset()));
                        if (audioHolder2.getIns().read(bArr3) == i5 && i6 == i5) {
                            short[] sArrBytesToShorts = bytesToShorts(bArr2);
                            short[] sArrBytesToShorts2 = bytesToShorts(bArr3);
                            for (int i7 = 0; i7 < startFrame2; i7++) {
                                sArrBytesToShorts2[i7] = (short) (sArrBytesToShorts2[i7] + ((short) (((double) (sArrBytesToShorts[i7] - r9)) * 0.5d)));
                            }
                            byte[] bArrShortsToBytes = shortsToBytes(sArrBytesToShorts2);
                            audioHolder2.getIns().seek((((long) audioHolder7.getStartFrame()) * 2) + ((long) audioHolder7.getPcmDataOffset()));
                            audioHolder2.getIns().write(bArrShortsToBytes);
                        }
                    }
                    audioHolder = audioHolder3;
                    i = 2;
                }
                for (com.up366.mediamuxlibrary.CombineAVsOptimized.AudioHolder audioHolder8 : list) {
                    if (audioHolder8.getType() != 1 && audioHolder8.getIns() != null) {
                        try {
                            audioHolder8.getIns().close();
                        } catch (java.lang.Exception unused) {
                        }
                    }
                }
                return convertPath;
            } catch (java.lang.Exception e2) {
                throw new java.io.IOException("Error combining audios: " + e2.getMessage(), e2);
            }
        } catch (java.lang.Throwable th) {
            for (com.up366.mediamuxlibrary.CombineAVsOptimized.AudioHolder audioHolder9 : list) {
                if (audioHolder9.getType() != 1 && audioHolder9.getIns() != null) {
                    try {
                        audioHolder9.getIns().close();
                    } catch (java.lang.Exception unused2) {
                    }
                }
            }
            throw th;
        }
    }

    private int[] skipToPCMStartAndReturnFrameNumAndPCMDataOffset(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        long j;
        int iByteArrayToInt;
        randomAccessFile.seek(36L);
        byte[] bArr = new byte[4];
        randomAccessFile.readFully(bArr);
        java.lang.String str = new java.lang.String(bArr);
        if ("LIST".equals(str)) {
            byte[] bArr2 = new byte[4];
            randomAccessFile.readFully(bArr2);
            int iByteArrayToInt2 = byteArrayToInt(bArr2);
            randomAccessFile.seek(randomAccessFile.getFilePointer() + ((long) iByteArrayToInt2));
            randomAccessFile.readFully(bArr);
            java.lang.String str2 = new java.lang.String(bArr);
            j = ((long) (iByteArrayToInt2 + 4)) + 44;
            iByteArrayToInt = iByteArrayToInt2;
            str = str2;
        } else {
            j = 40;
            iByteArrayToInt = 0;
        }
        if ("data".equals(str)) {
            byte[] bArr3 = new byte[4];
            randomAccessFile.readFully(bArr3);
            iByteArrayToInt = byteArrayToInt(bArr3);
            j += 4;
        }
        return new int[]{iByteArrayToInt / 2, (int) j};
    }

    private int byteArrayToInt(byte[] bArr) {
        return (bArr[0] & 255) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8);
    }

    private short[] bytesToShorts(byte[] bArr) {
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            sArr[i] = (short) ((bArr[i2 + 1] << 8) | (bArr[i2] & 255));
        }
        return sArr;
    }

    private byte[] shortsToBytes(short[] sArr) {
        byte[] bArr = new byte[sArr.length * 2];
        for (int i = 0; i < sArr.length; i++) {
            int i2 = i * 2;
            short s = sArr[i];
            bArr[i2] = (byte) (s & 255);
            bArr[i2 + 1] = (byte) ((s >> 8) & 255);
        }
        return bArr;
    }
}
