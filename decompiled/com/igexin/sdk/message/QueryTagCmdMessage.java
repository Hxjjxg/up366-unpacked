package com.igexin.sdk.message;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class QueryTagCmdMessage extends com.igexin.sdk.message.GTCmdMessage {
    private java.lang.String code;
    private java.lang.String sn;
    private com.igexin.sdk.Tag[] tags;

    public QueryTagCmdMessage(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        super(i);
        this.sn = str;
        this.code = str2;
        if (android.text.TextUtils.isEmpty(str3) || str3.equals(com.igexin.push.a.i)) {
            return;
        }
        java.lang.String[] strArrSplit = str3.split(" ");
        com.igexin.sdk.Tag[] tagArr = new com.igexin.sdk.Tag[strArrSplit.length];
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            com.igexin.sdk.Tag tag = new com.igexin.sdk.Tag();
            tag.setName(strArrSplit[i2]);
            tagArr[i2] = tag;
        }
        this.tags = tagArr;
    }

    public java.lang.String getCode() {
        return this.code;
    }

    public java.lang.String getSn() {
        return this.sn;
    }

    public com.igexin.sdk.Tag[] getTags() {
        return this.tags;
    }

    public void setCode(java.lang.String str) {
        this.code = str;
    }

    public void setSn(java.lang.String str) {
        this.sn = str;
    }

    public void setTags(com.igexin.sdk.Tag[] tagArr) {
        this.tags = tagArr;
    }
}
