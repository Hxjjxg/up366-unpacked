package com.up366.mobile.book.exercise.js;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class HttpHelper {
    private final com.up366.mobile.book.exercise.js.RegisterHelper registerHelper;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public HttpHelper(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.exercise.js.RegisterHelper registerHelper) {
        this.webView = studyPageWebView;
        this.registerHelper = registerHelper;
    }

    public void httpRequest(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final java.lang.String string = object.getString("sessionId");
        object.getString("method");
        java.lang.String string2 = object.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
        final java.lang.String string3 = object.getString("data");
        boolean zBooleanValue = object.getBoolean("async").booleanValue();
        com.up366.common.http.RequestParams<java.lang.String> requestParams = new com.up366.common.http.RequestParams<java.lang.String>(string2) { // from class: com.up366.mobile.book.exercise.js.HttpHelper.1
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                com.alibaba.fastjson.JSONObject object2 = com.alibaba.fastjson.JSON.parseObject(string3);
                if (object2 != null) {
                    for (java.util.Map.Entry entry : object2.entrySet()) {
                        map.put((java.lang.String) entry.getKey(), java.lang.String.valueOf(entry.getValue()));
                    }
                }
            }

            @Override // com.up366.common.http.RequestParams
            public java.lang.String handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                com.up366.mobile.book.exercise.js.HttpHelper.this.analyseSuccessRequest(response.getUrl());
                return (java.lang.String) super.handleResponse(response, str2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Object] */
            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str2) {
                super.onResponse(response, str2);
                com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
                jSONObject.put("result", jSONObject2);
                jSONObject2.put("code", java.lang.Integer.valueOf(response.getCode()));
                jSONObject2.put("msg", response.getInfo());
                try {
                    str2 = com.alibaba.fastjson.JSON.parse(str2);
                } catch (java.lang.Exception unused) {
                }
                jSONObject.put("data", str2);
                if (com.up366.mobile.book.exercise.js.HttpHelper.this.registerHelper.hasRegister("httpresponse")) {
                    com.up366.mobile.book.exercise.js.HttpHelper.this.registerHelper.callJsEvent("httpresponse", "('%s', '%s')", string, android.util.Base64.encodeToString(jSONObject.toJSONString().getBytes(), 0).replaceAll("\\s", ""));
                }
                com.up366.mobile.book.exercise.js.HttpHelper.this.analyseRequest(response.getUrl());
            }
        };
        if (zBooleanValue) {
            com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(6, java.lang.String.valueOf(java.lang.System.currentTimeMillis() + java.lang.Math.random()));
            batchUploadLog.addTask(requestParams);
            com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("result", jSONObject2);
            jSONObject2.put("code", 0);
            jSONObject2.put("msg", "success");
            jSONObject.put("data", com.alibaba.fastjson.JSON.parse((java.lang.String) null));
            if (this.registerHelper.hasRegister("httpresponse")) {
                this.registerHelper.callJsEvent("httpresponse", "('%s', '%s')", string, android.util.Base64.encodeToString(jSONObject.toJSONString().getBytes(), 0).replaceAll("\\s", ""));
                return;
            }
            return;
        }
        com.up366.common.http.HttpUtilsUp.post(requestParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void analyseRequest(java.lang.String str) {
        if (str.contains("client/job/submit")) {
            com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void analyseSuccessRequest(java.lang.String str) {
        com.up366.common.log.Logger.info("HttpHelper analyseSuccessRequest url = " + str);
    }
}
