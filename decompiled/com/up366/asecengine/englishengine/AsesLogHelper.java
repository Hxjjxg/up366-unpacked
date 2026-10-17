package com.up366.asecengine.englishengine;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AsesLogHelper {
    private static final java.lang.String LOG_PREFIX = "ases_log_";
    private static java.lang.String logDir;

    public static void setLogDir(java.lang.String str) {
        logDir = str;
    }

    static void addLogParams(java.util.List<com.up366.asecengine.model.KeyValue> list) {
        if (com.up366.common.StringUtils.isEmptyOrNull(logDir)) {
            return;
        }
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(logDir, LOG_PREFIX + java.lang.System.currentTimeMillis() + ".log");
        com.up366.common.FileUtilsUp.mkdirParentDir(strJoin);
        com.up366.common.log.Logger.info("TAG - AsesLogHelper - engine.log - " + strJoin);
        list.add(new com.up366.asecengine.model.KeyValue("log-open", strJoin));
        list.add(new com.up366.asecengine.model.KeyValue("log-level", "2"));
    }

    static void closeLog(com.up366.asecengine.jni.AsesJni asesJni, java.lang.String str) {
        int iLsxAsesSessionSetParam = asesJni.LsxAsesSessionSetParam(str, "log-close", "1");
        if (iLsxAsesSessionSetParam != 0) {
            com.up366.common.log.Logger.error("TAG - AsesLogHelper - closeLog - sessionId = [" + str + "]  result:" + iLsxAsesSessionSetParam);
        }
    }

    public static void cleanLog(com.up366.asecengine.englishengine.AsecSession asecSession) {
        java.lang.String logFile = getLogFile(asecSession);
        com.up366.common.log.Logger.info("TAG - AsesLogHelper - cleanLog - " + logFile + " ," + asecSession.isAutoCleanLog());
        if (asecSession.isAutoCleanLog()) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(logFile);
        }
    }

    public static java.lang.String getLogFile(com.up366.asecengine.englishengine.AsecSession asecSession) {
        if (asecSession == null) {
            return null;
        }
        for (com.up366.asecengine.model.KeyValue keyValue : asecSession.getSessionParams()) {
            if ("log-open".equals(keyValue.key)) {
                if (com.up366.common.FileUtilsUp.isFileExists(keyValue.value)) {
                    return keyValue.value;
                }
                return null;
            }
        }
        return null;
    }

    public static java.util.List<java.lang.String> listLogs() {
        java.lang.String[] list;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!com.up366.common.FileUtilsUp.isFileExists(logDir) || (list = new java.io.File(logDir).list()) == null) {
            return arrayList;
        }
        for (java.lang.String str : list) {
            if (str.startsWith(LOG_PREFIX)) {
                arrayList.add(com.up366.common.FileUtilsUp.join(logDir, str));
            }
        }
        return arrayList;
    }
}
