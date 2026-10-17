package com.up366.mobile.course.p1p.helper.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class Config {
    private java.util.List<com.up366.mobile.course.p1p.helper.model.SpecialConfig> specialConfigs;
    private com.up366.mobile.course.p1p.helper.model.DefaultConfig defaultConfig = new com.up366.mobile.course.p1p.helper.model.DefaultConfig();
    private int useHdr = 1;

    public com.up366.mobile.course.p1p.helper.model.DefaultConfig getP1pConfigData() {
        java.util.List<com.up366.mobile.course.p1p.helper.model.SpecialConfig> list = this.specialConfigs;
        if (list == null || list.size() == 0) {
            com.up366.common.log.Logger.info("specialConfigs is null or empty");
            return this.defaultConfig;
        }
        for (com.up366.mobile.course.p1p.helper.model.SpecialConfig specialConfig : this.specialConfigs) {
            if (specialConfig.getOrganIds().contains(java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.getUserInfo().getOrganId()))) {
                com.up366.mobile.course.p1p.helper.model.DefaultConfig p1pConfigData = specialConfig.getP1pConfigData(this.defaultConfig);
                p1pConfigData.setDisableCheckImageUids(this.defaultConfig.getDisableCheckImageUids());
                return p1pConfigData;
            }
        }
        return this.defaultConfig;
    }

    public void setDefaultConfig(com.up366.mobile.course.p1p.helper.model.DefaultConfig defaultConfig) {
        this.defaultConfig = defaultConfig;
    }

    public java.util.List<com.up366.mobile.course.p1p.helper.model.SpecialConfig> getSpecialConfigs() {
        return this.specialConfigs;
    }

    public void setSpecialConfigs(java.util.List<com.up366.mobile.course.p1p.helper.model.SpecialConfig> list) {
        this.specialConfigs = list;
    }

    public int getUseHdr() {
        return this.useHdr;
    }

    public void setUseHdr(int i) {
        this.useHdr = i;
    }
}
