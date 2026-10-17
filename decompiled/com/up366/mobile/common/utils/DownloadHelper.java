package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DownloadHelper {
    public static final int DOWN_ASES_MODEL = 15;
    public static final int DOWN_ASES_MODEL_DIFF = 17;
    public static final int DOWN_ATTACH_RES = 13;
    public static final int DOWN_BOOK = 1;
    public static final int DOWN_BOOK_SPEECH_MP3 = 3;
    public static final int DOWN_BOOK_VIDEO = 12;
    public static final int DOWN_CHAPTER = 2;
    public static final int DOWN_COURSE = 0;
    public static final int DOWN_DICT = 16;
    public static final int DOWN_EXERCISE = 14;
    public static final int DOWN_HOMEWORK = 7;
    public static final int DOWN_HOMEWORK_VIDEO = 8;
    public static final int DOWN_IM_FILE = 21;
    public static final int DOWN_LDX_VIDEO = 5;
    public static final int DOWN_MSG_NETS = 4;
    public static final int DOWN_PAPER_PDF = 25;
    public static final int DOWN_PARTAB_NET = 19;
    public static final int DOWN_PARTC_NET = 18;
    public static final int DOWN_TEMP_RESOURCE = 20;
    public static final int DOWN_V8_AUDIO = 23;
    public static final int DOWN_V8_RESOURCE = 22;
    public static final int DOWN_V9_AUDIO = 28;
    public static final int DOWN_V9_RESOURCE = 26;
    public static final int DOWN_V9_RESOURCE_Q = 27;
    private static boolean allowNonWifiDownload;
    private static boolean dialogHasShow;

    public static void add(com.up366.common.download.DownloadInfo downloadInfo) {
        add(true, true, 0L, downloadInfo, null);
    }

    public static void add(boolean z, boolean z2, long j, com.up366.common.download.DownloadInfo downloadInfo, com.up366.common.download.DownloadManager.IDownloadCallback iDownloadCallback) {
        if (!z2 || allowNonWifiDownload || com.up366.common.NetworkUtilsUp.isWifiConnect()) {
            toDownload(z, downloadInfo, iDownloadCallback);
            return;
        }
        com.up366.common.NetworkUtilsUp.checkNetworkConnect();
        if (com.up366.common.NetworkUtilsUp.isWifiConnect()) {
            toDownload(z, downloadInfo, iDownloadCallback);
            com.up366.mobile.common.onlinelog.OpLog.report("DownloadReCheck", "非WiFi的情况下多检测一次网络类型，解决从4G切换到wifi后状态改变不及时导致的网络状态不一致问题");
        } else {
            toDownload(z, downloadInfo, iDownloadCallback);
        }
    }

    private static void toDownload(boolean z, com.up366.common.download.DownloadInfo downloadInfo, com.up366.common.download.DownloadManager.IDownloadCallback iDownloadCallback) {
        if (!z) {
            com.up366.common.log.Logger.info("TAG - DownloadHelper - toDownload - " + downloadInfo.getDownloadUrl());
            com.up366.common.download.DownloadManager.getInstance().addDownload(downloadInfo, iDownloadCallback);
            return;
        }
        com.up366.common.log.Logger.info("TAG - DownloadHelper - toDownload - " + downloadInfo.getDownloadUrl());
        com.up366.common.download.DownloadManager.getInstance().addDownload(downloadInfo, iDownloadCallback);
    }

    public static void resetAllowNonWiFiState() {
        if (!com.up366.common.NetworkUtilsUp.isConnected() || com.up366.common.NetworkUtilsUp.isWifiConnect()) {
            allowNonWifiDownload = false;
        }
    }
}
