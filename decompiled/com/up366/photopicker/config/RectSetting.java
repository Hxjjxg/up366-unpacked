package com.up366.photopicker.config;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class RectSetting {

    @com.alibaba.fastjson.annotation.JSONField(name = "explicit")
    private boolean explicit = false;

    @com.alibaba.fastjson.annotation.JSONField(name = com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_TOP)
    private float top = 0.2f;

    @com.alibaba.fastjson.annotation.JSONField(name = com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_BOTTOM)
    private float bottom = 0.2f;

    @com.alibaba.fastjson.annotation.JSONField(name = com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_LEFT)
    private float left = 0.2f;

    @com.alibaba.fastjson.annotation.JSONField(name = com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_RIGHT)
    private float right = 0.2f;

    public boolean isExplicit() {
        return this.explicit;
    }

    public void setExplicit(boolean z) {
        this.explicit = z;
    }

    public float getTop() {
        return this.top;
    }

    public void setTop(float f) {
        this.top = f;
    }

    public float getBottom() {
        return this.bottom;
    }

    public void setBottom(float f) {
        this.bottom = f;
    }

    public float getLeft() {
        return this.left;
    }

    public void setLeft(float f) {
        this.left = f;
    }

    public float getRight() {
        return this.right;
    }

    public void setRight(float f) {
        this.right = f;
    }
}
