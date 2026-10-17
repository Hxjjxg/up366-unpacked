package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ThumbnailUtils {
    public static java.lang.String makeAndCacheThumbnail(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return "";
        }
        java.lang.String thumbnail = com.up366.medialibrary.common.utils.MMKVUtils.getInst().getThumbnail(str);
        if (com.up366.common.FileUtilsUp.isFileExists(thumbnail)) {
            return thumbnail;
        }
        java.lang.String str2 = com.up366.medialibrary.common.utils.MediaPathUtil.getInst().getImagePath() + com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() + com.up366.medialibrary.common.utils.MimeTypeUtils.PNG;
        if (com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(str)) {
            makeByHttpPathThumbnail(str, str2);
        } else {
            com.up366.common.BitmapUtilsUp.saveBitmap(android.media.ThumbnailUtils.createVideoThumbnail(str, 3), str2);
        }
        boolean zIsFileExists = com.up366.common.FileUtilsUp.isFileExists(str2);
        if (zIsFileExists) {
            com.up366.medialibrary.common.utils.MMKVUtils.getInst().putThumbnail(str, str2);
        }
        return zIsFileExists ? str2 : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v9 */
    private static void makeByHttpPathThumbnail(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        ?? r1 = 0;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new java.io.FileOutputStream(str2);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(com.up366.common.global.GB.get().getApplicationContext(), android.net.Uri.parse(str));
            r1 = 100;
            mediaMetadataRetriever.getFrameAtTime().compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.close();
            com.up366.common.IOUtils.close(fileOutputStream);
        } catch (java.lang.Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            com.up366.common.log.Logger.error("makeByHttpPathThumbnail error " + e.getMessage(), e);
            com.up366.common.IOUtils.close(fileOutputStream2);
            r1 = fileOutputStream2;
        } catch (java.lang.Throwable th2) {
            th = th2;
            r1 = fileOutputStream;
            com.up366.common.IOUtils.close(r1);
            throw th;
        }
    }
}
