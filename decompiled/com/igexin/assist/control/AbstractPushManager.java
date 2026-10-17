package com.igexin.assist.control;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface AbstractPushManager {
    java.lang.String getBrandCode();

    java.lang.String getToken(android.content.Context context);

    boolean isSupport();

    void register(android.content.Context context);

    void setSilentTime(android.content.Context context, int i, int i2);

    void turnOffPush(android.content.Context context);

    void turnOnPush(android.content.Context context);

    void unregister(android.content.Context context);
}
