package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UrlAppStuConfigInfo {
    private java.util.List<com.up366.mobile.common.logic.model.AppConfigAliyunToken> aliyuntoken;
    private java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner> banner;
    private long currentTime;
    private java.util.List<java.lang.String> funcClose;
    private java.util.List<com.up366.mobile.common.logic.model.UserFunAccredit> funcList;
    private java.util.List<com.up366.mobile.common.logic.model.AppConfigMiniCloud> minicloud;
    private java.util.List<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo.AppConfigUpdateModel> models;
    private com.up366.mobile.common.logic.model.UrlAppStuConfigInfo.OrganInfo organInfo;
    private java.lang.String up366token;

    public java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.AppConfigLastVersion> getModelMap() {
        java.util.HashMap map = new java.util.HashMap();
        java.util.List<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo.AppConfigUpdateModel> list = this.models;
        if (list != null) {
            for (com.up366.mobile.common.logic.model.UrlAppStuConfigInfo.AppConfigUpdateModel appConfigUpdateModel : list) {
                map.put(appConfigUpdateModel.modelName, appConfigUpdateModel.lastVersion);
            }
        }
        return map;
    }

    public static class OrganInfo {
        private int areaId;
        private int bindMobileType;
        private int changePwdType;

        public int getAreaId() {
            return this.areaId;
        }

        public void setAreaId(int i) {
            this.areaId = i;
        }

        public int getBindMobileType() {
            return this.bindMobileType;
        }

        public void setBindMobileType(int i) {
            this.bindMobileType = i;
        }

        public int getChangePwdType() {
            return this.changePwdType;
        }

        public void setChangePwdType(int i) {
            this.changePwdType = i;
        }
    }

    public class AppConfigUpdateModel {
        private com.up366.mobile.common.logic.model.AppConfigLastVersion lastVersion;
        private java.lang.String modelName;

        public AppConfigUpdateModel() {
        }

        public com.up366.mobile.common.logic.model.AppConfigLastVersion getLastVersion() {
            return this.lastVersion;
        }

        public void setLastVersion(com.up366.mobile.common.logic.model.AppConfigLastVersion appConfigLastVersion) {
            this.lastVersion = appConfigLastVersion;
        }

        public java.lang.String getModelName() {
            return this.modelName;
        }

        public void setModelName(java.lang.String str) {
            this.modelName = str;
        }
    }

    public long getCurrentTime() {
        return this.currentTime;
    }

    public void setCurrentTime(long j) {
        this.currentTime = j;
    }

    public java.util.List<com.up366.mobile.common.logic.model.AppConfigMiniCloud> getMinicloud() {
        return this.minicloud;
    }

    public void setMinicloud(java.util.List<com.up366.mobile.common.logic.model.AppConfigMiniCloud> list) {
        this.minicloud = list;
    }

    public java.util.List<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo.AppConfigUpdateModel> getModels() {
        return this.models;
    }

    public void setModels(java.util.List<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo.AppConfigUpdateModel> list) {
        this.models = list;
    }

    public java.util.List<java.lang.String> getFuncClose() {
        return this.funcClose;
    }

    public void setFuncClose(java.util.List<java.lang.String> list) {
        this.funcClose = list;
    }

    public java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner> getBanner() {
        return this.banner;
    }

    public void setBanner(java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner> list) {
        this.banner = list;
    }

    public java.lang.String getUp366token() {
        return this.up366token;
    }

    public void setUp366token(java.lang.String str) {
        this.up366token = str;
    }

    public java.util.List<com.up366.mobile.common.logic.model.AppConfigAliyunToken> getAliyuntoken() {
        return this.aliyuntoken;
    }

    public java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.AppConfigOssBucketInfo> getAliYunTokenMap() {
        java.util.HashMap map = new java.util.HashMap();
        java.util.List<com.up366.mobile.common.logic.model.AppConfigAliyunToken> list = this.aliyuntoken;
        if (list != null) {
            for (com.up366.mobile.common.logic.model.AppConfigAliyunToken appConfigAliyunToken : list) {
                map.put(appConfigAliyunToken.getBiz(), appConfigAliyunToken.getOssBucketInfo());
            }
        }
        return map;
    }

    public void setAliyuntoken(java.util.List<com.up366.mobile.common.logic.model.AppConfigAliyunToken> list) {
        this.aliyuntoken = list;
    }

    public com.up366.mobile.common.logic.model.UrlAppStuConfigInfo.OrganInfo getOrganInfo() {
        return this.organInfo;
    }

    public void setOrganInfo(com.up366.mobile.common.logic.model.UrlAppStuConfigInfo.OrganInfo organInfo) {
        this.organInfo = organInfo;
    }

    public java.util.List<com.up366.mobile.common.logic.model.UserFunAccredit> getFuncList() {
        return this.funcList;
    }

    public void setFuncList(java.util.List<com.up366.mobile.common.logic.model.UserFunAccredit> list) {
        this.funcList = list;
    }
}
