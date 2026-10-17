package com.up366.common.http;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RequestParams<T> {
    private static java.lang.String userAgent;
    private com.up366.common.http.RequestParams.IAddHeaders addHeaderCallback;
    private com.up366.common.http.RequestParams.IAddParams addParamCallback;
    private final boolean checkFormat;
    private com.up366.common.http.RequestParams.IHandleResponse<T> handleResponseCallback;
    private com.up366.common.http.RequestParams.IOnResponse<T> onResponseCallback;
    private okhttp3.RequestBody requestBody;
    private int timeout;
    private java.lang.String url;

    public interface IAddHeaders {
        void addHeaders(java.util.Map<java.lang.String, java.lang.Object> map);
    }

    public interface IAddParams {
        void addParams(java.util.Map<java.lang.String, java.lang.Object> map);
    }

    public interface IHandleResponse<T> {
        T handleResponse(com.up366.common.http.Response response, java.lang.String str);
    }

    public interface IOnResponse<T> {
        void onResponse(com.up366.common.http.Response response, T t);
    }

    public void initHeaders(java.util.Map<java.lang.String, java.lang.Object> map) {
    }

    public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
    }

    public RequestParams(java.lang.String str) {
        this.url = str;
        this.checkFormat = true;
    }

    public RequestParams(java.lang.String str, boolean z) {
        this.url = str;
        this.checkFormat = z;
    }

    public final java.util.Map<java.lang.String, java.lang.String> getHeaders() {
        if (com.up366.common.StringUtils.isEmptyOrNull(userAgent)) {
            throw new java.lang.IllegalStateException("需要在app中初始化USER_AGENT字符串");
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put("User-Agent", userAgent);
        map.put("X-Requested-With", "android");
        java.lang.String uniqueDeviceId = com.up366.common.global.GB.get().getUniqueDeviceId();
        if (uniqueDeviceId == null) {
            uniqueDeviceId = "";
        }
        map.put("clientId", uniqueDeviceId);
        com.up366.common.global.GB.get().addCommonHttpHeaders(this, map);
        initHeaders(map);
        com.up366.common.http.RequestParams.IAddHeaders iAddHeaders = this.addHeaderCallback;
        if (iAddHeaders != null) {
            iAddHeaders.addHeaders(map);
        }
        java.util.HashMap map2 = new java.util.HashMap(map.size());
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : map.entrySet()) {
            java.lang.Object value = entry.getValue();
            if (value == null) {
                map2.put(entry.getKey(), "");
            } else {
                map2.put(entry.getKey(), java.lang.String.valueOf(value));
            }
        }
        return map2;
    }

    public final java.util.Map<java.lang.String, java.lang.String> getParams() {
        java.util.HashMap map = new java.util.HashMap();
        com.up366.common.global.GB.get().addCommonHttpParams(map);
        initParams(map);
        com.up366.common.http.RequestParams.IAddParams iAddParams = this.addParamCallback;
        if (iAddParams != null) {
            iAddParams.addParams(map);
        }
        java.util.HashMap map2 = new java.util.HashMap(map.size());
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : map.entrySet()) {
            java.lang.Object value = entry.getValue();
            if (value == null) {
                map2.put(entry.getKey(), "");
            } else {
                map2.put(entry.getKey(), java.lang.String.valueOf(value));
            }
        }
        return map2;
    }

    public final com.up366.common.http.RequestParams<T> addHeaders(com.up366.common.http.RequestParams.IAddHeaders iAddHeaders) {
        this.addHeaderCallback = iAddHeaders;
        return this;
    }

    public final com.up366.common.http.RequestParams<T> addParams(com.up366.common.http.RequestParams.IAddParams iAddParams) {
        this.addParamCallback = iAddParams;
        return this;
    }

    public final com.up366.common.http.RequestParams<T> setRequestBody(okhttp3.RequestBody requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    public final com.up366.common.http.RequestParams<T> setResponseHandler(com.up366.common.http.RequestParams.IHandleResponse<T> iHandleResponse) {
        this.handleResponseCallback = iHandleResponse;
        return this;
    }

    final com.up366.common.http.RequestParams<T> setOnResponse(com.up366.common.http.RequestParams.IOnResponse<T> iOnResponse) {
        this.onResponseCallback = iOnResponse;
        return this;
    }

    public okhttp3.RequestBody getRequestBody() {
        return this.requestBody;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T handleResponse(com.up366.common.http.Response response, java.lang.String str) {
        com.up366.common.http.RequestParams.IHandleResponse<T> iHandleResponse = this.handleResponseCallback;
        return iHandleResponse != null ? iHandleResponse.handleResponse(response, str) : str;
    }

    public void onResponse(com.up366.common.http.Response response, T t) {
        com.up366.common.log.Logger.debug("onResponse - " + response.getUrl());
        com.up366.common.http.RequestParams.IOnResponse<T> iOnResponse = this.onResponseCallback;
        if (iOnResponse != null) {
            iOnResponse.onResponse(response, t);
        }
    }

    final void onErrorResponse(final java.lang.Exception exc) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.common.http.RequestParams$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onErrorResponse$0(exc);
            }
        });
        java.lang.String message = exc.getMessage();
        if (message != null && !com.igexin.push.core.b.m.equalsIgnoreCase(message)) {
            if (message.contains("Bad URL")) {
                com.up366.common.log.Logger.warn(message);
                return;
            } else {
                com.up366.common.log.Logger.warn(exc.getMessage(), exc);
                return;
            }
        }
        com.up366.common.log.Logger.warn("HTTP error !", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onErrorResponse$0(java.lang.Exception exc) throws java.lang.Exception {
        if (exc instanceof java.net.SocketTimeoutException) {
            onResponse(new com.up366.common.http.Response(com.up366.common.http.Response.FAIL_NETWORK_TIME_OUT, this.url, "网络错误，访问超时。", 0, null), null);
        } else {
            onResponse(new com.up366.common.http.Response(-10001, this.url, "访问服务器失败，请检查网络。", 0, null), null);
        }
    }

    public static void setUserAgent(java.lang.String str) {
        try {
            userAgent = java.net.URLEncoder.encode(str + com.up366.common.PackageUtils.getVersionName(), com.igexin.push.g.s.b).replaceAll("\\+", " ");
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - RequestParams - setUserAgent - ", e);
            userAgent = "Android-Up366-Mobile";
        }
    }

    public static java.lang.String getUserAgent() {
        return userAgent;
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }

    public final java.lang.String getUrl() {
        return com.up366.common.global.GB.get().wrapUrl(com.up366.common.global.GB.get().getServerUrl(this.url));
    }

    public final boolean isCheckFormat() {
        return this.checkFormat;
    }

    public final int getTimeout() {
        return this.timeout;
    }

    public final com.up366.common.http.RequestParams<T> setTimeout(int i) {
        this.timeout = i;
        return this;
    }
}
