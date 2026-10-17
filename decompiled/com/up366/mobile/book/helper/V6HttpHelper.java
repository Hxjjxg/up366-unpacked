package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V6HttpHelper {
    private static int uniqueSessionId;
    private final com.up366.mobile.book.helper.V6RegisterHelper registerHelper;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public V6HttpHelper(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.helper.V6RegisterHelper v6RegisterHelper) {
        this.webView = studyPageWebView;
        this.registerHelper = v6RegisterHelper;
    }

    public void httpSend(int i, java.lang.String str) {
        java.lang.String str2 = "";
        try {
            java.lang.String query = new java.net.URL(str).getQuery();
            if (query != null) {
                str2 = query;
            }
            str = str.split("\\?")[0];
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.up366.common.http.HttpUtilsUp.post(new com.up366.mobile.book.helper.V6HttpHelper.AnonymousClass1(str, str2, i));
    }

    /* JADX INFO: renamed from: com.up366.mobile.book.helper.V6HttpHelper$1, reason: invalid class name */
    class AnonymousClass1 extends com.up366.common.http.RequestParams<java.lang.String> {
        final /* synthetic */ java.lang.String val$finalQuery;
        final /* synthetic */ int val$sessionId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(java.lang.String str, java.lang.String str2, int i) {
            super(str);
            this.val$finalQuery = str2;
            this.val$sessionId = i;
        }

        @Override // com.up366.common.http.RequestParams
        public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
            super.initParams(map);
            for (java.lang.String str : this.val$finalQuery.split("&")) {
                if (!com.up366.common.StringUtils.isEmptyOrNull(str)) {
                    java.lang.String[] strArrSplit = str.split("=");
                    if (strArrSplit.length == 2 && !com.up366.common.StringUtils.isEmptyOrNull(strArrSplit[0]) && !com.up366.common.StringUtils.isEmptyOrNull(strArrSplit[1])) {
                        try {
                            map.put(strArrSplit[0], java.net.URLDecoder.decode(strArrSplit[1], com.igexin.push.g.s.b));
                        } catch (java.io.UnsupportedEncodingException e) {
                            com.up366.common.log.Logger.error(e.getMessage(), e);
                        }
                    }
                }
            }
        }

        @Override // com.up366.common.http.RequestParams
        public void onResponse(com.up366.common.http.Response response, java.lang.String str) {
            super.onResponse(response, str);
            final com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("code", java.lang.Integer.valueOf(response.getCode()));
            jSONObject.put("info", response.getInfo());
            jSONObject.put("data", str);
            if (com.up366.mobile.book.helper.V6HttpHelper.this.webView.isPageHasLoaded()) {
                com.up366.mobile.book.helper.V6HttpHelper.this.webView.callJSMethod("HttpClient.onResponse(%d, %s)", java.lang.Integer.valueOf(this.val$sessionId), jSONObject.toJSONString());
            } else {
                final int i = this.val$sessionId;
                com.up366.common.task.TaskUtils.postMainTaskDelay(1000L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V6HttpHelper$1$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        this.f$0.lambda$onResponse$0(i, jSONObject);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(int i, com.alibaba.fastjson.JSONObject jSONObject) throws java.lang.Exception {
            com.up366.mobile.book.helper.V6HttpHelper.this.webView.callJSMethod("HttpClient.onResponse(%d, %s)", java.lang.Integer.valueOf(i), jSONObject.toJSONString());
        }
    }

    public void httpSendToQueue(int i, java.lang.String str, final java.lang.String str2) {
        com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(6, java.lang.String.valueOf(java.lang.Math.random()));
        batchUploadLog.addTask(new com.up366.common.http.RequestParams<java.lang.Object>(str) { // from class: com.up366.mobile.book.helper.V6HttpHelper.2
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str2);
                if (object != null) {
                    for (java.util.Map.Entry entry : object.entrySet()) {
                        map.put((java.lang.String) entry.getKey(), java.lang.String.valueOf(entry.getValue()));
                    }
                }
            }
        });
        com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("code", 0);
        jSONObject.put("info", "success");
        this.webView.callJSMethod("HttpClient.onResponse(%d, %s)", java.lang.Integer.valueOf(i), jSONObject.toJSONString());
    }

    public int httpRequest(java.lang.String str) {
        final int i = uniqueSessionId;
        uniqueSessionId = i + 1;
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
        final com.alibaba.fastjson.JSONObject jSONObject = object.getJSONObject("header");
        object.getString("type");
        boolean booleanValue = object.containsKey("check") ? object.getBooleanValue("check") : false;
        final com.alibaba.fastjson.JSONObject jSONObject2 = object.getJSONObject("params");
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(string, booleanValue) { // from class: com.up366.mobile.book.helper.V6HttpHelper.3
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
                jSONObject3.put("sessionId", java.lang.Integer.valueOf(i));
                com.up366.mobile.book.helper.V6HttpHelper.this.registerHelper.callJsEvent(com.up366.mobile.book.helper.V6RegisterHelper.EVT_HTTP_REQUEST, "(%s)", jSONObject3.toJSONString());
            }
        });
        return i;
    }
}
