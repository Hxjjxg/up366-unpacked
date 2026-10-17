package com.up366.mobile.course.p1p.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class P1pConfigDataHelper {
    public static final com.up366.mobile.course.p1p.helper.P1pConfigDataHelper INSTANCE = new com.up366.mobile.course.p1p.helper.P1pConfigDataHelper();
    private com.up366.mobile.course.p1p.helper.model.Config config;
    private boolean taskCanOnline = true;
    private boolean isScanPaperGeneral = false;

    public void reset() {
        this.config = null;
    }

    public void fetchP1pConfig() {
        java.lang.String str = com.up366.mobile.common.http.HttpMgrUtils.LOAD_P1P_CONFIG;
        if (com.up366.mobile.common.utils.PlatformUtils.isDemo()) {
            str = com.up366.mobile.common.http.HttpMgrUtils.LOAD_P1P_CONFIG_DEMO;
        }
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Void>(str) { // from class: com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.1
            @Override // com.up366.common.http.RequestParams
            public java.lang.Void handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                com.up366.common.log.Logger.info(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("fetchP1pConfigV2", str2));
                if (response.isError()) {
                    com.up366.common.log.Logger.error("fetchP1pConfigV2 error " + response.toString());
                    return null;
                }
                com.up366.mobile.common.utils.PreferenceUtils.putString("fetchP1pConfigV2", str2);
                try {
                    com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.this.config = (com.up366.mobile.course.p1p.helper.model.Config) com.alibaba.fastjson.JSON.parseObject(str2, com.up366.mobile.course.p1p.helper.model.Config.class);
                } catch (java.lang.Exception e) {
                    com.up366.common.log.Logger.error("fetchP1pConfigV2 error", e);
                }
                return null;
            }
        });
    }

    public void fetchP1pConfig(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        setScanPaperGeneral(false);
        INSTANCE.setTaskCanOnline(taskInfoV2.getExtParam().canOnlineAnswer());
        fetchP1pConfig();
    }

    private com.up366.mobile.course.p1p.helper.model.Config loadConfigData() {
        com.up366.mobile.course.p1p.helper.model.Config config = this.config;
        if (config != null) {
            return config;
        }
        java.lang.String string = com.up366.mobile.common.utils.PreferenceUtils.getString("fetchP1pConfigV2", "{}");
        if ("{}".equals(string)) {
            com.up366.mobile.course.p1p.helper.model.Config config2 = new com.up366.mobile.course.p1p.helper.model.Config();
            this.config = config2;
            return config2;
        }
        try {
            this.config = (com.up366.mobile.course.p1p.helper.model.Config) com.alibaba.fastjson.JSON.parseObject(string, com.up366.mobile.course.p1p.helper.model.Config.class);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("loadConfigData error", e);
            this.config = new com.up366.mobile.course.p1p.helper.model.Config();
        }
        return this.config;
    }

    public boolean checkLessAssembleRetryCount(int i) {
        return this.isScanPaperGeneral || loadConfigData().getP1pConfigData().getAssembleRetryCount() - i > 0;
    }

    public boolean checkLessSingleRetryCount(int i) {
        return this.isScanPaperGeneral || loadConfigData().getP1pConfigData().getSingleRetryCount() - i > 0;
    }

    public boolean isEngineBlurForceUse() {
        return !this.isScanPaperGeneral && loadConfigData().getP1pConfigData().getEnableEngineBlurForceUse() == 1;
    }

    public boolean isOnline() {
        if (this.isScanPaperGeneral) {
            return false;
        }
        com.up366.common.log.Logger.info("isOnline taskCanOnline = " + this.taskCanOnline + "  " + loadConfigData().getP1pConfigData().isOnline());
        return loadConfigData().getP1pConfigData().isOnline() && this.taskCanOnline;
    }

    public boolean isSingleHidden() {
        return loadConfigData().getP1pConfigData().getSingleErrorHidden() == 1;
    }

    public boolean isSupportAlumSelect() {
        return loadConfigData().getP1pConfigData().getEnableAlumSelect() == 1;
    }

    public boolean isUseCameraX() {
        return loadConfigData().getP1pConfigData().getUseCameraX() == 1;
    }

    public int getBlurMinValue() {
        return loadConfigData().getP1pConfigData().getBlurMinValue();
    }

    public int getEngineBlurMinValue() {
        return loadConfigData().getP1pConfigData().getEngineBlurMinValue();
    }

    public boolean enableEngineBlur() {
        return loadConfigData().getP1pConfigData().getEnableEngineBlur() == 1;
    }

    public boolean useHdr() {
        return loadConfigData().getUseHdr() == 1;
    }

    public boolean isAutoFix() {
        return loadConfigData().getP1pConfigData().getAutofix() == 1;
    }

    public void setTaskCanOnline(boolean z) {
        this.taskCanOnline = z;
    }

    public boolean isForceUse() {
        if (this.taskCanOnline) {
            return loadConfigData().getP1pConfigData().isForceUse();
        }
        return true;
    }

    public boolean isEnableEngineCheckImage() {
        com.up366.mobile.course.p1p.helper.model.DefaultConfig p1pConfigData = loadConfigData().getP1pConfigData();
        java.lang.String disableCheckImageUids = p1pConfigData.getDisableCheckImageUids();
        if (disableCheckImageUids == null || disableCheckImageUids.isEmpty()) {
            return p1pConfigData.getEnableEngineCheckImage() == 1;
        }
        for (java.lang.String str : disableCheckImageUids.split(com.igexin.push.core.b.an)) {
            if (str.equals(com.up366.mobile.common.logic.Auth.getUserInfo().getUid() + "")) {
                return false;
            }
        }
        return p1pConfigData.getEnableEngineCheckImage() == 1;
    }

    public long getMaxNoLabelMillSeconds() {
        return ((long) loadConfigData().getP1pConfigData().getMaxNoLabelSeconds()) * 1000;
    }

    public long getMaxNotPhotoMillSeconds() {
        return ((long) loadConfigData().getP1pConfigData().getMaxNotPhotoSeconds()) * 1000;
    }

    public void setScanPaperGeneral(boolean z) {
        this.isScanPaperGeneral = z;
    }
}
