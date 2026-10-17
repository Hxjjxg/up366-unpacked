package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureSelectorExternalUtils {
    public static android.media.ExifInterface getExifInterface(android.content.Context context, java.lang.String str) throws java.lang.Throwable {
        java.io.InputStream contentResolverOpenInputStream;
        java.io.InputStream inputStream = null;
        android.media.ExifInterface exifInterface = null;
        try {
            if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() && com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(str)) {
                contentResolverOpenInputStream = com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenInputStream(context, android.net.Uri.parse(str));
                if (contentResolverOpenInputStream != null) {
                    try {
                        try {
                            com.igexin.c.a.d.g$$ExternalSyntheticApiModelOutline0.m$2();
                            exifInterface = com.igexin.c.a.d.g$$ExternalSyntheticApiModelOutline0.m(contentResolverOpenInputStream);
                        } catch (java.lang.Exception e) {
                            e = e;
                            e.printStackTrace();
                            com.up366.medialibrary.common.utils.PictureFileUtils.close(contentResolverOpenInputStream);
                            return null;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        inputStream = contentResolverOpenInputStream;
                        com.up366.medialibrary.common.utils.PictureFileUtils.close(inputStream);
                        throw th;
                    }
                }
            } else {
                exifInterface = new android.media.ExifInterface(str);
                contentResolverOpenInputStream = null;
            }
            com.up366.medialibrary.common.utils.PictureFileUtils.close(contentResolverOpenInputStream);
            return exifInterface;
        } catch (java.lang.Exception e2) {
            e = e2;
            contentResolverOpenInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            com.up366.medialibrary.common.utils.PictureFileUtils.close(inputStream);
            throw th;
        }
    }
}
