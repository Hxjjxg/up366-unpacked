package com.up366.common.http;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TimeoutInterceptor implements okhttp3.Interceptor {
    public static final java.lang.String HEADER_CONNECT_TIMEOUT = "X-Connect-Timeout";
    public static final java.lang.String HEADER_READ_TIMEOUT = "X-Read-Timeout";
    public static final java.lang.String HEADER_WRITE_TIMEOUT = "X-Write-Timeout";

    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        okhttp3.Request request = chain.request();
        java.lang.String strHeader = request.header(HEADER_READ_TIMEOUT);
        java.lang.String strHeader2 = request.header(HEADER_CONNECT_TIMEOUT);
        java.lang.String strHeader3 = request.header(HEADER_WRITE_TIMEOUT);
        if (strHeader != null) {
            chain = chain.withReadTimeout(java.lang.Integer.parseInt(strHeader), java.util.concurrent.TimeUnit.MILLISECONDS);
        }
        if (strHeader2 != null) {
            chain = chain.withConnectTimeout(java.lang.Integer.parseInt(strHeader2), java.util.concurrent.TimeUnit.MILLISECONDS);
        }
        if (strHeader3 != null) {
            chain = chain.withWriteTimeout(java.lang.Integer.parseInt(strHeader3), java.util.concurrent.TimeUnit.MILLISECONDS);
        }
        return chain.proceed(request);
    }
}
