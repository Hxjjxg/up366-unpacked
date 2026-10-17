package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public enum EnumC0060q {
    LOGIN_SUCCESS_CODE(1000, 1000, "获取token成功", "token success"),
    OPEN_PAGE_SUCCESS_CODE(1000, 1000, "授权页拉起成功", "start activity success"),
    CMCC_UNAVAILABLE_CODE(1001, 11001, "移动错误", "cmcc unavailable"),
    CUCC_UNAVAILABLE_CODE(1001, 11002, "联通错误", "cucc unavailable"),
    CTCC_UNAVAILABLE_CODE(1001, 11003, "电信错误", "ctcc unavailable"),
    REQUEST_DATA_ERROR_CODE(1002, 1002, "响应内容错误", "content error_"),
    REQUEST_TOKEN_ERROR_CODE(1003, 1003, "获取token失败", "token failed_"),
    NOT_INITIALIZED_CODE(1004, 1004, "未初始化", "not init_"),
    PRE_REQUEST_FAILED_CODE(1005, 1005, "请求失败", "request failed_"),
    REQUEST_FAILED_CODE(1007, 1007, "网络异常", "request anomaly_"),
    DATA_REQUEST_FAILED_CODE(1008, 1008, "数据流量不稳定", "network instability_"),
    USER_CANCEL_CODE(1011, 1011, "点击返回", "cancel"),
    SDK_EXCEPTION_CODE(1014, 1014, "异常", "SDK Exception_"),
    APPID_NULL_CODE(1016, 1016, "appid为空", "appid is null_"),
    INIT_SUCCESS_CODE(1022, 1022, "初始化成功", "init success"),
    INIT_CACHE_SUCCESS_CODE(1022, 0, "初始化成功", "success"),
    PRE_SUCCESS_CODE(1022, 1022, "预取号成功", "preInfo success"),
    PRE_CACHE_SUCCESS_CODE(1022, 0, "预取号成功", "success"),
    TIME_OUT_CODE(1023, 0, "超时", "timeout_"),
    AUTHPAGE_LOADING_CODE(1024, 0, "进行中", "in progress"),
    ACCOUNT_DISABLED_CODE(1032, 1032, "禁用", "account disabled_"),
    AUTH_TOKEN_FAILED_CODE(2003, 2003, "获取token失败", "token failed_"),
    AUTH_TOKEN_SUCCESS_CODE(2000, 2000, "获取token成功", "token success");

    private final int a;
    private final int b;
    private final java.lang.String c;
    private final java.lang.String d;

    EnumC0060q(int i, int i2, java.lang.String str, java.lang.String str2) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
    }

    public int b() {
        return this.b;
    }

    public java.lang.String c() {
        return this.d;
    }

    public int d() {
        return this.a;
    }

    public java.lang.String e() {
        return this.c;
    }
}
