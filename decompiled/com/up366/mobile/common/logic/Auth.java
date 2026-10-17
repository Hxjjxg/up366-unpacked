package com.up366.mobile.common.logic;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class Auth {
    private static boolean auth;
    private static com.up366.mobile.common.logic.AuthMgr authMgr;
    private static int uid;
    private static final android.util.SparseArray<com.up366.mobile.common.logic.Manager> mgrMap = new android.util.SparseArray<>();
    private static com.up366.mobile.common.logic.user.UserInfo userInfo = new com.up366.mobile.common.logic.user.UserInfo();

    public static com.up366.mobile.common.logic.Manager cur() {
        int i = uid;
        android.util.SparseArray<com.up366.mobile.common.logic.Manager> sparseArray = mgrMap;
        if (sparseArray.get(i) == null) {
            com.up366.common.log.Logger.info("TAG - Auth - cur - get manager uid:" + i);
            synchronized (com.up366.mobile.common.logic.Manager.class) {
                if (sparseArray.get(i) == null) {
                    com.up366.common.log.Logger.info("TAG - Auth - cur - create begin uid:" + i);
                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                    sparseArray.put(i, new com.up366.mobile.common.logic.Manager(i));
                    com.up366.common.log.Logger.info("TAG - Auth - cur - create end uid:" + i);
                    com.up366.common.log.Logger.info("count Auth.cur create time : " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                }
            }
        }
        return sparseArray.get(i);
    }

    public static com.up366.mobile.common.logic.Manager uid(int i) {
        android.util.SparseArray<com.up366.mobile.common.logic.Manager> sparseArray = mgrMap;
        if (sparseArray.get(i) == null) {
            com.up366.common.log.Logger.info("TAG - Auth - uid - get manager uid:" + i);
            synchronized (com.up366.mobile.common.logic.Manager.class) {
                if (sparseArray.get(i) == null) {
                    com.up366.common.log.Logger.info("TAG - Auth - uid - create begin uid:" + i);
                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                    sparseArray.put(i, new com.up366.mobile.common.logic.Manager(i));
                    com.up366.common.log.Logger.info("TAG - Auth - uid - create end uid:" + i);
                    com.up366.common.log.Logger.info("count Auth.uid create time : " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                }
            }
        }
        return sparseArray.get(i);
    }

    public static boolean isAuth() {
        return auth;
    }

    public static com.up366.mobile.common.logic.AuthMgr mgr() {
        if (authMgr == null) {
            authMgr = new com.up366.mobile.common.logic.AuthMgr();
        }
        return authMgr;
    }

    public static com.up366.mobile.common.logic.user.UserInfo getUserInfo() {
        return userInfo;
    }

    public static int UID() {
        return uid;
    }

    public static void logout() {
        com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.USER, com.up366.mobile.common.onlinelog.OpLogData.Control.LOGIN_STATE, com.up366.mobile.common.onlinelog.OpLogData.Event.LOG_OUT, new com.alibaba.fastjson.JSONObject());
        cur().getPrivateCloudMgr().stopPrivateCloudModel(true);
        com.up366.mobile.user.account.switchaccount.SwitchAccountHelper.INSTANCE.deleteAccount(userInfo.getUid());
        com.up366.mobile.main.PhonePasswordUpdateHelper.INSTANCE.removeAccount(userInfo.getUid());
        uid = 0;
        auth = false;
        userInfo.initWithJSONStr("{\"uid\":0,\"schoolType\":3}");
        com.up366.mobile.common.utils.PreferenceUtils.putText("auth-info-v2", "");
        com.up366.mobile.common.utils.PreferenceUtils.putText("user-info", "");
        com.up366.mobile.common.utils.PreferenceUtils.putText("auth-info", "");
        com.up366.common.http.HttpUtilsUp.clearCookies();
        com.up366.common.http.HttpUtilsUp.clearHttpCache();
        com.up366.mobile.common.utils.CookieUtils.clearAllCookie();
        com.up366.mobile.common.utils.CookieUtils.handleGrayCookie();
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("course-list").invalid();
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("my-products").invalid();
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.AuthLoginout());
        final android.content.Context applicationContext = com.up366.common.global.GB.get().getApplicationContext();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.Auth$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.user.account.login.AccountLoginActivity.open(applicationContext);
            }
        });
    }

    public static void cleanCookiesWhenSwitchAccount() {
        com.up366.common.http.HttpUtilsUp.clearCookies();
        com.up366.common.http.HttpUtilsUp.clearHttpCache();
        com.up366.mobile.common.utils.CookieUtils.clearAllCookie();
    }

    public static void logoutNoSkip() {
        cur().getPrivateCloudMgr().stopPrivateCloudModel(true);
        com.up366.mobile.user.account.switchaccount.SwitchAccountHelper.INSTANCE.deleteAccount(userInfo.getUid());
        uid = 0;
        auth = false;
        userInfo.initWithJSONStr("{\"uid\":0,\"schoolType\":3}");
        com.up366.mobile.common.utils.PreferenceUtils.putTextSync("auth-info-v2", "");
        com.up366.mobile.common.utils.PreferenceUtils.putTextSync("user-info", "");
        com.up366.mobile.common.utils.PreferenceUtils.putTextSync("auth-info", "");
        com.up366.common.http.HttpUtilsUp.clearCookies();
        com.up366.common.http.HttpUtilsUp.clearHttpCache();
        com.up366.mobile.common.utils.CookieUtils.clearAllCookie();
        com.up366.mobile.common.utils.CookieUtils.handleGrayCookie();
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("course-list").invalid();
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("my-products").invalid();
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.AuthLoginout());
    }

    public static boolean noAuth() {
        return !auth;
    }

    public static void loginSuccess(int i, java.lang.String str, final java.lang.String str2, final com.up366.mobile.common.logic.user.UserInfo userInfo2, final int i2, final java.lang.String str3, boolean z) {
        if (z) {
            com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.USER, com.up366.mobile.common.onlinelog.OpLogData.Control.LOGIN_STATE, com.up366.mobile.common.onlinelog.OpLogData.Event.LOG_OUT, new com.alibaba.fastjson.JSONObject());
        }
        uid = i;
        userInfo = userInfo2;
        auth = true;
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("uid", java.lang.Integer.valueOf(i));
        jSONObject.put("username", str);
        jSONObject.put("password", str2);
        jSONObject.put("auth", java.lang.Boolean.valueOf(auth));
        jSONObject.put("authType", java.lang.Integer.valueOf(i2));
        jSONObject.put("openId", str3);
        com.up366.mobile.common.utils.PreferenceUtils.putTextSync("auth-info-v2", jSONObject.toJSONString());
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("course-list").invalid();
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("my-products").invalid();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.Auth$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.user.account.switchaccount.SwitchAccountHelper.INSTANCE.saveAccount(str2, userInfo2, i2, str3);
            }
        });
    }

    public static void updateAuthInfo(final int i, final java.lang.String str, final java.lang.String str2) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("uid", java.lang.Integer.valueOf(i));
        jSONObject.put("username", str);
        jSONObject.put("password", str2);
        jSONObject.put("auth", java.lang.Boolean.valueOf(auth));
        final int i2 = 0;
        jSONObject.put("authType", 0);
        final java.lang.String str3 = "";
        jSONObject.put("openId", "");
        com.up366.mobile.common.utils.PreferenceUtils.putTextSync("auth-info-v2", jSONObject.toJSONString());
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.Auth$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.user.account.switchaccount.SwitchAccountHelper.INSTANCE.updateAccount(i, str2, str, i2, str3);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void init() {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.common.logic.Auth.init():void");
    }

    public static com.up366.common.http.NetHolder<java.lang.Object> autoLoginSync() throws java.lang.InterruptedException {
        com.up366.common.log.Logger.info("TAG - Auth - autoLoginSync - ");
        com.up366.common.http.NetHolder<java.lang.Object> netHolder = new com.up366.common.http.NetHolder<>();
        com.up366.common.http.Response response = new com.up366.common.http.Response(-404, "", "info", 0, null);
        netHolder.initWith(response, null);
        if (!auth) {
            response.setCode(-405);
            response.setInfo("未登录");
            return netHolder;
        }
        java.lang.String text = com.up366.mobile.common.utils.PreferenceUtils.getText("auth-info-v2", "");
        if (com.up366.common.StringUtils.isEmptyOrNull(text)) {
            uid = 0;
            auth = false;
            response.setCode(-406);
            response.setInfo("登录信息为空");
            return netHolder;
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(text);
        uid = object.getIntValue("uid");
        return mgr().doLoginSync(object.getString("username"), object.getString("password"), false, object.getIntValue("authType"), object.getString("openId"));
    }

    public static java.lang.String getPassword() {
        java.lang.String text = com.up366.mobile.common.utils.PreferenceUtils.getText("auth-info-v2", "");
        if (com.up366.common.StringUtils.isEmptyOrNull(text)) {
            return "noLogin";
        }
        return com.alibaba.fastjson.JSON.parseObject(text).getString("password");
    }

    public static java.lang.String getRealName() {
        if (!isAuth()) {
            return "同学-" + com.up366.common.global.GB.get().getUniqueDeviceId().substring(r0.length() - 3);
        }
        return getUserInfo().getRealname();
    }

    public static boolean isTourist() {
        if (isAuth()) {
            return mgr().isTouristUsername(userInfo.getUsername());
        }
        return false;
    }

    public static void updateUserInfo(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return;
        }
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
            if (object != null) {
                java.lang.String string = object.getString("mobile");
                java.lang.String string2 = object.getString(com.up366.mobile.common.event.WrongNoteRankOrderRefresh.RANK_TYPE_NAME);
                int intValue = object.getIntValue("organId");
                int intValue2 = object.getIntValue("uType");
                java.lang.String string3 = object.getString("username");
                int intValue3 = object.getIntValue("weakPwd");
                int intValue4 = object.getIntValue("backupPwd");
                userInfo.setWeakPwdFlag(intValue3);
                userInfo.setTempPwdFlag(intValue4);
                userInfo.setMobile(string);
                userInfo.setRealname(string2);
                userInfo.setOrganId(intValue);
                userInfo.setUtype(intValue2);
                userInfo.setUsername(string3);
                userInfo.updateJson();
                com.up366.common.http.Response response = new com.up366.common.http.Response();
                response.setCode(0);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.RefreshUserInfo(response, userInfo));
                com.up366.common.log.Logger.info("TAG - Auth - updateUserInfo - userInfo updated: " + str);
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - Auth - updateUserInfo - ", e);
        }
    }

    public static int userType() {
        return userInfo.getUtype();
    }

    public static void autoLoginSyncForH5() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.Auth$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.logic.Auth.lambda$autoLoginSyncForH5$3();
            }
        });
    }

    static /* synthetic */ void lambda$autoLoginSyncForH5$3() throws java.lang.Exception {
        try {
            com.up366.common.http.NetHolder<java.lang.Object> netHolderAutoLoginSync = autoLoginSync();
            if (netHolderAutoLoginSync.resp.isError()) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.UpdateCookiesEvent(netHolderAutoLoginSync.resp.getCode()));
            } else {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.UpdateCookiesEvent(0));
            }
            com.up366.common.log.Logger.info("TAG - Auth - autoLoginSyncForH5 - auto login for h5 done, code:");
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - Auth - autoLoginSyncForH5 - ", e);
        }
    }
}
