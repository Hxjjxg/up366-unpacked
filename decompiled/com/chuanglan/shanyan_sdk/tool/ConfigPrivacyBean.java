package com.chuanglan.shanyan_sdk.tool;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class ConfigPrivacyBean {
    private java.lang.String a;
    private java.lang.String b;
    private int c;
    private java.lang.String d;
    private java.lang.String e;

    public ConfigPrivacyBean(java.lang.String str, java.lang.String str2, int i, java.lang.String str3) {
        this.c = 0;
        this.d = "、";
        this.e = "";
        com.chuanglan.shanyan_sdk.Q.a("UIShanYanLogger", "privacy info", str, str2);
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            throw new java.lang.IllegalStateException("name,  url, is null");
        }
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = str3;
        this.e = str;
    }

    public int getColor() {
        return this.c;
    }

    public java.lang.String getMidStr() {
        return this.d;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public java.lang.String getTitle() {
        return this.e;
    }

    public java.lang.String getUrl() {
        return this.b;
    }

    public void setColor(int i) {
        this.c = i;
    }

    public void setMidStr(java.lang.String str) {
        this.d = str;
    }

    public void setName(java.lang.String str) {
        this.a = str;
    }

    public void setTitle(java.lang.String str) {
        this.e = str;
    }

    public void setUrl(java.lang.String str) {
        this.b = str;
    }

    public ConfigPrivacyBean(java.lang.String str, java.lang.String str2, int i) {
        this.c = 0;
        this.d = "、";
        this.e = "";
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            this.a = str;
            this.b = str2;
            this.c = i;
            this.e = str;
            return;
        }
        throw new java.lang.IllegalStateException("name,  url,  is null");
    }

    public ConfigPrivacyBean(java.lang.String str, java.lang.String str2) {
        this.c = 0;
        this.d = "、";
        this.e = "";
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            this.a = str;
            this.b = str2;
            this.e = str;
            return;
        }
        throw new java.lang.IllegalStateException("name,  url,  is null");
    }
}
