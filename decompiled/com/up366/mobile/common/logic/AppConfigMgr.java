package com.up366.mobile.common.logic;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppConfigMgr {
    private static final java.lang.String KEY_CONTENT_EXT_MK = "app-config-content-ext-mk";
    private static final java.lang.String KEY_DYNAMIC_CONFIG = "Key_Dynamic_Config";
    private static final java.util.Map<java.lang.Integer, com.alibaba.fastjson.JSONObject> dynamicConfigMap = new java.util.concurrent.ConcurrentHashMap();
    private final com.up366.greendao.DaoSession db;
    private final com.up366.mobile.common.logic.Manager manager;
    private volatile long lastFetchAllSyncTime = 0;
    private java.util.List<com.up366.common.callback.ICallbackResponse<java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.AppConfigOssBucketInfo>>> refreshAliTokenMapCache = java.util.Collections.synchronizedList(new java.util.ArrayList());

    public static class SLSToken {
        public java.lang.String accessKeyId;
        public java.lang.String accessKeySecret;
        public java.lang.String endpoint;
        public java.lang.String logStoreName;
        public java.lang.String projectName;
        public java.lang.String securityToken;
    }

    static /* synthetic */ void lambda$downloadPromotionDiagram$14(java.lang.String str, int i, int i2, java.lang.String str2, long j, long j2, int i3, java.lang.String str3) {
    }

    public boolean isEnableSDK() {
        return true;
    }

    public long getLastFetchAllSyncTime() {
        return this.lastFetchAllSyncTime;
    }

    public AppConfigMgr(com.up366.mobile.common.logic.Manager manager) {
        this.manager = manager;
        this.db = manager.db();
    }

    public com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo> fetchAllSync() throws java.lang.InterruptedException {
        this.lastFetchAllSyncTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        final com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("modelName", com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel());
        jSONObject.put("versionNo", java.lang.Integer.valueOf(com.up366.mobile.BuildConfig.VERSION_CODE));
        jSONArray.add(jSONObject);
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("modelName", com.up366.mobile.BuildConfig.EXERCISE_MODEL);
        jSONObject2.put("versionNo", java.lang.Integer.valueOf(com.up366.mobile.book.exercise.ExerciseResourceHelper.getVersionNo()));
        jSONArray.add(jSONObject2);
        com.alibaba.fastjson.JSONObject jSONObject3 = new com.alibaba.fastjson.JSONObject();
        jSONObject3.put("modelName", com.up366.mobile.BuildConfig.ASES_MODEL);
        jSONObject3.put("versionNo", java.lang.Integer.valueOf(com.up366.mobile.common.helper.AppResourceUpdateHelper.getAsesModelVersion()));
        jSONArray.add(jSONObject3);
        com.alibaba.fastjson.JSONObject jSONObject4 = new com.alibaba.fastjson.JSONObject();
        jSONObject4.put("modelName", com.up366.mobile.BuildConfig.DICT_MODEL);
        jSONObject4.put("versionNo", java.lang.Integer.valueOf(com.up366.mobile.book.dict.DictResourceHelper.getVersionNo()));
        jSONArray.add(jSONObject4);
        com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo> netHolderPostSync = com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.getStuConfigs).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticLambda5
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                map.put("modelJson", jSONArray.toString());
            }
        }).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticLambda6
            @Override // com.up366.common.http.RequestParams.IHandleResponse
            public final java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return this.f$0.lambda$fetchAllSync$1(response, str);
            }
        }));
        if (netHolderPostSync.resp.isError()) {
            com.up366.common.log.Logger.error("TAG - AppConfigMgr - fetchAllSync - error : " + netHolderPostSync.resp.toString());
            com.up366.mobile.common.utils.TimeSyncMgr.syncNtpTime();
        }
        return netHolderPostSync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.up366.mobile.common.logic.model.UrlAppStuConfigInfo lambda$fetchAllSync$1(com.up366.common.http.Response response, java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - AppConfigMgr - fetchAllSync - UrlAppStuConfigInfo : " + str);
        com.up366.mobile.common.logic.model.UrlAppStuConfigInfo urlAppStuConfigInfo = (com.up366.mobile.common.logic.model.UrlAppStuConfigInfo) com.up366.mobile.common.utils.ResponseUtil.parseObject(str, com.up366.mobile.common.logic.model.UrlAppStuConfigInfo.class);
        com.up366.mobile.common.utils.TimeSyncMgr.updateFromServerTime(urlAppStuConfigInfo.getCurrentTime());
        this.lastFetchAllSyncTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        this.manager.cache().put("app-config-modelMap", urlAppStuConfigInfo.getModelMap(), com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3);
        this.manager.cache().put("app-config-funcCloseList", urlAppStuConfigInfo.getFuncClose(), com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3);
        int iHashCode = urlAppStuConfigInfo.getFuncClose().hashCode();
        java.lang.Integer num = (java.lang.Integer) this.manager.cache().loadSync("app-config-funcCloseList-hash", new com.alibaba.fastjson.TypeReference<java.lang.Integer>() { // from class: com.up366.mobile.common.logic.AppConfigMgr.1
        });
        this.manager.cache().put("app-config-funcCloseList-hash", java.lang.Integer.valueOf(iHashCode), com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3);
        this.manager.cache().put("app-config-bannerList", urlAppStuConfigInfo.getBanner(), com.up366.mobile.common.logic.model.AppCacheInfo.TIME_DAY_10);
        this.manager.cache().put("app-config-logToken", urlAppStuConfigInfo.getUp366token(), 3600000L);
        this.manager.cache().put("app-config-aliTokenMap", urlAppStuConfigInfo.getAliYunTokenMap(), com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3);
        this.manager.cache().put("app-config-miniCloudList", urlAppStuConfigInfo.getMinicloud(), com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3);
        this.manager.cache().put("app-config-organInfo", urlAppStuConfigInfo.getOrganInfo(), com.up366.mobile.common.logic.model.AppCacheInfo.TIME_DAY_10);
        this.manager.cache().putMemorySync("app-config-organInfo-bindMobileType", java.lang.Integer.valueOf(urlAppStuConfigInfo.getOrganInfo().getBindMobileType()), 60000L);
        this.manager.cache().putMemorySync("app-config-organInfo-changePwdType", java.lang.Integer.valueOf(urlAppStuConfigInfo.getOrganInfo().getChangePwdType()), 60000L);
        com.up366.mobile.common.helper.UserFunAccreditHelper.INSTANCE.save(urlAppStuConfigInfo.getFuncList());
        if (num == null || iHashCode != num.intValue()) {
            com.up366.mobile.common.utils.AppFuncController.refreshData();
        }
        return urlAppStuConfigInfo;
    }

    public boolean isMoLiYingUser() {
        com.up366.mobile.common.logic.model.UrlAppStuConfigInfo.OrganInfo organInfo = (com.up366.mobile.common.logic.model.UrlAppStuConfigInfo.OrganInfo) this.manager.cache().loadSync("app-config-organInfo", new com.alibaba.fastjson.TypeReference<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo.OrganInfo>() { // from class: com.up366.mobile.common.logic.AppConfigMgr.2
        });
        if (organInfo != null) {
            com.up366.common.log.Logger.info("TAG - AppConfigMgr - isMoLiYingUser - " + organInfo.getAreaId());
            return organInfo.getAreaId() == 9;
        }
        if (com.up366.mobile.common.logic.Auth.getUserInfo() == null) {
            return false;
        }
        com.up366.common.log.Logger.info("TAG - AppConfigMgr - isMoLiYingUser - false");
        return com.up366.mobile.common.logic.Auth.getUserInfo().getAreaId() == 9;
    }

    public boolean isNeedBindPhone() {
        com.up366.common.log.Logger.info("isNeedBindPhone : " + getBindPhoneStatus() + " " + com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.common.logic.Auth.getUserInfo().getMobile()) + " " + com.up366.mobile.common.logic.Auth.isTourist() + " " + com.up366.mobile.common.utils.PlatformUtils.isClosePad() + " " + com.up366.mobile.common.logic.Auth.getUserInfo().getMobile() + " " + com.up366.common.NetworkUtilsUp.isConnected());
        return (!com.up366.common.NetworkUtilsUp.isConnected() || com.up366.mobile.common.utils.PlatformUtils.isClosePad() || com.up366.mobile.common.logic.Auth.isTourist() || com.up366.mobile.main.PhonePasswordUpdateHelper.INSTANCE.hasShowUpdateMobile(com.up366.mobile.common.logic.Auth.UID()) || com.up366.mobile.main.PhonePasswordUpdateHelper.INSTANCE.hasShowUpdatePassword(com.up366.mobile.common.logic.Auth.UID()) || getBindPhoneStatus() == 1 || !com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.common.logic.Auth.getUserInfo().getMobile())) ? false : true;
    }

    public boolean isNeedUpdatePassword() {
        com.up366.common.log.Logger.info("isNeedUpdatePassword : " + getChangePwdStatus() + " " + com.up366.mobile.common.logic.Auth.getUserInfo().isWeakPassword() + "  " + com.up366.mobile.common.logic.Auth.isTourist() + " " + com.up366.mobile.common.utils.PlatformUtils.isClosePad() + " " + com.up366.common.NetworkUtilsUp.isConnected());
        return (!com.up366.common.NetworkUtilsUp.isConnected() || com.up366.mobile.common.utils.PlatformUtils.isClosePad() || com.up366.mobile.common.logic.Auth.isTourist() || com.up366.mobile.common.logic.Auth.getUserInfo().isBackUpPassword() || com.up366.mobile.main.PhonePasswordUpdateHelper.INSTANCE.hasShowUpdatePassword(com.up366.mobile.common.logic.Auth.UID()) || getChangePwdStatus() == 1 || !com.up366.mobile.common.logic.Auth.getUserInfo().isWeakPassword()) ? false : true;
    }

    public boolean isMustBindPhone() {
        return getBindPhoneStatus() == 2 && com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.common.logic.Auth.getUserInfo().getMobile());
    }

    private int getBindPhoneStatus() {
        java.lang.Integer num = (java.lang.Integer) this.manager.cache().loadMemorySync("app-config-organInfo-bindMobileType");
        if (num == null) {
            return 1;
        }
        com.up366.common.log.Logger.info("TAG - AppConfigMgr - getBindPhoneStatus - " + num);
        return num.intValue();
    }

    public boolean isMustChangePwd() {
        return getChangePwdStatus() == 2;
    }

    private int getChangePwdStatus() {
        java.lang.Integer num = (java.lang.Integer) this.manager.cache().loadMemorySync("app-config-organInfo-changePwdType");
        if (num == null) {
            return 1;
        }
        com.up366.common.log.Logger.info("TAG - AppConfigMgr - getChangePwdStatus - " + num);
        return num.intValue();
    }

    public com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.AppConfigLastVersion> fetchModelMapSync(java.lang.String str, int i) {
        com.up366.mobile.common.logic.model.AppConfigLastVersion appConfigLastVersion;
        java.util.Map map = (java.util.Map) this.manager.cache().loadSync("app-config-modelMap", new com.alibaba.fastjson.TypeReference<java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.AppConfigLastVersion>>() { // from class: com.up366.mobile.common.logic.AppConfigMgr.3
        });
        com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.AppConfigLastVersion> netHolder = new com.up366.common.http.NetHolder<>();
        netHolder.initWith(new com.up366.common.http.Response(-3, "", "no update : " + str, 0, null), null);
        if (map != null && (appConfigLastVersion = (com.up366.mobile.common.logic.model.AppConfigLastVersion) map.get(str)) != null && !com.up366.common.StringUtils.isEmptyOrNull(appConfigLastVersion.getUrl()) && !com.up366.common.StringUtils.isEmptyOrNull(appConfigLastVersion.getApkMd5())) {
            netHolder.initWith(new com.up366.common.http.Response(0, "", "", 0, null), appConfigLastVersion);
        }
        return netHolder;
    }

    public void fetchModelMap(final java.lang.String str, final int i, final com.up366.common.callback.ICallbackResponse<com.up366.mobile.common.logic.model.AppConfigLastVersion> iCallbackResponse) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticLambda10
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$fetchModelMap$3(str, i, iCallbackResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchModelMap$3(java.lang.String str, int i, final com.up366.common.callback.ICallbackResponse iCallbackResponse) throws java.lang.Exception {
        final com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.AppConfigLastVersion> modelMap = getModelMap(str, i);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticLambda15
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.common.callback.ICallbackResponse iCallbackResponse2 = iCallbackResponse;
                com.up366.common.http.NetHolder netHolder = modelMap;
                iCallbackResponse2.onResult(netHolder.resp, (com.up366.mobile.common.logic.model.AppConfigLastVersion) netHolder.info);
            }
        });
    }

    public com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.AppConfigLastVersion> getModelMap(java.lang.String str, int i) {
        java.util.Map map = (java.util.Map) this.manager.cache().loadSync("app-config-modelMap", new com.alibaba.fastjson.TypeReference<java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.AppConfigLastVersion>>() { // from class: com.up366.mobile.common.logic.AppConfigMgr.4
        });
        com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.AppConfigLastVersion> netHolder = new com.up366.common.http.NetHolder<>();
        if (map == null) {
            netHolder.initWith(new com.up366.common.http.Response(-3, "", "no update : " + str, 0, null), null);
        } else {
            com.up366.mobile.common.logic.model.AppConfigLastVersion appConfigLastVersion = (com.up366.mobile.common.logic.model.AppConfigLastVersion) map.get(str);
            if (appConfigLastVersion == null || com.up366.common.StringUtils.isEmptyOrNull(appConfigLastVersion.getUrl()) || com.up366.common.StringUtils.isEmptyOrNull(appConfigLastVersion.getApkMd5())) {
                netHolder.initWith(new com.up366.common.http.Response(-3, "", "no update : " + str, 0, null), null);
            } else {
                netHolder.initWith(new com.up366.common.http.Response(0, "", "", 0, null), appConfigLastVersion);
            }
        }
        return netHolder;
    }

    public java.util.List<java.lang.String> loadFuncCloseListSync() {
        java.util.List<java.lang.String> list = (java.util.List) this.manager.cache().loadSync("app-config-funcCloseList", new com.alibaba.fastjson.TypeReference<java.util.List<java.lang.String>>() { // from class: com.up366.mobile.common.logic.AppConfigMgr.5
        });
        return list == null ? java.util.Collections.emptyList() : list;
    }

    public void loadBannerList(final com.up366.common.callback.ICallbackCodeInfoObj<java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner>> iCallbackCodeInfoObj) {
        this.manager.cache().load("app-config-bannerList", new com.alibaba.fastjson.TypeReference<java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner>>() { // from class: com.up366.mobile.common.logic.AppConfigMgr.6
        }, new com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache() { // from class: com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache
            public final void onLoad(java.lang.Object obj) {
                com.up366.mobile.common.logic.AppConfigMgr.lambda$loadBannerList$5(iCallbackCodeInfoObj, (java.util.List) obj);
            }
        });
    }

    static /* synthetic */ void lambda$loadBannerList$5(com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, java.util.List list) {
        if (list != null) {
            java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticLambda3
                @Override // java.util.Comparator
                public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                    return java.lang.Integer.compare(((com.up366.mobile.common.logic.model.AppConfigBanner) obj).getDisplayOrder(), ((com.up366.mobile.common.logic.model.AppConfigBanner) obj2).getDisplayOrder());
                }
            });
            iCallbackCodeInfoObj.onResult(0, "", list);
        } else {
            iCallbackCodeInfoObj.onResult(-1, "", null);
        }
    }

    public void fetchBannerList(final com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner>> iCallbackResponse) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticLambda12
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$fetchBannerList$7(iCallbackResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchBannerList$7(final com.up366.common.callback.ICallbackResponse iCallbackResponse) throws java.lang.Exception {
        final com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner>> netHolderFetchBannerListSync = fetchBannerListSync();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.common.callback.ICallbackResponse iCallbackResponse2 = iCallbackResponse;
                com.up366.common.http.NetHolder netHolder = netHolderFetchBannerListSync;
                iCallbackResponse2.onResult(netHolder.resp, (java.util.List) netHolder.info);
            }
        });
    }

    public com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner>> fetchBannerListSync() throws java.lang.InterruptedException {
        com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner>> netHolder = new com.up366.common.http.NetHolder<>();
        java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner> list = (java.util.List) this.manager.cache().loadSync("app-config-bannerList", new com.alibaba.fastjson.TypeReference<java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner>>() { // from class: com.up366.mobile.common.logic.AppConfigMgr.7
        });
        if (list != null) {
            java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticLambda17
                @Override // java.util.Comparator
                public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                    return java.lang.Integer.compare(((com.up366.mobile.common.logic.model.AppConfigBanner) obj).getDisplayOrder(), ((com.up366.mobile.common.logic.model.AppConfigBanner) obj2).getDisplayOrder());
                }
            });
            netHolder.initWith(new com.up366.common.http.Response(0, "", "", 0, null), list);
        } else {
            com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner>> netHolderFetchRollingPictureSync = this.manager.getFlowMgr().fetchRollingPictureSync();
            if (!netHolderFetchRollingPictureSync.resp.isError()) {
                this.manager.cache().put("app-config-bannerList", netHolderFetchRollingPictureSync.info, com.up366.mobile.common.logic.model.AppCacheInfo.TIME_DAY_10);
                java.util.Collections.sort(netHolderFetchRollingPictureSync.info, new java.util.Comparator() { // from class: com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticLambda18
                    @Override // java.util.Comparator
                    public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                        return java.lang.Integer.compare(((com.up366.mobile.common.logic.model.AppConfigBanner) obj).getDisplayOrder(), ((com.up366.mobile.common.logic.model.AppConfigBanner) obj2).getDisplayOrder());
                    }
                });
            }
            netHolder.initWith(netHolderFetchRollingPictureSync.resp, netHolderFetchRollingPictureSync.info);
        }
        if (!netHolder.resp.isError()) {
            java.util.Iterator<com.up366.mobile.common.logic.model.AppConfigBanner> it = netHolder.info.iterator();
            while (it.hasNext()) {
                if (it.next().getType() != 0) {
                    it.remove();
                }
            }
        }
        return netHolder;
    }

    public void fetchLogToken(final com.up366.common.callback.ICallbackResponse<java.lang.String> iCallbackResponse) {
        this.manager.cache().loadString("app-config-logToken", new com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache() { // from class: com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticLambda11
            @Override // com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache
            public final void onLoad(java.lang.Object obj) {
                this.f$0.lambda$fetchLogToken$10(iCallbackResponse, (java.lang.String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchLogToken$10(final com.up366.common.callback.ICallbackResponse iCallbackResponse, java.lang.String str) {
        if (str != null) {
            iCallbackResponse.onResult(new com.up366.common.http.Response(0, "", "", 0, null), str);
        } else {
            iCallbackResponse.onResult(new com.up366.common.http.Response(-3, "", "no cache", 0, null), str);
            com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.getUp366Token) { // from class: com.up366.mobile.common.logic.AppConfigMgr.8
                @Override // com.up366.common.http.RequestParams
                public java.lang.String handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                    java.lang.String string = com.up366.mobile.common.utils.ResponseUtil.parseObject(str2).getString("up366token");
                    com.up366.mobile.common.logic.AppConfigMgr.this.manager.cache().put("app-config-logToken", string, 3600000L);
                    return string;
                }

                @Override // com.up366.common.http.RequestParams
                public void onResponse(com.up366.common.http.Response response, java.lang.String str2) {
                    super.onResponse(response, str2);
                    iCallbackResponse.onResult(response, str2);
                }
            });
        }
    }

    public boolean hasAliTokenMap() {
        return ((java.util.Map) this.manager.cache().loadSync("app-config-aliTokenMap", new com.alibaba.fastjson.TypeReference<java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.AppConfigOssBucketInfo>>() { // from class: com.up366.mobile.common.logic.AppConfigMgr.9
        })) != null;
    }

    public void fetchAliTokenMap(com.up366.common.callback.ICallbackResponse<java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.AppConfigOssBucketInfo>> iCallbackResponse) {
        java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.AppConfigOssBucketInfo> map = (java.util.Map) this.manager.cache().loadSync("app-config-aliTokenMap", new com.alibaba.fastjson.TypeReference<java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.AppConfigOssBucketInfo>>() { // from class: com.up366.mobile.common.logic.AppConfigMgr.10
        });
        if (map != null) {
            iCallbackResponse.onResult(new com.up366.common.http.Response(0, "", "", 0, null), map);
        } else {
            refreshAliTokenMap(iCallbackResponse);
        }
    }

    public void refreshAliTokenMap(com.up366.common.callback.ICallbackResponse<java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.AppConfigOssBucketInfo>> iCallbackResponse) {
        if (this.refreshAliTokenMapCache.size() > 0 && this.refreshAliTokenMapCache.size() < 20) {
            this.refreshAliTokenMapCache.add(iCallbackResponse);
            com.up366.common.log.Logger.info("TAG - AppConfigMgr - refreshAliTokenMap - cached callback size" + this.refreshAliTokenMapCache.size());
            if (this.refreshAliTokenMapCache.size() > 19) {
                com.up366.mobile.common.onlinelog.OpLog.report("error-cached-ali-token-size-limit", java.lang.String.valueOf(this.refreshAliTokenMapCache.size()));
                return;
            }
            return;
        }
        this.refreshAliTokenMapCache.add(iCallbackResponse);
        com.up366.common.http.HttpUtilsUp.post(new com.up366.mobile.common.logic.AppConfigMgr.AnonymousClass11(com.up366.mobile.common.http.HttpMgrUtils.getAliYunTokenV2));
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.logic.AppConfigMgr$11, reason: invalid class name */
    class AnonymousClass11 extends com.up366.common.http.RequestParams<java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.AppConfigOssBucketInfo>> {
        AnonymousClass11(java.lang.String str) {
            super(str);
        }

        @Override // com.up366.common.http.RequestParams
        public java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.AppConfigOssBucketInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
            java.util.List<com.up366.mobile.common.logic.model.AppConfigAliyunToken> array = com.alibaba.fastjson.JSON.parseArray(str, com.up366.mobile.common.logic.model.AppConfigAliyunToken.class);
            java.util.HashMap map = new java.util.HashMap();
            if (array != null) {
                for (com.up366.mobile.common.logic.model.AppConfigAliyunToken appConfigAliyunToken : array) {
                    map.put(appConfigAliyunToken.getBiz(), appConfigAliyunToken.getOssBucketInfo());
                }
            }
            com.up366.mobile.common.logic.AppConfigMgr.this.manager.cache().put("app-config-aliTokenMap", map, com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3);
            return map;
        }

        @Override // com.up366.common.http.RequestParams
        public void onResponse(final com.up366.common.http.Response response, final java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.AppConfigOssBucketInfo> map) {
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.AppConfigMgr$11$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onResponse$0(response, map);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(com.up366.common.http.Response response, java.util.Map map) throws java.lang.Exception {
            java.util.List list = com.up366.mobile.common.logic.AppConfigMgr.this.refreshAliTokenMapCache;
            com.up366.mobile.common.logic.AppConfigMgr.this.refreshAliTokenMapCache = java.util.Collections.synchronizedList(new java.util.ArrayList());
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                ((com.up366.common.callback.ICallbackResponse) it.next()).onResult(response, map);
            }
        }
    }

    public com.up366.mobile.common.logic.model.AppConfigOssBucketInfo getDefaultBucketInfo() {
        com.up366.mobile.common.logic.model.AppConfigOssBucketInfo appConfigOssBucketInfo = new com.up366.mobile.common.logic.model.AppConfigOssBucketInfo();
        appConfigOssBucketInfo.setBucketname(com.up366.mobile.BuildConfig.OSS_DEFAULT_BUCKET);
        appConfigOssBucketInfo.setDefaulthostid(com.up366.mobile.BuildConfig.OSS_DEFAULT_HOST);
        return appConfigOssBucketInfo;
    }

    public void fetchMiniCloudList(final com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.common.logic.model.AppConfigMiniCloud>> iCallbackResponse) {
        this.manager.cache().load("app-config-miniCloudList", new com.alibaba.fastjson.TypeReference<java.util.List<com.up366.mobile.common.logic.model.AppConfigMiniCloud>>() { // from class: com.up366.mobile.common.logic.AppConfigMgr.12
        }, new com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache() { // from class: com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticLambda13
            @Override // com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache
            public final void onLoad(java.lang.Object obj) {
                com.up366.mobile.common.logic.AppConfigMgr.lambda$fetchMiniCloudList$11(iCallbackResponse, (java.util.List) obj);
            }
        });
    }

    static /* synthetic */ void lambda$fetchMiniCloudList$11(com.up366.common.callback.ICallbackResponse iCallbackResponse, java.util.List list) {
        if (list != null) {
            iCallbackResponse.onResult(new com.up366.common.http.Response(0, "", "", 0, null), list);
        } else {
            iCallbackResponse.onResult(new com.up366.common.http.Response(-3, "", "no cache", 0, null), list);
        }
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.logic.AppConfigMgr$13, reason: invalid class name */
    class AnonymousClass13 extends com.up366.common.http.RequestParams<com.up366.mobile.common.logic.model.AppConfigLastVersion> {
        final /* synthetic */ com.up366.common.callback.ICallbackResponse val$callback;
        final /* synthetic */ java.lang.String val$model;
        final /* synthetic */ int val$version;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass13(java.lang.String str, java.lang.String str2, int i, com.up366.common.callback.ICallbackResponse iCallbackResponse) {
            super(str);
            this.val$model = str2;
            this.val$version = i;
            this.val$callback = iCallbackResponse;
        }

        @Override // com.up366.common.http.RequestParams
        public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
            super.initParams(map);
            com.up366.mobile.common.logic.user.UserInfo userInfo = com.up366.mobile.common.logic.Auth.getUserInfo();
            if (userInfo.getUsername() != null) {
                map.put("username", userInfo.getUsername());
            }
            map.put("modelName", this.val$model);
            map.put("versionNo", java.lang.Integer.valueOf(this.val$version));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.up366.common.http.RequestParams
        public com.up366.mobile.common.logic.model.AppConfigLastVersion handleResponse(com.up366.common.http.Response response, java.lang.String str) {
            com.up366.common.log.Logger.info("TAG - AppConfigMgr - fetchXotEngine - " + str);
            final com.up366.mobile.common.logic.model.AppConfigLastVersion appConfigLastVersion = (com.up366.mobile.common.logic.model.AppConfigLastVersion) com.up366.mobile.common.utils.ResponseUtil.parseObject(str, com.up366.mobile.common.logic.model.AppConfigLastVersion.class);
            com.up366.mobile.common.logic.AppCacheMgr appCacheMgrCache = com.up366.mobile.common.logic.AppConfigMgr.this.manager.cache();
            com.alibaba.fastjson.TypeReference<java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.AppConfigLastVersion>> typeReference = new com.alibaba.fastjson.TypeReference<java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.AppConfigLastVersion>>() { // from class: com.up366.mobile.common.logic.AppConfigMgr.13.1
            };
            final java.lang.String str2 = this.val$model;
            appCacheMgrCache.load("app-config-modelMap", typeReference, new com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache() { // from class: com.up366.mobile.common.logic.AppConfigMgr$13$$ExternalSyntheticLambda0
                @Override // com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache
                public final void onLoad(java.lang.Object obj) {
                    this.f$0.lambda$handleResponse$0(str2, appConfigLastVersion, (java.util.Map) obj);
                }
            });
            return appConfigLastVersion;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleResponse$0(java.lang.String str, com.up366.mobile.common.logic.model.AppConfigLastVersion appConfigLastVersion, java.util.Map map) {
            if (map == null) {
                map = new java.util.HashMap();
            }
            map.put(str, appConfigLastVersion);
            com.up366.mobile.common.logic.AppConfigMgr.this.manager.cache().put("app-config-modelMap", map, com.up366.mobile.common.logic.model.AppCacheInfo.TIME_DAY_10);
        }

        @Override // com.up366.common.http.RequestParams
        public void onResponse(com.up366.common.http.Response response, com.up366.mobile.common.logic.model.AppConfigLastVersion appConfigLastVersion) {
            super.onResponse(response, appConfigLastVersion);
            this.val$callback.onResult(response, appConfigLastVersion);
        }
    }

    public void fetchModelVersion(java.lang.String str, int i, com.up366.common.callback.ICallbackResponse<com.up366.mobile.common.logic.model.AppConfigLastVersion> iCallbackResponse) {
        com.up366.common.log.Logger.info("TAG - AppConfigMgr - fetchModelVersion - model = [" + str + "], version = [" + i + "]");
        com.up366.common.http.HttpUtilsUp.post(new com.up366.mobile.common.logic.AppConfigMgr.AnonymousClass13(com.up366.mobile.common.http.HttpMgrUtils.checkVersion, str, i, iCallbackResponse));
    }

    public void fetchFunAccreditList(final com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.common.logic.model.UserFunAccredit>> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.common.logic.model.UserFunAccredit>>(com.up366.mobile.common.http.HttpMgrUtils.FUN_ACCREDIT_LIST) { // from class: com.up366.mobile.common.logic.AppConfigMgr.14
            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.common.logic.model.UserFunAccredit> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                java.util.List<com.up366.mobile.common.logic.model.UserFunAccredit> array = com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.common.logic.model.UserFunAccredit.class);
                com.up366.mobile.common.logic.Auth.cur().cache().put("user-fun-accredit", array);
                return array;
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.common.logic.model.UserFunAccredit> list) {
                com.up366.common.callback.ICallbackResponse iCallbackResponse2 = iCallbackResponse;
                if (iCallbackResponse2 != null) {
                    iCallbackResponse2.onResult(response, list);
                }
            }
        });
    }

    public com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.common.logic.model.UserFunAccredit>> fetchFunAccreditList() throws java.lang.InterruptedException {
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.common.logic.model.UserFunAccredit>>(com.up366.mobile.common.http.HttpMgrUtils.FUN_ACCREDIT_LIST) { // from class: com.up366.mobile.common.logic.AppConfigMgr.15
            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.common.logic.model.UserFunAccredit> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                java.util.List<com.up366.mobile.common.logic.model.UserFunAccredit> array = com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.common.logic.model.UserFunAccredit.class);
                com.up366.mobile.common.logic.Auth.cur().cache().put("user-fun-accredit", array);
                return array;
            }
        });
    }

    public java.lang.String resolveContentExt(java.lang.String str, boolean z) throws java.lang.Exception {
        if (!z) {
            java.lang.String str2 = (java.lang.String) this.manager.cache().loadMemorySync(KEY_CONTENT_EXT_MK);
            if (!android.text.TextUtils.isEmpty(str2) && (android.text.TextUtils.isEmpty(str) || com.up366.common.utils.EncryptUtil.matchMkEdk(str, str2))) {
                return str2;
            }
        }
        com.up366.common.http.NetHolder<java.lang.String> netHolderFetchContentExtMk = fetchContentExtMk();
        if (netHolderFetchContentExtMk.resp.isError()) {
            throw new java.lang.IllegalStateException("fetch content config failed: " + netHolderFetchContentExtMk.resp);
        }
        java.lang.String str3 = netHolderFetchContentExtMk.info;
        if (android.text.TextUtils.isEmpty(str3)) {
            throw new java.lang.IllegalStateException("content config mk empty");
        }
        java.lang.String strDecryptMk = com.up366.common.utils.EncryptUtil.decryptMk(str3);
        if (!android.text.TextUtils.isEmpty(strDecryptMk)) {
            this.manager.cache().putMemorySync(KEY_CONTENT_EXT_MK, strDecryptMk, 86400000L);
            return strDecryptMk;
        }
        throw new java.lang.IllegalStateException("content config mk decode empty");
    }

    private static com.up366.common.http.NetHolder<java.lang.String> fetchContentExtMk() throws java.lang.InterruptedException {
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.getContentConfig) { // from class: com.up366.mobile.common.logic.AppConfigMgr.16
            @Override // com.up366.common.http.RequestParams
            public java.lang.String handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return com.alibaba.fastjson2.JSONObject.parseObject(str).getString("contentFile");
            }
        });
    }

    public static void fetchDynamicConfig() throws java.lang.InterruptedException {
        com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.getCommonConfigs).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticLambda16
            @Override // com.up366.common.http.RequestParams.IHandleResponse
            public final java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return com.up366.mobile.common.logic.AppConfigMgr.lambda$fetchDynamicConfig$12(response, str);
            }
        }));
        com.up366.mobile.common.logic.Auth.cur().config().downloadPromotionDiagram();
    }

    static /* synthetic */ java.lang.Object lambda$fetchDynamicConfig$12(com.up366.common.http.Response response, java.lang.String str) {
        com.up366.mobile.common.utils.PreferenceUtils.putTextSync(KEY_DYNAMIC_CONFIG, str);
        dynamicConfigMap.clear();
        return str;
    }

    public static void injectTestConfig(java.lang.String str) {
        com.up366.mobile.common.utils.PreferenceUtils.putTextSync(KEY_DYNAMIC_CONFIG, str);
        dynamicConfigMap.clear();
    }

    public static com.alibaba.fastjson.JSONObject getDynamicConfig() {
        com.up366.mobile.common.logic.user.UserInfo userInfo = com.up366.mobile.common.logic.Auth.getUserInfo();
        int organId = userInfo.getOrganId();
        int schoolType = userInfo.getSchoolType();
        int iUID = com.up366.mobile.common.logic.Auth.UID();
        int cityId = userInfo.getCityId();
        int countryId = userInfo.getCountryId();
        int provinceId = userInfo.getProvinceId();
        java.lang.String appModel = com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel();
        com.alibaba.fastjson.JSONObject jSONObject = dynamicConfigMap.get(java.lang.Integer.valueOf(iUID));
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            jSONObject = com.alibaba.fastjson.JSON.parseObject(com.up366.mobile.common.utils.PreferenceUtils.getText(KEY_DYNAMIC_CONFIG, "{}"));
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - AppConfigMgr - getDynamicConfig - " + e.getMessage(), e);
        }
        if (jSONObject == null) {
            jSONObject = new com.alibaba.fastjson.JSONObject();
        }
        com.alibaba.fastjson.JSONObject jSONObject2 = jSONObject;
        applyFilter(jSONObject2, "promotion", iUID, organId, cityId, countryId, provinceId, "android", schoolType, appModel, com.up366.mobile.BuildConfig.VERSION_NAME);
        applyFilter(jSONObject2, "sls", iUID, organId, cityId, countryId, provinceId, "android", schoolType, appModel, com.up366.mobile.BuildConfig.VERSION_NAME);
        applyFilter(jSONObject2, "bookGray", iUID, organId, cityId, countryId, provinceId, "android", schoolType, appModel, com.up366.mobile.BuildConfig.VERSION_NAME);
        applyFilter(jSONObject2, "bookOpenType", iUID, organId, cityId, countryId, provinceId, "android", schoolType, appModel, com.up366.mobile.BuildConfig.VERSION_NAME);
        applyFilter(jSONObject2, "enable-paper-label-identify", iUID, organId, cityId, countryId, provinceId, "android", schoolType, appModel, com.up366.mobile.BuildConfig.VERSION_NAME);
        applyFilter(jSONObject2, "h5-tasklist", iUID, organId, cityId, countryId, provinceId, "android", schoolType, appModel, com.up366.mobile.BuildConfig.VERSION_NAME);
        applyFilter(jSONObject2, "third-party-login", iUID, organId, cityId, countryId, provinceId, "android", schoolType, appModel, com.up366.mobile.BuildConfig.VERSION_NAME);
        applyFilter(jSONObject2, "within-course-books", iUID, organId, cityId, countryId, provinceId, "android", schoolType, appModel, com.up366.mobile.BuildConfig.VERSION_NAME);
        applyFilter(jSONObject2, "use-new-mux", iUID, organId, cityId, countryId, provinceId, "android", schoolType, appModel, com.up366.mobile.BuildConfig.VERSION_NAME);
        applyFilter(jSONObject2, "new-record", iUID, organId, cityId, countryId, provinceId, "android", schoolType, appModel, com.up366.mobile.BuildConfig.VERSION_NAME);
        applyFilter(jSONObject2, "use-new-mux", iUID, organId, cityId, countryId, provinceId, "android", schoolType, appModel, com.up366.mobile.BuildConfig.VERSION_NAME);
        applyFilter(jSONObject2, "webview-crash-switch", iUID, organId, cityId, countryId, provinceId, "android", schoolType, appModel, com.up366.mobile.BuildConfig.VERSION_NAME);
        applyFilter(jSONObject2, "use-bluetooth-connect", iUID, organId, cityId, countryId, provinceId, "android", schoolType, appModel, com.up366.mobile.BuildConfig.VERSION_NAME);
        dynamicConfigMap.put(java.lang.Integer.valueOf(iUID), jSONObject2);
        com.up366.common.log.Logger.info("TAG - AppConfigMgr - getDynamicConfig - init : uid : " + iUID + " " + jSONObject2.toJSONString());
        return jSONObject2;
    }

    public static void testApplyFilter(com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str, int i, int i2, int i3, int i4, int i5, java.lang.String str2, int i6, java.lang.String str3, java.lang.String str4) {
        applyFilter(jSONObject, str, i, i2, i3, i4, i5, str2, i6, str3, str4);
    }

    private static void applyFilter(com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str, int i, int i2, int i3, int i4, int i5, java.lang.String str2, int i6, java.lang.String str3, java.lang.String str4) {
        com.alibaba.fastjson.JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject.put(str, new com.alibaba.fastjson.JSONObject());
            return;
        }
        com.alibaba.fastjson.JSONObject jSONObject3 = jSONObject2.getJSONObject("default");
        if (jSONObject3 == null) {
            jSONObject3 = new com.alibaba.fastjson.JSONObject();
        }
        com.alibaba.fastjson.JSONArray jSONArray = jSONObject2.getJSONArray("special");
        if (jSONArray == null) {
            jSONArray = new com.alibaba.fastjson.JSONArray();
        }
        for (int i7 = 0; i7 < jSONArray.size(); i7++) {
            com.alibaba.fastjson.JSONObject jSONObject4 = jSONArray.getJSONObject(i7);
            com.alibaba.fastjson.JSONArray jSONArray2 = jSONObject4.getJSONArray("areaIds");
            com.alibaba.fastjson.JSONArray jSONArray3 = jSONObject4.getJSONArray("organIds");
            com.alibaba.fastjson.JSONArray jSONArray4 = jSONObject4.getJSONArray("uids");
            java.lang.Integer integer = jSONObject4.getInteger("schoolType");
            com.alibaba.fastjson.JSONArray jSONArray5 = jSONObject4.getJSONArray("clientType");
            java.lang.Integer integer2 = jSONObject4.getInteger("uidPercent");
            java.lang.String string = jSONObject4.getString("version");
            com.alibaba.fastjson.JSONObject jSONObject5 = jSONObject4.getJSONObject("config");
            if (jSONObject5 != null && ((jSONArray2 == null || jSONArray2.contains(java.lang.Integer.valueOf(i4)) || jSONArray2.contains(java.lang.Integer.valueOf(i5)) || jSONArray2.contains(java.lang.Integer.valueOf(i3))) && ((jSONArray3 == null || jSONArray3.contains(java.lang.Integer.valueOf(i2))) && (jSONArray4 == null || jSONArray4.contains(java.lang.Integer.valueOf(i)))))) {
                if (jSONArray5 != null && !jSONArray5.contains(str2)) {
                    if (jSONArray5.contains(str3)) {
                    }
                }
                if (integer == null || integer.intValue() == i6) {
                    if (integer2 == null || (i > 0 && i % 100 < integer2.intValue())) {
                        if (string == null || matchVersionName(str4, string)) {
                            jSONObject3.putAll(jSONObject5);
                        }
                    }
                }
            }
        }
        jSONObject.put(str, jSONObject3);
    }

    public static boolean matchVersionName(java.lang.String str, java.lang.String str2) {
        try {
            if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
                java.lang.String[] strArrSplit = str2.split("~");
                java.lang.String str3 = (strArrSplit.length <= 0 || strArrSplit[0].length() <= 0) ? "0.0.0" : strArrSplit[0];
                java.lang.String str4 = (strArrSplit.length <= 1 || strArrSplit[1].length() <= 0) ? "2147483647.2147483647.2147483647" : strArrSplit[1];
                java.lang.String[] strArrSplit2 = str.split("\\.");
                java.lang.String[] strArrSplit3 = str3.split("\\.");
                java.lang.String[] strArrSplit4 = str4.split("\\.");
                androidx.arch.core.util.Function function = new androidx.arch.core.util.Function() { // from class: com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticLambda14
                    public final java.lang.Object apply(java.lang.Object obj) {
                        return com.up366.mobile.common.logic.AppConfigMgr.lambda$matchVersionName$13((java.lang.String) obj);
                    }
                };
                int i = 0;
                boolean z = false;
                boolean z2 = false;
                while (i < 3) {
                    int iIntValue = strArrSplit2.length > i ? ((java.lang.Integer) function.apply(strArrSplit2[i])).intValue() : 0;
                    int iIntValue2 = strArrSplit3.length > i ? ((java.lang.Integer) function.apply(strArrSplit3[i])).intValue() : 0;
                    int iIntValue3 = strArrSplit4.length > i ? ((java.lang.Integer) function.apply(strArrSplit4[i])).intValue() : Integer.MAX_VALUE;
                    if (!z && iIntValue > iIntValue2) {
                        z = true;
                    }
                    if (!z2 && iIntValue < iIntValue3) {
                        z2 = true;
                    }
                    if ((!z && iIntValue < iIntValue2) || (!z2 && iIntValue > iIntValue3)) {
                        return false;
                    }
                    if (iIntValue != iIntValue2 && iIntValue != iIntValue3 && iIntValue > iIntValue2 && iIntValue < iIntValue3) {
                        return true;
                    }
                    i++;
                }
                return true;
            }
            return false;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - - matchVersionName - ", e);
            return false;
        }
    }

    static /* synthetic */ java.lang.Integer lambda$matchVersionName$13(java.lang.String str) {
        try {
            return java.lang.Integer.valueOf(java.lang.Integer.parseInt(str));
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - - matchVersionName - safeParseInt", e);
            return 0;
        }
    }

    private void downloadPromotionDiagram() {
        java.lang.String promotionDiagramUrl = getPromotionDiagramUrl();
        java.lang.String promotionDiagramImagePath = getPromotionDiagramImagePath();
        if (android.text.TextUtils.isEmpty(promotionDiagramUrl) || com.up366.common.FileUtilsUp.isFileExists(promotionDiagramImagePath)) {
            return;
        }
        com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
        downloadInfo.setKey("promotion");
        downloadInfo.setFilePath(promotionDiagramImagePath);
        downloadInfo.setDownloadUrl(promotionDiagramUrl);
        downloadInfo.setDownType(13);
        downloadInfo.setNeedUnzip(false);
        downloadInfo.setNeedCheck(false);
        com.up366.common.download.DownloadManager.getInstance().addDownload(downloadInfo, new com.up366.common.download.DownloadManager.IDownloadCallback() { // from class: com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticLambda9
            @Override // com.up366.common.download.DownloadManager.IDownloadCallback
            public final void onStateChange(java.lang.String str, int i, int i2, java.lang.String str2, long j, long j2, int i3, java.lang.String str3) {
                com.up366.mobile.common.logic.AppConfigMgr.lambda$downloadPromotionDiagram$14(str, i, i2, str2, j, j2, i3, str3);
            }
        });
    }

    public boolean isShowPromotionDiagram() {
        com.alibaba.fastjson.JSONObject promotionDiagramConfig = getPromotionDiagramConfig();
        if (promotionDiagramConfig == null) {
            return false;
        }
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        long jLongValue = 1000 + currentNtpTimeInMillisecond;
        java.lang.Long l = promotionDiagramConfig.getLong("beginDate");
        java.lang.Long l2 = promotionDiagramConfig.getLong("endDate");
        long jLongValue2 = l != null ? l.longValue() : 0L;
        if (l2 != null) {
            jLongValue = l2.longValue();
        }
        return jLongValue2 < currentNtpTimeInMillisecond && currentNtpTimeInMillisecond < jLongValue && com.up366.common.FileUtilsUp.isFileExists(getPromotionDiagramImagePath());
    }

    public java.lang.String getPromotionDiagramImagePath() {
        java.lang.String promotionDiagramUrl = getPromotionDiagramUrl();
        if (android.text.TextUtils.isEmpty(promotionDiagramUrl)) {
            return null;
        }
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getCacheDir(), com.up366.common.digest.MD5.md5(promotionDiagramUrl));
    }

    public long getPromotionDiagramShowDuration() {
        com.alibaba.fastjson.JSONObject promotionDiagramConfig = getPromotionDiagramConfig();
        if (promotionDiagramConfig == null) {
            return com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS;
        }
        int intValue = promotionDiagramConfig.getIntValue("duration");
        if (intValue < 1) {
            intValue = 3;
        }
        return ((long) intValue) * 1000;
    }

    public com.alibaba.fastjson.JSONObject getPromotionDiagramConfig() {
        return getDynamicConfig().getJSONObject("promotion");
    }

    public com.alibaba.fastjson.JSONObject getSLSConfig() {
        return getDynamicConfig().getJSONObject("sls");
    }

    private com.alibaba.fastjson.JSONObject getWithinCourseBooksConfig() {
        return getDynamicConfig().getJSONObject("within-course-books");
    }

    public java.util.List<java.lang.String> getWithInCourseBooks() {
        com.alibaba.fastjson.JSONObject withinCourseBooksConfig = getWithinCourseBooksConfig();
        if (withinCourseBooksConfig == null || withinCourseBooksConfig.isEmpty()) {
            return com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticBackport0.m(new java.lang.Object[]{"D3C41EE252CD2A672E3B2ACF64781464"});
        }
        com.alibaba.fastjson.JSONArray jSONArray = withinCourseBooksConfig.getJSONArray("value");
        if (jSONArray == null || jSONArray.isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return jSONArray.toJavaList(java.lang.String.class);
    }

    public com.alibaba.fastjson.JSONObject getH5TaskListConfig() {
        return getDynamicConfig().getJSONObject("h5-tasklist");
    }

    public com.alibaba.fastjson.JSONObject getBookGrayConfig() {
        return getDynamicConfig().getJSONObject("bookGray");
    }

    public com.alibaba.fastjson.JSONObject getBookOpenTypeConfig() {
        return getDynamicConfig().getJSONObject("bookOpenType");
    }

    public com.alibaba.fastjson.JSONObject getThirdLoginConfig() {
        return getDynamicConfig().getJSONObject("third-party-login");
    }

    public com.alibaba.fastjson.JSONObject getLimitConfig() {
        return getDynamicConfig().getJSONObject("limit-config");
    }

    public java.lang.String convertBookFileId(java.lang.String str, java.lang.String str2) {
        com.alibaba.fastjson.JSONObject bookGrayConfig = getBookGrayConfig();
        if (bookGrayConfig == null) {
            return str2;
        }
        java.lang.String string = bookGrayConfig.getString(str);
        if (android.text.TextUtils.isEmpty(string)) {
            return str2;
        }
        com.up366.common.log.Logger.info("TAG - AppConfigMgr - convertBookFileId - use config fileId:" + string + " bookId:" + str);
        return string;
    }

    public boolean isEnableH5TaskList() {
        com.alibaba.fastjson.JSONObject h5TaskListConfig = getH5TaskListConfig();
        if (h5TaskListConfig == null || h5TaskListConfig.isEmpty()) {
            return true;
        }
        return h5TaskListConfig.getBooleanValue("enable");
    }

    public com.alibaba.fastjson.JSONObject getBookOpenType() {
        com.alibaba.fastjson.JSONObject bookOpenTypeConfig = getBookOpenTypeConfig();
        return bookOpenTypeConfig == null ? new com.alibaba.fastjson.JSONObject() : bookOpenTypeConfig;
    }

    public boolean isEnableSLS() {
        com.alibaba.fastjson.JSONObject sLSConfig = getSLSConfig();
        if (sLSConfig == null) {
            return true;
        }
        return sLSConfig.getBooleanValue("enable");
    }

    public boolean isEnableUseNewRecord() {
        com.alibaba.fastjson.JSONObject jSONObject = getDynamicConfig().getJSONObject("new-record");
        if (jSONObject == null || jSONObject.size() == 0) {
            return true;
        }
        return jSONObject.getBooleanValue("enable");
    }

    public boolean isEnableThirdLogin() {
        com.alibaba.fastjson.JSONObject thirdLoginConfig = getThirdLoginConfig();
        if (thirdLoginConfig == null) {
            return false;
        }
        return thirdLoginConfig.getBooleanValue("enable");
    }

    public boolean isWebViewCrashEnable() {
        com.alibaba.fastjson.JSONObject jSONObject = getDynamicConfig().getJSONObject("webview-crash-switch");
        if (jSONObject == null || jSONObject.size() == 0) {
            return true;
        }
        return jSONObject.getBooleanValue("enable");
    }

    public boolean isUseBlueToothConnect() {
        com.alibaba.fastjson.JSONObject jSONObject = getDynamicConfig().getJSONObject("use-bluetooth-connect");
        if (jSONObject == null || jSONObject.size() == 0) {
            return false;
        }
        return jSONObject.getBooleanValue("enable");
    }

    public com.up366.common.log.LogLevel getSLSLevel() {
        com.alibaba.fastjson.JSONObject sLSConfig = getSLSConfig();
        if (sLSConfig == null) {
            return com.up366.common.log.LogLevel.INFO;
        }
        java.lang.String string = sLSConfig.getString("level");
        if (android.text.TextUtils.equals(string, "verbose")) {
            return com.up366.common.log.LogLevel.VERBOSE;
        }
        if (android.text.TextUtils.equals(string, com.up366.papercut.library.BuildConfig.BUILD_TYPE)) {
            return com.up366.common.log.LogLevel.DEBUG;
        }
        if (android.text.TextUtils.equals(string, "error")) {
            return com.up366.common.log.LogLevel.ERROR;
        }
        if (android.text.TextUtils.equals(string, "warn")) {
            return com.up366.common.log.LogLevel.WARN;
        }
        return com.up366.common.log.LogLevel.INFO;
    }

    public java.lang.String getPromotionDiagramUrl() {
        com.alibaba.fastjson.JSONArray jSONArray;
        android.util.DisplayMetrics displayMetrics = com.up366.common.global.GB.get().getApplicationContext().getResources().getDisplayMetrics();
        float f = (displayMetrics.widthPixels * 1.0f) / displayMetrics.heightPixels;
        com.alibaba.fastjson.JSONObject promotionDiagramConfig = getPromotionDiagramConfig();
        java.lang.String string = null;
        if (promotionDiagramConfig == null || (jSONArray = promotionDiagramConfig.getJSONArray(com.up366.multimedia.activity.PreviewActivity.INTENT_IMAGE_ITEMS)) == null) {
            return null;
        }
        float f2 = 999.0f;
        for (int i = 0; i < jSONArray.size(); i++) {
            com.alibaba.fastjson.JSONObject jSONObject = jSONArray.getJSONObject(i);
            float fAbs = java.lang.Math.abs(f - ((jSONObject.getIntValue("width") * 1.0f) / jSONObject.getIntValue("height")));
            if (f2 > fAbs) {
                string = jSONObject.getString(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE);
                f2 = fAbs;
            }
        }
        return string;
    }

    public boolean useNewMuxAV() {
        com.alibaba.fastjson.JSONObject jSONObject = getDynamicConfig().getJSONObject("use-new-mux");
        if (jSONObject == null) {
            return true;
        }
        return jSONObject.getBooleanValue("enable");
    }

    public com.up366.common.http.NetHolder<com.up366.mobile.common.logic.AppConfigMgr.SLSToken> fetchSLSToken() throws java.lang.InterruptedException {
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.getAliYunSLSToken).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticLambda7
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                map.put("agentType", 2);
            }
        }).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticLambda8
            @Override // com.up366.common.http.RequestParams.IHandleResponse
            public final java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return com.up366.mobile.common.logic.AppConfigMgr.lambda$fetchSLSToken$16(response, str);
            }
        }));
    }

    static /* synthetic */ com.up366.mobile.common.logic.AppConfigMgr.SLSToken lambda$fetchSLSToken$16(com.up366.common.http.Response response, java.lang.String str) {
        return (com.up366.mobile.common.logic.AppConfigMgr.SLSToken) com.up366.mobile.common.utils.ResponseUtil.parseObject(str, com.up366.mobile.common.logic.AppConfigMgr.SLSToken.class);
    }

    public int getDownloadLimit() {
        try {
            com.alibaba.fastjson.JSONObject limitConfig = getLimitConfig();
            if (limitConfig != null && limitConfig.containsKey("android")) {
                com.alibaba.fastjson.JSONObject jSONObject = limitConfig.getJSONObject("android");
                if (jSONObject.containsKey("limit")) {
                    return jSONObject.getIntValue("limit");
                }
            }
            return 100;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - AppConfigMgr - getDownloadLimit - ", e);
            return 100;
        }
    }
}
