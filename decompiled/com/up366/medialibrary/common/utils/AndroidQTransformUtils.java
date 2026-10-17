package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AndroidQTransformUtils {
    public static java.lang.String copyPathToAndroidQ(android.content.Context context, long j, java.lang.String str, int i, int i2, java.lang.String str2, java.lang.String str3) {
        try {
            java.lang.String strCreateFilePath = com.up366.medialibrary.common.utils.PictureFileUtils.createFilePath(context, com.up366.medialibrary.common.utils.StringUtils.getEncryptionValue(j, i, i2), str2, str3);
            java.io.File file = new java.io.File(strCreateFilePath);
            return file.exists() ? strCreateFilePath : com.up366.medialibrary.common.utils.PictureFileUtils.writeFileFromIS(com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenInputStream(context, android.net.Uri.parse(str)), new java.io.FileOutputStream(file)) ? strCreateFilePath : "";
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
