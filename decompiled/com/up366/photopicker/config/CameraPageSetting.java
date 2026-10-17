package com.up366.photopicker.config;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CameraPageSetting {

    @com.alibaba.fastjson.annotation.JSONField(name = "rectSetting")
    private com.up366.photopicker.config.RectSetting rectSetting = new com.up366.photopicker.config.RectSetting();

    @com.alibaba.fastjson.annotation.JSONField(name = "guideSetting")
    private com.up366.photopicker.config.GuideSetting guideSetting = new com.up366.photopicker.config.GuideSetting();

    @com.alibaba.fastjson.annotation.JSONField(name = "description")
    private java.lang.String description = "请对准拍摄区域，保持画面清晰";

    @com.alibaba.fastjson.annotation.JSONField(name = "indexDescription")
    private java.lang.String indexDescription = "作文题目";

    @com.alibaba.fastjson.annotation.JSONField(name = "isMultiplyAvailable")
    private boolean isMultiplyAvailable = true;

    @com.alibaba.fastjson.annotation.JSONField(name = "maxPage")
    private int maxPage = 10;

    @com.alibaba.fastjson.annotation.JSONField(name = "isRectHidden")
    private boolean isRectHidden = false;

    @com.alibaba.fastjson.annotation.JSONField(name = "isGridButtonHidden")
    private boolean isGridButtonHidden = true;

    public boolean isRectHidden() {
        return this.isRectHidden;
    }

    public void setRectHidden(boolean z) {
        this.isRectHidden = z;
    }

    public boolean isGridButtonHidden() {
        return this.isGridButtonHidden;
    }

    public void setGridButtonHidden(boolean z) {
        this.isGridButtonHidden = z;
    }

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

    public java.lang.String getIndexDescription() {
        return this.indexDescription;
    }

    public void setIndexDescription(java.lang.String str) {
        this.indexDescription = str;
    }

    public boolean isMultiplyAvailable() {
        return this.isMultiplyAvailable;
    }

    public void setMultiplyAvailable(boolean z) {
        this.isMultiplyAvailable = z;
    }

    public int getMaxPage() {
        return this.maxPage;
    }

    public void setMaxPage(int i) {
        this.maxPage = i;
    }
}
