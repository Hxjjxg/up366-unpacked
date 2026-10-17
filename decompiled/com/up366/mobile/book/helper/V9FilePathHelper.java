package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V9FilePathHelper {
    public static java.lang.String getV9RootResourceDir() {
        return com.up366.mobile.common.utils.AppFileUtils.getV9RootResourceDir();
    }

    public static java.lang.String getRecordPath(java.lang.String str) {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getUserRootPath(), "record_v9", str + com.up366.medialibrary.common.utils.MimeTypeUtils.WAV);
    }

    public static java.lang.String getMuxPath(java.lang.String str) {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getUserRootPath(), "mux_v9", str);
    }

    public static java.lang.String getPhotoDir() {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getUserRootPath(), "photo_v9");
    }

    public static java.lang.String getGlobalPath() {
        return com.up366.common.FileUtilsUp.join(getV9RootResourceDir(), "Global/");
    }

    public java.lang.String getGlobalFontPath() {
        return com.up366.common.FileUtilsUp.join(getV9RootResourceDir(), com.up366.mobile.book.helper.V9FontHelper.FONT_DIR);
    }

    public java.lang.String getBooksPath() {
        return com.up366.common.FileUtilsUp.join(getV9RootResourceDir(), "Books/");
    }

    public java.lang.String getChaptersPath() {
        return com.up366.common.FileUtilsUp.join(getV9RootResourceDir(), "Chapters/");
    }

    public static java.lang.String getQuestionsPath() {
        return com.up366.common.FileUtilsUp.join(getV9RootResourceDir(), "Questions/");
    }

    public java.lang.String getExtendPath() {
        return com.up366.common.FileUtilsUp.join(getV9RootResourceDir(), "Extend/");
    }

    public static java.lang.String getMainHtmlPagePath(java.lang.String str) {
        return com.up366.common.FileUtilsUp.join(getGlobalPath(), str, "index.html");
    }
}
