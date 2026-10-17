package com.igexin.push.f.a;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class c {
    public static com.getui.gtc.base.http.GtHttpClient a = new com.getui.gtc.base.http.GtHttpClient.Builder().addInterceptor(new com.getui.gtc.base.http.LoggerInterceptor(com.igexin.c.a.c.a.a().a)).addInterceptor(new com.getui.gtc.base.http.Interceptor() { // from class: com.igexin.push.f.a.c.1
        public final com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException {
            if (com.getui.gtc.base.GtcProvider.context() == null || com.getui.gtc.base.util.NetworkUtil.isNetWorkAvailable(com.getui.gtc.base.GtcProvider.context())) {
                return chain.proceed(chain.request());
            }
            throw new java.lang.IllegalStateException("network is not available");
        }
    }).build();
    private static java.lang.String b = "c";

    private static void a(java.lang.String str, byte[] bArr, com.getui.gtc.base.http.Call.Callback callback) {
        try {
            a.newCall(new com.getui.gtc.base.http.Request.Builder().url(str).method("POST").cryptInterceptor(new com.getui.gtc.base.http.crypt.GtRASCryptoInterceptor(com.igexin.push.a.j, com.igexin.push.a.k)).body(com.getui.gtc.base.http.RequestBody.create(com.getui.gtc.base.http.MediaType.parse("application/json; charset=utf-8"), bArr)).build()).enqueue(callback);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }
}
