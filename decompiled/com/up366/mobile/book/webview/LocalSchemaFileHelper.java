package com.up366.mobile.book.webview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LocalSchemaFileHelper {
    public android.webkit.WebResourceResponse getJsWebResourceResponse(java.lang.String str) {
        if (!com.up366.common.FileUtilsUp.isFileExists(str)) {
            return null;
        }
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(str);
            com.up366.common.log.Logger.info("TAG - LocalSchemaFileHelper - getJsWebResourceResponse - decrypt load - path:" + str);
            return new android.webkit.WebResourceResponse(android.webkit.MimeTypeMap.getFileExtensionFromUrl(android.net.Uri.fromFile(new java.io.File(str)).toString()), "UTF-8", fileInputStream);
        } catch (java.lang.Exception e) {
            com.up366.mobile.common.onlinelog.OpLog.report("ERROR-LocalSchemaFileHelper-decrypt", str, e);
            com.up366.common.log.Logger.error(e);
            return null;
        }
    }
}
