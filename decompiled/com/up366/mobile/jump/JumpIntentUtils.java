package com.up366.mobile.jump;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class JumpIntentUtils {
    public static void skip(android.content.Context context, java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            onJumpError(context, "跳转信息为空...");
        }
        java.lang.String strReplace = str.replace("up366mobile://?", "");
        if (com.up366.common.StringUtils.isEmptyOrNull(strReplace)) {
            onJumpError(context, null);
            return;
        }
        int iJudgeUrlType = com.up366.mobile.jump.JumpUtils.judgeUrlType(strReplace);
        com.up366.common.log.Logger.info("initIntent  jumpType " + iJudgeUrlType + "   " + strReplace);
        switch (iJudgeUrlType) {
            case 0:
                onJumpToBookImmediately(context, strReplace);
                break;
            case 1:
                onJumpToBookWithToken(context, strReplace);
                break;
            case 2:
                onJumpWebview(context, strReplace);
                break;
            case 3:
                onJumpJustStr(context, strReplace);
                break;
            case 4:
                onJumpToBookWithNantong(context, strReplace);
                break;
            case 5:
            case 9:
            default:
                onJumpError(context, "未知错误...");
                break;
            case 6:
                onJumpToDailyWriteTry(context, strReplace);
                break;
            case 7:
                onJumpToNewJobDetail(context, strReplace);
                break;
            case 8:
                onJumpToBookCommon(context, strReplace);
                break;
            case 10:
                onJssdkWebView(context, strReplace);
                break;
        }
    }

    public static void onJssdkWebView(android.content.Context context, java.lang.String str) {
        java.lang.String str2 = com.up366.mobile.jump.JumpUtils.getParamsFromUrl(str).get(com.up366.mobile.commonui.CommonWebViewActivity.URL);
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity.class);
        intent.putExtra("URL", com.up366.mobile.jump.JumpUtils.decodeUrl(str2));
        jump(context, intent);
    }

    public static void onJumpToNewJobDetail(final android.content.Context context, java.lang.String str) {
        final java.util.Map<java.lang.String, java.lang.String> paramsFromUrl = com.up366.mobile.jump.JumpUtils.getParamsFromUrl(str);
        final java.lang.String str2 = paramsFromUrl.get("cid");
        final java.lang.String str3 = paramsFromUrl.get("jid");
        int i = (!paramsFromUrl.containsKey("uid") || com.up366.common.StringUtils.isEmptyOrNull(paramsFromUrl.get("uid"))) ? -1 : java.lang.Integer.parseInt((java.lang.String) java.util.Objects.requireNonNull(paramsFromUrl.get("uid")));
        if (i == -1 || com.up366.mobile.common.logic.Auth.UID() == i) {
            skipByFetchTask(context, str2, str3);
        } else if (com.up366.mobile.common.logic.Auth.UID() == 0) {
            autoLogin(context, str2, str3, paramsFromUrl.get("ttgt"));
        } else {
            com.up366.mobile.common.dialog.AppDialog.create(context).title("账号异常").message("检测到当前账号与App登录账号不符，是否切换？").right("切换", new android.view.View.OnClickListener() { // from class: com.up366.mobile.jump.JumpIntentUtils$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.jump.JumpIntentUtils.autoLogin(context, str2, str3, (java.lang.String) paramsFromUrl.get("ttgt"));
                }
            }).left("不切换", new android.view.View.OnClickListener() { // from class: com.up366.mobile.jump.JumpIntentUtils$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    ((android.app.Activity) context).finish();
                }
            }).btnClose(new android.view.View.OnClickListener() { // from class: com.up366.mobile.jump.JumpIntentUtils$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    ((android.app.Activity) context).finish();
                }
            }).setBtnCloseVisibility(0).show();
        }
    }

    public static void autoLogin(final android.content.Context context, final java.lang.String str, final java.lang.String str2, final java.lang.String str3) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.jump.JumpIntentUtils$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.jump.JumpIntentUtils.lambda$autoLogin$4(str3, context, str, str2);
            }
        });
    }

    static /* synthetic */ void lambda$autoLogin$4(java.lang.String str, final android.content.Context context, final java.lang.String str2, final java.lang.String str3) throws java.lang.Exception {
        final com.up366.common.http.NetHolder<java.lang.Object> netHolderLoginByToken = com.up366.mobile.common.logic.Auth.mgr().loginByToken(str);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.jump.JumpIntentUtils$$ExternalSyntheticLambda9
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.jump.JumpIntentUtils.lambda$autoLogin$3(netHolderLoginByToken, context, str2, str3);
            }
        });
    }

    static /* synthetic */ void lambda$autoLogin$3(com.up366.common.http.NetHolder netHolder, android.content.Context context, java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        if (netHolder.resp.isError()) {
            onJumpError(context, "切换账号登录失败" + netHolder.resp.getInfo());
        } else {
            com.up366.common.log.Logger.info(" autoLogin  " + com.up366.common.TimeUtils.formatTime(new java.util.Date(), "HH:mm:ss.SSS"));
            skipByFetchTask(context, str, str2);
        }
    }

    public static void skipByFetchTask(final android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.up366.mobile.common.logic.Auth.cur().taskMgr().fetchTask(str, str2, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.jump.JumpIntentUtils$$ExternalSyntheticLambda13
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.mobile.jump.JumpIntentUtils.lambda$skipByFetchTask$5(context, response, (com.up366.mobile.course.task.TaskInfoV2) obj);
            }
        });
    }

    static /* synthetic */ void lambda$skipByFetchTask$5(android.content.Context context, com.up366.common.http.Response response, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        if (response.isError()) {
            if (response.getCode() == 1 || response.getCode() == 2 || response.getCode() == 3) {
                onJumpError(context, "啊哦~您没有权限打开这份练习哦~");
                return;
            }
            onJumpError(context, "获取练习信息失败：" + response.getInfo());
            return;
        }
        if (com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() < taskInfoV2.getAriseTime()) {
            onJumpError(context, "啊哦~练习还没到达作答时间哦~");
            return;
        }
        if (taskInfoV2.getType() == 1) {
            new com.up366.mobile.course.task.TaskOpenBookStudyHelper().open(context, taskInfoV2);
            ((android.app.Activity) context).finish();
        } else {
            if (taskInfoV2.getType() == 3) {
                com.up366.common.log.Logger.info(" autoLogin  TYPE_ZUOYE" + com.up366.common.TimeUtils.formatTime(new java.util.Date(), "HH:mm:ss.SSS"));
                com.up366.mobile.course.task.TaskOpenBookStudyHelper.openHomework(context, taskInfoV2);
                ((android.app.Activity) context).finish();
                return;
            }
            onJumpError(context, "目前不支持类型跳转");
        }
    }

    public static void onJumpToDailyWriteTry(android.content.Context context, java.lang.String str) {
        android.app.Activity activity = (android.app.Activity) context;
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
        bookInfoStudy.setBookId(com.up366.mobile.jump.JumpUtils.getBookIdFromURI(str));
        bookInfoStudy.setBookType(1);
        java.lang.String fDateFromUrl = com.up366.mobile.jump.JumpUtils.getFDateFromUrl(str);
        bookInfoStudy.setJumpExtDailyDate(fDateFromUrl);
        if (bookInfoStudy.getBookId() == null || fDateFromUrl == null) {
            activity.finish();
            return;
        }
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("qrCode", str);
        bookInfoStudy.setJumpCommonParams(jSONObject.toJSONString());
        intent.putExtra("book", bookInfoStudy);
        jump(context, intent);
    }

    public static void onJumpToBookImmediately(final android.content.Context context, final java.lang.String str) {
        com.up366.common.log.Logger.debug("TAG - JumpProxyActivity - onJumpToBookImmediately - " + str);
        final com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
        bookInfoStudy.setCourseId(-1);
        bookInfoStudy.setBookType(1);
        bookInfoStudy.setBookId(com.up366.mobile.jump.JumpUtils.getBookIdFromURI(str));
        bookInfoStudy.setJumpOpenChapter(com.up366.mobile.jump.JumpUtils.getChapterIdFromURI(str));
        bookInfoStudy.setJumpOpenPage(com.up366.mobile.jump.JumpUtils.getPagerIdFromURI(str));
        com.up366.mobile.common.logic.Auth.cur().course().loadJumpCourseIdByCourseIdAndBookId(com.up366.mobile.jump.JumpUtils.getCourseIdFromURI(str), bookInfoStudy.getBookId(), new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.jump.JumpIntentUtils$$ExternalSyntheticLambda2
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str2, java.lang.Object obj) {
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.jump.JumpIntentUtils$$ExternalSyntheticLambda1
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        com.up366.mobile.jump.JumpIntentUtils.lambda$onJumpToBookImmediately$6(num, bookInfoStudy, context, str);
                    }
                });
            }
        });
    }

    static /* synthetic */ void lambda$onJumpToBookImmediately$6(java.lang.Integer num, com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, android.content.Context context, java.lang.String str) throws java.lang.Exception {
        com.up366.common.log.Logger.debug("TAG - JumpProxyActivity - onJumpToBookImmediately - " + num);
        bookInfoStudy.setCourseId(num.intValue());
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("qrCode", str);
        bookInfoStudy.setJumpCommonParams(jSONObject.toJSONString());
        intent.putExtra("book", bookInfoStudy);
        jump(context, intent);
    }

    public static void onJumpToBookCommon(final android.content.Context context, final java.lang.String str) {
        com.up366.common.log.Logger.debug("TAG - JumpProxyActivity - onJumpToBookCommon - " + str);
        java.util.Map<java.lang.String, java.lang.String> paramsFromUrl = com.up366.mobile.jump.JumpUtils.getParamsFromUrl(str);
        java.lang.String[] strArrSplit = str.split("\\?");
        final com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        if (strArrSplit.length > 1) {
            jSONObject.put("nativeQueryString", strArrSplit[1]);
        }
        final com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
        bookInfoStudy.setCourseId(-1);
        bookInfoStudy.setBookType(1);
        bookInfoStudy.setBookId(paramsFromUrl.get(com.igexin.push.core.b.C));
        bookInfoStudy.setJumpOpenTask(paramsFromUrl.get("tid"));
        com.up366.mobile.common.logic.Auth.cur().course().loadJumpCourseIdByCourseIdAndBookId(com.up366.mobile.jump.JumpUtils.getCourseIdFromURI(str), bookInfoStudy.getBookId(), new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.jump.JumpIntentUtils$$ExternalSyntheticLambda12
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str2, java.lang.Object obj) {
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.jump.JumpIntentUtils$$ExternalSyntheticLambda8
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        com.up366.mobile.jump.JumpIntentUtils.lambda$onJumpToBookCommon$8(num, bookInfoStudy, context, str, jSONObject);
                    }
                });
            }
        });
    }

    static /* synthetic */ void lambda$onJumpToBookCommon$8(java.lang.Integer num, com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, android.content.Context context, java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject) throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - JumpProxyActivity - onJumpToBookCommon - courseId:" + num);
        bookInfoStudy.setCourseId(num.intValue());
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("qrCode", str);
        bookInfoStudy.setJumpCommonParams(jSONObject2.toJSONString());
        intent.putExtra("book", bookInfoStudy);
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = new com.up366.mobile.book.model.OpenConfigInfo(bookInfoStudy);
        openConfigInfo.exerciseData = jSONObject.toJSONString();
        intent.putExtra("cfg", openConfigInfo);
        jump(context, intent);
    }

    public static void onJumpToBookWithToken(final android.content.Context context, final java.lang.String str) {
        com.up366.mobile.common.logic.Auth.cur().getJumpMgr().getSkipPathFromWeb(com.up366.mobile.jump.JumpUtils.getRequestParFromUrl(str), new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.jump.JumpIntentUtils$$ExternalSyntheticLambda11
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.mobile.jump.JumpIntentUtils.lambda$onJumpToBookWithToken$10(context, str, response, (java.lang.String) obj);
            }
        });
    }

    static /* synthetic */ void lambda$onJumpToBookWithToken$10(android.content.Context context, java.lang.String str, com.up366.common.http.Response response, java.lang.String str2) {
        if (response.isError()) {
            onJumpError(context, "获取跳转信息失败...");
            return;
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSONObject.parseObject(response.getResponse());
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
        bookInfoStudy.setCourseId(-1);
        bookInfoStudy.setBookType(1);
        bookInfoStudy.setBookId(object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID));
        bookInfoStudy.setJumpOpenChapter(object.getString("chapterId"));
        bookInfoStudy.setJumpOpenPage(object.getString("pageId"));
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("qrCode", str);
        bookInfoStudy.setJumpCommonParams(jSONObject.toJSONString());
        intent.putExtra("book", bookInfoStudy);
        jump(context, intent);
    }

    public static void onJumpToBookWithNantong(final android.content.Context context, final java.lang.String str) {
        java.lang.String username = com.up366.mobile.common.logic.Auth.getUserInfo().getUsername();
        final java.lang.String userNameFromURI = com.up366.mobile.jump.JumpUtils.getUserNameFromURI(str);
        if (userNameFromURI == null) {
            userNameFromURI = "";
        }
        if (userNameFromURI.equals(username) && com.up366.mobile.common.logic.Auth.isAuth()) {
            onNantongUserLoginSuccess(context, str);
        } else {
            final java.lang.String str2 = "123456";
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.jump.JumpIntentUtils$$ExternalSyntheticLambda10
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    com.up366.mobile.jump.JumpIntentUtils.lambda$onJumpToBookWithNantong$12(userNameFromURI, str2, context, str);
                }
            });
        }
    }

    static /* synthetic */ void lambda$onJumpToBookWithNantong$12(java.lang.String str, java.lang.String str2, final android.content.Context context, final java.lang.String str3) throws java.lang.Exception {
        final com.up366.common.http.NetHolder<java.lang.Object> netHolderDoLogin = com.up366.mobile.common.logic.Auth.mgr().doLogin(str, str2, true);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.jump.JumpIntentUtils$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.jump.JumpIntentUtils.lambda$onJumpToBookWithNantong$11(netHolderDoLogin, context, str3);
            }
        });
    }

    static /* synthetic */ void lambda$onJumpToBookWithNantong$11(com.up366.common.http.NetHolder netHolder, android.content.Context context, java.lang.String str) throws java.lang.Exception {
        if (netHolder.resp.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) context);
            jump(context, new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.user.account.login.AccountLoginActivity.class));
        } else {
            onNantongUserLoginSuccess(context, str);
        }
    }

    public static void onJumpJustStr(android.content.Context context, java.lang.String str) {
        onJumpError(context, "" + str);
    }

    public static void onJumpWebview(android.content.Context context, java.lang.String str) {
        try {
            java.net.URL url = new java.net.URL(str);
            if (url.getHost().contains("up366.com") || url.getHost().contains("up366.cn") || url.getHost().contains("up366demo.cn") || url.getHost().contains("up366test.cn")) {
                android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity.class);
                intent.putExtra("URL", str);
                jump(context, intent);
                return;
            }
        } catch (java.lang.Exception unused) {
        }
        com.up366.common.log.Logger.info("TAG - JumpIntentUtils - onJumpWebview - 扫一扫不支持外部url： " + str);
        onJumpError(context, 1, str);
    }

    public static void onNantongUserLoginSuccess(android.content.Context context, java.lang.String str) {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
        bookInfoStudy.setCourseId(-1);
        bookInfoStudy.setBookType(1);
        bookInfoStudy.setBookId(com.up366.mobile.jump.JumpUtils.getBookIdFromURI(str));
        bookInfoStudy.setJumpOpenChapter(com.up366.mobile.jump.JumpUtils.getChapterIdFromURI(str));
        bookInfoStudy.setJumpOpenPage(com.up366.mobile.jump.JumpUtils.getPagerIdFromURI(str));
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("qrCode", str);
        bookInfoStudy.setJumpCommonParams(jSONObject.toJSONString());
        intent.putExtra("book", bookInfoStudy);
        jump(context, intent);
    }

    public static void jump(android.content.Context context, android.content.Intent intent) {
        if (!(context instanceof com.up366.mobile.jump.JumpProxyActivity)) {
            if (intent == null) {
                com.up366.common.log.Logger.error("- jump  Error - intent is null");
                return;
            } else {
                context.startActivity(intent);
                ((android.app.Activity) context).finish();
                return;
            }
        }
        android.app.Activity activity = (android.app.Activity) context;
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        if (intent == null) {
            context.startActivity(new android.content.Intent(context, (java.lang.Class<?>) (com.up366.mobile.common.logic.Auth.isAuth() ? com.up366.mobile.main.MainActivity.class : com.up366.mobile.user.account.login.AccountLoginActivity.class)));
            activity.finish();
        } else {
            context.startActivities(new android.content.Intent[]{new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.main.MainActivity.class), intent});
            activity.finish();
        }
    }

    public static void onJumpError(android.content.Context context, java.lang.String str) {
        onJumpError(context, 0, str);
    }

    public static void onJumpError(android.content.Context context, final int i, final java.lang.String str) {
        if (!com.up366.common.StringUtils.isEmptyOrNull(str) && !str.contains("identityAuth")) {
            com.up366.common.task.TaskUtils.postLazyTaskGlobal("onJumpError", com.igexin.oppo.BuildConfig.VERSION_CODE, new com.up366.common.task.Task() { // from class: com.up366.mobile.jump.JumpIntentUtils$$ExternalSyntheticLambda4
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.ShowJumpErrorInfoEvent(i, str));
                }
            });
        }
        com.up366.common.log.Logger.warn("TAG - JumpProxyActivity - onJumpError - " + str);
        jump(context, null);
    }
}
