package com.up366.common.http;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class Response {
    public static final int DATA_NOT_FOUND = -3;
    public static final int DATA_OVER = 100;
    public static final int DEPRECATED = -6;
    public static final int FAIL_FORMAT_ERROR = -10004;
    public static final int FAIL_NETWORK = -10001;
    public static final int FAIL_NETWORK_NO_CONNECT = -10000;
    public static final int FAIL_NETWORK_TIME_OUT = -10002;
    public static final int FAIL_NETWORK_URL_IS_NULL = -10003;
    public static final int NO_AUTH = -4;
    public static final int NO_CHECK_SIGN = -8;
    public static final int PARAM_ERROR = -2;
    public static final int PARAM_MISSING = -1;
    public static final int RESULT_INVALID_REQUEST = -98;
    public static final int RESULT_OK = 0;
    public static final int RESULT_SSO_GEN_ST_FAILED = -25;
    public static final int RESULT_SSO_GEN_ST_OK = -24;
    public static final int RESULT_SSO_GEN_TGT_FAILED = -27;
    public static final int RESULT_SSO_GEN_TGT_OK = -26;
    public static final int RESULT_SSO_LOGIN_FREEZE = -30;
    public static final int RESULT_SSO_LOGIN_FREEZE_BY_USER_LOG_OFF = -50;
    public static final int RESULT_SSO_LOGIN_LOCKED = -29;
    public static final int RESULT_SSO_LOGIN_LOCKED_TERMINAL = -31;
    public static final int RESULT_SSO_LOGIN_OUT_OK = -28;
    public static final int RESULT_SSO_NO_LOGIN = -21;
    public static final int RESULT_SSO_NO_TGT = -23;
    public static final int RESULT_SSO_VAILD_ST_FAILED = -22;
    public static final int RESULT_SSO_WECHAT_LOGIN_NOT_BIND = -32;
    public static final int RESULT_V10_SERVER_ERROR = -99;
    private int code;
    private java.lang.String info;
    private java.lang.String response;
    private int totalCount;
    private java.lang.String url;

    public static boolean isError(int i) {
        return (i == 0 || i == 100) ? false : true;
    }

    public Response() {
        this.code = -234;
    }

    public Response(int i, java.lang.String str, java.lang.String str2, int i2, java.lang.String str3) {
        this.code = i;
        this.url = str;
        this.info = str2;
        this.totalCount = i2;
        this.response = str3;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }

    public java.lang.String getInfo() {
        return this.info;
    }

    public void setInfo(java.lang.String str) {
        this.info = str;
    }

    public java.lang.String getResponse() {
        return this.response;
    }

    public void setResponse(java.lang.String str) {
        this.response = str;
    }

    public java.lang.String toString() {
        return "Response{code=" + this.code + ", url='" + this.url + "', info='" + this.info + "', response='" + this.response + "', totalCount=" + this.totalCount + '}';
    }

    public boolean isError() {
        int i = this.code;
        return (i == 0 || i == 100) ? false : true;
    }
}
