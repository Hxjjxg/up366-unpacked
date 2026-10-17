package com.up366.mobile.common.http;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ErrCodeHandleV2 extends com.up366.common.http.SimpleCodeHandle {
    private static boolean hasInit;
    private final java.lang.Object lockFirstLogin = new java.lang.Object();
    private final java.lang.Object lockSyncGetTicket = new java.lang.Object();
    private final java.util.regex.Pattern hostClientPattern = java.util.regex.Pattern.compile("https?://([^/]+)/(client/)?");

    @Override // com.up366.common.http.SimpleCodeHandle
    public <T> void handle(com.up366.common.http.RequestParams<T> requestParams, com.up366.common.http.Response response) {
        int code = response.getCode();
        if (code != -8) {
            switch (code) {
                case com.up366.common.http.Response.RESULT_SSO_LOGIN_OUT_OK /* -28 */:
                    postErrResponse(requestParams, response);
                    break;
                case com.up366.common.http.Response.RESULT_SSO_GEN_TGT_FAILED /* -27 */:
                    postErrResponse(requestParams, response);
                    break;
                case com.up366.common.http.Response.RESULT_SSO_GEN_TGT_OK /* -26 */:
                    postErrResponse(requestParams, response);
                    break;
                case com.up366.common.http.Response.RESULT_SSO_GEN_ST_FAILED /* -25 */:
                    postErrResponse(requestParams, response);
                    break;
                case com.up366.common.http.Response.RESULT_SSO_GEN_ST_OK /* -24 */:
                    postErrResponse(requestParams, response);
                    break;
                case com.up366.common.http.Response.RESULT_SSO_NO_TGT /* -23 */:
                    com.up366.common.log.Logger.info("TAG - ErrCodeHandleV2 - handle - " + response.toString());
                    postErrResponse(requestParams, response);
                    break;
                case com.up366.common.http.Response.RESULT_SSO_VAILD_ST_FAILED /* -22 */:
                    postErrResponse(requestParams, response);
                    break;
                case com.up366.common.http.Response.RESULT_SSO_NO_LOGIN /* -21 */:
                    requestServiceTicket(requestParams, response);
                    break;
                default:
                    postErrResponse(requestParams, response);
                    break;
            }
        }
        com.up366.common.utils.EncryptUtil.enc(com.up366.mobile.common.base.Constants.sign, 1235);
        com.up366.mobile.common.utils.UpdateModule.getInstance().checkNewVersionAuto();
        postErrResponse(requestParams, response);
    }

    @Override // com.up366.common.http.SimpleCodeHandle
    public <T> void preHandleRequest(com.up366.common.http.RequestParams<T> requestParams) {
        if (com.up366.mobile.common.utils.PlatformUtils.isGray()) {
            com.up366.common.http.HttpUtilsUp.addCookie("", "u3h", "1", 0L, com.up366.mobile.common.utils.PlatformUtils.getTargetHost(), "/", false, false, false);
        }
        if (com.up366.mobile.common.logic.Auth.noAuth()) {
            return;
        }
        java.lang.String url = requestParams.getUrl();
        java.util.regex.Matcher matcher = this.hostClientPattern.matcher(url);
        if (!matcher.find() || matcher.group(2) == null || matcher.group(1).startsWith("sso.") || url.contains("ticket=")) {
            return;
        }
        synchronized (this.lockFirstLogin) {
            if (!hasInit) {
                hasInit = true;
                final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
                com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.http.ErrCodeHandleV2$$ExternalSyntheticLambda2
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        com.up366.mobile.common.http.ErrCodeHandleV2.lambda$preHandleRequest$0(countDownLatch);
                    }
                });
                try {
                    countDownLatch.await(10L, java.util.concurrent.TimeUnit.SECONDS);
                } catch (java.lang.InterruptedException e) {
                    com.up366.common.log.Logger.error("TAG - ErrCodeHandleV2 - preHandleRequest - ", e);
                }
            }
        }
    }

    static /* synthetic */ void lambda$preHandleRequest$0(java.util.concurrent.CountDownLatch countDownLatch) throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.autoLoginSync();
        countDownLatch.countDown();
    }

    private <T> void requestServiceTicket(final com.up366.common.http.RequestParams<T> requestParams, com.up366.common.http.Response response) {
        if (!com.up366.mobile.common.logic.Auth.isAuth() && !com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.common.http.HttpMgrUtils.GET_USER_INFO).equals(requestParams.getUrl())) {
            postErrResponse(requestParams, response);
            return;
        }
        synchronized (this.lockSyncGetTicket) {
            final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.http.ErrCodeHandleV2$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$requestServiceTicket$1(requestParams, countDownLatch);
                }
            });
            try {
                countDownLatch.await(20L, java.util.concurrent.TimeUnit.SECONDS);
            } catch (java.lang.InterruptedException e) {
                com.up366.common.log.Logger.error("TAG - ErrCodeHandleV2 - requestServiceTicket - ", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestServiceTicket$1(com.up366.common.http.RequestParams requestParams, java.util.concurrent.CountDownLatch countDownLatch) throws java.lang.Exception {
        com.up366.common.http.NetHolder<java.lang.String> netHolderSyncGetServiceTicket = syncGetServiceTicket(requestParams);
        if (netHolderSyncGetServiceTicket.resp.getCode() == -24) {
            syncReSendRequestWithTicket(requestParams, netHolderSyncGetServiceTicket.info);
        } else if ((netHolderSyncGetServiceTicket.resp.getCode() != -23 && netHolderSyncGetServiceTicket.resp.getCode() != -25) || !com.up366.mobile.common.logic.Auth.isAuth()) {
            netHolderSyncGetServiceTicket.resp.setUrl(requestParams.getUrl());
            postErrResponse(requestParams, netHolderSyncGetServiceTicket.resp);
        } else {
            com.up366.common.http.NetHolder<java.lang.Object> netHolderAutoLoginSync = com.up366.mobile.common.logic.Auth.autoLoginSync();
            if (netHolderAutoLoginSync.resp.isError()) {
                netHolderAutoLoginSync.resp.setUrl(requestParams.getUrl());
                postErrResponse(requestParams, netHolderAutoLoginSync.resp);
            } else {
                com.up366.common.http.NetHolder<java.lang.String> netHolderSyncGetServiceTicket2 = syncGetServiceTicket(requestParams);
                if (netHolderSyncGetServiceTicket2.resp.getCode() == -24) {
                    syncReSendRequestWithTicket(requestParams, netHolderSyncGetServiceTicket2.info);
                } else {
                    netHolderSyncGetServiceTicket2.resp.setUrl(requestParams.getUrl());
                    postErrResponse(requestParams, netHolderSyncGetServiceTicket2.resp);
                }
            }
        }
        countDownLatch.countDown();
    }

    private <T> void syncReSendRequestWithTicket(final com.up366.common.http.RequestParams<T> requestParams, java.lang.String str) throws java.lang.InterruptedException {
        requestParams.setUrl(joinUrlParam(requestParams.getUrl(), "ticket=" + str));
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<T>(requestParams.getUrl()) { // from class: com.up366.mobile.common.http.ErrCodeHandleV2.1
            @Override // com.up366.common.http.RequestParams
            public void initHeaders(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.putAll(requestParams.getHeaders());
            }

            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.putAll(requestParams.getParams());
            }

            @Override // com.up366.common.http.RequestParams
            public okhttp3.RequestBody getRequestBody() {
                return requestParams.getRequestBody();
            }

            @Override // com.up366.common.http.RequestParams
            public T handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                return (T) requestParams.handleResponse(response, str2);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, T t) {
                requestParams.onResponse(response, t);
                countDownLatch.countDown();
            }
        });
        countDownLatch.await(20L, java.util.concurrent.TimeUnit.SECONDS);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.String] */
    private com.up366.common.http.NetHolder<java.lang.String> syncGetServiceTicket(final com.up366.common.http.RequestParams<?> requestParams) throws java.lang.InterruptedException {
        com.up366.common.http.NetHolder<java.lang.String> netHolderPostSync = com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.serviceTicket).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.common.http.ErrCodeHandleV2$$ExternalSyntheticLambda1
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                map.put("service", requestParams.getUrl());
            }
        }));
        if (netHolderPostSync.resp.getCode() == -24) {
            netHolderPostSync.info = com.alibaba.fastjson.JSON.parseObject(netHolderPostSync.resp.getResponse()).getString("serverTicket");
        }
        return netHolderPostSync;
    }

    private java.lang.String joinUrlParam(java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        java.lang.String str3 = "?";
        if (str.endsWith("?") || str.endsWith("&")) {
            str3 = "";
        } else if (str.contains("?")) {
            str3 = "&";
        }
        sb.append(str3);
        sb.append(str2);
        return sb.toString();
    }

    public static void setHasInit() {
        hasInit = true;
    }
}
