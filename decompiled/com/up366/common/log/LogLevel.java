package com.up366.common.log;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public enum LogLevel {
    VERBOSE,
    DEBUG,
    INFO,
    WARN,
    ERROR;

    public com.up366.common.log.LogLevel getLogLevel(int i) {
        if (i == 0) {
            return VERBOSE;
        }
        if (i == 1) {
            return DEBUG;
        }
        if (i == 2) {
            return INFO;
        }
        if (i == 3) {
            return WARN;
        }
        if (i == 4) {
            return ERROR;
        }
        return ERROR;
    }
}
