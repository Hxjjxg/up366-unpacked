package com.up366.photopicker.config;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class GuideSetting {

    @com.alibaba.fastjson.annotation.JSONField(name = com.up366.mobile.commonui.CommonWebViewActivity.URL)
    private java.lang.String url = "";

    @com.alibaba.fastjson.annotation.JSONField(name = "isGuideAutoShown")
    private boolean isGuideAutoShown = false;

    @com.alibaba.fastjson.annotation.JSONField(name = "shownType")
    private int shownType = 0;

    @com.alibaba.fastjson.annotation.JSONField(name = "isGuideButtonHidden")
    private boolean isGuideButtonHidden = true;

    public java.lang.String getUrl() {
        return this.url;
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }

    public boolean isGuideAutoShown() {
        return this.isGuideAutoShown;
    }

    public void setGuideAutoShown(boolean z) {
        this.isGuideAutoShown = z;
    }

    public int getShownType() {
        return this.shownType;
    }

    public void setShownType(int i) {
        this.shownType = i;
    }

    public boolean isGuideButtonHidden() {
        return this.isGuideButtonHidden;
    }

    public void setGuideButtonHidden(boolean z) {
        this.isGuideButtonHidden = z;
    }
}
