package com.up366.mobile.book.jsbase;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BaseJSInterface {
    protected java.lang.String getParam(java.lang.String str, java.lang.String str2) {
        return com.alibaba.fastjson.JSON.parseObject(str).getString(str2);
    }

    protected java.lang.String getArrayParam(java.lang.String str, int i) {
        return com.alibaba.fastjson.JSON.parseArray(str).getString(i);
    }

    protected int getParamInt(java.lang.String str, java.lang.String str2) {
        return com.alibaba.fastjson.JSON.parseObject(str).getIntValue(str2);
    }

    protected long getParamLong(java.lang.String str, java.lang.String str2) {
        return com.alibaba.fastjson.JSON.parseObject(str).getLongValue(str2);
    }

    protected float getParamFloat(java.lang.String str, java.lang.String str2) {
        return com.alibaba.fastjson.JSON.parseObject(str).getFloatValue(str2);
    }

    protected boolean getParamBoolean(java.lang.String str, java.lang.String str2) {
        return com.alibaba.fastjson.JSON.parseObject(str).getBooleanValue(str2);
    }

    protected java.lang.String buildResultSuccess(java.lang.Object obj) {
        return buildResult(0, "success", obj);
    }

    protected java.lang.String buildResultError(int i, java.lang.String str) {
        return buildResult(i, str, null);
    }

    protected java.lang.String buildResult(int i, java.lang.String str, java.lang.Object obj) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("code", java.lang.Integer.valueOf(i));
        jSONObject2.put("msg", str);
        jSONObject.put("result", jSONObject2);
        jSONObject.put("data", obj);
        return jSONObject.toJSONString();
    }

    protected java.lang.String runInTryCatch(java.lang.Runnable runnable) {
        try {
            runnable.run();
            return buildResultSuccess(0);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - BaseJSInterface - runInTryCatch - Error", e);
            return buildResultError(-2, e.getMessage());
        }
    }

    protected java.lang.String runInTryCatch(com.up366.mobile.book.jsinterface.IRunnableResult iRunnableResult) {
        try {
            return buildResultSuccess(iRunnableResult.run());
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - BaseJSInterface - runInTryCatch with result - Error", e);
            return buildResultError(-2, e.getMessage());
        }
    }

    protected java.lang.String runInTryCatchAsync(final com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, final com.up366.mobile.book.jsinterface.IRunnableResult iRunnableResult) {
        final java.lang.String asyncUniqueKey = studyPageWebView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsbase.BaseJSInterface$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$runInTryCatchAsync$0(iRunnableResult, studyPageWebView, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runInTryCatchAsync$0(com.up366.mobile.book.jsinterface.IRunnableResult iRunnableResult, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, java.lang.String str) throws java.lang.Exception {
        java.lang.String strBuildResultError;
        try {
            strBuildResultError = buildResultSuccess(iRunnableResult.run());
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - BaseJSInterface - runInTryCatchAsync with result - Error", e);
            strBuildResultError = buildResultError(-2, e.getMessage());
        }
        studyPageWebView.getBridgeHelper().responseAsyncResult(str, strBuildResultError);
    }

    protected java.lang.String runInTryCatchMainAsync(final com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, final com.up366.mobile.book.jsinterface.IRunnableResult iRunnableResult) {
        final java.lang.String asyncUniqueKey = studyPageWebView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsbase.BaseJSInterface$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$runInTryCatchMainAsync$1(iRunnableResult, studyPageWebView, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runInTryCatchMainAsync$1(com.up366.mobile.book.jsinterface.IRunnableResult iRunnableResult, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, java.lang.String str) throws java.lang.Exception {
        java.lang.String strBuildResultError;
        try {
            strBuildResultError = buildResultSuccess(iRunnableResult.run());
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - BaseJSInterface - runInTryCatchAsync with result - Error", e);
            strBuildResultError = buildResultError(-2, e.getMessage());
        }
        studyPageWebView.getBridgeHelper().responseAsyncResult(str, strBuildResultError);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getUT(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - BaseJSInterface - getUT - json = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsbase.BaseJSInterface$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getUT$2(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getUT$2(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "data");
        java.lang.String param2 = getParam(str, "salt");
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("ut", com.up366.common.StringUtils.getUtV2(param, param2));
        return jSONObject;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String log(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsbase.BaseJSInterface$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.book.jsbase.BaseJSInterface.lambda$log$3(str);
            }
        });
    }

    static /* synthetic */ void lambda$log$3(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        int intValue = object.getIntValue("level");
        java.lang.String string = object.getString("msg");
        if (intValue == 1) {
            com.up366.common.log.Logger.debug("[JSLOG] " + string);
            return;
        }
        if (intValue == 2) {
            com.up366.common.log.Logger.info("[JSLOG] " + string);
            return;
        }
        if (intValue == 3) {
            com.up366.common.log.Logger.warn("[JSLOG] " + string);
        } else if (intValue == 4) {
            com.up366.common.log.Logger.error("[JSLOG] " + string);
        } else {
            com.up366.common.log.Logger.error("[JSLOG] " + intValue + " - " + string);
        }
    }

    @android.webkit.JavascriptInterface
    public java.lang.String upgradeClient(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - BaseJSInterface - upgradeClient - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsbase.BaseJSInterface$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.book.helper.AppInfoHelper.upgradeClient(com.up366.common.global.GB.get().getCurrentActivity());
            }
        });
    }
}
