package com.up366.multimedia.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PathUtils {
    public static java.lang.String getPath() {
        return com.up366.common.FileUtilsUp.join(getCachePath(), "mediaCache");
    }

    private static java.lang.String getCachePath() {
        android.content.Context applicationContext = com.up366.common.global.GB.get().getApplicationContext();
        if (applicationContext.getExternalCacheDir() != null) {
            return applicationContext.getExternalCacheDir().getAbsolutePath();
        }
        return applicationContext.getCacheDir().getAbsolutePath();
    }

    protected static java.lang.String makeTemPath() {
        return com.up366.common.FileUtilsUp.join(getPath(), java.util.UUID.randomUUID().toString() + com.up366.medialibrary.common.utils.MimeTypeUtils.JPG);
    }

    protected static java.lang.String makeOutPath() {
        return com.up366.common.FileUtilsUp.join(getPath(), java.util.UUID.randomUUID().toString() + com.up366.medialibrary.common.utils.MimeTypeUtils.JPG);
    }

    protected static java.lang.String makerCropPath() {
        return com.up366.common.FileUtilsUp.join(android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_PICTURES).getAbsolutePath(), java.util.UUID.randomUUID().toString() + com.up366.medialibrary.common.utils.MimeTypeUtils.JPG);
    }
}
