package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V8FilePathHelper {
    public java.lang.String getResourceRootDir() {
        return com.up366.mobile.common.utils.AppFileUtils.getRootResourceDir();
    }

    public java.lang.String getResourceDir(java.lang.String str) {
        return com.up366.common.FileUtilsUp.join(getResourceRootDir(), str);
    }

    public static java.lang.String getRecordPath(java.lang.String str) {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getUserRootPath(), "record_v8", str + com.up366.medialibrary.common.utils.MimeTypeUtils.WAV);
    }

    public static java.lang.String getMuxPath(java.lang.String str) {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getUserRootPath(), "mux_v8", str);
    }

    public static java.lang.String getPhotoDir() {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getUserRootPath(), "photo_v8");
    }

    private java.lang.String getConfigPath(java.lang.String str) throws java.lang.Throwable {
        java.lang.String fileContent = com.up366.common.FileUtilsUp.getFileContent(com.up366.common.FileUtilsUp.join(getResourceDir(str), "config.json"));
        com.up366.common.log.Logger.info("getConfigPath json" + fileContent + "  path :" + com.up366.common.FileUtilsUp.join(getResourceDir(str), "config.json"));
        if (com.up366.common.StringUtils.isEmptyOrNull(fileContent)) {
            return null;
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(fileContent);
        com.up366.common.log.Logger.info("getConfigPath json" + object);
        if (object == null) {
            return null;
        }
        return com.up366.common.FileUtilsUp.join(getResourceDir(str), object.getString("catalogPath"));
    }

    public java.lang.String getMainHtmlPagePath(java.lang.String str) throws java.lang.Throwable {
        java.lang.String configPath = getConfigPath(str);
        return com.up366.common.FileUtilsUp.isFileExists(configPath) ? configPath : com.up366.common.FileUtilsUp.join(getResourceDir(str), "resources/mobile/bookCatalog.html");
    }
}
