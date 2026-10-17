package com.up366.mobile.common.crash;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface CrashLevelHandlingStrategy<T> {
    java.lang.String getCrashLevelSummary(java.lang.String str);

    java.lang.String getCrashType();

    void handleCrash(T t);
}
