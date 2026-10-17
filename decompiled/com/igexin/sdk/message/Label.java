package com.igexin.sdk.message;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class Label implements java.io.Serializable {
    private long endTime = 0;
    private java.lang.String extraData;
    private java.lang.String tagId;
    private java.lang.String tagName;
    private java.lang.String tagVersion;

    public long getEndTime() {
        return this.endTime;
    }

    public java.lang.String getExtraData() {
        return this.extraData;
    }

    public org.json.JSONObject getJsonObject() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("tagId", this.tagId);
            if (!android.text.TextUtils.isEmpty(this.tagName)) {
                jSONObject.put("tagName", this.tagName);
            }
            if (!android.text.TextUtils.isEmpty(this.tagVersion)) {
                jSONObject.put("tagVersion", this.tagVersion);
            }
            jSONObject.put("endTime", this.endTime);
            if (!android.text.TextUtils.isEmpty(this.extraData)) {
                jSONObject.put("extraData", this.extraData);
            }
        } catch (org.json.JSONException e) {
            com.igexin.c.a.c.a.a(e);
        }
        return jSONObject;
    }

    public java.lang.String getTagId() {
        return this.tagId;
    }

    public java.lang.String getTagName() {
        return this.tagName;
    }

    public java.lang.String getTagVersion() {
        return this.tagVersion;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setExtraData(java.lang.String str) {
        this.extraData = str;
    }

    public void setTagId(java.lang.String str) {
        this.tagId = str;
    }

    public void setTagName(java.lang.String str) {
        this.tagName = str;
    }

    public void setTagVersion(java.lang.String str) {
        this.tagVersion = str;
    }
}
