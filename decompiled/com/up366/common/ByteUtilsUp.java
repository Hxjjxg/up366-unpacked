package com.up366.common;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ByteUtilsUp {
    public static java.lang.String bytesToMKB(long j) {
        if (j >= 1073741824) {
            return (((double) ((int) ((j / 1.073741824E7d) + 0.05d))) / 100.0d) + "G";
        }
        if (j >= com.up366.medialibrary.config.PictureConstants.MB) {
            return (((double) ((int) ((j / 10485.76d) + 0.05d))) / 100.0d) + "M";
        }
        if (j >= 1024) {
            return (((double) ((int) ((j / 10.24d) + 0.05d))) / 100.0d) + "K";
        }
        if (j >= 0) {
            return ((int) j) + "B";
        }
        return "0B";
    }

    public static java.lang.String downloadSpeed(long j, long j2) {
        if (j < 0 || j2 <= 0) {
            return "0KB/0KB";
        }
        java.lang.String strDownCurrent = downCurrent(j);
        if (j2 >= com.up366.medialibrary.config.PictureConstants.MB) {
            double d = ((double) ((int) (j2 / 10486.76d))) / 100.0d;
            if (j >= j2) {
                return d + "MB/" + d + "MB";
            }
            return strDownCurrent + d + "MB";
        }
        if (j2 >= 1024) {
            double d2 = ((double) ((int) ((j2 / 10.24d) + 0.05d))) / 100.0d;
            if (j >= j2) {
                return d2 + "KB/" + d2 + "KB";
            }
            return strDownCurrent + d2 + "KB";
        }
        int i = (int) j2;
        if (j >= j2) {
            return i + "B/" + i + "B";
        }
        return strDownCurrent + i + "B";
    }

    private static java.lang.String downCurrent(long j) {
        if (j >= com.up366.medialibrary.config.PictureConstants.MB) {
            return (((double) ((int) (j / 10486.76d))) / 100.0d) + "MB/";
        }
        if (j >= 1024) {
            return (((double) ((int) ((j / 10.24d) + 0.05d))) / 100.0d) + "KB/";
        }
        return ((int) j) + "B/";
    }
}
