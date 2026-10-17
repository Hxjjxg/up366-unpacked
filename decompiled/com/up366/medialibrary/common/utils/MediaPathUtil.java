package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MediaPathUtil {
    private static com.up366.medialibrary.common.utils.MediaPathUtil instance;

    private MediaPathUtil() {
    }

    public static com.up366.medialibrary.common.utils.MediaPathUtil getInst() {
        if (instance == null) {
            instance = new com.up366.medialibrary.common.utils.MediaPathUtil();
        }
        return instance;
    }

    public java.lang.String getImagePath() {
        return com.up366.medialibrary.helper.MediaHelperManager.getTools().getRootPath(1);
    }

    public java.lang.String getFilePath() {
        return com.up366.medialibrary.helper.MediaHelperManager.getTools().getRootPath(3);
    }

    public java.lang.String getVideoPath() {
        return com.up366.medialibrary.helper.MediaHelperManager.getTools().getRootPath(2);
    }

    public java.lang.String getLocalVideoPath(java.lang.String str) {
        if (!com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(str)) {
            return str;
        }
        return getVideoPath() + java.io.File.separator + com.up366.common.digest.MD5.md5(str);
    }

    public java.lang.String getLocalImagePath(java.lang.String str) {
        if (!com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(str)) {
            return str;
        }
        return getImagePath() + java.io.File.separator + com.up366.common.digest.MD5.md5(str);
    }
}
