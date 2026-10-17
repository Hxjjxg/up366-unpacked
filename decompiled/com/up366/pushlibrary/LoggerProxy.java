package com.up366.pushlibrary;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class LoggerProxy {
    public static void error(java.lang.String str) {
        try {
            com.up366.common.log.Logger.error(str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void info(java.lang.String str) {
        try {
            com.up366.common.log.Logger.info(str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
