package com.up366.mobile.jump;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class JumpUtils {
    public static final int JUMP_JUST_COMMON_STR = 3;
    public static final int JUMP_TO_BOOK_COMMON = 8;
    public static final int JUMP_TO_BOOK_FROM_NAN_TONG = 4;
    public static final int JUMP_TO_BOOK_IMMEDIATELY = 0;
    public static final int JUMP_TO_BOOK_WITH_TOKEN = 1;
    public static final int JUMP_TO_CHAT_PAGE = 9;
    public static final int JUMP_TO_DAILY_WRITE_TRY = 6;
    public static final int JUMP_TO_JSSDK_WEBVIEW = 10;
    public static final int JUMP_TO_NEW_JOB_DETAIL = 7;
    public static final int JUMP_TO_SEARCH_COURSE = 5;
    public static final int JUMP_TO_WEBVIEW = 2;

    private static java.lang.String getSchema(java.lang.String str) {
        try {
            return str.split("://")[0];
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("JumpUtils - getSchema - " + e.getMessage() + " url:" + str, e);
            com.up366.mobile.common.onlinelog.OpLog.report("JumpUtils-ERR-URL", str);
            return "";
        }
    }

    private static java.lang.String getHostPath(java.lang.String str) {
        try {
            return str.split("\\?")[0].split("://")[1];
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("JumpUtils - getHostPath - " + e.getMessage() + " url:" + str, e);
            com.up366.mobile.common.onlinelog.OpLog.report("JumpUtils-ERR-URL", str);
            return "";
        }
    }

    public static java.util.Map<java.lang.String, java.lang.String> getParamsFromUrl(java.lang.String str) {
        java.lang.String strDecode;
        java.util.HashMap map = new java.util.HashMap();
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return map;
        }
        java.lang.String[] strArrSplit = str.split("\\?");
        if (strArrSplit.length < 2) {
            return map;
        }
        java.lang.String str2 = strArrSplit[1];
        if (com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            return map;
        }
        for (java.lang.String str3 : str2.split("&")) {
            java.lang.String[] strArrSplit2 = str3.split("=");
            java.lang.String str4 = strArrSplit2[0];
            if (strArrSplit2.length == 2) {
                try {
                    strDecode = java.net.URLDecoder.decode(strArrSplit2[1], com.igexin.push.g.s.b);
                } catch (java.io.UnsupportedEncodingException unused) {
                    strDecode = "";
                }
            } else {
                strDecode = "";
            }
            map.put(str4, strDecode);
        }
        return map;
    }

    public static int judgeUrlType(java.lang.String str) {
        com.up366.mobile.common.onlinelog.OpLog.report("Jump-URL", str);
        java.lang.String schema = getSchema(str);
        java.lang.String hostPath = getHostPath(str);
        java.util.Map<java.lang.String, java.lang.String> paramsFromUrl = getParamsFromUrl(str);
        if ("jssdkwebview".equals(hostPath)) {
            return 10;
        }
        if (paramsFromUrl.containsKey("groupid")) {
            return 9;
        }
        if ("book".equals(hostPath)) {
            return 8;
        }
        if (paramsFromUrl.containsKey("j")) {
            return 1;
        }
        if ("jump".equals(paramsFromUrl.get("flag"))) {
            return paramsFromUrl.containsKey("username") ? 4 : 0;
        }
        if (schema.matches("https?")) {
            return 2;
        }
        if ("write".equals(hostPath)) {
            return 6;
        }
        if ("joinCourse".equals(hostPath)) {
            return 5;
        }
        return "new".equals(hostPath) ? 7 : 3;
    }

    public static java.lang.String getCourseIdFromURI(java.lang.String str) {
        return getParamsFromUrl(str).get(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID);
    }

    public static java.lang.String getBookIdFromURI(java.lang.String str) {
        return getParamsFromUrl(str).get(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
    }

    public static java.lang.String getChapterIdFromURI(java.lang.String str) {
        return getParamsFromUrl(str).get("chapterId");
    }

    public static java.lang.String getPagerIdFromURI(java.lang.String str) {
        return getParamsFromUrl(str).get("pageId");
    }

    public static java.lang.String getRequestParFromUrl(java.lang.String str) {
        return getParamsFromUrl(str).get("j");
    }

    public static java.lang.String getUserNameFromURI(java.lang.String str) {
        return getParamsFromUrl(str).get("username");
    }

    public static java.lang.String getCourseCodeFromUrl(java.lang.String str) {
        return getParamsFromUrl(str).get("courseCode");
    }

    public static java.lang.String getFDateFromUrl(java.lang.String str) {
        return getParamsFromUrl(str).get("fdate");
    }

    public static java.lang.String encodeUrl(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return "";
        }
        return str.replace("=", "DEHAO").replace("?", "WENHAO").replace("&", "ANDHAO").replace("#", "JINGHAO");
    }

    public static java.lang.String decodeUrl(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return "";
        }
        return str.replace("DEHAO", "=").replace("WENHAO", "?").replace("ANDHAO", "&").replace("JINGHAO", "#");
    }
}
