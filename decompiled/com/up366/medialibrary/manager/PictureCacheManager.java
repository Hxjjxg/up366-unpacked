package com.up366.medialibrary.manager;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureCacheManager {
    public static void deleteCacheDirFile(java.lang.String str) {
        deleteCacheDirFile(str, (com.up366.medialibrary.listener.OnCallbackListener<java.lang.String>) null);
    }

    public static void deleteCacheDirFile(java.lang.String str, com.up366.medialibrary.listener.OnCallbackListener<java.lang.String> onCallbackListener) {
        java.io.File[] fileArrListFiles = new java.io.File(str).listFiles();
        if (fileArrListFiles != null) {
            for (java.io.File file : fileArrListFiles) {
                if (file.isFile() && file.delete() && onCallbackListener != null) {
                    onCallbackListener.onCall(file.getAbsolutePath());
                }
            }
        }
    }

    public static void deleteCacheRefreshDirFile(android.content.Context context, int i) {
        deleteCacheDirFile(context, i, true, null);
    }

    public static void deleteCacheDirFile(android.content.Context context, int i) {
        deleteCacheDirFile(context, i, false, null);
    }

    public static void deleteCacheDirFile(android.content.Context context, int i, com.up366.medialibrary.listener.OnCallbackListener<java.lang.String> onCallbackListener) {
        deleteCacheDirFile(context, i, false, onCallbackListener);
    }

    private static void deleteCacheDirFile(final android.content.Context context, int i, boolean z, com.up366.medialibrary.listener.OnCallbackListener<java.lang.String> onCallbackListener) {
        java.io.File[] fileArrListFiles;
        java.io.File externalFilesDir = context.getExternalFilesDir(i == com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage() ? android.os.Environment.DIRECTORY_PICTURES : android.os.Environment.DIRECTORY_MOVIES);
        if (externalFilesDir == null || (fileArrListFiles = externalFilesDir.listFiles()) == null) {
            return;
        }
        for (final java.io.File file : fileArrListFiles) {
            if (file.isFile() && file.delete()) {
                if (z) {
                    com.up366.medialibrary.common.utils.PictureThreadUtils.runOnUiThread(new java.lang.Runnable() { // from class: com.up366.medialibrary.manager.PictureCacheManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            new com.up366.medialibrary.lib.PictureMediaScannerConnection(context, file.getAbsolutePath());
                        }
                    });
                } else if (onCallbackListener != null) {
                    onCallbackListener.onCall(file.getAbsolutePath());
                }
            }
        }
    }

    public static void deleteAllCacheDirFile(android.content.Context context) {
        deleteAllCacheDirFile(context, false, null);
    }

    public static void deleteAllCacheDirFile(android.content.Context context, com.up366.medialibrary.listener.OnCallbackListener<java.lang.String> onCallbackListener) {
        deleteAllCacheDirFile(context, false, onCallbackListener);
    }

    public static void deleteAllCacheDirRefreshFile(android.content.Context context) {
        deleteAllCacheDirFile(context, true, null);
    }

    private static void deleteAllCacheDirFile(final android.content.Context context, boolean z, com.up366.medialibrary.listener.OnCallbackListener<java.lang.String> onCallbackListener) {
        java.io.File[] fileArrListFiles;
        java.io.File[] fileArrListFiles2;
        java.io.File[] fileArrListFiles3;
        java.io.File externalFilesDir = context.getExternalFilesDir(android.os.Environment.DIRECTORY_PICTURES);
        if (externalFilesDir != null && (fileArrListFiles3 = externalFilesDir.listFiles()) != null) {
            for (final java.io.File file : fileArrListFiles3) {
                if (file.isFile() && file.delete()) {
                    if (z) {
                        com.up366.medialibrary.common.utils.PictureThreadUtils.runOnUiThread(new java.lang.Runnable() { // from class: com.up366.medialibrary.manager.PictureCacheManager.2
                            @Override // java.lang.Runnable
                            public void run() {
                                new com.up366.medialibrary.lib.PictureMediaScannerConnection(context, file.getAbsolutePath());
                            }
                        });
                    } else if (onCallbackListener != null) {
                        onCallbackListener.onCall(file.getAbsolutePath());
                    }
                }
            }
        }
        java.io.File externalFilesDir2 = context.getExternalFilesDir(android.os.Environment.DIRECTORY_MOVIES);
        if (externalFilesDir2 != null && (fileArrListFiles2 = externalFilesDir2.listFiles()) != null) {
            for (final java.io.File file2 : fileArrListFiles2) {
                if (file2.isFile() && file2.delete()) {
                    if (z) {
                        com.up366.medialibrary.common.utils.PictureThreadUtils.runOnUiThread(new java.lang.Runnable() { // from class: com.up366.medialibrary.manager.PictureCacheManager.3
                            @Override // java.lang.Runnable
                            public void run() {
                                new com.up366.medialibrary.lib.PictureMediaScannerConnection(context, file2.getAbsolutePath());
                            }
                        });
                    } else if (onCallbackListener != null) {
                        onCallbackListener.onCall(file2.getAbsolutePath());
                    }
                }
            }
        }
        java.io.File externalFilesDir3 = context.getExternalFilesDir(android.os.Environment.DIRECTORY_MUSIC);
        if (externalFilesDir3 == null || (fileArrListFiles = externalFilesDir3.listFiles()) == null) {
            return;
        }
        for (final java.io.File file3 : fileArrListFiles) {
            if (file3.isFile() && file3.delete()) {
                if (z) {
                    com.up366.medialibrary.common.utils.PictureThreadUtils.runOnUiThread(new java.lang.Runnable() { // from class: com.up366.medialibrary.manager.PictureCacheManager.4
                        @Override // java.lang.Runnable
                        public void run() {
                            new com.up366.medialibrary.lib.PictureMediaScannerConnection(context, file3.getAbsolutePath());
                        }
                    });
                } else if (onCallbackListener != null) {
                    onCallbackListener.onCall(file3.getAbsolutePath());
                }
            }
        }
    }
}
