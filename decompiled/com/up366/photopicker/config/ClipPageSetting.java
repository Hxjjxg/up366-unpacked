package com.up366.photopicker.config;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ClipPageSetting {

    @com.alibaba.fastjson.annotation.JSONField(name = "rectSetting")
    private com.up366.photopicker.config.RectSetting rectSetting = new com.up366.photopicker.config.RectSetting();

    @com.alibaba.fastjson.annotation.JSONField(name = "guideSetting")
    private com.up366.photopicker.config.GuideSetting guideSetting = new com.up366.photopicker.config.GuideSetting();

    @com.alibaba.fastjson.annotation.JSONField(name = "description")
    private java.lang.String description = "请框选需要裁剪的区域，支持手动调整边框";

    @com.alibaba.fastjson.annotation.JSONField(name = "draggingType")
    private int draggingType = 0;

    @com.alibaba.fastjson.annotation.JSONField(name = "isMagnifierEnabled")
    private boolean isMagnifierEnabled = false;

    public com.up366.photopicker.config.RectSetting getRectSetting() {
        return this.rectSetting;
    }

    public void setRectSetting(com.up366.photopicker.config.RectSetting rectSetting) {
        this.rectSetting = rectSetting;
    }

    public com.up366.photopicker.config.GuideSetting getGuideSetting() {
        return this.guideSetting;
    }

    public void setGuideSetting(com.up366.photopicker.config.GuideSetting guideSetting) {
        this.guideSetting = guideSetting;
    }

    public java.lang.String getDescription() {
        return this.description;
    }

    public void setDescription(java.lang.String str) {
        this.description = str;
    }

    public int getDraggingType() {
        return this.draggingType;
    }

    public void setDraggingType(int i) {
        this.draggingType = i;
    }

    public boolean isMagnifierEnabled() {
        return this.isMagnifierEnabled;
    }

    public void setMagnifierEnabled(boolean z) {
        this.isMagnifierEnabled = z;
    }
}
