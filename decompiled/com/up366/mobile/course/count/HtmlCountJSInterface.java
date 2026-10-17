package com.up366.mobile.course.count;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class HtmlCountJSInterface {
    private final com.up366.mobile.course.count.HtmlCountFragment.ICallFragment callFragment;
    private com.up366.mobile.book.helper.DataHelper dataHelper = new com.up366.mobile.book.helper.DataHelper();
    private com.up366.mobile.book.webview.StudyPageWebView webView;

    public HtmlCountJSInterface(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.course.count.HtmlCountFragment.ICallFragment iCallFragment) {
        this.webView = studyPageWebView;
        this.callFragment = iCallFragment;
    }

    @android.webkit.JavascriptInterface
    public int saveData(java.lang.String str, java.lang.String str2) {
        this.dataHelper.saveData(str2, str);
        return 0;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadData(java.lang.String str) {
        return this.dataHelper.loadData(str);
    }

    @android.webkit.JavascriptInterface
    public int toast(java.lang.String str) {
        com.up366.mobile.common.utils.ToastPopupUtil.show(str);
        return 0;
    }

    @android.webkit.JavascriptInterface
    public void disableRefresh(int i) {
        if (i == 0) {
            this.callFragment.disableRefresh(false);
        } else if (i == 1) {
            this.callFragment.disableRefresh(true);
        }
    }

    @android.webkit.JavascriptInterface
    public java.lang.String open(final java.lang.String str, final int i) {
        if (!str.startsWith("http")) {
            if (str.startsWith("..")) {
                com.up366.mobile.common.utils.ToastPopupUtil.show("url:" + str);
                return "noopen";
            }
            if (str.startsWith("./")) {
                str = str.substring(2, str.length());
            }
            str = "file://" + com.up366.common.FileUtilsUp.join(com.up366.mobile.book.exercise.ExerciseResourceHelper.getExerciseRootDir(), "report") + "/" + str;
        }
        com.up366.common.log.Logger.debug("-----------urlStr : " + str);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.count.HtmlCountJSInterface.1
            @Override // com.up366.common.task.Task
            public void run() {
                if (i == 0) {
                    com.up366.mobile.course.count.HtmlCountJSInterface.this.webView.loadUrlInQueue(str, 0);
                } else {
                    com.up366.mobile.course.count.HtmlCountJSInterface.this.callFragment.openNewPage(str);
                }
            }
        });
        return com.igexin.sdk.PushBuildConfig.sdk_conf_channelid;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String closePage() {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.count.HtmlCountJSInterface.2
            @Override // com.up366.common.task.Task
            public void run() {
                com.up366.mobile.course.count.HtmlCountJSInterface.this.callFragment.closePage();
            }
        });
        return "close";
    }

    @android.webkit.JavascriptInterface
    public void requestDataFromServer(final int i, java.lang.String str) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(str) { // from class: com.up366.mobile.course.count.HtmlCountJSInterface.3
            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str2) {
                super.onResponse(response, str2);
                com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                jSONObject.put("code", java.lang.Integer.valueOf(response.getCode()));
                jSONObject.put("info", response.getInfo());
                jSONObject.put("data", str2);
                com.up366.mobile.course.count.HtmlCountJSInterface.this.callJSMethod("HttpClient.onResponse(%d, %s)", java.lang.Integer.valueOf(i), jSONObject.toJSONString());
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void submitDataForServer(int i, java.lang.String str, final java.lang.String str2) {
        com.up366.common.http.RequestParams<java.lang.String> requestParams = new com.up366.common.http.RequestParams<java.lang.String>(str) { // from class: com.up366.mobile.course.count.HtmlCountJSInterface.4
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str2);
                if (object != null) {
                    for (java.util.Map.Entry entry : object.entrySet()) {
                        map.put((java.lang.String) entry.getKey(), java.lang.String.valueOf(entry.getValue()));
                    }
                }
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str3) {
                super.onResponse(response, str3);
            }
        };
        com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(6, java.lang.String.valueOf(java.lang.Math.random()));
        batchUploadLog.addTask(requestParams);
        com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("code", 0);
        jSONObject.put("info", "success");
        callJSMethod("HttpClient.onResponse(%d, %s)", java.lang.Integer.valueOf(i), jSONObject.toJSONString());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getClientInfo() {
        return this.webView.getContext().getString(com.up366.mobile.R.string.js_interface_client_info_prefix) + com.up366.common.PackageUtils.getVersionName();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getCourseBookInfo() {
        com.up366.mobile.book.model.BookInfoStudy bookInfo = this.callFragment.getBookInfo();
        if (bookInfo == null) {
            return "{}";
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(bookInfo.getCourseId()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookInfo.getBookId());
        jSONObject.put("bookName", bookInfo.getBookName());
        return jSONObject.toJSONString();
    }

    @android.webkit.JavascriptInterface
    public boolean isAuthed() {
        return com.up366.mobile.common.logic.Auth.isAuth();
    }

    @android.webkit.JavascriptInterface
    public int getUserType() {
        return com.up366.mobile.common.logic.Auth.getUserInfo().getUtype();
    }

    @android.webkit.JavascriptInterface
    public int getUid() {
        return com.up366.mobile.common.logic.Auth.getUserInfo().getUid();
    }

    @android.webkit.JavascriptInterface
    public void updateTitle(java.lang.String str, int i) {
        this.callFragment.updateTitle(str, i);
    }

    @android.webkit.JavascriptInterface
    public void showLoading(final boolean z) {
        com.up366.common.log.Logger.info("TAG - 2018/6/26 - HtmlCountJSInterface - showLoading - show = [" + z + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.count.HtmlCountJSInterface$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$showLoading$0(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoading$0(boolean z) throws java.lang.Exception {
        this.callFragment.showLoading(z);
    }

    public void callJSMethod(java.lang.String str, java.lang.Object... objArr) {
        callJSMethod(java.lang.String.format(str, objArr));
    }

    public void callJSMethod(java.lang.String str) {
        this.webView.callJSMethod(str);
    }
}
