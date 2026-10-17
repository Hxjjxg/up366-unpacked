package com.up366.mobile.common.logic;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AuthMgr {
    public static final int AUTH_TYPE_QQ = 2;
    public static final int AUTH_TYPE_TOKEN = 3;
    public static final int AUTH_TYPE_USERNAME = 0;
    public static final int AUTH_TYPE_WECHAT = 1;
    private final java.lang.String KEY_TOURIST_USERNAME = "TouristUsername";
    private final java.lang.String KEY_TOURIST_UNIQUE_ID = "TouristUniqueId";
    private final java.lang.String KEY_TOURIST_PASSWD = "yk123456";
    private java.lang.String globalTouristUsername = null;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @interface AuthType {
    }

    static /* synthetic */ java.lang.String lambda$findUsernameByStudentNumber$10(com.up366.common.http.Response response, java.lang.String str) {
        return str;
    }

    public com.up366.common.http.NetHolder<java.lang.Object> doLogin(java.lang.String str, java.lang.String str2, boolean z) throws java.lang.InterruptedException {
        return doLoginSync(str, str2, z, 0, null);
    }

    public com.up366.common.http.NetHolder<java.lang.Object> doLoginSync(java.lang.String str, java.lang.String str2, boolean z, int i, java.lang.String str3, boolean z2) throws java.lang.InterruptedException {
        com.up366.common.http.NetHolder<java.lang.Object> netHolderValidateToken;
        int loginType = getLoginType(str, str2, z, i, z2);
        if (loginType != -1) {
            com.up366.mobile.user.account.login.StaticTimeLoginHelper.INSTANCE.startLogin(loginType);
        }
        if (i == 0) {
            netHolderValidateToken = validateUsernamePassword(str, str2);
        } else if (i == 1) {
            netHolderValidateToken = validateWeChat(str3, "");
        } else if (i == 2) {
            netHolderValidateToken = validateQQ(str3, "");
        } else if (i == 3) {
            netHolderValidateToken = validateToken(str3);
        } else {
            if (!z2) {
                com.up366.common.log.Logger.info("logout");
                logout();
            }
            com.up366.common.http.NetHolder<java.lang.Object> netHolder = new com.up366.common.http.NetHolder<>();
            netHolder.initWith(new com.up366.common.http.Response(-407, "", "authType错误:" + i, 0, null), null);
            return netHolder;
        }
        com.up366.common.http.NetHolder<java.lang.Object> netHolderOnLoginResponse = onLoginResponse(netHolderValidateToken.resp, z, i, str, str2, str3, z2);
        onLoginResultHandler(netHolderOnLoginResponse, i, z, z2);
        return netHolderOnLoginResponse;
    }

    private int getLoginType(java.lang.String str, java.lang.String str2, boolean z, int i, boolean z2) {
        if (z2) {
            return 7;
        }
        if (!z) {
            return 0;
        }
        if (i == 0) {
            return (str.startsWith("youke") && str2.equals("yk123456")) ? 6 : 1;
        }
        if (i == 1) {
            return 5;
        }
        if (i == 2) {
            return 4;
        }
        return i == 3 ? 0 : -1;
    }

    public com.up366.common.http.NetHolder<java.lang.Object> doLoginSync(java.lang.String str, java.lang.String str2, boolean z, int i, java.lang.String str3) throws java.lang.InterruptedException {
        return doLoginSync(str, str2, z, i, str3, false);
    }

    public com.up366.common.http.NetHolder<java.lang.Object> handleOnceLoginHolder(com.up366.common.http.NetHolder<java.lang.Object> netHolder, boolean z) throws java.lang.InterruptedException {
        com.up366.common.http.NetHolder<java.lang.Object> netHolderOnLoginResponse = onLoginResponse(netHolder.resp, true, 3, null, null, null, false);
        onLoginResultHandler(netHolderOnLoginResponse, 3, true, z);
        return netHolderOnLoginResponse;
    }

    private com.up366.common.http.NetHolder<java.lang.Object> onLoginResponse(com.up366.common.http.Response response, boolean z, int i, java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z2) throws java.lang.InterruptedException {
        com.up366.common.log.Logger.info("doLogin onLoginResponse code:" + response.getCode() + "   info:" + response.getInfo());
        com.up366.mobile.common.http.ErrCodeHandleV2.setHasInit();
        com.up366.common.http.NetHolder<java.lang.Object> netHolder = new com.up366.common.http.NetHolder<>();
        netHolder.initWith(response, null);
        if (response.getCode() == -26) {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(response.getResponse());
            if (object.getIntValue("uType") != 102) {
                response.setCode(-402);
                response.setInfo("只能使用学生账号登录");
                return netHolder;
            }
            if (z) {
                com.up366.common.http.NetHolder<java.lang.String> netHolderLoadPersonInfoOnManually = loadPersonInfoOnManually();
                netHolder.initWith(netHolderLoadPersonInfoOnManually.resp, netHolderLoadPersonInfoOnManually.info);
                if (netHolderLoadPersonInfoOnManually.resp.isError()) {
                    com.up366.mobile.common.onlinelog.OpLog.report("doLogin", "登录失败：" + netHolderLoadPersonInfoOnManually.resp.toString());
                    com.up366.common.log.Logger.error("登录时获取用户信息出错：" + netHolderLoadPersonInfoOnManually.resp.toString());
                    return netHolder;
                }
                if (i == 3) {
                    str3 = object.getString(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN);
                }
                com.up366.mobile.common.logic.user.UserInfo userInfo = new com.up366.mobile.common.logic.user.UserInfo(netHolderLoadPersonInfoOnManually.info);
                com.up366.mobile.common.logic.Auth.loginSuccess(userInfo.getUid(), str, str2, userInfo, i, str3, z2);
                com.up366.mobile.common.logic.Auth.cur().config().fetchAllSync();
                return netHolder;
            }
            if (com.up366.mobile.common.logic.Auth.UID() != object.getIntValue("uid")) {
                com.up366.mobile.common.onlinelog.OpLog.report("UID ERROR", "Auth.UID():" + com.up366.mobile.common.logic.Auth.UID() + "  Resp.getUid():" + object.getIntValue("uid"));
                com.up366.common.http.NetHolder<java.lang.String> netHolderLoadPersonInfoOnManually2 = loadPersonInfoOnManually();
                netHolder.initWith(netHolderLoadPersonInfoOnManually2.resp, netHolderLoadPersonInfoOnManually2.info);
                if (netHolderLoadPersonInfoOnManually2.resp.isError()) {
                    com.up366.mobile.common.onlinelog.OpLog.report("doLogin", "登录失败：" + netHolderLoadPersonInfoOnManually2.resp.toString());
                    com.up366.common.log.Logger.error("登录时获取用户信息出错：" + netHolderLoadPersonInfoOnManually2.resp.toString());
                    return netHolder;
                }
                com.up366.mobile.common.logic.user.UserInfo userInfo2 = new com.up366.mobile.common.logic.user.UserInfo(netHolderLoadPersonInfoOnManually2.info);
                com.up366.mobile.common.logic.Auth.loginSuccess(userInfo2.getUid(), str, str2, userInfo2, i, str3, z2);
                com.up366.mobile.common.logic.Auth.cur().config().fetchAllSync();
                return netHolder;
            }
            com.up366.mobile.common.logic.Auth.updateUserInfo(response.getResponse());
            response.setCode(0);
            response.setInfo("success");
            return netHolder;
        }
        if (response.getCode() == -27 || response.getCode() == -32 || response.getCode() == -29 || response.getCode() == -30 || response.getCode() == -31 || response.getCode() == -50) {
            if (com.up366.mobile.common.logic.Auth.isAuth() && !z2) {
                cache().putMemorySync(com.up366.mobile.common.base.Constants.APP_CACHE_AUTO_LOGIN_FAILED, response, com.igexin.push.config.c.i);
                com.up366.common.log.Logger.info("logout");
                logout();
            }
            com.up366.common.log.Logger.error("doLoginSSO - error gen tgt error : " + response);
            netHolder.initWith(response, null);
            return netHolder;
        }
        com.up366.common.log.Logger.error("doLoginSSO - error unknown error : " + response);
        com.up366.mobile.common.onlinelog.OpLog.report("doLogin", "unknown error : " + response);
        netHolder.initWith(response, null);
        return netHolder;
    }

    private void onLoginResultHandler(com.up366.common.http.NetHolder<java.lang.Object> netHolder, int i, final boolean z, final boolean z2) {
        if (netHolder.resp.isError()) {
            if (z) {
                com.up366.mobile.user.account.login.StaticTimeLoginHelper.INSTANCE.reset();
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.AuthLoginFailed(netHolder.resp.getCode(), netHolder.resp.getInfo()));
                return;
            }
            return;
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("logintype", java.lang.Integer.valueOf(i == 3 ? 1 : 2));
        jSONObject.put("autologin", java.lang.Boolean.valueOf(!z));
        com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.USER, com.up366.mobile.common.onlinelog.OpLogData.Control.LOGIN_STATE, com.up366.mobile.common.onlinelog.OpLogData.Event.LOG_IN, jSONObject);
        com.tencent.bugly.crashreport.CrashReport.setUserId(com.up366.mobile.common.logic.Auth.getUserInfo().getUsername());
        if (z) {
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.AuthMgr$$ExternalSyntheticLambda3
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    com.up366.mobile.common.logic.AuthMgr.lambda$onLoginResultHandler$0();
                }
            });
        }
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.AuthMgr$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.logic.AuthMgr.lambda$onLoginResultHandler$1(z, z2);
            }
        });
    }

    static /* synthetic */ void lambda$onLoginResultHandler$0() throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.cur().info().fetchBindingParentList(null);
        com.up366.mobile.common.logic.Auth.cur().info().uploadClientId();
    }

    static /* synthetic */ void lambda$onLoginResultHandler$1(boolean z, boolean z2) throws java.lang.Exception {
        com.up366.mobile.common.utils.CookieUtils.syncCookie();
        if (!z && com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - com.up366.mobile.common.logic.Auth.cur().config().getLastFetchAllSyncTime() > com.igexin.push.config.c.s) {
            com.up366.mobile.common.logic.Auth.cur().config().fetchAllSync();
        }
        com.up366.mobile.common.logic.Auth.cur().logMgr().decreaseTryCount();
        com.up366.mobile.common.logic.Auth.cur().logMgr().startBatchQueue();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put(com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel(), java.lang.Integer.valueOf(com.up366.mobile.BuildConfig.VERSION_CODE));
        jSONObject2.put(com.up366.mobile.BuildConfig.EXERCISE_MODEL, java.lang.Integer.valueOf(com.up366.mobile.book.exercise.ExerciseResourceHelper.getVersionNo()));
        jSONObject2.put(com.up366.mobile.BuildConfig.ASES_MODEL, java.lang.Integer.valueOf(com.up366.mobile.common.helper.AppResourceUpdateHelper.getAsesModelVersion()));
        jSONObject2.put(com.up366.mobile.BuildConfig.DICT_MODEL, java.lang.Integer.valueOf(com.up366.mobile.book.dict.DictResourceHelper.getVersionNo()));
        jSONObject.put("localVer", jSONObject2);
        com.up366.mobile.common.onlinelog.OpLog.report("login", "loginsuccess", com.up366.mobile.common.onlinelog.OpLogData.Event.OTHER, jSONObject);
        com.up366.mobile.common.logic.Auth.cur().cache().put("started-App-time", java.lang.Long.valueOf(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()), com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3);
        com.up366.mobile.common.logic.Auth.cur().fileMgr().cleanCacheFiles();
        com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.fetchP1pConfig();
        if (com.up366.mobile.common.utils.PlatformUtils.isCustomClosePad()) {
            com.up366.mobile.common.logic.AppConfigMgr.fetchDynamicConfig();
        }
        if (z) {
            com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync("login-success-tip", z2 ? "" : "登录成功", 1000L);
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.AuthLoginSuccess(z2));
        }
    }

    public com.up366.common.http.NetHolder<java.lang.Object> loginByToken(final java.lang.String str) throws java.lang.InterruptedException {
        java.lang.String str2;
        java.lang.String lowerCase;
        com.up366.common.http.NetHolder netHolderPostSync = com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.tokenLogin).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.common.logic.AuthMgr$$ExternalSyntheticLambda10
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                map.put(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, str);
            }
        }));
        if (netHolderPostSync.resp.getCode() == -26) {
            java.lang.String username = new com.up366.mobile.common.logic.user.UserInfo(netHolderPostSync.resp.getResponse()).getUsername();
            com.up366.mobile.common.utils.PreferenceUtils.putString("remember_uname", username);
            str2 = username;
            lowerCase = com.up366.common.digest.MD5.md5(com.up366.common.digest.MD5.md5("123456").toLowerCase() + "fa&s*l%$k!fq$k!ld@fjlk").toLowerCase();
        } else {
            str2 = null;
            lowerCase = null;
        }
        com.up366.common.http.NetHolder<java.lang.Object> netHolderOnLoginResponse = onLoginResponse(netHolderPostSync.resp, true, 0, str2, lowerCase, null, false);
        onLoginResultHandler(netHolderOnLoginResponse, 3, true, false);
        return netHolderOnLoginResponse;
    }

    private com.up366.common.http.NetHolder<java.lang.String> loadPersonInfoOnManually() throws java.lang.InterruptedException {
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.GET_USER_INFO));
    }

    private void logout() {
        com.up366.mobile.common.logic.Auth.logout();
    }

    public void getVerificationCode(java.lang.String str, com.up366.common.callback.ICallbackResponse<java.lang.Object> iCallbackResponse) {
        sendVerificationCode(str, 2, iCallbackResponse);
    }

    public void resetPassword(final java.lang.String str, final java.lang.String str2, final com.up366.common.callback.ICallbackResponse<java.lang.String> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.UPDATE_USER_PASSWORD) { // from class: com.up366.mobile.common.logic.AuthMgr.1
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                java.lang.String lowerCase = com.up366.common.digest.MD5.md5(com.up366.common.digest.MD5.md5(str2).toLowerCase() + "fa&s*l%$k!fq$k!ld@fjlk").toLowerCase();
                map.put("mobile", str);
                map.put("password", lowerCase);
                map.put("rePassword", lowerCase);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str3) {
                iCallbackResponse.onResult(response, str3);
            }
        });
    }

    public com.up366.common.http.NetHolder<java.lang.String> fetchWeakPassword() throws java.lang.InterruptedException {
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.WEAK_PASSWORD_LIST));
    }

    public void resetPassword(final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final int i, final com.up366.common.callback.ICallbackResponse<java.lang.String> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.UPDATE_PHONE_USER_PASSWORD) { // from class: com.up366.mobile.common.logic.AuthMgr.2
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("mobile", str);
                map.put("password", str2);
                map.put("rePassword", str2);
                map.put("verifyCode", str3);
                map.put("type", java.lang.Integer.valueOf(i));
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str4) {
                iCallbackResponse.onResult(response, str4);
            }
        });
    }

    public void transformPhonePassword(final java.lang.String str, final java.lang.String str2, final com.up366.common.callback.ICallbackResponse<java.lang.String> iCallbackResponse) {
        final java.lang.String utV2 = com.up366.common.StringUtils.getUtV2(str + str2, "changeMobileEncryptionParameter");
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.UPDATE_PHONE_TRANSFORM) { // from class: com.up366.mobile.common.logic.AuthMgr.3
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("mobile", str);
                map.put("password", str2);
                map.put("rePassword", str2);
                map.put(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, utV2);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str3) {
                iCallbackResponse.onResult(response, str3);
            }
        });
    }

    public void transformPhone(final java.lang.String str, final com.up366.common.callback.ICallbackResponse<java.lang.String> iCallbackResponse) {
        final java.lang.String utV2 = com.up366.common.StringUtils.getUtV2(str, "changeMobileEncryptionParameter");
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.UPDATE_PHONE_TRANSFORM) { // from class: com.up366.mobile.common.logic.AuthMgr.4
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("mobile", str);
                map.put(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, utV2);
                map.put("type", 2);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str2) {
                iCallbackResponse.onResult(response, str2);
            }
        });
    }

    public void checkVerifyCode(final java.lang.String str, final java.lang.String str2, final com.up366.common.callback.ICallbackResponse<java.lang.String> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.CHECK_VERIFY_CODE) { // from class: com.up366.mobile.common.logic.AuthMgr.5
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("mobile", str);
                map.put("verifyCode", str2);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str3) {
                iCallbackResponse.onResult(response, str3);
            }
        });
    }

    public void getVerificationCodeForRegister(java.lang.String str, com.up366.common.callback.ICallbackResponse iCallbackResponse) {
        sendVerificationCode(str, 1, iCallbackResponse);
    }

    public void registerUser(final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final java.lang.String str4, final com.up366.common.callback.ICallbackResponse iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.APP_REGISTER) { // from class: com.up366.mobile.common.logic.AuthMgr.6
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                java.lang.String lowerCase = com.up366.common.digest.MD5.md5(com.up366.common.digest.MD5.md5(str3).toLowerCase() + "fa&s*l%$k!fq$k!ld@fjlk").toLowerCase();
                map.put("mobile", str);
                map.put("type", "2");
                map.put("deviceType", "0");
                map.put("password", lowerCase);
                map.put("rePassword", lowerCase);
                map.put("verifyCode", str2);
                map.put(com.up366.mobile.common.event.WrongNoteRankOrderRefresh.RANK_TYPE_NAME, str4);
                map.put("userType", java.lang.Short.valueOf(com.up366.mobile.common.logic.user.UserInfo.USER_TYPE_STUDENT));
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                iCallbackResponse.onResult(response, obj);
            }
        });
    }

    public void sendVerificationCode(final java.lang.String str, final int i, final com.up366.common.callback.ICallbackResponse<java.lang.Object> iCallbackResponse) {
        final java.lang.String ut = com.up366.common.StringUtils.getUt(str, 33);
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.SEND_VERIFY_CODE) { // from class: com.up366.mobile.common.logic.AuthMgr.7
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("mobile", str);
                map.put("ut", ut);
                map.put("checkExists", java.lang.Integer.valueOf(i));
                map.put("utype", java.lang.Short.valueOf(com.up366.mobile.common.logic.user.UserInfo.USER_TYPE_STUDENT));
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                iCallbackResponse.onResult(response, obj);
            }
        });
    }

    public void findUserInfoByThirdParty(final int i, final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final java.lang.String str4, final java.lang.String str5, final com.up366.common.callback.ICallbackResponse<com.up366.mobile.common.logic.model.ThirdPartyUserInfo> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<com.up366.mobile.common.logic.model.ThirdPartyUserInfo>(com.up366.mobile.common.http.HttpMgrUtils.findUserInfoByThirdParty) { // from class: com.up366.mobile.common.logic.AuthMgr.8
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("type", java.lang.Integer.valueOf(i));
                if (i == 1) {
                    map.put("mobile", str);
                    map.put("verifyCode", str2);
                }
                if (i == 2) {
                    map.put(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, str3);
                }
                if (i == 3) {
                    map.put("weChatOpenId", str4);
                }
                if (i == 4) {
                    map.put("QQOpenId", str5);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.up366.common.http.RequestParams
            public com.up366.mobile.common.logic.model.ThirdPartyUserInfo handleResponse(com.up366.common.http.Response response, java.lang.String str6) {
                return (com.up366.mobile.common.logic.model.ThirdPartyUserInfo) com.up366.mobile.common.utils.ResponseUtil.parseObject(str6, com.up366.mobile.common.logic.model.ThirdPartyUserInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, com.up366.mobile.common.logic.model.ThirdPartyUserInfo thirdPartyUserInfo) {
                iCallbackResponse.onResult(response, thirdPartyUserInfo);
            }
        });
    }

    public void flashTokenValidate(final java.lang.String str, final com.up366.common.callback.ICallbackResponse<com.up366.mobile.common.logic.model.ShanYanMobileInfo> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<com.up366.mobile.common.logic.model.ShanYanMobileInfo>(com.up366.mobile.common.http.HttpMgrUtils.flashTokenValidate) { // from class: com.up366.mobile.common.logic.AuthMgr.9
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, str);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.up366.common.http.RequestParams
            public com.up366.mobile.common.logic.model.ShanYanMobileInfo handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                return (com.up366.mobile.common.logic.model.ShanYanMobileInfo) com.up366.mobile.common.utils.ResponseUtil.parseObject(str2, com.up366.mobile.common.logic.model.ShanYanMobileInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, com.up366.mobile.common.logic.model.ShanYanMobileInfo shanYanMobileInfo) {
                iCallbackResponse.onResult(response, shanYanMobileInfo);
            }
        });
    }

    public void fetchAccountDictList(int i, com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.common.logic.model.AccountCityInfo>> iCallbackResponse) {
        java.lang.String str;
        if (i != 1) {
            str = com.up366.mobile.common.http.HttpMgrUtils.accountDictList;
        } else {
            str = com.up366.mobile.common.http.HttpMgrUtils.accountDictListV2;
        }
        com.up366.common.http.HttpUtilsUp.post(new com.up366.mobile.common.logic.AuthMgr.AnonymousClass10(str, iCallbackResponse));
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.logic.AuthMgr$10, reason: invalid class name */
    class AnonymousClass10 extends com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.common.logic.model.AccountCityInfo>> {
        final /* synthetic */ com.up366.common.callback.ICallbackResponse val$callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass10(java.lang.String str, com.up366.common.callback.ICallbackResponse iCallbackResponse) {
            super(str);
            this.val$callback = iCallbackResponse;
        }

        @Override // com.up366.common.http.RequestParams
        public java.util.List<com.up366.mobile.common.logic.model.AccountCityInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
            java.util.List<com.up366.mobile.common.logic.model.AccountCityInfo> array = com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.common.logic.model.AccountCityInfo.class);
            java.util.Collections.sort(array, new java.util.Comparator() { // from class: com.up366.mobile.common.logic.AuthMgr$10$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                    return ((com.up366.mobile.common.logic.model.AccountCityInfo) obj).getCityNamePinyin().compareToIgnoreCase(((com.up366.mobile.common.logic.model.AccountCityInfo) obj2).getCityNamePinyin());
                }
            });
            return array;
        }

        @Override // com.up366.common.http.RequestParams
        public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.common.logic.model.AccountCityInfo> list) {
            super.onResponse(response, list);
            this.val$callback.onResult(response, list);
        }
    }

    public void fetchAccountOrganList(int i, java.lang.String str, com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.common.logic.model.AccountOrganInfo>> iCallbackResponse) {
        java.lang.String str2;
        if (i != 1) {
            str2 = com.up366.mobile.common.http.HttpMgrUtils.accountOrganList;
        } else {
            str2 = com.up366.mobile.common.http.HttpMgrUtils.accountOrganListV2;
        }
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.common.logic.model.AccountOrganInfo>>(str2, str, iCallbackResponse) { // from class: com.up366.mobile.common.logic.AuthMgr.11
            final java.lang.String ut;
            final /* synthetic */ com.up366.common.callback.ICallbackResponse val$callback;
            final /* synthetic */ java.lang.String val$cityId;

            {
                this.val$cityId = str;
                this.val$callback = iCallbackResponse;
                this.ut = com.up366.common.StringUtils.getUt(str, 91);
            }

            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put("cityId", this.val$cityId);
                map.put("ut", this.ut);
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.common.logic.model.AccountOrganInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str3) {
                return com.up366.mobile.common.utils.ResponseUtil.parseArray(str3, com.up366.mobile.common.logic.model.AccountOrganInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.common.logic.model.AccountOrganInfo> list) {
                super.onResponse(response, list);
                this.val$callback.onResult(response, list);
            }
        });
    }

    public void fetchAccountFindClassList(java.lang.String str, java.lang.String str2, com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.common.logic.model.AccountClassInfo>> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.common.logic.model.AccountClassInfo>>(com.up366.mobile.common.http.HttpMgrUtils.accountFindClassList, str, str2, iCallbackResponse) { // from class: com.up366.mobile.common.logic.AuthMgr.12
            java.lang.String ut;
            final /* synthetic */ com.up366.common.callback.ICallbackResponse val$callback;
            final /* synthetic */ java.lang.String val$organId;
            final /* synthetic */ java.lang.String val$realName;

            {
                this.val$organId = str;
                this.val$realName = str2;
                this.val$callback = iCallbackResponse;
                this.ut = com.up366.common.StringUtils.getUt(str + str2, 91);
            }

            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put("organId", this.val$organId);
                map.put(com.up366.mobile.common.event.WrongNoteRankOrderRefresh.RANK_TYPE_NAME, this.val$realName);
                map.put("ut", this.ut);
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.common.logic.model.AccountClassInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str3) {
                return com.up366.mobile.common.utils.ResponseUtil.parseArray(str3, com.up366.mobile.common.logic.model.AccountClassInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.common.logic.model.AccountClassInfo> list) {
                super.onResponse(response, list);
                this.val$callback.onResult(response, list);
            }
        });
    }

    public void fetchAccountUserList(java.lang.String str, java.lang.String str2, com.up366.common.callback.ICallbackResponse<java.util.List<java.lang.String>> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<java.lang.String>>(com.up366.mobile.common.http.HttpMgrUtils.accountUserList, str, str2, iCallbackResponse) { // from class: com.up366.mobile.common.logic.AuthMgr.13
            java.lang.String ut;
            final /* synthetic */ com.up366.common.callback.ICallbackResponse val$callback;
            final /* synthetic */ java.lang.String val$classId;
            final /* synthetic */ java.lang.String val$realName;

            {
                this.val$classId = str;
                this.val$realName = str2;
                this.val$callback = iCallbackResponse;
                this.ut = com.up366.common.StringUtils.getUt(str + str2, 91);
            }

            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put("classId", this.val$classId);
                map.put(com.up366.mobile.common.event.WrongNoteRankOrderRefresh.RANK_TYPE_NAME, this.val$realName);
                map.put("ut", this.ut);
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<java.lang.String> handleResponse(com.up366.common.http.Response response, java.lang.String str3) {
                return com.up366.mobile.common.utils.ResponseUtil.parseArray(str3, java.lang.String.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<java.lang.String> list) {
                super.onResponse(response, list);
                this.val$callback.onResult(response, list);
            }
        });
    }

    public void fetchAccountUserVerify(java.lang.String str, java.lang.String str2, java.lang.String str3, com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.common.logic.model.AccountUserInfo>> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.common.logic.model.AccountUserInfo>>(com.up366.mobile.common.http.HttpMgrUtils.accountUserVerify, str, str2, str3, iCallbackResponse) { // from class: com.up366.mobile.common.logic.AuthMgr.14
            java.lang.String ut;
            final /* synthetic */ com.up366.common.callback.ICallbackResponse val$callback;
            final /* synthetic */ java.lang.String val$classId;
            final /* synthetic */ java.lang.String val$classMateNames;
            final /* synthetic */ java.lang.String val$realName;

            {
                this.val$classId = str;
                this.val$realName = str2;
                this.val$classMateNames = str3;
                this.val$callback = iCallbackResponse;
                this.ut = com.up366.common.StringUtils.getUt(str + str2 + str3, 91);
            }

            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put("classId", this.val$classId);
                map.put(com.up366.mobile.common.event.WrongNoteRankOrderRefresh.RANK_TYPE_NAME, this.val$realName);
                map.put("classMateNames", this.val$classMateNames);
                map.put("ut", this.ut);
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.common.logic.model.AccountUserInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str4) {
                return com.up366.mobile.common.utils.ResponseUtil.parseArray(str4, com.up366.mobile.common.logic.model.AccountUserInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.common.logic.model.AccountUserInfo> list) {
                super.onResponse(response, list);
                this.val$callback.onResult(response, list);
            }
        });
    }

    public void fetchCurrentCityInfo(final com.up366.common.callback.ICallbackResponse<com.up366.mobile.common.logic.model.AccountCityInfo> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<com.up366.mobile.common.logic.model.AccountCityInfo>(com.up366.mobile.common.http.HttpMgrUtils.getLocationByIP) { // from class: com.up366.mobile.common.logic.AuthMgr.15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.up366.common.http.RequestParams
            public com.up366.mobile.common.logic.model.AccountCityInfo handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                com.up366.mobile.common.logic.model.AccountCityInfo accountCityInfo = new com.up366.mobile.common.logic.model.AccountCityInfo();
                com.alibaba.fastjson.JSONObject object = com.up366.mobile.common.utils.ResponseUtil.parseObject(str);
                accountCityInfo.setCityId(object.getString(com.igexin.push.core.b.C));
                accountCityInfo.setCityName(object.getString("name"));
                return accountCityInfo;
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, com.up366.mobile.common.logic.model.AccountCityInfo accountCityInfo) {
                com.up366.common.log.Logger.info("TAG - AuthMgr - fetchCurrentCityInfo - handleResponse - resp = [" + response + "]");
                super.onResponse(response, accountCityInfo);
                iCallbackResponse.onResult(response, accountCityInfo);
            }
        });
    }

    private com.up366.common.http.NetHolder<java.lang.Object> validateUsernamePassword(final java.lang.String str, final java.lang.String str2) throws java.lang.InterruptedException {
        final java.lang.String ut = com.up366.common.StringUtils.getUt(str + str2, 22);
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.tickets).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.common.logic.AuthMgr$$ExternalSyntheticLambda7
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                com.up366.mobile.common.logic.AuthMgr.lambda$validateUsernamePassword$3(str, str2, ut, map);
            }
        }));
    }

    static /* synthetic */ void lambda$validateUsernamePassword$3(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map map) {
        map.put("username", str);
        map.put("password", str2);
        map.put("ut", str3);
        map.put("utype", java.lang.Short.valueOf(com.up366.mobile.common.logic.user.UserInfo.USER_TYPE_STUDENT));
    }

    public com.up366.common.http.NetHolder<java.lang.Object> validateMobileCode(final java.lang.String str, final java.lang.String str2) throws java.lang.InterruptedException {
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.ticketsCode).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.common.logic.AuthMgr$$ExternalSyntheticLambda8
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                com.up366.mobile.common.logic.AuthMgr.lambda$validateMobileCode$4(str, str2, map);
            }
        }));
    }

    static /* synthetic */ void lambda$validateMobileCode$4(java.lang.String str, java.lang.String str2, java.util.Map map) {
        map.put("mobile", str);
        map.put("verifyCode", str2);
    }

    public com.up366.common.http.NetHolder<java.lang.Object> validateFlash(final java.lang.String str) throws java.lang.InterruptedException {
        final java.lang.String ut = com.up366.common.StringUtils.getUt(str, 22);
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.ticketsFlash).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.common.logic.AuthMgr$$ExternalSyntheticLambda9
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                com.up366.mobile.common.logic.AuthMgr.lambda$validateFlash$5(str, ut, map);
            }
        }));
    }

    static /* synthetic */ void lambda$validateFlash$5(java.lang.String str, java.lang.String str2, java.util.Map map) {
        map.put(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, str);
        map.put("ut", str2);
    }

    private com.up366.common.http.NetHolder<java.lang.Object> validateToken(final java.lang.String str) throws java.lang.InterruptedException {
        final java.lang.String ut = com.up366.common.StringUtils.getUt(str, 22);
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.ticketsToken).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.common.logic.AuthMgr$$ExternalSyntheticLambda2
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                com.up366.mobile.common.logic.AuthMgr.lambda$validateToken$6(str, ut, map);
            }
        }));
    }

    static /* synthetic */ void lambda$validateToken$6(java.lang.String str, java.lang.String str2, java.util.Map map) {
        map.put(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, str);
        map.put("ut", str2);
    }

    public com.up366.common.http.NetHolder<java.lang.Object> validateWeChat(final java.lang.String str, final java.lang.String str2) throws java.lang.InterruptedException {
        final java.lang.String ut = com.up366.common.StringUtils.getUt(str + str2, 22);
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.validateWeChat).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.common.logic.AuthMgr$$ExternalSyntheticLambda6
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                com.up366.mobile.common.logic.AuthMgr.lambda$validateWeChat$7(str, str2, ut, map);
            }
        }));
    }

    static /* synthetic */ void lambda$validateWeChat$7(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map map) {
        map.put("openId", str);
        if (!com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            map.put("accessToken", str2);
        }
        map.put("ut", str3);
    }

    public com.up366.common.http.NetHolder<java.lang.Object> validateQQ(final java.lang.String str, final java.lang.String str2) throws java.lang.InterruptedException {
        final java.lang.String ut = com.up366.common.StringUtils.getUt(str + str2, 22);
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.validateQQ).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.common.logic.AuthMgr$$ExternalSyntheticLambda1
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                com.up366.mobile.common.logic.AuthMgr.lambda$validateQQ$8(str, str2, ut, map);
            }
        }));
    }

    static /* synthetic */ void lambda$validateQQ$8(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map map) {
        map.put("openId", str);
        if (!com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            map.put("accessToken", str2);
        }
        map.put("ut", str3);
    }

    public void validateWeChatNoLogin(java.lang.String str, java.lang.String str2, com.up366.common.callback.ICallbackResponse<java.lang.Object> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.validateWeChatNoLogin, str, str2, iCallbackResponse) { // from class: com.up366.mobile.common.logic.AuthMgr.16
            java.lang.String ut;
            final /* synthetic */ java.lang.String val$accessToken;
            final /* synthetic */ com.up366.common.callback.ICallbackResponse val$callback;
            final /* synthetic */ java.lang.String val$openId;

            {
                this.val$openId = str;
                this.val$accessToken = str2;
                this.val$callback = iCallbackResponse;
                this.ut = com.up366.common.StringUtils.getUt(str + str2, 22);
            }

            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put("openId", this.val$openId);
                map.put("accessToken", this.val$accessToken);
                map.put("ut", this.ut);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.common.log.Logger.info("TAG - AuthMgr - validateWeChatNoLogin - handleResponse - resp = [" + response + "]");
                super.onResponse(response, obj);
                this.val$callback.onResult(response, obj);
            }
        });
    }

    public void validateQQNoLogin(java.lang.String str, java.lang.String str2, com.up366.common.callback.ICallbackResponse<java.lang.Object> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.validateQQNoLogin, str, str2, iCallbackResponse) { // from class: com.up366.mobile.common.logic.AuthMgr.17
            java.lang.String ut;
            final /* synthetic */ java.lang.String val$accessToken;
            final /* synthetic */ com.up366.common.callback.ICallbackResponse val$callback;
            final /* synthetic */ java.lang.String val$openId;

            {
                this.val$openId = str;
                this.val$accessToken = str2;
                this.val$callback = iCallbackResponse;
                this.ut = com.up366.common.StringUtils.getUt(str + str2, 22);
            }

            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put("openId", this.val$openId);
                map.put("accessToken", this.val$accessToken);
                map.put("ut", this.ut);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.common.log.Logger.info("TAG - AuthMgr - validateQQNoLogin - handleResponse - resp = [" + response + "]");
                super.onResponse(response, obj);
                this.val$callback.onResult(response, obj);
            }
        });
    }

    public com.up366.mobile.common.logic.AppCacheMgr cache() {
        return com.up366.mobile.common.logic.Auth.uid(-1).cache();
    }

    public com.up366.common.http.NetHolder<java.lang.String> findUsernameByStudentNumber(final java.lang.String str, final java.lang.String str2) throws java.lang.InterruptedException {
        final java.lang.String ut = com.up366.common.StringUtils.getUt(str + str2, 91);
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.findUserNameByStudentNumber).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.common.logic.AuthMgr$$ExternalSyntheticLambda0
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                com.up366.mobile.common.logic.AuthMgr.lambda$findUsernameByStudentNumber$9(ut, str, str2, map);
            }
        }).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.common.logic.AuthMgr$$ExternalSyntheticLambda5
            @Override // com.up366.common.http.RequestParams.IHandleResponse
            public final java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str3) {
                return com.up366.mobile.common.logic.AuthMgr.lambda$findUsernameByStudentNumber$10(response, str3);
            }
        }));
    }

    static /* synthetic */ void lambda$findUsernameByStudentNumber$9(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map map) {
        map.put("ut", str);
        map.put("organId", str2);
        map.put("reserved1", str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.up366.common.http.NetHolder<java.lang.String> getTouristUsername() throws java.lang.InterruptedException {
        java.lang.String targetHost = com.up366.mobile.common.utils.PlatformUtils.getTargetHost();
        com.up366.common.log.Logger.info("TAG - AuthMgr - getTouristUsername - target:" + targetHost);
        java.lang.String string = com.up366.mobile.common.utils.PreferenceUtils.getString("TouristUsername" + targetHost, "");
        if (android.text.TextUtils.isEmpty(string)) {
            java.lang.String string2 = com.up366.mobile.common.utils.PreferenceUtils.getString("TouristUniqueId", java.lang.String.valueOf(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()));
            com.up366.mobile.common.utils.PreferenceUtils.putString("TouristUniqueId", string2);
            final java.lang.String str = com.up366.mobile.common.helper.DeviceIdHelper.getDeviceId() + "-" + string2;
            final java.lang.String ut = com.up366.common.StringUtils.getUt(str, 92);
            com.up366.common.http.NetHolder netHolderPostSync = com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.userAutoCreate).addHeaders(new com.up366.common.http.RequestParams.IAddHeaders() { // from class: com.up366.mobile.common.logic.AuthMgr$$ExternalSyntheticLambda11
                @Override // com.up366.common.http.RequestParams.IAddHeaders
                public final void addHeaders(java.util.Map map) {
                    map.put("clientId", str);
                }
            }).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.common.logic.AuthMgr$$ExternalSyntheticLambda12
                @Override // com.up366.common.http.RequestParams.IAddParams
                public final void addParams(java.util.Map map) {
                    map.put("ut", ut);
                }
            }).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.common.logic.AuthMgr$$ExternalSyntheticLambda13
                @Override // com.up366.common.http.RequestParams.IHandleResponse
                public final java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                    return com.alibaba.fastjson.JSONObject.parseObject(str2).getString("username");
                }
            }));
            if (netHolderPostSync.resp.isError()) {
                com.up366.common.http.NetHolder<java.lang.String> netHolder = new com.up366.common.http.NetHolder<>();
                netHolder.initWith(netHolderPostSync.resp, (java.lang.String) netHolderPostSync.info);
                return netHolder;
            }
            java.lang.String str2 = (java.lang.String) netHolderPostSync.info;
            if (!android.text.TextUtils.isEmpty(str2)) {
                com.up366.common.log.Logger.info("TAG - AuthMgr - getTouristUsername - touristUsername :" + str2 + " clientId:" + str);
                java.lang.StringBuilder sb = new java.lang.StringBuilder("TouristUsername");
                sb.append(targetHost);
                com.up366.mobile.common.utils.PreferenceUtils.putString(sb.toString(), str2);
            }
            string = str2;
        }
        com.up366.common.http.NetHolder<java.lang.String> netHolder2 = new com.up366.common.http.NetHolder<>();
        netHolder2.initWith(new com.up366.common.http.Response(0, "", "", 0, null), string);
        return netHolder2;
    }

    public com.up366.common.http.NetHolder<java.lang.Object> loginTourist(java.lang.String str) throws java.lang.InterruptedException {
        com.up366.common.log.Logger.info("TAG - AuthMgr - loginTourist - ");
        com.up366.common.http.NetHolder<java.lang.Object> netHolderDoLoginSync = doLoginSync(str, "yk123456", true, 0, null);
        if (!netHolderDoLoginSync.resp.isError()) {
            this.globalTouristUsername = str;
        }
        return netHolderDoLoginSync;
    }

    public boolean isTouristUsername(java.lang.String str) {
        if (this.globalTouristUsername == null) {
            this.globalTouristUsername = com.up366.mobile.common.utils.PreferenceUtils.getString("TouristUsername" + com.up366.mobile.common.utils.PlatformUtils.getTargetHost(), "$$$$$$$$");
        }
        return android.text.TextUtils.equals(str, this.globalTouristUsername);
    }
}
