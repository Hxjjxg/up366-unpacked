package com.up366.common.http;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class HttpUtilsUp {
    private final okhttp3.OkHttpClient httpClient;
    private static final com.up366.common.http.HttpUtilsUp http = new com.up366.common.http.HttpUtilsUp();
    private static com.up366.common.http.SimpleCodeHandle errCodeHandle = new com.up366.common.http.SimpleCodeHandle();
    private final java.util.concurrent.atomic.AtomicInteger seq = new java.util.concurrent.atomic.AtomicInteger();
    private final com.up366.common.http.CookieManager cookieManager = new com.up366.common.http.CookieManager();

    /* JADX WARN: Removed duplicated region for block: B:15:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private HttpUtilsUp() {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.common.http.HttpUtilsUp.<init>():void");
    }

    static /* synthetic */ boolean lambda$new$0(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
        javax.security.cert.X509Certificate[] peerCertificateChain;
        javax.security.cert.X509Certificate[] peerCertificateChain2;
        com.up366.common.log.Logger.debug("TAG - HttpUtilsUp - verify - hostname = [" + str + "], session = [" + sSLSession + "]");
        try {
            return (!str.contains("up366.cn") || (peerCertificateChain2 = sSLSession.getPeerCertificateChain()) == null || peerCertificateChain2.length <= 0) ? !str.contains("txai.com.cn") || (peerCertificateChain = sSLSession.getPeerCertificateChain()) == null || peerCertificateChain.length <= 0 || peerCertificateChain[0].getSubjectDN().getName().contains("天学") : peerCertificateChain2[0].getSubjectDN().getName().contains("天学网");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static <T> void post(final com.up366.common.http.RequestParams<T> requestParams) {
        if (com.up366.common.task.TaskUtils.isMainThread()) {
            final com.up366.common.task.StackRecordException stackRecordException = new com.up366.common.task.StackRecordException();
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.common.http.HttpUtilsUp$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.common.http.HttpUtilsUp.http.handleRequest(requestParams, stackRecordException);
                }
            });
        } else {
            http.handleRequest(requestParams, null);
        }
    }

    public static <T> com.up366.common.http.NetHolder<T> postSync(final com.up366.common.http.RequestParams<T> requestParams) throws java.lang.InterruptedException {
        final com.up366.common.http.NetHolder<T> netHolder = new com.up366.common.http.NetHolder<>();
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final com.up366.common.task.StackRecordException stackRecordException = new com.up366.common.task.StackRecordException();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.common.http.HttpUtilsUp$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.common.http.HttpUtilsUp.http.handleRequest(requestParams.setOnResponse(new com.up366.common.http.RequestParams.IOnResponse() { // from class: com.up366.common.http.HttpUtilsUp$$ExternalSyntheticLambda2
                    @Override // com.up366.common.http.RequestParams.IOnResponse
                    public final void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                        com.up366.common.http.HttpUtilsUp.lambda$postSync$2(netHolder, countDownLatch, response, obj);
                    }
                }), stackRecordException);
            }
        });
        countDownLatch.await();
        return netHolder;
    }

    static /* synthetic */ void lambda$postSync$2(com.up366.common.http.NetHolder netHolder, java.util.concurrent.CountDownLatch countDownLatch, com.up366.common.http.Response response, java.lang.Object obj) {
        netHolder.initWith(response, obj);
        countDownLatch.countDown();
    }

    public static void clearCookies() {
        http.cookieManager.clear();
    }

    public static void clearCookies(java.lang.String str) {
        http.cookieManager.clear(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void handleRequest(com.up366.common.http.RequestParams<T> requestParams, com.up366.common.task.StackRecordException stackRecordException) {
        java.lang.String url = requestParams.getUrl();
        if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            com.up366.common.log.Logger.info("URL:" + url);
            com.up366.common.log.Logger.warn("Network is not connected!");
            com.up366.common.log.Logger.info("TAG - HttpUtilsUp - handleRequest - checking network connection...");
            com.up366.common.NetworkUtilsUp.checkNetworkConnect();
            if (!com.up366.common.NetworkUtilsUp.isConnected()) {
                com.up366.common.log.Logger.info("TAG - HttpUtilsUp - handleRequest - no connection after check!");
                onError(requestParams, new com.up366.common.http.Response(com.up366.common.http.Response.FAIL_NETWORK_NO_CONNECT, url, "访问服务器失败，请检查网络。", 0, null));
                return;
            }
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(url) || !url.startsWith("http")) {
            com.up366.common.log.Logger.info("URL:" + url);
            com.up366.common.log.Logger.warn("post url is null,configUrl:" + url);
            onError(requestParams, new com.up366.common.http.Response(com.up366.common.http.Response.FAIL_NETWORK_URL_IS_NULL, url, "访问地址无效！", 0, null));
            return;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        errCodeHandle.preHandleRequest(requestParams);
        java.lang.String url2 = requestParams.getUrl();
        com.up366.common.log.Logger.debug("HttpUtilsUp - handleRequest : preHandleRequest : time : " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        com.up366.common.log.Logger.info("URL:" + url2);
        okhttp3.Request.Builder builderHeaders = new okhttp3.Request.Builder().url(url2).headers(okhttp3.Headers.of(requestParams.getHeaders()));
        java.util.Map<java.lang.String, java.lang.String> params = requestParams.getParams();
        if (params.size() > 0) {
            okhttp3.FormBody.Builder builder = new okhttp3.FormBody.Builder();
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : params.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
            builderHeaders.post(builder.build());
        }
        okhttp3.RequestBody requestBody = requestParams.getRequestBody();
        if (requestBody != null) {
            builderHeaders.post(requestBody);
        }
        okhttp3.Request requestBuild = builderHeaders.build();
        com.up366.common.task.StackRecordException stackRecordException2 = new com.up366.common.task.StackRecordException();
        if (stackRecordException != null) {
            stackRecordException2.addSuppressed(stackRecordException);
        }
        final okhttp3.Call callNewCall = this.httpClient.newCall(requestBuild);
        final boolean[] zArr = {false};
        java.lang.String str = "http-wk-" + this.seq.getAndIncrement();
        if (requestParams.getTimeout() > 0) {
            com.up366.common.task.TaskUtils.postLazyTaskGlobal(str, requestParams.getTimeout(), new com.up366.common.task.Task() { // from class: com.up366.common.http.HttpUtilsUp$$ExternalSyntheticLambda4
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    com.up366.common.http.HttpUtilsUp.lambda$handleRequest$4(zArr, callNewCall);
                }
            });
        }
        callNewCall.enqueue(new com.up366.common.http.HttpUtilsUp.AnonymousClass1(str, zArr, stackRecordException2, requestParams));
    }

    static /* synthetic */ void lambda$handleRequest$4(boolean[] zArr, okhttp3.Call call) throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - HttpUtilsUp - handleRequest - do cancel!!!");
        zArr[0] = true;
        call.cancel();
    }

    /* JADX INFO: renamed from: com.up366.common.http.HttpUtilsUp$1, reason: invalid class name */
    class AnonymousClass1 implements okhttp3.Callback {
        final /* synthetic */ boolean[] val$fromCustomTimeout;
        final /* synthetic */ com.up366.common.http.RequestParams val$requestParams;
        final /* synthetic */ com.up366.common.task.StackRecordException val$suppressed;
        final /* synthetic */ java.lang.String val$watchdogKey;

        AnonymousClass1(java.lang.String str, boolean[] zArr, com.up366.common.task.StackRecordException stackRecordException, com.up366.common.http.RequestParams requestParams) {
            this.val$watchdogKey = str;
            this.val$fromCustomTimeout = zArr;
            this.val$suppressed = stackRecordException;
            this.val$requestParams = requestParams;
        }

        public void onFailure(okhttp3.Call call, java.io.IOException iOException) {
            com.up366.common.task.TaskUtils.postLazyTaskGlobal(this.val$watchdogKey, 0, null);
            if (this.val$fromCustomTimeout[0]) {
                iOException = new java.net.SocketTimeoutException("custom timeout");
            }
            com.up366.common.NetworkUtilsUp.checkNetworkConnect();
            iOException.addSuppressed(this.val$suppressed);
            this.val$requestParams.onErrorResponse(iOException);
        }

        public void onResponse(okhttp3.Call call, okhttp3.Response response) {
            okhttp3.ResponseBody responseBodyBody;
            com.up366.common.task.TaskUtils.postLazyTaskGlobal(this.val$watchdogKey, 0, null);
            try {
                responseBodyBody = response.body();
            } catch (java.lang.Exception e) {
                e.addSuppressed(this.val$suppressed);
                this.val$requestParams.onErrorResponse(e);
            }
            if (responseBodyBody == null) {
                throw new java.lang.IllegalStateException("response.body() == null");
            }
            final com.up366.common.http.Response responseCheckAndParseResponse = com.up366.common.http.HttpUtilsUp.checkAndParseResponse(responseBodyBody.string(), this.val$requestParams);
            if (responseCheckAndParseResponse.isError()) {
                com.up366.common.http.HttpUtilsUp.errCodeHandle.handle(this.val$requestParams, responseCheckAndParseResponse);
            } else {
                final java.lang.Object objHandleResponse = this.val$requestParams.handleResponse(responseCheckAndParseResponse, responseCheckAndParseResponse.getResponse());
                final com.up366.common.http.RequestParams requestParams = this.val$requestParams;
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.common.http.HttpUtilsUp$1$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        requestParams.onResponse(responseCheckAndParseResponse, objHandleResponse);
                    }
                });
            }
            com.up366.common.log.Logger.debug("onResponse");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.up366.common.http.Response checkAndParseResponse(java.lang.String str, com.up366.common.http.RequestParams requestParams) {
        if (!requestParams.isCheckFormat()) {
            return new com.up366.common.http.Response(0, requestParams.getUrl(), "", 0, str);
        }
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
            return new com.up366.common.http.Response(object.getJSONObject("result").getIntValue("code"), requestParams.getUrl(), object.getJSONObject("result").getString("msg"), object.getIntValue("totalCount"), object.getString("data"));
        } catch (java.lang.Throwable th) {
            com.up366.common.log.Logger.warn("接口数据格式错误！", th);
            com.up366.common.log.Logger.info("TAG - HttpUtilsUp - checkAndParseResponse - " + str);
            clearHttpCache();
            return new com.up366.common.http.Response(com.up366.common.http.Response.FAIL_FORMAT_ERROR, requestParams.getUrl(), "接口数据格式错误", 0, str);
        }
    }

    private void onError(final com.up366.common.http.RequestParams<?> requestParams, final com.up366.common.http.Response response) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.common.http.HttpUtilsUp$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() {
                requestParams.onResponse(response, null);
            }
        });
    }

    public static void clearHttpCache() {
        try {
            okhttp3.Cache cache = http.httpClient.cache();
            if (cache != null) {
                cache.evictAll();
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - HttpUtilsUp - clearHttpCache - ", e);
        }
    }

    public static void setErrCodeHandle(com.up366.common.http.SimpleCodeHandle simpleCodeHandle) {
        errCodeHandle = simpleCodeHandle;
    }

    public static void addCookie(java.lang.String str, java.lang.String str2, java.lang.String str3, long j, java.lang.String str4, java.lang.String str5, boolean z, boolean z2, boolean z3) {
        okhttp3.Cookie.Builder builderName = new okhttp3.Cookie.Builder().name(str2).value(str3).expiresAt(j).domain(str4).path(str5).name(str2);
        if (z) {
            builderName.secure();
        }
        if (z2) {
            builderName.httpOnly();
        }
        if (z3) {
            builderName.httpOnly();
        }
        http.cookieManager.addCookie(str, builderName.build());
    }

    public static java.util.List<okhttp3.Cookie> loadForRequest(okhttp3.HttpUrl httpUrl) {
        return http.cookieManager.loadForRequest(httpUrl);
    }
}
