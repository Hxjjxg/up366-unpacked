package com.up366.mobile.book.dict.js;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DictOpenHelper {
    private final com.up366.mobile.book.StudyActivity context;
    private final com.up366.mobile.book.dict.DictHtmlView dictHtmlView;

    public DictOpenHelper(com.up366.mobile.book.dict.DictHtmlView dictHtmlView) {
        this.context = dictHtmlView.context;
        this.dictHtmlView = dictHtmlView;
    }

    public void launchXotEngine(java.lang.String str, java.lang.String str2, boolean z) {
        android.content.Intent intent = new android.content.Intent((android.content.Context) this.context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("exercise_type", str);
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, com.alibaba.fastjson.JSON.parseObject(str2).toJSONString());
        this.context.startActivity(intent);
    }

    public void openWebView(java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = this.dictHtmlView.cfg;
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo2 = new com.up366.mobile.book.model.OpenConfigInfo();
        openConfigInfo2.exerciseType = openConfigInfo.exerciseType;
        openConfigInfo2.exerciseData = openConfigInfo.exerciseData;
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        openConfigInfo2.title = object.getString("title");
        java.lang.String string = object.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
        if (com.up366.common.StringUtils.isEmptyOrNull(string)) {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this.context, "格式错误");
            com.up366.common.log.Logger.error("TAG - DictOpenHelper - openWebView - 格式错误 ： " + str);
            return;
        }
        if (string.startsWith("http")) {
            openConfigInfo2.openUrl = string;
        } else {
            if (string.contains("?")) {
                java.lang.String[] strArrSplit = string.split("\\?");
                java.lang.String str4 = strArrSplit[0];
                str2 = strArrSplit[1];
                string = str4;
            } else {
                str2 = null;
            }
            java.lang.String strJoin = com.up366.common.FileUtilsUp.join(this.dictHtmlView.b.webView.getCurrentDir(), string);
            if (!com.up366.common.FileUtilsUp.isFileExists(strJoin)) {
                com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this.context, this.context.getResources().getString(com.up366.mobile.R.string.study_page_not_found) + "(-5)");
                com.up366.common.log.Logger.error("TAG - DictOpenHelper - openWebView - 找不到页面 ： " + str + " filepath:" + strJoin);
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder("file://");
            sb.append(strJoin);
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = "?" + str2;
            }
            sb.append(str3);
            openConfigInfo2.openUrl = sb.toString();
        }
        this.context.openPage(openConfigInfo2);
    }

    public void closeWebView() {
        this.dictHtmlView.registerHelper.unRegister("beforegoback");
        this.context.onBackPressed();
    }

    public void openWordNote() {
        final android.content.Intent intent = new android.content.Intent((android.content.Context) this.context, (java.lang.Class<?>) com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.class);
        intent.putExtra("type", 1);
        intent.putExtra("fromType", 0);
        com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_WORDS).runWithTip(new java.lang.Runnable() { // from class: com.up366.mobile.book.dict.js.DictOpenHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openWordNote$0(intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWordNote$0(android.content.Intent intent) {
        this.context.startActivity(intent);
    }

    public void openTaskList() {
        this.context.startActivity(new android.content.Intent((android.content.Context) this.context, (java.lang.Class<?>) com.up366.mobile.course.task.TaskActivity.class));
    }

    public void openNetHelp() {
        this.context.startActivity(new android.content.Intent((android.content.Context) this.context, (java.lang.Class<?>) com.up366.mobile.commonui.LookHelpActivity.class));
    }
}
