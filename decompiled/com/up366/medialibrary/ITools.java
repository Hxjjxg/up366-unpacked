package com.up366.medialibrary;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface ITools {
    public static final int TYPE_FILE = 3;
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_VIDEO = 2;

    void downloadFile(java.lang.String str, java.lang.String str2, com.up366.medialibrary.listener.OnDownloadListener onDownloadListener);

    void downloadThnumbnail(java.lang.String str, java.lang.String str2, com.up366.medialibrary.listener.OnDownloadListener onDownloadListener);

    java.lang.String getRootPath(int i);

    void toastMessage(java.lang.String str);
}
