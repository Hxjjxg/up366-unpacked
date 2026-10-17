package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AttachmentUtils {
    public static final int MIME_EXCEL = 6;
    public static final int MIME_IMAGE = 1;
    public static final int MIME_PPT = 5;
    public static final int MIME_TEXT = 3;
    public static final int MIME_VIDEO = 2;
    public static final int MINE_PDF = 4;
    public static final int MINE_WORD = 7;
    private static final java.lang.String[][] MIME_MapTable = {new java.lang.String[]{"3gp", "video/3gpp"}, new java.lang.String[]{"apk", "application/vnd.android.package-archive"}, new java.lang.String[]{"asf", "video/x-ms-asf"}, new java.lang.String[]{"avi", "video/x-msvideo"}, new java.lang.String[]{"bin", "application/octet-stream"}, new java.lang.String[]{"bmp", "image/bmp"}, new java.lang.String[]{com.igexin.push.core.d.d.d, gdut.bsx.share2.ShareContentType.TEXT}, new java.lang.String[]{"class", "application/octet-stream"}, new java.lang.String[]{"conf", gdut.bsx.share2.ShareContentType.TEXT}, new java.lang.String[]{"cpp", gdut.bsx.share2.ShareContentType.TEXT}, new java.lang.String[]{"doc", "application/msword"}, new java.lang.String[]{"docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"}, new java.lang.String[]{"xls", "application/vnd.ms-excel"}, new java.lang.String[]{"xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"}, new java.lang.String[]{"exe", "application/octet-stream"}, new java.lang.String[]{"gif", "image/gif"}, new java.lang.String[]{"gtar", "application/x-gtar"}, new java.lang.String[]{"gz", "application/x-gzip"}, new java.lang.String[]{"h", gdut.bsx.share2.ShareContentType.TEXT}, new java.lang.String[]{"htm", "text/html"}, new java.lang.String[]{"html", "text/html"}, new java.lang.String[]{"jar", "application/java-archive"}, new java.lang.String[]{"java", gdut.bsx.share2.ShareContentType.TEXT}, new java.lang.String[]{"jpeg", "image/jpeg"}, new java.lang.String[]{"jpg", "image/jpeg"}, new java.lang.String[]{"js", "application/x-javascript"}, new java.lang.String[]{"log", gdut.bsx.share2.ShareContentType.TEXT}, new java.lang.String[]{"m3u", "audio/x-mpegurl"}, new java.lang.String[]{"m4a", "audio/mp4a-latm"}, new java.lang.String[]{"m4b", "audio/mp4a-latm"}, new java.lang.String[]{"m4p", "audio/mp4a-latm"}, new java.lang.String[]{"m4u", "video/vnd.mpegurl"}, new java.lang.String[]{"m4v", "video/x-m4v"}, new java.lang.String[]{"mov", "video/quicktime"}, new java.lang.String[]{"mp2", "audio/x-mpeg"}, new java.lang.String[]{"mp3", "audio/x-mpeg"}, new java.lang.String[]{"mp4", "video/mp4"}, new java.lang.String[]{"mpc", "application/vnd.mpohun.certificate"}, new java.lang.String[]{"mpe", "video/mpeg"}, new java.lang.String[]{"mpeg", "video/mpeg"}, new java.lang.String[]{"mpg", "video/mpeg"}, new java.lang.String[]{"mpg4", "video/mp4"}, new java.lang.String[]{"mpga", "audio/mpeg"}, new java.lang.String[]{"msg", "application/vnd.ms-outlook"}, new java.lang.String[]{"ogg", "audio/ogg"}, new java.lang.String[]{"pdf", "application/pdf"}, new java.lang.String[]{"png", com.up366.medialibrary.common.utils.MimeTypeUtils.PNG_Q}, new java.lang.String[]{"pps", "application/vnd.ms-powerpoint"}, new java.lang.String[]{"ppt", "application/vnd.ms-powerpoint"}, new java.lang.String[]{"pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation"}, new java.lang.String[]{"prop", gdut.bsx.share2.ShareContentType.TEXT}, new java.lang.String[]{"rc", gdut.bsx.share2.ShareContentType.TEXT}, new java.lang.String[]{"rmvb", "audio/x-pn-realaudio"}, new java.lang.String[]{"rtf", "application/rtf"}, new java.lang.String[]{"sh", gdut.bsx.share2.ShareContentType.TEXT}, new java.lang.String[]{"tar", "application/x-tar"}, new java.lang.String[]{"tgz", "application/x-compressed"}, new java.lang.String[]{"txt", gdut.bsx.share2.ShareContentType.TEXT}, new java.lang.String[]{"wav", com.up366.medialibrary.common.utils.MimeTypeUtils.WAV_Q}, new java.lang.String[]{"wma", "audio/x-ms-wma"}, new java.lang.String[]{"wmv", "audio/x-ms-wmv"}, new java.lang.String[]{"wps", "application/vnd.ms-works"}, new java.lang.String[]{"xml", gdut.bsx.share2.ShareContentType.TEXT}, new java.lang.String[]{"z", "application/x-compress"}, new java.lang.String[]{"zip", "application/x-zip-compressed"}, new java.lang.String[]{"", gdut.bsx.share2.ShareContentType.FILE}};
    private static final java.lang.String[] imageMIME = {"image/bmp", "image/x-ms-bmp", "image/jpeg", "image/gif", com.up366.medialibrary.common.utils.MimeTypeUtils.PNG_Q, "image/tiff", "image/x-targa", "image/vnd.adobe.photoshop"};
    private static final java.lang.String[] videoMIME = {"video/x-msvideo", "video/x-dv", "video/mp4", "video/mpeg", "video/quicktime", "video/x-ms-wmv", "video/x-flv", "video/x-matroska"};
    private static final java.lang.String[] textMIME = {gdut.bsx.share2.ShareContentType.TEXT, "text/x-php", "text/html", "text/css", "text/rtf", "text/rtfd", "text/x-python", "text/x-java-source", "text/x-ruby", "text/x-shellscript", "text/x-perl", "text/x-sql"};
    private static final java.lang.String[] pdfMIME = {"application/pdf"};
    private static final java.lang.String[] pptMIME = {"application/vnd.ms-powerpoint", "application/vnd.openxmlformats-officedocument.presentationml.presentation"};
    private static final java.lang.String[] wordMIME = {"application/vnd.ms-word", "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"};
    private static final java.lang.String[] excelMIME = {"application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"};

    public static void openFile(java.io.File file) {
        openFile(file, getMIMEType(file));
    }

    public static void openUrl(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.commonui.CommonWebViewActivity.class);
        intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, str);
        intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL_NAME, str2);
        context.startActivity(intent);
    }

    public static void openFile(java.io.File file, java.lang.String str) {
        if (file == null || !file.exists()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("open file error,file not exit,file is  ");
            sb.append(file);
            com.up366.common.log.Logger.error(sb.toString() == null ? null : file.getAbsolutePath());
            android.widget.Toast.makeText(com.up366.common.global.GB.get().getApplicationContext(), "文件不存在！", 0).show();
            return;
        }
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setFlags(1);
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(androidx.core.content.FileProvider.getUriForFile(com.up366.common.global.GB.get().getApplicationContext(), com.up366.common.global.GB.get().getApplicationId(), file), str);
            com.up366.common.global.GB.get().getApplicationContext().startActivity(intent);
        } catch (android.content.ActivityNotFoundException unused) {
            android.widget.Toast.makeText(com.up366.common.global.GB.get().getApplicationContext(), "附件不能打开，请下载相关软件！", 0).show();
        }
    }

    private static java.lang.String getMIMEType(java.io.File file) {
        java.lang.String name;
        int iLastIndexOf;
        java.lang.String lowerCase;
        java.lang.String str = gdut.bsx.share2.ShareContentType.FILE;
        if (file == null || (iLastIndexOf = (name = file.getName()).lastIndexOf(".")) < 0 || (lowerCase = name.substring(iLastIndexOf + 1, name.length()).toLowerCase()) == "") {
            return gdut.bsx.share2.ShareContentType.FILE;
        }
        for (java.lang.String[] strArr : MIME_MapTable) {
            if (lowerCase.equalsIgnoreCase(strArr[0])) {
                str = strArr[1];
            }
        }
        return str;
    }

    public static java.lang.String getMIMEType(java.lang.String str) {
        java.lang.String strSubstring = str.substring(str.lastIndexOf(".") + 1);
        java.lang.String str2 = "raw/binary";
        if (com.up366.common.StringUtils.isEmptyOrNull(strSubstring)) {
            return "raw/binary";
        }
        for (java.lang.String[] strArr : MIME_MapTable) {
            if (strSubstring.equalsIgnoreCase(strArr[0])) {
                str2 = strArr[1];
            }
        }
        return str2;
    }

    public static int getFileType(java.lang.String str) {
        java.lang.String mIMEType = getMIMEType(str);
        if (java.util.Arrays.toString(imageMIME).contains(mIMEType)) {
            return 1;
        }
        if (java.util.Arrays.toString(videoMIME).contains(mIMEType)) {
            return 2;
        }
        if (java.util.Arrays.toString(textMIME).contains(mIMEType)) {
            return 3;
        }
        if (java.util.Arrays.toString(pdfMIME).contains(mIMEType)) {
            return 4;
        }
        if (java.util.Arrays.toString(pptMIME).contains(mIMEType)) {
            return 5;
        }
        if (java.util.Arrays.toString(excelMIME).contains(mIMEType)) {
            return 6;
        }
        return java.util.Arrays.toString(wordMIME).contains(mIMEType) ? 7 : 3;
    }
}
