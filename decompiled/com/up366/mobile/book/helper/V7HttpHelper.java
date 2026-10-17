package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V7HttpHelper {
    public void httpSend(java.lang.String str, final com.up366.common.callback.ICallbackCodeInfoObj<com.alibaba.fastjson.JSONObject> iCallbackCodeInfoObj) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final java.lang.String string = object.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
        final com.alibaba.fastjson.JSONObject jSONObject = object.getJSONObject("header");
        object.getString("method");
        boolean booleanValue = object.containsKey("check") ? object.getBooleanValue("check") : true;
        final com.alibaba.fastjson.JSONObject jSONObject2 = object.getJSONObject("param");
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(string, booleanValue) { // from class: com.up366.mobile.book.helper.V7HttpHelper.1
            @Override // com.up366.common.http.RequestParams
            public void initHeaders(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initHeaders(map);
                com.alibaba.fastjson.JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    map.putAll(jSONObject3);
                }
            }

            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                com.alibaba.fastjson.JSONObject jSONObject3 = jSONObject2;
                if (jSONObject3 != null) {
                    for (java.util.Map.Entry entry : jSONObject3.entrySet()) {
                        map.put((java.lang.String) entry.getKey(), java.lang.String.valueOf(entry.getValue()));
                    }
                }
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str2) {
                super.onResponse(response, str2);
                com.alibaba.fastjson.JSONObject jSONObject3 = new com.alibaba.fastjson.JSONObject();
                com.alibaba.fastjson.JSONObject jSONObject4 = new com.alibaba.fastjson.JSONObject();
                jSONObject4.put("code", java.lang.Integer.valueOf(response.getCode()));
                jSONObject4.put("msg", response.getInfo());
                jSONObject3.put("result", jSONObject4);
                try {
                    jSONObject3.put("data", com.alibaba.fastjson.JSON.parse(str2));
                } catch (com.alibaba.fastjson.JSONException unused) {
                    jSONObject3.put("data", str2);
                }
                iCallbackCodeInfoObj.onResult(0, null, jSONObject3);
                com.up366.mobile.book.helper.V7HttpHelper.this.analyseRequest(string);
            }
        });
    }

    public void httpSendToQueue(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
        object.getString("method");
        final com.alibaba.fastjson.JSONObject jSONObject = object.getJSONObject("param");
        com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(6, java.lang.String.valueOf(java.lang.Math.random()));
        batchUploadLog.addTask(new com.up366.common.http.RequestParams<java.lang.Object>(string) { // from class: com.up366.mobile.book.helper.V7HttpHelper.2
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                com.alibaba.fastjson.JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    for (java.util.Map.Entry entry : jSONObject2.entrySet()) {
                        map.put((java.lang.String) entry.getKey(), java.lang.String.valueOf(entry.getValue()));
                    }
                }
            }
        });
        com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void analyseRequest(java.lang.String str) {
        if (str.contains("client/words/student/submit")) {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.JSRemoveWordEvent());
        }
        if (str.contains("client/wrongnote/student/question/submit")) {
            com.up366.mobile.common.utils.ViewDataInvalidRecord.$("wrongnote-submit").invalid();
        }
    }

    public void fetchImageBase64(final java.lang.String str, final com.up366.common.callback.ICallbackCodeInfoObj<java.lang.String> iCallbackCodeInfoObj) {
        if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            com.up366.common.log.Logger.error("TAG - V7HttpHelper - fetchImageBase64 - 网络未连接");
            iCallbackCodeInfoObj.onResult(-4, "网络未连接", null);
        } else {
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V7HttpHelper$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$fetchImageBase64$0(str, iCallbackCodeInfoObj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchImageBase64$0(java.lang.String str, com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj) throws java.lang.Exception {
        new okhttp3.OkHttpClient.Builder().followRedirects(true).followSslRedirects(true).build().newCall(new okhttp3.Request.Builder().get().url(str).build()).enqueue(new com.up366.mobile.book.helper.V7HttpHelper.AnonymousClass3(iCallbackCodeInfoObj));
    }

    /* JADX INFO: renamed from: com.up366.mobile.book.helper.V7HttpHelper$3, reason: invalid class name */
    class AnonymousClass3 implements okhttp3.Callback {
        final /* synthetic */ com.up366.common.callback.ICallbackCodeInfoObj val$callback;

        AnonymousClass3(com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj) {
            this.val$callback = iCallbackCodeInfoObj;
        }

        public void onFailure(okhttp3.Call call, final java.io.IOException iOException) {
            com.up366.common.log.Logger.error("TAG - V7HttpHelper - fetchImageBase64 onFailure - ", iOException);
            final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj = this.val$callback;
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V7HttpHelper$3$$ExternalSyntheticLambda3
                @Override // com.up366.common.task.Task
                public final void run() {
                    iCallbackCodeInfoObj.onResult(-1, iOException.getMessage(), null);
                }
            });
        }

        public void onResponse(okhttp3.Call call, final okhttp3.Response response) throws java.io.IOException {
            if (response.isSuccessful()) {
                if (response.body() != null) {
                    final java.lang.String strEncodeToString = android.util.Base64.encodeToString(response.body().bytes(), 2);
                    final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj = this.val$callback;
                    com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V7HttpHelper$3$$ExternalSyntheticLambda0
                        @Override // com.up366.common.task.Task
                        public final void run() {
                            iCallbackCodeInfoObj.onResult(0, "success", strEncodeToString);
                        }
                    });
                } else {
                    final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj2 = this.val$callback;
                    com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V7HttpHelper$3$$ExternalSyntheticLambda1
                        @Override // com.up366.common.task.Task
                        public final void run() {
                            iCallbackCodeInfoObj2.onResult(-3, "response.body() != null", null);
                        }
                    });
                }
                response.close();
                return;
            }
            final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj3 = this.val$callback;
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V7HttpHelper$3$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    com.up366.mobile.book.helper.V7HttpHelper.AnonymousClass3.lambda$onResponse$3(response, iCallbackCodeInfoObj3);
                }
            });
        }

        static /* synthetic */ void lambda$onResponse$3(okhttp3.Response response, com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj) throws java.lang.Exception {
            com.up366.common.log.Logger.info("TAG - V7HttpHelper - fetchImageBase64 onResponse error - " + response.message());
            iCallbackCodeInfoObj.onResult(-2, response.message(), null);
        }
    }
}
