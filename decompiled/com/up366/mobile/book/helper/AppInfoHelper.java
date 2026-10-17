package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppInfoHelper {
    private final android.app.Activity context;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public AppInfoHelper(android.app.Activity activity, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
        this.context = activity;
        this.webView = studyPageWebView;
    }

    public java.lang.String getClientInfo() {
        return getClientInfoV7();
    }

    public java.lang.String getClientInfoV7() {
        java.lang.String string = this.context.getString(com.up366.mobile.R.string.js_interface_client_info_prefix_v7);
        androidx.core.util.Supplier supplier = new androidx.core.util.Supplier() { // from class: com.up366.mobile.book.helper.AppInfoHelper$$ExternalSyntheticLambda0
            public final java.lang.Object get() {
                return com.up366.mobile.book.helper.AppInfoHelper.lambda$getClientInfoV7$0();
            }
        };
        return string + com.up366.common.PackageUtils.getVersionName() + "-" + com.up366.mobile.common.helper.DeviceIdHelper.getDeviceId() + "-" + ((java.lang.String) supplier.get()) + "-ANDROID";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.String lambda$getClientInfoV7$0() {
        /*
            java.lang.String r0 = com.up366.mobile.common.utils.PlatformUtils.getTargetHost()
            int r1 = r0.hashCode()
            r2 = 2
            r3 = 1
            switch(r1) {
                case -1284762386: goto L2f;
                case -548733026: goto L24;
                case -121843615: goto L19;
                case 772114063: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L3a
        Le:
            java.lang.String r1 = "up366test.cn"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3a
            r0 = 0
            goto L3b
        L19:
            java.lang.String r1 = "up366.cn"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3a
            r0 = 3
            goto L3b
        L24:
            java.lang.String r1 = "up366demo.cn"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3a
            r0 = r3
            goto L3b
        L2f:
            java.lang.String r1 = "up366.com.cn"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3a
            r0 = r2
            goto L3b
        L3a:
            r0 = -1
        L3b:
            if (r0 == 0) goto L4a
            if (r0 == r3) goto L47
            if (r0 == r2) goto L44
            java.lang.String r0 = "PRODUCT"
            return r0
        L44:
            java.lang.String r0 = "UAT"
            return r0
        L47:
            java.lang.String r0 = "DEMO"
            return r0
        L4a:
            java.lang.String r0 = "TEST"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.helper.AppInfoHelper.lambda$getClientInfoV7$0():java.lang.String");
    }

    public com.alibaba.fastjson.JSONObject getAppInfo(java.lang.String str) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("SDKVersion", com.up366.mobile.book.helper.Tools.SDK_VERSION);
        jSONObject.put("env", com.up366.mobile.book.helper.Tools.env.get());
        jSONObject.put("platform", com.up366.mobile.book.helper.Tools.platform);
        jSONObject.put("os", "ANDROID");
        jSONObject.put("systemOS", "ANDROID");
        jSONObject.put("client", com.up366.mobile.book.helper.Tools.client);
        jSONObject.put("clientId", com.up366.mobile.book.helper.Tools.clientId.get());
        jSONObject.put("gray", java.lang.Boolean.valueOf(com.up366.mobile.book.helper.Tools.gray));
        jSONObject.put("version", com.up366.mobile.BuildConfig.VERSION_NAME);
        jSONObject.put("theme", "light");
        jSONObject.put("loginState", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.isAuth() ? 1 : 0));
        jSONObject.put("whiteBoard", false);
        jSONObject.put("osVersion", android.os.Build.VERSION.RELEASE);
        jSONObject.put("mobileModel", android.os.Build.MODEL);
        jSONObject.put("appModel", com.up366.mobile.BuildConfig.APP_MODEL);
        jSONObject.put("isTablet", java.lang.Boolean.valueOf(com.up366.mobile.common.utils.PadUtils.isTablet(this.context)));
        jSONObject.put("scene", str);
        return jSONObject;
    }

    public java.lang.String getUserInfo() {
        com.up366.mobile.common.logic.user.UserInfo userInfo = com.up366.mobile.common.logic.Auth.getUserInfo();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("userUUid", userInfo.getUuid());
        jSONObject.put("uid", java.lang.Integer.valueOf(userInfo.getUid()));
        jSONObject.put("userName", userInfo.getUsername());
        jSONObject.put("realName", userInfo.getRealname());
        jSONObject.put("imgUrl", userInfo.getPhotoUrl());
        jSONObject.put("organId", java.lang.Integer.valueOf(userInfo.getOrganId()));
        jSONObject.put("schoolType", java.lang.Integer.valueOf(userInfo.getSchoolType()));
        return jSONObject.toJSONString();
    }

    public java.lang.String getUserInfoV7() {
        if (!com.up366.mobile.common.logic.Auth.isAuth()) {
            return "";
        }
        com.up366.mobile.common.logic.user.UserInfo userInfo = com.up366.mobile.common.logic.Auth.getUserInfo();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("uid", java.lang.Integer.valueOf(userInfo.getUid()));
        jSONObject.put("userName", userInfo.getUsername());
        jSONObject.put("realName", userInfo.getRealname());
        jSONObject.put("headImg", userInfo.getPhotoUrl());
        jSONObject.put("userStatus", 1);
        jSONObject.put("userType", java.lang.Integer.valueOf(userInfo.getUtype()));
        jSONObject.put("organId", java.lang.Integer.valueOf(userInfo.getOrganId()));
        jSONObject.put("schoolType", java.lang.Integer.valueOf(userInfo.getSchoolType()));
        return jSONObject.toJSONString();
    }

    public com.alibaba.fastjson.JSONObject getUserInfoV8() {
        if (!com.up366.mobile.common.logic.Auth.isAuth()) {
            return new com.alibaba.fastjson.JSONObject();
        }
        com.up366.mobile.common.logic.user.UserInfo userInfo = com.up366.mobile.common.logic.Auth.getUserInfo();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("uid", java.lang.Integer.valueOf(userInfo.getUid()));
        jSONObject.put("userName", userInfo.getUsername());
        jSONObject.put("realName", userInfo.getRealname());
        jSONObject.put("headImg", userInfo.getPhotoUrl());
        jSONObject.put("userStatus", 1);
        jSONObject.put("userType", java.lang.Integer.valueOf(userInfo.getUtype()));
        jSONObject.put("organId", java.lang.Integer.valueOf(userInfo.getOrganId()));
        jSONObject.put("schoolType", java.lang.Integer.valueOf(userInfo.getSchoolType()));
        jSONObject.put("organization", userInfo.getOrganName());
        jSONObject.put("phone", userInfo.getMobile());
        if (android.text.TextUtils.isEmpty(userInfo.getReserved1())) {
            jSONObject.put("studentNo", "");
        } else {
            jSONObject.put("studentNo", userInfo.getReserved1());
        }
        return jSONObject;
    }

    public com.alibaba.fastjson.JSONObject getUserInfoV9() {
        if (!com.up366.mobile.common.logic.Auth.isAuth()) {
            return new com.alibaba.fastjson.JSONObject();
        }
        com.up366.mobile.common.logic.user.UserInfo userInfo = com.up366.mobile.common.logic.Auth.getUserInfo();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("uid", java.lang.Integer.valueOf(userInfo.getUid()));
        jSONObject.put("userName", userInfo.getUsername());
        jSONObject.put("realName", userInfo.getRealname());
        jSONObject.put("headImg", userInfo.getPhotoUrl());
        jSONObject.put("userStatus", 1);
        jSONObject.put("userType", java.lang.Integer.valueOf(userInfo.getUtype()));
        jSONObject.put("organId", java.lang.Integer.valueOf(userInfo.getOrganId()));
        jSONObject.put("schoolType", java.lang.Integer.valueOf(userInfo.getSchoolType()));
        jSONObject.put("organization", userInfo.getOrganName());
        jSONObject.put("phone", userInfo.getMobile());
        if (android.text.TextUtils.isEmpty(userInfo.getReserved1())) {
            jSONObject.put("studentNo", "");
        } else {
            jSONObject.put("studentNo", userInfo.getReserved1());
        }
        return jSONObject;
    }

    public java.lang.String getNetWorkInfo() {
        java.lang.String netType = com.up366.common.NetworkUtilsUp.getNetType();
        netType.hashCode();
        switch (netType) {
            case "MOBILE":
                return "cell";
            case "NO":
                return com.igexin.push.a.i;
            case "WIFI":
                return "wifi";
            default:
                return "unknown";
        }
    }

    public static void upgradeClient(final android.app.Activity activity) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.AppInfoHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.AppInfoHelper.lambda$upgradeClient$2(activity);
            }
        });
    }

    static /* synthetic */ void lambda$upgradeClient$2(final android.app.Activity activity) throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "正在检查更新...");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.AppInfoHelper$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.AppInfoHelper.lambda$upgradeClient$1(activity);
            }
        });
    }

    static /* synthetic */ void lambda$upgradeClient$1(android.app.Activity activity) throws java.lang.Exception {
        com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo> netHolderFetchAllSync = com.up366.mobile.common.logic.Auth.cur().config().fetchAllSync();
        if (netHolderFetchAllSync.resp.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, netHolderFetchAllSync.resp);
            return;
        }
        com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.AppConfigLastVersion> modelMap = com.up366.mobile.common.logic.Auth.cur().config().getModelMap(com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel(), com.up366.mobile.BuildConfig.VERSION_CODE);
        if (modelMap.info != null && modelMap.info.getVersion() > 220) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
            com.up366.mobile.common.utils.UpdateModule.getInstance().checkNewVersionByUser();
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.show(activity, "当前已是最新版本");
        }
    }

    public java.lang.String getAppVersion() {
        return this.context.getString(com.up366.mobile.R.string.js_interface_skip_url_app_version_prefix) + com.up366.common.PackageUtils.getVersionName().replace(".", "_");
    }
}
