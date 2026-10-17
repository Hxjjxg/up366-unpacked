package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AlbumUtils {
    public static long generateCameraBucketId(android.content.Context context, java.io.File file, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return com.up366.medialibrary.common.utils.MediaUtils.getCameraFirstBucketId(context);
        }
        if (file.getParentFile() != null) {
            return file.getParentFile().getName().hashCode();
        }
        return com.up366.medialibrary.common.utils.MediaUtils.getCameraFirstBucketId(context);
    }

    public static java.lang.String generateCameraFolderName(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str3)) {
            return (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() && com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(str2)) ? android.os.Environment.DIRECTORY_MOVIES : com.up366.medialibrary.common.utils.MimeTypeUtils.CAMERA;
        }
        java.io.File file = new java.io.File(str);
        return file.getParentFile() != null ? file.getParentFile().getName() : com.up366.medialibrary.common.utils.MimeTypeUtils.CAMERA;
    }
}
