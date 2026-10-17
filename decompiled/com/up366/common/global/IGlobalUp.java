package com.up366.common.global;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface IGlobalUp {
    void addCommonHttpHeaders(com.up366.common.http.RequestParams<?> requestParams, java.util.Map<java.lang.String, java.lang.Object> map);

    void addCommonHttpParams(java.util.Map<java.lang.String, java.lang.Object> map);

    java.lang.String addSign(android.view.View view, java.lang.String str, int i, int i2);

    android.content.Context getApplicationContext();

    java.lang.String getApplicationId();

    com.alibaba.fastjson.JSONObject getConfig();

    android.app.Activity getCurrentActivity();

    java.lang.String getHttpCacheDir();

    java.lang.String getImgCacheDir();

    long getNtpDiffTime();

    long getReliableTime();

    java.lang.String getServerUrl(java.lang.String str);

    java.lang.String getUniqueDeviceId();

    @java.lang.Deprecated
    void sendLog(java.lang.String str);

    void sendLog(java.lang.String str, java.lang.String str2);

    void setCurrentActivity(android.app.Activity activity);

    java.lang.String wrapUrl(java.lang.String str);
}
