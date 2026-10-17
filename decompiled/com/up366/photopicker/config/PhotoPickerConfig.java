package com.up366.photopicker.config;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PhotoPickerConfig {

    @com.alibaba.fastjson.annotation.JSONField(name = "isReshoot")
    private boolean isReshoot;

    @com.alibaba.fastjson.annotation.JSONField(name = "productType")
    private int productType;

    @com.alibaba.fastjson.annotation.JSONField(name = "clipPageSetting")
    private com.up366.photopicker.config.ClipPageSetting clipPageSetting = new com.up366.photopicker.config.ClipPageSetting();

    @com.alibaba.fastjson.annotation.JSONField(name = "cameraPageSetting")
    private com.up366.photopicker.config.CameraPageSetting cameraPageSetting = new com.up366.photopicker.config.CameraPageSetting();

    public com.up366.photopicker.config.ClipPageSetting getClipPageSetting() {
        return this.clipPageSetting;
    }

    public void setClipPageSetting(com.up366.photopicker.config.ClipPageSetting clipPageSetting) {
        this.clipPageSetting = clipPageSetting;
    }

    public com.up366.photopicker.config.CameraPageSetting getCameraPageSetting() {
        return this.cameraPageSetting;
    }

    public void setCameraPageSetting(com.up366.photopicker.config.CameraPageSetting cameraPageSetting) {
        this.cameraPageSetting = cameraPageSetting;
    }

    public int getProductType() {
        return this.productType;
    }

    public void setProductType(int i) {
        this.productType = i;
    }

    public boolean isIsReshoot() {
        return this.isReshoot;
    }

    public void setIsReshoot(boolean z) {
        this.isReshoot = z;
    }
}
